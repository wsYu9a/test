package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.martian.rpauth.MartianRPUserManager;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.t;
import com.vivo.push.util.w;
import com.vivo.push.util.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a */
    private static volatile e f30997a;

    /* renamed from: h */
    private Context f31004h;

    /* renamed from: j */
    private com.vivo.push.util.b f31006j;
    private String k;
    private String l;
    private Boolean o;
    private Long p;
    private boolean q;
    private int s;

    /* renamed from: b */
    private long f30998b = -1;

    /* renamed from: c */
    private long f30999c = -1;

    /* renamed from: d */
    private long f31000d = -1;

    /* renamed from: e */
    private long f31001e = -1;

    /* renamed from: f */
    private long f31002f = -1;

    /* renamed from: g */
    private long f31003g = -1;

    /* renamed from: i */
    private boolean f31005i = true;
    private SparseArray<a> m = new SparseArray<>();
    private int n = 0;
    private IPushClientFactory r = new d();

    private e() {
    }

    public void m() {
        this.l = null;
        this.f31006j.b("APP_ALIAS");
    }

    private boolean n() {
        if (this.o == null) {
            this.o = Boolean.valueOf(l() >= 1230 && z.d(this.f31004h));
        }
        return this.o.booleanValue();
    }

    public final boolean d() {
        if (this.f31004h == null) {
            com.vivo.push.util.p.d("PushClientManager", "support:context is null");
            return false;
        }
        Boolean valueOf = Boolean.valueOf(n());
        this.o = valueOf;
        return valueOf.booleanValue();
    }

    public final boolean e() {
        return this.q;
    }

    public final String f() {
        if (!TextUtils.isEmpty(this.k)) {
            return this.k;
        }
        com.vivo.push.util.b bVar = this.f31006j;
        String b2 = bVar != null ? bVar.b("APP_TOKEN", (String) null) : "";
        c(b2);
        return b2;
    }

    public final boolean g() {
        return this.f31005i;
    }

    public final Context h() {
        return this.f31004h;
    }

    public final void i() {
        this.f31006j.a();
    }

    public final String j() {
        return this.l;
    }

    public final int k() {
        return this.s;
    }

    public final long l() {
        Context context = this.f31004h;
        if (context == null) {
            return -1L;
        }
        if (this.p == null) {
            this.p = Long.valueOf(z.a(context));
        }
        return this.p.longValue();
    }

    public void e(String str) {
        m.a(new k(this, str));
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (f30997a == null) {
                f30997a = new e();
            }
            eVar = f30997a;
        }
        return eVar;
    }

    protected final void b() throws VivoPushException {
        Context context = this.f31004h;
        if (context != null) {
            z.b(context);
        }
    }

    public final List<String> c() {
        String b2 = this.f31006j.b("APP_TAGS", (String) null);
        ArrayList arrayList = new ArrayList();
        try {
        } catch (JSONException unused) {
            this.f31006j.b("APP_TAGS");
            arrayList.clear();
            com.vivo.push.util.p.d("PushClientManager", "getTags error");
        }
        if (TextUtils.isEmpty(b2)) {
            return arrayList;
        }
        Iterator<String> keys = new JSONObject(b2).keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    public static class a {

        /* renamed from: a */
        private IPushActionListener f31009a;

        /* renamed from: b */
        private com.vivo.push.b.c f31010b;

        /* renamed from: c */
        private IPushActionListener f31011c;

        /* renamed from: d */
        private Runnable f31012d;

        /* renamed from: e */
        private Object[] f31013e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            this.f31010b = cVar;
            this.f31009a = iPushActionListener;
        }

        public final void a(int i2, Object... objArr) {
            this.f31013e = objArr;
            IPushActionListener iPushActionListener = this.f31011c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i2);
            }
            IPushActionListener iPushActionListener2 = this.f31009a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i2);
            }
        }

        public final Object[] b() {
            return this.f31013e;
        }

        public final void a(Runnable runnable) {
            this.f31012d = runnable;
        }

        public final void a() {
            Runnable runnable = this.f31012d;
            if (runnable == null) {
                com.vivo.push.util.p.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.f31011c = iPushActionListener;
        }
    }

    public synchronized a d(String str) {
        if (str != null) {
            try {
                int parseInt = Integer.parseInt(str);
                a aVar = this.m.get(parseInt);
                this.m.delete(parseInt);
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final void b(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String b2 = this.f31006j.b("APP_TAGS", (String) null);
            if (TextUtils.isEmpty(b2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(b2);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.remove(it.next());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                this.f31006j.b("APP_TAGS");
            } else {
                this.f31006j.a("APP_TAGS", jSONObject2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f31006j.b("APP_TAGS");
        }
    }

    public final synchronized void a(Context context) {
        if (this.f31004h == null) {
            this.f31004h = ContextDelegate.getContext(context);
            this.q = t.c(context, context.getPackageName());
            w.b().a(this.f31004h);
            a(new com.vivo.push.b.g());
            com.vivo.push.util.b bVar = new com.vivo.push.util.b();
            this.f31006j = bVar;
            bVar.a(this.f31004h, "com.vivo.push_preferences.appconfig_v1");
            this.k = f();
            this.l = this.f31006j.b("APP_ALIAS", (String) null);
        }
    }

    public final void c(List<String> list) {
        if (list.contains(this.l)) {
            m();
        }
    }

    private void c(String str) {
        m.c(new f(this, str));
    }

    public final void a(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String b2 = this.f31006j.b("APP_TAGS", (String) null);
            if (TextUtils.isEmpty(b2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(b2);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.put(it.next(), System.currentTimeMillis());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                this.f31006j.b("APP_TAGS");
            } else {
                this.f31006j.a("APP_TAGS", jSONObject2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f31006j.b("APP_TAGS");
        }
    }

    final void b(IPushActionListener iPushActionListener) {
        if (this.f31004h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if ("".equals(this.k)) {
            iPushActionListener.onStateChanged(0);
            return;
        }
        if (!a(this.f30999c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f30999c = SystemClock.elapsedRealtime();
        String packageName = this.f31004h.getPackageName();
        a aVar = null;
        if (this.f31004h != null) {
            com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, packageName);
            bVar.d();
            bVar.e();
            bVar.g();
            bVar.a(100);
            if (this.q) {
                if (n()) {
                    aVar = new a(bVar, iPushActionListener);
                    String a2 = a(aVar);
                    bVar.b(a2);
                    aVar.a(new j(this, bVar, a2));
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else if (bVar.a(this.f31004h) == 2) {
                aVar = a(bVar, iPushActionListener);
            } else {
                a(bVar);
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
        if (aVar == null) {
            return;
        }
        aVar.a(new i(this));
        aVar.a();
    }

    public final void a(String str) {
        this.k = str;
        this.f31006j.a("APP_TOKEN", str);
    }

    protected final void a(boolean z) {
        this.f31005i = z;
    }

    final void a(IPushActionListener iPushActionListener) {
        if (this.f31004h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        String f2 = f();
        this.k = f2;
        if (!TextUtils.isEmpty(f2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (!a(this.f30998b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f30998b = SystemClock.elapsedRealtime();
        String packageName = this.f31004h.getPackageName();
        a aVar = null;
        if (this.f31004h != null) {
            com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
            bVar.g();
            bVar.d();
            bVar.e();
            bVar.a(100);
            if (this.q) {
                if (n()) {
                    aVar = a(bVar, iPushActionListener);
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else if (bVar.a(this.f31004h) == 2) {
                aVar = a(bVar, iPushActionListener);
            } else {
                a(bVar);
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
        if (aVar == null) {
            return;
        }
        aVar.a(new g(this, aVar));
        aVar.a();
    }

    final void b(String str, IPushActionListener iPushActionListener) {
        if (this.f31004h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.l)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.f31004h.getPackageName(), arrayList);
        aVar.a(100);
        if (this.q) {
            if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            }
            if (!a(this.f31001e)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            }
            this.f31001e = SystemClock.elapsedRealtime();
            String a2 = a(new a(aVar, iPushActionListener));
            aVar.b(a2);
            if (TextUtils.isEmpty(this.k)) {
                a(a2, 30001);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                a(a2, 30002);
                return;
            } else if (str.length() > 70) {
                a(a2, 30003);
                return;
            } else {
                a(aVar);
                e(a2);
                return;
            }
        }
        a(aVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    private a a(com.vivo.push.b.b bVar, IPushActionListener iPushActionListener) {
        a aVar = new a(bVar, iPushActionListener);
        String a2 = a(aVar);
        bVar.b(a2);
        aVar.a(new h(this, bVar, a2));
        return aVar;
    }

    public final void a(String str, int i2, Object... objArr) {
        a d2 = d(str);
        if (d2 != null) {
            d2.a(i2, objArr);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyApp token is null");
        }
    }

    final void a(String str, IPushActionListener iPushActionListener) {
        if (this.f31004h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(this.l) && this.l.equals(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, this.f31004h.getPackageName(), arrayList);
        aVar.a(100);
        if (this.q) {
            if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            }
            if (!a(this.f31000d)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            }
            this.f31000d = SystemClock.elapsedRealtime();
            String a2 = a(new a(aVar, iPushActionListener));
            aVar.b(a2);
            if (TextUtils.isEmpty(this.k)) {
                a(a2, 30001);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                a(a2, 30002);
                return;
            } else if (str.length() > 70) {
                a(a2, 30003);
                return;
            } else {
                a(aVar);
                e(a2);
                return;
            }
        }
        a(aVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    public final void b(String str) {
        this.l = str;
        this.f31006j.a("APP_ALIAS", str);
    }

    final void b(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.f31004h;
        if (context == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(false, context.getPackageName(), arrayList);
        zVar.a(500);
        if (this.q) {
            if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            }
            if (!a(this.f31003g)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            }
            this.f31003g = SystemClock.elapsedRealtime();
            String a2 = a(new a(zVar, iPushActionListener));
            zVar.b(a2);
            if (TextUtils.isEmpty(this.k)) {
                a(a2, MartianRPUserManager.f14923j);
                return;
            }
            if (arrayList.size() < 0) {
                a(a2, 20002);
                return;
            }
            if (arrayList.size() > 500) {
                a(a2, 20004);
                return;
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().length() > 70) {
                    a(a2, 20003);
                    return;
                }
            }
            a(zVar);
            e(a2);
            return;
        }
        a(zVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    private static boolean a(long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j2 == -1 || elapsedRealtime <= j2 || elapsedRealtime >= j2 + 2000;
    }

    public final void a(String str, int i2) {
        a d2 = d(str);
        if (d2 != null) {
            d2.a(i2, new Object[0]);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    private synchronized String a(a aVar) {
        int i2;
        this.m.put(this.n, aVar);
        i2 = this.n;
        this.n = i2 + 1;
        return Integer.toString(i2);
    }

    final void a(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.f31004h;
        if (context == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(true, context.getPackageName(), arrayList);
        zVar.a(500);
        if (this.q) {
            if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            }
            if (!a(this.f31002f)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            }
            this.f31002f = SystemClock.elapsedRealtime();
            String a2 = a(new a(zVar, iPushActionListener));
            zVar.b(a2);
            if (TextUtils.isEmpty(this.k)) {
                a(a2, MartianRPUserManager.f14923j);
                return;
            }
            if (arrayList.size() < 0) {
                a(a2, 20002);
                return;
            }
            if (arrayList.size() + c().size() > 500) {
                a(a2, 20004);
                return;
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().length() > 70) {
                    a(a2, 20003);
                    return;
                }
            }
            a(zVar);
            e(a2);
            return;
        }
        a(zVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    public final void a(Intent intent, PushMessageCallback pushMessageCallback) {
        o createReceiverCommand = this.r.createReceiverCommand(intent);
        Context context = a().f31004h;
        if (createReceiverCommand == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        com.vivo.push.d.z createReceiveTask = this.r.createReceiveTask(createReceiverCommand);
        if (createReceiveTask == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(createReceiverCommand)));
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
                return;
            }
            return;
        }
        if (context != null && !(createReceiverCommand instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.p.a(context, "[接收指令]".concat(String.valueOf(createReceiverCommand)));
        }
        createReceiveTask.a(pushMessageCallback);
        m.a((l) createReceiveTask);
    }

    public final void a(o oVar) {
        Context context = a().f31004h;
        if (oVar == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        l createTask = this.r.createTask(oVar);
        if (createTask == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(oVar)));
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令" + oVar + "任务空！");
                return;
            }
            return;
        }
        com.vivo.push.util.p.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(oVar)));
        m.a(createTask);
    }
}
