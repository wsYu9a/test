package com.google.zxing;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a */
    private final float f8450a;

    /* renamed from: b */
    private final float f8451b;

    public l(float f2, float f3) {
        this.f8450a = f2;
        this.f8451b = f3;
    }

    private static float a(l lVar, l lVar2, l lVar3) {
        float f2 = lVar2.f8450a;
        float f3 = lVar2.f8451b;
        return ((lVar3.f8450a - f2) * (lVar.f8451b - f3)) - ((lVar3.f8451b - f3) * (lVar.f8450a - f2));
    }

    public static float b(l lVar, l lVar2) {
        return com.google.zxing.common.l.a.a(lVar.f8450a, lVar.f8451b, lVar2.f8450a, lVar2.f8451b);
    }

    public static void e(l[] lVarArr) {
        l lVar;
        l lVar2;
        l lVar3;
        float b2 = b(lVarArr[0], lVarArr[1]);
        float b3 = b(lVarArr[1], lVarArr[2]);
        float b4 = b(lVarArr[0], lVarArr[2]);
        if (b3 >= b2 && b3 >= b4) {
            lVar = lVarArr[0];
            lVar2 = lVarArr[1];
            lVar3 = lVarArr[2];
        } else if (b4 < b3 || b4 < b2) {
            lVar = lVarArr[2];
            lVar2 = lVarArr[0];
            lVar3 = lVarArr[1];
        } else {
            lVar = lVarArr[1];
            lVar2 = lVarArr[0];
            lVar3 = lVarArr[2];
        }
        if (a(lVar2, lVar, lVar3) < 0.0f) {
            l lVar4 = lVar3;
            lVar3 = lVar2;
            lVar2 = lVar4;
        }
        lVarArr[0] = lVar2;
        lVarArr[1] = lVar;
        lVarArr[2] = lVar3;
    }

    public final float c() {
        return this.f8450a;
    }

    public final float d() {
        return this.f8451b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f8450a == lVar.f8450a && this.f8451b == lVar.f8451b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f8450a) * 31) + Float.floatToIntBits(this.f8451b);
    }

    public final String toString() {
        return "(" + this.f8450a + ',' + this.f8451b + ')';
    }
}
