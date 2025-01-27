package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.heytap.mcssdk.c.e;
import com.heytap.mcssdk.e.c;
import com.heytap.mcssdk.n.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements f {
    private static final String A = "globalID";
    private static final String B = "supportOpenPush";
    private static final String C = "versionName";
    private static final String D = "versionCode";
    private static final String E = "pushSdkVersion";
    private static final int F = 23;
    private static final int G = 59;
    private static final int H = 24;
    private static final int I = 1000;
    private static String K = null;
    private static boolean L = false;

    /* renamed from: a */
    public static final String f8875a = "push_register";

    /* renamed from: b */
    public static final String f8876b = "push_transmit";

    /* renamed from: c */
    public static final String f8877c = "push_show";

    /* renamed from: d */
    public static final String f8878d = "push_no_show";

    /* renamed from: e */
    public static final String f8879e = "push_read_message";

    /* renamed from: f */
    public static final String f8880f = "push_click";

    /* renamed from: g */
    public static final String f8881g = "app_black_list";

    /* renamed from: h */
    public static final String f8882h = "push_exception";

    /* renamed from: i */
    public static final String f8883i = "push_delete";

    /* renamed from: j */
    public static final String f8884j = "push_revoke";
    public static final String k = "push_revoke_delete";
    public static final String l = "add_message_top";
    public static final String m = "add_message_no_disturbing";
    public static final String n = "imsi_not_exist";
    public static final String o = "message_repeat";
    private static final String r = "com.mcs.action.RECEIVE_SDK_MESSAGE";
    private static final String s = "type";
    private static final int t = 1012;
    private static final String u = "eventID";
    private static final String v = "taskID";
    private static final String w = "appPackage";
    private static final String x = "extra";
    private static final String y = "messageType";
    private static final String z = "messageID";
    private final Object M;
    private Context N;
    private List<c> O;
    private List<com.heytap.mcssdk.c.d> P;
    private String Q;
    private String R;
    private String S;
    private com.heytap.mcssdk.h.c T;
    private static final int[] p = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};
    private static final int[] q = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};
    private static int J = 0;

    private a() {
        this.M = new Object();
        this.O = new ArrayList();
        this.P = new ArrayList();
        this.S = null;
        synchronized (a.class) {
            int i2 = J;
            if (i2 > 0) {
                throw new RuntimeException("PushManager can't create again!");
            }
            J = i2 + 1;
        }
        W(new com.heytap.mcssdk.c.a());
        W(new e());
        W(new com.heytap.mcssdk.c.b());
        X(new com.heytap.mcssdk.e.a());
        X(new com.heytap.mcssdk.e.d());
        X(new com.heytap.mcssdk.e.b());
    }

    /* synthetic */ a(i iVar) {
        this();
    }

    private synchronized void W(com.heytap.mcssdk.c.d dVar) {
        if (dVar != null) {
            this.P.add(dVar);
        }
    }

    private synchronized void X(c cVar) {
        if (cVar != null) {
            this.O.add(cVar);
        }
    }

    private void Z() {
        a0();
        b0();
    }

    private void a0() {
        if (this.N == null) {
            throw new IllegalArgumentException("please call the register first!");
        }
    }

    private void b0() {
        if (this.S == null) {
            throw new IllegalArgumentException("please call the register until get the registerID!");
        }
    }

    public static a c0() {
        a aVar;
        aVar = j.f8893a;
        return aVar;
    }

    private Intent d0(int i2, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(m0(this.N));
        intent.setPackage(e0(this.N));
        intent.putExtra("type", i2);
        JSONObject jSONObject2 = new JSONObject();
        try {
            Context context = this.N;
            jSONObject2.putOpt(C, com.heytap.mcssdk.o.i.h(context, context.getPackageName()));
            Context context2 = this.N;
            jSONObject2.putOpt(D, Integer.valueOf(com.heytap.mcssdk.o.i.f(context2, context2.getPackageName())));
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.get(next));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            intent.putExtra("extra", jSONObject2.toString());
            throw th;
        }
        intent.putExtra("extra", jSONObject2.toString());
        intent.putExtra("params", str);
        intent.putExtra("appPackage", this.N.getPackageName());
        intent.putExtra(com.heytap.mcssdk.n.b.Q, this.Q);
        intent.putExtra(com.heytap.mcssdk.n.b.R, this.R);
        intent.putExtra(com.heytap.mcssdk.n.b.S, this.S);
        intent.putExtra("sdkVersion", n0());
        return intent;
    }

    public static String e0(Context context) {
        boolean z2;
        if (K == null) {
            String f0 = f0(context);
            if (f0 == null) {
                K = com.heytap.mcssdk.o.i.c(p);
                z2 = false;
            } else {
                K = f0;
                z2 = true;
            }
            L = z2;
        }
        return K;
    }

    private static String f0(Context context) {
        boolean z2;
        boolean z3;
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(r), 8192);
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        while (it.hasNext()) {
            String str = it.next().serviceInfo.packageName;
            try {
                z2 = (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) == 1;
                z3 = context.getPackageManager().getPackageUid(str, 0) == context.getPackageManager().getPackageUid(BaseWrapper.BASE_PKG_SYSTEM, 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (z2 || z3) {
                return str;
            }
        }
        return null;
    }

    public static String m0(Context context) {
        if (K == null) {
            f0(context);
        }
        return L ? r : com.heytap.mcssdk.o.i.c(q);
    }

    public static String n0() {
        return d.f8890f;
    }

    public static boolean o0(Context context) {
        String e0 = e0(context);
        return com.heytap.mcssdk.o.i.i(context, e0) && com.heytap.mcssdk.o.i.f(context, e0) >= 1012 && com.heytap.mcssdk.o.i.j(context, e0, B);
    }

    @Deprecated
    private static void p0(Context context) {
        v0(context, new com.heytap.mcssdk.n.e(context.getPackageName(), "app_start", null));
    }

    private void s0(int i2, String str, JSONObject jSONObject) {
        synchronized (this.M) {
            this.N.startService(d0(i2, str, jSONObject));
        }
    }

    private void t0(int i2, JSONObject jSONObject) {
        s0(i2, "", jSONObject);
    }

    public static void u0(Context context, com.heytap.mcssdk.n.a aVar, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(m0(context));
            intent.setPackage(e0(context));
            intent.putExtra("type", com.heytap.mcssdk.n.b.Y);
            intent.putExtra("taskID", aVar.c());
            intent.putExtra("appPackage", aVar.a());
            intent.putExtra("messageID", String.valueOf(aVar.b()));
            intent.putExtra("globalID", String.valueOf(aVar.b()));
            intent.putExtra(y, aVar.getType());
            intent.putExtra(u, str);
            context.startService(intent);
        } catch (Exception e2) {
            com.heytap.mcssdk.o.e.d("statisticMessage--Exception" + e2.getMessage());
        }
    }

    public static void v0(Context context, com.heytap.mcssdk.n.e eVar) {
        com.heytap.mcssdk.o.g.b(context, eVar);
    }

    public static void w0(Context context, h hVar, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(m0(context));
            intent.setPackage(e0(context));
            intent.putExtra("type", com.heytap.mcssdk.n.b.Y);
            intent.putExtra("taskID", hVar.c());
            intent.putExtra("appPackage", hVar.a());
            intent.putExtra("messageID", hVar.b());
            intent.putExtra("globalID", hVar.k());
            intent.putExtra(y, hVar.getType());
            intent.putExtra(u, str);
            context.startService(intent);
        } catch (Exception e2) {
            com.heytap.mcssdk.o.e.d("statisticMessage--Exception" + e2.getMessage());
        }
    }

    public static void x0(Context context, List<com.heytap.mcssdk.n.e> list) {
        com.heytap.mcssdk.o.g.c(context, list);
    }

    @Override // com.heytap.mcssdk.f
    public void A() {
        m(null);
    }

    @Override // com.heytap.mcssdk.g
    public void B(List<String> list, JSONObject jSONObject) {
        try {
            Z();
            if (list != null && list.size() != 0) {
                s0(com.heytap.mcssdk.n.b.e0, com.heytap.mcssdk.n.b.q(list), jSONObject);
            }
        } catch (Exception unused) {
            if (i0() != null) {
                i0().g(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.g
    public void C(JSONObject jSONObject) {
        try {
            Z();
            t0(com.heytap.mcssdk.n.b.j0, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().e(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.g
    public void D(JSONObject jSONObject) {
        try {
            Z();
            t0(com.heytap.mcssdk.n.b.r0, jSONObject);
        } catch (Exception e2) {
            com.heytap.mcssdk.o.e.f(com.heytap.mcssdk.o.e.f8936a, e2);
        }
    }

    @Override // com.heytap.mcssdk.f
    public void E() {
        C(null);
    }

    @Override // com.heytap.mcssdk.g
    public void F(String str, JSONObject jSONObject) {
        try {
            Z();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            j(arrayList, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().i(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.g
    public void G(List<String> list, JSONObject jSONObject) {
        try {
            Z();
            if (list != null && list.size() != 0) {
                s0(com.heytap.mcssdk.n.b.c0, com.heytap.mcssdk.n.b.q(list), jSONObject);
            }
        } catch (Exception unused) {
            if (i0() != null) {
                i0().f(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.f
    public void H() {
        e(null);
    }

    @Override // com.heytap.mcssdk.f
    public void I() {
        D(null);
    }

    @Override // com.heytap.mcssdk.g
    public void J(Context context, String str, String str2, JSONObject jSONObject, com.heytap.mcssdk.h.c cVar) {
        try {
            if (context == null) {
                throw new IllegalArgumentException("context is null !");
            }
            v0(context, new com.heytap.mcssdk.n.e(context.getPackageName(), f8875a, null));
            if (!o0(context)) {
                throw new IllegalArgumentException("the phone is not support push!");
            }
            this.Q = str;
            this.R = str2;
            this.N = context.getApplicationContext();
            this.T = cVar;
            t0(com.heytap.mcssdk.n.b.W, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().n(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.f
    public void K(List<String> list) {
        N(list, null);
    }

    @Override // com.heytap.mcssdk.f
    public void L(String str) {
        this.S = str;
    }

    @Override // com.heytap.mcssdk.g
    public void M(JSONObject jSONObject) {
        try {
            a0();
            t0(com.heytap.mcssdk.n.b.W, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().n(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.g
    @Deprecated
    public void N(List<String> list, JSONObject jSONObject) {
        try {
            Z();
            if (list != null && list.size() != 0) {
                s0(com.heytap.mcssdk.n.b.b0, com.heytap.mcssdk.n.b.q(list), jSONObject);
            }
        } catch (Exception unused) {
            if (i0() != null) {
                i0().k(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.f
    public void O() {
        w(null);
    }

    @Override // com.heytap.mcssdk.f
    public void P(int i2) {
        u(i2, null);
    }

    @Override // com.heytap.mcssdk.g
    public void Q(String str, JSONObject jSONObject) {
        try {
            Z();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            N(arrayList, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().k(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.f
    public void R() {
        M(null);
    }

    @Override // com.heytap.mcssdk.f
    public void S() {
        z(null);
    }

    @Override // com.heytap.mcssdk.g
    public void T(List<Integer> list, int i2, int i3, int i4, int i5, JSONObject jSONObject) {
        try {
            Z();
            if (list == null || list.size() <= 0 || i2 < 0 || i2 > 23 || i3 < 0 || i3 > 59 || i4 < i2 || i4 > 23 || i5 < i3 || i5 > 59) {
                throw new IllegalArgumentException("params are not all right,please check params");
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("weekDays", com.heytap.mcssdk.n.b.q(list));
                jSONObject2.put("startHour", i2);
                jSONObject2.put("startMin", i3);
                jSONObject2.put("endHour", i4);
                jSONObject2.put("endMin", i5);
                s0(com.heytap.mcssdk.n.b.f0, jSONObject2.toString(), jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            if (i0() != null) {
                i0().l(-2, e3.getMessage());
            }
        }
    }

    @Override // com.heytap.mcssdk.f
    public void U(Context context, String str, String str2, com.heytap.mcssdk.h.c cVar) {
        J(context, str, str2, null, cVar);
    }

    public void Y(int i2) {
        Intent d0 = d0(i2, "", null);
        this.N.bindService(d0, new i(this, d0), 1);
    }

    @Override // com.heytap.mcssdk.f
    public void a(List<String> list) {
        y(list, null);
    }

    @Override // com.heytap.mcssdk.g
    public void b(JSONObject jSONObject) {
        try {
            a0();
            t0(com.heytap.mcssdk.n.b.s0, jSONObject);
        } catch (Exception e2) {
            com.heytap.mcssdk.o.e.f(com.heytap.mcssdk.o.e.f8936a, e2);
        }
    }

    @Override // com.heytap.mcssdk.g
    public void c(List<String> list, JSONObject jSONObject) {
        try {
            Z();
            if (list != null && list.size() != 0) {
                s0(com.heytap.mcssdk.n.b.Z, com.heytap.mcssdk.n.b.q(list), jSONObject);
            }
        } catch (Exception unused) {
            if (i0() != null) {
                i0().a(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.f
    public void d(List<String> list) {
        G(list, null);
    }

    @Override // com.heytap.mcssdk.g
    public void e(JSONObject jSONObject) {
        try {
            Z();
            t0(com.heytap.mcssdk.n.b.q0, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().c(-2, 0);
            }
        }
    }

    @Override // com.heytap.mcssdk.f
    public void f() {
        x(null);
    }

    @Override // com.heytap.mcssdk.f
    public void g(List<String> list) {
        B(list, null);
    }

    public List<com.heytap.mcssdk.c.d> g0() {
        return this.P;
    }

    @Override // com.heytap.mcssdk.f
    public void h() {
        q(null);
    }

    public List<c> h0() {
        return this.O;
    }

    @Override // com.heytap.mcssdk.f
    public void i(String str) {
        Q(str, null);
    }

    public com.heytap.mcssdk.h.c i0() {
        return this.T;
    }

    @Override // com.heytap.mcssdk.g
    @Deprecated
    public void j(List<String> list, JSONObject jSONObject) {
        try {
            Z();
            if (list != null && list.size() != 0) {
                s0(com.heytap.mcssdk.n.b.i0, com.heytap.mcssdk.n.b.q(list), jSONObject);
            }
        } catch (Exception unused) {
            if (i0() != null) {
                i0().i(-2, null);
            }
        }
    }

    public void j0() {
        try {
            Z();
            t0(com.heytap.mcssdk.n.b.n0, null);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().d(-2, 0);
            }
        }
    }

    @Override // com.heytap.mcssdk.f
    public void k(String str) {
        F(str, null);
    }

    public int k0() {
        a0();
        Context context = this.N;
        return com.heytap.mcssdk.o.i.f(context, e0(context));
    }

    @Override // com.heytap.mcssdk.f
    public String l() {
        return this.S;
    }

    public String l0() {
        a0();
        Context context = this.N;
        return com.heytap.mcssdk.o.i.h(context, e0(context));
    }

    @Override // com.heytap.mcssdk.g
    public void m(JSONObject jSONObject) {
        try {
            Z();
            t0(com.heytap.mcssdk.n.b.g0, jSONObject);
        } catch (Exception e2) {
            com.heytap.mcssdk.o.e.f(com.heytap.mcssdk.o.e.f8936a, e2);
        }
    }

    @Override // com.heytap.mcssdk.f
    public void n(List<String> list) {
        j(list, null);
    }

    @Override // com.heytap.mcssdk.f
    public void o() {
        t(null);
    }

    @Override // com.heytap.mcssdk.f
    public void p() {
        try {
            a0();
            Y(com.heytap.mcssdk.n.b.u0);
        } catch (Exception e2) {
            com.heytap.mcssdk.o.e.f(com.heytap.mcssdk.o.e.f8936a, e2);
        }
    }

    @Override // com.heytap.mcssdk.g
    public void q(JSONObject jSONObject) {
        try {
            Z();
            t0(com.heytap.mcssdk.n.b.d0, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().m(-2, null);
            }
        }
    }

    public void q0(String str, String str2) {
        this.Q = str;
        this.R = str2;
    }

    @Override // com.heytap.mcssdk.f
    public void r() {
        b(null);
    }

    public void r0(com.heytap.mcssdk.h.c cVar) {
        this.T = cVar;
    }

    @Override // com.heytap.mcssdk.f
    public void s(List<Integer> list, int i2, int i3, int i4, int i5) {
        T(list, i2, i3, i4, i5, null);
    }

    @Override // com.heytap.mcssdk.g
    public void t(JSONObject jSONObject) {
        try {
            a0();
            t0(com.heytap.mcssdk.n.b.X, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().b(-2);
            }
        }
    }

    @Override // com.heytap.mcssdk.g
    public void u(int i2, JSONObject jSONObject) {
        try {
            Z();
            s0(com.heytap.mcssdk.n.b.o0, String.valueOf(i2), jSONObject);
        } catch (Exception e2) {
            com.heytap.mcssdk.o.e.f(com.heytap.mcssdk.o.e.f8936a, e2);
        }
    }

    @Override // com.heytap.mcssdk.f
    public void v(List<String> list) {
        c(list, null);
    }

    @Override // com.heytap.mcssdk.g
    public void w(JSONObject jSONObject) {
        try {
            Z();
            t0(com.heytap.mcssdk.n.b.p0, jSONObject);
        } catch (Exception e2) {
            com.heytap.mcssdk.o.e.f(com.heytap.mcssdk.o.e.f8936a, e2);
        }
    }

    @Override // com.heytap.mcssdk.g
    public void x(JSONObject jSONObject) {
        try {
            Z();
            t0(com.heytap.mcssdk.n.b.a0, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().j(-2, null);
            }
        }
    }

    @Override // com.heytap.mcssdk.g
    public void y(List<String> list, JSONObject jSONObject) {
        try {
            Z();
            if (list != null && list.size() != 0) {
                s0(com.heytap.mcssdk.n.b.k0, com.heytap.mcssdk.n.b.q(list), jSONObject);
            }
        } catch (Exception unused) {
            if (i0() != null) {
                i0().h(-2, null);
            }
        }
    }

    public void y0(Context context, String str, String str2, JSONObject jSONObject, com.heytap.mcssdk.h.c cVar) {
        this.Q = str;
        this.R = str2;
        this.N = context.getApplicationContext();
        this.T = cVar;
        t(jSONObject);
    }

    @Override // com.heytap.mcssdk.g
    public void z(JSONObject jSONObject) {
        try {
            Z();
            t0(com.heytap.mcssdk.n.b.h0, jSONObject);
        } catch (Exception e2) {
            com.heytap.mcssdk.o.e.f(com.heytap.mcssdk.o.e.f8936a, e2);
        }
    }
}
