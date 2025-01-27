package r3;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.lang.reflect.Method;
import p3.k;

/* loaded from: classes.dex */
public class e extends LinearLayout {

    /* renamed from: n */
    public static Handler f30283n = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    public ImageView f30284b;

    /* renamed from: c */
    public TextView f30285c;

    /* renamed from: d */
    public ImageView f30286d;

    /* renamed from: e */
    public ProgressBar f30287e;

    /* renamed from: f */
    public WebView f30288f;

    /* renamed from: g */
    public final C0783e f30289g;

    /* renamed from: h */
    public f f30290h;

    /* renamed from: i */
    public g f30291i;

    /* renamed from: j */
    public h f30292j;

    /* renamed from: k */
    public final n3.a f30293k;

    /* renamed from: l */
    public View.OnClickListener f30294l;

    /* renamed from: m */
    public final float f30295m;

    public class a implements View.OnClickListener {

        /* renamed from: r3.e$a$a */
        public class RunnableC0782a implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ View f30297b;

            public RunnableC0782a(View view) {
                this.f30297b = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f30297b.setEnabled(true);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar = e.this.f30292j;
            if (hVar != null) {
                view.setEnabled(false);
                e.f30283n.postDelayed(new RunnableC0782a(view), 256L);
                if (view == e.this.f30284b) {
                    hVar.b(e.this);
                } else if (view == e.this.f30286d) {
                    hVar.a(e.this);
                }
            }
        }
    }

    public class b implements DownloadListener {

        /* renamed from: b */
        public final /* synthetic */ Context f30299b;

