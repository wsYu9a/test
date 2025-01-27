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
    static final FrameLayout.LayoutParams f23100c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d */
    static Toast f23101d = null;

    /* renamed from: f */
    private static WeakReference<ProgressDialog> f23102f;

    /* renamed from: e */
    private WeakReference<Context> f23103e;

    /* renamed from: g */
    private String f23104g;

    /* renamed from: h */
    private OnTimeListener f23105h;

    /* renamed from: i */
    private IUiListener f23106i;

    /* renamed from: j */
    private FrameLayout f23107j;

    /* renamed from: k */
    private com.tencent.open.c.b f23108k;

    /* renamed from: l */
    private Handler f23109l;

    /* renamed from: m */
    private boolean f23110m;

    /* renamed from: n */
    private QQToken f23111n;

    public class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.f23108k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            f.a("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            TDialog.this.f23105h.onError(new UiError(i10, str, str2));
            if (TDialog.this.f23103e != null && TDialog.this.f23103e.get() != null) {
                Toast.makeText((Context) TDialog.this.f23103e.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            f.a("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(com.tencent.open.utils.f.a().a((Context) TDialog.this.f23103e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f23105h.onComplete(i.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f23105h.onCancel();
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
                intent.addFlags(268435456);
                if (TDialog.this.f23103e != null && TDialog.this.f23103e.get() != null) {
                    ((Context) TDialog.this.f23103e.get()).startActivity(intent);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return true;
        }

        public /* synthetic */ FbWebViewClient(TDialog tDialog, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class JsListener extends a.b {
        private JsListener() {
        }

        public void onAddShare(String str) {
            f.b("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            f.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.f23109l.obtainMessage(2, str).sendToTarget();
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
            TDialog.this.f23109l.obtainMessage(1, str).sendToTarget();
            f.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onLoad(String str) {
            TDialog.this.f23109l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.f23109l.obtainMessage(3, str).sendToTarget();
        }

        public /* synthetic */ JsListener(TDialog tDialog, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class OnTimeListener implements IUiListener {

        /* renamed from: a */
        String f23114a;

        /* renamed from: b */
        String f23115b;

        /* renamed from: c */
        private WeakReference<Context> f23116c;

        /* renamed from: d */
        private String f23117d;

        /* renamed from: e */
        private IUiListener f23118e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f23116c = new WeakReference<>(context);
            this.f23117d = str;
            this.f23114a = str2;
            this.f23115b = str3;
            this.f23118e = iUiListener;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f23118e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f23118e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g.a().a(this.f23117d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f23114a, false);
            IUiListener iUiListener = this.f23118e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f23118e = null;
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f23114a;
            } else {
                str = this.f23114a;
            }
            String str2 = str;
            g.a().a(this.f23117d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str2, false);
            IUiListener iUiListener = this.f23118e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f23118e = null;
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

    public class THandler extends Handler {

        /* renamed from: b */
        private OnTimeListener f23120b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f23120b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.b("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i10 = message.what;
            if (i10 == 1) {
                this.f23120b.a((String) message.obj);
                return;
            }
            if (i10 == 2) {
                this.f23120b.onCancel();
                return;
            }
            if (i10 == 3) {
                if (TDialog.this.f23103e == null || TDialog.this.f23103e.get() == null) {
                    return;
                }
                TDialog.c((Context) TDialog.this.f23103e.get(), (String) message.obj);
                return;
            }
            if (i10 != 5 || TDialog.this.f23103e == null || TDialog.this.f23103e.get() == null) {
                return;
            }
            TDialog.d((Context) TDialog.this.f23103e.get(), (String) message.obj);
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f23110m = false;
        this.f23111n = null;
        this.f23103e = new WeakReference<>(context);
        this.f23104g = str2;
        this.f23105h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f23109l = new THandler(this.f23105h, context.getMainLooper());
        this.f23106i = iUiListener;
        this.f23111n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f23105h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    @Override // com.tencent.open.b, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a();
        b();
    }

    public static void c(Context context, String str) {
        try {
            JSONObject d10 = i.d(str);
            int i10 = d10.getInt("type");
            String string = d10.getString("msg");
            if (i10 == 0) {
                Toast toast = f23101d;
                if (toast == null) {
                    f23101d = Toast.makeText(context, string, 0);
                } else {
                    toast.setView(toast.getView());
                    f23101d.setText(string);
                    f23101d.setDuration(0);
                }
                f23101d.show();
                return;
            }
            if (i10 == 1) {
                Toast toast2 = f23101d;
                if (toast2 == null) {
                    f23101d = Toast.makeText(context, string, 1);
                } else {
                    toast2.setView(toast2.getView());
                    f23101d.setText(string);
                    f23101d.setDuration(1);
                }
                f23101d.show();
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject d10 = i.d(str);
            int i10 = d10.getInt("action");
            String string = d10.getString("msg");
            if (i10 == 1) {
                WeakReference<ProgressDialog> weakReference = f23102f;
                if (weakReference != null && weakReference.get() != null) {
                    f23102f.get().setMessage(string);
                    if (!f23102f.get().isShowing()) {
                        f23102f.get().show();
                    }
                }
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setMessage(string);
                f23102f = new WeakReference<>(progressDialog);
                progressDialog.show();
            } else if (i10 == 0) {
                WeakReference<ProgressDialog> weakReference2 = f23102f;
                if (weakReference2 == null) {
                    return;
                }
                if (weakReference2.get() != null && f23102f.get().isShowing()) {
                    f23102f.get().dismiss();
                    f23102f = null;
                }
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    private void a() {
        new TextView(this.f23103e.get()).setText("test");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.c.b bVar = new com.tencent.open.c.b(this.f23103e.get());
        this.f23108k = bVar;
        bVar.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(this.f23103e.get());
        this.f23107j = frameLayout;
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        this.f23107j.addView(this.f23108k);
        setContentView(this.f23107j);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.f23108k.setVerticalScrollBarEnabled(false);
        this.f23108k.setHorizontalScrollBarEnabled(false);
        this.f23108k.setWebViewClient(new FbWebViewClient());
        this.f23108k.setWebChromeClient(this.f23175b);
        this.f23108k.clearFormData();
        WebSettings settings = this.f23108k.getSettings();
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
        WeakReference<Context> weakReference = this.f23103e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f23103e.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f23174a.a(new JsListener(), "sdk_js_if");
        this.f23108k.loadUrl(this.f23104g);
        this.f23108k.setLayoutParams(f23100c);
        this.f23108k.setVisibility(4);
        this.f23108k.getSettings().setSavePassword(false);
    }

    @Override // com.tencent.open.b
    public void a(String str) {
        f.b("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f23174a.a(this.f23108k, str);
        } catch (Exception unused) {
        }
    }
}
