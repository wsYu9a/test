package com.vivo.advv.vaf.expr.engine;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alipay.mobilesecuritysdk.deviceID.c;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
/* loaded from: classes4.dex */
public class DataManager {
    private JSONObject mData;

    public DataManager() {
        JSONObject jSONObject = new JSONObject();
        this.mData = jSONObject;
        try {
            jSONObject.put(c.y, 10);
        } catch (JSONException unused) {
        }
    }

    public void add(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.mData.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public Object getData(String str) {
        return this.mData.opt(str);
    }

    public void replaceData(Object obj) {
        if (obj == null || !(obj instanceof JSONObject)) {
            return;
        }
        this.mData = (JSONObject) obj;
    }

    public void setData(String str, Object obj) {
        try {
            this.mData.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void add(Map<String, Object> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                try {
                    this.mData.put(str, map.get(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
