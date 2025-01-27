package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.state.WidgetFrame;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import l.a;

/* loaded from: classes.dex */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int count;
    protected CurveFit mCurveFit;
    private String mType;
    protected int[] mTimePoints = new int[10];
    protected float[] mValues = new float[10];

    public static class CoreSpline extends SplineSet {
        long start;
        String type;

        public CoreSpline(String str, long j10) {
            this.type = str;
            this.start = j10;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setProperty(TypedValues typedValues, float f10) {
            typedValues.setValue(typedValues.getId(this.type), get(f10));
        }
    }

    public static class CustomSet extends SplineSet {
        String mAttributeName;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int i10, float f10) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(WidgetFrame widgetFrame, float f10) {
            this.mCurveFit.getPos(f10, this.mTempValues);
            widgetFrame.setCustomValue(this.mConstraintAttributeList.valueAt(0), this.mTempValues);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int i10) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, numberOfInterpolatedValues);
            for (int i11 = 0; i11 < size; i11++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i11);
                CustomAttribute valueAt = this.mConstraintAttributeList.valueAt(i11);
                dArr[i11] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i12 = 0;
                while (true) {
                    if (i12 < this.mTempValues.length) {
                        dArr2[i11][i12] = r6[i12];
                        i12++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(i10, dArr, dArr2);
        }

        public void setPoint(int i10, CustomAttribute customAttribute) {
            this.mConstraintAttributeList.append(i10, customAttribute);
        }
    }

    public static class CustomSpline extends SplineSet {
        String mAttributeName;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mTempValues;

        public CustomSpline(String str, KeyFrameArray.CustomVar customVar) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int i10, float f10) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setProperty(TypedValues typedValues, float f10) {
            setProperty((MotionWidget) typedValues, f10);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int i10) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, numberOfInterpolatedValues);
            for (int i11 = 0; i11 < size; i11++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i11);
                CustomVariable valueAt = this.mConstraintAttributeList.valueAt(i11);
                dArr[i11] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i12 = 0;
                while (true) {
                    if (i12 < this.mTempValues.length) {
                        dArr2[i11][i12] = r6[i12];
                        i12++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(i10, dArr, dArr2);
        }

        public void setPoint(int i10, CustomVariable customVariable) {
            this.mConstraintAttributeList.append(i10, customVariable);
        }

        public void setProperty(MotionWidget motionWidget, float f10) {
            this.mCurveFit.getPos(f10, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(motionWidget, this.mTempValues);
        }
    }

    public static class Sort {
        private Sort() {
        }

        public static void doubleQuickSort(int[] iArr, float[] fArr, int i10, int i11) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i11;
            iArr2[1] = i10;
            int i12 = 2;
            while (i12 > 0) {
                int i13 = iArr2[i12 - 1];
                int i14 = i12 - 2;
                int i15 = iArr2[i14];
                if (i13 < i15) {
                    int partition = partition(iArr, fArr, i13, i15);
                    iArr2[i14] = partition - 1;
                    iArr2[i12 - 1] = i13;
                    int i16 = i12 + 1;
                    iArr2[i12] = i15;
                    i12 += 2;
                    iArr2[i16] = partition + 1;
                } else {
                    i12 = i14;
                }
            }
        }

        private static int partition(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i11];
            int i13 = i10;
            while (i10 < i11) {
                if (iArr[i10] <= i12) {
                    swap(iArr, fArr, i13, i10);
                    i13++;
                }
                i10++;
            }
            swap(iArr, fArr, i13, i11);
            return i13;
        }

        private static void swap(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float f10 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = f10;
        }
    }

    public static SplineSet makeCustomSpline(String str, KeyFrameArray.CustomArray customArray) {
        return new CustomSet(str, customArray);
    }

    public static SplineSet makeCustomSplineSet(String str, KeyFrameArray.CustomVar customVar) {
        return new CustomSpline(str, customVar);
    }

    public static SplineSet makeSpline(String str, long j10) {
        return new CoreSpline(str, j10);
    }

    public float get(float f10) {
        return (float) this.mCurveFit.getPos(f10, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f10) {
        return (float) this.mCurveFit.getSlope(f10, 0);
    }

    public void setPoint(int i10, float f10) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.count + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i11 = this.count;
        iArr2[i11] = i10;
        this.mValues[i11] = f10;
        this.count = i11 + 1;
    }

    public void setProperty(TypedValues typedValues, float f10) {
        typedValues.setValue(a.a(this.mType), get(f10));
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i10) {
        int i11;
        int i12 = this.count;
        if (i12 == 0) {
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i12 - 1);
        int i13 = 1;
        for (int i14 = 1; i14 < this.count; i14++) {
            int[] iArr = this.mTimePoints;
            if (iArr[i14 - 1] != iArr[i14]) {
                i13++;
            }
        }
        double[] dArr = new double[i13];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i13, 1);
        int i15 = 0;
        while (i11 < this.count) {
            if (i11 > 0) {
                int[] iArr2 = this.mTimePoints;
                i11 = iArr2[i11] == iArr2[i11 + (-1)] ? i11 + 1 : 0;
            }
            dArr[i15] = this.mTimePoints[i11] * 0.01d;
            dArr2[i15][0] = this.mValues[i11];
            i15++;
        }
        this.mCurveFit = CurveFit.get(i10, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.count; i10++) {
            str = str + "[" + this.mTimePoints[i10] + " , " + decimalFormat.format(this.mValues[i10]) + "] ";
        }
        return str;
    }
}
