package ya;

import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.manager.BookManager;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public class b1 {

    /* renamed from: a */
    public final Map<Book, zb.c> f33121a = new Hashtable();

    /* renamed from: b */
    public final Map<Book, ConcurrentLinkedQueue<b>> f33122b = new Hashtable();

    /* renamed from: c */
    public final BookManager f33123c;

    public class a implements xb.d {

        /* renamed from: a */
        public final /* synthetic */ Book f33124a;

        public a(Book book) {
            this.f33124a = book;
        }

        @Override // xb.d
        public void a() {
            b1.this.r(this.f33124a);
        }

        @Override // xb.d
        public void b() {
            b1.this.q(this.f33124a);
        }

        @Override // xb.d
        public void c() {
            b1.this.o(this.f33124a);
        }

        @Override // xb.d
        public void d(int i10) {
            b1.this.p(this.f33124a, i10);
        }

        @Override // xb.d
        public void e(Integer... numArr) {
            b1.this.s(this.f33124a, numArr[0].intValue(), numArr[1].intValue(), numArr[2].intValue() != 0);
        }

        @Override // xb.d
        public void onResultError(x8.c cVar) {
            b1.this.n(this.f33124a, cVar);
        }
    }

    public interface b {
        void a(Book book);

        void c(Book book);

        void d(Book book, x8.c cVar);

        void e(Book book);

        void f(Book book);

        void g(Book book, int i10);

        void h(Book book, int i10, int i11, boolean z10);

        void i(Book book);
    }

    public b1(BookManager bookManager) {
        this.f33123c = bookManager;
    }

    public final synchronized void g(Book book, b bVar) {
        ConcurrentLinkedQueue<b> j10 = j(book);
        if (!j10.contains(bVar)) {
            j10.add(bVar);
        }
    }

    public final synchronized void h(Book book, zb.c cVar) {
        this.f33121a.put(book, cVar);
    }

    public synchronized void i(Book book) {
        zb.c k10 = k(book);
        if (k10 != null) {
            k10.h();
        }
    }

    public final synchronized ConcurrentLinkedQueue<b> j(Book book) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue;
        concurrentLinkedQueue = this.f33122b.get(book);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
            this.f33122b.put(book, concurrentLinkedQueue);
        }
        return concurrentLinkedQueue;
    }

    public final synchronized zb.c k(Book book) {
        return this.f33121a.get(book);
    }

    public synchronized boolean l(Book book) {
        return this.f33121a.containsKey(book);
    }

    public final synchronized void m(Book book) {
        try {
            ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f33122b.get(book);
            if (concurrentLinkedQueue != null) {
                Iterator<b> it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    it.next().i(book);
                }
            }
            u(book);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void n(Book book, x8.c cVar) {
        try {
            ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f33122b.get(book);
            if (concurrentLinkedQueue != null) {
                Iterator<b> it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    it.next().d(book, cVar);
                }
            }
            u(book);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void o(Book book) {
        try {
            ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f33122b.get(book);
            if (concurrentLinkedQueue != null) {
                Iterator<b> it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    it.next().e(book);
                }
            }
            u(book);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void p(Book book, int i10) {
        try {
            ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f33122b.get(book);
            if (concurrentLinkedQueue != null) {
                Iterator<b> it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    it.next().g(book, i10);
                }
            }
            u(book);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void q(Book book) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f33122b.get(book);
        if (concurrentLinkedQueue != null) {
            Iterator<b> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                it.next().f(book);
            }
        }
    }

    public final synchronized void r(Book book) {
        try {
            ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f33122b.get(book);
            if (concurrentLinkedQueue != null) {
                Iterator<b> it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    it.next().a(book);
                }
            }
            u(book);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void s(Book book, int i10, int i11, boolean z10) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f33122b.get(book);
        if (concurrentLinkedQueue != null) {
            Iterator<b> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                it.next().h(book, i10, i11, z10);
            }
        }
    }

    public final synchronized void t(Book book) {
        this.f33122b.remove(book);
    }

    public final synchronized void u(Book book) {
        this.f33121a.remove(book);
        t(book);
    }

    public synchronized void v(Book book, ChapterList chapterList, int i10, int i11, b bVar) {
        g(book, bVar);
        if (l(book)) {
            bVar.c(book);
            return;
        }
        if (MiConfigSingleton.b2().K2()) {
            i11 = chapterList.getCount();
        }
        zb.c t10 = this.f33123c.t(book, chapterList, i10, i11, new a(book));
        if (t10 != null) {
            t10.r();
            h(book, t10);
        } else {
            t(book);
        }
    }

    public synchronized void w(Book book, b bVar) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f33122b.get(book);
        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.contains(bVar)) {
            concurrentLinkedQueue.add(bVar);
            bVar.c(book);
        }
    }

    public synchronized void x(Book book, b bVar) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f33122b.get(book);
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.remove(bVar);
        }
    }

    public synchronized void y() {
        Iterator<Map.Entry<Book, ConcurrentLinkedQueue<b>>> it = this.f33122b.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().clear();
        }
    }
}
