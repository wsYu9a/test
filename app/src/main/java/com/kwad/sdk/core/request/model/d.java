package com.kwad.sdk.core.request.model;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d implements com.kwad.sdk.core.b {
    private String alB;
    private int alC;
    private int alD;

    public static d xs() {
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        d dVar = new d();
        dVar.alB = au.cn(context);
        dVar.alC = ag.ca(context);
        dVar.alD = ag.d(context, au.cq(context), at.Ee());
        return dVar;
    }

    public static d xt() {
        d dVar = new d();
        dVar.alC = ag.ca(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext());
        return dVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "mac", this.alB);
        t.putValue(jSONObject, "connectionType", this.alC);
        t.putValue(jSONObject, "operatorType", this.alD);
        return jSONObject;
    }
}
