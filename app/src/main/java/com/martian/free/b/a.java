package com.martian.free.b;

import android.app.Activity;
import com.martian.free.request.TFBookParams;
import com.martian.free.request.TFBuyChapterParams;
import com.martian.free.request.TFChapterContentParams;
import com.martian.free.request.TFChapterListParams;
import com.martian.free.request.TFSearchBookParams;
import com.martian.free.response.TFBook;
import com.martian.free.response.TFChapter;
import com.martian.free.response.TFChapterContent;
import com.martian.free.response.TFChapterList;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.n0;
import com.martian.libmars.utils.w0;
import com.martian.libsupport.k;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.response.ChapterPrice;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.e.o;
import com.martian.mibook.lib.model.manager.BookManager;

/* loaded from: classes2.dex */
public class a extends com.martian.mibook.lib.model.c.e {

    /* renamed from: b */
    private com.martian.free.c.b f9700b;

    /* renamed from: com.martian.free.b.a$a */
    class C0257a extends com.martian.free.d.e {

        /* renamed from: h */
        final /* synthetic */ com.martian.mibook.lib.model.d.h f9701h;

        C0257a(final com.martian.mibook.lib.model.d.h val$receiver) {
            this.f9701h = val$receiver;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f9701h.d(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(TYSearchBookList tySearchBookList) {
            this.f9701h.c(tySearchBookList.getBookItemList());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f9701h.a(show);
        }
    }

    class b extends com.martian.free.d.a {

        /* renamed from: h */
        final /* synthetic */ com.martian.mibook.lib.model.d.b f9703h;

        b(final com.martian.mibook.lib.model.d.b val$receiver) {
            this.f9703h = val$receiver;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f9703h.onResultError(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(TFBook tfBook) {
            a.this.e(tfBook);
            this.f9703h.a(tfBook);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f9703h.onLoading(show);
        }
    }

    class c extends com.martian.free.d.c {
        final /* synthetic */ com.martian.mibook.lib.model.d.e m;
        final /* synthetic */ TFChapter n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(com.martian.mibook.lib.model.c.b bookProvider, com.martian.mibook.lib.model.c.g sourceProvider, Chapter chapter, int index, final com.martian.mibook.lib.model.d.e val$chapter, final TFChapter val$receiver) {
            super(bookProvider, sourceProvider, chapter, index);
            this.m = val$chapter;
            this.n = val$receiver;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.m.onResultError(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: s */
        public void onDataReceived(TFChapterContent tfChapterContent) {
            if (tfChapterContent.isTaked()) {
                this.m.c(tfChapterContent);
                return;
            }
            if (this.n != null) {
                if (tfChapterContent.getPrice() != null) {
                    this.n.setPrice(tfChapterContent.getPrice());
                }
                this.n.setChargeType(tfChapterContent.getChargeType());
            }
            this.m.a(this.n, tfChapterContent.getContent());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.m.onLoading(show);
        }
    }

    class d extends com.martian.free.d.b {

        /* renamed from: j */
        final /* synthetic */ com.martian.mibook.lib.model.d.c f9705j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(j1 activity, final com.martian.mibook.lib.model.d.c val$receiver) {
            super(activity);
            this.f9705j = val$receiver;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            if (errorResult.c() == BookManager.f14021c) {
                this.f9705j.f();
            } else {
                this.f9705j.d(errorResult.d());
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(ChapterPrice tfChapterPrice) {
            this.f9705j.b(1, tfChapterPrice == null ? 0 : tfChapterPrice.getPrice());
        }
    }

    class e extends com.martian.free.d.d {

        /* renamed from: h */
        final /* synthetic */ Book f9706h;

        /* renamed from: i */
        final /* synthetic */ com.martian.mibook.lib.model.d.f f9707i;

        /* renamed from: j */
        final /* synthetic */ boolean f9708j;

        e(final Book val$fallBackToLocal, final com.martian.mibook.lib.model.d.f val$receiver, final boolean val$book) {
            this.f9706h = val$fallBackToLocal;
            this.f9707i = val$receiver;
            this.f9708j = val$book;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            if (this.f9708j) {
                a.this.A(this.f9706h, this.f9707i, false);
            } else {
                this.f9707i.d(errorResult);
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(TFChapterList tfChapterList) {
            a.this.B(this.f9706h, tfChapterList, this.f9707i);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f9707i.a(show);
        }
    }

    class f extends com.martian.free.d.c {
        final /* synthetic */ com.martian.mibook.lib.model.d.g m;
        final /* synthetic */ int n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(com.martian.mibook.lib.model.c.b bookProvider, com.martian.mibook.lib.model.c.g sourceProvider, Chapter chapter, int index, final com.martian.mibook.lib.model.d.g val$index, final int val$receiver) {
            super(bookProvider, sourceProvider, chapter, index);
            this.m = val$index;
            this.n = val$receiver;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.m.a(this.n, errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: s */
        public void onDataReceived(TFChapterContent tfChapterContent) {
            this.m.b(this.n, tfChapterContent);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class g extends com.martian.free.d.a {

        /* renamed from: h */
        final /* synthetic */ BookWrapper f9709h;

        /* renamed from: i */
        final /* synthetic */ com.martian.mibook.lib.model.d.a f9710i;

        /* renamed from: j */
        final /* synthetic */ int f9711j;

        g(final BookWrapper val$index, final com.martian.mibook.lib.model.d.a val$receiver, final int val$bookWrapper) {
            this.f9709h = val$index;
            this.f9710i = val$receiver;
            this.f9711j = val$bookWrapper;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.free.d.a, b.d.c.c.c, b.d.c.c.b
        /* renamed from: p */
        public boolean onPreDataReceived(TFBook sgBook) {
            a.this.z(sgBook, (TFBook) this.f9709h.book);
            if (a.this.i(sgBook) && !this.f9709h.hasUpdate()) {
                this.f9709h.setHasUpdate(true);
                a.this.E().k1(this.f9709h.item);
            }
            return super.onPreDataReceived(sgBook);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(TFBook tfBook) {
            if (this.f9709h.hasUpdate()) {
                this.f9710i.a(this.f9711j);
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class h extends com.martian.free.d.a {

        /* renamed from: h */
        final /* synthetic */ BookWrapper f9712h;

        h(final BookWrapper val$bookWrapper) {
            this.f9712h = val$bookWrapper;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.free.d.a, b.d.c.c.c, b.d.c.c.b
        /* renamed from: p */
        public boolean onPreDataReceived(TFBook ywBook) {
            TFBook tFBook = (TFBook) this.f9712h.book;
            if (a.this.i(ywBook)) {
                a.this.z(ywBook, tFBook);
                if (!this.f9712h.hasUpdate()) {
                    this.f9712h.setHasUpdate(true);
                    a.this.E().k1(this.f9712h.item);
                }
            }
            return super.onPreDataReceived(ywBook);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(TFBook tfBook) {
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    public a(BookManager bookMgr) {
        super(bookMgr);
        this.f9700b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.c.b
    public void C(final Activity activity, final Book book, final Chapter chapter, final ChapterContent content, final boolean prebuy, final com.martian.mibook.lib.model.d.c receiver) {
        if (!MiUserManager.s().f()) {
            w0.a(activity, "请先登录");
            com.martian.mibook.lib.account.e.d.b(activity, 10003, false);
            return;
        }
        if (!n0.C(activity) || chapter == null) {
            if (receiver != null) {
                receiver.d("");
                return;
            }
            return;
        }
        TFChapter tFChapter = (TFChapter) chapter;
        d dVar = new d((j1) activity, receiver);
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
    @Override // com.martian.mibook.lib.model.c.b
    public void D(com.martian.mibook.lib.model.c.g source, final com.martian.mibook.lib.model.d.b receiver, boolean isBlocking) {
        b bVar = new b(receiver);
        ((TFBookParams) bVar.k()).setBid(source.getSourceId());
        if (isBlocking) {
            bVar.i();
        } else {
            bVar.j();
        }
    }

    @Override // com.martian.mibook.lib.model.c.b
    public String F() {
        return com.martian.mibook.lib.model.manager.d.l;
    }

    @Override // com.martian.mibook.lib.model.c.b
    public boolean I() {
        return false;
    }

    @Override // com.martian.mibook.lib.model.c.e
    public Class<? extends Book> L() {
        return TFBook.class;
    }

    @Override // com.martian.mibook.lib.model.c.e
    public o M() {
        if (this.f9700b == null) {
            this.f9700b = new com.martian.free.c.b();
        }
        return this.f9700b;
    }

    @Override // com.martian.mibook.lib.model.c.e
    public Class<? extends Chapter> O() {
        return TFChapter.class;
    }

    @Override // com.martian.mibook.lib.model.c.e
    public com.martian.mibook.lib.model.e.a P(com.martian.mibook.lib.model.c.g sourceProvider) {
        return new com.martian.free.c.c(sourceProvider.getSourceId());
    }

    @Override // com.martian.mibook.lib.model.c.e
    public com.martian.mibook.lib.model.e.b Q(com.martian.mibook.lib.model.c.g sourceProvider) {
        return new com.martian.free.c.d(sourceProvider.getSourceId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.c.e
    protected void S(String keyword, int page, final com.martian.mibook.lib.model.d.h receiver, boolean isBlocking, int searchType, int ctype, String sourceName, String sourceId) {
        C0257a c0257a = new C0257a(receiver);
        ((TFSearchBookParams) c0257a.k()).setKeywords(keyword);
        ((TFSearchBookParams) c0257a.k()).setPage(Integer.valueOf(page));
        ((TFSearchBookParams) c0257a.k()).setCtype(Integer.valueOf(ctype));
        ((TFSearchBookParams) c0257a.k()).setFromUser(Integer.valueOf(searchType));
        ((TFSearchBookParams) c0257a.k()).setSourceName(F());
        if (!k.p(sourceId)) {
            ((TFSearchBookParams) c0257a.k()).setSourceId(sourceId);
        }
        ((TFSearchBookParams) c0257a.k()).setPageSize(Integer.valueOf(searchType == 6 ? 8 : 10));
        if (isBlocking) {
            c0257a.i();
        } else {
            c0257a.j();
        }
    }

    @Override // com.martian.mibook.lib.model.c.e
    protected void U(Book newBook, Book book) {
        TFBook tFBook = (TFBook) newBook;
        TFBook tFBook2 = (TFBook) book;
        tFBook2.setLatestChapter(tFBook.getLatestChapter());
        tFBook2.setStatus(tFBook.getRawStatus());
        tFBook2.setLatestChapterUpdateTime(tFBook.getLatestChapterUpdateTime());
        tFBook2.setAllWords(tFBook.getAllWords());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.c.a
    public boolean c(final BookWrapper bookWrapper) {
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
    @Override // com.martian.mibook.lib.model.c.a
    public void d(com.martian.mibook.lib.model.c.g source, ChapterList chapterList, int index, final com.martian.mibook.lib.model.d.e receiver) {
        if (chapterList == null) {
            return;
        }
        TFChapter tFChapter = (TFChapter) chapterList.getItem(index);
        c cVar = new c(this, source, tFChapter, index, receiver, tFChapter);
        if (MiUserManager.s() != null && MiUserManager.s().f()) {
            ((TFChapterContentParams) cVar.k()).setUid(MiUserManager.s().e().getUid());
            ((TFChapterContentParams) cVar.k()).setToken(MiUserManager.s().e().getToken());
        }
        ((TFChapterContentParams) cVar.k()).setBid(source.getSourceId());
        if (tFChapter != null) {
            ((TFChapterContentParams) cVar.k()).setCid(tFChapter.getCid());
        }
        cVar.p();
    }

    @Override // com.martian.mibook.lib.model.c.a
    public void g(Book book, com.martian.mibook.lib.model.d.f receiver, boolean fallBackToLocal) {
        q(book, receiver, fallBackToLocal);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.c.a
    public void m(final BookWrapper bookWrapper, final int index, final com.martian.mibook.lib.model.d.a receiver) {
        if (bookWrapper.book instanceof TFBook) {
            g gVar = new g(bookWrapper, receiver, index);
            ((TFBookParams) gVar.k()).setBid(bookWrapper.book.getSourceId());
            gVar.j();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.c.a
    public void q(final Book book, final com.martian.mibook.lib.model.d.f receiver, final boolean fallBackToLocal) {
        e eVar = new e(book, receiver, fallBackToLocal);
        ((TFChapterListParams) eVar.k()).setBid(book.getSourceId());
        eVar.j();
    }

    @Override // com.martian.mibook.lib.model.c.a
    public com.martian.mibook.lib.model.f.b t(com.martian.mibook.lib.model.c.g source, final int index, Chapter chapter, final com.martian.mibook.lib.model.d.g receiver) {
        return new f(this, source, chapter, index, receiver, index);
    }
}
