package com.martian.mibook.lib.account.d.q;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.request.auth.VideoBonusCompleteParams;
import com.martian.mibook.lib.account.response.ChapterPrice;

/* loaded from: classes3.dex */
public abstract class p0 extends com.martian.mibook.lib.account.d.n<VideoBonusCompleteParams, ChapterPrice> {
    public p0(j1 activity) {
        super(activity, VideoBonusCompleteParams.class, ChapterPrice.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(ChapterPrice chapterPrice) {
        if (chapterPrice == null) {
            return false;
        }
        return super.onPreDataReceived(chapterPrice);
    }
}
