package com.github.altickium.libslplugin.findusageprovider

import com.github.altickium.libslplugin.lexer.LibSLLexer
import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.psi.tree.TokenSet
import com.github.altickium.libslplugin.psi.LibSLTokenSets
import com.github.altickium.libslplugin.psi.LibSLTypes
class LibSLWordsScanner : DefaultWordsScanner(
    LibSLLexer(),
    TokenSet.create(LibSLTypes.Identifier),
    LibSLTokenSets.COMMENTS,
    TokenSet.orSet(
        //LibSLTokenSets.NUMBERS,
        LibSLTokenSets.STRINGS
    )
)
