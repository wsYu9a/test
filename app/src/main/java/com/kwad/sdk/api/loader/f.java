package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.api.loader.a;
import com.martian.mibook.application.MiConfigSingleton;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class f {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final v Zx;
    private int Zy;
    private String Zz;
    private final String mUrl;

    public interface a {
        void a(a.b bVar);
    }

    f(v vVar) {
        this.Zx = vVar;
        String tx = vVar.tx();
        this.mUrl = tx;
        this.Zz = tx;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004a: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:40:0x004a */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.io.InputStream r5) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            r2.<init>()     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
        La:
            int r3 = r5.read(r0)     // Catch: java.io.IOException -> L2b java.lang.Throwable -> L49
            r4 = -1
            if (r3 == r4) goto L16
            r4 = 0
            r2.write(r0, r4, r3)     // Catch: java.io.IOException -> L2b java.lang.Throwable -> L49
            goto La
        L16:
            java.lang.String r0 = r2.toString()     // Catch: java.io.IOException -> L2b java.lang.Throwable -> L49
            r5.close()     // Catch: java.io.IOException -> L1e
            goto L22
        L1e:
            r5 = move-exception
            r5.printStackTrace()
        L22:
            r2.close()     // Catch: java.io.IOException -> L26
            goto L2a
        L26:
            r5 = move-exception
            r5.printStackTrace()
        L2a:
            return r0
        L2b:
            r0 = move-exception
            goto L31
        L2d:
            r0 = move-exception
            goto L4b
        L2f:
            r0 = move-exception
            r2 = r1
        L31:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L49
            if (r5 == 0) goto L3e
            r5.close()     // Catch: java.io.IOException -> L3a
            goto L3e
        L3a:
            r5 = move-exception
            r5.printStackTrace()
        L3e:
            if (r2 == 0) goto L48
            r2.close()     // Catch: java.io.IOException -> L44
            goto L48
        L44:
            r5 = move-exception
            r5.printStackTrace()
        L48:
            return r1
        L49:
            r0 = move-exception
            r1 = r2
        L4b:
            if (r5 == 0) goto L55
            r5.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r5 = move-exception
            r5.printStackTrace()
        L55:
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.io.IOException -> L5b
            goto L5f
        L5b:
            r5 = move-exception
            r5.printStackTrace()
        L5f:
            goto L61
        L60:
            throw r0
        L61:
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.f.a(java.io.InputStream):java.lang.String");
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static HttpURLConnection bb(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }

    private String c(Map<String, String> map) {
        String ao = g.ao(this.Zx.getContext());
        if (TextUtils.isEmpty(ao)) {
            ao = this.Zx.ty().getSDKVersion();
        }
        int sDKVersionCode = this.Zx.ty().getSDKVersionCode();
        JSONObject appInfo = this.Zx.ty().getAppInfo();
        JSONObject deviceInfo = this.Zx.ty().getDeviceInfo();
        JSONObject networkInfo = this.Zx.ty().getNetworkInfo();
        JSONObject jSONObject = new JSONObject();
        l.putValue(jSONObject, "sdkApiVersion", "3.3.40");
        l.putValue(jSONObject, "sdkApiVersionCode", 3034000);
        l.putValue(jSONObject, "sdkVersion", ao);
        l.putValue(jSONObject, "SDKVersionCode", sDKVersionCode);
        l.putValue(jSONObject, "sdkType", 1);
        l.putValue(jSONObject, "appInfo", appInfo);
        l.putValue(jSONObject, com.alipay.mobilesecuritysdk.deviceID.c.v, deviceInfo);
        l.putValue(jSONObject, "networkInfo", networkInfo);
        l.putValue(jSONObject, "sdkAbi", w.tz());
        String jSONObject2 = jSONObject.toString();
        this.Zx.ty().addHp(map);
        JSONObject jSONObject3 = new JSONObject();
        l.putValue(jSONObject3, "version", "3.3.40");
        l.putValue(jSONObject3, "appId", appInfo.optString("appId"));
        l.putValue(jSONObject3, com.heytap.mcssdk.n.d.l, this.Zx.ty().getRM(jSONObject2));
        this.Zx.ty().sR(this.mUrl, map, jSONObject3.toString());
        return jSONObject3.toString();
    }

    private static Map<String, String> to() {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.ACCEPT_LANGUAGE, "zh-CN");
        hashMap.put("Connection", "keep-alive");
        hashMap.put("Charset", "UTF-8");
        hashMap.put("Content-Type", "application/json; charset=UTF-8");
        hashMap.put("User-Agent", RequestParamsUtils.getUserAgent());
        return hashMap;
    }

    public final void a(a aVar) {
        HttpURLConnection httpURLConnection = null;
        try {
            Map<String, String> map = to();
            String c2 = c(map);
            HttpURLConnection bb = bb(this.Zz);
            a(bb, map);
            bb.connect();
            new DataOutputStream(bb.getOutputStream()).write(c2.getBytes());
            int responseCode = bb.getResponseCode();
            if (responseCode == 200) {
                String a2 = a(bb.getInputStream());
                a.b bVar = new a.b();
                JSONObject jSONObject = new JSONObject(a2);
                String optString = jSONObject.optString(MiConfigSingleton.t0);
                if (!TextUtils.isEmpty(optString) && !"null".equals(optString)) {
                    jSONObject.put(MiConfigSingleton.t0, new JSONObject(this.Zx.ty().getRD(optString)));
                }
                bVar.parseJson(jSONObject);
                aVar.a(bVar);
            } else {
                if (responseCode / 100 != 3) {
                    throw new RuntimeException("response code = " + responseCode);
                }
                if (this.Zy < 21) {
                    this.Zz = bb.getHeaderField(HttpHeaders.LOCATION);
                    this.Zy++;
                    a(aVar);
                }
            }
            try {
                bb.disconnect();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }
}
