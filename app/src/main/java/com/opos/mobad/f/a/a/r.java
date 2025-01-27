package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;
import com.opos.mobad.ad.g;
import com.opos.mobad.service.a.e;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class r<T extends com.opos.mobad.ad.b, P extends com.opos.mobad.ad.g> extends i<T> implements o<T, P> {

    /* renamed from: a */
    final HashMap<Integer, List<P>> f20628a;

    /* renamed from: d */
    final s f20629d;

    public r(String str, int i2, com.opos.mobad.f.a.c.a aVar, List<e.a> list, e.a aVar2, long j2, int i3, com.opos.mobad.f.a.b.a<T> aVar3, b.a aVar4) {
        super(str, i2, aVar, list, aVar2, j2, i3, aVar3, aVar4);
        this.f20628a = new HashMap<>();
        this.f20629d = new s(list);
    }

    @Override // com.opos.mobad.f.a.a.i
    protected boolean f(int i2) {
        return this.f20628a.containsKey(Integer.valueOf(i2));
    }

    @Override // com.opos.mobad.f.a.a.o
    public List<P> h() {
        return this.f20628a.remove(Integer.valueOf(j()));
    }

    @Override // com.opos.mobad.f.a.a.i
    protected e.a m() {
        return this.f20629d.a(this.f20628a);
    }
}
