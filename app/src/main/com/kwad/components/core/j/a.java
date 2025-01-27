package com.kwad.components.core.j;

import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class a {
    private CopyOnWriteArrayList<b> On = new CopyOnWriteArrayList<>();
    private volatile boolean Oo;

    /* renamed from: com.kwad.components.core.j.a$a, reason: collision with other inner class name */
    public static final class C0433a {
        private static final a Op = new a();
    }

    public static class b {
        private final c Oq;
        public boolean Or;

        public b(c cVar) {
            this.Oq = cVar;
        }
    }

    public interface c {
        void bM();
    }

    public static boolean b(b bVar) {
        if (bVar == null) {
            return true;
        }
        return bVar.Or;
    }

    public static a pv() {
        return C0433a.Op;
    }

    public final void a(b bVar) {
        if (this.On.contains(bVar)) {
            return;
        }
        if (!this.Oo) {
            this.Oo = true;
            bVar.Or = true;
        }
        this.On.add(bVar);
    }

    public final void c(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.Or) {
            bVar.Or = false;
            this.Oo = false;
        }
        this.On.remove(bVar);
        if (this.On.size() == 0 || this.Oo) {
            return;
        }
        this.On.get(0).Or = true;
        this.Oo = true;
        this.On.get(0).Oq.bM();
    }
}
