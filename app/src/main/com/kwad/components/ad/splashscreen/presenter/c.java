package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.bt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c extends e implements com.kwad.sdk.core.h.c {
    private TextView EA;
    private com.kwad.components.ad.splashscreen.widget.b EB;
    private AdInfo.AdPreloadInfo ED;
    private boolean EE = false;
    private View EF;
    private AdInfo tG;

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.c$1 */
    public class AnonymousClass1 implements SkipView.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
        public final void Z(int i10) {
            c.this.EJ.Y(i10);
        }

        @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
        public final void lr() {
            c.this.lo();
        }

        @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
        public final void ls() {
            c.this.lp();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.c$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            c.this.lo();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.c$3 */
    public class AnonymousClass3 extends bd {

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.c$3$1 */
        public class AnonymousClass1 extends bd {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                int ab2 = c.this.EB.ab(35);
                ViewGroup.LayoutParams layoutParams = c.this.EF.getLayoutParams();
                layoutParams.width = ab2 + com.kwad.sdk.c.a.a.a(c.this.EJ.mRootContainer.getContext(), 66.0f);
                c.this.EF.setLayoutParams(layoutParams);
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            ((View) c.this.EB).post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    int ab2 = c.this.EB.ab(35);
                    ViewGroup.LayoutParams layoutParams = c.this.EF.getLayoutParams();
                    layoutParams.width = ab2 + com.kwad.sdk.c.a.a.a(c.this.EJ.mRootContainer.getContext(), 66.0f);
                    c.this.EF.setLayoutParams(layoutParams);
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.c$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.EB != null) {
                c.this.EB.bH();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.c$5 */
    public class AnonymousClass5 extends bd {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (com.kwad.components.core.e.c.b.of()) {
                c.this.EJ.mRootContainer.postDelayed(this, 1000L);
            } else {
                c.this.EJ.ld();
            }
        }
    }

    private SplashSkipViewModel ln() {
        SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
        AdInfo adInfo = this.tG;
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        int i10 = adSplashInfo.imageDisplaySecond;
        if (i10 <= 0) {
            i10 = 5;
        }
        int min = Math.min(adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.b.a.L(adInfo));
        if (com.kwad.sdk.core.response.b.a.bc(this.tG)) {
            i10 = min;
        }
        splashSkipViewModel.skipSecond = i10;
        return splashSkipViewModel;
    }

    public void lo() {
        com.kwad.components.ad.splashscreen.monitor.a.lk().ac(this.EJ.mAdTemplate);
        this.EJ.lf();
        JSONObject jSONObject = new JSONObject();
        com.kwad.components.ad.splashscreen.d.a aVar = this.EJ.DT;
        if (aVar != null) {
            try {
                jSONObject.put("duration", aVar.getCurrentPosition());
            } catch (JSONException e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
        }
        a.C0484a c0484a = new a.C0484a();
        bs bsVar = this.EJ.mTimerHelper;
        if (bsVar != null) {
            c0484a.duration = bsVar.getTime();
        }
        com.kwad.sdk.core.adlog.c.b(this.EJ.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cM(1).cU(22).b(c0484a), jSONObject);
    }

    private synchronized void lq() {
        if (!this.EE && this.EB != null) {
            if (com.kwad.sdk.core.response.b.a.cE(this.tG) && com.kwad.sdk.core.response.b.a.cF(this.tG)) {
                com.kwad.sdk.core.adlog.c.b(this.EJ.mAdTemplate, 124, (JSONObject) null);
                this.EE = true;
            }
        }
    }

    private void t(AdInfo adInfo) {
        findViewById(com.kwad.components.ad.splashscreen.e.c.z(adInfo) ? R.id.ksad_splash_right_top_root : R.id.ksad_splash_left_top_root).setVisibility(0);
    }

    private static boolean u(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.b.a.cC(adInfo);
    }

    private void v(AdInfo adInfo) {
        this.EA = (TextView) findViewById(com.kwad.components.ad.splashscreen.e.c.z(adInfo) ? R.id.ksad_splash_preload_right_tips : R.id.ksad_splash_preload_left_tips);
        AdInfo.AdPreloadInfo adPreloadInfo = adInfo.adPreloadInfo;
        this.ED = adPreloadInfo;
        if (adPreloadInfo == null || bm.isNullString(adPreloadInfo.preloadTips)) {
            this.EA.setVisibility(8);
        } else {
            this.EA.setVisibility(0);
            this.EA.setText(this.ED.preloadTips);
        }
    }

    private void w(AdInfo adInfo) {
        this.EF = findViewById(R.id.ksad_skip_view_area);
        if (!com.kwad.sdk.core.response.b.a.cD(adInfo) || adInfo.adSplashInfo.skipButtonPosition != 0) {
            this.EF.setVisibility(8);
            return;
        }
        this.EF.setVisibility(0);
        this.EF.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.presenter.c.2
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.lo();
            }
        });
        this.EF.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3

            /* renamed from: com.kwad.components.ad.splashscreen.presenter.c$3$1 */
            public class AnonymousClass1 extends bd {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    int ab2 = c.this.EB.ab(35);
                    ViewGroup.LayoutParams layoutParams = c.this.EF.getLayoutParams();
                    layoutParams.width = ab2 + com.kwad.sdk.c.a.a.a(c.this.EJ.mRootContainer.getContext(), 66.0f);
                    c.this.EF.setLayoutParams(layoutParams);
                }
            }

            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                ((View) c.this.EB).post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        int ab2 = c.this.EB.ab(35);
                        ViewGroup.LayoutParams layoutParams = c.this.EF.getLayoutParams();
                        layoutParams.width = ab2 + com.kwad.sdk.c.a.a.a(c.this.EJ.mRootContainer.getContext(), 66.0f);
                        c.this.EF.setLayoutParams(layoutParams);
                    }
                });
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void as() {
        super.as();
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onBind");
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate);
        this.tG = eb2;
        t(eb2);
        v(this.tG);
        if (u(this.tG)) {
            this.EB = (com.kwad.components.ad.splashscreen.widget.b) findViewById(com.kwad.components.ad.splashscreen.e.c.z(this.tG) ? R.id.ksad_splash_skip_right_view : R.id.ksad_splash_skip_left_view);
        } else {
            this.EB = (com.kwad.components.ad.splashscreen.widget.b) findViewById(com.kwad.components.ad.splashscreen.e.c.z(this.tG) ? R.id.ksad_splash_circle_skip_right_view : R.id.ksad_splash_circle_skip_left_view);
        }
        this.EB.a(ln(), this.tG);
        this.EB.setOnViewListener(new SkipView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.c.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void Z(int i10) {
                c.this.EJ.Y(i10);
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void lr() {
                c.this.lo();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void ls() {
                c.this.lp();
            }
        });
        w(this.tG);
        this.EJ.DV.a(this);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bl() {
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onPageVisible");
        this.EB.B(this.tG);
        lq();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void bm() {
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onPageInvisible");
        this.EB.A(this.tG);
    }

    public final void lp() {
        this.EJ.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.c.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (com.kwad.components.core.e.c.b.of()) {
                    c.this.EJ.mRootContainer.postDelayed(this, 1000L);
                } else {
                    c.this.EJ.ld();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.EJ.DV.b(this);
        bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.c.4
            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.EB != null) {
                    c.this.EB.bH();
                }
            }
        });
    }
}
