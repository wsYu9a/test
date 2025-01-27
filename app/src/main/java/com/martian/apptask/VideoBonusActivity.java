package com.martian.apptask;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import ba.l;
import com.martian.apptask.VideoBonusActivity;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.widget.CountdownNumberTextView;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.MartianActivity;
import com.martian.libmars.widget.MTWebView;
import com.martian.libvideoplayer.JCVideoPlayer;
import com.martian.libvideoplayer.JCVideoPlayerStandard;
import i8.g;
import i8.h;
import l9.k0;
import l9.m0;

/* loaded from: classes3.dex */
public class VideoBonusActivity extends MartianActivity implements MTWebView.c {
    public static final String L = "INTENT_APPTASK_JSON";
    public static final int M = 10006;
    public CountdownNumberTextView A;
    public View D;
    public ImageView E;
    public TextView F;
    public TextView G;
    public Button H;

    /* renamed from: w */
    public JCVideoPlayerStandard f11994w;

    /* renamed from: x */
    public AppTask f11995x;

    /* renamed from: y */
    public MTWebView f11996y;

    /* renamed from: z */
    public View f11997z;
    public boolean B = false;
    public boolean C = false;
    public String I = "";
    public boolean J = true;
    public boolean K = false;

    public class a implements JCVideoPlayerStandard.c {
        public a() {
        }

        @Override // com.martian.libvideoplayer.JCVideoPlayerStandard.c
        public void a() {
            h.b(VideoBonusActivity.this.f11995x.video.getPlayStartTrackers());
            VideoBonusActivity.this.A.setVisibility(0);
            VideoBonusActivity.this.A.l();
        }

        @Override // com.martian.libvideoplayer.JCVideoPlayerStandard.c
        public void b() {
            if (VideoBonusActivity.this.f11995x == null || VideoBonusActivity.this.f11995x.video == null || l.q(VideoBonusActivity.this.f11995x.video.getVhtml())) {
                return;
            }
            VideoBonusActivity.this.C = true;
            VideoBonusActivity.this.f11996y.setVisibility(0);
            VideoBonusActivity.this.f11996y.loadDataWithBaseURL(null, VideoBonusActivity.this.f11995x.video.getVhtml(), "text/html; charset=UTF-8", "utf-8", null);
            h.b(VideoBonusActivity.this.f11995x.video.getPlayEndTrackers());
            h.b(VideoBonusActivity.this.f11995x.exposeReportUrls);
            VideoBonusActivity.this.D.setVisibility(8);
        }
    }

    public class b implements g8.a {
        public b() {
        }

        @Override // g8.a
        public void a(AppTask appTask) {
        }

        @Override // g8.a
        public void b(AppTask appTask) {
        }

        @Override // g8.a
        public void c(AppTask appTask) {
        }

        @Override // g8.a
        public void d(AppTask appTask) {
        }
    }

