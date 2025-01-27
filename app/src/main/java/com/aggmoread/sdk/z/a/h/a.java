package com.aggmoread.sdk.z.a.h;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.media3.session.SessionCommand;
import com.aggmoread.sdk.z.a.d.a;
import com.aggmoread.sdk.z.b.d;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.h.a;
import com.aggmoread.sdk.z.b.j.g;
import com.aggmoread.sdk.z.b.m.n;
import com.aggmoread.sdk.z.b.p.a;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import com.baidu.mobads.sdk.internal.bm;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.shu.priory.config.AdKeys;
import com.sigmob.sdk.base.mta.PointCategory;
import com.umeng.analytics.pro.bt;
import com.vivo.push.PushClientConstants;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: com.aggmoread.sdk.z.a.h.a$a */
    public static class C0059a implements a.f {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.b.i.b f4287a;

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.a.e.a f4288b;

        /* renamed from: com.aggmoread.sdk.z.a.h.a$a$a */
        public class RunnableC0060a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.a.d.a f4289b;

            public RunnableC0060a(com.aggmoread.sdk.z.a.d.a aVar) {
                this.f4289b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    new com.aggmoread.sdk.z.a.j.a().a(this.f4289b, (com.aggmoread.sdk.z.b.s.e) C0059a.this.f4287a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    a.a(C0059a.this.f4287a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!   -->" + th2.toString()));
                }
            }
        }

        /* renamed from: com.aggmoread.sdk.z.a.h.a$a$b */
        public class b implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.a.d.a f4291b;

            public b(com.aggmoread.sdk.z.a.d.a aVar) {
                this.f4291b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.a(this.f4291b, (com.aggmoread.sdk.z.b.l.a) C0059a.this.f4287a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    a.a(C0059a.this.f4287a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!"));
                }
            }
        }

        /* renamed from: com.aggmoread.sdk.z.a.h.a$a$c */
        public class c implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.a.d.a f4293b;

            public c(com.aggmoread.sdk.z.a.d.a aVar) {
                this.f4293b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    new com.aggmoread.sdk.z.a.i.a().a(this.f4293b, (com.aggmoread.sdk.z.b.s.d) C0059a.this.f4287a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    a.a(C0059a.this.f4287a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!"));
                }
            }
        }

        /* renamed from: com.aggmoread.sdk.z.a.h.a$a$d */
        public class d implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.a.d.a f4295b;

            public d(com.aggmoread.sdk.z.a.d.a aVar) {
                this.f4295b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    new com.aggmoread.sdk.z.a.g.a().a(this.f4295b, (com.aggmoread.sdk.z.b.s.c) C0059a.this.f4287a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    a.a(C0059a.this.f4287a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!"));
                }
            }
        }

        /* renamed from: com.aggmoread.sdk.z.a.h.a$a$e */
        public class e implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.a.d.a f4297b;

            public e(com.aggmoread.sdk.z.a.d.a aVar) {
                this.f4297b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.a(this.f4297b, (com.aggmoread.sdk.z.b.k.a) C0059a.this.f4287a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    a.a(C0059a.this.f4287a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!"));
                }
            }
        }

        /* renamed from: com.aggmoread.sdk.z.a.h.a$a$f */
        public class f implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.a.d.a f4299b;

            public f(com.aggmoread.sdk.z.a.d.a aVar) {
                this.f4299b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.a(this.f4299b, (com.aggmoread.sdk.z.b.f.a) C0059a.this.f4287a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    a.a(C0059a.this.f4287a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, "SDK内部处理异常!"));
                }
            }
        }

        public C0059a(com.aggmoread.sdk.z.b.i.b bVar, com.aggmoread.sdk.z.a.e.a aVar) {
            this.f4287a = bVar;
            this.f4288b = aVar;
        }

        @Override // com.aggmoread.sdk.z.b.p.a.f
        public void a(int i10, JSONObject jSONObject, com.aggmoread.sdk.z.b.g.e eVar) {
            Handler a10;
            Runnable fVar;
            String str = "无广告填充!";
            try {
            } catch (Throwable th2) {
                th2.printStackTrace();
                a.a(this.f4287a, new com.aggmoread.sdk.z.b.g.e(10004, "请求数据解析错误"));
            }
            if (eVar != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(eVar.a());
                sb2.append(":");
                if (!TextUtils.isEmpty(eVar.b())) {
                    str = eVar.b();
                }
                sb2.append(str);
                a.a(this.f4287a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, sb2.toString()));
                return;
            }
            com.aggmoread.sdk.z.a.d.a b10 = com.aggmoread.sdk.z.a.d.a.b(jSONObject);
            if (b10 == null) {
                a.a(this.f4287a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "无广告填充!"));
                return;
            }
            if (b10.f()) {
                b10.a(this.f4288b);
                if (com.aggmoread.sdk.z.b.i.a.f4552b == this.f4288b.g()) {
                    a10 = n.a();
                    fVar = new RunnableC0060a(b10);
                } else if (com.aggmoread.sdk.z.b.i.a.f4553c == this.f4288b.g()) {
                    a10 = n.a();
                    fVar = new b(b10);
                } else if (com.aggmoread.sdk.z.b.i.a.f4557g == this.f4288b.g()) {
                    a10 = n.a();
                    fVar = new c(b10);
                } else if (com.aggmoread.sdk.z.b.i.a.f4556f == this.f4288b.g()) {
                    a10 = n.a();
                    fVar = new d(b10);
                } else if (com.aggmoread.sdk.z.b.i.a.f4554d == this.f4288b.g()) {
                    a10 = n.a();
                    fVar = new e(b10);
                } else if (com.aggmoread.sdk.z.b.i.a.f4555e == this.f4288b.g()) {
                    a10 = n.a();
                    fVar = new f(b10);
                }
                a10.post(fVar);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(b10.f4151c);
                sb3.append(":");
                if (!TextUtils.isEmpty(b10.f4152d)) {
                    str = b10.f4152d;
                }
                sb3.append(str);
                a.a(this.f4287a, new com.aggmoread.sdk.z.b.g.e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, sb3.toString()));
            }
            com.aggmoread.sdk.z.b.d.c("AGDRTAG", "onResponse: " + jSONObject);
        }
    }

    public static class b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ e f4301b;

        /* renamed from: c */
        final /* synthetic */ com.aggmoread.sdk.z.b.i.b f4302c;

        public b(e eVar, com.aggmoread.sdk.z.b.i.b bVar) {
            this.f4301b = eVar;
            this.f4302c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a("AGDRTAG", "NFE %s", this.f4301b);
            this.f4302c.a(this.f4301b);
        }
    }

    private static int a(Context context) {
        int c10 = com.aggmoread.sdk.z.b.p.e.c(context);
        if (c10 == 100) {
            return 6;
        }
        if (c10 == 1) {
            return 1;
        }
        if (c10 == 2) {
            return 2;
        }
        if (c10 == 3) {
            return 3;
        }
        if (c10 != 4) {
            return c10 != 5 ? 1 : 5;
        }
        return 4;
    }

    private static int b(Context context) {
        return context.getResources().getConfiguration().orientation == 2 ? 2 : 1;
    }

    private static int a(com.aggmoread.sdk.z.b.i.a aVar) {
        if (aVar.equals(com.aggmoread.sdk.z.b.i.a.f4552b)) {
            return 5;
        }
        return aVar.equals(com.aggmoread.sdk.z.b.i.a.f4553c) ? 2 : 0;
    }

    private static JSONObject b(com.aggmoread.sdk.z.a.e.a aVar) {
        com.aggmoread.sdk.z.b.g.a a10 = com.aggmoread.sdk.z.b.h.a.d().a(a.EnumC0075a.f4525d);
        try {
            String a11 = a(aVar);
            String a12 = a(a11, aVar.n());
            JSONObject jSONObject = new JSONObject();
            int i10 = 1;
            jSONObject.put("id", 1);
            jSONObject.put("bidfloor", aVar.i());
            jSONObject.put("width", aVar.r());
            jSONObject.put("height", aVar.l());
            if (aVar.g() == com.aggmoread.sdk.z.b.i.a.f4557g) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("videoType", 2);
                jSONObject2.put("orientation", 1);
                jSONObject2.put("delivery", 0);
                jSONObject2.put("maxLength", 0);
                jSONObject2.put("minDuration", 0);
                jSONObject2.put("maxDuration", 0);
                jSONObject.put("video", jSONObject2);
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(PushClientConstants.TAG_PKG_NAME, aVar.o());
            jSONObject3.put("version", a10.b());
            jSONObject3.put("appName", aVar.h());
            JSONObject jSONObject4 = new JSONObject();
            String i11 = a10.i();
            if (TextUtils.isEmpty(i11)) {
                i11 = !TextUtils.isEmpty(a10.p()) ? g.a(a10.p()) : a10.a();
            }
            jSONObject4.put("deviceId", i11);
            jSONObject4.put(PointCategory.NETWORK, a(aVar.k()));
            jSONObject4.put("deviceType", a10.A() ? 2 : 1);
            jSONObject4.put(bm.f6905j, a10.e());
            jSONObject4.put(bm.f6904i, a10.n());
            jSONObject4.put(bt.f23628x, "android");
            jSONObject4.put("osVersion", a10.q());
            jSONObject4.put("screenHeight", a10.h());
            jSONObject4.put("screenWidth", a10.z());
            jSONObject4.put("imei", a10.i());
            jSONObject4.put("imeiMd5", g.a(a10.i()));
            jSONObject4.put("androidId", a10.a());
            jSONObject4.put("androidIdMd5", g.a(a10.a()));
            String p10 = a10.p();
            d.c("AGDRTAG", "makeRequestBody oaid: " + p10);
            String a13 = g.a(p10);
            d.c("AGDRTAG", "makeRequestBody oaidMD5: " + a13);
            jSONObject4.put(AdKeys.OAID, p10);
            jSONObject4.put("oaidMd5", a13);
            jSONObject4.put("mac", a(a10.l()));
            jSONObject4.put("macMd5", g.a(a10.l()));
            String o10 = a10.o();
            if (TextUtils.isEmpty(o10)) {
                o10 = com.aggmoread.sdk.z.b.p.e.b(aVar.k());
            }
            jSONObject4.put("ip", o10);
            jSONObject4.put("ipMd5", g.a(o10));
            jSONObject4.put(TTDownloadField.TT_USERAGENT, a10.w());
            jSONObject4.put("orientation", b(aVar.k()));
            com.aggmoread.sdk.z.b.p.b a14 = com.aggmoread.sdk.z.b.p.e.a(aVar.k());
            if (!a14.equals(com.aggmoread.sdk.z.b.p.b.f4778c)) {
                i10 = a14.equals(com.aggmoread.sdk.z.b.p.b.f4779d) ? 3 : a14.equals(com.aggmoread.sdk.z.b.p.b.f4780e) ? 2 : 9;
            }
            jSONObject4.put(bt.P, i10);
            if (a10.k() != null) {
                double latitude = a10.k().getLatitude();
                double longitude = a10.k().getLongitude();
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("latitude", latitude);
                jSONObject5.put("longitude", longitude);
                jSONObject4.put("geo", jSONObject5);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("requestId", a11);
            jSONObject6.put(x2.b.f31793n, a12);
            jSONObject6.put("impType", a(aVar.g()));
            jSONObject6.put("version", aVar.q());
            jSONObject6.put("timeout", aVar.p());
            jSONObject6.put("imps", jSONArray);
            jSONObject6.put(PointCategory.APP, jSONObject3);
            jSONObject6.put(h3.e.f26411p, jSONObject4);
            return jSONObject6;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private static String a(com.aggmoread.sdk.z.a.e.a aVar) {
        try {
            String j10 = aVar.j();
            String m10 = aVar.m();
            StringBuilder sb2 = new StringBuilder();
            String format = new DecimalFormat("00000").format(Integer.parseInt(m10));
            sb2.append(format);
            d.c("AGDRTAG", "makeMediaRequestId mediaStr: " + format);
            String format2 = new DecimalFormat("0000000").format((long) Integer.parseInt(j10));
            d.c("AGDRTAG", "makeMediaRequestId codeIdStr: " + format2);
            sb2.append(format2);
            sb2.append(System.currentTimeMillis());
            d.c("AGDRTAG", "makeMediaRequestId requestSb: " + ((Object) sb2));
            return sb2.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    private static String a(String str) {
        return !TextUtils.isEmpty(str) ? str.toUpperCase() : str;
    }

    private static String a(String str, String str2) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str2);
            d.c("AGDRTAG", "auth " + ((Object) sb2));
            String a10 = g.a(sb2.toString());
            d.c("AGDRTAG", "auth md5 " + a10);
            String upperCase = a10.toUpperCase();
            d.c("AGDRTAG", "auth final md5 " + upperCase);
            return upperCase;
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static void a(com.aggmoread.sdk.z.a.d.a aVar, com.aggmoread.sdk.z.b.f.a aVar2) {
        if (!aVar.e()) {
            aVar2.a(new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "无数据填充!"));
            return;
        }
        a.C0052a.C0053a a10 = aVar.f4153e.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.aggmoread.sdk.z.a.c.a(aVar, a10, aVar2));
        aVar2.onAdLoaded(arrayList);
    }

    public static void a(com.aggmoread.sdk.z.a.d.a aVar, com.aggmoread.sdk.z.b.k.a aVar2) {
        if (!aVar.e()) {
            aVar2.a(new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "无数据填充!"));
            return;
        }
        a.C0052a.C0053a a10 = aVar.f4153e.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.aggmoread.sdk.z.a.f.a(aVar, a10, aVar2));
        aVar2.onAdLoaded(arrayList);
    }

    public static void a(com.aggmoread.sdk.z.a.d.a aVar, com.aggmoread.sdk.z.b.l.a aVar2) {
        if (!aVar.e()) {
            aVar2.a(new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT, "无数据填充!"));
            return;
        }
        a.C0052a.C0053a a10 = aVar.f4153e.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.aggmoread.sdk.z.a.h.b(aVar, a10));
        aVar2.onAdLoaded(arrayList);
    }

    public static void a(com.aggmoread.sdk.z.a.e.a aVar, com.aggmoread.sdk.z.b.i.b bVar) {
        d.c("AGDRTAG", "loadData enter , Request = " + aVar);
        JSONObject b10 = b(aVar);
        String str = (j.f6028r.booleanValue() && aVar.u()) ? "http://devapi.union.qihuapi.com/adGet" : "http://api.union.qihuapi.com/adGet";
        d.c("AGDRTAG", "rsUrl = " + str);
        d.c("AGDRTAG", "json : " + b10.toString());
        d.d(b10.toString(), "getDspUrl() = Json ");
        com.aggmoread.sdk.z.b.p.a.a(str, b10, (Map<String, String>) null, new C0059a(bVar, aVar));
    }

    public static void a(com.aggmoread.sdk.z.b.i.b bVar, e eVar) {
        n.a().post(new b(eVar, bVar));
    }
}
