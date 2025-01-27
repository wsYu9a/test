package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.g.c;
import com.kuaishou.weapon.p0.t;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;

@RequiresApi(api = 21)
/* loaded from: classes2.dex */
public final class d {
    public static o a(String str) {
        RandomAccessFile randomAccessFile;
        int[] iArr;
        RandomAccessFile randomAccessFile2 = null;
        Signature[] signatureArr = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, t.f11211k);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                try {
                    f.a(str, randomAccessFile, -262969152, com.bytedance.hume.readapk.a.f7430c);
                    try {
                        try {
                            m mVar = f.f7633a.get(str).get(-262969152);
                            if (mVar == null) {
                                throw new n("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
                            }
                            c.C0231c a10 = c.a(randomAccessFile, mVar);
                            Signature[] a11 = a(new Certificate[][]{a10.f7630a});
                            c.b bVar = a10.f7631b;
                            if (bVar != null) {
                                int size = bVar.f7628a.size();
                                Signature[] signatureArr2 = new Signature[size];
                                iArr = new int[a10.f7631b.f7629b.size()];
                                for (int i10 = 0; i10 < size; i10++) {
                                    signatureArr2[i10] = new Signature(a10.f7631b.f7628a.get(i10).getEncoded());
                                    iArr[i10] = a10.f7631b.f7629b.get(i10).intValue();
                                }
                                signatureArr = signatureArr2;
                            } else {
                                iArr = null;
                            }
                            o oVar = new o(a11, 3, signatureArr, iArr);
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused) {
                            }
                            return oVar;
                        } catch (n unused2) {
                            m mVar2 = f.f7633a.get(str).get(com.bytedance.hume.readapk.a.f7430c);
                            if (mVar2 == null) {
                                throw new n("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
                            }
                            o oVar2 = new o(a(b.a(randomAccessFile, mVar2).f7626a));
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused3) {
                            }
                            return oVar2;
                        } catch (Exception e10) {
                            throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e10);
                        }
                    } catch (n unused4) {
                        o a12 = a.a(str);
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused5) {
                        }
                        return a12;
                    } catch (Exception e11) {
                        throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e11);
                    }
                } catch (Exception e12) {
                    throw new q(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e12);
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused6) {
                    }
                }
                throw th;
            }
        } catch (Exception unused7) {
            throw new q(6, "failed to read apk file, minSignatureSchemeVersion : 1, apkPath : ".concat(String.valueOf(str)));
        }
    }

    public static Signature[] a(Certificate[][] certificateArr) {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i10 = 0; i10 < certificateArr.length; i10++) {
            if (Build.VERSION.SDK_INT <= 28) {
                Constructor a10 = com.bytedance.pangle.b.b.a.a((Class<?>) Signature.class, (Class<?>[]) new Class[]{Certificate[].class});
                if (a10 != null) {
                    a10.setAccessible(true);
                }
                if (a10 != null && a10.isAccessible()) {
                    try {
                        signatureArr[i10] = (Signature) a10.newInstance(certificateArr[i10]);
                    } catch (IllegalAccessException e10) {
                        e10.printStackTrace();
                    } catch (InstantiationException e11) {
                        e11.printStackTrace();
                    } catch (InvocationTargetException e12) {
                        e12.printStackTrace();
                    }
                }
            } else {
                signatureArr[i10] = new Signature(certificateArr[i10][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
