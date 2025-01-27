package com.aggmoread.sdk.z.d.a.a.d.a.d.r;

import com.aggmoread.sdk.z.d.a.a.d.b.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class p extends c {

    /* renamed from: l */
    private com.aggmoread.sdk.z.d.a.a.d.b.e f5575l;

    /* renamed from: m */
    private List<o> f5576m;

    public p(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, List<o> list, int i10) {
        this.f5575l = eVar;
        this.f5905a = dVar;
        this.f5906b = new com.aggmoread.sdk.z.d.a.a.e.f(new HashMap(eVar.f5906b.f6092a));
        this.f5908d = eVar.f5908d;
        this.f5576m = list;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                Map<Object, Object> map = list.get(i11).f5574b;
                if (map != null) {
                    arrayList.add(map);
                }
            }
        }
        Map<Object, Object> map2 = this.f5906b.f6092a;
        Object obj = e.c.f5918a;
        map2.put(obj, arrayList);
        List list2 = (List) this.f5906b.f6092a.get(obj);
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        boolean z10 = false;
        for (int i12 = 0; i12 < list2.size(); i12++) {
            com.aggmoread.sdk.z.d.a.a.e.f fVar = new com.aggmoread.sdk.z.d.a.a.e.f((Map) list2.get(i12));
            fVar.c(e.c.T);
            if (!z10 && fVar.b(e.c.V) > dVar.f5876v) {
                this.f5907c = fVar;
                this.f5910f = i12;
                z10 = true;
            }
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public void a(com.aggmoread.sdk.z.d.a.a.d.b.k kVar) {
        this.f5575l.a(kVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public void b(com.aggmoread.sdk.z.d.a.a.d.b.k kVar) {
        this.f5575l.b(kVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public int g() {
        o oVar;
        try {
            List<o> list = this.f5576m;
            if (list != null) {
                int size = list.size();
                int i10 = this.f5910f;
                if (size > i10 && (oVar = this.f5576m.get(i10)) != null) {
                    return oVar.f5573a;
                }
            }
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("ACWFRTAG", "gci err " + e10.getMessage());
        }
        return super.g();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public boolean h() {
        return this.f5575l.h();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public void j() {
        this.f5575l.j();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public void k() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("ACWFRTAG", "watter tryEnd " + this.f5905a.f5857c + ", this " + this);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public boolean l() {
        boolean l10 = super.l();
        com.aggmoread.sdk.z.d.a.a.e.e.b("ACWFRTAG", "watter tryNextSDK " + l10 + ", rid " + this.f5905a.f5857c + ", this " + this);
        if (l10 || this.f5905a.f5861g == null) {
            return true;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b("ACWFRTAG", "notify tryNextSDK");
        this.f5905a.f5861g.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(-20000, "未匹配到合适的广告"));
        return true;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.e
    public void a(boolean z10) {
        this.f5575l.a(true);
    }
}
