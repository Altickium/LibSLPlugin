package com.github.altickium.libslplugin.psi.highlighter

import com.github.altickium.libslplugin.lexer.LibSLLexer
import com.github.altickium.libslplugin.psi.LibSLTokenSets
import com.github.altickium.libslplugin.psi.LibSLTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.tree.IElementType


class LibSLSyntaxHighlighter : SyntaxHighlighterBase() {

    val KEY: TextAttributesKey = createTextAttributesKey("LIBSL_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    class Factory : SyntaxHighlighterFactory() {
        override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?) = LibSLSyntaxHighlighter()
    }
    override fun getHighlightingLexer(): Lexer = LibSLLexer()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        val tokenColor = tokenColor(tokenType)
        return if (tokenColor == null) TextAttributesKey.EMPTY_ARRAY else arrayOf(tokenColor)
    }

    private fun tokenColor(tokenType: IElementType): TextAttributesKey? {
        if (LibSLTokenSets.COMMENTS.contains(tokenType)) {
            return LibSLHighlighterColors.COMMENT
        }
        if (LibSLTokenSets.STRINGS.contains(tokenType)) {
            return LibSLHighlighterColors.STRING
        }
        if (LibSLTokenSets.BRACES.contains(tokenType)) {
            return LibSLHighlighterColors.BRACES
        }
        if (LibSLTokenSets.BRACKETS.contains(tokenType)) {
            return LibSLHighlighterColors.PARENTHESES
        }
        if (LibSLTokenSets.SQUARE_BRACKET.contains(tokenType)) {
            return LibSLHighlighterColors.BRACKETS
        }
        if (LibSLTokenSets.KEYWORDS.contains(tokenType)) {
            return LibSLHighlighterColors.KEYWORD
        }
        if (LibSLTokenSets.OPERATIONS.contains(tokenType)) {
            return LibSLHighlighterColors.OPERATION_SIGN
        }
        /*if (LibSLTokenSets.ASSIGNMENTS.contains(tokenType)) {
            return LibSLHighlighterColors.OPERATION_SIGN
        }
        if (LibSLTokenSets.NUMBERS.contains(tokenType)) {
            return LibSLHighlighterColors.NUMBER
        }*/
        return null;
    }
}