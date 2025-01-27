package com.kwad.components.ad.fullscreen.b;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.d.h;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.d.e;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.R;

/* loaded from: classes.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements h {
    private View gE;
    private View gF;
    private e gG = new e() { // from class: com.kwad.components.ad.fullscreen.b.c.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", c.this.qt.mAdTemplate).equals(str) || j.b("ksad-fullscreen-video-card", c.this.qt.mAdTemplate).equals(str)) {
                c.this.bY();
            }
        }
    };
    private f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.fullscreen.b.c.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            c.this.i(false);
        }
    };

    /* renamed from: com.kwad.components.ad.fullscreen.b.c$1 */
    final class AnonymousClass1 extends e {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", c.this.qt.mAdTemplate).equals(str) || j.b("ksad-fullscreen-video-card", c.this.qt.mAdTemplate).equals(str)) {
                c.this.bY();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.fullscreen.b.c$2 */
    final class AnonymousClass2 extends com.kwad.components.ad.reward.d.a {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            c.this.i(false);
        }
    }

    public c() {
        a(new com.kwad.components.ad.fullscreen.b.kwai.e());
        a(new com.kwad.components.ad.fullscreen.b.a.a());
        a(new com.kwad.components.ad.fullscreen.b.b.a());
    }

    public void bY() {
        this.gE.setVisibility(0);
        this.gF.setVisibility(8);
    }

    private void bZ() {
        com.kwad.components.ad.reward.j jVar = this.qt;
        if (jVar.ph || jVar.pg) {
            return;
        }
        this.gE.setVisibility(0);
        this.gF.setVisibility(8);
    }

    public void i(boolean z) {
        com.kwad.components.ad.reward.j jVar = this.qt;
        if ((jVar.ph || jVar.pg) && !z) {
            this.gE.setVisibility(8);
            this.gF.setVisibility(8);
        } else {
            this.gE.setVisibility(8);
            this.gF.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, @Nullable l lVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        int i2;
        View view;
        super.ar();
        this.qt.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.ff().a(this);
        if (com.kwad.components.ad.reward.j.c(this.qt) || com.kwad.components.ad.reward.j.a(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
            i2 = 8;
            this.gE.setVisibility(8);
            view = this.gF;
        } else {
            view = this.gE;
            i2 = 0;
        }
        view.setVisibility(i2);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        bZ();
        if (this.qt.pg && this.gF.getVisibility() == 0) {
            this.gF.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
        i(true);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gE = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.gF = findViewById(R.id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.qt.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.ff().b(this);
    }
}
