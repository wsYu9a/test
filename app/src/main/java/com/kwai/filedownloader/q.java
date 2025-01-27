package com.kwai.filedownloader;

import com.kwai.filedownloader.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes2.dex */
final class q {
    private final b aGb = new b();

    static class a {
        private static final q aGc = new q();

        static {
            com.kwai.filedownloader.message.e.Iv().a(new aa());
        }
    }

    static class b {
        private ThreadPoolExecutor aGd;
        private LinkedBlockingQueue<Runnable> aGe;

        b() {
            init();
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.aGe = linkedBlockingQueue;
            this.aGd = com.kwai.filedownloader.e.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public final void b(x.b bVar) {
            this.aGe.remove(bVar);
        }

        public final void c(x.b bVar) {
            this.aGd.execute(new c(bVar));
        }
    }

    static class c implements Runnable {
        private final x.b aGf;
        private boolean aGg = false;

        c(x.b bVar) {
            this.aGf = bVar;
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) || obj == this.aGf;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.aGg) {
                return;
            }
            this.aGf.start();
        }
    }

    q() {
    }

    public static q Hn() {
        return a.aGc;
    }

    final synchronized void a(x.b bVar) {
        this.aGb.c(bVar);
    }

    final synchronized void b(x.b bVar) {
        this.aGb.b(bVar);
    }
}
