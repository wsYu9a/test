package com.kwad.components.core.s;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public final class c {
    private Set<b> VL;

    public static class a {
        private static c VM = new c(0);
    }

    public interface b {
        void onPageClose();
    }

    public /* synthetic */ c(byte b10) {
        this();
    }

    public static c sd() {
        return a.VM;
    }

    public final void a(b bVar) {
        this.VL.add(bVar);
    }

    public final void b(b bVar) {
        this.VL.remove(bVar);
    }

    public final void se() {
        if (this.VL.size() == 0) {
            return;
        }
        Iterator<b> it = this.VL.iterator();
        while (it.hasNext()) {
            it.next().onPageClose();
        }
    }

    private c() {
        this.VL = new HashSet();
    }
}
