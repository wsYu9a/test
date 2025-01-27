package b.d.e.c.c.b;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import b.d.e.c.a.d;
import b.d.e.c.a.f.e;
import b.d.e.c.a.j.a;
import b.d.e.c.a.l.c;
import b.d.e.c.c.a.a;
import com.baidu.mobads.sdk.internal.bj;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.d.b.j;
import com.vivo.ic.dm.Constants;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: b.d.e.c.c.b.a$a */
    static class C0041a implements a.f {

        /* renamed from: a */
        final /* synthetic */ b.d.e.c.a.g.b f4728a;

        /* renamed from: b */
        final /* synthetic */ com.martian.ttbook.b.b.b.a f4729b;

        /* renamed from: b.d.e.c.c.b.a$a$a */
        class RunnableC0042a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ b.d.e.c.c.a.a f4730a;

            RunnableC0042a(b.d.e.c.c.a.a aVar) {
                this.f4730a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    new b.d.e.c.c.c.a().h(this.f4730a, (c) C0041a.this.f4728a);
                } catch (Throwable th) {
                    th.printStackTrace();
                    a.a(C0041a.this.f4728a, new e(50003, "SDK内部处理异常!   -->" + th.toString()));
                }
            }
        }

        /* renamed from: b.d.e.c.c.b.a$a$b */
        class b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ b.d.e.c.c.a.a f4732a;

            b(b.d.e.c.c.a.a aVar) {
                this.f4732a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.b(this.f4732a, (b.d.e.c.a.h.a) C0041a.this.f4728a);
                } catch (Throwable th) {
                    th.printStackTrace();
                    a.a(C0041a.this.f4728a, new e(50003, "SDK内部处理异常!"));
                }
            }
        }

        C0041a(b.d.e.c.a.g.b bVar, com.martian.ttbook.b.b.b.a aVar) {
            this.f4728a = bVar;
            this.f4729b = aVar;
        }

        @Override // b.d.e.c.a.j.a.f
        public void a(int i2, JSONObject jSONObject, e eVar) {
            Handler a2;
            Runnable bVar;
            String str = "无广告填充!";
            try {
            } catch (Throwable th) {
                th.printStackTrace();
                a.a(this.f4728a, new e(MartianRPUserManager.f14920g, "请求数据解析错误"));
            }
            if (eVar != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(eVar.a());
                sb.append(":");
                if (!TextUtils.isEmpty(eVar.b())) {
                    str = eVar.b();
                }
                sb.append(str);
                a.a(this.f4728a, new e(Constants.NOTI_ID_DOWNLOAD_ACTIVE_MULTI, sb.toString()));
                return;
            }
            b.d.e.c.c.a.a h2 = b.d.e.c.c.a.a.h(jSONObject);
            if (h2 == null) {
                a.a(this.f4728a, new e(Constants.NOTI_ID_DOWNLOAD_ACTIVE_MULTI, "无广告填充!"));
                return;
            }
            if (h2.l()) {
                h2.f(this.f4729b);
                if (b.d.e.c.a.g.a.f4619a == this.f4729b.t()) {
                    a2 = n.a();
                    bVar = new RunnableC0042a(h2);
                } else if (b.d.e.c.a.g.a.f4620b == this.f4729b.t()) {
                    a2 = n.a();
                    bVar = new b(h2);
                }
                a2.post(bVar);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(h2.f4712c);
                sb2.append(":");
                if (!TextUtils.isEmpty(h2.f4713d)) {
                    str = h2.f4713d;
                }
                sb2.append(str);
                a.a(this.f4728a, new e(Constants.NOTI_ID_DOWNLOAD_ACTIVE_MULTI, sb2.toString()));
            }
            d.k("DSPDRTAG", "onResponse: " + jSONObject);
        }
    }

    static class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ e f4734a;

        /* renamed from: b */
        final /* synthetic */ b.d.e.c.a.g.b f4735b;

        b(e eVar, b.d.e.c.a.g.b bVar) {
            this.f4734a = eVar;
            this.f4735b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.f("DSPDRTAG", "NFE %s", this.f4734a);
            this.f4735b.b(this.f4734a);
        }
    }

    public static void a(b.d.e.c.a.g.b bVar, e eVar) {
        n.a().post(new b(eVar, bVar));
    }

    public static void b(b.d.e.c.c.a.a aVar, b.d.e.c.a.h.a aVar2) {
        if (!aVar.k()) {
            aVar2.b(new e(Constants.NOTI_ID_DOWNLOAD_ACTIVE_MULTI, "无数据填充!"));
            return;
        }
        a.C0038a.C0039a a2 = aVar.f4714e.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b.d.e.c.c.b.b(aVar, a2));
        aVar2.onAdLoaded(arrayList);
    }

    public static void c(com.martian.ttbook.b.b.b.a aVar, b.d.e.c.a.g.b bVar) {
        d.k("DSPDRTAG", "loadData enter , Request = " + aVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("slotCode", aVar.u());
            jSONObject.put("request_id", aVar.w());
            jSONObject.put("slot_type", aVar.t().a());
            jSONObject.put("imei", com.martian.ttbook.b.a.g.a.f().d().c());
            jSONObject.put("oaid", com.martian.ttbook.b.a.g.a.f().d().i());
            jSONObject.put("os_type", "1");
            jSONObject.put(bj.f5605j, Build.BRAND);
            jSONObject.put(bj.f5604i, Build.MODEL);
            jSONObject.put("package_name", aVar.v().getPackageName());
            jSONObject.put("ip", b.d.e.c.a.j.e.c(aVar.v()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String d2 = j.d();
        d.k("DSPDRTAG", "getDspUrl() = " + d2);
        d.n(jSONObject.toString(), "getDspUrl() = Json ");
        b.d.e.c.a.j.a.c(d2, jSONObject, null, new C0041a(bVar, aVar));
    }
}
