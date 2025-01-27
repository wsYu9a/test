package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.IdRes;

/* loaded from: classes2.dex */
public abstract class s extends d {

    /* renamed from: uc */
    protected ViewGroup f11741uc;

    public final void a(ViewGroup viewGroup, @IdRes int i10, @IdRes int i11) {
        if (this.f11741uc != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i10);
        if (viewStub != null) {
            this.f11741uc = (ViewGroup) viewStub.inflate();
        } else {
            this.f11741uc = (ViewGroup) viewGroup.findViewById(i11);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public ViewGroup ha() {
        return this.f11741uc;
    }
}
