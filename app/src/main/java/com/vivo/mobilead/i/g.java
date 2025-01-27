package com.vivo.mobilead.i;

import android.text.TextUtils;
import android.util.Base64;
import com.vivo.ad.model.w;
import com.vivo.mobilead.util.h0;
import com.vivo.mobilead.util.x0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class g extends l {
    static String a(String str) {
        return str;
    }

    public static Map<String, String> a(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    hashMap.put(entry.getKey(), entry.getValue().get(0));
                }
            }
        }
        return hashMap;
    }

    public static String b(String str) {
        try {
            return new String(Base64.encode(str.getBytes(), 2), "utf-8");
        } catch (Exception e2) {
            x0.b("HttpUtils", "Base64 encode error happens", e2);
            return str;
        }
    }

    public static String c(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e2) {
            x0.b("HttpUtils", "url encode error happens", e2);
            return str;
        }
    }

    public static String d(String str) {
        try {
            String a2 = s.a("GET", str, a(str, true));
            x0.a("HttpUtils", "sign:" + a2);
            return a(str, "s", a2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String a(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";");
            for (int i2 = 1; i2 < split.length; i2++) {
                String[] split2 = split[i2].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable th) {
                byteArrayOutputStream.flush();
                throw th;
            }
        }
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray() != null ? byteArrayOutputStream.toByteArray() : new byte[0];
    }

    public static void a(HttpsURLConnection httpsURLConnection) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
            sSLContext.init(null, null, null);
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (KeyManagementException e2) {
            e2.printStackTrace();
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
        } catch (Exception unused) {
        }
    }

    public static String a(String str, boolean z, String str2, boolean z2) {
        HashMap a2 = a(str, z);
        HashMap a3 = a(str2, z2);
        String str3 = "";
        if (a2 != null && a3 != null) {
            try {
                a2.putAll(a3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        str3 = s.a("GET", str, a2);
        x0.a("HttpUtils", "sign:" + str3);
        return str3;
    }

    public static void a(String str, Map<String, String> map) {
        try {
            String a2 = s.a("POST", str, map);
            x0.a("HttpUtils", "sign:" + a2);
            map.put("s", a2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String a(String str, String str2, String str3) {
        if (str.contains("?")) {
            return str + "&" + str2 + "=" + c(str3);
        }
        return str + "?" + str2 + "=" + c(str3);
    }

    public static HashMap a(String str, boolean z) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        if (str.contains("?")) {
            try {
                str = str.split("\\?")[1];
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "";
            }
        }
        if (!TextUtils.isEmpty(str) && str.contains("=")) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length > 1) {
                    if (TextUtils.isEmpty(split[1])) {
                        split[1] = "";
                    }
                    String str3 = split[1];
                    if (z) {
                        try {
                            str3 = URLDecoder.decode(str3, "UTF-8");
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    hashMap.put(split[0], str3);
                } else if (split.length == 1) {
                    hashMap.put(split[0], "");
                }
            }
        } else {
            x0.b("HttpUtils", "keyUrl is empty");
        }
        return hashMap;
    }

    public static String a(String str, long j2, int i2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return a(str, j2, i2, f2, f3, f4, f5, f6, f7, f8, f9, null);
    }

    public static String a(String str, long j2, int i2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, w wVar) {
        if (str.contains("__TS__")) {
            str = str.replace("__TS__", c(String.valueOf(j2)));
        }
        if (str.contains("__IP__")) {
            str = str.replace("__IP__", h0.K().n());
        }
        if (str.contains("__CLICKAREA__")) {
            str = str.replace("__CLICKAREA__", c(String.valueOf(i2)));
        }
        if (str.contains("__X__")) {
            str = str.replace("__X__", String.valueOf(f4));
        }
        if (str.contains("__Y__")) {
            str = str.replace("__Y__", String.valueOf(f5));
        }
        if (str.contains("__REAL_X__")) {
            str = str.replace("__REAL_X__", String.valueOf(f2));
        }
        if (str.contains("__REAL_Y__")) {
            str = str.replace("__REAL_Y__", String.valueOf(f3));
        }
        if (str.contains("__AD_LT_X__")) {
            str = str.replace("__AD_LT_X__", String.valueOf(f6));
        }
        if (str.contains("__AD_LT_Y__")) {
            str = str.replace("__AD_LT_Y__", String.valueOf(f7));
        }
        if (str.contains("__AD_RB_X__")) {
            str = str.replace("__AD_RB_X__", String.valueOf(f8));
        }
        if (str.contains("__AD_RB_Y__")) {
            str = str.replace("__AD_RB_Y__", String.valueOf(f9));
        }
        if (wVar == null) {
            return str;
        }
        if (str.contains("__SHAKE_FLAG__")) {
            str = str.replace("__SHAKE_FLAG__", String.valueOf(wVar.e()));
        }
        if (str.contains("__CFG_ACC__")) {
            str = str.replace("__CFG_ACC__", String.valueOf(wVar.b()));
        }
        if (str.contains("__CFG_DEGREE__")) {
            str = str.replace("__CFG_DEGREE__", String.valueOf(wVar.a()));
        }
        if (str.contains("__SENSOR_ACC__")) {
            str = str.replace("__SENSOR_ACC__", String.valueOf(wVar.d()));
        }
        return str.contains("__SENSOR_DEGREE__") ? str.replace("__SENSOR_DEGREE__", String.valueOf(wVar.c())) : str;
    }

    public static String a(HashMap<String, String> hashMap) {
        JSONObject jSONObject = new JSONObject();
        if (hashMap == null || hashMap.size() <= 0) {
            return "";
        }
        try {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    try {
                        jSONObject.put(key, value);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return "";
                    }
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }
}
