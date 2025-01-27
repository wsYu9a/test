package com.alipay.mobilesecuritysdk.deviceID;

import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.sdk.internal.bj;
import com.baidu.mobads.sdk.internal.bw;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.martian.mibook.application.MiConfigSingleton;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a */
    public static final String f5264a = "0";

    private String b(Map<String, String> map) throws JSONException {
        if (map == null || map.size() <= 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
            }
        }
        return jSONObject.toString();
    }

    String a(SharedPreferences sharedPreferences, String str) {
        return sharedPreferences.getString(str, "");
    }

    public e c(String str) {
        JSONObject jSONObject;
        if (str == null) {
            return null;
        }
        Log.i(c.f5228b, "server response is" + str);
        e eVar = new e();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            eVar.r(jSONObject2.getBoolean(bw.o));
            if (eVar.j() && (jSONObject = jSONObject2.getJSONObject(MiConfigSingleton.t0)) != null) {
                eVar.t(jSONObject.getString("version"));
                eVar.m(jSONObject.getString("apdid"));
                eVar.n(jSONObject.getString(c.z));
                JSONObject jSONObject3 = jSONObject.getJSONObject("rule");
                if (jSONObject3 != null) {
                    eVar.l(jSONObject3.getString("function"));
                }
                eVar.q(jSONObject3.toString());
                eVar.s(jSONObject.getString(c.y));
                eVar.o(jSONObject.getString(c.B));
            }
        } catch (JSONException e2) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("");
            arrayList.add("");
            arrayList.add("");
            arrayList.add(f.e(e2));
            f.g(arrayList);
        }
        return eVar;
    }

    void d(SharedPreferences sharedPreferences, Map<String, String> map) {
        SharedPreferences.Editor edit;
        if (sharedPreferences == null || map == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.clear();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                edit.putString(key, (String) value);
            } else if (value instanceof Integer) {
                edit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                edit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                edit.putFloat(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                edit.putBoolean(key, ((Boolean) value).booleanValue());
            }
        }
        edit.commit();
    }

    public String e(Map<String, String> map) throws JSONException {
        return b(map);
    }

    public String f(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        String key = entry.getKey();
                        if (key.equals(c.v)) {
                            jSONObject3.put(key, new JSONObject(b((Map) entry.getValue())));
                        } else {
                            jSONObject3.put(key, (String) entry.getValue());
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        jSONObject2.put(am.x, BaseWrapper.BASE_PKG_SYSTEM);
        jSONObject2.put(MiConfigSingleton.t0, jSONObject3);
        jSONObject.put("type", "deviceinfo");
        jSONObject.put(bj.f5604i, jSONObject2);
        return jSONObject.toString();
    }

    public Map<String, String> g(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, (String) jSONObject.get(next));
            }
            return hashMap;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
