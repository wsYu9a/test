package com.vivo.push;

import com.vivo.push.e;

/* loaded from: classes4.dex */
final class k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f31026a;

    /* renamed from: b */
    final /* synthetic */ e f31027b;

    k(e eVar, String str) {
        this.f31027b = eVar;
        this.f31026a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.a d2;
        d2 = this.f31027b.d(this.f31026a);
        if (d2 != null) {
            d2.a(1003, new Object[0]);
        }
    }
}
