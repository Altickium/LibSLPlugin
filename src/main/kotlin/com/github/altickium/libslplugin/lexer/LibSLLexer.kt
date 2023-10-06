package com.github.altickium.libslplugin.lexer

import com.github.altickium.libslplugin.LibSLLanguage
import LibSLLexer as LibSLANTLRLexer
import com.github.altickium.libslplugin.antlr.FixedANTLRLexerAdaptor

class LibSLLexer : FixedANTLRLexerAdaptor(LibSLLanguage.INSTANCE, LibSLANTLRLexer(null)) {
}