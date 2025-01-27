package com.opos.cmn.func.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.acs.st.STManager;
import com.opos.cmn.biz.a.e;
import com.opos.cmn.func.b.b.a.b;
import com.opos.cmn.func.b.b.a.g;
import com.opos.cmn.func.b.b.d;
import com.opos.cmn.nt.crypt.EncryptUtils;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes4.dex */
public class b {
    public static g a(Context context) {
        try {
            new g.a().a(e(context));
            return new g.a().a();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("ParamUtils", "getDefaultInitParameter", e2);
            return null;
        }
    }

    public static d a(Context context, d dVar) {
        boolean z;
        try {
            d.a a2 = new d.a().a(dVar);
            Map<String, String> a3 = a(dVar.f17155c);
            byte[] bArr = dVar.f17156d;
            if (TextUtils.isEmpty(a(a3, "Route-Data")) && context != null) {
                a3.put("Route-Data", e.a(context));
            }
            if (dVar.f17159g && dVar.f17156d != null) {
                if (TextUtils.isEmpty(a(a3, "Content-Encoding"))) {
                    z = false;
                } else {
                    com.opos.cmn.an.f.a.b("ParamUtils", "isAlreadyCompress=true");
                    z = true;
                }
                if (!z) {
                    boolean z2 = dVar.f17156d.length >= 1024;
                    com.opos.cmn.an.f.a.b("ParamUtils", "neeCompress=" + z2);
                    if (z2) {
                        bArr = com.opos.cmn.b.c.a.a(bArr);
                        a3.put("Content-Encoding", "gzip");
                    }
                }
            }
            if (dVar.f17158f) {
                long currentTimeMillis = System.currentTimeMillis();
                byte[] executeEncryptBytesV2 = EncryptUtils.executeEncryptBytesV2(bArr);
                if (executeEncryptBytesV2 != null && executeEncryptBytesV2.length > 0) {
                    a3.put("encrypt", "v1");
                    bArr = executeEncryptBytesV2;
                    com.opos.cmn.an.f.a.b("ParamUtils", "crypt data costTime:" + (System.currentTimeMillis() - currentTimeMillis));
                }
                com.opos.cmn.an.f.a.b("ParamUtils", "crypt data failed");
                com.opos.cmn.an.f.a.b("ParamUtils", "crypt data costTime:" + (System.currentTimeMillis() - currentTimeMillis));
            }
            return a2.a(a3).a(bArr).a();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("ParamUtils", "getProcessedNetRequest", e2);
            return dVar;
        }
    }

    private static String a(Map<String, String> map, String str) {
        if (str == null || map == null || map.size() == 0) {
            return null;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equalsIgnoreCase(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    private static Map<String, String> a(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    public static String b(Context context) {
        return com.opos.cmn.an.h.d.a.c(context, context.getPackageName());
    }

    public static String c(Context context) {
        return com.opos.cmn.biz.a.d.a(context);
    }

    public static b.a d(Context context) {
        return STManager.REGION_OF_CN.equalsIgnoreCase(com.opos.cmn.biz.a.d.a(context)) ? b.a.CN : STManager.REGION_OF_IN.equalsIgnoreCase(com.opos.cmn.biz.a.d.a(context)) ? b.a.SA : b.a.SEA;
    }

    private static SSLSocketFactory e(Context context) {
        SSLSocketFactory sSLSocketFactory;
        try {
            sSLSocketFactory = com.opos.cmn.biz.a.g.a(context);
        } catch (Exception unused) {
            sSLSocketFactory = null;
        }
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused2) {
            return sSLSocketFactory;
        }
    }
}
