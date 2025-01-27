package com.martian.libmars.utils.tablayout;

import android.content.Context;

/* loaded from: classes2.dex */
public class m extends e {

    /* renamed from: j */
    private float f10263j;
    private float k;
    private boolean l;

    public m(Context context, boolean changeFont) {
        super(context, changeFont);
        this.f10263j = 1.2f;
        this.k = 0.89f;
    }

    @Override // com.martian.libmars.utils.tablayout.e, com.martian.libmars.utils.tablayout.o, com.martian.libmars.utils.tablayout.j
    public void b(int index, int totalCount, float enterPercent, boolean leftToRight) {
        super.b(index, totalCount, enterPercent, leftToRight);
        if (!this.l) {
            setScaleX(((this.f10263j - 1.0f) * enterPercent) + 1.0f);
            setScaleY(((this.f10263j - 1.0f) * enterPercent) + 1.0f);
        } else {
            float f2 = this.k;
            setScaleX(f2 + ((1.0f - f2) * enterPercent));
            float f3 = this.k;
            setScaleY(f3 + ((1.0f - f3) * enterPercent));
        }
    }

    @Override // com.martian.libmars.utils.tablayout.e, com.martian.libmars.utils.tablayout.o, com.martian.libmars.utils.tablayout.j
    public void d(int index, int totalCount, float leavePercent, boolean leftToRight) {
        super.d(index, totalCount, leavePercent, leftToRight);
        if (this.l) {
            setScaleX(((this.k - 1.0f) * leavePercent) + 1.0f);
            setScaleY(((this.k - 1.0f) * leavePercent) + 1.0f);
        } else {
            float f2 = this.f10263j;
            setScaleX(f2 + ((1.0f - f2) * leavePercent));
            float f3 = this.f10263j;
            setScaleY(f3 + ((1.0f - f3) * leavePercent));
        }
    }

    public void setMaxScale(float maxScale) {
        this.f10263j = maxScale;
    }

    public void setMinScale(float minScale) {
        this.k = minScale;
    }

    public void setMinScaleType(boolean minScaleType) {
        this.l = minScaleType;
    }
}
