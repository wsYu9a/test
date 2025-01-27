package com.kwad.components.ad.splashscreen.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class m extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.f.b, com.kwad.sdk.widget.c {
    private boolean Ey;
    private com.kwad.components.ad.splashscreen.d Fg;
    private ViewGroup Fj;
    private KsShakeView Fk;
    private TextView Fl;
    private com.kwad.sdk.core.f.d fv;
    private Vibrator fx;
    private long mStartTime;

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.m$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            m.this.EJ.Ek = SystemClock.elapsedRealtime() - m.this.mStartTime;
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.m$2 */
    public class AnonymousClass2 extends bd {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            m.this.Fk.mL();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.m$3 */
    public class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ double hu;

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.m$3$1 */
        public class AnonymousClass1 implements h.a {
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.ad.splashscreen.h.a
            public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                bVar.l(d10);
            }
        }

        public AnonymousClass3(double d10) {
            d10 = d10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            m mVar = m.this;
            com.kwad.components.ad.splashscreen.h hVar = mVar.EJ;
            if (hVar != null) {
                hVar.a(1, mVar.getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.m.3.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.components.ad.splashscreen.h.a
                    public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                        bVar.l(d10);
                    }
                });
            }
            m.this.Fk.mL();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void X(int i10) {
    }

    @Override // com.kwad.sdk.core.f.b
    public final void bw() {
        com.kwad.sdk.core.adlog.c.bV(this.EJ.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        getRootView().post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.m.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                m.this.EJ.Ek = SystemClock.elapsedRealtime() - m.this.mStartTime;
            }
        });
        Context context = getContext();
        if (context != null) {
            this.fx = (Vibrator) context.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_shake_layout);
        if (viewStub != null) {
            this.Fj = (ViewGroup) viewStub.inflate();
        } else {
            this.Fj = (ViewGroup) findViewById(R.id.ksad_shake_root);
        }
        this.Fl = (TextView) this.Fj.findViewById(R.id.ksad_shake_action);
        KsShakeView ksShakeView = (KsShakeView) this.Fj.findViewById(R.id.ksad_shake_view);
        this.Fk = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void j(int i10, String str) {
        TextView textView = this.Fl;
        if (textView != null) {
            if (i10 == 2) {
                textView.setText(str);
                return;
            }
            textView.setText("或点击" + str);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kS() {
        com.kwad.sdk.core.f.d dVar = this.fv;
        if (dVar != null) {
            dVar.bA(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lA() {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate);
        com.kwad.components.ad.splashscreen.h hVar = this.EJ;
        this.Fg = com.kwad.components.ad.splashscreen.d.a(hVar.mAdTemplate, eb2, hVar.mApkDownloadHelper, 2);
        this.Ey = com.kwad.sdk.core.response.b.d.dQ(this.EJ.mAdTemplate);
        new com.kwad.sdk.widget.f(this.Fk.getContext(), this.Fk, this);
        this.EJ.a(this);
        TextView textView = this.Fl;
        if (textView != null) {
            textView.setText(this.Fg.kM());
        }
        KsShakeView ksShakeView = this.Fk;
        if (ksShakeView != null) {
            ksShakeView.ad(this.Fg.kN());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lB() {
        ViewGroup viewGroup = this.Fj;
        if (viewGroup == null || this.EJ == null) {
            return;
        }
        viewGroup.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.EJ.mAdTemplate, 185, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.d.a.uf().aX(185);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lC() {
        float db2 = com.kwad.sdk.core.response.b.b.db(this.EJ.mAdTemplate);
        com.kwad.sdk.core.f.d dVar = this.fv;
        if (dVar != null) {
            dVar.g(db2);
            return;
        }
        com.kwad.sdk.core.f.d dVar2 = new com.kwad.sdk.core.f.d(db2);
        this.fv = dVar2;
        dVar2.a(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lD() {
        com.kwad.sdk.core.f.d dVar = this.fv;
        if (dVar != null) {
            dVar.bz(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lE() {
        com.kwad.sdk.core.f.d dVar = this.fv;
        if (dVar != null) {
            dVar.bA(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lF() {
        this.Fk.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.m.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                m.this.Fk.mL();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        AdTemplate adTemplate;
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onClick: " + view);
        if (!view.equals(this.Fk) || (hVar = this.EJ) == null || (adTemplate = hVar.mAdTemplate) == null || !com.kwad.sdk.core.response.b.b.dW(com.kwad.sdk.core.response.b.e.eb(adTemplate))) {
            return;
        }
        this.EJ.c(1, getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 1);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.EJ;
        if (hVar != null) {
            hVar.b(this);
        }
        KsShakeView ksShakeView = this.Fk;
        if (ksShakeView != null) {
            ksShakeView.mM();
        }
    }

    @Override // com.kwad.sdk.core.f.b
    public final void a(double d10) {
        boolean of2 = com.kwad.components.core.e.c.b.of();
        if (!this.EJ.DV.uH() || of2) {
            return;
        }
        this.Fk.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.presenter.m.3
            final /* synthetic */ double hu;

            /* renamed from: com.kwad.components.ad.splashscreen.presenter.m$3$1 */
            public class AnonymousClass1 implements h.a {
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.l(d10);
                }
            }

            public AnonymousClass3(double d102) {
                d10 = d102;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                m mVar = m.this;
                com.kwad.components.ad.splashscreen.h hVar = mVar.EJ;
                if (hVar != null) {
                    hVar.a(1, mVar.getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.m.3.1
                        public AnonymousClass1() {
                        }

                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.l(d10);
                        }
                    });
                }
                m.this.Fk.mL();
            }
        });
        bt.a(getContext(), this.fx);
        lE();
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.Ey);
        if (this.Ey && (hVar = this.EJ) != null) {
            hVar.c(1, view.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.d.c.d("SplashShakePresenter", "onSingleTap: " + view);
        if (com.kwad.sdk.core.response.b.b.dW(com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate)) && (hVar = this.EJ) != null) {
            hVar.c(1, getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 1);
        }
    }
}
