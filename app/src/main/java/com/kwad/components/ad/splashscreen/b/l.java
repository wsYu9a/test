package com.kwad.components.ad.splashscreen.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
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
import com.kwad.sdk.utils.bi;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class l extends e implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.f.b, com.kwad.sdk.widget.c {
    private static long ka = 400;
    private boolean BX;
    private com.kwad.components.ad.splashscreen.d CH;
    private ViewGroup CL;
    private KsShakeView CM;
    private TextView CN;
    private com.kwad.components.ad.splashscreen.e.a Cv;
    private com.kwad.sdk.core.f.d ef;
    private Vibrator eg;

    /* renamed from: com.kwad.components.ad.splashscreen.b.l$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            l.this.CM.lw();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.l$2 */
    final class AnonymousClass2 extends com.kwad.components.ad.splashscreen.e.a {
        AnonymousClass2(Context context, AdTemplate adTemplate) {
            super(context, adTemplate);
        }

        @Override // com.kwad.components.ad.splashscreen.e.a
        @SuppressLint({"SetTextI18n"})
        public final void ac(String str) {
            if (l.this.CN != null) {
                l.this.CN.setText("或点击" + str);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.l$3 */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            l.this.ef.xD();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.l$4 */
    final class AnonymousClass4 extends AnimatorListenerAdapter {
        final /* synthetic */ double fZ;

        /* renamed from: com.kwad.components.ad.splashscreen.b.l$4$1 */
        final class AnonymousClass1 implements h.a {
            AnonymousClass1() {
            }

            @Override // com.kwad.components.ad.splashscreen.h.a
            public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
                iVar.i(d2);
            }
        }

        /* renamed from: com.kwad.components.ad.splashscreen.b.l$4$2 */
        final class AnonymousClass2 implements Runnable {
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onShakeEvent openGate2");
                l.this.ef.xD();
            }
        }

        AnonymousClass4(double d2) {
            d2 = d2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            l lVar = l.this;
            com.kwad.components.ad.splashscreen.h hVar = lVar.Cg;
            if (hVar != null) {
                hVar.a(1, lVar.getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.l.4.1
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.components.ad.splashscreen.h.a
                    public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
                        iVar.i(d2);
                    }
                });
            }
            l.this.CM.lw();
            bi.a(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.l.4.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onShakeEvent openGate2");
                    l.this.ef.xD();
                }
            }, null, 500L);
        }
    }

    private void kV() {
        com.kwad.components.ad.splashscreen.h hVar = this.Cg;
        if (hVar != null) {
            com.kwad.components.ad.splashscreen.e.a aVar = this.Cv;
            if (aVar == null) {
                this.Cv = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Cg.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.l.2
                    AnonymousClass2(Context context, AdTemplate adTemplate) {
                        super(context, adTemplate);
                    }

                    @Override // com.kwad.components.ad.splashscreen.e.a
                    @SuppressLint({"SetTextI18n"})
                    public final void ac(String str) {
                        if (l.this.CN != null) {
                            l.this.CN.setText("或点击" + str);
                        }
                    }
                };
            } else {
                aVar.setAdTemplate(hVar.mAdTemplate);
            }
            com.kwad.components.core.d.b.c cVar = this.Cg.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.Cv);
            }
        }
    }

    private void lb() {
        TextView textView = this.CN;
        if (textView != null) {
            textView.setText(this.CH.kq());
        }
        KsShakeView ksShakeView = this.CM;
        if (ksShakeView != null) {
            ksShakeView.ah(this.CH.kr());
        }
        if (com.kwad.components.ad.splashscreen.e.c.c(this.Cg)) {
            com.kwad.components.ad.splashscreen.e.c.a(this.CN, -1, 60, -1, -1);
        }
    }

    private void lc() {
        ViewGroup viewGroup = this.CL;
        if (viewGroup == null || this.Cg == null) {
            return;
        }
        viewGroup.setVisibility(0);
        com.kwad.sdk.core.report.a.b(this.Cg.mAdTemplate, 185, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.f.b
    public final void a(double d2) {
        boolean mF = com.kwad.components.core.d.a.b.mF();
        if (!this.Cg.BH.rG() || mF) {
            bi.a(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.l.3
                AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    l.this.ef.xD();
                }
            }, null, 500L);
        } else {
            this.CM.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.b.l.4
                final /* synthetic */ double fZ;

                /* renamed from: com.kwad.components.ad.splashscreen.b.l$4$1 */
                final class AnonymousClass1 implements h.a {
                    AnonymousClass1() {
                    }

                    @Override // com.kwad.components.ad.splashscreen.h.a
                    public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
                        iVar.i(d2);
                    }
                }

                /* renamed from: com.kwad.components.ad.splashscreen.b.l$4$2 */
                final class AnonymousClass2 implements Runnable {
                    AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onShakeEvent openGate2");
                        l.this.ef.xD();
                    }
                }

                AnonymousClass4(double d22) {
                    d2 = d22;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    l lVar = l.this;
                    com.kwad.components.ad.splashscreen.h hVar = lVar.Cg;
                    if (hVar != null) {
                        hVar.a(1, lVar.getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.l.4.1
                            AnonymousClass1() {
                            }

                            @Override // com.kwad.components.ad.splashscreen.h.a
                            public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
                                iVar.i(d2);
                            }
                        });
                    }
                    l.this.CM.lw();
                    bi.a(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.l.4.2
                        AnonymousClass2() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onShakeEvent openGate2");
                            l.this.ef.xD();
                        }
                    }, null, 500L);
                }
            });
            bi.a(getContext(), this.eg);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onSingleTap: " + view);
        if (com.kwad.sdk.core.response.a.b.di(com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate)) && (hVar = this.Cg) != null) {
            hVar.c(1, getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aa(int i2) {
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.splashscreen.h hVar = this.Cg;
        if (hVar == null) {
            return;
        }
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(hVar.mAdTemplate);
        getContext();
        com.kwad.components.ad.splashscreen.h hVar2 = this.Cg;
        this.CH = com.kwad.components.ad.splashscreen.d.a(hVar2.mAdTemplate, cb, hVar2.mApkDownloadHelper, 2);
        float bx = com.kwad.sdk.core.response.a.b.bx(this.Cg.mAdTemplate);
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar == null) {
            com.kwad.sdk.core.f.d dVar2 = new com.kwad.sdk.core.f.d(bx);
            this.ef = dVar2;
            dVar2.a(this);
        } else {
            dVar.e(bx);
        }
        lb();
        if (com.kwad.sdk.core.response.a.a.ax(cb)) {
            kV();
        }
        lc();
        this.ef.aX(getContext());
        this.CM.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.l.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                l.this.CM.lw();
            }
        });
        this.BX = com.kwad.sdk.core.response.a.c.bQ(this.Cg.mAdTemplate);
        new com.kwad.sdk.widget.f(this.CM.getContext(), this.CM, this);
        this.Cg.a(this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.BX);
        if (this.BX && (hVar = this.Cg) != null) {
            hVar.c(1, view.getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 1);
        }
    }

    @Override // com.kwad.sdk.core.f.b
    public final void bd() {
        com.kwad.sdk.core.report.a.ax(this.Cg.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kt() {
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar != null) {
            dVar.aY(getContext());
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        AdTemplate adTemplate;
        com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onClick: " + view);
        if (!view.equals(this.CM) || (hVar = this.Cg) == null || (adTemplate = hVar.mAdTemplate) == null || !com.kwad.sdk.core.response.a.b.di(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            return;
        }
        this.Cg.c(1, getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        Context context = getContext();
        if (context != null) {
            this.eg = (Vibrator) context.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_shake_layout);
        this.CL = (ViewGroup) (viewStub != null ? viewStub.inflate() : findViewById(R.id.ksad_shake_root));
        this.CN = (TextView) this.CL.findViewById(R.id.ksad_shake_action);
        KsShakeView ksShakeView = (KsShakeView) this.CL.findViewById(R.id.ksad_shake_view);
        this.CM = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.b.d("SplashShakePresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.Cg;
        if (hVar != null) {
            hVar.b(this);
        }
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar != null) {
            dVar.aY(getContext());
        }
        KsShakeView ksShakeView = this.CM;
        if (ksShakeView != null) {
            ksShakeView.jW();
        }
    }
}
