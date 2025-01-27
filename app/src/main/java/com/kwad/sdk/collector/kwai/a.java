package com.kwad.sdk.collector.kwai;

import com.kwad.sdk.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.utils.t;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a extends d {
    private C0205a abj;

    /* renamed from: com.kwad.sdk.collector.kwai.a$a */
    static class C0205a {
        private List<String> abk;

        public C0205a(List<String> list) {
            this.abk = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, DBDefinition.PACKAGE_NAME, this.abk);
            return jSONObject;
        }
    }

    public a(List<String> list) {
        C0205a c0205a = new C0205a(list);
        this.abj = c0205a;
        putBody("targetAppInfo", c0205a.toJson());
        putBody("sdkVersion", "3.3.40");
        putBody("sdkVersionCode", 3034000);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return c.sk();
    }
}
