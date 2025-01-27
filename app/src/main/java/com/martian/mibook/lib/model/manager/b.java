package com.martian.mibook.lib.model.manager;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bj;
import com.martian.libmars.d.h;
import com.martian.libmars.utils.k0;
import com.martian.libsupport.j;
import com.martian.libsupport.k;
import com.martian.mibook.lib.model.data.BookStoreCategories;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiArchiveBookItem;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.MiBookStoreItemLegency;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.e.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    public static final String[] f14039a = {"玄幻", "言情", "都市", "历史", "校园", "武侠", "科幻", "灵异", "耽美", "军事", "其他"};

    /* renamed from: b */
    private final g f14040b = g.o();

    /* renamed from: c */
    private final com.martian.mibook.lib.model.e.c f14041c = com.martian.mibook.lib.model.e.c.a();

    /* renamed from: d */
    private final BookManager f14042d;

    /* renamed from: e */
    private BookStoreCategories f14043e;

    /* renamed from: f */
    private List<BookWrapper> f14044f;

    /* renamed from: g */
    private Boolean f14045g;

    class a implements Comparator<BookWrapper> {
        a() {
        }

        private int b(MiBookStoreItem lhs, MiBookStoreItem rhs) {
            return lhs.isFlagTop() ? rhs.isFlagTop() ? 0 : -1 : rhs.isFlagTop() ? 1 : 0;
        }

        private int c(MiBookStoreItem lhs, MiBookStoreItem rhs) {
            return (rhs.get_id() != null ? rhs.get_id().intValue() : 0) - (lhs.get_id() == null ? 0 : lhs.get_id().intValue());
        }

        private int d(MiBookStoreItem lhs, MiBookStoreItem rhs) {
            return ((rhs.getLastReadingTime() != null ? rhs.getLastReadingTime().longValue() : 0L) > (lhs.getLastReadingTime() == null ? 0L : lhs.getLastReadingTime().longValue()) ? 1 : ((rhs.getLastReadingTime() != null ? rhs.getLastReadingTime().longValue() : 0L) == (lhs.getLastReadingTime() == null ? 0L : lhs.getLastReadingTime().longValue()) ? 0 : -1));
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(BookWrapper lhs, BookWrapper rhs) {
            int b2 = b(lhs.item, rhs.item);
            if (b2 == 0) {
                b2 = d(lhs.item, rhs.item);
            }
            return b2 == 0 ? c(lhs.item, rhs.item) : b2;
        }
    }

    public b(BookManager bookMgr) {
        this.f14042d = bookMgr;
    }

    private BookWrapper G(Activity activity, MiBookStoreItem item, MiBook mibook, Book book) {
        BookWrapper bookWrapper;
        t();
        long insert = this.f14040b.insert(item);
        if (insert == -2) {
            k0.d0(activity);
            return null;
        }
        int i2 = 0;
        if (insert != -1) {
            this.f14040b.h(item);
            while (i2 < this.f14044f.size() && ((bookWrapper = this.f14044f.get(i2)) == null || bookWrapper.isAdsItem || (!bookWrapper.isAdderItem && this.f14044f.get(i2).item.isFlagTop()))) {
                i2++;
            }
            BookWrapper bookWrapper2 = new BookWrapper(item, mibook, book);
            this.f14044f.add(i2, bookWrapper2);
            a(item.getDirName());
            return bookWrapper2;
        }
        if (!this.f14040b.update(item)) {
            return null;
        }
        this.f14040b.h(item);
        while (i2 < this.f14044f.size()) {
            BookWrapper bookWrapper3 = this.f14044f.get(i2);
            if (bookWrapper3 != null && !bookWrapper3.isAdsItem && !bookWrapper3.isAdderItem && bookWrapper3.item.getBookId().equals(item.getBookId())) {
                this.f14044f.remove(i2);
                BookWrapper bookWrapper4 = new BookWrapper(item, mibook, book);
                this.f14044f.add(i2, bookWrapper4);
                return bookWrapper4;
            }
            i2++;
        }
        return null;
    }

    private void a(String category) {
        if (this.f14043e == null) {
            this.f14043e = new BookStoreCategories();
        }
        this.f14043e.addBookCategories(category);
    }

    public static String[] s(int M) {
        int length = f14039a.length;
        String[] strArr = new String[M];
        int i2 = 0;
        for (int i3 = 0; i3 < length && i2 < M; i3++) {
            double random = Math.random();
            double d2 = length - i3;
            Double.isNaN(d2);
            if (random * d2 < M - i2) {
                strArr[i2] = f14039a[i3];
                i2++;
            }
        }
        return strArr;
    }

    private List<j.d> y() {
        return this.f14041c.groupCount("tag", false, null, null);
    }

    private void z(List<BookWrapper> bookWrapperList) {
        MiReadingRecord V;
        BookStoreCategories bookStoreCategories = this.f14043e;
        if (bookStoreCategories == null) {
            this.f14043e = new BookStoreCategories();
        } else {
            bookStoreCategories.clear();
        }
        ArrayList<MiBookStoreItem> arrayList = new ArrayList();
        this.f14040b.i(arrayList);
        for (MiBookStoreItem miBookStoreItem : arrayList) {
            if (miBookStoreItem.getChapterSize() == null || miBookStoreItem.getChapterSize().intValue() == 0) {
                miBookStoreItem.setChapterSize(-1);
            }
            MiBook Q = this.f14042d.Q(miBookStoreItem.getBookId());
            if (Q == null) {
                Q = miBookStoreItem.buildMibook();
            }
            if (miBookStoreItem.getBookName() == null) {
                miBookStoreItem.setBookName(Q.getBookName());
            }
            Book N = this.f14042d.N(Q);
            if (N != null) {
                N.setShortIntro(null);
                if ((!miBookStoreItem.isReaded() || miBookStoreItem.getReadingContentPos() == null) && (V = this.f14042d.V(N)) != null) {
                    miBookStoreItem.setReadingContentPos(V.getContentIndex());
                    miBookStoreItem.setReadingChapterIndex(Integer.valueOf(V.getChapterIndex()));
                    miBookStoreItem.setReadingContentLength(V.getContentSize());
                }
            }
            bookWrapperList.add(new BookWrapper(miBookStoreItem, Q, N));
            a(miBookStoreItem.getDirName());
        }
    }

    public boolean A(MiBookStoreItem item, int position) {
        BookWrapper bookWrapper = this.f14044f.get(position);
        int i2 = 0;
        if (bookWrapper.mibook != null && item.getBookId().equals(bookWrapper.mibook.getBookId())) {
            item.setFlagTop(true);
            if (this.f14040b.update(item)) {
                if (item.getLastReadingTime() == null || item.get_id() == null) {
                    this.f14040b.h(item);
                }
                if (item.getLastReadingTime() == null) {
                    item.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
                }
                this.f14044f.remove(position);
                while (i2 < this.f14044f.size()) {
                    BookWrapper bookWrapper2 = this.f14044f.get(i2);
                    if (bookWrapper2 != null && !bookWrapper2.isAdsItem) {
                        if (!bookWrapper2.isAdderItem) {
                            MiBookStoreItem miBookStoreItem = this.f14044f.get(i2).item;
                            if (miBookStoreItem.get_id() == null || miBookStoreItem.getLastReadingTime() == null) {
                                this.f14040b.h(miBookStoreItem);
                            }
                            if (miBookStoreItem.getLastReadingTime() == null) {
                                miBookStoreItem.setLastReadingTime(Long.valueOf(System.currentTimeMillis() - 10));
                            }
                            if (!miBookStoreItem.isFlagTop() || item.getLastReadingTime().longValue() > miBookStoreItem.getLastReadingTime().longValue() || item.get_id().intValue() > miBookStoreItem.get_id().intValue()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i2++;
                }
                this.f14044f.add(i2, bookWrapper);
                return true;
            }
        }
        return false;
    }

    public boolean B(MiBookStoreItem item, int position) {
        MiBookStoreItem miBookStoreItem;
        BookWrapper bookWrapper = this.f14044f.get(position);
        int i2 = 0;
        if (bookWrapper.mibook == null || !item.getBookId().equals(bookWrapper.mibook.getBookId()) || !this.f14040b.update(item)) {
            return false;
        }
        if (item.getLastReadingTime() == null || item.get_id() == null) {
            this.f14040b.h(item);
        }
        if (item.getChapterSize() != null && (miBookStoreItem = bookWrapper.item) != null && miBookStoreItem.isReaded() && bookWrapper.item.getLastReadingTime() != null && System.currentTimeMillis() - bookWrapper.item.getLastReadingTime().longValue() <= bj.f5599d) {
            if (item.getLastReadingTime() == null) {
                item.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
            }
            this.f14044f.remove(position);
            while (i2 < this.f14044f.size()) {
                BookWrapper bookWrapper2 = this.f14044f.get(i2);
                if (bookWrapper2 != null && !bookWrapper2.isAdsItem) {
                    if (bookWrapper2.isAdderItem) {
                        break;
                    }
                    MiBookStoreItem miBookStoreItem2 = this.f14044f.get(i2).item;
                    if (miBookStoreItem2.get_id() == null || miBookStoreItem2.getLastReadingTime() == null) {
                        this.f14040b.h(miBookStoreItem2);
                    }
                    if (miBookStoreItem2.getLastReadingTime() == null) {
                        miBookStoreItem2.setLastReadingTime(Long.valueOf(System.currentTimeMillis() - 10));
                    }
                    if (!miBookStoreItem2.isFlagTop()) {
                        break;
                    }
                }
                i2++;
            }
            this.f14044f.add(i2, bookWrapper);
        }
        return true;
    }

    public synchronized void C() {
        this.f14043e.clear();
        for (BookWrapper bookWrapper : p()) {
            if (bookWrapper != null && !bookWrapper.isAdsItem && !bookWrapper.isAdderItem) {
                a(bookWrapper.item.getDirName());
            }
        }
        Collections.sort(this.f14044f, new a());
    }

    public synchronized boolean D(List<MiArchiveBookItem> archiveBookItems) {
        if (archiveBookItems != null) {
            if (!archiveBookItems.isEmpty()) {
                this.f14041c.reset();
                return this.f14041c.insert((Collection) archiveBookItems) > 0;
            }
        }
        return false;
    }

    public synchronized boolean E(List<BookWrapper> bookWrappers) {
        if (bookWrappers != null) {
            if (!bookWrappers.isEmpty()) {
                this.f14040b.m();
                this.f14043e.clear();
                List<BookWrapper> list = this.f14044f;
                if (list == null) {
                    this.f14044f = bookWrappers;
                } else {
                    list.clear();
                    this.f14044f.addAll(bookWrappers);
                }
                for (BookWrapper bookWrapper : bookWrappers) {
                    if (bookWrapper != null && !bookWrapper.isAdderItem && !bookWrapper.isAdsItem) {
                        MiBook miBook = bookWrapper.mibook;
                        if (miBook != null) {
                            this.f14042d.T0(miBook);
                        }
                        Book book = bookWrapper.book;
                        if (book != null) {
                            this.f14042d.s0(book);
                            if (this.f14042d.V(bookWrapper.book) == null && bookWrapper.item.getLastReadingTime() != null && bookWrapper.item.isReaded() && bookWrapper.item.getReadingContentLength() != null && bookWrapper.item.getReadingContentPos() != null) {
                                MiReadingRecord miReadingRecord = new MiReadingRecord();
                                miReadingRecord.setChapterIndex(bookWrapper.item.getReadingChapterIndex());
                                miReadingRecord.setContentIndex(bookWrapper.item.getReadingContentPos());
                                miReadingRecord.setContentSize(bookWrapper.item.getReadingContentLength());
                                miReadingRecord.setSourceString(bookWrapper.item.getSourceString());
                                miReadingRecord.setBookName(bookWrapper.item.getBookName());
                                this.f14042d.W0(miReadingRecord, true);
                            }
                        }
                        this.f14040b.f(bookWrapper.item);
                        bookWrapper.resetTempInfo();
                        a(bookWrapper.item.getDirName());
                    }
                }
                return true;
            }
        }
        return false;
    }

    public synchronized void F() {
        List<BookWrapper> list = this.f14044f;
        if (list == null) {
            t();
        } else {
            list.clear();
            z(this.f14044f);
        }
    }

    public boolean H() {
        if (this.f14045g == null) {
            List<MiArchiveBookItem> v = v();
            this.f14045g = Boolean.valueOf((v == null || v.isEmpty()) ? false : true);
        }
        return this.f14045g.booleanValue();
    }

    public void I() {
        this.f14042d.e1();
        if (h.F().L0("migrate_old_book_store")) {
            LinkedList linkedList = new LinkedList();
            try {
                if (!com.martian.mibook.lib.model.e.h.a().load((Collection) linkedList) || linkedList.size() <= 0) {
                    return;
                }
                this.f14044f = new ArrayList();
                ListIterator listIterator = linkedList.listIterator(linkedList.size());
                int i2 = 0;
                while (listIterator.hasPrevious()) {
                    MiBookStoreItemLegency miBookStoreItemLegency = (MiBookStoreItemLegency) listIterator.previous();
                    i2++;
                    MiBookStoreItem miBookStoreItem = new MiBookStoreItem();
                    miBookStoreItem.setBookId(miBookStoreItemLegency.getBookId());
                    miBookStoreItem.setFlagTop(miBookStoreItemLegency.isFlagTop());
                    String sourceString = miBookStoreItemLegency.getSourceString();
                    miBookStoreItem.setSourceString(sourceString);
                    MiBook Q = this.f14042d.Q(miBookStoreItem.getBookId());
                    Book T = this.f14042d.T(sourceString);
                    if (Q != null || T != null) {
                        if (Q == null) {
                            Q = new MiBook();
                            Q.setBookId(T.getSourceId());
                            Q.setAuthorName(T.getAuthor());
                            Q.setBookName(T.getBookName());
                            Q.setUrl(T.getSourceUrl());
                        }
                        miBookStoreItem.setBookName(Q.getBookName());
                        long j2 = i2;
                        miBookStoreItem.setAddTime(Long.valueOf(System.currentTimeMillis() + j2));
                        miBookStoreItem.setAddFlag(1);
                        miBookStoreItem.setDeleteFlag(0);
                        miBookStoreItem.setLastReadingTime(Long.valueOf(System.currentTimeMillis() + j2));
                        if (T != null) {
                            T.setShortIntro(null);
                            miBookStoreItem.setCoverUrl(T.getCover());
                            miBookStoreItem.setChapterSize(-1);
                            MiReadingRecord V = this.f14042d.V(T);
                            if (V != null) {
                                miBookStoreItem.setReadingChapterIndex(Integer.valueOf(V.getChapterIndex()));
                                miBookStoreItem.setReadingContentPos(V.getContentIndex());
                                miBookStoreItem.setReadingContentLength(V.getContentSize());
                            }
                        }
                        this.f14040b.f(miBookStoreItem);
                        this.f14044f.add(new BookWrapper(miBookStoreItem, Q, T));
                        a(miBookStoreItem.getDirName());
                    }
                }
            } catch (Exception unused) {
                this.f14044f = null;
            }
        }
    }

    public void J() {
        MiBookStoreItem miBookStoreItem;
        try {
            t();
            int i2 = 0;
            Iterator<BookWrapper> it = this.f14044f.iterator();
            while (it.hasNext()) {
                BookWrapper next = it.next();
                if (next != null && !next.isAdsItem && !next.isAdderItem && (miBookStoreItem = next.item) != null && miBookStoreItem.isRecommendBook() && (i2 = i2 + 1) > 2) {
                    if (this.f14040b.delete(next.item)) {
                        it.remove();
                        this.f14043e.removeCategoryBook(next.item.getDirName());
                        return;
                    }
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    public void K(MiBookStoreItem item, String category) {
        this.f14043e.updateBookCategory(item, category);
        item.setDirName(category);
        M(item);
    }

    public BookWrapper L(MiBook mibook, Book book) {
        MiBook miBook;
        t();
        if (TextUtils.isEmpty(mibook.getSourceString())) {
            return null;
        }
        for (BookWrapper bookWrapper : this.f14044f) {
            if (bookWrapper != null && !bookWrapper.isAdderItem && !bookWrapper.isAdsItem && (miBook = bookWrapper.mibook) != null && miBook.getBookId().equals(mibook.getBookId())) {
                Book S = this.f14042d.S(book);
                Book book2 = bookWrapper.book;
                if (book2 == null || !book2.equals(S)) {
                    bookWrapper.book = S;
                    bookWrapper.item.setSourceString(mibook.getSourceString());
                    bookWrapper.mibook.setSourceString(mibook.getSourceString());
                    M(bookWrapper.item);
                    bookWrapper.resetTempInfo();
                }
                return bookWrapper;
            }
        }
        return null;
    }

    public boolean M(MiBookStoreItem item) {
        return this.f14040b.update(item);
    }

    public synchronized BookWrapper N(Book book, MiReadingRecord record) {
        BookWrapper bookWrapper;
        if (TextUtils.isEmpty(record.getSourceString())) {
            return null;
        }
        t();
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14044f.size(); i3++) {
            BookWrapper bookWrapper2 = this.f14044f.get(i3);
            if (bookWrapper2 != null && !bookWrapper2.isAdderItem && !bookWrapper2.isAdsItem && bookWrapper2.book.equals(book)) {
                bookWrapper2.item.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
                bookWrapper2.item.setReadingChapterIndex(Integer.valueOf(record.getChapterIndex()));
                bookWrapper2.item.setReadingContentLength(record.getContentSize());
                bookWrapper2.item.setReadingContentPos(record.getContentIndex());
                M(bookWrapper2.item);
                this.f14044f.remove(i3);
                if (bookWrapper2.item.isFlagTop()) {
                    BookWrapper bookWrapper3 = this.f14044f.get(0);
                    if (bookWrapper3 == null || !bookWrapper3.isAdsItem) {
                        this.f14044f.add(0, bookWrapper2);
                    } else {
                        this.f14044f.add(1, bookWrapper2);
                    }
                } else {
                    while (i2 < this.f14044f.size() && ((bookWrapper = this.f14044f.get(i2)) == null || bookWrapper.isAdsItem || (!bookWrapper.isAdderItem && this.f14044f.get(i2).item.isFlagTop()))) {
                        i2++;
                    }
                    this.f14044f.add(i2, bookWrapper2);
                }
                return bookWrapper2;
            }
        }
        return null;
    }

    public synchronized void O(Book book, ChapterList chapterList) {
        t();
        for (BookWrapper bookWrapper : this.f14044f) {
            Book book2 = bookWrapper.book;
            if (book2 != null && book.equals(book2)) {
                long count = chapterList.getCount();
                bookWrapper.cacheSize = count;
                bookWrapper.hasChapterUpdate = false;
                bookWrapper.item.setChapterSize(Integer.valueOf((int) count));
                M(bookWrapper.item);
                return;
            }
        }
    }

    public BookWrapper b(Activity activity, MiBook mibook, Book book) {
        return c(activity, mibook, book, null);
    }

    public BookWrapper c(Activity activity, MiBook mibook, Book book, Integer recommendTag) {
        MiBookStoreItem miBookStoreItem = new MiBookStoreItem();
        if (mibook != null) {
            miBookStoreItem.setBookId(mibook.getBookId());
            miBookStoreItem.setBookName(mibook.getBookName());
        }
        miBookStoreItem.setFlagTop(false);
        miBookStoreItem.setAddTime(Long.valueOf(System.currentTimeMillis()));
        miBookStoreItem.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
        miBookStoreItem.setAddFlag(1);
        miBookStoreItem.setDeleteFlag(0);
        miBookStoreItem.setHasUpdate(false);
        if (recommendTag != null) {
            miBookStoreItem.setReadingChapterIndex(recommendTag);
        }
        if (book != null) {
            miBookStoreItem.setDirName(book.getCategory());
            miBookStoreItem.setSourceString(d.i(book));
            miBookStoreItem.setCoverUrl(book.getCover());
            if (mibook != null) {
                this.f14042d.r(mibook, book);
            }
        }
        return G(activity, miBookStoreItem, mibook, book);
    }

    public BookWrapper d(Activity activity, MiBookStoreItem item, MiBook mibook, Book book) {
        if (mibook != null) {
            item.setBookId(mibook.getBookId());
            item.setBookName(mibook.getBookName());
        }
        item.setHasUpdate(false);
        item.setAddFlag(1);
        item.setDeleteFlag(0);
        if (book != null) {
            item.setSourceString(d.i(book));
            if (mibook != null) {
                this.f14042d.r(mibook, book);
            }
            item.setCoverUrl(book.getCover());
        }
        return G(activity, item, mibook, book);
    }

    public BookWrapper e(final int index, String tag) {
        BookWrapper bookWrapper = this.f14044f.get(index);
        MiArchiveBookItem miArchiveBookItem = new MiArchiveBookItem();
        MiBook miBook = bookWrapper.mibook;
        if (miBook != null) {
            miArchiveBookItem.setBookId(miBook.getBookId());
            miArchiveBookItem.setBookName(bookWrapper.mibook.getBookName());
            miArchiveBookItem.setBookUrl(bookWrapper.mibook.getUrl());
        }
        miArchiveBookItem.setArchiveDate(new Date());
        miArchiveBookItem.setTag(tag);
        Book book = bookWrapper.book;
        if (book != null) {
            miArchiveBookItem.setSourceString(d.i(book));
            miArchiveBookItem.setAuthor(bookWrapper.book.getAuthor());
            miArchiveBookItem.setCover(bookWrapper.book.getCover());
            miArchiveBookItem.setLastestChapter(bookWrapper.book.getLastChapter());
            miArchiveBookItem.setShortIntro(bookWrapper.book.getShortIntro());
        }
        if (this.f14041c.insertOrUpdate((com.martian.mibook.lib.model.e.c) miArchiveBookItem) != -1) {
            MiBookStoreItem miBookStoreItem = this.f14044f.get(index).item;
            this.f14044f.remove(index);
            miBookStoreItem.setSourceString(null);
            this.f14043e.removeCategoryBook(miBookStoreItem.getDirName());
            if (this.f14040b.delete(miBookStoreItem)) {
                return bookWrapper;
            }
        }
        return null;
    }

    public long f(Activity activity, List<Book> bookList) {
        ArrayList arrayList = new ArrayList();
        for (Book book : bookList) {
            MiBook buildMibook = book.buildMibook();
            MiBookStoreItem miBookStoreItem = new MiBookStoreItem();
            if (buildMibook != null) {
                miBookStoreItem.setBookId(buildMibook.getBookId());
            }
            miBookStoreItem.setFlagTop(false);
            miBookStoreItem.setAddTime(Long.valueOf(System.currentTimeMillis()));
            miBookStoreItem.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
            miBookStoreItem.setBookName(book.getBookName());
            miBookStoreItem.setAddFlag(1);
            miBookStoreItem.setDeleteFlag(0);
            miBookStoreItem.setHasUpdate(false);
            miBookStoreItem.setSourceString(d.i(book));
            miBookStoreItem.setCoverUrl(book.getCover());
            miBookStoreItem.setDirName(book.getCategory());
            if (book.isPromoteBook()) {
                miBookStoreItem.setReadingChapterIndex(Integer.valueOf(BookManager.f14020b));
            }
            arrayList.add(miBookStoreItem);
        }
        long g2 = this.f14040b.g(arrayList);
        if (g2 == -2) {
            k0.d0(activity);
        }
        F();
        return g2;
    }

    public Set<String> g() {
        HashSet hashSet = new HashSet();
        for (BookWrapper bookWrapper : p()) {
            MiBookStoreItem miBookStoreItem = bookWrapper.item;
            if (miBookStoreItem != null) {
                hashSet.add(miBookStoreItem.getSourceString());
            } else {
                Book book = bookWrapper.book;
                if (book != null) {
                    hashSet.add(book.getSourceString());
                } else {
                    MiBook miBook = bookWrapper.mibook;
                    if (miBook != null) {
                        hashSet.add(miBook.getSourceString());
                    }
                }
            }
        }
        return hashSet;
    }

    public boolean h(MiBookStoreItem item, int position) {
        BookWrapper bookWrapper = this.f14044f.get(position);
        int i2 = 0;
        if (bookWrapper.mibook != null && item.getBookId().equals(bookWrapper.mibook.getBookId())) {
            item.setFlagTop(false);
            if (this.f14040b.update(item)) {
                if (item.getLastReadingTime() == null) {
                    this.f14040b.h(item);
                }
                if (item.getLastReadingTime() == null) {
                    item.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
                }
                this.f14044f.remove(position);
                while (i2 < this.f14044f.size()) {
                    BookWrapper bookWrapper2 = this.f14044f.get(i2);
                    if (bookWrapper2 != null && !bookWrapper2.isAdsItem) {
                        if (!bookWrapper2.isAdderItem) {
                            MiBookStoreItem miBookStoreItem = this.f14044f.get(i2).item;
                            if (miBookStoreItem.getLastReadingTime() == null) {
                                this.f14040b.h(miBookStoreItem);
                            }
                            if (miBookStoreItem.getLastReadingTime() == null) {
                                miBookStoreItem.setLastReadingTime(Long.valueOf(System.currentTimeMillis() - 10));
                            }
                            if (!miBookStoreItem.isFlagTop() && item.getLastReadingTime().longValue() > miBookStoreItem.getLastReadingTime().longValue()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i2++;
                }
                this.f14044f.add(i2, bookWrapper);
                return true;
            }
        }
        return false;
    }

    public void i() {
        List<BookWrapper> list = this.f14044f;
        if (list != null) {
            Iterator<BookWrapper> it = list.iterator();
            while (it.hasNext()) {
                BookWrapper next = it.next();
                if (next == null || next.isAdderItem || next.isAdsItem) {
                    it.remove();
                }
            }
        }
    }

    public boolean j(MiArchiveBookItem item) {
        return this.f14041c.delete(item);
    }

    public BookWrapper k(int index) {
        t();
        if (index >= this.f14044f.size()) {
            return null;
        }
        BookWrapper bookWrapper = this.f14044f.get(index);
        if (!this.f14040b.delete(bookWrapper.item)) {
            return null;
        }
        this.f14044f.remove(index);
        this.f14043e.removeCategoryBook(bookWrapper.item.getDirName());
        return bookWrapper;
    }

    public BookWrapper l(MiBook mibook) {
        t();
        Iterator<BookWrapper> it = this.f14044f.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BookWrapper next = it.next();
            if (next != null && !next.isAdsItem && !next.isAdderItem && mibook != null && next.item.getBookId().equals(mibook.getBookId())) {
                if (this.f14040b.delete(next.item)) {
                    it.remove();
                    this.f14043e.removeCategoryBook(next.item.getDirName());
                    return next;
                }
            }
        }
        return null;
    }

    public MiBookStoreItem m(String bookId) {
        MiBookStoreItem miBookStoreItem = new MiBookStoreItem();
        miBookStoreItem.setBookId(bookId);
        if (this.f14040b.h(miBookStoreItem)) {
            return miBookStoreItem;
        }
        return null;
    }

    public synchronized BookWrapper n(String bookId) {
        Iterator it = new ArrayList(p()).iterator();
        while (it.hasNext()) {
            BookWrapper bookWrapper = (BookWrapper) it.next();
            if (bookWrapper.mibook != null && !k.p(bookId) && bookId.equals(bookWrapper.mibook.getBookId())) {
                return bookWrapper;
            }
        }
        return null;
    }

    public BookStoreCategories o() {
        t();
        return this.f14043e;
    }

    public List<BookWrapper> p() {
        t();
        return this.f14044f;
    }

    public BookWrapper q(Book book) {
        Book book2;
        t();
        for (BookWrapper bookWrapper : this.f14044f) {
            if (bookWrapper != null && !bookWrapper.isAdderItem && !bookWrapper.isAdsItem && (book2 = bookWrapper.book) != null && book2.equals(book)) {
                return bookWrapper;
            }
        }
        return null;
    }

    public BookWrapper r(String bookId) {
        MiBook miBook;
        t();
        for (BookWrapper bookWrapper : this.f14044f) {
            if (bookWrapper != null && !bookWrapper.isAdderItem && !bookWrapper.isAdsItem && (miBook = bookWrapper.mibook) != null && miBook.getBookId().equals(bookId)) {
                return bookWrapper;
            }
        }
        return null;
    }

    public synchronized void t() {
        if (this.f14044f == null) {
            ArrayList arrayList = new ArrayList();
            this.f14044f = arrayList;
            z(arrayList);
        }
    }

    public boolean u(String bookId) {
        return n(bookId) != null;
    }

    public List<MiArchiveBookItem> v() {
        ArrayList arrayList = new ArrayList();
        this.f14041c.load((Collection) arrayList);
        return arrayList;
    }

    public List<MiArchiveBookItem> w(String tag) {
        ArrayList arrayList = new ArrayList();
        this.f14041c.load(arrayList, 0, 0, "tag = ?", new String[]{tag});
        return arrayList;
    }

    public List<j.d> x() {
        List<j.d> y = y();
        if (y.size() > 0) {
            return y;
        }
        for (String str : s(6 - y.size())) {
            y.add(new j.d(str, 0L));
        }
        return y;
    }
}
