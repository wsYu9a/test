package com.ss.android.downloadlib.zx;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.alipay.mobilesecuritysdk.constant.a;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class gv {

    /* renamed from: j */
    private static Handler f24384j = new Handler(Looper.getMainLooper());

    /* renamed from: com.ss.android.downloadlib.zx.gv$1 */
    static class AnonymousClass1 implements AppStatusManager.AppStatusChangeListener {

        /* renamed from: i */
        final /* synthetic */ y f24385i;
        final /* synthetic */ long zx;

        /* renamed from: com.ss.android.downloadlib.zx.gv$1$1 */
        class RunnableC05041 implements Runnable {
            RunnableC05041() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean i2 = nt.i(com.ss.android.downloadad.api.j.zx.this.q());
                long q = gv.q(com.ss.android.downloadad.api.j.zx.this);
                if (!i2 || q >= System.currentTimeMillis() - currentTimeMillis) {
                    long y = gv.y(com.ss.android.downloadad.api.j.zx.this);
                    long currentTimeMillis = System.currentTimeMillis();
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    if (currentTimeMillis - currentTimeMillis > y) {
                        com.ss.android.downloadlib.g.j.j().j("deeplink_delay_timeout", com.ss.android.downloadad.api.j.zx.this);
                        return;
                    }
                    com.ss.android.downloadad.api.j.zx.this.nt(true);
                    com.ss.android.downloadlib.g.j.j().j("deeplink_delay_invoke", com.ss.android.downloadad.api.j.zx.this);
                    yVar.j(true);
                    com.ss.android.downloadad.api.j.zx zxVar = com.ss.android.downloadad.api.j.zx.this;
                    gv.zx(zxVar, gv.pa(zxVar));
                }
            }
        }

        AnonymousClass1(long j2, y yVar) {
            currentTimeMillis = j2;
            yVar = yVar;
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            com.ss.android.downloadlib.g.j().j(new Runnable() { // from class: com.ss.android.downloadlib.zx.gv.1.1
                RunnableC05041() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean i2 = nt.i(com.ss.android.downloadad.api.j.zx.this.q());
                    long q = gv.q(com.ss.android.downloadad.api.j.zx.this);
                    if (!i2 || q >= System.currentTimeMillis() - currentTimeMillis) {
                        long y = gv.y(com.ss.android.downloadad.api.j.zx.this);
                        long currentTimeMillis = System.currentTimeMillis();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (currentTimeMillis - currentTimeMillis > y) {
                            com.ss.android.downloadlib.g.j.j().j("deeplink_delay_timeout", com.ss.android.downloadad.api.j.zx.this);
                            return;
                        }
                        com.ss.android.downloadad.api.j.zx.this.nt(true);
                        com.ss.android.downloadlib.g.j.j().j("deeplink_delay_invoke", com.ss.android.downloadad.api.j.zx.this);
                        yVar.j(true);
                        com.ss.android.downloadad.api.j.zx zxVar = com.ss.android.downloadad.api.j.zx.this;
                        gv.zx(zxVar, gv.pa(zxVar));
                    }
                }
            });
        }
    }

    /* renamed from: com.ss.android.downloadlib.zx.gv$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ int zx;

        AnonymousClass2(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = 1;
            if (!nt.i(com.ss.android.downloadad.api.j.zx.this.q())) {
                gv.zx(com.ss.android.downloadad.api.j.zx.this, i2 - 1);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!com.ss.android.downloadad.api.j.zx.this.c()) {
                    i2 = 2;
                }
                jSONObject.putOpt("deeplink_source", Integer.valueOf(i2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.g.j.j().j("deeplink_success_2", jSONObject, com.ss.android.downloadad.api.j.zx.this);
        }
    }

    public static boolean g(com.ss.android.downloadad.api.j.zx zxVar) {
        return com.ss.android.downloadlib.lg.q.j(zxVar).optInt("app_link_opt_dialog_switch") == 1;
    }

    public static boolean i(com.ss.android.downloadad.api.j.zx zxVar) {
        return com.ss.android.downloadlib.lg.q.j(zxVar).optInt("app_link_opt_invoke_switch") == 1;
    }

    private static int k(com.ss.android.downloadad.api.j.zx zxVar) {
        return com.ss.android.downloadlib.lg.q.j(zxVar).optInt("app_link_check_delay", 1);
    }

    public static int pa(com.ss.android.downloadad.api.j.zx zxVar) {
        return com.ss.android.downloadlib.lg.q.j(zxVar).optInt("app_link_check_count", 10);
    }

    public static long q(com.ss.android.downloadad.api.j.zx zxVar) {
        if (zxVar == null) {
            return 3000L;
        }
        return com.ss.android.downloadlib.lg.q.j(zxVar).optInt("app_link_opt_back_time_limit", 3) * 1000;
    }

    public static long y(com.ss.android.downloadad.api.j.zx zxVar) {
        return com.ss.android.downloadlib.lg.q.j(zxVar).optLong("app_link_check_timeout", a.k);
    }

    public static void zx(@NonNull com.ss.android.downloadad.api.j.zx zxVar, int i2) {
        if (i2 <= 0) {
            return;
        }
        com.ss.android.downloadlib.g.j().j(new Runnable() { // from class: com.ss.android.downloadlib.zx.gv.2
            final /* synthetic */ int zx;

            AnonymousClass2(int i22) {
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i22 = 1;
                if (!nt.i(com.ss.android.downloadad.api.j.zx.this.q())) {
                    gv.zx(com.ss.android.downloadad.api.j.zx.this, i2 - 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!com.ss.android.downloadad.api.j.zx.this.c()) {
                        i22 = 2;
                    }
                    jSONObject.putOpt("deeplink_source", Integer.valueOf(i22));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.downloadlib.g.j.j().j("deeplink_success_2", jSONObject, com.ss.android.downloadad.api.j.zx.this);
            }
        }, k(zxVar) * 1000);
    }

    public static void j(com.ss.android.downloadad.api.j.zx zxVar, @NonNull y yVar) {
        boolean isAppForeground = AppStatusManager.getInstance().isAppForeground();
        if (!isAppForeground && Build.VERSION.SDK_INT >= 29) {
            nt.zx();
        }
        boolean isAppForeground2 = AppStatusManager.getInstance().isAppForeground();
        boolean z = !isAppForeground && isAppForeground2;
        if (zxVar != null) {
            zxVar.nt(z);
        }
        yVar.j(z);
        if (zxVar == null) {
            return;
        }
        zx(zxVar, pa(zxVar));
        if (isAppForeground2) {
            return;
        }
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.downloadlib.zx.gv.1

            /* renamed from: i */
            final /* synthetic */ y f24385i;
            final /* synthetic */ long zx;

            /* renamed from: com.ss.android.downloadlib.zx.gv$1$1 */
            class RunnableC05041 implements Runnable {
                RunnableC05041() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean i2 = nt.i(com.ss.android.downloadad.api.j.zx.this.q());
                    long q = gv.q(com.ss.android.downloadad.api.j.zx.this);
                    if (!i2 || q >= System.currentTimeMillis() - currentTimeMillis) {
                        long y = gv.y(com.ss.android.downloadad.api.j.zx.this);
                        long currentTimeMillis = System.currentTimeMillis();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (currentTimeMillis - currentTimeMillis > y) {
                            com.ss.android.downloadlib.g.j.j().j("deeplink_delay_timeout", com.ss.android.downloadad.api.j.zx.this);
                            return;
                        }
                        com.ss.android.downloadad.api.j.zx.this.nt(true);
                        com.ss.android.downloadlib.g.j.j().j("deeplink_delay_invoke", com.ss.android.downloadad.api.j.zx.this);
                        yVar.j(true);
                        com.ss.android.downloadad.api.j.zx zxVar = com.ss.android.downloadad.api.j.zx.this;
                        gv.zx(zxVar, gv.pa(zxVar));
                    }
                }
            }

            AnonymousClass1(long j2, y yVar2) {
                currentTimeMillis = j2;
                yVar = yVar2;
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                com.ss.android.downloadlib.g.j().j(new Runnable() { // from class: com.ss.android.downloadlib.zx.gv.1.1
                    RunnableC05041() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean i2 = nt.i(com.ss.android.downloadad.api.j.zx.this.q());
                        long q = gv.q(com.ss.android.downloadad.api.j.zx.this);
                        if (!i2 || q >= System.currentTimeMillis() - currentTimeMillis) {
                            long y = gv.y(com.ss.android.downloadad.api.j.zx.this);
                            long currentTimeMillis = System.currentTimeMillis();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (currentTimeMillis - currentTimeMillis > y) {
                                com.ss.android.downloadlib.g.j.j().j("deeplink_delay_timeout", com.ss.android.downloadad.api.j.zx.this);
                                return;
                            }
                            com.ss.android.downloadad.api.j.zx.this.nt(true);
                            com.ss.android.downloadlib.g.j.j().j("deeplink_delay_invoke", com.ss.android.downloadad.api.j.zx.this);
                            yVar.j(true);
                            com.ss.android.downloadad.api.j.zx zxVar2 = com.ss.android.downloadad.api.j.zx.this;
                            gv.zx(zxVar2, gv.pa(zxVar2));
                        }
                    }
                });
            }
        });
    }

    public static boolean zx(com.ss.android.downloadad.api.j.zx zxVar) {
        return com.ss.android.downloadlib.lg.q.j(zxVar).optInt("app_link_opt_install_switch") == 1;
    }

    public static boolean j(com.ss.android.downloadad.api.j.zx zxVar) {
        return com.ss.android.downloadlib.lg.q.j(zxVar).optInt("app_link_opt_switch") == 1;
    }
}
