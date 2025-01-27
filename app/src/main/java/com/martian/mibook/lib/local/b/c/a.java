package com.martian.mibook.lib.local.b.c;

import com.martian.mibook.lib.model.c.b;
import com.martian.mibook.lib.model.d.f;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.manager.BookManager;

/* loaded from: classes3.dex */
public abstract class a extends b {
    public a(BookManager bookMgr) {
        super(bookMgr);
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean i(Book newBook) {
        return false;
    }

    @Override // com.martian.mibook.lib.model.c.a
    public void q(Book book, f receiver, boolean fallBackToLocal) {
        g(book, receiver, fallBackToLocal);
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean y(Book newBook) {
        return false;
    }
}
