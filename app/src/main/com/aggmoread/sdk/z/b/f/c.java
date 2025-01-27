package com.aggmoread.sdk.z.b.f;

import android.view.View;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.b.f.b;
import com.aggmoread.sdk.z.b.g.b;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.g.g;
import com.aggmoread.sdk.z.b.m.l;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.List;

/* loaded from: classes.dex */
public class c extends b {

    /* renamed from: m */
    private com.aggmoread.sdk.z.b.f.a f4408m;

    /* renamed from: n */
    private b.a.C0072a f4409n;

    /* renamed from: o */
    private com.aggmoread.sdk.z.b.g.b f4410o;

    /* renamed from: p */
    private com.aggmoread.sdk.z.b.s.a f4411p;

    public class a implements b.l {

        /* renamed from: a */
        final /* synthetic */ b.a.C0072a f4412a;

        public a(b.a.C0072a c0072a) {
            this.f4412a = c0072a;
        }

        @Override // com.aggmoread.sdk.z.b.f.b.l
        public void a() {
            if (c.this.f4408m != null) {
                c.this.f4408m.a(c.this);
            }
            b.a.C0072a c0072a = this.f4412a;
            if (c0072a != null) {
                com.aggmoread.sdk.z.b.q.a.a("onAdExposure", c0072a.q());
            }
        }

        @Override // com.aggmoread.sdk.z.b.f.b.l
        public void b() {
            if (c.this.f4408m != null) {
                c.this.f4408m.d(c.this);
            }
        }

        @Override // com.aggmoread.sdk.z.b.f.b.l
        public void c() {
            c.this.j();
            if (c.this.f4408m != null) {
                c.this.f4408m.b(c.this);
            }
        }

        @Override // com.aggmoread.sdk.z.b.f.b.l
        public void onRenderSuccess() {
            if (c.this.f4408m != null) {
                c.this.f4408m.c(c.this);
            }
        }

        @Override // com.aggmoread.sdk.z.b.f.b.l
        public void a(String str) {
            if (c.this.f4408m != null) {
                c.this.f4408m.a(c.this, new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, str));
            }
        }
    }

    public c(com.aggmoread.sdk.z.b.g.b bVar, b.a.C0072a c0072a, com.aggmoread.sdk.z.b.f.a aVar) {
        super(bVar.d().j());
        this.f4408m = aVar;
        this.f4409n = c0072a;
        this.f4410o = bVar;
        a(c0072a);
    }

    private com.aggmoread.sdk.z.b.g.c i() {
        com.aggmoread.sdk.z.b.s.a aVar = this.f4411p;
        return aVar != null ? aVar.a() : new com.aggmoread.sdk.z.b.g.c();
    }

    public void j() {
        com.aggmoread.sdk.z.b.q.a.a(IAdInterListener.AdCommandType.AD_CLICK, this.f4409n.p(), i());
        l.a(this.f4410o, this.f4409n, i(), this.f4408m);
    }

    @Override // com.aggmoread.sdk.z.b.f.b
    public View a() {
        View a10 = super.a();
        this.f4411p = com.aggmoread.sdk.z.b.s.a.a(a10, null);
        return a10;
    }

    @Override // com.aggmoread.sdk.z.b.f.b
    public int b() {
        return this.f4409n.f4463s;
    }

    @Override // com.aggmoread.sdk.z.b.f.b
    public String c() {
        return this.f4409n.a();
    }

    private void a(b.a.C0072a c0072a) {
        if (c0072a != null) {
            g gVar = new g();
            gVar.f4505a = c0072a.j();
            List<String> g10 = c0072a.g();
            if (g10 != null && g10.size() > 0) {
                gVar.f4509e = g10.get(0);
            }
            gVar.f4508d = c0072a.a();
            a(gVar);
        }
        a(new a(c0072a));
    }
}
