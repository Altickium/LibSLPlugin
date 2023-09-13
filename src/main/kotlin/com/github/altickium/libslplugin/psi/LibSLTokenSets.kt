package com.github.altickium.libslplugin.psi

import com.intellij.psi.tree.TokenSet
object LibSLTokenSets {
    val WHITESPACE = TokenSet.create(LibSLTypes.WS, LibSLTypes.NEWLINE)
    val COMMENTS = TokenSet.create(LibSLTypes.LINE_COMMENT, LibSLTypes.COMMENT)
}