    public static void J2(Activity activity, AppTask appTask) {
        Intent intent = new Intent(activity, (Class<?>) VideoBonusActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(L, GsonUtils.b().toJson(appTask));
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, 10006);
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void D(String str) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void E(WebView webView, String str, boolean z10) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public boolean F(WebView webView, String str, String str2) {
        return false;
    }

    public final void F2() {
        P1("加载视频失败,请重试");
        finish();
    }

    public final /* synthetic */ void G2(CountdownNumberTextView countdownNumberTextView) {
        this.B = true;
        this.A.setText("关闭");
    }

    public final /* synthetic */ void H2(String str, String str2) {
        P1("已开始下载" + str);
    }

    public final void I2() {
        this.A.setDelay(this.f11995x.video.getKeepSeconds());
        this.f11997z.setVisibility(8);
        this.f11994w.O(this.f11995x.video.getUrl(), 0, "");
        String posterUrl = this.f11995x.getPosterUrl();
        if (!l.q(posterUrl)) {
            this.f11994w.setThumbImage(posterUrl);
        }
        this.f11994w.f13039h.performClick();
        K2();
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void J(String str, String str2, String str3) {
        k0.d(this, str, str2, str3, new k0.a() { // from class: f8.c
            public /* synthetic */ c() {
            }

            @Override // l9.k0.a
            public final void a(String str4, String str5) {
                VideoBonusActivity.this.H2(str4, str5);
            }
        }, false);
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void K0(ValueCallback<Uri> valueCallback, String str, String str2) {
    }

    public void K2() {
        if (l.q(this.f11995x.title) && l.q(this.f11995x.iconUrl)) {
            return;
        }
        this.D.setVisibility(0);
        m0.k(this, this.f11995x.iconUrl, this.E);
        this.F.setText(this.f11995x.title);
        this.G.setText(this.f11995x.nDownloads + "个评分");
        if (this.f11995x.downloadDirectly) {
            this.H.setText("立即下载");
        } else {
            this.H.setText("查看详情");
        }
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void L(int i10, String str, String str2) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void N0(String str) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void S0(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void V(WebView webView, int i10) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void b(WebView webView, String str) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void c0(String str, Bitmap bitmap) {
    }

    public void onCloseClick(View view) {
        if (this.B) {
            if (this.C) {
                h.b(this.f11995x.video.getPageCloseTrackers());
            } else {
                h.b(this.f11995x.video.getPlayInterruptTrackers());
            }
            setResult(-1);
            finish();
        }
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_video_bonus);
        u2(true);
        g(false);
        String string = bundle != null ? bundle.getString(L) : q1(L);
        if (l.q(string)) {
            finish();
        }
        AppTask appTask = (AppTask) GsonUtils.b().fromJson(string, AppTask.class);
        this.f11995x = appTask;
        if (appTask == null) {
            finish();
        }
        MTWebView mTWebView = (MTWebView) findViewById(R.id.vb_video_webview);
        this.f11996y = mTWebView;
        mTWebView.setOnPageStateChangedListener(this);
        this.f11996y.getSettings().setDefaultTextEncodingName("UTF-8");
        CountdownNumberTextView countdownNumberTextView = (CountdownNumberTextView) findViewById(R.id.vb_countdown_text);
        this.A = countdownNumberTextView;
        countdownNumberTextView.setOnCountDownFinishListener(new CountdownNumberTextView.b() { // from class: f8.d
            public /* synthetic */ d() {
            }

            @Override // com.martian.apptask.widget.CountdownNumberTextView.b
            public final void a(CountdownNumberTextView countdownNumberTextView2) {
                VideoBonusActivity.this.G2(countdownNumberTextView2);
            }
        });
        this.f11997z = findViewById(R.id.vb_loading_hint);
        JCVideoPlayerStandard jCVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.vb_videoplayer);
        this.f11994w = jCVideoPlayerStandard;
        jCVideoPlayerStandard.setClearFullScreenStatus(false);
        this.f11994w.setOnVideoStateListener(new a());
        this.D = findViewById(R.id.ad_view);
        this.E = (ImageView) findViewById(R.id.ad_image);
        this.F = (TextView) findViewById(R.id.ad_title);
        this.G = (TextView) findViewById(R.id.ad_comments);
        this.H = (Button) findViewById(R.id.btn_detail);
        I2();
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        JCVideoPlayer.J();
        JCVideoPlayerStandard jCVideoPlayerStandard = this.f11994w;
        if (jCVideoPlayerStandard != null) {
            jCVideoPlayerStandard.destroyDrawingCache();
        }
    }

    public void onGrabClick(View view) {
        AppTask appTask = this.f11995x;
        if (appTask == null) {
            return;
        }
        this.K = true;
        h.b(appTask.video.getPageClickTrackers());
        g.B(this, this.f11995x, new b());
    }

    @Override // com.martian.libmars.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4 && i10 != 3) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (i10 != 4 || !this.f11996y.canGoBack()) {
            return true;
        }
        this.f11996y.goBack();
        return true;
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f11996y != null) {
            if (isFinishing()) {
                this.f11996y.loadUrl("about:blank");
            } else {
                this.f11996y.onPause();
            }
        }
        this.f11994w.f13039h.performClick();
        if (this.K) {
            return;
        }
        this.A.n();
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MTWebView mTWebView = this.f11996y;
        if (mTWebView != null) {
            mTWebView.onResume();
        }
        if (this.J) {
            this.J = false;
        } else {
            this.f11994w.f13039h.performClick();
        }
        if (this.K) {
            return;
        }
        this.A.l();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(L, GsonUtils.b().toJson(this.f11995x));
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (l.q(this.I)) {
            this.I = str;
            return false;
        }
        if (this.I.equalsIgnoreCase(str)) {
            return false;
        }
        h.b(this.f11995x.video.getPageClickTrackers());
        return false;
    }
}
