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
public class h {

    /* renamed from: a */
    private final Queue<Integer> f21933a;

    /* renamed from: b */
    private boolean f21934b;

    /* renamed from: c */
    private long f21935c;

    /* renamed from: d */
    private long f21936d;

    /* renamed from: e */
    private SoftReference<JumpUnknownSourceActivity> f21937e;

    /* renamed from: f */
    private Handler f21938f;

    /* renamed from: g */
    private Runnable f21939g;

    /* renamed from: com.ss.android.socialbase.appdownloader.h$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.c();
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.h$2 */
    public class AnonymousClass2 implements AppStatusManager.AppStatusChangeListener {
        public AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            boolean hasCallbacks;
            if (h.this.f21933a.isEmpty()) {
                return;
            }
            long optLong = DownloadSetting.obtainGlobal().optLong("install_on_resume_install_interval", 120000L);
            long currentTimeMillis = System.currentTimeMillis() - h.this.f21936d;
            if (currentTimeMillis >= optLong) {
                h.this.f21936d = System.currentTimeMillis();
                h.this.c();
            } else {
                hasCallbacks = h.this.f21938f.hasCallbacks(h.this.f21939g);
                if (hasCallbacks) {
                    return;
                }
                h.this.f21938f.postDelayed(h.this.f21939g, optLong - currentTimeMillis);
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.h$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f21942a;

        /* renamed from: b */
        final /* synthetic */ Integer f21943b;

        public AnonymousClass3(Context context, Integer num) {
            appContext = context;
            poll = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.b(appContext, poll.intValue(), false);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.h$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f21945a;

        /* renamed from: b */
        final /* synthetic */ int f21946b;

        /* renamed from: c */
        final /* synthetic */ boolean f21947c;

        public AnonymousClass4(Context context, int i10, boolean z10) {
            context = context;
            i10 = i10;
            z10 = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.a(context, i10, z10);
        }
    }

    public static class a {

        /* renamed from: a */
        private static final h f21949a = new h();
    }

    public /* synthetic */ h(AnonymousClass1 anonymousClass1) {
        this();
    }

    private h() {
        this.f21933a = new ArrayDeque();
        this.f21934b = false;
        this.f21938f = new Handler(Looper.getMainLooper());
        this.f21939g = new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.c();
            }
        };
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.socialbase.appdownloader.h.2
            public AnonymousClass2() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                boolean hasCallbacks;
                if (h.this.f21933a.isEmpty()) {
                    return;
                }
                long optLong = DownloadSetting.obtainGlobal().optLong("install_on_resume_install_interval", 120000L);
                long currentTimeMillis = System.currentTimeMillis() - h.this.f21936d;
                if (currentTimeMillis >= optLong) {
                    h.this.f21936d = System.currentTimeMillis();
                    h.this.c();
                } else {
                    hasCallbacks = h.this.f21938f.hasCallbacks(h.this.f21939g);
                    if (hasCallbacks) {
                        return;
                    }
                    h.this.f21938f.postDelayed(h.this.f21939g, optLong - currentTimeMillis);
                }
            }
        });
    }

    public int b(Context context, int i10, boolean z10) {
        int b10 = c.b(context, i10, z10);
        if (b10 == 1) {
            this.f21934b = true;
        }
        this.f21935c = System.currentTimeMillis();
        return b10;
    }

    public void c() {
        Integer poll;
        if (Build.VERSION.SDK_INT < 29 || AppStatusManager.getInstance().isAppForeground()) {
            synchronized (this.f21933a) {
                poll = this.f21933a.poll();
            }
            this.f21938f.removeCallbacks(this.f21939g);
            if (poll == null) {
                this.f21934b = false;
                return;
            }
            Context appContext = DownloadComponentManager.getAppContext();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f21938f.post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.3

                    /* renamed from: a */
                    final /* synthetic */ Context f21942a;

                    /* renamed from: b */
                    final /* synthetic */ Integer f21943b;

                    public AnonymousClass3(Context appContext2, Integer poll2) {
                        appContext = appContext2;
                        poll = poll2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.b(appContext, poll.intValue(), false);
                    }
                });
            } else {
                b(appContext2, poll2.intValue(), false);
            }
            this.f21938f.postDelayed(this.f21939g, 20000L);
        }
    }

    private boolean d() {
        return System.currentTimeMillis() - this.f21935c < 1000;
    }

    public void a(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        c();
    }

    public JumpUnknownSourceActivity b() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.f21937e;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.f21937e = null;
        return jumpUnknownSourceActivity;
    }

    public static h a() {
        return a.f21949a;
    }

    public int a(Context context, int i10, boolean z10) {
        if (z10) {
            return b(context, i10, z10);
        }
        if (d()) {
            this.f21938f.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.h.4

                /* renamed from: a */
                final /* synthetic */ Context f21945a;

                /* renamed from: b */
                final /* synthetic */ int f21946b;

                /* renamed from: c */
                final /* synthetic */ boolean f21947c;

                public AnonymousClass4(Context context2, int i102, boolean z102) {
                    context = context2;
                    i10 = i102;
                    z10 = z102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    h.this.a(context, i10, z10);
                }
            }, 1000L);
            return 1;
        }
        if (AppStatusManager.getInstance().isAppForeground()) {
            Logger.i("leaves", "on Foreground");
            return b(context2, i102, z102);
        }
        if (b.a()) {
            return 1;
        }
        boolean z11 = Build.VERSION.SDK_INT < 29;
        if (this.f21933a.isEmpty() && !this.f21934b && z11) {
            return b(context2, i102, z102);
        }
        int optInt = DownloadSetting.obtainGlobal().optInt("install_queue_size", 3);
        synchronized (this.f21933a) {
            while (this.f21933a.size() > optInt) {
                try {
                    this.f21933a.poll();
                } finally {
                }
            }
        }
        if (z11) {
            this.f21938f.removeCallbacks(this.f21939g);
            this.f21938f.postDelayed(this.f21939g, DownloadSetting.obtain(i102).optLong("install_queue_timeout", 20000L));
        }
        synchronized (this.f21933a) {
            try {
                if (!this.f21933a.contains(Integer.valueOf(i102))) {
                    this.f21933a.offer(Integer.valueOf(i102));
                }
            } finally {
            }
        }
        return 1;
    }

    public void a(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.f21937e = new SoftReference<>(jumpUnknownSourceActivity);
    }
}
