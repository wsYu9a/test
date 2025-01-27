package com.sigmob.sdk.videocache;

import android.content.Context;
import android.net.Uri;
import com.czhj.sdk.common.ThreadPool.BackgroundThreadFactory;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
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
public class h {

    /* renamed from: j */
    public static final String f20606j = "127.0.0.1";

    /* renamed from: a */
    public final Object f20607a;

    /* renamed from: b */
    public final ExecutorService f20608b;

    /* renamed from: c */
    public final Map<String, i> f20609c;

    /* renamed from: d */
    public final ServerSocket f20610d;

    /* renamed from: e */
    public final int f20611e;

    /* renamed from: f */
    public final Thread f20612f;

    /* renamed from: g */
    public final e f20613g;

    /* renamed from: h */
    public final n f20614h;

    /* renamed from: i */
    public InetAddress f20615i;

    public static final class b {

        /* renamed from: f */
        public static final long f20616f = 536870912;

        /* renamed from: a */
        public File f20617a;

        /* renamed from: d */
        public com.sigmob.sdk.videocache.sourcestorage.c f20620d;

        /* renamed from: c */
        public com.sigmob.sdk.videocache.file.a f20619c = new com.sigmob.sdk.videocache.file.h(f20616f);

        /* renamed from: b */
        public com.sigmob.sdk.videocache.file.c f20618b = new com.sigmob.sdk.videocache.file.f();

        /* renamed from: e */
        public com.sigmob.sdk.videocache.headers.b f20621e = new com.sigmob.sdk.videocache.headers.a();

        public b(Context context) {
            this.f20620d = com.sigmob.sdk.videocache.sourcestorage.d.a(context);
            this.f20617a = w.b(context);
        }

        public final e b() {
            return new e(this.f20617a, this.f20618b, this.f20619c, this.f20620d, this.f20621e);
        }

        public h a() {
            return new h(b());
        }

        public b a(File file) {
            this.f20617a = (File) o.a(file);
            return this;
        }

        public b a(com.sigmob.sdk.videocache.file.a aVar) {
            this.f20619c = (com.sigmob.sdk.videocache.file.a) o.a(aVar);
            return this;
        }

        public b a(com.sigmob.sdk.videocache.file.c cVar) {
            this.f20618b = (com.sigmob.sdk.videocache.file.c) o.a(cVar);
            return this;
        }

        public b a(com.sigmob.sdk.videocache.headers.b bVar) {
            this.f20621e = (com.sigmob.sdk.videocache.headers.b) o.a(bVar);
            return this;
        }

        public b a(int i10) {
            this.f20619c = new com.sigmob.sdk.videocache.file.g(i10);
            return this;
        }

        public b a(long j10) {
            this.f20619c = new com.sigmob.sdk.videocache.file.h(j10);
            return this;
        }
    }

    public final class c implements Runnable {

        /* renamed from: a */
        public final Socket f20622a;

        public c(Socket socket) {
            this.f20622a = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.d(this.f20622a);
        }
    }

    public final class d implements Runnable {

        /* renamed from: a */
        public final CountDownLatch f20624a;

        public d(CountDownLatch countDownLatch) {
            this.f20624a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20624a.countDown();
            h.this.e();
        }
    }

    public h(Context context) {
        this(new b(context).b());
    }

