package com.kwad.sdk.i;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.w;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: com.kwad.sdk.i.a$1 */
    public class AnonymousClass1 extends bd {
        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.Lg();
        }
    }

    /* renamed from: com.kwad.sdk.i.a$2 */
    public class AnonymousClass2 extends com.kwad.sdk.f.b<JSONObject, JSONObject> {
        private static JSONObject o(JSONObject jSONObject) {
            return jSONObject.optJSONObject("sdkTTPerfMonitor");
        }

        @Override // com.kwad.sdk.f.b
        public final /* synthetic */ JSONObject apply(JSONObject jSONObject) {
            return o(jSONObject);
        }
    }

    @KsJson
    /* renamed from: com.kwad.sdk.i.a$a */
    public static class C0508a extends com.kwad.sdk.commercial.c.a {
        public String aJK;
        public int aNY;
        public String sdkVersion;
    }

    @KsJson
    public static class b extends com.kwad.sdk.commercial.c.a {
        public int aNZ;
        public String aOa;
        public String aOb;
        public String aOc;
        public String aOd;
        public String aOe;
    }

    public static void Lf() {
        h.execute(new bd() { // from class: com.kwad.sdk.i.a.1
            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.Lg();
            }
        });
    }

    public static void Lg() {
        C0508a a10;
        JSONObject jSONObject = (JSONObject) d.DA().getAppConfigData(null, new com.kwad.sdk.f.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.i.a.2
            private static JSONObject o(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }

            @Override // com.kwad.sdk.f.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return o(jSONObject2);
            }
        });
        if (jSONObject == null) {
            return;
        }
        b bVar = new b();
        try {
            bVar.parseJson(jSONObject);
            if (bVar.aNZ == 1 && (a10 = a(ServiceProvider.getContext().getClassLoader(), bVar)) != null) {
                com.kwad.sdk.commercial.b.d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_tt_sdk_info", n3.a.f28754t).u(a10).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static C0508a a(ClassLoader classLoader, b bVar) {
        Class<?> a10 = w.a(bVar.aOa, classLoader);
        if (a10 == null) {
            return null;
        }
        C0508a c0508a = new C0508a();
        c0508a.aNY = w.classExists(bVar.aOb) ? 1 : 0;
        Object callStaticMethod = w.callStaticMethod(a10, bVar.aOc, new Object[0]);
        c0508a.sdkVersion = (String) w.callMethod(callStaticMethod, bVar.aOd, new Object[0]);
        c0508a.aJK = (String) w.callMethod(callStaticMethod, bVar.aOe, new Object[0]);
        return c0508a;
    }
}
