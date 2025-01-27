package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bh;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c extends e implements com.kwad.sdk.core.g.c {
    private TextView BY;
    private com.kwad.components.ad.splashscreen.widget.a BZ;
    private AdInfo.AdPreloadInfo Ca;
    private boolean Cb = false;
    private View Cc;
    private AdInfo rS;

    /* renamed from: com.kwad.components.ad.splashscreen.b.c$1 */
    final class AnonymousClass1 implements SkipView.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
        public final void ac(int i2) {
            c.this.Cg.ab(i2);
        }

        @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
        public final void kI() {
            c.this.kF();
        }

        @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
        public final void kJ() {
            c.this.kG();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.c$2 */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            c.this.kF();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.c$3 */
    final class AnonymousClass3 implements Runnable {

        /* renamed from: com.kwad.components.ad.splashscreen.b.c$3$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                int af = c.this.BZ.af(35);
                ViewGroup.LayoutParams layoutParams = c.this.Cc.getLayoutParams();
                layoutParams.width = af + com.kwad.sdk.c.kwai.a.a(c.this.Cg.mRootContainer.getContext(), 66.0f);
                c.this.Cc.setLayoutParams(layoutParams);
            }
        }

        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((View) c.this.BZ).post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.c.3.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int af = c.this.BZ.af(35);
                    ViewGroup.LayoutParams layoutParams = c.this.Cc.getLayoutParams();
                    layoutParams.width = af + com.kwad.sdk.c.kwai.a.a(c.this.Cg.mRootContainer.getContext(), 66.0f);
                    c.this.Cc.setLayoutParams(layoutParams);
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.c$4 */
    final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.kwad.components.core.d.a.b.mF()) {
                c.this.Cg.mRootContainer.postDelayed(this, 1000L);
            } else {
                c.this.Cg.kw();
            }
        }
    }

    private SplashSkipViewModel kE() {
        SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
        AdInfo adInfo = this.rS;
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        int i2 = adSplashInfo.imageDisplaySecond;
        if (i2 <= 0) {
            i2 = 5;
        }
        int min = Math.min(adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.a.a.F(adInfo));
        if (com.kwad.sdk.core.response.a.a.aU(this.rS)) {
            i2 = min;
        }
        splashSkipViewModel.skipSecond = i2;
        return splashSkipViewModel;
    }

    public void kF() {
        this.Cg.ky();
        JSONObject jSONObject = new JSONObject();
        com.kwad.components.ad.splashscreen.d.a aVar = this.Cg.BG;
        if (aVar != null) {
            try {
                jSONObject.put("duration", aVar.getCurrentPosition());
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        y.a aVar2 = new y.a();
        bh bhVar = this.Cg.mTimerHelper;
        if (bhVar != null) {
            aVar2.duration = bhVar.getTime();
        }
        com.kwad.sdk.core.report.a.b(this.Cg.mAdTemplate, new com.kwad.sdk.core.report.i().bk(1).bp(22).a(aVar2), jSONObject);
    }

    private synchronized void kH() {
        if (!this.Cb && this.BZ != null) {
            if (com.kwad.sdk.core.response.a.a.ce(this.rS) && com.kwad.sdk.core.response.a.a.cf(this.rS)) {
                com.kwad.sdk.core.report.a.b(this.Cg.mAdTemplate, 124, (JSONObject) null);
                this.Cb = true;
            }
        }
    }

    private static boolean q(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.a.a.cc(adInfo);
    }

    private void r(AdInfo adInfo) {
        TextView textView = (TextView) this.Cg.mRootContainer.findViewById(R.id.ksad_splash_preload_tips);
        this.BY = textView;
        this.Ca = adInfo.adPreloadInfo;
        textView.setVisibility(8);
        AdInfo.AdPreloadInfo adPreloadInfo = this.Ca;
        if (adPreloadInfo == null || bb.isNullString(adPreloadInfo.preloadTips)) {
            this.BY.setVisibility(8);
        } else {
            this.BY.setVisibility(0);
            this.BY.setText(this.Ca.preloadTips);
        }
    }

    private void s(AdInfo adInfo) {
        this.Cc = this.Cg.mRootContainer.findViewById(R.id.ksad_skip_view_area);
        if (!com.kwad.sdk.core.response.a.a.cd(adInfo) || adInfo.adSplashInfo.skipButtonPosition != 0) {
            this.Cc.setVisibility(8);
            return;
        }
        this.Cc.setVisibility(0);
        this.Cc.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.b.c.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.kF();
            }
        });
        this.Cc.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.c.3

            /* renamed from: com.kwad.components.ad.splashscreen.b.c$3$1 */
            final class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int af = c.this.BZ.af(35);
                    ViewGroup.LayoutParams layoutParams = c.this.Cc.getLayoutParams();
                    layoutParams.width = af + com.kwad.sdk.c.kwai.a.a(c.this.Cg.mRootContainer.getContext(), 66.0f);
                    c.this.Cc.setLayoutParams(layoutParams);
                }
            }

            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ((View) c.this.BZ).post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.c.3.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        int af = c.this.BZ.af(35);
                        ViewGroup.LayoutParams layoutParams = c.this.Cc.getLayoutParams();
                        layoutParams.width = af + com.kwad.sdk.c.kwai.a.a(c.this.Cg.mRootContainer.getContext(), 66.0f);
                        c.this.Cc.setLayoutParams(layoutParams);
                    }
                });
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void ar() {
        AdBaseFrameLayout adBaseFrameLayout;
        int i2;
        super.ar();
        com.kwad.sdk.core.d.b.d("SkipAdPresenter", "onBind");
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate);
        this.rS = cb;
        r(cb);
        if (q(this.rS)) {
            adBaseFrameLayout = this.Cg.mRootContainer;
            i2 = R.id.ksad_splash_skip_view;
        } else {
            adBaseFrameLayout = this.Cg.mRootContainer;
            i2 = R.id.ksad_splash_circle_skip_view;
        }
        this.BZ = (com.kwad.components.ad.splashscreen.widget.a) adBaseFrameLayout.findViewById(i2);
        this.BZ.a(kE(), this.rS);
        this.BZ.setOnViewListener(new SkipView.a() { // from class: com.kwad.components.ad.splashscreen.b.c.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void ac(int i22) {
                c.this.Cg.ab(i22);
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void kI() {
                c.this.kF();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void kJ() {
                c.this.kG();
            }
        });
        s(this.rS);
        this.Cg.BH.a(this);
    }

    public final void kG() {
        this.Cg.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.c.4
            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.kwad.components.core.d.a.b.mF()) {
                    c.this.Cg.mRootContainer.postDelayed(this, 1000L);
                } else {
                    c.this.Cg.kw();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageInvisible() {
        com.kwad.sdk.core.d.b.d("SkipAdPresenter", "onPageInvisible");
        this.BZ.u(this.rS);
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageVisible() {
        com.kwad.sdk.core.d.b.d("SkipAdPresenter", "onPageVisible");
        this.BZ.v(this.rS);
        kH();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Cg.BH.b(this);
        this.BZ.bn();
    }
}
