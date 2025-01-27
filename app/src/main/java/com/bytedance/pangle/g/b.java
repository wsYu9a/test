package com.bytedance.pangle.g;

import android.util.ArrayMap;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

@RequiresApi(api = 21)
/* loaded from: classes2.dex */
public final class b {

    public static class a {

        /* renamed from: a */
        public final X509Certificate[][] f7626a;

        /* renamed from: b */
        public final byte[] f7627b;

        public a(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.f7626a = x509CertificateArr;
            this.f7627b = bArr;
        }
    }

    public static a a(RandomAccessFile randomAccessFile, m mVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer a10 = f.a(mVar.f7648a);
                int i10 = 0;
                while (a10.hasRemaining()) {
                    i10++;
                    try {
                        arrayList.add(a(f.a(a10), arrayMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e10) {
                        throw new SecurityException("Failed to parse/verify signer #" + i10 + " block", e10);
                    }
                }
                if (i10 <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (arrayMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                f.a(arrayMap, randomAccessFile, mVar);
                return new a((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]), arrayMap.containsKey(3) ? f.a((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar) : null);
            } catch (IOException e11) {
                throw new SecurityException("Failed to read list of signers", e11);
            }
        } catch (CertificateException e12) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e12);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
    
        if (com.bytedance.pangle.g.f.a(r10, r6) <= 0) goto L407;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.security.cert.X509Certificate[] a(java.nio.ByteBuffer r12, java.util.Map<java.lang.Integer, byte[]> r13, java.security.cert.CertificateFactory r14) {
        /*
            Method dump skipped, instructions count: 534
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.g.b.a(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):java.security.cert.X509Certificate[]");
    }

    private static void a(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer a10 = f.a(byteBuffer);
            if (a10.remaining() >= 4) {
                if (a10.getInt() == -1091571699) {
                    if (a10.remaining() >= 4) {
                        if (a10.getInt() == 3) {
                            throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                        }
                    } else {
                        throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + a10.remaining());
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + a10.remaining());
            }
        }
    }
}
