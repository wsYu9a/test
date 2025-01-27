package com.ss.android.downloadlib.b;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private static Handler f21545a = new Handler(Looper.getMainLooper());

    /* renamed from: com.ss.android.downloadlib.b.f$1 */
    public static class AnonymousClass1 implements AppStatusManager.AppStatusChangeListener {

        /* renamed from: b */
        final /* synthetic */ long f21547b;

        /* renamed from: c */
        final /* synthetic */ h f21548c;

        /* renamed from: com.ss.android.downloadlib.b.f$1$1 */
        public class RunnableC06391 implements Runnable {
            public RunnableC06391() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean c10 = m.c(com.ss.android.downloadad.api.a.b.this.e());
                long e10 = f.e(com.ss.android.downloadad.api.a.b.this);
                if (!c10 || e10 >= System.currentTimeMillis() - currentTimeMillis) {
                    long h10 = f.h(com.ss.android.downloadad.api.a.b.this);
                    long currentTimeMillis = System.currentTimeMillis();
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    if (currentTimeMillis - currentTimeMillis > h10) {
                        com.ss.android.downloadlib.d.a.a().a("deeplink_delay_timeout", com.ss.android.downloadad.api.a.b.this);
                        return;
                    }
                    com.ss.android.downloadad.api.a.b.this.l(true);
                    com.ss.android.downloadlib.d.a.a().a("deeplink_delay_invoke", com.ss.android.downloadad.api.a.b.this);
                    hVar.a(true);
                    com.ss.android.downloadad.api.a.b bVar = com.ss.android.downloadad.api.a.b.this;
                    f.b(bVar, f.j(bVar));
                }
            }
        }

        public AnonymousClass1(long j10, h hVar) {
            currentTimeMillis = j10;
            hVar = hVar;
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.b.f.1.1
                public RunnableC06391() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean c10 = m.c(com.ss.android.downloadad.api.a.b.this.e());
                    long e10 = f.e(com.ss.android.downloadad.api.a.b.this);
                    if (!c10 || e10 >= System.currentTimeMillis() - currentTimeMillis) {
                        long h10 = f.h(com.ss.android.downloadad.api.a.b.this);
                        long currentTimeMillis = System.currentTimeMillis();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (currentTimeMillis - currentTimeMillis > h10) {
                            com.ss.android.downloadlib.d.a.a().a("deeplink_delay_timeout", com.ss.android.downloadad.api.a.b.this);
                            return;
                        }
                        com.ss.android.downloadad.api.a.b.this.l(true);
                        com.ss.android.downloadlib.d.a.a().a("deeplink_delay_invoke", com.ss.android.downloadad.api.a.b.this);
                        hVar.a(true);
                        com.ss.android.downloadad.api.a.b bVar = com.ss.android.downloadad.api.a.b.this;
                        f.b(bVar, f.j(bVar));
                    }
                }
            });
        }
    }

    /* renamed from: com.ss.android.downloadlib.b.f$2 */
    public static class AnonymousClass2 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ int f21551b;

        public AnonymousClass2(int i10) {
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = 1;
            if (!m.c(com.ss.android.downloadad.api.a.b.this.e())) {
                f.b(com.ss.android.downloadad.api.a.b.this, i10 - 1);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!com.ss.android.downloadad.api.a.b.this.aa()) {
                    i10 = 2;
                }
                jSONObject.putOpt("deeplink_source", Integer.valueOf(i10));
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("deeplink_success_2", jSONObject, com.ss.android.downloadad.api.a.b.this);
        }
    }

    public static void b(@NonNull com.ss.android.downloadad.api.a.b bVar, int i10) {
        if (i10 <= 0) {
            return;
        }
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.b.f.2

            /* renamed from: b */
            final /* synthetic */ int f21551b;

            public AnonymousClass2(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i102 = 1;
                if (!m.c(com.ss.android.downloadad.api.a.b.this.e())) {
                    f.b(com.ss.android.downloadad.api.a.b.this, i10 - 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!com.ss.android.downloadad.api.a.b.this.aa()) {
                        i102 = 2;
                    }
                    jSONObject.putOpt("deeplink_source", Integer.valueOf(i102));
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
                com.ss.android.downloadlib.d.a.a().a("deeplink_success_2", jSONObject, com.ss.android.downloadad.api.a.b.this);
            }
        }, i(bVar) * 1000);
    }

    public static boolean c(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).optInt("app_link_opt_invoke_switch") == 1;
    }

    public static boolean d(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).optInt("app_link_opt_dialog_switch") == 1;
    }

    public static long e(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return 3000L;
        }
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).optInt("app_link_opt_back_time_limit", 3) * 1000;
    }

    public static long h(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).optLong("app_link_check_timeout", 300000L);
    }

    private static int i(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).optInt("app_link_check_delay", 1);
    }

    public static int j(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).optInt("app_link_check_count", 10);
    }

    public static void a(com.ss.android.downloadad.api.a.b bVar, @NonNull h hVar) {
        boolean isAppForeground = AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && Build.VERSION.SDK_INT >= 29) {
            m.c();
        }
        boolean isAppForeground2 = AppStatusManager.getInstance().isAppForeground();
        boolean z10 = !isAppForeground && isAppForeground2;
        if (bVar != null) {
            bVar.l(z10);
        }
        hVar.a(z10);
        if (bVar == null) {
            return;
        }
        b(bVar, j(bVar));
        if (isAppForeground2) {
            return;
        }
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.downloadlib.b.f.1

            /* renamed from: b */
            final /* synthetic */ long f21547b;

            /* renamed from: c */
            final /* synthetic */ h f21548c;

            /* renamed from: com.ss.android.downloadlib.b.f$1$1 */
            public class RunnableC06391 implements Runnable {
                public RunnableC06391() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean c10 = m.c(com.ss.android.downloadad.api.a.b.this.e());
                    long e10 = f.e(com.ss.android.downloadad.api.a.b.this);
                    if (!c10 || e10 >= System.currentTimeMillis() - currentTimeMillis) {
                        long h10 = f.h(com.ss.android.downloadad.api.a.b.this);
                        long currentTimeMillis = System.currentTimeMillis();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (currentTimeMillis - currentTimeMillis > h10) {
                            com.ss.android.downloadlib.d.a.a().a("deeplink_delay_timeout", com.ss.android.downloadad.api.a.b.this);
                            return;
                        }
                        com.ss.android.downloadad.api.a.b.this.l(true);
                        com.ss.android.downloadlib.d.a.a().a("deeplink_delay_invoke", com.ss.android.downloadad.api.a.b.this);
                        hVar.a(true);
                        com.ss.android.downloadad.api.a.b bVar = com.ss.android.downloadad.api.a.b.this;
                        f.b(bVar, f.j(bVar));
                    }
                }
            }

            public AnonymousClass1(long j10, h hVar2) {
                currentTimeMillis = j10;
                hVar = hVar2;
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.b.f.1.1
                    public RunnableC06391() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean c10 = m.c(com.ss.android.downloadad.api.a.b.this.e());
                        long e10 = f.e(com.ss.android.downloadad.api.a.b.this);
                        if (!c10 || e10 >= System.currentTimeMillis() - currentTimeMillis) {
                            long h10 = f.h(com.ss.android.downloadad.api.a.b.this);
                            long currentTimeMillis = System.currentTimeMillis();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (currentTimeMillis - currentTimeMillis > h10) {
                                com.ss.android.downloadlib.d.a.a().a("deeplink_delay_timeout", com.ss.android.downloadad.api.a.b.this);
                                return;
                            }
                            com.ss.android.downloadad.api.a.b.this.l(true);
                            com.ss.android.downloadlib.d.a.a().a("deeplink_delay_invoke", com.ss.android.downloadad.api.a.b.this);
                            hVar.a(true);
                            com.ss.android.downloadad.api.a.b bVar2 = com.ss.android.downloadad.api.a.b.this;
                            f.b(bVar2, f.j(bVar2));
                        }
                    }
                });
            }
        });
    }

    public static boolean b(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).optInt("app_link_opt_install_switch") == 1;
    }

    public static boolean a(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) bVar).optInt("app_link_opt_switch") == 1;
    }
}
