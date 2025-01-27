package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes4.dex */
final class ae implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.vivo.push.b.i f24991a;

    /* renamed from: b */
    final /* synthetic */ ad f24992b;

    public ae(ad adVar, com.vivo.push.b.i iVar) {
        this.f24992b = adVar;
        this.f24991a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ad adVar = this.f24992b;
        PushMessageCallback pushMessageCallback = ((z) adVar).f25023b;
        context = ((com.vivo.push.l) adVar).f25064a;
        pushMessageCallback.onUnBind(context, this.f24991a.h(), this.f24991a.d());
    }
}
