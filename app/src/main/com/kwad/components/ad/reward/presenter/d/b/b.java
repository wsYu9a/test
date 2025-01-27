package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.utils.bt;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private View xr;
    private boolean xs;
    private final Runnable xt = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.d.b.b.1
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.getActivity() == null || b.this.getActivity().isFinishing()) {
                return;
            }
            b.this.ja();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.d.b.b$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.getActivity() == null || b.this.getActivity().isFinishing()) {
                return;
            }
            b.this.ja();
        }
    }

    public void ja() {
        com.kwad.sdk.core.d.c.d("RewardPlayEndCloseBtn", "showPageCloseBtn mPlayEndH5ShowSuccess: " + this.rO.qY + ", needHideCloseButton: " + this.xs);
        if (this.rO.qY && this.xs) {
            return;
        }
        this.xr.setVisibility(0);
        this.xr.setAlpha(0.0f);
        this.xr.animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.xs = com.kwad.sdk.core.response.b.b.eh(e.eb(this.rO.mAdTemplate));
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void iZ() {
        g gVar = this.rO;
        if (gVar.qH) {
            return;
        }
        long j10 = gVar.qS;
        if (j10 == 0) {
            this.xt.run();
        } else {
            bt.runOnUiThreadDelay(this.xt, j10);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.xr) {
            PlayableSource ga2 = this.rO.ga();
            if (ga2 == null || !(ga2.equals(PlayableSource.PENDANT_CLICK_NOT_AUTO) || ga2.equals(PlayableSource.PENDANT_CLICK_AUTO) || ga2.equals(PlayableSource.PENDANT_AUTO) || ga2.equals(PlayableSource.ACTIONBAR_CLICK))) {
                f.v(this.rO);
            } else {
                com.kwad.components.ad.reward.a.fr().fs();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View findViewById = findViewById(R.id.ksad_end_close_btn);
        this.xr = findViewById;
        findViewById.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.xr.setVisibility(8);
        bt.c(this.xt);
    }
}
