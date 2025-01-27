package com.bytedance.pangle.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b */
    public static String f6006b = "request_finish";

    /* renamed from: c */
    public static String f6007c = "download_start";

    /* renamed from: d */
    public static String f6008d = "download_finish";

    /* renamed from: e */
    public static String f6009e = "install_start";

    /* renamed from: f */
    public static String f6010f = "install_finish";

    /* renamed from: g */
    public static String f6011g = "load_start";

    /* renamed from: h */
    public static String f6012h = "load_finish";

    /* renamed from: i */
    public static String f6013i = "rm_entry_finish";

    /* renamed from: j */
    private static volatile b f6014j;

    /* renamed from: a */
    public final List<com.bytedance.pangle.c.a> f6015a = new ArrayList();

    public static class a {
        public static int A = 32007;
        public static int B = 32008;
        public static int C = 32999;
        public static int D = 40000;
        public static int E = 41000;
        public static int F = 42000;

        /* renamed from: a */
        public static int f6016a = 1;

        /* renamed from: b */
        public static int f6017b = 2;

        /* renamed from: c */
        public static int f6018c = -1;

        /* renamed from: d */
        public static int f6019d = -2;

        /* renamed from: e */
        public static int f6020e = 12000;

        /* renamed from: f */
        public static int f6021f = 12001;

        /* renamed from: g */
        public static int f6022g = 12002;

        /* renamed from: h */
        public static int f6023h = 12003;

        /* renamed from: i */
        public static int f6024i = 12004;

        /* renamed from: j */
        public static int f6025j = 20000;
        public static int k = 21000;
        public static int l = 21001;
        public static int m = 21002;
        public static int n = 22000;
        public static int o = 22001;
        public static int p = 22002;
        public static int q = 22999;
        public static int r = 30000;
        public static int s = 31000;
        public static int t = 32000;
        public static int u = 32001;
        public static int v = 32002;
        public static int w = 32003;
        public static int x = 32004;
        public static int y = 32005;
        public static int z = 32006;
    }

    private b() {
    }

    public static b a() {
        if (f6014j == null) {
            synchronized (b.class) {
                f6014j = new b();
            }
        }
        return f6014j;
    }

    public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.f6015a) {
            Iterator<com.bytedance.pangle.c.a> it = this.f6015a.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(str, jSONObject, jSONObject2, jSONObject3);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
