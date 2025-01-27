package com.kwad.components.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.c.d;
import com.kwad.sdk.core.webview.c.e;
import com.kwad.sdk.core.webview.c.f;
import com.kwad.sdk.utils.bz;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {
    private WebView Qc;
    private final Map<String, com.kwad.sdk.core.webview.c.a> Yd = new ConcurrentHashMap(32);
    private com.kwad.sdk.core.webview.c.a Ye = new d();
    private boolean Yf;

    /* renamed from: com.kwad.components.core.webview.a$1 */
    public class AnonymousClass1 implements com.kwad.sdk.core.webview.c.c {
        final /* synthetic */ com.kwad.sdk.core.webview.c.b Yg;

        public AnonymousClass1(com.kwad.sdk.core.webview.c.b bVar) {
            bVar = bVar;
        }

        @Override // com.kwad.sdk.core.webview.c.c
        public final void a(com.kwad.sdk.core.b bVar) {
            a.this.n(bVar.aIW, new f(bVar).toJson().toString());
        }

        @Override // com.kwad.sdk.core.webview.c.c
        public final void onError(int i10, String str) {
            a.this.n(bVar.aIW, new e(i10, str).toJson().toString());
        }
    }

    /* renamed from: com.kwad.components.core.webview.a$2 */
    public class AnonymousClass2 implements com.kwad.sdk.core.webview.c.c {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.c.c
        public final void a(com.kwad.sdk.core.b bVar) {
        }

        @Override // com.kwad.sdk.core.webview.c.c
        public final void onError(int i10, String str) {
        }
    }

    public a(WebView webView) {
        this.Qc = webView;
        tc();
    }

    public void n(String str, String str2) {
        if (this.Yf) {
            com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callJS after destroy jsInterface, " + str2);
        } else {
            if (TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callJS callback is empty");
                return;
            }
            com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
            WebView webView = this.Qc;
            if (webView == null) {
                return;
            }
            bz.a(webView, str, str2);
        }
    }

    private void tc() {
        a(new com.kwad.sdk.core.webview.d.a());
        a(new com.kwad.sdk.core.webview.d.b());
        a(new aa());
    }

    public final void b(com.kwad.sdk.core.webview.c.a aVar) {
        if (TextUtils.isEmpty(aVar.getKey())) {
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
        } else {
            this.Yd.put(aVar.getKey(), aVar);
        }
    }

    @JavascriptInterface
    public final void callAdBridge(String str) {
        com.kwad.sdk.core.d.c.d("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            com.kwad.sdk.core.webview.c.b bVar = new com.kwad.sdk.core.webview.c.b();
            bVar.parseJson(new JSONObject(str));
            com.kwad.sdk.core.webview.c.a aVar = this.Yd.get(bVar.aIV);
            if (aVar == null) {
                aVar = this.Ye;
            }
            WebView webView = this.Qc;
            if (webView != null && (webView instanceof KsAdWebView)) {
                KsAdWebView ksAdWebView = (KsAdWebView) webView;
                com.kwad.sdk.core.webview.b.c.b.a(ksAdWebView.getLoadUrl(), ksAdWebView.getUniqueId(), bVar.aIV, bVar.data);
            }
            if (aVar != null) {
                aVar.a(bVar.data, !TextUtils.isEmpty(bVar.aIW) ? new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.core.webview.a.1
                    final /* synthetic */ com.kwad.sdk.core.webview.c.b Yg;

                    public AnonymousClass1(com.kwad.sdk.core.webview.c.b bVar2) {
                        bVar = bVar2;
                    }

                    @Override // com.kwad.sdk.core.webview.c.c
                    public final void a(com.kwad.sdk.core.b bVar2) {
                        a.this.n(bVar.aIW, new f(bVar2).toJson().toString());
                    }

                    @Override // com.kwad.sdk.core.webview.c.c
                    public final void onError(int i10, String str2) {
                        a.this.n(bVar.aIW, new e(i10, str2).toJson().toString());
                    }
                } : new com.kwad.sdk.core.webview.c.c() { // from class: com.kwad.components.core.webview.a.2
                    public AnonymousClass2() {
                    }

                    @Override // com.kwad.sdk.core.webview.c.c
                    public final void a(com.kwad.sdk.core.b bVar2) {
                    }

                    @Override // com.kwad.sdk.core.webview.c.c
                    public final void onError(int i10, String str2) {
                    }
                });
            } else {
                com.kwad.sdk.core.d.c.e("KSAdJSBridge", "bridgeHandler is null");
            }
        } catch (JSONException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "callAdBridge JSONException:" + e10);
        }
    }

    public final void destroy() {
        com.kwad.sdk.core.d.c.i("KSAdJSBridge", "destroy jsInterface");
        Iterator<Map.Entry<String, com.kwad.sdk.core.webview.c.a>> it = this.Yd.entrySet().iterator();
        while (it.hasNext()) {
            com.kwad.sdk.core.webview.c.a value = it.next().getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        this.Yf = true;
    }

    public final void a(com.kwad.sdk.core.webview.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.getKey())) {
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "handler and handler'key cannot be null");
            return;
        }
        if (this.Yd.containsKey(aVar.getKey())) {
            com.kwad.sdk.core.d.c.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.getKey());
        }
        this.Yd.put(aVar.getKey(), aVar);
    }
}
