package com.martian.mibook.lib.model.c;

import com.martian.mibook.lib.model.data.MiChapterList;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.List;

/* loaded from: classes3.dex */
public interface d {
    void a(g sourceProvider);

    boolean e(Book book);

    long f(Book book);

    void h(g sourceProvider);

    boolean i(Book newbook);

    Book j(g sourceProvider);

    long k(List<Book> books);

    boolean l(Book book);

    void n(Book book, ChapterList chapterList);

    boolean o(Book newBook, Book book);

    MiChapterList p(g sourceProvider);

    boolean r(g sourceProvider, Chapter chapter);

    ChapterContent w(g sourceProvider, Chapter chapter);

    boolean x(g sourceProvider, Chapter chapter, ChapterContent content);

    boolean y(Book newbook);

    boolean z(Book newBook, Book book);
}
