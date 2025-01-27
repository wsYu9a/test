package rx.l;

/* loaded from: classes5.dex */
public class c<T> implements rx.b<T> {

    /* renamed from: a */
    private static final int f36884a = Integer.MAX_VALUE;

    /* renamed from: b */
    private static final Object f36885b = new Object();

    /* renamed from: c */
    private static final Object f36886c = new Object();

    /* renamed from: d */
    private final rx.b<? super T> f36887d;

    /* renamed from: e */
    private boolean f36888e = false;

    /* renamed from: f */
    private boolean f36889f = false;

    /* renamed from: g */
    private b f36890g;

    private static final class a {

        /* renamed from: a */
        final Throwable f36891a;

        a(Throwable th) {
            this.f36891a = th;
        }
    }

    static final class b {

        /* renamed from: a */
        Object[] f36892a;

        /* renamed from: b */
        int f36893b;

        b() {
        }

        public void a(Object obj) {
            int i2 = this.f36893b;
            Object[] objArr = this.f36892a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f36892a = objArr;
            } else if (i2 == objArr.length) {
                Object[] objArr2 = new Object[(i2 >> 2) + i2];
                System.arraycopy(objArr, 0, objArr2, 0, i2);
                this.f36892a = objArr2;
                objArr = objArr2;
            }
            objArr[i2] = obj;
            this.f36893b = i2 + 1;
        }
    }

    public c(rx.b<? super T> bVar) {
        this.f36887d = bVar;
    }

    void a(b bVar) {
        if (bVar == null || bVar.f36893b == 0) {
            return;
        }
        for (Object obj : bVar.f36892a) {
            if (obj == null) {
                return;
            }
            if (obj == f36885b) {
                this.f36887d.onNext(null);
            } else if (obj == f36886c) {
                this.f36887d.onCompleted();
            } else if (obj.getClass() == a.class) {
                this.f36887d.onError(((a) obj).f36891a);
            } else {
                this.f36887d.onNext(obj);
            }
        }
    }

    @Override // rx.b
    public void onCompleted() {
        synchronized (this) {
            if (this.f36889f) {
                return;
            }
            this.f36889f = true;
            if (this.f36888e) {
                if (this.f36890g == null) {
                    this.f36890g = new b();
                }
                this.f36890g.a(f36886c);
            } else {
                this.f36888e = true;
                b bVar = this.f36890g;
                this.f36890g = null;
                a(bVar);
                this.f36887d.onCompleted();
            }
        }
    }

    @Override // rx.b
    public void onError(Throwable th) {
        rx.exceptions.a.e(th);
        synchronized (this) {
            if (this.f36889f) {
                return;
            }
            if (this.f36888e) {
                if (this.f36890g == null) {
                    this.f36890g = new b();
                }
                this.f36890g.a(new a(th));
                return;
            }
            this.f36888e = true;
            b bVar = this.f36890g;
            this.f36890g = null;
            a(bVar);
            this.f36887d.onError(th);
            synchronized (this) {
                this.f36888e = false;
            }
        }
    }

    @Override // rx.b
    public void onNext(T t) {
        synchronized (this) {
            if (this.f36889f) {
                return;
            }
            if (this.f36888e) {
                if (this.f36890g == null) {
                    this.f36890g = new b();
                }
                b bVar = this.f36890g;
                if (t == null) {
                    t = (T) f36885b;
                }
                bVar.a(t);
                return;
            }
            boolean z = true;
            this.f36888e = true;
            b bVar2 = this.f36890g;
            b bVar3 = null;
            this.f36890g = null;
            int i2 = Integer.MAX_VALUE;
            do {
                try {
                    a(bVar2);
                    if (i2 == Integer.MAX_VALUE) {
                        this.f36887d.onNext(t);
                    }
                    i2--;
                    if (i2 > 0) {
                        try {
                            synchronized (this) {
                                try {
                                    bVar2 = this.f36890g;
                                    this.f36890g = null;
                                    if (bVar2 == null) {
                                        this.f36888e = false;
                                        return;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (!z) {
                                            synchronized (this) {
                                                if (this.f36889f) {
                                                    this.f36890g = null;
                                                } else {
                                                    this.f36888e = false;
                                                }
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z = false;
                }
            } while (i2 > 0);
            synchronized (this) {
                if (this.f36889f) {
                    b bVar4 = this.f36890g;
                    this.f36890g = null;
                    bVar3 = bVar4;
                } else {
                    this.f36888e = false;
                }
            }
            a(bVar3);
        }
    }
}
