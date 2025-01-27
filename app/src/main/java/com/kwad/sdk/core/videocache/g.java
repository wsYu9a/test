package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.utils.au;
import java.io.File;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
final class g {
    private final c aGs;
    private final AtomicInteger aGw = new AtomicInteger(0);
    private volatile e aGx;
    private final List<b> aGy;
    private final b aGz;
    private final String url;

    public static final class a extends Handler implements b {
        private final List<b> aGy;
        private final String url;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.url = str;
            this.aGy = list;
        }

        @Override // com.kwad.sdk.core.videocache.b
        public final void a(File file, int i10) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i10;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Iterator<b> it = this.aGy.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.aGy = copyOnWriteArrayList;
        this.url = au.gV(str);
        this.aGs = (c) au.checkNotNull(cVar);
        this.aGz = new a(str, copyOnWriteArrayList);
    }

    private synchronized void Ii() {
        try {
            if (this.aGs.aGe == 1 && isOkHttpSupported()) {
                this.aGx = this.aGx == null ? Il() : this.aGx;
            } else {
                this.aGx = this.aGx == null ? Ik() : this.aGx;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private synchronized void Ij() {
        if (this.aGw.decrementAndGet() <= 0) {
            this.aGx.shutdown();
            this.aGx = null;
        }
    }

    private e Ik() {
        String str = this.url;
        c cVar = this.aGs;
        e eVar = new e(new h(str, cVar.aGc, cVar.aGd), new com.kwad.sdk.core.videocache.a.b(this.aGs.eJ(this.url), this.aGs.aGb));
        eVar.a(this.aGz);
        return eVar;
    }

    private e Il() {
        String str = this.url;
        c cVar = this.aGs;
        e eVar = new e(new j(str, cVar.aGc, cVar.aGd), new com.kwad.sdk.core.videocache.a.b(this.aGs.eJ(this.url), this.aGs.aGb));
        eVar.a(this.aGz);
        return eVar;
    }

    private static boolean isOkHttpSupported() {
        try {
            Class.forName("okhttp3.OkHttpClient");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final int If() {
        return this.aGw.get();
    }

    public final void a(d dVar, Socket socket) {
        Ii();
        try {
            this.aGw.incrementAndGet();
            this.aGx.a(dVar, socket);
        } finally {
            Ij();
        }
    }

    public final void shutdown() {
        this.aGy.clear();
        e eVar = this.aGx;
        if (eVar != null) {
            eVar.a((b) null);
            eVar.shutdown();
        }
        this.aGx = null;
        this.aGw.set(0);
    }
}
