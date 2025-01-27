package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.an;

/* loaded from: classes2.dex */
public abstract class d {
    public void a(r rVar) {
    }

    public void ac(boolean z10) {
    }

    public final void b(@NonNull r rVar) {
        a(rVar);
        ha().getContext();
        ac(an.NS());
    }

    public abstract ViewGroup ha();

    public void onUnbind() {
    }
}
