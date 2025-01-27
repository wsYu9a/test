package com.kwad.components.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class c implements com.kwad.sdk.core.b {
    public long UK;
    public long photoId;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        x.putValue(jSONObject, "photoId", this.photoId);
        x.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, this.UK);
        return jSONObject;
    }
}
