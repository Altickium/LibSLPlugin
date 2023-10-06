package com.github.altickium.libslplugin.antlr

import com.intellij.lang.Language
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.ANTLRLexerState
import org.antlr.v4.runtime.Lexer

open class FixedANTLRLexerAdaptor(language: Language, lexer: Lexer) : ANTLRLexerAdaptor(language, lexer) {
    override fun toLexerState(state: Int): ANTLRLexerState {
        if (state == 0) {
            return initialState
        }
        return super.toLexerState(state)
    }
}