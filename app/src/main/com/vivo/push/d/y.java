package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes4.dex */
final class y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.vivo.push.b.r f25021a;

    /* renamed from: b */
    final /* synthetic */ x f25022b;

    public y(x xVar, com.vivo.push.b.r rVar) {
        this.f25022b = xVar;
        this.f25021a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        x xVar = this.f25022b;
        PushMessageCallback pushMessageCallback = ((z) xVar).f25023b;
        context = ((com.vivo.push.l) xVar).f25064a;
        pushMessageCallback.onPublish(context, this.f25021a.h(), this.f25021a.g());
    }
}
