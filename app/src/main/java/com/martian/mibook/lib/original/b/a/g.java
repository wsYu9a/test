package com.martian.mibook.lib.original.b.a;

import com.martian.mibook.lib.account.d.q.m0;
import com.martian.mibook.lib.original.http.request.ORSearchBookParams;
import com.martian.mibook.lib.original.response.CPORBooksList;

/* loaded from: classes2.dex */
public abstract class g extends m0<ORSearchBookParams, CPORBooksList> {
    public g() {
        super(ORSearchBookParams.class, CPORBooksList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(CPORBooksList cporBooksList) {
        if (cporBooksList == null || cporBooksList.getBookList() == null) {
            return false;
        }
        return super.onPreDataReceived(cporBooksList);
    }
}
