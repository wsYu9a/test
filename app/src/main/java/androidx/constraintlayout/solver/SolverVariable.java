package androidx.constraintlayout.solver;

import androidx.exifinterface.media.ExifInterface;
import com.kwad.sdk.ranger.e;
import java.util.Arrays;

/* loaded from: classes.dex */
public class SolverVariable {
    public static final int STRENGTH_BARRIER = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 6;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;

    /* renamed from: a */
    private static final boolean f1210a = false;

    /* renamed from: b */
    private static int f1211b = 1;

    /* renamed from: c */
    private static int f1212c = 1;

    /* renamed from: d */
    private static int f1213d = 1;

    /* renamed from: e */
    private static int f1214e = 1;

    /* renamed from: f */
    private static int f1215f = 1;

    /* renamed from: g */
    static final int f1216g = 7;
    public float computedValue;

    /* renamed from: h */
    private String f1217h;

    /* renamed from: i */
    int f1218i;
    public int id;

    /* renamed from: j */
    float[] f1219j;
    Type k;
    ArrayRow[] l;
    int m;
    public int strength;
    public int usageInRowCount;

    /* renamed from: androidx.constraintlayout.solver.SolverVariable$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f1220a;

        static {
            int[] iArr = new int[Type.values().length];
            f1220a = iArr;
            try {
                iArr[Type.UNRESTRICTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1220a[Type.CONSTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1220a[Type.SLACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1220a[Type.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1220a[Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.id = -1;
        this.f1218i = -1;
        this.strength = 0;
        this.f1219j = new float[7];
        this.l = new ArrayRow[8];
        this.m = 0;
        this.usageInRowCount = 0;
        this.f1217h = str;
        this.k = type;
    }

    private static String b(Type type, String str) {
        if (str != null) {
            return str + f1212c;
        }
        int i2 = AnonymousClass1.f1220a[type.ordinal()];
        if (i2 == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("U");
            int i3 = f1213d + 1;
            f1213d = i3;
            sb.append(i3);
            return sb.toString();
        }
        if (i2 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("C");
            int i4 = f1214e + 1;
            f1214e = i4;
            sb2.append(i4);
            return sb2.toString();
        }
        if (i2 == 3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(ExifInterface.LATITUDE_SOUTH);
            int i5 = f1211b + 1;
            f1211b = i5;
            sb3.append(i5);
            return sb3.toString();
        }
        if (i2 == 4) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(e.TAG);
            int i6 = f1212c + 1;
            f1212c = i6;
            sb4.append(i6);
            return sb4.toString();
        }
        if (i2 != 5) {
            throw new AssertionError(type.name());
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        int i7 = f1215f + 1;
        f1215f = i7;
        sb5.append(i7);
        return sb5.toString();
    }

    static void c() {
        f1212c++;
    }

    void a() {
        for (int i2 = 0; i2 < 7; i2++) {
            this.f1219j[i2] = 0.0f;
        }
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i2 = 0;
        while (true) {
            int i3 = this.m;
            if (i2 >= i3) {
                ArrayRow[] arrayRowArr = this.l;
                if (i3 >= arrayRowArr.length) {
                    this.l = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.l;
                int i4 = this.m;
                arrayRowArr2[i4] = arrayRow;
                this.m = i4 + 1;
                return;
            }
            if (this.l[i2] == arrayRow) {
                return;
            } else {
                i2++;
            }
        }
    }

    String d() {
        String str = this + "[";
        boolean z = false;
        boolean z2 = true;
        for (int i2 = 0; i2 < this.f1219j.length; i2++) {
            String str2 = str + this.f1219j[i2];
            float[] fArr = this.f1219j;
            if (fArr[i2] > 0.0f) {
                z = false;
            } else if (fArr[i2] < 0.0f) {
                z = true;
            }
            if (fArr[i2] != 0.0f) {
                z2 = false;
            }
            str = i2 < fArr.length - 1 ? str2 + ", " : str2 + "] ";
        }
        if (z) {
            str = str + " (-)";
        }
        if (!z2) {
            return str;
        }
        return str + " (*)";
    }

    public String getName() {
        return this.f1217h;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.l[i3] == arrayRow) {
                for (int i4 = 0; i4 < (i2 - i3) - 1; i4++) {
                    ArrayRow[] arrayRowArr = this.l;
                    int i5 = i3 + i4;
                    arrayRowArr[i5] = arrayRowArr[i5 + 1];
                }
                this.m--;
                return;
            }
        }
    }

    public void reset() {
        this.f1217h = null;
        this.k = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.f1218i = -1;
        this.computedValue = 0.0f;
        this.m = 0;
        this.usageInRowCount = 0;
    }

    public void setName(String str) {
        this.f1217h = str;
    }

    public void setType(Type type, String str) {
        this.k = type;
    }

    public String toString() {
        return "" + this.f1217h;
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            ArrayRow[] arrayRowArr = this.l;
            arrayRowArr[i3].variables.m(arrayRowArr[i3], arrayRow, false);
        }
        this.m = 0;
    }

    public SolverVariable(Type type, String str) {
        this.id = -1;
        this.f1218i = -1;
        this.strength = 0;
        this.f1219j = new float[7];
        this.l = new ArrayRow[8];
        this.m = 0;
        this.usageInRowCount = 0;
        this.k = type;
    }
}
