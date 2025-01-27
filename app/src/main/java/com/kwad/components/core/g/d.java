package com.kwad.components.core.g;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInnerAd;

/* loaded from: classes2.dex */
public final class d {

    @Nullable
    private Object JF;

    public d(Object obj) {
        this.JF = obj;
    }

    public final void c(c cVar) {
        if (this.JF == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.JF).onAdClicked((KsInnerAd) cVar.getHost());
        } catch (Exception unused) {
        }
    }

    public final void d(c cVar) {
        if (this.JF == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.JF).onAdShow((KsInnerAd) cVar.getHost());
        } catch (Exception unused) {
        }
    }

    public final void destroy() {
        this.JF = null;
    }
}
