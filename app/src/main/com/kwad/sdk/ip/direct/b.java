package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.utils.bt;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public final class b {
    private static Handler aMO = new Handler(Looper.getMainLooper());
    static int aMY = 80;
    static int port = 80;

    public static class a extends Thread {
        LinkedList aNa = new LinkedList();
        volatile boolean aNb = false;
        Selector aMZ = Selector.open();

        /* renamed from: com.kwad.sdk.ip.direct.b$a$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ SocketChannel aNc;

            public AnonymousClass1(SocketChannel socketChannel) {
                socketChannel = socketChannel;
            }

            @Override // java.lang.Runnable
            public final void run() {
                bt.c(socketChannel);
            }
        }

        public a() {
            setName("Connector");
        }

        private void KC() {
            synchronized (this.aNa) {
                while (this.aNa.size() > 0) {
                    try {
                        C0509b c0509b = (C0509b) this.aNa.removeFirst();
                        try {
                            c0509b.aNf.register(this.aMZ, 8, c0509b);
                        } catch (Throwable th2) {
                            c0509b.aNf.close();
                            c0509b.aNg = th2;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            }
        }

        private void KD() {
            Iterator<SelectionKey> it = this.aMZ.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0509b c0509b = (C0509b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0509b.aNk = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th2) {
                    bt.c(socketChannel);
                    c0509b.aNg = th2;
                }
            }
        }

        public final void a(C0509b c0509b) {
            SocketChannel socketChannel;
            try {
                socketChannel = SocketChannel.open();
                try {
                    socketChannel.configureBlocking(false);
                    boolean connect = socketChannel.connect(c0509b.aNe);
                    c0509b.aNf = socketChannel;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    c0509b.aNj = elapsedRealtime;
                    if (connect) {
                        c0509b.aNk = elapsedRealtime;
                        bt.c(socketChannel);
                    } else {
                        synchronized (this.aNa) {
                            this.aNa.add(c0509b);
                        }
                        Selector selector = this.aMZ;
                        if (selector != null) {
                            try {
                                selector.wakeup();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bt.c(socketChannel);
                        c0509b.aNg = th;
                        try {
                            b.aMO.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                final /* synthetic */ SocketChannel aNc;

                                public AnonymousClass1(SocketChannel socketChannel2) {
                                    socketChannel = socketChannel2;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    bt.c(socketChannel);
                                }
                            }, c0509b.aNi);
                        } catch (Throwable unused2) {
                        }
                    } finally {
                        try {
                            b.aMO.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                                final /* synthetic */ SocketChannel aNc;

                                public AnonymousClass1(SocketChannel socketChannel2) {
                                    socketChannel = socketChannel2;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    bt.c(socketChannel);
                                }
                            }, c0509b.aNi);
                        } catch (Throwable unused3) {
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                socketChannel2 = null;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.aMZ.select() > 0) {
                        KD();
                    }
                    KC();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                if (this.aNb) {
                    Selector selector = this.aMZ;
                    if (selector != null) {
                        try {
                            selector.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    return;
                }
                continue;
            }
        }

        public final void shutdown() {
            this.aNb = true;
            Selector selector = this.aMZ;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.ip.direct.b$b */
    public static class C0509b {
        InetSocketAddress aNe;
        SocketChannel aNf;
        Throwable aNg;
        private float aNh;
        long aNi;
        long aNj;
        long aNk = 0;
        boolean aNl = false;
        private boolean success;

        public C0509b(String str) {
            try {
                this.aNe = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th2) {
                this.aNg = th2;
            }
        }

        public final void KE() {
            String str;
            if (this.aNk != 0) {
                str = Long.toString(this.aNk - this.aNj) + "ms";
                this.aNh = this.aNk - this.aNj;
                this.success = true;
            } else {
                Throwable th2 = this.aNg;
                if (th2 != null) {
                    str = th2.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    str = "Timed out";
                }
            }
            com.kwad.sdk.core.d.c.d("IpDirect_Ping", this.aNe + " : " + str);
            this.aNl = true;
        }
    }

    public static c f(String str, long j10) {
        a aVar;
        long j11 = j10 / 5;
        com.kwad.sdk.core.d.c.d("IpDirect_Ping", "ping:" + str);
        c cVar = new c(str);
        try {
            aVar = new a();
        } catch (Throwable th2) {
            th2.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return cVar;
        }
        try {
            aVar.start();
            LinkedList linkedList = new LinkedList();
            for (int i10 = 0; i10 < cVar.KF(); i10++) {
                C0509b c0509b = new C0509b(str);
                c0509b.aNi = j10 + j11;
                linkedList.add(c0509b);
                try {
                    aVar.a(c0509b);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            try {
                Thread.sleep(j10 + j11);
                try {
                    aVar.shutdown();
                    aVar.join();
                    Iterator it = linkedList.iterator();
                    boolean z10 = true;
                    float f10 = 0.0f;
                    while (it.hasNext()) {
                        C0509b c0509b2 = (C0509b) it.next();
                        c0509b2.KE();
                        z10 &= c0509b2.success;
                        cVar.bF(z10);
                        f10 += c0509b2.aNh;
                    }
                    com.kwad.sdk.core.d.c.d("IpDirect_Ping", "sum:" + f10 + "*size:" + linkedList.size());
                    cVar.k(f10 / ((float) linkedList.size()));
                    return cVar;
                } catch (Throwable th4) {
                    th4.printStackTrace();
                    return cVar;
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                return cVar;
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
            return cVar;
        }
    }
}
