package com.github.altickium.libslplugin.psi.parserrules

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.util.SmartList
import com.intellij.util.containers.SmartHashSet

class LibSLPeriodIdentifierReference (element: LibSLIdentifierRule, rangeInElement: TextRange) :
    PsiPolyVariantReferenceBase<LibSLIdentifierRule>(element, rangeInElement) {

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val declarations = SmartList<PsiElement>()
        val name = myElement.name
        processDeclarations {
            if (it.name == name) declarations.add(it)
        }
        return PsiElementResolveResult.createResults(declarations)
    }

    override fun getVariants(): Array<Any> {
        val variants = SmartHashSet<String>()
        processDeclarations {
            val name = it.name
            if (name != null) variants.add(name)
        }
        return variants.toTypedArray()
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        return myElement.setName(newElementName)
    }

    private fun processDeclarations(callback: (PsiNamedElement) -> Unit) {
        var prev: PsiElement = myElement
        var current = myElement.parent
        while (current != null && prev !is LibSLFileRule) {
            processDeclarationsIteration(current, callback)
            prev = current
            current = current.parent
        }
    }

    private fun processDeclarationsIteration(current: PsiElement, callback: (PsiNamedElement) -> Unit) {
        when (current) {
            is LibSLFunctionDecl -> processDeclarationsInParameters(current, callback)
            //TODO: Process other types of decl
        }
    }

    private fun processDeclarationsInParameters(functionDeclaration: LibSLFunctionDecl, callback: (PsiNamedElement) -> Unit) {
        val parameters = functionDeclaration.header?.parameters
        if (parameters != null) processDeclarationsInParameters(parameters, callback)
    }

    private fun processDeclarationsInParameters(parameters: LibSLFunctionDeclArgList, callback: (PsiNamedElement) -> Unit) {
        parameters.parameters.forEach { parameter ->
            when (parameter) {
                else -> {
                    val identifier = parameter.ident
                    if (identifier != null) {
                        callback(identifier)
                    }
                }
            }
        }
    }
}