package e5;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterators;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import javax.annotation.CheckForNull;

@a5.b
@a5.a
@m
@Deprecated
/* loaded from: classes2.dex */
public abstract class y1<T> {

    public class a extends y1<T> {

        /* renamed from: a */
        public final /* synthetic */ b5.n f25694a;

        public a(b5.n nVar) {
            this.f25694a = nVar;
        }

        @Override // e5.y1
        public Iterable<T> b(T t10) {
            return (Iterable) this.f25694a.apply(t10);
        }
    }

    public class b extends w<T> {

        /* renamed from: c */
        public final /* synthetic */ Object f25695c;

        public b(Object obj) {
            this.f25695c = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        /* renamed from: L */
        public z1<T> iterator() {
            return y1.this.e(this.f25695c);
        }
    }

    public class c extends w<T> {

        /* renamed from: c */
        public final /* synthetic */ Object f25697c;

        public c(Object obj) {
            this.f25697c = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Iterable
        /* renamed from: L */
        public z1<T> iterator() {
            return y1.this.c(this.f25697c);
        }
    }

    public class d extends w<T> {

        /* renamed from: c */
        public final /* synthetic */ Object f25699c;

        public d(Object obj) {
            this.f25699c = obj;
        }

        @Override // java.lang.Iterable
        /* renamed from: L */
        public z1<T> iterator() {
            return new e(this.f25699c);
        }
    }

    public final class e extends z1<T> implements e1<T> {

        /* renamed from: b */
        public final Queue<T> f25701b;

        public e(T t10) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f25701b = arrayDeque;
            arrayDeque.add(t10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f25701b.isEmpty();
        }

        @Override // java.util.Iterator, e5.e1
        public T next() {
            T remove = this.f25701b.remove();
            u0.a(this.f25701b, y1.this.b(remove));
            return remove;
        }

        @Override // e5.e1
        public T peek() {
            return this.f25701b.element();
        }
    }

    public final class f extends AbstractIterator<T> {

        /* renamed from: d */
        public final ArrayDeque<g<T>> f25703d;

        public f(T t10) {
            ArrayDeque<g<T>> arrayDeque = new ArrayDeque<>();
            this.f25703d = arrayDeque;
            arrayDeque.addLast(d(t10));
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public T a() {
            while (!this.f25703d.isEmpty()) {
                g<T> last = this.f25703d.getLast();
                if (!last.f25706b.hasNext()) {
                    this.f25703d.removeLast();
                    return last.f25705a;
                }
                this.f25703d.addLast(d(last.f25706b.next()));
            }
            return b();
        }

        public final g<T> d(T t10) {
            return new g<>(t10, y1.this.b(t10).iterator());
        }
    }

    public static final class g<T> {

        /* renamed from: a */
        public final T f25705a;

        /* renamed from: b */
        public final Iterator<T> f25706b;

        public g(T t10, Iterator<T> it) {
            this.f25705a = (T) b5.u.E(t10);
            this.f25706b = (Iterator) b5.u.E(it);
        }
    }

    public final class h extends z1<T> {

        /* renamed from: b */
        public final Deque<Iterator<T>> f25707b;

        public h(T t10) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f25707b = arrayDeque;
            arrayDeque.addLast(Iterators.Y(b5.u.E(t10)));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f25707b.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            Iterator<T> last = this.f25707b.getLast();
            T t10 = (T) b5.u.E(last.next());
            if (!last.hasNext()) {
                this.f25707b.removeLast();
            }
            Iterator<T> it = y1.this.b(t10).iterator();
            if (it.hasNext()) {
                this.f25707b.addLast(it);
            }
            return t10;
        }
    }

    @Deprecated
    public static <T> y1<T> g(b5.n<T, ? extends Iterable<T>> nVar) {
        b5.u.E(nVar);
        return new a(nVar);
    }

    @Deprecated
    public final w<T> a(T t10) {
        b5.u.E(t10);
        return new d(t10);
    }

    public abstract Iterable<T> b(T t10);

    public z1<T> c(T t10) {
        return new f(t10);
    }

    @Deprecated
    public final w<T> d(T t10) {
        b5.u.E(t10);
        return new c(t10);
    }

    public z1<T> e(T t10) {
        return new h(t10);
    }

    @Deprecated
    public final w<T> f(T t10) {
        b5.u.E(t10);
        return new b(t10);
    }
}
