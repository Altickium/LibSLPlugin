package com.github.altickium.libslplugin.psi.highlighter

import com.github.altickium.libslplugin.LibSLIcons
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class LibSLColorSettingsPage : ColorSettingsPage {

    private val DESCRIPTORS = arrayOf<AttributesDescriptor>(
        AttributesDescriptor("Keyword", LibSLHighlighterColors.KEYWORD),
        AttributesDescriptor("Comment", LibSLHighlighterColors.COMMENT),
        AttributesDescriptor("String", LibSLHighlighterColors.STRING),
        AttributesDescriptor("Brackets", LibSLHighlighterColors.BRACKETS),
        AttributesDescriptor("Parenthesis", LibSLHighlighterColors.PARENTHESES),
        AttributesDescriptor("Braces", LibSLHighlighterColors.BRACES),
        AttributesDescriptor("Dot", LibSLHighlighterColors.DOT),
    )

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "LibSL"
    }

    override fun getIcon(): Icon? {
        return LibSLIcons.FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return LibSLSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return "libsl \"1.0.0\";\n" +
                "library test;\n" +
                "\n" +
                "//Comment example \n" +
                "automaton tcp_socket : int {\n" +
                "    //Состояния\n" +
                "    state Created;\n" +
                "    state Bound;\n" +
                "}"
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? {
        return null
    }
}