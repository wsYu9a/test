package com.vivo.push.ups;

import android.content.Context;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;

/* loaded from: classes4.dex */
final class a implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSRegisterCallback f25098a;

    /* renamed from: b */
    final /* synthetic */ Context f25099b;

    /* renamed from: c */
    final /* synthetic */ VUpsManager f25100c;

    public a(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback, Context context) {
        this.f25100c = vUpsManager;
        this.f25098a = uPSRegisterCallback;
        this.f25099b = context;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i10) {
        this.f25098a.onResult(new TokenResult(i10, PushClient.getInstance(this.f25099b).getRegId()));
    }
}
