package com.github.altickium.libslplugin.psi.parserrules

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.github.altickium.libslplugin.findusageprovider.LibSLElementFactory
import com.intellij.psi.PsiReference
import com.intellij.psi.util.PsiTreeUtil

class LibSLIdentifierRule(node : ASTNode) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner {

    override fun getReference(): PsiReference? {
        if (introducesName()) return null
        val rangeInElement = TextRange(0, node.textLength)
        return when (parent) {
            is LibSLPeriodSeparatedFullName -> LibSLPeriodIdentifierReference(this, rangeInElement)
            //is LibSLParameter -> LibSLPeriodIdentifierReference(this, rangeInElement)
            else -> null
        }
    }

    override fun getName(): String = nameIdentifier.text

    override fun setName(name: String): PsiElement {
        val idLeaf = nameIdentifier
        val newIdLeaf = LibSLElementFactory.createIdentifierTokenFromText(project, name)
        return idLeaf.replace(newIdLeaf)
    }

    fun introducesName(): Boolean {
        val parent = parent
        val parameter = PsiTreeUtil.getParentOfType(parent, LibSLParameter::class.java, false)
        if (automatonDeclaration() != null) {
            return true
        }
        return false
    }

    private fun automatonDeclaration(): LibSLAutomatonDecl? {
        var prev: PsiElement = this
        var current: PsiElement? = parent
        while (current != null && current !is LibSLAutomatonDecl) {
            prev = current
            current = current.parent
        }
        if (current != null) {
            return current as LibSLAutomatonDecl
        }
        return null
    }

    override fun getNameIdentifier(): PsiElement = firstChild
}