package com.kwad.components.ad.draw;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.n.m;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public final class b extends KSFrameLayout {

    /* renamed from: de */
    @Nullable
    private KsDrawAd.AdInteractionListener f11416de;

    /* renamed from: df */
    private com.kwad.components.ad.draw.a.b f11417df;

    /* renamed from: dg */
    private com.kwad.components.ad.draw.c.a f11418dg;

    /* renamed from: dh */
    private com.kwad.components.core.widget.a.b f11419dh;

    /* renamed from: di */
    private boolean f11420di;

    /* renamed from: dj */
    private ImageView f11421dj;

    /* renamed from: dk */
    private com.kwad.sdk.core.h.b f11422dk;
    private View.OnClickListener dl;
    private k dm;
    private AdInfo mAdInfo;

    @NonNull
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private Presenter mPresenter;
    private AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.ad.draw.b$1 */
    public class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: com.kwad.components.ad.draw.b$1$1 */
        public class C03641 implements a.b {
            public C03641() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.kwad.components.core.e.d.a.a(new a.C0427a(b.this.f11417df.mRootContainer.getContext()).au(b.this.f11417df.mAdTemplate).b(b.this.f11417df.mApkDownloadHelper).ap(false).ao(3).a(new a.b() { // from class: com.kwad.components.ad.draw.b.1.1
                public C03641() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                }
            }));
            if (3 == com.kwad.sdk.core.response.b.a.bx(e.eb(b.this.f11417df.mAdTemplate))) {
                b.this.aE();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.draw.b$2 */
    public class AnonymousClass2 extends l {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            b.this.f11421dj.setVisibility(0);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.f11421dj.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            b.this.f11421dj.setVisibility(8);
        }
    }

    public b(@NonNull Context context) {
        super(context);
        this.dl = new View.OnClickListener() { // from class: com.kwad.components.ad.draw.b.1

            /* renamed from: com.kwad.components.ad.draw.b$1$1 */
            public class C03641 implements a.b {
                public C03641() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                }
            }

            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.kwad.components.core.e.d.a.a(new a.C0427a(b.this.f11417df.mRootContainer.getContext()).au(b.this.f11417df.mAdTemplate).b(b.this.f11417df.mApkDownloadHelper).ap(false).ao(3).a(new a.b() { // from class: com.kwad.components.ad.draw.b.1.1
                    public C03641() {
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                    }
                }));
                if (3 == com.kwad.sdk.core.response.b.a.bx(e.eb(b.this.f11417df.mAdTemplate))) {
                    b.this.aE();
                }
            }
        };
        this.dm = new l() { // from class: com.kwad.components.ad.draw.b.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayPaused() {
                super.onMediaPlayPaused();
                b.this.f11421dj.setVisibility(0);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                b.this.f11421dj.setVisibility(8);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                b.this.f11421dj.setVisibility(8);
            }
        };
        this.mContext = context;
        initView();
    }

    public void aE() {
        this.f11418dg.g(!this.f11420di);
        if (this.f11420di) {
            this.f11418dg.resume();
        } else {
            this.f11418dg.pause();
        }
        this.f11420di = !this.f11420di;
    }

    private com.kwad.components.ad.draw.a.b aF() {
        com.kwad.components.ad.draw.a.b bVar = new com.kwad.components.ad.draw.a.b();
        bVar.f11414de = this.f11416de;
        bVar.mRootContainer = this.mRootContainer;
        bVar.mAdTemplate = this.mAdTemplate;
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            bVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        bVar.f11415dg = this.f11418dg;
        bVar.dv = new com.kwad.components.ad.draw.b.b.a(this.mAdTemplate);
        if (com.kwad.sdk.core.response.b.b.cH(this.mAdTemplate)) {
            bVar.dw = new com.kwad.components.ad.m.b();
        }
        return bVar;
    }

    private Presenter aG() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.draw.b.a.a());
        presenter.a(new com.kwad.components.ad.draw.b.b());
        presenter.a(new com.kwad.components.ad.draw.b.d());
        presenter.a(new com.kwad.components.ad.draw.b.c());
        presenter.a(new com.kwad.components.ad.draw.b.b.b());
        if (com.kwad.sdk.core.response.b.b.cu(this.mAdTemplate)) {
            presenter.a(new com.kwad.components.ad.draw.b.b.c());
        }
        presenter.a(new com.kwad.components.ad.draw.b.c.a());
        if (com.kwad.sdk.core.response.b.b.cH(this.mAdTemplate)) {
            presenter.a(new com.kwad.components.ad.draw.b.c.b());
        }
        if (com.kwad.sdk.core.response.b.a.aP(this.mAdInfo)) {
            presenter.a(new com.kwad.components.ad.draw.b.a());
        }
        return presenter;
    }

    private void initView() {
        m.inflate(this.mContext, R.layout.ksad_draw_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        this.f11421dj = (ImageView) adBaseFrameLayout.findViewById(R.id.ksad_video_control_button);
        DetailVideoView detailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.g(true, com.kwad.sdk.core.config.d.Ed());
        this.mDetailVideoView.setOnClickListener(this.dl);
        this.f11421dj.setOnClickListener(this.dl);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void Z() {
        super.Z();
        this.f11417df = aF();
        Presenter aG = aG();
        this.mPresenter = aG;
        aG.I(this.mRootContainer);
        this.mPresenter.k(this.f11417df);
        this.f11419dh.a(this.f11422dk);
        this.f11419dh.uE();
        this.f11418dg.bi();
        this.f11418dg.b(this.dm);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        com.kwad.components.core.widget.a.b bVar = this.f11419dh;
        if (bVar != null) {
            bVar.release();
        }
        com.kwad.components.ad.draw.c.a aVar = this.f11418dg;
        if (aVar != null) {
            aVar.bj();
            this.f11418dg.a(this.dm);
        }
        com.kwad.components.ad.draw.a.b bVar2 = this.f11417df;
        if (bVar2 != null) {
            bVar2.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public final void e(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eb(adTemplate);
        com.kwad.components.core.widget.a.b bVar = new com.kwad.components.core.widget.a.b(this, 70);
        this.f11419dh = bVar;
        this.f11418dg = new com.kwad.components.ad.draw.c.a(this.mAdTemplate, bVar, this.mDetailVideoView);
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f11416de = adInteractionListener;
    }

    public final void setPageExitListener(com.kwad.sdk.core.h.b bVar) {
        this.f11422dk = bVar;
    }

    public final void setVideoSound(boolean z10) {
        com.kwad.components.ad.draw.c.a aVar = this.f11418dg;
        if (aVar != null) {
            aVar.setVideoSound(z10);
        }
    }
}
