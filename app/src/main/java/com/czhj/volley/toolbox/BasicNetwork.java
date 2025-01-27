package com.czhj.volley.toolbox;

import android.os.SystemClock;
import com.czhj.volley.Cache;
import com.czhj.volley.Header;
import com.czhj.volley.Network;
import com.czhj.volley.Request;
import com.czhj.volley.RetryPolicy;
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
public class BasicNetwork implements Network {
    protected static final boolean DEBUG = VolleyLog.DEBUG;

    /* renamed from: b */
    public static final int f8751b = 3000;

    /* renamed from: c */
    public static final int f8752c = 4096;

    /* renamed from: a */
    public final BaseHttpStack f8753a;
    protected final ByteArrayPool mPool;

    public BasicNetwork(BaseHttpStack baseHttpStack) {
        this(baseHttpStack, new ByteArrayPool(4096));
    }

    public static void a(String str, Request<?> request) {
        request.addMarker(String.format("%s-Redirect [timeout=%s]", str, Integer.valueOf(request.getTimeoutMs())));
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

    /* JADX WARN: Removed duplicated region for block: B:43:0x017d A[Catch: all -> 0x016e, TRY_ENTER, TryCatch #8 {all -> 0x016e, blocks: (B:4:0x0012, B:43:0x017d, B:45:0x0198, B:56:0x01c0, B:58:0x01c6, B:59:0x021b, B:72:0x01cc, B:73:0x01d1, B:77:0x01da, B:79:0x01e0, B:81:0x01e6, B:82:0x01eb, B:84:0x01ee, B:86:0x01f4, B:88:0x01fa, B:89:0x01ff, B:91:0x0200, B:92:0x0205, B:93:0x0206, B:94:0x020e, B:95:0x0214, B:97:0x0239, B:98:0x023e, B:148:0x023f, B:149:0x0259, B:151:0x025a), top: B:3:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0239 A[SYNTHETIC] */
    @Override // com.czhj.volley.Network
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.czhj.volley.NetworkResponse performRequest(com.czhj.volley.Request<?> r25) throws com.czhj.volley.VolleyError {
        /*
            Method dump skipped, instructions count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.volley.toolbox.BasicNetwork.performRequest(com.czhj.volley.Request):com.czhj.volley.NetworkResponse");
    }

    public BasicNetwork(BaseHttpStack baseHttpStack, ByteArrayPool byteArrayPool) {
        this.f8753a = baseHttpStack;
        this.mPool = byteArrayPool;
    }

    public static void a(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VolleyError e10) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e10;
        }
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

    public final byte[] a(InputStream inputStream, int i10) throws IOException {
        byte[] byteArray;
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, i10);
        int i11 = 1024;
        if (i10 > 0 && i10 < 1024) {
            i11 = i10;
        }
        byte[] bArr = null;
        try {
            bArr = this.mPool.getBuf(i11);
            long j10 = 0;
            while (true) {
                int read = inputStream.read(bArr, 0, i11);
                if (read == -1 || (i10 >= 1 && j10 >= i10)) {
                    break;
                }
                poolingByteArrayOutputStream.write(bArr, 0, read);
                j10 += read;
            }
            byteArray = poolingByteArrayOutputStream.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused) {
                VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
            }
            this.mPool.returnBuf(bArr);
        } catch (Throwable th2) {
            try {
                VolleyLog.e("readError", th2.getMessage());
                byteArray = poolingByteArrayOutputStream.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.mPool.returnBuf(bArr);
            } catch (Throwable th3) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                        VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.mPool.returnBuf(bArr);
                poolingByteArrayOutputStream.close();
                throw th3;
            }
        }
        poolingByteArrayOutputStream.close();
        return byteArray;
    }

    public final void a(long j10, Request<?> request, byte[] bArr, int i10) {
        if (DEBUG || j10 > 3000) {
            VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", request, Long.valueOf(j10), bArr != null ? Integer.valueOf(bArr.length) : "null", Integer.valueOf(i10), Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount()));
        }
    }
}
