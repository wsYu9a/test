package com.martian.free.d;

import com.martian.free.request.TFBuyChapterParams;
import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.d.n;
import com.martian.mibook.lib.account.response.ChapterPrice;

/* loaded from: classes2.dex */
public abstract class b extends n<TFBuyChapterParams, ChapterPrice> {
    public b(j1 activity) {
        super(activity, TFBuyChapterParams.class, ChapterPrice.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: t */
    public boolean onPreDataReceived(ChapterPrice tfChapterPrice) {
        if (tfChapterPrice == null) {
            return false;
        }
        return super.onPreDataReceived(tfChapterPrice);
    }
}
