package com.github.altickium.libslplugin.psi.parserrules

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

class LibSLParameter (node : ASTNode) : ASTWrapperPsiElement(node) {
    val ident: LibSLIdentifierRule?
        get() = this.findChildByClass(LibSLIdentifierRule::class.java)
}