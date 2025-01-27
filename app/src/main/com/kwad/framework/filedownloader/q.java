package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes3.dex */
final class q {
    private final b aie = new b();

    public static class a {
        private static final q aif = new q();

        static {
            com.kwad.framework.filedownloader.message.e.xn().a(new aa());
        }
    }

    public static class b {
        private ThreadPoolExecutor aig;
        private LinkedBlockingQueue<Runnable> aih;

        public b() {
            init();
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.aih = linkedBlockingQueue;
            this.aig = com.kwad.framework.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public final void b(x.b bVar) {
            this.aih.remove(bVar);
        }

        public final void c(x.b bVar) {
            this.aig.execute(new c(bVar));
        }
    }

    public static class c implements Runnable {
        private final x.b aii;
        private boolean aij = false;

        public c(x.b bVar) {
            this.aii = bVar;
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) || obj == this.aii;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.aij) {
                return;
            }
            this.aii.start();
        }
    }

    public static q wa() {
        return a.aif;
    }

    public final synchronized void a(x.b bVar) {
        this.aie.c(bVar);
    }

    public final synchronized void b(x.b bVar) {
        this.aie.b(bVar);
    }
}
