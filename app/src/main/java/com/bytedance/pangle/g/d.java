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
/* loaded from: classes.dex */
public final class d {
    public static o a(String str) {
        RandomAccessFile randomAccessFile;
        int[] iArr;
        RandomAccessFile randomAccessFile2 = null;
        Signature[] signatureArr = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, t.k);
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    f.a(str, randomAccessFile, -262969152, com.bytedance.hume.readapk.a.f5954c);
                    try {
                        try {
                            try {
                                m mVar = f.f6131a.get(str).get(-262969152);
                                if (mVar == null) {
                                    throw new n("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
                                }
                                c.C0071c a2 = c.a(randomAccessFile, mVar);
                                Signature[] a3 = a(new Certificate[][]{a2.f6128a});
                                c.b bVar = a2.f6129b;
                                if (bVar != null) {
                                    int size = bVar.f6126a.size();
                                    Signature[] signatureArr2 = new Signature[size];
                                    iArr = new int[a2.f6129b.f6127b.size()];
                                    for (int i2 = 0; i2 < size; i2++) {
                                        signatureArr2[i2] = new Signature(a2.f6129b.f6126a.get(i2).getEncoded());
                                        iArr[i2] = a2.f6129b.f6127b.get(i2).intValue();
                                    }
                                    signatureArr = signatureArr2;
                                } else {
                                    iArr = null;
                                }
                                o oVar = new o(a3, 3, signatureArr, iArr);
                                try {
                                    randomAccessFile.close();
                                } catch (Exception unused) {
                                }
                                return oVar;
                            } catch (n unused2) {
                                m mVar2 = f.f6131a.get(str).get(com.bytedance.hume.readapk.a.f5954c);
                                if (mVar2 == null) {
                                    throw new n("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
                                }
                                o oVar2 = new o(a(b.a(randomAccessFile, mVar2).f6124a));
                                try {
                                    randomAccessFile.close();
                                } catch (Exception unused3) {
                                }
                                return oVar2;
                            } catch (Exception e2) {
                                throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e2);
                            }
                        } catch (n unused4) {
                            o a4 = a.a(str);
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused5) {
                            }
                            return a4;
                        }
                    } catch (Exception e3) {
                        throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e3);
                    }
                } catch (Exception e4) {
                    throw new q(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e4);
                }
            } catch (Throwable th2) {
                th = th2;
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
        for (int i2 = 0; i2 < certificateArr.length; i2++) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 21 && i3 <= 28) {
                Constructor a2 = com.bytedance.pangle.b.b.a.a((Class<?>) Signature.class, (Class<?>[]) new Class[]{Certificate[].class});
                if (a2 != null) {
                    a2.setAccessible(true);
                }
                if (a2 != null && a2.isAccessible()) {
                    try {
                        signatureArr[i2] = (Signature) a2.newInstance(certificateArr[i2]);
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    } catch (InstantiationException e3) {
                        e3.printStackTrace();
                    } catch (InvocationTargetException e4) {
                        e4.printStackTrace();
                    }
                }
            } else {
                signatureArr[i2] = new Signature(certificateArr[i2][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
