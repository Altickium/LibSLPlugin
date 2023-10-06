package com.github.altickium.libslplugin.findusageprovider

import com.intellij.lang.findUsages.EmptyFindUsagesProvider
import com.intellij.psi.PsiElement
import com.github.altickium.libslplugin.psi.*
import com.github.altickium.libslplugin.psi.parserrules.*

class LibSLFindUsagesProvider : EmptyFindUsagesProvider() {
    override fun getWordsScanner() = LibSLWordsScanner()

    override fun canFindUsagesFor(element: PsiElement): Boolean {
        return (element is LibSLIdentifierRule && element.introducesName())
    }
}