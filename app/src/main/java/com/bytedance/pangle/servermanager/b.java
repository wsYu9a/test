package com.bytedance.pangle.servermanager;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.c;
import com.bytedance.pangle.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    private static final Object f7786a = new Object();

    /* renamed from: b */
    private static final Object f7787b = new Object();

    /* renamed from: c */
    private static final Object f7788c = new Object();

    /* renamed from: d */
    private static final Map<String, Boolean> f7789d = new ConcurrentHashMap();

    /* renamed from: e */
    private static final Map<String, e> f7790e = new ConcurrentHashMap();

    /* renamed from: f */
    private static c f7791f;

    /* renamed from: com.bytedance.pangle.servermanager.b$1 */
    public static class AnonymousClass1 implements IBinder.DeathRecipient {

        /* renamed from: a */
        final /* synthetic */ String f7792a;

        /* renamed from: b */
        final /* synthetic */ IBinder f7793b;

        public AnonymousClass1(String str, IBinder iBinder) {
            r1 = str;
            r2 = iBinder;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            b.f7789d.put(r1, Boolean.FALSE);
            ZeusLogger.w(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
            HashMap<ServiceConnection, HashSet<ComponentName>> hashMap = ServiceManagerNative.getInstance().process2ConnAndService.get(r2);
            if (hashMap != null) {
                for (ServiceConnection serviceConnection : hashMap.keySet()) {
                    Iterator<ComponentName> it = hashMap.get(serviceConnection).iterator();
                    while (it.hasNext()) {
                        serviceConnection.onServiceDisconnected(it.next());
                    }
                }
            }
        }
    }

    public static e a(String str) {
        Boolean bool = f7789d.get(str);
        if (bool == null || !bool.booleanValue()) {
            f7790e.remove(str);
        }
        Map<String, e> map = f7790e;
        if (map.get(str) == null) {
            synchronized (f7787b) {
                try {
                    e eVar = (e) a(NotificationCompat.CATEGORY_SERVICE, str);
                    if (eVar == null) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                        return null;
                    }
                    map.put(str, eVar);
                } finally {
                }
            }
        }
        return map.get(str);
    }

    public static c a() {
        Boolean bool = f7789d.get("main");
        if (bool == null || !bool.booleanValue()) {
            f7791f = null;
        }
        if (f7791f == null) {
            synchronized (f7788c) {
                try {
                    c cVar = (c) a("package", "main");
                    if (cVar == null) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                        return null;
                    }
                    f7791f = cVar;
                } finally {
                }
            }
        }
        return f7791f;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0096 A[Catch: RemoteException -> 0x0080, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x0080, blocks: (B:14:0x0056, B:23:0x0091, B:26:0x0096, B:28:0x0076, B:31:0x0082), top: B:13:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0082 A[Catch: RemoteException -> 0x0080, TryCatch #0 {RemoteException -> 0x0080, blocks: (B:14:0x0056, B:23:0x0091, B:26:0x0096, B:28:0x0076, B:31:0x0082), top: B:13:0x0056 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.os.IInterface a(java.lang.String r5, java.lang.String r6) {
        /*
            boolean r0 = com.bytedance.pangle.Zeus.hasInit()
            if (r0 == 0) goto Lb3
            java.util.HashMap r0 = com.bytedance.pangle.Zeus.getServerManagerHashMap()
            java.lang.Object r0 = r0.get(r6)
            android.content.pm.ProviderInfo r0 = (android.content.pm.ProviderInfo) r0
            if (r0 == 0) goto La3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "content://"
            r1.<init>(r2)
            java.lang.String r0 = r0.authority
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.app.Application r1 = com.bytedance.pangle.Zeus.getAppApplication()
            android.content.ContentResolver r1 = r1.getContentResolver()
            java.lang.String r2 = "query_binder"
            r3 = 0
            android.os.Bundle r0 = r1.call(r0, r2, r5, r3)
            if (r0 == 0) goto L4d
            java.lang.Class<com.bytedance.pangle.servermanager.AbsServerManager> r1 = com.bytedance.pangle.servermanager.AbsServerManager.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            java.lang.String r1 = "binder"
            android.os.Parcelable r0 = r0.getParcelable(r1)
            com.bytedance.pangle.servermanager.a r0 = (com.bytedance.pangle.servermanager.a) r0
            if (r0 == 0) goto L4d
            android.os.IBinder r0 = r0.f7785a
            goto L4e
        L4d:
            r0 = r3
        L4e:
            if (r0 == 0) goto La2
            boolean r1 = r0.isBinderAlive()
            if (r1 == 0) goto La2
            com.bytedance.pangle.servermanager.b$1 r1 = new com.bytedance.pangle.servermanager.b$1     // Catch: android.os.RemoteException -> L80
            r1.<init>()     // Catch: android.os.RemoteException -> L80
            r2 = 0
            r0.linkToDeath(r1, r2)     // Catch: android.os.RemoteException -> L80
            java.util.Map<java.lang.String, java.lang.Boolean> r1 = com.bytedance.pangle.servermanager.b.f7789d     // Catch: android.os.RemoteException -> L80
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch: android.os.RemoteException -> L80
            r1.put(r6, r4)     // Catch: android.os.RemoteException -> L80
            int r6 = r5.hashCode()     // Catch: android.os.RemoteException -> L80
            r1 = -807062458(0xffffffffcfe53446, float:-7.6908165E9)
            r4 = 1
            if (r6 == r1) goto L82
            r1 = 1984153269(0x7643c6b5, float:9.927033E32)
            if (r6 == r1) goto L76
            goto L8b
        L76:
            java.lang.String r6 = "service"
            boolean r5 = r5.equals(r6)     // Catch: android.os.RemoteException -> L80
            if (r5 == 0) goto L8b
            r2 = 1
            goto L8c
        L80:
            r5 = move-exception
            goto L9b
        L82:
            java.lang.String r6 = "package"
            boolean r5 = r5.equals(r6)     // Catch: android.os.RemoteException -> L80
            if (r5 == 0) goto L8b
            goto L8c
        L8b:
            r2 = -1
        L8c:
            if (r2 == 0) goto L96
            if (r2 == r4) goto L91
            goto La2
        L91:
            com.bytedance.pangle.e r5 = com.bytedance.pangle.e.a.a(r0)     // Catch: android.os.RemoteException -> L80
            return r5
        L96:
            com.bytedance.pangle.c r5 = com.bytedance.pangle.c.a.a(r0)     // Catch: android.os.RemoteException -> L80
            return r5
        L9b:
            java.lang.String r6 = "Zeus/server_pangle"
            java.lang.String r0 = "generateServerManager failed."
            com.bytedance.pangle.log.ZeusLogger.errReport(r6, r0, r5)
        La2:
            return r3
        La3:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r0 = "宿主中没有找对对应进程的serverManager "
            java.lang.String r6 = r0.concat(r6)
            r5.<init>(r6)
            throw r5
        Lb3:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r0 = "generateServerManager 请先初始化Zeus, processName:"
            java.lang.String r6 = r0.concat(r6)
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.servermanager.b.a(java.lang.String, java.lang.String):android.os.IInterface");
    }
}
