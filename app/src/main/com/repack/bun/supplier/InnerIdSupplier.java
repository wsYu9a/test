package com.repack.bun.supplier;

import androidx.annotation.Keep;

/* loaded from: classes3.dex */
public interface InnerIdSupplier extends IdSupplier {
    @Keep
    String getUDID();

    boolean j();

    void k(SupplierListener supplierListener);

    @Keep
    void shutDown();
}
