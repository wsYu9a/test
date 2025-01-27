package com.opos.cmn.an.e;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private b f16376a;

    /* renamed from: b */
    private int f16377b;

    /* renamed from: c */
    private int f16378c;

    /* renamed from: d */
    private volatile long f16379d;

    /* renamed from: e */
    private volatile long f16380e;

    /* renamed from: f */
    private InterfaceC0368a f16381f;

    /* renamed from: g */
    private Object f16382g;

    /* renamed from: com.opos.cmn.an.e.a$1 */
    class AnonymousClass1 implements InterfaceC0368a {
        AnonymousClass1() {
        }

        @Override // com.opos.cmn.an.e.a.InterfaceC0368a
        public void a() {
            a.this.a(this, true);
        }

        @Override // com.opos.cmn.an.e.a.InterfaceC0368a
        public void b() {
            a.this.a(this, false);
        }
    }

    /* renamed from: com.opos.cmn.an.e.a$a */
    public interface InterfaceC0368a {
        void a();

        void b();
    }

    public interface b {
        void a(InterfaceC0368a interfaceC0368a);
    }

    public a(b bVar) {
        this(bVar, Integer.MAX_VALUE, 0);
    }

    public a(b bVar, int i2, int i3) {
        this.f16379d = -1L;
        this.f16380e = -1L;
        this.f16382g = new Object();
        this.f16376a = bVar;
        this.f16377b = i2;
        this.f16378c = i3;
    }

    public void a(InterfaceC0368a interfaceC0368a, boolean z) {
        if (interfaceC0368a != this.f16381f) {
            return;
        }
        synchronized (this.f16382g) {
            if (this.f16381f == interfaceC0368a) {
                this.f16379d = -1L;
                if (z) {
                    this.f16380e = SystemClock.elapsedRealtime();
                }
                this.f16381f = null;
            }
        }
    }

    public void a() {
        if (this.f16379d <= 0 || this.f16377b <= SystemClock.elapsedRealtime() - this.f16379d) {
            if (this.f16380e <= 0 || this.f16378c <= SystemClock.elapsedRealtime() - this.f16380e) {
                synchronized (this.f16382g) {
                    if ((this.f16379d <= 0 || this.f16377b <= SystemClock.elapsedRealtime() - this.f16379d) && (this.f16380e <= 0 || this.f16378c <= SystemClock.elapsedRealtime() - this.f16380e)) {
                        this.f16379d = SystemClock.elapsedRealtime();
                        this.f16380e = -1L;
                        AnonymousClass1 anonymousClass1 = new InterfaceC0368a() { // from class: com.opos.cmn.an.e.a.1
                            AnonymousClass1() {
                            }

                            @Override // com.opos.cmn.an.e.a.InterfaceC0368a
                            public void a() {
                                a.this.a(this, true);
                            }

                            @Override // com.opos.cmn.an.e.a.InterfaceC0368a
                            public void b() {
                                a.this.a(this, false);
                            }
                        };
                        this.f16381f = anonymousClass1;
                        this.f16376a.a(anonymousClass1);
                    }
                }
            }
        }
    }
}
