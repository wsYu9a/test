package wb;

import android.app.Activity;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.manager.BookManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import yb.n;

/* loaded from: classes3.dex */
public abstract class b implements d, wb.a {

    /* renamed from: a */
    public final BookManager f31681a;

    public class a extends zb.e {

        /* renamed from: d */
        public final /* synthetic */ Book f31682d;

        /* renamed from: e */
        public final /* synthetic */ xb.f f31683e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Book book, ChapterList chapterList, b bVar, Book book2, xb.f fVar) {
            super(book, chapterList, bVar);
            this.f31682d = book2;
            this.f31683e = fVar;
        }

        @Override // y8.f
        /* renamed from: g */
        public void onPostExecute(Void r42) {
            b.this.A(this.f31682d, this.f31683e, false);
            this.f31683e.a(false);
        }

        @Override // y8.f
        public void onPreExecute() {
            super.onPreExecute();
            this.f31683e.a(true);
        }
    }

    /* renamed from: wb.b$b */
    public class C0799b extends zb.d {

        /* renamed from: b */
        public final /* synthetic */ xb.f f31685b;

        /* renamed from: c */
        public final /* synthetic */ boolean f31686c;

        /* renamed from: d */
        public final /* synthetic */ Book f31687d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0799b(d dVar, xb.f fVar, boolean z10, Book book) {
            super(dVar);
            this.f31685b = fVar;
            this.f31686c = z10;
            this.f31687d = book;
        }

        @Override // y8.a
        /* renamed from: h */
        public void onDataReceived(ChapterList chapterList) {
            this.f31685b.c(chapterList);
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            if (this.f31686c) {
                b.this.x(this.f31687d, 0, this.f31685b, false);
            } else {
                this.f31685b.d(cVar);
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f31685b.a(z10);
        }
    }

    public b(BookManager bookManager) {
        this.f31681a = bookManager;
    }

    public void A(Book book, xb.f fVar, boolean z10) {
        new C0799b(this, fVar, z10, book).executeSerial(book);
    }

    public void B(Book book, ChapterList chapterList, xb.f fVar) {
        new a(book, chapterList, this, book, fVar).executeParallel(new Void[0]);
    }

    public abstract void D(f fVar, xb.b bVar, boolean z10);

    public abstract Class<? extends Book> E();

    public abstract n F();

    public BookManager G() {
        return this.f31681a;
    }

    public abstract String H();

    public boolean I(Book book) {
        return false;
    }

    public boolean J() {
        return true;
    }

    public boolean K() {
        return true;
    }

    public Set<Book> L(List<f> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<f> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getSourceId());
        }
        return F().h(F().d(), arrayList);
    }

    public Book M() {
        try {
            return E().newInstance();
        } catch (IllegalAccessException | InstantiationException unused) {
            return null;
        }
    }

    @Override // wb.a
    public List<BookWrapper> a(List<BookWrapper> list) {
        ArrayList arrayList = new ArrayList();
        for (BookWrapper bookWrapper : list) {
            if (c(bookWrapper)) {
                arrayList.add(bookWrapper);
            }
        }
        return arrayList;
    }

    @Override // wb.a
    public void d(List<BookWrapper> list, xb.a aVar) {
        Iterator<BookWrapper> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i(it.next(), i10, aVar);
            i10++;
        }
    }

    public void v(f fVar, xb.b bVar, boolean z10) {
        Book m10 = m(fVar);
        if (m10 != null) {
            bVar.a(m10);
        } else {
            D(fVar, bVar, z10);
        }
    }

    public void C(Activity activity, Book book, Chapter chapter, ChapterContent chapterContent, boolean z10, xb.c cVar) {
    }
}
