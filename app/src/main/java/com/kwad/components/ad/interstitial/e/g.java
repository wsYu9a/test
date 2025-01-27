package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ai;

/* loaded from: classes.dex */
public final class g extends FrameLayout {
    protected h hO;
    protected boolean ij;

    @NonNull
    protected Context mContext;
    private boolean my;

    public g(@NonNull Context context) {
        super(context);
        this.mContext = context;
        this.ij = ai.DL();
    }

    private void eH() {
        boolean DL = ai.DL();
        if (!this.my || DL == this.ij) {
            return;
        }
        this.ij = DL;
        h hVar = this.hO;
        if (hVar != null) {
            hVar.j(!DL);
        }
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        eH();
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.my = i2 == 0;
        eH();
    }

    public final void setOrientationChangeListener(h hVar) {
        this.hO = hVar;
    }
}
