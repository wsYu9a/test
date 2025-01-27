package com.vivo.mobilead.j;

import com.martian.mibook.application.MiConfigSingleton;
import com.vivo.ic.jsonparser.JsonParserUtil;
import com.vivo.mobilead.unified.exitFloat.e;
import com.vivo.mobilead.util.x0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a extends b {

    /* renamed from: a */
    private int f28910a;

    /* renamed from: b */
    private int f28911b;

    public a(int i2, int i3) {
        this.f28910a = i2;
        this.f28911b = i3;
    }

    @Override // com.vivo.mobilead.j.b
    protected Object b(JSONObject jSONObject) throws com.vivo.mobilead.i.c, JSONException {
        if (jSONObject != null) {
            int i2 = JsonParserUtil.getInt("code", jSONObject);
            String string = JsonParserUtil.getString(com.heytap.mcssdk.n.d.l, jSONObject);
            x0.a("AdItemDataParser", "parse AdItemData, code: " + i2 + " msg: " + string);
            if (i2 != 1) {
                if (i2 == 20240401 && this.f28910a == 5 && this.f28911b == 43) {
                    e.c().a(false);
                }
                throw new com.vivo.mobilead.i.c(com.vivo.mobilead.unified.base.f.a.d(i2), com.vivo.mobilead.unified.base.f.a.a(i2, string));
            }
            JSONArray jSONArray = JsonParserUtil.getJSONArray(MiConfigSingleton.t0, jSONObject);
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(new com.vivo.ad.model.b(jSONArray.getJSONObject(i3)));
                }
                return arrayList;
            }
        }
        throw new com.vivo.mobilead.i.c(402121, "数据解析异常，建议重试");
    }
}
