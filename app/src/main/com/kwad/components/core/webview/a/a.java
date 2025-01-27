package com.kwad.components.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.bz;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {
    private com.kwad.components.core.e.d.c MA;
    private WebView Qc;
    private boolean Yf;
    private KsAppDownloadListener Yr;
    private int Ys = -100;
    private int Yt = 0;

    /* renamed from: eb */
    private com.kwad.sdk.core.webview.b f11941eb;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.core.webview.a.a$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ String Yu;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.this.aJ(str);
        }
    }

    /* renamed from: com.kwad.components.core.webview.a.a$2 */
    public class AnonymousClass2 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            a.this.p(0, 0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            a.this.p(8, 100);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            a.this.p(0, 0);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            a.this.p(12, 100);
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            a.this.p(4, i10);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            if (i10 == 0) {
                a.this.p(1, 0);
            } else {
                a.this.p(2, i10);
            }
        }
    }

    @KsJson
    /* renamed from: com.kwad.components.core.webview.a.a$a */
    public static final class C0447a extends com.kwad.sdk.core.response.a.a {
        public String packageName;
        public String url;
    }

    @KsJson
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public int progress;
        public int status;
    }

    public a(WebView webView, com.kwad.sdk.core.webview.b bVar) {
        this.Qc = webView;
        this.mAdTemplate = bVar.getAdTemplate();
        this.f11941eb = bVar;
    }

    public void aJ(String str) {
        try {
            C0447a c0447a = new C0447a();
            c0447a.parseJson(new JSONObject(str));
            if (p(c0447a.url, c0447a.packageName)) {
                return;
            }
            if (this.MA == null) {
                o(c0447a.url, c0447a.packageName);
            }
            a.C0427a as = new a.C0427a(this.f11941eb.Qc.getContext()).ap(true).aq(false).au(this.mAdTemplate).as(false);
            if (this.MA.s(as)) {
                return;
            }
            this.MA.d(this.Yr);
            this.MA.r(as);
        } catch (JSONException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    private void n(String str, String str2) {
        WebView webView;
        if (this.Yf || TextUtils.isEmpty(str) || (webView = this.Qc) == null) {
            return;
        }
        bz.a(webView, str, str2);
    }

    private synchronized void o(String str, String str2) {
        this.MA = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, str, str2);
        if (this.Yr == null) {
            KsAppDownloadListener tp = tp();
            this.Yr = tp;
            this.MA.b(tp);
        }
    }

    private static boolean p(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    private KsAppDownloadListener tp() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.a.a.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.p(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.p(12, 100);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i10) {
                a.this.p(4, i10);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
                if (i10 == 0) {
                    a.this.p(1, 0);
                } else {
                    a.this.p(2, i10);
                }
            }
        };
    }

    public final void destroy() {
        this.Yf = true;
        com.kwad.components.core.e.d.c cVar = this.MA;
        if (cVar != null) {
            cVar.c(this.Yr);
        }
    }

    @JavascriptInterface
    public final int getDownLoadStatus(String str, String str2) {
        if (p(str, str2)) {
            return 0;
        }
        if (this.MA == null) {
            o(str, str2);
        }
        return this.MA.oK();
    }

    @JavascriptInterface
    public final int getProgress(String str, String str2) {
        if (p(str, str2)) {
            return 0;
        }
        if (this.MA == null) {
            o(str, str2);
        }
        return this.Yt;
    }

    @JavascriptInterface
    @WorkerThread
    public final void handleAdClick(String str) {
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.webview.a.a.1
            final /* synthetic */ String Yu;

            public AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.this.aJ(str);
            }
        });
    }

    public void p(int i10, int i11) {
        this.Yt = i11;
        if (this.Ys != i10) {
            this.Ys = i10;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i10);
            n("onDownLoadStatusCallback", sb2.toString());
        }
    }
}