        public b(Context context) {
            this.f30299b = context;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                this.f30299b.startActivity(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public class c extends WebChromeClient {
        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return e.this.f30290h.e(e.this, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            if (!e.this.f30289g.f30304b) {
                e.this.f30287e.setVisibility(8);
            } else {
                if (i10 > 90) {
                    e.this.f30287e.setVisibility(4);
                    return;
                }
                if (e.this.f30287e.getVisibility() == 4) {
                    e.this.f30287e.setVisibility(0);
                }
                e.this.f30287e.setProgress(i10);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            e.this.f30290h.c(e.this, str);
        }
    }

    public class d extends WebViewClient {
        public d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (e.this.f30291i.h(e.this, str)) {
                return;
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (e.this.f30291i.d(e.this, str)) {
                return;
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            if (e.this.f30291i.f(e.this, i10, str, str2)) {
                return;
            }
            super.onReceivedError(webView, i10, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (e.this.f30291i.i(e.this, sslErrorHandler, sslError)) {
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (e.this.f30291i.g(e.this, str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* renamed from: r3.e$e */
    public static final class C0783e {

        /* renamed from: a */
        public boolean f30303a;

        /* renamed from: b */
        public boolean f30304b;

        public C0783e(boolean z10, boolean z11) {
            this.f30303a = z10;
            this.f30304b = z11;
        }
    }

    public interface f {
        void c(e eVar, String str);

        boolean e(e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    public interface g {
        boolean d(e eVar, String str);

        boolean f(e eVar, int i10, String str, String str2);

        boolean g(e eVar, String str);

        boolean h(e eVar, String str);

        boolean i(e eVar, SslErrorHandler sslErrorHandler, SslError sslError);
    }

    public interface h {
        void a(e eVar);

        void b(e eVar);
    }

    public e(Context context, n3.a aVar, C0783e c0783e) {
        this(context, null, aVar, c0783e);
    }

    public final int a(int i10) {
        return (int) (i10 * this.f30295m);
    }

    public void c() {
        removeAllViews();
        this.f30288f.removeAllViews();
        this.f30288f.setWebViewClient(null);
        this.f30288f.setWebChromeClient(null);
        this.f30288f.destroy();
    }

    public final void d(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-218103809);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setVisibility(this.f30289g.f30303a ? 0 : 8);
        ImageView imageView = new ImageView(context);
        this.f30284b = imageView;
        imageView.setOnClickListener(this.f30294l);
        ImageView imageView2 = this.f30284b;
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
        imageView2.setScaleType(scaleType);
        this.f30284b.setImageDrawable(p3.h.a(p3.h.f29753a, context));
        this.f30284b.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.f30284b, new LinearLayout.LayoutParams(-2, -2));
        View view = new View(context);
        view.setBackgroundColor(-2500135);
        linearLayout.addView(view, new LinearLayout.LayoutParams(a(1), a(25)));
        TextView textView = new TextView(context);
        this.f30285c = textView;
        textView.setTextColor(-15658735);
        this.f30285c.setTextSize(17.0f);
        this.f30285c.setMaxLines(1);
        this.f30285c.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(17), 0, 0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.f30285c, layoutParams);
        ImageView imageView3 = new ImageView(context);
        this.f30286d = imageView3;
        imageView3.setOnClickListener(this.f30294l);
        this.f30286d.setScaleType(scaleType);
        this.f30286d.setImageDrawable(p3.h.a(p3.h.f29754b, context));
        this.f30286d.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.f30286d, new LinearLayout.LayoutParams(-2, -2));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, a(48)));
    }

    public void e(WebView webView, Context context) {
        String userAgentString = webView.getSettings().getUserAgentString();
        webView.getSettings().setUserAgentString(userAgentString + k.a0(context));
    }

    public void f(String str) {
        this.f30288f.loadUrl(str);
        r3.c.j(this.f30288f);
    }

    public void g(String str, byte[] bArr) {
        this.f30288f.postUrl(str, bArr);
    }

    public ImageView getBackButton() {
        return this.f30284b;
    }

    public ProgressBar getProgressbar() {
        return this.f30287e;
    }

    public ImageView getRefreshButton() {
        return this.f30286d;
    }

    public TextView getTitle() {
        return this.f30285c;
    }

    public String getUrl() {
        return this.f30288f.getUrl();
    }

    public WebView getWebView() {
        return this.f30288f;
    }

    public final void j(Context context) {
        ProgressBar progressBar = new ProgressBar(context, null, R.style.Widget.ProgressBar.Horizontal);
        this.f30287e = progressBar;
        progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.progress_horizontal));
        this.f30287e.setMax(100);
        this.f30287e.setBackgroundColor(-218103809);
        addView(this.f30287e, new LinearLayout.LayoutParams(-1, a(2)));
    }

    public final void l(Context context) {
        WebView webView = new WebView(context);
        this.f30288f = webView;
        webView.setVerticalScrollbarOverlay(true);
        e(this.f30288f, context);
        WebSettings settings = this.f30288f.getSettings();
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheMaxSize(com.sigmob.sdk.downloader.core.download.g.f19255e);
        settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        settings.setAllowFileAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setAllowContentAccess(false);
        this.f30288f.setVerticalScrollbarOverlay(true);
        this.f30288f.setDownloadListener(new b(context));
        try {
            try {
                this.f30288f.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f30288f.removeJavascriptInterface("accessibility");
                this.f30288f.removeJavascriptInterface("accessibilityTraversal");
            } catch (Exception unused) {
                Method method = this.f30288f.getClass().getMethod("removeJavascriptInterface", null);
                if (method != null) {
                    method.invoke(this.f30288f, "searchBoxJavaBridge_");
                    method.invoke(this.f30288f, "accessibility");
                    method.invoke(this.f30288f, "accessibilityTraversal");
                }
            }
        } catch (Throwable unused2) {
        }
        r3.c.j(this.f30288f);
        addView(this.f30288f, new LinearLayout.LayoutParams(-1, -1));
    }

    public void setChromeProxy(f fVar) {
        this.f30290h = fVar;
        if (fVar == null) {
            this.f30288f.setWebChromeClient(null);
        } else {
            this.f30288f.setWebChromeClient(new c());
        }
    }

    public void setWebClientProxy(g gVar) {
        this.f30291i = gVar;
        if (gVar == null) {
            this.f30288f.setWebViewClient(null);
        } else {
            this.f30288f.setWebViewClient(new d());
        }
    }

    public void setWebEventProxy(h hVar) {
        this.f30292j = hVar;
    }

    public e(Context context, AttributeSet attributeSet, n3.a aVar, C0783e c0783e) {
        super(context, attributeSet);
        this.f30294l = new a();
        this.f30289g = c0783e == null ? new C0783e(false, false) : c0783e;
        this.f30293k = aVar;
        this.f30295m = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        d(context);
        j(context);
        l(context);
    }
}
