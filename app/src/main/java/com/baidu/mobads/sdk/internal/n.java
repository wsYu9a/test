package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class n {

    /* renamed from: a */
    private int f7223a;

    /* renamed from: b */
    private String f7224b;

    public static List<CpuChannelResponse> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    n a10 = a(jSONArray.getJSONObject(i10));
                    if (a10 != null) {
                        arrayList.add(new CpuChannelResponse(a10));
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public String b() {
        return this.f7224b;
    }

    private static n a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("id", -1);
        String optString = jSONObject.optString("name", "");
        if (optInt == -1 || TextUtils.isEmpty(optString)) {
            return null;
        }
        n nVar = new n();
        nVar.f7223a = optInt;
        nVar.f7224b = optString;
        return nVar;
    }

    public int a() {
        return this.f7223a;
    }
}
