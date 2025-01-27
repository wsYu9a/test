package com.opos.mobad.service.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.opos.cmn.i.a;
import com.opos.mobad.service.j.m;

/* loaded from: classes4.dex */
public class n {

    /* renamed from: a */
    private static volatile n f23733a;

    /* renamed from: b */
    private Context f23734b;

    /* renamed from: c */
    private m f23735c;

    /* renamed from: d */
    private m f23736d;

    /* renamed from: e */
    private LruCache<String, m> f23737e;

    /* renamed from: f */
    private LruCache<String, m> f23738f;

    /* renamed from: g */
    private com.opos.cmn.i.a f23739g;

    /* renamed from: h */
    private com.opos.cmn.i.a f23740h;

    /* renamed from: i */
    private com.opos.cmn.i.a f23741i;

    /* renamed from: j */
    private String f23742j;
    private String k;
    private String l;
    private o m;

    /* renamed from: com.opos.mobad.service.j.n$1 */
    class AnonymousClass1 implements m.a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.service.j.m.a
        public void a(m mVar) {
            n.this.m.b(mVar.c(), mVar.d());
        }
    }

    /* renamed from: com.opos.mobad.service.j.n$2 */
    class AnonymousClass2 implements m.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.service.j.m.a
        public void a(m mVar) {
            n.this.m.a(mVar.c(), mVar.d());
        }
    }

    /* renamed from: com.opos.mobad.service.j.n$3 */
    class AnonymousClass3 implements a.b {
        AnonymousClass3() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            String str = n.this.f23742j;
            if (TextUtils.isEmpty(str)) {
                interfaceC0395a.b();
            } else {
                n.this.m.a(str);
                interfaceC0395a.a();
            }
        }
    }

    /* renamed from: com.opos.mobad.service.j.n$4 */
    class AnonymousClass4 implements a.b {
        AnonymousClass4() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            String str = n.this.k;
            if (TextUtils.isEmpty(str)) {
                interfaceC0395a.b();
            } else {
                n.this.m.b(str);
                interfaceC0395a.a();
            }
        }
    }

    /* renamed from: com.opos.mobad.service.j.n$5 */
    class AnonymousClass5 implements a.b {
        AnonymousClass5() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            String str = n.this.l;
            if (TextUtils.isEmpty(str)) {
                interfaceC0395a.b();
            } else {
                n.this.m.c(str);
                interfaceC0395a.a();
            }
        }
    }

    private n() {
    }

    public static final n a() {
        if (f23733a == null) {
            synchronized (n.class) {
                if (f23733a == null) {
                    f23733a = new n();
                }
            }
        }
        return f23733a;
    }

    public void a(Context context) {
        this.f23734b = context;
        this.m = new o(context);
        this.f23736d = new m(180000, 10, new m.a() { // from class: com.opos.mobad.service.j.n.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.service.j.m.a
            public void a(m mVar) {
                n.this.m.b(mVar.c(), mVar.d());
            }
        });
        this.f23735c = new m(180000, 10, new m.a() { // from class: com.opos.mobad.service.j.n.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.service.j.m.a
            public void a(m mVar) {
                n.this.m.a(mVar.c(), mVar.d());
            }
        });
        this.f23737e = new LruCache<>(10);
        this.f23738f = new LruCache<>(10);
        this.f23739g = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.j.n.3
            AnonymousClass3() {
            }

            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0395a interfaceC0395a) {
                String str = n.this.f23742j;
                if (TextUtils.isEmpty(str)) {
                    interfaceC0395a.b();
                } else {
                    n.this.m.a(str);
                    interfaceC0395a.a();
                }
            }
        }, 0, 180000);
        this.f23740h = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.j.n.4
            AnonymousClass4() {
            }

            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0395a interfaceC0395a) {
                String str = n.this.k;
                if (TextUtils.isEmpty(str)) {
                    interfaceC0395a.b();
                } else {
                    n.this.m.b(str);
                    interfaceC0395a.a();
                }
            }
        }, 0, 180000);
        this.f23741i = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.j.n.5
            AnonymousClass5() {
            }

            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0395a interfaceC0395a) {
                String str = n.this.l;
                if (TextUtils.isEmpty(str)) {
                    interfaceC0395a.b();
                } else {
                    n.this.m.c(str);
                    interfaceC0395a.a();
                }
            }
        }, 0, 180000);
    }

    public void a(String str) {
    }

    public void a(Throwable th) {
        o oVar = this.m;
        if (oVar != null) {
            oVar.a(th);
        }
    }

    public void a(boolean z) {
        if (this.f23734b == null) {
            return;
        }
        if (z) {
            this.f23735c.a();
        }
        this.f23735c.b();
    }

    public void b(String str) {
    }

    public void b(boolean z) {
        if (this.f23734b == null) {
            return;
        }
        if (z) {
            this.f23736d.a();
        }
        this.f23736d.b();
    }
}
