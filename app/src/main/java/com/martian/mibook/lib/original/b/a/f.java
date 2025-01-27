package com.martian.mibook.lib.original.b.a;

import com.martian.mibook.lib.account.d.q.m0;
import com.martian.mibook.lib.original.data.ORChapterList;
import com.martian.mibook.lib.original.http.request.ORChapterListParams;

/* loaded from: classes2.dex */
public abstract class f extends m0<ORChapterListParams, ORChapterList> {
    public f() {
        super(ORChapterListParams.class, ORChapterList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(ORChapterList orChapterList) {
        if (orChapterList == null || orChapterList.getChapters() == null) {
            return false;
        }
        return super.onPreDataReceived(orChapterList);
    }
}
