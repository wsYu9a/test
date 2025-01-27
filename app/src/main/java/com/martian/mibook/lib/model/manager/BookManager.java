package com.martian.mibook.lib.model.manager;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.d.h;
import com.martian.libsupport.j;
import com.martian.libsupport.k;
import com.martian.mibook.lib.model.c.g;
import com.martian.mibook.lib.model.d.f;
import com.martian.mibook.lib.model.data.BookStoreCategories;
import com.martian.mibook.lib.model.data.BookSyncInfo;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.BookWrapperList;
import com.martian.mibook.lib.model.data.MiArchiveBookItem;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.mibook.lib.model.data.MiBookShelfItem;
import com.martian.mibook.lib.model.data.MiBookShelfItemList;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.MiCacheItem;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.MiReadingRecordList;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.e.e;
import com.martian.mibook.lib.model.e.i;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class BookManager {

    /* renamed from: a */
    public static int f14019a = -1000;

    /* renamed from: b */
    public static int f14020b = -1001;

    /* renamed from: c */
    public static int f14021c = 10000;

    /* renamed from: d */
    private static final String f14022d = "SUPPORT_ARCHIVE";

    /* renamed from: e */
    private static final String f14023e = "qplay_recent_books_json_file";

    /* renamed from: f */
    private final Context f14024f;

    /* renamed from: g */
    private final e f14025g = e.o();

    /* renamed from: h */
    private final i f14026h = i.d();

    /* renamed from: i */
    private Map<String, com.martian.mibook.lib.model.c.b> f14027i;

    /* renamed from: j */
    private final com.martian.mibook.lib.model.manager.b f14028j;
    private final c k;
    private final BookSyncManager l;
    protected MiReadingRecordList m;

    /* loaded from: classes3.dex */
    class a extends com.martian.mibook.lib.model.f.c {

        /* renamed from: j */
        final /* synthetic */ com.martian.mibook.lib.model.d.d f14029j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g source, ChapterList chapterList, int start, int size, com.martian.mibook.lib.model.c.b bookProvider, final com.martian.mibook.lib.model.d.d val$receiver) {
            super(source, chapterList, start, size, bookProvider);
            this.f14029j = val$receiver;
        }

        @Override // com.martian.mibook.lib.model.f.c
        public void k() {
            this.f14029j.a();
        }

        @Override // com.martian.mibook.lib.model.f.c
        public void l() {
            this.f14029j.c();
        }

        @Override // com.martian.mibook.lib.model.f.c
        public void m(Integer... values) {
            this.f14029j.e(values);
        }

        @Override // com.martian.mibook.lib.model.f.c
        public void n(int failedSize) {
            this.f14029j.d(failedSize);
        }

        @Override // com.martian.mibook.lib.model.f.c
        public void o() {
            this.f14029j.b();
        }

        @Override // com.martian.mibook.lib.model.f.c
        public void q(b.d.c.b.c errorResult) {
            this.f14029j.onResultError(errorResult);
        }
    }

    /* loaded from: classes3.dex */
    class b implements com.martian.mibook.lib.model.d.b {

        /* renamed from: a */
        final /* synthetic */ Activity f14030a;

        /* renamed from: b */
        final /* synthetic */ MiBookStoreItem f14031b;

        /* renamed from: c */
        final /* synthetic */ List f14032c;

        b(final Activity val$newBookWrappers, final MiBookStoreItem val$bookStoreItem, final List val$activity) {
            this.f14030a = val$newBookWrappers;
            this.f14031b = val$bookStoreItem;
            this.f14032c = val$activity;
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void a(Book book) {
            BookWrapper f2 = BookManager.this.f(this.f14030a, this.f14031b, book.buildMibook(), book);
            if (f2 != null) {
                this.f14032c.add(f2);
            }
            MiReadingRecord e2 = BookManager.this.k.e(book);
            if (e2 == null) {
                e2 = new MiReadingRecord();
            }
            e2.setContentIndex(this.f14031b.getReadingContentPos());
            e2.setContentSize(this.f14031b.getReadingContentLength());
            e2.setChapterIndex(this.f14031b.getReadingChapterIndex());
            e2.setBookName(book.getBookName());
            BookManager.this.k.k(e2, true);
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onLoading(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onResultError(b.d.c.b.c errorResult) {
        }
    }

    public BookManager(Context context) {
        this.f14024f = context;
        q0(context);
        this.f14028j = new com.martian.mibook.lib.model.manager.b(this);
        this.k = new c();
        this.l = new BookSyncManager(context);
        F0();
    }

    private void O0(List<BookWrapper> bookWrappers) {
        w();
        for (BookWrapper bookWrapper : bookWrappers) {
            if (bookWrapper.item != null) {
                u1(bookWrapper, false);
            }
        }
        Y();
    }

    private synchronized int i(int index, String tag) {
        List<BookWrapper> p = this.f14028j.p();
        if (p == null || p.size() <= 0) {
            return 800;
        }
        while (index < p.size()) {
            if (p.get(index).isSelect()) {
                BookWrapper e2 = this.f14028j.e(index, tag);
                if (e2 == null) {
                    return 1000;
                }
                if (e2.book != null) {
                    o1(e2);
                }
                return index;
            }
            index++;
        }
        return p.size();
    }

    private void l1(MiBookStoreItem bookStoreItem, MiBookShelfItem bookShelfItem) {
        bookStoreItem.setSourceString(bookShelfItem.getSourceString());
        if (bookShelfItem.getTop() != null) {
            bookStoreItem.setFlagTop(bookShelfItem.getTop().intValue() == 1);
        }
        if (bookShelfItem.getCidx() != null) {
            bookStoreItem.setReadingChapterIndex(bookShelfItem.getCidx());
        }
        if (bookShelfItem.getContentLength() != null) {
            bookStoreItem.setReadingContentLength(bookShelfItem.getContentLength());
        }
        if (bookShelfItem.getContentPosition() != null) {
            bookStoreItem.setReadingContentPos(bookShelfItem.getContentPosition());
        }
        if (bookShelfItem.getDate() == null || bookShelfItem.getDate().longValue() == 0) {
            bookStoreItem.setAddTime(Long.valueOf(System.currentTimeMillis()));
            bookStoreItem.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
        } else {
            bookStoreItem.setAddTime(bookShelfItem.getDate());
            bookStoreItem.setLastReadingTime(bookShelfItem.getDate());
        }
        bookStoreItem.setDirName(bookShelfItem.ca);
    }

    private synchronized BookWrapper m1(Book book, MiReadingRecord record) {
        return this.f14028j.N(book, record);
    }

    private void q0(Context context) {
        HashMap hashMap = new HashMap();
        this.f14027i = hashMap;
        L0(context, hashMap);
    }

    private boolean u0(g sourceProvider) {
        com.martian.mibook.lib.model.c.b a0 = a0(sourceProvider);
        return a0 != null && a0.H();
    }

    static /* synthetic */ int z0(MiReadingRecord lhs, MiReadingRecord rhs) {
        long lastReadingTime = rhs.getLastReadingTime() - lhs.getLastReadingTime();
        if (lastReadingTime == 0) {
            return 0;
        }
        return lastReadingTime > 0 ? 1 : -1;
    }

    public synchronized void A() {
    }

    public List<MiArchiveBookItem> A0() {
        return this.f14028j.v();
    }

    public boolean B(MiArchiveBookItem item) {
        if (!this.f14028j.j(item)) {
            return false;
        }
        if (!TextUtils.isEmpty(item.getSourceString())) {
            v(d.k(item.getSourceString()));
        }
        h1(item.getBookId());
        return true;
    }

    public List<MiArchiveBookItem> B0(String tag) {
        return this.f14028j.w(tag);
    }

    public boolean C(MiBookMark bookMark) {
        return this.k.b(bookMark);
    }

    public List<j.d> C0() {
        return this.f14028j.x();
    }

    public synchronized BookWrapper D(int index) {
        BookWrapper E;
        E = E(index, true);
        if (E != null) {
            o1(E);
        }
        return E;
    }

    public ChapterContent D0(g source, Chapter chapter) {
        return a0(source).w(source, chapter);
    }

    public synchronized BookWrapper E(int index, boolean clearCache) {
        BookWrapper k;
        k = this.f14028j.k(index);
        if (k != null) {
            Book book = k.book;
            if (book != null && clearCache) {
                v(book);
            }
            g1(k.mibook);
            o1(k);
        }
        return k;
    }

    public List<MiReadingRecord> E0(int page, int pageSize) {
        return this.k.h(page, pageSize);
    }

    public synchronized boolean F(MiBook mibook) {
        BookWrapper l = this.f14028j.l(mibook);
        if (l == null) {
            return false;
        }
        Book book = l.book;
        if (book != null) {
            v(book);
        }
        g1(l.mibook);
        o1(l);
        return true;
    }

    public MiReadingRecordList F0() {
        try {
            String B = com.martian.libsupport.e.B(this.f14024f, f14023e);
            if (!TextUtils.isEmpty(B)) {
                MiReadingRecordList miReadingRecordList = (MiReadingRecordList) GsonUtils.b().fromJson(B, MiReadingRecordList.class);
                this.m = miReadingRecordList;
                return miReadingRecordList;
            }
        } catch (IOException unused) {
        }
        MiReadingRecordList miReadingRecordList2 = new MiReadingRecordList();
        this.m = miReadingRecordList2;
        return miReadingRecordList2;
    }

    public synchronized void G(g sourceProvider) {
        this.f14026h.a(sourceProvider);
    }

    public synchronized void G0(BookWrapper bookWrapper, int position) {
        this.f14028j.A(bookWrapper.item, position);
        t1(bookWrapper);
    }

    public void H(g source) {
        a0(source).h(source);
    }

    public synchronized void H0(MiBookStoreItem item, int position) {
        this.f14028j.B(item, position);
    }

    public boolean I(g sourceProvider) {
        return this.k.c(sourceProvider);
    }

    public void I0() {
        this.k.i();
    }

    public synchronized List<BookWrapper> J(String bookNameKeyword) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = new ArrayList(e0()).iterator();
        while (it.hasNext()) {
            BookWrapper bookWrapper = (BookWrapper) it.next();
            if (bookWrapper != null && !bookWrapper.isAdsItem && !bookWrapper.isAdderItem && !k.o(bookWrapper.item.getDirName(), BookStoreCategories.SECRETE_CATEGORY) && (TextUtils.isEmpty(bookNameKeyword) || bookWrapper.getBookName().contains(bookNameKeyword))) {
                arrayList.add(bookWrapper);
            }
        }
        return arrayList;
    }

    public synchronized void J0(BookWrapperList bookWrapperList) {
        bookWrapperList.bookWrappers = e0();
        bookWrapperList.archiveBooks = A0();
    }

    public synchronized List<BookWrapper> K(String category, String bookNameKeyword, boolean holdAds) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = new ArrayList(e0()).iterator();
        while (it.hasNext()) {
            BookWrapper bookWrapper = (BookWrapper) it.next();
            if (bookWrapper != null) {
                if (!bookWrapper.isAdsItem && !bookWrapper.isAdderItem) {
                    String dirName = bookWrapper.item.getDirName();
                    if (k.p(dirName)) {
                        dirName = BookStoreCategories.BOOK_UNCATEGORIED;
                    }
                    if (k.n(dirName, category) && (TextUtils.isEmpty(bookNameKeyword) || bookWrapper.getBookName().contains(bookNameKeyword))) {
                        arrayList.add(bookWrapper);
                    }
                }
                if (holdAds) {
                    arrayList.add(bookWrapper);
                }
            }
        }
        return arrayList;
    }

    public Cursor K0(String sourceString) {
        return this.k.j(sourceString);
    }

    public synchronized List<BookWrapper> L(boolean pureFilter, boolean holdAds) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = new ArrayList(e0()).iterator();
        while (it.hasNext()) {
            BookWrapper bookWrapper = (BookWrapper) it.next();
            if (bookWrapper != null) {
                if (!bookWrapper.isAdsItem && !bookWrapper.isAdderItem) {
                    if (!k.o(bookWrapper.item.getDirName(), BookStoreCategories.SECRETE_CATEGORY)) {
                        arrayList.add(bookWrapper);
                    }
                }
                if (holdAds) {
                    arrayList.add(bookWrapper);
                }
            }
        }
        return arrayList;
    }

    protected abstract void L0(Context context, Map<String, com.martian.mibook.lib.model.c.b> bookProviders);

    public synchronized List<BookWrapper> M(String category, String bookNameKeyword, boolean holdAds) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = new ArrayList(e0()).iterator();
        while (it.hasNext()) {
            BookWrapper bookWrapper = (BookWrapper) it.next();
            if (bookWrapper != null) {
                if (!bookWrapper.isAdsItem && !bookWrapper.isAdderItem) {
                    if (!k.o(bookWrapper.item.getDirName(), BookStoreCategories.SECRETE_CATEGORY) && (bookWrapper.item.hasUpdate() || bookWrapper.isUpdateCategoryRading())) {
                        if (TextUtils.isEmpty(bookNameKeyword) || bookWrapper.getBookName().contains(bookNameKeyword)) {
                            arrayList.add(bookWrapper);
                        }
                    }
                }
                if (holdAds) {
                    arrayList.add(bookWrapper);
                }
            }
        }
        return arrayList;
    }

    public boolean M0(MiArchiveBookItem item) {
        return this.f14028j.j(item);
    }

    public Book N(MiBook mibook) {
        g k;
        if (k.p(mibook.getSourceString()) || (k = d.k(mibook.getSourceString())) == null) {
            return null;
        }
        return a0(k).j(k);
    }

    public void N0(MiReadingRecord readingRecord) {
        MiReadingRecordList miReadingRecordList;
        if (readingRecord == null || (miReadingRecordList = this.m) == null || miReadingRecordList.getMiReadingRecords().isEmpty()) {
            return;
        }
        Iterator<MiReadingRecord> it = this.m.getMiReadingRecords().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().getSourceString().equalsIgnoreCase(readingRecord.getSourceString())) {
                it.remove();
                break;
            }
        }
        X0();
    }

    public synchronized MiBookStoreItem O(String bookId) {
        return this.f14028j.m(bookId);
    }

    public synchronized BookWrapper P(String bookId) {
        return this.f14028j.r(bookId);
    }

    public synchronized boolean P0(List<MiArchiveBookItem> archiveBookItems) {
        return this.f14028j.D(archiveBookItems);
    }

    public MiBook Q(String bookId) {
        MiBook miBook = new MiBook();
        miBook.setBookId(bookId);
        if (this.f14025g.h(miBook)) {
            return miBook;
        }
        return null;
    }

    public synchronized boolean Q0(List<BookWrapper> bookWrappers) {
        boolean E;
        E = this.f14028j.E(bookWrappers);
        if (E) {
            O0(bookWrappers);
        }
        return E;
    }

    public Book R(MiBook mibook) {
        return T(mibook.getSourceString());
    }

    public void R0(g source, Chapter chapter, ChapterContent chapterContent) {
        a0(source).x(source, chapter, chapterContent);
    }

    public Book S(g sourceProvider) {
        return a0(sourceProvider).j(sourceProvider);
    }

    public void S0(Book book, ChapterList chapterList) {
        a0(book).n(book, chapterList);
        n1(book, chapterList);
    }

    public Book T(String sourceString) {
        g k;
        if (k.p(sourceString) || (k = d.k(sourceString)) == null) {
            return null;
        }
        return a0(k).j(k);
    }

    public void T0(MiBook book) {
        this.f14025g.f(book);
    }

    public MiReadingRecord U(MiBook mibook) {
        return this.k.d(mibook);
    }

    public long U0(List<MiBook> books) {
        return this.f14025g.g(books);
    }

    public MiReadingRecord V(g sourceProvider) {
        return this.k.e(sourceProvider);
    }

    public void V0(Book book, MiReadingRecord record) {
        this.k.k(record, true);
        BookWrapper m1 = m1(book, record);
        c(record);
        if (m1 != null) {
            t1(m1);
        }
    }

    public MiReadingRecord W(String sourceString) {
        return this.k.f(sourceString);
    }

    public void W0(MiReadingRecord record, boolean updateTime) {
        this.k.k(record, updateTime);
    }

    public MiReadingRecord X(String sourceName, String sourceId) {
        return this.k.g(sourceName, sourceId);
    }

    public void X0() {
        MiReadingRecordList miReadingRecordList = this.m;
        if (miReadingRecordList != null && miReadingRecordList.getMiReadingRecords() != null && this.m.getMiReadingRecords().size() > 50) {
            this.m.getMiReadingRecords().remove(50);
        }
        try {
            com.martian.libsupport.e.E(this.f14024f, f14023e, GsonUtils.b().toJson(this.m));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void Y() {
        try {
            this.l.b();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void Y0(boolean support) {
        h.F().v1(f14022d, support);
    }

    public synchronized BookStoreCategories Z() {
        return this.f14028j.o();
    }

    protected void Z0() {
        MiReadingRecordList miReadingRecordList = this.m;
        if (miReadingRecordList == null || miReadingRecordList.getMiReadingRecords() == null || this.m.getMiReadingRecords().isEmpty()) {
            return;
        }
        Collections.sort(this.m.getMiReadingRecords(), new Comparator() { // from class: com.martian.mibook.lib.model.manager.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BookManager.z0((MiReadingRecord) obj, (MiReadingRecord) obj2);
            }
        });
        X0();
    }

    public com.martian.mibook.lib.model.c.b a0(g source) {
        return b0(source.getSourceName());
    }

    public boolean a1() {
        return h.F().Y(f14022d, false) || this.f14028j.H();
    }

    public boolean b(MiBookMark bookMark) {
        return this.k.a(bookMark);
    }

    public com.martian.mibook.lib.model.c.b b0(String sourceName) {
        return this.f14027i.get(sourceName);
    }

    public void b1(MiBook mibook, Book oldBook, Book newBook) {
        mibook.setSourceString(newBook.getSourceString());
        T0(mibook);
        BookWrapper L = this.f14028j.L(mibook, newBook);
        if (L != null) {
            p1(null, oldBook.getSourceString());
            t1(L);
        }
    }

    public void c(MiReadingRecord record) {
        if (record == null || k.p(record.getSourceString())) {
            return;
        }
        if (this.m == null) {
            this.m = new MiReadingRecordList();
        }
        for (MiReadingRecord miReadingRecord : this.m.getMiReadingRecords()) {
            if (miReadingRecord != null && !k.p(miReadingRecord.getSourceString()) && miReadingRecord.getSourceString().equalsIgnoreCase(record.getSourceString())) {
                miReadingRecord.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
                miReadingRecord.setChapterTitle(record.getChapterTitle());
                this.m.getMiReadingRecords().remove(miReadingRecord);
                this.m.getMiReadingRecords().add(0, miReadingRecord);
                X0();
                return;
            }
        }
        this.m.getMiReadingRecords().add(0, record);
        X0();
    }

    public Map<String, com.martian.mibook.lib.model.c.b> c0() {
        return this.f14027i;
    }

    public abstract void c1(g source, final com.martian.mibook.lib.model.d.b receiver);

    public synchronized BookWrapper d(Activity activity, MiBook mibook, Book book) {
        BookWrapper b2;
        b2 = this.f14028j.b(activity, mibook, book);
        if (b2 != null) {
            t1(b2);
        }
        return b2;
    }

    public synchronized MiBookStoreItem d0(String filepath) {
        try {
            filepath = new File(filepath).getCanonicalPath();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return O(filepath);
    }

    public synchronized boolean d1(Activity activity, MiBookShelfItemList bookShelfItemList) {
        if (bookShelfItemList != null) {
            if (bookShelfItemList.getBookList() != null && !bookShelfItemList.getBookList().isEmpty()) {
                ArrayList arrayList = new ArrayList();
                HashMap hashMap = new HashMap();
                Iterator it = new ArrayList(e0()).iterator();
                while (it.hasNext()) {
                    BookWrapper bookWrapper = (BookWrapper) it.next();
                    if (bookWrapper != null && !bookWrapper.isAdsItem && !bookWrapper.isAdderItem) {
                        if (bookWrapper.book == null) {
                            arrayList.add(bookWrapper);
                        } else if (k.p(bookWrapper.mibook.getSourceString())) {
                            hashMap.put(bookWrapper.book.getSourceString(), bookWrapper);
                        } else {
                            hashMap.put(bookWrapper.mibook.getSourceString(), bookWrapper);
                        }
                    }
                }
                HashMap hashMap2 = new HashMap();
                for (MiBookShelfItem miBookShelfItem : bookShelfItemList.getBookList()) {
                    if (u0(d.k(miBookShelfItem.getSourceString()))) {
                        hashMap2.put(miBookShelfItem.getSourceString(), miBookShelfItem);
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    BookWrapper bookWrapper2 = (BookWrapper) entry.getValue();
                    MiBookShelfItem miBookShelfItem2 = (MiBookShelfItem) hashMap2.get(entry.getKey());
                    if (miBookShelfItem2 != null) {
                        l1(bookWrapper2.item, miBookShelfItem2);
                        this.f14028j.M(bookWrapper2.item);
                        arrayList.add(bookWrapper2);
                        hashMap2.remove(entry.getKey());
                    } else {
                        F(bookWrapper2.mibook);
                    }
                }
                for (Map.Entry entry2 : hashMap2.entrySet()) {
                    MiBookShelfItem miBookShelfItem3 = (MiBookShelfItem) entry2.getValue();
                    MiBookStoreItem miBookStoreItem = new MiBookStoreItem();
                    l1(miBookStoreItem, miBookShelfItem3);
                    c1(d.k((String) entry2.getKey()), new b(activity, miBookStoreItem, arrayList));
                }
                e0().clear();
                e0().addAll(arrayList);
                this.f14028j.C();
                w();
                return true;
            }
        }
        return true;
    }

    public synchronized BookWrapper e(Activity activity, MiBook mibook, Book book, Integer recommendTag) {
        BookWrapper c2;
        c2 = this.f14028j.c(activity, mibook, book, recommendTag);
        if (c2 != null) {
            t1(c2);
        }
        return c2;
    }

    public synchronized List<BookWrapper> e0() {
        return this.f14028j.p();
    }

    public void e1() {
    }

    public synchronized BookWrapper f(Activity activity, MiBookStoreItem item, MiBook mibook, Book book) {
        BookWrapper d2;
        d2 = this.f14028j.d(activity, item, mibook, book);
        if (d2 != null) {
            t1(d2);
        }
        return d2;
    }

    public String f0() {
        return this.l.f();
    }

    public void f1() {
        this.f14028j.J();
    }

    public synchronized boolean g(int index, String tag) {
        BookWrapper e2 = this.f14028j.e(index, tag);
        if (e2 == null) {
            return false;
        }
        if (e2.book != null) {
            o1(e2);
        }
        return true;
    }

    public BookWrapper g0(Book book) {
        return this.f14028j.q(book);
    }

    void g1(MiBook book) {
        book.setSourceString("");
        T0(book);
    }

    public synchronized boolean h(String tag) {
        List<BookWrapper> p = this.f14028j.p();
        if (p == null || p.size() <= 0) {
            return false;
        }
        int i2 = 0;
        while (i2 < p.size()) {
            i2 = i(i2, tag);
        }
        return i2 != 1000;
    }

    public long h0(Book book) {
        return a0(book).f(book);
    }

    void h1(String bookId) {
        MiBook Q;
        if (TextUtils.isEmpty(bookId) || (Q = Q(bookId)) == null) {
            return;
        }
        g1(Q);
    }

    public MiCacheItem i0(g book) {
        return j0(book.getSourceName(), book.getSourceId());
    }

    public boolean i1(Book newBook, Book book) {
        if (newBook.getSourceId().equals(book.getSourceId())) {
            return a0(book).z(newBook, book);
        }
        return false;
    }

    public void j(Activity activity, Book book, Chapter chapter, ChapterContent content, boolean prebuy, com.martian.mibook.lib.model.d.c receiver) {
        a0(book).C(activity, book, chapter, content, prebuy, receiver);
    }

    public MiCacheItem j0(String sourceName, String sourceId) {
        return this.f14026h.c(sourceName, sourceId);
    }

    public synchronized void j1(BookWrapper bookWrapper, String category) {
        this.f14028j.K(bookWrapper.item, category);
        t1(bookWrapper);
    }

    public abstract void k(final List<BookWrapper> bookWrappers, final com.martian.mibook.lib.model.d.a receiver);

    public MiReadingRecord k0() {
        if (this.m == null) {
            F0();
        }
        MiReadingRecordList miReadingRecordList = this.m;
        if (miReadingRecordList == null || miReadingRecordList.getMiReadingRecords() == null || this.m.getMiReadingRecords().isEmpty()) {
            return null;
        }
        return this.m.getMiReadingRecords().get(0);
    }

    public synchronized void k1(MiBookStoreItem item) {
        this.f14028j.M(item);
    }

    public void l(Book book, f receiver) {
        a0(book).g(book, receiver, true);
    }

    public synchronized MiReadingRecordList l0() {
        if (this.m == null) {
            F0();
        }
        return this.m;
    }

    public abstract void m(g source, final com.martian.mibook.lib.model.d.b receiver);

    public boolean m0(Book newbook) {
        return a0(newbook).i(newbook);
    }

    public void n(Book book, ChapterList chapterList, int index, com.martian.mibook.lib.model.d.e receiver) {
        a0(book).d(book, chapterList, index, receiver);
    }

    public boolean n0(Book newBook) {
        return a0(newBook).G(newBook);
    }

    public synchronized void n1(Book book, ChapterList chapterList) {
        this.f14028j.O(book, chapterList);
    }

    public void o(Book book, boolean localFailure, boolean fetchLocal, f receiver) {
        if (localFailure || (!h.F().O0() && p0(book))) {
            l(book, receiver);
        } else if (fetchLocal) {
            a0(book).A(book, receiver, true);
        }
    }

    public boolean o0(g sourceProvider, Chapter chapter) {
        return a0(sourceProvider).r(sourceProvider, chapter);
    }

    public void o1(BookWrapper bookWrapper) {
        p1(bookWrapper, "");
    }

    public void p(Book book, f receiver) {
        a0(book).A(book, receiver, false);
    }

    public boolean p0(Book newBook) {
        return a0(newBook).y(newBook);
    }

    public void p1(BookWrapper bookWrapper, String sourceString) {
        BookSyncInfo bookSyncInfo = new BookSyncInfo();
        if (k.p(sourceString)) {
            MiBook miBook = bookWrapper.mibook;
            if (miBook == null || k.p(miBook.getSourceString())) {
                Book book = bookWrapper.book;
                if (book != null) {
                    bookSyncInfo.ss = book.getSourceString();
                } else {
                    MiBookStoreItem miBookStoreItem = bookWrapper.item;
                    if (miBookStoreItem != null) {
                        bookSyncInfo.ss = miBookStoreItem.getSourceString();
                    }
                }
            } else {
                bookSyncInfo.ss = bookWrapper.mibook.getSourceString();
            }
        } else {
            bookSyncInfo.ss = sourceString;
        }
        bookSyncInfo.opt = Long.valueOf(System.currentTimeMillis());
        bookSyncInfo.op = BookSyncInfo.OP_DELETE;
        this.l.j(bookSyncInfo);
        Y();
    }

    public long q(Activity activity, List<Book> bookList) {
        return this.f14028j.f(activity, bookList);
    }

    public void q1(g source, Chapter chapter, int chapterIndex, int chapterSize) {
        r1(source.getSourceName(), source.getSourceId(), chapter, chapterIndex, chapterSize);
    }

    void r(MiBook mibook, Book book) {
        mibook.setSourceString(d.i(book));
        T0(mibook);
    }

    public synchronized void r0() {
        this.f14028j.t();
    }

    public void r1(String sourceName, String sourceId, Chapter chapter, int chapterIndex, int chapterSize) {
        MiCacheItem j0 = j0(sourceName, sourceId);
        if (j0 == null || j0.getChapterIndex().intValue() <= chapterIndex) {
            this.f14026h.insertOrUpdate((i) new MiCacheItem(sourceName, sourceId, Integer.valueOf(chapterIndex), Integer.valueOf(chapterSize), chapter.getTitle(), chapter.getSrcLink()));
        }
    }

    public Set<String> s() {
        return this.f14028j.g();
    }

    public void s0(Book book) {
        a0(book).e(book);
    }

    public boolean s1(Book newBook) {
        return a0(newBook).z(newBook, newBook);
    }

    public synchronized void t(BookWrapper bookWrapper, int position) {
        this.f14028j.h(bookWrapper.item, position);
        t1(bookWrapper);
    }

    public void t0(List<Book> bookList) {
        HashMap hashMap = new HashMap();
        for (Book book : bookList) {
            String sourceString = book.getSourceString();
            List list = (List) hashMap.get(sourceString);
            if (list == null) {
                list = new ArrayList();
                hashMap.put(sourceString, list);
            }
            list.add(book);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null) {
                g k = d.k((String) entry.getKey());
                k.getClass();
                a0(k).k((List) entry.getValue());
            }
        }
    }

    public void t1(BookWrapper bookWrapper) {
        u1(bookWrapper, true);
    }

    public synchronized void u() {
        this.f14028j.i();
    }

    public void u1(BookWrapper bookWrapper, boolean z) {
        MiBookStoreItem miBookStoreItem = bookWrapper.item;
        if (miBookStoreItem == null) {
            return;
        }
        BookSyncInfo bookSyncInfo = new BookSyncInfo();
        MiBook miBook = bookWrapper.mibook;
        if (miBook == null || k.p(miBook.getSourceString())) {
            Book book = bookWrapper.book;
            if (book != null) {
                bookSyncInfo.ss = book.getSourceString();
            } else {
                bookSyncInfo.ss = miBookStoreItem.getSourceString();
            }
        } else {
            bookSyncInfo.ss = bookWrapper.mibook.getSourceString();
        }
        Long lastReadingTime = miBookStoreItem.getLastReadingTime();
        bookSyncInfo.opt = lastReadingTime;
        if (lastReadingTime == null) {
            bookSyncInfo.opt = miBookStoreItem.getAddTime();
        }
        bookSyncInfo.cp = miBookStoreItem.getReadingContentPos();
        bookSyncInfo.cl = miBookStoreItem.getReadingContentLength();
        bookSyncInfo.cx = miBookStoreItem.getReadingChapterIndex();
        bookSyncInfo.op = BookSyncInfo.OP_UPDATE;
        bookSyncInfo.ca = miBookStoreItem.getDirName();
        bookSyncInfo.top = Integer.valueOf(miBookStoreItem.isFlagTop() ? 1 : 0);
        this.l.j(bookSyncInfo);
        if (z) {
            Y();
        }
    }

    public void v(g book) {
        x(book);
        H(book);
        G(book);
    }

    public synchronized boolean v0(MiBook mibook) {
        return this.f14028j.u(mibook == null ? "" : mibook.getBookId());
    }

    public void w() {
        this.l.a();
    }

    public synchronized boolean w0(String bookId) {
        return this.f14028j.u(bookId);
    }

    public void x(g sourceProvider) {
        a0(sourceProvider).a(sourceProvider);
    }

    public synchronized boolean x0(String filepath) {
        try {
            filepath = new File(filepath).getCanonicalPath();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return O(filepath) != null;
    }

    public void y() {
        this.m = new MiReadingRecordList();
        X0();
    }

    public synchronized boolean y0(String filepath) {
        try {
            filepath = new File(filepath).getCanonicalPath();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return O(filepath) != null;
    }

    public com.martian.mibook.lib.model.f.c z(g sourceProvider, ChapterList chapterList, int start, int size, final com.martian.mibook.lib.model.d.d receiver) {
        return new a(sourceProvider, chapterList, start, size, a0(sourceProvider), receiver);
    }
}
