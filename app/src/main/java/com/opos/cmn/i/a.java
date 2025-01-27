package com.opos.cmn.i;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private b f17421a;

    /* renamed from: b */
    private int f17422b;

    /* renamed from: c */
    private int f17423c;

    /* renamed from: d */
    private volatile long f17424d;

    /* renamed from: e */
    private volatile long f17425e;

    /* renamed from: f */
    private InterfaceC0395a f17426f;

    /* renamed from: g */
    private Object f17427g;

    /* renamed from: com.opos.cmn.i.a$1 */
    class AnonymousClass1 implements InterfaceC0395a {
        AnonymousClass1() {
        }

        @Override // com.opos.cmn.i.a.InterfaceC0395a
        public void a() {
            a.this.a(this, true);
        }

        @Override // com.opos.cmn.i.a.InterfaceC0395a
        public void b() {
            a.this.a(this, false);
        }
    }

    /* renamed from: com.opos.cmn.i.a$a */
    public interface InterfaceC0395a {
        void a();

        void b();
    }

    public interface b {
        void a(InterfaceC0395a interfaceC0395a);
    }

    public a(b bVar) {
        this(bVar, Integer.MAX_VALUE, 0);
    }

    public a(b bVar, int i2, int i3) {
        this.f17424d = -1L;
        this.f17425e = -1L;
        this.f17427g = new Object();
        this.f17421a = bVar;
        this.f17422b = i2;
        this.f17423c = i3;
    }

    public void a(InterfaceC0395a interfaceC0395a, boolean z) {
        if (interfaceC0395a != this.f17426f) {
            return;
        }
        synchronized (this.f17427g) {
            if (this.f17426f == interfaceC0395a) {
                this.f17424d = -1L;
                if (z) {
                    this.f17425e = SystemClock.elapsedRealtime();
                }
                this.f17426f = null;
            }
        }
    }

    public void a() {
        if (this.f17424d <= 0 || this.f17422b <= SystemClock.elapsedRealtime() - this.f17424d) {
            if (this.f17425e <= 0 || this.f17423c <= SystemClock.elapsedRealtime() - this.f17425e) {
                synchronized (this.f17427g) {
                    if ((this.f17424d <= 0 || this.f17422b <= SystemClock.elapsedRealtime() - this.f17424d) && (this.f17425e <= 0 || this.f17423c <= SystemClock.elapsedRealtime() - this.f17425e)) {
                        this.f17424d = SystemClock.elapsedRealtime();
                        this.f17425e = -1L;
                        AnonymousClass1 anonymousClass1 = new InterfaceC0395a() { // from class: com.opos.cmn.i.a.1
                            AnonymousClass1() {
                            }

                            @Override // com.opos.cmn.i.a.InterfaceC0395a
                            public void a() {
                                a.this.a(this, true);
                            }

                            @Override // com.opos.cmn.i.a.InterfaceC0395a
                            public void b() {
                                a.this.a(this, false);
                            }
                        };
                        this.f17426f = anonymousClass1;
                        this.f17421a.a(anonymousClass1);
                    }
                }
            }
        }
    }
}
