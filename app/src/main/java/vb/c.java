package vb;

import android.app.Activity;
import android.text.TextUtils;
import ba.k;
import ba.l;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.BookrackCategoryManager;
import com.martian.mibook.lib.model.data.MiArchiveBookItem;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.manager.BookManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l9.i0;
import yb.f;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: h */
    public static final String[] f31284h = {"玄幻", "言情", "都市", "历史", "校园", "武侠", "科幻", "灵异", "耽美", "军事", "其他"};

    /* renamed from: a */
    public List<BookWrapper> f31285a;

    /* renamed from: b */
    public Map<String, BookWrapper> f31286b;

    /* renamed from: c */
    public final f f31287c = f.p();

    /* renamed from: d */
    public yb.c f31288d;

    /* renamed from: e */
    public final BookManager f31289e;

    /* renamed from: f */
    public BookrackCategoryManager f31290f;

    /* renamed from: g */
    public Boolean f31291g;

    public class a implements Comparator<BookWrapper> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(BookWrapper bookWrapper, BookWrapper bookWrapper2) {
            MiBookStoreItem miBookStoreItem;
            if (bookWrapper.isAdderItem() || bookWrapper2.isAdderItem() || (miBookStoreItem = bookWrapper2.item) == null) {
                return -1;
            }
            MiBookStoreItem miBookStoreItem2 = bookWrapper.item;
            if (miBookStoreItem2 == null) {
                return 1;
            }
            int b10 = b(miBookStoreItem2, miBookStoreItem);
            if (b10 == 0) {
                b10 = d(bookWrapper.item, bookWrapper2.item);
            }
            return b10 == 0 ? c(bookWrapper.item, bookWrapper2.item) : b10;
        }

        public final int b(MiBookStoreItem miBookStoreItem, MiBookStoreItem miBookStoreItem2) {
            return miBookStoreItem.isFlagTop() ? miBookStoreItem2.isFlagTop() ? 0 : -1 : miBookStoreItem2.isFlagTop() ? 1 : 0;
        }

        public final int c(MiBookStoreItem miBookStoreItem, MiBookStoreItem miBookStoreItem2) {
            return (miBookStoreItem2.get_id() != null ? miBookStoreItem2.get_id().intValue() : 0) - (miBookStoreItem.get_id() == null ? 0 : miBookStoreItem.get_id().intValue());
        }

        public final int d(MiBookStoreItem miBookStoreItem, MiBookStoreItem miBookStoreItem2) {
            return Long.compare(miBookStoreItem2.getLastReadingTime() != null ? miBookStoreItem2.getLastReadingTime().longValue() : 0L, miBookStoreItem.getLastReadingTime() == null ? 0L : miBookStoreItem.getLastReadingTime().longValue());
        }
    }

    public c(BookManager bookManager) {
        this.f31289e = bookManager;
    }

    public static String[] u(int i10) {
        int length = f31284h.length;
        String[] strArr = new String[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < length && i11 < i10; i12++) {
            if (Math.random() * (length - i12) < i10 - i11) {
                strArr[i11] = f31284h[i12];
                i11++;
            }
        }
        return strArr;
    }

    public final void A(List<BookWrapper> list) {
        ArrayList<MiBookStoreItem> arrayList = new ArrayList();
        this.f31287c.m(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (MiBookStoreItem miBookStoreItem : arrayList) {
            if (miBookStoreItem.getChapterSize() == null || miBookStoreItem.getChapterSize().intValue() == 0) {
                miBookStoreItem.setChapterSize(-1);
            }
            String sourceString = miBookStoreItem.getSourceString();
            wb.f l10 = e.l(miBookStoreItem.getSourceString());
            if (l10 != null) {
                arrayList3.add(l10);
                arrayList2.add(sourceString);
            }
        }
        HashMap hashMap = new HashMap();
        try {
            for (Book book : this.f31289e.p0(arrayList3)) {
                if (book != null) {
                    hashMap.put(book.getSourceString(), book);
                }
            }
        } catch (Exception unused) {
        }
        HashMap hashMap2 = new HashMap();
        try {
            for (MiReadingRecord miReadingRecord : this.f31289e.q0(arrayList2)) {
                if (miReadingRecord.getLastReadingTime() != -1) {
                    hashMap2.put(miReadingRecord.getSourceString(), miReadingRecord);
                }
            }
        } catch (Exception unused2) {
        }
        for (MiBookStoreItem miBookStoreItem2 : arrayList) {
            String sourceString2 = miBookStoreItem2.getSourceString();
            Book book2 = (Book) hashMap.get(sourceString2);
            if (book2 == null && !TextUtils.isEmpty(sourceString2)) {
                wb.f l11 = e.l(sourceString2);
                if (l11 != null) {
                    wb.b O = this.f31289e.O(l11);
                    if (O != null) {
                        book2 = O.M();
                        book2.setBookName(miBookStoreItem2.getBookName());
                        book2.setSourceId(l11.getSourceId());
                        book2.setCover(miBookStoreItem2.getCoverUrl());
                    }
                }
            }
            if (book2 != null) {
                if (miBookStoreItem2.getBookName() == null) {
                    miBookStoreItem2.setBookName(book2.getBookName());
                }
                book2.setShortIntro(null);
                MiReadingRecord miReadingRecord2 = (MiReadingRecord) hashMap2.get(sourceString2);
                if (miReadingRecord2 != null) {
                    miBookStoreItem2.setReadingContentPos(miReadingRecord2.getContentPos());
                    miBookStoreItem2.setReadingChapterIndex(Integer.valueOf(miReadingRecord2.getChapterIndex()));
                    miBookStoreItem2.setReadingContentLength(miReadingRecord2.getContentLength());
                }
                list.add(new BookWrapper(miBookStoreItem2, book2));
            }
        }
    }

    public void B(BookWrapper bookWrapper, boolean z10) {
        for (int i10 = 0; i10 < p().size(); i10++) {
            BookWrapper bookWrapper2 = p().get(i10);
            if (bookWrapper2 != null && !bookWrapper2.notBookItem() && bookWrapper2.item != null && bookWrapper2.equals(bookWrapper)) {
                bookWrapper2.item.setFlagTop(z10);
                if (J(bookWrapper2)) {
                    this.f31287c.i(bookWrapper2.item);
                    if (z10) {
                        p().add(0, p().remove(i10));
                        return;
                    }
                    int i11 = i10 + 1;
                    while (i11 < p().size()) {
                        BookWrapper bookWrapper3 = p().get(i11);
                        if (bookWrapper3 != null && !bookWrapper3.isAdItem()) {
                            if (bookWrapper3.isAdderItem()) {
                                break;
                            }
                            if (bookWrapper3.item.isFlagTop()) {
                                continue;
                            } else if (bookWrapper2.item.getLastReadingTime() == null) {
                                if (bookWrapper2.item.get_id() != null) {
                                    if (bookWrapper3.item.get_id() == null || bookWrapper2.item.get_id().intValue() > bookWrapper3.item.get_id().intValue()) {
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                if (bookWrapper3.item.getLastReadingTime() == null || bookWrapper2.item.getLastReadingTime().longValue() > bookWrapper3.item.getLastReadingTime().longValue()) {
                                    break;
                                }
                            }
                        }
                        i11++;
                    }
                    p().add(i11 - 1, p().remove(i10));
                    return;
                }
            }
        }
    }

    public final void C() {
        this.f31286b = new HashMap(p().size());
        for (BookWrapper bookWrapper : p()) {
            if (bookWrapper.item != null && !bookWrapper.notBookItem()) {
                this.f31286b.put(bookWrapper.item.getSourceString(), bookWrapper);
            }
        }
    }

    public void D() {
        this.f31290f = null;
        r();
    }

    public synchronized void E() {
        Collections.sort(p(), new a());
    }

    public synchronized void F(List<MiArchiveBookItem> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                m().x();
                m().insert((Collection) list);
            }
        }
    }

    public synchronized boolean G(List<BookWrapper> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    this.f31287c.l();
                    this.f31290f = null;
                    List<BookWrapper> list2 = this.f31285a;
                    if (list2 == null) {
                        this.f31285a = list;
                    } else {
                        list2.clear();
                        this.f31285a.addAll(list);
                    }
                    for (BookWrapper bookWrapper : list) {
                        if (bookWrapper != null && !bookWrapper.notBookItem()) {
                            Book book = bookWrapper.book;
                            if (book != null) {
                                this.f31289e.f0(book);
                                if (this.f31289e.K(bookWrapper.book) == null && bookWrapper.item.getLastReadingTime() != null && bookWrapper.item.isReaded() && bookWrapper.item.getReadingContentLength() != null && bookWrapper.item.getReadingContentPos() != null) {
                                    MiReadingRecord miReadingRecord = new MiReadingRecord();
                                    miReadingRecord.setChapterIndex(bookWrapper.item.getReadingChapterIndex());
                                    miReadingRecord.setContentPos(bookWrapper.item.getReadingContentPos());
                                    miReadingRecord.setContentLength(bookWrapper.item.getReadingContentLength());
                                    miReadingRecord.setSourceString(bookWrapper.item.getSourceString());
                                    miReadingRecord.setBookName(bookWrapper.item.getBookName());
                                    this.f31289e.D0(miReadingRecord, true);
                                }
                            }
                            this.f31287c.f(bookWrapper.item);
                            bookWrapper.resetTempInfo();
                        }
                    }
                    C();
                    return true;
                }
            } finally {
            }
        }
        return false;
    }

    public boolean H() {
        if (this.f31291g == null) {
            List<MiArchiveBookItem> w10 = w();
            this.f31291g = Boolean.valueOf((w10 == null || w10.isEmpty()) ? false : true);
        }
        return this.f31291g.booleanValue();
    }

    public void I() {
        MiBookStoreItem miBookStoreItem;
        try {
            Iterator<BookWrapper> it = p().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                BookWrapper next = it.next();
                if (next != null && !next.notBookItem() && (miBookStoreItem = next.item) != null && miBookStoreItem.isRecommendBook() && (i10 = i10 + 1) > 3 && h(next)) {
                    it.remove();
                    q().remove(next.item.getSourceString());
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public boolean J(BookWrapper bookWrapper) {
        BookManager bookManager;
        if (bookWrapper.item.getRawFlagTop() == null) {
            bookWrapper.item.setFlagTop(false);
        }
        boolean update = this.f31287c.update(bookWrapper.item);
        if (update && (bookManager = this.f31289e) != null) {
            bookManager.Q0(bookWrapper);
        }
        return update;
    }

    public synchronized void K(Book book, MiReadingRecord miReadingRecord) {
        try {
            if (l.q(miReadingRecord.getSourceString())) {
                return;
            }
            for (int i10 = 0; i10 < p().size(); i10++) {
                BookWrapper bookWrapper = p().get(i10);
                if (bookWrapper != null && !bookWrapper.notBookItem() && bookWrapper.book.equals(book)) {
                    bookWrapper.item.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
                    bookWrapper.item.setReadingChapterIndex(Integer.valueOf(miReadingRecord.getChapterIndex()));
                    bookWrapper.item.setReadingContentLength(miReadingRecord.getContentLength());
                    bookWrapper.item.setReadingContentPos(miReadingRecord.getContentPos());
                    J(bookWrapper);
                    if (bookWrapper.item.isFlagTop()) {
                        p().add(0, p().remove(i10));
                    } else {
                        p().add(t(), p().remove(i10));
                    }
                    return;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void L(Book book, ChapterList chapterList) {
        for (BookWrapper bookWrapper : p()) {
            Book book2 = bookWrapper.book;
            if (book2 != null && book.equals(book2)) {
                bookWrapper.item.setChapterSize(Integer.valueOf(chapterList.getCount()));
                J(bookWrapper);
                return;
            }
        }
    }

    public final BookWrapper a(Activity activity, MiBookStoreItem miBookStoreItem, Book book) {
        BookManager bookManager;
        if (TextUtils.isEmpty(miBookStoreItem.getBookId())) {
            return null;
        }
        BookWrapper bookWrapper = new BookWrapper(miBookStoreItem, book);
        long insert = this.f31287c.insert(bookWrapper.item);
        if (insert == -2) {
            i0.M0(activity);
        } else {
            if (insert != -1) {
                this.f31287c.i(bookWrapper.item);
                p().add(t(), bookWrapper);
                BookrackCategoryManager bookrackCategoryManager = this.f31290f;
                if (bookrackCategoryManager != null) {
                    bookrackCategoryManager.addBookCategory(miBookStoreItem.getDirName());
                    this.f31290f.sortCategories();
                }
                if ((miBookStoreItem.getReadingChapterIndex() == null || miBookStoreItem.getReadingChapterIndex().intValue() != BookManager.f13984i) && (bookManager = this.f31289e) != null) {
                    bookManager.Q0(bookWrapper);
                }
                q().put(bookWrapper.item.getSourceString(), bookWrapper);
                return bookWrapper;
            }
            if (J(bookWrapper)) {
                this.f31287c.i(bookWrapper.item);
                for (BookWrapper bookWrapper2 : p()) {
                    MiBookStoreItem miBookStoreItem2 = bookWrapper2.item;
                    if (miBookStoreItem2 != null && miBookStoreItem2.getBookId().equalsIgnoreCase(miBookStoreItem.getBookId())) {
                        bookWrapper2.item = bookWrapper.item;
                        return bookWrapper2;
                    }
                }
            }
        }
        return null;
    }

    public BookWrapper b(Activity activity, MiBookStoreItem miBookStoreItem, Book book) {
        miBookStoreItem.setHasUpdate(false);
        miBookStoreItem.setAddFlag(1);
        miBookStoreItem.setDeleteFlag(0);
        if (book != null) {
            miBookStoreItem.setDirName(book.getCategory());
            miBookStoreItem.setSourceString(e.k(book));
            miBookStoreItem.setCoverUrl(book.getCover());
            miBookStoreItem.setBookName(book.getBookName());
        }
        return a(activity, miBookStoreItem, book);
    }

    public BookWrapper c(Activity activity, Book book, Integer num) {
        MiBookStoreItem miBookStoreItem = new MiBookStoreItem();
        miBookStoreItem.setBookId(book.getBookId());
        miBookStoreItem.setBookName(book.getBookName());
        miBookStoreItem.setFlagTop(false);
        miBookStoreItem.setAddTime(Long.valueOf(System.currentTimeMillis()));
        miBookStoreItem.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
        miBookStoreItem.setAddFlag(1);
        miBookStoreItem.setDeleteFlag(0);
        miBookStoreItem.setHasUpdate(false);
        if (num != null) {
            miBookStoreItem.setReadingChapterIndex(num);
        }
        miBookStoreItem.setDirName(book.getCategory());
        miBookStoreItem.setSourceString(e.k(book));
        miBookStoreItem.setCoverUrl(book.getCover());
        miBookStoreItem.setChapterSize(book.getChapterSize());
        miBookStoreItem.setLastReadChapterSize(book.getChapterSize());
        return a(activity, miBookStoreItem, book);
    }

    public void d(String str) {
        for (BookWrapper bookWrapper : p()) {
            if (bookWrapper != null && !bookWrapper.notBookItem() && bookWrapper.isSelect() && !str.equalsIgnoreCase(bookWrapper.item.getDirName())) {
                BookrackCategoryManager bookrackCategoryManager = this.f31290f;
                if (bookrackCategoryManager != null) {
                    bookrackCategoryManager.updateBookCategory(bookWrapper.item, str);
                }
                bookWrapper.item.setDirName(str);
                J(bookWrapper);
            }
        }
        BookrackCategoryManager bookrackCategoryManager2 = this.f31290f;
        if (bookrackCategoryManager2 != null) {
            bookrackCategoryManager2.sortCategories();
        }
    }

    public void e(Activity activity, List<Book> list) {
        ArrayList arrayList = new ArrayList();
        for (Book book : list) {
            MiBookStoreItem miBookStoreItem = new MiBookStoreItem();
            miBookStoreItem.setBookId(book.getBookId());
            miBookStoreItem.setFlagTop(false);
            miBookStoreItem.setAddTime(Long.valueOf(System.currentTimeMillis()));
            miBookStoreItem.setLastReadingTime(Long.valueOf(System.currentTimeMillis()));
            miBookStoreItem.setBookName(book.getBookName());
            miBookStoreItem.setAddFlag(1);
            miBookStoreItem.setDeleteFlag(0);
            miBookStoreItem.setHasUpdate(false);
            miBookStoreItem.setSourceString(e.k(book));
            miBookStoreItem.setCoverUrl(book.getCover());
            miBookStoreItem.setDirName(book.getCategory());
            if (book.isPromoteBook()) {
                miBookStoreItem.setReadingChapterIndex(Integer.valueOf(BookManager.f13985j));
            }
            arrayList.add(miBookStoreItem);
        }
        if (this.f31287c.g(arrayList) == -2) {
            i0.M0(activity);
        }
        this.f31285a = null;
        p();
    }

    public void f() {
        this.f31285a = null;
        this.f31286b = null;
        this.f31290f = null;
    }

    public boolean g(MiArchiveBookItem miArchiveBookItem) {
        return m().delete(miArchiveBookItem);
    }

    public boolean h(BookWrapper bookWrapper) {
        f fVar = this.f31287c;
        boolean z10 = fVar != null && fVar.delete(bookWrapper.item);
        if (z10) {
            BookrackCategoryManager bookrackCategoryManager = this.f31290f;
            if (bookrackCategoryManager != null) {
                bookrackCategoryManager.removeCategoryBook(bookWrapper.item.getDirName());
            }
            BookManager bookManager = this.f31289e;
            if (bookManager != null) {
                Book book = bookWrapper.book;
                if (book != null) {
                    bookManager.q(book);
                }
                this.f31289e.L0(bookWrapper);
            }
        }
        return z10;
    }

    public boolean i(BookWrapper bookWrapper) {
        if (bookWrapper == null || bookWrapper.item == null) {
            return true;
        }
        Iterator<BookWrapper> it = p().iterator();
        while (it.hasNext()) {
            BookWrapper next = it.next();
            if (next.equals(bookWrapper) && h(next)) {
                it.remove();
                q().remove(bookWrapper.item.getSourceString());
                return true;
            }
        }
        return false;
    }

    public int j() {
        Iterator<BookWrapper> it = p().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            BookWrapper next = it.next();
            if (next != null && !next.notBookItem() && next.isSelect() && h(next)) {
                it.remove();
                q().remove(next.item.getSourceString());
                i10++;
            }
        }
        return i10;
    }

    public MiBookStoreItem k(String str, String str2) {
        BookWrapper bookWrapper = q().get(e.j(str, str2));
        if (bookWrapper != null) {
            return bookWrapper.item;
        }
        return null;
    }

    public synchronized BookWrapper l(String str) {
        return q().get(str);
    }

    public final yb.c m() {
        if (this.f31288d == null) {
            this.f31288d = yb.c.K();
        }
        return this.f31288d;
    }

    public BookWrapper n(Book book) {
        return this.f31286b.get(book.getSourceString());
    }

    public BookWrapper o(String str) {
        if (l.q(str)) {
            return null;
        }
        return q().get(str);
    }

    public synchronized List<BookWrapper> p() {
        try {
            if (this.f31285a == null) {
                ArrayList arrayList = new ArrayList();
                this.f31285a = arrayList;
                A(arrayList);
                C();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f31285a;
    }

    public final Map<String, BookWrapper> q() {
        if (this.f31286b == null) {
            p();
        }
        if (this.f31286b == null) {
            C();
        }
        return this.f31286b;
    }

    public BookrackCategoryManager r() {
        if (this.f31290f == null) {
            this.f31290f = new BookrackCategoryManager();
            Iterator<BookWrapper> it = p().iterator();
            while (it.hasNext()) {
                MiBookStoreItem miBookStoreItem = it.next().item;
                if (miBookStoreItem != null) {
                    this.f31290f.addBookCategory(miBookStoreItem.getDirName());
                }
            }
            this.f31290f.sortCategories();
        }
        return this.f31290f;
    }

    public String s() {
        MiBookStoreItem miBookStoreItem;
        Book book;
        String str = "";
        for (BookWrapper bookWrapper : p()) {
            if (!bookWrapper.notBookItem() && (miBookStoreItem = bookWrapper.item) != null && miBookStoreItem.isReaded() && bookWrapper.item.getChapterSize() != null && (book = bookWrapper.book) != null && !book.isLocal() && !bookWrapper.book.isSerialEnd()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(l.q(str) ? "" : ",");
                sb2.append(bookWrapper.item.getSourceString());
                str = sb2.toString();
            }
        }
        return str;
    }

    public final int t() {
        BookWrapper bookWrapper;
        MiBookStoreItem miBookStoreItem;
        ArrayList arrayList = new ArrayList(p());
        int i10 = 0;
        while (i10 < arrayList.size() && ((bookWrapper = (BookWrapper) arrayList.get(i10)) == null || bookWrapper.isAdItem() || (!bookWrapper.isAdderItem() && (miBookStoreItem = bookWrapper.item) != null && miBookStoreItem.isFlagTop()))) {
            i10++;
        }
        return i10;
    }

    public boolean v(String str) {
        return l(str) != null;
    }

    public List<MiArchiveBookItem> w() {
        ArrayList arrayList = new ArrayList();
        m().z(arrayList);
        return arrayList;
    }

    public List<MiArchiveBookItem> x(String str) {
        ArrayList arrayList = new ArrayList();
        m().C(arrayList, 0, 0, "tag = ?", new String[]{str});
        return arrayList;
    }

    public List<k.d> y() {
        List<k.d> z10 = z();
        if (z10.size() > 0) {
            return z10;
        }
        for (String str : u(6 - z10.size())) {
            z10.add(new k.d(str, 0L));
        }
        return z10;
    }

    public final List<k.d> z() {
        return m().p(TTDownloadField.TT_TAG, false, null, null);
    }
}
