package com.wbl.ad.yzz.wigdet.k.e;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.wigdet.wblplayer.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes5.dex */
public class f {

    /* renamed from: a */
    public final Object f34566a;

    /* renamed from: b */
    public final ExecutorService f34567b;

    /* renamed from: c */
    public final Map<String, g> f34568c;

    /* renamed from: d */
    public final ServerSocket f34569d;

    /* renamed from: e */
    public final int f34570e;

    /* renamed from: f */
    public final Thread f34571f;

    /* renamed from: g */
    public final com.wbl.ad.yzz.wigdet.k.e.c f34572g;

    /* renamed from: h */
    public final l f34573h;

    /* renamed from: i */
    public h f34574i;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f34575a;

        /* renamed from: b */
        public final /* synthetic */ int f34576b;

        /* renamed from: c */
        public final /* synthetic */ String f34577c;

        public a(String str, int i2, String str2) {
            this.f34575a = str;
            this.f34576b = i2;
            this.f34577c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7715, this, null);
        }
    }

    public static final class b {

        /* renamed from: a */
        public File f34579a;

        /* renamed from: d */
        public com.wbl.ad.yzz.wigdet.k.e.u.c f34582d;

        /* renamed from: c */
        public com.wbl.ad.yzz.wigdet.k.e.s.a f34581c = new com.wbl.ad.yzz.wigdet.k.e.s.h(536870912);

        /* renamed from: b */
        public com.wbl.ad.yzz.wigdet.k.e.s.c f34580b = new com.wbl.ad.yzz.wigdet.k.e.s.f();

        /* renamed from: e */
        public com.wbl.ad.yzz.wigdet.k.e.t.b f34583e = new com.wbl.ad.yzz.wigdet.k.e.t.a();

        public b(Context context) {
            this.f34582d = com.wbl.ad.yzz.wigdet.k.e.u.d.a(context);
            this.f34579a = r.b(context);
        }

        public b a(int i2) {
            return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7742, this, Integer.valueOf(i2));
        }

        public f a() {
            return (f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7741, this, null);
        }

        public final com.wbl.ad.yzz.wigdet.k.e.c b() {
            return (com.wbl.ad.yzz.wigdet.k.e.c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7744, this, null);
        }
    }

    public final class c implements Runnable {

        /* renamed from: a */
        public final Socket f34584a;

        public c(Socket socket) {
            this.f34584a = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7743, this, null);
        }
    }

    public final class d implements Runnable {

        /* renamed from: a */
        public final CountDownLatch f34586a;

        public d(CountDownLatch countDownLatch) {
            this.f34586a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7738, this, null);
        }
    }

    public /* synthetic */ f(com.wbl.ad.yzz.wigdet.k.e.c cVar, a aVar) {
        this(cVar);
    }

    public static /* synthetic */ g a(f fVar, String str) throws ProxyCacheException {
        return (g) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7737, null, fVar, str);
    }

    public static /* synthetic */ h a(f fVar) {
        return (h) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7740, null, fVar);
    }

    public final String a(String str) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7733, this, str);
    }

    public String a(String str, boolean z) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7736, this, str, Boolean.valueOf(z));
    }

    public final void a(File file) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7735, this, file);
    }

    public final void a(Throwable th) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7730, this, th);
    }

    public final void a(Socket socket) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7729, this, socket);
    }

    public final boolean a() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7732, this, null);
    }

    public boolean a(String str, int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7731, this, str, Integer.valueOf(i2));
    }

    public final File b(String str) {
        return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7694, this, str);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7693, this, null);
    }

    public final void b(Socket socket) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7696, this, socket);
    }

    public final g c(String str) throws ProxyCacheException {
        return (g) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7695, this, str);
    }

    public final void c(Socket socket) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7690, this, socket);
    }

    public String d(String str) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7689, this, str);
    }

    public final void d(Socket socket) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7692, this, socket);
    }

    public final void e(Socket socket) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7691, this, socket);
    }

    public boolean e(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7686, this, str);
    }

    public f(com.wbl.ad.yzz.wigdet.k.e.c cVar) {
        this.f34566a = new Object();
        this.f34567b = Executors.newFixedThreadPool(8);
        this.f34568c = new ConcurrentHashMap();
        this.f34574i = new h();
        this.f34572g = (com.wbl.ad.yzz.wigdet.k.e.c) m.a(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f34569d = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f34570e = localPort;
            j.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new d(countDownLatch));
            this.f34571f = thread;
            thread.start();
            countDownLatch.await();
            this.f34573h = new l("127.0.0.1", localPort);
            r.a("Proxy cache server started. Is it alive? " + a());
        } catch (IOException e2) {
            this.f34567b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e2);
        } catch (InterruptedException e3) {
            this.f34567b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e3);
        } catch (Exception e4) {
            this.f34567b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e4);
        }
    }
}
