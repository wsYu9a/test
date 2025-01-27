package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class b implements f {
    private final Map<String, String> mHeader = new HashMap();
    public final JSONObject mBodyParams = new JSONObject();

    public b() {
        try {
            onCreate();
            buildBaseHeader();
            buildBaseBody();
            if (encryptDisable()) {
                addHeader("x-ksad-ignore-decrypt", "true");
            }
            addHeader("cookie", com.kwad.sdk.core.response.b.f.GP().GQ());
            com.kwad.sdk.core.a.d.g(getHeader());
            addHeader("User-Agent", p.getUserAgent());
            addHeader("BrowserUa", p.Fu());
            addHeader("SystemUa", p.Ft());
        } catch (Throwable th2) {
            reportSdkCaughtException(th2);
        }
    }

    public void addHeader(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mHeader.put(str, str2);
    }

    public abstract void buildBaseBody();

    public abstract void buildBaseHeader();

    public boolean enableCrashReport() {
        return true;
    }

    public boolean encryptDisable() {
        return com.kwad.sdk.components.g.encryptDisable();
    }

    @Override // com.kwad.sdk.core.network.f
    public JSONObject getBody() {
        if (encryptDisable()) {
            return this.mBodyParams;
        }
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        x.putValue(jSONObject, "version", fVar.getSDKVersion());
        if (TextUtils.isEmpty(bp.getAppId())) {
            x.putValue(jSONObject, "appId", fVar.getAppId());
        } else {
            x.putValue(jSONObject, "appId", bp.getAppId());
        }
        x.putValue(jSONObject, b7.d.f1362o, com.kwad.sdk.core.a.d.an(getBodyParamsString()));
        com.kwad.sdk.core.a.d.a(getUrl(), getHeader(), jSONObject.toString());
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getBodyMap() {
        return null;
    }

    public JSONObject getBodyParams() {
        return this.mBodyParams;
    }

    public String getBodyParamsString() {
        return this.mBodyParams.toString();
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getHeader() {
        return this.mHeader;
    }

    public String getRequestHost() {
        return com.kwad.sdk.h.ze();
    }

    @Override // com.kwad.sdk.core.network.f
    @Nullable
    public SceneImpl getScene() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.f
    public abstract String getUrl();

    public void onCreate() {
    }

    public void putBody(String str, String str2) {
        x.putValue(this.mBodyParams, str, str2);
    }

    public void reportSdkCaughtException(Throwable th2) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th2);
        } else {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        }
    }

    public void putBody(String str, double d10) {
        x.putValue(this.mBodyParams, str, d10);
    }

    public void putBody(String str, int i10) {
        x.putValue(this.mBodyParams, str, i10);
    }

    public void putBody(String str, float f10) {
        x.putValue(this.mBodyParams, str, f10);
    }

    public void putBody(String str, byte b10) {
        x.putValue(this.mBodyParams, str, b10);
    }

    public void putBody(String str, long j10) {
        x.putValue(this.mBodyParams, str, j10);
    }

    public void putBody(String str, boolean z10) {
        x.putValue(this.mBodyParams, str, z10);
    }

    public void putBody(String str, JSONObject jSONObject) {
        x.putValue(this.mBodyParams, str, jSONObject);
    }

    public void putBody(String str, JSONArray jSONArray) {
        x.putValue(this.mBodyParams, str, jSONArray);
    }

    public void putBody(String str, com.kwad.sdk.core.b bVar) {
        x.a(this.mBodyParams, str, bVar);
    }

    public void putBody(String str, List<? extends com.kwad.sdk.core.b> list) {
        x.putValue(this.mBodyParams, str, list);
    }
}
