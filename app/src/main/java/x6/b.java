package x6;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b implements e {
    public static final String A = "type";
    public static final int B = 1012;
    public static final String C = "eventID";
    public static final String D = "taskID";
    public static final String E = "appPackage";
    public static final String F = "extra";
    public static final String G = "messageType";
    public static final String H = "messageID";
    public static final String I = "globalID";
    public static final String J = "supportOpenPush";
    public static final String K = "versionName";
    public static final String L = "versionCode";
    public static final String M = "pushSdkVersion";
    public static final int N = 23;
    public static final int O = 59;
    public static final int P = 24;
    public static final int Q = 1000;
    public static String S = null;
    public static boolean T = false;

    /* renamed from: i */
    public static final String f31838i = "push_register";

    /* renamed from: j */
    public static final String f31839j = "push_transmit";

    /* renamed from: k */
    public static final String f31840k = "push_show";

    /* renamed from: l */
    public static final String f31841l = "push_no_show";

    /* renamed from: m */
    public static final String f31842m = "push_read_message";

    /* renamed from: n */
    public static final String f31843n = "push_click";

    /* renamed from: o */
    public static final String f31844o = "app_black_list";

    /* renamed from: p */
    public static final String f31845p = "push_exception";

    /* renamed from: q */
    public static final String f31846q = "push_delete";

    /* renamed from: r */
    public static final String f31847r = "push_revoke";

    /* renamed from: s */
    public static final String f31848s = "push_revoke_delete";

    /* renamed from: t */
    public static final String f31849t = "add_message_top";

    /* renamed from: u */
    public static final String f31850u = "add_message_no_disturbing";

    /* renamed from: v */
    public static final String f31851v = "imsi_not_exist";

    /* renamed from: w */
    public static final String f31852w = "message_repeat";

    /* renamed from: z */
    public static final String f31855z = "com.mcs.action.RECEIVE_SDK_MESSAGE";

    /* renamed from: a */
    public final Object f31856a;

    /* renamed from: b */
    public Context f31857b;

    /* renamed from: c */
    public List<z6.c> f31858c;

    /* renamed from: d */
    public List<y6.d> f31859d;

    /* renamed from: e */
    public String f31860e;

    /* renamed from: f */
    public String f31861f;

    /* renamed from: g */
    public String f31862g;

    /* renamed from: h */
    public a7.c f31863h;

    /* renamed from: x */
    public static final int[] f31853x = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY, 46, 109, 99, TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY};

    /* renamed from: y */
    public static final int[] f31854y = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY, 46, 109, 99, TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY, TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY, 100, 107, 46, 97, 99, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};
    public static int R = 0;

    public b() {
        this.f31856a = new Object();
        this.f31858c = new ArrayList();
        this.f31859d = new ArrayList();
        this.f31862g = null;
        synchronized (b.class) {
            int i10 = R;
            if (i10 > 0) {
                throw new RuntimeException("PushManager can't create again!");
            }
            R = i10 + 1;
        }
        W(new y6.a());
        W(new y6.e());
        W(new y6.b());
        X(new z6.a());
        X(new z6.d());
        X(new z6.b());
    }

    public static b c0() {
        b bVar;
        bVar = h.f31872a;
        return bVar;
    }

    public static String e0(Context context) {
        boolean z10;
        if (S == null) {
            String f02 = f0(context);
            if (f02 == null) {
                S = c7.i.c(f31853x);
                z10 = false;
            } else {
                S = f02;
                z10 = true;
            }
            T = z10;
        }
        return S;
    }

    public static String f0(Context context) {
        boolean z10;
        int packageUid;
        int packageUid2;
        boolean z11;
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(f31855z), 8192);
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        while (it.hasNext()) {
            String str = it.next().serviceInfo.packageName;
            try {
                z10 = (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) == 1;
                packageUid = context.getPackageManager().getPackageUid(str, 0);
                packageUid2 = context.getPackageManager().getPackageUid("android", 0);
                z11 = packageUid == packageUid2;
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (z10 || z11) {
                return str;
            }
        }
        return null;
    }

    public static String m0(Context context) {
        if (S == null) {
            f0(context);
        }
        return T ? f31855z : c7.i.c(f31854y);
    }

    public static String n0() {
        return d.f31869f;
    }

    public static boolean o0(Context context) {
        String e02 = e0(context);
        return c7.i.i(context, e02) && c7.i.f(context, e02) >= 1012 && c7.i.j(context, e02, J);
    }

    @Deprecated
    public static void p0(Context context) {
        v0(context, new b7.e(context.getPackageName(), "app_start", null));
    }

    public static void u0(Context context, b7.a aVar, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(m0(context));
            intent.setPackage(e0(context));
            intent.putExtra("type", b7.b.f1310g0);
            intent.putExtra("taskID", aVar.c());
            intent.putExtra("appPackage", aVar.a());
            intent.putExtra("messageID", String.valueOf(aVar.b()));
            intent.putExtra("globalID", String.valueOf(aVar.b()));
            intent.putExtra("messageType", aVar.getType());
            intent.putExtra("eventID", str);
            context.startService(intent);
        } catch (Exception e10) {
            c7.e.d("statisticMessage--Exception" + e10.getMessage());
        }
    }

    public static void v0(Context context, b7.e eVar) {
        c7.g.b(context, eVar);
    }

    public static void w0(Context context, b7.h hVar, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(m0(context));
            intent.setPackage(e0(context));
            intent.putExtra("type", b7.b.f1310g0);
            intent.putExtra("taskID", hVar.c());
            intent.putExtra("appPackage", hVar.a());
            intent.putExtra("messageID", hVar.b());
            intent.putExtra("globalID", hVar.k());
            intent.putExtra("messageType", hVar.getType());
            intent.putExtra("eventID", str);
            context.startService(intent);
        } catch (Exception e10) {
            c7.e.d("statisticMessage--Exception" + e10.getMessage());
        }
    }

    public static void x0(Context context, List<b7.e> list) {
        c7.g.c(context, list);
    }

    @Override // x6.f
    public void A(JSONObject jSONObject) {
        try {
            Z();
            t0(b7.b.f1319p0, jSONObject);
        } catch (Exception e10) {
            c7.e.f(c7.e.f1710a, e10);
        }
    }

    @Override // x6.e
    public void B() {
        n(null);
    }

    @Override // x6.f
    public void C(List<String> list, JSONObject jSONObject) {
        try {
            Z();
            if (list != null && list.size() != 0) {
                s0(b7.b.f1316m0, b7.b.q(list), jSONObject);
            }
        } catch (Exception unused) {
            if (i0() != null) {
                i0().g(-2, null);
            }
        }
    }

    @Override // x6.f
    public void D(JSONObject jSONObject) {
        try {
            Z();
            t0(b7.b.f1321r0, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().e(-2, null);
            }
        }
    }

    @Override // x6.f
    public void E(JSONObject jSONObject) {
        try {
            Z();
            t0(b7.b.f1329z0, jSONObject);
        } catch (Exception e10) {
            c7.e.f(c7.e.f1710a, e10);
        }
    }

    @Override // x6.e
    public void F() {
        D(null);
    }

    @Override // x6.f
    public void G(String str, JSONObject jSONObject) {
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

    @Override // x6.f
    public void H(List<String> list, JSONObject jSONObject) {
        try {
            Z();
            if (list != null && list.size() != 0) {
                s0(b7.b.f1314k0, b7.b.q(list), jSONObject);
            }
        } catch (Exception unused) {
            if (i0() != null) {
                i0().f(-2, null);
            }
        }
    }

    @Override // x6.e
    public void I() {
        e(null);
    }

    @Override // x6.e
    public void J(Context context, String str, String str2, a7.c cVar) {
        m(context, str, str2, null, cVar);
    }

    @Override // x6.e
    public void K() {
        E(null);
    }

    @Override // x6.e
    public void L(List<String> list) {
        O(list, null);
    }

    @Override // x6.e
    public void M(String str) {
        this.f31862g = str;
    }

    @Override // x6.f
    public void N(JSONObject jSONObject) {
        try {
            a0();
            t0(b7.b.f1308e0, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().n(-2, null);
            }
        }
    }

    @Override // x6.f
    @Deprecated
    public void O(List<String> list, JSONObject jSONObject) {
        try {
            Z();
            if (list != null && list.size() != 0) {
                s0(b7.b.f1313j0, b7.b.q(list), jSONObject);
            }
        } catch (Exception unused) {
            if (i0() != null) {
                i0().k(-2, null);
            }
        }
    }

    @Override // x6.e
    public void P() {
        x(null);
    }

    @Override // x6.e
    public void Q(int i10) {
        v(i10, null);
    }

    @Override // x6.f
    public void R(String str, JSONObject jSONObject) {
        try {
            Z();
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            O(arrayList, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().k(-2, null);
            }
        }
    }

    @Override // x6.e
    public void S() {
        N(null);
    }

    @Override // x6.e
    public void T() {
        A(null);
    }

    @Override // x6.f
    public void U(List<Integer> list, int i10, int i11, int i12, int i13, JSONObject jSONObject) {
        try {
            Z();
            if (list == null || list.size() <= 0 || i10 < 0 || i10 > 23 || i11 < 0 || i11 > 59 || i12 < i10 || i12 > 23 || i13 < i11 || i13 > 59) {
                throw new IllegalArgumentException("params are not all right,please check params");
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("weekDays", b7.b.q(list));
                jSONObject2.put("startHour", i10);
                jSONObject2.put("startMin", i11);
                jSONObject2.put("endHour", i12);
                jSONObject2.put("endMin", i13);
                s0(b7.b.f1317n0, jSONObject2.toString(), jSONObject);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        } catch (Exception e11) {
            if (i0() != null) {
                i0().l(-2, e11.getMessage());
            }
        }
    }

    public final synchronized void W(y6.d dVar) {
        if (dVar != null) {
            this.f31859d.add(dVar);
        }
    }

    public final synchronized void X(z6.c cVar) {
        if (cVar != null) {
            this.f31858c.add(cVar);
        }
    }

    public void Y(int i10) {
        Intent d02 = d0(i10, "", null);
        this.f31857b.bindService(d02, new g(this, d02), 1);
    }

    public final void Z() {
        a0();
        b0();
    }

    @Override // x6.e
    public void a(List<String> list) {
        z(list, null);
    }

    public final void a0() {
        if (this.f31857b == null) {
            throw new IllegalArgumentException("please call the register first!");
        }
    }

    @Override // x6.f
    public void b(JSONObject jSONObject) {
        try {
            a0();
            t0(b7.b.A0, jSONObject);
        } catch (Exception e10) {
            c7.e.f(c7.e.f1710a, e10);
        }
    }

    public final void b0() {
        if (this.f31862g == null) {
            throw new IllegalArgumentException("please call the register until get the registerID!");
        }
    }

    @Override // x6.f
    public void c(List<String> list, JSONObject jSONObject) {
        try {
            Z();
            if (list != null && list.size() != 0) {
                s0(b7.b.f1311h0, b7.b.q(list), jSONObject);
            }
        } catch (Exception unused) {
            if (i0() != null) {
                i0().a(-2, null);
            }
        }
    }

    @Override // x6.e
    public void d(List<String> list) {
        H(list, null);
    }

    public final Intent d0(int i10, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(m0(this.f31857b));
        intent.setPackage(e0(this.f31857b));
        intent.putExtra("type", i10);
        JSONObject jSONObject2 = new JSONObject();
        try {
            Context context = this.f31857b;
            jSONObject2.putOpt("versionName", c7.i.h(context, context.getPackageName()));
            Context context2 = this.f31857b;
            jSONObject2.putOpt("versionCode", Integer.valueOf(c7.i.f(context2, context2.getPackageName())));
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.get(next));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th2) {
            intent.putExtra("extra", jSONObject2.toString());
            throw th2;
        }
        intent.putExtra("extra", jSONObject2.toString());
        intent.putExtra("params", str);
        intent.putExtra("appPackage", this.f31857b.getPackageName());
        intent.putExtra(b7.b.Y, this.f31860e);
        intent.putExtra(b7.b.Z, this.f31861f);
        intent.putExtra(b7.b.f1304a0, this.f31862g);
        intent.putExtra(b7.b.f1305b0, n0());
        return intent;
    }

    @Override // x6.f
    public void e(JSONObject jSONObject) {
        try {
            Z();
            t0(b7.b.f1328y0, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().c(-2, 0);
            }
        }
    }

    @Override // x6.e
    public void f() {
        y(null);
    }

    @Override // x6.e
    public void g(List<String> list) {
        C(list, null);
    }

    public List<y6.d> g0() {
        return this.f31859d;
    }

    @Override // x6.e
    public void h() {
        r(null);
    }

    public List<z6.c> h0() {
        return this.f31858c;
    }

    @Override // x6.e
    public void i(String str) {
        R(str, null);
    }

    public a7.c i0() {
        return this.f31863h;
    }

    @Override // x6.f
    @Deprecated
    public void j(List<String> list, JSONObject jSONObject) {
        try {
            Z();
            if (list != null && list.size() != 0) {
                s0(b7.b.f1320q0, b7.b.q(list), jSONObject);
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
            t0(b7.b.f1325v0, null);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().d(-2, 0);
            }
        }
    }

    @Override // x6.e
    public void k(String str) {
        G(str, null);
    }

    public int k0() {
        a0();
        Context context = this.f31857b;
        return c7.i.f(context, e0(context));
    }

    @Override // x6.e
    public String l() {
        return this.f31862g;
    }

    public String l0() {
        a0();
        Context context = this.f31857b;
        return c7.i.h(context, e0(context));
    }

    @Override // x6.f
    public void m(Context context, String str, String str2, JSONObject jSONObject, a7.c cVar) {
        try {
            if (context == null) {
                throw new IllegalArgumentException("context is null !");
            }
            v0(context, new b7.e(context.getPackageName(), f31838i, null));
            if (!o0(context)) {
                throw new IllegalArgumentException("the phone is not support push!");
            }
            this.f31860e = str;
            this.f31861f = str2;
            this.f31857b = context.getApplicationContext();
            this.f31863h = cVar;
            t0(b7.b.f1308e0, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().n(-2, null);
            }
        }
    }

    @Override // x6.f
    public void n(JSONObject jSONObject) {
        try {
            Z();
            t0(b7.b.f1318o0, jSONObject);
        } catch (Exception e10) {
            c7.e.f(c7.e.f1710a, e10);
        }
    }

    @Override // x6.e
    public void o(List<String> list) {
        j(list, null);
    }

    @Override // x6.e
    public void p() {
        u(null);
    }

    @Override // x6.e
    public void q() {
        try {
            a0();
            Y(b7.b.C0);
        } catch (Exception e10) {
            c7.e.f(c7.e.f1710a, e10);
        }
    }

    public void q0(String str, String str2) {
        this.f31860e = str;
        this.f31861f = str2;
    }

    @Override // x6.f
    public void r(JSONObject jSONObject) {
        try {
            Z();
            t0(b7.b.f1315l0, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().m(-2, null);
            }
        }
    }

    public void r0(a7.c cVar) {
        this.f31863h = cVar;
    }

    @Override // x6.e
    public void s() {
        b(null);
    }

    public final void s0(int i10, String str, JSONObject jSONObject) {
        synchronized (this.f31856a) {
            this.f31857b.startService(d0(i10, str, jSONObject));
        }
    }

    @Override // x6.e
    public void t(List<Integer> list, int i10, int i11, int i12, int i13) {
        U(list, i10, i11, i12, i13, null);
    }

    public final void t0(int i10, JSONObject jSONObject) {
        s0(i10, "", jSONObject);
    }

    @Override // x6.f
    public void u(JSONObject jSONObject) {
        try {
            a0();
            t0(b7.b.f1309f0, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().b(-2);
            }
        }
    }

    @Override // x6.f
    public void v(int i10, JSONObject jSONObject) {
        try {
            Z();
            s0(b7.b.f1326w0, String.valueOf(i10), jSONObject);
        } catch (Exception e10) {
            c7.e.f(c7.e.f1710a, e10);
        }
    }

    @Override // x6.e
    public void w(List<String> list) {
        c(list, null);
    }

    @Override // x6.f
    public void x(JSONObject jSONObject) {
        try {
            Z();
            t0(b7.b.f1327x0, jSONObject);
        } catch (Exception e10) {
            c7.e.f(c7.e.f1710a, e10);
        }
    }

    @Override // x6.f
    public void y(JSONObject jSONObject) {
        try {
            Z();
            t0(b7.b.f1312i0, jSONObject);
        } catch (Exception unused) {
            if (i0() != null) {
                i0().j(-2, null);
            }
        }
    }

    public void y0(Context context, String str, String str2, JSONObject jSONObject, a7.c cVar) {
        this.f31860e = str;
        this.f31861f = str2;
        this.f31857b = context.getApplicationContext();
        this.f31863h = cVar;
        u(jSONObject);
    }

    @Override // x6.f
    public void z(List<String> list, JSONObject jSONObject) {
        try {
            Z();
            if (list != null && list.size() != 0) {
                s0(b7.b.f1322s0, b7.b.q(list), jSONObject);
            }
        } catch (Exception unused) {
            if (i0() != null) {
                i0().h(-2, null);
            }
        }
    }

    public /* synthetic */ b(g gVar) {
        this();
    }
}
