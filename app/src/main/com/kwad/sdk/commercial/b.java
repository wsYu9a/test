package com.kwad.sdk.commercial;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bu;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.x;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import com.shu.priory.config.AdKeys;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.downloader.core.breakpoint.e;
import com.sigmob.windad.WindAds;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {
    private static float arn = -1.0f;
    private static double aro = -1.0d;
    private static final AtomicBoolean arp = new AtomicBoolean();
    private static boolean arq;
    private static volatile boolean arr;
    private static List<c> ars;
    private static a art;
    private static Map<String, com.kwad.sdk.commercial.c.c> aru;

    /* renamed from: com.kwad.sdk.commercial.b$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ boolean arw;

        public AnonymousClass1(boolean z10) {
            z10 = z10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            b.b(a.this, z10);
            b.Cd();
            b.arp.set(true);
            b.nF();
        }
    }

    /* renamed from: com.kwad.sdk.commercial.b$2 */
    public class AnonymousClass2 implements com.kwai.adclient.kscommerciallogger.a.b {
        public AnonymousClass2() {
        }

        private void M(String str, String str2) {
            a.this.j(str, str2, false);
        }

        @Override // com.kwai.adclient.kscommerciallogger.a.b
        public final void L(@NonNull String str, @NonNull String str2) {
            M(str, str2);
        }
    }

    public interface a {
        @WorkerThread
        boolean AU();

        @WorkerThread
        boolean AV();

        @WorkerThread
        JSONObject AW();

        String AX();

        @WorkerThread
        void j(String str, String str2, boolean z10);
    }

    public static void Cd() {
        try {
            aru = new HashMap();
            JSONObject AW = art.AW();
            if (AW == null) {
                return;
            }
            Iterator<String> keys = AW.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = AW.optJSONObject(next);
                if (optJSONObject != null) {
                    a(next, optJSONObject.optJSONArray(k.B));
                    b(next, optJSONObject.optJSONArray("ratioApmRL"));
                }
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static synchronized void a(a aVar, boolean z10) {
        synchronized (b.class) {
            if (arq) {
                return;
            }
            arq = true;
            art = aVar;
            h.execute(new bd() { // from class: com.kwad.sdk.commercial.b.1
                final /* synthetic */ boolean arw;

                public AnonymousClass1(boolean z102) {
                    z10 = z102;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    b.b(a.this, z10);
                    b.Cd();
                    b.arp.set(true);
                    b.nF();
                }
            });
        }
    }

    private static void b(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    Object obj = jSONArray.get(i10);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String a10 = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = aru.get(a10);
                        if (cVar2 != null) {
                            cVar2.arS = true;
                            cVar2.arP = Double.parseDouble(str);
                        } else {
                            cVar.arS = true;
                            cVar.arP = Double.parseDouble(str);
                            aru.put(a10, cVar);
                        }
                    }
                }
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    public static synchronized void d(c cVar) {
        synchronized (b.class) {
            try {
                if (com.kwad.framework.a.a.ns.booleanValue()) {
                    if (cVar.category.equals(ILoggerReporter.Category.ERROR_LOG)) {
                        com.kwad.sdk.core.d.c.e("KCLogReporter", "reportItem: " + cVar);
                    } else {
                        com.kwad.sdk.core.d.c.d("KCLogReporter", "reportItem: " + cVar);
                    }
                }
                if (arp.get()) {
                    b(cVar);
                } else {
                    c(cVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void e(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_reward_check_result", "check_type").a(BusinessType.AD_REWARD).u(aVar).a(new com.kwai.adclient.kscommerciallogger.model.b("RESULT_CHECK_REWARD")));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void f(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.5d).N("ad_sdk_webview_track", "scene_id").a(BusinessType.AD_WEBVIEW).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void g(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(0.01d).N("ad_sdk_reward_performance", WindAds.REWARD_TYPE).a(BusinessType.AD_REWARD).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aYW));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void h(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_reward_performance", "page_status").a(BusinessType.AD_REWARD).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aYW));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void i(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.1d).N("ad_sdk_splash_load", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void j(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.1d).N("ad_sdk_splash_preload", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void k(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_splash_cache", "cache").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYt));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void l(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_splash_show", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void m(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_splash_monitor_view_error", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void n(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_splash_monitor_template_data_error", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static synchronized void nF() {
        synchronized (b.class) {
            try {
                List<c> list = ars;
                if (list == null) {
                    return;
                }
                Iterator<c> it = list.iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
                ars.clear();
                ars = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void o(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N("ad_sdk_splash_monitor_errorcode_error", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void p(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_block_info", e.f19025e).a(com.kwai.adclient.kscommerciallogger.model.b.aYN).u(aVar));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void q(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_image_load_perf", "image_perf").u(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aYW));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void r(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(1.0d).N("ad_thread_monitor", "thread_perf").u(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aYW));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void s(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.001d).N("ad_video_load_perf", "video_load_perf").cC("ad_video_load_perf").u(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aYW));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void t(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.001d).N("ad_video_load_failed", "video_load_failed").cC("ad_video_load_failed").u(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aYW));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static void c(c cVar) {
        if (ars == null) {
            ars = new CopyOnWriteArrayList();
        }
        ars.add(cVar);
    }

    public static void c(boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        if (z10) {
            str = "ad_sdk_reward_page_show";
        } else {
            str = "ad_sdk_fullscreen_page_show";
        }
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N(str, "page_status").a(z10 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYk));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static void a(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    Object obj = jSONArray.get(i10);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String a10 = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = aru.get(a10);
                        if (cVar2 != null) {
                            cVar2.arR = true;
                            cVar2.arO = Double.parseDouble(str);
                        } else {
                            cVar.arR = true;
                            cVar.arO = Double.parseDouble(str);
                            aru.put(a10, cVar);
                        }
                    }
                }
            } catch (JSONException e10) {
                ServiceProvider.reportSdkCaughtException(e10);
            }
        }
    }

    public static void d(boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        if (z10) {
            str = "ad_sdk_reward_callback_interaction";
        } else {
            str = "ad_sdk_fullscreen_callback_interaction";
        }
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N(str, "callback_type").a(z10 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void e(boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        if (z10) {
            str = "ad_sdk_reward_callback_load";
        } else {
            str = "ad_sdk_fullscreen_callback_load";
        }
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N(str, "callback_type").a(z10 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void f(boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        if (z10) {
            str = "ad_sdk_reward_play_error";
        } else {
            str = "ad_sdk_fullscreen_play_error";
        }
        try {
            d(c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N(str, WindAds.REWARD_TYPE).a(z10 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.aYN));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void g(boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(z10 ? 1.0d : 0.01d).N("ad_sdk_splash_single_cache", "status").a(BusinessType.AD_SPLASH).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYt));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static void b(c cVar) {
        c.a Qn;
        if (arr) {
            com.kwad.sdk.commercial.c.b a10 = a(cVar);
            if (arn == -1.0f) {
                arn = new Random().nextFloat();
            }
            if (aro == -1.0d) {
                aro = new Random().nextFloat();
            }
            if ((art.AV() || arn <= a10.arO) && bu.ay(BuildConfig.VERSION_NAME, a10.arQ)) {
                try {
                    if (ILoggerReporter.Category.ERROR_LOG.equals(a(cVar.category, cVar))) {
                        Qn = c.a.Qm();
                    } else {
                        Qn = c.a.Qn();
                    }
                    com.kwai.adclient.kscommerciallogger.a.Qd().a(Qn.b(cVar.arA).b(cVar.arB).hy(TextUtils.isEmpty(cVar.tag) ? cVar.eventId : cVar.tag).b(cVar.arC).hz(cVar.eventId).A(a(cVar.msg, a10)).Qo());
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        }
    }

    public static void g(JSONObject jSONObject) {
        String str;
        try {
            int optInt = jSONObject.optInt("load_status");
            if (optInt != 3 && optInt != 4 && optInt != 7) {
                str = ILoggerReporter.Category.APM_LOG;
                d(c.Cg().cB(str).i(1.0d).j(0.1d).k(0.001d).N("ad_sdk_dynamic_update", "load_status").a(com.kwai.adclient.kscommerciallogger.model.a.aYu).h(jSONObject));
            }
            str = ILoggerReporter.Category.ERROR_LOG;
            d(c.Cg().cB(str).i(1.0d).j(0.1d).k(0.001d).N("ad_sdk_dynamic_update", "load_status").a(com.kwai.adclient.kscommerciallogger.model.a.aYu).h(jSONObject));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static String a(com.kwad.sdk.commercial.c.b bVar, String str) {
        try {
            int lastIndexOf = str.lastIndexOf(95);
            int length = str.length() - 1;
            if (str.charAt(length) >= '0' && str.charAt(length) <= '9' && lastIndexOf != -1) {
                bVar.arQ = str.substring(lastIndexOf + 1);
                return str.substring(0, lastIndexOf);
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    @NonNull
    private static com.kwad.sdk.commercial.c.b a(c cVar) {
        double d10;
        double d11;
        String str;
        com.kwad.sdk.commercial.c.c cVar2;
        com.kwad.sdk.commercial.c.c cVar3;
        com.kwad.sdk.commercial.c.b bVar = new com.kwad.sdk.commercial.c.b();
        try {
            Boolean bool = com.kwad.framework.a.a.ns;
            if (bool.booleanValue()) {
                bVar.arO = cVar.ary;
            } else {
                bVar.arO = cVar.arx;
            }
            bVar.arP = cVar.arz;
            if (!aru.containsKey(cVar.eventId) || (cVar3 = aru.get(cVar.eventId)) == null) {
                d10 = -1.0d;
                d11 = -1.0d;
            } else {
                d10 = cVar3.arR ? cVar3.arO : -1.0d;
                d11 = cVar3.arS ? cVar3.arP : -1.0d;
                if (!TextUtils.isEmpty(cVar3.arQ)) {
                    bVar.arQ = cVar3.arQ;
                }
            }
            if (TextUtils.isEmpty(cVar.primaryKey) && bool.booleanValue()) {
                throw new Exception("primaryKey为空");
            }
            String str2 = cVar.eventId;
            if (!TextUtils.isEmpty(cVar.primaryKey)) {
                if (cVar.msg.has(cVar.primaryKey)) {
                    str = str2 + hf.e.f26694a + cVar.msg.opt(cVar.primaryKey);
                } else {
                    str = str2 + hf.e.f26694a + cVar.primaryKey;
                }
                if (aru.containsKey(str) && (cVar2 = aru.get(str)) != null) {
                    if (cVar2.arR) {
                        d10 = cVar2.arO;
                    }
                    if (cVar2.arS) {
                        d11 = cVar2.arP;
                    }
                    if (!TextUtils.isEmpty(cVar2.arQ)) {
                        bVar.arQ = cVar2.arQ;
                    }
                }
            }
            if (d10 != -1.0d) {
                bVar.arO = d10;
            }
            if (d11 != -1.0d) {
                bVar.arP = d11;
            } else {
                bVar.arP = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Aa();
            }
            cVar.arx = bVar.arO;
            cVar.arz = bVar.arP;
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        return bVar;
    }

    public static void b(a aVar, boolean z10) {
        boolean AU = aVar.AU();
        arr = AU;
        if (AU) {
            JSONObject jSONObject = new JSONObject();
            x.putValue(jSONObject, "publish_type", 0);
            x.putValue(jSONObject, "plug_sdk", z10 ? 1 : 0);
            com.kwai.adclient.kscommerciallogger.a Qd = com.kwai.adclient.kscommerciallogger.a.Qd();
            com.kwad.sdk.commercial.a aVar2 = new com.kwad.sdk.commercial.a();
            AnonymousClass2 anonymousClass2 = new com.kwai.adclient.kscommerciallogger.a.b() { // from class: com.kwad.sdk.commercial.b.2
                public AnonymousClass2() {
                }

                private void M(String str, String str2) {
                    a.this.j(str, str2, false);
                }

                @Override // com.kwai.adclient.kscommerciallogger.a.b
                public final void L(@NonNull String str, @NonNull String str2) {
                    M(str, str2);
                }
            };
            Boolean bool = com.kwad.framework.a.a.ns;
            Qd.a(aVar2, anonymousClass2, jSONObject, bool.booleanValue(), bool.booleanValue());
            com.kwad.sdk.commercial.h.a.Co().cO(aVar.AX());
        }
    }

    public static void b(boolean z10, com.kwad.sdk.commercial.c.a aVar) {
        String str;
        if (z10) {
            str = "ad_sdk_reward_download_error";
        } else {
            str = "ad_sdk_fullscreen_download_error";
        }
        try {
            d(c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N(str, "download_type").a(z10 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.aYH));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void b(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(c.Cg().cB(str).i(ILoggerReporter.Category.ERROR_LOG.equals(str) ? 1.0d : 0.001d).N("union_web_cache_load_event", "state").a(BusinessType.WEB_CACHE).u(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.aYW));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static String a(String str, c cVar) {
        return (!str.equals(ILoggerReporter.Category.APM_LOG) || aro >= cVar.arz) ? str : ILoggerReporter.Category.ERROR_LOG;
    }

    public static void a(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        String str2;
        try {
            if (ILoggerReporter.Category.ERROR_LOG.equals(str)) {
                str2 = "ad_sdk_init_error_performance";
            } else {
                str2 = "ad_sdk_init_performance";
            }
            d(c.Cg().cB(str).i(0.001d).N(str2, "init_status").a(BusinessType.AD_SDK_INIT).u(aVar).a(dVar));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void b(j jVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(1.0E-5d).N("ad_perf_monitor_net_success", "network_monitor").u(jVar).a(com.kwai.adclient.kscommerciallogger.model.d.aYW));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(boolean z10, com.kwad.sdk.commercial.c.a aVar, com.kwai.adclient.kscommerciallogger.model.d dVar) {
        String str;
        if (z10) {
            str = "ad_sdk_reward_load";
        } else {
            str = "ad_sdk_fullscreen_load";
        }
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N(str, "load_status").a(z10 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).u(aVar).a(dVar));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void b(i iVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.1d).N("ad_perf_monitor_net_error", "network_monitor").u(iVar).a(com.kwai.adclient.kscommerciallogger.model.d.aYW));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void b(@NonNull com.kwad.sdk.utils.b.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_union_kv_fail_rate", "kv").u(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.aYW));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(boolean z10, String str, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).i(1.0d).N(str, WindAds.REWARD_TYPE).a(z10 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.aYN));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(c.Cg().cB(str).i(1.0E-4d).N("union_web_cache_download_event", "state").a(BusinessType.WEB_CACHE).u(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.aYW));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(String str, WebViewLoadMsg webViewLoadMsg) {
        try {
            d(c.Cg().cB(str).i(1.0d).N("union_webview_load_event", "state").u(webViewLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.aYW));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(String str, WebViewCommercialMsg webViewCommercialMsg) {
        try {
            double d10 = webViewCommercialMsg.rate;
            if (d10 >= l5.c.f27899e) {
                x.putValue(webViewCommercialMsg.msg, k.B, d10);
            }
            if (TextUtils.isEmpty(webViewCommercialMsg.primaryKey)) {
                webViewCommercialMsg.primaryKey = "web_log";
            }
            d(c.Cg().cB(str).i(webViewCommercialMsg.rate).N(webViewCommercialMsg.eventId, webViewCommercialMsg.primaryKey).a(webViewCommercialMsg.biz).a(webViewCommercialMsg.subBiz).h(webViewCommercialMsg.msg).a(com.kwai.adclient.kscommerciallogger.model.d.aYW));
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private static JSONObject a(JSONObject jSONObject, com.kwad.sdk.commercial.c.b bVar) {
        try {
            x.putValue(jSONObject, k.B, bVar.arO);
            double d10 = bVar.arO;
            if (d10 > l5.c.f27899e) {
                x.putValue(jSONObject, "ratio_count", a(1.0d, d10, 0));
            }
            x.putValue(jSONObject, AdKeys.DEBUG_MODE, com.kwad.framework.a.a.ns.booleanValue() ? 1 : 0);
            x.putValue(jSONObject, "convert_ratio", bVar.arP);
            double d11 = bVar.arP;
            if (d11 > l5.c.f27899e) {
                x.putValue(jSONObject, "convert_ratio_count", a(1.0d, d11, 0));
            }
            return jSONObject;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            return jSONObject;
        }
    }

    private static double a(double d10, double d11, int i10) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d11)), 0, RoundingMode.HALF_UP).doubleValue();
    }
}
