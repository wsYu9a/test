package com.vivo.ad.model;

import com.cdo.oaps.ad.OapsWrapper;
import com.vivo.ic.jsonparser.JsonParserUtil;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class g implements Serializable {

    /* renamed from: a */
    public String f26892a;

    /* renamed from: b */
    public String f26893b;

    public g(JSONObject jSONObject) {
        this.f26892a = JsonParserUtil.getString("originId", jSONObject);
        this.f26893b = JsonParserUtil.getString(OapsWrapper.KEY_PATH, jSONObject);
    }
}
