package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: classes.dex */
public class TypedBundle {
    private static final int INITIAL_BOOLEAN = 4;
    private static final int INITIAL_FLOAT = 10;
    private static final int INITIAL_INT = 10;
    private static final int INITIAL_STRING = 5;
    int[] mTypeInt = new int[10];
    int[] mValueInt = new int[10];
    int mCountInt = 0;
    int[] mTypeFloat = new int[10];
    float[] mValueFloat = new float[10];
    int mCountFloat = 0;
    int[] mTypeString = new int[5];
    String[] mValueString = new String[5];
    int mCountString = 0;
    int[] mTypeBoolean = new int[4];
    boolean[] mValueBoolean = new boolean[4];
    int mCountBoolean = 0;

    public void add(int i10, int i11) {
        int i12 = this.mCountInt;
        int[] iArr = this.mTypeInt;
        if (i12 >= iArr.length) {
            this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.mValueInt;
            this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.mTypeInt;
        int i13 = this.mCountInt;
        iArr3[i13] = i10;
        int[] iArr4 = this.mValueInt;
        this.mCountInt = i13 + 1;
        iArr4[i13] = i11;
    }

    public void addIfNotNull(int i10, String str) {
        if (str != null) {
            add(i10, str);
        }
    }

    public void applyDelta(TypedValues typedValues) {
        for (int i10 = 0; i10 < this.mCountInt; i10++) {
            typedValues.setValue(this.mTypeInt[i10], this.mValueInt[i10]);
        }
        for (int i11 = 0; i11 < this.mCountFloat; i11++) {
            typedValues.setValue(this.mTypeFloat[i11], this.mValueFloat[i11]);
        }
        for (int i12 = 0; i12 < this.mCountString; i12++) {
            typedValues.setValue(this.mTypeString[i12], this.mValueString[i12]);
        }
        for (int i13 = 0; i13 < this.mCountBoolean; i13++) {
            typedValues.setValue(this.mTypeBoolean[i13], this.mValueBoolean[i13]);
        }
    }

    public void clear() {
        this.mCountBoolean = 0;
        this.mCountString = 0;
        this.mCountFloat = 0;
        this.mCountInt = 0;
    }

    public int getInteger(int i10) {
        for (int i11 = 0; i11 < this.mCountInt; i11++) {
            if (this.mTypeInt[i11] == i10) {
                return this.mValueInt[i11];
            }
        }
        return -1;
    }

    public void add(int i10, float f10) {
        int i11 = this.mCountFloat;
        int[] iArr = this.mTypeFloat;
        if (i11 >= iArr.length) {
            this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValueFloat;
            this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTypeFloat;
        int i12 = this.mCountFloat;
        iArr2[i12] = i10;
        float[] fArr2 = this.mValueFloat;
        this.mCountFloat = i12 + 1;
        fArr2[i12] = f10;
    }

    public void applyDelta(TypedBundle typedBundle) {
        for (int i10 = 0; i10 < this.mCountInt; i10++) {
            typedBundle.add(this.mTypeInt[i10], this.mValueInt[i10]);
        }
        for (int i11 = 0; i11 < this.mCountFloat; i11++) {
            typedBundle.add(this.mTypeFloat[i11], this.mValueFloat[i11]);
        }
        for (int i12 = 0; i12 < this.mCountString; i12++) {
            typedBundle.add(this.mTypeString[i12], this.mValueString[i12]);
        }
        for (int i13 = 0; i13 < this.mCountBoolean; i13++) {
            typedBundle.add(this.mTypeBoolean[i13], this.mValueBoolean[i13]);
        }
    }

    public void add(int i10, String str) {
        int i11 = this.mCountString;
        int[] iArr = this.mTypeString;
        if (i11 >= iArr.length) {
            this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.mValueString;
            this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.mTypeString;
        int i12 = this.mCountString;
        iArr2[i12] = i10;
        String[] strArr2 = this.mValueString;
        this.mCountString = i12 + 1;
        strArr2[i12] = str;
    }

    public void add(int i10, boolean z10) {
        int i11 = this.mCountBoolean;
        int[] iArr = this.mTypeBoolean;
        if (i11 >= iArr.length) {
            this.mTypeBoolean = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.mValueBoolean;
            this.mValueBoolean = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.mTypeBoolean;
        int i12 = this.mCountBoolean;
        iArr2[i12] = i10;
        boolean[] zArr2 = this.mValueBoolean;
        this.mCountBoolean = i12 + 1;
        zArr2[i12] = z10;
    }
}
