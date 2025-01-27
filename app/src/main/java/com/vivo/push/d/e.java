package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes4.dex */
final class e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f24993a;

    /* renamed from: b */
    final /* synthetic */ com.vivo.push.b.i f24994b;

    /* renamed from: c */
    final /* synthetic */ d f24995c;

    public e(d dVar, String str, com.vivo.push.b.i iVar) {
        this.f24995c = dVar;
        this.f24993a = str;
        this.f24994b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f24993a)) {
            d dVar = this.f24995c;
            PushMessageCallback pushMessageCallback = ((z) dVar).f25023b;
            context2 = ((com.vivo.push.l) dVar).f25064a;
            pushMessageCallback.onReceiveRegId(context2, this.f24993a);
        }
        d dVar2 = this.f24995c;
        PushMessageCallback pushMessageCallback2 = ((z) dVar2).f25023b;
        context = ((com.vivo.push.l) dVar2).f25064a;
        pushMessageCallback2.onBind(context, this.f24994b.h(), this.f24994b.d());
    }
}
