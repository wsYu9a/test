package com.kwad.sdk.core.request.model;

import android.location.Location;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class c implements com.kwad.sdk.core.b {
    private static c aDQ;
    private double latitude;
    private double longitude;
    private int type;

    public static c GI() {
        Location location;
        c cVar = aDQ;
        if (cVar != null) {
            return cVar;
        }
        try {
            aDQ = new c();
            com.kwad.sdk.utils.c.a cm = ba.cm(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
            if (cm != null && (location = cm.aWW) != null) {
                aDQ.latitude = location.getLatitude();
                aDQ.longitude = cm.aWW.getLongitude();
                aDQ.type = cm.type;
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        return aDQ;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        x.putValue(jSONObject, "latitude", this.latitude);
        x.putValue(jSONObject, "longitude", this.longitude);
        x.putValue(jSONObject, "type", this.type);
        return jSONObject;
    }
}
