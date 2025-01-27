package com.ss.android.downloadlib.b;

import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.common.AppStatusManager;

/* loaded from: classes4.dex */
public class e implements AppStatusManager.AppStatusChangeListener {

    /* renamed from: a */
    private long f21540a;

    /* renamed from: com.ss.android.downloadlib.b.e$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f21541a;

        /* renamed from: b */
        final /* synthetic */ d f21542b;

        public AnonymousClass1(long j10, d dVar) {
            j10 = j10;
            dVar = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!AppStatusManager.getInstance().isAppFocus() || System.currentTimeMillis() - e.this.f21540a <= j10) {
                dVar.a(true);
            } else {
                dVar.a(false);
            }
        }
    }

    public static class a {

        /* renamed from: a */
        private static e f21544a = new e();
    }

    public /* synthetic */ e(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void b(d dVar) {
        if (dVar == null) {
            return;
        }
        a(dVar, k.j().optInt("check_an_result_delay", 1200) > 0 ? r0 : 1200);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        this.f21540a = System.currentTimeMillis();
    }

    private e() {
        this.f21540a = 0L;
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    public static e a() {
        return a.f21544a;
    }

    public void a(d dVar, long j10) {
        if (dVar == null) {
            return;
        }
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.b.e.1

            /* renamed from: a */
            final /* synthetic */ long f21541a;

            /* renamed from: b */
            final /* synthetic */ d f21542b;

            public AnonymousClass1(long j102, d dVar2) {
                j10 = j102;
                dVar = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!AppStatusManager.getInstance().isAppFocus() || System.currentTimeMillis() - e.this.f21540a <= j10) {
                    dVar.a(true);
                } else {
                    dVar.a(false);
                }
            }
        }, j102);
    }

    public void a(d dVar) {
        a(dVar, 5000L);
    }
}
