package com.bytedance.pangle.g;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* loaded from: classes.dex */
final class p extends r {

    /* renamed from: a */
    private final byte[] f6157a;

    /* renamed from: b */
    private int f6158b;

    p(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f6158b = -1;
        this.f6157a = bArr;
    }

    @Override // java.security.cert.Certificate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((p) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // com.bytedance.pangle.g.r, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.f6157a;
    }

    @Override // java.security.cert.Certificate
    public final int hashCode() {
        if (this.f6158b == -1) {
            try {
                this.f6158b = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.f6158b = 0;
            }
        }
        return this.f6158b;
    }
}
