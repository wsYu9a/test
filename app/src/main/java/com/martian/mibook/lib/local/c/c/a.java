package com.martian.mibook.lib.local.c.c;

import android.content.Context;
import android.text.TextUtils;
import b.d.c.b.k;
import com.martian.mibook.lib.local.c.b.b;
import com.martian.mibook.lib.local.txt.data.TXTBlock;
import com.martian.mibook.lib.local.txt.data.TXTBook;
import com.martian.mibook.lib.local.txt.data.TXTChapter;
import com.martian.mibook.lib.local.txt.data.TXTChapterList;
import com.martian.mibook.lib.model.c.g;
import com.martian.mibook.lib.model.d.e;
import com.martian.mibook.lib.model.d.f;
import com.martian.mibook.lib.model.d.h;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.MiChapterList;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.manager.BookManager;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class a extends com.martian.mibook.lib.local.b.c.a {

    /* renamed from: b */
    private final com.martian.mibook.lib.local.c.b.b f13944b;

    /* renamed from: com.martian.mibook.lib.local.c.c.a$a */
    class C0274a extends b.d.c.c.c<g, TXTBook> {

        /* renamed from: a */
        final /* synthetic */ com.martian.mibook.lib.model.d.b f13945a;

        C0274a(final com.martian.mibook.lib.model.d.b val$receiver) {
            this.f13945a = val$receiver;
        }

        @Override // b.d.c.c.c
        /* renamed from: f */
        public k doInBackground(g sourceProvider) {
            TXTBook e2 = a.this.f13944b.e(sourceProvider.getSourceId());
            if (e2 != null) {
                if (!a.this.e(e2)) {
                    a.this.z(e2, e2);
                }
                return new b.d.c.b.b(e2);
            }
            return new b.d.c.b.c(-1, "Failed to parse local book: " + sourceProvider.getSourceId());
        }

        @Override // b.d.c.c.b
        /* renamed from: g */
        public void onDataReceived(TXTBook txtBook) {
            this.f13945a.a(txtBook);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f13945a.onResultError(errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f13945a.onLoading(show);
        }
    }

    class b extends b.d.c.c.c<Chapter, ChapterContent> {

        /* renamed from: a */
        final /* synthetic */ g f13947a;

        /* renamed from: b */
        final /* synthetic */ e f13948b;

        b(final g val$receiver, final e val$source) {
            this.f13947a = val$receiver;
            this.f13948b = val$source;
        }

        @Override // b.d.c.c.c
        /* renamed from: f */
        public k doInBackground(Chapter chapter) {
            ChapterContent w = a.this.w(this.f13947a, chapter);
            if (w == null || w.isEmpty()) {
                return new b.d.c.b.c(-1, "获取章节内容失败.");
            }
            this.f13948b.b(w);
            return new b.d.c.b.b(w);
        }

        @Override // b.d.c.c.b
        /* renamed from: g */
        public void onDataReceived(ChapterContent chapterContent) {
            this.f13948b.c(chapterContent);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f13948b.onResultError(errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f13948b.onLoading(show);
        }
    }

    class c extends b.d.c.c.c<TXTBook, List<TXTBlock>> {

        /* renamed from: a */
        final /* synthetic */ f f13950a;

        /* renamed from: b */
        final /* synthetic */ Book f13951b;

        /* renamed from: c */
        final /* synthetic */ boolean f13952c;

        c(final f val$fallBackToLocal, final Book val$book, final boolean val$receiver) {
            this.f13950a = val$fallBackToLocal;
            this.f13951b = val$book;
            this.f13952c = val$receiver;
        }

        @Override // b.d.c.c.c
        /* renamed from: f */
        public k doInBackground(TXTBook txtBook) {
            List<TXTBlock> d2 = a.this.f13944b.d(txtBook);
            return (d2 == null || d2.isEmpty()) ? new b.d.c.b.c(-1, "Failed to parse block list.") : new b.d.c.b.b(d2);
        }

        @Override // b.d.c.c.b
        /* renamed from: g */
        public void onDataReceived(List<TXTBlock> txtBlocks) {
            a.this.M(this.f13951b, txtBlocks, this.f13950a, this.f13952c);
        }

        @Override // b.d.c.c.g
        protected void onProgressUpdate(Integer... values) {
            this.f13950a.b(values[0].intValue());
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            if (this.f13952c) {
                a.this.A(this.f13951b, this.f13950a, false);
            } else {
                this.f13950a.d(errorResult);
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f13950a.a(show);
        }
    }

    class d implements b.c {

        /* renamed from: a */
        private int f13954a = 0;

        /* renamed from: b */
        private final Map<Integer, List<TXTChapter>> f13955b = new Hashtable();

        /* renamed from: c */
        final /* synthetic */ f f13956c;

        /* renamed from: d */
        final /* synthetic */ List f13957d;

        /* renamed from: e */
        final /* synthetic */ Book f13958e;

        d(final f val$book, final List val$blockList, final Book val$receiver) {
            this.f13956c = val$book;
            this.f13957d = val$blockList;
            this.f13958e = val$receiver;
        }

        @Override // com.martian.mibook.lib.local.c.b.b.c
        public void a(int n) {
            f fVar = this.f13956c;
            int i2 = this.f13954a + 1;
            this.f13954a = i2;
            fVar.b(i2);
        }

        @Override // com.martian.mibook.lib.local.c.b.b.c
        public void b(TXTBlock block, List<TXTChapter> chapters) {
            TXTChapter remove;
            this.f13955b.put(Integer.valueOf(block.getIndex()), chapters);
            if (this.f13955b.size() == this.f13957d.size()) {
                LinkedList<TXTChapter> linkedList = new LinkedList();
                List<TXTChapter> list = this.f13955b.get(0);
                int i2 = 1;
                while (i2 < this.f13955b.size()) {
                    List<TXTChapter> list2 = this.f13955b.get(Integer.valueOf(i2));
                    TXTChapter tXTChapter = list2.get(0);
                    if (tXTChapter.getTitle() == null && (remove = list.remove(list.size() - 1)) != null) {
                        tXTChapter.setStartOffset(remove.getStartOffset());
                        tXTChapter.setTitle(remove.getTitle());
                    }
                    linkedList.addAll(list);
                    i2++;
                    list = list2;
                }
                linkedList.addAll(list);
                ArrayList arrayList = new ArrayList();
                TXTChapter tXTChapter2 = null;
                String str = "章节";
                int i3 = 0;
                for (TXTChapter tXTChapter3 : linkedList) {
                    if (!TextUtils.isEmpty(tXTChapter3.getTitle())) {
                        str = tXTChapter3.getTitle();
                        i3 = 0;
                    } else if (tXTChapter2 == null || (tXTChapter3.getEndOffset().longValue() - tXTChapter2.getStartOffset().longValue() >= 20000 && tXTChapter3.getEndOffset().longValue() - tXTChapter3.getStartOffset().longValue() >= 500)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(" (");
                        i3++;
                        sb.append(i3);
                        sb.append(")");
                        tXTChapter3.setTitle(sb.toString());
                    } else {
                        tXTChapter2.setEndOffset(tXTChapter3.getEndOffset());
                    }
                    arrayList.add(tXTChapter3);
                    tXTChapter2 = tXTChapter3;
                }
                TXTChapterList tXTChapterList = new TXTChapterList();
                tXTChapterList.setChapters(arrayList);
                a.this.B(this.f13958e, tXTChapterList, this.f13956c);
            }
        }

        @Override // com.martian.mibook.lib.local.c.b.b.c
        public void onLoading(boolean loading) {
            this.f13956c.a(loading);
        }

        @Override // com.martian.mibook.lib.local.c.b.b.c
        public void onResultError(b.d.c.b.c errorResult) {
            this.f13956c.d(errorResult);
        }
    }

    public a(Context context, BookManager bookMgr) {
        super(bookMgr);
        this.f13944b = new com.martian.mibook.lib.local.c.b.b();
    }

    private com.martian.mibook.lib.local.c.d.a N() {
        return com.martian.mibook.lib.local.c.d.a.o();
    }

    @Override // com.martian.mibook.lib.model.c.b
    public void D(g source, final com.martian.mibook.lib.model.d.b receiver, boolean isBlocking) {
        C0274a c0274a = new C0274a(receiver);
        if (isBlocking) {
            c0274a.executeBlocking(source);
        } else {
            c0274a.execute(source);
        }
    }

    @Override // com.martian.mibook.lib.model.c.b
    public String F() {
        return com.martian.mibook.lib.model.manager.d.f14056h;
    }

    public void L(final Book book, final f receiver, final boolean fallBackToLocal) {
        new c(receiver, book, fallBackToLocal).executeParallel((TXTBook) book);
    }

    public void M(final Book book, final List<TXTBlock> blockList, final f receiver, final boolean fallBackToLocal) {
        d dVar = new d(receiver, blockList, book);
        Iterator<TXTBlock> it = blockList.iterator();
        while (it.hasNext()) {
            this.f13944b.a(it.next(), dVar);
        }
    }

    @Override // com.martian.mibook.lib.model.c.d
    public void a(g sourceProvider) {
    }

    @Override // com.martian.mibook.lib.model.c.a
    public boolean c(BookWrapper bookWrapper) {
        return false;
    }

    @Override // com.martian.mibook.lib.model.c.a
    public void d(final g source, ChapterList chapterList, int index, final e receiver) {
        new b(source, receiver).execute(chapterList.getItem(index));
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean e(Book book) {
        return N().insert((TXTBook) book) == 1;
    }

    @Override // com.martian.mibook.lib.model.c.d
    public long f(Book book) {
        return new com.martian.mibook.lib.local.c.d.b(book).d();
    }

    @Override // com.martian.mibook.lib.model.c.a
    public void g(final Book book, final f receiver, boolean fallBackToLocal) {
        if (fallBackToLocal) {
            A(book, receiver, true);
        } else {
            L(book, receiver, false);
        }
    }

    @Override // com.martian.mibook.lib.model.c.d
    public void h(g sourceProvider) {
        new com.martian.mibook.lib.local.c.d.b(sourceProvider).b();
    }

    @Override // com.martian.mibook.lib.model.c.d
    public Book j(g sourceProvider) {
        TXTBook tXTBook = new TXTBook();
        tXTBook.setFilePath(sourceProvider.getSourceId());
        if (N().h(tXTBook)) {
            return tXTBook;
        }
        return null;
    }

    @Override // com.martian.mibook.lib.model.c.d
    public long k(List<Book> books) {
        ArrayList arrayList = new ArrayList();
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            arrayList.add((TXTBook) it.next());
        }
        return N().g(arrayList);
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean l(Book book) {
        return true;
    }

    @Override // com.martian.mibook.lib.model.c.a
    public void m(BookWrapper bookWrapper, int index, com.martian.mibook.lib.model.d.a receiver) {
    }

    @Override // com.martian.mibook.lib.model.c.d
    public synchronized void n(Book book, ChapterList chapterList) {
        com.martian.mibook.lib.local.c.d.b bVar = new com.martian.mibook.lib.local.c.d.b(book);
        bVar.a();
        bVar.h(((TXTChapterList) chapterList).getChapters());
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean o(Book newBook, Book book) {
        return false;
    }

    @Override // com.martian.mibook.lib.model.c.d
    public MiChapterList p(g sourceProvider) {
        return new MiChapterList(TXTChapter.class, new com.martian.mibook.lib.local.c.d.b(sourceProvider).query());
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean r(g sourceProvider, Chapter chapter) {
        return false;
    }

    @Override // com.martian.mibook.lib.model.c.a
    public void s(String bookName, int page, h receiver, boolean isBlocking, int searchType, int ctype, String sourceName, String sourceId) {
    }

    @Override // com.martian.mibook.lib.model.c.a
    public com.martian.mibook.lib.model.f.b t(g source, int index, Chapter chapter, com.martian.mibook.lib.model.d.g receiver) {
        return null;
    }

    @Override // com.martian.mibook.lib.model.c.d
    public ChapterContent w(g sourceProvider, Chapter chapter) {
        return this.f13944b.f(chapter);
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean x(g sourceProvider, Chapter chapter, ChapterContent content) {
        throw new UnsupportedOperationException("");
    }

    @Override // com.martian.mibook.lib.model.c.d
    public boolean z(Book newBook, Book book) {
        return N().f((TXTBook) newBook) != -1;
    }
}
