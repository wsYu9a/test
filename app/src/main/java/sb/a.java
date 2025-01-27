package sb;

import android.content.Context;
import android.text.TextUtils;
import com.martian.mibook.lib.local.txt.data.TXTBlock;
import com.martian.mibook.lib.local.txt.data.TXTBook;
import com.martian.mibook.lib.local.txt.data.TXTChapter;
import com.martian.mibook.lib.local.txt.data.TXTChapterList;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiChapterList;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.manager.BookManager;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import rb.b;
import wb.f;
import x8.k;
import xb.e;
import xb.g;
import xb.h;
import yb.n;

/* loaded from: classes3.dex */
public class a extends pb.a {

    /* renamed from: b */
    public final rb.b f30633b;

    /* renamed from: sb.a$a */
    public class C0786a extends y8.b<f, TXTBook> {

        /* renamed from: a */
        public final /* synthetic */ xb.b f30634a;

        public C0786a(xb.b bVar) {
            this.f30634a = bVar;
        }

        @Override // y8.b
        /* renamed from: f */
        public k doInBackground(f fVar) {
            TXTBook e10 = a.this.f30633b.e(fVar.getSourceId());
            if (e10 != null) {
                if (!a.this.e(e10)) {
                    a.this.z(e10, e10);
                }
                return new x8.b(e10);
            }
            return new x8.c(-1, "Failed to parse local book: " + fVar.getSourceId());
        }

        @Override // y8.a
        /* renamed from: g */
        public void onDataReceived(TXTBook tXTBook) {
            this.f30634a.a(tXTBook);
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f30634a.onResultError(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f30634a.onLoading(z10);
        }
    }

    public class b extends y8.b<Chapter, ChapterContent> {

        /* renamed from: a */
        public final /* synthetic */ f f30636a;

        /* renamed from: b */
        public final /* synthetic */ e f30637b;

        public b(f fVar, e eVar) {
            this.f30636a = fVar;
            this.f30637b = eVar;
        }

        @Override // y8.b
        /* renamed from: f */
        public k doInBackground(Chapter chapter) {
            ChapterContent o10 = a.this.o(this.f30636a, chapter);
            if (o10 == null || o10.isEmpty()) {
                return new x8.c(-1, "获取章节内容失败.");
            }
            this.f30637b.b(o10);
            return new x8.b(o10);
        }

        @Override // y8.a
        /* renamed from: g */
        public void onDataReceived(ChapterContent chapterContent) {
            this.f30637b.c(chapterContent);
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f30637b.onResultError(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f30637b.onLoading(z10);
        }
    }

    public class c extends y8.b<TXTBook, List<TXTBlock>> {

        /* renamed from: a */
        public final /* synthetic */ xb.f f30639a;

        /* renamed from: b */
        public final /* synthetic */ Book f30640b;

        /* renamed from: c */
        public final /* synthetic */ boolean f30641c;

        public c(xb.f fVar, Book book, boolean z10) {
            this.f30639a = fVar;
            this.f30640b = book;
            this.f30641c = z10;
        }

        @Override // y8.b
        /* renamed from: f */
        public k doInBackground(TXTBook tXTBook) {
            List<TXTBlock> d10 = a.this.f30633b.d(tXTBook);
            return (d10 == null || d10.isEmpty()) ? new x8.c(-1, "Failed to parse block list.") : new x8.b(d10);
        }

        @Override // y8.a
        /* renamed from: g */
        public void onDataReceived(List<TXTBlock> list) {
            a.this.Q(this.f30640b, list, this.f30639a, this.f30641c);
        }

        @Override // y8.f
        public void onProgressUpdate(Integer... numArr) {
            this.f30639a.b(numArr[0].intValue());
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            if (this.f30641c) {
                a.this.A(this.f30640b, this.f30639a, false);
            } else {
                this.f30639a.d(cVar);
            }
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f30639a.a(z10);
        }
    }

    public class d implements b.c {

        /* renamed from: a */
        public int f30643a = 0;

        /* renamed from: b */
        public final Map<Integer, List<TXTChapter>> f30644b = new Hashtable();

        /* renamed from: c */
        public final /* synthetic */ xb.f f30645c;

        /* renamed from: d */
        public final /* synthetic */ List f30646d;

        /* renamed from: e */
        public final /* synthetic */ Book f30647e;

        public d(xb.f fVar, List list, Book book) {
            this.f30645c = fVar;
            this.f30646d = list;
            this.f30647e = book;
        }

        @Override // rb.b.c
        public void a(int i10) {
            xb.f fVar = this.f30645c;
            int i11 = this.f30643a + 1;
            this.f30643a = i11;
            fVar.b(i11);
        }

