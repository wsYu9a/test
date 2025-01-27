package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import l.c;

/* loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    private String mWaveString = null;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();

    /* renamed from: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator$1 */
    public class AnonymousClass1 implements Comparator<WavePoint> {
        public AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
            return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
        }
    }

    public static class CoreSpline extends KeyCycleOscillator {
        String type;
        int typeId;

        public CoreSpline(String str) {
            this.type = str;
            this.typeId = c.a(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f10) {
            motionWidget.setValue(this.typeId, get(f10));
        }
    }

    public static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        private final int OFFST;
        private final int PHASE;
        private final int VALUE;
        CurveFit mCurveFit;
        float[] mOffset;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        float[] mPhase;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        public CycleOscillator(int i10, String str, int i11, int i12) {
            Oscillator oscillator = new Oscillator();
            this.mOscillator = oscillator;
            this.OFFST = 0;
            this.PHASE = 1;
            this.VALUE = 2;
            this.mWaveShape = i10;
            this.mVariesBy = i11;
            oscillator.setType(i10, str);
            this.mValues = new float[i12];
            this.mPosition = new double[i12];
            this.mPeriod = new float[i12];
            this.mOffset = new float[i12];
            this.mPhase = new float[i12];
            this.mScale = new float[i12];
        }

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float f10) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                double d10 = f10;
                curveFit.getSlope(d10, this.mSplineSlopeCache);
                this.mCurveFit.getPos(d10, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineSlopeCache;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d11 = f10;
            double value = this.mOscillator.getValue(d11, this.mSplineValueCache[1]);
            double slope = this.mOscillator.getSlope(d11, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
            double[] dArr2 = this.mSplineSlopeCache;
            return dArr2[0] + (value * dArr2[2]) + (slope * this.mSplineValueCache[2]);
        }

        public double getValues(float f10) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                curveFit.getPos(f10, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineValueCache;
                dArr[0] = this.mOffset[0];
                dArr[1] = this.mPhase[0];
                dArr[2] = this.mValues[0];
            }
            double[] dArr2 = this.mSplineValueCache;
            return dArr2[0] + (this.mOscillator.getValue(f10, dArr2[1]) * this.mSplineValueCache[2]);
        }

        public void setPoint(int i10, int i11, float f10, float f11, float f12, float f13) {
            this.mPosition[i10] = i11 / 100.0d;
            this.mPeriod[i10] = f10;
            this.mOffset[i10] = f11;
            this.mPhase[i10] = f12;
            this.mValues[i10] = f13;
        }

        public void setup(float f10) {
            this.mPathLength = f10;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.mPosition.length, 3);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[fArr.length + 2];
            this.mSplineSlopeCache = new double[fArr.length + 2];
            if (this.mPosition[0] > l5.c.f27899e) {
                this.mOscillator.addPoint(l5.c.f27899e, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i10 = 0; i10 < dArr.length; i10++) {
                double[] dArr3 = dArr[i10];
                dArr3[0] = this.mOffset[i10];
                dArr3[1] = this.mPhase[i10];
                dArr3[2] = this.mValues[i10];
                this.mOscillator.addPoint(this.mPosition[i10], this.mPeriod[i10]);
            }
            this.mOscillator.normalize();
            double[] dArr4 = this.mPosition;
            if (dArr4.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr4, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }

    public static class IntDoubleSort {
        private IntDoubleSort() {
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

        public static void sort(int[] iArr, float[] fArr, int i10, int i11) {
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

        private static void swap(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float f10 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = f10;
        }
    }

    public static class IntFloatFloatSort {
        private IntFloatFloatSort() {
        }

        private static int partition(int[] iArr, float[] fArr, float[] fArr2, int i10, int i11) {
            int i12 = iArr[i11];
            int i13 = i10;
            while (i10 < i11) {
                if (iArr[i10] <= i12) {
                    swap(iArr, fArr, fArr2, i13, i10);
                    i13++;
                }
                i10++;
            }
            swap(iArr, fArr, fArr2, i13, i11);
            return i13;
        }

        public static void sort(int[] iArr, float[] fArr, float[] fArr2, int i10, int i11) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i11;
            iArr2[1] = i10;
            int i12 = 2;
            while (i12 > 0) {
                int i13 = iArr2[i12 - 1];
                int i14 = i12 - 2;
                int i15 = iArr2[i14];
                if (i13 < i15) {
                    int partition = partition(iArr, fArr, fArr2, i13, i15);
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

        private static void swap(int[] iArr, float[] fArr, float[] fArr2, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float f10 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = f10;
            float f11 = fArr2[i10];
            fArr2[i10] = fArr2[i11];
            fArr2[i11] = f11;
        }
    }

    public static class PathRotateSet extends KeyCycleOscillator {
        String type;
        int typeId;

        public PathRotateSet(String str) {
            this.type = str;
            this.typeId = c.a(str);
        }

        public void setPathRotate(MotionWidget motionWidget, float f10, double d10, double d11) {
            motionWidget.setRotationZ(get(f10) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f10) {
            motionWidget.setValue(this.typeId, get(f10));
        }
    }

    public static class WavePoint {
        float mOffset;
        float mPeriod;
        float mPhase;
        int mPosition;
        float mValue;

        public WavePoint(int i10, float f10, float f11, float f12, float f13) {
            this.mPosition = i10;
            this.mValue = f13;
            this.mOffset = f11;
            this.mPeriod = f10;
            this.mPhase = f12;
        }
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        return str.equals("pathRotate") ? new PathRotateSet(str) : new CoreSpline(str);
    }

    public float get(float f10) {
        return (float) this.mCycleOscillator.getValues(f10);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f10) {
        return (float) this.mCycleOscillator.getSlope(f10);
    }

    public void setCustom(Object obj) {
    }

    public void setPoint(int i10, int i11, String str, int i12, float f10, float f11, float f12, float f13, Object obj) {
        this.mWavePoints.add(new WavePoint(i10, f10, f11, f12, f13));
        if (i12 != -1) {
            this.mVariesBy = i12;
        }
        this.mWaveShape = i11;
        setCustom(obj);
        this.mWaveString = str;
    }

    public void setProperty(MotionWidget motionWidget, float f10) {
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(float f10) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            public AnonymousClass1() {
            }

            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
            }
        });
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            WavePoint next = it.next();
            float f11 = next.mPeriod;
            dArr[i10] = f11 * 0.01d;
            double[] dArr3 = dArr2[i10];
            float f12 = next.mValue;
            dArr3[0] = f12;
            float f13 = next.mOffset;
            dArr3[1] = f13;
            float f14 = next.mPhase;
            dArr3[2] = f14;
            this.mCycleOscillator.setPoint(i10, next.mPosition, f11, f13, f14, f12);
            i10++;
            dArr2 = dArr2;
        }
        this.mCycleOscillator.setup(f10);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        while (it.hasNext()) {
            str = str + "[" + it.next().mPosition + " , " + decimalFormat.format(r3.mValue) + "] ";
        }
        return str;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    public void setPoint(int i10, int i11, String str, int i12, float f10, float f11, float f12, float f13) {
        this.mWavePoints.add(new WavePoint(i10, f10, f11, f12, f13));
        if (i12 != -1) {
            this.mVariesBy = i12;
        }
        this.mWaveShape = i11;
        this.mWaveString = str;
    }
}
