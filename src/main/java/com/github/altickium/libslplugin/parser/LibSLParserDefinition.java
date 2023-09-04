package com.github.altickium.libslplugin.parser;

import com.github.altickium.libslplugin.LibSLLanguage;
import com.github.altickium.libslplugin.lexer.LibSLLexerAdapter;
import com.github.altickium.libslplugin.psi.LibSLFile;
import com.github.altickium.libslplugin.psi.LibSLTokenSets;
import com.github.altickium.libslplugin.psi.LibSLTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;


public class LibSLParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(LibSLLanguage.Companion.getINSTANCE());
    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new LibSLLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return LibSLTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode node) {
        return LibSLTypes.Factory.createElement(node);
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new LibSLFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new LibSLParser();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }
}
