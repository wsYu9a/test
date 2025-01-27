package com.kwad.components.ad.interstitial.f;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: classes2.dex */
public class b extends Presenter {
    public c kY;

    @Override // com.kwad.sdk.mvp.Presenter
    public void as() {
        super.as();
        this.kY = (c) Lj();
    }

    public void dl() {
        List<Presenter> Li = Li();
        if (Li == null) {
            return;
        }
        for (Presenter presenter : Li) {
            if (presenter instanceof b) {
                ((b) presenter).dl();
            }
        }
    }

    public void dm() {
        List<Presenter> Li = Li();
        if (Li == null) {
            return;
        }
        for (Presenter presenter : Li) {
            if (presenter instanceof b) {
                ((b) presenter).dm();
            }
        }
    }
}
