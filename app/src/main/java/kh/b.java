package kh;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.sntech.ads.SNAdSdk;
import com.umeng.analytics.pro.bt;
import d3.d;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kh.a;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class b {
    public static String a(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            byte[] bytes = "x04VOtkJji86dsmn".getBytes();
            byte[] bytes2 = "x04VOtkJji86dsmn".getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bytes2));
            str = new String(cipher.doFinal(decode));
        } catch (Exception unused) {
            Context context = oh.a.f29195a;
        }
        Context context2 = oh.a.f29195a;
        return str;
    }

    public static JSONObject b(JSONObject jSONObject) {
        String str;
        String str2;
        Context context = oh.a.f29195a;
        String did = SNAdSdk.getAdManager().did(oh.a.f29195a);
        String a10 = a.b.a(UUID.randomUUID().toString().getBytes());
        byte[] bArr = a.f27832a;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("od", jSONObject);
        jSONObject2.put("did", did);
        jSONObject2.put(t.f11211k, a10);
        jSONObject2.put("p", oh.a.f29195a.getPackageName());
        jSONObject2.put("s_v", oh.a.f29196b);
        Context context2 = oh.a.f29195a;
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
        byte[] a11 = a.C0726a.a(bytes);
        byte[] bArr2 = a.f27832a;
        SecretKeySpec secretKeySpec = new SecretKeySpec(b10, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
        String encodeToString = Base64.encodeToString(cipher.doFinal(a11), 2);
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance(d.f25247a).generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtBXKwTT+bbYukXr9GxnfHcUJOZYp4BrT3AdOeCdEr3n/YT42o3oNOf6nCGuz0Wod61rrxcTlVS/A+sjhQLBf2H6kkOVM4Xc+LU+2xBRXEkmFRZQf8lzSrzLDclrqS7IhHIwUdWZJR6vdQJlvD6VA/AtnzVIGvbQPVhbnVzo2er+Moww/3Aqp8xBn7qF11tgL4AcyWqtDwPYY7cTC22IcxZeB3Um/WyWpAsR2a61RlyANfQ56znGXirZImI4SRFcIVwsSvBXrysnFVx07VNoXELRZEeIywjMfyK1QbSu9/Q2NZwnIR0cD/Cr/QAPr9qkhX3uHNjPZrBYZ+FxwBkijmQIDAQAB".replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", "").replaceAll("\n", ""), 0)));
        Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher2.init(1, rSAPublicKey);
        String encodeToString2 = Base64.encodeToString(cipher2.doFinal(b10), 2);
        jSONObject3.put("d", encodeToString);
        jSONObject3.put("k", encodeToString2);
        jSONObject3.put("d_v", 3);
        jSONObject3.put(e.TAG, 10);
        jSONObject3.put("c", oh.a.f29197c);
        jSONObject3.put("o", "Android");
        jSONObject3.put("s_v", oh.a.f29196b);
        try {
            str2 = oh.a.f29195a.getPackageManager().getPackageInfo(oh.a.f29195a.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            str2 = "";
        }
        jSONObject3.put("v", str2);
        jSONObject3.put("n_v", "1.1.2");
        jSONObject3.put("bvr", Build.VERSION.RELEASE);
        jSONObject3.put(t.f11211k, a10);
        jSONObject3.put("did", did);
        jSONObject3.put(bt.aO, System.currentTimeMillis());
        jSONObject3.put(ExposeManager.UtArgsNames.pid, Process.myPid());
        jSONObject3.put("uid", Process.myUid());
        String a12 = oh.a.a();
        jSONObject3.put("a", TextUtils.isEmpty(a12) ? "" : a12);
        try {
            jSONObject3.put("p", context.getPackageName());
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            jSONObject3.put("p_v", packageInfo.versionCode);
            jSONObject3.put("p_vn", packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException unused) {
            Context context3 = oh.a.f29195a;
        }
        return jSONObject3;
    }
}
