package com.shu.priory.splash;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.martian.mibook.activity.book.CoverSwitchActivity;
import com.shu.priory.R;
import com.shu.priory.b.b;
import com.shu.priory.bean.DownloadDialogInfo;
import com.shu.priory.config.AdError;
import com.shu.priory.config.AdKeys;
import com.shu.priory.config.ErrorCode;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.conn.SplashDataRef;
import com.shu.priory.conn.VideoDataRef;
import com.shu.priory.download.DownLoadDialogCallback;
import com.shu.priory.download.d;
import com.shu.priory.i.c;
import com.shu.priory.listener.IFLYSplashListener;
import com.shu.priory.listener.IFLYVideoListener;
import com.shu.priory.splash.SplashContainer;
import com.shu.priory.utils.h;
import com.shu.priory.videolib.JZVPStandard;
import com.umeng.analytics.pro.bt;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a extends b<SplashDataRef> {

    /* renamed from: f */
    private ViewGroup f17243f;

    /* renamed from: g */
    private SplashContainer f17244g;

    /* renamed from: h */
    private WebView f17245h;

    /* renamed from: i */
    private c f17246i;

    /* renamed from: j */
    private TextView f17247j;

    /* renamed from: k */
    private final IFLYSplashListener f17248k;

    /* renamed from: l */
    private volatile boolean f17249l;

    /* renamed from: m */
    private final SensorManager f17250m;

    /* renamed from: n */
    private volatile SensorEventListener f17251n;

    /* renamed from: o */
    private final Handler f17252o;

    /* renamed from: p */
    private com.shu.priory.b.c f17253p;

    /* renamed from: q */
    private int f17254q;

    /* renamed from: r */
    private volatile boolean f17255r;

    /* renamed from: s */
    private volatile int f17256s;

    /* renamed from: t */
    private boolean f17257t;

    /* renamed from: u */
    private final Runnable f17258u;

    /* renamed from: v */
    private d f17259v;

    /* renamed from: com.shu.priory.splash.a$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.d()) {
                a.b(a.this);
            }
            if (a.this.f17247j != null) {
                a.this.f17247j.setText(String.format(Locale.CHINA, "跳过 %d", Integer.valueOf(a.this.f17254q)));
            }
            if (a.this.f17254q >= 6 || a.this.f17254q <= 0) {
                a.this.f17248k.onAdTimeOver();
            } else {
                a.this.f17252o.postDelayed(this, 1000L);
            }
        }
    }

    /* renamed from: com.shu.priory.splash.a$2 */
    public class AnonymousClass2 implements d {
        public AnonymousClass2() {
        }

        @Override // com.shu.priory.download.d
        public void a() {
            if (a.this.d()) {
                a.this.f17254q = 1;
                a.this.a(false);
            }
        }

        @Override // com.shu.priory.download.d
        public void b() {
            if (a.this.d()) {
                return;
            }
            a.this.a(true);
        }
    }

    /* renamed from: com.shu.priory.splash.a$3 */
    public class AnonymousClass3 implements SensorEventListener {

        /* renamed from: a */
        final /* synthetic */ int f17262a;

        public AnonymousClass3(int i10) {
            optInt = i10;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                int type = sensorEvent.sensor.getType();
                float[] fArr = sensorEvent.values;
                if (type == 1) {
                    if (Math.abs(fArr[0]) <= optInt && Math.abs(fArr[1]) <= optInt && Math.abs(fArr[2]) <= optInt) {
                        return;
                    }
                    if (a.this.f17244g != null) {
                        a.this.f17244g.setAcc(new int[]{(int) (fArr[0] * 100.0f), (int) (fArr[1] * 100.0f), (int) (fArr[2] * 100.0f)});
                    }
                    a.this.b(true);
                }
            } catch (Throwable th2) {
                h.d(SDKConstants.TAG, "onSensorChanged" + th2.getMessage());
            }
        }
    }

    /* renamed from: com.shu.priory.splash.a$4 */
    public class AnonymousClass4 implements IFLYVideoListener {

        /* renamed from: a */
        final /* synthetic */ View f17264a;

        public AnonymousClass4(View view) {
            view = view;
        }

        @Override // com.shu.priory.listener.IFLYBaseAdListener
        /* renamed from: a */
        public void onAdLoaded(VideoDataRef videoDataRef) {
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public void onAdClick() {
            if (a.this.f17256s > 0) {
                a.this.b(false);
            }
        }

        @Override // com.shu.priory.listener.IFLYBaseAdListener
        public void onAdFailed(AdError adError) {
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public void onAdPlayError() {
        }

        @Override // com.shu.priory.download.DialogListener
        public void onCancel() {
        }

        @Override // com.shu.priory.download.DialogListener
        public void onConfirm() {
        }

        @Override // com.shu.priory.download.DialogListener
        public void onDownloading() {
        }

        @Override // com.shu.priory.download.DialogListener
        public boolean onShowDownloadDialog(DownloadDialogInfo downloadDialogInfo, DownLoadDialogCallback downLoadDialogCallback) {
            return false;
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public void onVideoCached() {
            h.a(SDKConstants.TAG, "cache splash video success");
            JZVPStandard a10 = a.this.f17246i.a();
            a10.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            a.this.f17246i.a(1);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ifly_splash);
            linearLayout.removeAllViews();
            linearLayout.addView(a10);
            a.this.f17243f.removeAllViews();
            a.this.f17243f.addView(view);
            if (!a.this.f17246i.h()) {
                a.this.f17246i.c();
            }
            if (a.this.f17253p.onExposure(view)) {
                a.this.f17248k.onAdExposure();
            } else {
                h.a(SDKConstants.TAG, "splash video ad exposure failed");
            }
            a.this.f17252o.post(a.this.f17258u);
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public void onVideoComplete() {
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public void onVideoReplay() {
        }

        @Override // com.shu.priory.listener.IFLYVideoListener
        public void onVideoStart() {
        }
    }

    /* renamed from: com.shu.priory.splash.a$5 */
    public class AnonymousClass5 extends WebViewClient {

        /* renamed from: a */
        final /* synthetic */ View f17266a;

        public AnonymousClass5(View view) {
            view = view;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            h.a(SDKConstants.TAG, "temp page finish : " + str);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ifly_splash);
            linearLayout.removeAllViews();
            linearLayout.addView(a.this.f17245h);
            a.this.f17245h.setVisibility(0);
            a.this.f17243f.removeAllViews();
            a.this.f17243f.addView(view);
            if (a.this.f17253p.onExposure(view)) {
                a.this.f17248k.onAdExposure();
            } else {
                h.a(SDKConstants.TAG, "temp ad exposure failed");
            }
            a.this.f17252o.post(a.this.f17258u);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            h.a(SDKConstants.TAG, "temp page start : " + str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            h.a(SDKConstants.TAG, "temp page error : " + webResourceError.toString());
            a.this.f17248k.onAdFailed(new AdError(ErrorCode.ERROR_NO_FILL));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (a.this.f17256s <= 0) {
                return true;
            }
            a.this.b(false);
            return true;
        }
    }

    public a(Context context, String str, IFLYSplashListener iFLYSplashListener) {
        super(context, str);
        this.f17252o = new Handler();
        this.f17258u = new Runnable() { // from class: com.shu.priory.splash.a.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.d()) {
                    a.b(a.this);
                }
                if (a.this.f17247j != null) {
                    a.this.f17247j.setText(String.format(Locale.CHINA, "跳过 %d", Integer.valueOf(a.this.f17254q)));
                }
                if (a.this.f17254q >= 6 || a.this.f17254q <= 0) {
                    a.this.f17248k.onAdTimeOver();
                } else {
                    a.this.f17252o.postDelayed(this, 1000L);
                }
            }
        };
        this.f17259v = new d() { // from class: com.shu.priory.splash.a.2
            public AnonymousClass2() {
            }

            @Override // com.shu.priory.download.d
            public void a() {
                if (a.this.d()) {
                    a.this.f17254q = 1;
                    a.this.a(false);
                }
            }

            @Override // com.shu.priory.download.d
            public void b() {
                if (a.this.d()) {
                    return;
                }
                a.this.a(true);
            }
        };
        this.f16823e.a(iFLYSplashListener);
        this.f16820b = context;
        this.f17248k = iFLYSplashListener;
        this.f17250m = (SensorManager) context.getSystemService(bt.f23586ac);
    }

    public static /* synthetic */ int b(a aVar) {
        int i10 = aVar.f17254q;
        aVar.f17254q = i10 - 1;
        return i10;
    }

    private void g() {
        this.f17249l = false;
        this.f17255r = false;
        if (this.f17250m != null && this.f17251n != null) {
            this.f17250m.unregisterListener(this.f17251n);
        }
        WebView webView = this.f17245h;
        if (webView != null) {
            webView.removeAllViews();
            this.f17245h.destroy();
            this.f17245h = null;
        }
        if (this.f17246i != null) {
            this.f17246i = null;
        }
    }

    private boolean h() {
        try {
            com.shu.priory.g.a aVar = this.f16821c.f17105f;
            String str = aVar.K;
            if (aVar.M == 3) {
                return TextUtils.isEmpty(str);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.shu.priory.b.b
    public void a() {
        try {
            Context context = this.f16820b;
            if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                a(new AdError(ErrorCode.ERROR_ACTIVITY_FINISH));
                h.a(SDKConstants.TAG, "activity is finishing");
                return;
            }
            com.shu.priory.g.b bVar = this.f16821c;
            if (70200 != bVar.f17100a || bVar.f17105f == null) {
                a(new AdError(this.f16821c.f17100a));
            } else {
                this.f16823e.post(new Runnable() { // from class: zf.e
                    public /* synthetic */ e() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.shu.priory.splash.a.this.e();
                    }
                });
            }
        } catch (Throwable th2) {
            a(new AdError(ErrorCode.ERROR_NETWORK));
            h.d(SDKConstants.TAG, th2.getMessage());
        }
    }

    @Override // com.shu.priory.b.b
    public synchronized void b() {
        g();
        super.b();
    }

    public /* synthetic */ void a(View view) {
        b(false);
    }

    public /* synthetic */ void b(View view) {
        this.f17248k.onAdSkip();
        this.f17252o.removeCallbacks(this.f17258u);
    }

    public boolean d() {
        return this.f17257t;
    }

    public void e() {
        h.a(SDKConstants.TAG, "splash ad load");
        f();
        com.shu.priory.b.c cVar = new com.shu.priory.b.c(this.f16820b, this.f16821c, this.f16819a, this.f17248k);
        this.f17253p = cVar;
        cVar.setTimerInterface(this.f17259v);
        com.shu.priory.g.a aVar = this.f16821c.f17105f;
        this.f17256s = (aVar.R << 1) + (aVar.Q <= 2 ? 0 : 1);
        this.f17248k.onAdLoaded(new SplashDataRef(this.f16820b.getApplicationContext(), this.f16821c.f17105f));
        if (this.f17255r || this.f17243f == null) {
            return;
        }
        a(this.f16821c.f17105f);
    }

    private void f() {
        int intParam = this.f16819a.getIntParam(AdKeys.COUNT_DOWN);
        h.a(SDKConstants.TAG, "countDown:" + intParam);
        this.f17254q = intParam < 5 ? Math.max(intParam, 3) : 5;
    }

    public void c() {
        h.a(SDKConstants.TAG, "splash ad destroy");
        WebView webView = this.f17245h;
        if (webView != null) {
            webView.removeAllViews();
            this.f17245h.destroy();
            this.f17245h = null;
        }
        if (this.f17247j != null) {
            this.f17247j = null;
        }
        ViewGroup viewGroup = this.f17243f;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.f17243f = null;
        }
        if (this.f17250m != null && this.f17251n != null) {
            this.f17250m.unregisterListener(this.f17251n);
        }
        c cVar = this.f17246i;
        if (cVar != null) {
            cVar.d();
        }
    }

    public /* synthetic */ void c(View view) {
        if (this.f17256s > 0) {
            b(false);
        }
    }

    public void a(ViewGroup viewGroup) {
        this.f17243f = viewGroup;
    }

    public void b(ViewGroup viewGroup) {
        try {
            if (viewGroup == null) {
                h.a(SDKConstants.TAG, "ad container is null");
                return;
            }
            this.f17243f = viewGroup;
            this.f17255r = true;
            a(this.f16821c.f17105f);
        } catch (Exception e10) {
            h.a(SDKConstants.TAG, "show ad error " + e10);
        }
    }

    private void a(AdError adError) {
        this.f16823e.post(new Runnable() { // from class: zf.d

            /* renamed from: c */
            public final /* synthetic */ AdError f33817c;

            public /* synthetic */ d(AdError adError2) {
                adError = adError2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.shu.priory.splash.a.this.b(adError);
            }
        });
    }

    public /* synthetic */ void b(AdError adError) {
        this.f17248k.onAdFailed(adError);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c(JSONObject jSONObject, View view) {
        String optString = jSONObject.optString("adm");
        WebView webView = (WebView) view.findViewById(R.id.ifly_splash_web);
        this.f17245h = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f17245h.setScrollContainer(false);
        this.f17245h.setHorizontalScrollBarEnabled(false);
        this.f17245h.setVerticalScrollBarEnabled(false);
        this.f17245h.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.f17245h.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        this.f17245h.requestFocus();
        this.f17245h.setWebViewClient(new WebViewClient() { // from class: com.shu.priory.splash.a.5

            /* renamed from: a */
            final /* synthetic */ View f17266a;

            public AnonymousClass5(View view2) {
                view = view2;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                h.a(SDKConstants.TAG, "temp page finish : " + str);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ifly_splash);
                linearLayout.removeAllViews();
                linearLayout.addView(a.this.f17245h);
                a.this.f17245h.setVisibility(0);
                a.this.f17243f.removeAllViews();
                a.this.f17243f.addView(view);
                if (a.this.f17253p.onExposure(view)) {
                    a.this.f17248k.onAdExposure();
                } else {
                    h.a(SDKConstants.TAG, "temp ad exposure failed");
                }
                a.this.f17252o.post(a.this.f17258u);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                super.onPageStarted(webView2, str, bitmap);
                h.a(SDKConstants.TAG, "temp page start : " + str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                h.a(SDKConstants.TAG, "temp page error : " + webResourceError.toString());
                a.this.f17248k.onAdFailed(new AdError(ErrorCode.ERROR_NO_FILL));
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                if (a.this.f17256s <= 0) {
                    return true;
                }
                a.this.b(false);
                return true;
            }
        });
        this.f17245h.loadDataWithBaseURL(null, optString, "text/html", "utf-8", null);
    }

    private void a(com.shu.priory.g.a aVar) {
        h.a(SDKConstants.TAG, "start assemble view, interact " + aVar.Q + ", click type " + aVar.R);
        int i10 = aVar.Q;
        if (i10 == 2 || i10 == 4) {
            a(aVar.S);
        }
        SplashContainer splashContainer = (SplashContainer) LayoutInflater.from(this.f16820b).inflate(R.layout.ifly_ad_splash_template, (ViewGroup) null);
        this.f17244g = splashContainer;
        splashContainer.setMask(this.f17256s);
        splashContainer.setOnClickListener(new View.OnClickListener() { // from class: zf.a
            public /* synthetic */ a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.shu.priory.splash.a.this.c(view);
            }
        });
        JSONObject jSONObject = aVar.f17079f;
        if (jSONObject != null) {
            b(jSONObject, splashContainer);
        } else {
            JSONObject jSONObject2 = aVar.f17083j;
            if (jSONObject2 != null) {
                a(jSONObject2, splashContainer);
            } else {
                JSONObject jSONObject3 = aVar.f17078e;
                if (jSONObject3 == null) {
                    this.f17248k.onAdFailed(new AdError(ErrorCode.ERROR_NO_FILL));
                    h.c(SDKConstants.TAG, "no valid ad data, show add error");
                    return;
                }
                c(jSONObject3, splashContainer);
            }
        }
        TextView textView = (TextView) splashContainer.findViewById(R.id.ifly_skip_tv);
        this.f17247j = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: zf.b
            public /* synthetic */ b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.shu.priory.splash.a.this.b(view);
            }
        });
        a(splashContainer, aVar.Q);
        LinearLayout linearLayout = (LinearLayout) splashContainer.findViewById(R.id.ifly_splash_click);
        linearLayout.setVisibility(0);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: zf.c
            public /* synthetic */ c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.shu.priory.splash.a.this.a(view);
            }
        });
    }

    private void a(SplashContainer splashContainer, int i10) {
        String str;
        h.a(SDKConstants.TAG, "splash ad interaction type " + i10);
        ImageView imageView = (ImageView) splashContainer.findViewById(R.id.ifly_splash_interaction_img);
        ImageView imageView2 = (ImageView) splashContainer.findViewById(R.id.ifly_splash_tip_img_right);
        ImageView imageView3 = (ImageView) splashContainer.findViewById(R.id.ifly_splash_tip_img_left);
        TextView textView = (TextView) splashContainer.findViewById(R.id.ifly_ad_splash_tip1);
        TextView textView2 = (TextView) splashContainer.findViewById(R.id.ifly_ad_splash_tip2);
        if (i10 != 2) {
            str = "ifly_ad_splash_icon_slide";
            if (i10 == 3) {
                textView.setText("上滑或点击图标");
                imageView2.setImageResource(R.drawable.ifly_ad_splash_tip_click);
            } else if (i10 != 4) {
                str = "ifly_ad_splash_icon_click";
            } else {
                textView.setText("摇一摇或点击图标");
                imageView2.setVisibility(8);
                imageView3.setVisibility(0);
            }
            textView2.setVisibility(0);
        } else {
            textView.setText("摇一摇或点击图标");
            imageView2.setImageResource(R.drawable.ifly_ad_splash_tip_click);
            textView2.setVisibility(0);
            str = "ifly_ad_splash_icon_shake";
        }
        Glide.with(this.f16820b).asGif().load2(CoverSwitchActivity.S + str + ".gif").into(imageView);
    }

    private void b(JSONObject jSONObject, View view) {
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            h.c(SDKConstants.TAG, "image url is empty, show add error");
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.ifly_splash_img);
        Glide.with(this.f16820b).load2(optString).into(imageView);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ifly_splash);
        linearLayout.removeAllViews();
        linearLayout.addView(imageView);
        imageView.setVisibility(0);
        this.f17243f.removeAllViews();
        this.f17243f.addView(view);
        if (this.f17253p.onExposure(view)) {
            this.f17248k.onAdExposure();
        } else {
            h.a(SDKConstants.TAG, "splash image ad exposure failed");
        }
        this.f17252o.post(this.f17258u);
    }

    public void b(boolean z10) {
        if (this.f17249l) {
            return;
        }
        SplashContainer.a touchPosition = this.f17244g.getTouchPosition();
        boolean onClick = this.f17253p.onClick(this.f17244g, Integer.valueOf(z10 ? 2 : touchPosition.e()), Float.valueOf(z10 ? -999.0f : touchPosition.a()), Float.valueOf(z10 ? -999.0f : touchPosition.b()), Float.valueOf(z10 ? -999.0f : touchPosition.c()), Float.valueOf(z10 ? -999.0f : touchPosition.d()), this.f17244g.getAcc());
        this.f17248k.onAdClick();
        this.f17249l = true;
        if (!h()) {
            this.f17252o.removeCallbacks(this.f17258u);
        }
        h.a(SDKConstants.TAG, "splash ad click " + onClick + ", position " + touchPosition);
    }

    private void a(JSONObject jSONObject) {
        if (this.f17250m == null) {
            h.c(SDKConstants.TAG, "sensor manager is null! ");
            return;
        }
        h.a(SDKConstants.TAG, "registerSensorListener shakeInfo： " + jSONObject.toString());
        this.f17251n = new SensorEventListener() { // from class: com.shu.priory.splash.a.3

            /* renamed from: a */
            final /* synthetic */ int f17262a;

            public AnonymousClass3(int i10) {
                optInt = i10;
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i10) {
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                try {
                    int type = sensorEvent.sensor.getType();
                    float[] fArr = sensorEvent.values;
                    if (type == 1) {
                        if (Math.abs(fArr[0]) <= optInt && Math.abs(fArr[1]) <= optInt && Math.abs(fArr[2]) <= optInt) {
                            return;
                        }
                        if (a.this.f17244g != null) {
                            a.this.f17244g.setAcc(new int[]{(int) (fArr[0] * 100.0f), (int) (fArr[1] * 100.0f), (int) (fArr[2] * 100.0f)});
                        }
                        a.this.b(true);
                    }
                } catch (Throwable th2) {
                    h.d(SDKConstants.TAG, "onSensorChanged" + th2.getMessage());
                }
            }
        };
        this.f17250m.registerListener(this.f17251n, this.f17250m.getDefaultSensor(1), 3);
    }

    private void a(JSONObject jSONObject, View view) {
        c cVar = new c(this.f16820b, 1, new IFLYVideoListener() { // from class: com.shu.priory.splash.a.4

            /* renamed from: a */
            final /* synthetic */ View f17264a;

            public AnonymousClass4(View view2) {
                view = view2;
            }

            @Override // com.shu.priory.listener.IFLYBaseAdListener
            /* renamed from: a */
            public void onAdLoaded(VideoDataRef videoDataRef) {
            }

            @Override // com.shu.priory.listener.IFLYVideoListener
            public void onAdClick() {
                if (a.this.f17256s > 0) {
                    a.this.b(false);
                }
            }

            @Override // com.shu.priory.listener.IFLYBaseAdListener
            public void onAdFailed(AdError adError) {
            }

            @Override // com.shu.priory.listener.IFLYVideoListener
            public void onAdPlayError() {
            }

            @Override // com.shu.priory.download.DialogListener
            public void onCancel() {
            }

            @Override // com.shu.priory.download.DialogListener
            public void onConfirm() {
            }

            @Override // com.shu.priory.download.DialogListener
            public void onDownloading() {
            }

            @Override // com.shu.priory.download.DialogListener
            public boolean onShowDownloadDialog(DownloadDialogInfo downloadDialogInfo, DownLoadDialogCallback downLoadDialogCallback) {
                return false;
            }

            @Override // com.shu.priory.listener.IFLYVideoListener
            public void onVideoCached() {
                h.a(SDKConstants.TAG, "cache splash video success");
                JZVPStandard a10 = a.this.f17246i.a();
                a10.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                a.this.f17246i.a(1);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ifly_splash);
                linearLayout.removeAllViews();
                linearLayout.addView(a10);
                a.this.f17243f.removeAllViews();
                a.this.f17243f.addView(view);
                if (!a.this.f17246i.h()) {
                    a.this.f17246i.c();
                }
                if (a.this.f17253p.onExposure(view)) {
                    a.this.f17248k.onAdExposure();
                } else {
                    h.a(SDKConstants.TAG, "splash video ad exposure failed");
                }
                a.this.f17252o.post(a.this.f17258u);
            }

            @Override // com.shu.priory.listener.IFLYVideoListener
            public void onVideoComplete() {
            }

            @Override // com.shu.priory.listener.IFLYVideoListener
            public void onVideoReplay() {
            }

            @Override // com.shu.priory.listener.IFLYVideoListener
            public void onVideoStart() {
            }
        });
        this.f17246i = cVar;
        cVar.a(new com.shu.priory.i.d(this.f16821c.f17105f));
        h.a(SDKConstants.TAG, "start cache video");
        this.f17246i.a(jSONObject);
    }

    public void a(boolean z10) {
        this.f17257t = z10;
    }
}
