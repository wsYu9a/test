package com.kwad.sdk.api.loader;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.bt;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes3.dex */
final class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a, reason: collision with other inner class name */
    public static class C0477a {
        int apq;
        String apr;
        transient File aps;
        long interval;
        String md5;
        String sdkVersion;

        public final boolean Bu() {
            return this.apq == 1;
        }

        public final boolean Bv() {
            return this.apq == -1;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.apq = jSONObject.optInt("dynamicType");
            this.apr = jSONObject.optString("dynamicUrl");
            this.md5 = jSONObject.optString("md5");
            this.interval = jSONObject.optLong(bt.f23596ba);
            this.sdkVersion = jSONObject.optString(b7.b.f1305b0);
        }

        public final String toString() {
            return "Data{dynamicType=" + this.apq + ", dynamicUrl='" + this.apr + "', md5='" + this.md5 + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.aps + '}';
        }
    }

    public static class b {
        long apt;
        C0477a apu;
        String errorMsg;

        public final boolean Bw() {
            return this.apt == 1 && this.apu != null;
        }

        public final void parseJson(JSONObject jSONObject) {
            this.apt = jSONObject.optLong(p3.i.f29758c);
            this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            C0477a c0477a = new C0477a();
            this.apu = c0477a;
            c0477a.parseJson(jSONObject.optJSONObject(h3.e.f26408m));
        }

        public final String toString() {
            return "UpdateData{result=" + this.apt + ", errorMsg='" + this.errorMsg + "', data=" + this.apu + '}';
        }
    }
}
