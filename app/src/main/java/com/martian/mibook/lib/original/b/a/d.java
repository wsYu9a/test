package com.martian.mibook.lib.original.b.a;

import com.martian.mibook.lib.original.data.ORBook;
import com.martian.mibook.lib.original.http.request.ORBookParams;

/* loaded from: classes2.dex */
public abstract class d extends com.martian.mibook.lib.account.d.f<ORBookParams, ORBook> {
    public d() {
        super(ORBookParams.class, ORBook.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(ORBook orBook) {
        if (orBook == null) {
            return false;
        }
        return super.onPreDataReceived(orBook);
    }
}
