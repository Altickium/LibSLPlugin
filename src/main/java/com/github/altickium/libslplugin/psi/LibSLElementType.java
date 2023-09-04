package com.github.altickium.libslplugin.psi;

import com.github.altickium.libslplugin.LibSLLanguage;
import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LibSLElementType extends IElementType {
    public LibSLElementType(@NonNls @NotNull String debugName) {
        super(debugName, LibSLLanguage.Companion.getINSTANCE());
    }
}
