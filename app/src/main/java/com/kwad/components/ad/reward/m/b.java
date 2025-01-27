package com.kwad.components.ad.reward.m;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.l.a<h> implements g.a {
    private com.kwad.components.core.g.c zn;

    public b(@NonNull AdTemplate adTemplate) {
        super(adTemplate);
        long M = com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.eb(adTemplate));
        com.kwad.components.core.g.c cVar = new com.kwad.components.core.g.c();
        this.zn = cVar;
        cVar.z(M);
    }

    public final FrameLayout Q(Context context) {
        FrameLayout imagePlayerView = this.zn.getImagePlayerView(context);
        this.zn.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
        return imagePlayerView;
    }

    @Override // com.kwad.components.ad.l.a
    public final void a(h hVar) {
        this.zn.d(hVar);
    }

    @Override // com.kwad.components.ad.l.a
    public final void b(h hVar) {
        this.zn.c(hVar);
    }

    @Override // com.kwad.components.ad.l.a
    public final long getPlayDuration() {
        return this.zn.getPlayDuration();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void go() {
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void gp() {
        resume();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void gq() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void gr() {
        this.zn.destroy();
    }

    public final void kd() {
        this.zn.setURLs(com.kwad.sdk.core.response.b.a.ba(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate)));
        this.zn.play();
    }

    @Override // com.kwad.components.ad.l.a
    public final void pause() {
        this.zn.pause();
    }

    @Override // com.kwad.components.ad.l.a
    public final void release() {
        super.release();
        this.zn.destroy();
    }

    @Override // com.kwad.components.ad.l.a
    public final void resume() {
        this.zn.resume();
    }

    @Override // com.kwad.components.ad.l.a
    public final void skipToEnd() {
        this.zn.skipToEnd();
    }
}
