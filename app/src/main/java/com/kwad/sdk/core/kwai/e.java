package com.kwad.sdk.core.kwai;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public final class e {
    public static void a(String str, Map<String, String> map, String str2) {
        map.put("Ks-Sig1", ca(s(str, str2)));
    }

    private static String bZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return emptyIfNull(str);
        }
        String[] split = str.split("&");
        Arrays.sort(split);
        return TextUtils.join("&", split);
    }

    private static String ca(String str) {
        String doSign;
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        return (context == null || (doSign = KWEGIDDFP.doSign(context, str)) == null) ? "" : doSign;
    }

    private static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    private static String s(String str, String str2) {
        Uri parse = Uri.parse(str);
        return parse.getPath() + "&" + bZ(parse.getQuery()) + "&" + str2;
    }
}
