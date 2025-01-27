package com.kwad.components.core.webview.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.EnvironmentCompat;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.a.a.m;
import com.kwad.components.core.webview.a.a.n;
import com.kwad.components.core.webview.a.a.t;
import com.kwad.components.core.webview.a.a.z;
import com.kwad.components.core.webview.a.b.d;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.a.kwai.r;
import com.kwad.components.core.webview.a.kwai.s;
import com.kwad.components.core.webview.a.kwai.t;
import com.kwad.components.core.webview.a.kwai.u;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.k;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.v;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class h implements com.kwad.sdk.components.i, com.kwad.sdk.core.webview.c.kwai.a {
    private static final String TAG = "TKLoadController";
    private static final int TIME_OUT = 1000;
    private static Map<Integer, WeakReference<com.kwad.components.core.webview.a.b.d>> mDialogMap = new HashMap();
    private boolean hasDownloadTimeout;
    private boolean isHasCallJsFailed;
    private boolean isTkTemplateRenderComplete;
    private boolean isTkTemplateRenderStart;
    protected com.kwad.sdk.core.webview.b jsBridgeContext;

    @Nullable
    private Activity mActivity;
    private AdTemplate mAdTemplate;
    protected final Context mContext;
    private Map<String, Object> mCustomEnv;
    private com.kwad.sdk.core.download.e mDownloadSyncInterfaceAdapter;
    private final Runnable mDownloadTimeoutRunnable;
    private com.kwad.sdk.components.j mHostActionHandler;
    private long mInitTime;
    private p mJSVideoProgress;
    private long mLoadEndTime;
    private long mLoadStartTime;
    private Future<?> mLoadTkFuture;
    protected long mPlayedDuration;
    private long mRenderStartTime;
    private StyleTemplate mStyleTemplate;
    private com.kwad.sdk.core.webview.b.g mTKBridgeHandler;
    protected i mTKLoadInterface;
    private com.kwad.components.core.offline.api.a.c mTKPlugin;
    private a mTKRenderListenerInner;
    private l mTKView;
    private com.kwad.components.core.webview.a.b.d mTkDialogFragment;
    private final com.kwad.components.core.video.j mVideoPlayStateListener;
    private final z mVideoProgress;
    private int tkLoadTimeOut;
    private int tkSource;

    /* renamed from: com.kwad.components.core.webview.a.h$1 */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: com.kwad.components.core.webview.a.h$1$1 */
        final class C01891 implements TKDownloadListener {
            C01891() {
            }

            @Override // com.kwad.components.offline.api.tk.TKDownloadListener
            public final void onFailed(String str) {
                h.this.handleLoadStyleTemplateFailed(str);
            }

            @Override // com.kwad.components.offline.api.tk.TKDownloadListener
            public final void onSuccess(@NonNull StyleTemplate styleTemplate) {
                h.this.handleLoadStyleTemplateSuccess(styleTemplate);
            }
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.this.mLoadStartTime = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.d.b.d(h.TAG, "开始读取模板 id: " + h.this.mTKLoadInterface.getTkTemplateId());
            h.this.loadStyleTemplateFromAdInfo(new TKDownloadListener() { // from class: com.kwad.components.core.webview.a.h.1.1
                C01891() {
                }

                @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                public final void onFailed(String str) {
                    h.this.handleLoadStyleTemplateFailed(str);
                }

                @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                public final void onSuccess(@NonNull StyleTemplate styleTemplate) {
                    h.this.handleLoadStyleTemplateSuccess(styleTemplate);
                }
            });
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$10 */
    final class AnonymousClass10 extends com.kwad.components.core.webview.a.kwai.d {
        AnonymousClass10() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.d
        public final void a(com.kwad.components.core.webview.a.a.g gVar) {
            super.a(gVar);
            com.kwad.components.core.m.a.pb().a(gVar.Tr, h.this.obtainAdTemplate(), gVar.Ts);
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$11 */
    final class AnonymousClass11 extends com.kwad.components.core.webview.a.kwai.j {
        AnonymousClass11() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.j
        public final void a(n nVar) {
            super.a(nVar);
            AdWebViewActivityProxy.launch(h.this.mContext, new AdWebViewActivityProxy.a.C0182a().au(nVar.title).av(nVar.url).aA(true).L(h.this.obtainAdTemplate()).oc());
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$12 */
    final class AnonymousClass12 implements Runnable {
        final /* synthetic */ StyleTemplate Uu;

        AnonymousClass12(StyleTemplate styleTemplate) {
            styleTemplate = styleTemplate;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h hVar = h.this;
            hVar.addTKView(styleTemplate, hVar.mTKRenderListenerInner);
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$13 */
    final class AnonymousClass13 extends com.kwad.components.core.video.j {
        AnonymousClass13() {
        }

        private void g(double d2) {
            h.this.mVideoProgress.Vq = false;
            h.this.mVideoProgress.Vm = false;
            h.this.mVideoProgress.nZ = (int) ((d2 / 1000.0d) + 0.5d);
            iR();
        }

        private void iR() {
            if (h.this.mJSVideoProgress == null || h.this.mVideoProgress == null) {
                return;
            }
            h.this.mJSVideoProgress.a(h.this.mVideoProgress);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            h.this.mVideoProgress.Vm = true;
            h.this.mVideoProgress.Vq = false;
            h.this.mVideoProgress.nZ = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(h.this.obtainAdTemplate()));
            iR();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i2, int i3) {
            h.this.mVideoProgress.Vq = true;
            h.this.mVideoProgress.Vm = false;
            iR();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            g(j3);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            g(0.0d);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPreparing() {
            g(0.0d);
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$14 */
    final class AnonymousClass14 implements Runnable {
        final /* synthetic */ l Uv;

        AnonymousClass14(l lVar) {
            lVar = lVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l lVar = lVar;
            if (lVar != null) {
                lVar.onDestroy();
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$15 */
    final class AnonymousClass15 implements Runnable {
        final /* synthetic */ String UA;
        final /* synthetic */ String Uw;
        final /* synthetic */ String Ux;
        final /* synthetic */ String Uy;
        final /* synthetic */ String Uz;

        /* renamed from: com.kwad.components.core.webview.a.h$15$1 */
        final class AnonymousClass1 implements AdHttpBodyBuilder {
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
            public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                adHttpFormDataBuilder.addFormDataPart(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID, string3);
                adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                adHttpFormDataBuilder.addFormDataPart("os_build_serial", EnvironmentCompat.MEDIA_UNKNOWN);
                adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                adHttpFormDataBuilder.addFormDataPart("app_version", "3.3.40");
                adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                adHttpFormDataBuilder.addFormDataPart("uid", "");
                adHttpFormDataBuilder.addFormDataPart("did", au.getDeviceId());
                adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                try {
                    adHttpFormDataBuilder.addFormDataPart("file", UUID.randomUUID().toString() + ".json", "application/octet-stream", str.getBytes("UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    com.kwad.sdk.core.d.b.printStackTrace(e2);
                }
            }
        }

        AnonymousClass15(String str, String str2, String str3, String str4, String str5) {
            string3 = str;
            string4 = str2;
            string2 = str3;
            string = str4;
            str = str5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str;
            String str2;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("coverage_task_id", Integer.valueOf(string3));
                jSONObject.put("user", "");
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject.put("branch_name", string4);
                jSONObject.put("version", "3.3.40");
                jSONObject.put("tk_version", String.valueOf(h.this.mStyleTemplate.templateVersionCode));
                jSONObject.put("tk_template_ids", h.this.mStyleTemplate.templateId);
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
            com.kwad.sdk.core.network.c doPost = com.kwad.sdk.b.rZ().doPost(string2 + "/analysis/add/pkg/info", (Map<String, String>) null, jSONObject);
            if (doPost.wb()) {
                str = "上传TK覆盖率pkg完成:" + doPost.agf;
            } else {
                str = "上传覆盖率pkg失败";
            }
            com.kwad.sdk.core.d.b.d(h.TAG, str);
            com.kwad.sdk.core.network.c doPost2 = com.kwad.sdk.b.rZ().doPost(string2 + "/attachment/ec", (Map<String, String>) null, new AdHttpBodyBuilder() { // from class: com.kwad.components.core.webview.a.h.15.1
                AnonymousClass1() {
                }

                @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
                public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                    adHttpFormDataBuilder.addFormDataPart(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID, string3);
                    adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                    adHttpFormDataBuilder.addFormDataPart("os_build_serial", EnvironmentCompat.MEDIA_UNKNOWN);
                    adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                    adHttpFormDataBuilder.addFormDataPart("app_version", "3.3.40");
                    adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                    adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                    adHttpFormDataBuilder.addFormDataPart("uid", "");
                    adHttpFormDataBuilder.addFormDataPart("did", au.getDeviceId());
                    adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                    adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                    try {
                        adHttpFormDataBuilder.addFormDataPart("file", UUID.randomUUID().toString() + ".json", "application/octet-stream", str.getBytes("UTF-8"));
                    } catch (UnsupportedEncodingException e22) {
                        com.kwad.sdk.core.d.b.printStackTrace(e22);
                    }
                }
            });
            if (doPost2.wb()) {
                str2 = "上传TK覆盖率完成:" + doPost2.agf;
            } else {
                str2 = "上传TK覆盖率失败";
            }
            com.kwad.sdk.core.d.b.d(h.TAG, str2);
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$16 */
    final class AnonymousClass16 implements a {
        AnonymousClass16() {
        }

        @Override // com.kwad.components.core.webview.a.h.a
        public final void onFailed() {
            h.this.callbackTkLoadFailed();
            com.kwad.sdk.core.d.b.d(h.TAG, "渲染失败");
        }

        @Override // com.kwad.components.core.webview.a.h.a
        public final void onSuccess() {
            com.kwad.sdk.core.d.b.d(h.TAG, "渲染成功");
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$17 */
    final class AnonymousClass17 implements k {
        final /* synthetic */ a UC;

        AnonymousClass17(a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.components.k
        public final void onFailed(Throwable th) {
            a aVar = aVar;
            if (aVar != null) {
                aVar.onFailed();
            }
            h.this.logTkError(th);
        }

        @Override // com.kwad.sdk.components.k
        public final void onSuccess() {
            a aVar = aVar;
            if (aVar != null) {
                aVar.onSuccess();
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$18 */
    final class AnonymousClass18 implements com.kwad.sdk.components.j {
        AnonymousClass18() {
        }

        @Override // com.kwad.sdk.components.j
        public final void a(com.kwad.sdk.components.g gVar) {
            Activity activity = h.this.mActivity;
            if (activity == null) {
                com.kwad.sdk.core.b.b.vS();
                activity = com.kwad.sdk.core.b.b.getCurrentActivity();
            }
            if (activity == null || activity.isFinishing()) {
                gVar.callbackPageStatus(false, "no host activity");
                return;
            }
            StyleTemplate styleTemplate = new StyleTemplate();
            try {
                styleTemplate.parseJson(styleTemplate, new JSONObject(gVar.getStyleTemplate()));
                d.b bVar = new d.b();
                bVar.setAdTemplate(h.this.obtainAdTemplate());
                bVar.setStyleTemplate(styleTemplate);
                bVar.aP(styleTemplate.templateId);
                bVar.c(gVar);
                com.kwad.components.core.webview.a.b.d b2 = com.kwad.components.core.webview.a.b.d.b(bVar);
                b2.show(activity.getFragmentManager(), "");
                h.mDialogMap.put(Integer.valueOf(gVar.getDialogId()), new WeakReference(b2));
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
                gVar.callbackPageStatus(false, "template parse failed");
            }
        }

        @Override // com.kwad.sdk.components.j
        public final void a(com.kwad.sdk.components.h hVar) {
            String message;
            if (hVar.getTemplateString() == null && hVar.getUrl() == null && hVar.getClassName() == null) {
                message = "intent invalid";
            } else {
                Activity activity = h.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.b.b.vS();
                    activity = com.kwad.sdk.core.b.b.getCurrentActivity();
                }
                if (activity == null) {
                    hVar.callbackPageStatus(false, "no host activity");
                }
                Intent intent = hVar.getIntent();
                try {
                    if (hVar.getTemplateString() != null) {
                        com.kwad.sdk.service.a.a(FeedDownloadActivity.class, com.kwad.components.core.q.kwai.a.class);
                        int pD = com.kwad.components.core.q.kwai.a.pD();
                        com.kwad.components.core.q.kwai.a.a(pD, "native_intent", hVar);
                        AdTemplate obtainAdTemplate = h.this.obtainAdTemplate();
                        if (obtainAdTemplate != null) {
                            intent.putExtra("tk_ad_template", obtainAdTemplate.toJson().toString());
                        }
                        intent.putExtra("tk_style_template", hVar.getTemplateString());
                        intent.putExtra("tk_id", pD);
                    } else if (hVar.getClassName() == null) {
                        intent.setData(Uri.parse(hVar.getUrl()));
                        activity.startActivity(intent);
                        hVar.callbackPageStatus(true, null);
                        return;
                    } else {
                        try {
                            com.kwad.sdk.service.a.a(FeedDownloadActivity.class, Class.forName(hVar.getClassName()));
                        } catch (ClassNotFoundException e2) {
                            message = e2.getMessage();
                        }
                    }
                    activity.startActivity(intent);
                    hVar.callbackPageStatus(true, null);
                    return;
                } catch (Throwable th) {
                    message = th.getMessage();
                }
                intent.setClass(h.this.mContext, FeedDownloadActivity.class);
            }
            hVar.callbackPageStatus(false, message);
        }

        @Override // com.kwad.sdk.components.j
        public final void b(com.kwad.sdk.components.g gVar) {
            WeakReference weakReference = (WeakReference) h.mDialogMap.get(Integer.valueOf(gVar.getDialogId()));
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            ((com.kwad.components.core.webview.a.b.d) weakReference.get()).dismiss();
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$19 */
    final class AnonymousClass19 implements Runnable {
        AnonymousClass19() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.d(h.TAG, "已经超时" + h.this.mTKLoadInterface.getTkTemplateId());
            h.this.logTkDownloadTimeout();
            h.this.hasDownloadTimeout = true;
            h.this.callbackTkLoadFailed();
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$2 */
    final class AnonymousClass2 implements ab.b {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ab.b
        public final void a(ab.a aVar) {
            h.this.onFrameValid(aVar);
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$20 */
    final class AnonymousClass20 implements Runnable {
        AnonymousClass20() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (h.this.isHasCallJsFailed) {
                return;
            }
            h.this.isHasCallJsFailed = true;
            h.this.mTKLoadInterface.onTkLoadFailed();
            com.kwad.components.core.webview.a.c.a.rn().aS(h.this.mTKLoadInterface.getTkTemplateId());
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$21 */
    final class AnonymousClass21 implements s.a {
        AnonymousClass21() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.s.a
        public final void a(t tVar) {
            if (TextUtils.isEmpty(tVar.message)) {
                return;
            }
            v.d(h.this.mContext, tVar.message, 0L);
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$22 */
    final class AnonymousClass22 implements u.b {
        AnonymousClass22() {
        }

        @Override // com.kwad.components.core.webview.jshandler.u.b
        public final void a(u.a aVar) {
            h.this.mTKLoadInterface.onGetContainerLimited(aVar);
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$3 */
    final class AnonymousClass3 implements ai.b {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            if (aVar.status != 1) {
                h.this.callbackTkLoadFailed();
                h.this.logTkRenderFail(aVar.errorMsg);
                return;
            }
            h.this.logTkRenderSuccess();
            i iVar = h.this.mTKLoadInterface;
            if (iVar != null) {
                iVar.onTkLoadSuccess();
                com.kwad.components.core.webview.a.c.a.rn().aT(h.this.mTKLoadInterface.getTkTemplateId());
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$4 */
    final class AnonymousClass4 extends com.kwad.sdk.core.download.e {
        final /* synthetic */ com.kwad.components.core.webview.a.kwai.l RS;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(AdTemplate adTemplate, com.kwad.components.core.webview.a.kwai.l lVar) {
            super(adTemplate);
            lVar2 = lVar;
        }

        @Override // com.kwad.sdk.core.download.e, com.kwad.sdk.core.download.d
        public final void a(String str, int i2, com.kwad.sdk.core.download.f fVar) {
            super.a(str, i2, fVar);
            com.kwad.components.core.webview.a.a.b bVar = new com.kwad.components.core.webview.a.a.b();
            bVar.UW = 1;
            lVar2.a(bVar);
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$5 */
    final class AnonymousClass5 implements t.a {
        AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.t.a
        public final void a(com.kwad.components.core.webview.a.a.u uVar) {
            h.this.mTKLoadInterface.onSkipClick(uVar);
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$6 */
    final class AnonymousClass6 implements u.a {
        AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.u.a
        public final void a(m mVar) {
            h.this.mTKLoadInterface.onUpdateMuteStatus(mVar);
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$7 */
    final class AnonymousClass7 extends r {
        AnonymousClass7() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.r
        public final void a(com.kwad.components.core.webview.a.a.s sVar) {
            super.a(sVar);
            if (h.this.mActivity == null) {
                h hVar = h.this;
                com.kwad.sdk.core.b.b.vS();
                hVar.mActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
            }
            if (h.this.mActivity == null || h.this.mActivity.isFinishing()) {
                return;
            }
            if (h.this.mTkDialogFragment != null) {
                h.this.mTkDialogFragment.dismiss();
            }
            d.b bVar = new d.b();
            bVar.setAdTemplate(h.this.obtainAdTemplate());
            bVar.aP(sVar.templateId);
            h.this.mTkDialogFragment = com.kwad.components.core.webview.a.b.d.b(bVar);
            h.this.mTkDialogFragment.show(h.this.mActivity.getFragmentManager(), "");
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$8 */
    final class AnonymousClass8 extends com.kwad.components.core.webview.a.kwai.c {
        AnonymousClass8() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.c
        public final void iT() {
            super.iT();
            if (h.this.mTkDialogFragment != null) {
                h.this.mTkDialogFragment.dismiss();
            }
            i iVar = h.this.mTKLoadInterface;
            if (iVar != null) {
                iVar.onCloseTKDialogClick();
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.h$9 */
    final class AnonymousClass9 implements com.kwad.sdk.core.webview.c.kwai.b {
        AnonymousClass9() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.b
        public final void a(WebCloseStatus webCloseStatus) {
            h.this.mTKLoadInterface.pageClose(webCloseStatus);
        }
    }

    interface a {
        void onFailed();

        void onSuccess();
    }

    public h(long j2, Context context) {
        this.hasDownloadTimeout = false;
        this.isTkTemplateRenderStart = false;
        this.isTkTemplateRenderComplete = false;
        this.isHasCallJsFailed = false;
        this.tkSource = 0;
        this.mPlayedDuration = -1L;
        this.tkLoadTimeOut = 1000;
        this.jsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mTKRenderListenerInner = new a() { // from class: com.kwad.components.core.webview.a.h.16
            AnonymousClass16() {
            }

            @Override // com.kwad.components.core.webview.a.h.a
            public final void onFailed() {
                h.this.callbackTkLoadFailed();
                com.kwad.sdk.core.d.b.d(h.TAG, "渲染失败");
            }

            @Override // com.kwad.components.core.webview.a.h.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.b.d(h.TAG, "渲染成功");
            }
        };
        this.mHostActionHandler = new com.kwad.sdk.components.j() { // from class: com.kwad.components.core.webview.a.h.18
            AnonymousClass18() {
            }

            @Override // com.kwad.sdk.components.j
            public final void a(com.kwad.sdk.components.g gVar) {
                Activity activity = h.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.b.b.vS();
                    activity = com.kwad.sdk.core.b.b.getCurrentActivity();
                }
                if (activity == null || activity.isFinishing()) {
                    gVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                StyleTemplate styleTemplate = new StyleTemplate();
                try {
                    styleTemplate.parseJson(styleTemplate, new JSONObject(gVar.getStyleTemplate()));
                    d.b bVar = new d.b();
                    bVar.setAdTemplate(h.this.obtainAdTemplate());
                    bVar.setStyleTemplate(styleTemplate);
                    bVar.aP(styleTemplate.templateId);
                    bVar.c(gVar);
                    com.kwad.components.core.webview.a.b.d b2 = com.kwad.components.core.webview.a.b.d.b(bVar);
                    b2.show(activity.getFragmentManager(), "");
                    h.mDialogMap.put(Integer.valueOf(gVar.getDialogId()), new WeakReference(b2));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                    gVar.callbackPageStatus(false, "template parse failed");
                }
            }

            @Override // com.kwad.sdk.components.j
            public final void a(com.kwad.sdk.components.h hVar) {
                String message;
                if (hVar.getTemplateString() == null && hVar.getUrl() == null && hVar.getClassName() == null) {
                    message = "intent invalid";
                } else {
                    Activity activity = h.this.mActivity;
                    if (activity == null) {
                        com.kwad.sdk.core.b.b.vS();
                        activity = com.kwad.sdk.core.b.b.getCurrentActivity();
                    }
                    if (activity == null) {
                        hVar.callbackPageStatus(false, "no host activity");
                    }
                    Intent intent = hVar.getIntent();
                    try {
                        if (hVar.getTemplateString() != null) {
                            com.kwad.sdk.service.a.a(FeedDownloadActivity.class, com.kwad.components.core.q.kwai.a.class);
                            int pD = com.kwad.components.core.q.kwai.a.pD();
                            com.kwad.components.core.q.kwai.a.a(pD, "native_intent", hVar);
                            AdTemplate obtainAdTemplate = h.this.obtainAdTemplate();
                            if (obtainAdTemplate != null) {
                                intent.putExtra("tk_ad_template", obtainAdTemplate.toJson().toString());
                            }
                            intent.putExtra("tk_style_template", hVar.getTemplateString());
                            intent.putExtra("tk_id", pD);
                        } else if (hVar.getClassName() == null) {
                            intent.setData(Uri.parse(hVar.getUrl()));
                            activity.startActivity(intent);
                            hVar.callbackPageStatus(true, null);
                            return;
                        } else {
                            try {
                                com.kwad.sdk.service.a.a(FeedDownloadActivity.class, Class.forName(hVar.getClassName()));
                            } catch (ClassNotFoundException e2) {
                                message = e2.getMessage();
                            }
                        }
                        activity.startActivity(intent);
                        hVar.callbackPageStatus(true, null);
                        return;
                    } catch (Throwable th) {
                        message = th.getMessage();
                    }
                    intent.setClass(h.this.mContext, FeedDownloadActivity.class);
                }
                hVar.callbackPageStatus(false, message);
            }

            @Override // com.kwad.sdk.components.j
            public final void b(com.kwad.sdk.components.g gVar) {
                WeakReference weakReference = (WeakReference) h.mDialogMap.get(Integer.valueOf(gVar.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((com.kwad.components.core.webview.a.b.d) weakReference.get()).dismiss();
            }
        };
        this.mDownloadTimeoutRunnable = new Runnable() { // from class: com.kwad.components.core.webview.a.h.19
            AnonymousClass19() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d(h.TAG, "已经超时" + h.this.mTKLoadInterface.getTkTemplateId());
                h.this.logTkDownloadTimeout();
                h.this.hasDownloadTimeout = true;
                h.this.callbackTkLoadFailed();
            }
        };
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.core.webview.a.h.13
            AnonymousClass13() {
            }

            private void g(double d2) {
                h.this.mVideoProgress.Vq = false;
                h.this.mVideoProgress.Vm = false;
                h.this.mVideoProgress.nZ = (int) ((d2 / 1000.0d) + 0.5d);
                iR();
            }

            private void iR() {
                if (h.this.mJSVideoProgress == null || h.this.mVideoProgress == null) {
                    return;
                }
                h.this.mJSVideoProgress.a(h.this.mVideoProgress);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                h.this.mVideoProgress.Vm = true;
                h.this.mVideoProgress.Vq = false;
                h.this.mVideoProgress.nZ = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(h.this.obtainAdTemplate()));
                iR();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
                h.this.mVideoProgress.Vq = true;
                h.this.mVideoProgress.Vm = false;
                iR();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayProgress(long j22, long j3) {
                g(j3);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                g(0.0d);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPreparing() {
                g(0.0d);
            }
        };
        this.mContext = context;
        this.mPlayedDuration = j2;
        this.mVideoProgress = new z();
    }

    public h(Context context, int i2) {
        this.hasDownloadTimeout = false;
        this.isTkTemplateRenderStart = false;
        this.isTkTemplateRenderComplete = false;
        this.isHasCallJsFailed = false;
        this.tkSource = 0;
        this.mPlayedDuration = -1L;
        this.tkLoadTimeOut = 1000;
        this.jsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mTKRenderListenerInner = new a() { // from class: com.kwad.components.core.webview.a.h.16
            AnonymousClass16() {
            }

            @Override // com.kwad.components.core.webview.a.h.a
            public final void onFailed() {
                h.this.callbackTkLoadFailed();
                com.kwad.sdk.core.d.b.d(h.TAG, "渲染失败");
            }

            @Override // com.kwad.components.core.webview.a.h.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.b.d(h.TAG, "渲染成功");
            }
        };
        this.mHostActionHandler = new com.kwad.sdk.components.j() { // from class: com.kwad.components.core.webview.a.h.18
            AnonymousClass18() {
            }

            @Override // com.kwad.sdk.components.j
            public final void a(com.kwad.sdk.components.g gVar) {
                Activity activity = h.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.b.b.vS();
                    activity = com.kwad.sdk.core.b.b.getCurrentActivity();
                }
                if (activity == null || activity.isFinishing()) {
                    gVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                StyleTemplate styleTemplate = new StyleTemplate();
                try {
                    styleTemplate.parseJson(styleTemplate, new JSONObject(gVar.getStyleTemplate()));
                    d.b bVar = new d.b();
                    bVar.setAdTemplate(h.this.obtainAdTemplate());
                    bVar.setStyleTemplate(styleTemplate);
                    bVar.aP(styleTemplate.templateId);
                    bVar.c(gVar);
                    com.kwad.components.core.webview.a.b.d b2 = com.kwad.components.core.webview.a.b.d.b(bVar);
                    b2.show(activity.getFragmentManager(), "");
                    h.mDialogMap.put(Integer.valueOf(gVar.getDialogId()), new WeakReference(b2));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                    gVar.callbackPageStatus(false, "template parse failed");
                }
            }

            @Override // com.kwad.sdk.components.j
            public final void a(com.kwad.sdk.components.h hVar) {
                String message;
                if (hVar.getTemplateString() == null && hVar.getUrl() == null && hVar.getClassName() == null) {
                    message = "intent invalid";
                } else {
                    Activity activity = h.this.mActivity;
                    if (activity == null) {
                        com.kwad.sdk.core.b.b.vS();
                        activity = com.kwad.sdk.core.b.b.getCurrentActivity();
                    }
                    if (activity == null) {
                        hVar.callbackPageStatus(false, "no host activity");
                    }
                    Intent intent = hVar.getIntent();
                    try {
                        if (hVar.getTemplateString() != null) {
                            com.kwad.sdk.service.a.a(FeedDownloadActivity.class, com.kwad.components.core.q.kwai.a.class);
                            int pD = com.kwad.components.core.q.kwai.a.pD();
                            com.kwad.components.core.q.kwai.a.a(pD, "native_intent", hVar);
                            AdTemplate obtainAdTemplate = h.this.obtainAdTemplate();
                            if (obtainAdTemplate != null) {
                                intent.putExtra("tk_ad_template", obtainAdTemplate.toJson().toString());
                            }
                            intent.putExtra("tk_style_template", hVar.getTemplateString());
                            intent.putExtra("tk_id", pD);
                        } else if (hVar.getClassName() == null) {
                            intent.setData(Uri.parse(hVar.getUrl()));
                            activity.startActivity(intent);
                            hVar.callbackPageStatus(true, null);
                            return;
                        } else {
                            try {
                                com.kwad.sdk.service.a.a(FeedDownloadActivity.class, Class.forName(hVar.getClassName()));
                            } catch (ClassNotFoundException e2) {
                                message = e2.getMessage();
                            }
                        }
                        activity.startActivity(intent);
                        hVar.callbackPageStatus(true, null);
                        return;
                    } catch (Throwable th) {
                        message = th.getMessage();
                    }
                    intent.setClass(h.this.mContext, FeedDownloadActivity.class);
                }
                hVar.callbackPageStatus(false, message);
            }

            @Override // com.kwad.sdk.components.j
            public final void b(com.kwad.sdk.components.g gVar) {
                WeakReference weakReference = (WeakReference) h.mDialogMap.get(Integer.valueOf(gVar.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((com.kwad.components.core.webview.a.b.d) weakReference.get()).dismiss();
            }
        };
        this.mDownloadTimeoutRunnable = new Runnable() { // from class: com.kwad.components.core.webview.a.h.19
            AnonymousClass19() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d(h.TAG, "已经超时" + h.this.mTKLoadInterface.getTkTemplateId());
                h.this.logTkDownloadTimeout();
                h.this.hasDownloadTimeout = true;
                h.this.callbackTkLoadFailed();
            }
        };
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.core.webview.a.h.13
            AnonymousClass13() {
            }

            private void g(double d2) {
                h.this.mVideoProgress.Vq = false;
                h.this.mVideoProgress.Vm = false;
                h.this.mVideoProgress.nZ = (int) ((d2 / 1000.0d) + 0.5d);
                iR();
            }

            private void iR() {
                if (h.this.mJSVideoProgress == null || h.this.mVideoProgress == null) {
                    return;
                }
                h.this.mJSVideoProgress.a(h.this.mVideoProgress);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                h.this.mVideoProgress.Vm = true;
                h.this.mVideoProgress.Vq = false;
                h.this.mVideoProgress.nZ = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(h.this.obtainAdTemplate()));
                iR();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i22, int i3) {
                h.this.mVideoProgress.Vq = true;
                h.this.mVideoProgress.Vm = false;
                iR();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayProgress(long j22, long j3) {
                g(j3);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                g(0.0d);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPreparing() {
                g(0.0d);
            }
        };
        this.mContext = context;
        this.tkLoadTimeOut = i2;
        this.mVideoProgress = new z();
    }

    public void addTKView(StyleTemplate styleTemplate, a aVar) {
        this.mStyleTemplate = styleTemplate;
        com.kwad.sdk.core.d.b.w(TAG, "addTKView mTKPlugin.getState(): " + this.mTKPlugin.getState());
        if (this.mTKPlugin.getState() == ITkOfflineCompo.TKState.SO_FAIL) {
            logTKEnvNotReady(TKPerformMsg.ERROR_REASON.KSAD_TK_SO_FAIL);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(styleTemplate.jsStr)) {
            logTkRenderFail(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        try {
            logTkRenderStart();
            this.mLoadEndTime = SystemClock.elapsedRealtime();
            l view = this.mTKPlugin.getView(this.mContext, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce);
            com.kwad.components.core.offline.api.a.kwai.a.a(view.getUniqId(), this.mAdTemplate);
            view.a(this.mHostActionHandler);
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate != null && adTemplate.mAdScene != null) {
                getCustomEnv().put("adStyle", Integer.valueOf(this.mAdTemplate.mAdScene.getAdStyle()));
            }
            view.setCustomEnv(getCustomEnv());
            this.mTKView = view;
            com.kwad.sdk.core.webview.b.g gVar = this.mTKBridgeHandler;
            if (gVar != null) {
                view.a(gVar);
            }
            this.mInitTime = SystemClock.elapsedRealtime() - this.mLoadEndTime;
            this.mRenderStartTime = SystemClock.elapsedRealtime();
            initJsBridgeContext();
            registerWebCardHandler(view);
            File file = new File(this.mTKPlugin.getJsBaseDir(this.mContext, this.mTKLoadInterface.getTkTemplateId()));
            view.a(styleTemplate.jsStr, file.getAbsolutePath() + "/", new k() { // from class: com.kwad.components.core.webview.a.h.17
                final /* synthetic */ a UC;

                AnonymousClass17(a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.kwad.sdk.components.k
                public final void onFailed(Throwable th) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onFailed();
                    }
                    h.this.logTkError(th);
                }

                @Override // com.kwad.sdk.components.k
                public final void onSuccess() {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onSuccess();
                    }
                }
            });
            View view2 = view.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mTKLoadInterface.getTKContainer().addView(view2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
            logTkError(th);
            if (aVar2 != null) {
                aVar2.onFailed();
            }
        }
    }

    public void callbackTkLoadFailed() {
        bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.h.20
            AnonymousClass20() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (h.this.isHasCallJsFailed) {
                    return;
                }
                h.this.isHasCallJsFailed = true;
                h.this.mTKLoadInterface.onTkLoadFailed();
                com.kwad.components.core.webview.a.c.a.rn().aS(h.this.mTKLoadInterface.getTkTemplateId());
            }
        });
    }

    private void doRegisterHandler(l lVar, com.kwad.sdk.core.webview.b.a aVar) {
        lVar.c(aVar);
    }

    private Map<String, Object> getCustomEnv() {
        if (this.mCustomEnv == null) {
            HashMap hashMap = new HashMap();
            this.mCustomEnv = hashMap;
            hashMap.put("TKVersion", "5.0.1");
            this.mCustomEnv.put("SDKVersion", "3.3.40");
            this.mCustomEnv.put("sdkType", 1);
        }
        return this.mCustomEnv;
    }

    private StyleTemplate getStyleTemplateFromAdInfo() {
        StyleTemplate styleTemplate = this.mStyleTemplate;
        if (styleTemplate != null) {
            return styleTemplate;
        }
        AdMatrixInfo.MatrixTemplate c2 = com.kwad.sdk.core.response.a.b.c(obtainAdTemplate(), this.mTKLoadInterface.getTkTemplateId());
        if (c2 == null) {
            return null;
        }
        com.kwad.components.core.offline.api.a.c cVar = this.mTKPlugin;
        if (cVar != null) {
            return cVar.checkStyleTemplateById(this.mContext, c2.templateId, c2.templateMd5, c2.templateUrl, (int) c2.templateVersionCode);
        }
        StyleTemplate styleTemplate2 = new StyleTemplate();
        styleTemplate2.templateId = c2.templateId;
        styleTemplate2.templateMd5 = c2.templateMd5;
        styleTemplate2.templateUrl = c2.templateUrl;
        styleTemplate2.templateVersionCode = (int) c2.templateVersionCode;
        styleTemplate2.tkSouce = 0;
        return styleTemplate2;
    }

    public void handleLoadStyleTemplateFailed(String str) {
        callbackTkLoadFailed();
        logTKEnvNotReady(str);
    }

    public void handleLoadStyleTemplateSuccess(@Nullable StyleTemplate styleTemplate) {
        com.kwad.sdk.utils.i.e("", "renderType_tk", styleTemplate.templateId, styleTemplate.templateUrl);
        com.kwad.sdk.core.d.b.d(TAG, "读取完毕，总耗时" + (SystemClock.elapsedRealtime() - this.mLoadStartTime) + ", 读取成功" + styleTemplate.templateId);
        if (this.hasDownloadTimeout) {
            return;
        }
        com.kwad.sdk.core.d.b.d(TAG, "没有超时");
        bi.b(this.mDownloadTimeoutRunnable);
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.h.12
            final /* synthetic */ StyleTemplate Uu;

            AnonymousClass12(StyleTemplate styleTemplate2) {
                styleTemplate = styleTemplate2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h hVar = h.this;
                hVar.addTKView(styleTemplate, hVar.mTKRenderListenerInner);
            }
        });
    }

    private void initJsBridgeContext() {
        this.jsBridgeContext.mScreenOrientation = !com.kwad.sdk.utils.ai.DL() ? 1 : 0;
        this.jsBridgeContext.app = this.mTKLoadInterface.getTouchCoordsView();
        this.jsBridgeContext.LD = this.mTKLoadInterface.getTKContainer();
        this.jsBridgeContext.Lc = null;
    }

    private void initParam() {
        this.isTkTemplateRenderStart = false;
        this.isTkTemplateRenderComplete = false;
        this.hasDownloadTimeout = false;
        this.isHasCallJsFailed = false;
        this.mLoadStartTime = 0L;
        this.mLoadEndTime = 0L;
        this.mInitTime = 0L;
        this.mRenderStartTime = 0L;
    }

    public void loadStyleTemplateFromAdInfo(TKDownloadListener tKDownloadListener) {
        StyleTemplate styleTemplate = this.mStyleTemplate;
        if (styleTemplate != null) {
            this.mTKPlugin.loadTkFileByTemplateId(this.mContext, styleTemplate.templateId, styleTemplate.templateMd5, styleTemplate.templateUrl, styleTemplate.templateVersionCode, tKDownloadListener);
            return;
        }
        AdMatrixInfo.MatrixTemplate c2 = com.kwad.sdk.core.response.a.b.c(obtainAdTemplate(), this.mTKLoadInterface.getTkTemplateId());
        if (c2 == null) {
            return;
        }
        this.mTKPlugin.loadTkFileByTemplateId(this.mContext, c2.templateId, c2.templateMd5, c2.templateUrl, (int) c2.templateVersionCode, tKDownloadListener);
    }

    private void loadTkStyleTemplate() {
        bi.runOnUiThreadDelay(this.mDownloadTimeoutRunnable, this.tkLoadTimeOut);
        this.mLoadTkFuture = GlobalThreadPools.xR().submit(new Runnable() { // from class: com.kwad.components.core.webview.a.h.1

            /* renamed from: com.kwad.components.core.webview.a.h$1$1 */
            final class C01891 implements TKDownloadListener {
                C01891() {
                }

                @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                public final void onFailed(String str) {
                    h.this.handleLoadStyleTemplateFailed(str);
                }

                @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                public final void onSuccess(@NonNull StyleTemplate styleTemplate) {
                    h.this.handleLoadStyleTemplateSuccess(styleTemplate);
                }
            }

            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                h.this.mLoadStartTime = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.d.b.d(h.TAG, "开始读取模板 id: " + h.this.mTKLoadInterface.getTkTemplateId());
                h.this.loadStyleTemplateFromAdInfo(new TKDownloadListener() { // from class: com.kwad.components.core.webview.a.h.1.1
                    C01891() {
                    }

                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onFailed(String str) {
                        h.this.handleLoadStyleTemplateFailed(str);
                    }

                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onSuccess(@NonNull StyleTemplate styleTemplate) {
                        h.this.handleLoadStyleTemplateSuccess(styleTemplate);
                    }
                });
            }
        });
    }

    private void logEnterTKScene() {
        StyleTemplate styleTemplateFromAdInfo = getStyleTemplateFromAdInfo();
        if (styleTemplateFromAdInfo == null) {
            return;
        }
        this.tkSource = styleTemplateFromAdInfo.tkSouce;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.tkSource).setRenderState(-1).setTemplateId(this.mTKLoadInterface.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateFromAdInfo.templateVersionCode)).toJson());
    }

    private void logTKEnvNotReady(String str) {
        StyleTemplate styleTemplateFromAdInfo = getStyleTemplateFromAdInfo();
        if (styleTemplateFromAdInfo == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.tkSource).setRenderState(4).setErrorReason(str).setTemplateId(this.mTKLoadInterface.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateFromAdInfo.templateVersionCode)).toJson());
    }

    public void logTkDownloadTimeout() {
        com.kwad.sdk.core.d.b.d("tkRender", "logTkRenderFail : timeout, templateId = " + this.mTKLoadInterface.getTkTemplateId());
        StyleTemplate styleTemplateFromAdInfo = getStyleTemplateFromAdInfo();
        if (styleTemplateFromAdInfo == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.tkSource).setRenderState(3).setErrorReason("timeout").setTemplateId(this.mTKLoadInterface.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateFromAdInfo.templateVersionCode)).toJson());
    }

    public void logTkError(Throwable th) {
        com.kwad.sdk.core.d.b.d("tkRender", "logTkRenderFail : " + th + ", templateId = " + this.mTKLoadInterface.getTkTemplateId());
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.tkSource).setRenderState(3).setErrorReason(th.getMessage()).setTemplateId(this.mTKLoadInterface.getTkTemplateId()).setVersionCode(String.valueOf(this.mStyleTemplate.templateVersionCode)).toJson());
    }

    public void logTkRenderFail(String str) {
        com.kwad.sdk.core.d.b.d("tkRender", "logTkRenderFail : " + str + ", templateId = " + this.mTKLoadInterface.getTkTemplateId());
        if (!this.isTkTemplateRenderStart || this.isTkTemplateRenderComplete) {
            return;
        }
        this.isTkTemplateRenderComplete = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.tkSource).setRenderState(2).setErrorReason(str).setTemplateId(this.mTKLoadInterface.getTkTemplateId()).setVersionCode(String.valueOf(this.mStyleTemplate.templateVersionCode)).toJson());
    }

    private void logTkRenderStart() {
        this.isTkTemplateRenderStart = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.tkSource).setRenderState(0).setTemplateId(this.mTKLoadInterface.getTkTemplateId()).setVersionCode(String.valueOf(this.mStyleTemplate.templateVersionCode)).toJson());
    }

    public void logTkRenderSuccess() {
        if (!this.isTkTemplateRenderStart || this.isTkTemplateRenderComplete) {
            return;
        }
        this.isTkTemplateRenderComplete = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.tkSource).setRenderState(1).setRenderTime(this.mRenderStartTime > 0 ? SystemClock.elapsedRealtime() - this.mRenderStartTime : 0L).setTemplateId(this.mTKLoadInterface.getTkTemplateId()).setLoadTime(this.mLoadEndTime - this.mLoadStartTime).setInitTime(this.mInitTime).setVersionCode(String.valueOf(this.mStyleTemplate.templateVersionCode)).toJson());
    }

    public void onFrameValid(ab.a aVar) {
        FrameLayout tKContainer = this.mTKLoadInterface.getTKContainer();
        if (tKContainer != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tKContainer.getLayoutParams();
            layoutParams.height = com.kwad.sdk.c.kwai.a.a(this.mContext, aVar.height);
            layoutParams.leftMargin = com.kwad.sdk.c.kwai.a.a(this.mContext, aVar.leftMargin);
            layoutParams.rightMargin = com.kwad.sdk.c.kwai.a.a(this.mContext, aVar.rightMargin);
            layoutParams.bottomMargin = com.kwad.sdk.c.kwai.a.a(this.mContext, aVar.bottomMargin);
            layoutParams.width = -1;
            tKContainer.setLayoutParams(layoutParams);
        }
    }

    private void registerWebCardHandler(l lVar) {
        com.kwad.components.core.d.b.c cVar = obtainAdTemplate() != null ? new com.kwad.components.core.d.b.c(obtainAdTemplate()) : null;
        this.mTKLoadInterface.onRegisterWebCardHandler(lVar, this.jsBridgeContext);
        s sVar = new s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.a.h.21
            AnonymousClass21() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.s.a
            public final void a(com.kwad.components.core.webview.a.a.t tVar) {
                if (TextUtils.isEmpty(tVar.message)) {
                    return;
                }
                v.d(h.this.mContext, tVar.message, 0L);
            }
        });
        doRegisterHandler(lVar, sVar);
        doRegisterHandler(lVar, createLogHandler(this.jsBridgeContext));
        doRegisterHandler(lVar, new com.kwad.sdk.core.webview.c.a());
        doRegisterHandler(lVar, new com.kwad.components.core.webview.a.kwai.f());
        doRegisterHandler(lVar, new com.kwad.components.core.webview.jshandler.s(this.jsBridgeContext, cVar, this));
        doRegisterHandler(lVar, new com.kwad.components.core.webview.jshandler.r());
        doRegisterHandler(lVar, new com.kwad.components.core.webview.a.kwai.k());
        doRegisterHandler(lVar, new com.kwad.components.core.webview.jshandler.v(this.jsBridgeContext));
        doRegisterHandler(lVar, new y(this.jsBridgeContext));
        com.kwad.components.core.webview.jshandler.u uVar = new com.kwad.components.core.webview.jshandler.u(this.jsBridgeContext);
        uVar.a(new u.b() { // from class: com.kwad.components.core.webview.a.h.22
            AnonymousClass22() {
            }

            @Override // com.kwad.components.core.webview.jshandler.u.b
            public final void a(u.a aVar) {
                h.this.mTKLoadInterface.onGetContainerLimited(aVar);
            }
        });
        doRegisterHandler(lVar, uVar);
        doRegisterHandler(lVar, new ab(this.jsBridgeContext, new ab.b() { // from class: com.kwad.components.core.webview.a.h.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ab.b
            public final void a(ab.a aVar) {
                h.this.onFrameValid(aVar);
            }
        }));
        doRegisterHandler(lVar, new ai(new ai.b() { // from class: com.kwad.components.core.webview.a.h.3
            AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ai.b
            public final void a(ai.a aVar) {
                if (aVar.status != 1) {
                    h.this.callbackTkLoadFailed();
                    h.this.logTkRenderFail(aVar.errorMsg);
                    return;
                }
                h.this.logTkRenderSuccess();
                i iVar = h.this.mTKLoadInterface;
                if (iVar != null) {
                    iVar.onTkLoadSuccess();
                    com.kwad.components.core.webview.a.c.a.rn().aT(h.this.mTKLoadInterface.getTkTemplateId());
                }
            }
        }));
        an anVar = new an();
        doRegisterHandler(lVar, anVar);
        this.mTKLoadInterface.onRegisterLifecycleLisener(anVar);
        doRegisterHandler(lVar, new aq(this.jsBridgeContext, cVar));
        p pVar = new p();
        this.mJSVideoProgress = pVar;
        doRegisterHandler(lVar, pVar);
        this.mTKLoadInterface.onRegisterVideoProgressListener(this.mJSVideoProgress, this.mVideoPlayStateListener);
        if (obtainAdTemplate() != null && com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(obtainAdTemplate()))) {
            com.kwad.components.core.webview.a.kwai.l lVar2 = new com.kwad.components.core.webview.a.kwai.l();
            doRegisterHandler(lVar, lVar2);
            this.mDownloadSyncInterfaceAdapter = new com.kwad.sdk.core.download.e(obtainAdTemplate()) { // from class: com.kwad.components.core.webview.a.h.4
                final /* synthetic */ com.kwad.components.core.webview.a.kwai.l RS;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass4(AdTemplate adTemplate, com.kwad.components.core.webview.a.kwai.l lVar22) {
                    super(adTemplate);
                    lVar2 = lVar22;
                }

                @Override // com.kwad.sdk.core.download.e, com.kwad.sdk.core.download.d
                public final void a(String str, int i2, com.kwad.sdk.core.download.f fVar) {
                    super.a(str, i2, fVar);
                    com.kwad.components.core.webview.a.a.b bVar = new com.kwad.components.core.webview.a.a.b();
                    bVar.UW = 1;
                    lVar2.a(bVar);
                }
            };
            com.kwad.sdk.core.download.c.vu().a(this.mDownloadSyncInterfaceAdapter, obtainAdTemplate());
        }
        com.kwad.components.core.webview.a.kwai.t tVar = new com.kwad.components.core.webview.a.kwai.t();
        tVar.a(new t.a() { // from class: com.kwad.components.core.webview.a.h.5
            AnonymousClass5() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.t.a
            public final void a(com.kwad.components.core.webview.a.a.u uVar2) {
                h.this.mTKLoadInterface.onSkipClick(uVar2);
            }
        });
        doRegisterHandler(lVar, tVar);
        com.kwad.components.core.webview.a.kwai.u uVar2 = new com.kwad.components.core.webview.a.kwai.u();
        uVar2.a(new u.a() { // from class: com.kwad.components.core.webview.a.h.6
            AnonymousClass6() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.u.a
            public final void a(m mVar) {
                h.this.mTKLoadInterface.onUpdateMuteStatus(mVar);
            }
        });
        doRegisterHandler(lVar, uVar2);
        o oVar = new o();
        doRegisterHandler(lVar, oVar);
        this.mTKLoadInterface.onRegisterVideoMuteStateListener(oVar);
        doRegisterHandler(lVar, new r() { // from class: com.kwad.components.core.webview.a.h.7
            AnonymousClass7() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.r
            public final void a(com.kwad.components.core.webview.a.a.s sVar2) {
                super.a(sVar2);
                if (h.this.mActivity == null) {
                    h hVar = h.this;
                    com.kwad.sdk.core.b.b.vS();
                    hVar.mActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
                }
                if (h.this.mActivity == null || h.this.mActivity.isFinishing()) {
                    return;
                }
                if (h.this.mTkDialogFragment != null) {
                    h.this.mTkDialogFragment.dismiss();
                }
                d.b bVar = new d.b();
                bVar.setAdTemplate(h.this.obtainAdTemplate());
                bVar.aP(sVar2.templateId);
                h.this.mTkDialogFragment = com.kwad.components.core.webview.a.b.d.b(bVar);
                h.this.mTkDialogFragment.show(h.this.mActivity.getFragmentManager(), "");
            }
        });
        doRegisterHandler(lVar, new com.kwad.components.core.webview.a.kwai.c() { // from class: com.kwad.components.core.webview.a.h.8
            AnonymousClass8() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.c
            public final void iT() {
                super.iT();
                if (h.this.mTkDialogFragment != null) {
                    h.this.mTkDialogFragment.dismiss();
                }
                i iVar = h.this.mTKLoadInterface;
                if (iVar != null) {
                    iVar.onCloseTKDialogClick();
                }
            }
        });
        doRegisterHandler(lVar, new q(new com.kwad.sdk.core.webview.c.kwai.b() { // from class: com.kwad.components.core.webview.a.h.9
            AnonymousClass9() {
            }

            @Override // com.kwad.sdk.core.webview.c.kwai.b
            public final void a(WebCloseStatus webCloseStatus) {
                h.this.mTKLoadInterface.pageClose(webCloseStatus);
            }
        }));
        doRegisterHandler(lVar, new com.kwad.components.core.webview.a.kwai.d() { // from class: com.kwad.components.core.webview.a.h.10
            AnonymousClass10() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.d
            public final void a(com.kwad.components.core.webview.a.a.g gVar) {
                super.a(gVar);
                com.kwad.components.core.m.a.pb().a(gVar.Tr, h.this.obtainAdTemplate(), gVar.Ts);
            }
        });
        doRegisterHandler(lVar, new com.kwad.components.core.webview.a.kwai.j() { // from class: com.kwad.components.core.webview.a.h.11
            AnonymousClass11() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.j
            public final void a(n nVar) {
                super.a(nVar);
                AdWebViewActivityProxy.launch(h.this.mContext, new AdWebViewActivityProxy.a.C0182a().au(nVar.title).av(nVar.url).aA(true).L(h.this.obtainAdTemplate()).oc());
            }
        });
        doRegisterHandler(lVar, new com.kwad.components.core.webview.a.kwai.a(obtainAdTemplate()));
        doRegisterHandler(lVar, new com.kwad.components.core.webview.a.a(obtainAdTemplate()));
        onRegisterWebCardHandler(this.jsBridgeContext, cVar, lVar, this.mTKLoadInterface.getTKContainer());
    }

    private void uploadCovData() {
        if (this.mTKPlugin == null || this.mTKView == null) {
            return;
        }
        File file = new File(new File(this.mTKPlugin.getJsBaseDir(this.mContext, this.mTKLoadInterface.getTkTemplateId())), "kcov.json");
        if (file.exists()) {
            try {
                String Q = com.kwad.sdk.utils.q.Q(file);
                if (TextUtils.isEmpty(Q)) {
                    return;
                }
                com.kwad.sdk.core.d.b.d(TAG, "kcov.json:" + Q);
                JSONObject jSONObject = new JSONObject(Q);
                String string = jSONObject.getString("gitHeadCommit");
                String string2 = jSONObject.getString("coverageApi");
                String string3 = jSONObject.getString("coverageTaskId");
                String string4 = jSONObject.getString("currentBranch");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    com.kwad.sdk.core.d.b.d(TAG, "尝试获取覆盖率统计...");
                    Object execute = this.mTKView.execute("JSON.stringify(this.__coverage__)");
                    if (execute instanceof String) {
                        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.core.webview.a.h.15
                            final /* synthetic */ String UA;
                            final /* synthetic */ String Uw;
                            final /* synthetic */ String Ux;
                            final /* synthetic */ String Uy;
                            final /* synthetic */ String Uz;

                            /* renamed from: com.kwad.components.core.webview.a.h$15$1 */
                            final class AnonymousClass1 implements AdHttpBodyBuilder {
                                AnonymousClass1() {
                                }

                                @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
                                public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                                    adHttpFormDataBuilder.addFormDataPart(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID, string3);
                                    adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                                    adHttpFormDataBuilder.addFormDataPart("os_build_serial", EnvironmentCompat.MEDIA_UNKNOWN);
                                    adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                                    adHttpFormDataBuilder.addFormDataPart("app_version", "3.3.40");
                                    adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                                    adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                                    adHttpFormDataBuilder.addFormDataPart("uid", "");
                                    adHttpFormDataBuilder.addFormDataPart("did", au.getDeviceId());
                                    adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                                    adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                                    try {
                                        adHttpFormDataBuilder.addFormDataPart("file", UUID.randomUUID().toString() + ".json", "application/octet-stream", str.getBytes("UTF-8"));
                                    } catch (UnsupportedEncodingException e22) {
                                        com.kwad.sdk.core.d.b.printStackTrace(e22);
                                    }
                                }
                            }

                            AnonymousClass15(String string32, String string42, String string22, String string5, String str5) {
                                string3 = string32;
                                string4 = string42;
                                string2 = string22;
                                string = string5;
                                str = str5;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                String str;
                                String str2;
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("coverage_task_id", Integer.valueOf(string3));
                                    jSONObject2.put("user", "");
                                    jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
                                    jSONObject2.put("branch_name", string4);
                                    jSONObject2.put("version", "3.3.40");
                                    jSONObject2.put("tk_version", String.valueOf(h.this.mStyleTemplate.templateVersionCode));
                                    jSONObject2.put("tk_template_ids", h.this.mStyleTemplate.templateId);
                                } catch (JSONException e2) {
                                    com.kwad.sdk.core.d.b.printStackTrace(e2);
                                }
                                com.kwad.sdk.core.network.c doPost = com.kwad.sdk.b.rZ().doPost(string2 + "/analysis/add/pkg/info", (Map<String, String>) null, jSONObject2);
                                if (doPost.wb()) {
                                    str = "上传TK覆盖率pkg完成:" + doPost.agf;
                                } else {
                                    str = "上传覆盖率pkg失败";
                                }
                                com.kwad.sdk.core.d.b.d(h.TAG, str);
                                com.kwad.sdk.core.network.c doPost2 = com.kwad.sdk.b.rZ().doPost(string2 + "/attachment/ec", (Map<String, String>) null, new AdHttpBodyBuilder() { // from class: com.kwad.components.core.webview.a.h.15.1
                                    AnonymousClass1() {
                                    }

                                    @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
                                    public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                                        adHttpFormDataBuilder.addFormDataPart(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID, string3);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_serial", EnvironmentCompat.MEDIA_UNKNOWN);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                                        adHttpFormDataBuilder.addFormDataPart("app_version", "3.3.40");
                                        adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                                        adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                                        adHttpFormDataBuilder.addFormDataPart("uid", "");
                                        adHttpFormDataBuilder.addFormDataPart("did", au.getDeviceId());
                                        adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                                        adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                                        try {
                                            adHttpFormDataBuilder.addFormDataPart("file", UUID.randomUUID().toString() + ".json", "application/octet-stream", str.getBytes("UTF-8"));
                                        } catch (UnsupportedEncodingException e22) {
                                            com.kwad.sdk.core.d.b.printStackTrace(e22);
                                        }
                                    }
                                });
                                if (doPost2.wb()) {
                                    str2 = "上传TK覆盖率完成:" + doPost2.agf;
                                } else {
                                    str2 = "上传TK覆盖率失败";
                                }
                                com.kwad.sdk.core.d.b.d(h.TAG, str2);
                            }
                        });
                        return;
                    }
                    return;
                }
                com.kwad.sdk.core.d.b.d(TAG, "kcov.json数据不合法，缺少关键字段gitHeadCommit | coverageApi | coverageTaskId | currentBranch");
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
    }

    public void addCustomEnv(String str, Object obj) {
        getCustomEnv().put(str, obj);
    }

    public void bind(@Nullable Activity activity, AdTemplate adTemplate, i iVar) {
        this.mActivity = activity;
        this.mAdTemplate = adTemplate;
        this.jsBridgeContext.setAdTemplate(adTemplate);
        this.mTKLoadInterface = iVar;
        initParam();
        FrameLayout tKContainer = this.mTKLoadInterface.getTKContainer();
        if (tKContainer != null) {
            tKContainer.removeAllViews();
        }
        if (!com.kwad.sdk.core.config.d.isCanUseTk()) {
            callbackTkLoadFailed();
            return;
        }
        this.mTKPlugin = (com.kwad.components.core.offline.api.a.c) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.a.c.class);
        logEnterTKScene();
        com.kwad.sdk.core.d.b.d(TAG, "bind mTKPlugin: " + this.mTKPlugin);
        if (this.mTKPlugin != null) {
            loadTkStyleTemplate();
        } else {
            callbackTkLoadFailed();
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.tkSource).setRenderState(4).setErrorReason(TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED).setTemplateId(this.mTKLoadInterface.getTkTemplateId()).toJson());
        }
    }

    @Override // com.kwad.sdk.components.i
    public void callJS(String str) {
        l lVar = this.mTKView;
        if (lVar != null) {
            lVar.a(str, null, null);
        }
    }

    protected ac createLogHandler(com.kwad.sdk.core.webview.b bVar) {
        return new ac(bVar);
    }

    public com.kwad.sdk.core.webview.b getJsBridgeContext() {
        return this.jsBridgeContext;
    }

    protected AdTemplate obtainAdTemplate() {
        return this.jsBridgeContext.getAdTemplate();
    }

    @Override // com.kwad.sdk.core.webview.c.kwai.a
    public void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
        i iVar = this.mTKLoadInterface;
        if (iVar != null) {
            iVar.onAdClicked(aVar);
        }
    }

    protected void onRegisterWebCardHandler(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, l lVar, ViewGroup viewGroup) {
    }

    public void resetAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null || this.mTKView == null) {
            return;
        }
        this.mAdTemplate = adTemplate;
        this.jsBridgeContext.setAdTemplate(adTemplate);
        com.kwad.components.core.offline.api.a.kwai.a.a(this.mTKView.getUniqId(), adTemplate);
        this.mTKView.unregisterJsBridge();
        registerWebCardHandler(this.mTKView);
    }

    public void setStyleTemplate(StyleTemplate styleTemplate) {
        this.mStyleTemplate = styleTemplate;
    }

    public void setTKBridgeHandler(com.kwad.sdk.core.webview.b.g gVar) {
        this.mTKBridgeHandler = gVar;
    }

    public void unBind() {
        Future<?> future = this.mLoadTkFuture;
        if (future != null) {
            future.cancel(true);
        }
        bi.b(this.mDownloadTimeoutRunnable);
        if (this.mDownloadSyncInterfaceAdapter != null) {
            com.kwad.sdk.core.download.c.vu().a(this.mDownloadSyncInterfaceAdapter);
        }
        com.kwad.components.core.webview.a.b.d dVar = this.mTkDialogFragment;
        if (dVar != null) {
            dVar.dismiss();
        }
        if (com.kwad.components.core.a.bI.booleanValue()) {
            uploadCovData();
        }
        com.kwad.components.core.offline.api.a.c cVar = this.mTKPlugin;
        if (cVar != null) {
            cVar.onDestroy();
        }
        l lVar = this.mTKView;
        if (lVar != null) {
            com.kwad.components.core.offline.api.a.kwai.a.aw(lVar.getUniqId());
            this.mTKView = null;
            bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.h.14
                final /* synthetic */ l Uv;

                AnonymousClass14(l lVar2) {
                    lVar = lVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    l lVar2 = lVar;
                    if (lVar2 != null) {
                        lVar2.onDestroy();
                    }
                }
            });
        }
    }
}
