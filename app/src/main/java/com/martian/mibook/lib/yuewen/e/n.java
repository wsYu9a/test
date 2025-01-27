package com.martian.mibook.lib.yuewen.e;

import com.martian.mibook.lib.account.d.q.m0;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.lib.yuewen.request.YWSearchBookParams;

/* loaded from: classes4.dex */
public abstract class n extends m0<YWSearchBookParams, TYSearchBookList> {
    public n() {
        super(YWSearchBookParams.class, TYSearchBookList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(TYSearchBookList TYSearchBookList) {
        if (TYSearchBookList == null || TYSearchBookList.getBookItemList() == null) {
            return false;
        }
        return super.onPreDataReceived(TYSearchBookList);
    }
}
