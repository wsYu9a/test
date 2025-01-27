package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a;
import com.tencent.open.a.f;
import com.tencent.open.b.g;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TDialog extends b {

    /* renamed from: c */
    static final FrameLayout.LayoutParams f25376c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d */
    static Toast f25377d = null;

    /* renamed from: f */
    private static WeakReference<ProgressDialog> f25378f;

    /* renamed from: e */
    private WeakReference<Context> f25379e;

    /* renamed from: g */
    private String f25380g;

    /* renamed from: h */
    private OnTimeListener f25381h;

    /* renamed from: i */
    private IUiListener f25382i;

    /* renamed from: j */
    private FrameLayout f25383j;
    private com.tencent.open.c.b k;
    private Handler l;
    private boolean m;
    private QQToken n;

    private class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            f.a("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            TDialog.this.f25381h.onError(new UiError(i2, str, str2));
            if (TDialog.this.f25379e != null && TDialog.this.f25379e.get() != null) {
                Toast.makeText((Context) TDialog.this.f25379e.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            f.a("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(com.tencent.open.utils.f.a().a((Context) TDialog.this.f25379e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f25381h.onComplete(i.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f25381h.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (!str.startsWith(Constants.DOWNLOAD_URI)) {
                return str.startsWith("auth://progress");
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(str.substring(11))));
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                if (TDialog.this.f25379e != null && TDialog.this.f25379e.get() != null) {
                    ((Context) TDialog.this.f25379e.get()).startActivity(intent);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        }

        /* synthetic */ FbWebViewClient(TDialog tDialog, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private class JsListener extends a.b {
        private JsListener() {
        }

        public void onAddShare(String str) {
            f.b("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            f.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.l.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void onCancelAddShare(String str) {
            f.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel("cancel");
        }

        public void onCancelInvite() {
            f.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.l.obtainMessage(1, str).sendToTarget();
            f.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onLoad(String str) {
            TDialog.this.l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.l.obtainMessage(3, str).sendToTarget();
        }

        /* synthetic */ JsListener(TDialog tDialog, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static class OnTimeListener implements IUiListener {

        /* renamed from: a */
        String f25386a;

        /* renamed from: b */
        String f25387b;

        /* renamed from: c */
        private WeakReference<Context> f25388c;

        /* renamed from: d */
        private String f25389d;

        /* renamed from: e */
        private IUiListener f25390e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f25388c = new WeakReference<>(context);
            this.f25389d = str;
            this.f25386a = str2;
            this.f25387b = str3;
            this.f25390e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f25390e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f25390e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g.a().a(this.f25389d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f25386a, false);
            IUiListener iUiListener = this.f25390e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f25390e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f25386a;
            } else {
                str = this.f25386a;
            }
            g a2 = g.a();
            a2.a(this.f25389d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f25390e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f25390e = null;
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

    private class THandler extends Handler {

        /* renamed from: b */
        private OnTimeListener f25392b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f25392b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.b("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.f25392b.a((String) message.obj);
                return;
            }
            if (i2 == 2) {
                this.f25392b.onCancel();
                return;
            }
            if (i2 == 3) {
                if (TDialog.this.f25379e == null || TDialog.this.f25379e.get() == null) {
                    return;
                }
                TDialog.c((Context) TDialog.this.f25379e.get(), (String) message.obj);
                return;
            }
            if (i2 != 5 || TDialog.this.f25379e == null || TDialog.this.f25379e.get() == null) {
                return;
            }
            TDialog.d((Context) TDialog.this.f25379e.get(), (String) message.obj);
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.m = false;
        this.n = null;
        this.f25379e = new WeakReference<>(context);
        this.f25380g = str2;
        this.f25381h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.l = new THandler(this.f25381h, context.getMainLooper());
        this.f25382i = iUiListener;
        this.n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f25381h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a();
        b();
    }

    public static void c(Context context, String str) {
        try {
            JSONObject d2 = i.d(str);
            int i2 = d2.getInt("type");
            String string = d2.getString("msg");
            if (i2 == 0) {
                Toast toast = f25377d;
                if (toast == null) {
                    f25377d = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f25377d.setText(string);
                    f25377d.setDuration(0);
                }
                f25377d.show();
                return;
            }
            if (i2 == 1) {
                Toast toast2 = f25377d;
                if (toast2 == null) {
                    f25377d = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f25377d.setText(string);
                    f25377d.setDuration(1);
                }
                f25377d.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d2 = i.d(str);
            int i2 = d2.getInt("action");
            String string = d2.getString("msg");
            if (i2 == 1) {
                WeakReference<ProgressDialog> weakReference = f25378f;
                if (weakReference != null && weakReference.get() != null) {
                    f25378f.get().setMessage(string);
                    if (!f25378f.get().isShowing()) {
                        f25378f.get().show();
                    }
                }
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setMessage(string);
                f25378f = new WeakReference<>(progressDialog);
                progressDialog.show();
            } else if (i2 == 0) {
                WeakReference<ProgressDialog> weakReference2 = f25378f;
                if (weakReference2 == null) {
                    return;
                }
                if (weakReference2.get() != null && f25378f.get().isShowing()) {
                    f25378f.get().dismiss();
                    f25378f = null;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a() {
        new TextView(this.f25379e.get()).setText("test");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f25379e.get());
        this.k = bVar;
        bVar.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.f25379e.get());
        this.f25383j = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.f25383j.addView(this.k);
        setContentView(this.f25383j);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.k.setVerticalScrollBarEnabled(false);
        this.k.setHorizontalScrollBarEnabled(false);
        this.k.setWebViewClient(new FbWebViewClient());
        this.k.setWebChromeClient(this.f25442b);
        this.k.clearFormData();
        WebSettings settings = this.k.getSettings();
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
        WeakReference<Context> weakReference = this.f25379e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f25379e.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f25441a.a(new JsListener(), "sdk_js_if");
        this.k.loadUrl(this.f25380g);
        this.k.setLayoutParams(f25376c);
        this.k.setVisibility(4);
        this.k.getSettings().setSavePassword(false);
    }

    @Override // com.tencent.open.b
    protected void a(String str) {
        f.b("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f25441a.a(this.k, str);
        } catch (Exception unused) {
        }
    }
}
