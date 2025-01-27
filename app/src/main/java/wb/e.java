package wb;

import android.database.sqlite.SQLiteException;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.mibook.lib.model.data.MiChapterList;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.manager.BookManager;
import java.io.IOException;
import java.util.List;
import xb.h;
import yb.m;

/* loaded from: classes3.dex */
public abstract class e extends b {
    public e(BookManager bookManager) {
        super(bookManager);
    }

    @Override // wb.b
    public boolean I(Book book) {
        return T(book) != null;
    }

    public void N(f fVar) {
        S(fVar).b();
    }

    public boolean O(f fVar) {
        return ba.g.o(P(fVar));
    }

    public final String P(f fVar) {
        return m.f33449e + "chapter_book/" + fVar.getSourceName() + hf.e.f26694a + fVar.getSourceId();
    }

    public abstract Class<? extends Chapter> Q();

    public abstract yb.a R(f fVar);

    public abstract yb.b S(f fVar);

    public Book T(f fVar) {
        try {
            return (Book) GsonUtils.a().fromJson(ba.g.A(P(fVar)), (Class) E());
        } catch (Exception unused) {
            return null;
        }
    }

    public final Book U(Book book) {
        try {
            Book newInstance = E().newInstance();
            newInstance.setBookName(book.getBookName());
            newInstance.setCover(book.getCover());
            newInstance.setAuthorName(book.getAuthor());
            newInstance.setSourceId(book.getSourceId());
            newInstance.setLastChapter(book.getLastChapter());
            newInstance.setAllWords(book.getAllWords());
            newInstance.setBookStatus(book.getStatus());
            newInstance.setLastChapter(book.getLastChapter());
            newInstance.setCategoryName(book.getCategory());
            if (book.getLastUpdated() != null) {
                newInstance.setLatestChapterUpdateTime(Long.valueOf(book.getLastUpdated().getTime()));
            }
            newInstance.setShortIntro(book.getShortIntro());
            return newInstance;
        } catch (IllegalAccessException | InstantiationException unused) {
            return null;
        }
    }

    public abstract void V(String str, int i10, h hVar, boolean z10, int i11, int i12, String str2, String str3);

    public void W(Book book, Book book2) {
        if (book == book2) {
            return;
        }
        if (book.getLastUpdated() != null) {
            book2.setLatestChapterUpdateTime(Long.valueOf(book.getLastUpdated().getTime()));
        }
        book2.setAllWords(book.getAllWords());
        book2.setBookStatus(book.getStatus());
        book2.setLastChapter(book.getLastChapter());
    }

    @Override // wb.d
    public boolean b(f fVar, Chapter chapter) {
        return R(fVar).d(chapter);
    }

    @Override // wb.d
    public boolean e(Book book) {
        return (book.getClass() == E() || (book = U(book)) != null) && F().f(book) == 1;
    }

    @Override // wb.d
    public long f(Book book) {
        try {
            return S(book).d();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // wb.d
    public MiChapterList h(f fVar) {
        try {
            return new MiChapterList(Q(), S(fVar).query());
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // wb.a
    public void j(String str, int i10, h hVar, boolean z10, int i11, int i12, String str2, String str3) {
        V(str, i10, hVar, z10, i11, i12, str2, str3);
    }

    @Override // wb.d
    public boolean k(Book book) {
        Book m10 = m(book);
        return m10 == null || r(book, m10);
    }

    @Override // wb.d
    public long l(List<Book> list) {
        return F().g(list);
    }

    @Override // wb.d
    public Book m(f fVar) {
        try {
            Book newInstance = E().newInstance();
            newInstance.setSourceId(fVar.getSourceId());
            if (F().i(newInstance)) {
                return newInstance;
            }
            return null;
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
            return null;
        } catch (InstantiationException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    @Override // wb.d
    public void n(f fVar) {
        O(fVar);
        N(fVar);
    }

    @Override // wb.d
    public ChapterContent o(f fVar, Chapter chapter) {
        try {
            return R(fVar).e(chapter);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // wb.d
    public boolean p(Book book) {
        try {
            ba.g.E(P(book), GsonUtils.a().toJson(book));
            return true;
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // wb.d
    public void q(Book book, ChapterList chapterList) {
        synchronized (chapterList.getClass()) {
            try {
                yb.b S = S(book);
                S.a();
                S.f(chapterList.getChapters());
                p(book);
            } catch (SQLiteException e10) {
                e10.printStackTrace();
            }
        }
    }

    @Override // wb.d
    public boolean r(Book book, Book book2) {
        try {
            if (book2.getLastChapter() != null) {
                return !book2.getLastChapter().equals(book.getLastChapter());
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // wb.d
    public void t(f fVar) {
        R(fVar).a();
    }

    @Override // wb.d
    public boolean w(f fVar, Chapter chapter, ChapterContent chapterContent) {
        try {
            return R(fVar).h(chapter, chapterContent);
        } catch (SQLiteException unused) {
            return false;
        }
    }

    @Override // wb.d
    public boolean y(Book book) {
        Book T = T(book);
        return T == null || r(book, T);
    }

    @Override // wb.d
    public boolean z(Book book, Book book2) {
        Book U;
        W(book, book2);
        if (book.getClass() != E() && (U = U(book)) != null) {
            book = U;
        }
        return F().f(book) >= 1;
    }
}
