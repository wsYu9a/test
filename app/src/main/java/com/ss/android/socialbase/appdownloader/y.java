package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes4.dex */
public class y {

    /* renamed from: g */
    private long f24509g;
    private Handler gv;

    /* renamed from: i */
    private long f24510i;

    /* renamed from: j */
    private final Queue<Integer> f24511j;
    private Runnable lg;
    private SoftReference<JumpUnknownSourceActivity> q;
    private boolean zx;

    /* renamed from: com.ss.android.socialbase.appdownloader.y$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.i();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.y$2 */
    class AnonymousClass2 implements AppStatusManager.AppStatusChangeListener {
        AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            if (y.this.f24511j.isEmpty()) {
                return;
            }
            long optLong = DownloadSetting.obtainGlobal().optLong("install_on_resume_install_interval", 120000L);
            long currentTimeMillis = System.currentTimeMillis() - y.this.f24509g;
            if (currentTimeMillis < optLong) {
                if (y.this.gv.hasCallbacks(y.this.lg)) {
                    return;
                }
                y.this.gv.postDelayed(y.this.lg, optLong - currentTimeMillis);
            } else {
                y.this.f24509g = System.currentTimeMillis();
                y.this.i();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.y$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ Context f24515j;
        final /* synthetic */ Integer zx;

        AnonymousClass3(Context context, Integer num) {
            appContext = context;
            poll = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.zx(appContext, poll.intValue(), false);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.y$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: i */
        final /* synthetic */ boolean f24517i;

        /* renamed from: j */
        final /* synthetic */ Context f24518j;
        final /* synthetic */ int zx;

        AnonymousClass4(Context context, int i2, boolean z) {
            context = context;
            i2 = i2;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.j(context, i2, z);
        }
    }

    private static class j {

        /* renamed from: j */
        private static final y f24519j = new y();
    }

    /* synthetic */ y(AnonymousClass1 anonymousClass1) {
        this();
    }

    private y() {
        this.f24511j = new ArrayDeque();
        this.zx = false;
        this.gv = new Handler(Looper.getMainLooper());
        this.lg = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.y.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                y.this.i();
            }
        };
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.socialbase.appdownloader.y.2
            AnonymousClass2() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                if (y.this.f24511j.isEmpty()) {
                    return;
                }
                long optLong = DownloadSetting.obtainGlobal().optLong("install_on_resume_install_interval", 120000L);
                long currentTimeMillis = System.currentTimeMillis() - y.this.f24509g;
                if (currentTimeMillis < optLong) {
                    if (y.this.gv.hasCallbacks(y.this.lg)) {
                        return;
                    }
                    y.this.gv.postDelayed(y.this.lg, optLong - currentTimeMillis);
                } else {
                    y.this.f24509g = System.currentTimeMillis();
                    y.this.i();
                }
            }
        });
    }

    private boolean g() {
        return System.currentTimeMillis() - this.f24510i < 1000;
    }

    public void i() {
        Integer poll;
        if (Build.VERSION.SDK_INT < 29 || AppStatusManager.getInstance().isAppForeground()) {
            synchronized (this.f24511j) {
                poll = this.f24511j.poll();
            }
            this.gv.removeCallbacks(this.lg);
            if (poll == null) {
                this.zx = false;
                return;
            }
            Context appContext = DownloadComponentManager.getAppContext();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.gv.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.y.3

                    /* renamed from: j */
                    final /* synthetic */ Context f24515j;
                    final /* synthetic */ Integer zx;

                    AnonymousClass3(Context appContext2, Integer poll2) {
                        appContext = appContext2;
                        poll = poll2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        y.this.zx(appContext, poll.intValue(), false);
                    }
                });
            } else {
                zx(appContext2, poll2.intValue(), false);
            }
            this.gv.postDelayed(this.lg, 20000L);
        }
    }

    public int zx(Context context, int i2, boolean z) {
        int zx = i.zx(context, i2, z);
        if (zx == 1) {
            this.zx = true;
        }
        this.f24510i = System.currentTimeMillis();
        return zx;
    }

    void j(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        i();
    }

    public JumpUnknownSourceActivity zx() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.q;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.q = null;
        return jumpUnknownSourceActivity;
    }

    public static y j() {
        return j.f24519j;
    }

    public int j(Context context, int i2, boolean z) {
        if (z) {
            return zx(context, i2, z);
        }
        if (g()) {
            this.gv.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.y.4

                /* renamed from: i */
                final /* synthetic */ boolean f24517i;

                /* renamed from: j */
                final /* synthetic */ Context f24518j;
                final /* synthetic */ int zx;

                AnonymousClass4(Context context2, int i22, boolean z2) {
                    context = context2;
                    i2 = i22;
                    z = z2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    y.this.j(context, i2, z);
                }
            }, 1000L);
            return 1;
        }
        if (AppStatusManager.getInstance().isAppForeground()) {
            Logger.i("leaves", "on Foreground");
            return zx(context2, i22, z2);
        }
        if (zx.j()) {
            return 1;
        }
        boolean z2 = Build.VERSION.SDK_INT < 29;
        if (this.f24511j.isEmpty() && !this.zx && z2) {
            return zx(context2, i22, z2);
        }
        int optInt = DownloadSetting.obtainGlobal().optInt("install_queue_size", 3);
        synchronized (this.f24511j) {
            while (this.f24511j.size() > optInt) {
                this.f24511j.poll();
            }
        }
        if (z2) {
            this.gv.removeCallbacks(this.lg);
            this.gv.postDelayed(this.lg, DownloadSetting.obtain(i22).optLong("install_queue_timeout", 20000L));
        }
        synchronized (this.f24511j) {
            if (!this.f24511j.contains(Integer.valueOf(i22))) {
                this.f24511j.offer(Integer.valueOf(i22));
            }
        }
        return 1;
    }

    public void j(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.q = new SoftReference<>(jumpUnknownSourceActivity);
    }
}
