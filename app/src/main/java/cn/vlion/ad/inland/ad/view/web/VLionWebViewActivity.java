package cn.vlion.ad.inland.ad.view.web;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.e0;
import cn.vlion.ad.inland.base.q;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class VLionWebViewActivity extends Activity implements View.OnClickListener {

    /* renamed from: d */
    public static String f2570d = null;

    /* renamed from: e */
    public static List<VlionCustomAdData.SeatbidBean.BidBean.HeadInfoBean.Headerbean> f2571e = null;

    /* renamed from: f */
    public static String f2572f = null;

    /* renamed from: g */
    public static String f2573g = null;

    /* renamed from: h */
    public static String f2574h = null;

    /* renamed from: i */
    public static int f2575i = 1;

    /* renamed from: a */
    public WebView f2576a;

    /* renamed from: b */
    public WebSettings f2577b;

    /* renamed from: c */
    public ImageView f2578c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            VLionWebViewActivity.this.finish();
        }
    }

    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i10, String str, String str2) {
            super.onReceivedError(webView, i10, str, str2);
            try {
                WebView webView2 = VLionWebViewActivity.this.f2576a;
                if (webView2 != null) {
                    webView2.setVisibility(8);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                LogVlion.e("VLionWebViewActivity shouldOverrideUrlLoading url=: " + str);
                if (str == null || (!str.startsWith("http:") && !str.startsWith("https:") && !str.startsWith("ftp:"))) {
                    if (q.a(VLionWebViewActivity.this.getApplicationContext(), str)) {
                        q.a(VLionWebViewActivity.this.getApplicationContext(), str, VLionWebViewActivity.f2573g, VLionWebViewActivity.f2574h);
                        return true;
                    }
                    VlionSDkManager.getInstance().upLoadCatchException(new Throwable("ldp WebView dp打不开异常 slotID = " + VLionWebViewActivity.f2573g + " dspid= " + VLionWebViewActivity.f2574h + " ldp= " + str));
                    return true;
                }
                webView.loadUrl(str);
                return true;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return true;
            }
        }
    }

    public static void start(Context context, int i10, String str, String str2, String str3, String str4, List<VlionCustomAdData.SeatbidBean.BidBean.HeadInfoBean.Headerbean> list) {
        if (context == null) {
            return;
        }
        try {
            f2575i = i10;
            f2570d = str;
            f2571e = list;
            f2572f = str2;
            f2573g = str3;
            f2574h = str4;
            Intent intent = new Intent(context, (Class<?>) VLionWebViewActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a() {
        try {
            LogVlion.e("VLionWebViewActivity initOrientation:adOrientation=" + f2575i);
            if (getResources().getConfiguration().orientation == 1) {
                if (f2575i == 2) {
                    setRequestedOrientation(0);
                }
            } else if (f2575i != 2) {
                setRequestedOrientation(1);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void b() {
        try {
            WebSettings settings = this.f2576a.getSettings();
            this.f2577b = settings;
            settings.setDatabaseEnabled(true);
            this.f2577b.setDomStorageEnabled(true);
            this.f2577b.setJavaScriptEnabled(true);
            this.f2577b.setDomStorageEnabled(true);
            this.f2576a.setWebViewClient(new b());
            try {
                WebView webView = this.f2576a;
                if (webView == null) {
                    return;
                }
                webView.setDownloadListener(new e0());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.vlion_cn_ad_dp_web);
            this.f2578c = (ImageView) findViewById(R.id.iv_closed);
            this.f2576a = (WebView) findViewById(R.id.wb_webview);
            a();
            b();
            this.f2578c.setOnClickListener(new a());
            if (!TextUtils.isEmpty(f2572f)) {
                this.f2576a.loadDataWithBaseURL(null, "<html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> <style>img{width: 100%; height:100%!important;position: absolute;top:50%;transform: translateY(-50%);}</style></head><body>" + f2572f + "</body></html>", "text/html", "utf-8", null);
                return;
            }
            if (f2570d != null) {
                LogVlion.e("VLionWebViewActivity url = " + f2570d);
                if (f2571e == null) {
                    this.f2576a.loadUrl(f2570d);
                    return;
                }
                HashMap hashMap = new HashMap();
                try {
                    for (VlionCustomAdData.SeatbidBean.BidBean.HeadInfoBean.Headerbean headerbean : f2571e) {
                        if (headerbean != null) {
                            hashMap.put(headerbean.getKey(), headerbean.getValue());
                            LogVlion.e("VLionWebViewActivity headerbean =   key " + headerbean.getKey() + " value =" + headerbean.getValue());
                        }
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                this.f2576a.loadUrl(f2570d, hashMap);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        try {
            WebView webView = this.f2576a;
            if (webView != null) {
                ViewParent parent = webView.getParent();
                if (parent != null) {
                    this.f2576a.removeAllViews();
                    ((ViewGroup) parent).removeView(this.f2576a);
                }
                this.f2576a.stopLoading();
                this.f2576a.clearHistory();
                this.f2576a.clearView();
                this.f2576a.destroy();
            }
            super.onDestroy();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        try {
            WebView webView = this.f2576a;
            if (webView != null) {
                webView.onPause();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        try {
            WebView webView = this.f2576a;
            if (webView != null) {
                webView.resumeTimers();
                this.f2576a.onResume();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onStop() {
        try {
            super.onStop();
            WebView webView = this.f2576a;
            if (webView != null) {
                webView.stopLoading();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            finish();
        }
    }
}