    public final void b(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            SigmobLog.d("Releasing input stream… Socket is closed by client.");
        } catch (IOException unused2) {
        }
    }

    public final void c(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
        }
    }

    public String d(String str) {
        return a(StringUtil.getUrl(str), true);
    }

    public boolean e(String str) {
        o.a(str, "Url can't be null!");
        return b(str).exists();
    }

    public void f(String str) {
        synchronized (this.f20607a) {
            try {
                i iVar = this.f20609c.get(str);
                if (iVar != null) {
                    iVar.d();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public h(e eVar) {
        this.f20607a = new Object();
        this.f20608b = Executors.newFixedThreadPool(2, new BackgroundThreadFactory());
        this.f20609c = new ConcurrentHashMap();
        this.f20613g = (e) o.a(eVar);
        try {
            this.f20615i = InetAddress.getByName(f20606j);
            ServerSocket serverSocket = new ServerSocket(0, 8, this.f20615i);
            this.f20610d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f20611e = localPort;
            k.a(f20606j, localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            SigmobLog.d("Thread create ,current thread num :" + Thread.activeCount());
            Thread thread = new Thread(new d(countDownLatch));
            this.f20612f = thread;
            thread.start();
            countDownLatch.await();
            this.f20614h = new n(f20606j, localPort);
            SigmobLog.i("Proxy cache server started. Is it alive? " + b());
        } catch (IOException | InterruptedException e10) {
            this.f20608b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e10);
        }
    }

    public File b(String str) {
        e eVar = this.f20613g;
        return new File(eVar.f20582a, eVar.f20583b.a(str));
    }

    public final i c(String str) throws q {
        i iVar;
        synchronized (this.f20607a) {
            try {
                iVar = this.f20609c.get(str);
                if (iVar == null) {
                    iVar = new i(str, this.f20613g);
                    this.f20609c.put(str, iVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iVar;
    }

    public final void d(Socket socket) {
        StringBuilder sb2;
        try {
            try {
                f a10 = f.a(socket.getInputStream());
                SigmobLog.d("Request to cache proxy:" + a10);
                String b10 = r.b(a10.f20589a);
                if (this.f20614h.a(b10)) {
                    this.f20614h.a(socket);
                } else {
                    c(b10).a(a10, socket);
                }
                e(socket);
                sb2 = new StringBuilder();
            } catch (q e10) {
                e = e10;
                a(new q("Error processing request", e));
                e(socket);
                sb2 = new StringBuilder();
            } catch (SocketException unused) {
                SigmobLog.d("Closing socket… Socket is closed by client.");
                e(socket);
                sb2 = new StringBuilder();
            } catch (IOException e11) {
                e = e11;
                a(new q("Error processing request", e));
                e(socket);
                sb2 = new StringBuilder();
            }
            sb2.append("Opened connections: ");
            sb2.append(a());
            SigmobLog.d(sb2.toString());
        } catch (Throwable th2) {
            e(socket);
            SigmobLog.d("Opened connections: " + a());
            throw th2;
        }
    }

    public final void e(Socket socket) {
        b(socket);
        c(socket);
        a(socket);
    }

    public /* synthetic */ h(e eVar, a aVar) {
        this(eVar);
    }

    public final String a(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", f20606j, Integer.valueOf(this.f20611e), r.c(str));
    }

    public final boolean b() {
        return this.f20614h.a(3, 70);
    }

    public void c() {
        SigmobLog.i("Shutdown proxy server");
        d();
        this.f20613g.f20585d.a();
        this.f20612f.interrupt();
        try {
            if (this.f20610d.isClosed()) {
                return;
            }
            this.f20610d.close();
        } catch (IOException e10) {
            a(new q("Error shutting down proxy server", e10));
        }
    }

    public final void d() {
        synchronized (this.f20607a) {
            try {
                Iterator<i> it = this.f20609c.values().iterator();
                while (it.hasNext()) {
                    it.next().d();
                }
                this.f20609c.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void e() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                this.f20608b.submit(new c(this.f20610d.accept()));
            } catch (IOException e10) {
                a(new q("Error during waiting connection", e10));
                return;
            }
        }
    }

    public final void a(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException unused) {
        }
    }

    public void b(com.sigmob.sdk.videocache.d dVar, String str) {
        o.a(dVar, str);
        synchronized (this.f20607a) {
            try {
                c(str).b(dVar);
            } catch (q e10) {
                SigmobLog.w("Error registering cache listener", e10);
            }
        }
    }

    public final int a() {
        int i10;
        synchronized (this.f20607a) {
            try {
                Iterator<i> it = this.f20609c.values().iterator();
                i10 = 0;
                while (it.hasNext()) {
                    i10 += it.next().b();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i10;
    }

    public String a(String str, boolean z10) {
        if (!z10 || !e(str)) {
            return b() ? a(str) : str;
        }
        File b10 = b(str);
        a(b10);
        return Uri.fromFile(b10).toString();
    }

    public final void a(Throwable th2) {
        SigmobLog.e("HttpProxyCacheServer error", th2);
    }

    public void a(com.sigmob.sdk.videocache.d dVar, String str) {
        o.a(dVar, str);
        synchronized (this.f20607a) {
            try {
                c(str).a(dVar);
            } catch (q e10) {
                SigmobLog.w("Error registering cache listener", e10);
            }
        }
    }

    public final void a(File file) {
        try {
            this.f20613g.f20584c.a(file);
        } catch (IOException e10) {
            SigmobLog.e("Error touching file " + file, e10);
        }
    }

    public void a(com.sigmob.sdk.videocache.d dVar) {
        o.a(dVar);
        synchronized (this.f20607a) {
            try {
                Iterator<i> it = this.f20609c.values().iterator();
                while (it.hasNext()) {
                    it.next().b(dVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
