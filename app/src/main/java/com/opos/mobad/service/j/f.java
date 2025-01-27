package com.opos.mobad.service.j;

import com.opos.mobad.service.j.c;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class f<T extends c> implements d<T> {

    /* renamed from: a */
    private List<d<T>> f23714a;

    public f(List<d<T>> list) {
        this.f23714a = list;
    }

    @Override // com.opos.mobad.service.j.d
    public boolean a(T t) {
        List<d<T>> list = this.f23714a;
        if (list == null || list.size() <= 0) {
            return true;
        }
        Iterator<d<T>> it = this.f23714a.iterator();
        while (it.hasNext()) {
            if (it.next().a(t)) {
                return true;
            }
        }
        return false;
    }
}
