package com.vivo.mobilead.unified;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.vivo.ad.model.AdError;
import com.vivo.ad.model.b;
import com.vivo.ad.model.d;
import com.vivo.ad.model.e;
import com.vivo.ad.model.r;
import com.vivo.mobilead.i.c;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.manager.g;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.callback.f;
import com.vivo.mobilead.unified.base.callback.j;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.g0;
import com.vivo.mobilead.util.h0;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;
import com.vivo.mobilead.util.w;
import com.vivo.mobilead.util.w0;
import com.vivo.mobilead.util.x;
import com.vivo.mobilead.util.y0;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class a implements f, j {
    private static final String s = "a";

    /* renamed from: a */
    protected Context f29661a;

    /* renamed from: b */
    protected AdParams f29662b;

    /* renamed from: e */
    protected String f29665e;

    /* renamed from: f */
    protected b f29666f;

    /* renamed from: g */
    protected int f29667g;

    /* renamed from: h */
    protected int f29668h;
    protected int n;
    protected int o;
    protected boolean p;
    protected int q;
    private com.vivo.mobilead.g.b r;

    /* renamed from: j */
    private volatile boolean f29670j = true;
    private int k = -1;
    protected volatile boolean l = false;
    private volatile boolean m = true;

    /* renamed from: c */
    protected String f29663c = x.b();

    /* renamed from: d */
    protected String f29664d = x.b();

    /* renamed from: i */
    protected HashMap<Integer, String> f29669i = g0.a();

    /* renamed from: com.vivo.mobilead.unified.a$a */
    class RunnableC0604a implements Runnable {
        RunnableC0604a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = a.this.f29666f;
            if (bVar != null) {
                boolean z = true;
                d b2 = bVar.b();
                if (b2 != null && b2.l()) {
                    z = com.vivo.mobilead.h.b.a().e(b2.h());
                }
                if (z) {
                    return;
                }
                try {
                    new com.vivo.mobilead.i.b(new com.vivo.mobilead.i.a(b2.h(), null)).a();
                } catch (c unused) {
                }
            }
        }
    }

    public a(Context context, AdParams adParams) {
        this.f29661a = context;
        this.f29662b = adParams;
    }

    private boolean d(String str) {
        return g.a(this.f29661a).a(str);
    }

    private int o() {
        return w0.a(this.f29661a, "com.vivo.browser");
    }

    private void p() {
        this.f29663c = x.b();
    }

    public void a(int i2) {
        a(i2, 1);
    }

    protected void b(b bVar) {
        e c2 = bVar.c();
        if (c2 != null) {
            if (c2.r() == 0) {
                com.vivo.mobilead.f.c.d().a(false);
                com.vivo.mobilead.f.c.d().c();
            } else {
                com.vivo.mobilead.f.c.d().a(true);
                com.vivo.mobilead.f.c.d().a();
                com.vivo.mobilead.f.c.d().a(c2.a() * 1000);
            }
        }
    }

    protected abstract void c();

    public void c(@NonNull AdError adError) {
        com.vivo.mobilead.g.b bVar = this.r;
        if (bVar != null) {
            bVar.a(new l0().a(c.a.f28912a).a(false).b(adError.getADID()).d(adError.getToken()).a(adError.getShowPriority()).b(adError.getErrorCode()).a(adError.getErrorMsg()));
        }
    }

    public void d() {
    }

    protected void e() {
        a1.e(new RunnableC0604a());
    }

    protected abstract int f();

    protected long g() {
        return 10000L;
    }

    protected int h() {
        int i2 = this.k;
        if (i2 != -1) {
            return i2;
        }
        if (f() == 2) {
            this.k = com.vivo.mobilead.manager.b.l().getInt("splash_orientation_key", 1);
        } else {
            this.k = w0.c();
        }
        return this.k;
    }

    public int i() {
        b bVar = this.f29666f;
        if (bVar == null) {
            return -1;
        }
        if (bVar.m() == 0) {
            return -2;
        }
        return this.f29666f.D();
    }

    public String j() {
        b bVar = this.f29666f;
        return (bVar == null || bVar.o() == null) ? "" : this.f29666f.o();
    }

    protected abstract String k();

    public void l() {
        a(1);
    }

    public void m() {
        com.vivo.mobilead.g.b bVar = this.r;
        if (bVar != null) {
            bVar.a(new l0().a(c.a.f28912a).a(true).b(this.f29666f.d()).d(this.f29666f.P()).a(this.f29666f.J()).c(this.f29666f.G()));
        }
    }

    protected void n() {
        if (this.l) {
            return;
        }
        this.l = true;
        k0.a(this.f29666f, a.EnumC0603a.LOADED, this.f29662b.getSourceAppend());
    }

    private void d(@NonNull AdError adError) {
        if (this.m) {
            k0.a(adError, this.f29662b.getPositionId(), this.f29662b.getSourceAppend(), k(), h(), this.f29667g, f() == 5 ? 0 : 1, this.f29668h, c.a.f28912a.intValue(), this.n);
        }
    }

    public void a(int i2, int i3) {
        a(i2, i3, -1);
    }

    public void a(int i2, int i3, int i4) {
        a(i2, i3, i4, true);
    }

    public void a(int i2, int i3, int i4, boolean z) {
        this.f29668h = i3;
        this.n = i2;
        this.o = i4;
        c(i2, i3);
        k0.a();
        if (f() != 5 || i4 != 43) {
            com.vivo.mobilead.unified.exitFloat.e.c().b();
            h0.K().a(true);
        }
        System.currentTimeMillis();
        com.vivo.mobilead.unified.base.c b2 = com.vivo.mobilead.unified.base.c.a().c(this.f29663c).a(f()).d(i2).b(this.f29662b.getPositionId());
        Context context = this.f29661a;
        com.vivo.mobilead.unified.base.c a2 = b2.a(context == null ? "" : context.getPackageName()).a(g()).e(i4).d(this.f29662b.getSourceAppend()).f(i3).b(z).c(this.f29662b.getFloorPrice()).e(this.f29662b.getWxAppId()).b(o()).a(this);
        if (!TextUtils.isEmpty(this.f29662b.getWxAppId())) {
            a2.a(d(this.f29662b.getWxAppId()));
        }
        a1.c(a2);
    }

    private void c(b bVar) {
        String str;
        if (bVar == null) {
            str = "";
        } else {
            str = bVar.j() + "";
        }
        String d2 = bVar == null ? "" : bVar.d();
        String P = bVar == null ? "" : bVar.P();
        Context context = this.f29661a;
        String packageName = context == null ? "" : context.getPackageName();
        String valueOf = String.valueOf(1);
        AdParams adParams = this.f29662b;
        String positionId = adParams != null ? adParams.getPositionId() : "";
        if (f() == 5) {
            valueOf = String.valueOf(0);
        }
        String str2 = valueOf;
        r z = bVar == null ? null : bVar.z();
        w.a(P, positionId, packageName, str, String.valueOf((z == null || 1 != z.a()) ? 0 : 1), this.f29663c, String.valueOf(this.n), d2, "3001000", String.valueOf(this.f29668h), str2, String.valueOf(f()));
    }

    @Override // com.vivo.mobilead.unified.base.callback.f
    public void b(@NonNull AdError adError) {
        k0.a(k(), this.f29666f, 0);
        c(this.f29666f);
        this.m = false;
        a(new AdError(40214, "下载广告素材失败，请检查网络是否良好，是否具有文件存储权限", adError.getRequestId(), adError.getToken(), adError.getShowPriority()));
    }

    public void b(String str) {
        this.f29663c = str;
    }

    public void b(int i2) {
        b bVar = this.f29666f;
        if (bVar == null || bVar.m() == 0 || this.p) {
            return;
        }
        if (this.f29666f.m() == 2) {
            if (a(this.f29666f, i2)) {
                this.q = i2;
                this.f29666f.a(i2);
            } else {
                VOpenLog.w(s, "Invalid value for parameter 'price'. Current is " + i2 + ".");
                c();
            }
        } else if (this.f29666f.m() == 1) {
            i2 = this.f29666f.D();
            b bVar2 = this.f29666f;
            bVar2.a(bVar2.D());
        }
        a(this.f29666f, 1, i2, 0);
    }

    private void c(int i2, int i3) {
        if (this.f29670j) {
            this.f29670j = false;
            this.f29667g = 1;
        } else {
            p();
            this.f29667g = 2;
        }
        k0.a(k(), this.f29663c, this.f29662b.getPositionId(), this.f29662b.getSourceAppend(), h(), i2, this.f29667g, f() == 5 ? 0 : 1, i3, this.o, this.f29662b.getFloorPrice(), c.a.f28912a.intValue());
    }

    public void b(int i2, int i3) {
        b bVar = this.f29666f;
        if (bVar == null || bVar.m() == 0 || this.p) {
            return;
        }
        a(this.f29666f, 0, i3, i2);
    }

    public void c(String str) {
        this.f29664d = str;
    }

    @Override // com.vivo.mobilead.unified.base.callback.j
    public void a(@NonNull List<b> list, long j2) {
        r z;
        if (list.size() != 0 && list.get(0) != null) {
            b bVar = list.get(0);
            this.f29666f = bVar;
            b(bVar);
            this.f29666f.a().a(this.f29668h);
            this.f29666f.a(this.f29662b.getWxAppId());
            int i2 = f() == 5 ? 0 : 1;
            if (a(j2)) {
                k0.a(this.f29666f, k(), this.f29662b.getSourceAppend(), h(), this.f29667g, i2, c.a.f28912a.intValue(), this.n);
            } else {
                Context context = this.f29661a;
                String packageName = context == null ? "" : context.getPackageName();
                b bVar2 = this.f29666f;
                String valueOf = bVar2 == null ? "" : String.valueOf(bVar2.j());
                String valueOf2 = String.valueOf(0);
                b bVar3 = this.f29666f;
                if (bVar3 != null && (z = bVar3.z()) != null && 1 == z.a()) {
                    valueOf2 = String.valueOf(1);
                }
                String str = valueOf2;
                b bVar4 = this.f29666f;
                w.a(this.f29662b.getPositionId(), packageName, valueOf, str, this.f29663c, bVar4 != null ? bVar4.d() : "", "3000005", String.valueOf(this.f29668h), String.valueOf(i2), String.valueOf(f()));
            }
            y0.a(this.f29666f);
            return;
        }
        a(new AdError(40218, "没有广告，建议过一会儿重试", null, null));
    }

    @Override // com.vivo.mobilead.unified.base.callback.j
    public void a(@NonNull AdError adError) {
        d(adError);
    }

    @Override // com.vivo.mobilead.unified.base.callback.f
    public void a(@NonNull b bVar) {
        k0.a(k(), bVar, 1);
        n();
    }

    public void a(com.vivo.mobilead.g.b bVar) {
        this.r = bVar;
    }

    protected boolean a(long j2) {
        if (this.f29666f == null) {
            return false;
        }
        e();
        com.vivo.ad.model.f f2 = this.f29666f.f();
        if (f2 != null && f2.c() != null && f2.c().size() > 0) {
            a1.c(com.vivo.mobilead.unified.base.b.a().a(this.f29666f).a(j2).a(this));
            return true;
        }
        this.m = true;
        a(new AdError(40219, "没有广告素材，建议重试", this.f29666f.G(), this.f29666f.P(), this.f29666f.J()));
        return false;
    }

    public void a(String str) {
        this.f29665e = str;
    }

    public final void a(b bVar, int i2, int i3, int i4) {
        if (this.p) {
            return;
        }
        this.p = true;
        k0.b(bVar, i2, i3, i4, this.f29662b.getSourceAppend());
        k0.a(bVar, i2, i3, i4, this.f29662b.getSourceAppend());
    }

    public boolean a(b bVar, int i2) {
        return bVar != null && i2 > 0 && i2 <= bVar.D();
    }
}
