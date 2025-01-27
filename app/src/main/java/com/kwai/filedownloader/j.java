package com.kwai.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public final class j {
    static int aFM = 10;
    static int aFN = 5;
    private final Executor aFI;
    private final LinkedBlockingQueue<t> aFJ;
    private final Object aFK;
    private final ArrayList<t> aFL;
    private final Handler handler;

    /* renamed from: com.kwai.filedownloader.j$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ t aFO;

        AnonymousClass1(t tVar) {
            tVar = tVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tVar.Hc();
        }
    }

    static final class a {
        private static final j aFQ = new j((byte) 0);
    }

    static class b implements Handler.Callback {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        private static void b(ArrayList<t> arrayList) {
            Iterator<t> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().Hc();
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                ((t) message.obj).Hc();
            } else if (i2 == 2) {
                b((ArrayList) message.obj);
                j.GY().push();
            }
            return true;
        }
    }

    private j() {
        this.aFI = com.kwai.filedownloader.e.b.n(5, "BlockCompleted");
        this.aFK = new Object();
        this.aFL = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.aFJ = new LinkedBlockingQueue<>();
    }

    /* synthetic */ j(byte b2) {
        this();
    }

    public static j GY() {
        return a.aFQ;
    }

    private static boolean GZ() {
        return aFM > 0;
    }

    private void a(t tVar, boolean z) {
        if (tVar.Hd()) {
            tVar.Hc();
            return;
        }
        if (tVar.He()) {
            this.aFI.execute(new Runnable() { // from class: com.kwai.filedownloader.j.1
                final /* synthetic */ t aFO;

                AnonymousClass1(t tVar2) {
                    tVar = tVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    tVar.Hc();
                }
            });
            return;
        }
        if (!GZ() && !this.aFJ.isEmpty()) {
            synchronized (this.aFK) {
                if (!this.aFJ.isEmpty()) {
                    Iterator<t> it = this.aFJ.iterator();
                    while (it.hasNext()) {
                        b(it.next());
                    }
                }
                this.aFJ.clear();
            }
        }
        if (GZ()) {
            c(tVar2);
        } else {
            b(tVar2);
        }
    }

    private void b(t tVar) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    private void c(t tVar) {
        synchronized (this.aFK) {
            this.aFJ.offer(tVar);
        }
        push();
    }

    public void push() {
        synchronized (this.aFK) {
            if (this.aFL.isEmpty()) {
                if (this.aFJ.isEmpty()) {
                    return;
                }
                int i2 = 0;
                if (GZ()) {
                    int i3 = aFM;
                    int min = Math.min(this.aFJ.size(), aFN);
                    while (i2 < min) {
                        this.aFL.add(this.aFJ.remove());
                        i2++;
                    }
                    i2 = i3;
                } else {
                    this.aFJ.drainTo(this.aFL);
                }
                Handler handler = this.handler;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.aFL), i2);
            }
        }
    }

    final void a(t tVar) {
        a(tVar, false);
    }
}
