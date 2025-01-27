package com.martian.mibook.lib.model.manager;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import ba.g;
import ba.j;
import ba.k;
import ba.l;
import com.google.gson.JsonSyntaxException;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.model.data.BookSyncInfo;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.BookrackCategoryManager;
import com.martian.mibook.lib.model.data.MiArchiveBookItem;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.mibook.lib.model.data.MiBookShelfItem;
import com.martian.mibook.lib.model.data.MiBookShelfItemList;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.MiCacheItem;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.MiReadingRecordList;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.manager.BookManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import l9.p0;
import vb.e;
import wb.f;
import x8.m;
import yb.h;

/* loaded from: classes3.dex */
public abstract class BookManager {

    /* renamed from: i */
    public static int f13984i = -1000;

    /* renamed from: j */
    public static int f13985j = -1001;

    /* renamed from: k */
    public static int f13986k = 10000;

    /* renamed from: l */
    public static final String f13987l = "PREF_LAST_SYNC_TIME";

    /* renamed from: m */
    public static final String f13988m = "SUPPORT_ARCHIVE";

    /* renamed from: n */
    public static final String f13989n = "qplay_recent_books_json_file";

    /* renamed from: a */
    public final Context f13990a;

    /* renamed from: b */
    public final h f13991b = h.N();

    /* renamed from: c */
    public Map<String, wb.b> f13992c;

    /* renamed from: d */
    public vb.c f13993d;

    /* renamed from: e */
    public final vb.d f13994e;

    /* renamed from: f */
    public final BookSyncManager f13995f;

    /* renamed from: g */
    public final vb.b f13996g;

    /* renamed from: h */
    public MiReadingRecordList f13997h;

    public class a extends zb.c {

        /* renamed from: j */
        public final /* synthetic */ xb.d f13998j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, ChapterList chapterList, int i10, int i11, wb.b bVar, xb.d dVar) {
            super(fVar, chapterList, i10, i11, bVar);
            this.f13998j = dVar;
        }

        @Override // zb.c
        public void k() {
            this.f13998j.a();
        }

        @Override // zb.c
        public void l() {
            this.f13998j.c();
        }

        @Override // zb.c
        public void m(Integer... numArr) {
            this.f13998j.e(numArr);
        }

        @Override // zb.c
        public void n(int i10) {
            this.f13998j.d(i10);
        }

        @Override // zb.c
        public void o() {
            this.f13998j.b();
        }

