package o8;

import android.app.Activity;
import ba.l;
import com.martian.free.request.TFBookParams;
import com.martian.free.request.TFBuyChapterParams;
import com.martian.free.request.TFChapterContentParams;
import com.martian.free.request.TFChapterListParams;
import com.martian.free.request.TFSearchBookParams;
import com.martian.free.response.TFBook;
import com.martian.free.response.TFChapter;
import com.martian.free.response.TFChapterContent;
import com.martian.free.response.TFChapterList;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.response.ChapterPrice;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.manager.BookManager;
import l9.m0;
import l9.t0;
import yb.n;

/* loaded from: classes3.dex */
public class a extends wb.e {

    /* renamed from: b */
    public p8.b f29100b;

    /* renamed from: o8.a$a */
    public class C0753a extends q8.e {

        /* renamed from: i */
        public final /* synthetic */ xb.h f29101i;

        public C0753a(xb.h hVar) {
            this.f29101i = hVar;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f29101i.d(cVar);
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(TYSearchBookList tYSearchBookList) {
            this.f29101i.c(tYSearchBookList.getBookItemList());
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f29101i.a(z10);
        }
    }

    public class b extends q8.a {

        /* renamed from: i */
        public final /* synthetic */ xb.b f29103i;

        public b(xb.b bVar) {
            this.f29103i = bVar;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f29103i.onResultError(cVar);
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(TFBook tFBook) {
            a.this.e(tFBook);
            this.f29103i.a(tFBook);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f29103i.onLoading(z10);
        }
    }

    public class c extends q8.c {

        /* renamed from: n */
        public final /* synthetic */ xb.e f29105n;

        /* renamed from: o */
        public final /* synthetic */ TFChapter f29106o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(wb.b bVar, wb.f fVar, Chapter chapter, int i10, xb.e eVar, TFChapter tFChapter) {
            super(bVar, fVar, chapter, i10);
            this.f29105n = eVar;
            this.f29106o = tFChapter;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f29105n.onResultError(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f29105n.onLoading(z10);
        }

        @Override // y8.a
        /* renamed from: t */
        public void onDataReceived(TFChapterContent tFChapterContent) {
            if (tFChapterContent.isTaked()) {
                this.f29105n.c(tFChapterContent);
                return;
            }
            if (this.f29106o != null) {
                if (tFChapterContent.getPrice() != null) {
                    this.f29106o.setPrice(tFChapterContent.getPrice());
                }
                this.f29106o.setChargeType(tFChapterContent.getChargeType());
            }
            this.f29105n.a(this.f29106o, tFChapterContent.getContent());
        }
    }

    public class e extends q8.d {

        /* renamed from: i */
        public final /* synthetic */ Book f29110i;

        /* renamed from: j */
        public final /* synthetic */ xb.f f29111j;

        /* renamed from: k */
        public final /* synthetic */ boolean f29112k;

        public e(Book book, xb.f fVar, boolean z10) {
            this.f29110i = book;
            this.f29111j = fVar;
            this.f29112k = z10;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            if (this.f29112k) {
                a.this.A(this.f29110i, this.f29111j, false);
            } else {
                this.f29111j.d(cVar);
            }
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(TFChapterList tFChapterList) {
            a.this.B(this.f29110i, tFChapterList, this.f29111j);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f29111j.a(z10);
        }
    }

