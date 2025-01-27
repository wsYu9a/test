package com.opos.cmn.biz.requeststatistic.a;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private b f16775a;

    /* renamed from: b */
    private int f16776b;

    /* renamed from: c */
    private int f16777c;

    /* renamed from: d */
    private volatile long f16778d;

    /* renamed from: e */
    private volatile long f16779e;

    /* renamed from: f */
    private InterfaceC0381a f16780f;

    /* renamed from: g */
    private Object f16781g;

    /* renamed from: com.opos.cmn.biz.requeststatistic.a.a$1 */
    final class AnonymousClass1 implements InterfaceC0381a {
        AnonymousClass1() {
        }

        @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0381a
        public final void a() {
            a.a(a.this, this);
        }

        @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0381a
        public final void b() {
            a.a(a.this, this);
        }
    }

    /* renamed from: com.opos.cmn.biz.requeststatistic.a.a$a */
    public interface InterfaceC0381a {
        void a();

        void b();
    }

    public interface b {
        void a(InterfaceC0381a interfaceC0381a);
    }

    public a(b bVar) {
        this(bVar, 0);
    }

    public a(b bVar, int i2) {
        this.f16778d = -1L;
        this.f16779e = -1L;
        this.f16781g = new Object();
        this.f16775a = bVar;
        this.f16776b = Integer.MAX_VALUE;
        this.f16777c = i2;
    }

    static /* synthetic */ void a(a aVar, InterfaceC0381a interfaceC0381a) {
        if (interfaceC0381a == aVar.f16780f) {
            synchronized (aVar.f16781g) {
                if (aVar.f16780f == interfaceC0381a) {
                    aVar.f16778d = -1L;
                    aVar.f16779e = SystemClock.elapsedRealtime();
                    aVar.f16780f = null;
                }
            }
        }
    }

    public final void a() {
        if (this.f16778d <= 0 || this.f16776b <= SystemClock.elapsedRealtime() - this.f16778d) {
            if (this.f16779e <= 0 || this.f16777c <= SystemClock.elapsedRealtime() - this.f16779e) {
                synchronized (this.f16781g) {
                    if ((this.f16778d <= 0 || this.f16776b <= SystemClock.elapsedRealtime() - this.f16778d) && (this.f16779e <= 0 || this.f16777c <= SystemClock.elapsedRealtime() - this.f16779e)) {
                        this.f16778d = SystemClock.elapsedRealtime();
                        this.f16779e = -1L;
                        AnonymousClass1 anonymousClass1 = new InterfaceC0381a() { // from class: com.opos.cmn.biz.requeststatistic.a.a.1
                            AnonymousClass1() {
                            }

                            @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0381a
                            public final void a() {
                                a.a(a.this, this);
                            }

                            @Override // com.opos.cmn.biz.requeststatistic.a.a.InterfaceC0381a
                            public final void b() {
                                a.a(a.this, this);
                            }
                        };
                        this.f16780f = anonymousClass1;
                        this.f16775a.a(anonymousClass1);
                    }
                }
            }
        }
    }
}
