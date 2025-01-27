package com.kwad.components.ad.g;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.g.b.g;
import com.kwad.components.ad.g.b.h;
import com.kwad.components.ad.g.b.i;
import com.kwad.components.ad.g.b.k;
import com.kwad.components.ad.g.d;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.j;

/* loaded from: classes2.dex */
public final class f extends KSFrameLayout {
    private j dQ;

    /* renamed from: dh */
    private com.kwad.components.core.widget.a.b f11561dh;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private Presenter mPresenter;
    private KsNativeAd.VideoPlayListener nG;
    private d.a nN;
    private AdBasePvFrameLayout nZ;

    /* renamed from: oe */
    private com.kwad.components.ad.g.a.b f11562oe;

    /* renamed from: of */
    public com.kwad.components.ad.g.c.a f11563of;

    /* renamed from: og */
    private KsAdVideoPlayConfig f11564og;

    /* renamed from: oh */
    private boolean f11565oh;

    /* renamed from: oi */
    private boolean f11566oi;

    /* renamed from: com.kwad.components.ad.g.f$1 */
    public class AnonymousClass1 implements j {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.widget.j
        public final void aN() {
            m.eA(f.this.mAdTemplate);
        }
    }

    /* renamed from: com.kwad.components.ad.g.f$2 */
    public class AnonymousClass2 extends bd {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (f.this.f11561dh != null) {
                f.this.f11561dh.release();
            }
            com.kwad.components.ad.g.c.a aVar = f.this.f11563of;
            if (aVar != null) {
                aVar.bj();
            }
            if (f.this.f11562oe != null) {
                f.this.f11562oe.release();
            }
            if (f.this.mPresenter != null) {
                f.this.mPresenter.destroy();
            }
        }
    }

    public f(@NonNull Context context) {
        this(context, null);
    }

    private void A(Context context) {
        com.kwad.sdk.n.m.inflate(context, R.layout.ksad_native_video_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.nZ = adBasePvFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
    }

    private Presenter aG() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.g.b.e());
        presenter.a(new com.kwad.components.ad.g.b.c());
        presenter.a(new i());
        presenter.a(new com.kwad.components.ad.g.b.j());
        presenter.a(new com.kwad.components.ad.g.b.d());
        presenter.a(new com.kwad.components.ad.g.b.b());
        presenter.a(new k());
        presenter.a(new com.kwad.components.ad.g.b.a(this.f11564og));
        presenter.a(new g());
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate))) {
            presenter.a(new com.kwad.components.ad.g.b.f());
        } else {
            presenter.a(new h());
        }
        return presenter;
    }

    private com.kwad.components.ad.g.a.b eO() {
        com.kwad.components.ad.g.a.b bVar = new com.kwad.components.ad.g.a.b();
        bVar.nZ = this.nZ;
        AdTemplate adTemplate = this.mAdTemplate;
        bVar.mAdTemplate = adTemplate;
        bVar.nN = this.nN;
        bVar.nG = this.nG;
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.eb(adTemplate))) {
            com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
            if (cVar == null) {
                bVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            } else {
                cVar.oI();
                bVar.mApkDownloadHelper = this.mApkDownloadHelper;
            }
        }
        bVar.nL = this.f11566oi;
        bVar.nK = this.f11565oh;
        bVar.f11531of = this.f11563of;
        return bVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void Z() {
        super.Z();
        if (this.f11563of == null) {
            this.f11563of = new com.kwad.components.ad.g.c.a(this.mAdTemplate, this.f11561dh, this.mDetailVideoView, this.f11564og);
        }
        this.f11562oe = eO();
        Presenter aG = aG();
        this.mPresenter = aG;
        aG.I(this.nZ);
        this.mPresenter.k(this.f11562oe);
        this.f11561dh.uE();
        this.f11563of.bi();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.g.f.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (f.this.f11561dh != null) {
                    f.this.f11561dh.release();
                }
                com.kwad.components.ad.g.c.a aVar = f.this.f11563of;
                if (aVar != null) {
                    aVar.bj();
                }
                if (f.this.f11562oe != null) {
                    f.this.f11562oe.release();
                }
                if (f.this.mPresenter != null) {
                    f.this.mPresenter.destroy();
                }
            }
        });
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.nN = aVar;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.nG = videoPlayListener;
    }

    private f(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.f11564og = ksAdVideoPlayConfig;
        this.nZ.setVisibleListener(this.dQ);
        this.f11561dh = new com.kwad.components.core.widget.a.b(getParent() == null ? this : (View) getParent(), 30);
    }

    public final void d(boolean z10, boolean z11) {
        this.f11566oi = z10;
        this.f11565oh = z11;
    }

    private f(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, 0);
        this.f11565oh = false;
        this.f11566oi = false;
        this.dQ = new j() { // from class: com.kwad.components.ad.g.f.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.widget.j
            public final void aN() {
                m.eA(f.this.mAdTemplate);
            }
        };
        A(context);
    }
}
