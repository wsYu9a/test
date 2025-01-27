package com.opos.cmn.an.i;

import com.opos.cmn.an.i.d;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a */
    private static final byte[] f16558a = new byte[0];

    /* renamed from: b */
    private static d f16559b;

    private static void a() {
        if (f16559b == null) {
            synchronized (f16558a) {
                if (f16559b == null) {
                    f16559b = new d.a().a(a.a()).b(a.b()).c(a.d()).d(a.c()).e(a.e()).a(a.f()).a();
                    com.opos.cmn.an.f.a.b("ThreadPoolTool", "initIfNeed ThreadPoolParams=" + f16559b.toString());
                }
            }
        }
    }

    public static void a(Runnable runnable) {
        a();
        ExecutorService executorService = f16559b.f16547b;
        if (executorService != null) {
            try {
                executorService.execute(runnable);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("ThreadPoolTool", "executeIOTask", e2);
            }
        }
    }
}
