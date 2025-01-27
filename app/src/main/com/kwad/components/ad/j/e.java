package com.kwad.components.ad.j;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class e {
    private final List<com.kwad.components.ad.b.a.b> pA;
    private final AtomicBoolean pz;

    public static class a {
        private static final e pB = new e((byte) 0);
    }

    public /* synthetic */ e(byte b10) {
        this();
    }

    public static e fp() {
        return a.pB;
    }

    public final boolean S() {
        return this.pz.get();
    }

    public final void a(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.pA.add(bVar);
        }
    }

    public final void b(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.pA.remove(bVar);
        }
    }

    public final void fl() {
        this.pz.set(true);
        Iterator<com.kwad.components.ad.b.a.b> it = this.pA.iterator();
        while (it.hasNext()) {
            it.next().T();
        }
    }

    public final void fn() {
        this.pz.set(false);
        Iterator<com.kwad.components.ad.b.a.b> it = this.pA.iterator();
        while (it.hasNext()) {
            it.next().U();
        }
    }

    private e() {
        this.pz = new AtomicBoolean();
        this.pA = new CopyOnWriteArrayList();
    }
}
