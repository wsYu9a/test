package com.shu.priory.utils;

import android.content.Context;
import android.text.TextUtils;
import com.shu.priory.config.SDKConstants;
import com.umeng.analytics.pro.by;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class j {

    /* renamed from: a */
    public static final String f17312a = "1";

    /* renamed from: b */
    public static final String f17313b = "0";

    /* renamed from: c */
    public static final String f17314c = "2";

    private static int a() {
        return new Random().nextInt(31) + 50;
    }

    public static void b(Object... objArr) {
        com.shu.priory.request.b bVar = new com.shu.priory.request.b();
        if (objArr == null || objArr.length == 0 || TextUtils.isEmpty((String) objArr[0])) {
            return;
        }
        if (objArr.length > 1) {
            bVar.a((Context) objArr[1]);
            bVar.a(((Integer) objArr[2]).intValue());
        } else {
            bVar.a(false);
        }
        bVar.b(0);
        bVar.c(by.f23697b);
        bVar.a((String) objArr[0], null, null);
        bVar.a((com.shu.priory.request.c) null);
    }

    public static JSONArray a(double d10, JSONArray jSONArray) {
        try {
            String jSONArray2 = jSONArray.toString();
            String replace = jSONArray2.replace("__TS__", String.valueOf(System.currentTimeMillis())).replace("__TIMESTAMP__", String.valueOf(System.currentTimeMillis() / 1000));
            if (!jSONArray2.contains("${AUCTION_PRICE}")) {
                return new JSONArray(replace);
            }
            if (d10 < l5.c.f27899e) {
                return null;
            }
            return new JSONArray(jSONArray2.replace("${AUCTION_PRICE}", f.b(d10 + "")));
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "exp array" + th2.getMessage());
            return jSONArray;
        }
    }

    public static JSONArray a(int i10, float f10, float f11, float f12, float f13, int[] iArr, JSONArray jSONArray) {
        String str;
        String str2;
        try {
            String replace = jSONArray.toString().replace("__INTERACT_TYPE__", String.valueOf(i10));
            if (replace.contains("__SLD__")) {
                if (i10 == 2) {
                    str2 = f17314c;
                } else {
                    str2 = i10 == 3 ? f17312a : f17313b;
                }
                replace = replace.replace("__SLD__", str2);
            }
            if (replace.contains("__CLICK_SLD__")) {
                if (i10 == 2) {
                    str = f17314c;
                } else {
                    str = i10 == 3 ? f17312a : f17313b;
                }
                replace = replace.replace("__CLICK_SLD__", str);
            }
            if (i10 == 2 && iArr.length == 3) {
                if (iArr[0] == 0) {
                    iArr[0] = -999;
                }
                if (iArr[1] == 0) {
                    iArr[1] = -999;
                }
                if (iArr[2] == 0) {
                    iArr[2] = -999;
                }
                if (replace.contains("__ACC_X__")) {
                    replace = replace.replace("__ACC_X__", String.valueOf(iArr[0]));
                }
                if (replace.contains("__ACC_Y__")) {
                    replace = replace.replace("__ACC_Y__", String.valueOf(iArr[1]));
                }
                if (replace.contains("__ACC_Z__")) {
                    replace = replace.replace("__ACC_Z__", String.valueOf(iArr[2]));
                }
                int i11 = iArr[0];
                if (i11 != -999 && iArr[1] != -999 && iArr[2] != -999) {
                    replace = replace.replace("__NEW_ACC_X__", String.valueOf(i11)).replace("__NEW_ACC_Y__", String.valueOf(iArr[1])).replace("__NEW_ACC_Z__", String.valueOf(iArr[2]));
                }
            }
            if (f10 != 0.0f && f11 != 0.0f && f12 != 0.0f && f13 != 0.0f) {
                replace = replace.replace("__DOWN_X__", String.valueOf(f10)).replace("__DOWN_Y__", String.valueOf(f11)).replace("__UP_X__", String.valueOf(f12)).replace("__UP_Y__", String.valueOf(f13));
                if (i10 == 1 || i10 == 3) {
                    replace = replace.replace("__CLICK_DOWN_X__", String.valueOf(f10)).replace("__CLICK_DOWN_Y__", String.valueOf(f11)).replace("__CLICK_UP_X__", String.valueOf(f12)).replace("__CLICK_UP_Y__", String.valueOf(f13));
                }
            }
            return new JSONArray(replace);
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "click array" + th2.getMessage());
            return jSONArray;
        }
    }

    public static JSONArray a(int i10, JSONArray jSONArray) {
        long currentTimeMillis = System.currentTimeMillis();
        long a10 = a() + currentTimeMillis;
        try {
            String replace = jSONArray.toString().replace("__TS__", String.valueOf(currentTimeMillis)).replace("__TIMESTAMP__", String.valueOf(System.currentTimeMillis() / 1000));
            if (i10 == 1 || i10 == 3) {
                replace = replace.replace("__UP_TS__", String.valueOf(a10));
            }
            return new JSONArray(replace);
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "click array ts " + th2.getMessage());
            return jSONArray;
        }
    }

    public static JSONArray a(String str, JSONArray jSONArray) {
        try {
            if (TextUtils.isEmpty(str)) {
                return jSONArray;
            }
            String jSONArray2 = jSONArray.toString();
            return !jSONArray2.contains("__IFLY_EXT__") ? jSONArray : new JSONArray(jSONArray2.replace("__IFLY_EXT__", f.c(str)));
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "exp ext array" + th2.getMessage());
            return jSONArray;
        }
    }

    public static JSONArray a(JSONArray jSONArray) {
        try {
            return new JSONArray(jSONArray.toString().replace("__TIMESTAMP__", String.valueOf(System.currentTimeMillis() / 1000)));
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "click array ts " + th2.getMessage());
            return jSONArray;
        }
    }

    public static void a(JSONArray jSONArray, String str, boolean z10) {
        if (jSONArray == null || jSONArray.length() < 1 || !z10) {
            return;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            String str2 = jSONArray.optString(i10) + str;
            com.shu.priory.request.b bVar = new com.shu.priory.request.b();
            bVar.a(false);
            bVar.b(0);
            bVar.c(by.f23697b);
            bVar.a(str2, null, null);
            bVar.a((com.shu.priory.request.c) null);
        }
    }

    public static void a(Object... objArr) {
        h.a(SDKConstants.TAG, "sendMonitor");
        try {
            JSONArray jSONArray = (JSONArray) objArr[0];
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    String string = jSONArray.getString(i10);
                    if (objArr.length <= 1 || i10 != 0) {
                        b(string);
                    } else {
                        b(string, objArr[1], objArr[2]);
                    }
                }
            }
        } catch (JSONException unused) {
            h.d(SDKConstants.TAG, "MonitorUtil::sendMonitor() error");
        }
    }
}
