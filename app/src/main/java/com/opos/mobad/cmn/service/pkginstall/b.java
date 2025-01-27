package com.opos.mobad.cmn.service.pkginstall;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.widget.Toast;
import com.opos.cmn.e.a.c.c.e;
import com.opos.mobad.cmn.a.b.d;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.model.data.AdItemData;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public final class b implements com.opos.cmn.e.a.c.a {

    /* renamed from: a */
    private static final byte[] f20334a = new byte[0];

    /* renamed from: b */
    private static volatile b f20335b;

    /* renamed from: d */
    private Context f20337d;

    /* renamed from: e */
    private LruCache<String, Set<InterfaceC0437b>> f20338e;

    /* renamed from: f */
    private e f20339f;

    /* renamed from: g */
    private LruCache<String, List<AdItemData>> f20340g;

    /* renamed from: c */
    private int f20336c = -1;

    /* renamed from: h */
    private final Handler f20341h = new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.cmn.service.pkginstall.b.1
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                try {
                    String str = (String) message.obj;
                    int i2 = message.what;
                    if (i2 == 0) {
                        b.this.a(str);
                        return;
                    }
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return;
                        }
                        b.this.a(str, (int[]) null);
                    } else {
                        if (!b.this.f() || !f.l()) {
                            com.opos.cmn.an.f.a.b("PkgInstallMgr", "show Toast but lack of conditions to show");
                            return;
                        }
                        Bundle data = message.getData();
                        if (data != null) {
                            boolean z = data.getBoolean("gbClick");
                            if (b.this.f20339f == null) {
                                b bVar = b.this;
                                bVar.f20339f = new com.opos.cmn.e.a.c.c.f(bVar.f20337d.getApplicationContext(), b.this);
                            }
                            b.this.f20339f.a(str, z, new Object[0]);
                        }
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
                }
            }
        }
    };

    /* renamed from: i */
    private final com.opos.mobad.cmn.service.pkginstall.a f20342i = new com.opos.mobad.cmn.service.pkginstall.a() { // from class: com.opos.mobad.cmn.service.pkginstall.b.2
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.a
        public void a(Object... objArr) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("PKG_ADDED_BR_LISTENER onReceive objects=");
                sb.append(objArr != null ? objArr : "null");
                com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
                if (objArr == null || objArr.length <= 0 || objArr[0] == null) {
                    return;
                }
                String str = (String) objArr[0];
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "installPkgName=" + str);
                if (b.this.d(str)) {
                    b.this.g(str);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
            }
        }
    };

    /* renamed from: com.opos.mobad.cmn.service.pkginstall.b$1 */
    class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                try {
                    String str = (String) message.obj;
                    int i2 = message.what;
                    if (i2 == 0) {
                        b.this.a(str);
                        return;
                    }
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return;
                        }
                        b.this.a(str, (int[]) null);
                    } else {
                        if (!b.this.f() || !f.l()) {
                            com.opos.cmn.an.f.a.b("PkgInstallMgr", "show Toast but lack of conditions to show");
                            return;
                        }
                        Bundle data = message.getData();
                        if (data != null) {
                            boolean z = data.getBoolean("gbClick");
                            if (b.this.f20339f == null) {
                                b bVar = b.this;
                                bVar.f20339f = new com.opos.cmn.e.a.c.c.f(bVar.f20337d.getApplicationContext(), b.this);
                            }
                            b.this.f20339f.a(str, z, new Object[0]);
                        }
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
                }
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.service.pkginstall.b$2 */
    class AnonymousClass2 implements com.opos.mobad.cmn.service.pkginstall.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.a
        public void a(Object... objArr) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("PKG_ADDED_BR_LISTENER onReceive objects=");
                sb.append(objArr != null ? objArr : "null");
                com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
                if (objArr == null || objArr.length <= 0 || objArr[0] == null) {
                    return;
                }
                String str = (String) objArr[0];
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "installPkgName=" + str);
                if (b.this.d(str)) {
                    b.this.g(str);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.service.pkginstall.b$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f20345a;

        AnonymousClass3(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(b.this.f20337d.getApplicationContext(), f.c(b.this.f20337d, str) + "已经安装完成", 0).show();
        }
    }

    /* renamed from: com.opos.mobad.cmn.service.pkginstall.b$4 */
    class AnonymousClass4 implements a {

        /* renamed from: a */
        final /* synthetic */ String f20347a;

        AnonymousClass4(String str) {
            r2 = str;
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.a
        public void a() {
            b.this.a(r2);
        }
    }

    /* renamed from: com.opos.mobad.cmn.service.pkginstall.b$5 */
    class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f20349a;

        AnonymousClass5(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Set<InterfaceC0437b> f2;
            if (com.opos.cmn.an.c.a.a(str) || (f2 = b.this.f(str)) == null || f2.size() <= 0) {
                return;
            }
            for (InterfaceC0437b interfaceC0437b : f2) {
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "notifyInstallCompletedEvent getListenerMap =" + interfaceC0437b);
                if (interfaceC0437b != null) {
                    List e2 = b.this.e(str);
                    if (e2 == null || e2.size() <= 0 || e2.get(0) == null) {
                        com.opos.cmn.an.f.a.b("PkgInstallMgr", "notify but data empty");
                    } else {
                        com.opos.cmn.an.f.a.b("PkgInstallMgr", "notifyInstallCompletedEvent listener = " + interfaceC0437b);
                        interfaceC0437b.a((AdItemData) e2.get(0), str);
                    }
                }
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.service.pkginstall.b$6 */
    class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f20351a;

        /* renamed from: b */
        final /* synthetic */ a f20352b;

        AnonymousClass6(String str, a aVar) {
            str = str;
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Set<InterfaceC0437b> f2;
            if (!com.opos.cmn.an.c.a.a(str) && (f2 = b.this.f(str)) != null && f2.size() > 0) {
                for (InterfaceC0437b interfaceC0437b : f2) {
                    if (interfaceC0437b != null) {
                        List e2 = b.this.e(str);
                        if (e2 == null || e2.size() <= 0 || e2.get(0) == null) {
                            com.opos.cmn.an.f.a.b("PkgInstallMgr", "notify but data empty");
                        } else {
                            interfaceC0437b.b((AdItemData) e2.get(0), str);
                        }
                    }
                }
            }
            a aVar = aVar;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    private interface a {
        void a();
    }

    /* renamed from: com.opos.mobad.cmn.service.pkginstall.b$b */
    public interface InterfaceC0437b {
        void a(AdItemData adItemData, String str);

        void b(AdItemData adItemData, String str);

        void c(AdItemData adItemData, String str);
    }

    private b(Context context) {
        this.f20337d = context.getApplicationContext();
        b();
    }

    public static b a(Context context) {
        b bVar = f20335b;
        if (bVar == null) {
            synchronized (f20334a) {
                bVar = f20335b;
                if (bVar == null) {
                    bVar = new b(context);
                    f20335b = bVar;
                }
            }
        }
        return bVar;
    }

    public void a(String str) {
        b(str);
        c(str);
    }

    private void a(String str, a aVar) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("notifyLaunchEvent pkgName=");
            sb.append(str != null ? str : "null");
            com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
            this.f20341h.post(new Runnable() { // from class: com.opos.mobad.cmn.service.pkginstall.b.6

                /* renamed from: a */
                final /* synthetic */ String f20351a;

                /* renamed from: b */
                final /* synthetic */ a f20352b;

                AnonymousClass6(String str2, a aVar2) {
                    str = str2;
                    aVar = aVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Set<InterfaceC0437b> f2;
                    if (!com.opos.cmn.an.c.a.a(str) && (f2 = b.this.f(str)) != null && f2.size() > 0) {
                        for (InterfaceC0437b interfaceC0437b : f2) {
                            if (interfaceC0437b != null) {
                                List e2 = b.this.e(str);
                                if (e2 == null || e2.size() <= 0 || e2.get(0) == null) {
                                    com.opos.cmn.an.f.a.b("PkgInstallMgr", "notify but data empty");
                                } else {
                                    interfaceC0437b.b((AdItemData) e2.get(0), str);
                                }
                            }
                        }
                    }
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            });
        } catch (Exception e2) {
            if (aVar2 != null) {
                aVar2.a();
            }
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0012, B:8:0x001a, B:11:0x002c, B:14:0x0035, B:16:0x001e, B:18:0x0026), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035 A[Catch: Exception -> 0x0039, TRY_LEAVE, TryCatch #0 {Exception -> 0x0039, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0012, B:8:0x001a, B:11:0x002c, B:14:0x0035, B:16:0x001e, B:18:0x0026), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r5, int[] r6) {
        /*
            r4 = this;
            boolean r0 = com.opos.cmn.an.c.a.a(r5)     // Catch: java.lang.Exception -> L39
            if (r0 != 0) goto L41
            java.lang.String r0 = r4.l(r5)     // Catch: java.lang.Exception -> L39
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L39
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L1e
            android.content.Context r1 = r4.f20337d     // Catch: java.lang.Exception -> L39
            boolean r0 = com.opos.mobad.cmn.a.b.f.b(r1, r0)     // Catch: java.lang.Exception -> L39
            if (r0 == 0) goto L1e
            r4.a(r5, r6, r3, r3)     // Catch: java.lang.Exception -> L39
            goto L29
        L1e:
            android.content.Context r0 = r4.f20337d     // Catch: java.lang.Exception -> L39
            boolean r0 = com.opos.mobad.cmn.a.b.f.a(r0, r5)     // Catch: java.lang.Exception -> L39
            if (r0 == 0) goto L2a
            r4.a(r5, r6, r2, r3)     // Catch: java.lang.Exception -> L39
        L29:
            r2 = 1
        L2a:
            if (r2 == 0) goto L35
            com.opos.mobad.cmn.service.pkginstall.b$4 r6 = new com.opos.mobad.cmn.service.pkginstall.b$4     // Catch: java.lang.Exception -> L39
            r6.<init>()     // Catch: java.lang.Exception -> L39
            r4.a(r5, r6)     // Catch: java.lang.Exception -> L39
            goto L41
        L35:
            r4.a(r5)     // Catch: java.lang.Exception -> L39
            goto L41
        L39:
            r5 = move-exception
            java.lang.String r6 = "PkgInstallMgr"
            java.lang.String r0 = ""
            com.opos.cmn.an.f.a.a(r6, r0, r5)
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.service.pkginstall.b.a(java.lang.String, int[]):void");
    }

    private void a(String str, int[] iArr, boolean z, boolean z2) {
        AdItemData adItemData;
        List<AdItemData> e2 = e(str);
        if (e2 == null || e2.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < e2.size(); i2++) {
            if (e2.get(i2) != null && (adItemData = e2.get(i2)) != null) {
                if (z) {
                    d.c(this.f20337d, adItemData.g(), adItemData, adItemData.i().get(0), z2, iArr, null);
                } else {
                    d.a(this.f20337d, adItemData, adItemData.i().get(0), z2, iArr);
                }
            }
        }
    }

    private boolean a(List<AdItemData> list, AdItemData adItemData) {
        if (list.size() <= 0) {
            return false;
        }
        for (AdItemData adItemData2 : list) {
            if (adItemData2 != null && !TextUtils.isEmpty(adItemData2.i().get(0).aa()) && !TextUtils.isEmpty(adItemData.i().get(0).aa()) && adItemData2.i().get(0).aa().equals(adItemData.i().get(0).aa())) {
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "addAdItemData but has contain ,traceId = " + adItemData2.i().get(0).aa());
                return true;
            }
        }
        return false;
    }

    private void b() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "init");
        try {
            if (this.f20340g == null) {
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "init sAdItemDataCache");
                this.f20340g = new LruCache<>(50);
            }
            if (this.f20338e == null) {
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "init sListenerMap");
                this.f20338e = new LruCache<>(20);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
        }
    }

    private void b(String str) {
        try {
            if (!com.opos.cmn.an.c.a.a(str) && this.f20340g.get(str) != null) {
                this.f20340g.remove(str);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "", e2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("removeAdItemDataList pkgName=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",sAdItemDataCache.size=");
        sb.append(this.f20340g.size());
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    private void b(String str, InterfaceC0437b interfaceC0437b) {
        Set<InterfaceC0437b> f2;
        try {
            if (!com.opos.cmn.an.c.a.a(str) && interfaceC0437b != null && (f2 = f(str)) != null) {
                if (f2.size() > 0) {
                    for (InterfaceC0437b interfaceC0437b2 : f2) {
                        if (interfaceC0437b2 != null && interfaceC0437b2.equals(interfaceC0437b)) {
                            com.opos.cmn.an.f.a.b("PkgInstallMgr", "addListener but has contain");
                            return;
                        }
                    }
                }
                f2.add(interfaceC0437b);
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "addListener pkgName=" + str + ",listenerList.size=" + f2.size());
                this.f20338e.put(str, f2);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("addListener pkgName=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",listener=");
        Object obj = interfaceC0437b;
        if (interfaceC0437b == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(",sListenerMap.size=");
        sb.append(this.f20338e.size());
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    private void b(String str, AdItemData adItemData) {
        List<AdItemData> e2;
        try {
            if (!com.opos.cmn.an.c.a.a(str) && adItemData != null && (e2 = e(str)) != null && !a(e2, adItemData)) {
                e2.add(adItemData);
                this.f20340g.put(str, e2);
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "addAdItemData pkgName=" + str + ",adItemDataList.size=" + e2.size());
            }
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e3);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("addAdItemData pkgName=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",sAdItemDataCache.size=");
        sb.append(this.f20340g.size());
        sb.append(",adItemData=");
        Object obj = adItemData;
        if (adItemData == null) {
            obj = "null";
        }
        sb.append(obj);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    private void c() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "clearDataMap");
        this.f20340g.evictAll();
        this.f20338e.evictAll();
    }

    private void c(String str) {
        try {
            if (!com.opos.cmn.an.c.a.a(str)) {
                this.f20338e.remove(str);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "", e2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("removeListenerList pkgName=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",sListenerMap.size=");
        sb.append(this.f20338e.size());
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    private void d() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "registerPkgInstallBR sDownloadBRListenerId=" + this.f20336c);
        if (-1 == this.f20336c) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "really registerPkgInstallBR!!!");
            this.f20336c = c.a().a(0, this.f20342i);
        }
    }

    public boolean d(String str) {
        boolean z;
        if (!com.opos.cmn.an.c.a.a(str)) {
            if (this.f20340g.get(str) != null) {
                z = true;
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "isContainPkgName result=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "isContainPkgName result=" + z);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.opos.mobad.model.data.AdItemData> e(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "PkgInstallMgr"
            android.util.LruCache<java.lang.String, java.util.List<com.opos.mobad.model.data.AdItemData>> r1 = r4.f20340g     // Catch: java.lang.Exception -> L15
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Exception -> L15
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Exception -> L15
            if (r1 != 0) goto L1d
            java.util.concurrent.CopyOnWriteArrayList r2 = new java.util.concurrent.CopyOnWriteArrayList     // Catch: java.lang.Exception -> L13
            r2.<init>()     // Catch: java.lang.Exception -> L13
            r1 = r2
            goto L1d
        L13:
            r2 = move-exception
            goto L18
        L15:
            r1 = move-exception
            r2 = r1
            r1 = 0
        L18:
            java.lang.String r3 = ""
            com.opos.cmn.an.f.a.a(r0, r3, r2)
        L1d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getAdItemDataList pkgName="
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = ",adItemDataList.size="
            r2.append(r5)
            if (r1 == 0) goto L3a
            int r5 = r1.size()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L3c
        L3a:
            java.lang.String r5 = "null"
        L3c:
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            com.opos.cmn.an.f.a.b(r0, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.service.pkginstall.b.e(java.lang.String):java.util.List");
    }

    private void e() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "unregisterPkgInstallBR sDownloadBRListenerId=" + this.f20336c);
        if (-1 != this.f20336c) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "really unregisterPkgInstallBR!!!");
            c.a().a(0, this.f20336c);
            this.f20336c = -1;
        }
    }

    public Set<InterfaceC0437b> f(String str) {
        Set<InterfaceC0437b> set;
        try {
            set = this.f20338e.get(str) != null ? this.f20338e.get(str) : new HashSet<>();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
            set = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getListenerMap pkgName=");
        sb.append(str);
        sb.append(",listenerMap.size=");
        sb.append(set != null ? Integer.valueOf(set.size()) : "null");
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
        return set;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (com.opos.cmn.an.h.d.a.a(r4.f20337d, "android.permission.SYSTEM_ALERT_WINDOW") != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean f() {
        /*
            r4 = this;
            java.lang.String r0 = "PkgInstallMgr"
            int r1 = com.opos.cmn.an.b.c.b()     // Catch: java.lang.Exception -> L16
            r2 = 19
            if (r1 >= r2) goto L14
            android.content.Context r1 = r4.f20337d     // Catch: java.lang.Exception -> L16
            java.lang.String r2 = "android.permission.SYSTEM_ALERT_WINDOW"
            boolean r1 = com.opos.cmn.an.h.d.a.a(r1, r2)     // Catch: java.lang.Exception -> L16
            if (r1 == 0) goto L1c
        L14:
            r1 = 1
            goto L1d
        L16:
            r1 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.a(r0, r2, r1)
        L1c:
            r1 = 0
        L1d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "hasAlertWindowPermission="
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            com.opos.cmn.an.f.a.b(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.service.pkginstall.b.f():boolean");
    }

    public void g(String str) {
        try {
            if (!com.opos.cmn.an.c.a.a(str)) {
                j(str);
                m(str);
                if (com.opos.cmn.an.h.a.a.d(this.f20337d)) {
                    i(str);
                } else {
                    a(str);
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
        }
    }

    private boolean h(String str) {
        boolean z = false;
        try {
            List<AdItemData> e2 = e(str);
            if (e2 != null && e2.size() > 0 && e2.get(0) != null && e2.get(0) != null) {
                z = e2.get(0).i().get(0).E();
            }
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e3);
        }
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "isGbClickToast pkgName=" + str + ",result=" + z);
        return z;
    }

    private void i(String str) {
        try {
            if (!com.opos.cmn.an.c.a.a(str)) {
                int k = k(str);
                Message obtainMessage = this.f20341h.obtainMessage(k);
                obtainMessage.obj = str;
                Bundle bundle = new Bundle();
                bundle.putBoolean("gbClick", h(str));
                obtainMessage.setData(bundle);
                if (2 == k) {
                    this.f20341h.post(new Runnable() { // from class: com.opos.mobad.cmn.service.pkginstall.b.3

                        /* renamed from: a */
                        final /* synthetic */ String f20345a;

                        AnonymousClass3(String str2) {
                            str = str2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(b.this.f20337d.getApplicationContext(), f.c(b.this.f20337d, str) + "已经安装完成", 0).show();
                        }
                    });
                    this.f20341h.sendMessageDelayed(obtainMessage, 2000L);
                } else {
                    this.f20341h.sendMessage(obtainMessage);
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
        }
    }

    private void j(String str) {
        List<AdItemData> e2;
        try {
            if (com.opos.cmn.an.c.a.a(str) || (e2 = e(str)) == null || e2.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < e2.size(); i2++) {
                if (e2.get(i2) != null && e2.get(i2) != null) {
                    AdItemData adItemData = e2.get(i2);
                    d.a(this.f20337d, adItemData, adItemData.i().get(0));
                }
            }
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e3);
        }
    }

    private int k(String str) {
        List<AdItemData> e2;
        try {
            if (com.opos.cmn.an.c.a.a(str) || (e2 = e(str)) == null || e2.size() <= 0 || e2.get(0) == null || e2.get(0) == null) {
                return 0;
            }
            return e2.get(0).i().get(0).C();
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e3);
            return 0;
        }
    }

    private String l(String str) {
        List<AdItemData> e2;
        String str2 = "";
        try {
            if (!com.opos.cmn.an.c.a.a(str) && (e2 = e(str)) != null && e2.size() > 0 && e2.get(0) != null && e2.get(0) != null) {
                str2 = e2.get(0).i().get(0).s();
            }
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e3);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getDeepLinkUrl pkgName=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(str2 != null ? str2 : "null");
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
        return str2;
    }

    private void m(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("notifyInstallCompletedEvent pkgName=");
            sb.append(str != null ? str : "null");
            com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
            this.f20341h.post(new Runnable() { // from class: com.opos.mobad.cmn.service.pkginstall.b.5

                /* renamed from: a */
                final /* synthetic */ String f20349a;

                AnonymousClass5(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Set<InterfaceC0437b> f2;
                    if (com.opos.cmn.an.c.a.a(str) || (f2 = b.this.f(str)) == null || f2.size() <= 0) {
                        return;
                    }
                    for (InterfaceC0437b interfaceC0437b : f2) {
                        com.opos.cmn.an.f.a.b("PkgInstallMgr", "notifyInstallCompletedEvent getListenerMap =" + interfaceC0437b);
                        if (interfaceC0437b != null) {
                            List e2 = b.this.e(str);
                            if (e2 == null || e2.size() <= 0 || e2.get(0) == null) {
                                com.opos.cmn.an.f.a.b("PkgInstallMgr", "notify but data empty");
                            } else {
                                com.opos.cmn.an.f.a.b("PkgInstallMgr", "notifyInstallCompletedEvent listener = " + interfaceC0437b);
                                interfaceC0437b.a((AdItemData) e2.get(0), str);
                            }
                        }
                    }
                }
            });
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
        }
    }

    public void a() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "exit");
        try {
            e();
            c();
            e eVar = this.f20339f;
            if (eVar != null) {
                eVar.b();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
        }
    }

    @Override // com.opos.cmn.e.a.c.a
    public void a(View view, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onToastShow pkgName=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",objects=");
        Object obj = objArr;
        if (objArr == null) {
            obj = "null";
        }
        sb.append(obj);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    @Override // com.opos.cmn.e.a.c.a
    public void a(View view, int[] iArr, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onToastClick pkgName=");
        sb.append(str != null ? str : "null");
        sb.append(",objects=");
        Object obj = objArr;
        if (objArr == null) {
            obj = "null";
        }
        sb.append(obj);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
        try {
            a(str, iArr);
            e eVar = this.f20339f;
            if (eVar != null) {
                eVar.a();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
        }
    }

    public void a(InterfaceC0437b interfaceC0437b) {
        if (interfaceC0437b != null) {
            Iterator<Set<InterfaceC0437b>> it = this.f20338e.snapshot().values().iterator();
            while (it.hasNext()) {
                it.next().remove(interfaceC0437b);
            }
        }
    }

    public void a(String str, InterfaceC0437b interfaceC0437b) {
        if (interfaceC0437b != null) {
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    d();
                    b(str, interfaceC0437b);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("addPkgInstallBRListener downloadPkgName=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",Listener=");
        sb.append(interfaceC0437b);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    public void a(String str, InterfaceC0437b interfaceC0437b, AdItemData adItemData) {
        if (interfaceC0437b != null && adItemData != null) {
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    d();
                    b(str, interfaceC0437b);
                    b(str, adItemData);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "addPkgInstallBRListener downloadPkgName=", str, "Listener=", interfaceC0437b, "adItemData=", adItemData);
    }

    public void a(String str, AdItemData adItemData) {
        if (adItemData != null) {
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    d();
                    b(str, adItemData);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "addPkgInstallBRListener downloadPkgName=", str, "adItemData=", adItemData);
    }

    @Override // com.opos.cmn.e.a.c.a
    public void b(View view, int[] iArr, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onToastClose pkgName=");
        sb.append(str != null ? str : "null");
        sb.append(",objects=");
        Object obj = objArr;
        if (objArr == null) {
            obj = "null";
        }
        sb.append(obj);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
        try {
            e eVar = this.f20339f;
            if (eVar != null) {
                eVar.a();
            }
            a(str);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e2);
        }
    }
}
