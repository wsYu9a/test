package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* loaded from: classes4.dex */
final class b implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSRegisterCallback f25101a;

    /* renamed from: b */
    final /* synthetic */ VUpsManager f25102b;

    public b(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f25102b = vUpsManager;
        this.f25101a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i10) {
        this.f25101a.onResult(new TokenResult(i10, ""));
    }
}
