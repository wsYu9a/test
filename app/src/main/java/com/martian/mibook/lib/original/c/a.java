package com.martian.mibook.lib.original.c;

import android.app.Activity;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.n0;
import com.martian.libmars.utils.w0;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.model.d.h;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.e.o;
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

/* loaded from: classes2.dex */
public class a extends com.martian.mibook.lib.model.c.e {

    /* renamed from: com.martian.mibook.lib.original.c.a$a */
    class C0276a extends com.martian.mibook.lib.original.b.a.d {

        /* renamed from: h */
        final /* synthetic */ com.martian.mibook.lib.model.d.b f14065h;

        C0276a(final com.martian.mibook.lib.model.d.b val$receiver) {
            this.f14065h = val$receiver;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f14065h.onResultError(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(ORBook orBook) {
            this.f14065h.a(orBook);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f14065h.onLoading(show);
        }
    }

    class b extends com.martian.mibook.lib.original.b.a.e {
        final /* synthetic */ com.martian.mibook.lib.model.d.e o;
        final /* synthetic */ ORChapter p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(com.martian.mibook.lib.model.c.b bookProvider, com.martian.mibook.lib.model.c.g sourceProvider, Chapter chapter, int index, final com.martian.mibook.lib.model.d.e val$chapter, final ORChapter val$receiver) {
            super(bookProvider, sourceProvider, chapter, index);
            this.o = val$chapter;
            this.p = val$receiver;
        }

        @Override // com.martian.mibook.lib.original.b.a.e
        protected void q(b.d.c.b.c errorResult) {
            this.o.onResultError(errorResult);
        }

        @Override // com.martian.mibook.lib.original.b.a.e
        protected void s(b.d.c.b.c errorResult) {
            this.o.a(this.p, errorResult.d());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.o.onLoading(show);
        }

        @Override // b.d.c.c.b
        /* renamed from: t */
        public void onDataReceived(ORChapterContent orChapterContent) {
            if (orChapterContent.getIsTaked() != null && orChapterContent.getIsTaked().intValue() == 1) {
                this.o.c(orChapterContent);
                return;
            }
            if (this.p != null && orChapterContent.getCoins() != null) {
                this.p.setCoins(orChapterContent.getCoins());
            }
            this.o.a(this.p, orChapterContent.getContent());
        }
    }

    class c extends com.martian.mibook.lib.original.b.a.c {

        /* renamed from: j */
        final /* synthetic */ com.martian.mibook.lib.model.d.c f14067j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(j1 activity, final com.martian.mibook.lib.model.d.c val$receiver) {
            super(activity);
            this.f14067j = val$receiver;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            if (errorResult.c() == 3001) {
                this.f14067j.f();
            } else {
                this.f14067j.d(errorResult.d());
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(MiConsumeOrder miConsumeOrder) {
            this.f14067j.b(1, miConsumeOrder.getCoins().intValue());
        }
    }

    class d extends com.martian.mibook.lib.original.b.a.f {

        /* renamed from: h */
        final /* synthetic */ Book f14068h;

        /* renamed from: i */
        final /* synthetic */ com.martian.mibook.lib.model.d.f f14069i;

        /* renamed from: j */
        final /* synthetic */ boolean f14070j;

        d(final Book val$fallBackToLocal, final com.martian.mibook.lib.model.d.f val$receiver, final boolean val$book) {
            this.f14068h = val$fallBackToLocal;
            this.f14069i = val$receiver;
            this.f14070j = val$book;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            if (this.f14070j) {
                a.this.A(this.f14068h, this.f14069i, false);
            } else {
                this.f14069i.d(errorResult);
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(ORChapterList orChapterList) {
            a.this.B(this.f14068h, orChapterList, this.f14069i);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f14069i.a(show);
        }
    }

    class e extends com.martian.mibook.lib.original.b.a.e {
        final /* synthetic */ com.martian.mibook.lib.model.d.g o;
        final /* synthetic */ int p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(com.martian.mibook.lib.model.c.b bookProvider, com.martian.mibook.lib.model.c.g sourceProvider, Chapter chapter, int index, final com.martian.mibook.lib.model.d.g val$index, final int val$receiver) {
            super(bookProvider, sourceProvider, chapter, index);
            this.o = val$index;
            this.p = val$receiver;
        }

        @Override // com.martian.mibook.lib.original.b.a.e
        protected void q(b.d.c.b.c errorResult) {
            this.o.a(this.p, errorResult);
        }

        @Override // com.martian.mibook.lib.original.b.a.e
        protected void s(b.d.c.b.c errorResult) {
            this.o.a(this.p, errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: t */
        public void onDataReceived(ORChapterContent bsChapterContent) {
            this.o.b(this.p, bsChapterContent);
        }
    }

    class f extends com.martian.mibook.lib.original.b.a.d {

        /* renamed from: h */
        final /* synthetic */ BookWrapper f14071h;

        /* renamed from: i */
        final /* synthetic */ com.martian.mibook.lib.model.d.a f14072i;

        /* renamed from: j */
        final /* synthetic */ int f14073j;

        f(final BookWrapper val$index, final com.martian.mibook.lib.model.d.a val$receiver, final int val$bookWrapper) {
            this.f14071h = val$index;
            this.f14072i = val$receiver;
            this.f14073j = val$bookWrapper;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.mibook.lib.original.b.a.d, b.d.c.c.c, b.d.c.c.b
        /* renamed from: p */
        public boolean onPreDataReceived(ORBook orBook) {
            if (a.this.i(orBook)) {
                a.this.z(orBook, (ORBook) this.f14071h.book);
                if (!this.f14071h.hasUpdate()) {
                    this.f14071h.setHasUpdate(true);
                    a.this.E().k1(this.f14071h.item);
                }
            }
            return super.onPreDataReceived(orBook);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(ORBook orBook) {
            if (this.f14071h.hasUpdate()) {
                this.f14072i.a(this.f14073j);
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class g extends com.martian.mibook.lib.original.b.a.d {

        /* renamed from: h */
        final /* synthetic */ BookWrapper f14074h;

        g(final BookWrapper val$bookWrapper) {
            this.f14074h = val$bookWrapper;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.mibook.lib.original.b.a.d, b.d.c.c.c, b.d.c.c.b
        /* renamed from: p */
        public boolean onPreDataReceived(ORBook orBook) {
            if (a.this.i(orBook)) {
                a.this.z(orBook, (ORBook) this.f14074h.book);
                if (!this.f14074h.hasUpdate()) {
                    this.f14074h.setHasUpdate(true);
                    a.this.E().k1(this.f14074h.item);
                }
            }
            return super.onPreDataReceived(orBook);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(ORBook orBook) {
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    public a(BookManager bookMgr) {
        super(bookMgr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void W(final Activity activity, final MartianRPAccount rpAccount, final Book book, final ORChapter orChapter, final boolean prebuy, final com.martian.mibook.lib.model.d.c receiver) {
        if (!n0.C(activity) || orChapter == null) {
            if (receiver != null) {
                receiver.d("");
                return;
            }
            return;
        }
        c cVar = new c((j1) activity, receiver);
        ((ConsumeChapterParams) cVar.k()).setBookId(book.getSourceId());
        ((ConsumeChapterParams) cVar.k()).setChapterId(orChapter.getChapterId());
        ((ConsumeChapterParams) cVar.k()).setCoins(orChapter.getCoins());
        ((ConsumeChapterParams) cVar.k()).setContent(orChapter.getTitle());
        ((ConsumeChapterParams) cVar.k()).setSubject(book.getBookName());
        cVar.j();
    }

    @Override // com.martian.mibook.lib.model.c.b
    public void C(final Activity activity, final Book book, final Chapter chapter, ChapterContent content, final boolean prebuy, final com.martian.mibook.lib.model.d.c receiver) {
        if (MiUserManager.s().f()) {
            W(activity, MartianIUserManager.b().c(), book, (ORChapter) chapter, prebuy, receiver);
        } else {
            w0.a(activity, "请先登录");
            com.martian.mibook.lib.account.e.d.b(activity, 10003, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.c.b
    public void D(com.martian.mibook.lib.model.c.g source, final com.martian.mibook.lib.model.d.b receiver, boolean isBlocking) {
        C0276a c0276a = new C0276a(receiver);
        ((ORBookParams) c0276a.k()).setBookId(source.getSourceId());
        if (isBlocking) {
            c0276a.i();
        } else {
            c0276a.j();
        }
    }

    @Override // com.martian.mibook.lib.model.c.b
    public String F() {
        return com.martian.mibook.lib.model.manager.d.f14055g;
    }

    @Override // com.martian.mibook.lib.model.c.b
    public boolean I() {
        return false;
    }

    @Override // com.martian.mibook.lib.model.c.e
    public Class<? extends Book> L() {
        return ORBook.class;
    }

    @Override // com.martian.mibook.lib.model.c.e
    public o M() {
        return com.martian.mibook.lib.original.d.b.o();
    }

    @Override // com.martian.mibook.lib.model.c.e
    public Class<? extends Chapter> O() {
        return ORChapter.class;
    }

    @Override // com.martian.mibook.lib.model.c.e
    public com.martian.mibook.lib.model.e.a P(com.martian.mibook.lib.model.c.g sourceProvider) {
        return new com.martian.mibook.lib.original.d.d(sourceProvider.getSourceId());
    }

    @Override // com.martian.mibook.lib.model.c.e
    public com.martian.mibook.lib.model.e.b Q(com.martian.mibook.lib.model.c.g sourceProvider) {
        return new com.martian.mibook.lib.original.d.e(sourceProvider.getSourceId());
    }

    @Override // com.martian.mibook.lib.model.c.e
    protected void S(String keyword, int page, final h receiver, boolean isBlocking, int searchType, int ctype, String sourceName, String sourceId) {
        receiver.d(new b.d.c.b.c(-1, "取消搜索"));
    }

    @Override // com.martian.mibook.lib.model.c.e
    protected void U(Book newBook, Book book) {
        ORBook oRBook = (ORBook) book;
        ORBook oRBook2 = (ORBook) newBook;
        oRBook.setLastChapter(oRBook2.getLastChapter());
        oRBook.setLatestChapterUpdateTime(oRBook2.getLatestChapterUpdateTime());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.c.a
    public boolean c(final BookWrapper bookWrapper) {
        Book book = bookWrapper.book;
        if (book == null || !book.getSourceName().equals(F())) {
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
    @Override // com.martian.mibook.lib.model.c.a
    public void d(com.martian.mibook.lib.model.c.g source, ChapterList chapterList, int index, final com.martian.mibook.lib.model.d.e receiver) {
        ORChapter oRChapter = (ORChapter) chapterList.getItem(index);
        b bVar = new b(this, source, oRChapter, index, receiver, oRChapter);
        ((ORChapterContentParams) bVar.k()).setBookId(source.getSourceId());
        ((ORChapterContentParams) bVar.k()).setChapterId(oRChapter.getChapterId());
        bVar.p();
    }

    @Override // com.martian.mibook.lib.model.c.a
    public void g(final Book book, final com.martian.mibook.lib.model.d.f receiver, boolean fallBackToLocal) {
        q(book, receiver, fallBackToLocal);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.c.a
    public void m(final BookWrapper bookWrapper, final int index, final com.martian.mibook.lib.model.d.a receiver) {
        if (bookWrapper == null || !(bookWrapper.book instanceof ORBook)) {
            return;
        }
        f fVar = new f(bookWrapper, receiver, index);
        ((ORBookParams) fVar.k()).setBookId(bookWrapper.book.getSourceId());
        fVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.c.a
    public void q(final Book book, final com.martian.mibook.lib.model.d.f receiver, final boolean fallBackToLocal) {
        d dVar = new d(book, receiver, fallBackToLocal);
        ((ORChapterListParams) dVar.k()).setBookId(book.getSourceId());
        ((ORChapterListParams) dVar.k()).setPage(0);
        dVar.j();
    }

    @Override // com.martian.mibook.lib.model.c.a
    public com.martian.mibook.lib.model.f.b t(com.martian.mibook.lib.model.c.g source, final int index, Chapter chapter, final com.martian.mibook.lib.model.d.g receiver) {
        return new e(this, source, chapter, index, receiver, index);
    }
}
