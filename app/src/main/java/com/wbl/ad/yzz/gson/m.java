package com.wbl.ad.yzz.gson;

import com.wbl.ad.yzz.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class m extends k {

    /* renamed from: a */
    public final LinkedTreeMap<String, k> f32263a = new LinkedTreeMap<>();

    public void a(String str, k kVar) {
        if (kVar == null) {
            kVar = l.f32262a;
        }
        this.f32263a.put(str, kVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof m) && ((m) obj).f32263a.equals(this.f32263a));
    }

    public Set<Map.Entry<String, k>> h() {
        return this.f32263a.entrySet();
    }

    public int hashCode() {
        return this.f32263a.hashCode();
    }
}
