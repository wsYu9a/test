package r3;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p3.i;
import p3.k;
import r3.e;
import v2.c;

/* loaded from: classes.dex */
public class d extends r3.c implements e.f, e.g, e.h {
    public static final String A = "exit";
    public static final String B = "action";
    public static final String C = "pushWindow";
    public static final String D = "h5JsFuncCallback";
    public static final String E = "sdkInfo";
    public static final String F = "canUseTaoLogin";
    public static final String G = "taoLogin";

    /* renamed from: m */
    public static final String f30245m = "sdk_result_code:";

    /* renamed from: n */
    public static final String f30246n = "alipayjsbridge://";

    /* renamed from: o */
    public static final String f30247o = "onBack";

    /* renamed from: p */
    public static final String f30248p = "setTitle";

    /* renamed from: q */
    public static final String f30249q = "onRefresh";

    /* renamed from: r */
    public static final String f30250r = "showBackButton";

    /* renamed from: s */
    public static final String f30251s = "onExit";

    /* renamed from: t */
    public static final String f30252t = "onLoadJs";

    /* renamed from: u */
    public static final String f30253u = "callNativeFunc";

    /* renamed from: v */
    public static final String f30254v = "back";

    /* renamed from: w */
    public static final String f30255w = "title";

    /* renamed from: x */
    public static final String f30256x = "refresh";

    /* renamed from: y */
    public static final String f30257y = "backButton";

    /* renamed from: z */
    public static final String f30258z = "refreshButton";

    /* renamed from: f */
    public boolean f30259f;

    /* renamed from: g */
    public String f30260g;

    /* renamed from: h */
    public boolean f30261h;

    /* renamed from: i */
    public final n3.a f30262i;

    /* renamed from: j */
    public boolean f30263j;

    /* renamed from: k */
    public r3.e f30264k;

