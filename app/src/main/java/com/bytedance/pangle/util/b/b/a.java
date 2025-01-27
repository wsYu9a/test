package com.bytedance.pangle.util.b.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    public List<c> f7836a = new ArrayList();

    public final void a(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (c cVar : this.f7836a) {
            if (!set.contains(cVar.f7846h)) {
                arrayList.add(cVar);
            }
        }
        this.f7836a = arrayList;
    }
}
