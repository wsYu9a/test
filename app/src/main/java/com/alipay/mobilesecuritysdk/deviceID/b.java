package com.alipay.mobilesecuritysdk.deviceID;

import android.content.SharedPreferences;
import java.util.Map;

/* loaded from: classes.dex */
public class b {
    String a(SharedPreferences sharedPreferences, String str) {
        return sharedPreferences.getString(str, "");
    }

    void b(SharedPreferences sharedPreferences, Map<String, String> map) {
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
}