        @Override // zb.c
        public void q(x8.c cVar) {
            this.f13998j.onResultError(cVar);
        }
    }

    public class b extends y8.f<Void, Void> {

        /* renamed from: a */
        public final /* synthetic */ d f14000a;

        public b(d dVar) {
            this.f14000a = dVar;
        }

        @Override // y8.f
        /* renamed from: f */
        public Void doInBackground(Void... voidArr) {
            BookManager.this.f13993d.j();
            return null;
        }

        @Override // y8.f
        /* renamed from: g */
        public void onPostExecute(Void r12) {
            super.onPostExecute(r12);
            this.f14000a.a();
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class c extends y8.f<Void, Void> {

        /* renamed from: a */
        public final /* synthetic */ String f14002a;

        /* renamed from: b */
        public final /* synthetic */ d f14003b;

        public c(String str, d dVar) {
            this.f14002a = str;
            this.f14003b = dVar;
        }

        @Override // y8.f
        /* renamed from: f */
        public Void doInBackground(Void... voidArr) {
            BookManager.this.T().d(this.f14002a);
            return null;
        }

        @Override // y8.f
        /* renamed from: g */
        public void onPostExecute(Void r12) {
            super.onPostExecute(r12);
            this.f14003b.a();
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public interface d {
        void a();
    }

    public BookManager(Context context) {
        this.f13990a = context;
        e0(context);
        this.f13994e = new vb.d();
        this.f13995f = new BookSyncManager(context);
        this.f13996g = new vb.b();
        r0();
    }

    public static /* synthetic */ int l0(MiReadingRecord miReadingRecord, MiReadingRecord miReadingRecord2) {
        long lastReadingTime = miReadingRecord2.getLastReadingTime() - miReadingRecord.getLastReadingTime();
        if (lastReadingTime == 0) {
            return 0;
        }
        return lastReadingTime > 0 ? 1 : -1;
    }

    public synchronized List<BookWrapper> A(String str) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = new ArrayList(S()).iterator();
            while (it.hasNext()) {
                BookWrapper bookWrapper = (BookWrapper) it.next();
                if (bookWrapper != null) {
                    if (!bookWrapper.notBookItem()) {
                        if (!BookrackCategoryManager.SECRETE_CATEGORY.equalsIgnoreCase(bookWrapper.item.getDirName())) {
                            if (!l.q(str) && !bookWrapper.getBookName().contains(str)) {
                            }
                            arrayList.add(bookWrapper);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return arrayList;
    }

    public synchronized void A0(List<BookWrapper> list) {
        if (T().G(list)) {
            y0(list);
        }
    }

    public synchronized List<BookWrapper> B(String str, String str2) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = new ArrayList(S()).iterator();
            while (it.hasNext()) {
                BookWrapper bookWrapper = (BookWrapper) it.next();
                if (bookWrapper != null) {
                    if (bookWrapper.notBookItem()) {
                        arrayList.add(bookWrapper);
                    } else if (l.o(bookWrapper.item.getDirName(), str) && (TextUtils.isEmpty(str2) || bookWrapper.getBookName().contains(str2))) {
                        arrayList.add(bookWrapper);
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return arrayList;
    }

    public void B0(Book book, ChapterList chapterList) {
        O(book).q(book, chapterList);
        T().L(book, chapterList);
    }

    public synchronized List<BookWrapper> C(boolean z10) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = new ArrayList(S()).iterator();
            while (it.hasNext()) {
                BookWrapper bookWrapper = (BookWrapper) it.next();
                if (bookWrapper != null) {
                    if (bookWrapper.notBookItem()) {
                        if (z10) {
                            arrayList.add(bookWrapper);
                        }
                    } else if (!BookrackCategoryManager.SECRETE_CATEGORY.equalsIgnoreCase(bookWrapper.item.getDirName())) {
                        arrayList.add(bookWrapper);
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return arrayList;
    }

    public void C0(Book book, MiReadingRecord miReadingRecord) {
        miReadingRecord.setCover(book.getCover());
        this.f13994e.h(miReadingRecord, true);
        T().K(book, miReadingRecord);
        e(miReadingRecord);
    }

    public Book D(String str) {
        if (l.q(str)) {
            return null;
        }
        return E(e.l(str));
    }

    public void D0(MiReadingRecord miReadingRecord, boolean z10) {
        this.f13994e.h(miReadingRecord, z10);
    }

    public Book E(f fVar) {
        wb.b O = O(fVar);
        if (O != null) {
            return O.m(fVar);
        }
        return null;
    }

    public void E0() {
        MiReadingRecordList miReadingRecordList = this.f13997h;
        if (miReadingRecordList != null && miReadingRecordList.getMiReadingRecords() != null && this.f13997h.getMiReadingRecords().size() > 50) {
            this.f13997h.getMiReadingRecords().remove(50);
        }
        try {
            g.F(this.f13990a, f13989n, GsonUtils.b().toJson(this.f13997h));
        } catch (IOException e10) {
            p0.b(e10.getMessage());
        }
    }

    public synchronized MiBookStoreItem F(String str, String str2) {
        return T().k(str, str2);
    }

    public void F0(boolean z10) {
        ConfigSingleton.D().g1(f13988m, z10);
    }

    public synchronized BookWrapper G(String str) {
        return T().o(str);
    }

    public void G0() {
        MiReadingRecordList miReadingRecordList = this.f13997h;
        if (miReadingRecordList == null || miReadingRecordList.getMiReadingRecords() == null || this.f13997h.getMiReadingRecords().isEmpty()) {
            return;
        }
        Collections.sort(this.f13997h.getMiReadingRecords(), new Comparator() { // from class: vb.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int l02;
                l02 = BookManager.l0((MiReadingRecord) obj, (MiReadingRecord) obj2);
                return l02;
            }
        });
        E0();
    }

    public Book H(String str) {
        f l10;
        if (l.q(str) || (l10 = e.l(str)) == null) {
            return null;
        }
        return O(l10).m(l10);
    }

    public boolean H0() {
        return ConfigSingleton.D().Q(f13988m, false) || T().H();
    }

    public Book I(f fVar) {
        wb.b O = O(fVar);
        if (O == null) {
            return null;
        }
        return O.m(fVar);
    }

    public abstract m<TYBookItem> I0(List<String> list);

    public MiReadingRecord J(String str) {
        return this.f13994e.b(str);
    }

    public synchronized boolean J0(Activity activity, MiBookShelfItemList miBookShelfItemList) {
        if (miBookShelfItemList != null) {
            try {
                if (miBookShelfItemList.getBookList() != null && !miBookShelfItemList.getBookList().isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    HashMap hashMap = new HashMap();
                    Iterator it = new ArrayList(S()).iterator();
                    while (it.hasNext()) {
                        BookWrapper bookWrapper = (BookWrapper) it.next();
                        if (bookWrapper != null && bookWrapper.book != null && !bookWrapper.isAdItem()) {
                            hashMap.put(bookWrapper.book.getSourceString(), bookWrapper);
                        }
                    }
                    HashMap hashMap2 = new HashMap();
                    for (MiBookShelfItem miBookShelfItem : miBookShelfItemList.getBookList()) {
                        if (h0(e.l(miBookShelfItem.getSourceString()))) {
                            hashMap2.put(miBookShelfItem.getSourceString(), miBookShelfItem);
                        }
                    }
                    for (Map.Entry entry : hashMap.entrySet()) {
                        BookWrapper bookWrapper2 = (BookWrapper) entry.getValue();
                        MiBookShelfItem miBookShelfItem2 = (MiBookShelfItem) hashMap2.get(entry.getKey());
                        if (miBookShelfItem2 != null) {
                            if (K0(bookWrapper2.item, miBookShelfItem2)) {
                                T().J(bookWrapper2);
                                MiReadingRecord d10 = this.f13994e.d(bookWrapper2.book);
                                if (d10 != null) {
                                    d10.setContentPos(bookWrapper2.item.getReadingContentPos());
                                    d10.setContentLength(bookWrapper2.item.getReadingContentLength());
                                    d10.setChapterIndex(bookWrapper2.item.getReadingChapterIndex());
                                    d10.setBookName(bookWrapper2.book.getBookName());
                                    this.f13994e.h(d10, true);
                                }
                            }
                            arrayList.add(bookWrapper2);
                            hashMap2.remove(entry.getKey());
                        } else if (bookWrapper2.item.isReaded()) {
                            arrayList.add(bookWrapper2);
                        } else {
                            x(bookWrapper2);
                        }
                    }
                    if (!hashMap2.isEmpty()) {
                        m<TYBookItem> I0 = I0(new ArrayList(hashMap2.keySet()));
                        if ((I0.k() && I0.e() != -100003) || I0.h() == null) {
                            return false;
                        }
                        for (TYBookItem tYBookItem : I0.h()) {
                            MiBookShelfItem miBookShelfItem3 = (MiBookShelfItem) hashMap2.get(tYBookItem.getSourceString());
                            if (miBookShelfItem3 != null) {
                                MiBookStoreItem miBookStoreItem = new MiBookStoreItem();
                                K0(miBookStoreItem, miBookShelfItem3);
                                BookWrapper f10 = f(activity, miBookStoreItem, tYBookItem);
                                if (f10 != null) {
                                    arrayList.add(f10);
                                }
                            }
                        }
                    }
                    S().clear();
                    S().addAll(arrayList);
                    T().E();
                    T().D();
                    BookWrapper bookWrapper3 = new BookWrapper(null, null);
                    bookWrapper3.setType(BookWrapper.Type.ADDER);
                    S().add(bookWrapper3);
                    r();
                    return true;
                }
            } finally {
            }
        }
        return true;
    }

    public MiReadingRecord K(f fVar) {
        return this.f13994e.d(fVar);
    }

    public final boolean K0(MiBookStoreItem miBookStoreItem, MiBookShelfItem miBookShelfItem) {
        boolean z10;
        miBookStoreItem.setSourceString(miBookShelfItem.getSourceString());
        f l10 = e.l(miBookShelfItem.getSourceString());
        if (l10 == null) {
            return false;
        }
        String b10 = e.b(l10);
        if (b10.equals(miBookStoreItem.getBookId())) {
            z10 = false;
        } else {
            miBookStoreItem.setBookId(b10);
            z10 = true;
        }
        if (miBookShelfItem.getTop() != null) {
            boolean z11 = miBookShelfItem.getTop().intValue() == 1;
            if (miBookStoreItem.isFlagTop() != z11) {
                miBookStoreItem.setFlagTop(z11);
                z10 = true;
            }
        }
        if (miBookStoreItem.getRawFlagTop() == null) {
            miBookStoreItem.setFlagTop(false);
        }
        if (miBookShelfItem.getCidx() != null && !miBookShelfItem.getCidx().equals(miBookStoreItem.getReadingChapterIndex())) {
            miBookStoreItem.setReadingChapterIndex(miBookShelfItem.getCidx());
            z10 = true;
        }
        if (miBookShelfItem.getContentLength() != null && !miBookShelfItem.getContentLength().equals(miBookStoreItem.getReadingContentLength())) {
            miBookStoreItem.setReadingContentLength(miBookShelfItem.getContentLength());
            z10 = true;
        }
        if (miBookShelfItem.getContentPosition() != null && !miBookShelfItem.getContentPosition().equals(miBookStoreItem.getReadingContentPos())) {
            miBookStoreItem.setReadingContentPos(miBookShelfItem.getContentPosition());
            z10 = true;
        }
        if (miBookShelfItem.getDate() == null || miBookShelfItem.getDate().longValue() == 0) {
            if (miBookStoreItem.getAddTime() == null) {
                miBookStoreItem.setAddTime(Long.valueOf(System.currentTimeMillis()));
                z10 = true;
            }
            if (miBookStoreItem.getLastReadingTime() == null) {
                miBookStoreItem.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
                z10 = true;
            }
        } else {
            if (miBookStoreItem.getAddTime() == null) {
                miBookStoreItem.setAddTime(miBookShelfItem.getDate());
            }
            if (miBookStoreItem.getLastReadingTime() == null || miBookStoreItem.getLastReadingTime().longValue() < miBookShelfItem.getDate().longValue()) {
                miBookStoreItem.setLastReadingTime(miBookShelfItem.getDate());
                z10 = true;
            }
        }
        if (l.q(miBookShelfItem.f13983ca) || miBookShelfItem.f13983ca.equals(miBookStoreItem.getDirName())) {
            return z10;
        }
        miBookStoreItem.setDirName(miBookShelfItem.f13983ca);
        return true;
    }

    public void L() {
        try {
            this.f13995f.b();
        } catch (Exception unused) {
        }
    }

    public void L0(BookWrapper bookWrapper) {
        BookSyncInfo bookSyncInfo = new BookSyncInfo();
        Book book = bookWrapper.book;
        if (book != null) {
            bookSyncInfo.setSourceString(book.getSourceString());
        } else {
            MiBookStoreItem miBookStoreItem = bookWrapper.item;
            if (miBookStoreItem != null) {
                bookSyncInfo.setSourceString(miBookStoreItem.getSourceString());
            }
        }
        bookSyncInfo.setOpt(Long.valueOf(System.currentTimeMillis()));
        bookSyncInfo.setOp(BookSyncInfo.OP_DELETE.intValue());
        this.f13995f.h(bookSyncInfo);
        L();
    }

    public List<MiBookMark> M(String str) {
        return this.f13996g.c(str, null);
    }

    public void M0() {
        j.n(this.f13990a, f13987l, System.currentTimeMillis());
    }

    public wb.b N(String str) {
        return this.f13992c.get(str);
    }

    public void N0(String str, String str2, Chapter chapter, int i10, int i11) {
        MiCacheItem Y = Y(str, str2);
        if (Y == null || Y.getChapterIndex().intValue() <= i10) {
            this.f13991b.q(new MiCacheItem(str, str2, Integer.valueOf(i10), Integer.valueOf(i11), chapter.getTitle(), chapter.getSrcLink()));
        }
    }

    public wb.b O(f fVar) {
        return N(fVar.getSourceName());
    }

    public void O0(f fVar, Chapter chapter, int i10, int i11) {
        N0(fVar.getSourceName(), fVar.getSourceId(), chapter, i10, i11);
    }

    public Map<String, wb.b> P() {
        return this.f13992c;
    }

    public void P0(Book book) {
        O(book).z(book, book);
    }

    public Map<String, BookSyncInfo> Q() {
        return this.f13995f.c();
    }

    public void Q0(BookWrapper bookWrapper) {
        R0(bookWrapper, true);
    }

    public String R() {
        return this.f13995f.e();
    }

    public void R0(BookWrapper bookWrapper, boolean z10) {
        MiBookStoreItem miBookStoreItem = bookWrapper.item;
        if (miBookStoreItem == null) {
            return;
        }
        BookSyncInfo bookSyncInfo = new BookSyncInfo();
        if (l.q(miBookStoreItem.getSourceString())) {
            Book book = bookWrapper.book;
            if (book != null) {
                bookSyncInfo.setSourceString(book.getSourceString());
            }
        } else {
            bookSyncInfo.setSourceString(miBookStoreItem.getSourceString());
        }
        bookSyncInfo.setOpt(miBookStoreItem.getLastReadingTime() == null ? miBookStoreItem.getAddTime() : miBookStoreItem.getLastReadingTime());
        bookSyncInfo.setContentPosition(miBookStoreItem.getReadingContentPos());
        bookSyncInfo.setContentLength(miBookStoreItem.getReadingContentLength());
        bookSyncInfo.setCidx(miBookStoreItem.getReadingChapterIndex());
        bookSyncInfo.setOp(BookSyncInfo.OP_UPDATE.intValue());
        bookSyncInfo.setCategory(miBookStoreItem.getDirName());
        bookSyncInfo.setTop(Integer.valueOf(miBookStoreItem.isFlagTop() ? 1 : 0));
        this.f13995f.h(bookSyncInfo);
        if (z10) {
            L();
        }
    }

    public List<BookWrapper> S() {
        return T().p();
    }

    public vb.c T() {
        if (this.f13993d == null) {
            this.f13993d = new vb.c(this);
        }
        return this.f13993d;
    }

    public List<MiBookMark> U(String str, Chapter chapter) {
        if (TextUtils.isEmpty(str) || chapter == null || TextUtils.isEmpty(chapter.getChapterId())) {
            return null;
        }
        return this.f13996g.d(str, chapter.getChapterId(), 0);
    }

    public List<MiBookMark> V(String str, Chapter chapter) {
        if (TextUtils.isEmpty(str) || chapter == null || TextUtils.isEmpty(chapter.getChapterId())) {
            return null;
        }
        return this.f13996g.d(str, chapter.getChapterId(), 1);
    }

    public long W(Book book) {
        return O(book).f(book);
    }

    public long X() {
        return j.h(this.f13990a, f13987l, 0L);
    }

    public MiCacheItem Y(String str, String str2) {
        return this.f13991b.M(str, str2);
    }

    public MiReadingRecord Z() {
        if (this.f13997h == null) {
            r0();
        }
        MiReadingRecordList miReadingRecordList = this.f13997h;
        if (miReadingRecordList == null || miReadingRecordList.getMiReadingRecords() == null || this.f13997h.getMiReadingRecords().isEmpty()) {
            return null;
        }
        return this.f13997h.getMiReadingRecords().get(0);
    }

    public synchronized MiReadingRecordList a0() {
        try {
            if (this.f13997h == null) {
                r0();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f13997h;
    }

    public synchronized MiBookStoreItem b0(String str) {
        try {
            str = new File(str).getCanonicalPath();
        } catch (IOException e10) {
            p0.b(e10.getMessage());
        }
        return F(e.f31296c, str);
    }

    public MiBookMark c(Book book, Chapter chapter, int i10, String str, int i11, int i12) {
        return this.f13996g.a(book, chapter, i10, str, i11, i12, 0);
    }

    public boolean c0(f fVar, Chapter chapter) {
        return O(fVar).b(fVar, chapter);
    }

    public MiBookMark d(Book book, Chapter chapter, int i10, String str, int i11, int i12) {
        return this.f13996g.a(book, chapter, i10, str, i11, i12, 1);
    }

    public boolean d0(Book book) {
        return O(book).y(book);
    }

    public void e(MiReadingRecord miReadingRecord) {
        if (miReadingRecord == null || l.q(miReadingRecord.getSourceString())) {
            return;
        }
        if (this.f13997h == null) {
            this.f13997h = new MiReadingRecordList();
        }
        for (MiReadingRecord miReadingRecord2 : this.f13997h.getMiReadingRecords()) {
            if (miReadingRecord2 != null && !l.q(miReadingRecord2.getSourceString()) && miReadingRecord2.getSourceString().equalsIgnoreCase(miReadingRecord.getSourceString())) {
                miReadingRecord2.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
                miReadingRecord2.setChapterTitle(miReadingRecord.getChapterTitle());
                miReadingRecord2.setChapterIndex(Integer.valueOf(miReadingRecord.getChapterIndex()));
                Integer contentPos = miReadingRecord.getContentPos();
                if (contentPos != null) {
                    miReadingRecord2.setContentPos(contentPos);
                }
                miReadingRecord2.setAudiobook(Integer.valueOf(miReadingRecord.getAudiobook()));
                if (!TextUtils.isEmpty(miReadingRecord.getCover())) {
                    miReadingRecord2.setCover(miReadingRecord.getCover());
                }
                this.f13997h.getMiReadingRecords().remove(miReadingRecord2);
                this.f13997h.getMiReadingRecords().add(0, miReadingRecord2);
                E0();
                return;
            }
        }
        this.f13997h.getMiReadingRecords().add(0, miReadingRecord);
        E0();
    }

    public final void e0(Context context) {
        HashMap hashMap = new HashMap();
        this.f13992c = hashMap;
        v0(context, hashMap);
    }

    public synchronized BookWrapper f(Activity activity, MiBookStoreItem miBookStoreItem, Book book) {
        return T().b(activity, miBookStoreItem, book);
    }

    public boolean f0(Book book) {
        return O(book).e(book);
    }

    public synchronized BookWrapper g(Activity activity, Book book) {
        return h(activity, book, null);
    }

    public void g0(List<Book> list) {
        HashMap hashMap = new HashMap();
        for (Book book : list) {
            String sourceString = book.getSourceString();
            List list2 = (List) hashMap.get(sourceString);
            if (list2 == null) {
                list2 = new ArrayList();
                hashMap.put(sourceString, list2);
            }
            list2.add(book);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null) {
                f l10 = e.l((String) entry.getKey());
                Objects.requireNonNull(l10);
                O(l10).l((List) entry.getValue());
            }
        }
    }

    public synchronized BookWrapper h(Activity activity, Book book, Integer num) {
        return T().c(activity, book, num);
    }

    public final boolean h0(f fVar) {
        wb.b O = O(fVar);
        return O != null && O.J();
    }

    public void i(Activity activity, Book book, Chapter chapter, ChapterContent chapterContent, boolean z10, xb.c cVar) {
        if (O(book) == null) {
            return;
        }
        O(book).C(activity, book, chapter, chapterContent, z10, cVar);
    }

    public synchronized boolean i0(String str) {
        return T().v(str);
    }

    public void j(Book book, int i10, xb.f fVar) {
        if (O(book) == null) {
            return;
        }
        O(book).x(book, i10, fVar, true);
    }

    public synchronized boolean j0(String str, String str2) {
        return T().v(e.j(str, str2));
    }

    public abstract void k(f fVar, xb.b bVar);

    public synchronized boolean k0(f fVar) {
        return T().v(e.k(fVar));
    }

    public void l(Book book, ChapterList chapterList, int i10, xb.e eVar) {
        O(book).u(book, chapterList, i10, eVar);
    }

    public void m(Book book, int i10, boolean z10, boolean z11, xb.f fVar) {
        if (z10 || (!ConfigSingleton.D().G0() && d0(book))) {
            j(book, i10, fVar);
        } else if (z11) {
            O(book).A(book, fVar, true);
        }
    }

    public List<MiArchiveBookItem> m0() {
        return T().w();
    }

    public void n(Book book, xb.f fVar) {
        if (O(book) == null) {
            return;
        }
        O(book).A(book, fVar, false);
    }

    public List<MiArchiveBookItem> n0(String str) {
        return T().x(str);
    }

    public void o(String str, d dVar) {
        new c(str, dVar).executeSerial(new Void[0]);
    }

    public List<k.d> o0() {
        return T().y();
    }

    public void p(d dVar) {
        new b(dVar).executeSerial(new Void[0]);
    }

    public List<Book> p0(List<f> list) {
        HashMap hashMap = new HashMap();
        for (f fVar : list) {
            wb.b O = O(fVar);
            if (O != null) {
                List list2 = (List) hashMap.get(O);
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(O, list2);
                }
                list2.add(fVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            wb.b bVar = (wb.b) entry.getKey();
            List<f> list3 = (List) entry.getValue();
            if (!list3.isEmpty()) {
                for (Book book : bVar.L(list3)) {
                    if (!TextUtils.isEmpty(book.getBookName())) {
                        arrayList.add(book);
                    }
                }
            }
        }
        return arrayList;
    }

    public void q(f fVar) {
        s(fVar);
        z(fVar);
        y(fVar);
    }

    public List<MiReadingRecord> q0(List<String> list) {
        return this.f13994e.f(list);
    }

    public void r() {
        this.f13995f.a();
    }

    public MiReadingRecordList r0() {
        try {
            String B = g.B(this.f13990a, f13989n);
            if (!TextUtils.isEmpty(B)) {
                MiReadingRecordList miReadingRecordList = (MiReadingRecordList) GsonUtils.b().fromJson(B, MiReadingRecordList.class);
                this.f13997h = miReadingRecordList;
                return miReadingRecordList;
            }
        } catch (JsonSyntaxException | IOException e10) {
            p0.b(e10.getMessage());
        }
        MiReadingRecordList miReadingRecordList2 = new MiReadingRecordList();
        this.f13997h = miReadingRecordList2;
        return miReadingRecordList2;
    }

    public void s(f fVar) {
        O(fVar).t(fVar);
    }

    public synchronized void s0(List<BookWrapper> list, boolean z10) {
        Iterator<BookWrapper> it = list.iterator();
        while (it.hasNext()) {
            T().B(it.next(), z10);
        }
    }

    public zb.c t(f fVar, ChapterList chapterList, int i10, int i11, xb.d dVar) {
        return new a(fVar, chapterList, i10, i11, O(fVar), dVar);
    }

    public synchronized boolean t0(String str) {
        try {
            str = new File(str).getCanonicalPath();
        } catch (IOException e10) {
            p0.b(e10.getMessage());
        }
        return F(e.f31296c, str) == null;
    }

    public void u(MiArchiveBookItem miArchiveBookItem) {
        if (!T().g(miArchiveBookItem) || TextUtils.isEmpty(miArchiveBookItem.getSourceString())) {
            return;
        }
        q(e.l(miArchiveBookItem.getSourceString()));
    }

    public Cursor u0(String str) {
        return this.f13996g.e(str, null);
    }

    public boolean v(MiBookMark miBookMark) {
        return this.f13996g.b(miBookMark);
    }

    public abstract void v0(Context context, Map<String, wb.b> map);

    public void w(MiBookMark miBookMark) {
        this.f13996g.b(miBookMark);
    }

    public void w0(MiArchiveBookItem miArchiveBookItem) {
        T().g(miArchiveBookItem);
    }

    public synchronized boolean x(BookWrapper bookWrapper) {
        return T().i(bookWrapper);
    }

    public void x0(MiReadingRecord miReadingRecord) {
        MiReadingRecordList miReadingRecordList;
        if (miReadingRecord == null || (miReadingRecordList = this.f13997h) == null || miReadingRecordList.getMiReadingRecords().isEmpty()) {
            return;
        }
        Iterator<MiReadingRecord> it = this.f13997h.getMiReadingRecords().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().getSourceString().equalsIgnoreCase(miReadingRecord.getSourceString())) {
                it.remove();
                break;
            }
        }
        E0();
    }

    public synchronized void y(f fVar) {
        this.f13991b.L(fVar);
    }

    public final void y0(List<BookWrapper> list) {
        r();
        for (BookWrapper bookWrapper : list) {
            if (bookWrapper.item != null) {
                R0(bookWrapper, false);
            }
        }
        L();
    }

    public void z(f fVar) {
        O(fVar).n(fVar);
    }

    public synchronized void z0(List<MiArchiveBookItem> list) {
        T().F(list);
    }
}
