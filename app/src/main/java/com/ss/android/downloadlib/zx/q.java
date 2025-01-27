package com.ss.android.downloadlib.zx;

import com.ss.android.socialbase.downloader.common.AppStatusManager;

/* loaded from: classes4.dex */
public class q implements AppStatusManager.AppStatusChangeListener {

    /* renamed from: j */
    private long f24394j;

    /* renamed from: com.ss.android.downloadlib.zx.q$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ long f24396j;
        final /* synthetic */ g zx;

        AnonymousClass1(long j2, g gVar) {
            j2 = j2;
            gVar = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!AppStatusManager.getInstance().isAppFocus() || System.currentTimeMillis() - q.this.f24394j <= j2) {
                gVar.j(true);
            } else {
                gVar.j(false);
            }
        }
    }

    private static class j {

        /* renamed from: j */
        private static q f24397j = new q();
    }

    /* synthetic */ q(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        this.f24394j = System.currentTimeMillis();
    }

    public void zx(g gVar) {
        if (gVar == null) {
            return;
        }
        j(gVar, com.ss.android.downloadlib.addownload.pa.k().optInt("check_an_result_delay", 1200) > 0 ? r1 : 1200);
    }

    private q() {
        this.f24394j = 0L;
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    public static q j() {
        return j.f24397j;
    }

    public void j(g gVar, long j2) {
        if (gVar == null) {
            return;
        }
        com.ss.android.downloadlib.g.j().j(new Runnable() { // from class: com.ss.android.downloadlib.zx.q.1

            /* renamed from: j */
            final /* synthetic */ long f24396j;
            final /* synthetic */ g zx;

            AnonymousClass1(long j22, g gVar2) {
                j2 = j22;
                gVar = gVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!AppStatusManager.getInstance().isAppFocus() || System.currentTimeMillis() - q.this.f24394j <= j2) {
                    gVar.j(true);
                } else {
                    gVar.j(false);
                }
            }
        }, j22);
    }

    public void j(g gVar) {
        j(gVar, 5000L);
    }
}
