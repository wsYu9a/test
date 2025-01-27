package wb;

import ba.k;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiArchiveBookItem;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.abs.ChapterInfo;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.List;

/* loaded from: classes3.dex */
public interface c {
    boolean a(String str, f fVar);

    boolean b(String str);

    BookWrapper c(int i10);

    List<MiArchiveBookItem> d(String str);

    boolean e(int i10, String str);

    MiBookStoreItem f(String str);

    boolean g(MiArchiveBookItem miArchiveBookItem);

    List<BookWrapper> h();

    void i(ChapterInfo chapterInfo, ChapterList chapterList);

    List<k.d> j();
}
