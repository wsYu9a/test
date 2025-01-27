package com.sigmob.sdk.videocache;

import com.czhj.sdk.logger.SigmobLog;
import java.io.IOException;
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
public class n {

    /* renamed from: d */
    public static final String f20655d = "ping";

    /* renamed from: e */
    public static final String f20656e = "ping ok";

    /* renamed from: a */
    public final ExecutorService f20657a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    public final String f20658b;

    /* renamed from: c */
    public final int f20659c;

    public class b implements Callable<Boolean> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(n.this.c());
        }

        public /* synthetic */ b(n nVar, a aVar) {
            this();
        }
    }

    public n(String str, int i10) {
        this.f20658b = (String) o.a(str);
        this.f20659c = i10;
    }

    public final String b() {
        return String.format(Locale.US, "http://%s:%d/%s", this.f20658b, Integer.valueOf(this.f20659c), f20655d);
    }

    public final boolean c() throws q {
        u a10 = t.a(b());
        try {
            try {
                byte[] bytes = f20656e.getBytes();
                a10.a(0L);
                byte[] bArr = new byte[bytes.length];
                a10.read(bArr);
                boolean equals = Arrays.equals(bytes, bArr);
                SigmobLog.i("Ping response: `" + new String(bArr) + "`, pinged? " + equals);
                return equals;
            } catch (q e10) {
                SigmobLog.e("Error reading ping response", e10);
                a10.close();
                return false;
            }
        } finally {
            a10.close();
        }
    }

    public final List<Proxy> a() {
        try {
            return ProxySelector.getDefault().select(new URI(b()));
        } catch (URISyntaxException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public boolean a(String str) {
        return f20655d.equals(str);
    }

    public boolean a(int i10, int i11) {
        o.a(i10 >= 1);
        o.a(i11 > 0);
        int i12 = 0;
        while (i12 < i10) {
            try {
            } catch (InterruptedException e10) {
                e = e10;
                SigmobLog.w("Error pinging server due to unexpected error", e);
            } catch (ExecutionException e11) {
                e = e11;
                SigmobLog.w("Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                SigmobLog.w("Error pinging server (attempt: " + i12 + ", timeout: " + i11 + "). ");
            }
            if (((Boolean) this.f20657a.submit(new b()).get(i11, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i12++;
            i11 *= 2;
        }
        SigmobLog.e(String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). Default proxies are: %s", Integer.valueOf(i12), Integer.valueOf(i11 / 2), a()));
        return false;
    }

    public void a(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write(f20656e.getBytes());
    }
}
