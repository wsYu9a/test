package com.martian.mibook.lib.model.c;

import com.martian.mibook.lib.model.d.h;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.List;

/* loaded from: classes3.dex */
public interface a {
    List<BookWrapper> b(final List<BookWrapper> bookWrappers);

    boolean c(final BookWrapper bookWrapper);

    void d(g source, ChapterList chapterList, int index, final com.martian.mibook.lib.model.d.e receiver);

    void g(Book book, final com.martian.mibook.lib.model.d.f receiver, final boolean fallBackToLocal);

    void m(final BookWrapper bookWrapper, final int index, final com.martian.mibook.lib.model.d.a receiver);

    void q(Book book, final com.martian.mibook.lib.model.d.f receiver, final boolean fallBackToLocal);

    void s(final String bookName, int page, final h receiver, boolean isBlocking, int searchType, int ctype, String sourceName, String sourceId);

    com.martian.mibook.lib.model.f.b t(g source, int index, Chapter chapter, com.martian.mibook.lib.model.d.g receiver);

    void u(final List<BookWrapper> bookWrappers, final com.martian.mibook.lib.model.d.a receiver);

    void v(g source, final com.martian.mibook.lib.model.d.b receiver, boolean isBlocking);
}
