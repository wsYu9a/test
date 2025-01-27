package com.martian.mibook.lib.model.c;

import com.martian.libsupport.j;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiArchiveBookItem;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.abs.ChapterInfo;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.List;

/* loaded from: classes3.dex */
public interface c {
    boolean a(String bookId);

    BookWrapper b(int index);

    List<MiArchiveBookItem> c(String tag);

    void d(MiBook book);

    boolean e(int index, String tag);

    boolean f(String bookId, g source);

    MiBookStoreItem g(String bookId);

    boolean h(MiArchiveBookItem item);

    List<BookWrapper> i();

    void j(ChapterInfo chapterInfo, ChapterList chapterList);

    List<j.d> k();
}
