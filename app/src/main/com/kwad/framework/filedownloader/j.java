package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public final class j {
    static int ahP = 10;
    static int ahQ = 5;
    private final Executor ahL;
    private final LinkedBlockingQueue<t> ahM;
    private final Object ahN;
    private final ArrayList<t> ahO;
    private final Handler handler;

    /* renamed from: com.kwad.framework.filedownloader.j$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ t ahR;

        public AnonymousClass1(t tVar) {
            tVar = tVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tVar.vP();
        }
    }

    public static final class a {
        private static final j ahT = new j((byte) 0);
    }

    public static class b implements Handler.Callback {
        private b() {
        }

        private static void a(ArrayList<t> arrayList) {
            Iterator<t> it = arrayList.iterator();
            while (it.hasNext()) {
                t next = it.next();
                if (next != null) {
                    next.vP();
                }
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                ((t) message.obj).vP();
            } else if (i10 == 2) {
                a((ArrayList) message.obj);
                j.vL().push();
            }
            return true;
        }

        public /* synthetic */ b(byte b10) {
            this();
        }
    }

    public /* synthetic */ j(byte b10) {
        this();
    }

    private void b(t tVar) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    private void c(t tVar) {
        synchronized (this.ahN) {
            this.ahM.offer(tVar);
        }
        push();
    }

    public void push() {
        synchronized (this.ahN) {
            try {
                if (this.ahO.isEmpty()) {
                    if (this.ahM.isEmpty()) {
                        return;
                    }
                    int i10 = 0;
                    if (vM()) {
                        int i11 = ahP;
                        int min = Math.min(this.ahM.size(), ahQ);
                        while (i10 < min) {
                            this.ahO.add(this.ahM.remove());
                            i10++;
                        }
                        i10 = i11;
                    } else {
                        this.ahM.drainTo(this.ahO);
                    }
                    Handler handler = this.handler;
                    handler.sendMessageDelayed(handler.obtainMessage(2, this.ahO), i10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static j vL() {
        return a.ahT;
    }

    private static boolean vM() {
        return ahP > 0;
    }

    private j() {
        this.ahL = com.kwad.framework.filedownloader.f.b.r(5, "BlockCompleted");
        this.ahN = new Object();
        this.ahO = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.ahM = new LinkedBlockingQueue<>();
    }

    public final void a(t tVar) {
        a(tVar, false);
    }

    private void a(t tVar, boolean z10) {
        if (tVar.vQ()) {
            tVar.vP();
            return;
        }
        if (tVar.vR()) {
            this.ahL.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.j.1
                final /* synthetic */ t ahR;

                public AnonymousClass1(t tVar2) {
                    tVar = tVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    tVar.vP();
                }
            });
            return;
        }
        if (!vM() && !this.ahM.isEmpty()) {
            synchronized (this.ahN) {
                try {
                    if (!this.ahM.isEmpty()) {
                        Iterator<t> it = this.ahM.iterator();
                        while (it.hasNext()) {
                            b(it.next());
                        }
                    }
                    this.ahM.clear();
                } finally {
                }
            }
        }
        if (!vM()) {
            b(tVar2);
        } else {
            c(tVar2);
        }
    }
}
