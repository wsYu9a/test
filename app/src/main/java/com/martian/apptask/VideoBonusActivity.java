package com.martian.apptask;

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
import com.martian.apptask.data.AppTask;
import com.martian.apptask.g.g;
import com.martian.apptask.g.h;
import com.martian.apptask.widget.CountdownNumberTextView;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.l0;
import com.martian.libmars.utils.n0;
import com.martian.libmars.utils.q0;
import com.martian.libmars.widget.MTWebView;
import com.martian.libsupport.k;
import com.martian.libvideoplayer.JCVideoPlayer;
import com.martian.libvideoplayer.JCVideoPlayerStandard;

/* loaded from: classes2.dex */
public class VideoBonusActivity extends j1 implements MTWebView.c {
    public static final String B = "INTENT_APPTASK_JSON";
    public static final int C = 10006;
    private JCVideoPlayerStandard D;
    private AppTask E;
    private MTWebView F;
    private View G;
    private CountdownNumberTextView H;
    private View K;
    private ImageView L;
    private TextView M;
    private TextView N;
    private Button O;
    private boolean I = false;
    private boolean J = false;
    private String P = "";
    private boolean Q = true;
    private boolean R = false;

    class a implements JCVideoPlayerStandard.c {
        a() {
        }

        @Override // com.martian.libvideoplayer.JCVideoPlayerStandard.c
        public void a() {
            q0.f("video_bonus", "playStartTrackers:" + VideoBonusActivity.this.E.video.getPlayStartTrackers().toString());
            h.b(VideoBonusActivity.this.E.video.getPlayStartTrackers());
            VideoBonusActivity.this.H.setVisibility(0);
            VideoBonusActivity.this.H.m();
        }

        @Override // com.martian.libvideoplayer.JCVideoPlayerStandard.c
        public void b() {
            if (VideoBonusActivity.this.E == null || VideoBonusActivity.this.E.video == null || k.p(VideoBonusActivity.this.E.video.getVhtml())) {
                return;
            }
            VideoBonusActivity.this.J = true;
            VideoBonusActivity.this.F.setVisibility(0);
            VideoBonusActivity.this.F.loadDataWithBaseURL(null, VideoBonusActivity.this.E.video.getVhtml(), "text/html; charset=UTF-8", "utf-8", null);
            q0.f("video_bonus", "playEndTrackers:" + VideoBonusActivity.this.E.video.getPlayEndTrackers());
            q0.f("video_bonus", "exposeReportUrls:" + VideoBonusActivity.this.E.exposeReportUrls);
            h.b(VideoBonusActivity.this.E.video.getPlayEndTrackers());
            h.b(VideoBonusActivity.this.E.exposeReportUrls);
            VideoBonusActivity.this.K.setVisibility(8);
        }
    }

