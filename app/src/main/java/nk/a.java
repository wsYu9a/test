package nk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kuaishou.weapon.p0.t;
import com.sntech.net.DomainProvider;
import com.sntech.net.NetCallback;
import com.sntech.net.NetClient;
import com.sntech.net.NetRequest;
import com.umeng.analytics.pro.bt;
import fh.a;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    public static String f28934a = "if" + p1.b.f29697h + a.class.getSimpleName();

    /* renamed from: b */
    public static JSONObject f28935b = null;

    /* JADX WARN: Removed duplicated region for block: B:26:0x0142 A[Catch: Exception -> 0x007c, TryCatch #0 {Exception -> 0x007c, blocks: (B:6:0x0044, B:41:0x0075, B:8:0x007f, B:10:0x008a, B:11:0x0092, B:13:0x0098, B:15:0x00a6, B:17:0x00ed, B:20:0x0113, B:21:0x0127, B:33:0x0132, B:24:0x013a, B:26:0x0142, B:27:0x0156, B:36:0x0161, B:38:0x0167), top: B:5:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x015f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0160 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p006instanceof.Cdo a(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.Object> r10) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: nk.a.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map):instanceof.do");
    }

    public static JSONObject b(JSONObject jSONObject) {
        String str;
        Context context = ph.g.f29897a;
        String str2 = ph.g.f29899c;
        String a10 = a.b.a(UUID.randomUUID().toString().getBytes());
        byte[] bArr = fh.a.f26040a;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("od", jSONObject);
        jSONObject2.put("did", str2);
        jSONObject2.put(t.f11211k, a10);
        jSONObject2.put("p", ph.g.f29897a.getPackageName());
        jSONObject2.put("s_v", ph.g.f29898b);
        Context context2 = ph.g.f29897a;
        try {
            str = a.b.a(context2.getPackageManager().getPackageInfo(context2.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e10) {
            e10.printStackTrace();
            str = "";
        }
        jSONObject2.put("p_s", str);
        byte[] bytes = jSONObject2.toString().getBytes();
        JSONObject jSONObject3 = new JSONObject();
        byte[] b10 = a.b.b(UUID.randomUUID().toString() + System.currentTimeMillis());
        byte[] a11 = a.c.a(bytes);
        byte[] bArr2 = fh.a.f26040a;
        SecretKeySpec secretKeySpec = new SecretKeySpec(b10, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
        String encodeToString = Base64.encodeToString(cipher.doFinal(a11), 2);
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance(d3.d.f25247a).generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtBXKwTT+bbYukXr9GxnfHcUJOZYp4BrT3AdOeCdEr3n/YT42o3oNOf6nCGuz0Wod61rrxcTlVS/A+sjhQLBf2H6kkOVM4Xc+LU+2xBRXEkmFRZQf8lzSrzLDclrqS7IhHIwUdWZJR6vdQJlvD6VA/AtnzVIGvbQPVhbnVzo2er+Moww/3Aqp8xBn7qF11tgL4AcyWqtDwPYY7cTC22IcxZeB3Um/WyWpAsR2a61RlyANfQ56znGXirZImI4SRFcIVwsSvBXrysnFVx07VNoXELRZEeIywjMfyK1QbSu9/Q2NZwnIR0cD/Cr/QAPr9qkhX3uHNjPZrBYZ+FxwBkijmQIDAQAB".replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", "").replaceAll("\n", ""), 0)));
        Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher2.init(1, rSAPublicKey);
        String encodeToString2 = Base64.encodeToString(cipher2.doFinal(b10), 2);
        jSONObject3.put("d", encodeToString);
        jSONObject3.put("k", encodeToString2);
        jSONObject3.put("d_v", 3);
        jSONObject3.put(com.kwad.sdk.m.e.TAG, 10);
        jSONObject3.put("c", ph.g.f29900d);
        jSONObject3.put("o", "Android");
        jSONObject3.put("s_v", ph.g.f29898b);
        jSONObject3.put("v", "2.9.60");
        jSONObject3.put("bvr", Build.VERSION.RELEASE);
        jSONObject3.put(t.f11211k, a10);
        jSONObject3.put("did", str2);
        jSONObject3.put(bt.aO, System.currentTimeMillis());
        jSONObject3.put(ExposeManager.UtArgsNames.pid, Process.myPid());
        jSONObject3.put("uid", Process.myUid());
        ph.e eVar = ph.g.f29901e;
        jSONObject3.put("a", eVar == null ? null : eVar.j());
        try {
            jSONObject3.put("p", context.getPackageName());
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            jSONObject3.put("p_v", packageInfo.versionCode);
            jSONObject3.put("p_vn", packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException e11) {
            if (ph.g.c()) {
                Log.e(f28934a, "", e11);
            }
        }
        return jSONObject3;
    }

    public static void c(String str, int i10) {
        String str2;
        StringBuilder sb2;
        String message;
        if (i10 >= 3) {
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        MediaType mediaType = fh.d.f26044a;
        sb3.append(DomainProvider.baseUrl());
        sb3.append("ru");
        String sb4 = sb3.toString();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("user_id", str);
            Response execute = fh.d.a().newCall(new Request.Builder().url(sb4).addHeader(m5.c.f28293b0, "gzip").post(RequestBody.create(mediaType, a.c.a(b(jSONObject).toString().getBytes()))).build()).execute();
            if (execute.isSuccessful()) {
                message = execute.body().string();
                if (!ph.g.c()) {
                    return;
                }
                str2 = f28934a;
                sb2 = new StringBuilder();
                sb2.append("response success: ");
            } else {
                if (!ph.g.c()) {
                    return;
                }
                str2 = f28934a;
                sb2 = new StringBuilder();
                sb2.append("response error: ");
                message = execute.message();
            }
            sb2.append(message);
            Log.d(str2, sb2.toString());
        } catch (Exception e10) {
            if (ph.g.c()) {
                e10.printStackTrace();
            }
            c(str, i10 + 1);
        }
    }

    public static void d(String str, int i10, String... strArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("test_name", str);
            jSONObject.put("test_version", i10);
            if (strArr != null) {
                jSONObject.put("user_tags", new JSONArray(strArr));
            }
        } catch (JSONException unused) {
        }
        NetRequest.Builder builder = new NetRequest.Builder();
        StringBuilder sb2 = new StringBuilder();
        MediaType mediaType = fh.d.f26044a;
        sb2.append(DomainProvider.baseUrl());
        sb2.append("ab");
        NetClient.postEncryptAsync(builder.url(sb2.toString()).requestJSON(jSONObject).checkReqId(false).build(), new C0749a());
    }

    public static void e(String str, JSONObject jSONObject) {
        String str2;
        StringBuilder sb2;
        StringBuilder sb3 = new StringBuilder();
        MediaType mediaType = fh.d.f26044a;
        sb3.append(DomainProvider.baseUrl());
        sb3.append("er");
        String sb4 = sb3.toString();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, str);
            jSONObject2.put("event_extra", jSONObject);
            if (ph.g.c()) {
                Log.d(f28934a, "request: " + jSONObject2);
            }
            Response execute = fh.d.a().newCall(new Request.Builder().url(sb4).addHeader(m5.c.f28293b0, "gzip").post(RequestBody.create(mediaType, a.c.a(b(jSONObject2).toString().getBytes()))).build()).execute();
            if (execute.isSuccessful()) {
                String string = execute.body().string();
                if (!ph.g.c()) {
                    return;
                }
                str2 = f28934a;
                sb2 = new StringBuilder();
                sb2.append("response success: ");
                sb2.append(string);
            } else {
                if (!ph.g.c()) {
                    return;
                }
                str2 = f28934a;
                sb2 = new StringBuilder();
                sb2.append("response error: ");
                sb2.append(execute.message());
            }
            Log.d(str2, sb2.toString());
        } catch (Exception e10) {
            if (ph.g.c()) {
                e10.printStackTrace();
            }
        }
    }

    public static boolean f() {
        Response execute;
        StringBuilder sb2 = new StringBuilder();
        MediaType mediaType = fh.d.f26044a;
        sb2.append(DomainProvider.baseUrl());
        sb2.append("jr");
        try {
            execute = fh.d.a().newCall(new Request.Builder().url(sb2.toString()).addHeader(m5.c.f28293b0, "gzip").post(RequestBody.create(mediaType, a.c.a(b(new JSONObject()).toString().getBytes()))).build()).execute();
        } catch (Exception e10) {
            if (ph.g.c()) {
                e10.printStackTrace();
            }
        }
        if (!execute.isSuccessful()) {
            if (ph.g.c()) {
                Log.d(f28934a, "response error: " + execute.message());
            }
            return false;
        }
        String str = new String(a.C0697a.a(Base64.decode(execute.body().string(), 0), "x04VOtkJji86dsmn".getBytes(), "x04VOtkJji86dsmn".getBytes()));
        if (ph.g.c()) {
            Log.d(f28934a, "response success: " + str);
        }
        return new JSONObject(str).optInt("risk_user", 0) > 0;
    }

    /* renamed from: nk.a$a */
    public class C0749a implements NetCallback {
        @Override // com.sntech.net.NetCallback
        public final void onFailure(Exception exc) {
        }

        @Override // com.sntech.net.NetCallback
        public final void onSuccess(String str) {
        }
    }
}
