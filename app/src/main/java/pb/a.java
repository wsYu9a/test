package pb;

import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.manager.BookManager;
import wb.b;
import xb.f;

/* loaded from: classes3.dex */
public abstract class a extends b {
    public a(BookManager bookManager) {
        super(bookManager);
    }

    @Override // wb.a
    public void g(Book book, int i10, f fVar, boolean z10) {
        x(book, i10, fVar, z10);
    }

    @Override // wb.d
    public boolean k(Book book) {
        return false;
    }

    @Override // wb.d
    public boolean y(Book book) {
        return false;
    }
}
