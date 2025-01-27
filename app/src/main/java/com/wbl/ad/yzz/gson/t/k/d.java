package com.wbl.ad.yzz.gson.t.k;

import com.wbl.ad.yzz.gson.p;
import com.wbl.ad.yzz.gson.q;
import com.wbl.ad.yzz.gson.r;

/* loaded from: classes5.dex */
public final class d implements r {

    /* renamed from: a */
    public final com.wbl.ad.yzz.gson.t.b f32311a;

    public d(com.wbl.ad.yzz.gson.t.b bVar) {
        this.f32311a = bVar;
    }

    @Override // com.wbl.ad.yzz.gson.r
    public <T> q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
        com.wbl.ad.yzz.gson.s.b bVar = (com.wbl.ad.yzz.gson.s.b) aVar.a().getAnnotation(com.wbl.ad.yzz.gson.s.b.class);
        if (bVar == null) {
            return null;
        }
        return (q<T>) a(this.f32311a, eVar, aVar, bVar);
    }

    public q<?> a(com.wbl.ad.yzz.gson.t.b bVar, com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<?> aVar, com.wbl.ad.yzz.gson.s.b bVar2) {
        q<?> lVar;
        Object a2 = bVar.a(com.wbl.ad.yzz.gson.u.a.a((Class) bVar2.value())).a();
        if (a2 instanceof q) {
            lVar = (q) a2;
        } else if (a2 instanceof r) {
            lVar = ((r) a2).a(eVar, aVar);
        } else {
            boolean z = a2 instanceof p;
            if (!z && !(a2 instanceof com.wbl.ad.yzz.gson.j)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a2.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            lVar = new l<>(z ? (p) a2 : null, a2 instanceof com.wbl.ad.yzz.gson.j ? (com.wbl.ad.yzz.gson.j) a2 : null, eVar, aVar, null);
        }
        return (lVar == null || !bVar2.nullSafe()) ? lVar : lVar.a();
    }
}
