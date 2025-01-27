package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.X;
import java.util.Map;

/* loaded from: classes4.dex */
public class j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Thread f22507a;

    /* renamed from: b */
    final /* synthetic */ int f22508b;

    /* renamed from: c */
    final /* synthetic */ String f22509c;

    /* renamed from: d */
    final /* synthetic */ String f22510d;

    /* renamed from: e */
    final /* synthetic */ String f22511e;

    /* renamed from: f */
    final /* synthetic */ Map f22512f;

    public j(Thread thread, int i10, String str, String str2, String str3, Map map) {
        this.f22507a = thread;
        this.f22508b = i10;
        this.f22509c = str;
        this.f22510d = str2;
        this.f22511e = str3;
        this.f22512f = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        k kVar;
        k kVar2;
        try {
            kVar = k.f22535a;
            if (kVar == null) {
                X.b("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
            } else {
                kVar2 = k.f22535a;
                kVar2.b(this.f22507a, this.f22508b, this.f22509c, this.f22510d, this.f22511e, this.f22512f);
            }
        } catch (Throwable th2) {
            if (!X.a(th2)) {
                th2.printStackTrace();
            }
            X.b("[ExtraCrashManager] Crash error %s %s %s", this.f22509c, this.f22510d, this.f22511e);
        }
    }
}
