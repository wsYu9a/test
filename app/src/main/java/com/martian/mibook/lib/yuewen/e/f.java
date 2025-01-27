package com.martian.mibook.lib.yuewen.e;

import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.response.ChapterPrice;
import com.martian.mibook.lib.yuewen.request.YWBuyChapterParams;

/* loaded from: classes4.dex */
public abstract class f extends com.martian.mibook.lib.account.d.n<YWBuyChapterParams, ChapterPrice> {
    public f(j1 activity) {
        super(activity, YWBuyChapterParams.class, ChapterPrice.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(ChapterPrice ywChapterPrice) {
        if (ywChapterPrice == null) {
            return false;
        }
        return super.onPreDataReceived(ywChapterPrice);
    }
}
