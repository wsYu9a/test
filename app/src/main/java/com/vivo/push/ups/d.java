package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* loaded from: classes4.dex */
final class d implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSTurnCallback f31069a;

    /* renamed from: b */
    final /* synthetic */ VUpsManager f31070b;

    d(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f31070b = vUpsManager;
        this.f31069a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.f31069a.onResult(new CodeResult(i2));
    }
}
