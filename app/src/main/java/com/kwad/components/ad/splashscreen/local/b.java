package com.kwad.components.ad.splashscreen.local;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {
    @Nullable
    private static a a(Context context, long j2) {
        if (context == null) {
            return null;
        }
        try {
            String Dy = y.Dy();
            if (TextUtils.isEmpty(Dy)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(Dy);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            String str = u.parseJSON2MapString(aVar.BU).get(String.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                aVar.BT.put(Long.valueOf(j2), 0);
            } else {
                aVar.BT.put(Long.valueOf(j2), Integer.valueOf(str));
            }
            return aVar;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    public static void b(Context context, long j2) {
        Map hashMap;
        a a2 = a(context, j2);
        long currentTimeMillis = System.currentTimeMillis();
        if (a2 == null) {
            a2 = new a(currentTimeMillis, j2, 1);
            hashMap = new HashMap();
            hashMap.put(String.valueOf(j2), "1");
        } else {
            String str = a2.BU;
            if (TextUtils.isEmpty(str) || !a2.e(currentTimeMillis)) {
                hashMap = new HashMap();
                hashMap.put(String.valueOf(j2), "1");
                a2.gq = currentTimeMillis;
                a2.BT.put(Long.valueOf(j2), 1);
            } else {
                hashMap = u.parseJSON2MapString(str);
                int intValue = (TextUtils.isEmpty((CharSequence) hashMap.get(String.valueOf(j2))) ? 0 : Integer.valueOf((String) hashMap.get(String.valueOf(j2))).intValue()) + 1;
                hashMap.put(String.valueOf(j2), String.valueOf(intValue));
                a2.BT.put(Long.valueOf(j2), Integer.valueOf(intValue));
            }
        }
        a2.BU = u.parseMap2JSON(hashMap).toString();
        if (context != null) {
            y.ad(context, a2.toJson().toString());
        }
    }

    public static boolean b(Context context, long j2, AdInfo adInfo) {
        a a2 = a(context, j2);
        return !(a2 == null || !a2.a(j2, adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardCountDaily));
    }
}
