package com.kwad.sdk.core.network;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class i {
    private static volatile i agy;
    private List<a> agx = new CopyOnWriteArrayList();

    public interface a {
        void a(g gVar, int i2);
    }

    private i() {
    }

    public static i wf() {
        if (agy == null) {
            synchronized (i.class) {
                if (agy == null) {
                    agy = new i();
                }
            }
        }
        return agy;
    }

    public final void a(a aVar) {
        this.agx.add(aVar);
    }

    final void b(g gVar, int i2) {
        Iterator<a> it = this.agx.iterator();
        while (it.hasNext()) {
            it.next().a(gVar, i2);
        }
    }
}
