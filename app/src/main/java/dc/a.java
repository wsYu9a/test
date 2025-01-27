package dc;

import android.app.Activity;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.manager.BookManager;
import com.martian.mibook.lib.original.data.ORBook;
import com.martian.mibook.lib.original.data.ORChapter;
import com.martian.mibook.lib.original.data.ORChapterContent;
import com.martian.mibook.lib.original.data.ORChapterList;
import com.martian.mibook.lib.original.http.request.ConsumeChapterParams;
import com.martian.mibook.lib.original.http.request.ORBookParams;
import com.martian.mibook.lib.original.http.request.ORChapterContentParams;
import com.martian.mibook.lib.original.http.request.ORChapterListParams;
import com.martian.mibook.lib.original.http.response.MiConsumeOrder;
import com.martian.rpauth.MartianIUserManager;
import com.martian.rpauth.response.MartianRPAccount;
import l9.m0;
import l9.t0;
import xb.h;
import yb.n;

/* loaded from: classes3.dex */
public class a extends wb.e {

    /* renamed from: dc.a$a */
    public class C0689a extends cc.b {

        /* renamed from: i */
        public final /* synthetic */ xb.b f25456i;

        public C0689a(xb.b bVar) {
            this.f25456i = bVar;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f25456i.onResultError(cVar);
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(ORBook oRBook) {
            this.f25456i.a(oRBook);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f25456i.onLoading(z10);
        }
    }

    public class b extends cc.c {

        /* renamed from: p */
        public final /* synthetic */ xb.e f25458p;

        /* renamed from: q */
        public final /* synthetic */ ORChapter f25459q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(wb.b bVar, wb.f fVar, Chapter chapter, int i10, xb.e eVar, ORChapter oRChapter) {
            super(bVar, fVar, chapter, i10);
            this.f25458p = eVar;
            this.f25459q = oRChapter;
        }

        @Override // cc.c
        public void r(x8.c cVar) {
            this.f25458p.onResultError(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f25458p.onLoading(z10);
        }

        @Override // cc.c
        public void t(x8.c cVar) {
            this.f25458p.a(this.f25459q, cVar.d());
        }

        @Override // y8.a
        /* renamed from: u */
        public void onDataReceived(ORChapterContent oRChapterContent) {
            if (oRChapterContent.getIsTaked() != null && oRChapterContent.getIsTaked().intValue() == 1) {
                this.f25458p.c(oRChapterContent);
                return;
            }
            if (this.f25459q != null && oRChapterContent.getCoins() != null) {
                this.f25459q.setCoins(oRChapterContent.getCoins());
            }
            this.f25458p.a(this.f25459q, oRChapterContent.getContent());
        }
    }

    public class d extends cc.d {

        /* renamed from: i */
        public final /* synthetic */ Book f25463i;

        /* renamed from: j */
        public final /* synthetic */ xb.f f25464j;

        /* renamed from: k */
        public final /* synthetic */ boolean f25465k;

        public d(Book book, xb.f fVar, boolean z10) {
            this.f25463i = book;
            this.f25464j = fVar;
            this.f25465k = z10;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            if (this.f25465k) {
                a.this.A(this.f25463i, this.f25464j, false);
            } else {
                this.f25464j.d(cVar);
            }
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(ORChapterList oRChapterList) {
            a.this.B(this.f25463i, oRChapterList, this.f25464j);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f25464j.a(z10);
        }
    }

    public a(BookManager bookManager) {
        super(bookManager);
    }

