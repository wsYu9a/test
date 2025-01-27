package com.martian.free.d;

import com.martian.free.request.TFSearchBookParams;
import com.martian.mibook.lib.account.d.q.m0;
import com.martian.mibook.lib.model.data.TYSearchBookList;

/* loaded from: classes2.dex */
public abstract class e extends m0<TFSearchBookParams, TYSearchBookList> {
    public e() {
        super(TFSearchBookParams.class, TYSearchBookList.class);
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
