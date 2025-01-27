package com.martian.mibook.lib.yuewen.c;

import android.app.Activity;
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
import com.martian.mibook.lib.yuewen.e.j;
import com.martian.mibook.lib.yuewen.e.n;
import com.martian.mibook.lib.yuewen.request.YWBookParams;
import com.martian.mibook.lib.yuewen.request.YWBuyBookParams;
import com.martian.mibook.lib.yuewen.request.YWBuyChapterParams;
import com.martian.mibook.lib.yuewen.request.YWChapterContentParams;
import com.martian.mibook.lib.yuewen.request.YWChapterListParams;
import com.martian.mibook.lib.yuewen.request.YWSearchBookParams;
import com.martian.mibook.lib.yuewen.response.YWBook;
import com.martian.mibook.lib.yuewen.response.YWBookPrice;
import com.martian.mibook.lib.yuewen.response.YWChapter;
import com.martian.mibook.lib.yuewen.response.YWChapterContent;
import com.martian.mibook.lib.yuewen.response.YWChapterList;
import com.martian.rpauth.MartianIUserManager;
import com.martian.rpauth.response.MartianRPAccount;

/* loaded from: classes4.dex */
public class a extends com.martian.mibook.lib.model.c.e {

    /* renamed from: b */
    private com.martian.mibook.lib.yuewen.d.b f14082b;

    /* renamed from: com.martian.mibook.lib.yuewen.c.a$a */
    class C0277a extends n {

        /* renamed from: h */
        final /* synthetic */ com.martian.mibook.lib.model.d.h f14083h;

