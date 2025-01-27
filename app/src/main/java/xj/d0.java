package xj;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import qj.a;

/* loaded from: classes5.dex */
public final class d0<T> implements a.n0<List<T>, T> {

    /* renamed from: b */
    public final int f32123b;

    /* renamed from: c */
    public final int f32124c;

    public class a extends qj.g<T> {

        /* renamed from: g */
        public List<T> f32125g;

        /* renamed from: h */
        public final /* synthetic */ qj.g f32126h;

        /* renamed from: xj.d0$a$a */
        public class C0815a implements qj.c {

            /* renamed from: b */
            public volatile boolean f32128b = false;

            /* renamed from: c */
            public final /* synthetic */ qj.c f32129c;

            public C0815a(qj.c cVar) {
                this.f32129c = cVar;
            }

            @Override // qj.c
            public void request(long j10) {
                if (this.f32128b) {
                    return;
                }
                int i10 = d0.this.f32123b;
                if (j10 < Long.MAX_VALUE / i10) {
                    this.f32129c.request(j10 * i10);
                } else {
                    this.f32128b = true;
                    this.f32129c.request(Long.MAX_VALUE);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32126h = gVar2;
        }

        @Override // qj.g
        public void f(qj.c cVar) {
            this.f32126h.f(new C0815a(cVar));
        }

        @Override // qj.b
        public void onCompleted() {
            List<T> list = this.f32125g;
            this.f32125g = null;
            if (list != null) {
                try {
                    this.f32126h.onNext(list);
                } catch (Throwable th2) {
                    onError(th2);
                    return;
                }
            }
            this.f32126h.onCompleted();
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32125g = null;
            this.f32126h.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            if (this.f32125g == null) {
                this.f32125g = new ArrayList(d0.this.f32123b);
            }
            this.f32125g.add(t10);
            if (this.f32125g.size() == d0.this.f32123b) {
                List<T> list = this.f32125g;
                this.f32125g = null;
                this.f32126h.onNext(list);
            }
        }
    }

    public class b extends qj.g<T> {

        /* renamed from: g */
        public final List<List<T>> f32131g;

        /* renamed from: h */
        public int f32132h;

        /* renamed from: i */
        public final /* synthetic */ qj.g f32133i;

        public class a implements qj.c {

            /* renamed from: b */
            public volatile boolean f32135b = true;

            /* renamed from: c */
            public volatile boolean f32136c = false;

            /* renamed from: d */
            public final /* synthetic */ qj.c f32137d;

            public a(qj.c cVar) {
                this.f32137d = cVar;
            }

            public final void a() {
                this.f32136c = true;
                this.f32137d.request(Long.MAX_VALUE);
            }

            @Override // qj.c
            public void request(long j10) {
                if (j10 == 0) {
                    return;
                }
                if (j10 < 0) {
                    throw new IllegalArgumentException("request a negative number: " + j10);
                }
                if (this.f32136c) {
                    return;
                }
                if (j10 == Long.MAX_VALUE) {
                    a();
                    return;
                }
                if (!this.f32135b) {
                    int i10 = d0.this.f32124c;
                    if (j10 >= Long.MAX_VALUE / i10) {
                        a();
                        return;
                    } else {
                        this.f32137d.request(i10 * j10);
                        return;
                    }
                }
                this.f32135b = false;
                long j11 = j10 - 1;
                d0 d0Var = d0.this;
                int i11 = d0Var.f32123b;
                int i12 = d0Var.f32124c;
                if (j11 >= (Long.MAX_VALUE - i11) / i12) {
                    a();
                } else {
                    this.f32137d.request(i11 + (i12 * j11));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qj.g gVar, qj.g gVar2) {
            super(gVar);
            this.f32133i = gVar2;
            this.f32131g = new LinkedList();
        }

        @Override // qj.g
        public void f(qj.c cVar) {
            this.f32133i.f(new a(cVar));
        }

        @Override // qj.b
        public void onCompleted() {
            try {
                Iterator<List<T>> it = this.f32131g.iterator();
                while (it.hasNext()) {
                    this.f32133i.onNext(it.next());
                }
                this.f32133i.onCompleted();
            } catch (Throwable th2) {
                onError(th2);
            } finally {
                this.f32131g.clear();
            }
        }

        @Override // qj.b
        public void onError(Throwable th2) {
            this.f32131g.clear();
            this.f32133i.onError(th2);
        }

        @Override // qj.b
        public void onNext(T t10) {
            int i10 = this.f32132h;
            this.f32132h = i10 + 1;
            if (i10 % d0.this.f32124c == 0) {
                this.f32131g.add(new ArrayList(d0.this.f32123b));
            }
            Iterator<List<T>> it = this.f32131g.iterator();
            while (it.hasNext()) {
                List<T> next = it.next();
                next.add(t10);
                if (next.size() == d0.this.f32123b) {
                    it.remove();
                    this.f32133i.onNext(next);
                }
            }
        }
    }

    public d0(int i10, int i11) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("count must be greater than 0");
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException("skip must be greater than 0");
        }
        this.f32123b = i10;
        this.f32124c = i11;
    }

    @Override // wj.o
    public qj.g<? super T> call(qj.g<? super List<T>> gVar) {
        return this.f32123b == this.f32124c ? new a(gVar, gVar) : new b(gVar, gVar);
    }
}
