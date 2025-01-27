package com.kwad.components.ad.reward.presenter.d.a;

import android.widget.FrameLayout;
import com.kwad.components.ad.m.b;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements b.a {
    private com.kwad.components.ad.m.b dw;
    private FrameLayout en;
    private DetailVideoView mDetailVideoView;
    private int uJ = Integer.MIN_VALUE;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.c.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (c.this.dw == null || !g.K(c.this.rO.mAdTemplate)) {
                return;
            }
            c.this.dw.ah(true);
        }
    };

    /* renamed from: ee */
    private com.kwad.sdk.core.webview.d.a.a f11765ee = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.c.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            c.this.rO.f11688qe.cg();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.d.a.c$1 */
    public class AnonymousClass1 implements l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (c.this.dw == null || !g.K(c.this.rO.mAdTemplate)) {
                return;
            }
            c.this.dw.ah(true);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.d.a.c$2 */
    public class AnonymousClass2 implements com.kwad.sdk.core.webview.d.a.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            c.this.rO.f11688qe.cg();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        g gVar = this.rO;
        AdTemplate adTemplate = gVar.mAdTemplate;
        j jVar = gVar.f11693qj;
        this.dw = jVar;
        if (jVar == null) {
            return;
        }
        com.kwad.components.ad.reward.b.fv().a(this.mRewardVerifyListener);
        this.dw.a(this.f11765ee);
        com.kwad.components.ad.m.b bVar = this.dw;
        FrameLayout frameLayout = this.en;
        g gVar2 = this.rO;
        bVar.a(frameLayout, gVar2.mRootContainer, adTemplate, gVar2.mApkDownloadHelper, gVar2.mScreenOrientation);
        this.dw.a((b.InterfaceC0390b) null);
        com.kwad.components.ad.m.b bVar2 = this.dw;
        if (bVar2 != null) {
            bVar2.a(this);
        }
    }

    @Override // com.kwad.components.ad.m.b.a
    public final void iW() {
        hK();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.en = (FrameLayout) findViewById(R.id.ksad_web_card_container);
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        int i10;
        super.onUnbind();
        com.kwad.components.ad.m.b bVar = this.dw;
        if (bVar != null) {
            bVar.mZ();
            this.dw.mM();
        }
        com.kwad.components.ad.reward.b.fv().b(this.mRewardVerifyListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView == null || (i10 = this.uJ) == Integer.MIN_VALUE) {
            return;
        }
        com.kwad.sdk.c.a.a.n(detailVideoView, i10);
    }
}
