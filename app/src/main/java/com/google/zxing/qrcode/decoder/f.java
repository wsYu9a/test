package com.google.zxing.qrcode.decoder;

import com.google.zxing.l;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a */
    private final boolean f8759a;

    f(boolean z) {
        this.f8759a = z;
    }

    public void a(l[] lVarArr) {
        if (!this.f8759a || lVarArr == null || lVarArr.length < 3) {
            return;
        }
        l lVar = lVarArr[0];
        lVarArr[0] = lVarArr[2];
        lVarArr[2] = lVar;
    }

    public boolean b() {
        return this.f8759a;
    }
}
