package com.bytedance.pangle.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: b */
    public static String f7483b = "request_finish";

    /* renamed from: c */
    public static String f7484c = "download_start";

    /* renamed from: d */
    public static String f7485d = "download_finish";

    /* renamed from: e */
    public static String f7486e = "install_start";

    /* renamed from: f */
    public static String f7487f = "install_finish";

    /* renamed from: g */
    public static String f7488g = "7z_unzip_start";

    /* renamed from: h */
    public static String f7489h = "7z_unzip_finish";

    /* renamed from: i */
    public static String f7490i = "load_start";

    /* renamed from: j */
    public static String f7491j = "load_finish";

    /* renamed from: k */
    public static String f7492k = "rm_entry_finish";

    /* renamed from: l */
    private static volatile b f7493l;

    /* renamed from: a */
    public final List<com.bytedance.pangle.c.a> f7494a = new ArrayList();

    public static class a {
        public static int A = 32007;
        public static int B = 32008;
        public static int C = 32999;
        public static int D = 40000;
        public static int E = 41000;
        public static int F = 42000;
        public static int G = 50000;
        public static int H = 50004;

        /* renamed from: a */
        public static int f7495a = 1;

        /* renamed from: b */
        public static int f7496b = 2;

        /* renamed from: c */
        public static int f7497c = -1;

        /* renamed from: d */
        public static int f7498d = -2;

        /* renamed from: e */
        public static int f7499e = 12000;

        /* renamed from: f */
        public static int f7500f = 12001;

        /* renamed from: g */
        public static int f7501g = 12002;

        /* renamed from: h */
        public static int f7502h = 12003;

        /* renamed from: i */
        public static int f7503i = 12004;

        /* renamed from: j */
        public static int f7504j = 20000;

        /* renamed from: k */
        public static int f7505k = 21000;

        /* renamed from: l */
        public static int f7506l = 21001;

        /* renamed from: m */
        public static int f7507m = 21002;

        /* renamed from: n */
        public static int f7508n = 22000;

        /* renamed from: o */
        public static int f7509o = 22001;

        /* renamed from: p */
        public static int f7510p = 22002;

        /* renamed from: q */
        public static int f7511q = 22999;

        /* renamed from: r */
        public static int f7512r = 30000;

        /* renamed from: s */
        public static int f7513s = 31000;

        /* renamed from: t */
        public static int f7514t = 32000;

        /* renamed from: u */
        public static int f7515u = 32001;

        /* renamed from: v */
        public static int f7516v = 32002;

        /* renamed from: w */
        public static int f7517w = 32003;

        /* renamed from: x */
        public static int f7518x = 32004;

        /* renamed from: y */
        public static int f7519y = 32005;

        /* renamed from: z */
        public static int f7520z = 32006;
    }

    private b() {
    }

    public static b a() {
        if (f7493l == null) {
            synchronized (b.class) {
                f7493l = new b();
            }
        }
        return f7493l;
    }

    public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.f7494a) {
            try {
                Iterator<com.bytedance.pangle.c.a> it = this.f7494a.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(str, jSONObject, jSONObject2, jSONObject3);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
