package com.kwad.components.ad.reward.presenter.e;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.b;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public final class a extends g implements com.kwad.components.ad.reward.k.a {
    private AdMatrixInfo.PreLandingPageTKInfo xB;
    private ay xC;
    private boolean pt = false;
    private com.kwad.components.ad.reward.e.g xD = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.e.a.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            c.d("TKPreFormPresenter", "handleToSkip PlayEndPageListener onPlayEndPageShow: " + a.this.rO.qz);
            if (a.this.rO.qz) {
                return;
            }
            a.this.jd();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.e.a$1 */
    public class AnonymousClass1 extends com.kwad.components.ad.reward.e.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            c.d("TKPreFormPresenter", "handleToSkip PlayEndPageListener onPlayEndPageShow: " + a.this.rO.qz);
            if (a.this.rO.qz) {
                return;
            }
            a.this.jd();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.e.a$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ boolean xF;

        public AnonymousClass2(boolean z10) {
            z10 = z10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.this.f11778yf.setVisibility(z10 ? 0 : 4);
            a.this.f11778yf.setClickable(z10);
            if (a.this.xC != null) {
                if (z10) {
                    a.this.xC.tu();
                    a.this.xC.tv();
                } else {
                    a.this.xC.tw();
                    a.this.xC.tx();
                }
            }
        }
    }

    private void T(boolean z10) {
        c.d("TKPreFormPresenter", "switchPreForm: " + z10);
        this.f11778yf.post(new bd() { // from class: com.kwad.components.ad.reward.presenter.e.a.2
            final /* synthetic */ boolean xF;

            public AnonymousClass2(boolean z102) {
                z10 = z102;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.this.f11778yf.setVisibility(z10 ? 0 : 4);
                a.this.f11778yf.setClickable(z10);
                if (a.this.xC != null) {
                    if (z10) {
                        a.this.xC.tu();
                        a.this.xC.tv();
                    } else {
                        a.this.xC.tw();
                        a.this.xC.tx();
                    }
                }
            }
        });
    }

    public void jd() {
        if (!this.pt || this.xB == null) {
            return;
        }
        c.d("TKPreFormPresenter", "handleToSkip handleToPlayEnd isPlayEndShow: " + this.xB.isPlayEndShow());
        if (this.xB.isPlayEndShow()) {
            T(true);
        }
    }

    private void je() {
        if (!this.pt || this.xB == null) {
            return;
        }
        c.d("TKPreFormPresenter", "handleToSkip mPreLandingPageData isSkipShow: " + this.xB.isSkipShow());
        if (this.xB.isSkipShow()) {
            T(true);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.xB = b.ds(this.rO.mAdTemplate);
        this.rO.b(this.xD);
        this.rO.a((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void ay() {
        super.ay();
        c.d("TKPreFormPresenter", "onTkLoadSuccess");
        this.pt = true;
    }

    public final BackPressHandleResult gI() {
        KSFrameLayout kSFrameLayout;
        return (this.xN == null || (kSFrameLayout = this.f11778yf) == null) ? BackPressHandleResult.NOT_HANDLED : kSFrameLayout.getVisibility() == 0 ? this.xN.gI() : BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_pre_landing_page";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return b.dK(this.rO.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int ih() {
        return R.id.ksad_pre_form_card;
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void jf() {
        c.d("TKPreFormPresenter", "onPlayComplete: ");
        jd();
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void jg() {
        c.d("TKPreFormPresenter", "onSkipClick: ");
        je();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.c(this.xD);
        this.rO.b((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final void a(FrameLayout frameLayout) {
        frameLayout.setVisibility(4);
        frameLayout.setClickable(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ad.a aVar) {
        float ba2 = com.kwad.sdk.c.a.a.ba(getContext());
        aVar.width = (int) ((bo.getScreenWidth(getContext()) / ba2) + 0.5f);
        aVar.height = (int) ((bo.getScreenHeight(getContext()) / ba2) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(ay ayVar) {
        super.a(ayVar);
        this.xC = ayVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        this.pt = false;
        c.d("TKPreFormPresenter", "onTkLoadFailed");
        T(false);
    }
}
