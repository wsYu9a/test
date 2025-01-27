package com.martian.ttbook.b.c.a.a.d.a.d.x;

import android.app.Activity;
import android.text.TextUtils;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.ttbook.b.a.k.m;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.c.a.a.b.a.c;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.e.c;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static String f15593a = "GDTHTAG";

    /* renamed from: b */
    private static boolean f15594b = true;

    /* renamed from: com.martian.ttbook.b.c.a.a.d.a.d.x.a$a */
    static class C0343a implements c.InterfaceC0361c {

        /* renamed from: a */
        final /* synthetic */ b f15595a;

        /* renamed from: com.martian.ttbook.b.c.a.a.d.a.d.x.a$a$a */
        class RunnableC0344a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ i f15596a;

            /* renamed from: b */
            final /* synthetic */ byte[] f15597b;

            RunnableC0344a(i iVar, byte[] bArr) {
                this.f15596a = iVar;
                this.f15597b = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.f(this.f15596a, this.f15597b, C0343a.this.f15595a);
            }
        }

        C0343a(b bVar) {
            this.f15595a = bVar;
        }

        @Override // com.martian.ttbook.b.c.a.a.e.c.InterfaceC0361c
        public void a(int i2, byte[] bArr, i iVar) {
            n.e(new RunnableC0344a(iVar, bArr));
        }
    }

    public interface b {
        void a(com.martian.ttbook.b.c.a.a.c.d dVar);

        void b(com.martian.ttbook.b.c.a.a.b.a.b bVar);
    }

    static class c implements InvocationHandler {

        /* renamed from: a */
        private com.martian.ttbook.b.c.a.a.b.a.c f15599a;

        /* renamed from: com.martian.ttbook.b.c.a.a.d.a.d.x.a$c$a */
        class C0345a implements c.b {

            /* renamed from: a */
            final /* synthetic */ Method f15600a;

            /* renamed from: b */
            final /* synthetic */ Object[] f15601b;

            /* renamed from: c */
            final /* synthetic */ Method f15602c;

            /* renamed from: com.martian.ttbook.b.c.a.a.d.a.d.x.a$c$a$a */
            class C0346a implements b {

                /* renamed from: a */
                final /* synthetic */ c.a f15603a;

                C0346a(C0345a c0345a, c.a aVar) {
                    this.f15603a = aVar;
                }

                @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.a.b
                public void a(com.martian.ttbook.b.c.a.a.c.d dVar) {
                    this.f15603a.a(dVar);
                }

                @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.a.b
                public void b(com.martian.ttbook.b.c.a.a.b.a.b bVar) {
                    this.f15603a.b(bVar);
                }
            }

            C0345a(c cVar, Method method, Object[] objArr, Method method2) {
                this.f15600a = method;
                this.f15601b = objArr;
                this.f15602c = method2;
            }

            @Override // com.martian.ttbook.b.c.a.a.b.a.c.b
            public void a(c.a aVar) {
                a.c(new C0346a(this, aVar), ((String) this.f15601b[2]) + "&resType=api");
            }

            @Override // com.martian.ttbook.b.c.a.a.b.a.c.b
            public void onCancel() {
                try {
                    com.martian.ttbook.b.c.a.a.e.d.g(a.f15593a, "dl cancel");
                    this.f15602c.invoke(this.f15601b[3], new Object[0]);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
            }

            @Override // com.martian.ttbook.b.c.a.a.b.a.c.b
            public void onConfirm() {
                try {
                    com.martian.ttbook.b.c.a.a.e.d.g(a.f15593a, "dl confirm");
                    this.f15600a.invoke(this.f15601b[3], new Object[0]);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
            }
        }

        public c(com.martian.ttbook.b.c.a.a.b.a.c cVar) {
            this.f15599a = cVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            try {
                com.martian.ttbook.b.c.a.a.e.d.c(a.f15593a, "mn = %s", method.getName());
                if ("onDownloadConfirm".equals(method.getName())) {
                    b.d.e.c.a.d.f(a.f15593a, " args[3] = %s", objArr[3]);
                    Class<?> cls = Class.forName("com.qq.e.comm.compliance.DownloadConfirmCallBack");
                    if (!cls.isInstance(objArr[3])) {
                        return null;
                    }
                    Method method2 = cls.getMethod("onConfirm", new Class[0]);
                    Method method3 = cls.getMethod("onCancel", new Class[0]);
                    com.martian.ttbook.b.c.a.a.b.a.c cVar = this.f15599a;
                    if (cVar == null) {
                        return null;
                    }
                    cVar.a((Activity) objArr[0], ((Integer) objArr[1]).intValue(), new C0345a(this, method2, objArr, method3));
                    return null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                com.martian.ttbook.b.c.a.a.e.d.g(a.f15593a, "dce = " + e2);
            }
            Object invoke = method.invoke(this, objArr);
            com.martian.ttbook.b.c.a.a.e.d.c(a.f15593a, "t %s, r %s", this, invoke);
            return invoke;
        }
    }

    public static String b(Object obj) {
        try {
            Class<?> cls = Class.forName("com.qq.e.comm.compliance.ApkDownloadComplianceInterface");
            if (cls.isInstance(obj)) {
                return String.valueOf(cls.getMethod("getApkInfoUrl", new Class[0]).invoke(obj, new Object[0]));
            }
            return null;
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.g(f15593a, "not found cls e = " + e2);
            return null;
        }
    }

    public static void c(b bVar, String str) {
        if (bVar == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bVar.a(new i(-1000, "请求地址为空"));
            return;
        }
        com.martian.ttbook.b.c.a.a.e.d.g(f15593a, "info = " + str);
        com.martian.ttbook.b.c.a.a.e.c.e(str, null, new C0343a(bVar));
    }

    public static void e(Object obj, com.martian.ttbook.b.c.a.a.b.a.c cVar) {
        com.martian.ttbook.b.c.a.a.e.d.c(f15593a, "ADC s = %s, l = %s, is = %s", obj, cVar, Boolean.valueOf(f15594b));
        try {
            Class<?> cls = Class.forName("com.qq.e.comm.compliance.ApkDownloadComplianceInterface");
            Class<?> cls2 = Class.forName("com.qq.e.comm.compliance.DownloadConfirmListener");
            if (cVar == null || !cls.isInstance(obj)) {
                return;
            }
            cls.getMethod("setDownloadConfirmListener", cls2).invoke(obj, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new c(cVar)));
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.c(f15593a, "set err = %s", e2);
        }
    }

    public static void f(i iVar, byte[] bArr, b bVar) {
        JSONArray jSONArray;
        String str;
        String str2 = ";";
        if (iVar != null) {
            com.martian.ttbook.b.c.a.a.e.d.g(f15593a, "onError er " + iVar);
            bVar.a(new i(-1000, "请求失败！"));
            return;
        }
        try {
            String str3 = new String(bArr, "UTF-8");
            JSONObject jSONObject = new JSONObject(str3);
            com.martian.ttbook.b.c.a.a.e.d.i(str3, "CD");
            if (!jSONObject.has(MiConfigSingleton.t0)) {
                com.martian.ttbook.b.c.a.a.e.d.g(f15593a, "res null!");
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(MiConfigSingleton.t0);
            com.martian.ttbook.b.c.a.a.e.d.g(f15593a, "response = " + jSONObject2.toString());
            String string = jSONObject2.getString("appName");
            String string2 = jSONObject2.getString("authorName");
            long optLong = jSONObject2.optLong("apkPublishTime");
            long optLong2 = jSONObject2.optLong("fileSize");
            String string3 = jSONObject2.getString("privacyAgreement");
            String string4 = jSONObject2.getString("versionName");
            String string5 = jSONObject2.getString(DBDefinition.ICON_URL);
            if (TextUtils.isEmpty(string5)) {
                string5 = jSONObject2.getString("icon_url");
            }
            String str4 = string5;
            JSONArray optJSONArray = jSONObject2.optJSONArray("permissions");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i2 = 0;
                while (i2 < optJSONArray.length()) {
                    String string6 = optJSONArray.getString(i2);
                    if (!TextUtils.isEmpty(string6)) {
                        if (string6.contains(str2)) {
                            String[] split = string6.split(str2);
                            if (split != null && split.length > 0) {
                                String str5 = f15593a;
                                jSONArray = optJSONArray;
                                StringBuilder sb = new StringBuilder();
                                str = str2;
                                sb.append("length = ");
                                sb.append(split.length);
                                com.martian.ttbook.b.c.a.a.e.d.g(str5, sb.toString());
                                for (int i3 = 0; i3 < split.length; i3++) {
                                    com.martian.ttbook.b.c.a.a.e.d.g(f15593a, "arrs item " + split[i3]);
                                    arrayList.add(split[i3]);
                                }
                            }
                        } else {
                            jSONArray = optJSONArray;
                            str = str2;
                            arrayList.add(string6);
                        }
                        i2++;
                        optJSONArray = jSONArray;
                        str2 = str;
                    }
                    jSONArray = optJSONArray;
                    str = str2;
                    i2++;
                    optJSONArray = jSONArray;
                    str2 = str;
                }
            }
            m.b(arrayList);
            bVar.b(new com.martian.ttbook.b.c.a.a.b.a.b(string, string2, string4, optLong2, optLong, string3, arrayList, str4));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
