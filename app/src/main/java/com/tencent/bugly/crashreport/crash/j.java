package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.X;
import java.util.Map;

/* loaded from: classes4.dex */
class j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Thread f24883a;

    /* renamed from: b */
    final /* synthetic */ int f24884b;

    /* renamed from: c */
    final /* synthetic */ String f24885c;

    /* renamed from: d */
    final /* synthetic */ String f24886d;

    /* renamed from: e */
    final /* synthetic */ String f24887e;

    /* renamed from: f */
    final /* synthetic */ Map f24888f;

    j(Thread thread, int i2, String str, String str2, String str3, Map map) {
        this.f24883a = thread;
        this.f24884b = i2;
        this.f24885c = str;
        this.f24886d = str2;
        this.f24887e = str3;
        this.f24888f = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        k kVar;
        k kVar2;
        try {
            kVar = k.f24905a;
            if (kVar == null) {
                X.b("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
            } else {
                kVar2 = k.f24905a;
                kVar2.b(this.f24883a, this.f24884b, this.f24885c, this.f24886d, this.f24887e, this.f24888f);
            }
        } catch (Throwable th) {
            if (!X.a(th)) {
                th.printStackTrace();
            }
            X.b("[ExtraCrashManager] Crash error %s %s %s", this.f24885c, this.f24886d, this.f24887e);
        }
    }
}
