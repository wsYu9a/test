package com.opos.mobad.f;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.heytap.nearx.tapplugin.pluginapi.PluginApi;
import com.opos.mobad.ad.c;
import com.opos.mobad.ad.c.g;
import com.opos.mobad.ad.c.j;
import com.opos.mobad.ad.c.m;
import com.opos.mobad.ad.c.n;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.s;
import com.opos.mobad.provider.MobAdGlobalProvider;
import com.opos.mobad.service.f.a;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: com.opos.mobad.f.e$1 */
    class AnonymousClass1 implements a.c {

        /* renamed from: a */
        final /* synthetic */ Context f20814a;

        /* renamed from: c */
        private String f20816c;

        /* renamed from: d */
        private String f20817d;

        /* renamed from: e */
        private Boolean f20818e;

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.opos.mobad.service.f.a.c
        public String a() {
            if (TextUtils.isEmpty(this.f20816c)) {
                this.f20816c = com.opos.mobad.cmn.a.b.c.a(context);
            }
            return this.f20816c;
        }

        @Override // com.opos.mobad.service.f.a.c
        public String b() {
            if (TextUtils.isEmpty(this.f20817d)) {
                this.f20817d = com.opos.mobad.cmn.a.b.c.a();
            }
            return this.f20817d;
        }

        @Override // com.opos.mobad.service.f.a.c
        public boolean c() {
            if (this.f20818e == null) {
                this.f20818e = Boolean.valueOf(com.opos.mobad.cmn.a.b.c.b(context));
            }
            return this.f20818e.booleanValue();
        }

        @Override // com.opos.mobad.service.f.a.c
        public void d() {
            this.f20816c = com.opos.mobad.cmn.a.b.c.a(context);
            this.f20817d = com.opos.mobad.cmn.a.b.c.a();
            this.f20818e = Boolean.valueOf(com.opos.mobad.cmn.a.b.c.b(context));
        }
    }

    /* renamed from: com.opos.mobad.f.e$2 */
    class AnonymousClass2 implements a.g {

        /* renamed from: a */
        final /* synthetic */ Context f20819a;

        /* renamed from: c */
        private String f20821c;

        /* renamed from: d */
        private String f20822d;

        /* renamed from: e */
        private Boolean f20823e;

        AnonymousClass2(Context context) {
            context = context;
        }

        @Override // com.opos.mobad.service.f.a.g
        public String a() {
            if (TextUtils.isEmpty(this.f20821c)) {
                this.f20821c = com.opos.mobad.cmn.a.b.c.a(context);
            }
            return this.f20821c;
        }

        @Override // com.opos.mobad.service.f.a.g
        public String b() {
            if (TextUtils.isEmpty(this.f20822d)) {
                this.f20822d = com.opos.mobad.cmn.a.b.c.a();
            }
            return this.f20822d;
        }

        @Override // com.opos.mobad.service.f.a.g
        public boolean c() {
            if (this.f20823e == null) {
                this.f20823e = Boolean.valueOf(com.opos.mobad.cmn.a.b.c.b(context));
            }
            return this.f20823e.booleanValue();
        }

        @Override // com.opos.mobad.service.f.a.g
        public void d() {
            this.f20821c = com.opos.mobad.cmn.a.b.c.a(context);
            this.f20822d = com.opos.mobad.cmn.a.b.c.a();
            this.f20823e = Boolean.valueOf(com.opos.mobad.cmn.a.b.c.b(context));
        }
    }

    /* renamed from: com.opos.mobad.f.e$3 */
    class AnonymousClass3 implements a.InterfaceC0485a {

        /* renamed from: a */
        final /* synthetic */ String f20824a;

        /* renamed from: b */
        final /* synthetic */ Context f20825b;

        /* renamed from: d */
        private String f20827d;

        /* renamed from: e */
        private String f20828e;

        /* renamed from: f */
        private int f20829f = -1;

        AnonymousClass3(String str, Context context) {
            str = str;
            context = context;
        }

        @Override // com.opos.mobad.service.f.a.InterfaceC0485a
        public String a() {
            return str;
        }

        @Override // com.opos.mobad.service.f.a.InterfaceC0485a
        public String b() {
            if (TextUtils.isEmpty(this.f20827d)) {
                this.f20827d = context.getPackageName();
            }
            return this.f20827d;
        }

        @Override // com.opos.mobad.service.f.a.InterfaceC0485a
        public String c() {
            if (TextUtils.isEmpty(this.f20828e)) {
                Context context = context;
                this.f20828e = com.opos.cmn.an.h.d.a.c(context, context.getPackageName());
            }
            return this.f20828e;
        }
    }

    /* renamed from: com.opos.mobad.f.e$4 */
    class AnonymousClass4 implements a.f {

        /* renamed from: a */
        final /* synthetic */ int f20830a;

        AnonymousClass4(int i2) {
            i2 = i2;
        }

        @Override // com.opos.mobad.service.f.a.f
        public int a() {
            return 481004;
        }

        @Override // com.opos.mobad.service.f.a.f
        public String b() {
            return "4.8.1";
        }

        @Override // com.opos.mobad.service.f.a.f
        public int c() {
            return i2;
        }
    }

    /* renamed from: com.opos.mobad.f.e$5 */
    class AnonymousClass5 implements a.b {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.ad.d f20832a;

        AnonymousClass5(com.opos.mobad.ad.d dVar) {
            dVar = dVar;
        }

        @Override // com.opos.mobad.service.f.a.b
        public String a() {
            return dVar.a();
        }
    }

    private void b() {
    }

    public com.opos.mobad.ad.a.a a(Activity activity, String str, com.opos.mobad.ad.a.b bVar) {
        return c.d().a(activity, str, bVar);
    }

    public com.opos.mobad.ad.b.a a(Activity activity, String str, com.opos.mobad.ad.b.b bVar) {
        return c.d().a(activity, str, bVar);
    }

    public com.opos.mobad.ad.b.c a(Activity activity, String str, com.opos.mobad.ad.b.d dVar) {
        return c.d().a(activity, str, dVar);
    }

    public com.opos.mobad.ad.c.c a(Context context, String str, int i2, m mVar) {
        return c.d().a(context, str, i2, mVar);
    }

    public com.opos.mobad.ad.c.c a(Context context, String str, com.opos.mobad.ad.c.f fVar) {
        return c.d().a(context, str, fVar);
    }

    public g a(Context context, String str, j jVar) {
        return c.d().a(context, str, jVar);
    }

    public n a(Context context, String str, s sVar, o oVar) {
        return c.d().a(context, str, sVar, oVar);
    }

    public com.opos.mobad.ad.d.a a(Context context, String str, com.opos.mobad.ad.d.b bVar) {
        return c.d().a(context, str, bVar);
    }

    public com.opos.mobad.ad.e.a a(Context context, String str, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        return c.d().a(context, str, cVar, fVar);
    }

    public com.opos.mobad.ad.e.b a(Activity activity, String str, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        return c.d().a(activity, str, cVar, fVar);
    }

    public void a(Context context) {
        if (context == null) {
            com.opos.cmn.an.f.a.d("", "exit with null context");
            return;
        }
        com.opos.mobad.service.f.e();
        c.b(com.opos.mobad.service.b.a(context));
        com.opos.mobad.service.b.a();
    }

    public void a(Context context, String str, int i2) {
        a(context, str, i2, (com.opos.mobad.ad.e) null);
    }

    public void a(Context context, String str, int i2, com.opos.mobad.ad.e eVar) {
        a(context, str, false, true, i2, eVar, false, 0, null);
    }

    public void a(Context context, String str, boolean z, boolean z2, int i2, com.opos.mobad.ad.e eVar, boolean z3, int i3, com.opos.mobad.ad.d dVar) {
        String str2;
        if (context == null || com.opos.cmn.an.c.a.a(str)) {
            if (eVar == null) {
                return;
            } else {
                str2 = "context or appId is null.";
            }
        } else if (PluginApi.sPluginMode) {
            if (com.opos.cmn.an.b.c.b() >= 21 || eVar == null) {
                return;
            } else {
                str2 = "init sdk failed! sdk not support android sdk version < 21";
            }
        } else if (com.opos.cmn.an.b.c.b() >= 19) {
            if (com.opos.cmn.i.b.a(context, Uri.parse("content://" + MobAdGlobalProvider.getAuthority(context)))) {
                if (com.opos.cmn.i.b.a(context, Uri.parse("content://" + context.getPackageName() + ".MobFileProvider"))) {
                    Context context2 = PluginApi.sPluginContext;
                    if (!PluginApi.sPluginMode || context2 != null) {
                        Context context3 = context2 == null ? context : context2;
                        com.opos.cmn.an.d.a.a.a(context3);
                        com.opos.mobad.service.b.a(context3, context);
                        com.opos.mobad.service.f.a(context3, z, z2, z3, i3, new a.c() { // from class: com.opos.mobad.f.e.1

                            /* renamed from: a */
                            final /* synthetic */ Context f20814a;

                            /* renamed from: c */
                            private String f20816c;

                            /* renamed from: d */
                            private String f20817d;

                            /* renamed from: e */
                            private Boolean f20818e;

                            AnonymousClass1(Context context4) {
                                context = context4;
                            }

                            @Override // com.opos.mobad.service.f.a.c
                            public String a() {
                                if (TextUtils.isEmpty(this.f20816c)) {
                                    this.f20816c = com.opos.mobad.cmn.a.b.c.a(context);
                                }
                                return this.f20816c;
                            }

                            @Override // com.opos.mobad.service.f.a.c
                            public String b() {
                                if (TextUtils.isEmpty(this.f20817d)) {
                                    this.f20817d = com.opos.mobad.cmn.a.b.c.a();
                                }
                                return this.f20817d;
                            }

                            @Override // com.opos.mobad.service.f.a.c
                            public boolean c() {
                                if (this.f20818e == null) {
                                    this.f20818e = Boolean.valueOf(com.opos.mobad.cmn.a.b.c.b(context));
                                }
                                return this.f20818e.booleanValue();
                            }

                            @Override // com.opos.mobad.service.f.a.c
                            public void d() {
                                this.f20816c = com.opos.mobad.cmn.a.b.c.a(context);
                                this.f20817d = com.opos.mobad.cmn.a.b.c.a();
                                this.f20818e = Boolean.valueOf(com.opos.mobad.cmn.a.b.c.b(context));
                            }
                        }, new a.g() { // from class: com.opos.mobad.f.e.2

                            /* renamed from: a */
                            final /* synthetic */ Context f20819a;

                            /* renamed from: c */
                            private String f20821c;

                            /* renamed from: d */
                            private String f20822d;

                            /* renamed from: e */
                            private Boolean f20823e;

                            AnonymousClass2(Context context4) {
                                context = context4;
                            }

                            @Override // com.opos.mobad.service.f.a.g
                            public String a() {
                                if (TextUtils.isEmpty(this.f20821c)) {
                                    this.f20821c = com.opos.mobad.cmn.a.b.c.a(context);
                                }
                                return this.f20821c;
                            }

                            @Override // com.opos.mobad.service.f.a.g
                            public String b() {
                                if (TextUtils.isEmpty(this.f20822d)) {
                                    this.f20822d = com.opos.mobad.cmn.a.b.c.a();
                                }
                                return this.f20822d;
                            }

                            @Override // com.opos.mobad.service.f.a.g
                            public boolean c() {
                                if (this.f20823e == null) {
                                    this.f20823e = Boolean.valueOf(com.opos.mobad.cmn.a.b.c.b(context));
                                }
                                return this.f20823e.booleanValue();
                            }

                            @Override // com.opos.mobad.service.f.a.g
                            public void d() {
                                this.f20821c = com.opos.mobad.cmn.a.b.c.a(context);
                                this.f20822d = com.opos.mobad.cmn.a.b.c.a();
                                this.f20823e = Boolean.valueOf(com.opos.mobad.cmn.a.b.c.b(context));
                            }
                        }, new a.InterfaceC0485a() { // from class: com.opos.mobad.f.e.3

                            /* renamed from: a */
                            final /* synthetic */ String f20824a;

                            /* renamed from: b */
                            final /* synthetic */ Context f20825b;

                            /* renamed from: d */
                            private String f20827d;

                            /* renamed from: e */
                            private String f20828e;

                            /* renamed from: f */
                            private int f20829f = -1;

                            AnonymousClass3(String str3, Context context4) {
                                str = str3;
                                context = context4;
                            }

                            @Override // com.opos.mobad.service.f.a.InterfaceC0485a
                            public String a() {
                                return str;
                            }

                            @Override // com.opos.mobad.service.f.a.InterfaceC0485a
                            public String b() {
                                if (TextUtils.isEmpty(this.f20827d)) {
                                    this.f20827d = context.getPackageName();
                                }
                                return this.f20827d;
                            }

                            @Override // com.opos.mobad.service.f.a.InterfaceC0485a
                            public String c() {
                                if (TextUtils.isEmpty(this.f20828e)) {
                                    Context context4 = context;
                                    this.f20828e = com.opos.cmn.an.h.d.a.c(context4, context4.getPackageName());
                                }
                                return this.f20828e;
                            }
                        }, new a.f() { // from class: com.opos.mobad.f.e.4

                            /* renamed from: a */
                            final /* synthetic */ int f20830a;

                            AnonymousClass4(int i22) {
                                i2 = i22;
                            }

                            @Override // com.opos.mobad.service.f.a.f
                            public int a() {
                                return 481004;
                            }

                            @Override // com.opos.mobad.service.f.a.f
                            public String b() {
                                return "4.8.1";
                            }

                            @Override // com.opos.mobad.service.f.a.f
                            public int c() {
                                return i2;
                            }
                        }, dVar == null ? null : new a.b() { // from class: com.opos.mobad.f.e.5

                            /* renamed from: a */
                            final /* synthetic */ com.opos.mobad.ad.d f20832a;

                            AnonymousClass5(com.opos.mobad.ad.d dVar2) {
                                dVar = dVar2;
                            }

                            @Override // com.opos.mobad.service.f.a.b
                            public String a() {
                                return dVar.a();
                            }
                        });
                        c.d().a(context4, str3, i22, z, z3);
                        if (com.opos.cmn.a.a.a()) {
                            c.a a2 = c.d().a();
                            if (!a2.f19473a) {
                                com.opos.cmn.an.f.a.d("MobAdManager", a2.f19474b);
                                if (eVar == null) {
                                    return;
                                } else {
                                    str2 = a2.f19474b;
                                }
                            }
                        }
                        if (c.d().b()) {
                            b();
                            if (eVar != null) {
                                eVar.a();
                                return;
                            }
                            return;
                        }
                        if (eVar == null) {
                            return;
                        } else {
                            str2 = "init fail";
                        }
                    } else if (eVar == null) {
                        return;
                    } else {
                        str2 = "init sdk failed!";
                    }
                } else if (eVar == null) {
                    return;
                } else {
                    str2 = "init sdk failed! com.heytap.msp.mobad.api.MobFileProvider don't find in AndroidManifest.xml.";
                }
            } else if (eVar == null) {
                return;
            } else {
                str2 = "init sdk failed! com.opos.mobad.provider.MobAdGlobalProvider don't find in AndroidManifest.xml.";
            }
        } else if (eVar == null) {
            return;
        } else {
            str2 = "init sdk failed! sdk not support android sdk version < 19";
        }
        eVar.a(str2);
    }

    public void a(Context context, String str, boolean z, boolean z2, int i2, boolean z3, int i3, com.opos.mobad.ad.d dVar) {
        a(context, str, z, z2, i2, null, z3, i3, dVar);
    }

    public boolean a() {
        return com.opos.mobad.service.f.b().c();
    }

    public com.opos.mobad.ad.e.b b(Activity activity, String str, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        return c.d().b(activity, str, cVar, fVar);
    }
}
