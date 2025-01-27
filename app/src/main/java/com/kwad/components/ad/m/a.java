package com.kwad.components.ad.m;

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
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.a.c;

/* loaded from: classes2.dex */
public final class a {
    protected AdBaseFrameLayout JA;
    private InterfaceC0388a JB;
    private c.a JF;
    private b JG;
    private KsAdWebView Jx;
    private boolean Jy;
    private boolean Jz;
    private AdBaseFrameLayout eQ;

    /* renamed from: ee */
    @Nullable
    private com.kwad.sdk.core.webview.d.a.a f11645ee;
    private FrameLayout en;
    private Activity mActivity;
    private AdTemplate mAdTemplate;
    private ImageView mBackIcon;
    private long mLastDown;
    private boolean Jw = true;

    /* renamed from: hf */
    private Handler f11646hf = new Handler(Looper.getMainLooper());
    private boolean JC = false;
    private boolean JD = false;
    private boolean JE = false;

    /* renamed from: com.kwad.components.ad.m.a$1 */
    public class AnonymousClass1 implements DownloadListener {
        public AnonymousClass1() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            a.a(a.this, true);
            if (a.this.JB != null) {
                a.this.JB.S(a.this.bW());
            }
        }
    }

    /* renamed from: com.kwad.components.ad.m.a$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (a.this.JG != null) {
                a.this.JG.iR();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.m.a$3 */
    public class AnonymousClass3 implements KsAdWebView.e {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageFinished() {
            if (a.this.JB != null) {
                a.this.JB.S(a.this.bW());
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageStart() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onReceivedHttpError(int i10, String str, String str2) {
            a.b(a.this, true);
            if (a.this.JB != null) {
                a.this.JB.S(a.this.bW());
            }
        }
    }

    /* renamed from: com.kwad.components.ad.m.a$4 */
    public class AnonymousClass4 implements KsAdWebView.b {
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.b
        public final void onFailed() {
            a.c(a.this, true);
            if (a.this.JB != null) {
                a.this.JB.S(a.this.bW());
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.b
        public final void onSuccess() {
            a.c(a.this, true);
            if (a.this.JB != null) {
                a.this.JB.S(a.this.bW());
            }
        }
    }

    /* renamed from: com.kwad.components.ad.m.a$5 */
    public class AnonymousClass5 implements View.OnTouchListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getX() > a.this.mBackIcon.getX() && motionEvent.getX() - a.this.mBackIcon.getX() < a.this.mBackIcon.getWidth() && motionEvent.getY() > a.this.mBackIcon.getY() && motionEvent.getY() - a.this.mBackIcon.getY() < a.this.mBackIcon.getHeight()) {
                com.kwad.sdk.core.d.c.d("LandingPageWebCard", "onClick backIcon");
                return false;
            }
            if (motionEvent.getAction() == 0) {
                a.this.mLastDown = SystemClock.elapsedRealtime();
            } else if (motionEvent.getAction() == 1) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.mLastDown;
                if (a.this.mLastDown > 0 && elapsedRealtime > 30 && elapsedRealtime < 500) {
                    com.kwad.sdk.core.adlog.c.a(a.this.mAdTemplate, 155, a.this.eQ.getTouchCoords());
                    if (!a.this.Jy) {
                        a.d(a.this, true);
                        if (a.this.f11645ee != null) {
                            com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
                            aVar.aap = 3;
                            a.this.f11645ee.a(aVar);
                        }
                    }
                }
                a.this.mLastDown = 0L;
            }
            return false;
        }
    }

    /* renamed from: com.kwad.components.ad.m.a$6 */
    public class AnonymousClass6 implements Runnable {
        public AnonymousClass6() {
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

    /* renamed from: com.kwad.components.ad.m.a$a */
    public interface InterfaceC0388a {
        void S(boolean z10);
    }

    public interface b {
        void iR();
    }

    private static String F(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.aS(e.eb(adTemplate));
    }

    public boolean bW() {
        return this.JE ? !this.Jw : (this.Jw || this.JC || this.JD) ? false : true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void fD() {
        this.en.removeAllViews();
        this.en.setVisibility(4);
        this.JA = (AdBaseFrameLayout) ((ViewGroup) com.kwad.sdk.c.a.a.a((ViewGroup) this.en, R.layout.ksad_ad_landingpage_layout, true)).findViewById(R.id.ksad_web_card_frame);
        KsAdWebView ksAdWebView = (KsAdWebView) this.en.findViewById(R.id.ksad_web_card_webView);
        this.Jx = ksAdWebView;
        ksAdWebView.setBackgroundColor(-1);
        c.a b10 = this.Jx.getClientConfig().bx(false).bz(true).by(false).bw(true).ex(this.mAdTemplate).a(mX()).b(iF());
        this.JF = b10;
        this.Jx.setClientConfig(b10);
        this.Jx.setDownloadListener(new DownloadListener() { // from class: com.kwad.components.ad.m.a.1
            public AnonymousClass1() {
            }

            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
                a.a(a.this, true);
                if (a.this.JB != null) {
                    a.this.JB.S(a.this.bW());
                }
            }
        });
        ImageView imageView = (ImageView) this.JA.findViewById(R.id.ksad_end_close_btn);
        this.mBackIcon = imageView;
        imageView.setVisibility(8);
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.m.a.2
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (a.this.JG != null) {
                    a.this.JG.iR();
                }
            }
        });
    }

    private KsAdWebView.e iF() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.m.a.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                if (a.this.JB != null) {
                    a.this.JB.S(a.this.bW());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i10, String str, String str2) {
                a.b(a.this, true);
                if (a.this.JB != null) {
                    a.this.JB.S(a.this.bW());
                }
            }
        };
    }

    private KsAdWebView.b mX() {
        return new KsAdWebView.b() { // from class: com.kwad.components.ad.m.a.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                a.c(a.this, true);
                if (a.this.JB != null) {
                    a.this.JB.S(a.this.bW());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                a.c(a.this, true);
                if (a.this.JB != null) {
                    a.this.JB.S(a.this.bW());
                }
            }
        };
    }

    private boolean mY() {
        if (!bW()) {
            FrameLayout frameLayout = this.en;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            return false;
        }
        FrameLayout frameLayout2 = this.en;
        if (frameLayout2 == null) {
            return true;
        }
        frameLayout2.setVisibility(0);
        return true;
    }

    public final boolean aQ() {
        boolean mY = mY();
        this.JE = true;
        if (mY && this.mActivity != null) {
            if (this.Jx.getClientConfig() != null) {
                this.Jx.getClientConfig().bx(true);
                this.Jx.getClientConfig().by(true);
            }
            this.JA.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.m.a.5
                public AnonymousClass5() {
                }

                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.mBackIcon.getX() && motionEvent.getX() - a.this.mBackIcon.getX() < a.this.mBackIcon.getWidth() && motionEvent.getY() > a.this.mBackIcon.getY() && motionEvent.getY() - a.this.mBackIcon.getY() < a.this.mBackIcon.getHeight()) {
                        com.kwad.sdk.core.d.c.d("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        a.this.mLastDown = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.mLastDown;
                        if (a.this.mLastDown > 0 && elapsedRealtime > 30 && elapsedRealtime < 500) {
                            com.kwad.sdk.core.adlog.c.a(a.this.mAdTemplate, 155, a.this.eQ.getTouchCoords());
                            if (!a.this.Jy) {
                                a.d(a.this, true);
                                if (a.this.f11645ee != null) {
                                    com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
                                    aVar.aap = 3;
                                    a.this.f11645ee.a(aVar);
                                }
                            }
                        }
                        a.this.mLastDown = 0L;
                    }
                    return false;
                }
            });
            long am = com.kwad.sdk.core.response.b.a.am(e.eb(this.mAdTemplate));
            if (am == 0 || !this.Jz) {
                this.mBackIcon.setVisibility(0);
            } else {
                this.f11646hf.postDelayed(new Runnable() { // from class: com.kwad.components.ad.m.a.6
                    public AnonymousClass6() {
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
                }, am);
            }
            KsAdWebView ksAdWebView = this.Jx;
            if (ksAdWebView != null) {
                ksAdWebView.onActivityCreate();
            }
        }
        return mY;
    }

    public final void aX() {
        this.en.setVisibility(4);
        String F = F(this.mAdTemplate);
        if (TextUtils.isEmpty(F)) {
            return;
        }
        this.Jx.loadUrl(F);
    }

    public final a ag(boolean z10) {
        this.Jz = true;
        return this;
    }

    public final void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z10) {
        aVar.Jw = true;
        return true;
    }

    public static /* synthetic */ boolean c(a aVar, boolean z10) {
        aVar.JC = true;
        return true;
    }

    public static /* synthetic */ boolean d(a aVar, boolean z10) {
        aVar.Jy = true;
        return true;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z10) {
        aVar.JD = true;
        return true;
    }

    public final void a(InterfaceC0388a interfaceC0388a) {
        this.JB = interfaceC0388a;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        this.en = frameLayout;
        this.eQ = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        fD();
        this.Jw = false;
    }

    public final void a(b bVar) {
        this.JG = bVar;
    }

    public final void a(com.kwad.sdk.core.webview.d.a.a aVar) {
        this.f11645ee = aVar;
    }
}
