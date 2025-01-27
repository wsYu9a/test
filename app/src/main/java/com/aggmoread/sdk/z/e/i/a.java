package com.aggmoread.sdk.z.e.i;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.b.d;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.h.a;
import com.aggmoread.sdk.z.b.j.g;
import com.aggmoread.sdk.z.b.m.n;
import com.aggmoread.sdk.z.b.p.a;
import com.aggmoread.sdk.z.e.e.a;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.bm;
import com.shu.priory.config.AdKeys;
import com.sigmob.sdk.base.mta.PointCategory;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: com.aggmoread.sdk.z.e.i.a$a */
    public static class C0199a implements a.f {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.b.i.b f6243a;

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.e.f.a f6244b;

        /* renamed from: com.aggmoread.sdk.z.e.i.a$a$a */
        public class RunnableC0200a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.e.e.a f6245b;

            public RunnableC0200a(com.aggmoread.sdk.z.e.e.a aVar) {
                this.f6245b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    new com.aggmoread.sdk.z.e.j.a().a(this.f6245b, (com.aggmoread.sdk.z.b.s.e) C0199a.this.f6243a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    a.a(C0199a.this.f6243a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!   -->" + th2.toString()));
                }
            }
        }

        /* renamed from: com.aggmoread.sdk.z.e.i.a$a$b */
        public class b implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.e.e.a f6247b;

            public b(com.aggmoread.sdk.z.e.e.a aVar) {
                this.f6247b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.a(this.f6247b, (com.aggmoread.sdk.z.b.l.a) C0199a.this.f6243a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    a.a(C0199a.this.f6243a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!"));
                }
            }
        }

        /* renamed from: com.aggmoread.sdk.z.e.i.a$a$c */
        public class c implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.e.e.a f6249b;

            public c(com.aggmoread.sdk.z.e.e.a aVar) {
                this.f6249b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.a(this.f6249b, (com.aggmoread.sdk.z.b.k.a) C0199a.this.f6243a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    a.a(C0199a.this.f6243a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!"));
                }
            }
        }

        /* renamed from: com.aggmoread.sdk.z.e.i.a$a$d */
        public class d implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.e.e.a f6251b;

            public d(com.aggmoread.sdk.z.e.e.a aVar) {
                this.f6251b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.a(this.f6251b, (com.aggmoread.sdk.z.b.f.a) C0199a.this.f6243a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    a.a(C0199a.this.f6243a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!"));
                }
            }
        }

        /* renamed from: com.aggmoread.sdk.z.e.i.a$a$e */
        public class e implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.e.e.a f6253b;

            public e(com.aggmoread.sdk.z.e.e.a aVar) {
                this.f6253b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    new com.aggmoread.sdk.z.e.h.a().a(this.f6253b, (com.aggmoread.sdk.z.b.s.c) C0199a.this.f6243a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    a.a(C0199a.this.f6243a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!"));
                }
            }
        }

        public C0199a(com.aggmoread.sdk.z.b.i.b bVar, com.aggmoread.sdk.z.e.f.a aVar) {
            this.f6243a = bVar;
            this.f6244b = aVar;
        }

        @Override // com.aggmoread.sdk.z.b.p.a.f
        public void a(int i10, JSONObject jSONObject, com.aggmoread.sdk.z.b.g.e eVar) {
            Handler a10;
            Runnable eVar2;
            String str = "无广告填充!";
            try {
            } catch (Throwable th2) {
                th2.printStackTrace();
                a.a(this.f6243a, new com.aggmoread.sdk.z.b.g.e(10004, "请求数据解析错误"));
            }
            if (eVar != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(eVar.a());
                sb2.append(":");
                if (!TextUtils.isEmpty(eVar.b())) {
                    str = eVar.b();
                }
                sb2.append(str);
                a.a(this.f6243a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, sb2.toString()));
                return;
            }
            com.aggmoread.sdk.z.e.e.a b10 = com.aggmoread.sdk.z.e.e.a.b(jSONObject);
            if (b10 == null) {
                a.a(this.f6243a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "无广告填充!"));
                return;
            }
            if (b10.f()) {
                b10.a(this.f6244b);
                if (com.aggmoread.sdk.z.b.i.a.f4552b == this.f6244b.g()) {
                    a10 = n.a();
                    eVar2 = new RunnableC0200a(b10);
                } else if (com.aggmoread.sdk.z.b.i.a.f4553c == this.f6244b.g()) {
                    a10 = n.a();
                    eVar2 = new b(b10);
                } else if (com.aggmoread.sdk.z.b.i.a.f4554d == this.f6244b.g()) {
                    a10 = n.a();
                    eVar2 = new c(b10);
                } else if (com.aggmoread.sdk.z.b.i.a.f4555e == this.f6244b.g()) {
                    a10 = n.a();
                    eVar2 = new d(b10);
                } else if (com.aggmoread.sdk.z.b.i.a.f4556f == this.f6244b.g()) {
                    a10 = n.a();
                    eVar2 = new e(b10);
                }
                a10.post(eVar2);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(b10.f6159c);
                sb3.append(":");
                if (!TextUtils.isEmpty(b10.f6160d)) {
                    str = b10.f6160d;
                }
                sb3.append(str);
                a.a(this.f6243a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, sb3.toString()));
            }
            com.aggmoread.sdk.z.b.d.c("DSPDRTAG", "onResponse: " + jSONObject);
        }
    }

    public static class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ e f6255b;

        /* renamed from: c */
        final /* synthetic */ com.aggmoread.sdk.z.b.i.b f6256c;

        public b(e eVar, com.aggmoread.sdk.z.b.i.b bVar) {
            this.f6255b = eVar;
            this.f6256c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a("DSPDRTAG", "NFE %s", this.f6255b);
            this.f6256c.a(this.f6255b);
        }
    }

    private static int a(com.aggmoread.sdk.z.b.i.a aVar) {
        if (aVar.equals(com.aggmoread.sdk.z.b.i.a.f4552b)) {
            return 5;
        }
        return aVar.equals(com.aggmoread.sdk.z.b.i.a.f4553c) ? 2 : 0;
    }

    private static String a(Context context) {
        return System.getProperty("http.agent");
    }

    private static JSONObject a(com.aggmoread.sdk.z.e.f.a aVar) {
        com.aggmoread.sdk.z.b.g.a a10 = com.aggmoread.sdk.z.b.h.a.d().a(a.EnumC0075a.f4526e);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", UUID.randomUUID().toString());
            jSONObject.put("tagid", aVar.j());
            jSONObject.put("impType", a(aVar.g()));
            jSONObject.put("secure", 1);
            jSONObject.put("deepLink", 1);
            jSONObject.put("bidfloor", aVar.i());
            jSONObject.put("width", aVar.p());
            jSONObject.put("height", aVar.l());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("bundle", aVar.n());
            jSONObject2.put("ver", a10.b());
            jSONObject2.put("name", aVar.h());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(bd.f23524d, a(aVar.k()));
            String o10 = a10.o();
            if (TextUtils.isEmpty(o10)) {
                o10 = com.aggmoread.sdk.z.b.p.e.b(aVar.k());
            }
            jSONObject3.put("ip", o10);
            jSONObject3.put("devicetype", a10.A() ? 5 : 4);
            jSONObject3.put("make", a10.e());
            jSONObject3.put(bm.f6904i, a10.n());
            jSONObject3.put(bt.f23628x, "android");
            jSONObject3.put("osv", a10.q());
            jSONObject3.put("h", a10.h());
            jSONObject3.put(IAdInterListener.AdReqParam.WIDTH, a10.z());
            jSONObject3.put("ppi", a10.s());
            jSONObject3.put("did", a10.i());
            jSONObject3.put("didmd5", g.a(a10.i()));
            jSONObject3.put("androidId", a10.a());
            jSONObject3.put("androidIdMd5", g.a(a10.a()));
            jSONObject3.put(AdKeys.OAID, a10.p());
            jSONObject3.put("oaidMd5", g.a(a10.p()));
            jSONObject3.put("region", "CN");
            com.aggmoread.sdk.z.b.p.b a11 = com.aggmoread.sdk.z.b.p.e.a(aVar.k());
            jSONObject3.put(bt.P, a11.equals(com.aggmoread.sdk.z.b.p.b.f4778c) ? "mobile" : a11.equals(com.aggmoread.sdk.z.b.p.b.f4779d) ? "telecom" : a11.equals(com.aggmoread.sdk.z.b.p.b.f4780e) ? "unicom" : "unknown");
            if (a10.k() != null) {
                float latitude = (float) a10.k().getLatitude();
                float longitude = (float) a10.k().getLongitude();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(f.C, latitude);
                jSONObject4.put("lon", longitude);
                jSONObject3.put("geo", jSONObject4);
            }
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("id", UUID.randomUUID());
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("id", aVar.o());
            jSONObject6.put("test", 0);
            jSONObject6.put(PointCategory.APP, jSONObject2);
            jSONObject6.put(bd.f23523c, jSONArray);
            jSONObject6.put(bd.f23533m, jSONObject5);
            jSONObject6.put(h3.e.f26411p, jSONObject3);
            return jSONObject6;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static void a(com.aggmoread.sdk.z.b.i.b bVar, e eVar) {
        n.a().post(new b(eVar, bVar));
    }

    public static void a(com.aggmoread.sdk.z.e.e.a aVar, com.aggmoread.sdk.z.b.f.a aVar2) {
        if (!aVar.e()) {
            aVar2.a(new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "无数据填充!"));
            return;
        }
        a.C0192a.C0193a a10 = aVar.f6163g.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.aggmoread.sdk.z.e.d.a(aVar, a10, aVar2));
        aVar2.onAdLoaded(arrayList);
    }

    public static void a(com.aggmoread.sdk.z.e.e.a aVar, com.aggmoread.sdk.z.b.k.a aVar2) {
        if (!aVar.e()) {
            aVar2.a(new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "无数据填充!"));
            return;
        }
        a.C0192a.C0193a a10 = aVar.f6163g.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.aggmoread.sdk.z.e.g.a(aVar, a10, aVar2));
        aVar2.onAdLoaded(arrayList);
    }

    public static void a(com.aggmoread.sdk.z.e.e.a aVar, com.aggmoread.sdk.z.b.l.a aVar2) {
        if (!aVar.e()) {
            aVar2.a(new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "无数据填充!"));
            return;
        }
        a.C0192a.C0193a a10 = aVar.f6163g.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.aggmoread.sdk.z.e.i.b(aVar, a10));
        aVar2.onAdLoaded(arrayList);
    }

    public static void a(com.aggmoread.sdk.z.e.f.a aVar, com.aggmoread.sdk.z.b.i.b bVar) {
        d.c("DSPDRTAG", "loadData enter , Request = " + aVar);
        JSONObject a10 = a(aVar);
        String str = "http://bid-adx.vlion.cn/main?media=" + aVar.m();
        d.c("DSPDRTAG", "rsUrl = " + str);
        d.c("DSPDRTAG", "json : " + a10.toString());
        d.d(a10.toString(), "getDspUrl() = Json ");
        com.aggmoread.sdk.z.b.p.a.a(str, a10, (Map<String, String>) null, new C0199a(bVar, aVar));
    }
}
