package com.wbl.ad.yzz.network.c.e;

import android.content.Context;
import android.os.Handler;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class g implements o<com.wbl.ad.yzz.network.b.b.d> {

    /* renamed from: a */
    public final Handler f33679a;

    /* renamed from: b */
    public Handler f33680b;

    /* renamed from: c */
    public int f33681c;

    /* renamed from: d */
    public final Object f33682d = new Object();

    /* renamed from: e */
    public final com.wbl.ad.yzz.innerconfig.d.d f33683e;

    /* renamed from: f */
    public long f33684f;

    /* renamed from: g */
    public com.wbl.ad.yzz.network.b.b.d f33685g;

    /* renamed from: h */
    public c f33686h;

    /* renamed from: i */
    public Context f33687i;

    /* renamed from: j */
    public String f33688j;
    public com.wbl.ad.yzz.adrequest.c.c k;

    public static final class a implements Runnable {

        /* renamed from: a */
        public final long f33689a;

        /* renamed from: b */
        public final int f33690b;

        /* renamed from: c */
        public final com.wbl.ad.yzz.network.c.e.b f33691c;

        /* renamed from: d */
        public final g f33692d;

        /* renamed from: e */
        public final Object f33693e;

        /* renamed from: f */
        public int f33694f;

        /* renamed from: com.wbl.ad.yzz.network.c.e.g$a$a */
        public static final class RunnableC0773a implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ Context f33696b;

            /* renamed from: c */
            public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f33697c;

            /* renamed from: d */
            public final /* synthetic */ Handler f33698d;

            /* renamed from: e */
            public final /* synthetic */ com.wbl.ad.yzz.network.b.b.b f33699e;

            /* renamed from: f */
            public final /* synthetic */ String f33700f;

            /* renamed from: g */
            public final /* synthetic */ com.wbl.ad.yzz.adrequest.c.c f33701g;

            /* renamed from: h */
            public final /* synthetic */ c f33702h;

            public RunnableC0773a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, Handler handler, com.wbl.ad.yzz.network.b.b.b bVar, String str, com.wbl.ad.yzz.adrequest.c.c cVar, c cVar2) {
                this.f33696b = context;
                this.f33697c = dVar;
                this.f33698d = handler;
                this.f33699e = bVar;
                this.f33700f = str;
                this.f33701g = cVar;
                this.f33702h = cVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10496, this, null);
            }
        }

        public static final class b implements c {

            /* renamed from: b */
            public final /* synthetic */ c f33704b;

            /* renamed from: c */
            public final /* synthetic */ com.wbl.ad.yzz.network.b.b.b f33705c;

            public b(c cVar, com.wbl.ad.yzz.network.b.b.b bVar) {
                this.f33704b = cVar;
                this.f33705c = bVar;
            }

            @Override // com.wbl.ad.yzz.network.c.e.c
            public void a(com.wbl.ad.yzz.adapter.d.b bVar) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10495, this, bVar);
            }

            @Override // com.wbl.ad.yzz.network.c.e.c
            public void loadAdError(int i2, String str) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10490, this, Integer.valueOf(i2), str);
            }
        }

        public a(int i2, long j2, @f.b.a.d com.wbl.ad.yzz.network.c.e.b adLoader, @f.b.a.d g waterfallLoader) {
            Intrinsics.checkNotNullParameter(adLoader, "adLoader");
            Intrinsics.checkNotNullParameter(waterfallLoader, "waterfallLoader");
            this.f33693e = new Object();
            this.f33690b = i2;
            this.f33689a = j2;
            this.f33691c = adLoader;
            this.f33692d = waterfallLoader;
        }

        public final void a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, Handler handler, Handler handler2, com.wbl.ad.yzz.network.b.b.b bVar, String str, com.wbl.ad.yzz.adrequest.c.c cVar, c cVar2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10486, this, context, dVar, handler, handler2, bVar, str, cVar, cVar2);
        }

        public final void a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, Handler handler, com.wbl.ad.yzz.network.b.b.b bVar, String str, com.wbl.ad.yzz.adrequest.c.c cVar, c cVar2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10485, this, context, dVar, handler, bVar, str, cVar, cVar2);
        }

        public final void a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, com.wbl.ad.yzz.network.b.b.b bVar, String str, com.wbl.ad.yzz.adrequest.c.c cVar, c cVar2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10488, this, context, dVar, bVar, str, cVar, cVar2);
        }

        public final void a(c cVar, com.wbl.ad.yzz.network.b.b.b bVar, int i2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10487, this, cVar, bVar, Integer.valueOf(i2), str);
        }

        public final void a(c cVar, com.wbl.ad.yzz.network.b.b.b bVar, com.wbl.ad.yzz.adapter.d.b bVar2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10482, this, cVar, bVar, bVar2);
        }

        public final boolean c() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10481, this, null);
        }

        public final void d() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10484, this, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10483, this, null);
        }
    }

    public g(@f.b.a.e Handler handler, @f.b.a.e Handler handler2, @f.b.a.e com.wbl.ad.yzz.innerconfig.d.d dVar) {
        this.f33679a = handler;
        this.f33683e = dVar;
        this.f33680b = handler2;
    }

    public static final /* synthetic */ String a(g gVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10446, null, gVar);
    }

    public final com.wbl.ad.yzz.network.b.b.b a(com.wbl.ad.yzz.network.b.b.d dVar, int i2) {
        return (com.wbl.ad.yzz.network.b.b.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10441, this, dVar, Integer.valueOf(i2));
    }

    public final b a(com.wbl.ad.yzz.network.b.b.b bVar, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10444, this, bVar, dVar);
    }

    public final void a(int i2, c cVar, int i3, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10443, this, Integer.valueOf(i2), cVar, Integer.valueOf(i3), str);
    }

    public final void a(long j2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10438, this, Long.valueOf(j2));
    }

    public final void a(Context context, int i2, com.wbl.ad.yzz.network.b.b.b bVar, String str, com.wbl.ad.yzz.adrequest.c.c cVar, c cVar2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10437, this, context, Integer.valueOf(i2), bVar, str, cVar, cVar2);
    }

    /* renamed from: a */
    public void a2(Context context, com.wbl.ad.yzz.network.b.b.d dVar, String str, com.wbl.ad.yzz.adrequest.c.c cVar, c cVar2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10440, this, context, dVar, str, cVar, cVar2);
    }

    @Override // com.wbl.ad.yzz.network.c.e.o
    public /* bridge */ /* synthetic */ void a(Context context, com.wbl.ad.yzz.network.b.b.d dVar, String str, com.wbl.ad.yzz.adrequest.c.c cVar, c cVar2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10439, this, context, dVar, str, cVar, cVar2);
    }

    public final void a(Context context, String str, com.wbl.ad.yzz.adrequest.c.c cVar, c cVar2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10434, this, context, str, cVar, cVar2);
    }

    public final void a(com.wbl.ad.yzz.network.b.b.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10433, this, bVar);
    }

    public final void a(c cVar, int i2, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10436, this, cVar, Integer.valueOf(i2), str);
    }

    public final void a(c cVar, com.wbl.ad.yzz.adapter.d.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10435, this, cVar, bVar);
    }

    public final void a(c cVar, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10462, this, cVar, str);
    }

    public final boolean a() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10461, this, null);
    }

    public final boolean a(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10464, this, Integer.valueOf(i2));
    }

    public final boolean a(int i2, int i3) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10463, this, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final Handler b() {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10458, this, null);
    }

    public final com.wbl.ad.yzz.network.b.b.b b(int i2) {
        return (com.wbl.ad.yzz.network.b.b.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10457, this, Integer.valueOf(i2));
    }

    public final String c() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10460, this, null);
    }

    public final boolean c(int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10459, this, Integer.valueOf(i2));
    }

    public final int d() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10454, this, null);
    }

    public final void d(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10453, this, Integer.valueOf(i2));
    }

    public final int e() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10456, this, null);
    }

    public final void e(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10455, this, Integer.valueOf(i2));
    }

    public final boolean f() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10450, this, null);
    }

    public final void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10449, this, null);
    }
}
