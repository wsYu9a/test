package com.sigmob.sdk.base.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.AdPrivacy;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.windad.WindAdRequest;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class q extends Dialog implements DialogInterface.OnShowListener, DialogInterface.OnDismissListener {

    /* renamed from: a */
    public g f18838a;

    /* renamed from: b */
    public Map<String, String> f18839b;

    /* renamed from: c */
    public Context f18840c;

    /* renamed from: d */
    public Window f18841d;

    /* renamed from: e */
    public int f18842e;

    /* renamed from: f */
    public int f18843f;

    /* renamed from: g */
    public int f18844g;

    /* renamed from: h */
    public int f18845h;

    /* renamed from: i */
    public com.sigmob.sdk.base.views.g f18846i;

    /* renamed from: j */
    public BaseAdUnit f18847j;

    /* renamed from: k */
    public boolean f18848k;

    /* renamed from: l */
    public ImageView f18849l;

    /* renamed from: m */
    public String f18850m;

    /* renamed from: n */
    public File f18851n;

    /* renamed from: o */
    public boolean f18852o;

    /* renamed from: p */
    public RelativeLayout f18853p;

    /* renamed from: q */
    public Handler f18854q;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q.this.f18838a != null) {
                q.this.f18838a.a();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q.this.f18852o) {
                return;
            }
            q.this.a();
        }
    }

    public class c extends WebChromeClient {
        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (e.f18859a[consoleMessage.messageLevel().ordinal()] != 1) {
                return false;
            }
            SigmobLog.e("onConsoleMessage " + consoleMessage.message());
            com.sigmob.sdk.base.common.b0.a("h5_error", "download_dialog", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, q.this.f18847j, (b0.g) null);
            return false;
        }
    }

    public class d extends WebViewClient {
        public d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            com.sigmob.sdk.base.common.b0.a("h5_error", "download_dialog", 0, str2 + " error:" + str, (WindAdRequest) null, (LoadAdRequest) null, q.this.f18847j, (b0.g) null);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            com.sigmob.sdk.base.common.b0.a("h5_error", "download_dialog", 0, webResourceRequest.getUrl() + " error:" + webResourceResponse.getStatusCode(), (WindAdRequest) null, (LoadAdRequest) null, q.this.f18847j, (b0.g) null);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            SigmobLog.i("onReceivedSslError:" + sslError.toString());
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return com.sigmob.sdk.base.h.a(webResourceRequest.getUrl());
            } catch (Throwable unused) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                SigmobLog.i("shouldOverrideUrlLoading:" + str);
                Uri parse = Uri.parse(str);
                if (StringUtil.scheme().equalsIgnoreCase(parse.getScheme())) {
                    String host = parse.getHost();
                    if (!TextUtils.isEmpty(host)) {
                        if ("useCustomClose".equals(host)) {
                            q.this.f18852o = true;
                            q.this.f18854q.removeCallbacksAndMessages(null);
                        } else if ("closeFourElements".equals(host)) {
                            if (q.this.f18838a != null) {
                                q.this.f18838a.a();
                            }
                        } else if ("buttonClick".equals(host)) {
                            Map<String, String> queryParamMap = ClientMetadata.getQueryParamMap(parse);
                            String str2 = queryParamMap.get("url");
                            String str3 = queryParamMap.get("x");
                            String str4 = "0";
                            if (TextUtils.isEmpty(str3)) {
                                str3 = "0";
                            }
                            String str5 = queryParamMap.get("y");
                            if (!TextUtils.isEmpty(str5)) {
                                str4 = str5;
                            }
                            String format = String.format("%s,%s,%s,%s", str3, str4, str3, str4);
                            q.this.f18847j.getMacroCommon().updateClickMarco(str3, str4, str3, str4);
                            q.this.f18847j.getClickCommon().down = new TouchLocation(Integer.parseInt(str3), Integer.parseInt(str4));
                            q.this.f18847j.getClickCommon().up = new TouchLocation(Integer.parseInt(str3), Integer.parseInt(str4));
                            if (q.this.f18838a != null) {
                                q.this.f18838a.a(str2, format);
                            }
                        }
                        return true;
                    }
                }
            } catch (Throwable th2) {
                SigmobLog.e("DownloadDialog:" + th2.getMessage());
            }
            if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
                webView.loadUrl(str);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            CharSequence description;
            SigmobLog.i("onReceivedError:" + webResourceError.toString());
            if (Build.VERSION.SDK_INT >= 23) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(webResourceRequest.getUrl());
                sb2.append(" error:");
                description = webResourceError.getDescription();
                sb2.append((Object) description);
                com.sigmob.sdk.base.common.b0.a("h5_error", "download_dialog", 0, sb2.toString(), (WindAdRequest) null, (LoadAdRequest) null, q.this.f18847j, (b0.g) null);
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            try {
                return com.sigmob.sdk.base.h.a(Uri.parse(str));
            } catch (Throwable unused) {
                return super.shouldInterceptRequest(webView, str);
            }
        }
    }

    public static /* synthetic */ class e {

        /* renamed from: a */
        public static final /* synthetic */ int[] f18859a;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            f18859a = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class f {

        /* renamed from: a */
        public Map<String, String> f18860a;

        public f(Map<String, String> map) {
            this.f18860a = map;
        }

        @JavascriptInterface
        public String getPrivacyInfo() {
            try {
                Map<String, String> map = this.f18860a;
                if (map == null || map.size() <= 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : this.f18860a.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                return jSONObject.toString();
            } catch (Throwable th2) {
                th2.printStackTrace();
                return null;
            }
        }
    }

    public interface g {
        void a();

        void a(String str, String str2);

        void b();
    }

    public q(Context context, BaseAdUnit baseAdUnit) {
        super(context, com.sigmob.sdk.base.g.j());
        this.f18841d = null;
        this.f18848k = false;
        this.f18850m = "";
        this.f18840c = context.getApplicationContext();
        this.f18847j = baseAdUnit;
        this.f18846i = c();
        this.f18849l = d();
        this.f18844g = ClientMetadata.getInstance().getDisplayMetrics().widthPixels;
        int i10 = ClientMetadata.getInstance().getDisplayMetrics().heightPixels;
        this.f18845h = i10;
        this.f18842e = i10;
        this.f18843f = this.f18844g;
    }

    public final void f() {
        Window window = getWindow();
        this.f18841d = window;
        if (window != null) {
            window.setGravity(80);
            this.f18841d.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = this.f18841d.getAttributes();
            attributes.width = this.f18843f;
            attributes.height = this.f18842e;
            this.f18841d.setAttributes(attributes);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f18853p = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f18853p.setBackgroundColor(0);
        setContentView(this.f18853p);
        setOnShowListener(this);
        setOnDismissListener(this);
        SigmobLog.i("DownloadDialog onCreate:" + this.f18843f + ":" + this.f18842e);
        if (this.f18846i != null) {
            this.f18853p.addView(this.f18846i, new RelativeLayout.LayoutParams(-1, -1));
        }
        Handler handler = new Handler(Looper.getMainLooper());
        this.f18854q = handler;
        handler.postDelayed(new b(), 5000L);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        f();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        SigmobLog.i("DownloadDialog  onDismiss");
        g gVar = this.f18838a;
        if (gVar != null) {
            gVar.a();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        SigmobLog.i("DownloadDialog  onShow");
        g gVar = this.f18838a;
        if (gVar != null) {
            gVar.b();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        View decorView = getWindow().getDecorView();
        ViewGroup.LayoutParams layoutParams = decorView.getLayoutParams();
        layoutParams.width = this.f18843f;
        layoutParams.height = this.f18842e;
        decorView.setLayoutParams(layoutParams);
    }

    public void b() {
        com.sigmob.sdk.base.views.g gVar = this.f18846i;
        if (gVar != null) {
            gVar.destroy();
            this.f18846i = null;
        }
        Handler handler = this.f18854q;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f18854q = null;
        }
        ImageView imageView = this.f18849l;
        if (imageView != null) {
            com.sigmob.sdk.base.utils.e.e(imageView);
            this.f18849l = null;
        }
        if (this.f18840c != null) {
            this.f18840c = null;
        }
        if (this.f18838a != null) {
            this.f18838a = null;
        }
    }

    public com.sigmob.sdk.base.views.g c() {
        com.sigmob.sdk.base.views.g gVar;
        String str;
        AdPrivacy adPrivacy;
        BaseAdUnit baseAdUnit = this.f18847j;
        if (baseAdUnit != null) {
            MaterialMeta material = baseAdUnit.getMaterial();
            if (material == null || (adPrivacy = material.ad_privacy) == null) {
                SigmobLog.i("ad_privacy is null");
            } else {
                Map<String, String> map = adPrivacy.privacy_template_info;
                if (map != null && map.size() > 0) {
                    this.f18839b = adPrivacy.privacy_template_info;
                }
                if (!TextUtils.isEmpty(adPrivacy.privacy_template_url)) {
                    String md5 = Md5Util.md5(adPrivacy.privacy_template_url);
                    this.f18851n = new File(com.sigmob.sdk.base.utils.d.b(com.sigmob.sdk.base.utils.d.f18408e), md5 + ".html");
                }
            }
        }
        File file = this.f18851n;
        if (file == null || !file.exists() || this.f18839b == null) {
            this.f18848k = false;
            return null;
        }
        this.f18848k = true;
        com.sigmob.sdk.base.views.g gVar2 = new com.sigmob.sdk.base.views.g(this.f18840c);
        this.f18846i = gVar2;
        gVar2.a(true);
        this.f18846i.setAdUnit(this.f18847j);
        this.f18846i.a((o.a) null);
        this.f18846i.setBackgroundColor(0);
        this.f18846i.setWebChromeClient(new c());
        this.f18846i.setWebViewClient(new d());
        if (TextUtils.isEmpty(this.f18850m)) {
            File file2 = this.f18851n;
            if (file2 == null || !file2.exists()) {
                this.f18848k = false;
                return this.f18846i;
            }
            this.f18846i.addJavascriptInterface(new f(this.f18839b), "sigPrivacy");
            gVar = this.f18846i;
            str = "file://" + this.f18851n.getAbsolutePath();
        } else {
            gVar = this.f18846i;
            str = this.f18850m;
        }
        gVar.loadUrl(str);
        return this.f18846i;
    }

    public final ImageView d() {
        ImageView imageView = new ImageView(this.f18840c);
        this.f18849l = imageView;
        imageView.setImageBitmap(s.CLOSE.b());
        this.f18849l.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f18849l.setImageAlpha(127);
        this.f18849l.setClickable(true);
        this.f18849l.setOnClickListener(new a());
        return this.f18849l;
    }

    public boolean e() {
        return this.f18848k;
    }

    public final void a() {
        if (this.f18849l != null) {
            int dipsToIntPixels = Dips.dipsToIntPixels(18.0f, this.f18840c);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            int i10 = dipsToIntPixels / 2;
            layoutParams.setMargins(0, i10, i10, 0);
            this.f18853p.addView(this.f18849l, layoutParams);
        }
    }

    public void a(g gVar) {
        this.f18838a = gVar;
    }
}
