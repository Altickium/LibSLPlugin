package com.github.altickium.libslplugin.psi;

import com.intellij.psi.tree.TokenSet;
public interface LibSLTokenSets {
    TokenSet IDENTIFIERS = TokenSet.create(LibSLTypes.KEY);

    TokenSet COMMENTS = TokenSet.create(LibSLTypes.COMMENT);

}
