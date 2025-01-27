package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.cq;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public class ImprintHandler implements FileLockCallback {

    /* renamed from: a */
    private static final String f24632a = "ImprintHandler";

    /* renamed from: k */
    private static Context f24639k = null;

    /* renamed from: l */
    private static FileLockUtil f24640l = null;

    /* renamed from: m */
    private static final int f24641m = 0;

    /* renamed from: n */
    private static final int f24642n = 1;

    /* renamed from: e */
    private com.umeng.commonsdk.statistics.internal.d f24645e;

    /* renamed from: h */
    private a f24646h = new a();

    /* renamed from: i */
    private com.umeng.commonsdk.statistics.proto.d f24647i = null;

    /* renamed from: b */
    private static Object f24633b = new Object();

    /* renamed from: c */
    private static final String f24634c = bd.b().b(bd.f23523c);

    /* renamed from: d */
    private static final byte[] f24635d = "pbl0".getBytes();

    /* renamed from: f */
    private static Map<String, ArrayList<UMImprintChangeCallback>> f24636f = new HashMap();

    /* renamed from: g */
    private static Object f24637g = new Object();

    /* renamed from: j */
    private static ImprintHandler f24638j = null;

    /* renamed from: o */
    private static Map<String, UMImprintPreProcessCallback> f24643o = new HashMap();

    /* renamed from: p */
    private static Object f24644p = new Object();

    private ImprintHandler(Context context) {
        f24639k = context.getApplicationContext();
    }

    private static void a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (f24637g) {
            try {
                int i10 = 0;
                if (f24636f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f24636f.get(str);
                    int size = arrayList.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size);
                    while (i10 < size) {
                        if (uMImprintChangeCallback == arrayList.get(i10)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i10++;
                    }
                    arrayList.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
                } else {
                    ArrayList<UMImprintChangeCallback> arrayList2 = new ArrayList<>();
                    int size2 = arrayList2.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size2);
                    while (i10 < size2) {
                        if (uMImprintChangeCallback == arrayList2.get(i10)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i10++;
                    }
                    arrayList2.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                    f24636f.put(str, arrayList2);
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(f24639k, th2);
            }
        }
    }

    private static void b(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        synchronized (f24637g) {
            try {
                if (f24636f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f24636f.get(str);
                    if (arrayList.size() > 0) {
                        int size = arrayList.size();
                        ULog.i("--->>> removeCallback: before remove: callbacks size is: " + size);
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size) {
                                break;
                            }
                            if (uMImprintChangeCallback == arrayList.get(i10)) {
                                ULog.i("--->>> removeCallback: remove index " + i10);
                                arrayList.remove(i10);
                                break;
                            }
                            i10++;
                        }
                        ULog.i("--->>> removeCallback: after remove: callbacks size is: " + arrayList.size());
                        if (arrayList.size() == 0) {
                            ULog.i("--->>> removeCallback: remove key from map: key = " + str);
                            f24636f.remove(str);
                        }
                    }
                }
            } finally {
            }
        }
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (!dVar.i().equals(a(dVar))) {
            return false;
        }
        for (com.umeng.commonsdk.statistics.proto.e eVar : dVar.c().values()) {
            String h10 = eVar.h();
            if (!TextUtils.isEmpty(h10)) {
                byte[] reverseHexString = DataHelper.reverseHexString(h10);
                byte[] a10 = a(eVar);
                for (int i10 = 0; i10 < 4; i10++) {
                    if (reverseHexString[i10] != a10[i10]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.e> c10 = dVar.c();
        if (c10.containsKey(bt.f23610f)) {
            c10.remove(bt.f23610f);
            this.f24646h.a(bt.f23610f);
            dVar.a(dVar.f());
            dVar.a(a(dVar));
        }
        return dVar;
    }

    private com.umeng.commonsdk.statistics.proto.d e(com.umeng.commonsdk.statistics.proto.d dVar) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z10;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, com.umeng.commonsdk.statistics.proto.e> c10 = dVar.c();
        ArrayList<String> arrayList3 = new ArrayList(c10.size() / 2);
        Iterator<Map.Entry<String, com.umeng.commonsdk.statistics.proto.e>> it = c10.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> next = it.next();
            if (next.getValue().d()) {
                String key = next.getKey();
                String str = next.getValue().f24798a;
                synchronized (f24644p) {
                    try {
                        z10 = !TextUtils.isEmpty(key) && f24643o.containsKey(key) && (uMImprintPreProcessCallback = f24643o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                    } finally {
                    }
                }
                if (z10) {
                    arrayList3.add(key);
                }
                synchronized (f24637g) {
                    try {
                        if (!TextUtils.isEmpty(key) && f24636f.containsKey(key) && (arrayList2 = f24636f.get(key)) != null) {
                            for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                                arrayList2.get(i10).onImprintValueChanged(key, str);
                            }
                        }
                    } finally {
                    }
                }
            } else {
                arrayList3.add(next.getKey());
            }
        }
        for (String str2 : arrayList3) {
            synchronized (f24637g) {
                try {
                    if (!TextUtils.isEmpty(str2) && f24636f.containsKey(str2) && (arrayList = f24636f.get(str2)) != null) {
                        for (int i11 = 0; i11 < arrayList.size(); i11++) {
                            arrayList.get(i11).onImprintValueChanged(str2, null);
                        }
                    }
                } finally {
                }
            }
            c10.remove(str2);
        }
        return dVar;
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        ImprintHandler imprintHandler;
        synchronized (ImprintHandler.class) {
            try {
                if (f24638j == null) {
                    f24638j = new ImprintHandler(context);
                    f24640l = new FileLockUtil();
                    f24640l.doFileOperateion(new File(f24639k.getFilesDir(), f24634c), f24638j, 0);
                }
                imprintHandler = f24638j;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return imprintHandler;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        a(str, uMImprintChangeCallback);
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (TextUtils.isEmpty(str) || uMImprintPreProcessCallback == null) {
            return;
        }
        synchronized (f24644p) {
            try {
                if (f24643o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> key : " + str + " PreProcesser has registed!");
                } else {
                    f24643o.put(str, uMImprintPreProcessCallback);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> registPreProcessCallback: key : " + str + " regist success.");
                }
            } finally {
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        b(str, uMImprintChangeCallback);
    }

    public static class a {

        /* renamed from: a */
        private Map<String, String> f24648a = new HashMap();

        public a() {
        }

        private synchronized void b(com.umeng.commonsdk.statistics.proto.d dVar) {
            com.umeng.commonsdk.statistics.proto.e eVar;
            if (dVar != null) {
                if (dVar.e()) {
                    Map<String, com.umeng.commonsdk.statistics.proto.e> c10 = dVar.c();
                    for (String str : c10.keySet()) {
                        if (!TextUtils.isEmpty(str) && (eVar = c10.get(str)) != null) {
                            String b10 = eVar.b();
                            if (!TextUtils.isEmpty(b10)) {
                                this.f24648a.put(str, b10);
                                if (AnalyticsConstants.UM_DEBUG) {
                                    Log.i(ImprintHandler.f24632a, "imKey is " + str + ", imValue is " + b10);
                                }
                            }
                        }
                    }
                }
            }
        }

        public synchronized void a(String str) {
            Map<String, String> map = this.f24648a;
            if (map != null && map.size() > 0 && !TextUtils.isEmpty(str) && this.f24648a.containsKey(str)) {
                this.f24648a.remove(str);
            }
        }

        public a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar == null) {
                return;
            }
            b(dVar);
        }

        public synchronized String a(String str, String str2) {
            if (!TextUtils.isEmpty(str) && this.f24648a.size() > 0) {
                String str3 = this.f24648a.get(str);
                return !TextUtils.isEmpty(str3) ? str3 : str2;
            }
            return str2;
        }
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i10) {
        if (i10 == 0) {
            f24638j.e();
        } else if (i10 == 1) {
            f24638j.a(file);
        }
        return true;
    }

    public void d() {
        if (this.f24647i == null || f24640l == null) {
            return;
        }
        File file = new File(f24639k.getFilesDir(), f24634c);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                    file.createNewFile();
                }
            } catch (IOException e10) {
                UMCrashManager.reportCrash(f24639k, e10);
            }
        }
        f24640l.doFileOperateion(file, f24638j, 1);
    }

    public a c() {
        return this.f24646h;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        com.umeng.commonsdk.statistics.proto.d a10;
        boolean z10;
        if (dVar == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.d(UMRTLog.RTLOG_TAG, "Imprint is null");
                return;
            }
            return;
        }
        if (!c(dVar)) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "Imprint is not valid");
                return;
            }
            return;
        }
        boolean z11 = AnalyticsConstants.UM_DEBUG;
        HashMap hashMap = new HashMap();
        synchronized (this) {
            try {
                com.umeng.commonsdk.statistics.proto.d dVar2 = this.f24647i;
                com.umeng.commonsdk.statistics.proto.d d10 = d(dVar);
                String str = null;
                String i10 = dVar2 == null ? null : dVar2.i();
                if (dVar2 == null) {
                    a10 = e(d10);
                } else {
                    a10 = a(dVar2, d10, hashMap);
                }
                this.f24647i = a10;
                if (a10 != null) {
                    str = a10.i();
                }
                z10 = !a(i10, str);
            } finally {
            }
        }
        com.umeng.commonsdk.statistics.proto.d dVar3 = this.f24647i;
        if (dVar3 != null && z10) {
            this.f24646h.a(dVar3);
            com.umeng.commonsdk.statistics.internal.d dVar4 = this.f24645e;
            if (dVar4 != null) {
                dVar4.onImprintChanged(this.f24646h);
            }
        }
        if (hashMap.size() > 0) {
            synchronized (f24637g) {
                try {
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && f24636f.containsKey(key)) {
                            ULog.i("--->>> target imprint key is: " + key + "; value is: " + value);
                            ArrayList<UMImprintChangeCallback> arrayList = f24636f.get(key);
                            if (arrayList != null) {
                                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                                    arrayList.get(i11).onImprintValueChanged(key, value);
                                }
                            }
                        }
                    }
                } finally {
                }
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (f24644p) {
            try {
                if (f24643o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                    f24636f.remove(str);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            android.content.Context r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f24639k
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r2 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f24634c
            r0.<init>(r1, r2)
            java.lang.Object r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f24633b
            monitor-enter(r1)
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1a
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L18
            return
        L18:
            r0 = move-exception
            goto L61
        L1a:
            r0 = 0
            android.content.Context r3 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f24639k     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L32
            java.io.FileInputStream r2 = r3.openFileInput(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L32
            byte[] r0 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r2)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
        L25:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r2)     // Catch: java.lang.Throwable -> L18
            goto L38
        L29:
            r0 = move-exception
            goto L5d
        L2b:
            r3 = move-exception
            goto L34
        L2d:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
            goto L5d
        L32:
            r3 = move-exception
            r2 = r0
        L34:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L29
            goto L25
        L38:
            if (r0 == 0) goto L5b
            com.umeng.commonsdk.statistics.proto.d r2 = new com.umeng.commonsdk.statistics.proto.d     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            r2.<init>()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            com.umeng.analytics.pro.ck r3 = new com.umeng.analytics.pro.ck     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            r3.<init>()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            r3.a(r2, r0)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            r5.f24647i = r2     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a r0 = r5.f24646h     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            r0.a(r2)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            com.umeng.commonsdk.statistics.proto.d r0 = r5.f24647i     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            com.umeng.commonsdk.statistics.proto.d r0 = r5.d(r0)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            r5.f24647i = r0     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L57
            goto L5b
        L57:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L18
        L5b:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L18
            return
        L5d:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r2)     // Catch: java.lang.Throwable -> L18
            throw r0     // Catch: java.lang.Throwable -> L18
        L61:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L18
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.e():void");
    }

    public void a(com.umeng.commonsdk.statistics.internal.d dVar) {
        this.f24645e = dVar;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : new TreeMap(dVar.c()).entrySet()) {
            sb2.append((String) entry.getKey());
            if (((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).d()) {
                sb2.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).b());
            }
        }
        sb2.append(dVar.f24780b);
        return HelperUtils.MD5(sb2.toString()).toLowerCase(Locale.US);
    }

    public byte[] a(com.umeng.commonsdk.statistics.proto.e eVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(eVar.e());
        byte[] array = allocate.array();
        byte[] bArr = f24635d;
        byte[] bArr2 = new byte[4];
        for (int i10 = 0; i10 < 4; i10++) {
            bArr2[i10] = (byte) (array[i10] ^ bArr[i10]);
        }
        return bArr2;
    }

    public byte[] a() {
        try {
            synchronized (this) {
                try {
                    com.umeng.commonsdk.statistics.proto.d dVar = this.f24647i;
                    if (dVar == null) {
                        return null;
                    }
                    if (dVar.b() <= 0) {
                        return null;
                    }
                    return new cq().a(this.f24647i);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            UMCrashManager.reportCrash(f24639k, th3);
            return null;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d b() {
        return this.f24647i;
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, Map<String, String> map) {
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        ArrayList<UMImprintChangeCallback> arrayList;
        if (dVar2 == null) {
            return dVar;
        }
        Map<String, com.umeng.commonsdk.statistics.proto.e> c10 = dVar.c();
        for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar2.c().entrySet()) {
            int i10 = 0;
            if (entry.getValue().d()) {
                String key = entry.getKey();
                String str = entry.getValue().f24798a;
                synchronized (f24644p) {
                    try {
                        if (!TextUtils.isEmpty(key) && f24643o.containsKey(key) && (uMImprintPreProcessCallback = f24643o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                            i10 = 1;
                        }
                    } finally {
                    }
                }
                if (i10 == 0) {
                    c10.put(entry.getKey(), entry.getValue());
                    synchronized (f24637g) {
                        try {
                            if (!TextUtils.isEmpty(key) && f24636f.containsKey(key) && f24636f.get(key) != null) {
                                map.put(key, str);
                            }
                        } finally {
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                String key2 = entry.getKey();
                synchronized (f24637g) {
                    try {
                        if (!TextUtils.isEmpty(key2) && f24636f.containsKey(key2) && (arrayList = f24636f.get(key2)) != null) {
                            while (i10 < arrayList.size()) {
                                arrayList.get(i10).onImprintValueChanged(key2, null);
                                i10++;
                            }
                        }
                    } finally {
                    }
                }
                c10.remove(key2);
                this.f24646h.a(key2);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private void a(File file) {
        if (this.f24647i == null) {
            return;
        }
        try {
            synchronized (f24633b) {
                try {
                    byte[] a10 = new cq().a(this.f24647i);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(a10);
                        fileOutputStream.flush();
                    } finally {
                        HelperUtils.safeClose(fileOutputStream);
                    }
                } finally {
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
