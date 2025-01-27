package com.czhj.volley.toolbox;

import android.os.SystemClock;
import com.czhj.volley.Cache;
import com.czhj.volley.Header;
import com.czhj.volley.Network;
import com.czhj.volley.Request;
import com.czhj.volley.RetryPolicy;
import com.czhj.volley.ServerError;
import com.czhj.volley.VolleyError;
import com.czhj.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import m5.c;

/* loaded from: classes2.dex */
public class FileDownloadNetwork implements Network {
    protected static final boolean DEBUG = VolleyLog.DEBUG;

    /* renamed from: b */
    public static final int f8758b = 3000;

    /* renamed from: c */
    public static final int f8759c = 4096;

    /* renamed from: a */
    public final BaseHttpStack f8760a;
    protected final ByteArrayPool mPool;

    public FileDownloadNetwork(BaseHttpStack baseHttpStack) {
        this(baseHttpStack, new ByteArrayPool(4096));
    }

    public static List<Header> a(List<Header> list, Cache.Entry entry) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<Header> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().getName());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<Header> list2 = entry.allResponseHeaders;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (Header header : entry.allResponseHeaders) {
                    if (!treeSet.contains(header.getName())) {
                        arrayList.add(header);
                    }
                }
            }
        } else if (!entry.responseHeaders.isEmpty()) {
            for (Map.Entry<String, String> entry2 : entry.responseHeaders.entrySet()) {
                if (!treeSet.contains(entry2.getKey())) {
                    arrayList.add(new Header(entry2.getKey(), entry2.getValue()));
                }
            }
        }
        return arrayList;
    }

    public static void attemptRetryOnException(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(String.format("%s-retry [RetryCount %s]  [timeout=%s]", str, Integer.valueOf(retryPolicy.getCurrentRetryCount()), Integer.valueOf(timeoutMs)));
        } catch (VolleyError e10) {
            request.addMarker(String.format("%s-timeout-giveup [RetryCount %s] [timeout=%s]", str, Integer.valueOf(retryPolicy.getCurrentRetryCount()), Integer.valueOf(timeoutMs)));
            throw e10;
        }
    }

    public static Map<String, String> convertHeaders(List<Header> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i10 = 0; i10 < list.size(); i10++) {
            Header header = list.get(i10);
            treeMap.put(header.getName(), header.getValue());
        }
        return treeMap;
    }

    public void logError(String str, String str2, long j10) {
        VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(SystemClock.elapsedRealtime() - j10), str2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:10|11)|(6:(9:13|(1:15)|17|18|19|20|21|22|(2:29|30)(2:26|27))(1:86)|21|22|(1:24)|29|30)|16|17|18|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00de, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00df, code lost:
    
        r23 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0187 A[SYNTHETIC] */
    @Override // com.czhj.volley.Network
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.czhj.volley.NetworkResponse performRequest(com.czhj.volley.Request<?> r29) throws com.czhj.volley.VolleyError {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.volley.toolbox.FileDownloadNetwork.performRequest(com.czhj.volley.Request):com.czhj.volley.NetworkResponse");
    }

    public FileDownloadNetwork(BaseHttpStack baseHttpStack, ByteArrayPool byteArrayPool) {
        this.f8760a = baseHttpStack;
        this.mPool = byteArrayPool;
    }

    public final Map<String, String> a(Cache.Entry entry) {
        if (entry == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = entry.etag;
        if (str != null) {
            hashMap.put(c.A, str);
        }
        long j10 = entry.lastModified;
        if (j10 > 0) {
            hashMap.put(c.f28364z, HttpHeaderParser.a(j10));
        }
        return hashMap;
    }

    public final byte[] a(InputStream inputStream, int i10) throws IOException, ServerError {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, i10);
        try {
            if (inputStream == null) {
                throw new ServerError();
            }
            byte[] buf = this.mPool.getBuf(1024);
            while (true) {
                int read = inputStream.read(buf);
                if (read == -1) {
                    break;
                }
                poolingByteArrayOutputStream.write(buf, 0, read);
            }
            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused) {
                VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
            }
            this.mPool.returnBuf(buf);
            poolingByteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.mPool.returnBuf(null);
            poolingByteArrayOutputStream.close();
            throw th2;
        }
    }

    public final void a(long j10, Request<?> request, byte[] bArr, int i10) {
        if (DEBUG || j10 > 3000) {
            VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", request, Long.valueOf(j10), bArr != null ? Integer.valueOf(bArr.length) : "null", Integer.valueOf(i10), Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount()));
        }
    }
}
