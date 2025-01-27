package com.kwad.sdk.core.report;

import android.text.TextUtils;
import com.kwad.sdk.utils.x;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class f extends com.kwad.sdk.core.network.d {
    protected String aBK;

    public f(List<n> list) {
        this.aBK = "";
        if (list == null || list.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<n> it = list.iterator();
        while (it.hasNext()) {
            x.a(jSONArray, it.next().buildReportData());
        }
        putBody("actionList", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.d
    public final boolean enablePrivateInfoObtain() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        if (encryptDisable() && !TextUtils.isEmpty(this.aBK)) {
            putBody("actionListString", this.aBK);
        }
        return super.getBody();
    }

    @Override // com.kwad.sdk.core.network.b
    public final String getBodyParamsString() {
        String bodyParamsString = super.getBodyParamsString();
        try {
            if (TextUtils.isEmpty(this.aBK)) {
                return bodyParamsString;
            }
            StringBuilder sb2 = new StringBuilder(bodyParamsString);
            sb2.insert(sb2.length() - 1, this.aBK);
            return sb2.toString();
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            return bodyParamsString;
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.zj();
    }

    public f(String str) {
        this.aBK = str;
    }
}
