package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.an;

/* loaded from: classes2.dex */
public final class e extends com.kwad.components.ad.reward.presenter.b implements j {
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.e.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            e.this.iO();
        }
    };
    private View wY;
    private View wZ;

    /* renamed from: xa */
    private ImageView f11815xa;

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.e$1 */
    public class AnonymousClass1 extends com.kwad.components.ad.reward.e.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            e.this.iO();
        }
    }

    public e() {
        a(new com.kwad.components.ad.reward.presenter.platdetail.a());
        a(new com.kwad.components.ad.reward.presenter.d.a());
    }

    private void iN() {
        if (!this.rO.qw) {
            this.wZ.setVisibility(8);
        }
        this.wY.setVisibility(0);
        getContext();
        if (com.kwad.components.ad.reward.g.J(this.rO.mAdTemplate) && an.NS()) {
            this.f11815xa.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.wY.setVisibility(0);
        this.wZ.setVisibility(8);
        this.rO.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.fr().a(this);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void cu() {
        iN();
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void cv() {
        iO();
    }

    public final void iO() {
        if (this.rO.qw) {
            this.wY.setVisibility(8);
        } else {
            this.wY.setVisibility(8);
            this.wZ.setVisibility(0);
        }
        getContext();
        if (com.kwad.components.ad.reward.g.J(this.rO.mAdTemplate) && an.NS()) {
            this.f11815xa.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wY = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.wZ = findViewById(R.id.ksad_play_end_top_toolbar);
        this.f11815xa = (ImageView) findViewById(R.id.ksad_blur_end_cover);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        iN();
        this.rO.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.fr().b(this);
        this.wZ.setVisibility(8);
    }
}
