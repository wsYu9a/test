package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.utils.ao;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class g {
    private final c anK;
    private final AtomicInteger anO = new AtomicInteger(0);
    private volatile e anP;
    private final List<b> anQ;
    private final b anR;
    private final String url;

    static final class a extends Handler implements b {
        private final List<b> anQ;
        private final String url;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.url = str;
            this.anQ = list;
        }

        @Override // com.kwad.sdk.core.videocache.b
        public final void a(File file, int i2) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i2;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Iterator<b> it = this.anQ.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.anQ = copyOnWriteArrayList;
        this.url = ao.eK(str);
        this.anK = (c) ao.checkNotNull(cVar);
        this.anR = new a(str, copyOnWriteArrayList);
    }

    private synchronized void yB() {
        this.anP = this.anP == null ? yD() : this.anP;
    }

    private synchronized void yC() {
        if (this.anO.decrementAndGet() <= 0) {
            this.anP.shutdown();
            this.anP = null;
        }
    }

    private e yD() {
        String str = this.url;
        c cVar = this.anK;
        e eVar = new e(new h(str, cVar.anw, cVar.anx), new com.kwad.sdk.core.videocache.kwai.b(this.anK.cP(this.url), this.anK.anv));
        eVar.a(this.anR);
        return eVar;
    }

    public final void a(d dVar, Socket socket) {
        yB();
        try {
            this.anO.incrementAndGet();
            this.anP.a(dVar, socket);
        } finally {
            yC();
        }
    }

    public final void shutdown() {
        this.anQ.clear();
        e eVar = this.anP;
        if (eVar != null) {
            eVar.a((b) null);
            eVar.shutdown();
        }
        this.anP = null;
        this.anO.set(0);
    }

    public final int yy() {
        return this.anO.get();
    }
}
