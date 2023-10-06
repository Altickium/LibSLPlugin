package com.github.altickium.libslplugin.psi

import com.intellij.psi.tree.TokenSet
object LibSLTokenSets {
    val WHITESPACE = TokenSet.create(LibSLTypes.WS, LibSLTypes.NEWLINE, LibSLTypes.BR)
    val COMMENTS = TokenSet.create(LibSLTypes.LINE_COMMENT, LibSLTypes.COMMENT)
    val STRINGS = TokenSet.create(
        LibSLTypes.DoubleQuotedString
    )
    val BRACES = TokenSet.create(LibSLTypes.L_BRACE, LibSLTypes.R_BRACE)

    val BRACKETS = TokenSet.create(LibSLTypes.L_BRACKET, LibSLTypes.R_BRACKET)

    val SQUARE_BRACKET = TokenSet.create(LibSLTypes.L_SQUARE_BRACKET, LibSLTypes.R_SQUARE_BRACKET)

    val KEYWORDS = TokenSet.create(
        //LibSLTypes.ImportStatement,
        //LibSLTypes.IncludeStatement,
        LibSLTypes.IMPORT,
        LibSLTypes.INCLUDE,
        LibSLTypes.LIBSL,
        LibSLTypes.LIBRARY,
        LibSLTypes.VERSION,
        LibSLTypes.LANGUAGE,
        LibSLTypes.URL,
        LibSLTypes.TYPEALIAS,
        LibSLTypes.TYPE,
        LibSLTypes.TYPES,
        LibSLTypes.ENUM,
        LibSLTypes.ANNOTATION,
        LibSLTypes.AUTOMATON,
        LibSLTypes.CONCEPT,
        LibSLTypes.VAR,
        LibSLTypes.VAL,
        LibSLTypes.INITSTATE,
        LibSLTypes.STATE,
        LibSLTypes.FINISHSTATE,
        LibSLTypes.SHIFT,
        LibSLTypes.NEW,
        LibSLTypes.FUN,
        LibSLTypes.CONSTRUCTOR,
        LibSLTypes.DESTRUCTOR,
        LibSLTypes.PROC,
        LibSLTypes.AT,
        LibSLTypes.ACTION,
        LibSLTypes.REQUIRES,
        LibSLTypes.ENSURES,
        LibSLTypes.ASSIGNS,
        LibSLTypes.TRUE,
        LibSLTypes.FALSE,
        LibSLTypes.DEFINE,
        LibSLTypes.IF,
        LibSLTypes.ELSE,
        LibSLTypes.BY,
        LibSLTypes.IS,
        LibSLTypes.AS,
        LibSLTypes.NULL
    )

    val OPERATIONS = TokenSet.create(
        //LibSLTypes.ImportStatement,
        //LibSLTypes.IncludeStatement,
        LibSLTypes.ASSIGN_OP,
        LibSLTypes.EQ,
        LibSLTypes.MINUS_ARROW,
        LibSLTypes.L_ARROW,
        LibSLTypes.R_ARROW,
        LibSLTypes.ASTERISK,
        LibSLTypes.SLASH,
        LibSLTypes.PERCENT,
        LibSLTypes.PLUS,
        LibSLTypes.MINUS,
        LibSLTypes.INCREMENT,
        LibSLTypes.DECREMENT,
        LibSLTypes.PLUS_EQ,
        LibSLTypes.MINUS_EQ,
        LibSLTypes.ASTERISK_EQ,
        LibSLTypes.SLASH_EQ,
        LibSLTypes.PERCENT_EQ,
        LibSLTypes.EXCLAMATION,
        LibSLTypes.EXCLAMATION_EQ,
        LibSLTypes.L_ARROW_EQ,
        LibSLTypes.R_ARROW_EQ,
        LibSLTypes.AMPERSAND,
        LibSLTypes.DOUBLE_AMPERSAND,
        LibSLTypes.BIT_OR,
        LibSLTypes.LOGIC_OR,
        LibSLTypes.XOR,
        LibSLTypes.TILDE,
        LibSLTypes.AMPERSAND_EQ,
        LibSLTypes.OR_EQ,
        LibSLTypes.XOR_EQ,
        LibSLTypes.R_SHIFT_EQ,
        LibSLTypes.L_SHIFT_EQ,
        LibSLTypes.APOSTROPHE,
        LibSLTypes.BACK_QOUTE
    )
}