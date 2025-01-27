package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.loader.a;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class j {
    public static int ZG;

    static class a {
        private int ZH;
        private int ZI;
        private String ZJ;
        private String ZK;
        private long ZL;
        private int ZM;
        private String ZN;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public a H(long j2) {
            this.ZL = j2;
            return this;
        }

        public a aT(int i2) {
            this.ZH = i2;
            return this;
        }

        public a aU(int i2) {
            this.ZI = i2;
            return this;
        }

        public a aV(int i2) {
            this.ZM = i2;
            return this;
        }

        public a bc(String str) {
            this.ZJ = str;
            return this;
        }

        public a bd(String str) {
            this.ZK = str;
            return this;
        }

        public a be(String str) {
            this.ZN = str;
            return this;
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.ZH));
                jSONObject.putOpt("update_count", Integer.valueOf(this.ZI));
                jSONObject.putOpt("dynamic_version", this.ZJ);
                jSONObject.putOpt("download_url", this.ZK);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.ZL));
                jSONObject.putOpt("error_code", Integer.valueOf(this.ZM));
                jSONObject.putOpt("error_msg", this.ZN);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.ZH + ", update_count=" + this.ZI + ", dynamic_version='" + this.ZJ + "', download_url='" + this.ZK + "', duration_ms=" + this.ZL + ", error_code=" + this.ZM + ", error_msg='" + this.ZN + "'}";
        }
    }

    private static void a(int i2, a.C0202a c0202a, long j2, int i3, String str) {
        if (c0202a == null) {
            return;
        }
        try {
            JSONObject json = new a((byte) 0).aT(i2).aU(ZG).bc(c0202a.sdkVersion).bd(c0202a.Zl).H(j2).aV(i3).be(str).toJson();
            StringBuilder sb = new StringBuilder("status:");
            sb.append(i2);
            sb.append("--jo:");
            sb.append(json);
            com.kwad.sdk.api.c.a("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }

    public static void a(a.C0202a c0202a) {
        ZG++;
        a(1, c0202a, 0L, 0, "");
    }

    public static void a(a.C0202a c0202a, int i2, String str) {
        a(4, c0202a, 0L, i2, str);
    }

    public static void a(a.C0202a c0202a, long j2) {
        a(2, c0202a, j2, 0, "");
    }

    public static void a(a.C0202a c0202a, long j2, String str) {
        a(3, c0202a, j2, 0, str);
    }

    public static void b(a.C0202a c0202a) {
        a(5, c0202a, 0L, 0, "");
    }

    public static void b(a.C0202a c0202a, int i2, String str) {
        a(7, c0202a, 0L, i2, str);
    }

    public static void b(a.C0202a c0202a, long j2) {
        a(6, c0202a, j2, 0, "");
    }
}