    class b implements com.martian.apptask.e.c {
        b() {
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskActivated(AppTask appTask) {
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskClick(AppTask appTask) {
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskDownload(AppTask appTask) {
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskInstalled(AppTask appTask) {
        }
    }

    private void l2() {
        k1("加载视频失败,请重试");
        finish();
    }

    /* renamed from: m2 */
    public /* synthetic */ void n2(CountdownNumberTextView textView) {
        this.I = true;
        this.H.setText("关闭");
    }

    /* renamed from: o2 */
    public /* synthetic */ void p2(String name, String url1) {
        k1("已开始下载" + name);
    }

    private void q2() {
        this.H.setDelay(this.E.video.getKeepSeconds());
        this.G.setVisibility(8);
        this.D.N(this.E.video.getUrl(), 0, "");
        String posterUrl = this.E.getPosterUrl();
        if (!k.p(posterUrl)) {
            this.D.setThumbImage(posterUrl);
        }
        this.D.K.performClick();
        s2();
    }

    public static void r2(j1 activity, AppTask appTask) {
        Bundle bundle = new Bundle();
        bundle.putString(B, GsonUtils.b().toJson(appTask));
        activity.startActivityForResult(VideoBonusActivity.class, bundle, 10006);
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void c(WebView view, String title) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void g(String url) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void h(WebView view, String deeplink, boolean canHandle) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public boolean i(WebView view, String url, String message) {
        return false;
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void k(String url, String contentDisposition, String mimetype) {
        l0.f(this, url, contentDisposition, mimetype, new l0.a() { // from class: com.martian.apptask.b
            @Override // com.martian.libmars.utils.l0.a
            public final void a(String str, String str2) {
                VideoBonusActivity.this.p2(str, str2);
            }
        }, false);
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void l(int errorCode, String description, String failingUrl) {
    }

    public void onCloseClick(View view) {
        if (this.I) {
            if (this.J) {
                q0.f("video_bonus", "pageCloseTrackers");
                h.b(this.E.video.getPageCloseTrackers());
            } else {
                q0.f("video_bonus", "playInterruptTrackers");
                h.b(this.E.video.getPlayInterruptTrackers());
            }
            setResult(-1);
            finish();
        }
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_bonus);
        a2(true);
        d(false);
        String string = savedInstanceState != null ? savedInstanceState.getString(B) : G0(B);
        if (k.p(string)) {
            finish();
        }
        AppTask appTask = (AppTask) GsonUtils.b().fromJson(string, AppTask.class);
        this.E = appTask;
        if (appTask == null) {
            finish();
        }
        MTWebView mTWebView = (MTWebView) findViewById(R.id.vb_video_webview);
        this.F = mTWebView;
        mTWebView.setOnPageStateChangedListener(this);
        this.F.getSettings().setDefaultTextEncodingName("UTF-8");
        CountdownNumberTextView countdownNumberTextView = (CountdownNumberTextView) findViewById(R.id.vb_countdown_text);
        this.H = countdownNumberTextView;
        countdownNumberTextView.setOnCountDownFinishListener(new CountdownNumberTextView.b() { // from class: com.martian.apptask.a
            @Override // com.martian.apptask.widget.CountdownNumberTextView.b
            public final void a(CountdownNumberTextView countdownNumberTextView2) {
                VideoBonusActivity.this.n2(countdownNumberTextView2);
            }
        });
        this.G = findViewById(R.id.vb_loading_hint);
        JCVideoPlayerStandard jCVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.vb_videoplayer);
        this.D = jCVideoPlayerStandard;
        jCVideoPlayerStandard.setClearFullScreenStatus(false);
        this.D.setOnVideoStateListener(new a());
        this.K = findViewById(R.id.ad_view);
        this.L = (ImageView) findViewById(R.id.ad_image);
        this.M = (TextView) findViewById(R.id.ad_title);
        this.N = (TextView) findViewById(R.id.ad_comments);
        this.O = (Button) findViewById(R.id.btn_detail);
        q2();
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        JCVideoPlayer.I();
        JCVideoPlayerStandard jCVideoPlayerStandard = this.D;
        if (jCVideoPlayerStandard != null) {
            jCVideoPlayerStandard.destroyDrawingCache();
        }
    }

    public void onGrabClick(View view) {
        AppTask appTask = this.E;
        if (appTask == null) {
            return;
        }
        this.R = true;
        h.b(appTask.video.getPageClickTrackers());
        g.v(this, this.E, new b());
    }

    @Override // com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 && keyCode != 3) {
            return super.onKeyDown(keyCode, event);
        }
        if (keyCode != 4 || !this.F.canGoBack()) {
            return true;
        }
        this.F.goBack();
        return true;
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void onPageFinished(String url) {
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.F != null) {
            if (isFinishing()) {
                this.F.loadUrl("about:blank");
            } else {
                this.F.onPause();
            }
        }
        this.D.K.performClick();
        if (this.R) {
            return;
        }
        this.H.o();
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        MTWebView mTWebView = this.F;
        if (mTWebView != null) {
            mTWebView.onResume();
        }
        if (this.Q) {
            this.Q = false;
        } else {
            this.D.K.performClick();
        }
        if (this.R) {
            return;
        }
        this.H.m();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(B, GsonUtils.b().toJson(this.E));
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void p(WebView view, int newProgress) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void q(String url, Bitmap favicon) {
    }

    public void s2() {
        if (k.p(this.E.title) && k.p(this.E.iconUrl)) {
            return;
        }
        this.K.setVisibility(0);
        n0.k(this, this.E.iconUrl, this.L);
        this.M.setText(this.E.title);
        this.N.setText(this.E.nDownloads + "个评分");
        if (this.E.downloadDirectly) {
            this.O.setText("立即下载");
        } else {
            this.O.setText("查看详情");
        }
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (k.p(this.P)) {
            this.P = url;
            return false;
        }
        if (this.P.equalsIgnoreCase(url)) {
            return false;
        }
        q0.f("video_bonus", "pageClickTrackers");
        h.b(this.E.video.getPageClickTrackers());
        return false;
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void t(ValueCallback<Uri> callback, String acceptType, String capture) {
    }

    @Override // com.martian.libmars.widget.MTWebView.c
    public void u(WebView webView, ValueCallback<Uri[]> uploadMsg, WebChromeClient.FileChooserParams fileChooserParams) {
    }
}
