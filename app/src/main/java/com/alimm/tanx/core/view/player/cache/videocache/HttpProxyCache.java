package com.alimm.tanx.core.view.player.cache.videocache;

import android.text.TextUtils;
import android.util.Log;
import com.alimm.tanx.core.view.player.cache.videocache.file.FileCache;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/* loaded from: classes.dex */
class HttpProxyCache extends ProxyCache {
    private static final float NO_CACHE_BARRIER = 0.2f;
    private final FileCache cache;
    private CacheListener listener;
    private final HttpUrlSource source;

    public HttpProxyCache(HttpUrlSource httpUrlSource, FileCache fileCache) {
        super(httpUrlSource, fileCache);
        this.cache = fileCache;
        this.source = httpUrlSource;
    }

    private String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private boolean isUseCache(GetRequest getRequest) throws ProxyCacheException {
        long length = this.source.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && getRequest.partial && ((float) getRequest.rangeOffset) > ((float) this.cache.available()) + (((float) length) * 0.2f)) ? false : true;
    }

    private String newResponseHeaders(GetRequest getRequest) throws IOException, ProxyCacheException {
        String mime = this.source.getMime();
        boolean z10 = !TextUtils.isEmpty(mime);
        long available = this.cache.isCompleted() ? this.cache.available() : this.source.length();
        boolean z11 = available >= 0;
        boolean z12 = getRequest.partial;
        long j10 = z12 ? available - getRequest.rangeOffset : available;
        boolean z13 = z11 && z12;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getRequest.partial ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb2.append("Accept-Ranges: bytes\n");
        sb2.append(z11 ? format("Content-Length: %d\n", Long.valueOf(j10)) : "");
        sb2.append(z13 ? format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(getRequest.rangeOffset), Long.valueOf(available - 1), Long.valueOf(available)) : "");
        sb2.append(z10 ? format("Content-Type: %s\n", mime) : "");
        sb2.append("\n");
        return sb2.toString();
    }

    private void responseWithCache(OutputStream outputStream, long j10) throws ProxyCacheException, IOException {
        Log.e("开始读取缓存数据", "缓存数据读取");
        byte[] bArr = new byte[8192];
        while (true) {
            int read = read(bArr, j10, 8192);
            if (read == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, read);
                j10 += read;
            }
        }
    }

    private void responseWithoutCache(OutputStream outputStream, long j10) throws ProxyCacheException, IOException {
        HttpUrlSource httpUrlSource = new HttpUrlSource(this.source);
        try {
            httpUrlSource.open((int) j10);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = httpUrlSource.read(bArr);
                if (read == -1) {
                    outputStream.flush();
                    httpUrlSource.close();
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } catch (Throwable th2) {
            httpUrlSource.close();
            throw th2;
        }
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.ProxyCache
    public void onCachePercentsAvailableChanged(int i10) {
        CacheListener cacheListener = this.listener;
        if (cacheListener != null) {
            cacheListener.onCacheAvailable(this.cache.file, this.source.getUrl(), i10);
        }
    }

    public void processRequest(GetRequest getRequest, Socket socket) throws IOException, ProxyCacheException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(newResponseHeaders(getRequest).getBytes(StandardCharsets.UTF_8));
        long j10 = getRequest.rangeOffset;
        if (isUseCache(getRequest)) {
            responseWithCache(bufferedOutputStream, j10);
        } else {
            responseWithoutCache(bufferedOutputStream, j10);
        }
    }

    public void registerCacheListener(CacheListener cacheListener) {
        this.listener = cacheListener;
    }
}
