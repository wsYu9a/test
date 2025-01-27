package com.martian.free.d;

import com.martian.free.request.TFChapterListParams;
import com.martian.free.response.TFChapterList;
import com.martian.mibook.lib.account.d.f;

/* loaded from: classes2.dex */
public abstract class d extends f<TFChapterListParams, TFChapterList> {
    public d() {
        super(TFChapterListParams.class, TFChapterList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(TFChapterList tfChapterList) {
        if (tfChapterList == null || tfChapterList.getChapters() == null) {
            return false;
        }
        return super.onPreDataReceived(tfChapterList);
    }
}
