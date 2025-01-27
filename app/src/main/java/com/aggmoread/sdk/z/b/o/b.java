package com.aggmoread.sdk.z.b.o;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.b.d;
import com.aggmoread.sdk.z.b.g.b;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.g.g;
import com.aggmoread.sdk.z.b.m.l;
import com.aggmoread.sdk.z.b.o.a;
import com.aggmoread.sdk.z.b.s.c;
import com.baidu.mobads.sdk.api.IAdInterListener;

/* loaded from: classes.dex */
public class b implements com.aggmoread.sdk.z.b.a {

    /* renamed from: a */
    private com.aggmoread.sdk.z.b.g.b f4752a;

    /* renamed from: b */
    private c f4753b;

    /* renamed from: c */
    private b.a.C0072a f4754c;

    /* renamed from: d */
    private com.aggmoread.sdk.z.b.s.a f4755d;

    /* renamed from: e */
    private Activity f4756e;

    /* renamed from: f */
    private Context f4757f;

    /* renamed from: h */
    private String f4759h;

    /* renamed from: j */
    private com.aggmoread.sdk.z.b.o.a f4761j;

    /* renamed from: g */
    private boolean f4758g = false;

    /* renamed from: i */
    private int f4760i = -1;

    public class a implements a.d {

        /* renamed from: a */
        final /* synthetic */ c f4762a;

        public a(c cVar) {
            this.f4762a = cVar;
        }

        @Override // com.aggmoread.sdk.z.b.o.a.d
        public void a() {
            b.this.f();
        }

        @Override // com.aggmoread.sdk.z.b.o.a.d
        public void a(int i10, String str) {
            com.aggmoread.sdk.z.b.s.b.a(this.f4762a, new e(i10, str));
        }

        @Override // com.aggmoread.sdk.z.b.o.a.d
        public void a(Activity activity) {
            b.this.a(activity);
        }

        @Override // com.aggmoread.sdk.z.b.o.a.d
        public void a(com.aggmoread.sdk.z.b.s.a aVar) {
            b.this.f4755d = aVar;
            b.this.h();
            b.this.g();
        }
    }

    private com.aggmoread.sdk.z.b.g.c a() {
        com.aggmoread.sdk.z.b.s.a aVar = this.f4755d;
        return aVar != null ? aVar.a() : new com.aggmoread.sdk.z.b.g.c();
    }

    private void b(Activity activity) {
        d.c("JHInterHandler_dsp", "showAD enter ");
        if (activity == null) {
            com.aggmoread.sdk.z.b.s.b.a(this.f4753b, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "广告展示失败,Activity缺失!"));
            return;
        }
        try {
            com.aggmoread.sdk.z.b.u.a.a(this.f4761j);
            com.aggmoread.sdk.z.b.u.a.a(activity, null);
        } catch (Exception e10) {
            e10.printStackTrace();
            com.aggmoread.sdk.z.b.s.b.a(this.f4753b, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "广告展示失败!"));
        }
    }

    private void e() {
        d.c("JHInterHandler_dsp", "onAdClick = " + a());
        com.aggmoread.sdk.z.b.q.a.a(IAdInterListener.AdCommandType.AD_CLICK, this.f4754c.p(), a());
        this.f4753b.onAdClicked();
    }

    public void f() {
        this.f4753b.a();
    }

    public void g() {
        com.aggmoread.sdk.z.b.q.a.a("onAdExposure", this.f4754c.q());
        this.f4753b.d();
    }

    public void h() {
        this.f4753b.onAdShow();
    }

    @Override // com.aggmoread.sdk.z.b.a
    public String c() {
        b.a.C0072a c0072a = this.f4754c;
        if (c0072a != null) {
            return TextUtils.isEmpty(c0072a.a()) ? this.f4754c.f() : this.f4754c.a();
        }
        return null;
    }

    @Override // com.aggmoread.sdk.z.b.a
    public int d() {
        return this.f4760i;
    }

    public void a(Activity activity) {
        e();
        if (com.aggmoread.sdk.z.b.m.a.a(activity)) {
            com.aggmoread.sdk.z.b.s.b.a(this.f4753b, e.f4493c);
        } else {
            l.a(this.f4752a, this.f4754c, a(), this.f4753b);
        }
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean b() {
        return a(this.f4756e, (ViewGroup) null);
    }

    public void a(com.aggmoread.sdk.z.b.g.b bVar, c cVar) {
        d.c("JHInterHandler_dsp", "handle   enter");
        this.f4752a = bVar;
        this.f4753b = cVar;
        this.f4756e = bVar.d().e();
        Context j10 = bVar.d().j();
        this.f4757f = j10;
        if (this.f4756e == null && (j10 instanceof Activity)) {
            this.f4756e = (Activity) j10;
        }
        b.a.C0072a a10 = bVar.f4443e.get(0).a();
        if (a10 == null) {
            com.aggmoread.sdk.z.b.s.b.a(cVar, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "广告数据异常"));
            return;
        }
        this.f4754c = a10;
        this.f4760i = a10.f4463s;
        this.f4759h = a10.i();
        d.c("JHInterHandler_dsp", "clickUrl = " + this.f4759h);
        g gVar = new g();
        gVar.f4505a = a10.j();
        gVar.f4508d = a10.a();
        gVar.f4509e = a10.f();
        com.aggmoread.sdk.z.b.o.a aVar = new com.aggmoread.sdk.z.b.o.a();
        this.f4761j = aVar;
        aVar.a(gVar);
        this.f4758g = true;
        c cVar2 = this.f4753b;
        if (cVar2 != null) {
            cVar2.a(this);
        }
        this.f4761j.a(new a(cVar));
        if (bVar.d().n()) {
            return;
        }
        b(this.f4756e);
    }

    @Override // com.aggmoread.sdk.z.b.a
    public boolean a(Activity activity, ViewGroup viewGroup) {
        if (!this.f4752a.d().n() || !this.f4758g) {
            return false;
        }
        b(activity);
        return true;
    }
}
