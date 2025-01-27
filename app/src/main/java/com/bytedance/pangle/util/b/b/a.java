package com.bytedance.pangle.util.b.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public List<c> f6313a = new ArrayList();

    public final void a(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (c cVar : this.f6313a) {
            if (!set.contains(cVar.f6323h)) {
                arrayList.add(cVar);
            }
        }
        this.f6313a = arrayList;
    }
}
