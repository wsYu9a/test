package com.kwad.components.ad.draw.a.a;

import android.view.ViewGroup;
import com.kwad.components.ad.draw.a.a.a;
import com.kwad.components.ad.draw.view.playcard.DrawCardApp;
import com.kwad.components.ad.draw.view.playcard.DrawCardH5;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes.dex */
public final class b extends com.kwad.components.ad.draw.kwai.a {
    private a.InterfaceC0119a cM = new a.InterfaceC0119a() { // from class: com.kwad.components.ad.draw.a.a.b.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.draw.a.a.a.InterfaceC0119a
        public final void ay() {
            b.this.ay();
        }
    };
    private DrawCardApp cP;
    private DrawCardH5 cQ;
    private ViewGroup cv;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.draw.a.a.b$1 */
    final class AnonymousClass1 implements a.InterfaceC0119a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.draw.a.a.a.InterfaceC0119a
        public final void ay() {
            b.this.ay();
        }
    }

    /* renamed from: com.kwad.components.ad.draw.a.a.b$2 */
    final class AnonymousClass2 implements DrawCardApp.a {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
        public final void aD() {
            b.this.cv.setVisibility(0);
        }

        @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
        public final void aE() {
            b.this.aC();
        }
    }

    /* renamed from: com.kwad.components.ad.draw.a.a.b$3 */
    final class AnonymousClass3 implements DrawCardH5.a {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
        public final void aD() {
            b.this.cv.setVisibility(0);
        }

        @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
        public final void aE() {
            b.this.aC();
        }
    }

    private void aA() {
        this.cv.setVisibility(8);
        this.cP.a(this.mAdTemplate, new DrawCardApp.a() { // from class: com.kwad.components.ad.draw.a.a.b.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
            public final void aD() {
                b.this.cv.setVisibility(0);
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
            public final void aE() {
                b.this.aC();
            }
        });
        this.cP.setVisibility(0);
        this.cP.aU();
    }

    private void aB() {
        this.cv.setVisibility(8);
        this.cQ.a(this.mAdTemplate, new DrawCardH5.a() { // from class: com.kwad.components.ad.draw.a.a.b.3
            AnonymousClass3() {
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
            public final void aD() {
                b.this.cv.setVisibility(0);
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
            public final void aE() {
                b.this.aC();
            }
        });
        this.cQ.setVisibility(0);
        this.cQ.aU();
    }

    public void aC() {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 29, this.bW.mRootContainer.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = this.bW.bV;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    public void ay() {
        if (com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
            aA();
        } else {
            aB();
        }
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdTemplate adTemplate = this.bW.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.cb(adTemplate);
        this.bW.co.a(this.cM);
        this.cP.setVisibility(8);
        this.cQ.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cv = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.cP = (DrawCardApp) findViewById(R.id.ksad_card_app_container);
        this.cQ = (DrawCardH5) findViewById(R.id.ksad_card_h5_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.cP.release();
        this.cQ.release();
        this.bW.co.a((a.InterfaceC0119a) null);
    }
}
