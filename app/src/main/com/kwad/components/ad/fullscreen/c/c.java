package com.kwad.components.ad.fullscreen.c;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.fullscreen.c.a.e;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements j {
    private View is;
    private View it;
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.c.c.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            c.this.j(false);
        }
    };

    /* renamed from: com.kwad.components.ad.fullscreen.c.c$1 */
    public class AnonymousClass1 extends com.kwad.components.ad.reward.e.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            c.this.j(false);
        }
    }

    public c() {
        a(new e());
        a(new com.kwad.components.ad.fullscreen.c.b.a());
    }

    private void ct() {
        com.kwad.components.ad.reward.g gVar = this.rO;
        if (gVar.qw || gVar.qv) {
            return;
        }
        this.is.setVisibility(0);
        this.it.setVisibility(8);
    }

    public void j(boolean z10) {
        com.kwad.components.ad.reward.g gVar = this.rO;
        if ((gVar.qw || gVar.qv) && !z10) {
            this.is.setVisibility(8);
            this.it.setVisibility(8);
        } else {
            this.is.setVisibility(8);
            this.it.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.rO.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.fr().a(this);
        this.is.setVisibility(0);
        this.it.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void cu() {
        ct();
        if (this.rO.qv && this.it.getVisibility() == 0) {
            this.it.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void cv() {
        j(true);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.is = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.it = findViewById(R.id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.fr().b(this);
    }
}
