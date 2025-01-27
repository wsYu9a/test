package com.jd.ad.sdk.jad_oz;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.jd.ad.sdk.jad_ir.jad_kx;
import com.jd.ad.sdk.jad_ir.jad_ly;
import com.jd.ad.sdk.jad_js.jad_an;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class jad_jw {
    public final com.jd.ad.sdk.jad_ir.jad_hu<com.jd.ad.sdk.jad_ju.jad_hu, String> jad_an = new com.jd.ad.sdk.jad_ir.jad_hu<>(1000);
    public final Pools.Pool<jad_bo> jad_bo = com.jd.ad.sdk.jad_js.jad_an.jad_an(10, new jad_an(this));

    public class jad_an implements jad_an.jad_bo<jad_bo> {
        public jad_an(jad_jw jad_jwVar) {
        }

        @Override // com.jd.ad.sdk.jad_js.jad_an.jad_bo
        public jad_bo jad_an() {
            try {
                return new jad_bo(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public static final class jad_bo implements jad_an.jad_dq {
        public final MessageDigest jad_an;
        public final com.jd.ad.sdk.jad_js.jad_dq jad_bo = com.jd.ad.sdk.jad_js.jad_dq.jad_an();

        public jad_bo(MessageDigest messageDigest) {
            this.jad_an = messageDigest;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_an.jad_dq
        @NonNull
        public com.jd.ad.sdk.jad_js.jad_dq jad_an() {
            return this.jad_bo;
        }
    }

    public String jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar) {
        String jad_an2;
        synchronized (this.jad_an) {
            jad_an2 = this.jad_an.jad_an((com.jd.ad.sdk.jad_ir.jad_hu<com.jd.ad.sdk.jad_ju.jad_hu, String>) jad_huVar);
        }
        if (jad_an2 == null) {
            jad_bo jad_boVar = (jad_bo) jad_kx.jad_an(this.jad_bo.acquire());
            try {
                jad_huVar.jad_an(jad_boVar.jad_an);
                byte[] digest = jad_boVar.jad_an.digest();
                char[] cArr = jad_ly.jad_bo;
                synchronized (cArr) {
                    for (int i10 = 0; i10 < digest.length; i10++) {
                        try {
                            byte b10 = digest[i10];
                            int i11 = i10 * 2;
                            char[] cArr2 = jad_ly.jad_an;
                            cArr[i11] = cArr2[(b10 & 255) >>> 4];
                            cArr[i11 + 1] = cArr2[b10 & 15];
                        } finally {
                        }
                    }
                    jad_an2 = new String(cArr);
                }
            } finally {
                this.jad_bo.release(jad_boVar);
            }
        }
        synchronized (this.jad_an) {
            this.jad_an.jad_bo(jad_huVar, jad_an2);
        }
        return jad_an2;
    }
}
