package com.sigmob.sdk.videoAd;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.base.views.y;

/* loaded from: classes4.dex */
public class l extends ImageView {

    /* renamed from: a */
    public y f20477a;

    /* renamed from: b */
    public final int f20478b;

    public l(Context context) {
        super(context);
        y yVar = new y(context);
        this.f20477a = yVar;
        setImageDrawable(yVar);
        this.f20478b = Dips.dipsToIntPixels(2.0f, context);
    }

    public void a(int i10, int i11) {
        this.f20477a.a(i10, i11);
        setVisibility(0);
    }

    @Deprecated
    public y getImageViewDrawable() {
        return this.f20477a;
    }

    public void setAnchorId(int i10) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f20478b);
        layoutParams.addRule(8, i10);
        setLayoutParams(layoutParams);
    }

    @Deprecated
    public void setImageViewDrawable(y yVar) {
        this.f20477a = yVar;
    }

    public void a() {
        this.f20477a.d();
        this.f20477a.a(0);
    }

    public void a(int i10) {
        this.f20477a.a(i10);
    }
}
