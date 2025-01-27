package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ak;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.concurrent.ExecutorService;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {
    private static ExecutorService ahP = GlobalThreadPools.xQ();
    public static JSONObject ahQ;
    public static boolean ahR;

    /* renamed from: com.kwad.sdk.core.report.a$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ JSONObject ahS;

        AnonymousClass1(JSONObject jSONObject) {
            jSONObject = jSONObject;
        }

        @Override // java.lang.Runnable
        public final void run() {
            y.b bVar = new y.b();
            AdTemplate adTemplate = AdTemplate.this;
            bVar.downloadSource = adTemplate.downloadSource;
            a.a(adTemplate, bVar);
            a.b(AdTemplate.this, 31, bVar, jSONObject);
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(AdTemplate.this);
            ak.af(cb.downloadFilePath, cb.downloadId);
        }
    }

    /* renamed from: com.kwad.sdk.core.report.a$2 */
    static class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(AdTemplate.this);
            int ag = ak.ag(cb.downloadId, com.kwad.sdk.core.response.a.a.aq(cb));
            y.b bVar = new y.b();
            AdTemplate adTemplate = AdTemplate.this;
            bVar.downloadSource = adTemplate.downloadSource;
            bVar.aks = ag;
            bVar.akt = adTemplate.installFrom;
            a.b(adTemplate, 32, bVar, (JSONObject) null);
        }
    }

    /* renamed from: com.kwad.sdk.core.report.a$3 */
    static class AnonymousClass3 extends x {
        final /* synthetic */ JSONObject ahS;
        final /* synthetic */ int ahT;
        final /* synthetic */ y.b ahU;

        AnonymousClass3(int i2, y.b bVar, JSONObject jSONObject) {
            i2 = i2;
            bVar = bVar;
            jSONObject = jSONObject;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: wN */
        public y createRequest() {
            return new y(AdTemplate.this, i2, bVar, jSONObject);
        }
    }

    @KsJson
    /* renamed from: com.kwad.sdk.core.report.a$a */
    public static class C0218a extends com.kwad.sdk.core.response.kwai.a {
        public int code;
        public String msg;

        public C0218a(int i2, String str) {
            this.code = i2;
            this.msg = str;
        }
    }

    private static boolean C(AdInfo adInfo) {
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        if (eVar == null) {
            return false;
        }
        String aq = com.kwad.sdk.core.response.a.a.aq(adInfo);
        if (TextUtils.isEmpty(aq)) {
            return false;
        }
        return ak.ah(eVar.getContext(), aq);
    }

    public static void a(AdTemplate adTemplate, int i2, long j2, int i3, long j3, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.uV = j2;
        bVar.akI = i3;
        bVar.akh = i2;
        y.a aVar = new y.a();
        aVar.duration = j3;
        bVar.akG = aVar;
        b(adTemplate, 3, bVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i2, long j2, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.akh = i2;
        y.a aVar = new y.a();
        aVar.duration = j2;
        bVar.akG = aVar;
        b(adTemplate, 3, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i2, AdExposureFailedReason adExposureFailedReason) {
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            y.b bVar = new y.b();
            bVar.akl = i2;
            if (adExposureFailedReason != null && i2 == 2) {
                bVar.akm = adExposureFailedReason.winEcpm;
                try {
                    int i3 = adExposureFailedReason.adnType;
                    bVar.adnType = i3;
                    if (i3 == 2) {
                        bVar.adnName = adExposureFailedReason.adnName;
                    }
                } catch (Throwable unused) {
                }
            }
            b(adTemplate, 809, bVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i2, @NonNull y.b bVar, @Nullable JSONObject jSONObject) {
        bVar.aki = i2;
        b(adTemplate, 140, bVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i2, @Nullable ac.a aVar) {
        y.b bVar = new y.b();
        bVar.jU = i2;
        if (aVar != null) {
            bVar.jW = aVar;
        }
        a(adTemplate, bVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i2, ac.a aVar, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.jU = i2;
        bVar.jW = aVar;
        a(adTemplate, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.akf = i2;
        b(adTemplate, 402, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i2, JSONObject jSONObject, String str) {
        y.b bVar = new y.b();
        bVar.Ts = str;
        b(adTemplate, i2, bVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, long j2, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        y.a aVar = new y.a();
        if (j2 != -1) {
            aVar.duration = j2;
            bVar.akG = aVar;
        }
        b(adTemplate, 934, bVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, C0218a c0218a) {
        y.b bVar = new y.b();
        bVar.aku = c0218a.toJson().toString();
        b(adTemplate, 40, bVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, @Nullable i iVar) {
        b(adTemplate, 141, iVar != null ? iVar.wY() : null, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, i iVar, JSONObject jSONObject) {
        a(adTemplate, iVar != null ? iVar.wY() : null, jSONObject);
    }

    public static void a(AdTemplate adTemplate, y.b bVar) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        String str = cb.downloadFilePath;
        if (str == null) {
            return;
        }
        String aq = com.kwad.sdk.core.response.a.a.aq(cb);
        String eI = ak.eI(str);
        if (eI == null || TextUtils.isEmpty(eI) || eI.equals(aq)) {
            return;
        }
        bVar.akx = eI;
        bVar.akw = aq;
        cb.adBaseInfo.appPackageName = eI;
    }

    public static void a(AdTemplate adTemplate, y.b bVar, @Nullable JSONObject jSONObject) {
        if (bVar != null && adTemplate.fromCache) {
            bVar.a(j.aE(adTemplate));
        }
        b(adTemplate, 2, bVar, jSONObject);
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, int i2) {
        y.b bVar = new y.b();
        bVar.akp = i2;
        if (!str.equals("")) {
            bVar.akq = str;
        }
        b(adTemplate, 803, bVar, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, int i2, y.b bVar) {
        if (bVar == null) {
            bVar = new y.b();
        }
        bVar.akp = i2;
        if (!str.equals("")) {
            bVar.akq = str;
        }
        b(adTemplate, 320, bVar, (JSONObject) null);
    }

    public static void aA(AdTemplate adTemplate) {
        r(adTemplate, 721);
    }

    public static void aB(AdTemplate adTemplate) {
        i iVar = new i();
        y.a aVar = new y.a();
        aVar.aka = 1;
        iVar.a(aVar);
        b(adTemplate, 804, iVar.wY(), (JSONObject) null);
    }

    public static void aC(AdTemplate adTemplate) {
        i iVar = new i();
        y.a aVar = new y.a();
        aVar.aka = 2;
        iVar.a(aVar);
        b(adTemplate, 804, iVar.wY(), (JSONObject) null);
    }

    private static boolean aD(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.a.d.bT(adTemplate)) {
            return true;
        }
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        return eVar != null && eVar.X(adTemplate);
    }

    public static void ao(AdTemplate adTemplate) {
        r(adTemplate, 4);
    }

    public static void ap(AdTemplate adTemplate) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 30, bVar, (JSONObject) null);
    }

    public static void aq(AdTemplate adTemplate) {
        ahP.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(AdTemplate.this);
                int ag = ak.ag(cb.downloadId, com.kwad.sdk.core.response.a.a.aq(cb));
                y.b bVar = new y.b();
                AdTemplate adTemplate2 = AdTemplate.this;
                bVar.downloadSource = adTemplate2.downloadSource;
                bVar.aks = ag;
                bVar.akt = adTemplate2.installFrom;
                a.b(adTemplate2, 32, bVar, (JSONObject) null);
            }
        });
    }

    public static void ar(AdTemplate adTemplate) {
        r(adTemplate, 36);
    }

    public static void as(AdTemplate adTemplate) {
        r(adTemplate, 38);
    }

    public static void at(AdTemplate adTemplate) {
        r(adTemplate, 41);
    }

    public static void au(AdTemplate adTemplate) {
        y.b bVar = new y.b();
        bVar.akw = com.kwad.sdk.core.response.a.a.aq(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        b(adTemplate, 768, bVar, new JSONObject());
    }

    public static void av(@Nullable AdTemplate adTemplate) {
        h(adTemplate, null);
    }

    public static void aw(@Nullable AdTemplate adTemplate) {
        r(adTemplate, 58);
    }

    public static void ax(AdTemplate adTemplate) {
        r(adTemplate, 914);
    }

    public static void ay(AdTemplate adTemplate) {
        y.b bVar = new y.b();
        bVar.akE = com.kwad.sdk.core.response.a.a.bo(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        com.kwad.sdk.core.d.b.d("AdReportManager", "reportDownloadCardClose downloadStatus=" + bVar.akE);
        b(adTemplate, 713, bVar, (JSONObject) null);
    }

    public static void az(AdTemplate adTemplate) {
        r(adTemplate, 722);
    }

    public static void b(@Nullable AdTemplate adTemplate, int i2, @Nullable y.b bVar, @Nullable JSONObject jSONObject) {
        if (adTemplate == null || !aD(adTemplate)) {
            return;
        }
        if (bVar == null) {
            bVar = new y.b();
        }
        bVar.akF = com.kwad.sdk.core.response.a.a.aL(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        com.kwad.sdk.core.d.b.d("AdReportManager", sb.toString());
        bVar.adxResult = adTemplate.adxResult;
        if (i2 == 2 && ahR) {
            if (bVar.akG == null) {
                bVar.akG = new y.a();
            }
            bVar.akG.akd = ahQ;
        }
        new x() { // from class: com.kwad.sdk.core.report.a.3
            final /* synthetic */ JSONObject ahS;
            final /* synthetic */ int ahT;
            final /* synthetic */ y.b ahU;

            AnonymousClass3(int i22, y.b bVar2, JSONObject jSONObject2) {
                i2 = i22;
                bVar = bVar2;
                jSONObject = jSONObject2;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: wN */
            public y createRequest() {
                return new y(AdTemplate.this, i2, bVar, jSONObject);
            }
        }.fetch();
    }

    public static void b(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.aki = i2;
        b(adTemplate, 140, bVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate, i iVar, @Nullable JSONObject jSONObject) {
        b(adTemplate, 3, iVar != null ? iVar.wY() : null, jSONObject);
    }

    public static void b(@Nullable AdTemplate adTemplate, y.b bVar) {
        b(adTemplate, 50, bVar, (JSONObject) null);
    }

    public static void b(@Nullable AdTemplate adTemplate, String str, int i2, y.b bVar) {
        if (bVar == null) {
            bVar = new y.b();
        }
        bVar.akp = i2;
        if (!str.equals("")) {
            bVar.akq = str;
        }
        b(adTemplate, 321, bVar, (JSONObject) null);
    }

    public static void b(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable i iVar) {
        if (adTemplate.mPvReported) {
            return;
        }
        adTemplate.mPvReported = true;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (iVar == null) {
            iVar = new i();
        }
        iVar.bu(wM());
        y.b wY = iVar.wY();
        if (adTemplate.fromCache) {
            wY.a(j.aE(adTemplate));
        }
        wY.akD = C(cb) ? 1 : 0;
        b(adTemplate, 1, wY, jSONObject);
    }

    public static void c(@Nullable AdTemplate adTemplate, int i2, int i3) {
        y.b bVar = new y.b();
        bVar.akC = i2;
        bVar.akR = i3;
        b(adTemplate, 323, bVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, int i2, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.akw = com.kwad.sdk.core.response.a.a.aq(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        bVar.aki = 93;
        b(adTemplate, 140, bVar, (JSONObject) null);
    }

    public static void c(@Nullable AdTemplate adTemplate, y.b bVar) {
        b(adTemplate, 51, bVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 33, bVar, jSONObject);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject, i iVar) {
        b(adTemplate, TinkerReport.KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR, iVar != null ? iVar.wY() : null, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, int i2, int i3) {
        y.b bVar = new y.b();
        bVar.aki = 69;
        bVar.aky = i2;
        bVar.akz = i3;
        b(adTemplate, HttpStatus.SC_NOT_IMPLEMENTED, bVar, (JSONObject) null);
    }

    private static void d(AdTemplate adTemplate, int i2, JSONObject jSONObject) {
        b(adTemplate, i2, (y.b) null, jSONObject);
    }

    public static void d(@Nullable AdTemplate adTemplate, y.b bVar) {
        b(adTemplate, 52, bVar, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 34, bVar, jSONObject);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject, i iVar) {
        b(adTemplate, 140, iVar != null ? iVar.wY() : null, jSONObject);
    }

    public static void e(@Nullable AdTemplate adTemplate, y.b bVar) {
        b(adTemplate, 59, bVar, (JSONObject) null);
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject) {
        ahP.submit(new Runnable() { // from class: com.kwad.sdk.core.report.a.1
            final /* synthetic */ JSONObject ahS;

            AnonymousClass1(JSONObject jSONObject2) {
                jSONObject = jSONObject2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                y.b bVar = new y.b();
                AdTemplate adTemplate2 = AdTemplate.this;
                bVar.downloadSource = adTemplate2.downloadSource;
                a.a(adTemplate2, bVar);
                a.b(AdTemplate.this, 31, bVar, jSONObject);
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(AdTemplate.this);
                ak.af(cb.downloadFilePath, cb.downloadId);
            }
        });
    }

    public static void f(AdTemplate adTemplate, JSONObject jSONObject) {
        y.b bVar = new y.b();
        bVar.downloadSource = adTemplate.downloadSource;
        b(adTemplate, 35, bVar, jSONObject);
    }

    public static void g(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 399, jSONObject);
    }

    public static void h(@Nullable AdTemplate adTemplate) {
        g(adTemplate, null);
    }

    public static void h(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 400, jSONObject);
    }

    public static void i(AdTemplate adTemplate, int i2) {
        y.b bVar = new y.b();
        bVar.akN = i2;
        b(adTemplate, 37, bVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, long j2) {
        y.b bVar = new y.b();
        bVar.akk = j2;
        b(adTemplate, 600, bVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, HttpStatus.SC_NOT_IMPLEMENTED, jSONObject);
    }

    public static void j(AdTemplate adTemplate, int i2) {
        y.b bVar = new y.b();
        bVar.ako = i2;
        b(adTemplate, 923, bVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, long j2) {
        y.b bVar = new y.b();
        bVar.akB = j2;
        b(adTemplate, 401, bVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, TinkerReport.KEY_LOADED_INTERPRET_GET_INSTRUCTION_SET_ERROR, jSONObject);
    }

    public static void k(@Nullable AdTemplate adTemplate, int i2) {
        y.b bVar = new y.b();
        bVar.akr = i2;
        b(adTemplate, "wxsmallapp", 1, bVar);
    }

    public static void k(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, TinkerReport.KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR, jSONObject);
    }

    public static void l(@Nullable AdTemplate adTemplate, int i2) {
        c(adTemplate, i2, 0);
    }

    public static void m(AdTemplate adTemplate, int i2) {
        y.b bVar = new y.b();
        bVar.akg = i2;
        b(adTemplate, 759, bVar, (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate, int i2) {
        y.b bVar = new y.b();
        bVar.akf = i2;
        b(adTemplate, 28, bVar, (JSONObject) null);
    }

    public static void o(AdTemplate adTemplate, int i2) {
        if (adTemplate == null) {
            return;
        }
        y.b bVar = new y.b();
        bVar.akw = com.kwad.sdk.core.response.a.a.aq(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        b(adTemplate, i2, bVar, new JSONObject());
    }

    public static void p(AdTemplate adTemplate, int i2) {
        b(adTemplate, i2, new y.b(), new JSONObject());
    }

    @Deprecated
    public static void q(AdTemplate adTemplate, int i2) {
        a(adTemplate, new i().bl(i2));
    }

    private static void r(AdTemplate adTemplate, int i2) {
        b(adTemplate, i2, (y.b) null, new JSONObject());
    }

    private static int wM() {
        return ai.DM() ? 2 : 1;
    }
}
