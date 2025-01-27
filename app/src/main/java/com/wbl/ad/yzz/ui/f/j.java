package com.wbl.ad.yzz.ui.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.dialog.h;
import com.wbl.ad.yzz.download.c;
import com.wbl.ad.yzz.network.b.b.k;
import com.wbl.ad.yzz.network.b.b.r;
import com.wbl.ad.yzz.network.c.d;

/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a */
    public String f34163a;

    /* renamed from: b */
    public com.wbl.ad.yzz.dialog.h f34164b;

    /* renamed from: c */
    public com.wbl.ad.yzz.dialog.l.e f34165c;

    /* renamed from: d */
    public boolean f34166d;

    /* renamed from: e */
    public boolean f34167e;

    /* renamed from: g */
    public boolean f34169g;

    /* renamed from: i */
    public com.wbl.ad.yzz.dialog.l.a f34171i;
    public boolean k;

    /* renamed from: f */
    public int f34168f = -1;

    /* renamed from: h */
    public Handler f34170h = new Handler(Looper.getMainLooper());

    /* renamed from: j */
    public c.b f34172j = new c();

    public interface a {
        void a(int i2);
    }

    public static final class b implements d.b0<r> {

        /* renamed from: b */
        public final /* synthetic */ a f34174b;

        /* renamed from: c */
        public final /* synthetic */ String f34175c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f34176d;

        public b(a aVar, String str, com.wbl.ad.yzz.innerconfig.d.d dVar) {
            this.f34174b = aVar;
            this.f34175c = str;
            this.f34176d = dVar;
        }

        public void a(String str, r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9006, this, str, rVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9005, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, r rVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9008, this, str, rVar);
        }
    }

    public static final class c extends c.b {
        @Override // com.wbl.ad.yzz.download.c.b
        public void a(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9007, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void a(com.wbl.ad.yzz.download.h.c cVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9002, this, cVar);
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9001, this, null);
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void b(int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9004, this, Integer.valueOf(i2));
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9003, this, null);
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void d() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8998, this, null);
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void e() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8997, this, null);
        }

        @Override // com.wbl.ad.yzz.download.c.b
        public void f() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9000, this, null);
        }
    }

    public static final class d implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Context f34178b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f34179c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.k f34180d;

        public d(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, com.wbl.ad.yzz.network.b.b.k kVar) {
            this.f34178b = context;
            this.f34179c = dVar;
            this.f34180d = kVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8999, this, null);
        }
    }

    public static final class e implements h.a {

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f34182b;

        /* renamed from: c */
        public final /* synthetic */ Context f34183c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.network.b.b.k f34184d;

        public e(com.wbl.ad.yzz.innerconfig.d.d dVar, Context context, com.wbl.ad.yzz.network.b.b.k kVar) {
            this.f34182b = dVar;
            this.f34183c = context;
            this.f34184d = kVar;
        }

        @Override // com.wbl.ad.yzz.dialog.h.a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8994, this, null);
        }

        @Override // com.wbl.ad.yzz.dialog.h.a
        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8993, this, null);
        }

        @Override // com.wbl.ad.yzz.dialog.h.a
        public void c() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8996, this, null);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ int f34186b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f34187c;

        /* renamed from: d */
        public final /* synthetic */ Context f34188d;

        /* renamed from: e */
        public final /* synthetic */ k.a f34189e;

        public f(int i2, com.wbl.ad.yzz.innerconfig.d.d dVar, Context context, k.a aVar) {
            this.f34186b = i2;
            this.f34187c = dVar;
            this.f34188d = context;
            this.f34189e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8995, this, view);
        }
    }

    public static final /* synthetic */ com.wbl.ad.yzz.dialog.l.e a(j jVar) {
        return (com.wbl.ad.yzz.dialog.l.e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9022, null, jVar);
    }

    public static final /* synthetic */ String b(j jVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9018, null, jVar);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9020, this, null);
    }

    public final void a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, com.wbl.ad.yzz.network.b.b.k kVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9019, this, context, dVar, kVar);
    }

    public final void a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9014, this, context, dVar, aVar);
    }

    public final boolean a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, com.wbl.ad.yzz.network.b.b.k kVar, int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9013, this, context, dVar, kVar, Integer.valueOf(i2));
    }

    public final boolean a(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, com.wbl.ad.yzz.network.b.b.k kVar, boolean z, int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9016, this, context, dVar, kVar, Boolean.valueOf(z), Integer.valueOf(i2));
    }

    public final boolean a(com.wbl.ad.yzz.network.b.b.k kVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9015, this, kVar);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9010, this, null);
    }

    public final boolean b(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, com.wbl.ad.yzz.network.b.b.k kVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9009, this, context, dVar, kVar);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9012, this, null);
    }

    public final void c(Context context, com.wbl.ad.yzz.innerconfig.d.d dVar, com.wbl.ad.yzz.network.b.b.k kVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-9011, this, context, dVar, kVar);
    }

    public final String d() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8974, this, null);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8973, this, null);
    }
}
