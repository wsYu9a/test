package com.opos.cmn.biz.monitor.a;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private b f16678a;

    /* renamed from: b */
    private int f16679b;

    /* renamed from: c */
    private int f16680c;

    /* renamed from: f */
    private InterfaceC0375a f16683f;

    /* renamed from: d */
    private volatile long f16681d = -1;

    /* renamed from: e */
    private volatile long f16682e = -1;

    /* renamed from: g */
    private Object f16684g = new Object();

    /* renamed from: com.opos.cmn.biz.monitor.a.a$1 */
    class AnonymousClass1 implements InterfaceC0375a {
        AnonymousClass1() {
        }

        @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0375a
        public void a() {
            a.this.a(this);
        }

        @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0375a
        public void b() {
            a.this.a(this);
        }
    }

    /* renamed from: com.opos.cmn.biz.monitor.a.a$a */
    public interface InterfaceC0375a {
        void a();

        void b();
    }

    public interface b {
        void a(InterfaceC0375a interfaceC0375a);
    }

    public a(b bVar, int i2, int i3) {
        this.f16678a = bVar;
        this.f16679b = i2;
        this.f16680c = i3;
    }

    public void a(InterfaceC0375a interfaceC0375a) {
        if (interfaceC0375a != this.f16683f) {
            return;
        }
        synchronized (this.f16684g) {
            if (this.f16683f == interfaceC0375a) {
                this.f16681d = -1L;
                this.f16682e = SystemClock.elapsedRealtime();
                this.f16683f = null;
            }
        }
    }

    public void a() {
        if (this.f16681d <= 0 || this.f16679b <= SystemClock.elapsedRealtime() - this.f16681d) {
            if (this.f16682e <= 0 || this.f16680c <= SystemClock.elapsedRealtime() - this.f16682e) {
                synchronized (this.f16684g) {
                    if ((this.f16681d <= 0 || this.f16679b <= SystemClock.elapsedRealtime() - this.f16681d) && (this.f16682e <= 0 || this.f16680c <= SystemClock.elapsedRealtime() - this.f16682e)) {
                        this.f16681d = SystemClock.elapsedRealtime();
                        this.f16682e = -1L;
                        AnonymousClass1 anonymousClass1 = new InterfaceC0375a() { // from class: com.opos.cmn.biz.monitor.a.a.1
                            AnonymousClass1() {
                            }

                            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0375a
                            public void a() {
                                a.this.a(this);
                            }

                            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0375a
                            public void b() {
                                a.this.a(this);
                            }
                        };
                        this.f16683f = anonymousClass1;
                        this.f16678a.a(anonymousClass1);
                    }
                }
            }
        }
    }
}
