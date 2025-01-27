package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Arrays;

/* loaded from: classes.dex */
final class o {

    /* renamed from: a */
    public static final o f6151a = new o(null, 0, null, null, null);

    /* renamed from: b */
    @Nullable
    public final Signature[] f6152b;

    /* renamed from: c */
    public final int f6153c;

    /* renamed from: d */
    @Nullable
    public final ArraySet<PublicKey> f6154d;

    /* renamed from: e */
    @Nullable
    public final Signature[] f6155e;

    /* renamed from: f */
    @Nullable
    public final int[] f6156f;

    public o(Signature[] signatureArr, int i2, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.f6152b = signatureArr;
        this.f6153c = i2;
        this.f6154d = arraySet;
        this.f6155e = signatureArr2;
        this.f6156f = iArr;
    }

    private static ArraySet<PublicKey> a(Signature[] signatureArr) {
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            Method method = null;
            try {
                method = Signature.class.getMethod("getPublicKey", new Class[0]);
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            }
            if (method != null && method.isAccessible()) {
                try {
                    arraySet.add((PublicKey) method.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
        return arraySet;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f6153c != oVar.f6153c || !a(this.f6152b, oVar.f6152b)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.f6154d;
        if (arraySet != null) {
            if (!arraySet.equals(oVar.f6154d)) {
                return false;
            }
        } else if (oVar.f6154d != null) {
            return false;
        }
        return Arrays.equals(this.f6155e, oVar.f6155e) && Arrays.equals(this.f6156f, oVar.f6156f);
    }

    public final int hashCode() {
        int hashCode = ((Arrays.hashCode(this.f6152b) * 31) + this.f6153c) * 31;
        ArraySet<PublicKey> arraySet = this.f6154d;
        return ((((hashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.f6155e)) * 31) + Arrays.hashCode(this.f6156f);
    }

    public o(Signature[] signatureArr, int i2, Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i2, a(signatureArr), signatureArr2, iArr);
    }

    public o(Signature[] signatureArr) {
        this(signatureArr, 2, null, null);
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.d.a((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.d.a((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
