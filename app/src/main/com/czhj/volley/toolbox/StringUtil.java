package com.czhj.volley.toolbox;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class StringUtil {
    public static String clsName = null;

    /* renamed from: cn, reason: collision with root package name */
    public static String f8835cn = "q1vljpre1fq";

    /* renamed from: dc, reason: collision with root package name */
    public static String f8836dc = "gf1vljpre1fq";
    public static String rtb = "uwefdooedfn1vljpre1fq";

    /* renamed from: s, reason: collision with root package name */
    public static String f8837s = "vljpre";
    public static String sad = "vljpreDg";
    public static String service = "dgvhuylfh1vljpre1fq";
    public static String tp = "wudfnws1vljpre1fq";
    public static String track = "wudfn1vljpre1fq";
    public static Map<String, String> urlMap;

    static {
        HashMap hashMap = new HashMap();
        urlMap = hashMap;
        clsName = "frp1f}km";
        hashMap.put(decode(service), "adservice.sigmob.cn");
        urlMap.put(decode(f8836dc), "dc.sigmob.cn");
        urlMap.put(decode(track), "track.sigmob.cn");
        urlMap.put(decode(tp), "tracktp.sigmob.cn");
        urlMap.put(decode(f8835cn), "n.sigmob.cn");
        urlMap.put(decode(rtb), "rtbcallback.sigmob.cn");
    }

    public static String decode(String str) {
        byte[] bytes = str.getBytes();
        for (int i10 = 0; i10 < bytes.length; i10++) {
            bytes[i10] = (byte) (bytes[i10] - 3);
        }
        return new String(bytes);
    }

    public static String getUrl(String str) {
        if (StringUtil.class.getName().startsWith(decode(clsName))) {
            return str;
        }
        for (Map.Entry<String, String> entry : urlMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(str) && str.contains(key)) {
                return str.replace(key, value);
            }
        }
        return str;
    }

    public static String scheme() {
        return decode(sad);
    }
}
