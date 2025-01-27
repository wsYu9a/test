package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.z;

/* loaded from: classes4.dex */
final class f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f25051a;

    /* renamed from: b */
    final /* synthetic */ e f25052b;

    public f(e eVar, String str) {
        this.f25052b = eVar;
        this.f25051a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.f25052b.f25031h;
        if (context == null || TextUtils.isEmpty(this.f25051a)) {
            return;
        }
        context2 = this.f25052b.f25031h;
        context3 = this.f25052b.f25031h;
        if (z.b(context2, context3.getPackageName(), this.f25051a)) {
            this.f25052b.i();
        }
    }
}
