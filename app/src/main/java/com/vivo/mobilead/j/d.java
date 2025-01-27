package com.vivo.mobilead.j;

import com.martian.mibook.application.MiConfigSingleton;
import com.vivo.ic.jsonparser.JsonParserUtil;
import com.vivo.mobilead.manager.e;
import com.vivo.mobilead.util.x0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d extends b {
    @Override // com.vivo.mobilead.j.b
    protected Object b(JSONObject jSONObject) throws com.vivo.mobilead.i.c, JSONException {
        if (jSONObject == null) {
            return null;
        }
        x0.a("StrategyManager", "parseData: " + jSONObject);
        int i2 = JsonParserUtil.getInt("code", jSONObject);
        String string = JsonParserUtil.getString(com.heytap.mcssdk.n.d.l, jSONObject);
        x0.a("StrategyManager", "parse sdk config, code: " + i2 + " msg: " + string);
        if (i2 != 1) {
            throw new com.vivo.mobilead.i.c(com.vivo.mobilead.unified.base.f.a.d(i2), com.vivo.mobilead.unified.base.f.a.a(i2, string));
        }
        JSONObject object = JsonParserUtil.getObject(MiConfigSingleton.t0, jSONObject);
        if (object == null) {
            x0.a("StrategyManager", "The data is null");
        } else {
            x0.a("StrategyManager", "The data not null");
        }
        return e.c().b(object);
    }
}
