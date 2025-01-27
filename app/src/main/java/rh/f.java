package rh;

import android.content.Context;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
import org.mozilla.universalchardet.prober.g;

/* loaded from: classes4.dex */
public final class f implements Runnable {
    public static JSONObject a(Context context, JSONObject jSONObject) {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        JSONObject jSONObject2 = new JSONObject();
        String str = sk.d.a(UUID.randomUUID().toString().getBytes()) + System.currentTimeMillis();
        int random = (int) ((Math.random() * 20.0d) + 1.0d);
        for (int i10 = 0; i10 < random; i10++) {
            str = sk.d.a(str.getBytes());
        }
        byte[] bytes = jSONObject.toString().getBytes();
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bytes == null || bytes.length == 0) {
            bArr = null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream3);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
            } catch (Exception e10) {
                if (d.d()) {
                    e10.printStackTrace();
                }
            }
            bArr = byteArrayOutputStream3.toByteArray();
        }
        byte[] encode = Base64.encode(bArr, 2);
        byte[] bytes2 = str.getBytes();
        byte[] bArr2 = sk.b.f30681e;
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
        String encodeToString = Base64.encodeToString(cipher.doFinal(encode), 2);
        byte[] bytes3 = str.getBytes();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance(d3.d.f25247a).generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtBXKwTT+bbYukXr9GxnfHcUJOZYp4BrT3AdOeCdEr3n/YT42o3oNOf6nCGuz0Wod61rrxcTlVS/A+sjhQLBf2H6kkOVM4Xc+LU+2xBRXEkmFRZQf8lzSrzLDclrqS7IhHIwUdWZJR6vdQJlvD6VA/AtnzVIGvbQPVhbnVzo2er+Moww/3Aqp8xBn7qF11tgL4AcyWqtDwPYY7cTC22IcxZeB3Um/WyWpAsR2a61RlyANfQ56znGXirZImI4SRFcIVwsSvBXrysnFVx07VNoXELRZEeIywjMfyK1QbSu9/Q2NZwnIR0cD/Cr/QAPr9qkhX3uHNjPZrBYZ+FxwBkijmQIDAQAB", 0)));
        int length = bytes3.length / g.f29297x;
        if (bytes3.length % g.f29297x != 0) {
            length++;
        }
        try {
            try {
                Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher2.init(1, rSAPublicKey);
                byteArrayOutputStream = new ByteArrayOutputStream(length * 256);
                for (int i11 = 0; i11 < bytes3.length; i11 += g.f29297x) {
                    try {
                        int length2 = bytes3.length - i11;
                        if (length2 > 245) {
                            length2 = g.f29297x;
                        }
                        byteArrayOutputStream.write(cipher2.doFinal(bytes3, i11, length2));
                    } catch (Exception e11) {
                        e = e11;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        throw new Exception("ENCRYPT ERROR:", e);
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e12) {
                                throw new Exception("CLOSE ByteArrayOutputStream ERROR:", e12);
                            }
                        }
                        throw th;
                    }
                }
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    String encodeToString2 = Base64.encodeToString(byteArray, 2);
                    jSONObject2.put("s_v", sk.b.f30677a);
                    jSONObject2.put("v", "1.5.60");
                    jSONObject2.put("p", context.getPackageName());
                    jSONObject2.put(com.kwad.sdk.m.e.TAG, 1);
                    jSONObject2.put("d", encodeToString);
                    jSONObject2.put("k", encodeToString2);
                    jSONObject2.put("c", sk.b.f30678b);
                    jSONObject2.put("did", sk.b.a(context));
                    return jSONObject2;
                } catch (Exception e13) {
                    throw new Exception("CLOSE ByteArrayOutputStream ERROR:", e13);
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = byteArrayOutputStream2;
            }
        } catch (Exception e14) {
            e = e14;
        }
    }
}
