package com.kwad.components.core.h;

import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class a {
    private CopyOnWriteArrayList<b> JL = new CopyOnWriteArrayList<>();
    private volatile boolean JM;

    /* renamed from: com.kwad.components.core.h.a$a, reason: collision with other inner class name */
    static final class C0177a {
        private static final a JN = new a();
    }

    public static class b {
        private final c JO;
        public boolean JP;

        public b(c cVar) {
            this.JO = cVar;
        }
    }

    public interface c {
        void bs();
    }

    public static boolean b(b bVar) {
        if (bVar == null) {
            return true;
        }
        return bVar.JP;
    }

    public static a nC() {
        return C0177a.JN;
    }

    public final void a(b bVar) {
        if (this.JL.contains(bVar)) {
            return;
        }
        if (!this.JM) {
            this.JM = true;
            bVar.JP = true;
        }
        this.JL.add(bVar);
    }

    public final void c(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.JP) {
            bVar.JP = false;
            this.JM = false;
        }
        this.JL.remove(bVar);
        if (this.JL.size() == 0 || this.JM) {
            return;
        }
        this.JL.get(0).JP = true;
        this.JM = true;
        this.JL.get(0).JO.bs();
    }
}
