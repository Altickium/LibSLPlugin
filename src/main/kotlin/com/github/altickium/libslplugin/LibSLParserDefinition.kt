package com.github.altickium.libslplugin

import com.github.altickium.libslplugin.lexer.LibSLLexer
import com.github.altickium.libslplugin.parser.LibSLParser
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiParser
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.github.altickium.libslplugin.psi.*

class LibSLParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?) = LibSLLexer();

    override fun createParser(project: Project?): PsiParser = LibSLParser();

    override fun getFileNodeType(): IFileElementType = LibSLTypes.FILE

    override fun getCommentTokens(): TokenSet = LibSLTokenSets.COMMENTS

    override fun getWhitespaceTokens() = LibSLTokenSets.WHITESPACE

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode): PsiElement = LibSLTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = LibSLFile(viewProvider)
}