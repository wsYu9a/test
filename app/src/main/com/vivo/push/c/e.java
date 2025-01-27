package com.vivo.push.c;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.p;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes4.dex */
public final class e implements b {

    /* renamed from: a */
    private static PrivateKey f24968a;

    /* renamed from: b */
    private static PublicKey f24969b;

    /* renamed from: c */
    private static KeyStore f24970c;

    /* renamed from: d */
    private static X500Principal f24971d;

    /* renamed from: e */
    private Context f24972e;

    public e(Context context) {
        this.f24972e = context;
        try {
            b();
            a(context);
        } catch (Exception e10) {
            e10.printStackTrace();
            p.a("RsaSecurity", "init error" + e10.getMessage());
        }
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (f24970c == null) {
                b();
            }
            return f24970c.containsAlias(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            p.a("RsaSecurity", "getPrivateKeySigin error" + e10.getMessage());
            return false;
        }
    }

    @Override // com.vivo.push.c.b
    public final String a(String str) {
        try {
            if (TextUtils.isEmpty(str) || b(this.f24972e) == null) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            PrivateKey b10 = b(this.f24972e);
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(b10);
            signature.update(bytes);
            String encodeToString = Base64.encodeToString(signature.sign(), 2);
            p.d("RsaSecurity", str.hashCode() + " = " + encodeToString);
            return encodeToString;
        } catch (Exception e10) {
            e10.printStackTrace();
            p.a("RsaSecurity", "signClientSDK error" + e10.getMessage());
            return null;
        }
    }

    private static void b() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            f24970c = keyStore;
            keyStore.load(null);
            f24971d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e10) {
            e10.printStackTrace();
            p.a("RsaSecurity", "initKeyStore error" + e10.getMessage());
        }
    }

    @Override // com.vivo.push.c.b
    public final boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e10) {
            e10.printStackTrace();
            p.a("RsaSecurity", "verifyClientSDK error" + e10.getMessage());
            return false;
        }
    }

    private static PrivateKey b(Context context) {
        PrivateKey privateKey;
        try {
            privateKey = f24968a;
        } catch (Exception e10) {
            e10.printStackTrace();
            p.a("RsaSecurity", "getPrivateKeySigin error" + e10.getMessage());
        }
        if (privateKey != null) {
            return privateKey;
        }
        if (context == null) {
            p.d("RsaSecurity", " getPrivateKeySigin context == null ");
            return null;
        }
        if (!b("PushRsaKeyAlias")) {
            a(context);
        }
        KeyStore.Entry entry = f24970c.getEntry("PushRsaKeyAlias", null);
        if (entry instanceof KeyStore.PrivateKeyEntry) {
            PrivateKey privateKey2 = ((KeyStore.PrivateKeyEntry) entry).getPrivateKey();
            f24968a = privateKey2;
            return privateKey2;
        }
        return null;
    }

    private static void a(Context context) {
        try {
            if (context == null) {
                p.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
                return;
            }
            if (!b("PushRsaKeyAlias")) {
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(1, 999);
                KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(f24971d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(d3.d.f25247a, "AndroidKeyStore");
                keyPairGenerator.initialize(build);
                keyPairGenerator.generateKeyPair();
                return;
            }
            p.d("RsaSecurity", " generateRSAKeyPairSign this keyAlias PushRsaKeyAlias is Created ");
        } catch (Exception e10) {
            e10.printStackTrace();
            p.a("RsaSecurity", "generateRSAKeyPairSign error" + e10.getMessage());
        }
    }

    @Override // com.vivo.push.c.b
    public final PublicKey a() {
        PublicKey publicKey;
        try {
            publicKey = f24969b;
        } catch (Exception e10) {
            e10.printStackTrace();
            p.a("RsaSecurity", "getPublicKeySign error" + e10.getMessage());
        }
        if (publicKey != null) {
            return publicKey;
        }
        if (!b("PushRsaKeyAlias")) {
            a(this.f24972e);
        }
        KeyStore.Entry entry = f24970c.getEntry("PushRsaKeyAlias", null);
        if (entry instanceof KeyStore.PrivateKeyEntry) {
            PublicKey publicKey2 = ((KeyStore.PrivateKeyEntry) entry).getCertificate().getPublicKey();
            f24969b = publicKey2;
            return publicKey2;
        }
        return null;
    }
}
