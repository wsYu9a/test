package com.kwad.sdk.api.loader;

import com.martian.mibook.application.MiConfigSingleton;
import com.umeng.analytics.pro.am;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a, reason: collision with other inner class name */
    static class C0202a {
        String Tf;
        int Zk;
        String Zl;
        transient File Zm;
        long interval;
        String sdkVersion;

        C0202a() {
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.Zk = jSONObject.optInt("dynamicType");
            this.Zl = jSONObject.optString("dynamicUrl");
            this.Tf = jSONObject.optString("md5");
            this.interval = jSONObject.optLong(am.aU);
            this.sdkVersion = jSONObject.optString("sdkVersion");
        }

        public final boolean tl() {
            return this.Zk == 1;
        }

        public final boolean tm() {
            return this.Zk == -1;
        }

        public final String toString() {
            return "Data{dynamicType=" + this.Zk + ", dynamicUrl='" + this.Zl + "', md5='" + this.Tf + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.Zm + '}';
        }
    }

    static class b {
        long Zn;
        C0202a Zo;
        String errorMsg;

        b() {
        }

        public final void parseJson(JSONObject jSONObject) {
            this.Zn = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString("errorMsg");
            C0202a c0202a = new C0202a();
            this.Zo = c0202a;
            c0202a.parseJson(jSONObject.optJSONObject(MiConfigSingleton.t0));
        }

        final boolean tn() {
            return this.Zn == 1 && this.Zo != null;
        }

        public final String toString() {
            return "UpdateData{result=" + this.Zn + ", errorMsg='" + this.errorMsg + "', data=" + this.Zo + '}';
        }
    }
}
