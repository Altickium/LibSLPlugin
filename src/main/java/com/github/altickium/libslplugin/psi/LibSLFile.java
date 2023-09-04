package com.github.altickium.libslplugin.psi;

import com.github.altickium.libslplugin.LibSLFileType;
import com.github.altickium.libslplugin.LibSLLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class LibSLFile extends PsiFileBase {

    public LibSLFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, LibSLLanguage.Companion.getINSTANCE());
    }

    @Override
    public @NotNull FileType getFileType() {
        return LibSLFileType.Companion.getINSTANCE();
    }
    @Override
    public String toString() {
        return "LibSL File";
    }
}
