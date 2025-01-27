package com.kwad.components.offline.c.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ae;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class a {
    private static long agK;
    private static final AtomicBoolean afJ = new AtomicBoolean(false);
    private static final String agE = ae.format("lib%s.so", "tk_runtime_v0_0_161");
    private static final String agF = ae.format("lib%s.so", "tk_runtime_lite_v0_0_161");
    private static final String agG = ae.format("lib%s.so", "kwai-v8");
    private static final String agH = ae.format("lib%s.so", "kwai-v8-lite");
    private static final String agI = ae.format("lib%s.so", "kwad-fb");
    private static final String agJ = ae.format("lib%s.so", "kwad-yoga");
    private static final String afK = ae.format("lib%s.so", "c++_shared");
    private static Boolean agL = null;

    public static void a(Context context, @NonNull SoLoadListener soLoadListener) {
        String Dg;
        String str;
        String str2;
        AtomicBoolean atomicBoolean = afJ;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        boolean useTkLite = useTkLite();
        if (AbiUtil.isArm64(context)) {
            Dg = d.Dh();
            if (TextUtils.isEmpty(Dg)) {
                Dg = useTkLite ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v8_lite_3358" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v8_3358";
            }
            str = useTkLite ? "sotk-v8a-lite" : "sotk-v8a";
            str2 = useTkLite ? "0e2d6748c990aa021d01521b6926a5d1" : "581986671ff8549adfa5bcc94410a6d5";
            if (useTkLite) {
                hashMap.put(agF, "0666493e16b18f08ec178a949c41ce30");
                hashMap.put(agH, "77545ba1892c1a1d4a039db37b3249eb");
            } else {
                hashMap.put(agE, "a72b02a82df72cd82a3acace986099ad");
                hashMap.put(agG, "7316cd8d074b04e6cb21486288d314ce");
            }
            hashMap.put(agI, "31f065607e6da6b741330d1df0b35460");
            hashMap.put(agJ, "76308532f64b68fd5a930c42cceec22b");
            hashMap.put(afK, "2e989e1c8d777ce169376feb637530e9");
        } else {
            Dg = d.Dg();
            if (TextUtils.isEmpty(Dg)) {
                Dg = useTkLite ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v7_lite_3358" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/3.3.58/ks_tk_so_v7_3358";
            }
            str = useTkLite ? "sotk-v7a-lite" : "sotk-v7a";
            str2 = useTkLite ? "e9821df3990aca6fc2cd6b5b71c5a1df" : "16335fa1eb7d19586a6be6aa74778b5b";
            if (useTkLite) {
                hashMap.put(agF, "cb8a97957aa4cb944a27f4353be3384c");
                hashMap.put(agH, "2dbd72527a0739740746adaae48ed2e0");
            } else {
                hashMap.put(agE, "75ae8eff358638dcddad68117cbbc494");
                hashMap.put(agG, "519ba633e88efafb8fbd536d800da734");
            }
            hashMap.put(agI, "eff11bebb8a3c872fa30b0484b460d12");
            hashMap.put(agJ, "2c6f402c6a565d2e6912b0013fa59380");
            hashMap.put(afK, "2ce4deb75b884953f20ab2e6e149be98");
        }
        b bVar = new b();
        bVar.ano = com.kwad.sdk.core.network.idc.a.Fz().eg(Dg);
        bVar.Lc = true;
        bVar.ann = str;
        bVar.version = useTkLite ? "3.3.60-lite" : "3.3.60";
        bVar.anr = false;
        bVar.anq = str2;
        bVar.ant = hashMap;
        com.kwad.library.b.a j10 = com.kwad.library.solder.a.a.j(context, ITkOfflineCompo.PACKAGE_NAME);
        c.d("TkSoLoadHelper", "tkOfflineCompoPlugin: " + j10);
        if (j10 instanceof com.kwad.library.b.a) {
            bVar.anw = j10.yc();
        }
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.c.b.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            /* renamed from: b */
            public void e(com.kwad.library.solder.lib.b.c cVar) {
                super.e(cVar);
                SoLoadListener.this.onPreUpdate();
                long unused = a.agK = SystemClock.elapsedRealtime();
                TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(0).setRetryCount(cVar.yz()).setThreadPoolCoreSize(cVar.yt().yg().yH()).toJson());
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            /* renamed from: c */
            public void d(com.kwad.library.solder.lib.b.c cVar) {
                super.d(cVar);
                if (cVar.getState() == 4) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setRetryCount(cVar.yz()).setDownloadTime(SystemClock.elapsedRealtime() - a.agK).setDownloadState(1).setThreadPoolCoreSize(cVar.yt().yg().yH()).toJson());
                }
            }

            private void uO() {
                SoLoadListener.this.onLoaded();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar) {
                uO();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.c cVar, PluginError pluginError) {
                SoLoadListener.this.onFailed(pluginError.getCode(), pluginError);
                if (cVar.getState() == 1) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setRetryCount(cVar.yz()).setErrorReason(String.valueOf(pluginError.getCode())).setDownloadState(2).toJson());
                }
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a */
            public void f(com.kwad.library.solder.lib.b.c cVar) {
                super.f(cVar);
            }
        });
    }

    public static boolean useTkLite() {
        if (agL == null) {
            agL = Boolean.valueOf(!d.a(com.kwad.sdk.core.config.c.auF));
        }
        return agL.booleanValue();
    }

    /* renamed from: com.kwad.components.offline.c.b.a$1 */
    public class AnonymousClass1 extends b.c {
        public AnonymousClass1() {
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        /* renamed from: b */
        public void e(com.kwad.library.solder.lib.b.c cVar) {
            super.e(cVar);
            SoLoadListener.this.onPreUpdate();
            long unused = a.agK = SystemClock.elapsedRealtime();
            TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(0).setRetryCount(cVar.yz()).setThreadPoolCoreSize(cVar.yt().yg().yH()).toJson());
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        /* renamed from: c */
        public void d(com.kwad.library.solder.lib.b.c cVar) {
            super.d(cVar);
            if (cVar.getState() == 4) {
                TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setRetryCount(cVar.yz()).setDownloadTime(SystemClock.elapsedRealtime() - a.agK).setDownloadState(1).setThreadPoolCoreSize(cVar.yt().yg().yH()).toJson());
            }
        }

        private void uO() {
            SoLoadListener.this.onLoaded();
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar) {
            uO();
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        public void a(com.kwad.library.solder.lib.b.c cVar, PluginError pluginError) {
            SoLoadListener.this.onFailed(pluginError.getCode(), pluginError);
            if (cVar.getState() == 1) {
                TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setRetryCount(cVar.yz()).setErrorReason(String.valueOf(pluginError.getCode())).setDownloadState(2).toJson());
            }
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        /* renamed from: a */
        public void f(com.kwad.library.solder.lib.b.c cVar) {
            super.f(cVar);
        }
    }
}
