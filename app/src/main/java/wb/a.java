package wb;

import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.List;
import xb.h;

/* loaded from: classes3.dex */
public interface a {
    List<BookWrapper> a(List<BookWrapper> list);

    boolean c(BookWrapper bookWrapper);

    void d(List<BookWrapper> list, xb.a aVar);

    void g(Book book, int i10, xb.f fVar, boolean z10);

    void i(BookWrapper bookWrapper, int i10, xb.a aVar);

    void j(String str, int i10, h hVar, boolean z10, int i11, int i12, String str2, String str3);

    zb.a s(f fVar, int i10, Chapter chapter, xb.g gVar);

    void u(f fVar, ChapterList chapterList, int i10, xb.e eVar);

    void v(f fVar, xb.b bVar, boolean z10);

    void x(Book book, int i10, xb.f fVar, boolean z10);
}
