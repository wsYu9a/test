package hc;

import android.app.Activity;
import ba.l;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.response.ChapterPrice;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.TYSearchBookList;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.manager.BookManager;
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
import jc.j;
import jc.n;
import l9.m0;
import l9.t0;

/* loaded from: classes3.dex */
public class a extends wb.e {

    /* renamed from: b */
    public ic.b f26518b;

    /* renamed from: hc.a$a */
    public class C0709a extends n {

        /* renamed from: i */
        public final /* synthetic */ xb.h f26519i;

        public C0709a(xb.h hVar) {
            this.f26519i = hVar;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f26519i.d(cVar);
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(TYSearchBookList tYSearchBookList) {
            this.f26519i.c(tYSearchBookList.getBookItemList());
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f26519i.a(z10);
        }
    }

    public class b extends jc.d {

        /* renamed from: i */
        public final /* synthetic */ xb.b f26521i;

        public b(xb.b bVar) {
            this.f26521i = bVar;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f26521i.onResultError(cVar);
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(YWBook yWBook) {
            a.this.e(yWBook);
            this.f26521i.a(yWBook);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f26521i.onLoading(z10);
        }
    }

    public class c extends jc.i {

        /* renamed from: n */
        public final /* synthetic */ xb.e f26523n;

        /* renamed from: o */
        public final /* synthetic */ YWChapter f26524o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(wb.b bVar, wb.f fVar, Chapter chapter, int i10, xb.e eVar, YWChapter yWChapter) {
            super(bVar, fVar, chapter, i10);
            this.f26523n = eVar;
            this.f26524o = yWChapter;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f26523n.onResultError(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            if (z10) {
                this.f26523n.onLoading(z10);
            }
        }

        @Override // y8.a
        /* renamed from: t */
        public void onDataReceived(YWChapterContent yWChapterContent) {
            if (yWChapterContent.getIsTaked() == 1) {
                this.f26523n.c(yWChapterContent);
                return;
            }
            if (this.f26524o != null) {
                if (yWChapterContent.getPrice() != null) {
                    this.f26524o.setPrice(yWChapterContent.getPrice());
                }
                this.f26524o.setChargeType(yWChapterContent.getChargeType().intValue());
                this.f26524o.setVipflag(1);
            }
            this.f26523n.a(this.f26524o, yWChapterContent.getContent());
        }
    }

    public class d extends j {

        /* renamed from: i */
        public final /* synthetic */ Book f26526i;

        /* renamed from: j */
        public final /* synthetic */ xb.f f26527j;

        /* renamed from: k */
        public final /* synthetic */ boolean f26528k;

        public d(Book book, xb.f fVar, boolean z10) {
            this.f26526i = book;
            this.f26527j = fVar;
            this.f26528k = z10;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            if (this.f26528k) {
                a.this.A(this.f26526i, this.f26527j, false);
            } else {
                this.f26527j.d(cVar);
            }
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(YWChapterList yWChapterList) {
            a.this.B(this.f26526i, yWChapterList, this.f26527j);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f26527j.a(z10);
        }
    }

    public a(BookManager bookManager) {
        super(bookManager);
        this.f26518b = null;
    }

