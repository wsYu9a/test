package com.opos.mobad.model;

import android.content.Context;
import android.os.SystemClock;
import com.baidu.mobads.sdk.api.SplashAd;
import com.opos.mobad.model.b.c;
import com.opos.mobad.model.d.g;
import com.opos.mobad.model.d.m;
import com.opos.mobad.model.d.s;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.model.e.e;
import com.opos.mobad.service.f;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public static int f21483a = 0;

    /* renamed from: b */
    public static int f21484b = 1;

    /* renamed from: c */
    public static int f21485c = 2;

    /* renamed from: d */
    public static int f21486d = 3;

    /* renamed from: e */
    private static String f21487e = "b";

    /* renamed from: f */
    private static volatile b f21488f;

    /* renamed from: g */
    private com.opos.mobad.model.e.b f21489g = new com.opos.mobad.model.e.b();

    /* renamed from: h */
    private com.opos.mobad.model.a.a.b f21490h;

    /* renamed from: com.opos.mobad.model.b$1 */
    class AnonymousClass1 implements com.opos.mobad.model.c.a {

        /* renamed from: a */
        final /* synthetic */ FutureTask f21491a;

        /* renamed from: b */
        final /* synthetic */ long f21492b;

        /* renamed from: c */
        final /* synthetic */ int f21493c;

        /* renamed from: d */
        final /* synthetic */ Context f21494d;

        /* renamed from: e */
        final /* synthetic */ String f21495e;

        /* renamed from: f */
        final /* synthetic */ a f21496f;

        AnonymousClass1(FutureTask futureTask, long j2, int i2, Context context, String str, a aVar) {
            a2 = futureTask;
            elapsedRealtime = j2;
            i3 = i2;
            context = context;
            str = str;
            aVar = aVar;
        }

        @Override // com.opos.mobad.model.c.a
        public void a(int i2, String str, AdData adData, Object... objArr) {
            int i3;
            FutureTask futureTask = a2;
            if (futureTask != null) {
                try {
                    i3 = ((Integer) futureTask.get(b.this.a(elapsedRealtime, i3), TimeUnit.MILLISECONDS)).intValue();
                } catch (Exception e2) {
                    int f2 = com.opos.mobad.service.a.a().f();
                    com.opos.cmn.an.f.a.b(b.f21487e, "check future fail", e2);
                    i3 = f2;
                }
            } else {
                i3 = 0;
            }
            b.this.a(context.getApplicationContext(), str, i2, str, adData, i3, aVar);
        }
    }

    /* renamed from: com.opos.mobad.model.b$2 */
    class AnonymousClass2 implements com.opos.mobad.model.c.a {

        /* renamed from: a */
        final /* synthetic */ FutureTask f21498a;

        /* renamed from: b */
        final /* synthetic */ long f21499b;

        /* renamed from: c */
        final /* synthetic */ int f21500c;

        /* renamed from: d */
        final /* synthetic */ Context f21501d;

        /* renamed from: e */
        final /* synthetic */ String f21502e;

        /* renamed from: f */
        final /* synthetic */ a f21503f;

        AnonymousClass2(FutureTask futureTask, long j2, int i2, Context context, String str, a aVar) {
            a2 = futureTask;
            elapsedRealtime = j2;
            i3 = i2;
            context = context;
            str = str;
            aVar = aVar;
        }

        @Override // com.opos.mobad.model.c.a
        public void a(int i2, String str, AdData adData, Object... objArr) {
            int i3;
            FutureTask futureTask = a2;
            if (futureTask != null) {
                try {
                    i3 = ((Integer) futureTask.get(b.this.a(elapsedRealtime, i3), TimeUnit.MILLISECONDS)).intValue();
                } catch (Exception e2) {
                    int f2 = com.opos.mobad.service.a.a().f();
                    com.opos.cmn.an.f.a.b(b.f21487e, "check future fail", e2);
                    i3 = f2;
                }
            } else {
                i3 = 0;
            }
            b.this.a(context, str, i2, str, adData, i3, aVar);
        }
    }

    /* renamed from: com.opos.mobad.model.b$3 */
    class AnonymousClass3 implements m.a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.model.c.a f21505a;

        AnonymousClass3(com.opos.mobad.model.c.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.model.d.m.a
        public void a() {
        }

        @Override // com.opos.mobad.model.d.m.a
        public void a(AdData adData) {
            aVar.a(adData.d(), adData.e(), adData, new Object[0]);
        }

        @Override // com.opos.mobad.model.d.m.a
        public void b(AdData adData) {
            aVar.a(adData.d(), adData.e(), adData, new Object[0]);
        }

        @Override // com.opos.mobad.model.d.m.a
        public void c(AdData adData) {
            aVar.a(adData.d(), adData.e(), adData, new Object[0]);
        }
    }

    /* renamed from: com.opos.mobad.model.b$4 */
    class AnonymousClass4 implements m.a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.model.c.a f21507a;

        AnonymousClass4(com.opos.mobad.model.c.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.model.d.m.a
        public void a() {
        }

        @Override // com.opos.mobad.model.d.m.a
        public void a(AdData adData) {
            aVar.a(adData.d(), adData.e(), adData, new Object[0]);
        }

        @Override // com.opos.mobad.model.d.m.a
        public void b(AdData adData) {
            aVar.a(adData.d(), adData.e(), adData, new Object[0]);
        }

        @Override // com.opos.mobad.model.d.m.a
        public void c(AdData adData) {
            aVar.a(adData.d(), adData.e(), adData, new Object[0]);
        }
    }

    public interface a {
        void a(int i2, a.C0457a c0457a);

        void a(int i2, String str, AdData adData);
    }

    private b(Context context) {
        this.f21490h = new com.opos.mobad.model.a.a.b(context);
    }

    private int a(int i2) {
        switch (i2) {
            case 1:
                return f.b().j();
            case 2:
                return f.b().o();
            case 3:
            case 6:
                return f.b().l();
            case 4:
                return f.b().t();
            case 5:
                return f.b().r();
            default:
                return 0;
        }
    }

    public int a(long j2, int i2) {
        long max = Math.max(SystemClock.elapsedRealtime() - j2, 0L);
        long j3 = i2;
        if (j3 > max) {
            return (int) Math.max((j3 - max) - 100, 0L);
        }
        return 0;
    }

    public static b a(Context context) {
        if (f21488f == null) {
            synchronized (b.class) {
                if (f21488f == null) {
                    f21488f = new b(context);
                }
            }
        }
        return f21488f;
    }

    private FutureTask<Integer> a(Context context, String str, int i2) {
        if (i2 == 5) {
            return null;
        }
        return com.opos.mobad.service.a.a().a(context, str);
    }

    private void a(Context context, String str, int i2, String str2, int i3, com.opos.mobad.model.c.a aVar) {
        c a2 = com.opos.mobad.cmn.a.b.f.a(context, str, i2, str2);
        int a3 = a(i2);
        com.opos.cmn.an.f.a.b(f21487e, "fetch ad with sync timeout:" + a3);
        if (a3 > 0) {
            new s(context, str, str2, a2, true, this.f21490h, i3, a3, new m.a() { // from class: com.opos.mobad.model.b.4

                /* renamed from: a */
                final /* synthetic */ com.opos.mobad.model.c.a f21507a;

                AnonymousClass4(com.opos.mobad.model.c.a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.opos.mobad.model.d.m.a
                public void a() {
                }

                @Override // com.opos.mobad.model.d.m.a
                public void a(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }

                @Override // com.opos.mobad.model.d.m.a
                public void b(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }

                @Override // com.opos.mobad.model.d.m.a
                public void c(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }
            }).f();
        } else {
            new g(context, this.f21490h).a(str, a2, aVar2, 30000L, true, new Object[0]);
        }
    }

    private void a(Context context, String str, int i2, String str2, int i3, com.opos.mobad.model.c.a aVar, int i4, int i5) {
        int i6;
        boolean z;
        c a2 = com.opos.mobad.cmn.a.b.f.a(context, str, i2, str2);
        if (i4 == f21483a || i4 == f21484b) {
            a2.a(i4 == f21484b ? 2 : 1);
            i6 = i5;
            z = false;
        } else {
            i6 = i5;
            z = true;
        }
        a2.f(i6);
        int a3 = a(i2);
        if (a3 > 0) {
            new s(context, str, str2, a2, z, this.f21490h, i3, a3, new m.a() { // from class: com.opos.mobad.model.b.3

                /* renamed from: a */
                final /* synthetic */ com.opos.mobad.model.c.a f21505a;

                AnonymousClass3(com.opos.mobad.model.c.a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.opos.mobad.model.d.m.a
                public void a() {
                }

                @Override // com.opos.mobad.model.d.m.a
                public void a(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }

                @Override // com.opos.mobad.model.d.m.a
                public void b(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }

                @Override // com.opos.mobad.model.d.m.a
                public void c(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }
            }).f();
        } else {
            new g(context, this.f21490h).a(str, a2, aVar2, 30000L, z, new Object[0]);
        }
    }

    public void a(Context context, String str, int i2, String str2, AdData adData, int i3, a aVar) {
        String str3;
        if (adData != null && adData.g() > 0) {
            int g2 = adData.g() * 1000;
            com.opos.cmn.an.f.a.b(f21487e, "setReqAdInterval=" + g2);
            this.f21489g.a(str, g2);
        }
        if (10000 != i2 || adData == null) {
            String str4 = f21487e;
            StringBuilder sb = new StringBuilder();
            sb.append("code=");
            sb.append(i2);
            sb.append(",msg=");
            sb.append(str2 != null ? str2 : "");
            com.opos.cmn.an.f.a.a(str4, sb.toString());
            aVar.a(i2, str2, adData);
            return;
        }
        a.C0457a a2 = com.opos.mobad.model.e.a.a(adData);
        if (a2 != null) {
            int c2 = adData.c();
            a2.f21743a.a(i3);
            com.opos.mobad.service.c.b.a().a(a2.f21745c.b());
            aVar.a(c2, a2);
            return;
        }
        int i4 = 10401;
        if (e.a(context, adData)) {
            str3 = com.opos.mobad.ad.a.a(10401);
        } else {
            i4 = -1;
            str3 = "ad data is null";
        }
        aVar.a(i4, str3, adData);
    }

    private boolean a(String str, a aVar) {
        int i2;
        if (!com.opos.mobad.cmn.a.b.f.e()) {
            i2 = 11005;
        } else {
            if (this.f21489g.b(str)) {
                return true;
            }
            i2 = 11003;
        }
        aVar.a(i2, com.opos.mobad.ad.a.a(i2), null);
        return false;
    }

    public com.opos.mobad.model.a.a.b a() {
        return this.f21490h;
    }

    public void a(Context context, String str, int i2, String str2, int i3, a aVar) {
        com.opos.cmn.an.f.a.b(f21487e, SplashAd.KEY_FETCHAD);
        if (a(str, aVar)) {
            this.f21489g.a(str);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.opos.cmn.an.f.a.b(f21487e, "fetchAd start:" + elapsedRealtime);
            a(context.getApplicationContext(), str, i2, str2, i3, new com.opos.mobad.model.c.a() { // from class: com.opos.mobad.model.b.1

                /* renamed from: a */
                final /* synthetic */ FutureTask f21491a;

                /* renamed from: b */
                final /* synthetic */ long f21492b;

                /* renamed from: c */
                final /* synthetic */ int f21493c;

                /* renamed from: d */
                final /* synthetic */ Context f21494d;

                /* renamed from: e */
                final /* synthetic */ String f21495e;

                /* renamed from: f */
                final /* synthetic */ a f21496f;

                AnonymousClass1(FutureTask futureTask, long elapsedRealtime2, int i32, Context context2, String str3, a aVar2) {
                    a2 = futureTask;
                    elapsedRealtime = elapsedRealtime2;
                    i3 = i32;
                    context = context2;
                    str = str3;
                    aVar = aVar2;
                }

                @Override // com.opos.mobad.model.c.a
                public void a(int i22, String str3, AdData adData, Object... objArr) {
                    int i32;
                    FutureTask futureTask = a2;
                    if (futureTask != null) {
                        try {
                            i32 = ((Integer) futureTask.get(b.this.a(elapsedRealtime, i3), TimeUnit.MILLISECONDS)).intValue();
                        } catch (Exception e2) {
                            int f2 = com.opos.mobad.service.a.a().f();
                            com.opos.cmn.an.f.a.b(b.f21487e, "check future fail", e2);
                            i32 = f2;
                        }
                    } else {
                        i32 = 0;
                    }
                    b.this.a(context.getApplicationContext(), str, i22, str3, adData, i32, aVar);
                }
            });
        }
    }

    public void a(Context context, String str, int i2, String str2, int i3, a aVar, int i4) {
        a(context.getApplicationContext(), str, i2, str2, i3, aVar, i4, -1);
    }

    public void a(Context context, String str, int i2, String str2, int i3, a aVar, int i4, int i5) {
        com.opos.cmn.an.f.a.b(f21487e, SplashAd.KEY_FETCHAD);
        if (a(str, aVar)) {
            this.f21489g.a(str);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.opos.cmn.an.f.a.b(f21487e, "fetchAd start:" + elapsedRealtime);
            a(context, str, i2, str2, i3, new com.opos.mobad.model.c.a() { // from class: com.opos.mobad.model.b.2

                /* renamed from: a */
                final /* synthetic */ FutureTask f21498a;

                /* renamed from: b */
                final /* synthetic */ long f21499b;

                /* renamed from: c */
                final /* synthetic */ int f21500c;

                /* renamed from: d */
                final /* synthetic */ Context f21501d;

                /* renamed from: e */
                final /* synthetic */ String f21502e;

                /* renamed from: f */
                final /* synthetic */ a f21503f;

                AnonymousClass2(FutureTask futureTask, long elapsedRealtime2, int i32, Context context2, String str3, a aVar2) {
                    a2 = futureTask;
                    elapsedRealtime = elapsedRealtime2;
                    i3 = i32;
                    context = context2;
                    str = str3;
                    aVar = aVar2;
                }

                @Override // com.opos.mobad.model.c.a
                public void a(int i22, String str3, AdData adData, Object... objArr) {
                    int i32;
                    FutureTask futureTask = a2;
                    if (futureTask != null) {
                        try {
                            i32 = ((Integer) futureTask.get(b.this.a(elapsedRealtime, i3), TimeUnit.MILLISECONDS)).intValue();
                        } catch (Exception e2) {
                            int f2 = com.opos.mobad.service.a.a().f();
                            com.opos.cmn.an.f.a.b(b.f21487e, "check future fail", e2);
                            i32 = f2;
                        }
                    } else {
                        i32 = 0;
                    }
                    b.this.a(context, str, i22, str3, adData, i32, aVar);
                }
            }, i4, i5);
        }
    }
}
