package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.z;

/* loaded from: classes4.dex */
final class f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f31015a;

    /* renamed from: b */
    final /* synthetic */ e f31016b;

    f(e eVar, String str) {
        this.f31016b = eVar;
        this.f31015a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.f31016b.f31004h;
        if (context == null || TextUtils.isEmpty(this.f31015a)) {
            return;
        }
        context2 = this.f31016b.f31004h;
        context3 = this.f31016b.f31004h;
        if (z.b(context2, context3.getPackageName(), this.f31015a)) {
            this.f31016b.i();
        }
    }
}
