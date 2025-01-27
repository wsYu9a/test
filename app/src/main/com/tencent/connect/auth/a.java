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
    private String f22959a;

    /* renamed from: b */
    private b f22960b;

    /* renamed from: c */
    private IUiListener f22961c;

    /* renamed from: d */
    private Handler f22962d;

    /* renamed from: e */
    private FrameLayout f22963e;

    /* renamed from: f */
    private LinearLayout f22964f;

    /* renamed from: g */
    private FrameLayout f22965g;

    /* renamed from: h */
    private ProgressBar f22966h;

    /* renamed from: i */
    private String f22967i;

    /* renamed from: j */
    private com.tencent.open.c.c f22968j;

    /* renamed from: k */
    private Context f22969k;

    /* renamed from: l */
    private com.tencent.open.web.security.b f22970l;

    /* renamed from: m */
    private boolean f22971m;

    /* renamed from: n */
    private int f22972n;

    /* renamed from: o */
    private String f22973o;

    /* renamed from: p */
    private String f22974p;

    /* renamed from: q */
    private long f22975q;

    /* renamed from: r */
    private long f22976r;

    /* renamed from: s */
    private HashMap<String, Runnable> f22977s;

    /* renamed from: com.tencent.connect.auth.a$1 */
    public class AnonymousClass1 implements View.OnLongClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* renamed from: com.tencent.connect.auth.a$2 */
    public class AnonymousClass2 implements View.OnTouchListener {
        public AnonymousClass2() {
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
    public class AnonymousClass3 implements DialogInterface.OnDismissListener {
        public AnonymousClass3() {
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
    public class C0655a extends WebViewClient {

        /* renamed from: com.tencent.connect.auth.a$a$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f22968j.loadUrl(a.this.f22973o);
            }
        }

        private C0655a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            f.a("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            a.this.f22965g.setVisibility(8);
            if (a.this.f22968j != null) {
                a.this.f22968j.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a.this.f22962d.removeCallbacks((Runnable) a.this.f22977s.remove(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            f.a("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            a.this.f22965g.setVisibility(0);
            a.this.f22975q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.f22973o)) {
                a.this.f22962d.removeCallbacks((Runnable) a.this.f22977s.remove(a.this.f22973o));
            }
            a.this.f22973o = str;
            a aVar = a.this;
            d dVar = aVar.new d(aVar.f22973o);
            a.this.f22977s.put(str, dVar);
            a.this.f22962d.postDelayed(dVar, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            f.c("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i10 + " | description: " + str);
            if (!i.c(a.this.f22969k)) {
                a.this.f22960b.onError(new UiError(ErrorCode.PrivateError.LOAD_FAIL, "当前网络不可用，请稍后重试！", str2));
                a.this.dismiss();
                return;
            }
            if (a.this.f22973o.startsWith("http://qzs.qq.com/open/mobile/login/qzsjump.html?")) {
                a.this.f22960b.onError(new UiError(i10, str, str2));
                a.this.dismiss();
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f22975q;
            if (a.this.f22972n >= 1 || elapsedRealtime >= a.this.f22976r) {
                a.this.f22968j.loadUrl(a.this.a());
            } else {
                a.m(a.this);
                a.this.f22962d.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.a.a.1
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f22968j.loadUrl(a.this.f22973o);
                    }
                }, 500L);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
            a.this.f22960b.onError(new UiError(sslError.getPrimaryError(), "请求不合法，请检查手机安全设置，如系统时间、代理等。", "ssl error"));
            a.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            List<String> pathSegments;
            f.a("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject c10 = i.c(str);
                a aVar = a.this;
                aVar.f22971m = aVar.e();
                if (!a.this.f22971m) {
                    if (c10.optString("fail_cb", null) != null) {
                        a.this.a(c10.optString("fail_cb"), "");
                    } else if (c10.optInt("fall_to_wv") == 1) {
                        a aVar2 = a.this;
                        a.a(aVar2, (Object) (aVar2.f22959a.indexOf("?") > -1 ? "&" : "?"));
                        a.a(a.this, (Object) "browser_error=1");
                        a.this.f22968j.loadUrl(a.this.f22959a);
                    } else {
                        String optString = c10.optString("redir", null);
                        if (optString != null) {
                            a.this.f22968j.loadUrl(optString);
                        }
                    }
                }
                return true;
            }
            if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.f22960b.onComplete(i.c(str));
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                a.this.f22960b.onCancel();
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
                    intent.addFlags(268435456);
                    a.this.f22969k.startActivity(intent);
                } catch (Exception e10) {
                    f.b("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e10);
                }
                return true;
            }
            if (!str.startsWith("auth://progress")) {
                if (str.startsWith("auth://onLoginSubmit")) {
                    try {
                        List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                        if (!pathSegments2.isEmpty()) {
                            a.this.f22974p = pathSegments2.get(0);
                        }
                    } catch (Exception unused) {
                    }
                    return true;
                }
                if (a.this.f22970l.a(a.this.f22968j, str)) {
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
                a.this.f22965g.setVisibility(8);
                a.this.f22968j.setVisibility(0);
            } else if (intValue == 1) {
                a.this.f22965g.setVisibility(0);
            }
            return true;
        }

        public /* synthetic */ C0655a(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class b implements IUiListener {

        /* renamed from: a */
        String f22983a;

        /* renamed from: b */
        String f22984b;

        /* renamed from: d */
        private String f22986d;

        /* renamed from: e */
        private IUiListener f22987e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
            this.f22986d = str;
            this.f22983a = str2;
            this.f22984b = str3;
            this.f22987e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f22987e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f22987e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g.a().a(this.f22986d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f22983a, false);
            IUiListener iUiListener = this.f22987e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f22987e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f22983a;
            } else {
                str = this.f22983a;
            }
            g.a().a(this.f22986d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            a.this.a(str);
            IUiListener iUiListener = this.f22987e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f22987e = null;
            }
        }

        public void a(String str) {
            try {
                onComplete(i.d(str));
            } catch (JSONException e10) {
                e10.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    public class c extends Handler {

        /* renamed from: b */
        private b f22989b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.f22989b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                this.f22989b.a((String) message.obj);
            } else if (i10 == 2) {
                this.f22989b.onCancel();
            } else {
                if (i10 != 3) {
                    return;
                }
                a.b(a.this.f22969k, (String) message.obj);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: a */
        String f22990a;

        public d(String str) {
            this.f22990a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.a("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f22990a + " | mRetryUrl: " + a.this.f22973o);
            if (this.f22990a.equals(a.this.f22973o)) {
                a.this.f22960b.onError(new UiError(ErrorCode.PrivateError.PARAM_ERROR, "请求页面超时，请稍后重试！", a.this.f22973o));
                a.this.dismiss();
            }
        }
    }

    static {
        try {
            Context a10 = com.tencent.open.utils.d.a();
            if (a10 != null) {
                if (new File(a10.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME).exists()) {
                    System.load(a10.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("-->load lib success:");
                    sb2.append(AuthAgent.SECURE_LIB_NAME);
                    f.c("openSDK_LOG.AuthDialog", sb2.toString());
                } else {
                    f.c("openSDK_LOG.AuthDialog", "-->fail, because so is not exists:" + AuthAgent.SECURE_LIB_NAME);
                }
            } else {
                f.c("openSDK_LOG.AuthDialog", "-->load lib fail, because context is null:" + AuthAgent.SECURE_LIB_NAME);
            }
        } catch (Exception e10) {
            f.b("openSDK_LOG.AuthDialog", "-->load lib error:" + AuthAgent.SECURE_LIB_NAME, e10);
        }
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f22971m = false;
        this.f22975q = 0L;
        this.f22976r = 30000L;
        this.f22969k = context;
        this.f22959a = str2;
        this.f22960b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.f22962d = new c(this.f22960b, context.getMainLooper());
        this.f22961c = iUiListener;
        this.f22967i = str;
        this.f22970l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    public static /* synthetic */ int m(a aVar) {
        int i10 = aVar.f22972n;
        aVar.f22972n = i10 + 1;
        return i10;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f22977s.clear();
        this.f22962d.removeCallbacksAndMessages(null);
        if (isShowing()) {
            super.dismiss();
        }
        com.tencent.open.c.c cVar = this.f22968j;
        if (cVar != null) {
            cVar.destroy();
            this.f22968j = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.f22971m) {
            this.f22960b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        b();
        d();
        this.f22977s = new HashMap<>();
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.f22968j.setVerticalScrollBarEnabled(false);
        this.f22968j.setHorizontalScrollBarEnabled(false);
        this.f22968j.setWebViewClient(new C0655a());
        this.f22968j.setWebChromeClient(new WebChromeClient());
        this.f22968j.clearFormData();
        this.f22968j.clearSslPreferences();
        this.f22968j.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.connect.auth.a.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.f22968j.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.connect.auth.a.2
            public AnonymousClass2() {
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
        WebSettings settings = this.f22968j.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f22969k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        f.a("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f22959a);
        String str = this.f22959a;
        this.f22973o = str;
        this.f22968j.loadUrl(str);
        this.f22968j.setVisibility(4);
        this.f22968j.getSettings().setSavePassword(false);
        this.f22970l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.connect.auth.a.3
            public AnonymousClass3() {
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
        com.tencent.connect.auth.b a10 = com.tencent.connect.auth.b.a();
        String c10 = a10.c();
        b.a aVar = new b.a();
        aVar.f22997a = this.f22961c;
        aVar.f22998b = this;
        aVar.f22999c = c10;
        String a11 = a10.a(aVar);
        String str = this.f22959a;
        String substring = str.substring(0, str.indexOf("?"));
        Bundle b10 = i.b(this.f22959a);
        b10.putString("token_key", c10);
        b10.putString("serial", a11);
        b10.putString("browser", "1");
        String str2 = substring + "?" + HttpUtils.encodeUrl(b10);
        this.f22959a = str2;
        return i.a(this.f22969k, str2);
    }

    public static /* synthetic */ String a(a aVar, Object obj) {
        String str = aVar.f22959a + obj;
        aVar.f22959a = str;
        return str;
    }

    private void b() {
        c();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.c.c cVar = new com.tencent.open.c.c(this.f22969k);
        this.f22968j = cVar;
        cVar.setLayerType(1, null);
        this.f22968j.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.f22969k);
        this.f22963e = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.f22963e.addView(this.f22968j);
        this.f22963e.addView(this.f22965g);
        setContentView(this.f22963e);
    }

    private void c() {
        TextView textView;
        this.f22966h = new ProgressBar(this.f22969k);
        this.f22966h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f22964f = new LinearLayout(this.f22969k);
        if (this.f22967i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.f22969k);
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
        this.f22964f.setLayoutParams(layoutParams2);
        this.f22964f.addView(this.f22966h);
        if (textView != null) {
            this.f22964f.addView(textView);
        }
        this.f22965g = new FrameLayout(this.f22969k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = 80;
        layoutParams3.rightMargin = 80;
        layoutParams3.topMargin = 40;
        layoutParams3.bottomMargin = 40;
        layoutParams3.gravity = 17;
        this.f22965g.setLayoutParams(layoutParams3);
        this.f22965g.setBackgroundResource(R.drawable.alert_dark_frame);
        this.f22965g.addView(this.f22964f);
    }

    public String a(String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.f22974p) && this.f22974p.length() >= 4) {
            String str2 = this.f22974p;
            String substring = str2.substring(str2.length() - 4);
            sb2.append("_u_");
            sb2.append(substring);
        }
        return sb2.toString();
    }

    public String a() {
        String str = this.f22959a;
        String str2 = "http://qzs.qq.com/open/mobile/login/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        f.c("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: http://qzs.qq.com/open/mobile/login/qzsjump.html?");
        return str2;
    }

    public static void b(Context context, String str) {
        try {
            JSONObject d10 = i.d(str);
            int i10 = d10.getInt("type");
            Toast.makeText(context.getApplicationContext(), d10.getString("msg"), i10).show();
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.f22968j.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }
}
