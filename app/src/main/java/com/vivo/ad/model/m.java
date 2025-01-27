package com.vivo.ad.model;

import com.vivo.ic.jsonparser.JsonParserUtil;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class m extends l {

    /* renamed from: c */
    private int f26913c;

    public m(JSONObject jSONObject) {
        super(jSONObject);
        this.f26913c = JsonParserUtil.getInt("type", jSONObject, 0);
    }

    public int c() {
        return this.f26913c;
    }
}
