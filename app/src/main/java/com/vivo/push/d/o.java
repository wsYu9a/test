package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes4.dex */
final class o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.vivo.push.b.n f30981a;

    /* renamed from: b */
    final /* synthetic */ n f30982b;

    o(n nVar, com.vivo.push.b.n nVar2) {
        this.f30982b = nVar;
        this.f30981a = nVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        n nVar = this.f30982b;
        PushMessageCallback pushMessageCallback = ((z) nVar).f30996b;
        context = ((com.vivo.push.l) nVar).f31028a;
        pushMessageCallback.onLog(context, this.f30981a.d(), this.f30981a.e(), this.f30981a.f());
    }
}
