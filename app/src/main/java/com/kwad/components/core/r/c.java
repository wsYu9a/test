package com.kwad.components.core.r;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class c {
    private Set<b> PS;

    static class a {
        private static c PT = new c(0);
    }

    public interface b {
        void onPageClose();
    }

    private c() {
        this.PS = new HashSet();
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    public static c pL() {
        return a.PT;
    }

    public final void a(b bVar) {
        this.PS.add(bVar);
    }

    public final void b(b bVar) {
        this.PS.remove(bVar);
    }

    public final void pM() {
        if (this.PS.size() == 0) {
            return;
        }
        Iterator<b> it = this.PS.iterator();
        while (it.hasNext()) {
            it.next().onPageClose();
        }
    }
}
