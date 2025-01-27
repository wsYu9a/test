package com.wbl.ad.yzz.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class h extends k implements Iterable<k> {

    /* renamed from: a */
    public final List<k> f32222a = new ArrayList();

    public void a(k kVar) {
        if (kVar == null) {
            kVar = l.f32262a;
        }
        this.f32222a.add(kVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof h) && ((h) obj).f32222a.equals(this.f32222a));
    }

    public int hashCode() {
        return this.f32222a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<k> iterator() {
        return this.f32222a.iterator();
    }
}
