package com.opos.mobad.f.a.a;

import com.opos.mobad.ad.b;
import com.opos.mobad.service.a.e;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class q<T extends com.opos.mobad.ad.b, P> extends h<T> implements o<T, P> {

    /* renamed from: a */
    final HashMap<Integer, List<P>> f20627a;

    public q(String str, int i2, com.opos.mobad.f.a.c.a aVar, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.a.b.c<T> cVar, b.a aVar3) {
        super(str, i2, aVar, list, aVar2, j2, cVar, aVar3);
        this.f20627a = new HashMap<>();
    }

    @Override // com.opos.mobad.f.a.a.h
    protected boolean g(int i2) {
        return this.f20627a.containsKey(Integer.valueOf(i2));
    }

    @Override // com.opos.mobad.f.a.a.o
    public List<P> h() {
        return this.f20627a.remove(Integer.valueOf(j()));
    }
}
