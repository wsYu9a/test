package com.martian.mibook.lib.yuewen.e;

import com.martian.mibook.lib.yuewen.request.YWCategoryBookListParams;
import com.martian.mibook.lib.yuewen.response.YWCategoryBookList;

/* loaded from: classes4.dex */
public abstract class g extends com.martian.mibook.lib.account.d.f<YWCategoryBookListParams, YWCategoryBookList> {
    public g() {
        super(YWCategoryBookListParams.class, YWCategoryBookList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(YWCategoryBookList ywCategoryBookList) {
        if (ywCategoryBookList == null || ywCategoryBookList.getBookList() == null) {
            return false;
        }
        return super.onPreDataReceived(ywCategoryBookList);
    }
}
