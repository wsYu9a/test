package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.ay;
import com.umeng.analytics.pro.be;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
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
public class e {

    /* renamed from: a */
    public static final long f26339a = 86400000;

    /* renamed from: b */
    public static e f26340b = null;

    /* renamed from: c */
    private static final String f26341c = "umeng_it.cache";

    /* renamed from: j */
    private static Object f26342j = new Object();

    /* renamed from: d */
    private File f26343d;

    /* renamed from: f */
    private long f26345f;

    /* renamed from: i */
    private a f26348i;

    /* renamed from: e */
    private com.umeng.commonsdk.statistics.proto.c f26344e = null;

    /* renamed from: h */
    private Set<com.umeng.commonsdk.statistics.idtracking.a> f26347h = new HashSet();

    /* renamed from: g */
    private long f26346g = 86400000;

    public static class a {

        /* renamed from: a */
        private Context f26349a;

        /* renamed from: b */
        private Set<String> f26350b = new HashSet();

        public a(Context context) {
            this.f26349a = context;
        }

        public synchronized boolean a(String str) {
            return !this.f26350b.contains(str);
        }

        public synchronized void b(String str) {
            this.f26350b.add(str);
        }

        public void c(String str) {
            this.f26350b.remove(str);
        }

        public synchronized void a() {
            if (!this.f26350b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = this.f26350b.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.f26349a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized void b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.f26349a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f26350b.add(str);
                    }
                }
            }
        }
    }

    e(Context context) {
        this.f26348i = null;
        this.f26343d = new File(context.getFilesDir(), f26341c);
        a aVar = new a(context);
        this.f26348i = aVar;
        aVar.b();
    }

    public static synchronized void a() {
        synchronized (e.class) {
            e eVar = f26340b;
            if (eVar != null) {
                eVar.e();
                f26340b = null;
            }
        }
    }

    private synchronized void h() {
        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f26347h) {
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
            this.f26344e = cVar;
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (f26342j) {
            if (!this.f26343d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.f26343d);
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                HelperUtils.safeClose(fileInputStream);
                throw th;
            }
            try {
                try {
                    byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                    com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                    new ay().a(cVar, readStreamToByteArray);
                    HelperUtils.safeClose(fileInputStream);
                    return cVar;
                } catch (Throwable th3) {
                    th = th3;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                HelperUtils.safeClose(fileInputStream);
                return null;
            }
        }
    }

    public synchronized void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f26345f >= this.f26346g) {
            boolean z = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f26347h) {
                if (aVar.c() && aVar.a()) {
                    z = true;
                    if (!aVar.c()) {
                        this.f26348i.b(aVar.b());
                    }
                }
            }
            if (z) {
                h();
                this.f26348i.a();
                g();
            }
            this.f26345f = currentTimeMillis;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.f26344e;
    }

    public String d() {
        return null;
    }

    public synchronized void e() {
        if (f26340b == null) {
            return;
        }
        boolean z = false;
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f26347h) {
            if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                z = true;
            }
        }
        if (z) {
            this.f26344e.b(false);
            g();
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c i2 = i();
        if (i2 == null) {
            return;
        }
        a(i2);
        ArrayList arrayList = new ArrayList(this.f26347h.size());
        synchronized (this) {
            this.f26344e = i2;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.f26347h) {
                aVar.a(this.f26344e);
                if (!aVar.c()) {
                    arrayList.add(aVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f26347h.remove((com.umeng.commonsdk.statistics.idtracking.a) it.next());
            }
            h();
        }
    }

    public synchronized void g() {
        com.umeng.commonsdk.statistics.proto.c cVar = this.f26344e;
        if (cVar != null) {
            b(cVar);
        }
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (f26340b == null) {
                e eVar2 = new e(context);
                f26340b = eVar2;
                eVar2.a(new f(context));
                f26340b.a(new b(context));
                f26340b.a(new j(context));
                f26340b.a(new d(context));
                f26340b.a(new c(context));
                f26340b.a(new g(context));
                f26340b.a(new i());
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                    f26340b.a(new h(context));
                }
                f26340b.f();
            }
            eVar = f26340b;
        }
        return eVar;
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] a2;
        synchronized (f26342j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        a2 = new be().a(cVar);
                    }
                    if (a2 != null) {
                        HelperUtils.writeFile(this.f26343d, a2);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.f26348i.a(aVar.b())) {
            return this.f26347h.add(aVar);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    public void a(long j2) {
        this.f26346g = j2;
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map;
        if (cVar == null || (map = cVar.f26427a) == null) {
            return;
        }
        if (map.containsKey("mac") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f26501h)) {
            cVar.f26427a.remove("mac");
        }
        if (cVar.f26427a.containsKey("imei") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f26500g)) {
            cVar.f26427a.remove("imei");
        }
        if (cVar.f26427a.containsKey("android_id") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f26502i)) {
            cVar.f26427a.remove("android_id");
        }
        if (cVar.f26427a.containsKey("serial") && !FieldManager.allow(com.umeng.commonsdk.utils.d.f26503j)) {
            cVar.f26427a.remove("serial");
        }
        if (cVar.f26427a.containsKey("idfa") && !FieldManager.allow(com.umeng.commonsdk.utils.d.w)) {
            cVar.f26427a.remove("idfa");
        }
        if (!cVar.f26427a.containsKey("oaid") || FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return;
        }
        cVar.f26427a.remove("oaid");
    }
}
