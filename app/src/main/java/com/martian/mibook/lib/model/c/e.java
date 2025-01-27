package com.martian.mibook.lib.model.c;

import android.database.sqlite.SQLiteException;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.mibook.lib.model.d.h;
import com.martian.mibook.lib.model.data.MiChapterList;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.e.n;
import com.martian.mibook.lib.model.e.o;
import com.martian.mibook.lib.model.manager.BookManager;
import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class e extends b {
    public e(BookManager bookMgr) {
        super(bookMgr);
    }

    private String N(g sourceProvider) {
        return n.f13980a + "chapter_book/" + sourceProvider.getSourceName() + "_" + sourceProvider.getSourceId();
    }

    @Override // com.martian.mibook.lib.model.c.b
    public boolean G(Book newBook) {
        return R(newBook) != null;
    }

    public void J(g sourceProvider) {
        Q(sourceProvider).b();
    }

    public boolean K(g sourceProvider) {
        return com.martian.libsupport.e.o(N(sourceProvider));
    }

    public abstract Class<? extends Book> L();

    public abstract o M();

    public abstract Class<? extends Chapter> O();

    public abstract com.martian.mibook.lib.model.e.a P(g sourceProvider);

    public abstract com.martian.mibook.lib.model.e.b Q(g sourceProvider);

    public Book R(g sourceProvider) {
        try {
            return (Book) GsonUtils.a().fromJson(com.martian.libsupport.e.A(N(sourceProvider)), (Class) L());
        } catch (Exception unused) {
            return null;
        }
    }

    protected abstract void S(String keyword, int page, h receiver, boolean isBlocking, int searchType, int ctype, String sourceName, String sourceId);

    public boolean T(Book book) {
        return M().f(book) >= 1;
    }

    protected abstract void U(Book newBook, Book book);

    @Override // com.martian.mibook.lib.model.c.d
    public void a(g sourceProvider) {
        P(sourceProvider).a();
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean e(Book book) {
        return M().insert(book) == 1;
    }

    @Override // com.martian.mibook.lib.model.c.d
    public long f(Book book) {
        try {
            return Q(book).d();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.martian.mibook.lib.model.c.d
    public void h(g sourceProvider) {
        K(sourceProvider);
        J(sourceProvider);
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean i(Book newBook) {
        Book j2 = j(newBook);
        return j2 == null || o(newBook, j2);
    }

    @Override // com.martian.mibook.lib.model.c.d
    public Book j(g sourceProvider) {
        try {
            Book newInstance = L().newInstance();
            newInstance.setSourceId(sourceProvider.getSourceId());
            if (M().h(newInstance)) {
                return newInstance;
            }
            return null;
        } catch (IllegalAccessException | InstantiationException unused) {
            return null;
        }
    }

    @Override // com.martian.mibook.lib.model.c.d
    public long k(List<Book> books) {
        return M().g(books);
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean l(Book book) {
        try {
            com.martian.libsupport.e.D(N(book), GsonUtils.a().toJson(book));
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.martian.mibook.lib.model.c.d
    public void n(Book book, ChapterList chapterList) {
        synchronized (chapterList.getClass()) {
            try {
                com.martian.mibook.lib.model.e.b Q = Q(book);
                Q.a();
                Q.h(chapterList.getChapters());
                l(book);
            } catch (SQLiteException unused) {
            }
        }
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean o(Book newBook, Book book) {
        try {
            if (book.getLastChapter() != null) {
                return !book.getLastChapter().equals(newBook.getLastChapter());
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.martian.mibook.lib.model.c.d
    public MiChapterList p(g sourceProvider) {
        try {
            return new MiChapterList(O(), Q(sourceProvider).query());
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean r(g sourceProvider, Chapter chapter) {
        return P(sourceProvider).d(chapter);
    }

    @Override // com.martian.mibook.lib.model.c.a
    public void s(String keyword, int page, h receiver, boolean isBlocking, int searchType, int ctype, String sourceName, String sourceId) {
        S(keyword, page, receiver, isBlocking, searchType, ctype, sourceName, sourceId);
    }

    @Override // com.martian.mibook.lib.model.c.d
    public ChapterContent w(g sourceProvider, Chapter chapter) {
        try {
            return P(sourceProvider).e(chapter);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean x(g sourceProvider, Chapter chapter, ChapterContent content) {
        try {
            return P(sourceProvider).h(chapter, content);
        } catch (SQLiteException unused) {
            return false;
        }
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean y(Book newBook) {
        Book R = R(newBook);
        return R == null || o(newBook, R);
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean z(Book newBook, Book book) {
        U(newBook, book);
        return M().f(newBook) >= 1;
    }
}
