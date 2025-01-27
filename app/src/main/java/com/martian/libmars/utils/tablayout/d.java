package com.martian.libmars.utils.tablayout;

import android.content.Context;

/* loaded from: classes2.dex */
public class d extends o {

    /* renamed from: j */
    private float f10236j;

    public d(Context context, boolean changeFont) {
        super(context, changeFont);
        this.f10236j = 0.5f;
    }

    @Override // com.martian.libmars.utils.tablayout.o, com.martian.libmars.utils.tablayout.j
    public void a(int index, int totalCount) {
    }

    @Override // com.martian.libmars.utils.tablayout.o, com.martian.libmars.utils.tablayout.j
    public void b(int index, int totalCount, float enterPercent, boolean leftToRight) {
        if (enterPercent >= this.f10236j) {
            setTextColor(this.f10267e);
        } else {
            setTextColor(this.f10268f);
        }
    }

    @Override // com.martian.libmars.utils.tablayout.o, com.martian.libmars.utils.tablayout.j
    public void c(int index, int totalCount) {
    }

    @Override // com.martian.libmars.utils.tablayout.o, com.martian.libmars.utils.tablayout.j
    public void d(int index, int totalCount, float leavePercent, boolean leftToRight) {
        if (leavePercent >= this.f10236j) {
            setTextColor(this.f10268f);
        } else {
            setTextColor(this.f10267e);
        }
    }

    public float getChangePercent() {
        return this.f10236j;
    }

    public void setChangePercent(float changePercent) {
        this.f10236j = changePercent;
    }
}
