package com.tencent.connect.auth;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.qq.e.comm.constants.ErrorCode;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.tencent.connect.auth.b;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import com.tencent.open.b.g;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.i;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a extends Dialog {

    /* renamed from: a */
    private String f25244a;

    /* renamed from: b */
    private b f25245b;

    /* renamed from: c */
    private IUiListener f25246c;

    /* renamed from: d */
    private Handler f25247d;

    /* renamed from: e */
    private FrameLayout f25248e;

    /* renamed from: f */
    private LinearLayout f25249f;

    /* renamed from: g */
    private FrameLayout f25250g;

    /* renamed from: h */
    private ProgressBar f25251h;

    /* renamed from: i */
    private String f25252i;

    /* renamed from: j */
    private com.tencent.open.c.c f25253j;
    private Context k;
    private com.tencent.open.web.security.b l;
    private boolean m;
    private int n;
    private String o;
    private String p;
    private long q;
    private long r;
    private HashMap<String, Runnable> s;

    /* renamed from: com.tencent.connect.auth.a$1 */
    class AnonymousClass1 implements View.OnLongClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* renamed from: com.tencent.connect.auth.a$2 */
    class AnonymousClass2 implements View.OnTouchListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if ((action != 0 && action != 1) || view.hasFocus()) {
                return false;
            }
            view.requestFocus();
            return false;
        }
    }

    /* renamed from: com.tencent.connect.auth.a$3 */
    class AnonymousClass3 implements DialogInterface.OnDismissListener {
        AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            try {
                JniInterface.clearAllPWD();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: com.tencent.connect.auth.a$a */
    private class C0526a extends WebViewClient {

        /* renamed from: com.tencent.connect.auth.a$a$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f25253j.loadUrl(a.this.o);
            }
        }

        private C0526a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            f.a("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            a.this.f25250g.setVisibility(8);
            if (a.this.f25253j != null) {
                a.this.f25253j.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a.this.f25247d.removeCallbacks((Runnable) a.this.s.remove(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            f.a("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            a.this.f25250g.setVisibility(0);
            a.this.q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.o)) {
                a.this.f25247d.removeCallbacks((Runnable) a.this.s.remove(a.this.o));
            }
            a.this.o = str;
            a aVar = a.this;
            d dVar = aVar.new d(aVar.o);
            a.this.s.put(str, dVar);
            a.this.f25247d.postDelayed(dVar, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            f.c("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i2 + " | description: " + str);
            if (!i.c(a.this.k)) {
                a.this.f25245b.onError(new UiError(ErrorCode.PrivateError.LOAD_FAIL, "当前网络不可用，请稍后重试！", str2));
                a.this.dismiss();
                return;
            }
            if (a.this.o.startsWith("http://qzs.qq.com/open/mobile/login/qzsjump.html?")) {
                a.this.f25245b.onError(new UiError(i2, str, str2));
                a.this.dismiss();
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.q;
            if (a.this.n >= 1 || elapsedRealtime >= a.this.r) {
                a.this.f25253j.loadUrl(a.this.a());
            } else {
                a.m(a.this);
                a.this.f25247d.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.a.a.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f25253j.loadUrl(a.this.o);
                    }
                }, 500L);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
            a.this.f25245b.onError(new UiError(sslError.getPrimaryError(), "请求不合法，请检查手机安全设置，如系统时间、代理等。", "ssl error"));
            a.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            List<String> pathSegments;
            f.a("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject c2 = i.c(str);
                a aVar = a.this;
                aVar.m = aVar.e();
                if (!a.this.m) {
                    if (c2.optString("fail_cb", null) != null) {
                        a.this.a(c2.optString("fail_cb"), "");
                    } else if (c2.optInt("fall_to_wv") == 1) {
                        a aVar2 = a.this;
                        a.a(aVar2, (Object) (aVar2.f25244a.indexOf("?") > -1 ? "&" : "?"));
                        a.a(a.this, (Object) "browser_error=1");
                        a.this.f25253j.loadUrl(a.this.f25244a);
                    } else {
                        String optString = c2.optString("redir", null);
                        if (optString != null) {
                            a.this.f25253j.loadUrl(optString);
                        }
                    }
                }
                return true;
            }
            if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.f25245b.onComplete(i.c(str));
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                a.this.f25245b.onCancel();
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.DOWNLOAD_URI)) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(str.substring(11))));
                    intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                    a.this.k.startActivity(intent);
                } catch (Exception e2) {
                    f.b("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e2);
                }
                return true;
            }
            if (!str.startsWith("auth://progress")) {
                if (str.startsWith("auth://onLoginSubmit")) {
                    try {
                        List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                        if (!pathSegments2.isEmpty()) {
                            a.this.p = pathSegments2.get(0);
                        }
                    } catch (Exception unused) {
                    }
                    return true;
                }
                if (a.this.l.a(a.this.f25253j, str)) {
                    return true;
                }
                f.c("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                return false;
            }
            try {
                pathSegments = Uri.parse(str).getPathSegments();
            } catch (Exception unused2) {
            }
            if (pathSegments.isEmpty()) {
                return true;
            }
            int intValue = Integer.valueOf(pathSegments.get(0)).intValue();
            if (intValue == 0) {
                a.this.f25250g.setVisibility(8);
                a.this.f25253j.setVisibility(0);
            } else if (intValue == 1) {
                a.this.f25250g.setVisibility(0);
            }
            return true;
        }

        /* synthetic */ C0526a(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private class b implements IUiListener {

        /* renamed from: a */
        String f25259a;

        /* renamed from: b */
        String f25260b;

        /* renamed from: d */
        private String f25262d;

        /* renamed from: e */
        private IUiListener f25263e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
            this.f25262d = str;
            this.f25259a = str2;
            this.f25260b = str3;
            this.f25263e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f25263e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f25263e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g.a().a(this.f25262d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f25259a, false);
            IUiListener iUiListener = this.f25263e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f25263e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f25259a;
            } else {
                str = this.f25259a;
            }
            g.a().a(this.f25262d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            a.this.a(str);
            IUiListener iUiListener = this.f25263e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f25263e = null;
            }
        }

        public void a(String str) {
            try {
                onComplete(i.d(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    private class c extends Handler {

        /* renamed from: b */
        private b f25265b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.f25265b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                this.f25265b.a((String) message.obj);
            } else if (i2 == 2) {
                this.f25265b.onCancel();
            } else {
                if (i2 != 3) {
                    return;
                }
                a.b(a.this.k, (String) message.obj);
            }
        }
    }

    class d implements Runnable {

        /* renamed from: a */
        String f25266a;

        public d(String str) {
            this.f25266a = "";
            this.f25266a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.a("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f25266a + " | mRetryUrl: " + a.this.o);
            if (this.f25266a.equals(a.this.o)) {
                a.this.f25245b.onError(new UiError(ErrorCode.PrivateError.PARAM_ERROR, "请求页面超时，请稍后重试！", a.this.o));
                a.this.dismiss();
            }
        }
    }

    static {
        try {
            Context a2 = com.tencent.open.utils.d.a();
            if (a2 != null) {
                if (new File(a2.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME).exists()) {
                    System.load(a2.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME);
                    StringBuilder sb = new StringBuilder();
                    sb.append("-->load lib success:");
                    sb.append(AuthAgent.SECURE_LIB_NAME);
                    f.c("openSDK_LOG.AuthDialog", sb.toString());
                } else {
                    f.c("openSDK_LOG.AuthDialog", "-->fail, because so is not exists:" + AuthAgent.SECURE_LIB_NAME);
                }
            } else {
                f.c("openSDK_LOG.AuthDialog", "-->load lib fail, because context is null:" + AuthAgent.SECURE_LIB_NAME);
            }
        } catch (Exception e2) {
            f.b("openSDK_LOG.AuthDialog", "-->load lib error:" + AuthAgent.SECURE_LIB_NAME, e2);
        }
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.m = false;
        this.q = 0L;
        this.r = 30000L;
        this.k = context;
        this.f25244a = str2;
        this.f25245b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.f25247d = new c(this.f25245b, context.getMainLooper());
        this.f25246c = iUiListener;
        this.f25252i = str;
        this.l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    static /* synthetic */ int m(a aVar) {
        int i2 = aVar.n;
        aVar.n = i2 + 1;
        return i2;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.s.clear();
        this.f25247d.removeCallbacksAndMessages(null);
        if (isShowing()) {
            super.dismiss();
        }
        com.tencent.open.c.c cVar = this.f25253j;
        if (cVar != null) {
            cVar.destroy();
            this.f25253j = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.m) {
            this.f25245b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        b();
        d();
        this.s = new HashMap<>();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.f25253j.setVerticalScrollBarEnabled(false);
        this.f25253j.setHorizontalScrollBarEnabled(false);
        this.f25253j.setWebViewClient(new C0526a());
        this.f25253j.setWebChromeClient(new WebChromeClient());
        this.f25253j.clearFormData();
        this.f25253j.clearSslPreferences();
        this.f25253j.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.connect.auth.a.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.f25253j.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.connect.auth.a.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        WebSettings settings = this.f25253j.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        f.a("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f25244a);
        String str = this.f25244a;
        this.o = str;
        this.f25253j.loadUrl(str);
        this.f25253j.setVisibility(4);
        this.f25253j.getSettings().setSavePassword(false);
        this.l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.connect.auth.a.3
            AnonymousClass3() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    JniInterface.clearAllPWD();
                } catch (Exception unused) {
                }
            }
        });
    }

    public boolean e() {
        com.tencent.connect.auth.b a2 = com.tencent.connect.auth.b.a();
        String c2 = a2.c();
        b.a aVar = new b.a();
        aVar.f25273a = this.f25246c;
        aVar.f25274b = this;
        aVar.f25275c = c2;
        String a3 = a2.a(aVar);
        String str = this.f25244a;
        String substring = str.substring(0, str.indexOf("?"));
        Bundle b2 = i.b(this.f25244a);
        b2.putString("token_key", c2);
        b2.putString("serial", a3);
        b2.putString("browser", "1");
        String str2 = substring + "?" + HttpUtils.encodeUrl(b2);
        this.f25244a = str2;
        return i.a(this.k, str2);
    }

    static /* synthetic */ String a(a aVar, Object obj) {
        String str = aVar.f25244a + obj;
        aVar.f25244a = str;
        return str;
    }

    private void b() {
        c();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.c.c cVar = new com.tencent.open.c.c(this.k);
        this.f25253j = cVar;
        if (Build.VERSION.SDK_INT >= 11) {
            cVar.setLayerType(1, null);
        }
        this.f25253j.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.k);
        this.f25248e = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.f25248e.addView(this.f25253j);
        this.f25248e.addView(this.f25250g);
        setContentView(this.f25248e);
    }

    private void c() {
        TextView textView;
        this.f25251h = new ProgressBar(this.k);
        this.f25251h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f25249f = new LinearLayout(this.k);
        if (this.f25252i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f25249f.setLayoutParams(layoutParams2);
        this.f25249f.addView(this.f25251h);
        if (textView != null) {
            this.f25249f.addView(textView);
        }
        this.f25250g = new FrameLayout(this.k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = 80;
        layoutParams3.rightMargin = 80;
        layoutParams3.topMargin = 40;
        layoutParams3.bottomMargin = 40;
        layoutParams3.gravity = 17;
        this.f25250g.setLayoutParams(layoutParams3);
        this.f25250g.setBackgroundResource(R.drawable.alert_dark_frame);
        this.f25250g.addView(this.f25249f);
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.p) && this.p.length() >= 4) {
            String str2 = this.p;
            String substring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(substring);
        }
        return sb.toString();
    }

    public String a() {
        String str = this.f25244a;
        String str2 = "http://qzs.qq.com/open/mobile/login/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        f.c("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: http://qzs.qq.com/open/mobile/login/qzsjump.html?");
        return str2;
    }

    public static void b(Context context, String str) {
        try {
            JSONObject d2 = i.d(str);
            int i2 = d2.getInt("type");
            Toast.makeText(context.getApplicationContext(), d2.getString("msg"), i2).show();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.f25253j.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }
}
