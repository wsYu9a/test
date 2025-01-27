package com.kwad.sdk.core.adlog;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.pdf417.decoder.DecodedBitStreamParser;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bd;
import com.sigmob.sdk.base.mta.PointType;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class c {
    private static ExecutorService asN = GlobalThreadPools.Ho();
    public static JSONObject asO;
    public static boolean asP;

    /* renamed from: com.kwad.sdk.core.adlog.c$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ JSONObject asQ;

        public AnonymousClass1(JSONObject jSONObject) {
            jSONObject = jSONObject;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.C0484a c0484a = new a.C0484a();
            c0484a.asC = AdTemplate.this.downLoadType;
            com.kwad.sdk.core.adlog.c.b cO = new com.kwad.sdk.core.adlog.c.b().b(c0484a).cO(AdTemplate.this.downloadSource);
            c.a(AdTemplate.this, cO);
            c.a(AdTemplate.this, 31, cO.CQ(), jSONObject);
            AdInfo eb2 = e.eb(AdTemplate.this);
            ap.at(eb2.downloadFilePath, eb2.downloadId);
        }
    }

    /* renamed from: com.kwad.sdk.core.adlog.c$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ JSONObject asQ;

        public AnonymousClass2(JSONObject jSONObject) {
            jSONObject = jSONObject;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            AdInfo eb2 = e.eb(AdTemplate.this);
            int au = ap.au(eb2.downloadId, com.kwad.sdk.core.response.b.a.ay(eb2));
            com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
            AdTemplate adTemplate = AdTemplate.this;
            aVar.downloadSource = adTemplate.downloadSource;
            aVar.atA = au;
            aVar.atB = adTemplate.installFrom;
            aVar.a(new a.C0484a());
            a.C0484a c0484a = aVar.MJ;
            AdTemplate adTemplate2 = AdTemplate.this;
            c0484a.asC = adTemplate2.downLoadType;
            c.a(adTemplate2, 32, aVar, jSONObject);
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int code;
        public String msg;

        public a(int i10, String str) {
            this.code = i10;
            this.msg = str;
        }
    }

    private static int CE() {
        return an.isOrientationPortrait() ? 2 : 1;
    }

    private static boolean G(AdInfo adInfo) {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar == null) {
            return false;
        }
        String ay = com.kwad.sdk.core.response.b.a.ay(adInfo);
        if (TextUtils.isEmpty(ay)) {
            return false;
        }
        return ap.an(fVar.getContext(), ay);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, @Nullable JSONObject jSONObject) {
        if (aVar != null) {
            try {
                if (adTemplate.fromCache) {
                    aVar.a(h.ce(adTemplate));
                }
                aVar.e(adTemplate, null, null);
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
                return;
            }
        }
        a(adTemplate, 2, aVar, jSONObject);
    }

    public static void bM(AdTemplate adTemplate) {
        q(adTemplate, 4);
    }

    public static void bN(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        adTemplate.downLoadType = 3;
        aVar.a(new a.C0484a());
        aVar.MJ.asC = adTemplate.downLoadType;
        a(adTemplate, 30, aVar, (JSONObject) null);
    }

    public static void bO(AdTemplate adTemplate) {
        q(adTemplate, 36);
    }

    public static void bP(AdTemplate adTemplate) {
        q(adTemplate, 38);
    }

    public static void bQ(AdTemplate adTemplate) {
        q(adTemplate, 41);
    }

    public static void bR(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.atF = com.kwad.sdk.core.response.b.a.ay(e.eb(adTemplate));
        a(adTemplate, 768, aVar, new JSONObject());
    }

    public static void bS(@Nullable AdTemplate adTemplate) {
        f(adTemplate, null);
    }

    public static void bT(@Nullable AdTemplate adTemplate) {
        g(adTemplate, (JSONObject) null);
    }

    public static void bU(@Nullable AdTemplate adTemplate) {
        q(adTemplate, 58);
    }

    public static void bV(AdTemplate adTemplate) {
        q(adTemplate, 914);
    }

    public static void bW(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadStatus = com.kwad.sdk.core.response.b.a.bz(e.eb(adTemplate));
        com.kwad.sdk.core.d.c.d("AdReportManager", "reportDownloadCardClose downloadStatus=" + aVar.downloadStatus);
        a(adTemplate, 713, aVar, (JSONObject) null);
    }

    public static void bX(AdTemplate adTemplate) {
        q(adTemplate, 722);
    }

    public static void bY(AdTemplate adTemplate) {
        q(adTemplate, 721);
    }

    private static boolean bZ(AdTemplate adTemplate) {
        if (e.dT(adTemplate)) {
            return true;
        }
        f fVar = (f) ServiceProvider.get(f.class);
        return fVar != null && fVar.aM(adTemplate);
    }

    public static void c(AdTemplate adTemplate, JSONObject jSONObject) {
        asN.submit(new bd() { // from class: com.kwad.sdk.core.adlog.c.1
            final /* synthetic */ JSONObject asQ;

            public AnonymousClass1(JSONObject jSONObject2) {
                jSONObject = jSONObject2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.C0484a c0484a = new a.C0484a();
                c0484a.asC = AdTemplate.this.downLoadType;
                com.kwad.sdk.core.adlog.c.b cO = new com.kwad.sdk.core.adlog.c.b().b(c0484a).cO(AdTemplate.this.downloadSource);
                c.a(AdTemplate.this, cO);
                c.a(AdTemplate.this, 31, cO.CQ(), jSONObject);
                AdInfo eb2 = e.eb(AdTemplate.this);
                ap.at(eb2.downloadFilePath, eb2.downloadId);
            }
        });
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0484a());
        aVar.MJ.asC = adTemplate.downLoadType;
        a(adTemplate, 35, aVar, jSONObject);
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject) {
        asN.submit(new bd() { // from class: com.kwad.sdk.core.adlog.c.2
            final /* synthetic */ JSONObject asQ;

            public AnonymousClass2(JSONObject jSONObject2) {
                jSONObject = jSONObject2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                AdInfo eb2 = e.eb(AdTemplate.this);
                int au = ap.au(eb2.downloadId, com.kwad.sdk.core.response.b.a.ay(eb2));
                com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                AdTemplate adTemplate2 = AdTemplate.this;
                aVar.downloadSource = adTemplate2.downloadSource;
                aVar.atA = au;
                aVar.atB = adTemplate2.installFrom;
                aVar.a(new a.C0484a());
                a.C0484a c0484a = aVar.MJ;
                AdTemplate adTemplate22 = AdTemplate.this;
                c0484a.asC = adTemplate22.downLoadType;
                c.a(adTemplate22, 32, aVar, jSONObject);
            }
        });
    }

    public static void f(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 399, jSONObject);
    }

    public static void g(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 400, jSONObject);
    }

    public static void h(AdTemplate adTemplate, int i10) {
        adTemplate.mInstallApkFromSDK = true;
        adTemplate.mInstallApkFormUser = i10 == 1;
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.atR = i10;
        aVar.a(new a.C0484a());
        aVar.MJ.asC = adTemplate.downLoadType;
        a(adTemplate, 37, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, int i10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.MK = i10;
        a(adTemplate, DecodedBitStreamParser.f10596i, aVar, (JSONObject) null);
    }

    public static void j(@Nullable AdTemplate adTemplate, int i10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.atz = i10;
        b(adTemplate, "wxsmallapp", 1, aVar);
    }

    public static void k(@Nullable AdTemplate adTemplate, int i10) {
        e(adTemplate, i10, 0);
    }

    public static void l(AdTemplate adTemplate, int i10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.atk = i10;
        a(adTemplate, 759, aVar, (JSONObject) null);
    }

    public static void m(AdTemplate adTemplate, int i10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.atj = i10;
        a(adTemplate, 28, aVar, (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate, int i10) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.atF = com.kwad.sdk.core.response.b.a.ay(e.eb(adTemplate));
        a(adTemplate, i10, aVar, new JSONObject());
    }

    public static void o(AdTemplate adTemplate, int i10) {
        a(adTemplate, i10, new com.kwad.sdk.core.adlog.c.a(), new JSONObject());
    }

    @Deprecated
    public static void p(AdTemplate adTemplate, int i10) {
        e(adTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cN(i10));
    }

    private static void q(AdTemplate adTemplate, int i10) {
        a(adTemplate, i10, (com.kwad.sdk.core.adlog.c.a) null, new JSONObject());
    }

    public static boolean b(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        if (adTemplate.mPvReported) {
            return false;
        }
        adTemplate.mPvReported = true;
        AdInfo eb2 = e.eb(adTemplate);
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.cZ(CE());
        com.kwad.sdk.core.adlog.c.a CQ = bVar.CQ();
        if (adTemplate.fromCache) {
            CQ.a(h.ce(adTemplate));
        }
        CQ.atM = G(eb2) ? 1 : 0;
        return a(adTemplate, 1, CQ, jSONObject);
    }

    public static void c(@Nullable AdTemplate adTemplate, String str, int i10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.atx = i10;
        if (!str.equals("")) {
            aVar.aty = str;
        }
        a(adTemplate, 803, aVar, (JSONObject) null);
    }

    public static void e(@Nullable AdTemplate adTemplate, int i10, int i11) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.atL = i10;
        aVar.ML = i11;
        a(adTemplate, 323, aVar, (JSONObject) null);
    }

    public static void f(AdTemplate adTemplate, int i10, int i11) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.atm = 69;
        aVar.atH = i10;
        aVar.atI = i11;
        a(adTemplate, TypedValues.PositionType.TYPE_TRANSITION_EASING, aVar, (JSONObject) null);
    }

    public static void g(@Nullable AdTemplate adTemplate, boolean z10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0484a c0484a = new a.C0484a();
        if (z10) {
            c0484a.asG = 1;
        } else {
            c0484a.asG = 2;
        }
        aVar.a(c0484a);
        a(adTemplate, 323, aVar, (JSONObject) null);
    }

    public static void k(@Nullable AdTemplate adTemplate, long j10) {
        a(adTemplate, 52, com.kwad.sdk.core.adlog.c.a.CP().ap(j10), (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, TypedValues.PositionType.TYPE_TRANSITION_EASING, jSONObject);
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, TinkerReport.KEY_LOADED_INTERPRET_GET_INSTRUCTION_SET_ERROR, jSONObject);
    }

    public static void k(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, TinkerReport.KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR, jSONObject);
    }

    public static void l(AdTemplate adTemplate, long j10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.ato = j10;
        a(adTemplate, 600, aVar, (JSONObject) null);
    }

    public static void m(AdTemplate adTemplate, long j10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.atK = j10;
        a(adTemplate, 401, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, boolean z10) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0484a c0484a = new a.C0484a();
        c0484a.asD = 1;
        bVar.b(c0484a);
        if (z10) {
            bVar.cU(33);
        }
        a(adTemplate, 804, bVar.CQ(), (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, boolean z10) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0484a c0484a = new a.C0484a();
        c0484a.asD = 2;
        bVar.b(c0484a);
        if (z10) {
            bVar.cU(33);
        }
        a(adTemplate, 804, bVar.CQ(), (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i10, @Nullable ag.a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.lz = i10;
        int i11 = adTemplate.swipeAngle;
        if (i11 != 0) {
            aVar2.atV = i11;
        }
        if (aVar != null) {
            aVar2.lB = aVar;
        }
        a(adTemplate, aVar2, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a CQ = bVar.CQ();
        CQ.e(adTemplate, null, null);
        a(adTemplate, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, CQ, jSONObject);
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a CQ = bVar.CQ();
        CQ.e(adTemplate, null, null);
        a(adTemplate, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, CQ, jSONObject);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        a(adTemplate, TinkerReport.KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR, bVar != null ? bVar.CQ() : null, (JSONObject) null);
    }

    public static void h(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.atl = 1;
        a.C0484a c0484a = new a.C0484a();
        aVar.MJ = c0484a;
        c0484a.templateId = PointType.ANTI_SPAM;
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, int i10, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.atF = com.kwad.sdk.core.response.b.a.ay(e.eb(adTemplate));
        aVar.atm = 93;
        a(adTemplate, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, aVar, (JSONObject) null);
    }

    private static void d(AdTemplate adTemplate, int i10, JSONObject jSONObject) {
        a(adTemplate, i10, (com.kwad.sdk.core.adlog.c.a) null, jSONObject);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        a(adTemplate, bVar != null ? bVar.CQ() : null, jSONObject);
    }

    public static void b(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, @Nullable JSONObject jSONObject) {
        a(adTemplate, 3, bVar != null ? bVar.CQ() : null, jSONObject);
    }

    public static void h(@Nullable AdTemplate adTemplate, boolean z10) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0484a c0484a = new a.C0484a();
        if (z10) {
            c0484a.asG = 1;
        } else {
            c0484a.asG = 2;
        }
        aVar.a(c0484a);
        a(adTemplate, 652, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, long j10, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0484a c0484a = new a.C0484a();
        if (j10 != -1) {
            c0484a.duration = j10;
            aVar.MJ = c0484a;
        }
        a(adTemplate, 934, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0484a());
        aVar.MJ.asC = adTemplate.downLoadType;
        a(adTemplate, 34, aVar, jSONObject);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i10, long j10, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.atl = i10;
        a.C0484a c0484a = new a.C0484a();
        c0484a.duration = j10;
        aVar.MJ = c0484a;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void b(@Nullable AdTemplate adTemplate, String str, int i10, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.atx = i10;
        if (!str.equals("")) {
            aVar.aty = str;
        }
        a(adTemplate, 321, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i10, long j10, int i11, long j11, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.f11968xc = j10;
        aVar.atO = i11;
        aVar.atl = i10;
        a.C0484a c0484a = new a.C0484a();
        c0484a.duration = j11;
        aVar.MJ = c0484a;
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void b(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 59, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void b(AdTemplate adTemplate, int i10, @Nullable JSONObject jSONObject) {
        d(adTemplate, jSONObject, new com.kwad.sdk.core.adlog.c.b().cN(i10));
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0484a());
        aVar.MJ.asC = adTemplate.downLoadType;
        a(adTemplate, 33, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar) {
        AdInfo eb2 = e.eb(adTemplate);
        String str = eb2.downloadFilePath;
        if (str == null) {
            return;
        }
        String ay = com.kwad.sdk.core.response.b.a.ay(eb2);
        String gT = ap.gT(str);
        if (gT == null || TextUtils.isEmpty(gT) || gT.equals(ay)) {
            return;
        }
        bVar.dq(gT);
        bVar.dp(ay);
        eb2.adBaseInfo.appPackageName = gT;
    }

    public static void a(AdTemplate adTemplate, a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.atC = aVar.toJson().toString();
        aVar2.a(new a.C0484a());
        aVar2.MJ.asC = adTemplate.downLoadType;
        a(adTemplate, 40, aVar2, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, int i10, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.atx = i10;
        if (!str.equals("")) {
            aVar.aty = str;
        }
        a(adTemplate, 320, aVar, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 50, aVar, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, long j10) {
        aVar.atJ = j10;
        a(adTemplate, 51, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i10, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.atj = i10;
        a(adTemplate, 402, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i10, AdExposureFailedReason adExposureFailedReason) {
        if (i10 == 0 || i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
            aVar.atp = i10;
            if (adExposureFailedReason != null && i10 == 2) {
                aVar.atq = adExposureFailedReason.winEcpm;
                try {
                    int i11 = adExposureFailedReason.adnType;
                    aVar.adnType = i11;
                    if (i11 == 2) {
                        aVar.adnName = adExposureFailedReason.adnName;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adUserName)) {
                        aVar.atr = adExposureFailedReason.adUserName;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adTitle)) {
                        aVar.ats = adExposureFailedReason.adTitle;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adRequestId)) {
                        aVar.att = adExposureFailedReason.adRequestId;
                    }
                    aVar.atu = adExposureFailedReason.isShow;
                    aVar.atv = adExposureFailedReason.isClick;
                } catch (Throwable unused) {
                }
            }
            a(adTemplate, 809, aVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i10, JSONObject jSONObject, String str) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.MI = str;
        a(adTemplate, i10, aVar, jSONObject);
    }

    public static boolean a(@Nullable AdTemplate adTemplate, int i10, @Nullable com.kwad.sdk.core.adlog.c.a aVar, @Nullable JSONObject jSONObject) {
        if (adTemplate == null || !bZ(adTemplate)) {
            return false;
        }
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.atN = com.kwad.sdk.core.response.b.a.aT(e.eb(adTemplate));
        aVar.adxResult = adTemplate.adxResult;
        if (i10 == 2 && asP) {
            if (aVar.MJ == null) {
                aVar.MJ = new a.C0484a();
            }
            aVar.MJ.asH = asO;
        }
        aVar.adTemplate = adTemplate;
        aVar.asm = i10;
        aVar.ati = jSONObject;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i10);
        com.kwad.sdk.core.d.c.d("AdReportManager", sb2.toString());
        b.a(aVar);
        return true;
    }
}
