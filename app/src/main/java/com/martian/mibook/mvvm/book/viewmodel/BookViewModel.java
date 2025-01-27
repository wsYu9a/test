package com.martian.mibook.mvvm.book.viewmodel;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.response.TYChapterContent;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.mvvm.base.BaseViewModel;
import com.martian.mibook.mvvm.book.repository.BookRepository;
import com.martian.mibook.mvvm.book.viewmodel.BookViewModel;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.tts.service.BaseReadAloudService;
import com.umeng.analytics.pro.bt;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xb.f;
import xb.h;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0016\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001e\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\n¢\u0006\u0004\b \u0010\u0004R$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u00100\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00106\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010:\u001a\u00020\u00188F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00102\u001a\u0004\b8\u00103\"\u0004\b9\u00105R$\u0010B\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001f\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010;0C8\u0006¢\u0006\f\n\u0004\bG\u0010E\u001a\u0004\bH\u0010IR\u001c\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010L0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001f\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010L0K8\u0006¢\u0006\f\n\u0004\bP\u0010N\u001a\u0004\bQ\u0010RR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020)0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010NR\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020)0K8\u0006¢\u0006\f\n\u0004\bV\u0010N\u001a\u0004\bW\u0010RR\u001c\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Y0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010NR\u001f\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Y0K8\u0006¢\u0006\f\n\u0004\b \u0010N\u001a\u0004\b\\\u0010RR\"\u0010_\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010^0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010NR%\u0010a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010^0K8\u0006¢\u0006\f\n\u0004\b,\u0010N\u001a\u0004\b`\u0010RR\"\u0010b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010^0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010NR%\u0010d\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010^0K8\u0006¢\u0006\f\n\u0004\b\u0016\u0010N\u001a\u0004\bc\u0010R¨\u0006e"}, d2 = {"Lcom/martian/mibook/mvvm/book/viewmodel/BookViewModel;", "Lcom/martian/mibook/mvvm/base/BaseViewModel;", "Lcom/martian/mibook/mvvm/book/repository/BookRepository;", "<init>", "()V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "books", "", "excludeBookName", "", "R", "(Ljava/util/List;Ljava/lang/String;)V", "J", "()Lcom/martian/mibook/mvvm/book/repository/BookRepository;", "sourceId", "sourceName", "", "isAsync", "K", "(Ljava/lang/String;Ljava/lang/String;Z)V", "chapterId", "x", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "pageIndex", "pageSize", "G", "(II)V", "author", "u", "(Ljava/lang/String;Ljava/lang/String;)V", bt.aO, "Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;", "h", "Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;", IAdInterListener.AdReqParam.WIDTH, "()Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;", "N", "(Lcom/martian/mibook/mvvm/book/viewmodel/BookInfo;)V", "bookInfo", "Lcom/martian/mibook/lib/model/data/abs/Book;", "i", "Lcom/martian/mibook/lib/model/data/abs/Book;", "v", "()Lcom/martian/mibook/lib/model/data/abs/Book;", "M", "(Lcom/martian/mibook/lib/model/data/abs/Book;)V", "book", "j", "I", "()I", "Q", "(I)V", "seed", "k", "y", "O", BaseReadAloudService.f15168x, "Lcom/martian/mibook/lib/model/data/abs/ChapterList;", t.f11204d, "Lcom/martian/mibook/lib/model/data/abs/ChapterList;", bt.aJ, "()Lcom/martian/mibook/lib/model/data/abs/ChapterList;", "P", "(Lcom/martian/mibook/lib/model/data/abs/ChapterList;)V", "chapterList", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "m", "Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "_mAsyncChapterListLiveData", "n", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/martian/mibook/mvvm/tts/NonStickyLiveData;", "mAsyncChapterListLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "o", "Landroidx/lifecycle/MutableLiveData;", "_mLoadBookErrorLiveData", "p", "D", "()Landroidx/lifecycle/MutableLiveData;", "mLoadBookErrorLiveData", "q", "_mLoadBookLiveData", t.f11211k, ExifInterface.LONGITUDE_EAST, "mLoadBookLiveData", "Lcom/martian/mibook/lib/account/response/TYChapterContent;", "s", "_mChapterContentLiveData", "C", "mChapterContentLiveData", "", "_mRecommendBookListLiveData", "F", "mRecommendBookListLiveData", "_mAuthorBookListLiveData", "B", "mAuthorBookListLiveData", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBookViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BookViewModel.kt\ncom/martian/mibook/mvvm/book/viewmodel/BookViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,213:1\n1#2:214\n*E\n"})
/* loaded from: classes3.dex */
public final class BookViewModel extends BaseViewModel<BookRepository> {

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public BookInfo bookInfo;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public Book book;

    /* renamed from: j, reason: from kotlin metadata */
    public int seed;

    /* renamed from: k, reason: from kotlin metadata */
    public int com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String;

    /* renamed from: l */
    @l
    public ChapterList chapterList;

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ChapterList> _mAsyncChapterListLiveData;

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final NonStickyLiveData<ChapterList> mAsyncChapterListLiveData;

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> _mLoadBookErrorLiveData;

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public final MutableLiveData<ErrorResult> mLoadBookErrorLiveData;

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public final MutableLiveData<Book> _mLoadBookLiveData;

    /* renamed from: r */
    @k
    public final MutableLiveData<Book> mLoadBookLiveData;

    /* renamed from: s, reason: from kotlin metadata */
    @k
    public final MutableLiveData<TYChapterContent> _mChapterContentLiveData;

    /* renamed from: t */
    @k
    public final MutableLiveData<TYChapterContent> mChapterContentLiveData;

    /* renamed from: u, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> _mRecommendBookListLiveData;

    /* renamed from: v, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> mRecommendBookListLiveData;

    /* renamed from: w */
    @k
    public final MutableLiveData<List<TYBookItem>> _mAuthorBookListLiveData;

    /* renamed from: x, reason: from kotlin metadata */
    @k
    public final MutableLiveData<List<TYBookItem>> mAuthorBookListLiveData;

    public static final class a extends f {
        public a() {
        }

        @Override // xb.f
        public void a(boolean z10) {
        }

        @Override // xb.f
        public void b(int i10) {
        }

        @Override // xb.f
        public void c(@l ChapterList chapterList) {
            BookViewModel.this.P(chapterList);
            BookViewModel.this._mAsyncChapterListLiveData.postValue(chapterList);
        }

        @Override // xb.f
        public void d(@l x8.c cVar) {
            BookViewModel.this._mAsyncChapterListLiveData.postValue(null);
        }
    }

    public static final class b extends h {

        /* renamed from: b */
        public final /* synthetic */ String f14160b;

        public b(String str) {
            this.f14160b = str;
        }

        @Override // xb.h
        public void a(boolean z10) {
        }

        @Override // xb.h
        public void b(@l List<? extends TYBookItem> list) {
            super.b(list);
        }

        @Override // xb.h
        public void c(@l List<? extends TYBookItem> list) {
            List mutableList = list != null ? CollectionsKt.toMutableList((Collection) list) : null;
            BookViewModel bookViewModel = BookViewModel.this;
            String str = this.f14160b;
            Intrinsics.checkNotNull(str);
            bookViewModel.R(mutableList, str);
            BookViewModel.this._mAuthorBookListLiveData.postValue(mutableList);
        }

        @Override // xb.h
        public void d(@l x8.c cVar) {
            BookViewModel.this._mAuthorBookListLiveData.postValue(null);
        }
    }

    public static final class c implements xb.b {
        public c() {
        }

        @Override // xb.b
        @SuppressLint({"NullSafeMutableLiveData"})
        public void a(@l Book book) {
            Unit unit;
            if (book != null) {
                BookViewModel.this._mLoadBookLiveData.postValue(book);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                BookViewModel.this._mLoadBookErrorLiveData.postValue(new ErrorResult(-1, "信息获取失败", null, 4, null));
            }
        }

        @Override // xb.b
        public void onLoading(boolean z10) {
        }

        @Override // xb.b
        public void onResultError(@l x8.c cVar) {
            MutableLiveData mutableLiveData = BookViewModel.this._mLoadBookErrorLiveData;
            int c10 = cVar != null ? cVar.c() : -1;
            String d10 = cVar != null ? cVar.d() : null;
            if (d10 == null) {
                d10 = "信息获取失败";
            }
            mutableLiveData.postValue(new ErrorResult(c10, d10, null, 4, null));
        }
    }

    public BookViewModel() {
        NonStickyLiveData<ChapterList> nonStickyLiveData = new NonStickyLiveData<>();
        this._mAsyncChapterListLiveData = nonStickyLiveData;
        this.mAsyncChapterListLiveData = nonStickyLiveData;
        MutableLiveData<ErrorResult> mutableLiveData = new MutableLiveData<>();
        this._mLoadBookErrorLiveData = mutableLiveData;
        this.mLoadBookErrorLiveData = mutableLiveData;
        MutableLiveData<Book> mutableLiveData2 = new MutableLiveData<>();
        this._mLoadBookLiveData = mutableLiveData2;
        this.mLoadBookLiveData = mutableLiveData2;
        MutableLiveData<TYChapterContent> mutableLiveData3 = new MutableLiveData<>();
        this._mChapterContentLiveData = mutableLiveData3;
        this.mChapterContentLiveData = mutableLiveData3;
        MutableLiveData<List<TYBookItem>> mutableLiveData4 = new MutableLiveData<>();
        this._mRecommendBookListLiveData = mutableLiveData4;
        this.mRecommendBookListLiveData = mutableLiveData4;
        MutableLiveData<List<TYBookItem>> mutableLiveData5 = new MutableLiveData<>();
        this._mAuthorBookListLiveData = mutableLiveData5;
        this.mAuthorBookListLiveData = mutableLiveData5;
    }

    public static /* synthetic */ void H(BookViewModel bookViewModel, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 8;
        }
        bookViewModel.G(i10, i11);
    }

    public static /* synthetic */ void L(BookViewModel bookViewModel, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        bookViewModel.K(str, str2, z10);
    }

    public static final int S(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    @k
    public final NonStickyLiveData<ChapterList> A() {
        return this.mAsyncChapterListLiveData;
    }

    @k
    public final MutableLiveData<List<TYBookItem>> B() {
        return this.mAuthorBookListLiveData;
    }

    @k
    public final MutableLiveData<TYChapterContent> C() {
        return this.mChapterContentLiveData;
    }

    @k
    public final MutableLiveData<ErrorResult> D() {
        return this.mLoadBookErrorLiveData;
    }

    @k
    public final MutableLiveData<Book> E() {
        return this.mLoadBookLiveData;
    }

    @k
    public final MutableLiveData<List<TYBookItem>> F() {
        return this.mRecommendBookListLiveData;
    }

    public final void G(int pageIndex, int pageSize) {
        j(new BookViewModel$getRecommendBookList$1(pageIndex, pageSize, this, null), new BookViewModel$getRecommendBookList$2(this, null), false);
    }

    /* renamed from: I, reason: from getter */
    public final int getSeed() {
        return this.seed;
    }

    @Override // com.martian.mibook.mvvm.base.BaseViewModel
    @k
    /* renamed from: J */
    public BookRepository i() {
        return new BookRepository();
    }

    public final void K(@l String sourceId, @l String sourceName, boolean isAsync) {
        if (sourceId == null || sourceId.length() == 0 || sourceName == null || sourceName.length() == 0) {
            MutableLiveData<ErrorResult> mutableLiveData = this._mLoadBookErrorLiveData;
            ErrorResult errorResult = new ErrorResult(-1, "信息获取失败", null, 4, null);
            errorResult.setObj(Boolean.TRUE);
            mutableLiveData.postValue(errorResult);
            return;
        }
        Unit unit = null;
        Book I = !isAsync ? MiConfigSingleton.b2().M1().I(new Source(sourceName, sourceId)) : null;
        if (I != null) {
            this._mLoadBookLiveData.postValue(I);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            MiConfigSingleton.b2().M1().k(new Source(sourceName, sourceId), new c());
        }
    }

    public final void M(@l Book book) {
        this.book = book;
    }

    public final void N(@l BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public final void O(int i10) {
        this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String = i10;
    }

    public final void P(@l ChapterList chapterList) {
        this.chapterList = chapterList;
    }

    public final void Q(int i10) {
        this.seed = i10;
    }

    public final void R(List<TYBookItem> books, String excludeBookName) {
        List<TYBookItem> list = books;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<TYBookItem> it = books.iterator();
        while (it.hasNext()) {
            if (it.next().getBookName() == null) {
                it.remove();
            }
        }
        CollectionsKt.sortWith(books, new Comparator() { // from class: pc.a
            public /* synthetic */ a() {
            }

            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int S;
                S = BookViewModel.S(Function2.this, obj, obj2);
                return S;
            }
        });
        Iterator<TYBookItem> it2 = books.iterator();
        String str = "";
        while (it2.hasNext()) {
            String bookName = it2.next().getBookName();
            if (Intrinsics.areEqual(bookName, excludeBookName)) {
                it2.remove();
            } else if (Intrinsics.areEqual(bookName, str)) {
                it2.remove();
            } else {
                Intrinsics.checkNotNull(bookName);
                str = bookName;
            }
        }
    }

    public final void t() {
        if (this.book == null) {
            this._mAsyncChapterListLiveData.postValue(null);
        } else {
            MiConfigSingleton.b2().M1().m(this.book, 0, true, false, new a());
        }
    }

    public final void u(@l String author, @l String excludeBookName) {
        if (TextUtils.isEmpty(author) || TextUtils.isEmpty(excludeBookName)) {
            return;
        }
        MiBookManager M1 = MiConfigSingleton.b2().M1();
        b bVar = new b(excludeBookName);
        BookInfo bookInfo = this.bookInfo;
        String sourceName = bookInfo != null ? bookInfo.getSourceName() : null;
        BookInfo bookInfo2 = this.bookInfo;
        M1.k1(author, 0, bVar, sourceName, bookInfo2 != null ? bookInfo2.getSourceId() : null);
    }

    @l
    /* renamed from: v, reason: from getter */
    public final Book getBook() {
        return this.book;
    }

    @l
    /* renamed from: w, reason: from getter */
    public final BookInfo getBookInfo() {
        return this.bookInfo;
    }

    public final void x(@l String sourceName, @l String sourceId, @l String chapterId) {
        if (sourceId == null || sourceId.length() == 0 || sourceName == null || sourceName.length() == 0) {
            return;
        }
        BaseViewModel.k(this, new BookViewModel$getChapterContent$1(this, sourceName, sourceId, chapterId, null), new BookViewModel$getChapterContent$2(this, null), false, 4, null);
    }

    public final int y() {
        ChapterList chapterList = this.chapterList;
        int count = chapterList != null ? chapterList.getCount() : 0;
        if (this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String >= count) {
            this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String = count - 1;
        }
        if (this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String < 0) {
            this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String = 0;
        }
        return this.com.martian.mibook.mvvm.tts.service.BaseReadAloudService.x java.lang.String;
    }

    @l
    /* renamed from: z, reason: from getter */
    public final ChapterList getChapterList() {
        return this.chapterList;
    }
}
