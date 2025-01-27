package com.aggmoread.sdk.z.d.a.a.d.a.d.u;

import android.app.Activity;
import android.text.TextUtils;
import com.aggmoread.sdk.z.d.a.a.d.a.c;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.e.d;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.g;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private static String f5662a = "AMHTAGGDT";

    /* renamed from: b */
    private static boolean f5663b = true;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.u.a$a */
    public static class C0157a implements d.c {

        /* renamed from: a */
        final /* synthetic */ b f5664a;

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.u.a$a$a */
        public class RunnableC0158a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ i f5665b;

            /* renamed from: c */
            final /* synthetic */ byte[] f5666c;

            public RunnableC0158a(i iVar, byte[] bArr) {
                this.f5665b = iVar;
                this.f5666c = bArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.b(this.f5665b, this.f5666c, C0157a.this.f5664a);
            }
        }

        public C0157a(b bVar) {
            this.f5664a = bVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.d.c
        public void a(int i10, byte[] bArr, i iVar) {
            n.a(new RunnableC0158a(iVar, bArr));
        }
    }

    public interface b {
        void a(com.aggmoread.sdk.z.d.a.a.c.d dVar);

        void a(com.aggmoread.sdk.z.d.a.a.d.a.b bVar);
    }

    public static class c implements InvocationHandler {

        /* renamed from: a */
        private com.aggmoread.sdk.z.d.a.a.d.a.c f5668a;

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.u.a$c$a */
        public class C0159a implements c.b {

            /* renamed from: a */
            final /* synthetic */ Method f5669a;

            /* renamed from: b */
            final /* synthetic */ Object[] f5670b;

            /* renamed from: c */
            final /* synthetic */ Method f5671c;

            /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.u.a$c$a$a */
            public class C0160a implements b {

                /* renamed from: a */
                final /* synthetic */ c.a f5672a;

                public C0160a(C0159a c0159a, c.a aVar) {
                    this.f5672a = aVar;
                }

                @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.b
                public void a(com.aggmoread.sdk.z.d.a.a.c.d dVar) {
                    this.f5672a.a(dVar);
                }

                @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.a.b
                public void a(com.aggmoread.sdk.z.d.a.a.d.a.b bVar) {
                    this.f5672a.a(bVar);
                }
            }

            public C0159a(c cVar, Method method, Object[] objArr, Method method2) {
                this.f5669a = method;
                this.f5670b = objArr;
                this.f5671c = method2;
            }

            @Override // com.aggmoread.sdk.z.d.a.a.d.a.c.b
            public void a(c.a aVar) {
                a.a(new C0160a(this, aVar), ((String) this.f5670b[2]) + "&resType=api");
            }

            @Override // com.aggmoread.sdk.z.d.a.a.d.a.c.b
            public void onCancel() {
                try {
                    e.b(a.f5662a, "dl cancel");
                    this.f5671c.invoke(this.f5670b[3], null);
                } catch (IllegalAccessException | InvocationTargetException e10) {
                    e10.printStackTrace();
                }
            }

            @Override // com.aggmoread.sdk.z.d.a.a.d.a.c.b
            public void onConfirm() {
                try {
                    e.b(a.f5662a, "dl confirm");
                    this.f5669a.invoke(this.f5670b[3], null);
                } catch (IllegalAccessException | InvocationTargetException e10) {
                    e10.printStackTrace();
                }
            }
        }

        public c(com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
            this.f5668a = cVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            try {
                e.a(a.f5662a, "mn = %s", method.getName());
                if ("onDownloadConfirm".equals(method.getName())) {
                    e.a(a.f5662a, " args[3] = %s", objArr[3]);
                    if (DownloadConfirmCallBack.class.isInstance(objArr[3])) {
                        Method method2 = DownloadConfirmCallBack.class.getMethod("onConfirm", null);
                        Method method3 = DownloadConfirmCallBack.class.getMethod("onCancel", null);
                        com.aggmoread.sdk.z.d.a.a.d.a.c cVar = this.f5668a;
                        if (cVar != null) {
                            cVar.a((Activity) objArr[0], ((Integer) objArr[1]).intValue(), new C0159a(this, method2, objArr, method3));
                        }
                    }
                    return null;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                e.b(a.f5662a, "dce = " + e10);
            }
            Object invoke = method.invoke(this, objArr);
            e.a(a.f5662a, "t %s, r %s", this, invoke);
            return invoke;
        }
    }

    public static void b(i iVar, byte[] bArr, b bVar) {
        JSONArray jSONArray;
        String str;
        String str2 = ";";
        if (iVar != null) {
            e.b(f5662a, "onError er " + iVar);
            bVar.a(new i(1001002005, "请求失败！"));
            return;
        }
        try {
            String str3 = new String(bArr, "UTF-8");
            JSONObject jSONObject = new JSONObject(str3);
            e.c(str3, "CD");
            if (!jSONObject.has(h3.e.f26408m)) {
                e.b(f5662a, "res null!");
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(h3.e.f26408m);
            e.b(f5662a, "response = " + jSONObject2.toString());
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
                int i10 = 0;
                while (i10 < optJSONArray.length()) {
                    String string6 = optJSONArray.getString(i10);
                    if (!TextUtils.isEmpty(string6)) {
                        if (string6.contains(str2)) {
                            String[] split = string6.split(str2);
                            if (split != null && split.length > 0) {
                                String str5 = f5662a;
                                jSONArray = optJSONArray;
                                StringBuilder sb2 = new StringBuilder();
                                str = str2;
                                sb2.append("length = ");
                                sb2.append(split.length);
                                e.b(str5, sb2.toString());
                                for (int i11 = 0; i11 < split.length; i11++) {
                                    e.b(f5662a, "arrs item " + split[i11]);
                                    arrayList.add(split[i11]);
                                }
                            }
                        } else {
                            jSONArray = optJSONArray;
                            str = str2;
                            arrayList.add(string6);
                        }
                        i10++;
                        optJSONArray = jSONArray;
                        str2 = str;
                    }
                    jSONArray = optJSONArray;
                    str = str2;
                    i10++;
                    optJSONArray = jSONArray;
                    str2 = str;
                }
            }
            g.a(arrayList);
            bVar.a(new com.aggmoread.sdk.z.d.a.a.d.a.b(string, string2, string4, optLong2, optLong, string3, arrayList, str4));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static String a(Object obj) {
        try {
            if (ApkDownloadComplianceInterface.class.isInstance(obj)) {
                return String.valueOf(ApkDownloadComplianceInterface.class.getMethod("getApkInfoUrl", null).invoke(obj, null));
            }
        } catch (Exception e10) {
            e.b(f5662a, "not found cls e = " + e10);
        }
        return null;
    }

    public static void a(b bVar, String str) {
        if (bVar == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bVar.a(new i(1001002005, "请求地址为空"));
            return;
        }
        e.b(f5662a, "info = " + str);
        com.aggmoread.sdk.z.d.a.a.e.d.a(str, null, new C0157a(bVar));
    }

    public static void a(Object obj, com.aggmoread.sdk.z.d.a.a.d.a.c cVar) {
        e.a(f5662a, "ADC s = %s, l = %s, is = %s", obj, cVar, Boolean.valueOf(f5663b));
        if (cVar != null) {
            try {
                if (ApkDownloadComplianceInterface.class.isInstance(obj)) {
                    ApkDownloadComplianceInterface.class.getMethod("setDownloadConfirmListener", DownloadConfirmListener.class).invoke(obj, Proxy.newProxyInstance(DownloadConfirmListener.class.getClassLoader(), new Class[]{DownloadConfirmListener.class}, new c(cVar)));
                }
            } catch (Exception e10) {
                e.a(f5662a, "set err = %s", e10);
            }
        }
    }
}
