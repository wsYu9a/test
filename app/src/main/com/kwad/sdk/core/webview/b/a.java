package com.kwad.sdk.core.webview.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.webview.b.b.a;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.e;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile a aIA;
    private long acf;
    private Context mContext;
    private volatile boolean mHasInit = false;
    private final List<com.kwad.sdk.g.a.b> aIB = new CopyOnWriteArrayList();
    private final List<String> aIC = new CopyOnWriteArrayList();
    private final List<String> aID = new CopyOnWriteArrayList();
    private final NetworkMonitor.a aIE = new NetworkMonitor.a() { // from class: com.kwad.sdk.core.webview.b.a.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                a.this.IN();
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.webview.b.a$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            try {
                if (d.b(c.avE)) {
                    a.this.acf = System.currentTimeMillis();
                    a.this.bG(context);
                    a.this.IN();
                    NetworkMonitor.getInstance().a(a.this.mContext, a.this.aIE);
                }
            } catch (Throwable th2) {
                ((e) ServiceProvider.get(e.class)).gatherException(th2);
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.b.a$2 */
    public class AnonymousClass2 implements NetworkMonitor.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                a.this.IN();
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.b.a$3 */
    public class AnonymousClass3 extends bd {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            try {
                List<com.kwad.sdk.g.a.b> IO = a.this.IO();
                if (IO != null && !IO.isEmpty()) {
                    a.this.C(IO);
                    for (com.kwad.sdk.g.a.b bVar : IO) {
                        if (bVar.packageType == 1) {
                            int i10 = bVar.loadType;
                            if (i10 != 1) {
                                if (i10 == 2 && al.isWifiConnected(a.this.mContext)) {
                                }
                            }
                            a.this.a(bVar);
                        }
                    }
                }
            } catch (Throwable th2) {
                ((e) ServiceProvider.get(e.class)).gatherException(th2);
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.b.a$4 */
    public class AnonymousClass4 implements a.InterfaceC0501a {
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0501a
        public final void c(com.kwad.sdk.g.a.b bVar) {
            a.this.aID.add(bVar.aMy);
            com.kwad.sdk.core.d.c.d("HybridPackageManager", "download onStart: " + bVar.toString());
        }

        @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0501a
        public final void d(com.kwad.sdk.g.a.b bVar) {
            com.kwad.sdk.core.d.c.d("HybridPackageManager", "download success: " + bVar.toString());
            if (com.kwad.sdk.core.webview.b.b.b.a(a.this.mContext, bVar)) {
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "install success: " + bVar.toString());
                a.this.aIB.add(bVar);
                a aVar = a.this;
                aVar.bF(aVar.mContext);
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 4);
            }
            a.this.aID.remove(bVar.aMy);
        }

        @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0501a
        public final void e(com.kwad.sdk.g.a.b bVar) {
            com.kwad.sdk.core.d.c.d("HybridPackageManager", "download failure: " + bVar.toString());
            a.this.aID.remove(bVar.aMy);
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.b.a$5 */
    public class AnonymousClass5 extends bd {
        final /* synthetic */ com.kwad.sdk.g.a.b aIG;

        public AnonymousClass5(com.kwad.sdk.g.a.b bVar) {
            bVar = bVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.g.a.b bVar = bVar;
            if (bVar != null) {
                a.this.a(bVar);
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.b.a$6 */
    public class AnonymousClass6 implements com.kwad.sdk.core.c<com.kwad.sdk.g.a.b> {
        public AnonymousClass6() {
        }

        private static com.kwad.sdk.g.a.b IP() {
            return new com.kwad.sdk.g.a.b();
        }

        @Override // com.kwad.sdk.core.c
        public final /* synthetic */ com.kwad.sdk.g.a.b Ct() {
            return IP();
        }
    }

    private a() {
    }

    public void C(List<com.kwad.sdk.g.a.b> list) {
        synchronized (this.aIB) {
            try {
                bG(this.mContext);
                for (com.kwad.sdk.g.a.b bVar : this.aIB) {
                    if (!list.contains(bVar)) {
                        u.ab(new File(bVar.aMA));
                        this.aIB.remove(bVar);
                    } else if (u.gG(com.kwad.sdk.core.webview.b.c.a.J(this.mContext, bVar.aMz))) {
                        list.remove(bVar);
                    }
                }
                bF(this.mContext);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static a IL() {
        if (aIA == null) {
            synchronized (a.class) {
                try {
                    if (aIA == null) {
                        aIA = new a();
                    }
                } finally {
                }
            }
        }
        return aIA;
    }

    @Nullable
    public List<com.kwad.sdk.g.a.b> IO() {
        List<com.kwad.sdk.g.a.a> list;
        SdkConfigData DA = d.DA();
        if (DA == null || (list = DA.h5PreloadConfigs) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.kwad.sdk.g.a.a aVar : list) {
            for (com.kwad.sdk.g.a.b bVar : aVar.aMx) {
                a(bVar, aVar);
                if (bVar.isValid()) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    private WebResourceResponse ab(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            b.a aVar = new b.a();
            this.aIC.add(str);
            WebResourceResponse a10 = a(str, str2, aVar, false);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (a10 != null) {
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "load success time:" + currentTimeMillis2 + "--url:" + str2);
                com.kwad.sdk.core.webview.b.c.b.a(str2, str, 1, "", currentTimeMillis2);
            } else {
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "load fail errorMsg:" + aVar.msg + "-url:" + str2);
                com.kwad.sdk.core.webview.b.c.b.a(str2, str, 2, aVar.msg, currentTimeMillis2);
            }
            return a10;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            com.kwad.sdk.core.webview.b.c.b.a(str2, str, 2, "HybridWebViewClient中 Exception " + Log.getStackTraceString(th2), System.currentTimeMillis() - currentTimeMillis);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0046 A[Catch: all -> 0x0022, TryCatch #0 {, blocks: (B:9:0x001e, B:10:0x0035, B:11:0x0040, B:13:0x0046, B:16:0x0050, B:21:0x0058, B:31:0x005a, B:32:0x005d, B:27:0x0032), top: B:4:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bF(android.content.Context r5) {
        /*
            r4 = this;
            java.util.List<com.kwad.sdk.g.a.b> r0 = r4.aIB
            monitor-enter(r0)
            r1 = 0
            java.io.File r5 = com.kwad.sdk.core.webview.b.c.a.bJ(r5)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            java.util.List<com.kwad.sdk.g.a.b> r2 = r4.aIB     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            org.json.JSONArray r2 = com.kwad.sdk.utils.x.N(r2)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            byte[] r5 = r2.getBytes()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            r3.write(r5)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)     // Catch: java.lang.Throwable -> L22
            goto L35
        L22:
            r5 = move-exception
            goto L5e
        L24:
            r5 = move-exception
            r1 = r3
            goto L5a
        L27:
            r1 = r3
            goto L2b
        L29:
            r5 = move-exception
            goto L5a
        L2b:
            java.lang.String r5 = "updatePackageIndexFile"
            java.lang.String r2 = "read packageIndex file error"
            com.kwad.sdk.core.d.c.e(r5, r2)     // Catch: java.lang.Throwable -> L29
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L22
        L35:
            java.util.List<java.lang.String> r5 = r4.aIC     // Catch: java.lang.Throwable -> L22
            r5.clear()     // Catch: java.lang.Throwable -> L22
            java.util.List<com.kwad.sdk.g.a.b> r5 = r4.aIB     // Catch: java.lang.Throwable -> L22
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L22
        L40:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L58
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L22
            com.kwad.sdk.g.a.b r1 = (com.kwad.sdk.g.a.b) r1     // Catch: java.lang.Throwable -> L22
            boolean r2 = r1.aMC     // Catch: java.lang.Throwable -> L22
            if (r2 == 0) goto L40
            java.util.List<java.lang.String> r2 = r4.aIC     // Catch: java.lang.Throwable -> L22
            java.lang.String r1 = r1.aMy     // Catch: java.lang.Throwable -> L22
            r2.add(r1)     // Catch: java.lang.Throwable -> L22
            goto L40
        L58:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L22
            return
        L5a:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L22
            throw r5     // Catch: java.lang.Throwable -> L22
        L5e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L22
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.b.a.bF(android.content.Context):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042 A[Catch: all -> 0x0038, TryCatch #2 {, blocks: (B:11:0x0033, B:14:0x0042, B:15:0x004c, B:16:0x0057, B:18:0x005d, B:20:0x0071, B:21:0x0076, B:24:0x007a, B:29:0x0082, B:39:0x0084, B:40:0x0087, B:35:0x003d), top: B:4:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: all -> 0x0038, TryCatch #2 {, blocks: (B:11:0x0033, B:14:0x0042, B:15:0x004c, B:16:0x0057, B:18:0x005d, B:20:0x0071, B:21:0x0076, B:24:0x007a, B:29:0x0082, B:39:0x0084, B:40:0x0087, B:35:0x003d), top: B:4:0x0004 }] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bG(android.content.Context r5) {
        /*
            r4 = this;
            java.util.List<com.kwad.sdk.g.a.b> r0 = r4.aIB
            monitor-enter(r0)
            r1 = 0
            java.io.File r5 = com.kwad.sdk.core.webview.b.c.a.bJ(r5)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            boolean r2 = com.kwad.sdk.utils.u.M(r5)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            if (r2 == 0) goto L32
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
            java.lang.String r5 = com.kwad.sdk.crash.utils.h.b(r5)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
            com.kwad.sdk.core.webview.b.a$6 r3 = new com.kwad.sdk.core.webview.b.a$6     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
            r3.<init>()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
            java.util.List r1 = a(r5, r3)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
            r5 = r1
            r1 = r2
            goto L33
        L28:
            r5 = move-exception
            r1 = r2
            goto L84
        L2b:
            r5 = move-exception
            goto L3a
        L2d:
            r5 = move-exception
            goto L84
        L2f:
            r5 = move-exception
            r2 = r1
            goto L3a
        L32:
            r5 = r1
        L33:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L38
            r1 = r5
            goto L40
        L38:
            r5 = move-exception
            goto L88
        L3a:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L28
            com.kwad.sdk.crash.utils.b.closeQuietly(r2)     // Catch: java.lang.Throwable -> L38
        L40:
            if (r1 == 0) goto L4c
            java.util.List<com.kwad.sdk.g.a.b> r5 = r4.aIB     // Catch: java.lang.Throwable -> L38
            r5.clear()     // Catch: java.lang.Throwable -> L38
            java.util.List<com.kwad.sdk.g.a.b> r5 = r4.aIB     // Catch: java.lang.Throwable -> L38
            r5.addAll(r1)     // Catch: java.lang.Throwable -> L38
        L4c:
            java.util.List<java.lang.String> r5 = r4.aIC     // Catch: java.lang.Throwable -> L38
            r5.clear()     // Catch: java.lang.Throwable -> L38
            java.util.List<com.kwad.sdk.g.a.b> r5 = r4.aIB     // Catch: java.lang.Throwable -> L38
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L38
        L57:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L38
            if (r1 == 0) goto L82
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L38
            com.kwad.sdk.g.a.b r1 = (com.kwad.sdk.g.a.b) r1     // Catch: java.lang.Throwable -> L38
            android.content.Context r2 = r4.mContext     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = r1.aMz     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = com.kwad.sdk.core.webview.b.c.a.J(r2, r3)     // Catch: java.lang.Throwable -> L38
            boolean r2 = com.kwad.sdk.utils.u.gG(r2)     // Catch: java.lang.Throwable -> L38
            if (r2 != 0) goto L76
            java.util.List<com.kwad.sdk.g.a.b> r2 = r4.aIB     // Catch: java.lang.Throwable -> L38
            r2.remove(r1)     // Catch: java.lang.Throwable -> L38
        L76:
            boolean r2 = r1.aMC     // Catch: java.lang.Throwable -> L38
            if (r2 == 0) goto L57
            java.util.List<java.lang.String> r2 = r4.aIC     // Catch: java.lang.Throwable -> L38
            java.lang.String r1 = r1.aMy     // Catch: java.lang.Throwable -> L38
            r2.add(r1)     // Catch: java.lang.Throwable -> L38
            goto L57
        L82:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L38
            return
        L84:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L38
            throw r5     // Catch: java.lang.Throwable -> L38
        L88:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L38
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.b.a.bG(android.content.Context):void");
    }

    private WebResourceResponse eY(String str) {
        try {
            b.a aVar = new b.a();
            synchronized (this.aIB) {
                try {
                    Iterator<String> it = this.aIC.iterator();
                    while (it.hasNext()) {
                        WebResourceResponse a10 = a(it.next(), str, aVar, true);
                        if (a10 != null) {
                            return a10;
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
            return null;
        }
    }

    private com.kwad.sdk.g.a.b eZ(String str) {
        List<com.kwad.sdk.g.a.b> IO = IO();
        if (IO != null && !IO.isEmpty()) {
            for (com.kwad.sdk.g.a.b bVar : IO) {
                if (bm.isEquals(str, bVar.aMy)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    private com.kwad.sdk.g.a.b fa(String str) {
        synchronized (this.aIB) {
            try {
                if (!TextUtils.isEmpty(str) && this.aIB.size() > 0) {
                    for (com.kwad.sdk.g.a.b bVar : this.aIB) {
                        if (TextUtils.equals(str, bVar.aMy)) {
                            return bVar;
                        }
                    }
                    return null;
                }
                return null;
            } finally {
            }
        }
    }

    public final long IM() {
        return this.acf;
    }

    public final void IN() {
        if (d.DJ()) {
            h.execute(new bd() { // from class: com.kwad.sdk.core.webview.b.a.3
                public AnonymousClass3() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    try {
                        List<com.kwad.sdk.g.a.b> IO = a.this.IO();
                        if (IO != null && !IO.isEmpty()) {
                            a.this.C(IO);
                            for (com.kwad.sdk.g.a.b bVar : IO) {
                                if (bVar.packageType == 1) {
                                    int i10 = bVar.loadType;
                                    if (i10 != 1) {
                                        if (i10 == 2 && al.isWifiConnected(a.this.mContext)) {
                                        }
                                    }
                                    a.this.a(bVar);
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        ((e) ServiceProvider.get(e.class)).gatherException(th2);
                    }
                }
            });
        }
    }

    @Nullable
    public final WebResourceResponse aa(String str, String str2) {
        if (!this.mHasInit) {
            return null;
        }
        String fd2 = com.kwad.sdk.core.webview.b.c.a.fd(str);
        if (TextUtils.isEmpty(fd2)) {
            return eY(str);
        }
        com.kwad.sdk.core.webview.b.c.b.c(str2, fd2, str);
        WebResourceResponse ab2 = ab(fd2, str);
        com.kwad.sdk.core.webview.b.c.b.d(str2, fd2, str);
        return ab2;
    }

    public final synchronized void init(Context context) {
        if (!this.mHasInit && context != null) {
            this.mContext = ServiceProvider.MA();
            this.mHasInit = true;
            h.execute(new bd() { // from class: com.kwad.sdk.core.webview.b.a.1
                final /* synthetic */ Context hB;

                public AnonymousClass1(Context context2) {
                    context = context2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    try {
                        if (d.b(c.avE)) {
                            a.this.acf = System.currentTimeMillis();
                            a.this.bG(context);
                            a.this.IN();
                            NetworkMonitor.getInstance().a(a.this.mContext, a.this.aIE);
                        }
                    } catch (Throwable th2) {
                        ((e) ServiceProvider.get(e.class)).gatherException(th2);
                    }
                }
            });
        }
    }

    private void b(@NonNull com.kwad.sdk.g.a.b bVar) {
        h.execute(new bd() { // from class: com.kwad.sdk.core.webview.b.a.5
            final /* synthetic */ com.kwad.sdk.g.a.b aIG;

            public AnonymousClass5(com.kwad.sdk.g.a.b bVar2) {
                bVar = bVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.g.a.b bVar2 = bVar;
                if (bVar2 != null) {
                    a.this.a(bVar2);
                }
            }
        });
    }

    public void a(@NonNull com.kwad.sdk.g.a.b bVar) {
        if (this.aID.contains(bVar.aMy) || TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        com.kwad.sdk.core.webview.b.b.a.a(bVar, new a.InterfaceC0501a() { // from class: com.kwad.sdk.core.webview.b.a.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0501a
            public final void c(com.kwad.sdk.g.a.b bVar2) {
                a.this.aID.add(bVar2.aMy);
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "download onStart: " + bVar2.toString());
            }

            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0501a
            public final void d(com.kwad.sdk.g.a.b bVar2) {
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "download success: " + bVar2.toString());
                if (com.kwad.sdk.core.webview.b.b.b.a(a.this.mContext, bVar2)) {
                    com.kwad.sdk.core.d.c.d("HybridPackageManager", "install success: " + bVar2.toString());
                    a.this.aIB.add(bVar2);
                    a aVar = a.this;
                    aVar.bF(aVar.mContext);
                    com.kwad.sdk.core.webview.b.c.b.a(bVar2, 4);
                }
                a.this.aID.remove(bVar2.aMy);
            }

            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0501a
            public final void e(com.kwad.sdk.g.a.b bVar2) {
                com.kwad.sdk.core.d.c.d("HybridPackageManager", "download failure: " + bVar2.toString());
                a.this.aID.remove(bVar2.aMy);
            }
        });
    }

    private WebResourceResponse a(@NonNull String str, String str2, b.a aVar, boolean z10) {
        com.kwad.sdk.g.a.b fa2 = fa(str);
        if (fa2 == null) {
            com.kwad.sdk.g.a.b eZ = eZ(str);
            if (eZ == null) {
                aVar.msg = "配置文件没有下发该zip资源";
                return null;
            }
            aVar.msg = "资源未下载:" + eZ.loadType;
            b(eZ);
            return null;
        }
        return b.a(this.mContext, str2, fa2, aVar, z10);
    }

    private void a(com.kwad.sdk.g.a.b bVar, com.kwad.sdk.g.a.a aVar) {
        bVar.aMy = aVar.sceneId;
        if (TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        String fe2 = com.kwad.sdk.core.webview.b.c.a.fe(bVar.packageUrl);
        if (TextUtils.isEmpty(fe2)) {
            return;
        }
        bVar.aMz = fe2;
        bVar.aMA = com.kwad.sdk.core.webview.b.c.a.H(this.mContext, fe2);
    }

    @Deprecated
    private static List<com.kwad.sdk.g.a.b> a(String str, @NonNull com.kwad.sdk.core.c<com.kwad.sdk.g.a.b> cVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                com.kwad.sdk.g.a.b Ct = cVar.Ct();
                Ct.parseJson(jSONObject);
                arrayList.add(Ct);
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }
}
