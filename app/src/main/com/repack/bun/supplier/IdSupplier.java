package com.repack.bun.supplier;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes3.dex */
public interface IdSupplier {
    @Keep
    String getAAID();

    @Keep
    String getOAID();

    @Keep
    String getVAID();

    @Keep
    boolean isSupported();
}
