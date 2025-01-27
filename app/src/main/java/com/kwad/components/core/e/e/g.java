package com.kwad.components.core.e.e;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class g {
    private final List<f> Nx;

    public static class a {
        private static final g Ny = new g((byte) 0);
    }

    public /* synthetic */ g(byte b10) {
        this();
    }

    public static g pg() {
        return a.Ny;
    }

    public final void a(f fVar) {
        this.Nx.add(fVar);
    }

    public final void b(f fVar) {
        if (fVar != null) {
            this.Nx.remove(fVar);
        }
    }

    public final void ph() {
        Iterator<f> it = this.Nx.iterator();
        while (it.hasNext()) {
            it.next().show();
        }
    }

    public final void pi() {
        Iterator<f> it = this.Nx.iterator();
        while (it.hasNext()) {
            it.next().dismiss();
        }
    }

    private g() {
        this.Nx = new CopyOnWriteArrayList();
    }
}
