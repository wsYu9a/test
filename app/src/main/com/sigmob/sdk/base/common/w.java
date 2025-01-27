package com.sigmob.sdk.base.common;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.exceptions.IntentNotResolvableException;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import com.sigmob.windad.WindAdRequest;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class w extends j {

    /* renamed from: i */
    public com.sigmob.sdk.base.views.g f18023i;

    /* renamed from: j */
    public int f18024j;

    /* renamed from: k */
    public BaseAdUnit f18025k;

    /* renamed from: l */
    public RelativeLayout f18026l;

    /* renamed from: m */
    public TextView f18027m;

    /* renamed from: n */
    public ImageView f18028n;

    /* renamed from: o */
    public String f18029o;

    public class a extends com.sigmob.sdk.base.h {

        /* renamed from: com.sigmob.sdk.base.common.w$a$a */
        public class C0568a implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ String f18031a;

            public C0568a(String str) {
                this.f18031a = str;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setUrl(this.f18031a);
                }
            }
        }

        public a() {
        }

        @Override // com.sigmob.sdk.base.h, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            b0.a("h5_error", "landpage", i10, str2 + " error:" + str, (WindAdRequest) null, (LoadAdRequest) null, w.this.f18025k, (b0.g) null);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            b0.a("h5_error", "landpage", webResourceResponse.getStatusCode(), webResourceRequest.getUrl().toString(), (WindAdRequest) null, (LoadAdRequest) null, w.this.f18025k, (b0.g) null);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Context context;
            String scheme;
            int i10;
            try {
                context = webView.getContext();
                Uri parse = Uri.parse(str);
                scheme = parse.getScheme();
                if (StringUtil.scheme().equalsIgnoreCase(scheme)) {
                    String host = parse.getHost();
                    if (!TextUtils.isEmpty(host)) {
                        if (!"track".equals(host)) {
                            if ("active".equals(host)) {
                            }
                        }
                        String queryParameter = parse.getQueryParameter(h3.e.f26408m);
                        String queryParameter2 = parse.getQueryParameter(NotificationCompat.CATEGORY_EVENT);
                        if (!TextUtils.isEmpty(queryParameter2) && !TextUtils.isEmpty(queryParameter)) {
                            b0.a(host, queryParameter2, w.this.f18025k, new C0568a(new String(Base64.decode(queryParameter, 0), "utf-8")));
                        }
                        return true;
                    }
                }
            } catch (IntentNotResolvableException e10) {
                e = e10;
                SigmobLog.e(e.getMessage());
                return true;
            } catch (Throwable th2) {
                e = th2;
                SigmobLog.e(e.getMessage());
                return true;
            }
            if (TextUtils.isEmpty(scheme) || scheme.equals("http") || scheme.equals("https")) {
                SigmobLog.i("load Url: " + str);
                webView.loadUrl(str);
                return true;
            }
            List<String> list = w.this.f18025k.getAdSetting() != null ? w.this.f18025k.getAdSetting().scheme_white_list : null;
            if (list != null && list.size() > 0) {
                for (i10 = 0; i10 < list.size(); i10++) {
                    String str2 = list.get(i10);
                    if (!str.startsWith(str2) && !str2.equals(m5.h.f28447r)) {
                    }
                    u.a(context, Uri.parse(str));
                    b0.a(com.sigmob.sdk.base.a.LAND_PAGE, "click", w.this.f18025k, "1", str, w.this.f18029o);
                }
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
                b0.a("h5_error", "landpage", 0, sb2.toString(), (WindAdRequest) null, (LoadAdRequest) null, w.this.f18025k, (b0.g) null);
            }
        }
    }

    public class b extends WebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (g.f18040a[consoleMessage.messageLevel().ordinal()] != 1) {
                return false;
            }
            SigmobLog.e("onConsoleMessage " + consoleMessage.message());
            b0.a("h5_error", "landpage", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, w.this.f18025k, (b0.g) null);
            return false;
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (str == null || str.isEmpty() || str.startsWith("http") || str.length() > 10) {
                if (w.this.f18027m != null) {
                    w.this.f18027m.setVisibility(8);
                }
            } else if (w.this.f18027m != null) {
                w.this.f18027m.setVisibility(0);
                w.this.f18027m.setText(str);
            }
        }
    }

    public class c implements DownloadListener {
        public c() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            p.a(str, w.this.f18025k);
            b0.a(com.sigmob.sdk.base.a.LAND_PAGE, "click", w.this.f18025k, "0", str, w.this.f18029o);
            SigmobLog.d("onDownloadStart() called with: url = [" + str + "], userAgent = [" + str2 + "], contentDisposition = [" + str3 + "], mimetype = [" + str4 + "], contentLength = [" + j10 + "]");
        }
    }

    public class d implements View.OnTouchListener {

        /* renamed from: a */
        public MotionEvent f18035a = null;

        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            SigmobLog.d(motionEvent.toString());
            if (motionEvent.getAction() == 0) {
                this.f18035a = MotionEvent.obtain(motionEvent);
                return false;
            }
            if (motionEvent.getAction() != 1) {
                return false;
            }
            MotionEvent motionEvent2 = this.f18035a;
            if (motionEvent2 == null) {
                w.this.f18029o = SigMacroCommon.getCoordinate(motionEvent, motionEvent, true);
                return false;
            }
            w.this.f18029o = SigMacroCommon.getCoordinate(motionEvent2, motionEvent, true);
            return false;
        }
    }

    public class e implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f18037a;

        public e(String str) {
            this.f18037a = str;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setCoordinate(this.f18037a);
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w.this.g().a();
        }
    }

    public static /* synthetic */ class g {

        /* renamed from: a */
        public static final /* synthetic */ int[] f18040a;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            f18040a = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public w(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, k kVar) {
        super(activity, str, kVar);
        this.f18025k = baseAdUnit;
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable(BaseAdActivity.f20402i);
            if (serializable instanceof BaseAdUnit) {
                this.f18025k = (BaseAdUnit) serializable;
            }
        }
        if (this.f18025k != null) {
            f().requestWindowFeature(8);
            f().getWindow().addFlags(1024);
        } else {
            a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            g().a();
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void j() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void k() {
        int l10 = com.sigmob.sdk.base.g.l();
        if (l10 > 0) {
            f().getTheme().applyStyle(l10, true);
        }
        s();
        r();
        String macroProcess = this.f18025k.getMacroCommon().macroProcess(this.f18025k.getMaterial().landing_page);
        if (TextUtils.isEmpty(this.f18025k.getLandUrl())) {
            this.f18023i.loadUrl(macroProcess);
        } else {
            this.f18023i.loadUrl(this.f18025k.getLandUrl());
        }
        a(IntentActions.ACTION_LANDPAGE_SHOW);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void l() {
        a(IntentActions.ACTION_LANDPAGE_DISMISS);
        ImageView imageView = this.f18028n;
        if (imageView != null) {
            imageView.setOnClickListener(null);
            this.f18028n = null;
        }
        com.sigmob.sdk.base.views.g gVar = this.f18023i;
        if (gVar != null) {
            gVar.destroy();
            this.f18023i = null;
        }
        super.l();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void m() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void n() {
        com.sigmob.sdk.base.views.g gVar = this.f18023i;
        if (gVar != null) {
            gVar.resumeTimers();
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }

    public final void q() {
        if (this.f18026l == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            int dipsToIntPixels = Dips.dipsToIntPixels(20.0f, this.f17899b);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
            layoutParams2.addRule(15);
            layoutParams2.addRule(9);
            int i10 = dipsToIntPixels / 2;
            layoutParams2.setMargins(i10, i10, 0, 0);
            ImageView imageView = new ImageView(this.f17899b);
            this.f18028n = imageView;
            imageView.setImageBitmap(com.sigmob.sdk.base.views.s.BACK.b());
            this.f18028n.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f18028n.setClickable(true);
            this.f18028n.setId(ClientMetadata.generateViewId());
            this.f18028n.setOnClickListener(new f());
            RelativeLayout relativeLayout = new RelativeLayout(h());
            this.f18026l = relativeLayout;
            relativeLayout.setLayoutParams(layoutParams);
            this.f18026l.setBackgroundColor(-1);
            this.f18026l.addView(this.f18028n, layoutParams2);
            TextView textView = new TextView(this.f17899b);
            this.f18027m = textView;
            textView.setTextColor(-16777216);
            this.f18027m.setTextSize(18.0f);
            this.f18027m.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            this.f18026l.addView(this.f18027m, layoutParams3);
        }
    }

    public final void r() {
        if (this.f18023i == null) {
            try {
                com.sigmob.sdk.base.views.g gVar = new com.sigmob.sdk.base.views.g(f());
                this.f18023i = gVar;
                gVar.setScrollBarStyle(0);
                this.f18023i.setAdUnit(this.f18025k);
                this.f18023i.setWebViewClient(new a());
                this.f18023i.setWebChromeClient(new b());
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
                this.f17902e.a();
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout = new LinearLayout(f());
        linearLayout.addView(this.f18023i, 0, layoutParams);
        this.f17902e.onSetContentView(linearLayout);
        if (this.f18025k.getAd() != null && this.f18025k.getAd().ad_setting != null && !this.f18025k.getAd().ad_setting.disable_download_listener.booleanValue()) {
            this.f18023i.setDownloadListener(new c());
        }
        this.f18023i.setOnTouchListener(new d());
    }

    public final void s() {
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-1, -1, 17);
        ActionBar actionBar = f().getActionBar();
        if (actionBar != null) {
            q();
            actionBar.setCustomView(this.f18026l, layoutParams);
            actionBar.setDisplayOptions(16);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public boolean b() {
        if (!this.f18023i.canGoBack()) {
            return true;
        }
        this.f18023i.goBack();
        return false;
    }

    public final void a(String str, String str2, BaseAdUnit baseAdUnit, String str3) {
        b0.a(str2, str, baseAdUnit, new e(str3));
    }
}
