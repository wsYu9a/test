package com.bytedance.pangle.g;

import android.util.ArrayMap;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RequiresApi(api = 21)
/* loaded from: classes2.dex */
public final class c {

    public static class a extends Exception {
    }

    public static class b {

        /* renamed from: a */
        public final List<X509Certificate> f7628a;

        /* renamed from: b */
        public final List<Integer> f7629b;

        public b(List<X509Certificate> list, List<Integer> list2) {
            this.f7628a = list;
            this.f7629b = list2;
        }
    }

    /* renamed from: com.bytedance.pangle.g.c$c */
    public static class C0231c {

        /* renamed from: a */
        public final X509Certificate[] f7630a;

        /* renamed from: b */
        public final b f7631b;

        /* renamed from: c */
        public byte[] f7632c;

        public C0231c(X509Certificate[] x509CertificateArr, b bVar) {
            this.f7630a = x509CertificateArr;
            this.f7631b = bVar;
        }
    }

    public static C0231c a(RandomAccessFile randomAccessFile, m mVar) {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer a10 = f.a(mVar.f7648a);
                int i10 = 0;
                C0231c c0231c = null;
                while (a10.hasRemaining()) {
                    try {
                        c0231c = a(f.a(a10), arrayMap, certificateFactory);
                        i10++;
                    } catch (a unused) {
                    } catch (IOException e10) {
                        e = e10;
                        throw new SecurityException("Failed to parse/verify signer #" + i10 + " block", e);
                    } catch (SecurityException e11) {
                        e = e11;
                        throw new SecurityException("Failed to parse/verify signer #" + i10 + " block", e);
                    } catch (BufferUnderflowException e12) {
                        e = e12;
                        throw new SecurityException("Failed to parse/verify signer #" + i10 + " block", e);
                    }
                }
                if (i10 <= 0 || c0231c == null) {
                    throw new SecurityException("No signers found");
                }
                if (i10 != 1) {
                    throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
                }
                if (arrayMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                f.a(arrayMap, randomAccessFile, mVar);
                if (arrayMap.containsKey(3)) {
                    c0231c.f7632c = f.a((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar);
                }
                return c0231c;
            } catch (IOException e13) {
                throw new SecurityException("Failed to read list of signers", e13);
            }
        } catch (CertificateException e14) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e14);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
        if (com.bytedance.pangle.g.f.a(r14, r10) <= 0) goto L431;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.bytedance.pangle.g.c.C0231c a(java.nio.ByteBuffer r16, java.util.Map<java.lang.Integer, byte[]> r17, java.security.cert.CertificateFactory r18) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.g.c.a(java.nio.ByteBuffer, java.util.Map, java.security.cert.CertificateFactory):com.bytedance.pangle.g.c$c");
    }

    private static C0231c a(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        b bVar = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer a10 = f.a(byteBuffer);
            if (a10.remaining() >= 4) {
                if (a10.getInt() == 1000370060) {
                    if (bVar == null) {
                        bVar = a(a10, certificateFactory);
                        try {
                            if (bVar.f7628a.size() > 0) {
                                if (!Arrays.equals(bVar.f7628a.get(r1.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                                    throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                                }
                            } else {
                                continue;
                            }
                        } catch (CertificateEncodingException e10) {
                            throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e10);
                        }
                    } else {
                        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + a10.remaining());
            }
        }
        return new C0231c(x509CertificateArr, bVar);
    }

    private static b a(ByteBuffer byteBuffer, CertificateFactory certificateFactory) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i10 = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i11 = -1;
            p pVar = null;
            while (byteBuffer.hasRemaining()) {
                i10++;
                ByteBuffer a10 = f.a(byteBuffer);
                ByteBuffer a11 = f.a(a10);
                int i12 = a10.getInt();
                int i13 = a10.getInt();
                byte[] b10 = f.b(a10);
                if (pVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> d10 = f.d(i11);
                    PublicKey publicKey = pVar.getPublicKey();
                    Signature signature = Signature.getInstance((String) d10.first);
                    signature.initVerify(publicKey);
                    Object obj = d10.second;
                    if (obj != null) {
                        signature.setParameter((AlgorithmParameterSpec) obj);
                    }
                    signature.update(a11);
                    if (!signature.verify(b10)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i10 + " using " + ((String) d10.first) + " when verifying Proof-of-rotation record");
                    }
                }
                a11.rewind();
                byte[] b11 = f.b(a11);
                int i14 = a11.getInt();
                if (pVar != null && i11 != i14) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i10 + " when verifying Proof-of-rotation record");
                }
                pVar = new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(b11)), b11);
                if (!hashSet.contains(pVar)) {
                    hashSet.add(pVar);
                    arrayList.add(pVar);
                    arrayList2.add(Integer.valueOf(i12));
                    i11 = i13;
                } else {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i10 + ".  All signing certificates should be unique");
                }
            }
            return new b(arrayList, arrayList2);
        } catch (IOException e10) {
            e = e10;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (BufferUnderflowException e11) {
            e = e11;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (InvalidAlgorithmParameterException e12) {
            e = e12;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (InvalidKeyException e13) {
            e = e13;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (NoSuchAlgorithmException e14) {
            e = e14;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (SignatureException e15) {
            e = e15;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (CertificateException e16) {
            throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e16);
        }
    }
}
