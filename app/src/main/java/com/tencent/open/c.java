package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
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
public class c extends com.tencent.open.b implements a.InterfaceC0661a {

    /* renamed from: c */
    static Toast f23214c;

    /* renamed from: d */
    private String f23215d;

    /* renamed from: e */
    private IUiListener f23216e;

    /* renamed from: f */
    private C0662c f23217f;

    /* renamed from: g */
    private Handler f23218g;

    /* renamed from: h */
    private com.tencent.open.c.a f23219h;

    /* renamed from: i */
    private com.tencent.open.c.b f23220i;

    /* renamed from: j */
    private WeakReference<Context> f23221j;

    /* renamed from: k */
    private int f23222k;

    public class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            c.this.f23220i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            f.a("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            c.this.f23217f.onError(new UiError(i10, str, str2));
            if (c.this.f23221j != null && c.this.f23221j.get() != null) {
                Toast.makeText((Context) c.this.f23221j.get(), "网络连接异常或系统错误", 0).show();
            }
            c.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            f.a("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(com.tencent.open.utils.f.a().a((Context) c.this.f23221j.get(), "auth://tauth.qq.com/"))) {
                c.this.f23217f.onComplete(i.c(str));
                c.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                c.this.f23217f.onCancel();
                c.this.dismiss();
                return true;
            }
            if (!str.startsWith(Constants.CLOSE_URI)) {
                return false;
            }
            c.this.dismiss();
            return true;
        }

        public /* synthetic */ a(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class b extends a.b {
        private b() {
        }

        public /* synthetic */ b(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* renamed from: com.tencent.open.c$c */
    public static class C0662c implements IUiListener {

        /* renamed from: a */
        String f23232a;

        /* renamed from: b */
        String f23233b;

        /* renamed from: c */
        private WeakReference<Context> f23234c;

        /* renamed from: d */
        private String f23235d;

        /* renamed from: e */
        private IUiListener f23236e;

        public C0662c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f23234c = new WeakReference<>(context);
            this.f23235d = str;
            this.f23232a = str2;
            this.f23233b = str3;
            this.f23236e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f23236e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f23236e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g.a().a(this.f23235d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f23232a, false);
            IUiListener iUiListener = this.f23236e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f23236e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f23232a;
            } else {
                str = this.f23232a;
            }
            String str2 = str;
            g.a().a(this.f23235d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str2, false);
            IUiListener iUiListener = this.f23236e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f23236e = null;
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

    public class d extends Handler {

        /* renamed from: b */
        private C0662c f23238b;

        public d(C0662c c0662c, Looper looper) {
            super(looper);
            this.f23238b = c0662c;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.b("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i10 = message.what;
            if (i10 == 1) {
                this.f23238b.a((String) message.obj);
                return;
            }
            if (i10 == 2) {
                this.f23238b.onCancel();
                return;
            }
            if (i10 == 3) {
                if (c.this.f23221j == null || c.this.f23221j.get() == null) {
                    return;
                }
                c.c((Context) c.this.f23221j.get(), (String) message.obj);
                return;
            }
            if (i10 != 5 || c.this.f23221j == null || c.this.f23221j.get() == null) {
                return;
            }
            c.d((Context) c.this.f23221j.get(), (String) message.obj);
        }
    }

    public c(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f23221j = new WeakReference<>(context);
        this.f23215d = str2;
        this.f23217f = new C0662c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f23218g = new d(this.f23217f, context.getMainLooper());
        this.f23216e = iUiListener;
        this.f23222k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        f.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.f23222k);
    }

    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d10 = i.d(str);
            d10.getInt("action");
            d10.getString("msg");
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        this.f23220i.setVerticalScrollBarEnabled(false);
        this.f23220i.setHorizontalScrollBarEnabled(false);
        this.f23220i.setWebViewClient(new a());
        this.f23220i.setWebChromeClient(this.f23175b);
        this.f23220i.clearFormData();
        WebSettings settings = this.f23220i.getSettings();
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
        WeakReference<Context> weakReference = this.f23221j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f23221j.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f23174a.a(new b(), "sdk_js_if");
        this.f23220i.clearView();
        this.f23220i.loadUrl(this.f23215d);
        this.f23220i.getSettings().setSavePassword(false);
    }

    private void b() {
        com.tencent.open.c.a aVar = new com.tencent.open.c.a(this.f23221j.get());
        this.f23219h = aVar;
        aVar.setBackgroundColor(1711276032);
        this.f23219h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f23221j.get());
        this.f23220i = bVar;
        bVar.setBackgroundColor(0);
        this.f23220i.setBackgroundDrawable(null);
        try {
            View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f23220i, 1, new Paint());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f23222k);
        layoutParams.addRule(13, -1);
        this.f23220i.setLayoutParams(layoutParams);
        this.f23219h.addView(this.f23220i);
        this.f23219h.a(this);
        setContentView(this.f23219h);
    }

    @Override // com.tencent.open.c.a.InterfaceC0661a
    public void a(int i10) {
        WeakReference<Context> weakReference = this.f23221j;
        if (weakReference != null && weakReference.get() != null) {
            if (i10 < this.f23222k && 2 == this.f23221j.get().getResources().getConfiguration().orientation) {
                this.f23220i.getLayoutParams().height = i10;
            } else {
                this.f23220i.getLayoutParams().height = this.f23222k;
            }
        }
        f.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.c.a.InterfaceC0661a
    public void a() {
        this.f23220i.getLayoutParams().height = this.f23222k;
        f.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        f.b("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.f23174a.a(this.f23220i, str);
        } catch (Exception unused) {
        }
    }

    public static void c(Context context, String str) {
        try {
            JSONObject d10 = i.d(str);
            int i10 = d10.getInt("type");
            String string = d10.getString("msg");
            if (i10 == 0) {
                Toast toast = f23214c;
                if (toast == null) {
                    f23214c = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f23214c.setText(string);
                    f23214c.setDuration(0);
                }
                f23214c.show();
                return;
            }
            if (i10 == 1) {
                Toast toast2 = f23214c;
                if (toast2 == null) {
                    f23214c = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f23214c.setText(string);
                    f23214c.setDuration(1);
                }
                f23214c.show();
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }
}
