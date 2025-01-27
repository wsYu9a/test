package com.opos.mobad.service.e;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.g;
import com.opos.cmn.ac.AcTools;
import com.opos.cmn.an.b.c;
import com.opos.cmn.an.b.e;
import com.opos.cmn.g.a.b;
import com.opos.cmn.i.a;
import com.opos.mobad.provider.openId.IdModelIdentify;
import com.opos.mobad.provider.openId.OpenIdData;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static volatile a f23580a;

    /* renamed from: b */
    private volatile com.opos.mobad.provider.openId.a f23581b;

    /* renamed from: c */
    private Context f23582c;

    /* renamed from: i */
    private com.opos.cmn.i.a f23588i;

    /* renamed from: j */
    private com.opos.cmn.i.a f23589j;
    private com.opos.cmn.i.a k;

    /* renamed from: d */
    private String f23583d = "";

    /* renamed from: e */
    private String f23584e = "";

    /* renamed from: f */
    private String f23585f = "";

    /* renamed from: g */
    private String f23586g = "";

    /* renamed from: h */
    private String f23587h = "";
    private boolean l = true;
    private boolean m = true;
    private String n = "";
    private volatile String o = "";
    private volatile boolean p = false;

    /* renamed from: com.opos.mobad.service.e.a$1 */
    class AnonymousClass1 implements a.b {

        /* renamed from: com.opos.mobad.service.e.a$1$1 */
        class RunnableC04831 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0395a f23591a;

            RunnableC04831(a.InterfaceC0395a interfaceC0395a) {
                interfaceC0395a = interfaceC0395a;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!b.e(a.this.f23582c)) {
                        com.opos.cmn.an.f.a.a("IdentityIdManager", "unsupport id");
                    } else {
                        if (a.this.u() == null) {
                            com.opos.cmn.an.f.a.b("IdentityIdManager", "openIdData == null");
                            a.InterfaceC0395a interfaceC0395a = interfaceC0395a;
                            if (interfaceC0395a != null) {
                                interfaceC0395a.b();
                                return;
                            }
                            return;
                        }
                        com.opos.cmn.an.f.a.b("IdentityIdManager", "init succ");
                    }
                    a aVar = a.this;
                    String b2 = aVar.b(aVar.f23582c);
                    if (!TextUtils.isEmpty(b2)) {
                        a.this.f23586g = b2;
                    }
                    a.this.b();
                    a.this.c();
                    interfaceC0395a.a();
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("IdentityIdManager", "init error" + e2);
                    interfaceC0395a.b();
                }
            }
        }

        AnonymousClass1() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            com.opos.cmn.an.f.a.b("IdentityIdManager", "init");
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.e.a.1.1

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0395a f23591a;

                RunnableC04831(a.InterfaceC0395a interfaceC0395a2) {
                    interfaceC0395a = interfaceC0395a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!b.e(a.this.f23582c)) {
                            com.opos.cmn.an.f.a.a("IdentityIdManager", "unsupport id");
                        } else {
                            if (a.this.u() == null) {
                                com.opos.cmn.an.f.a.b("IdentityIdManager", "openIdData == null");
                                a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                                if (interfaceC0395a2 != null) {
                                    interfaceC0395a2.b();
                                    return;
                                }
                                return;
                            }
                            com.opos.cmn.an.f.a.b("IdentityIdManager", "init succ");
                        }
                        a aVar = a.this;
                        String b2 = aVar.b(aVar.f23582c);
                        if (!TextUtils.isEmpty(b2)) {
                            a.this.f23586g = b2;
                        }
                        a.this.b();
                        a.this.c();
                        interfaceC0395a.a();
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("IdentityIdManager", "init error" + e2);
                        interfaceC0395a.b();
                    }
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.service.e.a$2 */
    class AnonymousClass2 implements a.b {

        /* renamed from: com.opos.mobad.service.e.a$2$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0395a f23594a;

            AnonymousClass1(a.InterfaceC0395a interfaceC0395a) {
                interfaceC0395a = interfaceC0395a;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (TextUtils.isEmpty(a.this.v())) {
                        com.opos.cmn.an.f.a.b("IdentityIdManager", "clientIdData == null");
                        a.InterfaceC0395a interfaceC0395a = interfaceC0395a;
                        if (interfaceC0395a != null) {
                            interfaceC0395a.b();
                        }
                    } else {
                        com.opos.cmn.an.f.a.b("IdentityIdManager", "init clienitid succ");
                        interfaceC0395a.a();
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("IdentityIdManager", "init error" + e2);
                    interfaceC0395a.b();
                }
            }
        }

        AnonymousClass2() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            com.opos.cmn.an.f.a.b("IdentityIdManager", "initClientId");
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.e.a.2.1

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0395a f23594a;

                AnonymousClass1(a.InterfaceC0395a interfaceC0395a2) {
                    interfaceC0395a = interfaceC0395a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (TextUtils.isEmpty(a.this.v())) {
                            com.opos.cmn.an.f.a.b("IdentityIdManager", "clientIdData == null");
                            a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                            if (interfaceC0395a2 != null) {
                                interfaceC0395a2.b();
                            }
                        } else {
                            com.opos.cmn.an.f.a.b("IdentityIdManager", "init clienitid succ");
                            interfaceC0395a.a();
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("IdentityIdManager", "init error" + e2);
                        interfaceC0395a.b();
                    }
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.service.e.a$3 */
    class AnonymousClass3 implements a.b {
        AnonymousClass3() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
        }
    }

    /* renamed from: com.opos.mobad.service.e.a$4 */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a aVar = a.this;
                aVar.l = aVar.a(aVar.f23582c).b();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("IdentityIdManager", "update status error" + e2);
            }
        }
    }

    private a() {
    }

    public com.opos.mobad.provider.openId.a a(Context context) {
        com.opos.mobad.provider.openId.a aVar = this.f23581b;
        if (aVar == null) {
            synchronized (a.class) {
                aVar = this.f23581b;
                if (aVar == null) {
                    aVar = new com.opos.mobad.provider.openId.a(context.getApplicationContext(), new IdModelIdentify(com.opos.cmn.a.a.a(), com.opos.cmn.a.a.b()));
                    this.f23581b = aVar;
                }
            }
        }
        return aVar;
    }

    public static a a() {
        a aVar = f23580a;
        if (aVar == null) {
            synchronized (a.class) {
                aVar = f23580a;
                if (aVar == null) {
                    aVar = new a();
                    f23580a = aVar;
                }
            }
        }
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0036, code lost:
    
        if (r5 != null) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(android.content.Context r5) {
        /*
            r4 = this;
            android.content.ContentResolver r5 = r5.getContentResolver()
            java.lang.String r0 = "content://mk_ex"
            android.net.Uri r0 = android.net.Uri.parse(r0)
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r2 = ""
            r3 = 26
            if (r1 <= r3) goto L46
            r1 = 0
            android.content.ContentProviderClient r5 = r5.acquireUnstableContentProviderClient(r0)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L40
            if (r5 == 0) goto L36
            java.lang.String r0 = "query_vaid"
            android.os.Bundle r0 = r5.call(r0, r1, r1)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            java.lang.String r1 = "vaid_result"
            java.lang.String r2 = r0.getString(r1)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
        L25:
            r5.close()     // Catch: java.lang.Throwable -> L46
            goto L46
        L29:
            r0 = move-exception
            goto L32
        L2b:
            r0 = move-exception
            java.lang.String r1 = "IdentityIdManager"
            com.opos.cmn.an.f.a.b(r1, r2, r0)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L34
            goto L36
        L32:
            r1 = r5
            goto L3a
        L34:
            r1 = r5
            goto L41
        L36:
            if (r5 == 0) goto L46
            goto L25
        L39:
            r0 = move-exception
        L3a:
            if (r1 == 0) goto L3f
            r1.close()     // Catch: java.lang.Throwable -> L3f
        L3f:
            throw r0
        L40:
        L41:
            if (r1 == 0) goto L46
            r1.close()     // Catch: java.lang.Throwable -> L46
        L46:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.e.a.b(android.content.Context):java.lang.String");
    }

    private void o() {
        if (this.f23582c == null) {
            return;
        }
        this.k.a();
    }

    private void p() {
        if (TextUtils.isEmpty(this.f23583d) && TextUtils.isEmpty(this.f23584e) && this.f23582c != null) {
            this.f23588i.a();
        }
    }

    private void q() {
        Context context = this.f23582c;
        if (context == null) {
            return;
        }
        if (b.e(context)) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.e.a.4
                AnonymousClass4() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar = a.this;
                        aVar.l = aVar.a(aVar.f23582c).b();
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("IdentityIdManager", "update status error" + e2);
                    }
                }
            });
        } else {
            this.l = true;
        }
    }

    private void r() {
        if (TextUtils.isEmpty(this.f23587h) && this.f23582c != null && s() && t()) {
            this.f23589j.a();
        }
    }

    private boolean s() {
        return c.b() < 29;
    }

    private boolean t() {
        return com.opos.cmn.an.h.d.a.a(this.f23582c, g.f9318c) || com.opos.cmn.an.h.d.a.a(this.f23582c, g.f9324i);
    }

    public OpenIdData u() {
        OpenIdData a2;
        com.opos.cmn.an.f.a.b("IdentityIdManager", "start getOpenId");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            a2 = a(this.f23582c).a();
        } catch (Exception unused) {
        }
        if (a2 == null) {
            com.opos.cmn.an.f.a.b("IdentityIdManager", "openIdData == null");
            return null;
        }
        String str = a2.f23135a;
        if (!TextUtils.isEmpty(str)) {
            this.f23583d = str;
        }
        String str2 = a2.f23137c;
        if (!TextUtils.isEmpty(str2)) {
            this.f23585f = str2;
        }
        String str3 = a2.f23136b;
        if (!TextUtils.isEmpty(str3)) {
            this.f23584e = str3;
        }
        com.opos.cmn.an.f.a.b("IdentityIdManager", "getOpenId cost time = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return a2;
    }

    public String v() {
        String c2;
        com.opos.cmn.an.f.a.b("IdentityIdManager", "start getCryptClientId");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            c2 = a(this.f23582c).c();
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(c2)) {
            com.opos.cmn.an.f.a.b("IdentityIdManager", "clientIdData == null");
            return null;
        }
        this.f23587h = c2;
        com.opos.cmn.an.f.a.b("IdentityIdManager", "getCryptClientId cost time = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return this.f23587h;
    }

    public void a(Context context, boolean z) {
        this.f23582c = context.getApplicationContext();
        this.p = z;
        this.f23588i = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.e.a.1

            /* renamed from: com.opos.mobad.service.e.a$1$1 */
            class RunnableC04831 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0395a f23591a;

                RunnableC04831(a.InterfaceC0395a interfaceC0395a2) {
                    interfaceC0395a = interfaceC0395a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!b.e(a.this.f23582c)) {
                            com.opos.cmn.an.f.a.a("IdentityIdManager", "unsupport id");
                        } else {
                            if (a.this.u() == null) {
                                com.opos.cmn.an.f.a.b("IdentityIdManager", "openIdData == null");
                                a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                                if (interfaceC0395a2 != null) {
                                    interfaceC0395a2.b();
                                    return;
                                }
                                return;
                            }
                            com.opos.cmn.an.f.a.b("IdentityIdManager", "init succ");
                        }
                        a aVar = a.this;
                        String b2 = aVar.b(aVar.f23582c);
                        if (!TextUtils.isEmpty(b2)) {
                            a.this.f23586g = b2;
                        }
                        a.this.b();
                        a.this.c();
                        interfaceC0395a.a();
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("IdentityIdManager", "init error" + e2);
                        interfaceC0395a.b();
                    }
                }
            }

            AnonymousClass1() {
            }

            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0395a interfaceC0395a2) {
                com.opos.cmn.an.f.a.b("IdentityIdManager", "init");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.e.a.1.1

                    /* renamed from: a */
                    final /* synthetic */ a.InterfaceC0395a f23591a;

                    RunnableC04831(a.InterfaceC0395a interfaceC0395a22) {
                        interfaceC0395a = interfaceC0395a22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!b.e(a.this.f23582c)) {
                                com.opos.cmn.an.f.a.a("IdentityIdManager", "unsupport id");
                            } else {
                                if (a.this.u() == null) {
                                    com.opos.cmn.an.f.a.b("IdentityIdManager", "openIdData == null");
                                    a.InterfaceC0395a interfaceC0395a22 = interfaceC0395a;
                                    if (interfaceC0395a22 != null) {
                                        interfaceC0395a22.b();
                                        return;
                                    }
                                    return;
                                }
                                com.opos.cmn.an.f.a.b("IdentityIdManager", "init succ");
                            }
                            a aVar = a.this;
                            String b2 = aVar.b(aVar.f23582c);
                            if (!TextUtils.isEmpty(b2)) {
                                a.this.f23586g = b2;
                            }
                            a.this.b();
                            a.this.c();
                            interfaceC0395a.a();
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.a("IdentityIdManager", "init error" + e2);
                            interfaceC0395a.b();
                        }
                    }
                });
            }
        }, Integer.MAX_VALUE, 0);
        this.f23589j = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.e.a.2

            /* renamed from: com.opos.mobad.service.e.a$2$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0395a f23594a;

                AnonymousClass1(a.InterfaceC0395a interfaceC0395a2) {
                    interfaceC0395a = interfaceC0395a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (TextUtils.isEmpty(a.this.v())) {
                            com.opos.cmn.an.f.a.b("IdentityIdManager", "clientIdData == null");
                            a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                            if (interfaceC0395a2 != null) {
                                interfaceC0395a2.b();
                            }
                        } else {
                            com.opos.cmn.an.f.a.b("IdentityIdManager", "init clienitid succ");
                            interfaceC0395a.a();
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("IdentityIdManager", "init error" + e2);
                        interfaceC0395a.b();
                    }
                }
            }

            AnonymousClass2() {
            }

            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0395a interfaceC0395a2) {
                com.opos.cmn.an.f.a.b("IdentityIdManager", "initClientId");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.e.a.2.1

                    /* renamed from: a */
                    final /* synthetic */ a.InterfaceC0395a f23594a;

                    AnonymousClass1(a.InterfaceC0395a interfaceC0395a22) {
                        interfaceC0395a = interfaceC0395a22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (TextUtils.isEmpty(a.this.v())) {
                                com.opos.cmn.an.f.a.b("IdentityIdManager", "clientIdData == null");
                                a.InterfaceC0395a interfaceC0395a22 = interfaceC0395a;
                                if (interfaceC0395a22 != null) {
                                    interfaceC0395a22.b();
                                }
                            } else {
                                com.opos.cmn.an.f.a.b("IdentityIdManager", "init clienitid succ");
                                interfaceC0395a.a();
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.a("IdentityIdManager", "init error" + e2);
                            interfaceC0395a.b();
                        }
                    }
                });
            }
        }, Integer.MAX_VALUE, 0);
        this.k = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.e.a.3
            AnonymousClass3() {
            }

            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0395a interfaceC0395a) {
            }
        }, Integer.MAX_VALUE, 0);
        p();
        r();
        o();
    }

    public void a(boolean z) {
        this.m = z;
    }

    public String b() {
        return AcTools.isSoEnabled() ? AcTools.getBootMark() : "";
    }

    public String c() {
        return AcTools.isSoEnabled() ? AcTools.getUpdateMark() : "";
    }

    public boolean d() {
        com.opos.cmn.an.f.a.b("IdentityIdManager", "app status:" + this.m);
        return this.m;
    }

    public String e() {
        if (this.p) {
            return "";
        }
        String str = this.o;
        if (TextUtils.isEmpty(str)) {
            Context context = this.f23582c;
            if (context == null) {
                return "";
            }
            try {
                str = e.a(context);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.a("IdentityIdManager", "", th);
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            this.o = str;
        }
        return str;
    }

    public String f() {
        p();
        return this.f23583d;
    }

    public String g() {
        p();
        return this.f23584e;
    }

    public String h() {
        p();
        return this.f23585f;
    }

    public String i() {
        p();
        return this.f23586g;
    }

    public boolean j() {
        q();
        return this.l;
    }

    public String k() {
        r();
        return this.f23587h;
    }

    public String l() {
        this.k.a();
        return this.n;
    }

    public String m() {
        return (TextUtils.isEmpty(this.f23587h) && this.f23582c != null && s() && t()) ? v() : this.f23587h;
    }

    public String n() {
        Context context;
        if (TextUtils.isEmpty(this.f23583d) && TextUtils.isEmpty(this.f23584e) && (context = this.f23582c) != null && b.e(context)) {
            u();
        }
        return this.f23583d;
    }
}
