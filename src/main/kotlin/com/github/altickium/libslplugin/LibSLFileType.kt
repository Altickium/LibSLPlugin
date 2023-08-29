package com.github.altickium.libslplugin
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class LibSLFileType : LanguageFileType(LibSLLanguage.INSTANCE) {
    override fun getName(): String {
        return "LibSL File"
    }

    override fun getDescription(): String {
        return "LibSL language file"
    }

    override fun getDefaultExtension(): String {
        return "lsl"
    }

    override fun getIcon(): Icon {
        return LibSLIcons.FILE
    }

    companion object {
        @JvmStatic
        val INSTANCE = LibSLFileType()
    }
}