package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.loader.a;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class l {
    public static int aqe;

    public static class a {
        private int aqf;
        private int aqg;
        private String aqh;
        private String aqi;
        private long aqj;
        private int aqk;
        private String aql;

        private a() {
        }

        public a aj(long j10) {
            this.aqj = j10;
            return this;
        }

        public a bY(int i10) {
            this.aqf = i10;
            return this;
        }

        public a bZ(int i10) {
            this.aqg = i10;
            return this;
        }

        public a ca(int i10) {
            this.aqk = i10;
            return this;
        }

        public a co(String str) {
            this.aqh = str;
            return this;
        }

        public a cp(String str) {
            this.aqi = str;
            return this;
        }

        public a cq(String str) {
            this.aql = str;
            return this;
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.aqf));
                jSONObject.putOpt("update_count", Integer.valueOf(this.aqg));
                jSONObject.putOpt("dynamic_version", this.aqh);
                jSONObject.putOpt("download_url", this.aqi);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.aqj));
                jSONObject.putOpt("error_code", Integer.valueOf(this.aqk));
                jSONObject.putOpt("error_msg", this.aql);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.aqf + ", update_count=" + this.aqg + ", dynamic_version='" + this.aqh + "', download_url='" + this.aqi + "', duration_ms=" + this.aqj + ", error_code=" + this.aqk + ", error_msg='" + this.aql + "'}";
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public static void a(a.C0477a c0477a) {
        aqe++;
        a(1, c0477a, 0L, 0, "");
    }

    public static void b(a.C0477a c0477a) {
        a(5, c0477a, 0L, 0, "");
    }

    public static void b(a.C0477a c0477a, long j10) {
        a(6, c0477a, j10, 0, "");
    }

    public static void a(a.C0477a c0477a, long j10) {
        a(2, c0477a, j10, 0, "");
    }

    public static void b(a.C0477a c0477a, int i10, String str) {
        a(7, c0477a, 0L, i10, str);
    }

    public static void a(a.C0477a c0477a, long j10, String str) {
        a(3, c0477a, j10, 0, str);
    }

    public static void a(a.C0477a c0477a, int i10, String str) {
        a(4, c0477a, 0L, i10, str);
    }

    private static void a(int i10, a.C0477a c0477a, long j10, int i11, String str) {
        if (c0477a == null) {
            return;
        }
        try {
            JSONObject json = new a((byte) 0).bY(i10).bZ(aqe).co(c0477a.sdkVersion).cp(c0477a.apr).aj(j10).ca(i11).cq(str).toJson();
            Objects.toString(json);
            com.kwad.sdk.api.c.f("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }
}
