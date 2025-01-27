package com.kwad.components.ad.splashscreen.b;

import android.content.Context;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.ic.dm.Downloads;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class m extends e {
    private AdMatrixInfo.SplashSlideInfo CQ;
    private TextView CR;
    private ImageView CS;
    private com.kwad.components.ad.splashscreen.widget.c CU;
    private KsSplashSlidePathView CV;
    private com.kwad.components.core.d.b.c CW;
    private double CX;
    private com.kwad.components.ad.splashscreen.e.a Cv;
    private TextView he;
    private AdInfo mAdInfo;
    private AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.ad.splashscreen.b.m$1 */
    final class AnonymousClass1 implements KsSplashSlidePathView.a {

        /* renamed from: com.kwad.components.ad.splashscreen.b.m$1$1 */
        final class C01591 implements h.a {
            final /* synthetic */ float CZ;

            C01591(float f2) {
                b2 = f2;
            }

            @Override // com.kwad.components.ad.splashscreen.h.a
            public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
                iVar.bq(m.this.CQ.style);
                iVar.br((int) b2);
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
        public final void a(float f2, float f3, float f4, float f5) {
            m mVar;
            com.kwad.components.ad.splashscreen.h hVar;
            float b2 = com.kwad.sdk.c.kwai.a.b(m.this.getContext(), (float) Math.sqrt(Math.pow(f4 - f2, 2.0d) + Math.pow(f5 - f3, 2.0d)));
            if (b2 < m.this.CX || (hVar = (mVar = m.this).Cg) == null) {
                return;
            }
            hVar.a(1, mVar.getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.m.1.1
                final /* synthetic */ float CZ;

                C01591(float b22) {
                    b2 = b22;
                }

                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
                    iVar.bq(m.this.CQ.style);
                    iVar.br((int) b2);
                }
            });
        }

        @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
        public final void lf() {
            m mVar;
            com.kwad.components.ad.splashscreen.h hVar;
            if (!o.o(m.this.mAdInfo) || (hVar = (mVar = m.this).Cg) == null) {
                return;
            }
            hVar.c(1, mVar.getContext(), 53, 2);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.m$2 */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            m.this.le();
            if (m.this.CU != null) {
                m.this.CU.start();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.m$3 */
    final class AnonymousClass3 extends com.kwad.components.ad.splashscreen.e.a {
        AnonymousClass3(Context context, AdTemplate adTemplate) {
            super(context, adTemplate);
        }

        @Override // com.kwad.components.ad.splashscreen.e.a
        public final void ac(String str) {
            m.this.CR.setText(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initView() {
        /*
            r3 = this;
            com.kwad.sdk.core.response.model.AdInfo r0 = r3.mAdInfo
            com.kwad.sdk.core.response.model.AdMatrixInfo r0 = r0.adMatrixInfo
            com.kwad.sdk.core.response.model.AdMatrixInfo$AdDataV2 r0 = r0.adDataV2
            com.kwad.sdk.core.response.model.AdMatrixInfo$SplashInfo r0 = r0.splashInfo
            com.kwad.sdk.core.response.model.AdMatrixInfo$AdInteractionInfo r0 = r0.interactionInfo
            com.kwad.sdk.core.response.model.AdMatrixInfo$SplashSlideInfo r0 = r0.slideInfo
            r3.CQ = r0
            int r1 = r0.convertDistance
            double r1 = (double) r1
            r3.CX = r1
            int r0 = r0.style
            com.kwad.components.ad.splashscreen.widget.c r1 = new com.kwad.components.ad.splashscreen.widget.c
            android.content.Context r2 = r3.getContext()
            r1.<init>(r2, r0)
            r3.CU = r1
            android.widget.ImageView r2 = r3.CS
            r2.setImageDrawable(r1)
            android.widget.ImageView r1 = r3.CS
            com.kwad.components.ad.splashscreen.b.m$2 r2 = new com.kwad.components.ad.splashscreen.b.m$2
            r2.<init>()
            r1.post(r2)
            com.kwad.sdk.core.response.model.AdMatrixInfo$SplashSlideInfo r1 = r3.CQ
            java.lang.String r1 = r1.title
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L43
            android.widget.TextView r0 = r3.he
            com.kwad.sdk.core.response.model.AdMatrixInfo$SplashSlideInfo r1 = r3.CQ
            java.lang.String r1 = r1.title
        L3f:
            r0.setText(r1)
            goto L5b
        L43:
            if (r0 == 0) goto L56
            r1 = 1
            if (r0 == r1) goto L51
            r1 = 2
            if (r0 == r1) goto L4c
            goto L5b
        L4c:
            android.widget.TextView r0 = r3.he
            java.lang.String r1 = "向右滑动"
            goto L3f
        L51:
            android.widget.TextView r0 = r3.he
            java.lang.String r1 = "向左滑动"
            goto L3f
        L56:
            android.widget.TextView r0 = r3.he
            java.lang.String r1 = "向上滑动"
            goto L3f
        L5b:
            com.kwad.sdk.core.response.model.AdMatrixInfo$SplashSlideInfo r0 = r3.CQ
            java.lang.String r0 = r0.subtitle
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L6f
            android.widget.TextView r0 = r3.CR
            com.kwad.sdk.core.response.model.AdMatrixInfo$SplashSlideInfo r1 = r3.CQ
            java.lang.String r1 = r1.subtitle
        L6b:
            r0.setText(r1)
            goto L92
        L6f:
            com.kwad.sdk.core.response.model.AdInfo r0 = r3.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.a.a.ax(r0)
            if (r0 == 0) goto L8d
            com.kwad.components.ad.splashscreen.h r0 = r3.Cg
            com.kwad.sdk.core.response.model.AdTemplate r0 = r0.mAdTemplate
            com.kwad.sdk.core.response.model.AdInfo r1 = r3.mAdInfo
            com.kwad.components.core.d.b.c r2 = r3.CW
            int r2 = r2.nb()
            java.lang.String r0 = com.kwad.components.ad.splashscreen.d.a(r0, r1, r2)
            android.widget.TextView r1 = r3.CR
            r1.setText(r0)
            goto L92
        L8d:
            android.widget.TextView r0 = r3.CR
            java.lang.String r1 = "跳转详情页或者第三方应用"
            goto L6b
        L92:
            com.kwad.components.ad.splashscreen.h r0 = r3.Cg
            boolean r0 = com.kwad.components.ad.splashscreen.e.c.c(r0)
            if (r0 == 0) goto La6
            int r0 = com.kwad.sdk.R.id.ksad_splash_slide_actiontext
            android.view.View r0 = r3.findViewById(r0)
            r1 = 60
            r2 = -1
            com.kwad.components.ad.splashscreen.e.c.a(r0, r2, r1, r2, r2)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.b.m.initView():void");
    }

    private void ld() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.Cv;
        if (aVar != null) {
            aVar.setAdTemplate(this.Cg.mAdTemplate);
            return;
        }
        AnonymousClass3 anonymousClass3 = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Cg.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.m.3
            AnonymousClass3(Context context, AdTemplate adTemplate) {
                super(context, adTemplate);
            }

            @Override // com.kwad.components.ad.splashscreen.e.a
            public final void ac(String str) {
                m.this.CR.setText(str);
            }
        };
        this.Cv = anonymousClass3;
        this.CW.b(anonymousClass3);
    }

    public void le() {
        if (this.CQ != null) {
            y.b bVar = new y.b();
            bVar.bx(this.CQ.style);
            com.kwad.sdk.core.report.a.a(this.Cg.mAdTemplate, Downloads.Impl.STATUS_PENDING, bVar, (JSONObject) null);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.splashscreen.h hVar = this.Cg;
        if (hVar == null) {
            return;
        }
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(hVar.mAdTemplate);
        this.CW = this.Cg.mApkDownloadHelper;
        initView();
        if (com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
            ld();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((ViewStub) findViewById(R.id.ksad_slide_layout)).inflate();
        this.he = (TextView) findViewById(R.id.ksad_splash_slide_title);
        this.CR = (TextView) findViewById(R.id.ksad_splash_slide_actiontext);
        this.CS = (ImageView) findViewById(R.id.ksad_splash_slideView);
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_splash_root_container);
        KsSplashSlidePathView ksSplashSlidePathView = (KsSplashSlidePathView) ((ViewStub) findViewById(R.id.ksad_splash_slideTouchView)).inflate();
        this.CV = ksSplashSlidePathView;
        ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.b.m.1

            /* renamed from: com.kwad.components.ad.splashscreen.b.m$1$1 */
            final class C01591 implements h.a {
                final /* synthetic */ float CZ;

                C01591(float b22) {
                    b2 = b22;
                }

                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
                    iVar.bq(m.this.CQ.style);
                    iVar.br((int) b2);
                }
            }

            AnonymousClass1() {
            }

            @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
            public final void a(float f2, float f3, float f4, float f5) {
                m mVar;
                com.kwad.components.ad.splashscreen.h hVar;
                float b22 = com.kwad.sdk.c.kwai.a.b(m.this.getContext(), (float) Math.sqrt(Math.pow(f4 - f2, 2.0d) + Math.pow(f5 - f3, 2.0d)));
                if (b22 < m.this.CX || (hVar = (mVar = m.this).Cg) == null) {
                    return;
                }
                hVar.a(1, mVar.getContext(), TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.m.1.1
                    final /* synthetic */ float CZ;

                    C01591(float b222) {
                        b2 = b222;
                    }

                    @Override // com.kwad.components.ad.splashscreen.h.a
                    public final void b(@NonNull com.kwad.sdk.core.report.i iVar) {
                        iVar.bq(m.this.CQ.style);
                        iVar.br((int) b2);
                    }
                });
            }

            @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
            public final void lf() {
                m mVar;
                com.kwad.components.ad.splashscreen.h hVar;
                if (!o.o(m.this.mAdInfo) || (hVar = (mVar = m.this).Cg) == null) {
                    return;
                }
                hVar.c(1, mVar.getContext(), 53, 2);
            }
        });
    }
}
