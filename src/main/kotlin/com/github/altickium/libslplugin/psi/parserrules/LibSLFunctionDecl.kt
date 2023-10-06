package com.github.altickium.libslplugin.psi.parserrules

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiNameIdentifierOwner

class LibSLFunctionDecl (node : ASTNode) : ASTWrapperPsiElement(node){
    val header: LibSLFunctionHeader?
        get() = this.findChildByClass(LibSLFunctionHeader::class.java)
}