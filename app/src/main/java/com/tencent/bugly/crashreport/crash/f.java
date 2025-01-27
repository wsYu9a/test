package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.proguard.X;

/* loaded from: classes4.dex */
class f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f24847a;

    /* renamed from: b */
    final /* synthetic */ Thread f24848b;

    /* renamed from: c */
    final /* synthetic */ Throwable f24849c;

    /* renamed from: d */
    final /* synthetic */ String f24850d;

    /* renamed from: e */
    final /* synthetic */ byte[] f24851e;

    /* renamed from: f */
    final /* synthetic */ boolean f24852f;

    /* renamed from: g */
    final /* synthetic */ h f24853g;

    f(h hVar, boolean z, Thread thread, Throwable th, String str, byte[] bArr, boolean z2) {
        this.f24853g = hVar;
        this.f24847a = z;
        this.f24848b = thread;
        this.f24849c = th;
        this.f24850d = str;
        this.f24851e = bArr;
        this.f24852f = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        Context context;
        try {
            X.a("post a throwable %b", Boolean.valueOf(this.f24847a));
            lVar = this.f24853g.s;
            lVar.b(this.f24848b, this.f24849c, false, this.f24850d, this.f24851e);
            if (this.f24852f) {
                X.c("clear user datas", new Object[0]);
                context = this.f24853g.q;
                com.tencent.bugly.crashreport.common.info.a.a(context).a();
            }
        } catch (Throwable th) {
            if (!X.a(th)) {
                th.printStackTrace();
            }
            X.b("java catch error: %s", this.f24849c.toString());
        }
    }
}
