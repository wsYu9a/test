package com.kwad.components.ad.interstitial.f.a;

import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.tachikoma.a.i;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.s;
import com.kwad.sdk.widget.e;

/* loaded from: classes2.dex */
public abstract class a extends com.kwad.components.ad.interstitial.f.b implements j {
    private i hw;

    /* renamed from: com.kwad.components.ad.interstitial.f.a.a$1 */
    public class AnonymousClass1 implements i.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.i.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            com.kwad.components.ad.interstitial.report.a.ei().a(a.this.kY.mAdTemplate, 1L, 177L);
            a.this.a(aVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(ay ayVar) {
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        this.hw.a(getActivity(), this.kY.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public e getTouchCoordsView() {
        return this.kY.f11594lg;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        this.hw = new com.kwad.components.core.webview.tachikoma.i(-1L, getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.tachikoma.i iVar = this.hw;
        if (iVar != null) {
            iVar.jK();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(t tVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
        sVar.c(new com.kwad.components.core.webview.tachikoma.a.i(new i.a() { // from class: com.kwad.components.ad.interstitial.f.a.a.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.i.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                com.kwad.components.ad.interstitial.report.a.ei().a(a.this.kY.mAdTemplate, 1L, 177L);
                a.this.a(aVar);
            }
        }));
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0448a c0448a) {
        c cVar = this.kY;
        if (cVar == null || cVar.jr == null) {
            return;
        }
        String str = c0448a.YC;
        str.hashCode();
        switch (str) {
            case "adSkipCallback":
                this.kY.jr.onSkippedAd();
                break;
            case "adShowCallback":
                this.kY.jr.onAdShow();
                break;
            case "adCloseCallback":
                this.kY.jr.onAdClosed();
                break;
            case "adAutoCloseCallback":
                this.kY.jr.onPageDismiss();
                break;
            case "adClickCallback":
                this.kY.jr.onAdClicked();
                break;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        c cVar = this.kY;
        cVar.f11588la = true;
        cVar.b(aVar.aJf, aVar.lz);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        m mVar = new m();
        mVar.adu = !this.kY.bS.isVideoSoundEnable();
        oVar.c(mVar);
    }
}