    /* renamed from: l */
    public r3.f f30265l;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f30243b.finish();
        }
    }

    public class b extends e {

        /* renamed from: a */
        public final /* synthetic */ r3.e f30267a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(r3.e eVar) {
            super(null);
            this.f30267a = eVar;
        }

        @Override // r3.d.e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f30267a.c();
            d.this.f30261h = false;
        }
    }

    public class c extends e {

        /* renamed from: a */
        public final /* synthetic */ r3.e f30269a;

        /* renamed from: b */
        public final /* synthetic */ String f30270b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(r3.e eVar, String str) {
            super(null);
            this.f30269a = eVar;
            this.f30270b = str;
        }

        @Override // r3.d.e, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            d.this.removeView(this.f30269a);
            d.this.f30264k.f(this.f30270b);
            d.this.f30261h = false;
        }
    }

    /* renamed from: r3.d$d */
    public class RunnableC0781d implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Activity f30272b;

        /* renamed from: c */
        public final /* synthetic */ SslErrorHandler f30273c;

        /* renamed from: r3.d$d$a */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                RunnableC0781d.this.f30273c.cancel();
                x2.a.i(d.this.f30262i, "net", x2.b.A, "2");
                v2.b.c(v2.b.a());
                RunnableC0781d.this.f30272b.finish();
            }
        }

        public RunnableC0781d(Activity activity, SslErrorHandler sslErrorHandler) {
            this.f30272b = activity;
            this.f30273c = sslErrorHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            r3.b.b(this.f30272b, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new a(), null, null);
        }
    }

    public static abstract class e implements Animation.AnimationListener {
        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static class f {

        /* renamed from: a */
        public final WeakReference<r3.e> f30276a;

        /* renamed from: b */
        public final String f30277b;

        /* renamed from: c */
        public final String f30278c;

        /* renamed from: d */
        public final JSONObject f30279d;

        /* renamed from: e */
        public boolean f30280e = false;

        public f(r3.e eVar, String str, String str2, JSONObject jSONObject) {
            this.f30276a = new WeakReference<>(eVar);
            this.f30277b = str;
            this.f30278c = str2;
            this.f30279d = jSONObject;
        }

        public static String a(String str) {
            return TextUtils.isEmpty(str) ? "" : str.replace("'", "");
        }

        public void b(JSONObject jSONObject) {
            r3.e eVar;
            if (this.f30280e || (eVar = (r3.e) k.f(this.f30276a)) == null) {
                return;
            }
            this.f30280e = true;
            eVar.f(String.format("javascript:window.AlipayJSBridge.callBackFromNativeFunc('%s','%s');", a(this.f30278c), a(jSONObject.toString())));
        }
    }

    public static class g implements c.a {

        /* renamed from: a */
        public final f f30281a;

        /* renamed from: b */
        public final String f30282b;

        public g(f fVar, String str) {
            this.f30281a = fVar;
            this.f30282b = str;
        }

        @Override // v2.c.a
        public void a(boolean z10, JSONObject jSONObject, String str) {
            try {
                this.f30281a.b(new JSONObject().put("success", z10).put("random", this.f30282b).put("code", jSONObject).put("status", str));
            } catch (JSONException unused) {
            }
        }
    }

    public d(Activity activity, n3.a aVar, String str) {
        super(activity, str);
        this.f30259f = true;
        this.f30260g = "GET";
        this.f30261h = false;
        this.f30264k = null;
        this.f30265l = new r3.f();
        this.f30262i = aVar;
        A();
    }

    public final synchronized boolean A() {
        try {
            r3.e eVar = new r3.e(this.f30243b, this.f30262i, new e.C0783e(!m(), !m()));
            this.f30264k = eVar;
            eVar.setChromeProxy(this);
            this.f30264k.setWebClientProxy(this);
            this.f30264k.setWebEventProxy(this);
            addView(this.f30264k);
        } catch (Exception unused) {
            return false;
        }
        return true;
    }

    public final void B() {
        r3.e eVar = this.f30264k;
        if (eVar != null) {
            eVar.getWebView().loadUrl("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        }
    }

    public final synchronized void C() {
        try {
            WebView webView = this.f30264k.getWebView();
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                r3.f fVar = this.f30265l;
                if (fVar == null || fVar.c()) {
                    s(false);
                } else {
                    y();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // r3.e.h
    public synchronized void a(r3.e eVar) {
        eVar.getWebView().reload();
        eVar.getRefreshButton().setVisibility(4);
    }

    @Override // r3.e.h
    public synchronized void b(r3.e eVar) {
        z();
    }

    @Override // r3.e.f
    public synchronized void c(r3.e eVar, String str) {
        if (!str.startsWith("http") && !eVar.getUrl().endsWith(str)) {
            this.f30264k.getTitle().setText(str);
        }
    }

    @Override // r3.e.g
    public synchronized boolean d(r3.e eVar, String str) {
        x2.a.d(this.f30262i, x2.b.f31789l, "h5ld", SystemClock.elapsedRealtime() + "|" + k.f0(str));
        if (!TextUtils.isEmpty(str) && !str.endsWith(".apk")) {
            B();
        }
        return false;
    }

    @Override // r3.e.f
    public synchronized boolean e(r3.e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
            if (str2.startsWith("<head>") && str2.contains(f30245m)) {
                this.f30243b.runOnUiThread(new a());
            }
            jsPromptResult.cancel();
        } catch (Throwable th2) {
            throw th2;
        }
        return true;
    }

    @Override // r3.e.g
    public synchronized boolean f(r3.e eVar, int i10, String str, String str2) {
        this.f30263j = true;
        x2.a.i(this.f30262i, "net", x2.b.f31815y, "onReceivedError:" + i10 + "|" + str2);
        eVar.getRefreshButton().setVisibility(0);
        return false;
    }

    @Override // r3.e.g
    public synchronized boolean g(r3.e eVar, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Activity activity = this.f30243b;
            if (activity == null) {
                return true;
            }
            if (k.B(this.f30262i, str, activity)) {
                return true;
            }
            if (str.startsWith(f30246n)) {
                v(str.substring(17));
            } else if (TextUtils.equals(str, z2.a.f33606q)) {
                s(false);
            } else if (str.startsWith("http://") || str.startsWith("https://")) {
                this.f30264k.f(str);
            } else {
                try {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    activity.startActivity(intent);
                } catch (Throwable th2) {
                    x2.a.g(this.f30262i, x2.b.f31789l, th2);
                }
            }
            return true;
        } catch (Throwable th3) {
            throw th3;
        }
    }

    @Override // r3.e.g
    public synchronized boolean h(r3.e eVar, String str) {
        x2.a.d(this.f30262i, x2.b.f31789l, "h5ldd", SystemClock.elapsedRealtime() + "|" + k.f0(str));
        B();
        eVar.getRefreshButton().setVisibility(0);
        return true;
    }

    @Override // r3.e.g
    public synchronized boolean i(r3.e eVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = this.f30243b;
        if (activity == null) {
            return true;
        }
        x2.a.i(this.f30262i, "net", x2.b.f31817z, "2-" + sslError);
        activity.runOnUiThread(new RunnableC0781d(activity, sslErrorHandler));
        return true;
    }

    @Override // r3.c
    public synchronized void k(String str) {
        try {
            if ("POST".equals(this.f30260g)) {
                this.f30264k.g(str, null);
            } else {
                this.f30264k.f(str);
            }
            r3.c.j(this.f30264k.getWebView());
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // r3.c
    public synchronized boolean n() {
        try {
            Activity activity = this.f30243b;
            if (activity == null) {
                return true;
            }
            if (!m()) {
                if (!this.f30261h) {
                    z();
                }
                return true;
            }
            r3.e eVar = this.f30264k;
            if (eVar != null && eVar.getWebView() != null) {
                if (!eVar.getWebView().canGoBack()) {
                    v2.b.c(v2.b.a());
                    activity.finish();
                } else if (x()) {
                    com.alipay.sdk.m.j.c b10 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.NETWORK_ERROR.b());
                    v2.b.c(v2.b.b(b10.b(), b10.a(), ""));
                    activity.finish();
                }
                return true;
            }
            activity.finish();
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // r3.c
    public synchronized void o() {
        this.f30264k.c();
        this.f30265l.a();
    }

    @Override // android.view.ViewGroup
    public synchronized boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f30261h ? true : super.onInterceptTouchEvent(motionEvent);
    }

    public final synchronized void q(String str, String str2, String str3) {
        r3.e eVar;
        char c10;
        try {
            eVar = this.f30264k;
        } catch (Throwable th2) {
            x2.a.f(this.f30262i, x2.b.f31789l, "jInfoErr", th2, str);
        } finally {
        }
        if (eVar == null) {
            return;
        }
        JSONObject c02 = k.c0(str3);
        f fVar = new f(eVar, str, str2, c02);
        Context context = eVar.getContext();
        String str4 = fVar.f30277b;
        switch (str4.hashCode()) {
            case -1785164386:
                if (str4.equals(F)) {
                    c10 = '\b';
                    break;
                }
                c10 = 65535;
                break;
            case -552487705:
                if (str4.equals(G)) {
                    c10 = '\t';
                    break;
                }
                c10 = 65535;
                break;
            case 3015911:
                if (str4.equals(f30254v)) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case 3127582:
                if (str4.equals(A)) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case 110371416:
                if (str4.equals("title")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case 1085444827:
                if (str4.equals(f30256x)) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case 1703426986:
                if (str4.equals(C)) {
                    c10 = 6;
                    break;
                }
                c10 = 65535;
                break;
            case 1906413305:
                if (str4.equals(f30257y)) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case 1947723784:
                if (str4.equals(E)) {
                    c10 = 7;
                    break;
                }
                c10 = 65535;
                break;
            case 2033767917:
                if (str4.equals(f30258z)) {
                    c10 = 5;
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
                if (c02.has("title")) {
                    eVar.getTitle().setText(c02.optString("title", ""));
                    break;
                }
                break;
            case 1:
                eVar.getWebView().reload();
                break;
            case 2:
                C();
                break;
            case 3:
                v2.b.c(c02.optString(i.f29758c, null));
                s(c02.optBoolean("success", false));
                break;
            case 4:
                eVar.getBackButton().setVisibility(c02.optBoolean("show", true) ? 0 : 4);
                break;
            case 5:
                eVar.getRefreshButton().setVisibility(c02.optBoolean("show", true) ? 0 : 4);
                break;
            case 6:
                w(c02.optString("url"), c02.optString("title", ""));
                break;
            case 7:
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sdk_version", "15.8.30");
                jSONObject.put("app_name", this.f30262i.h());
                jSONObject.put("app_version", this.f30262i.m());
                fVar.b(jSONObject);
                break;
            case '\b':
                String url = eVar.getUrl();
                if (!k.A(this.f30262i, url)) {
                    x2.a.i(this.f30262i, x2.b.f31789l, "jsUrlErr", url);
                    break;
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    boolean c11 = v2.c.c(this.f30262i, context);
                    jSONObject2.put("enabled", c11);
                    x2.a.d(this.f30262i, x2.b.f31789l, x2.b.f31806t0, String.valueOf(c11));
                    fVar.b(jSONObject2);
                    break;
                }
            case '\t':
                String url2 = eVar.getUrl();
                if (!k.A(this.f30262i, url2)) {
                    x2.a.i(this.f30262i, x2.b.f31789l, "jsUrlErr", url2);
                    break;
                } else {
                    String optString = c02.optString("random");
                    JSONObject optJSONObject = c02.optJSONObject("options");
                    if (!TextUtils.isEmpty("random") && optJSONObject != null) {
                        String optString2 = optJSONObject.optString("url");
                        String optString3 = optJSONObject.optString("action");
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && (context instanceof Activity)) {
                            v2.c.b(this.f30262i, (Activity) context, 1010, optString2, optString3, new g(fVar, optString));
                            break;
                        }
                    }
                }
                break;
        }
    }

    public synchronized void r(String str, String str2, boolean z10) {
        this.f30260g = str2;
        this.f30264k.getTitle().setText(str);
        this.f30259f = z10;
    }

    public final synchronized void s(boolean z10) {
        v2.b.d(z10);
        this.f30243b.finish();
    }

    public final synchronized void v(String str) {
        try {
            Map<String, String> I = k.I(this.f30262i, str);
            if (str.startsWith(f30253u)) {
                q(I.get("func"), I.get("cbId"), I.get(h3.e.f26408m));
            } else if (str.startsWith(f30247o)) {
                C();
            } else if (str.startsWith(f30248p) && I.containsKey("title")) {
                this.f30264k.getTitle().setText(I.get("title"));
            } else if (str.startsWith(f30249q)) {
                this.f30264k.getWebView().reload();
            } else if (str.startsWith(f30250r) && I.containsKey("bshow")) {
                this.f30264k.getBackButton().setVisibility(TextUtils.equals("true", I.get("bshow")) ? 0 : 4);
            } else if (str.startsWith(f30251s)) {
                v2.b.c(I.get(i.f29758c));
                s(TextUtils.equals("true", I.get("bsucc")));
            } else if (str.startsWith(f30252t)) {
                this.f30264k.f("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized boolean w(String str, String str2) {
        r3.e eVar = this.f30264k;
        try {
            r3.e eVar2 = new r3.e(this.f30243b, this.f30262i, new e.C0783e(!m(), !m()));
            this.f30264k = eVar2;
            eVar2.setChromeProxy(this);
            this.f30264k.setWebClientProxy(this);
            this.f30264k.setWebEventProxy(this);
            if (!TextUtils.isEmpty(str2)) {
                this.f30264k.getTitle().setText(str2);
            }
            this.f30261h = true;
            this.f30265l.b(eVar);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new c(eVar, str));
            this.f30264k.setAnimation(translateAnimation);
            addView(this.f30264k);
        } catch (Throwable unused) {
            return false;
        }
        return true;
    }

    public boolean x() {
        return this.f30263j;
    }

    public final synchronized boolean y() {
        try {
            if (this.f30265l.c()) {
                this.f30243b.finish();
            } else {
                this.f30261h = true;
                r3.e eVar = this.f30264k;
                this.f30264k = this.f30265l.d();
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(400L);
                translateAnimation.setFillAfter(false);
                translateAnimation.setAnimationListener(new b(eVar));
                eVar.setAnimation(translateAnimation);
                removeView(eVar);
                addView(this.f30264k);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return true;
    }

    public final synchronized void z() {
        try {
            Activity activity = this.f30243b;
            r3.e eVar = this.f30264k;
            if (activity != null && eVar != null) {
                if (this.f30259f) {
                    activity.finish();
                } else {
                    eVar.f("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
                }
            }
        } finally {
        }
    }
}
