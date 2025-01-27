package xj;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import qj.a;

/* loaded from: classes5.dex */
public final class r1<T> implements a.n0<T, T> {

    /* renamed from: b */
    public final boolean f32593b;

    /* renamed from: c */
    public final T f32594c;

    public class a implements qj.c {

        /* renamed from: b */
        public final AtomicBoolean f32595b = new AtomicBoolean(false);

        /* renamed from: c */
        public final /* synthetic */ c f32596c;

        public a(c cVar) {
            this.f32596c = cVar;
        }

        @Override // qj.c
        public void request(long j10) {
            if (j10 <= 0 || !this.f32595b.compareAndSet(false, true)) {
                return;
            }
            this.f32596c.g(2L);
        }
    }

    public static class b {

        /* renamed from: a */
        public static final r1<?> f32598a = new r1<>((a) null);
    }

    public static final class c<T> extends qj.g<T> {

        /* renamed from: g */
        public final qj.g<? super T> f32599g;

        /* renamed from: h */
        public final boolean f32600h;

        /* renamed from: i */
        public final T f32601i;

        /* renamed from: j */
        public T f32602j;

        /* renamed from: k */
        public boolean f32603k = false;

        /* renamed from: l */
        public boolean f32604l = false;

        public c(qj.g<? super T> gVar, boolean z10, T t10) {
            this.f32599g = gVar;
            this.f32600h = z10;
            this.f32601i = t10;
        }

        public void g(long j10) {
            e(j10);
        }

        @Override // qj.b
        public void onCompleted() {
            if (this.f32604l) {
                return;
            }
            if (this.f32603k) {
                this.f32599g.onNext(this.f32602j);
                this.f32599g.onCompleted();
            } else if (!this.f32600h) {
                this.f32599g.onError(new NoSuchElementException("Sequence contains no elements"));
            } else {
                this.f32599g.onNext(this.f32601i);
                this.f32599g.onCompleted();
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32599g.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (!this.f32603k) {
                this.f32602j = t10;
                this.f32603k = true;
            } else {
                this.f32604l = true;
                this.f32599g.onError(new IllegalArgumentException("Sequence contains too many elements"));
                unsubscribe();
            }
        }
    }

    public /* synthetic */ r1(a aVar) {
        this();
    }

    public static <T> r1<T> a() {
        return (r1<T>) b.f32598a;
    }

    public r1() {
        this(false, null);
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super T> gVar) {
        c cVar = new c(gVar, this.f32593b, this.f32594c);
        gVar.f(new a(cVar));
        gVar.b(cVar);
        return cVar;
    }

    public r1(T t10) {
        this(true, t10);
    }

    public r1(boolean z10, T t10) {
        this.f32593b = z10;
        this.f32594c = t10;
    }
}
