package com.kwad.sdk.core.request.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a implements com.kwad.sdk.core.b {
    private static JSONObject aDo;
    private String aDp;
    private String appId;
    private String name;
    private String packageName;
    private String version;

    public static JSONObject GF() {
        if (!l(aDo)) {
            aDo = GG().toJson();
        }
        return aDo;
    }

    public static a GG() {
        a aVar = new a();
        try {
            aVar.appId = ServiceProvider.MB().appId;
            aVar.name = ServiceProvider.MB().appName;
            aVar.packageName = ServiceProvider.MA().getPackageName();
            aVar.version = l.ch(ServiceProvider.MA());
            aVar.aDp = com.kwad.sdk.utils.f.bX(ServiceProvider.MA());
            if (!TextUtils.isEmpty(bp.getAppId())) {
                aVar.appId = bp.getAppId();
            }
            if (!TextUtils.isEmpty(bp.getPackageName())) {
                aVar.packageName = bp.getPackageName();
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        return aVar;
    }

    private static boolean l(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("name");
        return !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString) && optString.equals(ServiceProvider.MB().appId) && optString2.equals(ServiceProvider.MB().appName);
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        x.putValue(jSONObject, "appId", this.appId);
        x.putValue(jSONObject, "name", this.name);
        x.putValue(jSONObject, "packageName", this.packageName);
        x.putValue(jSONObject, "version", this.version);
        x.putValue(jSONObject, "sha1", this.aDp);
        return jSONObject;
    }
}
