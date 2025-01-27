package com.vivo.push.c;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.vivo.push.util.p;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import zg.f;

/* loaded from: classes4.dex */
public final class a implements c {

    /* renamed from: a */
    private KeyStore f24962a;

    /* renamed from: b */
    private SecretKey f24963b;

    public a() {
        a();
        b();
    }

    private void a() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.f24962a = keyStore;
            keyStore.load(null);
        } catch (Exception e10) {
            e10.printStackTrace();
            p.a("AesSecurity", "initKeyStore error" + e10.getMessage());
        }
    }

    private SecretKey b() {
        KeyGenParameterSpec.Builder blockModes;
        KeyGenParameterSpec.Builder encryptionPaddings;
        KeyGenParameterSpec.Builder keySize;
        KeyGenParameterSpec build;
        try {
            SecretKey secretKey = this.f24963b;
            if (secretKey != null) {
                return secretKey;
            }
            if (c()) {
                this.f24963b = d();
            } else {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                if (Build.VERSION.SDK_INT >= 23) {
                    f.a();
                    blockModes = zg.e.a("AesKeyAlias", 3).setBlockModes("GCM");
                    encryptionPaddings = blockModes.setEncryptionPaddings("NoPadding");
                    keySize = encryptionPaddings.setKeySize(256);
                    build = keySize.build();
                    keyGenerator.init(build);
                }
                this.f24963b = keyGenerator.generateKey();
            }
            return this.f24963b;
        } catch (Exception e10) {
            e10.printStackTrace();
            p.a("AesSecurity", "getSecretKey error" + e10.getMessage());
            return null;
        }
    }

    private boolean c() {
        try {
            if (this.f24962a == null) {
                a();
            }
            return this.f24962a.containsAlias("AesKeyAlias");
        } catch (Exception e10) {
            e10.printStackTrace();
            p.a("AesSecurity", "hasAESKey error" + e10.getMessage());
            return false;
        }
    }

    private SecretKey d() {
        try {
            return ((KeyStore.SecretKeyEntry) this.f24962a.getEntry("AesKeyAlias", null)).getSecretKey();
        } catch (Exception e10) {
            e10.printStackTrace();
            p.a("AesSecurity", "getAESSecretKey error" + e10.getMessage());
            return null;
        }
    }
}
