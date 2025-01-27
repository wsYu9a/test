package com.bytedance.pangle.download;

import android.os.Handler;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: e */
    private static volatile b f7543e;

    /* renamed from: a */
    final Map<String, Long> f7544a = new ConcurrentHashMap();

    /* renamed from: b */
    public final Handler f7545b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    public final Map<String, Runnable> f7546c = new ConcurrentHashMap();

    /* renamed from: d */
    final Map<String, Runnable> f7547d = new ConcurrentHashMap();

    /* renamed from: com.bytedance.pangle.download.b$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f7548a;

        public AnonymousClass1(String str2) {
            str = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            /*
                this = this;
                android.app.Application r0 = com.bytedance.pangle.Zeus.getAppApplication()
                java.lang.String r1 = r0.getPackageName()
                boolean r2 = android.text.TextUtils.isEmpty(r1)
                if (r2 != 0) goto L46
                java.lang.String r2 = "activity"
                java.lang.Object r0 = r0.getSystemService(r2)
                android.app.ActivityManager r0 = (android.app.ActivityManager) r0
                r2 = 1
                java.util.List r0 = r0.getRunningTasks(r2)
                if (r0 == 0) goto L46
                boolean r2 = r0.isEmpty()
                if (r2 != 0) goto L46
                r2 = 0
                java.lang.Object r0 = r0.get(r2)
                android.app.ActivityManager$RunningTaskInfo r0 = (android.app.ActivityManager.RunningTaskInfo) r0
                android.content.ComponentName r0 = g4.a.a(r0)
                if (r0 == 0) goto L46
                java.lang.String r0 = r0.getPackageName()
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L46
                com.bytedance.pangle.download.b r0 = com.bytedance.pangle.download.b.this
                android.os.Handler r0 = com.bytedance.pangle.download.b.a(r0)
                r1 = 1800000(0x1b7740, double:8.89318E-318)
                r0.postDelayed(r3, r1)
            L46:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.download.b.AnonymousClass1.run():void");
        }
    }

    private b() {
    }

    public static b a() {
        if (f7543e == null) {
            synchronized (b.class) {
                try {
                    if (f7543e == null) {
                        f7543e = new b();
                    }
                } finally {
                }
            }
        }
        return f7543e;
    }
}
