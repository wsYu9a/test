package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a;
import com.tencent.open.a.f;
import com.tencent.open.b.g;
import com.tencent.open.c.a;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c extends com.tencent.open.b implements a.InterfaceC0532a {

    /* renamed from: c */
    static Toast f25481c;

    /* renamed from: d */
    private String f25482d;

    /* renamed from: e */
    private IUiListener f25483e;

    /* renamed from: f */
    private C0533c f25484f;

    /* renamed from: g */
    private Handler f25485g;

    /* renamed from: h */
    private com.tencent.open.c.a f25486h;

    /* renamed from: i */
    private com.tencent.open.c.b f25487i;

    /* renamed from: j */
    private WeakReference<Context> f25488j;
    private int k;

    private class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            c.this.f25487i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            f.a("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            c.this.f25484f.onError(new UiError(i2, str, str2));
            if (c.this.f25488j != null && c.this.f25488j.get() != null) {
                Toast.makeText((Context) c.this.f25488j.get(), "网络连接异常或系统错误", 0).show();
            }
            c.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            f.a("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(com.tencent.open.utils.f.a().a((Context) c.this.f25488j.get(), "auth://tauth.qq.com/"))) {
                c.this.f25484f.onComplete(i.c(str));
                c.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                c.this.f25484f.onCancel();
                c.this.dismiss();
                return true;
            }
            if (!str.startsWith(Constants.CLOSE_URI)) {
                return false;
            }
            c.this.dismiss();
            return true;
        }

        /* synthetic */ a(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private class b extends a.b {
        private b() {
        }

        /* synthetic */ b(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* renamed from: com.tencent.open.c$c */
    private static class C0533c implements IUiListener {

        /* renamed from: a */
        String f25498a;

        /* renamed from: b */
        String f25499b;

        /* renamed from: c */
        private WeakReference<Context> f25500c;

        /* renamed from: d */
        private String f25501d;

        /* renamed from: e */
        private IUiListener f25502e;

        public C0533c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f25500c = new WeakReference<>(context);
            this.f25501d = str;
            this.f25498a = str2;
            this.f25499b = str3;
            this.f25502e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f25502e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f25502e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g.a().a(this.f25501d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f25498a, false);
            IUiListener iUiListener = this.f25502e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f25502e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f25498a;
            } else {
                str = this.f25498a;
            }
            g a2 = g.a();
            a2.a(this.f25501d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f25502e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f25502e = null;
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

    private class d extends Handler {

        /* renamed from: b */
        private C0533c f25504b;

        public d(C0533c c0533c, Looper looper) {
            super(looper);
            this.f25504b = c0533c;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.b("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.f25504b.a((String) message.obj);
                return;
            }
            if (i2 == 2) {
                this.f25504b.onCancel();
                return;
            }
            if (i2 == 3) {
                if (c.this.f25488j == null || c.this.f25488j.get() == null) {
                    return;
                }
                c.c((Context) c.this.f25488j.get(), (String) message.obj);
                return;
            }
            if (i2 != 5 || c.this.f25488j == null || c.this.f25488j.get() == null) {
                return;
            }
            c.d((Context) c.this.f25488j.get(), (String) message.obj);
        }
    }

    public c(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f25488j = new WeakReference<>(context);
        this.f25482d = str2;
        this.f25484f = new C0533c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f25485g = new d(this.f25484f, context.getMainLooper());
        this.f25483e = iUiListener;
        this.k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        f.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.k);
    }

    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d2 = i.d(str);
            d2.getInt("action");
            d2.getString("msg");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        this.f25487i.setVerticalScrollBarEnabled(false);
        this.f25487i.setHorizontalScrollBarEnabled(false);
        this.f25487i.setWebViewClient(new a());
        this.f25487i.setWebChromeClient(this.f25442b);
        this.f25487i.clearFormData();
        WebSettings settings = this.f25487i.getSettings();
        if (settings == null) {
            return;
        }
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        WeakReference<Context> weakReference = this.f25488j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f25488j.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f25441a.a(new b(), "sdk_js_if");
        this.f25487i.clearView();
        this.f25487i.loadUrl(this.f25482d);
        this.f25487i.getSettings().setSavePassword(false);
    }

    private void b() {
        com.tencent.open.c.a aVar = new com.tencent.open.c.a(this.f25488j.get());
        this.f25486h = aVar;
        aVar.setBackgroundColor(1711276032);
        this.f25486h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f25488j.get());
        this.f25487i = bVar;
        bVar.setBackgroundColor(0);
        this.f25487i.setBackgroundDrawable(null);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f25487i, 1, new Paint());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.k);
        layoutParams.addRule(13, -1);
        this.f25487i.setLayoutParams(layoutParams);
        this.f25486h.addView(this.f25487i);
        this.f25486h.a(this);
        setContentView(this.f25486h);
    }

    @Override // com.tencent.open.c.a.InterfaceC0532a
    public void a(int i2) {
        WeakReference<Context> weakReference = this.f25488j;
        if (weakReference != null && weakReference.get() != null) {
            if (i2 < this.k && 2 == this.f25488j.get().getResources().getConfiguration().orientation) {
                this.f25487i.getLayoutParams().height = i2;
            } else {
                this.f25487i.getLayoutParams().height = this.k;
            }
        }
        f.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.c.a.InterfaceC0532a
    public void a() {
        this.f25487i.getLayoutParams().height = this.k;
        f.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.b
    protected void a(String str) {
        f.b("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.f25441a.a(this.f25487i, str);
        } catch (Exception unused) {
        }
    }

    public static void c(Context context, String str) {
        try {
            JSONObject d2 = i.d(str);
            int i2 = d2.getInt("type");
            String string = d2.getString("msg");
            if (i2 == 0) {
                Toast toast = f25481c;
                if (toast == null) {
                    f25481c = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f25481c.setText(string);
                    f25481c.setDuration(0);
                }
                f25481c.show();
                return;
            }
            if (i2 == 1) {
                Toast toast2 = f25481c;
                if (toast2 == null) {
                    f25481c = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f25481c.setText(string);
                    f25481c.setDuration(1);
                }
                f25481c.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
