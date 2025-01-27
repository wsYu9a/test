package com.kwad.components.core.n.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d implements com.kwad.sdk.core.b {
    public long Pa;
    public long photoId;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "photoId", this.photoId);
        t.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, this.Pa);
        return jSONObject;
    }
}
