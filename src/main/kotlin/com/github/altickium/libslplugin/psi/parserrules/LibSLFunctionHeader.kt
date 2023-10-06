package com.github.altickium.libslplugin.psi.parserrules

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

class LibSLFunctionHeader (node : ASTNode) : ASTWrapperPsiElement(node) {
    val parameters: LibSLFunctionDeclArgList?
        get() = this.findChildByClass(LibSLFunctionDeclArgList::class.java)
}