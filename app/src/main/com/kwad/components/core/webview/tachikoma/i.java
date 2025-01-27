package com.kwad.components.core.webview.tachikoma;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.l;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.av;
import com.kwad.components.core.webview.jshandler.ax;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.r;
import com.kwad.components.core.webview.tachikoma.a.s;
import com.kwad.components.core.webview.tachikoma.a.t;
import com.kwad.components.core.webview.tachikoma.a.v;
import com.kwad.components.core.webview.tachikoma.a.x;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.n;
import com.kwad.components.core.webview.tachikoma.b.y;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.p;
import com.kwad.sdk.components.q;
import com.kwad.sdk.components.s;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.z;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class i implements com.kwad.components.core.e.e.f, p, com.kwad.sdk.core.view.b, com.kwad.sdk.core.webview.d.a.a {
    private static Map<Integer, WeakReference<com.kwad.components.core.webview.tachikoma.c.e>> ach = new HashMap();
    private long GC;
    private StyleTemplate Vh;
    private av Yk;
    private com.kwad.sdk.core.download.d Yl;
    private com.kwad.components.core.webview.tachikoma.c.e abM;
    protected j abN;
    private com.kwad.sdk.core.webview.c.g abO;
    private com.kwad.components.core.n.a.d.c abP;
    private Future<?> abQ;
    private s abR;
    private com.kwad.components.core.webview.tachikoma.a.p abS;
    private ax abT;
    private bb abU;
    private com.kwad.sdk.core.view.d abV;
    private TextView abW;
    private boolean abX;
    private boolean abY;
    private boolean abZ;
    private boolean aca;
    private boolean acb;
    private int acc;
    private long acd;
    private long ace;
    private long acf;
    private Map<String, Object> acg;
    private int aci;
    private int acj;
    private boolean ack;
    private String acl;
    private String acm;
    protected com.kwad.sdk.core.webview.e acn;
    private KsAdWebView.b aco;
    private a acp;
    private q acq;
    private com.kwad.sdk.components.k acr;
    private final Runnable acs;
    private final Runnable act;

    /* renamed from: ed */
    private ay f11958ed;

    /* renamed from: ia */
    private final l f11959ia;

    @Nullable
    private Activity mActivity;
    private AdResultData mAdResultData;
    protected final Context mContext;
    private final y xS;
    protected long yV;

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$1 */
    public class AnonymousClass1 implements KsAdWebView.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.b
        public final void onFailed() {
            if (i.this.Yk != null) {
                i.this.Yk.onFailed();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.b
        public final void onSuccess() {
            if (i.this.Yk != null) {
                i.this.Yk.onSuccess();
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$10 */
    public class AnonymousClass10 extends com.kwad.sdk.core.download.d {
        final /* synthetic */ com.kwad.components.core.webview.tachikoma.a.l Yq;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass10(AdTemplate adTemplate, com.kwad.components.core.webview.tachikoma.a.l lVar) {
            super(adTemplate);
            lVar = lVar;
        }

        @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
        public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
            super.b(str, str2, eVar);
            com.kwad.components.core.webview.tachikoma.b.b bVar = new com.kwad.components.core.webview.tachikoma.b.b();
            bVar.adl = 1;
            lVar.a(bVar);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$11 */
    public class AnonymousClass11 implements t.a {
        public AnonymousClass11() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.t.a
        public final void b(com.kwad.components.core.webview.tachikoma.b.t tVar) {
            i.this.abN.a(tVar);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$12 */
    public class AnonymousClass12 extends bd {

        /* renamed from: com.kwad.components.core.webview.tachikoma.i$12$1 */
        public class AnonymousClass1 implements TKDownloadListener {
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.offline.api.tk.TKDownloadListener
            public final void onFailed(String str) {
                i.this.aU(str);
            }

            @Override // com.kwad.components.offline.api.tk.TKDownloadListener
            public final void onSuccess(@NonNull StyleTemplate styleTemplate) {
                i.this.b(styleTemplate);
            }
        }

        public AnonymousClass12() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            i.this.GC = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.d.c.d("TKLoadController", "开始读取模板 id: " + i.this.abN.getTkTemplateId());
            i.this.a(new TKDownloadListener() { // from class: com.kwad.components.core.webview.tachikoma.i.12.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                public final void onFailed(String str) {
                    i.this.aU(str);
                }

                @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                public final void onSuccess(@NonNull StyleTemplate styleTemplate) {
                    i.this.b(styleTemplate);
                }
            });
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$13 */
    public class AnonymousClass13 implements v.a {
        public AnonymousClass13() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.v.a
        public final void b(m mVar) {
            i.this.abN.a(mVar);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$14 */
    public class AnonymousClass14 extends r {
        public AnonymousClass14() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.r
        public final void a(com.kwad.components.core.webview.tachikoma.b.r rVar) {
            super.a(rVar);
            if (i.this.mActivity == null) {
                i iVar = i.this;
                com.kwad.sdk.core.c.b.Fi();
                iVar.mActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            }
            if (i.this.mActivity == null || i.this.mActivity.isFinishing()) {
                return;
            }
            if (i.this.abM != null) {
                i.this.abM.dismiss();
            }
            e.b bVar = new e.b();
            bVar.a(i.this.mAdResultData);
            bVar.aZ(rVar.templateId);
            i.this.abM = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
            i.this.abM.show(i.this.mActivity.getFragmentManager(), "");
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$15 */
    public class AnonymousClass15 extends com.kwad.components.core.webview.tachikoma.a.c {
        public AnonymousClass15() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.c
        public final void js() {
            super.js();
            if (i.this.abM != null) {
                i.this.abM.dismiss();
            }
            j jVar = i.this.abN;
            if (jVar != null) {
                jVar.az();
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$16 */
    public class AnonymousClass16 implements com.kwad.sdk.core.webview.d.a.b {
        public AnonymousClass16() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.b
        public final void b(WebCloseStatus webCloseStatus) {
            i.this.abN.a(webCloseStatus);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$17 */
    public class AnonymousClass17 extends com.kwad.components.core.webview.tachikoma.a.d {
        public AnonymousClass17() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.d
        public final void a(com.kwad.components.core.webview.tachikoma.b.g gVar) {
            int i10 = gVar.Yy;
            AdTemplate a10 = i10 >= 0 ? com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.n.a.d.a.a.au(i10), gVar.Li) : null;
            if (a10 == null) {
                a10 = i.this.tP();
            }
            com.kwad.components.core.o.a.ri().a(gVar.actionType, a10, gVar.MI);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$18 */
    public class AnonymousClass18 extends com.kwad.components.core.webview.tachikoma.a.j {
        public AnonymousClass18() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.j
        public final void a(n nVar) {
            super.a(nVar);
            AdWebViewActivityProxy.launch(i.this.mContext, new AdWebViewActivityProxy.a.C0438a().au(nVar.title).av(nVar.url).aF(!nVar.adv).n(i.this.mAdResultData).qa());
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$19 */
    public class AnonymousClass19 extends l {
        public AnonymousClass19() {
        }

        private void g(double d10) {
            i.this.xS.adC = false;
            i.this.xS.Tz = false;
            i.this.xS.oZ = (int) ((d10 / 1000.0d) + 0.5d);
            jp();
        }

        private void jp() {
            if (i.this.abS == null || i.this.xS == null) {
                return;
            }
            i.this.abS.a(i.this.xS);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            i.this.xS.Tz = true;
            i.this.xS.adC = false;
            i.this.xS.oZ = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.eb(i.this.tP()));
            jp();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i10, int i11) {
            i.this.xS.adC = true;
            i.this.xS.Tz = false;
            jp();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            g(j11);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            g(l5.c.f27899e);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPreparing() {
            g(l5.c.f27899e);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            i.b(i.this, true);
            i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$20 */
    public class AnonymousClass20 implements Runnable {
        final /* synthetic */ s acy;

        public AnonymousClass20(s sVar) {
            sVar = sVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            s sVar = sVar;
            if (sVar != null) {
                sVar.onDestroy();
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$21 */
    public class AnonymousClass21 implements Runnable {
        final /* synthetic */ String acA;
        final /* synthetic */ String acB;
        final /* synthetic */ String acC;
        final /* synthetic */ String acD;
        final /* synthetic */ String acz;

        /* renamed from: com.kwad.components.core.webview.tachikoma.i$21$1 */
        public class AnonymousClass1 implements AdHttpBodyBuilder {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
            public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                adHttpFormDataBuilder.addFormDataPart(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID, string3);
                adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                adHttpFormDataBuilder.addFormDataPart("os_build_serial", "unknown");
                adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                adHttpFormDataBuilder.addFormDataPart("app_version", BuildConfig.VERSION_NAME);
                adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                adHttpFormDataBuilder.addFormDataPart("uid", "");
                adHttpFormDataBuilder.addFormDataPart("did", ba.getDeviceId());
                adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                try {
                    adHttpFormDataBuilder.addFormDataPart(com.sigmob.sdk.base.k.f18193y, UUID.randomUUID().toString() + ".json", "application/octet-stream", str.getBytes("UTF-8"));
                } catch (UnsupportedEncodingException e10) {
                    com.kwad.sdk.core.d.c.printStackTrace(e10);
                }
            }
        }

        public AnonymousClass21(String str, String str2, String str3, String str4, String str5) {
            string3 = str;
            string4 = str2;
            string2 = str3;
            string = str4;
            str = str5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("coverage_task_id", Integer.valueOf(string3));
                jSONObject.put(com.umeng.analytics.pro.bd.f23533m, "");
                jSONObject.put(o3.a.f29032k, System.currentTimeMillis() / 1000);
                jSONObject.put("branch_name", string4);
                jSONObject.put("version", BuildConfig.VERSION_NAME);
                jSONObject.put("tk_version", String.valueOf(i.this.Vh.templateVersionCode));
                jSONObject.put("tk_template_ids", i.this.Vh.templateId);
            } catch (JSONException e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
            com.kwad.sdk.core.network.c doPost = com.kwad.sdk.g.zc().doPost(string2 + "/analysis/add/pkg/info", (Map<String, String>) null, jSONObject);
            if (doPost.Fr()) {
                com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率pkg完成:" + doPost.azu);
            } else {
                com.kwad.sdk.core.d.c.d("TKLoadController", "上传覆盖率pkg失败");
            }
            com.kwad.sdk.core.network.c doPost2 = com.kwad.sdk.g.zc().doPost(string2 + "/attachment/ec", (Map<String, String>) null, new AdHttpBodyBuilder() { // from class: com.kwad.components.core.webview.tachikoma.i.21.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
                public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                    adHttpFormDataBuilder.addFormDataPart(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID, string3);
                    adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                    adHttpFormDataBuilder.addFormDataPart("os_build_serial", "unknown");
                    adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                    adHttpFormDataBuilder.addFormDataPart("app_version", BuildConfig.VERSION_NAME);
                    adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                    adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                    adHttpFormDataBuilder.addFormDataPart("uid", "");
                    adHttpFormDataBuilder.addFormDataPart("did", ba.getDeviceId());
                    adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                    adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                    try {
                        adHttpFormDataBuilder.addFormDataPart(com.sigmob.sdk.base.k.f18193y, UUID.randomUUID().toString() + ".json", "application/octet-stream", str.getBytes("UTF-8"));
                    } catch (UnsupportedEncodingException e102) {
                        com.kwad.sdk.core.d.c.printStackTrace(e102);
                    }
                }
            });
            if (!doPost2.Fr()) {
                com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率失败");
                return;
            }
            com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率完成:" + doPost2.azu);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$22 */
    public class AnonymousClass22 extends bd {
        final /* synthetic */ StyleTemplate acF;

        public AnonymousClass22(StyleTemplate styleTemplate) {
            styleTemplate = styleTemplate;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            i iVar = i.this;
            iVar.a(styleTemplate, iVar.acp);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$23 */
    public class AnonymousClass23 implements a {
        public AnonymousClass23() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.i.a
        public final void onFailed() {
            i.this.b(TKRenderFailReason.RENDER_ERROR);
            com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
        }

        @Override // com.kwad.components.core.webview.tachikoma.i.a
        public final void onSuccess() {
            com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$24 */
    public class AnonymousClass24 implements com.kwad.sdk.components.r {
        final /* synthetic */ a acG;

        public AnonymousClass24(a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.components.r
        public final void onFailed(Throwable th2) {
            a aVar = aVar;
            if (aVar != null) {
                aVar.onFailed();
            }
            i.this.f(th2);
        }

        @Override // com.kwad.sdk.components.r
        public final void onSuccess() {
            a aVar = aVar;
            if (aVar != null) {
                aVar.onSuccess();
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$26 */
    public class AnonymousClass26 implements com.kwad.sdk.components.k {
        public AnonymousClass26() {
        }

        @Override // com.kwad.sdk.components.k
        public final com.kwad.sdk.components.j aT(int i10) {
            return i.this.aI(com.kwad.sdk.core.response.b.c.o(com.kwad.components.core.n.a.d.a.a.au(i10)));
        }

        @Override // com.kwad.sdk.components.k
        public final com.kwad.sdk.components.j aY(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.parseJson(jSONObject);
                return i.this.aI(adTemplate);
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTrace(th2);
                return null;
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$27 */
    public class AnonymousClass27 implements com.kwad.sdk.components.j {
        final /* synthetic */ com.kwad.components.core.e.d.c acJ;
        final /* synthetic */ AdTemplate cP;

        /* renamed from: com.kwad.components.core.webview.tachikoma.i$27$1 */
        public class AnonymousClass1 extends com.kwad.sdk.core.download.a.a {
            final /* synthetic */ com.kwad.sdk.components.i acK;

            public AnonymousClass1(com.kwad.sdk.components.i iVar) {
                iVar = iVar;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                iVar.onDownloadFailed();
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                iVar.onDownloadFinished();
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                iVar.onDownloadStarted();
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                iVar.onIdle();
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                iVar.onInstalled();
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i10) {
                long j10;
                long j11;
                AdTemplate adTemplate = i.this.acn.getAdTemplate();
                if (adTemplate != null) {
                    j10 = com.kwad.sdk.core.response.b.e.eb(adTemplate).totalBytes;
                    j11 = com.kwad.sdk.core.response.b.e.eb(adTemplate).soFarBytes;
                } else {
                    j10 = 0;
                    j11 = 0;
                }
                iVar.onPaused(i10, j10, j11);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
                long j10;
                long j11;
                AdTemplate adTemplate = i.this.acn.getAdTemplate();
                if (adTemplate != null) {
                    j10 = com.kwad.sdk.core.response.b.e.eb(adTemplate).totalBytes;
                    j11 = com.kwad.sdk.core.response.b.e.eb(adTemplate).soFarBytes;
                } else {
                    j10 = 0;
                    j11 = 0;
                }
                iVar.onProgressUpdate(i10, j10, j11);
            }
        }

        public AnonymousClass27(com.kwad.components.core.e.d.c cVar, AdTemplate adTemplate) {
            cVar = cVar;
            adTemplate = adTemplate;
        }

        @Override // com.kwad.sdk.components.j
        public final void a(com.kwad.sdk.components.i iVar) {
            cVar.b(new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.tachikoma.i.27.1
                final /* synthetic */ com.kwad.sdk.components.i acK;

                public AnonymousClass1(com.kwad.sdk.components.i iVar2) {
                    iVar = iVar2;
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    iVar.onDownloadFailed();
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    iVar.onDownloadFinished();
                }

                @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadStarted() {
                    iVar.onDownloadStarted();
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    iVar.onIdle();
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    iVar.onInstalled();
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i10) {
                    long j10;
                    long j11;
                    AdTemplate adTemplate = i.this.acn.getAdTemplate();
                    if (adTemplate != null) {
                        j10 = com.kwad.sdk.core.response.b.e.eb(adTemplate).totalBytes;
                        j11 = com.kwad.sdk.core.response.b.e.eb(adTemplate).soFarBytes;
                    } else {
                        j10 = 0;
                        j11 = 0;
                    }
                    iVar.onPaused(i10, j10, j11);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i10) {
                    long j10;
                    long j11;
                    AdTemplate adTemplate = i.this.acn.getAdTemplate();
                    if (adTemplate != null) {
                        j10 = com.kwad.sdk.core.response.b.e.eb(adTemplate).totalBytes;
                        j11 = com.kwad.sdk.core.response.b.e.eb(adTemplate).soFarBytes;
                    } else {
                        j10 = 0;
                        j11 = 0;
                    }
                    iVar.onProgressUpdate(i10, j10, j11);
                }
            });
        }

        @Override // com.kwad.sdk.components.j
        public final void cancelDownload() {
            com.kwad.sdk.core.download.a.dJ(com.kwad.sdk.core.response.b.e.ee(adTemplate));
        }

        @Override // com.kwad.sdk.components.j
        public final void installApp() {
            cVar.oU();
        }

        @Override // com.kwad.sdk.components.j
        public final void openApp() {
            cVar.oS();
        }

        @Override // com.kwad.sdk.components.j
        public final void pauseDownload() {
            cVar.oW();
        }

        @Override // com.kwad.sdk.components.j
        public final void resumeDownload() {
            cVar.oX();
        }

        @Override // com.kwad.sdk.components.j
        public final void setCustomReportParam(String str) {
            try {
                cVar.d(new JSONObject(str));
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTrace(th2);
            }
        }

        @Override // com.kwad.sdk.components.j
        public final void startDownload() {
            cVar.oV();
        }

        @Override // com.kwad.sdk.components.j
        public final void stopDownload() {
            cVar.oW();
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$28 */
    public class AnonymousClass28 implements Runnable {
        public AnonymousClass28() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.d("TKLoadController", "已经超时" + i.this.abN.getTkTemplateId());
            i.this.tU();
            i.a(i.this, true);
            i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$3 */
    public class AnonymousClass3 extends bd {
        final /* synthetic */ TKRenderFailReason acv;

        public AnonymousClass3(TKRenderFailReason tKRenderFailReason) {
            tKRenderFailReason = tKRenderFailReason;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (i.this.acb) {
                return;
            }
            i.c(i.this, true);
            i.this.abN.a(tKRenderFailReason);
            com.kwad.components.core.e.e.g.pg().b(i.this);
            com.kwad.components.core.webview.tachikoma.d.b.uj().s(i.this.acl, i.this.acm);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$4 */
    public class AnonymousClass4 implements s.a {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.s.a
        public final void a(com.kwad.components.core.webview.tachikoma.b.s sVar) {
            if (TextUtils.isEmpty(sVar.message)) {
                return;
            }
            z.d(i.this.mContext, sVar.message, 0L);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$5 */
    public class AnonymousClass5 implements ad.b {
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ad.b
        public final void c(ad.a aVar) {
            i.this.abN.a(aVar);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$6 */
    public class AnonymousClass6 implements bc.a {
        public AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.jshandler.bc.a
        public final void aH(AdTemplate adTemplate) {
            try {
                i.this.acn.IB().remove(0);
                i.this.acn.IB().add(adTemplate);
                ArrayList arrayList = new ArrayList();
                arrayList.add(adTemplate);
                AdResultData adResultData = new AdResultData();
                adResultData.setAdTemplateList(arrayList);
                adResultData.llsid = adTemplate.llsid;
                i.this.mAdResultData = adResultData;
                if (i.this.abR != null) {
                    com.kwad.components.core.n.a.d.a.a.a(i.this.abR.getUniqId(), i.this.mAdResultData);
                }
                i.this.abU.setApkDownloadHelper(new com.kwad.components.core.e.d.c(adTemplate));
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTrace(th2);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$7 */
    public class AnonymousClass7 implements ak.b {
        public AnonymousClass7() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            i.this.b(aVar);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$8 */
    public class AnonymousClass8 implements ar.b {

        /* renamed from: com.kwad.components.core.webview.tachikoma.i$8$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                i.this.abN.ay();
            }
        }

        public AnonymousClass8() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
            if (aVar.status != 1) {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                i.this.aX(aVar.errorMsg);
            } else {
                if (i.this.abY) {
                    i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
                    return;
                }
                bt.c(i.this.act);
                i.this.tT();
                if (i.this.abN != null) {
                    bt.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.8.1
                        public AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            i.this.abN.ay();
                        }
                    });
                    com.kwad.components.core.webview.tachikoma.d.b.uj().c(i.this.abN.getTkTemplateId(), i.this.ace - i.this.GC, i.this.acf, i.this.acd > 0 ? SystemClock.elapsedRealtime() - i.this.acd : 0L);
                }
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$9 */
    public class AnonymousClass9 implements a.b {
        public AnonymousClass9() {
        }

        @Override // com.kwad.components.core.webview.jshandler.a.b
        public final void c(a.C0448a c0448a) {
            i.this.abN.a(c0448a);
        }
    }

    public interface a {
        void onFailed();

        void onSuccess();
    }

    public i(Context context) {
        this(context, true);
    }

    public com.kwad.sdk.components.j aI(AdTemplate adTemplate) {
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(adTemplate);
        cVar.oP();
        return new com.kwad.sdk.components.j() { // from class: com.kwad.components.core.webview.tachikoma.i.27
            final /* synthetic */ com.kwad.components.core.e.d.c acJ;
            final /* synthetic */ AdTemplate cP;

            /* renamed from: com.kwad.components.core.webview.tachikoma.i$27$1 */
            public class AnonymousClass1 extends com.kwad.sdk.core.download.a.a {
                final /* synthetic */ com.kwad.sdk.components.i acK;

                public AnonymousClass1(com.kwad.sdk.components.i iVar2) {
                    iVar = iVar2;
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    iVar.onDownloadFailed();
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    iVar.onDownloadFinished();
                }

                @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadStarted() {
                    iVar.onDownloadStarted();
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    iVar.onIdle();
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    iVar.onInstalled();
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i10) {
                    long j10;
                    long j11;
                    AdTemplate adTemplate = i.this.acn.getAdTemplate();
                    if (adTemplate != null) {
                        j10 = com.kwad.sdk.core.response.b.e.eb(adTemplate).totalBytes;
                        j11 = com.kwad.sdk.core.response.b.e.eb(adTemplate).soFarBytes;
                    } else {
                        j10 = 0;
                        j11 = 0;
                    }
                    iVar.onPaused(i10, j10, j11);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i10) {
                    long j10;
                    long j11;
                    AdTemplate adTemplate = i.this.acn.getAdTemplate();
                    if (adTemplate != null) {
                        j10 = com.kwad.sdk.core.response.b.e.eb(adTemplate).totalBytes;
                        j11 = com.kwad.sdk.core.response.b.e.eb(adTemplate).soFarBytes;
                    } else {
                        j10 = 0;
                        j11 = 0;
                    }
                    iVar.onProgressUpdate(i10, j10, j11);
                }
            }

            public AnonymousClass27(com.kwad.components.core.e.d.c cVar2, AdTemplate adTemplate2) {
                cVar = cVar2;
                adTemplate = adTemplate2;
            }

            @Override // com.kwad.sdk.components.j
            public final void a(com.kwad.sdk.components.i iVar2) {
                cVar.b(new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.tachikoma.i.27.1
                    final /* synthetic */ com.kwad.sdk.components.i acK;

                    public AnonymousClass1(com.kwad.sdk.components.i iVar22) {
                        iVar = iVar22;
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFailed() {
                        iVar.onDownloadFailed();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFinished() {
                        iVar.onDownloadFinished();
                    }

                    @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadStarted() {
                        iVar.onDownloadStarted();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onIdle() {
                        iVar.onIdle();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onInstalled() {
                        iVar.onInstalled();
                    }

                    @Override // com.kwad.sdk.core.download.a.a
                    public final void onPaused(int i10) {
                        long j10;
                        long j11;
                        AdTemplate adTemplate2 = i.this.acn.getAdTemplate();
                        if (adTemplate2 != null) {
                            j10 = com.kwad.sdk.core.response.b.e.eb(adTemplate2).totalBytes;
                            j11 = com.kwad.sdk.core.response.b.e.eb(adTemplate2).soFarBytes;
                        } else {
                            j10 = 0;
                            j11 = 0;
                        }
                        iVar.onPaused(i10, j10, j11);
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onProgressUpdate(int i10) {
                        long j10;
                        long j11;
                        AdTemplate adTemplate2 = i.this.acn.getAdTemplate();
                        if (adTemplate2 != null) {
                            j10 = com.kwad.sdk.core.response.b.e.eb(adTemplate2).totalBytes;
                            j11 = com.kwad.sdk.core.response.b.e.eb(adTemplate2).soFarBytes;
                        } else {
                            j10 = 0;
                            j11 = 0;
                        }
                        iVar.onProgressUpdate(i10, j10, j11);
                    }
                });
            }

            @Override // com.kwad.sdk.components.j
            public final void cancelDownload() {
                com.kwad.sdk.core.download.a.dJ(com.kwad.sdk.core.response.b.e.ee(adTemplate));
            }

            @Override // com.kwad.sdk.components.j
            public final void installApp() {
                cVar.oU();
            }

            @Override // com.kwad.sdk.components.j
            public final void openApp() {
                cVar.oS();
            }

            @Override // com.kwad.sdk.components.j
            public final void pauseDownload() {
                cVar.oW();
            }

            @Override // com.kwad.sdk.components.j
            public final void resumeDownload() {
                cVar.oX();
            }

            @Override // com.kwad.sdk.components.j
            public final void setCustomReportParam(String str) {
                try {
                    cVar.d(new JSONObject(str));
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                }
            }

            @Override // com.kwad.sdk.components.j
            public final void startDownload() {
                cVar.oV();
            }

            @Override // com.kwad.sdk.components.j
            public final void stopDownload() {
                cVar.oW();
            }
        };
    }

    public void aU(String str) {
        b(TKRenderFailReason.TK_FILE_LOAD_ERROR);
        aW(str);
    }

    private static StyleTemplate aV(String str) {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return null;
    }

    private void aW(String str) {
        f(this.abN.getTkTemplateId(), str);
        StyleTemplate tN = tN();
        if (tN == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.acc).setRenderState(4).setErrorReason(str).setTemplateId(this.abN.getTkTemplateId()).setVersionCode(String.valueOf(tN.templateVersionCode)).setTKPublishType(tQ()).toJson());
    }

    public void aX(String str) {
        com.kwad.sdk.core.d.c.d("TKLoadController", "logTkRenderFail : " + str + ", templateId = " + this.abN.getTkTemplateId());
        g(this.abN.getTkTemplateId(), str);
        if (!this.abZ || this.aca) {
            return;
        }
        this.aca = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.acc).setRenderState(2).setErrorReason(str).setTemplateId(this.abN.getTkTemplateId()).setVersionCode(String.valueOf(this.Vh.templateVersionCode)).setTKPublishType(tQ()).toJson());
    }

    private static boolean isLocalDebugEnable() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return false;
    }

    private void tK() {
        this.abZ = false;
        this.aca = false;
        this.abX = false;
        this.abY = false;
        this.acb = false;
        this.GC = 0L;
        this.ace = 0L;
        this.acf = 0L;
        this.acd = 0L;
    }

    private void tL() {
        if (isLocalDebugEnable()) {
            this.aci = 2000;
            this.acj = 3000;
        }
        bt.runOnUiThreadDelay(this.acs, this.aci);
        int i10 = this.acj;
        if (i10 > 0) {
            bt.runOnUiThreadDelay(this.act, i10);
        }
        this.abQ = GlobalThreadPools.Hp().submit(new bd() { // from class: com.kwad.components.core.webview.tachikoma.i.12

            /* renamed from: com.kwad.components.core.webview.tachikoma.i$12$1 */
            public class AnonymousClass1 implements TKDownloadListener {
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                public final void onFailed(String str) {
                    i.this.aU(str);
                }

                @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                public final void onSuccess(@NonNull StyleTemplate styleTemplate) {
                    i.this.b(styleTemplate);
                }
            }

            public AnonymousClass12() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                i.this.GC = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.d.c.d("TKLoadController", "开始读取模板 id: " + i.this.abN.getTkTemplateId());
                i.this.a(new TKDownloadListener() { // from class: com.kwad.components.core.webview.tachikoma.i.12.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onFailed(String str) {
                        i.this.aU(str);
                    }

                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onSuccess(@NonNull StyleTemplate styleTemplate) {
                        i.this.b(styleTemplate);
                    }
                });
            }
        });
    }

    private static boolean tM() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return false;
    }

    private StyleTemplate tN() {
        AdMatrixInfo.MatrixTemplate k10;
        String tkTemplateId = this.abN.getTkTemplateId();
        StyleTemplate styleTemplate = this.Vh;
        if (styleTemplate != null) {
            tkTemplateId = styleTemplate.templateId;
        }
        StyleTemplate aV = aV(tkTemplateId);
        if (aV != null) {
            return aV;
        }
        if (!isLocalDebugEnable()) {
            StyleTemplate styleTemplate2 = this.Vh;
            if (styleTemplate2 != null) {
                return styleTemplate2;
            }
            AdTemplate tP = tP();
            if (tP == null || (k10 = com.kwad.sdk.core.response.b.b.k(tP, this.abN.getTkTemplateId())) == null) {
                return null;
            }
            com.kwad.components.core.n.a.d.c cVar = this.abP;
            if (cVar != null) {
                return cVar.checkStyleTemplateById(this.mContext, k10.templateId, k10.templateMd5, k10.templateUrl, (int) k10.templateVersionCode);
            }
            StyleTemplate styleTemplate3 = new StyleTemplate();
            styleTemplate3.templateId = k10.templateId;
            styleTemplate3.templateMd5 = k10.templateMd5;
            styleTemplate3.templateUrl = k10.templateUrl;
            styleTemplate3.templateVersionCode = (int) k10.templateVersionCode;
            styleTemplate3.tkSouce = 0;
            return styleTemplate3;
        }
        StyleTemplate styleTemplate4 = new StyleTemplate();
        styleTemplate4.templateId = tkTemplateId;
        styleTemplate4.templateVersion = "1.0.4";
        styleTemplate4.templateVersionCode = 104;
        if (tM()) {
            styleTemplate4.templateUrl = "http://" + OfflineHostProvider.getApi().env().localIpAddress() + ":24680/" + tkTemplateId + ".104.coverage.zip";
        } else {
            styleTemplate4.templateUrl = "http://" + OfflineHostProvider.getApi().env().localIpAddress() + ":24680/" + tkTemplateId + ".104.zip";
        }
        return styleTemplate4;
    }

    private void tO() {
        this.acn.a(!an.NS() ? 1 : 0, this.abN.getTouchCoordsView(), this.abN.getTKContainer(), this.abN.getTkTemplateId());
    }

    private int tQ() {
        String tkTemplateId = this.abN.getTkTemplateId();
        int i10 = tN() != null ? tN().templateVersionCode : 0;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(tkTemplateId);
        stringBuffer.append("#");
        stringBuffer.append(i10);
        return com.kwad.sdk.core.config.d.cd(stringBuffer.toString());
    }

    private void tR() {
        StyleTemplate tN = tN();
        if (tN == null) {
            return;
        }
        this.acc = tN.tkSouce;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.acc).setRenderState(-1).setTemplateId(this.abN.getTkTemplateId()).setVersionCode(String.valueOf(tN.templateVersionCode)).setTKPublishType(tQ()).toJson());
    }

    private void tS() {
        this.abZ = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.acc).setRenderState(0).setTemplateId(this.abN.getTkTemplateId()).setVersionCode(String.valueOf(this.Vh.templateVersionCode)).setTKPublishType(tQ()).toJson());
    }

    public void tT() {
        StringBuilder sb2 = new StringBuilder("logTkRenderSuccess, templateId = ");
        sb2.append(this.abN.getTkTemplateId());
        sb2.append(":");
        StyleTemplate styleTemplate = this.Vh;
        sb2.append(styleTemplate != null ? styleTemplate.templateVersionCode : 0);
        com.kwad.sdk.core.d.c.d("TKLoadController", sb2.toString());
        if (!this.abZ || this.aca) {
            return;
        }
        this.aca = true;
        long elapsedRealtime = this.acd > 0 ? SystemClock.elapsedRealtime() - this.acd : 0L;
        com.kwad.sdk.core.d.c.d("TKLoadController", "render time, templateId = " + this.abN.getTkTemplateId() + " init:" + this.acf + " load:" + (this.ace - this.GC) + " render:" + elapsedRealtime);
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.acc).setRenderState(1).setRenderTime(elapsedRealtime).setTemplateId(this.abN.getTkTemplateId()).setLoadTime(this.ace - this.GC).setInitTime(this.acf).setVersionCode(String.valueOf(this.Vh.templateVersionCode)).setTKPublishType(tQ()).toJson());
    }

    public void tU() {
        com.kwad.sdk.core.d.c.d("TKLoadController", "logTkRenderFail : timeout, templateId = " + this.abN.getTkTemplateId());
        StyleTemplate tN = tN();
        if (tN == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.acc).setRenderState(3).setErrorReason("timeout").setTemplateId(this.abN.getTkTemplateId()).setVersionCode(String.valueOf(tN.templateVersionCode)).setTKPublishType(tQ()).toJson());
    }

    private Map<String, Object> tV() {
        if (this.acg == null) {
            HashMap hashMap = new HashMap();
            this.acg = hashMap;
            hashMap.put("TKVersion", "6.1.2");
            this.acg.put("SDKVersion", BuildConfig.VERSION_NAME);
            this.acg.put("sdkType", 1);
        }
        return this.acg;
    }

    private void tW() {
        if (this.abP == null || this.abR == null) {
            return;
        }
        File file = new File(new File(this.abP.getJsBaseDir(this.mContext, this.abN.getTkTemplateId())), "kcov.json");
        if (file.exists()) {
            try {
                String W = u.W(file);
                if (TextUtils.isEmpty(W)) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("TKLoadController", "kcov.json:" + W);
                JSONObject jSONObject = new JSONObject(W);
                String string = jSONObject.getString("gitHeadCommit");
                String string2 = jSONObject.getString("coverageApi");
                String string3 = jSONObject.getString("coverageTaskId");
                String string4 = jSONObject.getString("currentBranch");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    StringBuilder sb2 = new StringBuilder("尝试获取覆盖率统计... ");
                    sb2.append(this.Vh);
                    com.kwad.sdk.core.d.c.d("TKLoadController", sb2.toString() != null ? this.Vh.templateId : "");
                    Object execute = this.abR.execute("JSON.stringify(this.__coverage__)");
                    if (execute instanceof String) {
                        com.kwad.sdk.utils.h.execute(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.21
                            final /* synthetic */ String acA;
                            final /* synthetic */ String acB;
                            final /* synthetic */ String acC;
                            final /* synthetic */ String acD;
                            final /* synthetic */ String acz;

                            /* renamed from: com.kwad.components.core.webview.tachikoma.i$21$1 */
                            public class AnonymousClass1 implements AdHttpBodyBuilder {
                                public AnonymousClass1() {
                                }

                                @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
                                public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                                    adHttpFormDataBuilder.addFormDataPart(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID, string3);
                                    adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                                    adHttpFormDataBuilder.addFormDataPart("os_build_serial", "unknown");
                                    adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                                    adHttpFormDataBuilder.addFormDataPart("app_version", BuildConfig.VERSION_NAME);
                                    adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                                    adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                                    adHttpFormDataBuilder.addFormDataPart("uid", "");
                                    adHttpFormDataBuilder.addFormDataPart("did", ba.getDeviceId());
                                    adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                                    adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                                    try {
                                        adHttpFormDataBuilder.addFormDataPart(com.sigmob.sdk.base.k.f18193y, UUID.randomUUID().toString() + ".json", "application/octet-stream", str.getBytes("UTF-8"));
                                    } catch (UnsupportedEncodingException e102) {
                                        com.kwad.sdk.core.d.c.printStackTrace(e102);
                                    }
                                }
                            }

                            public AnonymousClass21(String string32, String string42, String string22, String string5, String str5) {
                                string3 = string32;
                                string4 = string42;
                                string2 = string22;
                                string = string5;
                                str = str5;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("coverage_task_id", Integer.valueOf(string3));
                                    jSONObject2.put(com.umeng.analytics.pro.bd.f23533m, "");
                                    jSONObject2.put(o3.a.f29032k, System.currentTimeMillis() / 1000);
                                    jSONObject2.put("branch_name", string4);
                                    jSONObject2.put("version", BuildConfig.VERSION_NAME);
                                    jSONObject2.put("tk_version", String.valueOf(i.this.Vh.templateVersionCode));
                                    jSONObject2.put("tk_template_ids", i.this.Vh.templateId);
                                } catch (JSONException e10) {
                                    com.kwad.sdk.core.d.c.printStackTrace(e10);
                                }
                                com.kwad.sdk.core.network.c doPost = com.kwad.sdk.g.zc().doPost(string2 + "/analysis/add/pkg/info", (Map<String, String>) null, jSONObject2);
                                if (doPost.Fr()) {
                                    com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率pkg完成:" + doPost.azu);
                                } else {
                                    com.kwad.sdk.core.d.c.d("TKLoadController", "上传覆盖率pkg失败");
                                }
                                com.kwad.sdk.core.network.c doPost2 = com.kwad.sdk.g.zc().doPost(string2 + "/attachment/ec", (Map<String, String>) null, new AdHttpBodyBuilder() { // from class: com.kwad.components.core.webview.tachikoma.i.21.1
                                    public AnonymousClass1() {
                                    }

                                    @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
                                    public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                                        adHttpFormDataBuilder.addFormDataPart(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID, string3);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_serial", "unknown");
                                        adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                                        adHttpFormDataBuilder.addFormDataPart("app_version", BuildConfig.VERSION_NAME);
                                        adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                                        adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                                        adHttpFormDataBuilder.addFormDataPart("uid", "");
                                        adHttpFormDataBuilder.addFormDataPart("did", ba.getDeviceId());
                                        adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                                        adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                                        try {
                                            adHttpFormDataBuilder.addFormDataPart(com.sigmob.sdk.base.k.f18193y, UUID.randomUUID().toString() + ".json", "application/octet-stream", str.getBytes("UTF-8"));
                                        } catch (UnsupportedEncodingException e102) {
                                            com.kwad.sdk.core.d.c.printStackTrace(e102);
                                        }
                                    }
                                });
                                if (!doPost2.Fr()) {
                                    com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率失败");
                                    return;
                                }
                                com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率完成:" + doPost2.azu);
                            }
                        });
                        return;
                    }
                    return;
                }
                com.kwad.sdk.core.d.c.d("TKLoadController", "kcov.json数据不合法，缺少关键字段gitHeadCommit | coverageApi | coverageTaskId | currentBranch");
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            }
        }
    }

    public void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.components.s sVar, ViewGroup viewGroup) {
    }

    @Override // com.kwad.sdk.components.p
    public final void callJS(String str) {
        com.kwad.sdk.components.s sVar = this.abR;
        if (sVar != null) {
            sVar.a(str, null, null);
        }
    }

    @Override // com.kwad.components.core.e.e.f
    public void dismiss() {
        ay ayVar = this.f11958ed;
        if (ayVar != null) {
            ayVar.ty();
        }
    }

    public void f(String str, String str2) {
    }

    public void g(String str, String str2) {
    }

    public final String getTkTemplateId() {
        j jVar = this.abN;
        if (jVar == null) {
            return null;
        }
        return jVar.getTkTemplateId();
    }

    public void jK() {
        com.kwad.sdk.core.view.d dVar = this.abV;
        if (dVar != null) {
            dVar.getWindowFocusChangeHelper().b(this);
            this.abV = null;
        }
        Future<?> future = this.abQ;
        if (future != null) {
            future.cancel(true);
        }
        bt.c(this.acs);
        bt.c(this.act);
        com.kwad.components.core.e.e.g.pg().b(this);
        if (this.Yl != null) {
            com.kwad.sdk.core.download.b.EI().a(this.Yl);
        }
        com.kwad.components.core.webview.tachikoma.c.e eVar = this.abM;
        if (eVar != null) {
            eVar.dismiss();
        }
        if (com.kwad.components.core.a.ns.booleanValue()) {
            tW();
        }
        com.kwad.components.core.n.a.d.c cVar = this.abP;
        if (cVar != null) {
            cVar.onDestroy();
        }
        com.kwad.sdk.components.s sVar = this.abR;
        if (sVar != null) {
            this.abR = null;
            bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.20
                final /* synthetic */ com.kwad.sdk.components.s acy;

                public AnonymousClass20(com.kwad.sdk.components.s sVar2) {
                    sVar = sVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.components.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.onDestroy();
                    }
                }
            });
        }
    }

    public boolean nY() {
        return false;
    }

    @Override // com.kwad.components.core.e.e.f
    public void show() {
        ay ayVar = this.f11958ed;
        if (ayVar != null) {
            ayVar.tz();
        }
    }

    public final com.kwad.sdk.core.webview.b tJ() {
        return this.acn;
    }

    public final AdTemplate tP() {
        return this.acn.getAdTemplate();
    }

    public i(Context context, boolean z10) {
        this.abX = false;
        this.abY = false;
        this.abZ = false;
        this.aca = false;
        this.acb = false;
        this.acc = 0;
        this.yV = -1L;
        this.aci = 1000;
        this.acj = 0;
        this.ack = true;
        this.acn = new com.kwad.sdk.core.webview.e();
        this.aco = new KsAdWebView.b() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (i.this.Yk != null) {
                    i.this.Yk.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (i.this.Yk != null) {
                    i.this.Yk.onSuccess();
                }
            }
        };
        this.acp = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            public AnonymousClass23() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.acq = new q() { // from class: com.kwad.components.core.webview.tachikoma.i.25

            /* renamed from: com.kwad.components.core.webview.tachikoma.i$25$1 */
            public class AnonymousClass1 extends k {
                final /* synthetic */ String acH;

                public AnonymousClass1(String str) {
                    viewKey = str;
                }

                @Override // com.kwad.components.core.webview.tachikoma.k
                public final com.kwad.sdk.components.n a(Object... objArr) {
                    if (i.this.abR != null) {
                        return i.this.abR.bd(viewKey);
                    }
                    return null;
                }
            }

            /* renamed from: com.kwad.components.core.webview.tachikoma.i$25$2 */
            public class AnonymousClass2 extends k {
                final /* synthetic */ String acH;

                public AnonymousClass2(String str) {
                    r2 = str;
                }

                @Override // com.kwad.components.core.webview.tachikoma.k
                public final com.kwad.sdk.components.n a(Object... objArr) {
                    if (i.this.abR != null) {
                        return i.this.abR.bd(r2);
                    }
                    return null;
                }
            }

            public AnonymousClass25() {
            }

            @Override // com.kwad.sdk.components.q
            public final void a(com.kwad.sdk.components.l lVar) {
                StyleTemplate styleTemplate;
                Activity activity = i.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.c.b.Fi();
                    activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activity == null || activity.isFinishing()) {
                    lVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                String viewKey = lVar.getViewKey();
                if (viewKey == null) {
                    styleTemplate = new StyleTemplate();
                    try {
                        styleTemplate.parseJson(styleTemplate, new JSONObject(lVar.getStyleTemplate()));
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.d.c.printStackTrace(th2);
                        lVar.callbackPageStatus(false, "template parse failed");
                        return;
                    }
                } else {
                    styleTemplate = null;
                }
                e.b bVar = new e.b();
                bVar.a(i.this.mAdResultData);
                bVar.c(lVar);
                if (styleTemplate != null) {
                    bVar.a(styleTemplate);
                }
                if (viewKey != null) {
                    bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.25.1
                        final /* synthetic */ String acH;

                        public AnonymousClass1(String viewKey2) {
                            viewKey = viewKey2;
                        }

                        @Override // com.kwad.components.core.webview.tachikoma.k
                        public final com.kwad.sdk.components.n a(Object... objArr) {
                            if (i.this.abR != null) {
                                return i.this.abR.bd(viewKey);
                            }
                            return null;
                        }
                    });
                }
                com.kwad.components.core.webview.tachikoma.c.e b10 = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                b10.show(activity.getFragmentManager(), "");
                i.ach.put(Integer.valueOf(lVar.getDialogId()), new WeakReference(b10));
            }

            @Override // com.kwad.sdk.components.q
            public final void b(com.kwad.sdk.components.l lVar) {
                WeakReference weakReference = (WeakReference) i.ach.get(Integer.valueOf(lVar.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.c.e) weakReference.get()).dismiss();
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
            
                if (r0 != com.kwad.sdk.core.c.b.getCurrentActivity()) goto L96;
             */
            @Override // com.kwad.sdk.components.q
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void a(com.kwad.sdk.components.m r8) {
                /*
                    r7 = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.i.c(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.c.b.Fi()
                    android.app.Activity r1 = com.kwad.sdk.core.c.b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.c.b.Fi()
                    android.app.Activity r0 = com.kwad.sdk.core.c.b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.String r3 = r8.getTemplateString()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r4 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    if (r3 == 0) goto L62
                    java.lang.String r3 = r8.getViewKey()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r3 = r8.getClassName()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lb9
                    java.lang.String r3 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.b.a(r4, r3)
                    com.kwad.components.core.webview.tachikoma.i r3 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r3 = r3.mContext
                    r2.setClass(r3, r4)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.r.a.a> r3 = com.kwad.components.core.r.a.a.class
                    com.kwad.sdk.service.b.a(r4, r3)
                    int r3 = com.kwad.components.core.r.a.a.rT()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.r.a.a.a(r3, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.i.d(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.c.f.nt()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.i.d(r6)
                    int r5 = r5.j(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = "tk_style_template"
                    java.lang.String r6 = r8.getTemplateString()
                    r2.putExtra(r5, r6)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$25$2 r6 = new com.kwad.components.core.webview.tachikoma.i$25$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.r.a.a.a(r3, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r3)
                    com.kwad.components.core.webview.tachikoma.i r3 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r3 = r3.mContext
                    r2.setClass(r3, r4)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Le5
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                    java.lang.String r3 = "adCacheId"
                    int r3 = r2.getIntExtra(r3, r1)
                    if (r3 <= 0) goto Le5
                    com.kwad.sdk.core.response.model.AdResultData r3 = com.kwad.components.core.n.a.d.a.a.au(r3)
                    com.kwad.sdk.core.response.model.AdTemplate r3 = com.kwad.sdk.core.response.b.c.o(r3)
                    com.kwad.components.core.proxy.launchdialog.d r4 = com.kwad.components.core.proxy.launchdialog.d.rg()
                    r4.ay(r3)
                Le5:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Lee
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Lee
                    return
                Lee:
                    r0 = move-exception
                    com.kwad.sdk.core.d.c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass25.a(com.kwad.sdk.components.m):void");
            }
        };
        this.acr = new com.kwad.sdk.components.k() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            public AnonymousClass26() {
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j aT(int i10) {
                return i.this.aI(com.kwad.sdk.core.response.b.c.o(com.kwad.components.core.n.a.d.a.a.au(i10)));
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j aY(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aI(adTemplate);
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                    return null;
                }
            }
        };
        this.acs = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.28
            public AnonymousClass28() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "已经超时" + i.this.abN.getTkTemplateId());
                i.this.tU();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.act = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.2
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.f11959ia = new l() { // from class: com.kwad.components.core.webview.tachikoma.i.19
            public AnonymousClass19() {
            }

            private void g(double d10) {
                i.this.xS.adC = false;
                i.this.xS.Tz = false;
                i.this.xS.oZ = (int) ((d10 / 1000.0d) + 0.5d);
                jp();
            }

            private void jp() {
                if (i.this.abS == null || i.this.xS == null) {
                    return;
                }
                i.this.abS.a(i.this.xS);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                i.this.xS.Tz = true;
                i.this.xS.adC = false;
                i.this.xS.oZ = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.eb(i.this.tP()));
                jp();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                i.this.xS.adC = true;
                i.this.xS.Tz = false;
                jp();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j10, long j11) {
                g(j11);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                g(l5.c.f27899e);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                g(l5.c.f27899e);
            }
        };
        this.mContext = context;
        this.yV = -1L;
        this.aci = 1000;
        this.ack = z10;
        this.xS = new y();
    }

    public static /* synthetic */ boolean c(i iVar, boolean z10) {
        iVar.acb = true;
        return true;
    }

    @Override // com.kwad.sdk.core.view.b
    public final void i(View view, boolean z10) {
        ax axVar;
        FrameLayout tKContainer = this.abN.getTKContainer();
        if (tKContainer == null || !tKContainer.equals(view) || (axVar = this.abT) == null) {
            return;
        }
        axVar.aV(z10);
    }

    public static /* synthetic */ boolean b(i iVar, boolean z10) {
        iVar.abY = true;
        return true;
    }

    private void c(StyleTemplate styleTemplate) {
        if (com.kwad.components.core.a.ns.booleanValue() && this.abN.getTKContainer() != null) {
            if (this.abW == null) {
                TextView textView = new TextView(this.mContext);
                this.abW = textView;
                textView.setTextSize(12.0f);
                this.abW.setTextColor(SupportMenu.CATEGORY_MASK);
                this.abN.getTKContainer().addView(this.abW);
            }
            this.abW.setText(styleTemplate.templateId + " " + styleTemplate.templateVersionCode);
            this.abW.setVisibility(0);
        }
    }

    public void f(Throwable th2) {
        com.kwad.sdk.core.d.c.d("TKLoadController", "logTkRenderFail : " + th2 + ", templateId = " + this.abN.getTkTemplateId());
        String tkTemplateId = this.abN.getTkTemplateId();
        StringBuilder sb2 = new StringBuilder("error:");
        sb2.append(th2.toString());
        g(tkTemplateId, sb2.toString());
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.acc).setRenderState(3).setErrorReason(th2.toString()).setTemplateId(this.abN.getTkTemplateId()).setVersionCode(String.valueOf(this.Vh.templateVersionCode)).setTKPublishType(tQ()).toJson());
    }

    public void b(StyleTemplate styleTemplate) {
        com.kwad.sdk.utils.j.b("", "renderType_tk", styleTemplate.templateId, styleTemplate.templateUrl);
        com.kwad.sdk.core.d.c.d("TKLoadController", "读取完毕，总耗时" + (SystemClock.elapsedRealtime() - this.GC) + ", 读取成功" + styleTemplate.templateId);
        if (this.abX) {
            return;
        }
        com.kwad.sdk.core.d.c.d("TKLoadController", "没有超时");
        bt.c(this.acs);
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            final /* synthetic */ StyleTemplate acF;

            public AnonymousClass22(StyleTemplate styleTemplate2) {
                styleTemplate = styleTemplate2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                i iVar = i.this;
                iVar.a(styleTemplate, iVar.acp);
            }
        });
        ViewParent tKContainer = this.abN.getTKContainer();
        if (tKContainer instanceof com.kwad.sdk.core.view.d) {
            com.kwad.sdk.core.view.d dVar = (com.kwad.sdk.core.view.d) tKContainer;
            this.abV = dVar;
            dVar.getWindowFocusChangeHelper().a(this);
        }
    }

    public al c(com.kwad.sdk.core.webview.b bVar) {
        return new al(bVar);
    }

    public void b(TKRenderFailReason tKRenderFailReason) {
        bt.postOnUiThread(new bd() { // from class: com.kwad.components.core.webview.tachikoma.i.3
            final /* synthetic */ TKRenderFailReason acv;

            public AnonymousClass3(TKRenderFailReason tKRenderFailReason2) {
                tKRenderFailReason = tKRenderFailReason2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (i.this.acb) {
                    return;
                }
                i.c(i.this, true);
                i.this.abN.a(tKRenderFailReason);
                com.kwad.components.core.e.e.g.pg().b(i.this);
                com.kwad.components.core.webview.tachikoma.d.b.uj().s(i.this.acl, i.this.acm);
            }
        });
    }

    public static /* synthetic */ boolean a(i iVar, boolean z10) {
        iVar.abX = true;
        return true;
    }

    public void b(ak.a aVar) {
        FrameLayout tKContainer = this.abN.getTKContainer();
        if (tKContainer != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tKContainer.getLayoutParams();
            layoutParams.height = com.kwad.sdk.c.a.a.a(this.mContext, aVar.height);
            layoutParams.leftMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.leftMargin);
            layoutParams.rightMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.rightMargin);
            layoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.bottomMargin);
            layoutParams.width = -1;
            tKContainer.setLayoutParams(layoutParams);
        }
    }

    public final void a(StyleTemplate styleTemplate) {
        this.Vh = styleTemplate;
    }

    public void a(@Nullable Activity activity, AdResultData adResultData, j jVar) {
        this.mActivity = activity;
        this.mAdResultData = adResultData;
        this.acn.a(adResultData);
        this.abN = jVar;
        this.acl = jVar.getTkTemplateId();
        this.acm = this.abN.getTKReaderScene();
        tK();
        FrameLayout tKContainer = this.abN.getTKContainer();
        if (tKContainer != null) {
            tKContainer.removeAllViews();
        }
        if (!com.kwad.sdk.core.config.d.Du()) {
            b(TKRenderFailReason.SWITCH_CLOSE);
            return;
        }
        this.abP = (com.kwad.components.core.n.a.d.c) com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.d.c.class);
        tR();
        com.kwad.sdk.core.d.c.d("TKLoadController", "bind mTKPlugin: " + this.abP);
        if (TextUtils.isEmpty(this.acl)) {
            com.kwad.sdk.commercial.e.a.e(tP(), this.acm);
        }
        if (this.abP != null) {
            tL();
            return;
        }
        b(TKRenderFailReason.PLUGIN_NOT_READY);
        f(this.acl, TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED);
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.acc).setRenderState(4).setErrorReason(TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED).setTemplateId(this.acl).toJson());
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.i$25 */
    public class AnonymousClass25 implements q {

        /* renamed from: com.kwad.components.core.webview.tachikoma.i$25$1 */
        public class AnonymousClass1 extends k {
            final /* synthetic */ String acH;

            public AnonymousClass1(String viewKey2) {
                viewKey = viewKey2;
            }

            @Override // com.kwad.components.core.webview.tachikoma.k
            public final com.kwad.sdk.components.n a(Object... objArr) {
                if (i.this.abR != null) {
                    return i.this.abR.bd(viewKey);
                }
                return null;
            }
        }

        /* renamed from: com.kwad.components.core.webview.tachikoma.i$25$2 */
        public class AnonymousClass2 extends k {
            final /* synthetic */ String acH;

            public AnonymousClass2(String str) {
                r2 = str;
            }

            @Override // com.kwad.components.core.webview.tachikoma.k
            public final com.kwad.sdk.components.n a(Object... objArr) {
                if (i.this.abR != null) {
                    return i.this.abR.bd(r2);
                }
                return null;
            }
        }

        public AnonymousClass25() {
        }

        @Override // com.kwad.sdk.components.q
        public final void a(com.kwad.sdk.components.l lVar) {
            StyleTemplate styleTemplate;
            Activity activity = i.this.mActivity;
            if (activity == null) {
                com.kwad.sdk.core.c.b.Fi();
                activity = com.kwad.sdk.core.c.b.getCurrentActivity();
            }
            if (activity == null || activity.isFinishing()) {
                lVar.callbackPageStatus(false, "no host activity");
                return;
            }
            String viewKey2 = lVar.getViewKey();
            if (viewKey2 == null) {
                styleTemplate = new StyleTemplate();
                try {
                    styleTemplate.parseJson(styleTemplate, new JSONObject(lVar.getStyleTemplate()));
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                    lVar.callbackPageStatus(false, "template parse failed");
                    return;
                }
            } else {
                styleTemplate = null;
            }
            e.b bVar = new e.b();
            bVar.a(i.this.mAdResultData);
            bVar.c(lVar);
            if (styleTemplate != null) {
                bVar.a(styleTemplate);
            }
            if (viewKey2 != null) {
                bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.25.1
                    final /* synthetic */ String acH;

                    public AnonymousClass1(String viewKey22) {
                        viewKey = viewKey22;
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.k
                    public final com.kwad.sdk.components.n a(Object... objArr) {
                        if (i.this.abR != null) {
                            return i.this.abR.bd(viewKey);
                        }
                        return null;
                    }
                });
            }
            com.kwad.components.core.webview.tachikoma.c.e b10 = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
            b10.show(activity.getFragmentManager(), "");
            i.ach.put(Integer.valueOf(lVar.getDialogId()), new WeakReference(b10));
        }

        @Override // com.kwad.sdk.components.q
        public final void b(com.kwad.sdk.components.l lVar) {
            WeakReference weakReference = (WeakReference) i.ach.get(Integer.valueOf(lVar.getDialogId()));
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            ((com.kwad.components.core.webview.tachikoma.c.e) weakReference.get()).dismiss();
        }

        @Override // com.kwad.sdk.components.q
        public final void a(com.kwad.sdk.components.m mVar) {
            /*
                this = this;
                com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.i.this
                android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.i.c(r0)
                if (r0 == 0) goto L11
                com.kwad.sdk.core.c.b.Fi()
                android.app.Activity r1 = com.kwad.sdk.core.c.b.getCurrentActivity()
                if (r0 == r1) goto L18
            L11:
                com.kwad.sdk.core.c.b.Fi()
                android.app.Activity r0 = com.kwad.sdk.core.c.b.getCurrentActivity()
            L18:
                r1 = 0
                if (r0 != 0) goto L21
                java.lang.String r0 = "no host activity"
                r8.callbackPageStatus(r1, r0)
                return
            L21:
                android.content.Intent r2 = r8.getIntent()
                java.lang.String r3 = r8.getTemplateString()
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r4 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                if (r3 == 0) goto L62
                java.lang.String r3 = r8.getViewKey()
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto L3c
                goto L62
            L3c:
                java.lang.String r3 = r8.getClassName()
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto Lb9
                java.lang.String r3 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L59
                com.kwad.sdk.service.b.a(r4, r3)
                com.kwad.components.core.webview.tachikoma.i r3 = com.kwad.components.core.webview.tachikoma.i.this
                android.content.Context r3 = r3.mContext
                r2.setClass(r3, r4)
                goto Lb9
            L59:
                r0 = move-exception
                java.lang.String r0 = r0.getMessage()
                r8.callbackPageStatus(r1, r0)
                return
            L62:
                java.lang.Class<com.kwad.components.core.r.a.a> r3 = com.kwad.components.core.r.a.a.class
                com.kwad.sdk.service.b.a(r4, r3)
                int r3 = com.kwad.components.core.r.a.a.rT()
                java.lang.String r5 = "native_intent"
                com.kwad.components.core.r.a.a.a(r3, r5, r8)
                com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.i.this
                com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.i.d(r5)
                if (r5 == 0) goto L8b
                com.kwad.components.core.c.f r5 = com.kwad.components.core.c.f.nt()
                com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.i.this
                com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.i.d(r6)
                int r5 = r5.j(r6)
                java.lang.String r6 = "ad_result_cache_idx"
                r2.putExtra(r6, r5)
            L8b:
                java.lang.String r5 = r8.getTemplateString()
                boolean r5 = android.text.TextUtils.isEmpty(r5)
                if (r5 != 0) goto L9f
                java.lang.String r5 = "tk_style_template"
                java.lang.String r6 = r8.getTemplateString()
                r2.putExtra(r5, r6)
                goto Lad
            L9f:
                java.lang.String r5 = r8.getViewKey()
                com.kwad.components.core.webview.tachikoma.i$25$2 r6 = new com.kwad.components.core.webview.tachikoma.i$25$2
                r6.<init>()
                java.lang.String r5 = "tk_view_holder"
                com.kwad.components.core.r.a.a.a(r3, r5, r6)
            Lad:
                java.lang.String r5 = "tk_id"
                r2.putExtra(r5, r3)
                com.kwad.components.core.webview.tachikoma.i r3 = com.kwad.components.core.webview.tachikoma.i.this
                android.content.Context r3 = r3.mContext
                r2.setClass(r3, r4)
            Lb9:
                java.lang.String r3 = r8.getUrl()
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto Le5
                java.lang.String r3 = r8.getUrl()
                android.net.Uri r3 = android.net.Uri.parse(r3)
                r2.setData(r3)
                java.lang.String r3 = "adCacheId"
                int r3 = r2.getIntExtra(r3, r1)
                if (r3 <= 0) goto Le5
                com.kwad.sdk.core.response.model.AdResultData r3 = com.kwad.components.core.n.a.d.a.a.au(r3)
                com.kwad.sdk.core.response.model.AdTemplate r3 = com.kwad.sdk.core.response.b.c.o(r3)
                com.kwad.components.core.proxy.launchdialog.d r4 = com.kwad.components.core.proxy.launchdialog.d.rg()
                r4.ay(r3)
            Le5:
                r0.startActivity(r2)     // Catch: java.lang.Throwable -> Lee
                r0 = 1
                r2 = 0
                r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Lee
                return
            Lee:
                r0 = move-exception
                com.kwad.sdk.core.d.c.printStackTraceOnly(r0)
                java.lang.String r0 = r0.getMessage()
                r8.callbackPageStatus(r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass25.a(com.kwad.sdk.components.m):void");
        }
    }

    public i(long j10, Context context) {
        this.abX = false;
        this.abY = false;
        this.abZ = false;
        this.aca = false;
        this.acb = false;
        this.acc = 0;
        this.yV = -1L;
        this.aci = 1000;
        this.acj = 0;
        this.ack = true;
        this.acn = new com.kwad.sdk.core.webview.e();
        this.aco = new KsAdWebView.b() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (i.this.Yk != null) {
                    i.this.Yk.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (i.this.Yk != null) {
                    i.this.Yk.onSuccess();
                }
            }
        };
        this.acp = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            public AnonymousClass23() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.acq = new q() { // from class: com.kwad.components.core.webview.tachikoma.i.25

            /* renamed from: com.kwad.components.core.webview.tachikoma.i$25$1 */
            public class AnonymousClass1 extends k {
                final /* synthetic */ String acH;

                public AnonymousClass1(String viewKey22) {
                    viewKey = viewKey22;
                }

                @Override // com.kwad.components.core.webview.tachikoma.k
                public final com.kwad.sdk.components.n a(Object... objArr) {
                    if (i.this.abR != null) {
                        return i.this.abR.bd(viewKey);
                    }
                    return null;
                }
            }

            /* renamed from: com.kwad.components.core.webview.tachikoma.i$25$2 */
            public class AnonymousClass2 extends k {
                final /* synthetic */ String acH;

                public AnonymousClass2(String str) {
                    r2 = str;
                }

                @Override // com.kwad.components.core.webview.tachikoma.k
                public final com.kwad.sdk.components.n a(Object... objArr) {
                    if (i.this.abR != null) {
                        return i.this.abR.bd(r2);
                    }
                    return null;
                }
            }

            public AnonymousClass25() {
            }

            @Override // com.kwad.sdk.components.q
            public final void a(com.kwad.sdk.components.l lVar) {
                StyleTemplate styleTemplate;
                Activity activity = i.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.c.b.Fi();
                    activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activity == null || activity.isFinishing()) {
                    lVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                String viewKey22 = lVar.getViewKey();
                if (viewKey22 == null) {
                    styleTemplate = new StyleTemplate();
                    try {
                        styleTemplate.parseJson(styleTemplate, new JSONObject(lVar.getStyleTemplate()));
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.d.c.printStackTrace(th2);
                        lVar.callbackPageStatus(false, "template parse failed");
                        return;
                    }
                } else {
                    styleTemplate = null;
                }
                e.b bVar = new e.b();
                bVar.a(i.this.mAdResultData);
                bVar.c(lVar);
                if (styleTemplate != null) {
                    bVar.a(styleTemplate);
                }
                if (viewKey22 != null) {
                    bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.25.1
                        final /* synthetic */ String acH;

                        public AnonymousClass1(String viewKey222) {
                            viewKey = viewKey222;
                        }

                        @Override // com.kwad.components.core.webview.tachikoma.k
                        public final com.kwad.sdk.components.n a(Object... objArr) {
                            if (i.this.abR != null) {
                                return i.this.abR.bd(viewKey);
                            }
                            return null;
                        }
                    });
                }
                com.kwad.components.core.webview.tachikoma.c.e b10 = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                b10.show(activity.getFragmentManager(), "");
                i.ach.put(Integer.valueOf(lVar.getDialogId()), new WeakReference(b10));
            }

            @Override // com.kwad.sdk.components.q
            public final void b(com.kwad.sdk.components.l lVar) {
                WeakReference weakReference = (WeakReference) i.ach.get(Integer.valueOf(lVar.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.c.e) weakReference.get()).dismiss();
            }

            @Override // com.kwad.sdk.components.q
            public final void a(com.kwad.sdk.components.m mVar) {
                /*
                    this = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.i.c(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.c.b.Fi()
                    android.app.Activity r1 = com.kwad.sdk.core.c.b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.c.b.Fi()
                    android.app.Activity r0 = com.kwad.sdk.core.c.b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.String r3 = r8.getTemplateString()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r4 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    if (r3 == 0) goto L62
                    java.lang.String r3 = r8.getViewKey()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r3 = r8.getClassName()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lb9
                    java.lang.String r3 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.b.a(r4, r3)
                    com.kwad.components.core.webview.tachikoma.i r3 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r3 = r3.mContext
                    r2.setClass(r3, r4)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.r.a.a> r3 = com.kwad.components.core.r.a.a.class
                    com.kwad.sdk.service.b.a(r4, r3)
                    int r3 = com.kwad.components.core.r.a.a.rT()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.r.a.a.a(r3, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.i.d(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.c.f.nt()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.i.d(r6)
                    int r5 = r5.j(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = "tk_style_template"
                    java.lang.String r6 = r8.getTemplateString()
                    r2.putExtra(r5, r6)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$25$2 r6 = new com.kwad.components.core.webview.tachikoma.i$25$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.r.a.a.a(r3, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r3)
                    com.kwad.components.core.webview.tachikoma.i r3 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r3 = r3.mContext
                    r2.setClass(r3, r4)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Le5
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                    java.lang.String r3 = "adCacheId"
                    int r3 = r2.getIntExtra(r3, r1)
                    if (r3 <= 0) goto Le5
                    com.kwad.sdk.core.response.model.AdResultData r3 = com.kwad.components.core.n.a.d.a.a.au(r3)
                    com.kwad.sdk.core.response.model.AdTemplate r3 = com.kwad.sdk.core.response.b.c.o(r3)
                    com.kwad.components.core.proxy.launchdialog.d r4 = com.kwad.components.core.proxy.launchdialog.d.rg()
                    r4.ay(r3)
                Le5:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Lee
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Lee
                    return
                Lee:
                    r0 = move-exception
                    com.kwad.sdk.core.d.c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass25.a(com.kwad.sdk.components.m):void");
            }
        };
        this.acr = new com.kwad.sdk.components.k() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            public AnonymousClass26() {
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j aT(int i10) {
                return i.this.aI(com.kwad.sdk.core.response.b.c.o(com.kwad.components.core.n.a.d.a.a.au(i10)));
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j aY(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aI(adTemplate);
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                    return null;
                }
            }
        };
        this.acs = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.28
            public AnonymousClass28() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "已经超时" + i.this.abN.getTkTemplateId());
                i.this.tU();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.act = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.2
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.f11959ia = new l() { // from class: com.kwad.components.core.webview.tachikoma.i.19
            public AnonymousClass19() {
            }

            private void g(double d10) {
                i.this.xS.adC = false;
                i.this.xS.Tz = false;
                i.this.xS.oZ = (int) ((d10 / 1000.0d) + 0.5d);
                jp();
            }

            private void jp() {
                if (i.this.abS == null || i.this.xS == null) {
                    return;
                }
                i.this.abS.a(i.this.xS);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                i.this.xS.Tz = true;
                i.this.xS.adC = false;
                i.this.xS.oZ = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.eb(i.this.tP()));
                jp();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                i.this.xS.adC = true;
                i.this.xS.Tz = false;
                jp();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j102, long j11) {
                g(j11);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                g(l5.c.f27899e);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                g(l5.c.f27899e);
            }
        };
        this.mContext = context;
        this.yV = j10;
        this.xS = new y();
    }

    public final void a(com.kwad.sdk.core.webview.c.g gVar) {
        this.abO = gVar;
    }

    public void a(TKDownloadListener tKDownloadListener) {
        StyleTemplate tN = tN();
        if (tN == null) {
            tKDownloadListener.onFailed("no template");
            return;
        }
        if (!isLocalDebugEnable()) {
            String n10 = h.tH().n(tN.templateId, tN.templateVersionCode);
            if (!TextUtils.isEmpty(n10) && !isLocalDebugEnable()) {
                tN.jsStr = n10;
                tN.tkSouce = 4;
                com.kwad.sdk.core.d.c.d("TKLoadController", "使用TK模板缓存");
                tKDownloadListener.onSuccess(tN);
                return;
            }
        }
        this.abP.loadTkFileByTemplateId(this.mContext, tN.templateId, tN.templateMd5, tN.templateUrl, tN.templateVersionCode, tKDownloadListener);
    }

    public i(Context context, int i10, int i11) {
        this.abX = false;
        this.abY = false;
        this.abZ = false;
        this.aca = false;
        this.acb = false;
        this.acc = 0;
        this.yV = -1L;
        this.aci = 1000;
        this.acj = 0;
        this.ack = true;
        this.acn = new com.kwad.sdk.core.webview.e();
        this.aco = new KsAdWebView.b() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (i.this.Yk != null) {
                    i.this.Yk.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (i.this.Yk != null) {
                    i.this.Yk.onSuccess();
                }
            }
        };
        this.acp = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            public AnonymousClass23() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.acq = new q() { // from class: com.kwad.components.core.webview.tachikoma.i.25

            /* renamed from: com.kwad.components.core.webview.tachikoma.i$25$1 */
            public class AnonymousClass1 extends k {
                final /* synthetic */ String acH;

                public AnonymousClass1(String viewKey222) {
                    viewKey = viewKey222;
                }

                @Override // com.kwad.components.core.webview.tachikoma.k
                public final com.kwad.sdk.components.n a(Object... objArr) {
                    if (i.this.abR != null) {
                        return i.this.abR.bd(viewKey);
                    }
                    return null;
                }
            }

            /* renamed from: com.kwad.components.core.webview.tachikoma.i$25$2 */
            public class AnonymousClass2 extends k {
                final /* synthetic */ String acH;

                public AnonymousClass2(String str) {
                    r2 = str;
                }

                @Override // com.kwad.components.core.webview.tachikoma.k
                public final com.kwad.sdk.components.n a(Object... objArr) {
                    if (i.this.abR != null) {
                        return i.this.abR.bd(r2);
                    }
                    return null;
                }
            }

            public AnonymousClass25() {
            }

            @Override // com.kwad.sdk.components.q
            public final void a(com.kwad.sdk.components.l lVar) {
                StyleTemplate styleTemplate;
                Activity activity = i.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.c.b.Fi();
                    activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activity == null || activity.isFinishing()) {
                    lVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                String viewKey222 = lVar.getViewKey();
                if (viewKey222 == null) {
                    styleTemplate = new StyleTemplate();
                    try {
                        styleTemplate.parseJson(styleTemplate, new JSONObject(lVar.getStyleTemplate()));
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.d.c.printStackTrace(th2);
                        lVar.callbackPageStatus(false, "template parse failed");
                        return;
                    }
                } else {
                    styleTemplate = null;
                }
                e.b bVar = new e.b();
                bVar.a(i.this.mAdResultData);
                bVar.c(lVar);
                if (styleTemplate != null) {
                    bVar.a(styleTemplate);
                }
                if (viewKey222 != null) {
                    bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.25.1
                        final /* synthetic */ String acH;

                        public AnonymousClass1(String viewKey2222) {
                            viewKey = viewKey2222;
                        }

                        @Override // com.kwad.components.core.webview.tachikoma.k
                        public final com.kwad.sdk.components.n a(Object... objArr) {
                            if (i.this.abR != null) {
                                return i.this.abR.bd(viewKey);
                            }
                            return null;
                        }
                    });
                }
                com.kwad.components.core.webview.tachikoma.c.e b10 = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                b10.show(activity.getFragmentManager(), "");
                i.ach.put(Integer.valueOf(lVar.getDialogId()), new WeakReference(b10));
            }

            @Override // com.kwad.sdk.components.q
            public final void b(com.kwad.sdk.components.l lVar) {
                WeakReference weakReference = (WeakReference) i.ach.get(Integer.valueOf(lVar.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.c.e) weakReference.get()).dismiss();
            }

            @Override // com.kwad.sdk.components.q
            public final void a(com.kwad.sdk.components.m mVar) {
                /*
                    this = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.i.c(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.c.b.Fi()
                    android.app.Activity r1 = com.kwad.sdk.core.c.b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.c.b.Fi()
                    android.app.Activity r0 = com.kwad.sdk.core.c.b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.String r3 = r8.getTemplateString()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r4 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    if (r3 == 0) goto L62
                    java.lang.String r3 = r8.getViewKey()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r3 = r8.getClassName()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lb9
                    java.lang.String r3 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.b.a(r4, r3)
                    com.kwad.components.core.webview.tachikoma.i r3 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r3 = r3.mContext
                    r2.setClass(r3, r4)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.r.a.a> r3 = com.kwad.components.core.r.a.a.class
                    com.kwad.sdk.service.b.a(r4, r3)
                    int r3 = com.kwad.components.core.r.a.a.rT()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.r.a.a.a(r3, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.i.d(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.c.f.nt()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.i.d(r6)
                    int r5 = r5.j(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = "tk_style_template"
                    java.lang.String r6 = r8.getTemplateString()
                    r2.putExtra(r5, r6)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$25$2 r6 = new com.kwad.components.core.webview.tachikoma.i$25$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.r.a.a.a(r3, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r3)
                    com.kwad.components.core.webview.tachikoma.i r3 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r3 = r3.mContext
                    r2.setClass(r3, r4)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Le5
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                    java.lang.String r3 = "adCacheId"
                    int r3 = r2.getIntExtra(r3, r1)
                    if (r3 <= 0) goto Le5
                    com.kwad.sdk.core.response.model.AdResultData r3 = com.kwad.components.core.n.a.d.a.a.au(r3)
                    com.kwad.sdk.core.response.model.AdTemplate r3 = com.kwad.sdk.core.response.b.c.o(r3)
                    com.kwad.components.core.proxy.launchdialog.d r4 = com.kwad.components.core.proxy.launchdialog.d.rg()
                    r4.ay(r3)
                Le5:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Lee
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Lee
                    return
                Lee:
                    r0 = move-exception
                    com.kwad.sdk.core.d.c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass25.a(com.kwad.sdk.components.m):void");
            }
        };
        this.acr = new com.kwad.sdk.components.k() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            public AnonymousClass26() {
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j aT(int i102) {
                return i.this.aI(com.kwad.sdk.core.response.b.c.o(com.kwad.components.core.n.a.d.a.a.au(i102)));
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j aY(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aI(adTemplate);
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                    return null;
                }
            }
        };
        this.acs = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.28
            public AnonymousClass28() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "已经超时" + i.this.abN.getTkTemplateId());
                i.this.tU();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.act = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.2
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.f11959ia = new l() { // from class: com.kwad.components.core.webview.tachikoma.i.19
            public AnonymousClass19() {
            }

            private void g(double d10) {
                i.this.xS.adC = false;
                i.this.xS.Tz = false;
                i.this.xS.oZ = (int) ((d10 / 1000.0d) + 0.5d);
                jp();
            }

            private void jp() {
                if (i.this.abS == null || i.this.xS == null) {
                    return;
                }
                i.this.abS.a(i.this.xS);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                i.this.xS.Tz = true;
                i.this.xS.adC = false;
                i.this.xS.oZ = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.eb(i.this.tP()));
                jp();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i102, int i112) {
                i.this.xS.adC = true;
                i.this.xS.Tz = false;
                jp();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j102, long j11) {
                g(j11);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                g(l5.c.f27899e);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                g(l5.c.f27899e);
            }
        };
        this.mContext = context;
        this.aci = i10;
        this.xS = new y();
        this.acj = i11;
    }

    public void a(StyleTemplate styleTemplate, a aVar) {
        this.Vh = styleTemplate;
        com.kwad.sdk.core.d.c.w("TKLoadController", "addTKView mTKPlugin.getState(): " + this.abP.getState());
        if (this.abP.getState() == ITkOfflineCompo.TKState.SO_FAIL) {
            aW(TKPerformMsg.ERROR_REASON.KSAD_TK_SO_FAIL);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(styleTemplate.jsStr)) {
            aX(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        try {
            tS();
            this.ace = SystemClock.elapsedRealtime();
            com.kwad.sdk.components.s a10 = this.abP.a(this.mContext, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce, this.ack);
            com.kwad.components.core.n.a.d.a.a.a(a10.getUniqId(), this.mAdResultData);
            a10.a(this.acq);
            a10.a(this.acr);
            AdResultData adResultData = this.mAdResultData;
            if (adResultData != null && com.kwad.sdk.core.response.b.c.o(adResultData).mAdScene != null) {
                tV().put("adStyle", Integer.valueOf(com.kwad.sdk.core.response.b.c.o(this.mAdResultData).mAdScene.getAdStyle()));
                tV().put("adScene", com.kwad.sdk.core.response.b.c.o(this.mAdResultData).mAdScene.toJson().toString());
            }
            if (this.Vh != null) {
                tV().put("styleTemplate", this.Vh.toJson().toString());
            }
            tV().put("adCacheId", Integer.valueOf(a10.getUniqId()));
            tV().put("appId", ServiceProvider.getAppId());
            tV().put("isDebug", com.kwad.components.core.a.ns);
            a10.setCustomEnv(tV());
            this.abR = a10;
            com.kwad.sdk.core.c.b.Fi();
            Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null) {
                ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView();
                tV().put("isImmersiveMode", Boolean.valueOf(com.kwad.sdk.c.a.a.E(viewGroup) && com.kwad.sdk.c.a.a.aZ(currentActivity) == viewGroup.getHeight()));
            }
            a10.setCustomEnv(tV());
            com.kwad.sdk.core.webview.c.g gVar = this.abO;
            if (gVar != null) {
                a10.b(gVar);
            }
            this.acf = SystemClock.elapsedRealtime() - this.ace;
            this.acd = SystemClock.elapsedRealtime();
            tO();
            a(a10);
            File file = new File(this.abP.getJsBaseDir(this.mContext, this.abN.getTkTemplateId()));
            a10.a(styleTemplate.jsStr, file.getAbsolutePath() + "/", new com.kwad.sdk.components.r() { // from class: com.kwad.components.core.webview.tachikoma.i.24
                final /* synthetic */ a acG;

                public AnonymousClass24(a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.kwad.sdk.components.r
                public final void onFailed(Throwable th2) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onFailed();
                    }
                    i.this.f(th2);
                }

                @Override // com.kwad.sdk.components.r
                public final void onSuccess() {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onSuccess();
                    }
                }
            });
            FrameLayout tKContainer = this.abN.getTKContainer();
            if (tKContainer == null || !this.ack) {
                return;
            }
            View view = a10.getView();
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            tKContainer.addView(view);
            c(styleTemplate);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
            f(th2);
            if (aVar2 != null) {
                aVar2.onFailed();
            }
        }
    }

    private void a(com.kwad.sdk.components.s sVar) {
        com.kwad.components.core.e.d.c cVar = tP() != null ? new com.kwad.components.core.e.d.c(tP()) : null;
        this.abN.a(sVar, this.acn);
        a(sVar, new com.kwad.components.core.webview.jshandler.p());
        a(sVar, new com.kwad.components.core.webview.jshandler.q());
        com.kwad.components.core.webview.tachikoma.a.s sVar2 = new com.kwad.components.core.webview.tachikoma.a.s();
        sVar2.a(new s.a() { // from class: com.kwad.components.core.webview.tachikoma.i.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.s.a
            public final void a(com.kwad.components.core.webview.tachikoma.b.s sVar3) {
                if (TextUtils.isEmpty(sVar3.message)) {
                    return;
                }
                z.d(i.this.mContext, sVar3.message, 0L);
            }
        });
        a(sVar, sVar2);
        a(sVar, c(this.acn));
        a(sVar, new com.kwad.components.core.webview.jshandler.m(this.acn));
        a(sVar, new com.kwad.components.core.webview.jshandler.n(this.acn));
        a(sVar, new com.kwad.sdk.core.webview.d.a());
        a(sVar, new com.kwad.components.core.webview.tachikoma.a.f());
        a(sVar, new x());
        if (nY()) {
            com.kwad.components.core.webview.jshandler.y yVar = new com.kwad.components.core.webview.jshandler.y(this.acn, cVar, this);
            if (!this.acl.equals(com.kwad.sdk.core.response.b.b.cX(this.acn.getAdTemplate()))) {
                com.kwad.components.core.e.e.g.pg().a(this);
            }
            a(sVar, yVar);
        } else {
            a(sVar, new ab(this.acn, cVar, this, (byte) 0));
        }
        a(sVar, new aa(this.acn));
        a(sVar, new com.kwad.components.core.webview.tachikoma.a.k());
        a(sVar, new ae(this.acn));
        a(sVar, new ah(this.acn));
        a(sVar, new aq(this.mContext, tP()));
        ad adVar = new ad(this.acn);
        adVar.a(new ad.b() { // from class: com.kwad.components.core.webview.tachikoma.i.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ad.b
            public final void c(ad.a aVar) {
                i.this.abN.a(aVar);
            }
        });
        a(sVar, adVar);
        a(sVar, new bc(this.acn, new bc.a() { // from class: com.kwad.components.core.webview.tachikoma.i.6
            public AnonymousClass6() {
            }

            @Override // com.kwad.components.core.webview.jshandler.bc.a
            public final void aH(AdTemplate adTemplate) {
                try {
                    i.this.acn.IB().remove(0);
                    i.this.acn.IB().add(adTemplate);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(adTemplate);
                    AdResultData adResultData = new AdResultData();
                    adResultData.setAdTemplateList(arrayList);
                    adResultData.llsid = adTemplate.llsid;
                    i.this.mAdResultData = adResultData;
                    if (i.this.abR != null) {
                        com.kwad.components.core.n.a.d.a.a.a(i.this.abR.getUniqId(), i.this.mAdResultData);
                    }
                    i.this.abU.setApkDownloadHelper(new com.kwad.components.core.e.d.c(adTemplate));
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                }
            }
        }));
        a(sVar, new ak(this.acn, new ak.b() { // from class: com.kwad.components.core.webview.tachikoma.i.7
            public AnonymousClass7() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ak.b
            public final void a(ak.a aVar) {
                i.this.b(aVar);
            }
        }));
        a(sVar, new ar(new ar.b() { // from class: com.kwad.components.core.webview.tachikoma.i.8

            /* renamed from: com.kwad.components.core.webview.tachikoma.i$8$1 */
            public class AnonymousClass1 implements Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    i.this.abN.ay();
                }
            }

            public AnonymousClass8() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ar.b
            public final void a(ar.a aVar) {
                if (aVar.status != 1) {
                    i.this.b(TKRenderFailReason.RENDER_ERROR);
                    i.this.aX(aVar.errorMsg);
                } else {
                    if (i.this.abY) {
                        i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
                        return;
                    }
                    bt.c(i.this.act);
                    i.this.tT();
                    if (i.this.abN != null) {
                        bt.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.8.1
                            public AnonymousClass1() {
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                i.this.abN.ay();
                            }
                        });
                        com.kwad.components.core.webview.tachikoma.d.b.uj().c(i.this.abN.getTkTemplateId(), i.this.ace - i.this.GC, i.this.acf, i.this.acd > 0 ? SystemClock.elapsedRealtime() - i.this.acd : 0L);
                    }
                }
            }
        }));
        ay ayVar = new ay();
        this.f11958ed = ayVar;
        a(sVar, ayVar);
        this.abN.a(this.f11958ed);
        ax axVar = new ax();
        this.abT = axVar;
        a(sVar, axVar);
        bb bbVar = new bb(this.acn, cVar);
        this.abU = bbVar;
        a(sVar, bbVar);
        com.kwad.components.core.webview.tachikoma.a.p pVar = new com.kwad.components.core.webview.tachikoma.a.p();
        this.abS = pVar;
        a(sVar, pVar);
        this.abN.a(this.abS);
        a(sVar, new com.kwad.components.core.webview.jshandler.a(new a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.9
            public AnonymousClass9() {
            }

            @Override // com.kwad.components.core.webview.jshandler.a.b
            public final void c(a.C0448a c0448a) {
                i.this.abN.a(c0448a);
            }
        }));
        if (tP() != null && com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.eb(tP()))) {
            com.kwad.components.core.webview.tachikoma.a.l lVar = new com.kwad.components.core.webview.tachikoma.a.l();
            a(sVar, lVar);
            this.Yl = new com.kwad.sdk.core.download.d(tP()) { // from class: com.kwad.components.core.webview.tachikoma.i.10
                final /* synthetic */ com.kwad.components.core.webview.tachikoma.a.l Yq;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass10(AdTemplate adTemplate, com.kwad.components.core.webview.tachikoma.a.l lVar2) {
                    super(adTemplate);
                    lVar = lVar2;
                }

                @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
                public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
                    super.b(str, str2, eVar);
                    com.kwad.components.core.webview.tachikoma.b.b bVar = new com.kwad.components.core.webview.tachikoma.b.b();
                    bVar.adl = 1;
                    lVar.a(bVar);
                }
            };
            com.kwad.sdk.core.download.b.EI().a(this.Yl, tP());
        }
        t tVar = new t();
        tVar.a(new t.a() { // from class: com.kwad.components.core.webview.tachikoma.i.11
            public AnonymousClass11() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.t.a
            public final void b(com.kwad.components.core.webview.tachikoma.b.t tVar2) {
                i.this.abN.a(tVar2);
            }
        });
        a(sVar, tVar);
        v vVar = new v();
        vVar.a(new v.a() { // from class: com.kwad.components.core.webview.tachikoma.i.13
            public AnonymousClass13() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.v.a
            public final void b(m mVar) {
                i.this.abN.a(mVar);
            }
        });
        a(sVar, vVar);
        o oVar = new o();
        a(sVar, oVar);
        this.abN.a(oVar);
        a(sVar, new r() { // from class: com.kwad.components.core.webview.tachikoma.i.14
            public AnonymousClass14() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.r
            public final void a(com.kwad.components.core.webview.tachikoma.b.r rVar) {
                super.a(rVar);
                if (i.this.mActivity == null) {
                    i iVar = i.this;
                    com.kwad.sdk.core.c.b.Fi();
                    iVar.mActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (i.this.mActivity == null || i.this.mActivity.isFinishing()) {
                    return;
                }
                if (i.this.abM != null) {
                    i.this.abM.dismiss();
                }
                e.b bVar = new e.b();
                bVar.a(i.this.mAdResultData);
                bVar.aZ(rVar.templateId);
                i.this.abM = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                i.this.abM.show(i.this.mActivity.getFragmentManager(), "");
            }
        });
        a(sVar, new com.kwad.components.core.webview.tachikoma.a.c() { // from class: com.kwad.components.core.webview.tachikoma.i.15
            public AnonymousClass15() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.c
            public final void js() {
                super.js();
                if (i.this.abM != null) {
                    i.this.abM.dismiss();
                }
                j jVar = i.this.abN;
                if (jVar != null) {
                    jVar.az();
                }
            }
        });
        a(sVar, new com.kwad.components.core.webview.jshandler.z(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.16
            public AnonymousClass16() {
            }

            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                i.this.abN.a(webCloseStatus);
            }
        }));
        a(sVar, new com.kwad.components.core.webview.tachikoma.a.d() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            public AnonymousClass17() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.d
            public final void a(com.kwad.components.core.webview.tachikoma.b.g gVar) {
                int i10 = gVar.Yy;
                AdTemplate a10 = i10 >= 0 ? com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.n.a.d.a.a.au(i10), gVar.Li) : null;
                if (a10 == null) {
                    a10 = i.this.tP();
                }
                com.kwad.components.core.o.a.ri().a(gVar.actionType, a10, gVar.MI);
            }
        });
        a(sVar, new com.kwad.components.core.webview.tachikoma.a.j() { // from class: com.kwad.components.core.webview.tachikoma.i.18
            public AnonymousClass18() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.j
            public final void a(n nVar) {
                super.a(nVar);
                AdWebViewActivityProxy.launch(i.this.mContext, new AdWebViewActivityProxy.a.C0438a().au(nVar.title).av(nVar.url).aF(!nVar.adv).n(i.this.mAdResultData).qa());
            }
        });
        a(sVar, new com.kwad.components.core.webview.tachikoma.a.a(tP()));
        a(sVar, new com.kwad.components.core.webview.tachikoma.a(tP()));
        a(this.acn, cVar, sVar, this.abN.getTKContainer());
        a(sVar, new com.kwad.components.core.webview.jshandler.a.f(this.mContext));
        a(sVar, new com.kwad.components.core.webview.jshandler.a.d(this.mContext));
        a(sVar, new com.kwad.components.core.webview.jshandler.a.a());
        a(sVar, new com.kwad.components.core.webview.jshandler.a.e(this.mContext));
        av avVar = new av();
        this.Yk = avVar;
        a(sVar, avVar);
    }

    private static void a(com.kwad.sdk.components.s sVar, com.kwad.sdk.core.webview.c.a aVar) {
        sVar.c(aVar);
    }

    public final void a(String str, Object obj) {
        tV().put(str, obj);
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        j jVar = this.abN;
        if (jVar != null) {
            jVar.a(aVar);
        }
    }
}
