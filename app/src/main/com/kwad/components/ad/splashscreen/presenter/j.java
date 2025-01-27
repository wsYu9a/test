package com.kwad.components.ad.splashscreen.presenter;

import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public final class j extends e {

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.j$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            j.this.cm();
        }
    }

    public void cm() {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate);
        a(new b(), true);
        a(new c(), true);
        if (com.kwad.sdk.core.response.b.a.bc(eb2)) {
            a(new d(), true);
            a(new q(), true);
        } else {
            a(new h(), true);
        }
        if (this.EJ.Eb) {
            a(new p(), true);
        } else {
            boolean dL = com.kwad.sdk.core.response.b.b.dL(eb2);
            boolean dP = com.kwad.sdk.core.response.b.b.dP(eb2);
            boolean dU = com.kwad.sdk.core.response.b.b.dU(eb2);
            if (com.kwad.sdk.core.response.b.b.dR(eb2)) {
                a(new n(), true);
            } else if (dL) {
                a(new m(), true);
            } else if (dP) {
                a(new l(), true);
            } else if (dU) {
                a(new p(), true);
            } else {
                a(new p(), true);
            }
        }
        if (com.kwad.sdk.core.response.b.a.aP(eb2)) {
            a(new f(), true);
        }
        if (!this.EJ.bM) {
            a(new com.kwad.components.ad.splashscreen.presenter.playcard.b(), true);
        }
        a(new a(), true);
        a(new g(), true);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        bt.postOnUiThread(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.j.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                j.this.cm();
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        findViewById(R.id.splash_play_card_view).setVisibility(0);
    }
}
