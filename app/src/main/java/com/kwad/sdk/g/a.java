package com.kwad.sdk.g;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.model.AdnName;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {
    private static List<String> aub;
    private static volatile boolean auc;

    /* renamed from: com.kwad.sdk.g.a$1 */
    static class AnonymousClass1 extends aw {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            a.AZ();
        }
    }

    @KsJson
    /* renamed from: com.kwad.sdk.g.a$a */
    public static class C0227a extends com.kwad.sdk.core.response.kwai.a {
        public long aud;
        public long aue;
        public long auf;
        public String aug;
        public String auh;
        public String aui;
        public String sdkVersion;
    }

    static class b {
        private String aug;
        private String auh;
        private String aui;
        private String sdkVersion;

        private b() {
        }

        public static String a(b bVar) {
            return "exit&" + bVar.aug + "&" + bVar.auh + "&" + bVar.aui + "&" + bVar.sdkVersion;
        }

        public static String c(String str, String str2, String str3, String str4) {
            return str + "&" + str2 + "&" + str3 + "&" + str4 + "&" + KsAdSDKImpl.get().getSDKVersion();
        }

        public static b ee(String str) {
            String[] split = str.split("&");
            b bVar = new b();
            bVar.aug = split[1];
            bVar.auh = split[2];
            bVar.aui = split[3];
            bVar.sdkVersion = split[4];
            return bVar;
        }
    }

    public static synchronized void AZ() {
        synchronized (a.class) {
            List<C0227a> Bb = Bb();
            if (!Bb.isEmpty()) {
                com.kwad.sdk.core.d.b.d("DynamicRunMonitor", "monitorInfoList:" + Bb);
                JSONObject jSONObject = new JSONObject();
                t.putValue(jSONObject, "monitor_info_list", Bb);
                KSLoggerReporter.r(jSONObject);
            }
            auc = true;
            Ba();
        }
    }

    private static void Ba() {
        List<String> list = aub;
        if (list == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            ec(it.next());
        }
        aub.clear();
    }

    private static synchronized List<C0227a> Bb() {
        synchronized (a.class) {
            ArrayList arrayList = new ArrayList();
            Map<String, ?> af = y.af(ServiceProvider.getContext(), "dynamic_monitor_info");
            if (af == null) {
                return arrayList;
            }
            for (String str : af.keySet()) {
                if (str.startsWith("enter")) {
                    Object obj = af.get(str);
                    long longValue = obj instanceof Long ? ((Long) obj).longValue() : 0L;
                    b ee = b.ee(str);
                    String a2 = b.a(ee);
                    Object obj2 = af.get(a2);
                    long longValue2 = longValue - (obj2 instanceof Long ? ((Long) obj2).longValue() : 0L);
                    long j2 = longValue2 > 0 ? longValue2 : 0L;
                    C0227a c0227a = new C0227a();
                    c0227a.aud = longValue;
                    c0227a.aue = j2;
                    c0227a.auf = longValue2;
                    c0227a.aug = ee.aug;
                    c0227a.auh = ee.auh;
                    c0227a.aui = ee.aui;
                    c0227a.sdkVersion = ee.sdkVersion;
                    arrayList.add(c0227a);
                    y.ae("dynamic_monitor_info", str);
                    y.ae("dynamic_monitor_info", a2);
                }
            }
            return arrayList;
        }
    }

    public static void U(String str, String str2) {
        e(str, str2, AdnName.OTHER);
    }

    public static void V(String str, String str2) {
        f(str, str2, AdnName.OTHER);
    }

    private static synchronized void b(String str, String str2, String str3, String str4) {
        String c2;
        synchronized (a.class) {
            try {
                c2 = b.c(str, str2, str3, str4);
            } catch (Throwable th) {
                com.kwad.components.core.c.a.b(th);
            }
            if (auc) {
                ec(c2);
            } else {
                ed(c2);
            }
        }
    }

    public static void e(String str, String str2, String str3) {
        b("enter", str, str2, str3);
    }

    private static synchronized void ec(String str) {
        synchronized (a.class) {
            long b2 = y.b("dynamic_monitor_info", str, 0L);
            com.kwad.sdk.core.d.b.d("DynamicRunMonitor", "increaseLocalCount: " + str + "--lastCount:" + b2);
            y.a("dynamic_monitor_info", str, b2 + 1);
        }
    }

    private static void ed(String str) {
        if (aub == null) {
            aub = new CopyOnWriteArrayList();
        }
        com.kwad.sdk.core.d.b.d("DynamicRunMonitor", "saveToCache: " + str);
        aub.add(str);
    }

    public static void f(String str, String str2, String str3) {
        b("exit", str, str2, str3);
    }

    public static void report() {
        g.schedule(new aw() { // from class: com.kwad.sdk.g.a.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                a.AZ();
            }
        }, 1L, TimeUnit.SECONDS);
    }
}
