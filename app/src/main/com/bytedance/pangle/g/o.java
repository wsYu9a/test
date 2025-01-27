package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class o {

    /* renamed from: a */
    public static final o f7653a = new o(null, 0, null, null, null);

    /* renamed from: b */
    @Nullable
    public final Signature[] f7654b;

    /* renamed from: c */
    public final int f7655c;

    /* renamed from: d */
    @Nullable
    public final ArraySet<PublicKey> f7656d;

    /* renamed from: e */
    @Nullable
    public final Signature[] f7657e;

    /* renamed from: f */
    @Nullable
    public final int[] f7658f;

    public o(Signature[] signatureArr, int i10, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.f7654b = signatureArr;
        this.f7655c = i10;
        this.f7656d = arraySet;
        this.f7657e = signatureArr2;
        this.f7658f = iArr;
    }

    private static ArraySet<PublicKey> a(Signature[] signatureArr) {
        Method method;
        h4.e.a();
        ArraySet<PublicKey> a10 = h4.d.a(signatureArr.length);
        for (Signature signature : signatureArr) {
            try {
                method = Signature.class.getMethod("getPublicKey", null);
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
                method = null;
            }
            if (method != null && method.isAccessible()) {
                try {
                    a10.add((PublicKey) method.invoke(signature, null));
                } catch (IllegalAccessException e11) {
                    e11.printStackTrace();
                } catch (InvocationTargetException e12) {
                    e12.printStackTrace();
                } catch (Exception e13) {
                    e13.printStackTrace();
                }
            }
        }
        return a10;
    }

    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f7655c != oVar.f7655c || !a(this.f7654b, oVar.f7654b)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.f7656d;
        if (arraySet != null) {
            equals = arraySet.equals(oVar.f7656d);
            if (!equals) {
                return false;
            }
        } else if (oVar.f7656d != null) {
            return false;
        }
        return Arrays.equals(this.f7657e, oVar.f7657e) && Arrays.equals(this.f7658f, oVar.f7658f);
    }

    public final int hashCode() {
        int hashCode = ((Arrays.hashCode(this.f7654b) * 31) + this.f7655c) * 31;
        ArraySet<PublicKey> arraySet = this.f7656d;
        return ((((hashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.f7657e)) * 31) + Arrays.hashCode(this.f7658f);
    }

    public o(Signature[] signatureArr, int i10, Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i10, a(signatureArr), signatureArr2, iArr);
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
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }
}
