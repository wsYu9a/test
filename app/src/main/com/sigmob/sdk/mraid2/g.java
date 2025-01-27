package com.sigmob.sdk.mraid2;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.DownloadItem;
import com.czhj.volley.toolbox.FileDownloadRequest;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.r;
import com.sigmob.sdk.base.common.u;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.mraid.o;
import com.sigmob.sdk.mraid2.c;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class g extends com.sigmob.sdk.mraid2.a {

    /* renamed from: x */
    public static String f19757x = "Mraid2Bridge";

    /* renamed from: y */
    public static HashMap<String, g> f19758y = new LinkedHashMap();

    /* renamed from: f */
    public final g f19759f;

    /* renamed from: g */
    public com.sigmob.sdk.mraid2.c f19760g;

    /* renamed from: h */
    public g f19761h;

    /* renamed from: i */
    public String f19762i;

    /* renamed from: j */
    public f f19763j;

    /* renamed from: k */
    public e f19764k;

    /* renamed from: l */
    public d f19765l;

    /* renamed from: m */
    public boolean f19766m;

    /* renamed from: n */
    public FrameLayout f19767n;

    /* renamed from: o */
    public LinearLayout f19768o;

    /* renamed from: p */
    public boolean f19769p;

    /* renamed from: q */
    public JSONObject f19770q;

    /* renamed from: r */
    public BaseAdUnit f19771r;

    /* renamed from: s */
    public final com.sigmob.sdk.mraid2.h f19772s;

    /* renamed from: t */
    public com.sigmob.sdk.base.common.g f19773t;

    /* renamed from: u */
    public HashMap<String, n> f19774u;

    /* renamed from: v */
    public com.sigmob.sdk.mraid2.f f19775v;

    /* renamed from: w */
    public final c.f f19776w;

    public class a extends com.sigmob.sdk.mraid2.h {

        /* renamed from: com.sigmob.sdk.mraid2.g$a$a */
        public class C0606a implements ValueCallback {
            public C0606a() {
            }

            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Object obj) {
                a.this.b();
            }
        }

        public a() {
        }

        public final void b() {
            if (g.this.f19760g != null) {
                if (g.this.f19770q != null) {
                    g.this.f19760g.a(g.this.f19770q);
                }
                g.this.f19760g.j();
            }
            if (g.this.f19759f != null && g.this.f19759f.getMraidBridge() != null && !TextUtils.isEmpty(g.this.f19762i)) {
                g.this.f19759f.getMraidBridge().g(g.this.f19762i);
            }
            if (g.this.f19766m) {
                return;
            }
            g.this.f19766m = true;
            if (g.this.f19765l != null) {
                g.this.f19765l.a(g.this.f19761h);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            Log.d(g.f19757x, g.this.f19770q + "-----------onPageFinished---------" + str);
            if (g.this.f19760g.h()) {
                b();
            } else {
                g.this.f19760g.a(com.sigmob.sdk.mraid2.h.f19792l, new C0606a());
            }
        }

        @Override // com.sigmob.sdk.base.h, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.sigmob.sdk.base.h, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            b0.a("h5_error", "mraid2", i10, str2 + " error:" + str, (WindAdRequest) null, (LoadAdRequest) null, g.this.getAdUnitList().get(0), (b0.g) null);
            if (g.this.f19759f == null || g.this.f19759f.getMraidBridge() == null || TextUtils.isEmpty(g.this.f19762i)) {
                return;
            }
            g.this.f19759f.getMraidBridge().a(g.this.f19762i, i10, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            b0.a("h5_error", "mraid2", webResourceResponse.getStatusCode(), webResourceRequest.getUrl().toString(), (WindAdRequest) null, (LoadAdRequest) null, g.this.getAdUnitList().get(0), (b0.g) null);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            WindAdError windAdError;
            boolean didCrash;
            Log.d(g.f19757x, "-----------onRenderProcessGone---------" + renderProcessGoneDetail);
            if (Build.VERSION.SDK_INT >= 26) {
                if (renderProcessGoneDetail != null) {
                    didCrash = renderProcessGoneDetail.didCrash();
                    if (didCrash) {
                        windAdError = WindAdError.RENDER_PROCESS_GONE_WITH_CRASH;
                    }
                }
                windAdError = WindAdError.RENDER_PROCESS_GONE_UNSPECIFIED;
            } else {
                windAdError = null;
            }
            SigmobLog.e("handleRenderProcessGone " + windAdError);
            if (g.this.f19765l != null) {
                g.this.f19765l.a(windAdError);
            }
            g.this.b();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int i10;
            int i11;
            if (str == null) {
                return false;
            }
            try {
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (!str.startsWith("http") && !str.startsWith("https")) {
                if (g.this.f19771r != null) {
                    List<String> list = g.this.f19771r.getAdSetting() != null ? g.this.f19771r.getAdSetting().scheme_white_list : null;
                    if (list != null && list.size() > 0) {
                        while (i11 < list.size()) {
                            String str2 = list.get(i11);
                            i11 = (str.startsWith(str2) || str2.equals(m5.h.f28447r)) ? 0 : i11 + 1;
                            u.a(g.this.getContext(), Uri.parse(str));
                            return true;
                        }
                    }
                } else {
                    for (int i12 = 0; i12 < g.this.getAdUnitList().size(); i12++) {
                        BaseAdUnit baseAdUnit = g.this.getAdUnitList().get(i12);
                        List<String> list2 = baseAdUnit.getAdSetting() != null ? baseAdUnit.getAdSetting().scheme_white_list : null;
                        if (list2 != null && list2.size() > 0) {
                            while (i10 < list2.size()) {
                                String str3 = list2.get(i10);
                                i10 = (str.startsWith(str3) || str3.equals(m5.h.f28447r)) ? 0 : i10 + 1;
                                u.a(g.this.getContext(), Uri.parse(str));
                                return true;
                            }
                        }
                    }
                }
                return true;
            }
            webView.loadUrl(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            CharSequence description;
            int errorCode;
            CharSequence description2;
            SigmobLog.i("onReceivedError:" + webResourceError.toString());
            if (Build.VERSION.SDK_INT >= 23) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(webResourceRequest.getUrl());
                sb2.append(" error:");
                description = webResourceError.getDescription();
                sb2.append((Object) description);
                b0.a("h5_error", "mraid2", 0, sb2.toString(), (WindAdRequest) null, (LoadAdRequest) null, g.this.getAdUnitList().get(0), (b0.g) null);
                if (g.this.f19759f == null || g.this.f19759f.getMraidBridge() == null || TextUtils.isEmpty(g.this.f19762i)) {
                    return;
                }
                com.sigmob.sdk.mraid2.c mraidBridge = g.this.f19759f.getMraidBridge();
                String str = g.this.f19762i;
                errorCode = webResourceError.getErrorCode();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                description2 = webResourceError.getDescription();
                sb3.append((Object) description2);
                mraidBridge.a(str, errorCode, sb3.toString());
            }
        }
    }

    public class b implements FileDownloadRequest.FileDownloadListener {

        /* renamed from: a */
        public final /* synthetic */ File f19779a;

        public b(File file) {
            this.f19779a = file;
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void downloadProgress(DownloadItem downloadItem, long j10, long j11) {
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onCancel(DownloadItem downloadItem) {
            Log.d(g.f19757x, "-----------onCancel----------" + downloadItem.url);
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onErrorResponse(DownloadItem downloadItem) {
            Log.d(g.f19757x, "-----------onErrorResponse----------" + downloadItem.url);
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onSuccess(DownloadItem downloadItem) {
            Log.d(g.f19757x, downloadItem.url + "-----------onSuccess----------" + downloadItem.filePath);
            try {
                com.sigmob.sdk.base.utils.b.a(new File(downloadItem.filePath), new File(downloadItem.filePath.replace(".tgz", "/")));
                if (this.f19779a.exists()) {
                    g.this.f19761h.a("file://" + this.f19779a.getAbsolutePath());
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public class c implements c.f {

        public class a implements o.c {
            public a() {
            }

            @Override // com.sigmob.sdk.mraid.o.c
            public void a(String str, int i10, String str2) {
                if (g.this.f19760g != null) {
                    g.this.f19760g.b(str, "code:" + i10 + ", msg:" + str2);
                }
                b0.a("video", i10, str2, g.this.f19771r);
            }

            @Override // com.sigmob.sdk.mraid.o.c
            public void b(String str, int i10) {
                if (g.this.f19760g != null) {
                    g.this.f19760g.a(str, i10);
                }
            }

            @Override // com.sigmob.sdk.mraid.o.c
            public void a(String str, long j10) {
                if (g.this.f19760g != null) {
                    g.this.f19760g.b(str, (int) j10);
                }
            }

            @Override // com.sigmob.sdk.mraid.o.c
            public void a(String str, int i10) {
                if (g.this.f19760g != null) {
                    g.this.f19760g.c(str, i10);
                }
            }

            @Override // com.sigmob.sdk.mraid.o.c
            public void a(String str, long j10, long j11) {
                if (g.this.f19760g != null) {
                    g.this.f19760g.a(str, (int) j10, (int) j11);
                }
            }

            @Override // com.sigmob.sdk.mraid.o.c
            public void a(String str, long j10, int i10, int i11) {
                if (g.this.f19760g != null) {
                    g.this.f19760g.a(str, (int) j10, i10, i11);
                }
            }
        }

        public class b implements Animator.AnimatorListener {

            /* renamed from: a */
            public final /* synthetic */ String f19783a;

            public b(String str) {
                this.f19783a = str;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                g.this.f19760g.d(this.f19783a);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        /* renamed from: com.sigmob.sdk.mraid2.g$c$c */
        public class C0607c implements i {
            public C0607c() {
            }

            @Override // com.sigmob.sdk.mraid2.i
            public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
                if (g.this.f19760g != null) {
                    g.this.f19760g.a(str, str2, str3, hashMap);
                }
            }
        }

        public class d implements i {
            public d() {
            }

            @Override // com.sigmob.sdk.mraid2.i
            public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
                if (g.this.f19760g != null) {
                    g.this.f19760g.a(str, str2, str3, hashMap);
                }
            }
        }

        public class e implements i {
            public e() {
            }

            @Override // com.sigmob.sdk.mraid2.i
            public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
                if (g.this.f19760g != null) {
                    g.this.f19760g.a(str, str2, str3, hashMap);
                }
            }
        }

        public c() {
        }

        @Override // com.sigmob.sdk.mraid2.c.f
        public void a(JSONObject jSONObject) {
            ViewGroup viewGroup;
            String optString = jSONObject.optString("uniqueId");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.f19688e.get(optString);
            if (jVar != null) {
                jVar.a(g.this.f19762i);
                View c10 = jVar.c();
                if (c10 != null) {
                    com.sigmob.sdk.base.utils.e.e(c10);
                    if (!g.this.f19769p || g.this.f19768o == null) {
                        viewGroup = g.this.f19767n;
                    } else {
                        c10.setX(0.0f);
                        c10.setY(0.0f);
                        viewGroup = g.this.f19768o;
                    }
                    viewGroup.addView(c10);
                }
            }
            g gVar = (g) g.f19758y.get(optString);
            if (gVar != null) {
                com.sigmob.sdk.base.utils.e.e(gVar);
                g.this.f19767n.addView(gVar);
            }
        }

        @Override // com.sigmob.sdk.mraid2.c.f
        public void b() {
            if (g.this.f19764k != null) {
                g.this.f19764k.b();
            }
        }

        @Override // com.sigmob.sdk.mraid2.c.f
        public void c() {
            for (com.sigmob.sdk.mraid.j jVar : com.sigmob.sdk.mraid2.a.f19688e.values()) {
                if (!TextUtils.isEmpty(jVar.b()) && jVar.b().equals(g.this.f19762i)) {
                    com.sigmob.sdk.base.utils.e.e(jVar.c());
                    jVar.a();
                }
            }
            com.sigmob.sdk.base.utils.e.e(g.this.f19761h);
            if (g.this.f19774u != null && g.this.f19774u.size() > 0) {
                Iterator it = g.this.f19774u.values().iterator();
                while (it.hasNext()) {
                    ((n) it.next()).c();
                }
                g.this.f19774u.clear();
            }
            if (g.this.f19761h != null) {
                g.this.f19761h = null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0179  */
        /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
        @Override // com.sigmob.sdk.mraid2.c.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void d(org.json.JSONObject r28) {
            /*
                Method dump skipped, instructions count: 470
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid2.g.c.d(org.json.JSONObject):void");
        }

        @Override // com.sigmob.sdk.mraid2.c.f
        public void e(JSONObject jSONObject) {
            String optString = jSONObject.optString("uniqueId");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.f19688e.get(optString);
            if (jVar != null) {
                jVar.a(g.this.f19762i);
                View c10 = jVar.c();
                if (c10 != null) {
                    com.sigmob.sdk.base.utils.e.e(c10);
                    if (!g.this.f19769p || g.this.f19768o == null) {
                        g.this.f19767n.addView(c10);
                        g.this.f19767n.bringChildToFront(g.this.f19761h);
                    } else {
                        c10.setX(0.0f);
                        c10.setY(0.0f);
                        g.this.f19768o.addView(c10);
                    }
                }
            }
            g gVar = (g) g.f19758y.get(optString);
            if (gVar != null) {
                com.sigmob.sdk.base.utils.e.e(gVar);
                g.this.f19767n.addView(gVar);
                g.this.f19767n.bringChildToFront(g.this.f19761h);
            }
        }

        @Override // com.sigmob.sdk.mraid2.c.f
        public void f(JSONObject jSONObject) {
            com.sigmob.sdk.mraid2.f fVar;
            com.sigmob.sdk.mraid2.f fVar2;
            SigmobLog.d(" postMessage data:" + jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("args");
            String optString = optJSONObject != null ? optJSONObject.optString("uniqueId") : null;
            String optString2 = jSONObject.optString("subEvent");
            if (TextUtils.isEmpty(optString)) {
                SigmobLog.e(" onMotionViewEvent uniqueId is null:" + optJSONObject);
                return;
            }
            com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.f19688e.get(optString);
            fVar = jVar instanceof com.sigmob.sdk.mraid2.f ? (com.sigmob.sdk.mraid2.f) jVar : null;
            optString2.hashCode();
            switch (optString2) {
                case "init_sensitivity_raw":
                    String optString3 = optJSONObject.optString("type", "");
                    int optInt = optJSONObject.optInt("sensitivity_raw", 0);
                    fVar2 = new com.sigmob.sdk.mraid2.f(optString, optString3);
                    fVar2.a(new d());
                    fVar2.b(optInt);
                    break;
                case "init":
                    String optString4 = optJSONObject.optString("type", "");
                    int optInt2 = optJSONObject.optInt("sensitivity", 0);
                    fVar2 = new com.sigmob.sdk.mraid2.f(optString, optString4);
                    fVar2.a(new C0607c());
                    fVar2.a(optInt2);
                    break;
                case "destroy":
                    if (fVar != null) {
                        fVar.a();
                    }
                    com.sigmob.sdk.mraid2.a.f19688e.remove(optString);
                    return;
                default:
                    return;
            }
            fVar2.h();
            com.sigmob.sdk.mraid2.a.f19688e.put(optString, fVar2);
        }

        @Override // com.sigmob.sdk.mraid2.c.f
        public void g(JSONObject jSONObject) {
            com.sigmob.sdk.mraid.h hVar;
            SigmobLog.d(" postMessage data:" + jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("args");
            String optString = optJSONObject != null ? optJSONObject.optString("uniqueId") : null;
            String optString2 = jSONObject.optString("subEvent");
            if (TextUtils.isEmpty(optString)) {
                SigmobLog.e(" onMotionViewEvent uniqueId is null:" + optJSONObject);
            }
            com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.f19688e.get(optString);
            hVar = jVar instanceof com.sigmob.sdk.mraid.h ? (com.sigmob.sdk.mraid.h) jVar : null;
            optString2.hashCode();
            switch (optString2) {
                case "hidden":
                    if (hVar != null) {
                        hVar.a(optJSONObject.optBoolean("hidden"));
                        break;
                    }
                    break;
                case "init":
                    com.sigmob.sdk.mraid.h hVar2 = new com.sigmob.sdk.mraid.h(com.sigmob.sdk.a.d(), optString, optJSONObject.optInt("type"));
                    hVar2.a(new e());
                    com.sigmob.sdk.mraid2.a.f19688e.put(optString, hVar2);
                    break;
                case "frame":
                    if (hVar != null) {
                        hVar.i(optJSONObject);
                        break;
                    }
                    break;
                case "start":
                    if (hVar != null) {
                        hVar.d();
                        break;
                    }
                    break;
                case "sensitivity":
                    if (hVar != null) {
                        hVar.a(optJSONObject.optInt("sensitivity"));
                        break;
                    }
                    break;
                case "destroy":
                    if (hVar != null) {
                        hVar.a();
                    }
                    com.sigmob.sdk.mraid2.a.f19688e.remove(optString);
                    break;
                case "sensitivity_raw":
                    if (hVar != null) {
                        hVar.b(optJSONObject.optInt("sensitivity_raw"));
                        break;
                    }
                    break;
            }
        }

        @Override // com.sigmob.sdk.mraid2.c.f
        public void a() {
            if (g.this.f19764k != null) {
                g.this.f19764k.a(g.this.f19761h);
            }
        }

        @Override // com.sigmob.sdk.mraid2.c.f
        public void b(String str, JSONObject jSONObject) {
            n nVar;
            SigmobLog.d(" onTimerEvent :" + str + ":" + jSONObject);
            String optString = jSONObject.optString("uniqueId");
            if (TextUtils.isEmpty(optString)) {
            }
            nVar = (n) g.this.f19774u.get(optString);
            str.hashCode();
            switch (str) {
                case "invalidate":
                    if (nVar != null) {
                        nVar.c();
                    }
                    g.this.f19774u.remove(optString);
                    break;
                case "fire":
                    if (nVar != null) {
                        nVar.a();
                        break;
                    }
                    break;
                case "init":
                    g.this.f19774u.put(optString, new n(g.this.f19760g, jSONObject));
                    break;
                case "pause":
                    if (nVar != null) {
                        nVar.d();
                        break;
                    }
                    break;
            }
        }

        @Override // com.sigmob.sdk.mraid2.c.f
        public void c(JSONObject jSONObject) {
            if (g.this.f19764k != null) {
                g.this.f19764k.a(g.this.f19761h, jSONObject);
            }
        }

        @Override // com.sigmob.sdk.mraid2.c.f
        public void d() {
            if (g.this.f19764k != null) {
                g.this.f19764k.b(g.this.f19761h);
            }
        }

        @Override // com.sigmob.sdk.mraid2.c.f
        public void a(String str, JSONObject jSONObject) {
            com.sigmob.sdk.mraid.o oVar;
            SigmobLog.d(" onVpaidEvent :" + str + ":" + jSONObject);
            String optString = jSONObject.optString("uniqueId");
            if (TextUtils.isEmpty(optString)) {
            }
            com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.f19688e.get(optString);
            oVar = jVar instanceof com.sigmob.sdk.mraid.o ? (com.sigmob.sdk.mraid.o) jVar : null;
            str.hashCode();
            switch (str) {
                case "replay":
                    if (oVar != null) {
                        oVar.h(jSONObject);
                        break;
                    }
                    break;
                case "assetURL":
                    if (oVar != null) {
                        oVar.d(jSONObject);
                        break;
                    }
                    break;
                case "init":
                    com.sigmob.sdk.mraid.o oVar2 = new com.sigmob.sdk.mraid.o(optString);
                    oVar2.a(new a());
                    oVar2.a(g.this.getContext(), jSONObject);
                    View c10 = oVar2.c();
                    if (c10 != null) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
                        layoutParams.topMargin = 0;
                        layoutParams.rightMargin = 0;
                        c10.setLayoutParams(layoutParams);
                    }
                    com.sigmob.sdk.mraid2.a.f19688e.put(optString, oVar2);
                    break;
                case "play":
                    if (oVar != null) {
                        oVar.a(jSONObject);
                        break;
                    }
                    break;
                case "seek":
                    if (oVar != null) {
                        oVar.f(jSONObject);
                        break;
                    }
                    break;
                case "stop":
                    if (oVar != null) {
                        oVar.b(jSONObject);
                        oVar.a();
                        com.sigmob.sdk.mraid2.a.f19688e.remove(oVar);
                        break;
                    }
                    break;
                case "frame":
                    if (oVar != null) {
                        oVar.e(jSONObject);
                        break;
                    }
                    break;
                case "muted":
                    if (oVar != null) {
                        oVar.c(jSONObject);
                        break;
                    }
                    break;
                case "pause":
                    if (oVar != null) {
                        oVar.g(jSONObject);
                        break;
                    }
                    break;
            }
        }

        @Override // com.sigmob.sdk.mraid2.c.f
        public void b(JSONObject jSONObject) {
            g.this.f19769p = true;
            int optInt = jSONObject.optInt("flag");
            if (g.this.f19764k == null || g.this.f19768o != null) {
                return;
            }
            g gVar = g.this;
            gVar.f19768o = gVar.f19764k.a(g.this.f19761h, optInt);
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < g.this.f19767n.getChildCount(); i10++) {
                View childAt = g.this.f19767n.getChildAt(i10);
                if (childAt instanceof com.sigmob.sdk.mraid.m) {
                    arrayList.add((com.sigmob.sdk.mraid.m) childAt);
                }
            }
            Log.d(g.f19757x, "-------------onUseScrollView----------" + arrayList.size());
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                com.sigmob.sdk.mraid.m mVar = (com.sigmob.sdk.mraid.m) arrayList.get(i11);
                mVar.setX(0.0f);
                mVar.setY(0.0f);
                com.sigmob.sdk.base.utils.e.e(mVar);
                g.this.f19768o.addView(mVar);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.sigmob.sdk.mraid2.c.f
        public void c(String str, JSONObject jSONObject) {
            char c10;
            SigmobLog.d(" onWebViewEvent :" + str + ":" + jSONObject);
            String optString = jSONObject.optString("uniqueId");
            if (TextUtils.isEmpty(optString)) {
            }
            g gVar = (g) g.f19758y.get(optString);
            str.hashCode();
            switch (str.hashCode()) {
                case -1435435774:
                    if (str.equals("loadHTMLString")) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1097519967:
                    if (str.equals(Constants.LOAD_ID)) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -948122918:
                    if (str.equals("stopLoading")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -934641255:
                    if (str.equals("reload")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 3237136:
                    if (str.equals(PointCategory.INIT)) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 97692013:
                    if (str.equals(TypedValues.AttributesType.S_FRAME)) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 336630441:
                    if (str.equals("loadURL")) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 723516230:
                    if (str.equals("loadURLByPackage")) {
                        c10 = 7;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    String optString2 = jSONObject.optString(com.baidu.mobads.sdk.internal.a.f6640f);
                    if (gVar != null && !TextUtils.isEmpty(optString2)) {
                        gVar.c(optString2);
                        break;
                    }
                    break;
                case 1:
                    String optString3 = jSONObject.optString("id");
                    if (gVar != null && !TextUtils.isEmpty(optString3)) {
                        gVar.d(optString3);
                        break;
                    }
                    break;
                case 2:
                    if (gVar != null) {
                        gVar.k();
                        break;
                    }
                    break;
                case 3:
                    if (gVar != null) {
                        gVar.i();
                        break;
                    }
                    break;
                case 4:
                    if (g.this.f19764k != null) {
                        g.f19758y.put(optString, g.this.f19764k.b(g.this.f19761h, jSONObject));
                        break;
                    }
                    break;
                case 5:
                    if (gVar != null) {
                        JSONObject optJSONObject = jSONObject.optJSONObject(TypedValues.AttributesType.S_FRAME);
                        int optInt = optJSONObject.optInt("x", 0);
                        int optInt2 = optJSONObject.optInt("y", 0);
                        int optInt3 = optJSONObject.optInt(IAdInterListener.AdReqParam.WIDTH, -1);
                        int optInt4 = optJSONObject.optInt("h", -1);
                        if (optInt3 > 0) {
                            optInt3 = Dips.dipsToIntPixels(optInt3, com.sigmob.sdk.a.d());
                        }
                        if (optInt4 > 0) {
                            optInt4 = Dips.dipsToIntPixels(optInt4, com.sigmob.sdk.a.d());
                        }
                        gVar.setLayoutParams(new FrameLayout.LayoutParams(optInt3, optInt4));
                        gVar.setX(Dips.dipsToIntPixels(optInt, com.sigmob.sdk.a.d()));
                        gVar.setY(Dips.dipsToIntPixels(optInt2, com.sigmob.sdk.a.d()));
                        gVar.requestLayout();
                        break;
                    }
                    break;
                case 6:
                    String optString4 = jSONObject.optString("url");
                    if (gVar != null) {
                        gVar.e(optString4);
                        break;
                    }
                    break;
                case 7:
                    String optString5 = jSONObject.optString("URL");
                    if (gVar != null && !TextUtils.isEmpty(optString5)) {
                        gVar.f(optString5);
                        break;
                    }
                    break;
            }
        }

        @Override // com.sigmob.sdk.mraid2.c.f
        public void a(BaseAdUnit baseAdUnit, JSONObject jSONObject) {
            if (g.this.f19764k != null) {
                g.this.f19764k.a(g.this.f19761h, baseAdUnit, jSONObject);
            }
        }

        @Override // com.sigmob.sdk.mraid2.c.f
        public void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                for (int i10 = 0; i10 < g.this.getAdUnitList().size(); i10++) {
                    g gVar = g.this;
                    gVar.f19771r = gVar.getAdUnitList().get(i10);
                    if (str.equals(g.this.f19771r.getVid())) {
                        break;
                    }
                }
            }
            if (g.this.f19771r != null) {
                com.sigmob.sdk.base.common.h.s().j(g.this.f19771r.getCamp_id());
                com.sigmob.sdk.base.common.h.s().k(g.this.f19771r.getCrid());
            }
        }
    }

    public interface d {
        void a(g gVar);

        void a(WindAdError windAdError);
    }

    public interface e {
        LinearLayout a(g gVar, int i10);

        void a(g gVar);

        void a(g gVar, BaseAdUnit baseAdUnit, JSONObject jSONObject);

        void a(g gVar, JSONObject jSONObject);

        g b(g gVar, JSONObject jSONObject);

        void b();

        void b(g gVar);
    }

    public interface f {
        void a(g gVar, JSONObject jSONObject);

        void a(JSONObject jSONObject);

        void b(JSONObject jSONObject);
    }

    /* renamed from: com.sigmob.sdk.mraid2.g$g */
    public class C0608g {
        public C0608g() {
        }

        @JavascriptInterface
        public boolean canInstallByVid(String str, String str2) {
            BaseAdUnit baseAdUnit;
            if (g.this.getAdUnitList() == null) {
                return false;
            }
            if (g.this.getAdUnitList() != null && g.this.getAdUnitList().size() > 0) {
                for (int i10 = 0; i10 < g.this.getAdUnitList().size(); i10++) {
                    baseAdUnit = g.this.getAdUnitList().get(i10);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            if (baseAdUnit == null) {
                return false;
            }
            if (TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(baseAdUnit.getApkName())) {
                    str2 = baseAdUnit.getApkName();
                } else if (TextUtils.isEmpty(baseAdUnit.getApkMd5())) {
                    str2 = "";
                } else {
                    str2 = baseAdUnit.getApkMd5() + ".apk";
                }
            }
            return baseAdUnit.canInstall(str2);
        }

        @JavascriptInterface
        public boolean canOpen(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return u.a(com.sigmob.sdk.a.d(), str);
        }

        @JavascriptInterface
        public boolean canOpenByVid(String str, String str2) {
            BaseAdUnit baseAdUnit;
            if (!TextUtils.isEmpty(str2)) {
                return g.this.getContext().getPackageManager().getLaunchIntentForPackage(str2) != null;
            }
            if (g.this.getAdUnitList() == null) {
                return false;
            }
            if (g.this.getAdUnitList() != null && g.this.getAdUnitList().size() > 0) {
                for (int i10 = 0; i10 < g.this.getAdUnitList().size(); i10++) {
                    baseAdUnit = g.this.getAdUnitList().get(i10);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            if (baseAdUnit == null) {
                return false;
            }
            return baseAdUnit.canOpen();
        }

        @JavascriptInterface
        public boolean isOpenListReport() {
            return (com.sigmob.sdk.base.l.w().o().isEmpty() || com.sigmob.sdk.base.services.b.h()) ? false : true;
        }

        @JavascriptInterface
        public void onOpenListReport() {
            com.sigmob.sdk.base.services.b.i();
        }

        public /* synthetic */ C0608g(g gVar, a aVar) {
            this();
        }
    }

    public static class h {

        /* renamed from: a */
        public View f19789a;

        public h(View view) {
            this.f19789a = view;
        }

        public int a() {
            return this.f19789a.getLayoutParams().height;
        }

        public int b() {
            return this.f19789a.getLayoutParams().width;
        }

        public void a(int i10) {
            this.f19789a.getLayoutParams().height = i10;
            this.f19789a.requestLayout();
        }

        public void b(int i10) {
            this.f19789a.getLayoutParams().width = i10;
            this.f19789a.requestLayout();
        }
    }

    public g(Context context, List<BaseAdUnit> list, FrameLayout frameLayout) {
        this(context, list, frameLayout, null, null);
        a(new C0608g(this, null), "sigandroidh5");
    }

    public static HashMap<String, g> getMraidWebViews() {
        return f19758y;
    }

    public com.sigmob.sdk.base.common.g getAdSize() {
        return this.f19773t;
    }

    @Override // com.sigmob.sdk.mraid2.a
    public List<BaseAdUnit> getAdUnitList() {
        com.sigmob.sdk.mraid2.c cVar = this.f19760g;
        if (cVar != null) {
            return cVar.e();
        }
        return null;
    }

    public com.sigmob.sdk.mraid2.c getMraidBridge() {
        return this.f19760g;
    }

    public f getScrollTouchListener() {
        return this.f19763j;
    }

    public String getUniqueId() {
        return this.f19762i;
    }

    public void n() {
        BaseAdUnit baseAdUnit = getAdUnitList().get(0);
        Template template = baseAdUnit.scene;
        if (template == null) {
            template = (baseAdUnit.getMaterial() == null || baseAdUnit.getMaterial().main_template == null) ? (baseAdUnit.getMaterial() == null || baseAdUnit.getMaterial().sub_template == null) ? null : baseAdUnit.getMaterial().sub_template : baseAdUnit.getMaterial().main_template;
        }
        if (template != null) {
            int intValue = template.type.intValue();
            if (intValue == 1) {
                e(template.context.utf8());
            } else if (intValue == 2) {
                c(template.context.utf8());
            } else {
                if (intValue != 3) {
                    return;
                }
                f(template.context.utf8());
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        com.sigmob.sdk.mraid2.c cVar = this.f19760g;
        if (cVar != null) {
            cVar.a(i10 == 0);
        }
    }

    public void setAdSize(com.sigmob.sdk.base.common.g gVar) {
        this.f19773t = gVar;
    }

    public void setLoadListener(d dVar) {
        this.f19765l = dVar;
    }

    public void setNextWebViewListener(e eVar) {
        this.f19764k = eVar;
    }

    public void setScrollTouchListener(f fVar) {
        this.f19763j = fVar;
    }

    public g(Context context, List<BaseAdUnit> list, FrameLayout frameLayout, g gVar, JSONObject jSONObject) {
        super(context);
        this.f19769p = false;
        this.f19771r = null;
        this.f19772s = new a();
        this.f19774u = new LinkedHashMap();
        this.f19776w = new c();
        this.f19761h = this;
        this.f19767n = frameLayout;
        this.f19759f = gVar;
        this.f19766m = false;
        if (jSONObject != null) {
            try {
                this.f19770q = new JSONObject(jSONObject.optString("args"));
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            this.f19762i = jSONObject.optString("uniqueId");
        } else {
            String str = "wv_" + UUID.randomUUID().toString();
            this.f19762i = str;
            f19758y.put(str, this);
        }
        a(true);
        setBackgroundColor(0);
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(getSettings(), new String(Base64.decode(com.sigmob.sdk.base.k.C, 2)));
            methodBuilder.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder.execute();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            ReflectionUtil.MethodBuilder methodBuilder2 = new ReflectionUtil.MethodBuilder(getSettings(), new String(Base64.decode(com.sigmob.sdk.base.k.E, 2)));
            methodBuilder2.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder2.execute();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        this.f19772s.b(com.sigmob.sdk.base.l.w().g());
        BaseAdUnit baseAdUnit = list.get(0);
        if (baseAdUnit != null) {
            this.f19772s.a(baseAdUnit.isDisablexRequestWith());
        }
        setWebViewClient(this.f19772s);
        com.sigmob.sdk.mraid2.c cVar = new com.sigmob.sdk.mraid2.c(list);
        this.f19760g = cVar;
        cVar.a(this.f19776w);
        this.f19760g.a(this);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void c(String str) {
        a(new c.e(this.f19760g), "sigandroid");
        File a10 = com.sigmob.sdk.base.utils.d.a(str, Md5Util.md5(str) + ".html");
        if (a10 == null || TextUtils.isEmpty(a10.getAbsolutePath())) {
            a(Networking.getBaseUrlScheme() + "://localhost/", str, "text/html", "UTF-8", null);
            return;
        }
        a("file://" + a10.getAbsolutePath());
    }

    public final void d(String str) {
        String str2;
        List<MaterialMeta> list;
        Template template;
        Log.d(f19757x, "---------loadContentId----------" + str);
        for (int i10 = 0; i10 < getAdUnitList().size(); i10++) {
            BaseAdUnit baseAdUnit = getAdUnitList().get(i10);
            if (baseAdUnit != null) {
                Template template2 = baseAdUnit.scene;
                if (template2 == null || !str.equals(template2.templateId)) {
                    Ad ad2 = baseAdUnit.getAd();
                    if (ad2 != null && (list = ad2.materials) != null && list.get(0) != null) {
                        if (ad2.materials.get(0).main_template != null && str.equals(ad2.materials.get(0).main_template.templateId)) {
                            template = ad2.materials.get(0).main_template;
                        } else if (ad2.materials.get(0).sub_template != null && str.equals(ad2.materials.get(0).sub_template.templateId)) {
                            template = ad2.materials.get(0).sub_template;
                        }
                    }
                } else {
                    template = baseAdUnit.scene;
                }
                str2 = template.context.utf8();
                break;
            }
        }
        str2 = null;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void e(String str) {
        Log.d(f19757x, "---------loadContentUrl----------" + str);
        a(new c.e(this.f19760g), "sigandroid");
        a(str);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(new c.e(this.f19760g), "sigandroid");
        String md5 = Md5Util.md5(str);
        File c10 = com.sigmob.sdk.base.utils.d.c(com.sigmob.sdk.base.utils.d.f18409f);
        File file = new File(c10.getAbsolutePath() + File.separator + md5, "endcard.html");
        Log.d(f19757x, file.exists() + "---------loadURLByPackage----------" + file.getAbsolutePath());
        if (file.exists()) {
            a("file://" + file.getAbsolutePath());
            return;
        }
        File file2 = new File(c10, md5 + ".tgz");
        DownloadItem downloadItem = new DownloadItem();
        downloadItem.url = str;
        downloadItem.filePath = file2.getAbsolutePath();
        downloadItem.type = DownloadItem.FileType.FILE;
        r.a().add(downloadItem, new b(file));
    }

    @Override // com.sigmob.sdk.mraid2.a
    public void b() {
        try {
            setLoadListener(null);
            setNextWebViewListener(null);
            setScrollTouchListener(null);
            if (this.f19761h != null) {
                this.f19761h = null;
            }
            com.sigmob.sdk.mraid2.c cVar = this.f19760g;
            if (cVar != null) {
                cVar.c();
                this.f19760g = null;
            }
            super.b();
        } catch (Throwable unused) {
        }
    }
}
