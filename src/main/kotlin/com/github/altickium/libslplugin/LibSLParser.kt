package com.github.altickium.libslplugin

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import LibSLParser as LibSLANLTRParser
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree

class LibSLParser : ANTLRParserAdaptor(LibSLLanguage.Companion.INSTANCE, LibSLANLTRParser(null)) {
    override fun parse(parser: Parser, root: IElementType): ParseTree {
        if (root is IFileElementType) {
            return (parser as LibSLANLTRParser).header()
        }
        throw UnsupportedOperationException("Unsupported root: ${root.javaClass.name}")
    }
}