package com.sigmob.sdk.mraid2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.views.r0;
import com.sigmob.sdk.nativead.APKStatusBroadcastReceiver;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class a extends FrameLayout {

    /* renamed from: c */
    public static String f19686c = "BaseWebView2";

    /* renamed from: d */
    public static boolean f19687d = false;

    /* renamed from: e */
    public static HashMap<String, com.sigmob.sdk.mraid.j> f19688e = new LinkedHashMap();

    /* renamed from: a */
    public Map<String, APKStatusBroadcastReceiver> f19689a;

    /* renamed from: b */
    public com.sigmob.sdk.base.views.g f19690b;

    /* renamed from: com.sigmob.sdk.mraid2.a$a */
    public class C0601a implements o.a {
        public C0601a() {
        }

        @Override // com.sigmob.sdk.base.common.o.a
        public void a(boolean z10, long j10) {
            a.this.g();
        }

        @Override // com.sigmob.sdk.base.common.o.a
        public void b(boolean z10, long j10) {
            if (z10) {
                a.this.h();
            } else {
                a.this.d();
            }
        }

        @Override // com.sigmob.sdk.base.common.o.a
        public void c(boolean z10, long j10) {
            if (z10) {
                a.this.c();
            } else {
                a.this.d();
            }
        }

        @Override // com.sigmob.sdk.base.common.o.a
        public void a(boolean z10) {
            if (z10) {
                a.this.e();
            } else {
                a.this.d();
            }
        }

        @Override // com.sigmob.sdk.base.common.o.a
        public void b(boolean z10) {
            if (z10) {
                a.this.f();
            } else {
                a.this.d();
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f19692a;

        public b(String str) {
            this.f19692a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b("mraidbridge.notifyApkDownloadStateEvent(\"" + this.f19692a + "\");", null);
        }
    }

    public class c {
        public c() {
        }

        @JavascriptInterface
        public int cancelDownloadTaskByVid(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && a.this.getAdUnitList().size() > 0) {
                for (int i10 = 0; i10 < a.this.getAdUnitList().size(); i10++) {
                    baseAdUnit = a.this.getAdUnitList().get(i10);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Log.d(a.f19686c, baseAdUnit + "-----------resumeDownloadByVid---------" + str);
            if (baseAdUnit == null || baseAdUnit.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.n.a(a.this.getContext(), baseAdUnit);
        }

        @JavascriptInterface
        public int getApKDownloadProcessId(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && a.this.getAdUnitList().size() > 0) {
                for (int i10 = 0; i10 < a.this.getAdUnitList().size(); i10++) {
                    baseAdUnit = a.this.getAdUnitList().get(i10);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Log.d(a.f19686c, baseAdUnit + "-----------getApKDownloadProcessId---------" + str);
            if (baseAdUnit == null) {
                baseAdUnit = a.this.getAdUnitList().get(0);
            }
            if (a.this.getContext() == null || baseAdUnit == null) {
                return -1;
            }
            long[] c10 = baseAdUnit.getApkDownloadType() != 0 ? com.sigmob.sdk.base.common.n.c(a.this.getContext(), baseAdUnit) : com.sigmob.sdk.base.common.p.a(a.this.getContext(), baseAdUnit.getDownloadId());
            int i11 = (int) c10[2];
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 4) {
                        return i11 != 8 ? -1 : 100;
                    }
                    return -2;
                }
                long j10 = c10[0];
                long j11 = c10[1];
                if (j11 != 0 && j10 != 0) {
                    return (int) ((j10 * 100) / j11);
                }
            }
            return 0;
        }

        @JavascriptInterface
        public int pauseDownloadByVid(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && a.this.getAdUnitList().size() > 0) {
                for (int i10 = 0; i10 < a.this.getAdUnitList().size(); i10++) {
                    baseAdUnit = a.this.getAdUnitList().get(i10);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Log.d(a.f19686c, baseAdUnit + "-----------PauseDownloadByVid---------" + str);
            if (baseAdUnit == null || baseAdUnit.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.n.b(a.this.getContext(), baseAdUnit);
        }

        @JavascriptInterface
        public void registerDownloadEvent(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && a.this.getAdUnitList().size() > 0) {
                for (int i10 = 0; i10 < a.this.getAdUnitList().size(); i10++) {
                    baseAdUnit = a.this.getAdUnitList().get(i10);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Log.d(a.f19686c, baseAdUnit + "-----------registerDownloadEvent---------" + str);
            if (baseAdUnit == null) {
                baseAdUnit = a.this.getAdUnitList().get(0);
            }
            a.this.a(baseAdUnit);
        }

        @JavascriptInterface
        public int resumeDownloadByVid(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && a.this.getAdUnitList().size() > 0) {
                for (int i10 = 0; i10 < a.this.getAdUnitList().size(); i10++) {
                    baseAdUnit = a.this.getAdUnitList().get(i10);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Log.d(a.f19686c, baseAdUnit + "-----------resumeDownloadByVid---------" + str);
            if (baseAdUnit == null || baseAdUnit.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.n.d(a.this.getContext(), baseAdUnit);
        }
    }

    public a(Context context) {
        super(context);
        this.f19689a = new HashMap();
        this.f19690b = null;
        com.sigmob.sdk.base.views.g a10 = r0.a().a(context);
        this.f19690b = a10;
        if (a10 == null) {
            this.f19690b = new com.sigmob.sdk.base.views.g(context);
        }
        this.f19690b.addJavascriptInterface(new c(), "sigandroidapk");
        addView(this.f19690b, new FrameLayout.LayoutParams(-1, -1));
    }

    public void b() {
        Map<String, APKStatusBroadcastReceiver> map = this.f19689a;
        if (map != null && map.size() > 0) {
            for (APKStatusBroadcastReceiver aPKStatusBroadcastReceiver : this.f19689a.values()) {
                aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            }
            this.f19689a.clear();
        }
        HashMap<String, com.sigmob.sdk.mraid.j> hashMap = f19688e;
        if (hashMap != null && hashMap.size() > 0) {
            for (com.sigmob.sdk.mraid.j jVar : f19688e.values()) {
                if (jVar != null) {
                    jVar.a();
                }
            }
            f19688e.clear();
        }
        if (this.f19690b != null) {
            r0.a().a(this.f19690b);
            this.f19690b = null;
        }
        removeAllViews();
    }

    public void c() {
        b(PointCategory.DOWNLOAD_END);
    }

    public void d() {
        b("download_fail");
    }

    public void e() {
        b(com.sigmob.sdk.base.common.a.I);
    }

    public void f() {
        b("install_end");
    }

    public void g() {
        b("download_pause");
    }

    public abstract List<BaseAdUnit> getAdUnitList();

    public WebSettings getSettings() {
        return this.f19690b.getSettings();
    }

    public void h() {
        b("download_start");
    }

    public void i() {
        com.sigmob.sdk.base.views.g gVar = this.f19690b;
        if (gVar != null) {
            gVar.reload();
        }
    }

    public void j() {
        this.f19690b.resumeTimers();
    }

    public void k() {
        com.sigmob.sdk.base.views.g gVar = this.f19690b;
        if (gVar != null) {
            gVar.stopLoading();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        this.f19690b.setBackground(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        super.setBackgroundColor(i10);
        this.f19690b.setBackgroundColor(i10);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        com.sigmob.sdk.base.views.g gVar = this.f19690b;
        if (gVar != null) {
            gVar.setWebChromeClient(webChromeClient);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        com.sigmob.sdk.base.views.g gVar = this.f19690b;
        if (gVar != null) {
            gVar.setWebViewClient(webViewClient);
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void a(Object obj, String str) {
        this.f19690b.addJavascriptInterface(obj, str);
    }

    public void b(String str, ValueCallback valueCallback) {
        if (this.f19690b == null) {
            return;
        }
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
        this.f19690b.evaluateJavascript(str, valueCallback);
    }

    public void a(boolean z10) {
        com.sigmob.sdk.base.views.g gVar = this.f19690b;
        if (gVar != null) {
            gVar.a(z10);
        }
    }

    public void b(String str) {
        post(new b(str));
    }

    public void a(String str, ValueCallback valueCallback) {
        com.sigmob.sdk.base.views.g gVar = this.f19690b;
        if (gVar != null) {
            gVar.evaluateJavascript(str, valueCallback);
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        com.sigmob.sdk.base.views.g gVar = this.f19690b;
        if (gVar != null) {
            gVar.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void a(String str) {
        this.f19690b.loadUrl(str);
    }

    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || this.f19689a.get(baseAdUnit.getUuid()) != null) {
            return;
        }
        APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = new APKStatusBroadcastReceiver(new C0601a(), baseAdUnit.getUuid());
        aPKStatusBroadcastReceiver.a(aPKStatusBroadcastReceiver);
        this.f19689a.put(baseAdUnit.getUuid(), aPKStatusBroadcastReceiver);
    }
}
