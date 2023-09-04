package com.github.altickium.libslplugin.psi;

import com.github.altickium.libslplugin.LibSLLanguage;
import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LibSLTokenType extends IElementType {
    public LibSLTokenType(@NonNls @NotNull String debugName) {
        super(debugName, LibSLLanguage.Companion.getINSTANCE());
    }

    @Override
    public String toString() {
        return "LibSLTokenType" + super.toString();
    }
}
