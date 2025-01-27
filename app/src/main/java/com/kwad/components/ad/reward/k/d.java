package com.kwad.components.ad.reward.k;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ai;

/* loaded from: classes.dex */
public abstract class d {
    protected void a(v vVar) {
    }

    protected void ag(boolean z) {
    }

    public final void b(@NonNull v vVar) {
        a(vVar);
        gK().getContext();
        ag(ai.DL());
    }

    public abstract ViewGroup gK();

    public void onUnbind() {
    }
}
