package t5;

/* loaded from: classes2.dex */
public class l {

    /* renamed from: a */
    public final float f30727a;

    /* renamed from: b */
    public final float f30728b;

    public l(float f10, float f11) {
        this.f30727a = f10;
        this.f30728b = f11;
    }

    public static float a(l lVar, l lVar2, l lVar3) {
        float f10 = lVar2.f30727a;
        float f11 = lVar2.f30728b;
        return ((lVar3.f30727a - f10) * (lVar.f30728b - f11)) - ((lVar3.f30728b - f11) * (lVar.f30727a - f10));
    }

    public static float b(l lVar, l lVar2) {
        return a6.a.a(lVar.f30727a, lVar.f30728b, lVar2.f30727a, lVar2.f30728b);
    }

    public static void e(l[] lVarArr) {
        l lVar;
        l lVar2;
        l lVar3;
        float b10 = b(lVarArr[0], lVarArr[1]);
        float b11 = b(lVarArr[1], lVarArr[2]);
        float b12 = b(lVarArr[0], lVarArr[2]);
        if (b11 >= b10 && b11 >= b12) {
            lVar = lVarArr[0];
            lVar2 = lVarArr[1];
            lVar3 = lVarArr[2];
        } else if (b12 < b11 || b12 < b10) {
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
        return this.f30727a;
    }

    public final float d() {
        return this.f30728b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f30727a == lVar.f30727a && this.f30728b == lVar.f30728b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f30727a) * 31) + Float.floatToIntBits(this.f30728b);
    }

    public final String toString() {
        return "(" + this.f30727a + ',' + this.f30728b + ')';
    }
}
