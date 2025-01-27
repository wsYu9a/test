package com.aggmoread.sdk.z.d.a.a.d.a.d.t.d;

import android.view.View;
import com.aggmoread.sdk.z.b.s.f;
import com.aggmoread.sdk.z.c.b.a;
import com.aggmoread.sdk.z.d.a.a.d.a.d.j;
import com.aggmoread.sdk.z.d.a.a.d.a.d.t.b;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class a extends j implements f {

    /* renamed from: x */
    private com.aggmoread.sdk.z.c.b.a f5660x;

    /* renamed from: y */
    private com.aggmoread.sdk.z.b.a f5661y;

    public a(d dVar, e eVar) {
        super(dVar, eVar);
    }

    @Override // com.aggmoread.sdk.z.b.s.e
    public void a() {
        r();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.view.ViewGroup r3) {
        /*
            r2 = this;
            com.aggmoread.sdk.z.b.a r0 = r2.f5661y
            if (r0 == 0) goto L33
            android.content.Context r0 = r3.getContext()
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L13
            android.content.Context r0 = r3.getContext()
        L10:
            android.app.Activity r0 = (android.app.Activity) r0
            goto L1d
        L13:
            com.aggmoread.sdk.z.d.a.a.d.b.d r0 = r2.f5842g
            android.content.Context r0 = r0.f5858d
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L1c
            goto L10
        L1c:
            r0 = 0
        L1d:
            if (r0 == 0) goto L25
            com.aggmoread.sdk.z.b.a r1 = r2.f5661y
            r1.a(r0, r3)
            goto L33
        L25:
            com.aggmoread.sdk.z.d.a.a.d.b.i r3 = new com.aggmoread.sdk.z.d.a.a.d.b.i
            r0 = 1001001000(0x3baa1028, float:0.0051899143)
            java.lang.String r1 = "容器页面不可见!"
            r3.<init>(r0, r1)
            r2.b(r3)
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aggmoread.sdk.z.d.a.a.d.a.d.t.d.a.b(android.view.ViewGroup):void");
    }

    @Override // com.aggmoread.sdk.z.b.s.e
    public void d() {
        s();
    }

    @Override // com.aggmoread.sdk.z.b.s.f
    public void e() {
    }

    @Override // com.aggmoread.sdk.z.b.s.e
    public void onAdClicked() {
        q();
    }

    @Override // com.aggmoread.sdk.z.b.s.e
    public void onAdShow() {
    }

    @Override // com.aggmoread.sdk.z.b.s.f
    public void onAdTick(long j10) {
        a(j10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.j
    public void a(View view) {
        try {
            b.a().a(this.f5842g.f5858d);
            this.f5660x = new a.b(this.f5842g.f5858d).b(this.f5842g.f5867m).a(true).c(this.f5842g.f5868n).a(view).a(this.f5843h.f5907c.c(e.c.T)).d();
            new k(this.f5842g, this.f5843h).a(0).b();
            this.f5660x.a(this);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.aggmoread.sdk.z.b.s.f
    public void a(com.aggmoread.sdk.z.b.a aVar) {
        ArrayList arrayList = new ArrayList();
        this.f5661y = aVar;
        arrayList.add(this);
        e(arrayList);
    }

    @Override // com.aggmoread.sdk.z.b.i.b
    public void a(com.aggmoread.sdk.z.b.g.e eVar) {
        b(new i(eVar.a(), eVar.b()));
    }
}
