package com.kwad.sdk.collector.a;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.x;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a extends d {
    private C0479a arc;

    /* renamed from: com.kwad.sdk.collector.a.a$a */
    public static class C0479a {
        private List<String> ard;

        public C0479a(List<String> list) {
            this.ard = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            x.putValue(jSONObject, "packageName", this.ard);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0479a c0479a = new C0479a(list);
        this.arc = c0479a;
        putBody("targetAppInfo", c0479a.toJson());
        putBody(b7.b.f1305b0, BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.zn();
    }
}
