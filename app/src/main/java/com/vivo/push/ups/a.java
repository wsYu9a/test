package com.vivo.push.ups;

import android.content.Context;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;

/* loaded from: classes4.dex */
final class a implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSRegisterCallback f31062a;

    /* renamed from: b */
    final /* synthetic */ Context f31063b;

    /* renamed from: c */
    final /* synthetic */ VUpsManager f31064c;

    a(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback, Context context) {
        this.f31064c = vUpsManager;
        this.f31062a = uPSRegisterCallback;
        this.f31063b = context;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.f31062a.onResult(new TokenResult(i2, PushClient.getInstance(this.f31063b).getRegId()));
    }
}
