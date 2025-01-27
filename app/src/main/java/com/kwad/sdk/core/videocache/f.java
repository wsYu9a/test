package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.au;
import com.sigmob.sdk.videocache.h;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class f {
    private final Object aGn;
    private final ExecutorService aGo;
    private final Map<String, g> aGp;
    private final ServerSocket aGq;
    private final Thread aGr;
    private final com.kwad.sdk.core.videocache.c aGs;
    private final int port;

    public static final class a {
        private File aFZ;
        private com.kwad.sdk.core.videocache.d.c aGc;
        private int aGe;
        private Context context;
        private int aGf = 0;
        private com.kwad.sdk.core.videocache.a.a aGb = new com.kwad.sdk.core.videocache.a.g(h.b.f20616f);
        private com.kwad.sdk.core.videocache.a.c aGa = new com.kwad.sdk.core.videocache.a.f();
        private com.kwad.sdk.core.videocache.b.b aGd = new com.kwad.sdk.core.videocache.b.a();

        public a(Context context) {
            this.context = context;
            this.aFZ = o.bB(context);
        }

        private com.kwad.sdk.core.videocache.c Ih() {
            return new com.kwad.sdk.core.videocache.c(this.aFZ, this.aGa, this.aGb, this.aGc, this.aGd, this.aGe, this.aGf);
        }

        public final f Ig() {
            this.aGc = com.kwad.sdk.core.videocache.d.d.k(this.context, this.aGf);
            return new f(Ih(), (byte) 0);
        }

        public final a aB(long j10) {
            this.aGb = new com.kwad.sdk.core.videocache.a.g(h.b.f20616f);
            return this;
        }

        public final a dw(int i10) {
            this.aGe = i10;
            return this;
        }

        public final a dx(int i10) {
            this.aGf = i10;
            return this;
        }
    }

    public final class b implements Runnable {
        private final Socket aGt;

        public b(Socket socket) {
            this.aGt = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            f.this.a(this.aGt);
        }
    }

    public final class c implements Runnable {
        private final CountDownLatch aGv;

        public c(CountDownLatch countDownLatch) {
            this.aGv = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.aGv.countDown();
                f.this.Ie();
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTrace(th2);
            }
        }
    }

    public /* synthetic */ f(com.kwad.sdk.core.videocache.c cVar, byte b10) {
        this(cVar);
    }

    public void Ie() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.aGq.accept();
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Accept new socket " + accept);
                this.aGo.submit(new b(accept));
            } catch (IOException e10) {
                onError(new ProxyCacheException("Error during waiting connection", e10));
                return;
            }
        }
    }

    private int If() {
        int i10;
        synchronized (this.aGn) {
            try {
                Iterator<g> it = this.aGp.values().iterator();
                i10 = 0;
                while (it.hasNext()) {
                    i10 += it.next().If();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i10;
    }

    private File W(String str) {
        com.kwad.sdk.core.videocache.c cVar = this.aGs;
        return new File(cVar.aFZ, cVar.aGa.generate(str));
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e10) {
            onError(new ProxyCacheException("Error closing socket input stream", e10));
        }
    }

    private static void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            com.kwad.sdk.core.d.c.w("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e10) {
            onError(new ProxyCacheException("Error closing socket", e10));
        }
    }

    private String eQ(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", com.sigmob.sdk.videocache.h.f20606j, Integer.valueOf(this.port), l.encode(str));
    }

    private File eR(String str) {
        return new File(this.aGs.aFZ, this.aGs.aGa.generate(str) + com.sigmob.sdk.videocache.file.b.f20592d);
    }

    private g eS(String str) {
        g gVar;
        synchronized (this.aGn) {
            try {
                gVar = this.aGp.get(str);
                if (gVar == null) {
                    gVar = new g(str, this.aGs);
                    this.aGp.put(str, gVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return gVar;
    }

    private String f(String str, boolean z10) {
        if (!W(str).exists()) {
            return eQ(str);
        }
        File W = W(str);
        r(W);
        return Uri.fromFile(W).toString();
    }

    private static void onError(Throwable th2) {
        com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
    }

    private void r(File file) {
        try {
            this.aGs.aGb.s(file);
        } catch (IOException unused) {
            com.kwad.sdk.core.d.c.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    public final String eM(String str) {
        return str == null ? "" : f(str, true);
    }

    public final boolean eN(String str) {
        au.av(str, "Url can't be null!");
        return W(str).exists();
    }

    public final boolean eO(String str) {
        au.av(str, "Url can't be null!");
        return eR(str).exists() || W(str).exists();
    }

    public final boolean eP(String str) {
        g gVar = this.aGp.get(str);
        if (gVar == null) {
            return false;
        }
        gVar.shutdown();
        this.aGp.remove(str);
        return true;
    }

    private f(com.kwad.sdk.core.videocache.c cVar) {
        this.aGn = new Object();
        this.aGo = GlobalThreadPools.Hq();
        this.aGp = new ConcurrentHashMap();
        this.aGs = (com.kwad.sdk.core.videocache.c) au.checkNotNull(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName(com.sigmob.sdk.videocache.h.f20606j));
            this.aGq = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            i.install(com.sigmob.sdk.videocache.h.f20606j, localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.aGr = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e10) {
            this.aGo.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e10);
        }
    }

    public final boolean a(String str, long j10, a.C0497a c0497a, AdHttpResponseListener adHttpResponseListener) {
        com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (eN(str)) {
            return true;
        }
        return com.kwad.sdk.core.network.a.a.a(eQ(str), null, c0497a, j10, adHttpResponseListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.kwad.sdk.core.videocache.f] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public void a(Socket socket) {
        ?? r62;
        ?? r02 = "Opened connections: ";
        try {
            try {
                d b10 = d.b(socket.getInputStream());
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Request to cache proxy:" + b10);
                eS(l.decode(b10.uri)).a(b10, socket);
                b(socket);
                r62 = new StringBuilder("Opened connections: ");
            } catch (ProxyCacheException e10) {
                e = e10;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                r62 = new StringBuilder("Opened connections: ");
            } catch (SocketException e11) {
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e11.printStackTrace();
                b(socket);
                r62 = new StringBuilder("Opened connections: ");
            } catch (IOException e12) {
                e = e12;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                r62 = new StringBuilder("Opened connections: ");
            }
            r02 = If();
            r62.append(r02);
            socket = r62.toString();
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", socket);
        } catch (Throwable th2) {
            b(socket);
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", ((String) r02) + If());
            throw th2;
        }
    }
}
