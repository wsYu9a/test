package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a */
    private int f5828a;

    /* renamed from: b */
    private String f5829b;

    public static List<CpuChannelResponse> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    k a2 = a(jSONArray.getJSONObject(i2));
                    if (a2 != null) {
                        arrayList.add(new CpuChannelResponse(a2));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public String b() {
        return this.f5829b;
    }

    private static k a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("id", -1);
        String optString = jSONObject.optString("name", "");
        if (optInt == -1 || TextUtils.isEmpty(optString)) {
            return null;
        }
        k kVar = new k();
        kVar.f5828a = optInt;
        kVar.f5829b = optString;
        return kVar;
    }

    public int a() {
        return this.f5828a;
    }
}
