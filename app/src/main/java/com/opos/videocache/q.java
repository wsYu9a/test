package com.opos.videocache;

import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
class q {

    /* renamed from: a */
    private final ExecutorService f23844a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private final String f23845b;

    /* renamed from: c */
    private final int f23846c;

    private class a implements Callable<Boolean> {
        private a() {
        }

        /* synthetic */ a(q qVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            return Boolean.valueOf(q.this.b());
        }
    }

    q(String str, int i2) {
        this.f23845b = (String) f.a(str);
        this.f23846c = i2;
    }

    private List<Proxy> a() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public boolean b() {
        boolean z;
        d dVar = new d(c());
        try {
            try {
                byte[] bytes = "ping ok".getBytes();
                dVar.a(0L);
                byte[] bArr = new byte[bytes.length];
                dVar.a(bArr);
                z = Arrays.equals(bytes, bArr);
                com.opos.cmn.an.f.a.a("Pinger", "Ping response: `" + new String(bArr) + "`, pinged? " + z);
            } catch (g e2) {
                com.opos.cmn.an.f.a.d("Pinger", "Error reading ping response", e2);
                z = false;
            }
            return z;
        } finally {
            dVar.b();
        }
    }

    private String c() {
        return String.format(Locale.US, "http://%s:%d/%s", this.f23845b, Integer.valueOf(this.f23846c), "ping");
    }

    void a(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    boolean a(int i2, int i3) {
        f.a(i2 >= 1);
        f.a(i3 > 0);
        int i4 = 0;
        while (i4 < i2) {
            try {
            } catch (InterruptedException e2) {
                e = e2;
                com.opos.cmn.an.f.a.d("Pinger", "Error pinging server due to unexpected error", e);
            } catch (ExecutionException e3) {
                e = e3;
                com.opos.cmn.an.f.a.d("Pinger", "Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                com.opos.cmn.an.f.a.c("Pinger", "Error pinging server (attempt: " + i4 + ", timeout: " + i3 + "). ");
            }
            if (((Boolean) this.f23844a.submit(new a()).get(i3, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i3 *= 2;
            i4++;
        }
        String format = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at. Default proxies are: %s", Integer.valueOf(i4), Integer.valueOf(i3 / 2), a());
        com.opos.cmn.an.f.a.d("Pinger", format, new g(format));
        return false;
    }

    boolean a(String str) {
        return "ping".equals(str);
    }
}
