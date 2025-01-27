package com.aggmoread.sdk.z.c.c;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.b.d;
import com.aggmoread.sdk.z.b.h.a;
import com.aggmoread.sdk.z.b.m.n;
import com.aggmoread.sdk.z.b.p.a;
import com.aggmoread.sdk.z.b.s.e;
import com.aggmoread.sdk.z.c.a.a;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import com.baidu.mobads.sdk.internal.bm;
import com.shu.priory.config.AdKeys;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: com.aggmoread.sdk.z.c.c.a$a */
    public static class C0105a implements a.f {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.b.i.b f5132a;

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.c.b.a f5133b;

        /* renamed from: com.aggmoread.sdk.z.c.c.a$a$a */
        public class RunnableC0106a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.c.a.a f5134b;

            public RunnableC0106a(com.aggmoread.sdk.z.c.a.a aVar) {
                this.f5134b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    new com.aggmoread.sdk.z.c.d.a().a(this.f5134b, (e) C0105a.this.f5132a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    a.a(C0105a.this.f5132a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!   -->" + th2.toString()));
                }
            }
        }

        /* renamed from: com.aggmoread.sdk.z.c.c.a$a$b */
        public class b implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.c.a.a f5136b;

            public b(com.aggmoread.sdk.z.c.a.a aVar) {
                this.f5136b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.a(this.f5136b, (com.aggmoread.sdk.z.b.l.a) C0105a.this.f5132a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    a.a(C0105a.this.f5132a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!"));
                }
            }
        }

        public C0105a(com.aggmoread.sdk.z.b.i.b bVar, com.aggmoread.sdk.z.c.b.a aVar) {
            this.f5132a = bVar;
            this.f5133b = aVar;
        }

        @Override // com.aggmoread.sdk.z.b.p.a.f
        public void a(int i10, JSONObject jSONObject, com.aggmoread.sdk.z.b.g.e eVar) {
            Handler a10;
            Runnable bVar;
            String str = "无广告填充!";
            try {
            } catch (Throwable th2) {
                th2.printStackTrace();
                a.a(this.f5132a, new com.aggmoread.sdk.z.b.g.e(10004, "请求数据解析错误"));
            }
            if (eVar != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(eVar.a());
                sb2.append(":");
                if (!TextUtils.isEmpty(eVar.b())) {
                    str = eVar.b();
                }
                sb2.append(str);
                a.a(this.f5132a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, sb2.toString()));
                return;
            }
            com.aggmoread.sdk.z.c.a.a b10 = com.aggmoread.sdk.z.c.a.a.b(jSONObject);
            if (b10 == null) {
                a.a(this.f5132a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "无广告填充!"));
                return;
            }
            if (b10.f()) {
                b10.a(this.f5133b);
                if (com.aggmoread.sdk.z.b.i.a.f4552b == this.f5133b.g()) {
                    a10 = n.a();
                    bVar = new RunnableC0106a(b10);
                } else if (com.aggmoread.sdk.z.b.i.a.f4553c == this.f5133b.g()) {
                    a10 = n.a();
                    bVar = new b(b10);
                }
                a10.post(bVar);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(b10.f5088c);
                sb3.append(":");
                if (!TextUtils.isEmpty(b10.f5089d)) {
                    str = b10.f5089d;
                }
                sb3.append(str);
                a.a(this.f5132a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, sb3.toString()));
            }
            d.c("DSPDRTAG", "onResponse: " + jSONObject);
        }
    }

    public static class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.b.g.e f5138b;

        /* renamed from: c */
        final /* synthetic */ com.aggmoread.sdk.z.b.i.b f5139c;

        public b(com.aggmoread.sdk.z.b.g.e eVar, com.aggmoread.sdk.z.b.i.b bVar) {
            this.f5138b = eVar;
            this.f5139c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a("DSPDRTAG", "NFE %s", this.f5138b);
            this.f5139c.a(this.f5138b);
        }
    }

    public static void a(com.aggmoread.sdk.z.b.i.b bVar, com.aggmoread.sdk.z.b.g.e eVar) {
        n.a().post(new b(eVar, bVar));
    }

    public static void a(com.aggmoread.sdk.z.c.a.a aVar, com.aggmoread.sdk.z.b.l.a aVar2) {
        if (!aVar.e()) {
            aVar2.a(new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "无数据填充!"));
            return;
        }
        a.C0101a.C0102a a10 = aVar.f5090e.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.aggmoread.sdk.z.c.c.b(aVar, a10));
        aVar2.onAdLoaded(arrayList);
    }

    public static void a(com.aggmoread.sdk.z.c.b.a aVar, com.aggmoread.sdk.z.b.i.b bVar) {
        d.c("DSPDRTAG", "loadData enter , Request = " + aVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("slotCode", aVar.h());
            jSONObject.put(AdKeys.REQUEST_ID, aVar.j());
            jSONObject.put("slot_type", aVar.g().a());
            com.aggmoread.sdk.z.b.h.a d10 = com.aggmoread.sdk.z.b.h.a.d();
            a.EnumC0075a enumC0075a = a.EnumC0075a.f4524c;
            jSONObject.put("imei", d10.a(enumC0075a).i());
            jSONObject.put(AdKeys.OAID, com.aggmoread.sdk.z.b.h.a.d().a(enumC0075a).p());
            jSONObject.put("os_type", "1");
            jSONObject.put(bm.f6905j, Build.BRAND);
            jSONObject.put(bm.f6904i, Build.MODEL);
            jSONObject.put("package_name", aVar.i().getPackageName());
            jSONObject.put("ip", com.aggmoread.sdk.z.b.p.e.b(aVar.i()));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        String d11 = j.d();
        d.c("DSPDRTAG", "getDspUrl() = " + d11);
        d.d(jSONObject.toString(), "getDspUrl() = Json ");
        com.aggmoread.sdk.z.b.p.a.a(d11, jSONObject, (Map<String, String>) null, new C0105a(bVar, aVar));
    }
}
