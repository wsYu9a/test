package com.kwad.components.ad.fullscreen.c.c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.f.a {

    /* renamed from: jg */
    private FrameLayout f11527jg;

    /* renamed from: jh */
    private j f11528jh = new j() { // from class: com.kwad.components.ad.fullscreen.c.c.b.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, @Nullable n nVar) {
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void cu() {
            b.this.f11527jg.setVisibility(0);
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void cv() {
            b.this.f11527jg.setVisibility(4);
        }
    };

    /* renamed from: com.kwad.components.ad.fullscreen.c.c.b$1 */
    public class AnonymousClass1 implements j {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, @Nullable n nVar) {
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void cu() {
            b.this.f11527jg.setVisibility(0);
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void cv() {
            b.this.f11527jg.setVisibility(4);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.rO.qv = true;
        com.kwad.components.ad.reward.a.fr().a(this.f11528jh);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.f11527jg;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_fullscreen";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dz(this.rO.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f11527jg = (FrameLayout) findViewById(R.id.ksad_js_full_card);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.a.fr().b(this.f11528jh);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        this.f11527jg.setVisibility(8);
        this.rO.qv = false;
    }
}