    public a(BookManager bookManager) {
        super(bookManager);
        this.f29100b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.b
    public void C(Activity activity, Book book, Chapter chapter, ChapterContent chapterContent, boolean z10, xb.c cVar) {
        if (!MiUserManager.q().f()) {
            t0.b(activity, "请先登录");
            lb.d.b(activity, 10003, false);
            return;
        }
        if (!m0.C(activity) || chapter == null) {
            if (cVar != null) {
                cVar.d("");
                return;
            }
            return;
        }
        TFChapter tFChapter = (TFChapter) chapter;
        d dVar = new d(activity, cVar);
        if (book != null) {
            ((TFBuyChapterParams) dVar.k()).setSourceName(book.getSourceName());
            ((TFBuyChapterParams) dVar.k()).setSourceId(book.getSourceId());
        }
        ((TFBuyChapterParams) dVar.k()).setChapterId(tFChapter.getCid());
        ((TFBuyChapterParams) dVar.k()).setChapterName(tFChapter.getTitle());
        ((TFBuyChapterParams) dVar.k()).setPrice(tFChapter.getPrice());
        dVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.b
    public void D(wb.f fVar, xb.b bVar, boolean z10) {
        b bVar2 = new b(bVar);
        ((TFBookParams) bVar2.k()).setBid(fVar.getSourceId());
        if (z10) {
            bVar2.i();
        } else {
            bVar2.j();
        }
    }

    @Override // wb.b
    public Class<? extends Book> E() {
        return TFBook.class;
    }

    @Override // wb.b
    public n F() {
        if (this.f29100b == null) {
            this.f29100b = new p8.b();
        }
        return this.f29100b;
    }

    @Override // wb.b
    public String H() {
        return vb.e.f31300g;
    }

    @Override // wb.b
    public boolean K() {
        return false;
    }

    @Override // wb.e
    public Class<? extends Chapter> Q() {
        return TFChapter.class;
    }

    @Override // wb.e
    public yb.a R(wb.f fVar) {
        return new p8.c(fVar.getSourceId());
    }

    @Override // wb.e
    public yb.b S(wb.f fVar) {
        return new p8.d(fVar.getSourceId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.e
    public void V(String str, int i10, xb.h hVar, boolean z10, int i11, int i12, String str2, String str3) {
        C0753a c0753a = new C0753a(hVar);
        ((TFSearchBookParams) c0753a.k()).setKeywords(str);
        ((TFSearchBookParams) c0753a.k()).setPage(Integer.valueOf(i10));
        ((TFSearchBookParams) c0753a.k()).setCtype(Integer.valueOf(i12));
        ((TFSearchBookParams) c0753a.k()).setFromUser(Integer.valueOf(i11));
        ((TFSearchBookParams) c0753a.k()).setSourceName(H());
        if (!l.q(str3)) {
            ((TFSearchBookParams) c0753a.k()).setSourceId(str3);
        }
        ((TFSearchBookParams) c0753a.k()).setPageSize(Integer.valueOf(i11 == 6 ? 8 : 10));
        if (z10) {
            c0753a.i();
        } else {
            c0753a.j();
        }
    }

    @Override // wb.e
    public void W(Book book, Book book2) {
        if (book == book2 || !(book instanceof TFBook) || !(book2 instanceof TFBook)) {
            super.W(book, book2);
            return;
        }
        TFBook tFBook = (TFBook) book;
        TFBook tFBook2 = (TFBook) book2;
        tFBook2.setLatestChapter(tFBook.getLatestChapter());
        tFBook2.setStatus(tFBook.getRawStatus());
        tFBook2.setLatestChapterUpdateTime(tFBook.getLatestChapterUpdateTime());
        tFBook2.setAllWords(tFBook.getAllWords());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.a
    public boolean c(BookWrapper bookWrapper) {
        if (!(bookWrapper.book instanceof TFBook)) {
            return false;
        }
        if (bookWrapper.hasUpdate()) {
            return true;
        }
        h hVar = new h(bookWrapper);
        ((TFBookParams) hVar.k()).setBid(bookWrapper.book.getSourceId());
        hVar.i();
        return bookWrapper.hasUpdate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.a
    public void g(Book book, int i10, xb.f fVar, boolean z10) {
        e eVar = new e(book, fVar, z10);
        ((TFChapterListParams) eVar.k()).setBid(book.getSourceId());
        ((TFChapterListParams) eVar.k()).setRetry(Integer.valueOf(i10));
        eVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.a
    public void i(BookWrapper bookWrapper, int i10, xb.a aVar) {
        if (bookWrapper.book instanceof TFBook) {
            g gVar = new g(bookWrapper, aVar, i10);
            ((TFBookParams) gVar.k()).setBid(bookWrapper.book.getSourceId());
            gVar.j();
        }
    }

    @Override // wb.a
    public zb.a s(wb.f fVar, int i10, Chapter chapter, xb.g gVar) {
        return new f(this, fVar, chapter, i10, gVar, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.a
    public void u(wb.f fVar, ChapterList chapterList, int i10, xb.e eVar) {
        if (chapterList == null) {
            return;
        }
        TFChapter tFChapter = (TFChapter) chapterList.getItem(i10);
        c cVar = new c(this, fVar, tFChapter, i10, eVar, tFChapter);
        if (MiUserManager.q() != null && MiUserManager.q().f()) {
            ((TFChapterContentParams) cVar.k()).setUid(MiUserManager.q().e().getUid());
            ((TFChapterContentParams) cVar.k()).setToken(MiUserManager.q().e().getToken());
        }
        ((TFChapterContentParams) cVar.k()).setBid(fVar.getSourceId());
        if (tFChapter != null) {
            ((TFChapterContentParams) cVar.k()).setCid(tFChapter.getCid());
        }
        cVar.q();
    }

    @Override // wb.a
    public void x(Book book, int i10, xb.f fVar, boolean z10) {
        g(book, i10, fVar, z10);
    }

    public class d extends q8.b {

        /* renamed from: k */
        public final /* synthetic */ xb.c f29108k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Activity activity, xb.c cVar) {
            super(activity);
            this.f29108k = cVar;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            if (cVar.c() == BookManager.f13986k) {
                this.f29108k.f();
            } else {
                this.f29108k.d(cVar.d());
            }
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(ChapterPrice chapterPrice) {
            this.f29108k.b(1, chapterPrice == null ? 0 : chapterPrice.getPrice());
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class f extends q8.c {

        /* renamed from: n */
        public final /* synthetic */ xb.g f29114n;

        /* renamed from: o */
        public final /* synthetic */ int f29115o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(wb.b bVar, wb.f fVar, Chapter chapter, int i10, xb.g gVar, int i11) {
            super(bVar, fVar, chapter, i10);
            this.f29114n = gVar;
            this.f29115o = i11;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f29114n.a(this.f29115o, cVar);
        }

        @Override // y8.a
        /* renamed from: t */
        public void onDataReceived(TFChapterContent tFChapterContent) {
            this.f29114n.b(this.f29115o, tFChapterContent);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class g extends q8.a {

        /* renamed from: i */
        public final /* synthetic */ BookWrapper f29117i;

        /* renamed from: j */
        public final /* synthetic */ xb.a f29118j;

        /* renamed from: k */
        public final /* synthetic */ int f29119k;

        public g(BookWrapper bookWrapper, xb.a aVar, int i10) {
            this.f29117i = bookWrapper;
            this.f29118j = aVar;
            this.f29119k = i10;
        }

        @Override // q8.a, y8.b, y8.a
        /* renamed from: q */
        public boolean onPreDataReceived(TFBook tFBook) {
            a.this.z(tFBook, (TFBook) this.f29117i.book);
            if (a.this.k(tFBook) && !this.f29117i.hasUpdate()) {
                this.f29117i.setHasUpdate(true);
                a.this.G().T().J(this.f29117i);
            }
            return super.onPreDataReceived(tFBook);
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(TFBook tFBook) {
            if (this.f29117i.hasUpdate()) {
                this.f29118j.a(this.f29119k);
            }
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class h extends q8.a {

        /* renamed from: i */
        public final /* synthetic */ BookWrapper f29121i;

        public h(BookWrapper bookWrapper) {
            this.f29121i = bookWrapper;
        }

        @Override // q8.a, y8.b, y8.a
        /* renamed from: q */
        public boolean onPreDataReceived(TFBook tFBook) {
            TFBook tFBook2 = (TFBook) this.f29121i.book;
            if (a.this.k(tFBook)) {
                a.this.z(tFBook, tFBook2);
                if (!this.f29121i.hasUpdate()) {
                    this.f29121i.setHasUpdate(true);
                    a.this.G().T().J(this.f29121i);
                }
            }
            return super.onPreDataReceived(tFBook);
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(TFBook tFBook) {
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }
}
