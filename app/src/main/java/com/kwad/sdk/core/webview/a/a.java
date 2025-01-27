package com.kwad.sdk.core.webview.a;

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
import com.kwad.sdk.core.webview.a.a.a;
import com.kwad.sdk.core.webview.a.b.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class a {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile a apJ;
    private Context mContext;
    private long mInitTime;
    private volatile boolean mHasInit = false;
    private final List<com.kwad.sdk.f.kwai.b> apK = new CopyOnWriteArrayList();
    private final List<String> apL = new CopyOnWriteArrayList();
    private final List<String> apM = new CopyOnWriteArrayList();
    private final NetworkMonitor.a apN = new NetworkMonitor.a() { // from class: com.kwad.sdk.core.webview.a.a.2
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                a.this.zc();
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.webview.a.a$1 */
    final class AnonymousClass1 extends aw {
        final /* synthetic */ Context jN;

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            try {
                if (d.b(c.adb)) {
                    a.this.mInitTime = System.currentTimeMillis();
                    a.this.bg(context);
                    a.this.zc();
                    NetworkMonitor.getInstance().a(a.this.mContext, a.this.apN);
                }
            } catch (Throwable th) {
                ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(th);
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.a.a$2 */
    final class AnonymousClass2 implements NetworkMonitor.a {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                a.this.zc();
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.a.a$3 */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i2;
            try {
                List<com.kwad.sdk.f.kwai.b> zd = a.this.zd();
                if (zd != null && !zd.isEmpty()) {
                    a.this.t(zd);
                    for (com.kwad.sdk.f.kwai.b bVar : zd) {
                        if (bVar.packageType == 1 && ((i2 = bVar.loadType) == 1 || (i2 == 2 && ag.isWifiConnected(a.this.mContext)))) {
                            a.this.a(bVar);
                        }
                    }
                }
            } catch (Throwable th) {
                ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(th);
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.a.a$4 */
    final class AnonymousClass4 implements a.InterfaceC0221a {
        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.webview.a.a.a.InterfaceC0221a
        public final void c(com.kwad.sdk.f.kwai.b bVar) {
            a.this.apM.add(bVar.atm);
            com.kwad.sdk.core.d.b.d("HybridPackageManager", "download onStart: " + bVar.toString());
        }

        @Override // com.kwad.sdk.core.webview.a.a.a.InterfaceC0221a
        public final void d(com.kwad.sdk.f.kwai.b bVar) {
            com.kwad.sdk.core.d.b.d("HybridPackageManager", "download success: " + bVar.toString());
            if (com.kwad.sdk.core.webview.a.a.b.a(a.this.mContext, bVar)) {
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "install success: " + bVar.toString());
                a.this.apK.add(bVar);
                a aVar = a.this;
                aVar.bf(aVar.mContext);
                com.kwad.sdk.core.webview.a.b.b.a(bVar, 4);
            }
            a.this.apM.remove(bVar.atm);
        }

        @Override // com.kwad.sdk.core.webview.a.a.a.InterfaceC0221a
        public final void e(com.kwad.sdk.f.kwai.b bVar) {
            com.kwad.sdk.core.d.b.d("HybridPackageManager", "download failure: " + bVar.toString());
            a.this.apM.remove(bVar.atm);
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.a.a$5 */
    final class AnonymousClass5 implements Runnable {
        final /* synthetic */ com.kwad.sdk.f.kwai.b apP;

        AnonymousClass5(com.kwad.sdk.f.kwai.b bVar) {
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.a(bVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.a.a$6 */
    final class AnonymousClass6 implements com.kwad.sdk.core.c<com.kwad.sdk.f.kwai.b> {
        AnonymousClass6() {
        }

        private static com.kwad.sdk.f.kwai.b ze() {
            return new com.kwad.sdk.f.kwai.b();
        }

        @Override // com.kwad.sdk.core.c
        public final /* synthetic */ com.kwad.sdk.f.kwai.b tU() {
            return ze();
        }
    }

    private a() {
    }

    private WebResourceResponse L(String str, String str2) {
        int i2;
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            b.a aVar = new b.a();
            this.apL.add(str);
            WebResourceResponse a2 = a(str, str2, aVar, false);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (a2 != null) {
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "load success time:" + currentTimeMillis2 + "--url:" + str2);
                i2 = 1;
                str3 = "";
            } else {
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "load fail errorMsg:" + aVar.msg + "-url:" + str2);
                i2 = 2;
                str3 = aVar.msg;
            }
            com.kwad.sdk.core.webview.a.b.b.a(str2, str, i2, str3, currentTimeMillis2);
            return a2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            com.kwad.sdk.core.webview.a.b.b.a(str2, str, 2, "HybridWebViewClient中 Exception " + Log.getStackTraceString(th), System.currentTimeMillis() - currentTimeMillis);
            return null;
        }
    }

    private WebResourceResponse a(@NonNull String str, String str2, b.a aVar, boolean z) {
        com.kwad.sdk.f.kwai.b df = df(str);
        if (df != null) {
            return b.a(this.mContext, str2, df, aVar, z);
        }
        com.kwad.sdk.f.kwai.b de2 = de(str);
        if (de2 == null) {
            aVar.msg = "配置文件没有下发该zip资源";
            return null;
        }
        aVar.msg = "资源未下载:" + de2.loadType;
        b(de2);
        return null;
    }

    public void a(@NonNull com.kwad.sdk.f.kwai.b bVar) {
        if (this.apM.contains(bVar.atm)) {
            return;
        }
        com.kwad.sdk.core.webview.a.a.a.a(bVar, new a.InterfaceC0221a() { // from class: com.kwad.sdk.core.webview.a.a.4
            AnonymousClass4() {
            }

            @Override // com.kwad.sdk.core.webview.a.a.a.InterfaceC0221a
            public final void c(com.kwad.sdk.f.kwai.b bVar2) {
                a.this.apM.add(bVar2.atm);
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "download onStart: " + bVar2.toString());
            }

            @Override // com.kwad.sdk.core.webview.a.a.a.InterfaceC0221a
            public final void d(com.kwad.sdk.f.kwai.b bVar2) {
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "download success: " + bVar2.toString());
                if (com.kwad.sdk.core.webview.a.a.b.a(a.this.mContext, bVar2)) {
                    com.kwad.sdk.core.d.b.d("HybridPackageManager", "install success: " + bVar2.toString());
                    a.this.apK.add(bVar2);
                    a aVar = a.this;
                    aVar.bf(aVar.mContext);
                    com.kwad.sdk.core.webview.a.b.b.a(bVar2, 4);
                }
                a.this.apM.remove(bVar2.atm);
            }

            @Override // com.kwad.sdk.core.webview.a.a.a.InterfaceC0221a
            public final void e(com.kwad.sdk.f.kwai.b bVar2) {
                com.kwad.sdk.core.d.b.d("HybridPackageManager", "download failure: " + bVar2.toString());
                a.this.apM.remove(bVar2.atm);
            }
        });
    }

    private void a(com.kwad.sdk.f.kwai.b bVar, com.kwad.sdk.f.kwai.a aVar) {
        bVar.atm = aVar.sceneId;
        if (TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        String dj = com.kwad.sdk.core.webview.a.b.a.dj(bVar.packageUrl);
        if (TextUtils.isEmpty(dj)) {
            return;
        }
        bVar.atn = dj;
        bVar.ato = com.kwad.sdk.core.webview.a.b.a.y(this.mContext, dj);
    }

    private void b(@NonNull com.kwad.sdk.f.kwai.b bVar) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.webview.a.a.5
            final /* synthetic */ com.kwad.sdk.f.kwai.b apP;

            AnonymousClass5(com.kwad.sdk.f.kwai.b bVar2) {
                bVar = bVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.a(bVar);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0044 A[Catch: all -> 0x005c, TryCatch #4 {, blocks: (B:10:0x001e, B:11:0x0033, B:12:0x003e, B:14:0x0044, B:17:0x004e, B:22:0x0056, B:32:0x0058, B:33:0x005b, B:28:0x0030), top: B:4:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bf(android.content.Context r5) {
        /*
            r4 = this;
            java.util.List<com.kwad.sdk.f.kwai.b> r0 = r4.apK
            monitor-enter(r0)
            r1 = 0
            java.io.File r5 = com.kwad.sdk.core.webview.a.b.a.bj(r5)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.util.List<com.kwad.sdk.f.kwai.b> r2 = r4.apK     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            org.json.JSONArray r2 = com.kwad.sdk.utils.t.C(r2)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            byte[] r5 = r2.getBytes()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            r3.write(r5)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L25
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)     // Catch: java.lang.Throwable -> L5c
            goto L33
        L22:
            r5 = move-exception
            r1 = r3
            goto L58
        L25:
            r1 = r3
            goto L29
        L27:
            r5 = move-exception
            goto L58
        L29:
            java.lang.String r5 = "updatePackageIndexFile"
            java.lang.String r2 = "read packageIndex file error"
            com.kwad.sdk.core.d.b.e(r5, r2)     // Catch: java.lang.Throwable -> L27
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L5c
        L33:
            java.util.List<java.lang.String> r5 = r4.apL     // Catch: java.lang.Throwable -> L5c
            r5.clear()     // Catch: java.lang.Throwable -> L5c
            java.util.List<com.kwad.sdk.f.kwai.b> r5 = r4.apK     // Catch: java.lang.Throwable -> L5c
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L5c
        L3e:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L5c
            if (r1 == 0) goto L56
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L5c
            com.kwad.sdk.f.kwai.b r1 = (com.kwad.sdk.f.kwai.b) r1     // Catch: java.lang.Throwable -> L5c
            boolean r2 = r1.atr     // Catch: java.lang.Throwable -> L5c
            if (r2 == 0) goto L3e
            java.util.List<java.lang.String> r2 = r4.apL     // Catch: java.lang.Throwable -> L5c
            java.lang.String r1 = r1.atm     // Catch: java.lang.Throwable -> L5c
            r2.add(r1)     // Catch: java.lang.Throwable -> L5c
            goto L3e
        L56:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5c
            return
        L58:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L5c
            throw r5     // Catch: java.lang.Throwable -> L5c
        L5c:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5c
            goto L60
        L5f:
            throw r5
        L60:
            goto L5f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.a.a.bf(android.content.Context):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:11:0x002a, B:14:0x003b, B:15:0x0045, B:16:0x0050, B:18:0x0056, B:20:0x006a, B:21:0x006f, B:24:0x0073, B:29:0x007b, B:35:0x0036, B:39:0x007f, B:40:0x0082), top: B:4:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:11:0x002a, B:14:0x003b, B:15:0x0045, B:16:0x0050, B:18:0x0056, B:20:0x006a, B:21:0x006f, B:24:0x0073, B:29:0x007b, B:35:0x0036, B:39:0x007f, B:40:0x0082), top: B:4:0x0004 }] */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bg(android.content.Context r5) {
        /*
            r4 = this;
            java.util.List<com.kwad.sdk.f.kwai.b> r0 = r4.apK
            monitor-enter(r0)
            r1 = 0
            java.io.File r5 = com.kwad.sdk.core.webview.a.b.a.bj(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            boolean r2 = com.kwad.sdk.utils.q.G(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            if (r2 == 0) goto L29
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            r5.<init>(r2)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            java.lang.String r5 = com.kwad.sdk.crash.utils.h.b(r5)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            com.kwad.sdk.core.webview.a.a$6 r3 = new com.kwad.sdk.core.webview.a.a$6     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            r3.<init>()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            java.util.List r5 = com.kwad.sdk.utils.t.a(r5, r3)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L7d
            r1 = r2
            goto L2a
        L27:
            r5 = move-exception
            goto L33
        L29:
            r5 = r1
        L2a:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L83
            r1 = r5
            goto L39
        L2f:
            r5 = move-exception
            goto L7f
        L31:
            r5 = move-exception
            r2 = r1
        L33:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L7d
            com.kwad.sdk.crash.utils.b.closeQuietly(r2)     // Catch: java.lang.Throwable -> L83
        L39:
            if (r1 == 0) goto L45
            java.util.List<com.kwad.sdk.f.kwai.b> r5 = r4.apK     // Catch: java.lang.Throwable -> L83
            r5.clear()     // Catch: java.lang.Throwable -> L83
            java.util.List<com.kwad.sdk.f.kwai.b> r5 = r4.apK     // Catch: java.lang.Throwable -> L83
            r5.addAll(r1)     // Catch: java.lang.Throwable -> L83
        L45:
            java.util.List<java.lang.String> r5 = r4.apL     // Catch: java.lang.Throwable -> L83
            r5.clear()     // Catch: java.lang.Throwable -> L83
            java.util.List<com.kwad.sdk.f.kwai.b> r5 = r4.apK     // Catch: java.lang.Throwable -> L83
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L83
        L50:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L7b
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L83
            com.kwad.sdk.f.kwai.b r1 = (com.kwad.sdk.f.kwai.b) r1     // Catch: java.lang.Throwable -> L83
            android.content.Context r2 = r4.mContext     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r1.atn     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = com.kwad.sdk.core.webview.a.b.a.A(r2, r3)     // Catch: java.lang.Throwable -> L83
            boolean r2 = com.kwad.sdk.utils.q.ew(r2)     // Catch: java.lang.Throwable -> L83
            if (r2 != 0) goto L6f
            java.util.List<com.kwad.sdk.f.kwai.b> r2 = r4.apK     // Catch: java.lang.Throwable -> L83
            r2.remove(r1)     // Catch: java.lang.Throwable -> L83
        L6f:
            boolean r2 = r1.atr     // Catch: java.lang.Throwable -> L83
            if (r2 == 0) goto L50
            java.util.List<java.lang.String> r2 = r4.apL     // Catch: java.lang.Throwable -> L83
            java.lang.String r1 = r1.atm     // Catch: java.lang.Throwable -> L83
            r2.add(r1)     // Catch: java.lang.Throwable -> L83
            goto L50
        L7b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L83
            return
        L7d:
            r5 = move-exception
            r1 = r2
        L7f:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L83
            throw r5     // Catch: java.lang.Throwable -> L83
        L83:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L83
            goto L87
        L86:
            throw r5
        L87:
            goto L86
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.a.a.bg(android.content.Context):void");
    }

    private WebResourceResponse dd(String str) {
        try {
            b.a aVar = new b.a();
            synchronized (this.apK) {
                Iterator<String> it = this.apL.iterator();
                while (it.hasNext()) {
                    WebResourceResponse a2 = a(it.next(), str, aVar, true);
                    if (a2 != null) {
                        return a2;
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private com.kwad.sdk.f.kwai.b de(String str) {
        List<com.kwad.sdk.f.kwai.b> zd = zd();
        if (zd != null && !zd.isEmpty()) {
            for (com.kwad.sdk.f.kwai.b bVar : zd) {
                if (bb.isEquals(str, bVar.atm)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    private com.kwad.sdk.f.kwai.b df(String str) {
        synchronized (this.apK) {
            if (!TextUtils.isEmpty(str) && this.apK.size() > 0) {
                for (com.kwad.sdk.f.kwai.b bVar : this.apK) {
                    if (TextUtils.equals(str, bVar.atm)) {
                        return bVar;
                    }
                }
                return null;
            }
            return null;
        }
    }

    public void t(List<com.kwad.sdk.f.kwai.b> list) {
        synchronized (this.apK) {
            bg(this.mContext);
            for (com.kwad.sdk.f.kwai.b bVar : this.apK) {
                if (!list.contains(bVar)) {
                    q.V(new File(bVar.ato));
                    this.apK.remove(bVar);
                } else if (q.ew(com.kwad.sdk.core.webview.a.b.a.A(this.mContext, bVar.atn))) {
                    list.remove(bVar);
                }
            }
            bf(this.mContext);
        }
    }

    public static a za() {
        if (apJ == null) {
            synchronized (a.class) {
                if (apJ == null) {
                    apJ = new a();
                }
            }
        }
        return apJ;
    }

    @Nullable
    public List<com.kwad.sdk.f.kwai.b> zd() {
        List<com.kwad.sdk.f.kwai.a> list;
        SdkConfigData uu = d.uu();
        if (uu == null || (list = uu.h5PreloadConfigs) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.kwad.sdk.f.kwai.a aVar : list) {
            for (com.kwad.sdk.f.kwai.b bVar : aVar.atl) {
                a(bVar, aVar);
                if (bVar.isValid()) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public final WebResourceResponse K(String str, String str2) {
        if (!this.mHasInit) {
            return null;
        }
        String di = com.kwad.sdk.core.webview.a.b.a.di(str);
        if (TextUtils.isEmpty(di)) {
            return dd(str);
        }
        com.kwad.sdk.core.webview.a.b.b.b(str2, di, str);
        WebResourceResponse L = L(di, str);
        com.kwad.sdk.core.webview.a.b.b.c(str2, di, str);
        return L;
    }

    public final synchronized void init(Context context) {
        if (!this.mHasInit && context != null) {
            this.mContext = ServiceProvider.CA();
            this.mHasInit = true;
            g.execute(new aw() { // from class: com.kwad.sdk.core.webview.a.a.1
                final /* synthetic */ Context jN;

                AnonymousClass1(Context context2) {
                    context = context2;
                }

                @Override // com.kwad.sdk.utils.aw
                public final void doTask() {
                    try {
                        if (d.b(c.adb)) {
                            a.this.mInitTime = System.currentTimeMillis();
                            a.this.bg(context);
                            a.this.zc();
                            NetworkMonitor.getInstance().a(a.this.mContext, a.this.apN);
                        }
                    } catch (Throwable th) {
                        ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(th);
                    }
                }
            });
        }
    }

    public final long zb() {
        return this.mInitTime;
    }

    public final void zc() {
        if (d.uD()) {
            g.execute(new Runnable() { // from class: com.kwad.sdk.core.webview.a.a.3
                AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i2;
                    try {
                        List<com.kwad.sdk.f.kwai.b> zd = a.this.zd();
                        if (zd != null && !zd.isEmpty()) {
                            a.this.t(zd);
                            for (com.kwad.sdk.f.kwai.b bVar : zd) {
                                if (bVar.packageType == 1 && ((i2 = bVar.loadType) == 1 || (i2 == 2 && ag.isWifiConnected(a.this.mContext)))) {
                                    a.this.a(bVar);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(th);
                    }
                }
            });
        }
    }
}
