package com.martian.mibook.application;

import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.manager.BookManager;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class n0 {

    /* renamed from: a */
    private final Map<Book, com.martian.mibook.lib.model.f.c> f11512a = new Hashtable();

    /* renamed from: b */
    private final Map<Book, ConcurrentLinkedQueue<b>> f11513b = new Hashtable();

    /* renamed from: c */
    private final BookManager f11514c;

    /* loaded from: classes3.dex */
    class a implements com.martian.mibook.lib.model.d.d {

        /* renamed from: a */
        final /* synthetic */ Book f11515a;

        a(final Book val$book) {
            this.f11515a = val$book;
        }

        @Override // com.martian.mibook.lib.model.d.d
        public void a() {
            n0.this.u(this.f11515a);
        }

        @Override // com.martian.mibook.lib.model.d.d
        public void b() {
            n0.this.t(this.f11515a);
        }

        @Override // com.martian.mibook.lib.model.d.d
        public void c() {
            n0.this.r(this.f11515a);
        }

        @Override // com.martian.mibook.lib.model.d.d
        public void d(int failedSize) {
            n0.this.s(this.f11515a, failedSize);
        }

        @Override // com.martian.mibook.lib.model.d.d
        public void e(Integer... values) {
            n0.this.v(this.f11515a, values[0].intValue(), values[1].intValue(), values[2].intValue() != 0);
        }

        @Override // com.martian.mibook.lib.model.d.d
        public void onResultError(b.d.c.b.c errorResult) {
            n0.this.q(this.f11515a, errorResult);
        }
    }

    public interface b {
        void b(Book book, b.d.c.b.c errorResult);

        void e(Book book);

        void f(Book book);

        void j(Book book);

        void m(Book book);

        void n(Book book, int failedSize);

        void o(Book book, int index, int size, boolean cachedBefore);

        void s(Book book);
    }

    public n0(BookManager bookMgr) {
        this.f11514c = bookMgr;
    }

    private synchronized void g(Book book, b l) {
        ConcurrentLinkedQueue<b> k = k(book);
        if (!k.contains(l)) {
            k.add(l);
        }
    }

    private synchronized void h(Book book, com.martian.mibook.lib.model.f.c task) {
        this.f11512a.put(book, task);
    }

    private synchronized ConcurrentLinkedQueue<b> k(Book book) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue;
        concurrentLinkedQueue = this.f11513b.get(book);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
            this.f11513b.put(book, concurrentLinkedQueue);
        }
        return concurrentLinkedQueue;
    }

    private synchronized com.martian.mibook.lib.model.f.c n(Book book) {
        return this.f11512a.get(book);
    }

    private synchronized void p(Book book) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f11513b.get(book);
        if (concurrentLinkedQueue != null) {
            Iterator<b> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                it.next().s(book);
            }
        }
        x(book);
    }

    public synchronized void q(Book book, b.d.c.b.c errorResult) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f11513b.get(book);
        if (concurrentLinkedQueue != null) {
            Iterator<b> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                it.next().b(book, errorResult);
            }
        }
        x(book);
    }

    public synchronized void r(Book book) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f11513b.get(book);
        if (concurrentLinkedQueue != null) {
            Iterator<b> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                it.next().j(book);
            }
        }
        x(book);
    }

    public synchronized void s(Book book, int failedSize) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f11513b.get(book);
        if (concurrentLinkedQueue != null) {
            Iterator<b> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                it.next().n(book, failedSize);
            }
        }
        x(book);
    }

    public synchronized void t(Book book) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f11513b.get(book);
        if (concurrentLinkedQueue != null) {
            Iterator<b> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                it.next().m(book);
            }
        }
    }

    public synchronized void u(Book book) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f11513b.get(book);
        if (concurrentLinkedQueue != null) {
            Iterator<b> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                it.next().e(book);
            }
        }
        x(book);
    }

    public synchronized void v(Book book, int index, int size, boolean cachedBefore) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f11513b.get(book);
        if (concurrentLinkedQueue != null) {
            Iterator<b> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                it.next().o(book, index, size, cachedBefore);
            }
        }
    }

    private synchronized void w(Book book) {
        this.f11513b.remove(book);
    }

    private synchronized void x(Book book) {
        this.f11512a.remove(book);
        w(book);
    }

    public synchronized void A(Book book, b l) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f11513b.get(book);
        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.contains(l)) {
            concurrentLinkedQueue.add(l);
            l.f(book);
        }
    }

    public synchronized void B(Book book, b l) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f11513b.get(book);
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.remove(l);
        }
    }

    public synchronized void C() {
        Iterator<Map.Entry<Book, ConcurrentLinkedQueue<b>>> it = this.f11513b.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().clear();
        }
    }

    public synchronized boolean i(Book book) {
        com.martian.mibook.lib.model.f.c n = n(book);
        if (n == null) {
            return false;
        }
        n.g();
        return true;
    }

    public void j(String tag) {
        if (com.martian.libmars.d.h.F().Q0()) {
            Iterator<Map.Entry<Book, ConcurrentLinkedQueue<b>>> it = this.f11513b.entrySet().iterator();
            while (it.hasNext()) {
                com.martian.libmars.utils.q0.d(this, tag + " -> size: " + it.next().getValue().size());
            }
        }
    }

    public synchronized Book l(com.martian.mibook.lib.model.c.g sourceProvider) {
        for (Book book : m()) {
            if (book.equals(sourceProvider)) {
                return book;
            }
        }
        return null;
    }

    public synchronized Set<Book> m() {
        return this.f11512a.keySet();
    }

    public synchronized boolean o(Book book) {
        return this.f11512a.containsKey(book);
    }

    public synchronized boolean y(final Book book, ChapterList chapterList, int start, int size, b l) {
        g(book, l);
        if (o(book)) {
            l.f(book);
            return false;
        }
        com.martian.mibook.lib.model.f.c z = this.f11514c.z(book, chapterList, start, size, new a(book));
        if (z != null) {
            z.r();
            h(book, z);
        } else {
            w(book);
        }
        return true;
    }

    public boolean z(final Book book, ChapterList chapterList, b l) {
        return y(book, chapterList, 0, chapterList.getCount(), l);
    }
}