    @Override // wb.b
    public void C(Activity activity, Book book, Chapter chapter, ChapterContent chapterContent, boolean z10, xb.c cVar) {
        if (!MiUserManager.q().f()) {
            t0.b(activity, "请先登录");
            lb.d.b(activity, 10003, false);
            return;
        }
        MartianRPAccount c10 = MartianIUserManager.b().c();
        YWChapter yWChapter = (YWChapter) chapter;
        YWBook yWBook = (YWBook) book;
        YWChapterContent yWChapterContent = (YWChapterContent) chapterContent;
        if (yWBook != null && yWChapterContent != null) {
            if (yWBook.getChargeType() == null) {
                yWBook.setChargeType(yWChapterContent.getChargeType());
            }
            if (yWBook.getTotalPrice() == null) {
                yWBook.setTotalPrice(yWChapterContent.getTotalPrice());
            }
        }
        if (yWBook == null || yWBook.getChargeType() == null || yWBook.getChargeType().intValue() != 2) {
            Z(activity, yWBook, yWChapter, cVar);
        } else {
            a0(activity, c10.getBookCoins(), book, chapter, cVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.b
    public void D(wb.f fVar, xb.b bVar, boolean z10) {
        b bVar2 = new b(bVar);
        ((YWBookParams) bVar2.k()).setCbid(Long.valueOf(Long.parseLong(fVar.getSourceId())));
        if (z10) {
            bVar2.i();
        } else {
            bVar2.j();
        }
    }

    @Override // wb.b
    public Class<? extends Book> E() {
        return YWBook.class;
    }

    @Override // wb.b
    public yb.n F() {
        if (this.f26518b == null) {
            this.f26518b = new ic.b();
        }
        return this.f26518b;
    }

    @Override // wb.b
    public String H() {
        return vb.e.f31299f;
    }

    @Override // wb.b
    public boolean K() {
        return false;
    }

    @Override // wb.e
    public Class<? extends Chapter> Q() {
        return YWChapter.class;
    }

    @Override // wb.e
    public yb.a R(wb.f fVar) {
        return new ic.c(fVar.getSourceId());
    }

    @Override // wb.e
    public yb.b S(wb.f fVar) {
        return new ic.d(fVar.getSourceId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.e
    public void V(String str, int i10, xb.h hVar, boolean z10, int i11, int i12, String str2, String str3) {
        C0709a c0709a = new C0709a(hVar);
        ((YWSearchBookParams) c0709a.k()).setKeywords(str);
        ((YWSearchBookParams) c0709a.k()).setPage(Integer.valueOf(i10));
        ((YWSearchBookParams) c0709a.k()).setCtype(Integer.valueOf(i12));
        ((YWSearchBookParams) c0709a.k()).setFromUser(Integer.valueOf(i11));
        YWSearchBookParams yWSearchBookParams = (YWSearchBookParams) c0709a.k();
        if (l.q(str2)) {
            str2 = H();
        }
        yWSearchBookParams.setSourceName(str2);
        if (!l.q(str3)) {
            ((YWSearchBookParams) c0709a.k()).setSourceId(str3);
        }
        if (i11 == 6) {
            ((YWSearchBookParams) c0709a.k()).setPageSize(8);
        } else if (i11 == 7) {
            ((YWSearchBookParams) c0709a.k()).setPageSize(8);
        } else {
            ((YWSearchBookParams) c0709a.k()).setPageSize(10);
        }
        if (z10) {
            c0709a.i();
        } else {
            c0709a.j();
        }
    }

    @Override // wb.e
    public void W(Book book, Book book2) {
        if (book == book2 || !(book instanceof YWBook) || !(book2 instanceof YWBook)) {
            super.W(book, book2);
            return;
        }
        YWBook yWBook = (YWBook) book;
        YWBook yWBook2 = (YWBook) book2;
        yWBook2.setLatestChapter(yWBook.getLatestChapter());
        yWBook2.setStatus(yWBook.getRawStatus());
        yWBook2.setLatestChapterUpdateTime(yWBook.getLatestChapterUpdateTime());
        yWBook2.setAllWords(yWBook.getAllWords());
        yWBook2.setLatestChapterId(yWBook.getLatestChapterId());
        yWBook2.setDistType(yWBook.getDistType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Z(Activity activity, YWBook yWBook, YWChapter yWChapter, xb.c cVar) {
        if (!m0.C(activity) || yWChapter == null) {
            if (cVar != null) {
                cVar.d("");
                return;
            }
            return;
        }
        h hVar = new h(activity, cVar, yWBook, yWChapter);
        if (yWBook != null) {
            ((YWBuyChapterParams) hVar.k()).setSourceName(yWBook.getSourceName());
            ((YWBuyChapterParams) hVar.k()).setSourceId(yWBook.getSourceId());
        }
        if (yWChapter.getCcid() != null) {
            ((YWBuyChapterParams) hVar.k()).setChapterId(String.valueOf(yWChapter.getCcid()));
        }
        ((YWBuyChapterParams) hVar.k()).setChapterName(yWChapter.getTitle());
        ((YWBuyChapterParams) hVar.k()).setPrice(yWChapter.getPrice());
        hVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a0(Activity activity, int i10, Book book, Chapter chapter, xb.c cVar) {
        YWBook yWBook;
        if (activity == null || chapter == null || (yWBook = (YWBook) book) == null) {
            return;
        }
        i iVar = new i(activity, cVar);
        ((YWBuyBookParams) iVar.k()).setCbid(yWBook.getSourceId());
        ((YWBuyBookParams) iVar.k()).setPrice(yWBook.getTotalPrice());
        ((YWBuyBookParams) iVar.k()).setBookName(yWBook.getBookName());
        iVar.j();
    }

    public final void b0(Book book, YWChapter yWChapter) {
        if (yWChapter == null) {
            return;
        }
        ic.d dVar = new ic.d(book.getSourceId());
        yWChapter.setIsTaked(1);
        dVar.e(yWChapter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.a
    public boolean c(BookWrapper bookWrapper) {
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
    @Override // wb.a
    public void g(Book book, int i10, xb.f fVar, boolean z10) {
        d dVar = new d(book, fVar, z10);
        ((YWChapterListParams) dVar.k()).setCbid(Long.valueOf(Long.parseLong(book.getSourceId())));
        ((YWChapterListParams) dVar.k()).setRetry(Integer.valueOf(i10));
        dVar.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.a
    public void i(BookWrapper bookWrapper, int i10, xb.a aVar) {
        if (bookWrapper == null || !(bookWrapper.book instanceof YWBook)) {
            return;
        }
        f fVar = new f(bookWrapper, aVar, i10);
        ((YWBookParams) fVar.k()).setCbid(Long.valueOf(Long.parseLong(bookWrapper.book.getSourceId())));
        fVar.j();
    }

    @Override // wb.a
    public zb.a s(wb.f fVar, int i10, Chapter chapter, xb.g gVar) {
        return new e(this, fVar, chapter, i10, gVar, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // wb.a
    public void u(wb.f fVar, ChapterList chapterList, int i10, xb.e eVar) {
        YWChapter yWChapter = (YWChapter) chapterList.getItem(i10);
        c cVar = new c(this, fVar, yWChapter, i10, eVar, yWChapter);
        if (MiUserManager.q() != null && MiUserManager.q().f()) {
            ((YWChapterContentParams) cVar.k()).setAutoBuy(Boolean.valueOf(MiUserManager.q().v()));
            ((YWChapterContentParams) cVar.k()).setUid(MiUserManager.q().e().getUid());
            ((YWChapterContentParams) cVar.k()).setToken(MiUserManager.q().e().getToken());
        }
        ((YWChapterContentParams) cVar.k()).setCbid(fVar.getSourceId());
        if (yWChapter != null && yWChapter.getCcid() != null) {
            ((YWChapterContentParams) cVar.k()).setCcid(yWChapter.getCcid());
        }
        cVar.q();
    }

    @Override // wb.a
    public void x(Book book, int i10, xb.f fVar, boolean z10) {
        g(book, i10, fVar, z10);
    }

    public class e extends jc.i {

        /* renamed from: n */
        public final /* synthetic */ xb.g f26530n;

        /* renamed from: o */
        public final /* synthetic */ int f26531o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(wb.b bVar, wb.f fVar, Chapter chapter, int i10, xb.g gVar, int i11) {
            super(bVar, fVar, chapter, i10);
            this.f26530n = gVar;
            this.f26531o = i11;
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f26530n.a(this.f26531o, cVar);
        }

        @Override // y8.a
        /* renamed from: t */
        public void onDataReceived(YWChapterContent yWChapterContent) {
            this.f26530n.b(this.f26531o, yWChapterContent);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class f extends jc.d {

        /* renamed from: i */
        public final /* synthetic */ BookWrapper f26533i;

        /* renamed from: j */
        public final /* synthetic */ xb.a f26534j;

        /* renamed from: k */
        public final /* synthetic */ int f26535k;

        public f(BookWrapper bookWrapper, xb.a aVar, int i10) {
            this.f26533i = bookWrapper;
            this.f26534j = aVar;
            this.f26535k = i10;
        }

        @Override // jc.d, y8.b, y8.a
        /* renamed from: q */
        public boolean onPreDataReceived(YWBook yWBook) {
            YWBook yWBook2 = (YWBook) this.f26533i.book;
            if (a.this.k(yWBook)) {
                a.this.z(yWBook, yWBook2);
                if (!this.f26533i.hasUpdate()) {
                    this.f26533i.setHasUpdate(true);
                    a.this.G().T().J(this.f26533i);
                }
            } else if (yWBook != null && yWBook2 != null && !yWBook.getDistType().equals(yWBook2.getDistType())) {
                a.this.z(yWBook, yWBook2);
            }
            return super.onPreDataReceived(yWBook);
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(YWBook yWBook) {
            if (this.f26533i.hasUpdate()) {
                this.f26534j.a(this.f26535k);
            }
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class g extends jc.d {

        /* renamed from: i */
        public final /* synthetic */ BookWrapper f26537i;

        public g(BookWrapper bookWrapper) {
            this.f26537i = bookWrapper;
        }

        @Override // jc.d, y8.b, y8.a
        /* renamed from: q */
        public boolean onPreDataReceived(YWBook yWBook) {
            YWBook yWBook2 = (YWBook) this.f26537i.book;
            if (a.this.k(yWBook)) {
                a.this.z(yWBook, yWBook2);
                if (!this.f26537i.hasUpdate()) {
                    this.f26537i.setHasUpdate(true);
                    a.this.G().T().J(this.f26537i);
                }
            } else if (yWBook != null && yWBook2 != null && !yWBook.getDistType().equals(yWBook2.getDistType())) {
                a.this.z(yWBook, yWBook2);
            }
            return super.onPreDataReceived(yWBook);
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
        }

        @Override // y8.a
        /* renamed from: r */
        public void onDataReceived(YWBook yWBook) {
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class h extends jc.f {

        /* renamed from: k */
        public final /* synthetic */ xb.c f26539k;

        /* renamed from: l */
        public final /* synthetic */ YWBook f26540l;

        /* renamed from: m */
        public final /* synthetic */ YWChapter f26541m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Activity activity, xb.c cVar, YWBook yWBook, YWChapter yWChapter) {
            super(activity);
            this.f26539k = cVar;
            this.f26540l = yWBook;
            this.f26541m = yWChapter;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            if (cVar.c() == BookManager.f13986k) {
                this.f26539k.f();
            } else {
                this.f26539k.d(cVar.d());
            }
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(ChapterPrice chapterPrice) {
            a.this.b0(this.f26540l, this.f26541m);
            this.f26539k.b(1, chapterPrice == null ? 0 : chapterPrice.getPrice());
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class i extends jc.e {

        /* renamed from: k */
        public final /* synthetic */ xb.c f26543k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Activity activity, xb.c cVar) {
            super(activity);
            this.f26543k = cVar;
        }

        @Override // jb.k
        public void s(x8.c cVar) {
            if (cVar.c() == BookManager.f13986k) {
                this.f26543k.f();
            } else {
                this.f26543k.d(cVar.d());
            }
        }

        @Override // y8.a
        /* renamed from: v */
        public void onDataReceived(YWBookPrice yWBookPrice) {
            this.f26543k.b(1, yWBookPrice.getPrice());
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }
}
