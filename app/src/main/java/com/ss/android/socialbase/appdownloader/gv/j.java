package com.ss.android.socialbase.appdownloader.gv;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.lg;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: j */
    private static final HashMap<String, lg.j> f24447j = new HashMap<>();

    public static boolean i(JSONObject jSONObject) {
        return jSONObject == null || gv.j() || jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_SECURITY_MODE) != 1;
    }

    public static boolean j(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null && str.equals(optJSONObject.optString("type")) && j(optJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean zx(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i2 = Build.VERSION.SDK_INT;
        String optString = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_ALLOW_OS_API_RANGE);
        int optInt = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_MIN_OS_API, -1);
        if (TextUtils.isEmpty(optString)) {
            return optInt <= 0 || i2 >= optInt;
        }
        try {
            String[] split = optString.split("[-,]");
            for (int i3 = 0; i3 < split.length; i3 += 2) {
                int parseInt = Integer.parseInt(split[i3]);
                int parseInt2 = Integer.parseInt(split[i3 + 1]);
                if (i2 >= parseInt && i2 <= parseInt2) {
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return zx(jSONObject) && j(jSONObject.optJSONArray(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_REQUIREMENTS)) && i(jSONObject);
    }

    public static boolean j(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_PACKAGE_NAMES);
                JSONArray optJSONArray = optJSONObject.optJSONArray(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_VERSION_ALLOW);
                JSONArray optJSONArray2 = optJSONObject.optJSONArray(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_VERSION_BLOCK);
                String optString2 = optJSONObject.optString(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ALLOW_VERSION_RANGE);
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                for (String str : optString.split(",")) {
                    if (BaseConstants.SCHEME_MARKET.equals(str)) {
                        str = q.k();
                    }
                    lg.j zx = zx(str);
                    if (zx != null && !(z = j(optJSONArray, optJSONArray2, optString2, zx))) {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    private static boolean zx(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i2).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static lg.j zx(String str) {
        HashMap<String, lg.j> hashMap = f24447j;
        if (hashMap.containsKey(str)) {
            lg.j jVar = hashMap.get(str);
            if (jVar != null) {
                return jVar;
            }
            return null;
        }
        lg.j zx = lg.zx(str);
        hashMap.put(str, zx);
        if (zx != null) {
            return zx;
        }
        return null;
    }

    private static boolean j(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull lg.j jVar) {
        String lg = jVar.lg();
        int gv = jVar.gv();
        String str2 = gv + "_" + lg;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("[-,]");
                for (int i2 = 0; i2 < split.length; i2 += 2) {
                    int parseInt = Integer.parseInt(split[i2]);
                    int parseInt2 = Integer.parseInt(split[i2 + 1]);
                    if (gv >= parseInt && gv <= parseInt2) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (zx(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !zx(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    public static lg.j j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                lg.j zx = zx(str);
                if (zx != null) {
                    return zx;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean j(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String optString = jSONObject.optString("s");
            try {
                String j2 = i.j(jSONObject.optString("az"), optString);
                String j3 = i.j(jSONObject.optString("ba"), optString);
                Field declaredField = ContextWrapper.class.getDeclaredField(j2);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(j3);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
