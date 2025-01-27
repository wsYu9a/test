package yj;

import qj.c;

/* loaded from: classes5.dex */
public final class a implements c {

    /* renamed from: h */
    public static final c f33546h = new C0850a();

    /* renamed from: b */
    public long f33547b;

    /* renamed from: c */
    public c f33548c;

    /* renamed from: d */
    public boolean f33549d;

    /* renamed from: e */
    public long f33550e;

    /* renamed from: f */
    public long f33551f;

    /* renamed from: g */
    public c f33552g;

    public void a() {
        while (true) {
            synchronized (this) {
                try {
                    long j10 = this.f33550e;
                    long j11 = this.f33551f;
                    c cVar = this.f33552g;
                    if (j10 == 0 && j11 == 0 && cVar == null) {
                        this.f33549d = false;
                        return;
                    }
                    this.f33550e = 0L;
                    this.f33551f = 0L;
                    this.f33552g = null;
                    long j12 = this.f33547b;
                    if (j12 != Long.MAX_VALUE) {
                        long j13 = j12 + j10;
                        if (j13 < 0 || j13 == Long.MAX_VALUE) {
                            this.f33547b = Long.MAX_VALUE;
                            j12 = Long.MAX_VALUE;
                        } else {
                            j12 = j13 - j11;
                            if (j12 < 0) {
                                throw new IllegalStateException("more produced than requested");
                            }
                            this.f33547b = j12;
                        }
                    }
                    if (cVar == null) {
                        c cVar2 = this.f33548c;
                        if (cVar2 != null && j10 != 0) {
                            cVar2.request(j10);
                        }
                    } else if (cVar == f33546h) {
                        this.f33548c = null;
                    } else {
                        this.f33548c = cVar;
                        cVar.request(j12);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void b(long j10) {
        if (j10 <= 0) {
            throw new IllegalArgumentException("n > 0 required");
        }
        synchronized (this) {
            try {
                if (this.f33549d) {
                    this.f33551f += j10;
                    return;
                }
                this.f33549d = true;
                try {
                    long j11 = this.f33547b;
                    if (j11 != Long.MAX_VALUE) {
                        long j12 = j11 - j10;
                        if (j12 < 0) {
                            throw new IllegalStateException("more items arrived than were requested");
                        }
                        this.f33547b = j12;
                    }
                    a();
                } catch (Throwable th2) {
                    synchronized (this) {
                        this.f33549d = false;
                        throw th2;
                    }
                }
            } finally {
            }
        }
    }

    public void c(c cVar) {
        synchronized (this) {
            try {
                if (this.f33549d) {
                    if (cVar == null) {
                        cVar = f33546h;
                    }
                    this.f33552g = cVar;
                    return;
                }
                this.f33549d = true;
                try {
                    this.f33548c = cVar;
                    if (cVar != null) {
                        cVar.request(this.f33547b);
                    }
                    a();
                } catch (Throwable th2) {
                    synchronized (this) {
                        this.f33549d = false;
                        throw th2;
                    }
                }
            } finally {
            }
        }
    }

    @Override // qj.c
    public void request(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j10 == 0) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f33549d) {
                    this.f33550e += j10;
                    return;
                }
                this.f33549d = true;
                try {
                    long j11 = this.f33547b + j10;
                    if (j11 < 0) {
                        j11 = Long.MAX_VALUE;
                    }
                    this.f33547b = j11;
                    c cVar = this.f33548c;
                    if (cVar != null) {
                        cVar.request(j10);
                    }
                    a();
                } catch (Throwable th2) {
                    synchronized (this) {
                        this.f33549d = false;
                        throw th2;
                    }
                }
            } finally {
            }
        }
    }

    /* renamed from: yj.a$a */
    public static class C0850a implements c {
        @Override // qj.c
        public void request(long j10) {
        }
    }
}