        C0277a(final com.martian.mibook.lib.model.d.h val$receiver) {
            this.f14083h = val$receiver;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f14083h.d(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(TYSearchBookList ywSearchBookList) {
            this.f14083h.c(ywSearchBookList.getBookItemList());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f14083h.a(show);
        }
    }

    class b extends com.martian.mibook.lib.yuewen.e.d {

        /* renamed from: h */
        final /* synthetic */ com.martian.mibook.lib.model.d.b f14085h;

        b(final com.martian.mibook.lib.model.d.b val$receiver) {
            this.f14085h = val$receiver;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f14085h.onResultError(errorResult);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(YWBook ywBook) {
            a.this.e(ywBook);
            this.f14085h.a(ywBook);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f14085h.onLoading(show);
        }
    }

    class c extends com.martian.mibook.lib.yuewen.e.i {
        final /* synthetic */ com.martian.mibook.lib.model.d.e m;
        final /* synthetic */ YWChapter n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(com.martian.mibook.lib.model.c.b bookProvider, com.martian.mibook.lib.model.c.g sourceProvider, Chapter chapter, int index, final com.martian.mibook.lib.model.d.e val$chapter, final YWChapter val$receiver) {
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
        public void onDataReceived(YWChapterContent ywChapterContent) {
            if (ywChapterContent.getIsTaked() == 1) {
                this.m.c(ywChapterContent);
                return;
            }
            if (this.n != null) {
                if (ywChapterContent.getPrice() != null) {
                    this.n.setPrice(ywChapterContent.getPrice());
                }
                this.n.setChargeType(ywChapterContent.getChargeType().intValue());
                this.n.setVipflag(1);
            }
            this.m.a(this.n, ywChapterContent.getContent());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            if (show) {
                this.m.onLoading(show);
            }
        }
    }

    class d extends j {

        /* renamed from: h */
        final /* synthetic */ Book f14087h;

        /* renamed from: i */
        final /* synthetic */ com.martian.mibook.lib.model.d.f f14088i;

        /* renamed from: j */
        final /* synthetic */ boolean f14089j;

        d(final Book val$fallBackToLocal, final com.martian.mibook.lib.model.d.f val$receiver, final boolean val$book) {
            this.f14087h = val$fallBackToLocal;
            this.f14088i = val$receiver;
            this.f14089j = val$book;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            if (this.f14089j) {
                a.this.A(this.f14087h, this.f14088i, false);
            } else {
                this.f14088i.d(errorResult);
            }
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(YWChapterList ywChapterList) {
            a.this.B(this.f14087h, ywChapterList, this.f14088i);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f14088i.a(show);
        }
    }

    class e extends com.martian.mibook.lib.yuewen.e.i {
        final /* synthetic */ com.martian.mibook.lib.model.d.g m;
        final /* synthetic */ int n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(com.martian.mibook.lib.model.c.b bookProvider, com.martian.mibook.lib.model.c.g sourceProvider, Chapter chapter, int index, final com.martian.mibook.lib.model.d.g val$index, final int val$receiver) {
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
        public void onDataReceived(YWChapterContent ywChapterContent) {
            this.m.b(this.n, ywChapterContent);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class f extends com.martian.mibook.lib.yuewen.e.d {

        /* renamed from: h */
        final /* synthetic */ BookWrapper f14090h;

        /* renamed from: i */
        final /* synthetic */ com.martian.mibook.lib.model.d.a f14091i;

        /* renamed from: j */
        final /* synthetic */ int f14092j;

        f(final BookWrapper val$index, final com.martian.mibook.lib.model.d.a val$receiver, final int val$bookWrapper) {
            this.f14090h = val$index;
            this.f14091i = val$receiver;
            this.f14092j = val$bookWrapper;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.mibook.lib.yuewen.e.d, b.d.c.c.c, b.d.c.c.b
        /* renamed from: p */
        public boolean onPreDataReceived(YWBook sgBook) {
            YWBook yWBook = (YWBook) this.f14090h.book;
            if (a.this.i(sgBook)) {
                a.this.z(sgBook, yWBook);
                if (!this.f14090h.hasUpdate()) {
                    this.f14090h.setHasUpdate(true);
                    a.this.E().k1(this.f14090h.item);
                }
            } else if (sgBook != null && yWBook != null && !sgBook.getDistType().equals(yWBook.getDistType())) {
                a.this.z(sgBook, yWBook);
            }
            return super.onPreDataReceived(sgBook);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(YWBook ywBook) {
            if (this.f14090h.hasUpdate()) {
                this.f14091i.a(this.f14092j);
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class g extends com.martian.mibook.lib.yuewen.e.d {

        /* renamed from: h */
        final /* synthetic */ BookWrapper f14093h;

        g(final BookWrapper val$bookWrapper) {
            this.f14093h = val$bookWrapper;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
        }

        @Override // com.martian.mibook.lib.yuewen.e.d, b.d.c.c.c, b.d.c.c.b
        /* renamed from: p */
        public boolean onPreDataReceived(YWBook ywBook) {
            YWBook yWBook = (YWBook) this.f14093h.book;
            if (a.this.i(ywBook)) {
                a.this.z(ywBook, yWBook);
                if (!this.f14093h.hasUpdate()) {
                    this.f14093h.setHasUpdate(true);
                    a.this.E().k1(this.f14093h.item);
                }
            } else if (ywBook != null && yWBook != null && !ywBook.getDistType().equals(yWBook.getDistType())) {
                a.this.z(ywBook, yWBook);
            }
            return super.onPreDataReceived(ywBook);
        }

        @Override // b.d.c.c.b
        /* renamed from: q */
        public void onDataReceived(YWBook ywBook) {
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class h extends com.martian.mibook.lib.yuewen.e.f {

        /* renamed from: j */
        final /* synthetic */ com.martian.mibook.lib.model.d.c f14095j;
        final /* synthetic */ YWBook k;
        final /* synthetic */ YWChapter l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(j1 activity, final com.martian.mibook.lib.model.d.c val$chapter, final YWBook val$book, final YWChapter val$receiver) {
            super(activity);
            this.f14095j = val$chapter;
            this.k = val$book;
            this.l = val$receiver;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            if (errorResult.c() == BookManager.f14021c) {
                this.f14095j.f();
            } else {
                this.f14095j.d(errorResult.d());
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(ChapterPrice ywChapterPrice) {
            a.this.Z(this.k, this.l);
            this.f14095j.b(1, ywChapterPrice == null ? 0 : ywChapterPrice.getPrice());
        }
    }

    class i extends com.martian.mibook.lib.yuewen.e.e {

        /* renamed from: j */
        final /* synthetic */ com.martian.mibook.lib.model.d.c f14096j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(j1 activity, final com.martian.mibook.lib.model.d.c val$receiver) {
            super(activity);
            this.f14096j = val$receiver;
        }

        @Override // com.martian.mibook.lib.account.d.n
        protected void r(b.d.c.b.c errorResult) {
            if (errorResult.c() == BookManager.f14021c) {
                this.f14096j.f();
            } else {
                this.f14096j.d(errorResult.d());
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        /* renamed from: u */
        public void onDataReceived(YWBookPrice ywBookPrice) {
            this.f14096j.b(1, ywBookPrice.getPrice());
        }
    }

    public a(BookManager bookMgr) {
        super(bookMgr);
        this.f14082b = null;
    }

    public void Z(Book book, YWChapter ywChapter) {
        if (ywChapter == null) {
            return;
        }
        com.martian.mibook.lib.yuewen.d.d dVar = new com.martian.mibook.lib.yuewen.d.d(book.getSourceId());
        ywChapter.setIsTaked(1);
        dVar.g(ywChapter);
    }

    @Override // com.martian.mibook.lib.model.c.b
    public void C(final Activity activity, final Book book, final Chapter chapter, final ChapterContent content, final boolean prebuy, final com.martian.mibook.lib.model.d.c receiver) {
        boolean z = false;
        if (!MiUserManager.s().f()) {
            w0.a(activity, "请先登录");
            com.martian.mibook.lib.account.e.d.b(activity, 10003, false);
            return;
        }
        MartianRPAccount c2 = MartianIUserManager.b().c();
        YWChapter yWChapter = (YWChapter) chapter;
        YWBook yWBook = (YWBook) book;
        YWChapterContent yWChapterContent = (YWChapterContent) content;
        if (yWBook != null && yWChapterContent != null) {
            if (yWBook.getChargeType() == null) {
                yWBook.setChargeType(yWChapterContent.getChargeType());
            }
            if (yWBook.getTotalPrice() == null) {
                yWBook.setTotalPrice(yWChapterContent.getTotalPrice());
            }
        }
        if (yWBook != null && yWBook.getChargeType() != null && yWBook.getChargeType().intValue() == 2) {
            z = true;
        }
        if (z) {
            Y(activity, c2.getBookCoins(), book, chapter, receiver);
        } else {
            X(activity, yWBook, yWChapter, receiver);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.c.b
    public void D(com.martian.mibook.lib.model.c.g source, final com.martian.mibook.lib.model.d.b receiver, boolean isBlocking) {
        b bVar = new b(receiver);
        ((YWBookParams) bVar.k()).setCbid(Long.valueOf(Long.parseLong(source.getSourceId())));
        if (isBlocking) {
            bVar.i();
        } else {
            bVar.j();
        }
    }

    @Override // com.martian.mibook.lib.model.c.b
    public String F() {
        return com.martian.mibook.lib.model.manager.d.k;
    }

    @Override // com.martian.mibook.lib.model.c.b
    public boolean I() {
        return false;
    }

    @Override // com.martian.mibook.lib.model.c.e
    public Class<? extends Book> L() {
        return YWBook.class;
    }

    @Override // com.martian.mibook.lib.model.c.e
    public o M() {
        if (this.f14082b == null) {
            this.f14082b = new com.martian.mibook.lib.yuewen.d.b();
        }
        return this.f14082b;
    }

    @Override // com.martian.mibook.lib.model.c.e
    public Class<? extends Chapter> O() {
        return YWChapter.class;
    }

    @Override // com.martian.mibook.lib.model.c.e
    public com.martian.mibook.lib.model.e.a P(com.martian.mibook.lib.model.c.g sourceProvider) {
        return new com.martian.mibook.lib.yuewen.d.c(sourceProvider.getSourceId());
    }

    @Override // com.martian.mibook.lib.model.c.e
    public com.martian.mibook.lib.model.e.b Q(com.martian.mibook.lib.model.c.g sourceProvider) {
        return new com.martian.mibook.lib.yuewen.d.d(sourceProvider.getSourceId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.c.e
    protected void S(String keyword, int page, final com.martian.mibook.lib.model.d.h receiver, boolean isBlocking, int searchType, int ctype, String sourceName, String sourceId) {
        C0277a c0277a = new C0277a(receiver);
        ((YWSearchBookParams) c0277a.k()).setKeywords(keyword);
        ((YWSearchBookParams) c0277a.k()).setPage(Integer.valueOf(page));
        ((YWSearchBookParams) c0277a.k()).setCtype(Integer.valueOf(ctype));
        ((YWSearchBookParams) c0277a.k()).setFromUser(Integer.valueOf(searchType));
        YWSearchBookParams yWSearchBookParams = (YWSearchBookParams) c0277a.k();
        if (k.p(sourceName)) {
            sourceName = F();
        }
        yWSearchBookParams.setSourceName(sourceName);
        if (!k.p(sourceId)) {
            ((YWSearchBookParams) c0277a.k()).setSourceId(sourceId);
        }
        if (searchType == 6) {
            ((YWSearchBookParams) c0277a.k()).setPageSize(8);
        } else if (searchType == 7) {
            ((YWSearchBookParams) c0277a.k()).setPageSize(8);
        } else {
            ((YWSearchBookParams) c0277a.k()).setPageSize(10);
        }
        if (isBlocking) {
            c0277a.i();
        } else {
            c0277a.j();
        }
    }

    @Override // com.martian.mibook.lib.model.c.e
    protected void U(Book newBook, Book book) {
        if (newBook == book) {
            return;
        }
        YWBook yWBook = (YWBook) newBook;
        YWBook yWBook2 = (YWBook) book;
        yWBook2.setLatestChapter(yWBook.getLatestChapter());
        yWBook2.setStatus(yWBook.getRawStatus());
        yWBook2.setLatestChapterUpdateTime(yWBook.getLatestChapterUpdateTime());
        yWBook2.setAllWords(yWBook.getAllWords());
        yWBook2.setLatestChapterId(yWBook.getLatestChapterId());
        yWBook2.setDistType(yWBook.getDistType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void X(final Activity activity, final YWBook book, final YWChapter chapter, final com.martian.mibook.lib.model.d.c receiver) {
        if (!n0.C(activity) || chapter == null) {
            if (receiver != null) {
                receiver.d("");
                return;
            }
            return;
        }
        h hVar = new h((j1) activity, receiver, book, chapter);
        if (book != null) {
            ((YWBuyChapterParams) hVar.k()).setSourceName(book.getSourceName());
            ((YWBuyChapterParams) hVar.k()).setSourceId(book.getSourceId());
        }
        if (chapter.getCcid() != null) {
            ((YWBuyChapterParams) hVar.k()).setChapterId(String.valueOf(chapter.getCcid()));
        }
        ((YWBuyChapterParams) hVar.k()).setChapterName(chapter.getTitle());
        ((YWBuyChapterParams) hVar.k()).setPrice(chapter.getPrice());
        hVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Y(final Activity activity, final int accountCoins, Book book, Chapter chapter, final com.martian.mibook.lib.model.d.c receiver) {
        YWBook yWBook;
        if (activity == null || chapter == null || (yWBook = (YWBook) book) == null) {
            return;
        }
        i iVar = new i((j1) activity, receiver);
        ((YWBuyBookParams) iVar.k()).setCbid(yWBook.getSourceId());
        ((YWBuyBookParams) iVar.k()).setPrice(yWBook.getTotalPrice());
        ((YWBuyBookParams) iVar.k()).setBookName(yWBook.getBookName());
        iVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.c.a
    public boolean c(final BookWrapper bookWrapper) {
        if (!(bookWrapper.book instanceof YWBook)) {
            return false;
        }
        if (bookWrapper.hasUpdate()) {
            return true;
        }
        g gVar = new g(bookWrapper);
        ((YWBookParams) gVar.k()).setCbid(Long.valueOf(Long.parseLong(bookWrapper.book.getSourceId())));
        gVar.i();
        return bookWrapper.hasUpdate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.c.a
    public void d(com.martian.mibook.lib.model.c.g source, ChapterList chapterList, int index, final com.martian.mibook.lib.model.d.e receiver) {
        YWChapter yWChapter = (YWChapter) chapterList.getItem(index);
        c cVar = new c(this, source, yWChapter, index, receiver, yWChapter);
        if (MiUserManager.s() != null && MiUserManager.s().f()) {
            ((YWChapterContentParams) cVar.k()).setAutoBuy(Boolean.valueOf(MiUserManager.s().A()));
            ((YWChapterContentParams) cVar.k()).setUid(MiUserManager.s().e().getUid());
            ((YWChapterContentParams) cVar.k()).setToken(MiUserManager.s().e().getToken());
        }
        ((YWChapterContentParams) cVar.k()).setCbid(source.getSourceId());
        if (yWChapter != null && yWChapter.getCcid() != null) {
            ((YWChapterContentParams) cVar.k()).setCcid(yWChapter.getCcid());
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
        if (bookWrapper == null || !(bookWrapper.book instanceof YWBook)) {
            return;
        }
        f fVar = new f(bookWrapper, receiver, index);
        ((YWBookParams) fVar.k()).setCbid(Long.valueOf(Long.parseLong(bookWrapper.book.getSourceId())));
        fVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.c.a
    public void q(final Book book, final com.martian.mibook.lib.model.d.f receiver, final boolean fallBackToLocal) {
        d dVar = new d(book, receiver, fallBackToLocal);
        ((YWChapterListParams) dVar.k()).setCbid(Long.valueOf(Long.parseLong(book.getSourceId())));
        dVar.j();
    }

    @Override // com.martian.mibook.lib.model.c.a
    public com.martian.mibook.lib.model.f.b t(com.martian.mibook.lib.model.c.g source, final int index, Chapter chapter, final com.martian.mibook.lib.model.d.g receiver) {
        return new e(this, source, chapter, index, receiver, index);
    }
}
