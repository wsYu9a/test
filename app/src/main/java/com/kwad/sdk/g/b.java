package com.kwad.sdk.g;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.s;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: com.kwad.sdk.g.b$1 */
    static class AnonymousClass1 extends aw {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            b.Be();
        }
    }

    /* renamed from: com.kwad.sdk.g.b$2 */
    static class AnonymousClass2 extends com.kwad.sdk.e.b<JSONObject, JSONObject> {
        AnonymousClass2() {
        }

        private static JSONObject D(JSONObject jSONObject) {
            return jSONObject.optJSONObject("sdkTTPerfMonitor");
        }

        @Override // com.kwad.sdk.e.b
        public final /* synthetic */ JSONObject apply(JSONObject jSONObject) {
            return D(jSONObject);
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int auj;
        public String auk;
        public String sdkVersion;
    }

    @KsJson
    /* renamed from: com.kwad.sdk.g.b$b */
    public static class C0228b extends com.kwad.sdk.core.response.kwai.a {
        public int aul;
        public String aum;
        public String aun;
        public String auo;
        public String aup;
        public String auq;
    }

    public static void Bd() {
        g.execute(new aw() { // from class: com.kwad.sdk.g.b.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                b.Be();
            }
        });
    }

    public static void Be() {
        a a2;
        JSONObject jSONObject = (JSONObject) d.uu().getAppConfigData(null, new com.kwad.sdk.e.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.g.b.2
            AnonymousClass2() {
            }

            private static JSONObject D(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }

            @Override // com.kwad.sdk.e.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return D(jSONObject2);
            }
        });
        if (jSONObject == null) {
            return;
        }
        C0228b c0228b = new C0228b();
        try {
            c0228b.parseJson(jSONObject);
            if (c0228b.aul == 1 && (a2 = a(ServiceProvider.getContext().getClassLoader(), c0228b)) != null) {
                KSLoggerReporter.a(new o.a().cE(ILoggerReporter.Category.APM_LOG).b(BusinessType.OTHER).a(SubBusinessType.OTHER).cF("ad_sdk_tt_sdk_info").A(a2.toJson()).xa());
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static a a(ClassLoader classLoader, C0228b c0228b) {
        Class<?> a2 = s.a(c0228b.aum, classLoader);
        if (a2 == null) {
            return null;
        }
        a aVar = new a();
        aVar.auj = s.ez(c0228b.aun) ? 1 : 0;
        Object b2 = s.b(a2, c0228b.auo, new Object[0]);
        aVar.sdkVersion = (String) s.a(b2, c0228b.aup, new Object[0]);
        aVar.auk = (String) s.a(b2, c0228b.auq, new Object[0]);
        return aVar;
    }
}
