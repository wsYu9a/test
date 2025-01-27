package com.sigmob.sdk.videocache;

import android.content.Context;
import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class x {

    /* renamed from: d */
    public static x f20689d;

    /* renamed from: a */
    public ExecutorService f20690a = Executors.newFixedThreadPool(8);

    /* renamed from: b */
    public Map<String, WeakReference<a>> f20691b = new HashMap();

    /* renamed from: c */
    public Context f20692c;

    public static class a implements Runnable {

        /* renamed from: a */
        public String f20693a;

        /* renamed from: b */
        public AtomicBoolean f20694b = new AtomicBoolean(false);

        public a(String str) {
            this.f20693a = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:53:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v10 */
        /* JADX WARN: Type inference failed for: r8v3, types: [java.net.HttpURLConnection] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(java.lang.String r8) {
            /*
                r7 = this;
                r0 = 0
                r1 = 1
                r2 = 0
                java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L64
                r3.<init>(r8)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L64
                java.net.URLConnection r8 = r3.openConnection()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L64
                java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L64
                r3 = 5000(0x1388, float:7.006E-42)
                r8.setConnectTimeout(r3)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                r8.setReadTimeout(r3)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                r8.connect()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                r3 = 1024(0x400, float:1.435E-42)
                byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                java.io.InputStream r2 = r8.getInputStream()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            L21:
                int r4 = r2.read(r3)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                r5 = -1
                if (r4 == r5) goto L44
                java.util.concurrent.atomic.AtomicBoolean r4 = r7.f20694b     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                boolean r4 = r4.get()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                if (r4 == 0) goto L21
                java.lang.String r3 = "cancelPreLoadVideo,取消网络请求,成功(正在下载数据),url=%s"
                java.lang.String r4 = r7.f20693a     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                r5[r0] = r4     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                java.lang.String r3 = java.lang.String.format(r3, r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                com.czhj.sdk.logger.SigmobLog.d(r3)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                goto L44
            L40:
                r0 = move-exception
                goto L8d
            L42:
                r3 = move-exception
                goto L66
            L44:
                java.lang.String r3 = "preloadVideo,网络文件,成功,url=%s"
                java.lang.String r4 = r7.f20693a     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                r5[r0] = r4     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                java.lang.String r3 = java.lang.String.format(r3, r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                com.czhj.sdk.logger.SigmobLog.i(r3)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                r2.close()     // Catch: java.lang.Exception -> L57
                goto L5b
            L57:
                r0 = move-exception
                r0.printStackTrace()
            L5b:
                r8.disconnect()     // Catch: java.lang.Exception -> L5f
                goto L8c
            L5f:
                r8 = move-exception
                goto L89
            L61:
                r0 = move-exception
                r8 = r2
                goto L8d
            L64:
                r3 = move-exception
                r8 = r2
            L66:
                java.lang.String r4 = "preloadVideo,网络文件,失败,msg=%s,url=%s"
                java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L40
                java.lang.String r5 = r7.f20693a     // Catch: java.lang.Throwable -> L40
                r6 = 2
                java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L40
                r6[r0] = r3     // Catch: java.lang.Throwable -> L40
                r6[r1] = r5     // Catch: java.lang.Throwable -> L40
                java.lang.String r0 = java.lang.String.format(r4, r6)     // Catch: java.lang.Throwable -> L40
                com.czhj.sdk.logger.SigmobLog.e(r0)     // Catch: java.lang.Throwable -> L40
                if (r2 == 0) goto L86
                r2.close()     // Catch: java.lang.Exception -> L82
                goto L86
            L82:
                r0 = move-exception
                r0.printStackTrace()
            L86:
                if (r8 == 0) goto L8c
                goto L5b
            L89:
                r8.printStackTrace()
            L8c:
                return
            L8d:
                if (r2 == 0) goto L97
                r2.close()     // Catch: java.lang.Exception -> L93
                goto L97
            L93:
                r1 = move-exception
                r1.printStackTrace()
            L97:
                if (r8 == 0) goto La1
                r8.disconnect()     // Catch: java.lang.Exception -> L9d
                goto La1
            L9d:
                r8 = move-exception
                r8.printStackTrace()
            La1:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videocache.x.a.a(java.lang.String):void");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f20694b.get()) {
                SigmobLog.i(String.format("cancelPreLoadVideo,取消网络请求,成功(未下载数据),url=%s", this.f20693a));
            } else {
                a(this.f20693a);
            }
        }

        public void a(boolean z10) {
            this.f20694b.set(z10);
        }
    }

    public x(Context context) {
        this.f20692c = context;
    }

    public void a(String str) {
        WeakReference<a> weakReference;
        a aVar;
        SigmobLog.d(String.format("cancelPreLoadVideo,ulr=%s", str));
        if (this.f20691b == null || TextUtils.isEmpty(str) || (weakReference = this.f20691b.get(str)) == null || (aVar = weakReference.get()) == null) {
            return;
        }
        SigmobLog.d(String.format("cancelPreLoadVideo,取消网络请求,ulr=%s", str));
        aVar.a(true);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String url = StringUtil.getUrl(str);
        Object[] objArr = new Object[1];
        if (!url.startsWith("http")) {
            objArr[0] = url;
            SigmobLog.d(String.format("preloadVideo,本地文件:ulr=%s", objArr));
            return;
        }
        objArr[0] = url;
        SigmobLog.d(String.format("preloadVideo,网络文件,开始下载:ulr=%s", objArr));
        a aVar = new a(url);
        this.f20691b.put(url, new WeakReference<>(aVar));
        this.f20690a.execute(aVar);
    }

    public static synchronized x a(Context context) {
        x xVar;
        synchronized (x.class) {
            try {
                if (f20689d == null && context != null) {
                    f20689d = new x(context.getApplicationContext());
                }
                xVar = f20689d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return xVar;
    }
}
