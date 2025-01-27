package com.martian.mibook.lib.original.e;

import com.martian.mibook.lib.account.d.f;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.lib.original.request.CPORBooksListParams;

/* loaded from: classes2.dex */
public abstract class a extends f<CPORBooksListParams, TYSearchBookList> {
    public a() {
        super(CPORBooksListParams.class, TYSearchBookList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(TYSearchBookList cporBooksList) {
        if (cporBooksList == null || cporBooksList.getBookItemList() == null) {
            return false;
        }
        return super.onPreDataReceived(cporBooksList);
    }
}
