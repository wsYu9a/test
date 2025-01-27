package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.an;

/* loaded from: classes3.dex */
public final class f extends FrameLayout {
    private boolean afx;
    protected boolean jN;
    protected g js;

    @NonNull
    protected Context mContext;

    public f(@NonNull Context context) {
        super(context);
        this.mContext = context;
        this.jN = an.NS();
    }

    private void uC() {
        boolean NS = an.NS();
        if (!this.afx || NS == this.jN) {
            return;
        }
        this.jN = NS;
        g gVar = this.js;
        if (gVar != null) {
            gVar.k(!NS);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        uC();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.afx = i10 == 0;
        uC();
    }

    public final void setOrientationChangeListener(g gVar) {
        this.js = gVar;
    }
}
