package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes4.dex */
final class o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.vivo.push.b.n f25008a;

    /* renamed from: b */
    final /* synthetic */ n f25009b;

    public o(n nVar, com.vivo.push.b.n nVar2) {
        this.f25009b = nVar;
        this.f25008a = nVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        n nVar = this.f25009b;
        PushMessageCallback pushMessageCallback = ((z) nVar).f25023b;
        context = ((com.vivo.push.l) nVar).f25064a;
        pushMessageCallback.onLog(context, this.f25008a.d(), this.f25008a.e(), this.f25008a.f());
    }
}