        @Override // rb.b.c
        public void b(TXTBlock tXTBlock, List<TXTChapter> list) {
            TXTChapter remove;
            this.f30644b.put(Integer.valueOf(tXTBlock.getIndex()), list);
            if (this.f30644b.size() == this.f30646d.size()) {
                LinkedList<TXTChapter> linkedList = new LinkedList();
                List<TXTChapter> list2 = this.f30644b.get(0);
                int i10 = 1;
                while (i10 < this.f30644b.size()) {
                    List<TXTChapter> list3 = this.f30644b.get(Integer.valueOf(i10));
                    TXTChapter tXTChapter = list3.get(0);
                    if (tXTChapter.getTitle() == null && (remove = list2.remove(list2.size() - 1)) != null) {
                        tXTChapter.setStartOffset(remove.getStartOffset());
                        tXTChapter.setTitle(remove.getTitle());
                    }
                    linkedList.addAll(list2);
                    i10++;
                    list2 = list3;
                }
                linkedList.addAll(list2);
                ArrayList arrayList = new ArrayList();
                String str = "章节";
                TXTChapter tXTChapter2 = null;
                int i11 = 0;
                for (TXTChapter tXTChapter3 : linkedList) {
                    if (!TextUtils.isEmpty(tXTChapter3.getTitle())) {
                        str = tXTChapter3.getTitle();
                        i11 = 0;
                    } else if (tXTChapter2 == null || (tXTChapter3.getEndOffset().longValue() - tXTChapter2.getStartOffset().longValue() >= 20000 && tXTChapter3.getEndOffset().longValue() - tXTChapter3.getStartOffset().longValue() >= 500)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(" (");
                        i11++;
                        sb2.append(i11);
                        sb2.append(")");
                        tXTChapter3.setTitle(sb2.toString());
                    } else {
                        tXTChapter2.setEndOffset(tXTChapter3.getEndOffset());
                    }
                    arrayList.add(tXTChapter3);
                    tXTChapter2 = tXTChapter3;
                }
                TXTChapterList tXTChapterList = new TXTChapterList();
                tXTChapterList.setChapters(arrayList);
                a.this.B(this.f30647e, tXTChapterList, this.f30645c);
            }
        }

        @Override // rb.b.c
        public void onLoading(boolean z10) {
            this.f30645c.a(z10);
        }

        @Override // rb.b.c
        public void onResultError(x8.c cVar) {
            this.f30645c.d(cVar);
        }
    }

    public a(Context context, BookManager bookManager) {
        super(bookManager);
        this.f30633b = new rb.b();
    }

    @Override // wb.b
    public void D(f fVar, xb.b bVar, boolean z10) {
        C0786a c0786a = new C0786a(bVar);
        if (z10) {
            c0786a.executeBlocking(fVar);
        } else {
            c0786a.executeSerial(fVar);
        }
    }

    @Override // wb.b
    public Class<? extends Book> E() {
        return TXTBook.class;
    }

    @Override // wb.b
    public n F() {
        return tb.a.p();
    }

    @Override // wb.b
    public String H() {
        return vb.e.f31296c;
    }

    public void P(Book book, xb.f fVar, boolean z10) {
        new c(fVar, book, z10).executeParallel((TXTBook) book);
    }

    public void Q(Book book, List<TXTBlock> list, xb.f fVar, boolean z10) {
        d dVar = new d(fVar, list, book);
        Iterator<TXTBlock> it = list.iterator();
        while (it.hasNext()) {
            this.f30633b.a(it.next(), dVar);
        }
    }

    public final tb.a R() {
        return tb.a.p();
    }

    @Override // wb.d
    public boolean b(f fVar, Chapter chapter) {
        return false;
    }

    @Override // wb.a
    public boolean c(BookWrapper bookWrapper) {
        return false;
    }

    @Override // wb.d
    public boolean e(Book book) {
        return R().insert((TXTBook) book) == 1;
    }

    @Override // wb.d
    public long f(Book book) {
        return new tb.b(book).d();
    }

    @Override // wb.d
    public MiChapterList h(f fVar) {
        return new MiChapterList(TXTChapter.class, new tb.b(fVar).query());
    }

    @Override // wb.d
    public long l(List<Book> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Book> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((TXTBook) it.next());
        }
        return R().g(arrayList);
    }

    @Override // wb.d
    public Book m(f fVar) {
        TXTBook tXTBook = new TXTBook();
        tXTBook.setFilePath(fVar.getSourceId());
        if (R().i(tXTBook)) {
            return tXTBook;
        }
        return null;
    }

    @Override // wb.d
    public void n(f fVar) {
        new tb.b(fVar).b();
    }

    @Override // wb.d
    public ChapterContent o(f fVar, Chapter chapter) {
        return this.f30633b.f(chapter);
    }

    @Override // wb.d
    public boolean p(Book book) {
        return true;
    }

    @Override // wb.d
    public synchronized void q(Book book, ChapterList chapterList) {
        tb.b bVar = new tb.b(book);
        bVar.a();
        bVar.f(((TXTChapterList) chapterList).getChapters());
    }

    @Override // wb.d
    public boolean r(Book book, Book book2) {
        return false;
    }

    @Override // wb.a
    public zb.a s(f fVar, int i10, Chapter chapter, g gVar) {
        return null;
    }

    @Override // wb.a
    public void u(f fVar, ChapterList chapterList, int i10, e eVar) {
        new b(fVar, eVar).executeSerial(chapterList.getItem(i10));
    }

    @Override // wb.b, wb.a
    public void v(f fVar, xb.b bVar, boolean z10) {
        D(fVar, bVar, z10);
    }

    @Override // wb.d
    public boolean w(f fVar, Chapter chapter, ChapterContent chapterContent) {
        throw new UnsupportedOperationException("");
    }

    @Override // wb.a
    public void x(Book book, int i10, xb.f fVar, boolean z10) {
        if (z10) {
            A(book, fVar, true);
        } else {
            P(book, fVar, false);
        }
    }

    @Override // wb.d
    public boolean z(Book book, Book book2) {
        return R().f((TXTBook) book) != -1;
    }

    @Override // wb.d
    public void t(f fVar) {
    }

    @Override // wb.a
    public void i(BookWrapper bookWrapper, int i10, xb.a aVar) {
    }

    @Override // wb.a
    public void j(String str, int i10, h hVar, boolean z10, int i11, int i12, String str2, String str3) {
    }
}
