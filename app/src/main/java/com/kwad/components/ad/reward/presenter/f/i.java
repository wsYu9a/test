package com.kwad.components.ad.reward.presenter.f;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.a.kwai.e;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class i extends c implements com.kwad.components.ad.reward.d.h, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private an wi;
    private boolean wj;
    private boolean wk;
    private FrameLayout wv;

    @Nullable
    private View ww;
    private boolean wx = false;
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.f.i.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            i.this.wv.setVisibility(8);
        }
    };
    private j.a wy = new j.a() { // from class: com.kwad.components.ad.reward.presenter.f.i.2
        AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.j.a
        public final void gb() {
            i.this.wk = true;
        }

        @Override // com.kwad.components.ad.reward.j.a
        public final void gc() {
            i.this.wk = true;
            i.this.iW();
        }

        @Override // com.kwad.components.ad.reward.j.a
        public final void gd() {
            i.this.wk = false;
            if (i.this.wi != null) {
                i.this.wi.re();
            }
        }

        @Override // com.kwad.components.ad.reward.j.a
        public final void ge() {
            i.this.wk = false;
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.f.i$1 */
    final class AnonymousClass1 extends com.kwad.components.ad.reward.d.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            i.this.wv.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.i$2 */
    final class AnonymousClass2 implements j.a {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.j.a
        public final void gb() {
            i.this.wk = true;
        }

        @Override // com.kwad.components.ad.reward.j.a
        public final void gc() {
            i.this.wk = true;
            i.this.iW();
        }

        @Override // com.kwad.components.ad.reward.j.a
        public final void gd() {
            i.this.wk = false;
            if (i.this.wi != null) {
                i.this.wi.re();
            }
        }

        @Override // com.kwad.components.ad.reward.j.a
        public final void ge() {
            i.this.wk = false;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f.i$3 */
    final class AnonymousClass3 implements e.b {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.e.b
        public final int iZ() {
            if (i.this.qt.pu != null) {
                return com.kwad.sdk.c.kwai.a.b(i.this.getContext(), r0.ch());
            }
            if (i.this.ww == null) {
                return 0;
            }
            return i.this.ww.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? com.kwad.sdk.c.kwai.a.b(i.this.getContext(), i.this.ww.getHeight() + ((ViewGroup.MarginLayoutParams) r0).bottomMargin) : com.kwad.sdk.c.kwai.a.b(i.this.getContext(), i.this.ww.getHeight());
        }
    }

    public void iW() {
        an anVar = this.wi;
        if (anVar == null || !this.wk) {
            return;
        }
        if (this.wj) {
            anVar.rd();
            return;
        }
        anVar.qZ();
        this.wi.ra();
        this.wj = true;
    }

    private e.b iY() {
        return new e.b() { // from class: com.kwad.components.ad.reward.presenter.f.i.3
            AnonymousClass3() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.e.b
            public final int iZ() {
                if (i.this.qt.pu != null) {
                    return com.kwad.sdk.c.kwai.a.b(i.this.getContext(), r0.ch());
                }
                if (i.this.ww == null) {
                    return 0;
                }
                return i.this.ww.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? com.kwad.sdk.c.kwai.a.b(i.this.getContext(), i.this.ww.getHeight() + ((ViewGroup.MarginLayoutParams) r0).bottomMargin) : com.kwad.sdk.c.kwai.a.b(i.this.getContext(), i.this.ww.getHeight());
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.ww = view;
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, @Nullable l lVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qt.a(this.wy);
        this.qt.oQ.a(this);
        this.qt.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.ff().a(this);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        if (this.wx) {
            this.wv.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
        if (this.wx) {
            this.wv.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c
    protected final boolean ck() {
        return true;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.wv;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return com.kwad.components.core.webview.a.j.b("ksad-video-topfloor", this.qt.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wv = (FrameLayout) findViewById(R.id.ksad_js_topfloor);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onGetContainerLimited(u.a aVar) {
        float ax = com.kwad.sdk.c.kwai.a.ax(getContext());
        float screenHeight = com.kwad.sdk.c.kwai.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.kwai.a.getScreenWidth(getContext()) / ax) + 0.5f);
        aVar.height = (int) ((screenHeight / ax) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onRegisterLifecycleLisener(an anVar) {
        super.onRegisterLifecycleLisener(anVar);
        this.wi = anVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(new com.kwad.components.core.webview.a.kwai.e(iY()));
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        an anVar = this.wi;
        if (anVar != null) {
            anVar.rb();
            this.wi.rc();
        }
        this.wx = false;
        this.wv.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onTkLoadSuccess() {
        super.onTkLoadSuccess();
        iW();
        this.wx = true;
        this.wv.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        an anVar = this.wi;
        if (anVar != null) {
            anVar.rb();
            this.wi.rc();
        }
        super.onUnbind();
        this.qt.b(this.wy);
        this.qt.oQ.b(this);
        this.qt.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.ff().b(this);
        this.qt.a((com.kwad.components.core.webview.a.d.a) null);
    }
}
