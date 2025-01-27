package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* loaded from: classes4.dex */
final class c implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSTurnCallback f25103a;

    /* renamed from: b */
    final /* synthetic */ VUpsManager f25104b;

    public c(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f25104b = vUpsManager;
        this.f25103a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i10) {
        this.f25103a.onResult(new CodeResult(i10));
    }
}
