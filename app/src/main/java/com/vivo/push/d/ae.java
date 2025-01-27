package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes4.dex */
final class ae implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.vivo.push.b.i f30964a;

    /* renamed from: b */
    final /* synthetic */ ad f30965b;

    ae(ad adVar, com.vivo.push.b.i iVar) {
        this.f30965b = adVar;
        this.f30964a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ad adVar = this.f30965b;
        PushMessageCallback pushMessageCallback = ((z) adVar).f30996b;
        context = ((com.vivo.push.l) adVar).f31028a;
        pushMessageCallback.onUnBind(context, this.f30964a.h(), this.f30964a.d());
    }
}