    @Override // wb.b
    public void C(Activity activity, Book book, Chapter chapter, ChapterContent chapterContent, boolean z10, xb.c cVar) {
        if (MiUserManager.q().f()) {
            Y(activity, MartianIUserManager.b().c(), book, (ORChapter) chapter, z10, cVar);
        } else {
            t0.b(activity, "请先登录");
            lb.d.b(activity, 10003, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.b
    public void D(wb.f fVar, xb.b bVar, boolean z10) {
        C0689a c0689a = new C0689a(bVar);
        ((ORBookParams) c0689a.k()).setBookId(fVar.getSourceId());
        if (z10) {
            c0689a.i();
        } else {
            c0689a.j();
        }
    }

    @Override // wb.b
    public Class<? extends Book> E() {
        return ORBook.class;
    }

    @Override // wb.b
    public n F() {
        return ec.b.p();
    }

    @Override // wb.b
    public String H() {
        return vb.e.f31295b;
    }

    @Override // wb.b
    public boolean K() {
        return false;
    }

    @Override // wb.e
    public Class<? extends Chapter> Q() {
        return ORChapter.class;
    }

    @Override // wb.e
    public yb.a R(wb.f fVar) {
        return new ec.d(fVar.getSourceId());
    }

    @Override // wb.e
    public yb.b S(wb.f fVar) {
        return new ec.e(fVar.getSourceId());
    }

    @Override // wb.e
    public void V(String str, int i10, h hVar, boolean z10, int i11, int i12, String str2, String str3) {
        hVar.d(new x8.c(-1, "取消搜索"));
    }

    @Override // wb.e
    public void W(Book book, Book book2) {
        if (book != book2 && (book instanceof ORBook) && (book2 instanceof ORBook)) {
            ORBook oRBook = (ORBook) book2;
            ORBook oRBook2 = (ORBook) book;
            oRBook.setLastChapter(oRBook2.getLastChapter());
            oRBook.setLatestChapterUpdateTime(oRBook2.getLatestChapterUpdateTime());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y(Activity activity, MartianRPAccount martianRPAccount, Book book, ORChapter oRChapter, boolean z10, xb.c cVar) {
        if (!m0.C(activity) || oRChapter == null) {
            if (cVar != null) {
                cVar.d("");
                return;
            }
            return;
        }
        c cVar2 = new c(activity, cVar);
        ((ConsumeChapterParams) cVar2.k()).setBookId(book.getSourceId());
        ((ConsumeChapterParams) cVar2.k()).setChapterId(Integer.valueOf(Integer.parseInt(oRChapter.getChapterId())));
        ((ConsumeChapterParams) cVar2.k()).setCoins(oRChapter.getCoins());
        ((ConsumeChapterParams) cVar2.k()).setContent(oRChapter.getTitle());
        ((ConsumeChapterParams) cVar2.k()).setSubject(book.getBookName());
        cVar2.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.a
    public boolean c(BookWrapper bookWrapper) {
        Book book = bookWrapper.book;
        if (book == null || !book.getSourceName().equals(H())) {
            return false;
        }
        if (bookWrapper.hasUpdate()) {
            return true;
        }
        g gVar = new g(bookWrapper);
        ((ORBookParams) gVar.k()).setBookId(bookWrapper.book.getSourceId());
        gVar.i();
        return bookWrapper.hasUpdate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.a
    public void g(Book book, int i10, xb.f fVar, boolean z10) {
        d dVar = new d(book, fVar, z10);
        ((ORChapterListParams) dVar.k()).setBookId(book.getSourceId());
        ((ORChapterListParams) dVar.k()).setPage(0);
        dVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.a
    public void i(BookWrapper bookWrapper, int i10, xb.a aVar) {
        if (bookWrapper == null || !(bookWrapper.book instanceof ORBook)) {
            return;
        }
        f fVar = new f(bookWrapper, aVar, i10);
        ((ORBookParams) fVar.k()).setBookId(bookWrapper.book.getSourceId());
        fVar.j();
    }

    @Override // wb.a
    public zb.a s(wb.f fVar, int i10, Chapter chapter, xb.g gVar) {
        return new e(this, fVar, chapter, i10, gVar, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.a
    public void u(wb.f fVar, ChapterList chapterList, int i10, xb.e eVar) {
        ORChapter oRChapter = (ORChapter) chapterList.getItem(i10);
        b bVar = new b(this, fVar, oRChapter, i10, eVar, oRChapter);
        ((ORChapterContentParams) bVar.k()).setBookId(fVar.getSourceId());
        ((ORChapterContentParams) bVar.k()).setChapterId(Integer.valueOf(Integer.parseInt(oRChapter.getChapterId())));
        bVar.q();
    }

    @Override // wb.a
    public void x(Book book, int i10, xb.f fVar, boolean z10) {
        g(book, i10, fVar, z10);
    }

    public class c extends cc.a {

        /* renamed from: k */
        public final /* synthetic */ xb.c f25461k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Activity activity, xb.c cVar) {
            super(activity);
            this.f25461k = cVar;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            if (cVar.c() == 3001) {
                this.f25461k.f();
            } else {
                this.f25461k.d(cVar.d());
            }
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(MiConsumeOrder miConsumeOrder) {
            this.f25461k.b(1, miConsumeOrder.getCoins().intValue());
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class e extends cc.c {

        /* renamed from: p */
        public final /* synthetic */ xb.g f25467p;

        /* renamed from: q */
        public final /* synthetic */ int f25468q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(wb.b bVar, wb.f fVar, Chapter chapter, int i10, xb.g gVar, int i11) {
            super(bVar, fVar, chapter, i10);
            this.f25467p = gVar;
            this.f25468q = i11;
        }

        @Override // cc.c
        public void r(x8.c cVar) {
            this.f25467p.a(this.f25468q, cVar);
        }

        @Override // cc.c
        public void t(x8.c cVar) {
            this.f25467p.a(this.f25468q, cVar);
        }

        @Override // y8.a
        /* renamed from: u */
        public void onDataReceived(ORChapterContent oRChapterContent) {
            this.f25467p.b(this.f25468q, oRChapterContent);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class f extends cc.b {

        /* renamed from: i */
        public final /* synthetic */ BookWrapper f25470i;

        /* renamed from: j */
        public final /* synthetic */ xb.a f25471j;

        /* renamed from: k */
        public final /* synthetic */ int f25472k;

        public f(BookWrapper bookWrapper, xb.a aVar, int i10) {
            this.f25470i = bookWrapper;
            this.f25471j = aVar;
            this.f25472k = i10;
        }

        @Override // cc.b, y8.b, y8.a
        /* renamed from: q */
        public boolean onPreDataReceived(ORBook oRBook) {
            if (a.this.k(oRBook)) {
                a.this.z(oRBook, (ORBook) this.f25470i.book);
                if (!this.f25470i.hasUpdate()) {
                    this.f25470i.setHasUpdate(true);
                    a.this.G().T().J(this.f25470i);
                }
            }
            return super.onPreDataReceived(oRBook);
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(ORBook oRBook) {
            if (this.f25470i.hasUpdate()) {
                this.f25471j.a(this.f25472k);
            }
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class g extends cc.b {

        /* renamed from: i */
        public final /* synthetic */ BookWrapper f25474i;

        public g(BookWrapper bookWrapper) {
            this.f25474i = bookWrapper;
        }

        @Override // cc.b, y8.b, y8.a
        /* renamed from: q */
        public boolean onPreDataReceived(ORBook oRBook) {
            if (a.this.k(oRBook)) {
                a.this.z(oRBook, (ORBook) this.f25474i.book);
                if (!this.f25474i.hasUpdate()) {
                    this.f25474i.setHasUpdate(true);
                    a.this.G().T().J(this.f25474i);
                }
            }
            return super.onPreDataReceived(oRBook);
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(ORBook oRBook) {
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }
}
