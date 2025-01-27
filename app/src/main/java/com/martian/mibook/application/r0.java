package com.martian.mibook.application;

import com.martian.mibook.lib.local.base.data.LocalBook;
import com.martian.mibook.lib.model.data.MiBook;
import java.util.Map;

/* loaded from: classes3.dex */
public class r0 extends com.martian.mibook.lib.model.manager.d {
    public static MiBook m(LocalBook book) {
        MiBook miBook = new MiBook();
        miBook.setBookId(book.getFilePath());
        miBook.setBookName(book.getBookName());
        miBook.setUrl(book.getFilePath());
        miBook.setAuthorName(book.getAuthor());
        miBook.setSourceString(com.martian.mibook.lib.model.manager.d.i(book));
        return miBook;
    }

    @Override // com.martian.mibook.lib.model.manager.d
    public void l(Map<String, com.martian.mibook.lib.model.c.f> providers) {
    }
}
