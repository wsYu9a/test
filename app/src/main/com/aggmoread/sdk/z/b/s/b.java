package com.aggmoread.sdk.z.b.s;

import android.os.Handler;
import android.text.TextUtils;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.b.g.b;
import com.aggmoread.sdk.z.b.m.n;
import com.aggmoread.sdk.z.b.p.a;
import com.kwad.sdk.core.scene.URLPackage;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    public static class a implements a.f {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.b.i.b f4848a;

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.b.h.c f4849b;

        /* renamed from: com.aggmoread.sdk.z.b.s.b$a$a */
        public class RunnableC0092a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.b.g.b f4850b;

            public RunnableC0092a(com.aggmoread.sdk.z.b.g.b bVar) {
                this.f4850b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    new g().a(this.f4850b, (com.aggmoread.sdk.z.b.s.e) a.this.f4848a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    b.a(a.this.f4848a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!   -->" + th2.toString()));
                }
            }
        }

        /* renamed from: com.aggmoread.sdk.z.b.s.b$a$b */
        public class RunnableC0093b implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.b.g.b f4852b;

            public RunnableC0093b(com.aggmoread.sdk.z.b.g.b bVar) {
                this.f4852b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.a(this.f4852b, (com.aggmoread.sdk.z.b.l.a) a.this.f4848a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    b.a(a.this.f4848a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!"));
                }
            }
        }

        public class c implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.b.g.b f4854b;

            public c(com.aggmoread.sdk.z.b.g.b bVar) {
                this.f4854b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    new com.aggmoread.sdk.z.b.o.b().a(this.f4854b, (com.aggmoread.sdk.z.b.s.c) a.this.f4848a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    b.a(a.this.f4848a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!"));
                }
            }
        }

        public class d implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.b.g.b f4856b;

            public d(com.aggmoread.sdk.z.b.g.b bVar) {
                this.f4856b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.a(this.f4856b, (com.aggmoread.sdk.z.b.k.a) a.this.f4848a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    b.a(a.this.f4848a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!"));
                }
            }
        }

        public class e implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.b.g.b f4858b;

            public e(com.aggmoread.sdk.z.b.g.b bVar) {
                this.f4858b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.a(this.f4858b, (com.aggmoread.sdk.z.b.f.a) a.this.f4848a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    b.a(a.this.f4848a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!"));
                }
            }
        }

        public a(com.aggmoread.sdk.z.b.i.b bVar, com.aggmoread.sdk.z.b.h.c cVar) {
            this.f4848a = bVar;
            this.f4849b = cVar;
        }

        @Override // com.aggmoread.sdk.z.b.p.a.f
        public void a(int i10, JSONObject jSONObject, com.aggmoread.sdk.z.b.g.e eVar) {
            Handler a10;
            Runnable eVar2;
            String str = "无广告填充!";
            try {
            } catch (Throwable th2) {
                th2.printStackTrace();
                b.a(this.f4848a, new com.aggmoread.sdk.z.b.g.e(10004, "请求数据解析错误"));
            }
            if (eVar != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(eVar.a());
                sb2.append(":");
                if (!TextUtils.isEmpty(eVar.b())) {
                    str = eVar.b();
                }
                sb2.append(str);
                b.a(this.f4848a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, sb2.toString()));
                return;
            }
            com.aggmoread.sdk.z.b.g.b b10 = com.aggmoread.sdk.z.b.g.b.b(jSONObject);
            if (b10 == null) {
                b.a(this.f4848a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "无广告填充!"));
                return;
            }
            if (b10.f()) {
                b10.a(this.f4849b);
                if (com.aggmoread.sdk.z.b.i.a.f4552b == this.f4849b.h()) {
                    a10 = n.a();
                    eVar2 = new RunnableC0092a(b10);
                } else if (com.aggmoread.sdk.z.b.i.a.f4553c == this.f4849b.h()) {
                    a10 = n.a();
                    eVar2 = new RunnableC0093b(b10);
                } else if (com.aggmoread.sdk.z.b.i.a.f4556f == this.f4849b.h()) {
                    a10 = n.a();
                    eVar2 = new c(b10);
                } else if (com.aggmoread.sdk.z.b.i.a.f4554d == this.f4849b.h()) {
                    a10 = n.a();
                    eVar2 = new d(b10);
                } else if (com.aggmoread.sdk.z.b.i.a.f4555e == this.f4849b.h()) {
                    a10 = n.a();
                    eVar2 = new e(b10);
                }
                a10.post(eVar2);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(b10.f4441c);
                sb3.append(":");
                if (!TextUtils.isEmpty(b10.f4442d)) {
                    str = b10.f4442d;
                }
                sb3.append(str);
                b.a(this.f4848a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, sb3.toString()));
            }
            com.aggmoread.sdk.z.b.d.c("ADRIML", "onResponse: " + jSONObject);
        }
    }

    /* renamed from: com.aggmoread.sdk.z.b.s.b$b */
    public static class RunnableC0094b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.b.g.e f4860b;

        /* renamed from: c */
        final /* synthetic */ com.aggmoread.sdk.z.b.i.b f4861c;

        public RunnableC0094b(com.aggmoread.sdk.z.b.g.e eVar, com.aggmoread.sdk.z.b.i.b bVar) {
            this.f4860b = eVar;
            this.f4861c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aggmoread.sdk.z.b.d.a("ADRIML", "NFE %s", this.f4860b);
            this.f4861c.a(this.f4860b);
        }
    }

    public static void a(com.aggmoread.sdk.z.b.g.b bVar, com.aggmoread.sdk.z.b.f.a aVar) {
        if (!bVar.e()) {
            aVar.a(new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "无数据填充!"));
            return;
        }
        b.a.C0072a a10 = bVar.f4443e.get(0).a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.aggmoread.sdk.z.b.f.c(bVar, a10, aVar));
        aVar.onAdLoaded(arrayList);
    }

    public static void a(com.aggmoread.sdk.z.b.g.b bVar, com.aggmoread.sdk.z.b.k.a aVar) {
        if (!bVar.e()) {
            aVar.a(new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "无数据填充!"));
            return;
        }
        b.a.C0072a a10 = bVar.f4443e.get(0).a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.aggmoread.sdk.z.b.k.b(bVar, a10, aVar));
        aVar.onAdLoaded(arrayList);
    }

    public static void a(com.aggmoread.sdk.z.b.g.b bVar, com.aggmoread.sdk.z.b.l.a aVar) {
        if (!bVar.e()) {
            aVar.a(new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "无数据填充!"));
            return;
        }
        b.a.C0072a a10 = bVar.f4443e.get(0).a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.aggmoread.sdk.z.b.l.d(bVar, a10));
        aVar.onAdLoaded(arrayList);
    }

    public static void a(com.aggmoread.sdk.z.b.h.c cVar, com.aggmoread.sdk.z.b.i.b bVar) {
        com.aggmoread.sdk.z.b.d.c("ADRIML", "loadData enter , Request = " + cVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", cVar.k());
            jSONObject.put(h3.e.f26411p, new com.aggmoread.sdk.z.b.g.d().a(cVar.j()));
            jSONObject.put(PointCategory.NETWORK, new com.aggmoread.sdk.z.b.g.f().a(cVar.j()));
            jSONObject.put(URLPackage.KEY_CHANNEL_ID, cVar.i());
            jSONObject.put("pageInfo", new JSONObject());
            jSONObject.put("apiType", "sdk");
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        String str = cVar.o() ? "http://a.wearewinner.cn:15921/api/test/ads" : "http://a.wearewinner.cn:15921/api/ads";
        com.aggmoread.sdk.z.b.d.c("ADRIML", "json : " + jSONObject.toString());
        com.aggmoread.sdk.z.b.d.d(jSONObject.toString(), "getApiUrl() = " + str);
        com.aggmoread.sdk.z.b.p.a.a(str, jSONObject, (Map<String, String>) null, new a(bVar, cVar));
    }

    public static void a(com.aggmoread.sdk.z.b.i.b bVar, com.aggmoread.sdk.z.b.g.e eVar) {
        n.a().post(new RunnableC0094b(eVar, bVar));
    }
}
