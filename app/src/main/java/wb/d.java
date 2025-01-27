package wb;

import com.martian.mibook.lib.model.data.MiChapterList;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.List;

/* loaded from: classes3.dex */
public interface d {
    boolean b(f fVar, Chapter chapter);

    boolean e(Book book);

    long f(Book book);

    MiChapterList h(f fVar);

    boolean k(Book book);

    long l(List<Book> list);

    Book m(f fVar);

    void n(f fVar);

    ChapterContent o(f fVar, Chapter chapter);

    boolean p(Book book);

    void q(Book book, ChapterList chapterList);

    boolean r(Book book, Book book2);

    void t(f fVar);

    boolean w(f fVar, Chapter chapter, ChapterContent chapterContent);

    boolean y(Book book);

    boolean z(Book book, Book book2);
}
