package com.kwad.components.ad.reward.presenter.d;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.presenter.d.b.c;
import com.kwad.components.ad.reward.presenter.d.b.d;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: classes2.dex */
public class a extends com.kwad.components.ad.reward.presenter.b implements g, j {
    public a() {
        cD();
    }

    private void cw() {
        this.rO.b(this);
        com.kwad.components.ad.reward.a.fr().a(this);
    }

    private void eu() {
        List<Presenter> Li = Li();
        if (Li == null) {
            return;
        }
        for (Object obj : Li) {
            if (obj instanceof c) {
                ((c) obj).iZ();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        cw();
    }

    public void cD() {
        a(new d());
        a(new com.kwad.components.ad.reward.presenter.d.b.a());
        a(new com.kwad.components.ad.reward.presenter.d.b.b());
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void ch() {
        eu();
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void cu() {
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void cv() {
        eu();
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.rO.c(this);
        com.kwad.components.ad.reward.a.fr().b(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
