package ek;

/* loaded from: classes5.dex */
public class c<T> implements qj.b<T> {

    /* renamed from: f */
    public static final int f25922f = Integer.MAX_VALUE;

    /* renamed from: g */
    public static final Object f25923g = new Object();

    /* renamed from: h */
    public static final Object f25924h = new Object();

    /* renamed from: b */
    public final qj.b<? super T> f25925b;

    /* renamed from: c */
    public boolean f25926c = false;

    /* renamed from: d */
    public boolean f25927d = false;

    /* renamed from: e */
    public b f25928e;

    public static final class a {

        /* renamed from: a */
        public final Throwable f25929a;

        public a(Throwable th2) {
            this.f25929a = th2;
        }
    }

    public static final class b {

        /* renamed from: a */
        public Object[] f25930a;

        /* renamed from: b */
        public int f25931b;

        public void a(Object obj) {
            int i10 = this.f25931b;
            Object[] objArr = this.f25930a;
            if (objArr == null) {
                objArr = new Object[16];
                this.f25930a = objArr;
            } else if (i10 == objArr.length) {
                Object[] objArr2 = new Object[(i10 >> 2) + i10];
                System.arraycopy(objArr, 0, objArr2, 0, i10);
                this.f25930a = objArr2;
                objArr = objArr2;
            }
            objArr[i10] = obj;
            this.f25931b = i10 + 1;
        }
    }

    public c(qj.b<? super T> bVar) {
        this.f25925b = bVar;
    }

    public void a(b bVar) {
        if (bVar == null || bVar.f25931b == 0) {
            return;
        }
        for (Object obj : bVar.f25930a) {
            if (obj == null) {
                return;
            }
            if (obj == f25923g) {
                this.f25925b.onNext(null);
            } else if (obj == f25924h) {
                this.f25925b.onCompleted();
            } else if (obj.getClass() == a.class) {
                this.f25925b.onError(((a) obj).f25929a);
            } else {
                this.f25925b.onNext(obj);
            }
        }
    }

    @Override // qj.b
    public void onCompleted() {
        synchronized (this) {
            try {
                if (this.f25927d) {
                    return;
                }
                this.f25927d = true;
                if (this.f25926c) {
                    if (this.f25928e == null) {
                        this.f25928e = new b();
                    }
                    this.f25928e.a(f25924h);
                } else {
                    this.f25926c = true;
                    b bVar = this.f25928e;
                    this.f25928e = null;
                    a(bVar);
                    this.f25925b.onCompleted();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // qj.b
    public void onError(Throwable th2) {
        vj.a.e(th2);
        synchronized (this) {
            try {
                if (this.f25927d) {
                    return;
                }
                if (this.f25926c) {
                    if (this.f25928e == null) {
                        this.f25928e = new b();
                    }
                    this.f25928e.a(new a(th2));
                    return;
                }
                this.f25926c = true;
                b bVar = this.f25928e;
                this.f25928e = null;
                a(bVar);
                this.f25925b.onError(th2);
                synchronized (this) {
                    this.f25926c = false;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // qj.b
    public void onNext(T t10) {
        synchronized (this) {
            try {
                if (this.f25927d) {
                    return;
                }
                if (this.f25926c) {
                    if (this.f25928e == null) {
                        this.f25928e = new b();
                    }
                    b bVar = this.f25928e;
                    if (t10 == null) {
                        t10 = (T) f25923g;
                    }
                    bVar.a(t10);
                    return;
                }
                boolean z10 = true;
                this.f25926c = true;
                b bVar2 = this.f25928e;
                b bVar3 = null;
                this.f25928e = null;
                int i10 = Integer.MAX_VALUE;
                do {
                    try {
                        a(bVar2);
                        if (i10 == Integer.MAX_VALUE) {
                            this.f25925b.onNext(t10);
                        }
                        i10--;
                        if (i10 > 0) {
                            try {
                                synchronized (this) {
                                    try {
                                        bVar2 = this.f25928e;
                                        this.f25928e = null;
                                        if (bVar2 == null) {
                                            this.f25926c = false;
                                            return;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z10 = false;
                                        try {
                                            throw th;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            if (!z10) {
                                                synchronized (this) {
                                                    try {
                                                        if (this.f25927d) {
                                                            this.f25928e = null;
                                                        } else {
                                                            this.f25926c = false;
                                                        }
                                                    } finally {
                                                    }
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z10 = false;
                    }
                } while (i10 > 0);
                synchronized (this) {
                    try {
                        if (this.f25927d) {
                            b bVar4 = this.f25928e;
                            this.f25928e = null;
                            bVar3 = bVar4;
                        } else {
                            this.f25926c = false;
                        }
                    } finally {
                    }
                }
                a(bVar3);
            } finally {
            }
        }
    }
}
