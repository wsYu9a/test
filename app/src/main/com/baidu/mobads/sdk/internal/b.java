package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a */
    private int f6815a = 0;

    /* renamed from: b */
    private List<a> f6816b = new ArrayList();

    public static b a(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f6815a = jSONObject.optInt("n", 0);
            int optInt = jSONObject.optInt("enc", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("ad");
            if (optInt == 1) {
                String optString = jSONObject.optString("ad");
                if (!TextUtils.isEmpty(optString)) {
                    String b10 = i.b(optString);
                    if (!TextUtils.isEmpty(b10)) {
                        optJSONArray = new JSONArray(b10);
                    }
                }
            }
            bVar.f6816b = a.a(optJSONArray);
            return bVar;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return bVar;
        }
    }

    public List<a> a() {
        return this.f6816b;
    }
}
