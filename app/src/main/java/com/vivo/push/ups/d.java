package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* loaded from: classes4.dex */
final class d implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSTurnCallback f25105a;

    /* renamed from: b */
    final /* synthetic */ VUpsManager f25106b;

    public d(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f25106b = vUpsManager;
        this.f25105a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i10) {
        this.f25105a.onResult(new CodeResult(i10));
    }
}
