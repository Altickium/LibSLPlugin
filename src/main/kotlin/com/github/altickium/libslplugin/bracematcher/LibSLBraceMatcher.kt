package com.github.altickium.libslplugin.bracematcher
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.github.altickium.libslplugin.psi.LibSLTypes
class LibSLBraceMatcher: PairedBraceMatcher {
    override fun getPairs() = PAIRS
    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?) = true
    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int) = openingBraceOffset
}

private val PAIRS = arrayOf(
    BracePair(LibSLTypes.L_BRACE, LibSLTypes.R_BRACE, true),
    BracePair(LibSLTypes.L_BRACKET, LibSLTypes.R_BRACKET, true),
    BracePair(LibSLTypes.L_SQUARE_BRACKET, LibSLTypes.L_SQUARE_BRACKET, true),
)
