package b.h.a.e;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.internal.bj;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    private static final String f4993a = "b.h.a.e.k";

    public static String a(String str, String str2, long j2, int i2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, b.h.a.b bVar) {
        String str12;
        HashMap hashMap = new HashMap();
        hashMap.put("specificId", str);
        hashMap.put("reportReason", str2);
        hashMap.put("ts", String.valueOf(j2));
        hashMap.put("businessVersion", b.f(b.a()));
        hashMap.put("protocolVersion", "3");
        hashMap.put("errorCode", String.valueOf(i2));
        hashMap.put("subType", str3);
        hashMap.put(bj.f5605j, f.b());
        hashMap.put(bj.f5604i, Build.MODEL);
        hashMap.put("osVersion", f.c());
        hashMap.put("romVersion", f.a());
        hashMap.put("androidVersion", Build.VERSION.RELEASE);
        hashMap.put("imei", str4.replace("%23", "#"));
        hashMap.put("openId", str5.replace("%23", "#"));
        hashMap.put("tracePkg", str6);
        hashMap.put("program", str7);
        if (!TextUtils.isEmpty(str8)) {
            hashMap.put("fileName", str8);
        }
        if (!TextUtils.isEmpty(str9)) {
            hashMap.put("errorMsg", str9);
        }
        String str13 = str10 + File.separator + str8;
        String b2 = b(hashMap);
        bVar.a("NearX-HLog", "签名生成空格替换前参数: " + b2 + "url: " + str13);
        String replaceAll = b2.replaceAll(" ", "_");
        byte[] bytes = replaceAll.getBytes();
        byte[] b3 = h.b(h.c(str13));
        if (b3 == null) {
            Log.e(com.alipay.mobilesecuritysdk.deviceID.h.f5265a, "log zip file is null");
            str12 = str11;
        } else {
            byte[] bArr = new byte[bytes.length + b3.length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            System.arraycopy(b3, 0, bArr, bytes.length, b3.length);
            str12 = str11;
            bytes = bArr;
        }
        String d2 = d(bytes, str12);
        bVar.a("NearX-HLog", "签名生成空格替换后参数: " + replaceAll + "url: " + str13 + "\n sign: " + d2);
        return d2;
    }

    private static String b(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            sb.append(str);
            sb.append("=");
            sb.append(map.get(str));
            sb.append("&");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    private static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if ((bArr[i2] & 255) < 16) {
                sb.append("0");
            }
            sb.append(Long.toString(bArr[i2] & 255, 16));
        }
        return sb.toString();
    }

    private static String d(byte[] bArr, String str) {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(str.getBytes("UTF-8"), mac.getAlgorithm()));
            return c(mac.doFinal(bArr));
        } catch (Exception e2) {
            throw new RuntimeException("HMAC-SHA1 encode error", e2);
        }
    }
}
