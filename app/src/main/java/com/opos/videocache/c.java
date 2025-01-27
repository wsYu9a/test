package com.opos.videocache;

import android.content.Context;
import android.net.Uri;
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
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private final Object f23793a;

    /* renamed from: b */
    private final ExecutorService f23794b;

    /* renamed from: c */
    private final Map<String, o> f23795c;

    /* renamed from: d */
    private final ServerSocket f23796d;

    /* renamed from: e */
    private final int f23797e;

    /* renamed from: f */
    private final Thread f23798f;

    /* renamed from: g */
    private final l f23799g;

    /* renamed from: h */
    private final q f23800h;

    public static final class a {

        /* renamed from: a */
        private File f23801a;

        /* renamed from: d */
        private com.opos.videocache.c.b f23804d;

        /* renamed from: c */
        private com.opos.videocache.a.a f23803c = new com.opos.videocache.a.g(536870912);

        /* renamed from: b */
        private com.opos.videocache.a.c f23802b = new com.opos.videocache.a.e();

        /* renamed from: e */
        private com.opos.videocache.b.b f23805e = new com.opos.videocache.b.a();

        public a(Context context) {
            this.f23804d = com.opos.videocache.c.c.a(context);
        }

        private l b() {
            File file = this.f23801a;
            return file == null ? new k(this.f23802b, this.f23803c, this.f23804d, this.f23805e) : new l(file, this.f23802b, this.f23803c, this.f23804d, this.f23805e);
        }

        public a a(int i2) {
            this.f23803c = new com.opos.videocache.a.f(i2);
            return this;
        }

        public a a(long j2) {
            this.f23803c = new com.opos.videocache.a.g(j2);
            return this;
        }

        public a a(com.opos.videocache.a.c cVar) {
            this.f23802b = (com.opos.videocache.a.c) f.a(cVar);
            return this;
        }

        public a a(com.opos.videocache.b.b bVar) {
            this.f23805e = (com.opos.videocache.b.b) f.a(bVar);
            return this;
        }

        public c a() {
            return new c(b());
        }
    }

    private final class b implements Runnable {

        /* renamed from: b */
        private final Socket f23807b;

        public b(Socket socket) {
            this.f23807b = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.f23807b);
        }
    }

    /* renamed from: com.opos.videocache.c$c */
    private final class RunnableC0489c implements Runnable {

        /* renamed from: b */
        private final CountDownLatch f23809b;

        public RunnableC0489c(CountDownLatch countDownLatch) {
            this.f23809b = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f23809b.countDown();
            c.this.b();
        }
    }

    private c(l lVar) {
        this.f23793a = new Object();
        this.f23794b = Executors.newFixedThreadPool(8);
        this.f23795c = new ConcurrentHashMap();
        this.f23799g = (l) f.a(lVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f23796d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f23797e = localPort;
            p.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new RunnableC0489c(countDownLatch));
            this.f23798f = thread;
            thread.start();
            countDownLatch.await();
            this.f23800h = new q("127.0.0.1", localPort);
            com.opos.cmn.an.f.a.a("HttpProxyCacheServer", "Proxy cache server started. Is it alive? " + a());
        } catch (IOException | InterruptedException e2) {
            this.f23794b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e2);
        }
    }

    /* synthetic */ c(l lVar, AnonymousClass1 anonymousClass1) {
        this(lVar);
    }

    private void a(File file) {
        try {
            this.f23799g.f23821c.a(file);
        } catch (IOException e2) {
            com.opos.cmn.an.f.a.d("HttpProxyCacheServer", "Error touching file " + file, e2);
        }
    }

    private void a(Throwable th) {
        com.opos.cmn.an.f.a.d("HttpProxyCacheServer", "HttpProxyCacheServer error", th);
    }

    public void a(Socket socket) {
        StringBuilder sb;
        try {
            try {
                m a2 = m.a(socket.getInputStream());
                com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Request to cache proxy:" + a2);
                String c2 = h.c(a2.f23826a);
                if (this.f23800h.a(c2)) {
                    this.f23800h.a(socket);
                } else {
                    e(c2).a(a2, socket);
                }
                b(socket);
                sb = new StringBuilder();
            } catch (g e2) {
                e = e2;
                a(new g("Error processing request", e));
                b(socket);
                sb = new StringBuilder();
            } catch (SocketException unused) {
                com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                b(socket);
                sb = new StringBuilder();
            } catch (IOException e3) {
                e = e3;
                a(new g("Error processing request", e));
                b(socket);
                sb = new StringBuilder();
            }
            sb.append("Opened connections: ");
            sb.append(c());
            com.opos.cmn.an.f.a.b("HttpProxyCacheServer", sb.toString());
        } catch (Throwable th) {
            b(socket);
            com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Opened connections: " + c());
            throw th;
        }
    }

    private boolean a() {
        return this.f23800h.a(3, 70);
    }

    public void b() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f23796d.accept();
                com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Accept new socket " + accept);
                this.f23794b.submit(new b(accept));
            } catch (IOException e2) {
                a(new g("Error during waiting connection", e2));
                return;
            }
        }
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private int c() {
        int i2;
        synchronized (this.f23793a) {
            Iterator<o> it = this.f23795c.values().iterator();
            i2 = 0;
            while (it.hasNext()) {
                i2 += it.next().a();
            }
        }
        return i2;
    }

    private String c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.f23797e), h.b(str));
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            com.opos.cmn.an.f.a.b("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e2) {
            a(new g("Error closing socket input stream", e2));
        }
    }

    private File d(String str) {
        return this.f23799g.a(str);
    }

    private void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException e2) {
            com.opos.cmn.an.f.a.a("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.", (Throwable) e2);
        }
    }

    private o e(String str) {
        o oVar;
        synchronized (this.f23793a) {
            oVar = this.f23795c.get(str);
            if (oVar == null) {
                oVar = new o(str, this.f23799g);
                this.f23795c.put(str, oVar);
            }
        }
        return oVar;
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e2) {
            a(new g("Error closing socket", e2));
        }
    }

    public String a(String str) {
        return a(str, true);
    }

    public String a(String str, boolean z) {
        if (!z || !b(str)) {
            return a() ? c(str) : str;
        }
        File d2 = d(str);
        a(d2);
        return Uri.fromFile(d2).toString();
    }

    public boolean b(String str) {
        f.a(str, "Url can't be null!");
        return d(str).exists();
    }
}
