package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.proguard.X;

/* loaded from: classes4.dex */
public class f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f22454a;

    /* renamed from: b */
    final /* synthetic */ Thread f22455b;

    /* renamed from: c */
    final /* synthetic */ Throwable f22456c;

    /* renamed from: d */
    final /* synthetic */ String f22457d;

    /* renamed from: e */
    final /* synthetic */ byte[] f22458e;

    /* renamed from: f */
    final /* synthetic */ boolean f22459f;

    /* renamed from: g */
    final /* synthetic */ h f22460g;

    public f(h hVar, boolean z10, Thread thread, Throwable th2, String str, byte[] bArr, boolean z11) {
        this.f22460g = hVar;
        this.f22454a = z10;
        this.f22455b = thread;
        this.f22456c = th2;
        this.f22457d = str;
        this.f22458e = bArr;
        this.f22459f = z11;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        Context context;
        try {
            X.a("post a throwable %b", Boolean.valueOf(this.f22454a));
            lVar = this.f22460g.f22480s;
            lVar.b(this.f22455b, this.f22456c, false, this.f22457d, this.f22458e);
            if (this.f22459f) {
                X.c("clear user datas", new Object[0]);
                context = this.f22460g.f22478q;
                com.tencent.bugly.crashreport.common.info.a.a(context).a();
            }
        } catch (Throwable th2) {
            if (!X.a(th2)) {
                th2.printStackTrace();
            }
            X.b("java catch error: %s", this.f22456c.toString());
        }
    }
}
