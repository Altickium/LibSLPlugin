package com.github.altickium.libslplugin.lexer

import LibSLLexer as LibSLANTLRLexer
import com.github.altickium.libslplugin.LibSLLanguage
import com.github.altickium.libslplugin.antlr.FixedANTLRLexerAdaptor

class LibSLLexer2 : FixedANTLRLexerAdaptor(LibSLLanguage.Companion.INSTANCE, LibSLANTLRLexer(null)) {
}