package com.github.altickium.libslplugin

import LibSLLexer as LibSLANTLRLexer
import com.github.altickium.libslplugin.antlr.FixedANTLRLexerAdaptor

class LibSLLexer : FixedANTLRLexerAdaptor(LibSLLanguage.Companion.INSTANCE, LibSLANTLRLexer(null)) {
}