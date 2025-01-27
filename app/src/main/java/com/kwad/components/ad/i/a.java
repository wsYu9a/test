package com.kwad.components.ad.i;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.kwai.c;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes.dex */
public final class a {
    private KsAdWebView Go;
    private boolean Gp;
    private boolean Gq;
    protected AdBaseFrameLayout Gr;
    private InterfaceC0131a Gs;
    private b Gw;
    private AdBaseFrameLayout dG;
    private FrameLayout df;
    private c.a kl;
    private Activity mActivity;
    private AdTemplate mAdTemplate;
    private ImageView mBackIcon;
    private long mLastDown;

    @Nullable
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener;
    private boolean Gn = true;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean Gt = false;
    private boolean Gu = false;
    private boolean Gv = false;

    /* renamed from: com.kwad.components.ad.i.a$1 */
    final class AnonymousClass1 implements DownloadListener {
        AnonymousClass1() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            a.a(a.this, true);
            if (a.this.Gs != null) {
                a.this.Gs.V(a.this.bE());
            }
        }
    }

    /* renamed from: com.kwad.components.ad.i.a$2 */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (a.this.Gw != null) {
                a.this.Gw.in();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.i.a$3 */
    final class AnonymousClass3 implements KsAdWebView.d {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageFinished() {
            if (a.this.Gs != null) {
                a.this.Gs.V(a.this.bE());
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageStart() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onReceivedHttpError(int i2, String str, String str2) {
            a.b(a.this, true);
            if (a.this.Gs != null) {
                a.this.Gs.V(a.this.bE());
            }
        }
    }

    /* renamed from: com.kwad.components.ad.i.a$4 */
    final class AnonymousClass4 implements KsAdWebView.b {
        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.b
        public final void onFailed() {
            a.c(a.this, true);
            if (a.this.Gs != null) {
                a.this.Gs.V(a.this.bE());
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.b
        public final void onSuccess() {
            a.c(a.this, true);
            if (a.this.Gs != null) {
                a.this.Gs.V(a.this.bE());
            }
        }
    }

    /* renamed from: com.kwad.components.ad.i.a$5 */
    final class AnonymousClass5 implements View.OnTouchListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getX() > a.this.mBackIcon.getX() && motionEvent.getX() - a.this.mBackIcon.getX() < a.this.mBackIcon.getWidth() && motionEvent.getY() > a.this.mBackIcon.getY() && motionEvent.getY() - a.this.mBackIcon.getY() < a.this.mBackIcon.getHeight()) {
                com.kwad.sdk.core.d.b.d("LandingPageWebCard", "onClick backIcon");
                return false;
            }
            if (motionEvent.getAction() == 0) {
                a.this.mLastDown = SystemClock.elapsedRealtime();
            } else if (motionEvent.getAction() == 1) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.mLastDown;
                if (a.this.mLastDown > 0 && elapsedRealtime > 30 && elapsedRealtime < 500) {
                    com.kwad.sdk.core.report.a.a(a.this.mAdTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, a.this.dG.getTouchCoords());
                    if (!a.this.Gp) {
                        a.d(a.this, true);
                        if (a.this.mWebCardClickListener != null) {
                            com.kwad.sdk.core.webview.c.a.a aVar = new com.kwad.sdk.core.webview.c.a.a();
                            aVar.TC = 3;
                            a.this.mWebCardClickListener.onAdClicked(aVar);
                        }
                    }
                }
                a.this.mLastDown = 0L;
            }
            return false;
        }
    }

    /* renamed from: com.kwad.components.ad.i.a$6 */
    final class AnonymousClass6 implements Runnable {
        AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.mActivity == null || a.this.mActivity.isFinishing()) {
                return;
            }
            a.this.mBackIcon.setVisibility(0);
            a.this.mBackIcon.setAlpha(0.0f);
            a.this.mBackIcon.animate().alpha(1.0f).setDuration(500L).start();
        }
    }

    /* renamed from: com.kwad.components.ad.i.a$a */
    public interface InterfaceC0131a {
        void V(boolean z);
    }

    public interface b {
        void in();
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.Gu = true;
        return true;
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.Gn = true;
        return true;
    }

    public boolean bE() {
        return this.Gv ? !this.Gn : (this.Gn || this.Gt || this.Gu) ? false : true;
    }

    static /* synthetic */ boolean c(a aVar, boolean z) {
        aVar.Gt = true;
        return true;
    }

    static /* synthetic */ boolean d(a aVar, boolean z) {
        aVar.Gp = true;
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void fq() {
        this.df.removeAllViews();
        this.df.setVisibility(4);
        this.Gr = (AdBaseFrameLayout) ((ViewGroup) com.kwad.sdk.c.kwai.a.a((ViewGroup) this.df, R.layout.ksad_ad_landingpage_layout, true)).findViewById(R.id.ksad_web_card_frame);
        KsAdWebView ksAdWebView = (KsAdWebView) this.df.findViewById(R.id.ksad_web_card_webView);
        this.Go = ksAdWebView;
        ksAdWebView.setBackgroundColor(-1);
        y.b bVar = new y.b();
        bVar.akv = 1;
        c.a b2 = this.Go.getClientConfig().bc(false).be(true).bd(false).b(bVar).ct(this.mAdTemplate).a(lI()).b(getWebListener());
        this.kl = b2;
        this.Go.setClientConfig(b2);
        this.Go.setDownloadListener(new DownloadListener() { // from class: com.kwad.components.ad.i.a.1
            AnonymousClass1() {
            }

            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                a.a(a.this, true);
                if (a.this.Gs != null) {
                    a.this.Gs.V(a.this.bE());
                }
            }
        });
        ImageView imageView = (ImageView) this.Gr.findViewById(R.id.ksad_end_close_btn);
        this.mBackIcon = imageView;
        imageView.setVisibility(8);
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.i.a.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (a.this.Gw != null) {
                    a.this.Gw.in();
                }
            }
        });
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.i.a.3
            AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                if (a.this.Gs != null) {
                    a.this.Gs.V(a.this.bE());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                a.b(a.this, true);
                if (a.this.Gs != null) {
                    a.this.Gs.V(a.this.bE());
                }
            }
        };
    }

    private static String l(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.a.aK(d.cb(adTemplate));
    }

    private KsAdWebView.b lI() {
        return new KsAdWebView.b() { // from class: com.kwad.components.ad.i.a.4
            AnonymousClass4() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                a.c(a.this, true);
                if (a.this.Gs != null) {
                    a.this.Gs.V(a.this.bE());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                a.c(a.this, true);
                if (a.this.Gs != null) {
                    a.this.Gs.V(a.this.bE());
                }
            }
        };
    }

    private boolean lJ() {
        if (!bE()) {
            FrameLayout frameLayout = this.df;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            return false;
        }
        FrameLayout frameLayout2 = this.df;
        if (frameLayout2 == null) {
            return true;
        }
        frameLayout2.setVisibility(0);
        return true;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        this.df = frameLayout;
        this.dG = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        fq();
        this.Gn = false;
    }

    public final void a(InterfaceC0131a interfaceC0131a) {
        this.Gs = interfaceC0131a;
    }

    public final void a(b bVar) {
        this.Gw = bVar;
    }

    public final void a(com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this.mWebCardClickListener = aVar;
    }

    public final void aG() {
        this.df.setVisibility(4);
        String l = l(this.mAdTemplate);
        if (TextUtils.isEmpty(l)) {
            return;
        }
        this.Go.loadUrl(l);
    }

    public final a ak(boolean z) {
        this.Gq = z;
        return this;
    }

    public final boolean az() {
        boolean lJ = lJ();
        this.Gv = true;
        if (lJ && this.mActivity != null) {
            if (this.Go.getClientConfig() != null) {
                this.Go.getClientConfig().bc(true);
                this.Go.getClientConfig().bd(true);
            }
            this.Gr.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.i.a.5
                AnonymousClass5() {
                }

                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.mBackIcon.getX() && motionEvent.getX() - a.this.mBackIcon.getX() < a.this.mBackIcon.getWidth() && motionEvent.getY() > a.this.mBackIcon.getY() && motionEvent.getY() - a.this.mBackIcon.getY() < a.this.mBackIcon.getHeight()) {
                        com.kwad.sdk.core.d.b.d("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        a.this.mLastDown = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.mLastDown;
                        if (a.this.mLastDown > 0 && elapsedRealtime > 30 && elapsedRealtime < 500) {
                            com.kwad.sdk.core.report.a.a(a.this.mAdTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, a.this.dG.getTouchCoords());
                            if (!a.this.Gp) {
                                a.d(a.this, true);
                                if (a.this.mWebCardClickListener != null) {
                                    com.kwad.sdk.core.webview.c.a.a aVar = new com.kwad.sdk.core.webview.c.a.a();
                                    aVar.TC = 3;
                                    a.this.mWebCardClickListener.onAdClicked(aVar);
                                }
                            }
                        }
                        a.this.mLastDown = 0L;
                    }
                    return false;
                }
            });
            long ad2 = com.kwad.sdk.core.response.a.a.ad(d.cb(this.mAdTemplate));
            if (ad2 == 0 || !this.Gq) {
                this.mBackIcon.setVisibility(0);
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.i.a.6
                    AnonymousClass6() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.mActivity == null || a.this.mActivity.isFinishing()) {
                            return;
                        }
                        a.this.mBackIcon.setVisibility(0);
                        a.this.mBackIcon.setAlpha(0.0f);
                        a.this.mBackIcon.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, ad2);
            }
            KsAdWebView ksAdWebView = this.Go;
            if (ksAdWebView != null) {
                ksAdWebView.onActivityCreate();
            }
        }
        return lJ;
    }

    public final void setActivity(Activity activity) {
        this.mActivity = activity;
    }
}
