package com.aggmoread.sdk.z.b.k;

import android.view.View;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.b.g.b;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.g.g;
import com.aggmoread.sdk.z.b.k.c;
import com.aggmoread.sdk.z.b.m.l;
import com.baidu.mobads.sdk.api.IAdInterListener;

/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: l */
    private com.aggmoread.sdk.z.b.k.a f4653l;

    /* renamed from: m */
    private b.a.C0072a f4654m;

    /* renamed from: n */
    private com.aggmoread.sdk.z.b.g.b f4655n;

    /* renamed from: o */
    private com.aggmoread.sdk.z.b.s.a f4656o;

    public class a implements c.k {

        /* renamed from: a */
        final /* synthetic */ b.a.C0072a f4657a;

        public a(b.a.C0072a c0072a) {
            this.f4657a = c0072a;
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void a() {
            if (b.this.f4653l != null) {
                b.this.f4653l.b(b.this);
            }
            b.a.C0072a c0072a = this.f4657a;
            if (c0072a != null) {
                com.aggmoread.sdk.z.b.q.a.a("onAdExposure", c0072a.q());
            }
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void b() {
            if (b.this.f4653l != null) {
                b.this.f4653l.d(b.this);
            }
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void c() {
            b.this.j();
            if (b.this.f4653l != null) {
                b.this.f4653l.c(b.this);
            }
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void onRenderSuccess() {
            if (b.this.f4653l != null) {
                b.this.f4653l.a(b.this);
            }
        }

        @Override // com.aggmoread.sdk.z.b.k.c.k
        public void a(String str) {
            if (b.this.f4653l != null) {
                b.this.f4653l.a(b.this, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, str));
            }
        }
    }

    public b(com.aggmoread.sdk.z.b.g.b bVar, b.a.C0072a c0072a, com.aggmoread.sdk.z.b.k.a aVar) {
        super(bVar.d().j());
        this.f4653l = aVar;
        this.f4654m = c0072a;
        this.f4655n = bVar;
        a(c0072a);
    }

    private com.aggmoread.sdk.z.b.g.c i() {
        com.aggmoread.sdk.z.b.s.a aVar = this.f4656o;
        return aVar != null ? aVar.a() : new com.aggmoread.sdk.z.b.g.c();
    }

    public void j() {
        com.aggmoread.sdk.z.b.q.a.a(IAdInterListener.AdCommandType.AD_CLICK, this.f4654m.p(), i());
        l.a(this.f4655n, this.f4654m, i(), this.f4653l);
    }

    @Override // com.aggmoread.sdk.z.b.k.c
    public View a() {
        View a10 = super.a();
        this.f4656o = com.aggmoread.sdk.z.b.s.a.a(a10, null);
        return a10;
    }

    @Override // com.aggmoread.sdk.z.b.k.c
    public int b() {
        return this.f4654m.f4463s;
    }

    @Override // com.aggmoread.sdk.z.b.k.c
    public String c() {
        return this.f4654m.a();
    }

    private void a(b.a.C0072a c0072a) {
        if (c0072a != null) {
            g gVar = new g();
            gVar.f4505a = c0072a.j();
            gVar.f4509e = c0072a.f();
            gVar.f4508d = c0072a.a();
            a(gVar);
        }
        a(new a(c0072a));
    }
}
