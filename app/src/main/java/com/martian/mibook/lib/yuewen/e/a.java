package com.martian.mibook.lib.yuewen.e;

import com.martian.mibook.lib.yuewen.request.GetInitialBooksParams;
import com.martian.mibook.lib.yuewen.response.TYInitialBookList;

/* loaded from: classes4.dex */
public abstract class a extends com.martian.mibook.lib.account.d.f<GetInitialBooksParams, TYInitialBookList> {
    public a() {
        super(GetInitialBooksParams.class, TYInitialBookList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(TYInitialBookList tyInitialBookList) {
        if (tyInitialBookList == null || tyInitialBookList.getBookList() == null) {
            return false;
        }
        return super.onPreDataReceived(tyInitialBookList);
    }
}
