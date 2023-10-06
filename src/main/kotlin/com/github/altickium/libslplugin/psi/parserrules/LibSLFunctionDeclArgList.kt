package com.github.altickium.libslplugin.psi.parserrules

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.util.PsiTreeUtil

class LibSLFunctionDeclArgList(node: ASTNode) : ASTWrapperPsiElement(node) {
    val parameters: List<LibSLParameter>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, LibSLParameter::class.java)
}