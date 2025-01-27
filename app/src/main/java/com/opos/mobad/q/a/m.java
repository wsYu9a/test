package com.opos.mobad.q.a;

import android.content.Context;
import android.view.View;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.q.a.a;
import com.opos.mobad.q.a.j;

/* loaded from: classes4.dex */
public abstract class m implements e {

    /* renamed from: a */
    private AdItemData f23378a;

    /* renamed from: b */
    private MaterialData f23379b;
    protected final com.opos.mobad.q.a.a l;
    protected j m;
    protected l n;
    protected long o = -1;

    /* renamed from: com.opos.mobad.q.a.m$1 */
    class AnonymousClass1 implements com.opos.mobad.ad.h {

        /* renamed from: a */
        final /* synthetic */ a f23380a;

        AnonymousClass1(a aVar) {
            aVar2 = aVar;
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
            m.this.a(aVar2, objArr);
        }
    }

    public interface a extends com.opos.mobad.ad.h, a.InterfaceC0474a, j.a {
    }

    public m(Context context, String str, com.opos.mobad.cmn.a.a aVar, b.InterfaceC0437b interfaceC0437b, a aVar2) {
        this.l = new com.opos.mobad.q.a.a(context, str, aVar, interfaceC0437b, aVar2);
        this.m = new j(context, str, aVar2);
        this.n = new l(context, new com.opos.mobad.ad.h() { // from class: com.opos.mobad.q.a.m.1

            /* renamed from: a */
            final /* synthetic */ a f23380a;

            AnonymousClass1(a aVar22) {
                aVar2 = aVar22;
            }

            @Override // com.opos.mobad.ad.h
            public void a(Object... objArr) {
                m.this.a(aVar2, objArr);
            }
        });
    }

    private int a(int i2) {
        if (i2 == 0) {
            return 10410;
        }
        if (i2 == 1) {
            return 10411;
        }
        if (i2 == 2) {
            return 10412;
        }
        if (i2 != 100) {
            return i2 != 101 ? -1 : 10409;
        }
        return 10402;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void a(int i2, String str) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onError" + i2);
        this.m.a(a(i2), str);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void a(long j2, long j3) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onComplete" + j2);
        this.o = j3;
        this.m.a(j3);
        this.n.b(j2);
    }

    public void a(View view) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onShow");
        this.l.a(view);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void a(View view, int[] iArr, boolean z) {
    }

    public void a(com.opos.mobad.ad.h hVar, Object... objArr) {
        if (hVar == null) {
            return;
        }
        hVar.a(objArr);
    }

    public void a(AdItemData adItemData, MaterialData materialData, int i2) {
        a(adItemData, materialData, -1L, i2, materialData.af());
    }

    public void a(AdItemData adItemData, MaterialData materialData, long j2, int i2) {
        a(adItemData, materialData, j2, i2, materialData.af());
    }

    public void a(AdItemData adItemData, MaterialData materialData, long j2, int i2, int i3) {
        this.f23378a = adItemData;
        this.f23379b = materialData;
        this.o = -1L;
        this.l.a(adItemData, materialData, i2, i3);
        this.m.a(adItemData, materialData, j2, i2);
        this.n.a(adItemData, materialData);
    }

    protected boolean a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar) {
        return a(view, iArr, aVar, (a.c) null);
    }

    protected boolean a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar, a.c cVar) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onClick" + aVar);
        if (!com.opos.mobad.cmn.a.b.g.a(this.f23378a, aVar)) {
            return false;
        }
        long j2 = this.o;
        this.l.a(view, iArr, aVar, this.o, j2 > 0 ? com.opos.mobad.cmn.a.b.d.a(j2, this.f23379b.u()) : null, cVar);
        l lVar = this.n;
        if (lVar != null) {
            lVar.a();
        }
        return true;
    }

    @Override // com.opos.mobad.o.c.a.InterfaceC0471a
    public void a_(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.a.b.a.Pendant);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void b(int i2) {
        this.l.a(i2);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void b(long j2, long j3) {
    }

    public void c() {
        this.l.b();
        this.m.a();
        this.n.e();
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void c(int i2) {
        this.l.d(i2);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void c(long j2, long j3) {
    }

    public void d(int i2) {
        this.l.b(i2);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void d(long j2, long j3) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onProcess =" + j2 + ",duration =" + j3);
        this.o = j2;
        this.m.a(j2, j3);
        this.n.a(j2);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void d(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onCloseClick");
        this.l.a(false, iArr);
        this.m.a(view, iArr, this.o);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void e() {
        this.l.a();
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void e(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.a.b.a.Video);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void f(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.a.b.a.ClickBt);
    }

    public void g() {
        com.opos.cmn.an.f.a.b("UniversalPresenter", "onBackClick");
        this.l.a(true, (int[]) null);
        this.m.a((View) null, (int[]) null, this.o);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void g(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.a.b.a.NonClickBt);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void h(View view, int[] iArr) {
        l lVar = this.n;
        if (lVar != null) {
            lVar.c();
        }
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void i(View view, int[] iArr) {
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void j(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.a.b.a.FloatLayerNonClickBt);
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void k(View view, int[] iArr) {
        a(view, iArr, com.opos.mobad.cmn.a.b.a.FloatLayerClickBt);
    }
}
