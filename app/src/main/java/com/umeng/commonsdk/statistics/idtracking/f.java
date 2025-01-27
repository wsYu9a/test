package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.shu.priory.config.AdKeys;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cq;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    public static final long f24664a = 86400000;

    /* renamed from: b */
    public static f f24665b;

    /* renamed from: c */
    private static final String f24666c = bd.b().b("id");

    /* renamed from: j */
    private static Object f24667j = new Object();

    /* renamed from: d */
    private File f24668d;

    /* renamed from: f */
    private long f24670f;

    /* renamed from: i */
    private a f24673i;

    /* renamed from: e */
    private com.umeng.commonsdk.statistics.proto.c f24669e = null;

    /* renamed from: h */
    private Set<com.umeng.commonsdk.statistics.idtracking.a> f24672h = new HashSet();

    /* renamed from: g */
    private long f24671g = 86400000;

    public static class a {

        /* renamed from: a */
        private Context f24674a;

        /* renamed from: b */
        private Set<String> f24675b = new HashSet();

        public a(Context context) {
            this.f24674a = context;
        }

        public synchronized boolean a(String str) {
            return !this.f24675b.contains(str);
        }

        public synchronized void b(String str) {
            this.f24675b.add(str);
        }

        public void c(String str) {
            this.f24675b.remove(str);
        }

        public synchronized void a() {
            try {
                if (!this.f24675b.isEmpty()) {
                    StringBuilder sb2 = new StringBuilder();
                    Iterator<String> it = this.f24675b.iterator();
                    while (it.hasNext()) {
                        sb2.append(it.next());
                        sb2.append(',');
                    }
                    sb2.deleteCharAt(sb2.length() - 1);
                    PreferenceWrapper.getDefault(this.f24674a).edit().putString("invld_id", sb2.toString()).commit();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }

        public synchronized void b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.f24674a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f24675b.add(str);
                    }
                }
            }
        }
    }

    public f(Context context) {
        this.f24673i = null;
        this.f24668d = new File(context.getFilesDir(), f24666c);
        a aVar = new a(context);
        this.f24673i = aVar;
        aVar.b();
    }

    public static synchronized void a() {
        synchronized (f.class) {
            f fVar = f24665b;
            if (fVar != null) {
                fVar.e();
                f24665b = null;
            }
        }
    }

    private synchronized void h() {
        try {
            com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f24672h) {
                if (aVar.c()) {
                    if (aVar.d() != null) {
                        hashMap.put(aVar.b(), aVar.d());
                    }
                    if (aVar.e() != null && !aVar.e().isEmpty()) {
                        arrayList.addAll(aVar.e());
                    }
                }
            }
            cVar.a(arrayList);
            cVar.a(hashMap);
            synchronized (this) {
                this.f24669e = cVar;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        Throwable th2;
        FileInputStream fileInputStream;
        synchronized (f24667j) {
            if (!this.f24668d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.f24668d);
            } catch (Exception e10) {
                e = e10;
                fileInputStream = null;
            } catch (Throwable th3) {
                th2 = th3;
                fileInputStream = null;
                HelperUtils.safeClose(fileInputStream);
                throw th2;
            }
            try {
                try {
                    byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                    com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                    new ck().a(cVar, readStreamToByteArray);
                    HelperUtils.safeClose(fileInputStream);
                    return cVar;
                } catch (Throwable th4) {
                    th2 = th4;
                    HelperUtils.safeClose(fileInputStream);
                    throw th2;
                }
            } catch (Exception e11) {
                e = e11;
                e.printStackTrace();
                HelperUtils.safeClose(fileInputStream);
                return null;
            }
        }
    }

    public synchronized void b() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f24670f >= this.f24671g) {
                boolean z10 = false;
                for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f24672h) {
                    if (aVar.c() && aVar.a()) {
                        if (!aVar.c()) {
                            this.f24673i.b(aVar.b());
                        }
                        z10 = true;
                    }
                }
                if (z10) {
                    h();
                    this.f24673i.a();
                    g();
                }
                this.f24670f = currentTimeMillis;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.f24669e;
    }

    public String d() {
        return null;
    }

    public synchronized void e() {
        try {
            if (f24665b == null) {
                return;
            }
            boolean z10 = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f24672h) {
                if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                    aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                    z10 = true;
                }
            }
            if (z10) {
                this.f24669e.b(false);
                g();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c i10 = i();
        if (i10 == null) {
            return;
        }
        a(i10);
        ArrayList arrayList = new ArrayList(this.f24672h.size());
        synchronized (this) {
            try {
                this.f24669e = i10;
                for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f24672h) {
                    aVar.a(this.f24669e);
                    if (!aVar.c()) {
                        arrayList.add(aVar);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f24672h.remove((com.umeng.commonsdk.statistics.idtracking.a) it.next());
                }
                h();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public synchronized void g() {
        com.umeng.commonsdk.statistics.proto.c cVar = this.f24669e;
        if (cVar != null) {
            b(cVar);
        }
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            try {
                if (f24665b == null) {
                    f fVar2 = new f(context);
                    f24665b = fVar2;
                    fVar2.a(new g(context));
                    f24665b.a(new b(context));
                    f24665b.a(new k(context));
                    f24665b.a(new e(context));
                    f24665b.a(new d(context));
                    f24665b.a(new h(context));
                    f24665b.a(new j());
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                        f24665b.a(new i(context));
                        if (DeviceConfig.isHonorDevice()) {
                            f24665b.a(new c(context));
                        }
                    }
                    f24665b.f();
                }
                fVar = f24665b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fVar;
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] a10;
        synchronized (f24667j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        a10 = new cq().a(cVar);
                    }
                    if (a10 != null) {
                        HelperUtils.writeFile(this.f24668d, a10);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.f24673i.a(aVar.b())) {
            return this.f24672h.add(aVar);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    public void a(long j10) {
        this.f24671g = j10;
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map;
        if (cVar == null || (map = cVar.f24760a) == null) {
            return;
        }
        if (map.containsKey("mac") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f24851h)) {
            cVar.f24760a.remove("mac");
        }
        if (cVar.f24760a.containsKey("imei") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f24850g)) {
            cVar.f24760a.remove("imei");
        }
        if (cVar.f24760a.containsKey("android_id") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f24852i)) {
            cVar.f24760a.remove("android_id");
        }
        if (cVar.f24760a.containsKey("serial") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f24853j)) {
            cVar.f24760a.remove("serial");
        }
        if (cVar.f24760a.containsKey("idfa") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f24866w)) {
            cVar.f24760a.remove("idfa");
        }
        if (!cVar.f24760a.containsKey(AdKeys.OAID) || FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return;
        }
        cVar.f24760a.remove(AdKeys.OAID);
    }
}
