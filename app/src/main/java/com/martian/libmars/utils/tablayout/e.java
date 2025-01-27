package com.martian.libmars.utils.tablayout;

import android.content.Context;

/* loaded from: classes2.dex */
public class e extends o {
    public e(Context context, boolean changeFont) {
        super(context, changeFont);
    }

    @Override // com.martian.libmars.utils.tablayout.o, com.martian.libmars.utils.tablayout.j
    public void a(int index, int totalCount) {
        super.a(index, totalCount);
    }

    @Override // com.martian.libmars.utils.tablayout.o, com.martian.libmars.utils.tablayout.j
    public void b(int index, int totalCount, float enterPercent, boolean leftToRight) {
        setTextColor(c.a(enterPercent, this.f10268f, this.f10267e));
    }

    @Override // com.martian.libmars.utils.tablayout.o, com.martian.libmars.utils.tablayout.j
    public void c(int index, int totalCount) {
        super.c(index, totalCount);
    }

    @Override // com.martian.libmars.utils.tablayout.o, com.martian.libmars.utils.tablayout.j
    public void d(int index, int totalCount, float leavePercent, boolean leftToRight) {
        setTextColor(c.a(leavePercent, this.f10267e, this.f10268f));
    }
}
