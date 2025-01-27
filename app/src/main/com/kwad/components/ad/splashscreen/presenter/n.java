package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class n extends e {
    private com.kwad.components.ad.splashscreen.e.a EZ;
    private AdMatrixInfo.SplashSlideInfo Fo;
    private TextView Fp;
    private ImageView Fq;
    private com.kwad.components.ad.splashscreen.widget.d Fr;
    private KsSplashSlidePathView Fs;
    private com.kwad.components.core.e.d.c Ft;
    private double Fu;
    private TextView iO;
    private AdInfo mAdInfo;
    private long mStartTime;

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.n$1 */
    public class AnonymousClass1 implements KsSplashSlidePathView.a {

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.n$1$1 */
        public class C04111 implements h.a {
            final /* synthetic */ float Fw;

            public C04111(float f10) {
                px2dip = f10;
            }

            @Override // com.kwad.components.ad.splashscreen.h.a
            public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                bVar.cV(n.this.Fo.style);
                bVar.cW((int) px2dip);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
        public final void a(float f10, float f11, float f12, float f13) {
            n nVar;
            com.kwad.components.ad.splashscreen.h hVar;
            float px2dip = com.kwad.sdk.c.a.a.px2dip(n.this.getContext(), (float) Math.sqrt(Math.pow(f12 - f10, 2.0d) + Math.pow(f13 - f11, 2.0d)));
            if (px2dip < n.this.Fu || (hVar = (nVar = n.this).EJ) == null) {
                return;
            }
            hVar.a(1, nVar.getContext(), 153, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.n.1.1
                final /* synthetic */ float Fw;

                public C04111(float px2dip2) {
                    px2dip = px2dip2;
                }

                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.cV(n.this.Fo.style);
                    bVar.cW((int) px2dip);
                }
            });
        }

        @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
        public final void lL() {
            n nVar;
            com.kwad.components.ad.splashscreen.h hVar;
            if (!com.kwad.components.ad.splashscreen.h.n(n.this.mAdInfo) || (hVar = (nVar = n.this).EJ) == null) {
                return;
            }
            hVar.c(1, nVar.getContext(), 53, 2);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.n$2 */
    public class AnonymousClass2 extends bd {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            n.this.EJ.Ek = SystemClock.elapsedRealtime() - n.this.mStartTime;
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.n$3 */
    public class AnonymousClass3 extends bd {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            n.this.lK();
            if (n.this.Fr != null) {
                n.this.Fr.start();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.n$4 */
    public class AnonymousClass4 extends com.kwad.components.ad.splashscreen.e.a {
        public AnonymousClass4(Context context, AdTemplate adTemplate) {
            super(adTemplate);
        }

        @Override // com.kwad.components.ad.splashscreen.e.a
        public final void k(int i10, String str) {
            n.this.Fp.setText(str);
        }
    }

    private void initView() {
        AdMatrixInfo.SplashSlideInfo splashSlideInfo = this.mAdInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
        this.Fo = splashSlideInfo;
        this.Fu = splashSlideInfo.convertDistance;
        int i10 = splashSlideInfo.style;
        com.kwad.components.ad.splashscreen.widget.d dVar = new com.kwad.components.ad.splashscreen.widget.d(getContext(), i10);
        this.Fr = dVar;
        this.Fq.setImageDrawable(dVar);
        this.Fq.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.n.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                n.this.lK();
                if (n.this.Fr != null) {
                    n.this.Fr.start();
                }
            }
        });
        if (!TextUtils.isEmpty(this.Fo.title)) {
            this.iO.setText(this.Fo.title);
        } else if (i10 == 0) {
            this.iO.setText("向上滑动");
        } else if (i10 == 1) {
            this.iO.setText("向左滑动");
        } else if (i10 == 2) {
            this.iO.setText("向右滑动");
        }
        if (!TextUtils.isEmpty(this.Fo.subtitle)) {
            this.Fp.setText(this.Fo.subtitle);
        } else if (!com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            this.Fp.setText("跳转详情页或者第三方应用");
        } else {
            this.Fp.setText(com.kwad.components.ad.splashscreen.d.a(this.EJ.mAdTemplate, this.mAdInfo, this.Ft.oK(), 0));
        }
    }

    private void lJ() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.EZ;
        if (aVar != null) {
            aVar.setAdTemplate(this.EJ.mAdTemplate);
            return;
        }
        AnonymousClass4 anonymousClass4 = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.EJ.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.n.4
            public AnonymousClass4(Context context, AdTemplate adTemplate) {
                super(adTemplate);
            }

            @Override // com.kwad.components.ad.splashscreen.e.a
            public final void k(int i10, String str) {
                n.this.Fp.setText(str);
            }
        };
        this.EZ = anonymousClass4;
        this.Ft.b(anonymousClass4);
    }

    public void lK() {
        if (this.Fo != null) {
            com.kwad.sdk.core.adlog.c.d(this.EJ.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cV(this.Fo.style).cN(190));
            com.kwad.components.core.webview.tachikoma.d.a.uf().aX(190);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        if (this.EJ == null) {
            return;
        }
        bt.postOnUiThread(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.n.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                n.this.EJ.Ek = SystemClock.elapsedRealtime() - n.this.mStartTime;
            }
        });
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate);
        this.Ft = this.EJ.mApkDownloadHelper;
        initView();
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            lJ();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mStartTime = SystemClock.elapsedRealtime();
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_slide_layout);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.iO = (TextView) findViewById(R.id.ksad_splash_slide_title);
        this.Fp = (TextView) findViewById(R.id.ksad_splash_slide_actiontext);
        this.Fq = (ImageView) findViewById(R.id.ksad_splash_slideView);
        ViewStub viewStub2 = (ViewStub) findViewById(R.id.ksad_splash_slideTouchView);
        if (viewStub2 != null) {
            this.Fs = (KsSplashSlidePathView) viewStub2.inflate();
        } else {
            this.Fs = (KsSplashSlidePathView) findViewById(R.id.ksad_splash_slideview_root);
        }
        KsSplashSlidePathView ksSplashSlidePathView = this.Fs;
        if (ksSplashSlidePathView != null) {
            ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.n.1

                /* renamed from: com.kwad.components.ad.splashscreen.presenter.n$1$1 */
                public class C04111 implements h.a {
                    final /* synthetic */ float Fw;

                    public C04111(float px2dip2) {
                        px2dip = px2dip2;
                    }

                    @Override // com.kwad.components.ad.splashscreen.h.a
                    public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                        bVar.cV(n.this.Fo.style);
                        bVar.cW((int) px2dip);
                    }
                }

                public AnonymousClass1() {
                }

                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void a(float f10, float f11, float f12, float f13) {
                    n nVar;
                    com.kwad.components.ad.splashscreen.h hVar;
                    float px2dip2 = com.kwad.sdk.c.a.a.px2dip(n.this.getContext(), (float) Math.sqrt(Math.pow(f12 - f10, 2.0d) + Math.pow(f13 - f11, 2.0d)));
                    if (px2dip2 < n.this.Fu || (hVar = (nVar = n.this).EJ) == null) {
                        return;
                    }
                    hVar.a(1, nVar.getContext(), 153, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.n.1.1
                        final /* synthetic */ float Fw;

                        public C04111(float px2dip22) {
                            px2dip = px2dip22;
                        }

                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.cV(n.this.Fo.style);
                            bVar.cW((int) px2dip);
                        }
                    });
                }

                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void lL() {
                    n nVar;
                    com.kwad.components.ad.splashscreen.h hVar;
                    if (!com.kwad.components.ad.splashscreen.h.n(n.this.mAdInfo) || (hVar = (nVar = n.this).EJ) == null) {
                        return;
                    }
                    hVar.c(1, nVar.getContext(), 53, 2);
                }
            });
        }
    }
}
