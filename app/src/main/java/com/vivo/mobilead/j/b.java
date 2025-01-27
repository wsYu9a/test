package com.vivo.mobilead.j;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class b extends c {
    public Object a(JSONObject jSONObject) throws com.vivo.mobilead.i.c, JSONException {
        if (jSONObject != null) {
            return b(jSONObject);
        }
        throw new com.vivo.mobilead.i.c(402123, "没有请求数据");
    }

    protected abstract Object b(JSONObject jSONObject) throws com.vivo.mobilead.i.c, JSONException;
}
