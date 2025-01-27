package com.vivo.push;

import com.vivo.push.e;

/* loaded from: classes4.dex */
final class k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f25062a;

    /* renamed from: b */
    final /* synthetic */ e f25063b;

    public k(e eVar, String str) {
        this.f25063b = eVar;
        this.f25062a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.a d10;
        d10 = this.f25063b.d(this.f25062a);
        if (d10 != null) {
            d10.a(1003, new Object[0]);
        }
    }
}
