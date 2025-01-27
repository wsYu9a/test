package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* loaded from: classes4.dex */
final class b implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSRegisterCallback f31065a;

    /* renamed from: b */
    final /* synthetic */ VUpsManager f31066b;

    b(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f31066b = vUpsManager;
        this.f31065a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.f31065a.onResult(new TokenResult(i2, ""));
    }
}
