package com.alimm.tanx.core.view.player.cache.videocache;

import com.alimm.tanx.core.view.player.cache.videocache.log.Logger;
import com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory;
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

/* loaded from: classes.dex */
class Pinger {
    private static final Logger LOG = LoggerFactory.getLogger("Pinger");
    private static final String PING_REQUEST = "ping";
    private static final String PING_RESPONSE = "ping ok";
    private final String host;
    private final ExecutorService pingExecutor = Executors.newSingleThreadExecutor();
    private final int port;

    public class PingCallable implements Callable<Boolean> {
        private PingCallable() {
        }

        public /* synthetic */ PingCallable(Pinger pinger, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            return Boolean.valueOf(Pinger.this.pingServer());
        }
    }

    public Pinger(String str, int i10) {
        this.host = (String) Preconditions.checkNotNull(str);
        this.port = i10;
    }

    private List<Proxy> getDefaultProxies() {
        try {
            return ProxySelector.getDefault().select(new URI(getPingUrl()));
        } catch (URISyntaxException e10) {
            throw new IllegalStateException(e10);
        }
    }

    private String getPingUrl() {
        return String.format(Locale.US, "http://%s:%d/%s", this.host, Integer.valueOf(this.port), "ping");
    }

    public boolean pingServer() throws ProxyCacheException {
        HttpUrlSource httpUrlSource = new HttpUrlSource(getPingUrl());
        try {
            try {
                byte[] bytes = "ping ok".getBytes();
                httpUrlSource.open(0L);
                byte[] bArr = new byte[bytes.length];
                httpUrlSource.read(bArr);
                boolean equals = Arrays.equals(bytes, bArr);
                LOG.info("Ping response: `" + new String(bArr) + "`, pinged? " + equals);
                return equals;
            } catch (ProxyCacheException e10) {
                LOG.error("Error reading ping response", e10);
                httpUrlSource.close();
                return false;
            }
        } finally {
            httpUrlSource.close();
        }
    }

    public boolean isPingRequest(String str) {
        return "ping".equals(str);
    }

    public boolean ping(int i10, int i11) {
        Preconditions.checkArgument(i10 >= 1);
        Preconditions.checkArgument(i11 > 0);
        int i12 = 0;
        while (i12 < i10) {
            try {
            } catch (InterruptedException e10) {
                e = e10;
                LOG.error("Error pinging server due to unexpected error", e);
            } catch (ExecutionException e11) {
                e = e11;
                LOG.error("Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                LOG.warn("Error pinging server (attempt: " + i12 + ", timeout: " + i11 + "). ");
            }
            if (((Boolean) this.pingExecutor.submit(new PingCallable()).get(i11, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i12++;
            i11 *= 2;
        }
        String format = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i12), Integer.valueOf(i11 / 2), getDefaultProxies());
        LOG.error(format, new ProxyCacheException(format));
        return false;
    }

    public void responseToPing(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }
}
