package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import id.c;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names = {c.f26972i, "x", "y", "width", "height", "pathRotate"};
    HashMap<String, CustomVariable> customAttributes;
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    float mRelativeAngle;
    Motion mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;

    /* renamed from: x */
    float f292x;

    /* renamed from: y */
    float f293y;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f10, float f11) {
        return (Float.isNaN(f10) || Float.isNaN(f11)) ? Float.isNaN(f10) != Float.isNaN(f11) : Math.abs(f10 - f11) > 1.0E-6f;
    }

    private static final float xRotate(float f10, float f11, float f12, float f13, float f14, float f15) {
        return (((f14 - f12) * f11) - ((f15 - f13) * f10)) + f12;
    }

    private static final float yRotate(float f10, float f11, float f12, float f13, float f14, float f15) {
        return ((f14 - f12) * f10) + ((f15 - f13) * f11) + f13;
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.mKeyFrameEasing = Easing.getInterpolator(motionWidget.motion.mTransitionEasing);
        MotionWidget.Motion motion = motionWidget.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = motionWidget.propertySet.mProgress;
        this.mRelativeAngle = 0.0f;
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.customAttributes.put(str, customAttribute);
            }
        }
    }

    public void configureRelativeTo(Motion motion) {
        motion.getPos(this.mProgress);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z10) {
        boolean diff = diff(this.f292x, motionPaths.f292x);
        boolean diff2 = diff(this.f293y, motionPaths.f293y);
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        boolean z11 = diff | diff2 | z10;
        zArr[1] = zArr[1] | z11;
        zArr[2] = z11 | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.f292x, this.f293y, this.width, this.height, this.mPathRotate};
        int i10 = 0;
        for (int i11 : iArr) {
            if (i11 < 6) {
                dArr[i10] = fArr[r2];
                i10++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.width;
        float f11 = this.height;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f12 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 3) {
                f10 = f12;
            } else if (i12 == 4) {
                f11 = f12;
            }
        }
        fArr[i10] = f10;
        fArr[i10 + 1] = f11;
    }

    public void getCenter(double d10, int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f292x;
        float f11 = this.f293y;
        float f12 = this.width;
        float f13 = this.height;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f14 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f14;
            } else if (i12 == 2) {
                f11 = f14;
            } else if (i12 == 3) {
                f12 = f14;
            } else if (i12 == 4) {
                f13 = f14;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d10, fArr2, new float[2]);
            float f15 = fArr2[0];
            float f16 = fArr2[1];
            double d11 = f15;
            double d12 = f10;
            double d13 = f11;
            f10 = (float) ((d11 + (Math.sin(d13) * d12)) - (f12 / 2.0f));
            f11 = (float) ((f16 - (d12 * Math.cos(d13))) - (f13 / 2.0f));
        }
        fArr[i10] = f10 + (f12 / 2.0f) + 0.0f;
        fArr[i10 + 1] = f11 + (f13 / 2.0f) + 0.0f;
    }

    public void getCenterVelocity(double d10, int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f292x;
        float f11 = this.f293y;
        float f12 = this.width;
        float f13 = this.height;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f14 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f14;
            } else if (i12 == 2) {
                f11 = f14;
            } else if (i12 == 3) {
                f12 = f14;
            } else if (i12 == 4) {
                f13 = f14;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d10, fArr2, new float[2]);
            float f15 = fArr2[0];
            float f16 = fArr2[1];
            double d11 = f15;
            double d12 = f10;
            double d13 = f11;
            f10 = (float) ((d11 + (Math.sin(d13) * d12)) - (f12 / 2.0f));
            f11 = (float) ((f16 - (d12 * Math.cos(d13))) - (f13 / 2.0f));
        }
        fArr[i10] = f10 + (f12 / 2.0f) + 0.0f;
        fArr[i10 + 1] = f11 + (f13 / 2.0f) + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i10) {
        CustomVariable customVariable = this.customAttributes.get(str);
        int i11 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i10] = customVariable.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        customVariable.getValuesToInterpolate(new float[numberOfInterpolatedValues]);
        while (i11 < numberOfInterpolatedValues) {
            dArr[i10] = r2[i11];
            i11++;
            i10++;
        }
        return numberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        CustomVariable customVariable = this.customAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f292x;
        float f11 = this.f293y;
        float f12 = this.width;
        float f13 = this.height;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f14 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f14;
            } else if (i12 == 2) {
                f11 = f14;
            } else if (i12 == 3) {
                f12 = f14;
            } else if (i12 == 4) {
                f13 = f14;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float centerX = motion.getCenterX();
            float centerY = this.mRelativeToController.getCenterY();
            double d10 = f10;
            double d11 = f11;
            float sin = (float) ((centerX + (Math.sin(d11) * d10)) - (f12 / 2.0f));
            f11 = (float) ((centerY - (d10 * Math.cos(d11))) - (f13 / 2.0f));
            f10 = sin;
        }
        float f15 = f12 + f10;
        float f16 = f13 + f11;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i10] = f10 + 0.0f;
        fArr[i10 + 1] = f11 + 0.0f;
        fArr[i10 + 2] = f15 + 0.0f;
        fArr[i10 + 3] = f11 + 0.0f;
        fArr[i10 + 4] = f15 + 0.0f;
        fArr[i10 + 5] = f16 + 0.0f;
        fArr[i10 + 6] = f10 + 0.0f;
        fArr[i10 + 7] = f16 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.customAttributes.containsKey(str);
    }

    public void initCartesian(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f10 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f10;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f11 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f10 : motionKeyPosition.mPercentWidth;
        float f12 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f10 : motionKeyPosition.mPercentHeight;
        float f13 = motionPaths2.width;
        float f14 = motionPaths.width;
        float f15 = motionPaths2.height;
        float f16 = motionPaths.height;
        this.position = this.time;
        float f17 = motionPaths.f292x;
        float f18 = motionPaths.f293y;
        float f19 = (motionPaths2.f292x + (f13 / 2.0f)) - ((f14 / 2.0f) + f17);
        float f20 = (motionPaths2.f293y + (f15 / 2.0f)) - (f18 + (f16 / 2.0f));
        float f21 = ((f13 - f14) * f11) / 2.0f;
        this.f292x = (int) ((f17 + (f19 * f10)) - f21);
        float f22 = ((f15 - f16) * f12) / 2.0f;
        this.f293y = (int) ((f18 + (f20 * f10)) - f22);
        this.width = (int) (f14 + r9);
        this.height = (int) (f16 + r12);
        float f23 = Float.isNaN(motionKeyPosition.mPercentX) ? f10 : motionKeyPosition.mPercentX;
        float f24 = Float.isNaN(motionKeyPosition.mAltPercentY) ? 0.0f : motionKeyPosition.mAltPercentY;
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            f10 = motionKeyPosition.mPercentY;
        }
        float f25 = Float.isNaN(motionKeyPosition.mAltPercentX) ? 0.0f : motionKeyPosition.mAltPercentX;
        this.mMode = 0;
        this.f292x = (int) (((motionPaths.f292x + (f23 * f19)) + (f25 * f20)) - f21);
        this.f293y = (int) (((motionPaths.f293y + (f19 * f24)) + (f20 * f10)) - f22);
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPath(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f10 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f10;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f11 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f10 : motionKeyPosition.mPercentWidth;
        float f12 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f10 : motionKeyPosition.mPercentHeight;
        float f13 = motionPaths2.width - motionPaths.width;
        float f14 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            f10 = motionKeyPosition.mPercentX;
        }
        float f15 = motionPaths.f292x;
        float f16 = motionPaths.width;
        float f17 = motionPaths.f293y;
        float f18 = motionPaths.height;
        float f19 = (motionPaths2.f292x + (motionPaths2.width / 2.0f)) - ((f16 / 2.0f) + f15);
        float f20 = (motionPaths2.f293y + (motionPaths2.height / 2.0f)) - ((f18 / 2.0f) + f17);
        float f21 = f19 * f10;
        float f22 = (f13 * f11) / 2.0f;
        this.f292x = (int) ((f15 + f21) - f22);
        float f23 = f10 * f20;
        float f24 = (f14 * f12) / 2.0f;
        this.f293y = (int) ((f17 + f23) - f24);
        this.width = (int) (f16 + r7);
        this.height = (int) (f18 + r8);
        float f25 = Float.isNaN(motionKeyPosition.mPercentY) ? 0.0f : motionKeyPosition.mPercentY;
        this.mMode = 1;
        float f26 = (int) ((motionPaths.f292x + f21) - f22);
        float f27 = (int) ((motionPaths.f293y + f23) - f24);
        this.f292x = f26 + ((-f20) * f25);
        this.f293y = f27 + (f19 * f25);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPolar(int i10, int i11, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float min;
        float f10;
        float f11 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f11;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mMode = motionKeyPosition.mPositionType;
        float f12 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f11 : motionKeyPosition.mPercentWidth;
        float f13 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f11 : motionKeyPosition.mPercentHeight;
        float f14 = motionPaths2.width;
        float f15 = motionPaths.width;
        float f16 = motionPaths2.height;
        float f17 = motionPaths.height;
        this.position = this.time;
        this.width = (int) (f15 + ((f14 - f15) * f12));
        this.height = (int) (f17 + ((f16 - f17) * f13));
        int i12 = motionKeyPosition.mPositionType;
        if (i12 == 1) {
            float f18 = Float.isNaN(motionKeyPosition.mPercentX) ? f11 : motionKeyPosition.mPercentX;
            float f19 = motionPaths2.f292x;
            float f20 = motionPaths.f292x;
            this.f292x = (f18 * (f19 - f20)) + f20;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f11 = motionKeyPosition.mPercentY;
            }
            float f21 = motionPaths2.f293y;
            float f22 = motionPaths.f293y;
            this.f293y = (f11 * (f21 - f22)) + f22;
        } else if (i12 != 2) {
            float f23 = Float.isNaN(motionKeyPosition.mPercentX) ? f11 : motionKeyPosition.mPercentX;
            float f24 = motionPaths2.f292x;
            float f25 = motionPaths.f292x;
            this.f292x = (f23 * (f24 - f25)) + f25;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f11 = motionKeyPosition.mPercentY;
            }
            float f26 = motionPaths2.f293y;
            float f27 = motionPaths.f293y;
            this.f293y = (f11 * (f26 - f27)) + f27;
        } else {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f28 = motionPaths2.f292x;
                float f29 = motionPaths.f292x;
                min = ((f28 - f29) * f11) + f29;
            } else {
                min = Math.min(f13, f12) * motionKeyPosition.mPercentX;
            }
            this.f292x = min;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f30 = motionPaths2.f293y;
                float f31 = motionPaths.f293y;
                f10 = (f11 * (f30 - f31)) + f31;
            } else {
                f10 = motionKeyPosition.mPercentY;
            }
            this.f293y = f10;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initScreen(int i10, int i11, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f10 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f10;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f11 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f10 : motionKeyPosition.mPercentWidth;
        float f12 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f10 : motionKeyPosition.mPercentHeight;
        float f13 = motionPaths2.width;
        float f14 = motionPaths.width;
        float f15 = motionPaths2.height;
        float f16 = motionPaths.height;
        this.position = this.time;
        float f17 = motionPaths.f292x;
        float f18 = motionPaths.f293y;
        float f19 = motionPaths2.f292x + (f13 / 2.0f);
        float f20 = motionPaths2.f293y + (f15 / 2.0f);
        float f21 = (f13 - f14) * f11;
        this.f292x = (int) ((f17 + ((f19 - ((f14 / 2.0f) + f17)) * f10)) - (f21 / 2.0f));
        float f22 = (f15 - f16) * f12;
        this.f293y = (int) ((f18 + ((f20 - (f18 + (f16 / 2.0f))) * f10)) - (f22 / 2.0f));
        this.width = (int) (f14 + f21);
        this.height = (int) (f16 + f22);
        this.mMode = 2;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            this.f292x = (int) (motionKeyPosition.mPercentX * ((int) (i10 - this.width)));
        }
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            this.f293y = (int) (motionKeyPosition.mPercentY * ((int) (i11 - this.height)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void setBounds(float f10, float f11, float f12, float f13) {
        this.f292x = f10;
        this.f293y = f11;
        this.width = f12;
        this.height = f13;
    }

    public void setDpDt(float f10, float f11, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f16 = (float) dArr[i10];
            double d10 = dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f12 = f16;
            } else if (i11 == 2) {
                f14 = f16;
            } else if (i11 == 3) {
                f13 = f16;
            } else if (i11 == 4) {
                f15 = f16;
            }
        }
        float f17 = f12 - ((0.0f * f13) / 2.0f);
        float f18 = f14 - ((0.0f * f15) / 2.0f);
        fArr[0] = (f17 * (1.0f - f10)) + (((f13 * 1.0f) + f17) * f10) + 0.0f;
        fArr[1] = (f18 * (1.0f - f11)) + (((f15 * 1.0f) + f18) * f11) + 0.0f;
    }

    public void setView(float f10, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f11;
        float f12;
        float f13 = this.f292x;
        float f14 = this.f293y;
        float f15 = this.width;
        float f16 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i10 = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i10];
            this.mTempDelta = new double[i10];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            double[] dArr4 = this.mTempValue;
            int i12 = iArr[i11];
            dArr4[i12] = dArr[i11];
            this.mTempDelta[i12] = dArr2[i11];
        }
        float f17 = Float.NaN;
        int i13 = 0;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = 0.0f;
        float f21 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i13 >= dArr5.length) {
                break;
            }
            boolean isNaN = Double.isNaN(dArr5[i13]);
            double d10 = l5.c.f27899e;
            if (isNaN && (dArr3 == null || dArr3[i13] == l5.c.f27899e)) {
                f12 = f17;
            } else {
                if (dArr3 != null) {
                    d10 = dArr3[i13];
                }
                if (!Double.isNaN(this.mTempValue[i13])) {
                    d10 = this.mTempValue[i13] + d10;
                }
                f12 = f17;
                float f22 = (float) d10;
                float f23 = (float) this.mTempDelta[i13];
                if (i13 == 1) {
                    f17 = f12;
                    f18 = f23;
                    f13 = f22;
                } else if (i13 == 2) {
                    f17 = f12;
                    f19 = f23;
                    f14 = f22;
                } else if (i13 == 3) {
                    f17 = f12;
                    f20 = f23;
                    f15 = f22;
                } else if (i13 == 4) {
                    f17 = f12;
                    f21 = f23;
                    f16 = f22;
                } else if (i13 == 5) {
                    f17 = f22;
                }
                i13++;
            }
            f17 = f12;
            i13++;
        }
        float f24 = f17;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter(f10, fArr, fArr2);
            float f25 = fArr[0];
            float f26 = fArr[1];
            float f27 = fArr2[0];
            float f28 = fArr2[1];
            double d11 = f13;
            double d12 = f14;
            float sin = (float) ((f25 + (Math.sin(d12) * d11)) - (f15 / 2.0f));
            f11 = f16;
            float cos = (float) ((f26 - (Math.cos(d12) * d11)) - (f16 / 2.0f));
            double d13 = f18;
            double d14 = f19;
            float sin2 = (float) (f27 + (Math.sin(d12) * d13) + (Math.cos(d12) * d11 * d14));
            float cos2 = (float) ((f28 - (d13 * Math.cos(d12))) + (d11 * Math.sin(d12) * d14));
            if (dArr2.length >= 2) {
                dArr2[0] = sin2;
                dArr2[1] = cos2;
            }
            if (!Float.isNaN(f24)) {
                motionWidget.setRotationZ((float) (f24 + Math.toDegrees(Math.atan2(cos2, sin2))));
            }
            f13 = sin;
            f14 = cos;
        } else {
            f11 = f16;
            if (!Float.isNaN(f24)) {
                motionWidget.setRotationZ((float) (0.0f + f24 + Math.toDegrees(Math.atan2(f19 + (f21 / 2.0f), f18 + (f20 / 2.0f)))));
            }
        }
        float f29 = f13 + 0.5f;
        float f30 = f14 + 0.5f;
        motionWidget.layout((int) f29, (int) f30, (int) (f29 + f15), (int) (f30 + f11));
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d10 = ((this.f292x + (this.width / 2.0f)) - motionPaths.f292x) - (motionPaths.width / 2.0f);
        double d11 = ((this.f293y + (this.height / 2.0f)) - motionPaths.f293y) - (motionPaths.height / 2.0f);
        this.mRelativeToController = motion;
        this.f292x = (float) Math.hypot(d11, d10);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.f293y = (float) (Math.atan2(d11, d10) + 1.5707963267948966d);
        } else {
            this.f293y = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public MotionPaths(int i10, int i11, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != -1) {
            initPolar(i10, i11, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i12 = motionKeyPosition.mPositionType;
        if (i12 == 1) {
            initPath(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i12 != 2) {
            initCartesian(motionKeyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i10, i11, motionKeyPosition, motionPaths, motionPaths2);
        }
    }

    public void getCenter(double d10, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f10;
        float f11 = this.f292x;
        float f12 = this.f293y;
        float f13 = this.width;
        float f14 = this.height;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f19 = (float) dArr[i10];
            float f20 = (float) dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f11 = f19;
                f15 = f20;
            } else if (i11 == 2) {
                f12 = f19;
                f17 = f20;
            } else if (i11 == 3) {
                f13 = f19;
                f16 = f20;
            } else if (i11 == 4) {
                f14 = f19;
                f18 = f20;
            }
        }
        float f21 = 2.0f;
        float f22 = (f16 / 2.0f) + f15;
        float f23 = (f18 / 2.0f) + f17;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d10, fArr3, fArr4);
            float f24 = fArr3[0];
            float f25 = fArr3[1];
            float f26 = fArr4[0];
            float f27 = fArr4[1];
            double d11 = f11;
            double d12 = f12;
            f10 = f13;
            float sin = (float) ((f24 + (Math.sin(d12) * d11)) - (f13 / 2.0f));
            float cos = (float) ((f25 - (d11 * Math.cos(d12))) - (f14 / 2.0f));
            double d13 = f15;
            double d14 = f17;
            float sin2 = (float) (f26 + (Math.sin(d12) * d13) + (Math.cos(d12) * d14));
            f23 = (float) ((f27 - (d13 * Math.cos(d12))) + (Math.sin(d12) * d14));
            f22 = sin2;
            f11 = sin;
            f12 = cos;
            f21 = 2.0f;
        } else {
            f10 = f13;
        }
        fArr[0] = f11 + (f10 / f21) + 0.0f;
        fArr[1] = f12 + (f14 / f21) + 0.0f;
        fArr2[0] = f22;
        fArr2[1] = f23;
    }
}
