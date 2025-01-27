package rx.internal.producers;

import rx.c;

/* loaded from: classes5.dex */
public final class a implements c {

    /* renamed from: a */
    static final c f36714a = new C0881a();

    /* renamed from: b */
    long f36715b;

    /* renamed from: c */
    c f36716c;

    /* renamed from: d */
    boolean f36717d;

    /* renamed from: e */
    long f36718e;

    /* renamed from: f */
    long f36719f;

    /* renamed from: g */
    c f36720g;

    /* renamed from: rx.internal.producers.a$a */
    static class C0881a implements c {
        C0881a() {
        }

        @Override // rx.c
        public void request(long j2) {
        }
    }

    public void a() {
        while (true) {
            synchronized (this) {
                long j2 = this.f36718e;
                long j3 = this.f36719f;
                c cVar = this.f36720g;
                if (j2 == 0 && j3 == 0 && cVar == null) {
                    this.f36717d = false;
                    return;
                }
                this.f36718e = 0L;
                this.f36719f = 0L;
                this.f36720g = null;
                long j4 = this.f36715b;
                if (j4 != Long.MAX_VALUE) {
                    long j5 = j4 + j2;
                    if (j5 < 0 || j5 == Long.MAX_VALUE) {
                        this.f36715b = Long.MAX_VALUE;
                        j4 = Long.MAX_VALUE;
                    } else {
                        j4 = j5 - j3;
                        if (j4 < 0) {
                            throw new IllegalStateException("more produced than requested");
                        }
                        this.f36715b = j4;
                    }
                }
                if (cVar == null) {
                    c cVar2 = this.f36716c;
                    if (cVar2 != null && j2 != 0) {
                        cVar2.request(j2);
                    }
                } else if (cVar == f36714a) {
                    this.f36716c = null;
                } else {
                    this.f36716c = cVar;
                    cVar.request(j4);
                }
            }
        }
    }

    public void b(long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("n > 0 required");
        }
        synchronized (this) {
            if (this.f36717d) {
                this.f36719f += j2;
                return;
            }
            this.f36717d = true;
            try {
                long j3 = this.f36715b;
                if (j3 != Long.MAX_VALUE) {
                    long j4 = j3 - j2;
                    if (j4 < 0) {
                        throw new IllegalStateException("more items arrived than were requested");
                    }
                    this.f36715b = j4;
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f36717d = false;
                    throw th;
                }
            }
        }
    }

    public void c(c cVar) {
        synchronized (this) {
            if (this.f36717d) {
                if (cVar == null) {
                    cVar = f36714a;
                }
                this.f36720g = cVar;
                return;
            }
            this.f36717d = true;
            try {
                this.f36716c = cVar;
                if (cVar != null) {
                    cVar.request(this.f36715b);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f36717d = false;
                    throw th;
                }
            }
        }
    }

    @Override // rx.c
    public void request(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j2 == 0) {
            return;
        }
        synchronized (this) {
            if (this.f36717d) {
                this.f36718e += j2;
                return;
            }
            this.f36717d = true;
            try {
                long j3 = this.f36715b + j2;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
                this.f36715b = j3;
                c cVar = this.f36716c;
                if (cVar != null) {
                    cVar.request(j2);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f36717d = false;
                    throw th;
                }
            }
        }
    }
}
