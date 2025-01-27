package b.d.e.c.a.l;

import android.os.Handler;
import android.text.TextUtils;
import b.d.e.c.a.f.b;
import b.d.e.c.a.j.a;
import com.baidu.mobads.sdk.internal.bj;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbook.b.a.k.n;
import com.vivo.ic.dm.Constants;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b {

    static class a implements a.f {

        /* renamed from: a */
        final /* synthetic */ b.d.e.c.a.g.b f4673a;

        /* renamed from: b */
        final /* synthetic */ com.martian.ttbook.b.a.g.c f4674b;

        /* renamed from: b.d.e.c.a.l.b$a$a */
        class RunnableC0032a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ b.d.e.c.a.f.b f4675a;

            RunnableC0032a(b.d.e.c.a.f.b bVar) {
                this.f4675a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    new e().g(this.f4675a, (c) a.this.f4673a);
                } catch (Throwable th) {
                    th.printStackTrace();
                    b.c(a.this.f4673a, new b.d.e.c.a.f.e(50003, "SDK内部处理异常!   -->" + th.toString()));
                }
            }
        }

        /* renamed from: b.d.e.c.a.l.b$a$b */
        class RunnableC0033b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ b.d.e.c.a.f.b f4677a;

            RunnableC0033b(b.d.e.c.a.f.b bVar) {
                this.f4677a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.a(this.f4677a, (b.d.e.c.a.h.a) a.this.f4673a);
                } catch (Throwable th) {
                    th.printStackTrace();
                    b.c(a.this.f4673a, new b.d.e.c.a.f.e(50003, "SDK内部处理异常!"));
                }
            }
        }

        a(b.d.e.c.a.g.b bVar, com.martian.ttbook.b.a.g.c cVar) {
            this.f4673a = bVar;
            this.f4674b = cVar;
        }

        @Override // b.d.e.c.a.j.a.f
        public void a(int i2, JSONObject jSONObject, b.d.e.c.a.f.e eVar) {
            Handler a2;
            Runnable runnableC0033b;
            String str = "无广告填充!";
            try {
            } catch (Throwable th) {
                th.printStackTrace();
                b.c(this.f4673a, new b.d.e.c.a.f.e(MartianRPUserManager.f14920g, "请求数据解析错误"));
            }
            if (eVar != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(eVar.a());
                sb.append(":");
                if (!TextUtils.isEmpty(eVar.b())) {
                    str = eVar.b();
                }
                sb.append(str);
                b.c(this.f4673a, new b.d.e.c.a.f.e(Constants.NOTI_ID_DOWNLOAD_ACTIVE_MULTI, sb.toString()));
                return;
            }
            b.d.e.c.a.f.b j2 = b.d.e.c.a.f.b.j(jSONObject);
            if (j2 == null) {
                b.c(this.f4673a, new b.d.e.c.a.f.e(Constants.NOTI_ID_DOWNLOAD_ACTIVE_MULTI, "无广告填充!"));
                return;
            }
            if (j2.n()) {
                j2.g(this.f4674b);
                if (b.d.e.c.a.g.a.f4619a == this.f4674b.u()) {
                    a2 = n.a();
                    runnableC0033b = new RunnableC0032a(j2);
                } else if (b.d.e.c.a.g.a.f4620b == this.f4674b.u()) {
                    a2 = n.a();
                    runnableC0033b = new RunnableC0033b(j2);
                }
                a2.post(runnableC0033b);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(j2.f4566c);
                sb2.append(":");
                if (!TextUtils.isEmpty(j2.f4567d)) {
                    str = j2.f4567d;
                }
                sb2.append(str);
                b.c(this.f4673a, new b.d.e.c.a.f.e(Constants.NOTI_ID_DOWNLOAD_ACTIVE_MULTI, sb2.toString()));
            }
            b.d.e.c.a.d.k("ADRIML", "onResponse: " + jSONObject);
        }
    }

    /* renamed from: b.d.e.c.a.l.b$b */
    static class RunnableC0034b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ b.d.e.c.a.f.e f4679a;

        /* renamed from: b */
        final /* synthetic */ b.d.e.c.a.g.b f4680b;

        RunnableC0034b(b.d.e.c.a.f.e eVar, b.d.e.c.a.g.b bVar) {
            this.f4679a = eVar;
            this.f4680b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.d.e.c.a.d.f("ADRIML", "NFE %s", this.f4679a);
            this.f4680b.b(this.f4679a);
        }
    }

    public static void a(b.d.e.c.a.f.b bVar, b.d.e.c.a.h.a aVar) {
        if (!bVar.m()) {
            aVar.b(new b.d.e.c.a.f.e(Constants.NOTI_ID_DOWNLOAD_ACTIVE_MULTI, "无数据填充!"));
            return;
        }
        b.a.C0022a a2 = bVar.f4568e.get(0).a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b.d.e.c.a.h.d(bVar, a2));
        aVar.onAdLoaded(arrayList);
    }

    public static void b(com.martian.ttbook.b.a.g.c cVar, b.d.e.c.a.g.b bVar) {
        b.d.e.c.a.d.k("ADRIML", "loadData enter , Request = " + cVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", cVar.x());
            jSONObject.put("device", new b.d.e.c.a.f.d().b(cVar.w()));
            jSONObject.put("network", new b.d.e.c.a.f.f().c(cVar.w()));
            jSONObject.put("channelId", cVar.v());
            jSONObject.put("apiType", bj.f5602g);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        b.d.e.c.a.d.k("ADRIML", "getApiUrl() = http://39.97.28.133:8898/api/test/ads");
        b.d.e.c.a.d.n(jSONObject.toString(), "getApiUrl() = Json ");
        b.d.e.c.a.j.a.c("http://39.97.28.133:8898/api/test/ads", jSONObject, null, new a(bVar, cVar));
    }

    public static void c(b.d.e.c.a.g.b bVar, b.d.e.c.a.f.e eVar) {
        n.a().post(new RunnableC0034b(eVar, bVar));
    }
}
