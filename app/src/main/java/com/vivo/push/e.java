package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.martian.mibook.lib.account.MiUserManager;
import com.sigmob.sdk.base.common.y;
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
    private static volatile e f25024a;

    /* renamed from: h */
    private Context f25031h;

    /* renamed from: j */
    private com.vivo.push.util.b f25033j;

    /* renamed from: k */
    private String f25034k;

    /* renamed from: l */
    private String f25035l;

    /* renamed from: o */
    private Boolean f25038o;

    /* renamed from: p */
    private Long f25039p;

    /* renamed from: q */
    private boolean f25040q;

    /* renamed from: s */
    private int f25042s;

    /* renamed from: b */
    private long f25025b = -1;

    /* renamed from: c */
    private long f25026c = -1;

    /* renamed from: d */
    private long f25027d = -1;

    /* renamed from: e */
    private long f25028e = -1;

    /* renamed from: f */
    private long f25029f = -1;

    /* renamed from: g */
    private long f25030g = -1;

    /* renamed from: i */
    private boolean f25032i = true;

    /* renamed from: m */
    private SparseArray<a> f25036m = new SparseArray<>();

    /* renamed from: n */
    private int f25037n = 0;

    /* renamed from: r */
    private IPushClientFactory f25041r = new d();

    private e() {
    }

    public void m() {
        this.f25035l = null;
        this.f25033j.b("APP_ALIAS");
    }

    private boolean n() {
        if (this.f25038o == null) {
            this.f25038o = Boolean.valueOf(l() >= 1230 && z.d(this.f25031h));
        }
        return this.f25038o.booleanValue();
    }

    public final boolean d() {
        if (this.f25031h == null) {
            com.vivo.push.util.p.d("PushClientManager", "support:context is null");
            return false;
        }
        Boolean valueOf = Boolean.valueOf(n());
        this.f25038o = valueOf;
        return valueOf.booleanValue();
    }

    public final boolean e() {
        return this.f25040q;
    }

    public final String f() {
        if (!TextUtils.isEmpty(this.f25034k)) {
            return this.f25034k;
        }
        com.vivo.push.util.b bVar = this.f25033j;
        String b10 = bVar != null ? bVar.b("APP_TOKEN", (String) null) : "";
        c(b10);
        return b10;
    }

    public final boolean g() {
        return this.f25032i;
    }

    public final Context h() {
        return this.f25031h;
    }

    public final void i() {
        this.f25033j.a();
    }

    public final String j() {
        return this.f25035l;
    }

    public final int k() {
        return this.f25042s;
    }

    public final long l() {
        Context context = this.f25031h;
        if (context == null) {
            return -1L;
        }
        if (this.f25039p == null) {
            this.f25039p = Long.valueOf(z.a(context));
        }
        return this.f25039p.longValue();
    }

    public void e(String str) {
        m.a(new k(this, str));
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f25024a == null) {
                    f25024a = new e();
                }
                eVar = f25024a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    public final void b() throws VivoPushException {
        Context context = this.f25031h;
        if (context != null) {
            z.b(context);
        }
    }

    public final List<String> c() {
        String b10 = this.f25033j.b("APP_TAGS", (String) null);
        ArrayList arrayList = new ArrayList();
        try {
        } catch (JSONException unused) {
            this.f25033j.b("APP_TAGS");
            arrayList.clear();
            com.vivo.push.util.p.d("PushClientManager", "getTags error");
        }
        if (TextUtils.isEmpty(b10)) {
            return arrayList;
        }
        Iterator<String> keys = new JSONObject(b10).keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    public static class a {

        /* renamed from: a */
        private IPushActionListener f25045a;

        /* renamed from: b */
        private com.vivo.push.b.c f25046b;

        /* renamed from: c */
        private IPushActionListener f25047c;

        /* renamed from: d */
        private Runnable f25048d;

        /* renamed from: e */
        private Object[] f25049e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            this.f25046b = cVar;
            this.f25045a = iPushActionListener;
        }

        public final void a(int i10, Object... objArr) {
            this.f25049e = objArr;
            IPushActionListener iPushActionListener = this.f25047c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i10);
            }
            IPushActionListener iPushActionListener2 = this.f25045a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i10);
            }
        }

        public final Object[] b() {
            return this.f25049e;
        }

        public final void a(Runnable runnable) {
            this.f25048d = runnable;
        }

        public final void a() {
            Runnable runnable = this.f25048d;
            if (runnable == null) {
                com.vivo.push.util.p.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.f25047c = iPushActionListener;
        }
    }

    public synchronized a d(String str) {
        if (str != null) {
            try {
                int parseInt = Integer.parseInt(str);
                a aVar = this.f25036m.get(parseInt);
                this.f25036m.delete(parseInt);
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
            String b10 = this.f25033j.b("APP_TAGS", (String) null);
            if (TextUtils.isEmpty(b10)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(b10);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.remove(it.next());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                this.f25033j.b("APP_TAGS");
            } else {
                this.f25033j.a("APP_TAGS", jSONObject2);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
            this.f25033j.b("APP_TAGS");
        }
    }

    public final synchronized void a(Context context) {
        if (this.f25031h == null) {
            this.f25031h = ContextDelegate.getContext(context);
            this.f25040q = t.c(context, context.getPackageName());
            w.b().a(this.f25031h);
            a(new com.vivo.push.b.g());
            com.vivo.push.util.b bVar = new com.vivo.push.util.b();
            this.f25033j = bVar;
            bVar.a(this.f25031h, "com.vivo.push_preferences.appconfig_v1");
            this.f25034k = f();
            this.f25035l = this.f25033j.b("APP_ALIAS", (String) null);
        }
    }

    public final void c(List<String> list) {
        if (list.contains(this.f25035l)) {
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
            String b10 = this.f25033j.b("APP_TAGS", (String) null);
            if (TextUtils.isEmpty(b10)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(b10);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.put(it.next(), System.currentTimeMillis());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                this.f25033j.b("APP_TAGS");
            } else {
                this.f25033j.a("APP_TAGS", jSONObject2);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
            this.f25033j.b("APP_TAGS");
        }
    }

    public final void b(IPushActionListener iPushActionListener) {
        if (this.f25031h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if ("".equals(this.f25034k)) {
            iPushActionListener.onStateChanged(0);
            return;
        }
        if (!a(this.f25026c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f25026c = SystemClock.elapsedRealtime();
        String packageName = this.f25031h.getPackageName();
        a aVar = null;
        if (this.f25031h != null) {
            com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, packageName);
            bVar.d();
            bVar.e();
            bVar.g();
            bVar.a(100);
            if (this.f25040q) {
                if (n()) {
                    aVar = new a(bVar, iPushActionListener);
                    String a10 = a(aVar);
                    bVar.b(a10);
                    aVar.a(new j(this, bVar, a10));
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else if (bVar.a(this.f25031h) == 2) {
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
        this.f25034k = str;
        this.f25033j.a("APP_TOKEN", str);
    }

    public final void a(boolean z10) {
        this.f25032i = z10;
    }

    public final void a(IPushActionListener iPushActionListener) {
        if (this.f25031h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        String f10 = f();
        this.f25034k = f10;
        if (!TextUtils.isEmpty(f10)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (!a(this.f25025b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f25025b = SystemClock.elapsedRealtime();
        String packageName = this.f25031h.getPackageName();
        a aVar = null;
        if (this.f25031h != null) {
            com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
            bVar.g();
            bVar.d();
            bVar.e();
            bVar.a(100);
            if (this.f25040q) {
                if (n()) {
                    aVar = a(bVar, iPushActionListener);
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else if (bVar.a(this.f25031h) == 2) {
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

    public final void b(String str, IPushActionListener iPushActionListener) {
        if (this.f25031h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.f25035l)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.f25031h.getPackageName(), arrayList);
        aVar.a(100);
        if (this.f25040q) {
            if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            }
            if (!a(this.f25028e)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            }
            this.f25028e = SystemClock.elapsedRealtime();
            String a10 = a(new a(aVar, iPushActionListener));
            aVar.b(a10);
            if (TextUtils.isEmpty(this.f25034k)) {
                a(a10, 30001);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                a(a10, 30002);
                return;
            } else if (str.length() > 70) {
                a(a10, 30003);
                return;
            } else {
                a(aVar);
                e(a10);
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
        String a10 = a(aVar);
        bVar.b(a10);
        aVar.a(new h(this, bVar, a10));
        return aVar;
    }

    public final void a(String str, int i10, Object... objArr) {
        a d10 = d(str);
        if (d10 != null) {
            d10.a(i10, objArr);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyApp token is null");
        }
    }

    public final void a(String str, IPushActionListener iPushActionListener) {
        if (this.f25031h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(this.f25035l) && this.f25035l.equals(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, this.f25031h.getPackageName(), arrayList);
        aVar.a(100);
        if (this.f25040q) {
            if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            }
            if (!a(this.f25027d)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            }
            this.f25027d = SystemClock.elapsedRealtime();
            String a10 = a(new a(aVar, iPushActionListener));
            aVar.b(a10);
            if (TextUtils.isEmpty(this.f25034k)) {
                a(a10, 30001);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                a(a10, 30002);
                return;
            } else if (str.length() > 70) {
                a(a10, 30003);
                return;
            } else {
                a(aVar);
                e(a10);
                return;
            }
        }
        a(aVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    public final void b(String str) {
        this.f25035l = str;
        this.f25033j.a("APP_ALIAS", str);
    }

    public final void b(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.f25031h;
        if (context == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(false, context.getPackageName(), arrayList);
        zVar.a(500);
        if (this.f25040q) {
            if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            }
            if (!a(this.f25030g)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            }
            this.f25030g = SystemClock.elapsedRealtime();
            String a10 = a(new a(zVar, iPushActionListener));
            zVar.b(a10);
            if (TextUtils.isEmpty(this.f25034k)) {
                a(a10, 20001);
                return;
            }
            if (arrayList.size() < 0) {
                a(a10, 20002);
                return;
            }
            if (arrayList.size() > 500) {
                a(a10, MiUserManager.f13852h);
                return;
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().length() > 70) {
                    a(a10, 20003);
                    return;
                }
            }
            a(zVar);
            e(a10);
            return;
        }
        a(zVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    private static boolean a(long j10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j10 == -1 || elapsedRealtime <= j10 || elapsedRealtime >= j10 + y.f.f18076n;
    }

    public final void a(String str, int i10) {
        a d10 = d(str);
        if (d10 != null) {
            d10.a(i10, new Object[0]);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    private synchronized String a(a aVar) {
        int i10;
        this.f25036m.put(this.f25037n, aVar);
        i10 = this.f25037n;
        this.f25037n = i10 + 1;
        return Integer.toString(i10);
    }

    public final void a(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Context context = this.f25031h;
        if (context == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(true, context.getPackageName(), arrayList);
        zVar.a(500);
        if (this.f25040q) {
            if (!n()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            }
            if (!a(this.f25029f)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                    return;
                }
                return;
            }
            this.f25029f = SystemClock.elapsedRealtime();
            String a10 = a(new a(zVar, iPushActionListener));
            zVar.b(a10);
            if (TextUtils.isEmpty(this.f25034k)) {
                a(a10, 20001);
                return;
            }
            if (arrayList.size() < 0) {
                a(a10, 20002);
                return;
            }
            if (arrayList.size() + c().size() > 500) {
                a(a10, MiUserManager.f13852h);
                return;
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().length() > 70) {
                    a(a10, 20003);
                    return;
                }
            }
            a(zVar);
            e(a10);
            return;
        }
        a(zVar);
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(0);
        }
    }

    public final void a(Intent intent, PushMessageCallback pushMessageCallback) {
        o createReceiverCommand = this.f25041r.createReceiverCommand(intent);
        Context context = a().f25031h;
        if (createReceiverCommand == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        com.vivo.push.d.z createReceiveTask = this.f25041r.createReceiveTask(createReceiverCommand);
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
        Context context = a().f25031h;
        if (oVar == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        l createTask = this.f25041r.createTask(oVar);
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
