package com.vivo.push.c;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.vivo.push.util.p;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* loaded from: classes4.dex */
public final class a implements c {

    /* renamed from: a */
    private KeyStore f30935a;

    /* renamed from: b */
    private SecretKey f30936b;

    public a() {
        a();
        b();
    }

    private void a() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.f30935a = keyStore;
            keyStore.load(null);
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("AesSecurity", "initKeyStore error" + e2.getMessage());
        }
    }

    private SecretKey b() {
        try {
            SecretKey secretKey = this.f30936b;
            if (secretKey != null) {
                return secretKey;
            }
            if (c()) {
                this.f30936b = d();
            } else {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                if (Build.VERSION.SDK_INT >= 23) {
                    keyGenerator.init(new KeyGenParameterSpec.Builder("AesKeyAlias", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
                }
                this.f30936b = keyGenerator.generateKey();
            }
            return this.f30936b;
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("AesSecurity", "getSecretKey error" + e2.getMessage());
            return null;
        }
    }

    private boolean c() {
        try {
            if (this.f30935a == null) {
                a();
            }
            return this.f30935a.containsAlias("AesKeyAlias");
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("AesSecurity", "hasAESKey error" + e2.getMessage());
            return false;
        }
    }

    private SecretKey d() {
        try {
            return ((KeyStore.SecretKeyEntry) this.f30935a.getEntry("AesKeyAlias", null)).getSecretKey();
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("AesSecurity", "getAESSecretKey error" + e2.getMessage());
            return null;
        }
    }
}
