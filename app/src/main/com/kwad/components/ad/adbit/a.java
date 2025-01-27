package com.kwad.components.ad.adbit;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.x;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {

    @NonNull
    public JSONObject bA;

    @NonNull
    public Map<String, String> bB;

    public a(@NonNull JSONObject jSONObject, @NonNull Map<String, String> map) {
        this.bA = jSONObject;
        this.bB = map;
    }

    public final String N() {
        for (String str : this.bB.keySet()) {
            x.putValue(this.bA, str, this.bB.get(str));
        }
        return this.bA.toString();
    }
}
