package com.kwad.components.ad.reward.k;

import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.IdRes;

/* loaded from: classes.dex */
public abstract class w extends d {
    protected ViewGroup sn;

    public final void a(ViewGroup viewGroup, @IdRes int i2, @IdRes int i3) {
        if (this.sn != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i2);
        this.sn = (ViewGroup) (viewStub != null ? viewStub.inflate() : viewGroup.findViewById(i3));
    }

    @Override // com.kwad.components.ad.reward.k.d
    public ViewGroup gK() {
        return this.sn;
    }
}
