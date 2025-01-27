package com.kwad.components.ad.draw.b.b;

import android.view.ViewGroup;
import com.kwad.components.ad.draw.b.b.a;
import com.kwad.components.ad.draw.view.playcard.DrawCardApp;
import com.kwad.components.ad.draw.view.playcard.DrawCardH5;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.draw.a.a {
    private ViewGroup dC;
    private a.InterfaceC0365a dS = new a.InterfaceC0365a() { // from class: com.kwad.components.ad.draw.b.b.b.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.draw.b.b.a.InterfaceC0365a
        public final void aP() {
            b.this.aP();
        }
    };
    private DrawCardApp dV;
    private DrawCardH5 dW;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.draw.b.b.b$1 */
    public class AnonymousClass1 implements a.InterfaceC0365a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.draw.b.b.a.InterfaceC0365a
        public final void aP() {
            b.this.aP();
        }
    }

    /* renamed from: com.kwad.components.ad.draw.b.b.b$2 */
    public class AnonymousClass2 implements DrawCardApp.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
        public final void aU() {
            b.this.dC.setVisibility(0);
        }

        @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
        public final void aV() {
            b.this.aT();
        }
    }

    /* renamed from: com.kwad.components.ad.draw.b.b.b$3 */
    public class AnonymousClass3 implements DrawCardH5.a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
        public final void aU() {
            b.this.dC.setVisibility(0);
        }

        @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
        public final void aV() {
            b.this.aT();
        }
    }

    public void aP() {
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            aR();
        } else {
            aS();
        }
    }

    private void aR() {
        this.dC.setVisibility(8);
        this.dV.a(this.mAdTemplate, new DrawCardApp.a() { // from class: com.kwad.components.ad.draw.b.b.b.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
            public final void aU() {
                b.this.dC.setVisibility(0);
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
            public final void aV() {
                b.this.aT();
            }
        });
        this.dV.setVisibility(0);
        this.dV.bn();
    }

    private void aS() {
        this.dC.setVisibility(8);
        this.dW.a(this.mAdTemplate, new DrawCardH5.a() { // from class: com.kwad.components.ad.draw.b.b.b.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
            public final void aU() {
                b.this.dC.setVisibility(0);
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
            public final void aV() {
                b.this.aT();
            }
        });
        this.dW.setVisibility(0);
        this.dW.bn();
    }

    public void aT() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, 29, this.f11413df.mRootContainer.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = this.f11413df.f11414de;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AdTemplate adTemplate = this.f11413df.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eb(adTemplate);
        this.f11413df.dv.a(this.dS);
        this.dV.setVisibility(8);
        this.dW.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dC = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.dV = (DrawCardApp) findViewById(R.id.ksad_card_app_container);
        this.dW = (DrawCardH5) findViewById(R.id.ksad_card_h5_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.dV.release();
        this.dW.release();
        this.f11413df.dv.a((a.InterfaceC0365a) null);
    }
}
