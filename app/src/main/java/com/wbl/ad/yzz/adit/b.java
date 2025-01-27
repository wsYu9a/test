package com.wbl.ad.yzz.adit;

import android.content.Context;
import android.os.Handler;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.c.d;

/* loaded from: classes5.dex */
public final class b implements Runnable, com.wbl.ad.yzz.network.e.b {

    /* renamed from: a */
    public final g f31450a;

    /* renamed from: b */
    public Handler f31451b;

    /* renamed from: c */
    public final boolean f31452c;

    /* renamed from: d */
    public final Context f31453d;

    public class a implements d.b0<com.wbl.ad.yzz.network.b.b.a> {
        public a() {
        }

        public void a(String str, com.wbl.ad.yzz.network.b.b.a aVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15492, this, str, aVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15491, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, com.wbl.ad.yzz.network.b.b.a aVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15518, this, str, aVar);
        }
    }

    /* renamed from: com.wbl.ad.yzz.adit.b$b */
    public class RunnableC0686b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f31455a;

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.a f31456b;

        public RunnableC0686b(String str, com.wbl.ad.yzz.network.b.b.a aVar) {
            this.f31455a = str;
            this.f31456b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15517, this, null);
        }
    }

    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f31458a;

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.a f31459b;

        public c(String str, com.wbl.ad.yzz.network.b.b.a aVar) {
            this.f31458a = str;
            this.f31459b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15520, this, null);
        }
    }

    public class d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f31461a;

        /* renamed from: b */
        public final /* synthetic */ String f31462b;

        public d(String str, String str2) {
            this.f31461a = str;
            this.f31462b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15519, this, null);
        }
    }

    public class e implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f31464a;

        /* renamed from: b */
        public final /* synthetic */ String f31465b;

        public e(String str, String str2) {
            this.f31464a = str;
            this.f31465b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15514, this, null);
        }
    }

    public class f implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.a f31467a;

        public f(com.wbl.ad.yzz.network.b.b.a aVar) {
            this.f31467a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15513, this, null);
        }
    }

    public class g implements d.b0<com.wbl.ad.yzz.network.b.b.a> {

        /* renamed from: a */
        public boolean f31469a = false;

        /* renamed from: b */
        public final d.b0<com.wbl.ad.yzz.network.b.b.a> f31470b;

        public g(b bVar, d.b0<com.wbl.ad.yzz.network.b.b.a> b0Var) {
            this.f31470b = b0Var;
        }

        public void a(String str, com.wbl.ad.yzz.network.b.b.a aVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15516, this, str, aVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15515, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, com.wbl.ad.yzz.network.b.b.a aVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15510, this, str, aVar);
        }
    }

    public b(Context context, Handler handler, boolean z, d.b0<com.wbl.ad.yzz.network.b.b.a> b0Var) {
        this.f31450a = new g(this, b0Var);
        this.f31451b = handler;
        this.f31452c = z;
        if (context != null) {
            this.f31453d = context.getApplicationContext();
        } else {
            this.f31453d = com.wbl.ad.yzz.adit.c.f31477g.b();
        }
    }

    public static /* synthetic */ g a(b bVar) {
        return (g) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15509, null, bVar);
    }

    public static /* synthetic */ Context b(b bVar) {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15505, null, bVar);
    }

    public final void a(com.wbl.ad.yzz.network.b.b.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15508, this, aVar);
    }

    public final void a(String str, com.wbl.ad.yzz.network.b.b.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15507, this, str, aVar);
    }

    public final void a(String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15598, this, str, str2);
    }

    @Override // com.wbl.ad.yzz.network.e.b
    public void a(Throwable th) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15597, this, th);
    }

    public final com.wbl.ad.yzz.network.b.b.a c() {
        return (com.wbl.ad.yzz.network.b.b.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15600, this, null);
    }

    public final boolean d() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15599, this, null);
    }

    public void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15594, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15593, this, null);
    }

    @Override // java.lang.Runnable
    public void run() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15596, this, null);
    }
}
