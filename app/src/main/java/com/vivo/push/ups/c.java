package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* loaded from: classes4.dex */
final class c implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSTurnCallback f31067a;

    /* renamed from: b */
    final /* synthetic */ VUpsManager f31068b;

    c(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f31068b = vUpsManager;
        this.f31067a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.f31067a.onResult(new CodeResult(i2));
    }
}
