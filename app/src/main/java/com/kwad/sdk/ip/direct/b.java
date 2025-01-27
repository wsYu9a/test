package com.kwad.sdk.ip.direct;

import android.os.SystemClock;
import com.kwad.sdk.utils.bi;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class b {
    static int atN = 80;
    static int port = 80;

    static class a extends Thread {
        LinkedList atP = new LinkedList();
        volatile boolean atQ = false;
        Selector atO = Selector.open();

        a() {
            setName("Connector");
        }

        private void AU() {
            synchronized (this.atP) {
                while (this.atP.size() > 0) {
                    C0229b c0229b = (C0229b) this.atP.removeFirst();
                    try {
                        c0229b.atS.register(this.atO, 8, c0229b);
                    } catch (Throwable th) {
                        c0229b.atS.close();
                        c0229b.atT = th;
                    }
                }
            }
        }

        private void AV() {
            Iterator<SelectionKey> it = this.atO.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0229b c0229b = (C0229b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0229b.atW = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    bi.c(socketChannel);
                    c0229b.atT = th;
                }
            }
        }

        final void a(C0229b c0229b) {
            SocketChannel socketChannel;
            try {
                socketChannel = SocketChannel.open();
            } catch (Throwable th) {
                th = th;
                socketChannel = null;
            }
            try {
                socketChannel.configureBlocking(false);
                boolean connect = socketChannel.connect(c0229b.atR);
                c0229b.atS = socketChannel;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                c0229b.atV = elapsedRealtime;
                if (connect) {
                    c0229b.atW = elapsedRealtime;
                    bi.c(socketChannel);
                    return;
                }
                synchronized (this.atP) {
                    this.atP.add(c0229b);
                }
                Selector selector = this.atO;
                if (selector != null) {
                    try {
                        selector.wakeup();
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bi.c(socketChannel);
                c0229b.atT = th;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.atO.select() > 0) {
                        AV();
                    }
                    AU();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (this.atQ) {
                    Selector selector = this.atO;
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

        final void shutdown() {
            this.atQ = true;
            Selector selector = this.atO;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.ip.direct.b$b */
    static class C0229b {
        InetSocketAddress atR;
        SocketChannel atS;
        Throwable atT;
        private float atU;
        long atV;
        long atW = 0;
        boolean atX = false;
        private boolean success;

        C0229b(String str) {
            try {
                this.atR = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.atT = th;
            }
        }

        final void AW() {
            String str;
            if (this.atW != 0) {
                str = Long.toString(this.atW - this.atV) + "ms";
                this.atU = this.atW - this.atV;
                this.success = true;
            } else {
                Throwable th = this.atT;
                if (th != null) {
                    str = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    str = "Timed out";
                }
            }
            com.kwad.sdk.core.d.b.d("IpDirect_Ping", this.atR + " : " + str);
            this.atX = true;
        }
    }

    public static c f(String str, long j2) {
        a aVar;
        long j3 = j2 / 5;
        com.kwad.sdk.core.d.b.d("IpDirect_Ping", "ping:" + str);
        c cVar = new c(str);
        try {
            aVar = new a();
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return cVar;
        }
        try {
            aVar.start();
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < cVar.AX(); i2++) {
                C0229b c0229b = new C0229b(str);
                linkedList.add(c0229b);
                try {
                    aVar.a(c0229b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                Thread.sleep(j2 + j3);
                try {
                    aVar.shutdown();
                    aVar.join();
                    float f2 = 0.0f;
                    Iterator it = linkedList.iterator();
                    boolean z = true;
                    while (it.hasNext()) {
                        C0229b c0229b2 = (C0229b) it.next();
                        c0229b2.AW();
                        z &= c0229b2.success;
                        cVar.bk(z);
                        f2 += c0229b2.atU;
                    }
                    com.kwad.sdk.core.d.b.d("IpDirect_Ping", "sum:" + f2 + "*size:" + linkedList.size());
                    cVar.i(f2 / ((float) linkedList.size()));
                    return cVar;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return cVar;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return cVar;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return cVar;
        }
    }
}
