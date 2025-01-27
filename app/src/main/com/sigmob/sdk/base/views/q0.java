package com.sigmob.sdk.base.views;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: classes4.dex */
public class q0 extends ImageView {

    /* renamed from: a */
    public y f18861a;

    /* renamed from: b */
    public final int f18862b;

    public q0(Context context) {
        super(context);
        y yVar = new y(context);
        this.f18861a = yVar;
        setImageDrawable(yVar);
        this.f18862b = Dips.dipsToIntPixels(2.0f, context);
    }

    public void a(int i10, int i11) {
        this.f18861a.a(i10, i11);
        setVisibility(0);
    }

    @Deprecated
    public y getImageViewDrawable() {
        return this.f18861a;
    }

    public void setAnchorId(int i10) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f18862b);
        layoutParams.addRule(12, i10);
        setLayoutParams(layoutParams);
    }

    @Deprecated
    public void setImageViewDrawable(y yVar) {
        this.f18861a = yVar;
    }

    public void a(int i10) {
        this.f18861a.a(i10);
    }
}
