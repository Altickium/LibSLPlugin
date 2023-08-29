package com.github.altickium.libslplugin

import com.intellij.lang.Language
class LibSLLanguage : Language("LibSL"){
    companion object {
        @JvmStatic
        val INSTANCE = LibSLLanguage()
    }
}