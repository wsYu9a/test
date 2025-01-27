package com.aggmoread.sdk.z.d.a.a.d.a.d.o.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.aggmoread.sdk.z.a.e.a;
import com.aggmoread.sdk.z.b.f.b;
import com.aggmoread.sdk.z.d.a.a.d.a.d.o.c;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public class a extends com.aggmoread.sdk.z.d.a.a.d.a.d.a implements com.aggmoread.sdk.z.b.f.a {

    /* renamed from: r */
    private b f5396r;

    public a(d dVar, e eVar) {
        super(dVar, eVar);
    }

    private void y() {
        View a10;
        if (this.f5291m && this.f5396r != null && this.f5293o.compareAndSet(false, true)) {
            com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = this.f5295q.get();
            if (aVar == null || (a10 = this.f5396r.a()) == null) {
                b(new i(1001002008, "广告展示失败!"));
                return;
            }
            if (a10.getParent() != null) {
                ((ViewGroup) a10.getParent()).removeView(a10);
            }
            aVar.addView(a10);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.m.a
    public void a(ViewGroup viewGroup) {
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(this.f5842g.f5858d);
        this.f5295q = new WeakReference<>(aVar);
        aVar.addOnAttachStateChangeListener(new com.aggmoread.sdk.z.d.a.a.d.b.m.b());
        if (viewGroup != null) {
            ViewGroup viewGroup2 = (ViewGroup) aVar.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(aVar);
            }
            viewGroup.addView(aVar, new ViewGroup.LayoutParams(-1, -2));
        }
        y();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.m.a
    public void b() {
        a(this.f5842g.f5864j);
    }

    @Override // com.aggmoread.sdk.z.b.f.a
    public void c(b bVar) {
    }

    @Override // com.aggmoread.sdk.z.b.f.a
    public void d(b bVar) {
        r();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.m.a
    public void destroy() {
        b bVar = this.f5396r;
        if (bVar != null) {
            bVar.g();
            this.f5396r = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public String j() {
        b bVar = this.f5396r;
        return bVar != null ? bVar.c() : super.j();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        String str;
        String[] split;
        try {
            c.a().a(j.f6027q);
            int b10 = this.f5842g.f5871q.b();
            int a10 = this.f5842g.f5871q.a();
            if (b10 <= 0) {
                b10 = DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;
            }
            if (a10 <= 0) {
                a10 = 1920;
            }
            String c10 = this.f5843h.f5907c.c(e.c.T);
            if (!TextUtils.isEmpty(c10) && c10.contains("ban_test_")) {
                c10 = c10.replace("ban_test_", "").trim();
            }
            if (TextUtils.isEmpty(c10) || !c10.contains("#") || (split = c10.split("#")) == null || split.length <= 1) {
                str = null;
            } else {
                c10 = split[0];
                str = split[1];
            }
            com.aggmoread.sdk.z.d.a.a.e.e.b("AGBANNERHTAG", "slot id " + c10);
            new a.b(this.f5842g.f5858d).b(this.f5842g.f5867m).b(c10).d(str).c(this.f5843h.f5907c.c(e.c.X)).a(this.f5843h.f5907c.c(e.c.W)).e(this.f5843h.f5907c.c(e.c.f5921b0)).e(b10).c(a10).b(com.aggmoread.sdk.z.d.a.a.d.a.d.o.b.a(this.f5843h)).d().a(this);
            new k(this.f5842g, this.f5843h).a(0).b();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.aggmoread.sdk.z.b.f.a
    public void onAdLoaded(List<b> list) {
        if (list == null || list.size() <= 0) {
            b(new i(-1000, "广告无填充!"));
            return;
        }
        b bVar = list.get(0);
        this.f5396r = bVar;
        int b10 = bVar.b();
        if (com.aggmoread.sdk.z.d.a.a.d.a.d.o.b.a(this.f5843h, b10)) {
            a(b10, 0);
            return;
        }
        b(b10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.o.b.b(this.f5841f, b10, this.f5843h);
        v();
    }

    @Override // com.aggmoread.sdk.z.b.f.a
    public void a(b bVar) {
        x();
        a(new View[0]);
        t();
    }

    @Override // com.aggmoread.sdk.z.b.f.a
    public void b(b bVar) {
        q();
    }

    @Override // com.aggmoread.sdk.z.b.f.a
    public void a(b bVar, com.aggmoread.sdk.z.b.g.e eVar) {
        b(new i(eVar.a(), eVar.b()));
    }

    @Override // com.aggmoread.sdk.z.b.i.b
    public void a(com.aggmoread.sdk.z.b.g.e eVar) {
        b(new i(eVar.a(), eVar.b()));
    }
}
