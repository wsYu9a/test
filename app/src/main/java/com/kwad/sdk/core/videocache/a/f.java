package com.kwad.sdk.core.videocache.a;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.utils.ai;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes3.dex */
public final class f implements c {
    private static String eU(String str) {
        Uri parse = Uri.parse(str);
        if (parse.getHost() == null || !parse.getHost().contains("yximgs.com")) {
            return str;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        HashMap hashMap = new HashMap();
        if (parse.isHierarchical()) {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            for (String str2 : queryParameterNames) {
                hashMap.put(str2, parse.getQueryParameter(str2));
            }
            buildUpon.clearQuery();
            for (String str3 : queryParameterNames) {
                if (!TTDownloadField.TT_TAG.equals(str3) && !"di".equals(str3) && str3 != null) {
                    buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
                }
            }
        }
        return buildUpon.toString();
    }

    private static String getExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || lastIndexOf + 6 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.kwad.sdk.core.videocache.a.c
    public final String generate(String str) {
        String eU = eU(str);
        String extension = getExtension(eU);
        String by = ai.by(eU);
        if (TextUtils.isEmpty(extension)) {
            return by;
        }
        return by + p1.b.f29697h + extension;
    }
}
