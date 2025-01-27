package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import id.c;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names = {c.f26972i, "x", "y", "width", "height", "pathRotate"};
    LinkedHashMap<String, ConstraintAttribute> attributes;
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mRelativeAngle;
    MotionController mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;

    /* renamed from: x */
    float f306x;

    /* renamed from: y */
    float f307y;
    int mDrawPath = 0;
    float mPathRotate = Float.NaN;
    float mProgress = Float.NaN;

    public MotionPaths() {
        int i10 = Key.UNSET;
        this.mPathMotionArc = i10;
        this.mAnimateRelativeTo = i10;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float a10, float b10) {
        return (Float.isNaN(a10) || Float.isNaN(b10)) ? Float.isNaN(a10) != Float.isNaN(b10) : Math.abs(a10 - b10) > 1.0E-6f;
    }

    private static final float xRotate(float sin, float cos, float cx, float cy, float x10, float y10) {
        return (((x10 - cx) * cos) - ((y10 - cy) * sin)) + cx;
    }

    private static final float yRotate(float sin, float cos, float cx, float cy, float x10, float y10) {
        return ((x10 - cx) * sin) + ((y10 - cy) * cos) + cy;
    }

    public void applyParameters(ConstraintSet.Constraint c10) {
        this.mKeyFrameEasing = Easing.getInterpolator(c10.motion.mTransitionEasing);
        ConstraintSet.Motion motion = c10.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = c10.propertySet.mProgress;
        this.mRelativeAngle = c10.layout.circleAngle;
        for (String str : c10.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = c10.mCustomConstraints.get(str);
            if (constraintAttribute != null && constraintAttribute.isContinuous()) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    public void configureRelativeTo(MotionController toOrbit) {
        toOrbit.getPos(this.mProgress);
    }

    public void different(MotionPaths points, boolean[] mask, String[] custom, boolean arcMode) {
        boolean diff = diff(this.f306x, points.f306x);
        boolean diff2 = diff(this.f307y, points.f307y);
        mask[0] = mask[0] | diff(this.position, points.position);
        boolean z10 = diff | diff2 | arcMode;
        mask[1] = mask[1] | z10;
        mask[2] = z10 | mask[2];
        mask[3] = mask[3] | diff(this.width, points.width);
        mask[4] = diff(this.height, points.height) | mask[4];
    }

    public void fillStandard(double[] data, int[] toUse) {
        float[] fArr = {this.position, this.f306x, this.f307y, this.width, this.height, this.mPathRotate};
        int i10 = 0;
        for (int i11 : toUse) {
            if (i11 < 6) {
                data[i10] = fArr[r2];
                i10++;
            }
        }
    }

    public void getBounds(int[] toUse, double[] data, float[] point, int offset) {
        float f10 = this.width;
        float f11 = this.height;
        for (int i10 = 0; i10 < toUse.length; i10++) {
            float f12 = (float) data[i10];
            int i11 = toUse[i10];
            if (i11 == 3) {
                f10 = f12;
            } else if (i11 == 4) {
                f11 = f12;
            }
        }
        point[offset] = f10;
        point[offset + 1] = f11;
    }

    public void getCenter(double p10, int[] toUse, double[] data, float[] point, int offset) {
        float f10 = this.f306x;
        float f11 = this.f307y;
        float f12 = this.width;
        float f13 = this.height;
        for (int i10 = 0; i10 < toUse.length; i10++) {
            float f14 = (float) data[i10];
            int i11 = toUse[i10];
            if (i11 == 1) {
                f10 = f14;
            } else if (i11 == 2) {
                f11 = f14;
            } else if (i11 == 3) {
                f12 = f14;
            } else if (i11 == 4) {
                f13 = f14;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            motionController.getCenter(p10, fArr, new float[2]);
            float f15 = fArr[0];
            float f16 = fArr[1];
            double d10 = f15;
            double d11 = f10;
            double d12 = f11;
            f10 = (float) ((d10 + (Math.sin(d12) * d11)) - (f12 / 2.0f));
            f11 = (float) ((f16 - (d11 * Math.cos(d12))) - (f13 / 2.0f));
        }
        point[offset] = f10 + (f12 / 2.0f) + 0.0f;
        point[offset + 1] = f11 + (f13 / 2.0f) + 0.0f;
    }

    public void getCenterVelocity(double p10, int[] toUse, double[] data, float[] point, int offset) {
        float f10 = this.f306x;
        float f11 = this.f307y;
        float f12 = this.width;
        float f13 = this.height;
        for (int i10 = 0; i10 < toUse.length; i10++) {
            float f14 = (float) data[i10];
            int i11 = toUse[i10];
            if (i11 == 1) {
                f10 = f14;
            } else if (i11 == 2) {
                f11 = f14;
            } else if (i11 == 3) {
                f12 = f14;
            } else if (i11 == 4) {
                f13 = f14;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            motionController.getCenter(p10, fArr, new float[2]);
            float f15 = fArr[0];
            float f16 = fArr[1];
            double d10 = f15;
            double d11 = f10;
            double d12 = f11;
            f10 = (float) ((d10 + (Math.sin(d12) * d11)) - (f12 / 2.0f));
            f11 = (float) ((f16 - (d11 * Math.cos(d12))) - (f13 / 2.0f));
        }
        point[offset] = f10 + (f12 / 2.0f) + 0.0f;
        point[offset + 1] = f11 + (f13 / 2.0f) + 0.0f;
    }

    public int getCustomData(String name, double[] value, int offset) {
        ConstraintAttribute constraintAttribute = this.attributes.get(name);
        int i10 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.numberOfInterpolatedValues() == 1) {
            value[offset] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = constraintAttribute.numberOfInterpolatedValues();
        constraintAttribute.getValuesToInterpolate(new float[numberOfInterpolatedValues]);
        while (i10 < numberOfInterpolatedValues) {
            value[offset] = r2[i10];
            i10++;
            offset++;
        }
        return numberOfInterpolatedValues;
    }

    public int getCustomDataCount(String name) {
        ConstraintAttribute constraintAttribute = this.attributes.get(name);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.numberOfInterpolatedValues();
    }

    public void getRect(int[] toUse, double[] data, float[] path, int offset) {
        float f10 = this.f306x;
        float f11 = this.f307y;
        float f12 = this.width;
        float f13 = this.height;
        for (int i10 = 0; i10 < toUse.length; i10++) {
            float f14 = (float) data[i10];
            int i11 = toUse[i10];
            if (i11 == 1) {
                f10 = f14;
            } else if (i11 == 2) {
                f11 = f14;
            } else if (i11 == 3) {
                f12 = f14;
            } else if (i11 == 4) {
                f13 = f14;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float centerX = motionController.getCenterX();
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
        path[offset] = f10 + 0.0f;
        path[offset + 1] = f11 + 0.0f;
        path[offset + 2] = f15 + 0.0f;
        path[offset + 3] = f11 + 0.0f;
        path[offset + 4] = f15 + 0.0f;
        path[offset + 5] = f16 + 0.0f;
        path[offset + 6] = f10 + 0.0f;
        path[offset + 7] = f16 + 0.0f;
    }

    public boolean hasCustomData(String name) {
        return this.attributes.containsKey(name);
    }

    public void initCartesian(KeyPosition c10, MotionPaths startTimePoint, MotionPaths endTimePoint) {
        float f10 = c10.mFramePosition / 100.0f;
        this.time = f10;
        this.mDrawPath = c10.mDrawPath;
        float f11 = Float.isNaN(c10.mPercentWidth) ? f10 : c10.mPercentWidth;
        float f12 = Float.isNaN(c10.mPercentHeight) ? f10 : c10.mPercentHeight;
        float f13 = endTimePoint.width;
        float f14 = startTimePoint.width;
        float f15 = endTimePoint.height;
        float f16 = startTimePoint.height;
        this.position = this.time;
        float f17 = startTimePoint.f306x;
        float f18 = startTimePoint.f307y;
        float f19 = (endTimePoint.f306x + (f13 / 2.0f)) - ((f14 / 2.0f) + f17);
        float f20 = (endTimePoint.f307y + (f15 / 2.0f)) - (f18 + (f16 / 2.0f));
        float f21 = ((f13 - f14) * f11) / 2.0f;
        this.f306x = (int) ((f17 + (f19 * f10)) - f21);
        float f22 = ((f15 - f16) * f12) / 2.0f;
        this.f307y = (int) ((f18 + (f20 * f10)) - f22);
        this.width = (int) (f14 + r9);
        this.height = (int) (f16 + r12);
        float f23 = Float.isNaN(c10.mPercentX) ? f10 : c10.mPercentX;
        float f24 = Float.isNaN(c10.mAltPercentY) ? 0.0f : c10.mAltPercentY;
        if (!Float.isNaN(c10.mPercentY)) {
            f10 = c10.mPercentY;
        }
        float f25 = Float.isNaN(c10.mAltPercentX) ? 0.0f : c10.mAltPercentX;
        this.mMode = 0;
        this.f306x = (int) (((startTimePoint.f306x + (f23 * f19)) + (f25 * f20)) - f21);
        this.f307y = (int) (((startTimePoint.f307y + (f19 * f24)) + (f20 * f10)) - f22);
        this.mKeyFrameEasing = Easing.getInterpolator(c10.mTransitionEasing);
        this.mPathMotionArc = c10.mPathMotionArc;
    }

    public void initPath(KeyPosition c10, MotionPaths startTimePoint, MotionPaths endTimePoint) {
        float f10 = c10.mFramePosition / 100.0f;
        this.time = f10;
        this.mDrawPath = c10.mDrawPath;
        float f11 = Float.isNaN(c10.mPercentWidth) ? f10 : c10.mPercentWidth;
        float f12 = Float.isNaN(c10.mPercentHeight) ? f10 : c10.mPercentHeight;
        float f13 = endTimePoint.width - startTimePoint.width;
        float f14 = endTimePoint.height - startTimePoint.height;
        this.position = this.time;
        if (!Float.isNaN(c10.mPercentX)) {
            f10 = c10.mPercentX;
        }
        float f15 = startTimePoint.f306x;
        float f16 = startTimePoint.width;
        float f17 = startTimePoint.f307y;
        float f18 = startTimePoint.height;
        float f19 = (endTimePoint.f306x + (endTimePoint.width / 2.0f)) - ((f16 / 2.0f) + f15);
        float f20 = (endTimePoint.f307y + (endTimePoint.height / 2.0f)) - ((f18 / 2.0f) + f17);
        float f21 = f19 * f10;
        float f22 = (f13 * f11) / 2.0f;
        this.f306x = (int) ((f15 + f21) - f22);
        float f23 = f10 * f20;
        float f24 = (f14 * f12) / 2.0f;
        this.f307y = (int) ((f17 + f23) - f24);
        this.width = (int) (f16 + r7);
        this.height = (int) (f18 + r8);
        float f25 = Float.isNaN(c10.mPercentY) ? 0.0f : c10.mPercentY;
        this.mMode = 1;
        float f26 = (int) ((startTimePoint.f306x + f21) - f22);
        float f27 = (int) ((startTimePoint.f307y + f23) - f24);
        this.f306x = f26 + ((-f20) * f25);
        this.f307y = f27 + (f19 * f25);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(c10.mTransitionEasing);
        this.mPathMotionArc = c10.mPathMotionArc;
    }

    public void initPolar(int parentWidth, int parentHeight, KeyPosition c10, MotionPaths s10, MotionPaths e10) {
        float min;
        float f10;
        float f11 = c10.mFramePosition / 100.0f;
        this.time = f11;
        this.mDrawPath = c10.mDrawPath;
        this.mMode = c10.mPositionType;
        float f12 = Float.isNaN(c10.mPercentWidth) ? f11 : c10.mPercentWidth;
        float f13 = Float.isNaN(c10.mPercentHeight) ? f11 : c10.mPercentHeight;
        float f14 = e10.width;
        float f15 = s10.width;
        float f16 = e10.height;
        float f17 = s10.height;
        this.position = this.time;
        this.width = (int) (f15 + ((f14 - f15) * f12));
        this.height = (int) (f17 + ((f16 - f17) * f13));
        int i10 = c10.mPositionType;
        if (i10 == 1) {
            float f18 = Float.isNaN(c10.mPercentX) ? f11 : c10.mPercentX;
            float f19 = e10.f306x;
            float f20 = s10.f306x;
            this.f306x = (f18 * (f19 - f20)) + f20;
            if (!Float.isNaN(c10.mPercentY)) {
                f11 = c10.mPercentY;
            }
            float f21 = e10.f307y;
            float f22 = s10.f307y;
            this.f307y = (f11 * (f21 - f22)) + f22;
        } else if (i10 != 2) {
            float f23 = Float.isNaN(c10.mPercentX) ? f11 : c10.mPercentX;
            float f24 = e10.f306x;
            float f25 = s10.f306x;
            this.f306x = (f23 * (f24 - f25)) + f25;
            if (!Float.isNaN(c10.mPercentY)) {
                f11 = c10.mPercentY;
            }
            float f26 = e10.f307y;
            float f27 = s10.f307y;
            this.f307y = (f11 * (f26 - f27)) + f27;
        } else {
            if (Float.isNaN(c10.mPercentX)) {
                float f28 = e10.f306x;
                float f29 = s10.f306x;
                min = ((f28 - f29) * f11) + f29;
            } else {
                min = Math.min(f13, f12) * c10.mPercentX;
            }
            this.f306x = min;
            if (Float.isNaN(c10.mPercentY)) {
                float f30 = e10.f307y;
                float f31 = s10.f307y;
                f10 = (f11 * (f30 - f31)) + f31;
            } else {
                f10 = c10.mPercentY;
            }
            this.f307y = f10;
        }
        this.mAnimateRelativeTo = s10.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(c10.mTransitionEasing);
        this.mPathMotionArc = c10.mPathMotionArc;
    }

    public void initScreen(int parentWidth, int parentHeight, KeyPosition c10, MotionPaths startTimePoint, MotionPaths endTimePoint) {
        float f10 = c10.mFramePosition / 100.0f;
        this.time = f10;
        this.mDrawPath = c10.mDrawPath;
        float f11 = Float.isNaN(c10.mPercentWidth) ? f10 : c10.mPercentWidth;
        float f12 = Float.isNaN(c10.mPercentHeight) ? f10 : c10.mPercentHeight;
        float f13 = endTimePoint.width;
        float f14 = startTimePoint.width;
        float f15 = endTimePoint.height;
        float f16 = startTimePoint.height;
        this.position = this.time;
        float f17 = startTimePoint.f306x;
        float f18 = startTimePoint.f307y;
        float f19 = endTimePoint.f306x + (f13 / 2.0f);
        float f20 = endTimePoint.f307y + (f15 / 2.0f);
        float f21 = (f13 - f14) * f11;
        this.f306x = (int) ((f17 + ((f19 - ((f14 / 2.0f) + f17)) * f10)) - (f21 / 2.0f));
        float f22 = (f15 - f16) * f12;
        this.f307y = (int) ((f18 + ((f20 - (f18 + (f16 / 2.0f))) * f10)) - (f22 / 2.0f));
        this.width = (int) (f14 + f21);
        this.height = (int) (f16 + f22);
        this.mMode = 2;
        if (!Float.isNaN(c10.mPercentX)) {
            this.f306x = (int) (c10.mPercentX * ((int) (parentWidth - this.width)));
        }
        if (!Float.isNaN(c10.mPercentY)) {
            this.f307y = (int) (c10.mPercentY * ((int) (parentHeight - this.height)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(c10.mTransitionEasing);
        this.mPathMotionArc = c10.mPathMotionArc;
    }

    public void setBounds(float x10, float y10, float w10, float h10) {
        this.f306x = x10;
        this.f307y = y10;
        this.width = w10;
        this.height = h10;
    }

    public void setDpDt(float locationX, float locationY, float[] mAnchorDpDt, int[] toUse, double[] deltaData, double[] data) {
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (int i10 = 0; i10 < toUse.length; i10++) {
            float f14 = (float) deltaData[i10];
            double d10 = data[i10];
            int i11 = toUse[i10];
            if (i11 == 1) {
                f10 = f14;
            } else if (i11 == 2) {
                f12 = f14;
            } else if (i11 == 3) {
                f11 = f14;
            } else if (i11 == 4) {
                f13 = f14;
            }
        }
        float f15 = f10 - ((0.0f * f11) / 2.0f);
        float f16 = f12 - ((0.0f * f13) / 2.0f);
        mAnchorDpDt[0] = (f15 * (1.0f - locationX)) + (((f11 * 1.0f) + f15) * locationX) + 0.0f;
        mAnchorDpDt[1] = (f16 * (1.0f - locationY)) + (((f13 * 1.0f) + f16) * locationY) + 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setView(float position, View view, int[] toUse, double[] data, double[] slope, double[] cycle, boolean mForceMeasure) {
        float f10;
        float f11;
        float f12 = this.f306x;
        float f13 = this.f307y;
        float f14 = this.width;
        float f15 = this.height;
        if (toUse.length != 0 && this.mTempValue.length <= toUse[toUse.length - 1]) {
            int i10 = toUse[toUse.length - 1] + 1;
            this.mTempValue = new double[i10];
            this.mTempDelta = new double[i10];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i11 = 0; i11 < toUse.length; i11++) {
            double[] dArr = this.mTempValue;
            int i12 = toUse[i11];
            dArr[i12] = data[i11];
            this.mTempDelta[i12] = slope[i11];
        }
        float f16 = Float.NaN;
        int i13 = 0;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = 0.0f;
        while (true) {
            double[] dArr2 = this.mTempValue;
            if (i13 >= dArr2.length) {
                break;
            }
            boolean isNaN = Double.isNaN(dArr2[i13]);
            double d10 = l5.c.f27899e;
            if (isNaN && (cycle == null || cycle[i13] == l5.c.f27899e)) {
                f11 = f16;
            } else {
                if (cycle != null) {
                    d10 = cycle[i13];
                }
                if (!Double.isNaN(this.mTempValue[i13])) {
                    d10 = this.mTempValue[i13] + d10;
                }
                f11 = f16;
                float f21 = (float) d10;
                float f22 = (float) this.mTempDelta[i13];
                if (i13 == 1) {
                    f16 = f11;
                    f17 = f22;
                    f12 = f21;
                } else if (i13 == 2) {
                    f16 = f11;
                    f18 = f22;
                    f13 = f21;
                } else if (i13 == 3) {
                    f16 = f11;
                    f19 = f22;
                    f14 = f21;
                } else if (i13 == 4) {
                    f16 = f11;
                    f20 = f22;
                    f15 = f21;
                } else if (i13 == 5) {
                    f16 = f21;
                }
                i13++;
            }
            f16 = f11;
            i13++;
        }
        float f23 = f16;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.getCenter(position, fArr, fArr2);
            float f24 = fArr[0];
            float f25 = fArr[1];
            float f26 = fArr2[0];
            float f27 = fArr2[1];
            double d11 = f12;
            double d12 = f13;
            float sin = (float) ((f24 + (Math.sin(d12) * d11)) - (f14 / 2.0f));
            f10 = f15;
            float cos = (float) ((f25 - (Math.cos(d12) * d11)) - (f15 / 2.0f));
            double d13 = f17;
            double d14 = f18;
            float sin2 = (float) (f26 + (Math.sin(d12) * d13) + (Math.cos(d12) * d11 * d14));
            float cos2 = (float) ((f27 - (d13 * Math.cos(d12))) + (d11 * Math.sin(d12) * d14));
            if (slope.length >= 2) {
                slope[0] = sin2;
                slope[1] = cos2;
            }
            if (!Float.isNaN(f23)) {
                view.setRotation((float) (f23 + Math.toDegrees(Math.atan2(cos2, sin2))));
            }
            f12 = sin;
            f13 = cos;
        } else {
            f10 = f15;
            if (!Float.isNaN(f23)) {
                view.setRotation((float) (0.0f + f23 + Math.toDegrees(Math.atan2(f18 + (f20 / 2.0f), f17 + (f19 / 2.0f)))));
            }
        }
        if (view instanceof FloatLayout) {
            ((FloatLayout) view).layout(f12, f13, f14 + f12, f13 + f10);
            return;
        }
        float f28 = f12 + 0.5f;
        int i14 = (int) f28;
        float f29 = f13 + 0.5f;
        int i15 = (int) f29;
        int i16 = (int) (f28 + f14);
        int i17 = (int) (f29 + f10);
        int i18 = i16 - i14;
        int i19 = i17 - i15;
        if (i18 != view.getMeasuredWidth() || i19 != view.getMeasuredHeight() || mForceMeasure) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
        }
        view.layout(i14, i15, i16, i17);
    }

    public void setupRelative(MotionController mc2, MotionPaths relative) {
        double d10 = ((this.f306x + (this.width / 2.0f)) - relative.f306x) - (relative.width / 2.0f);
        double d11 = ((this.f307y + (this.height / 2.0f)) - relative.f307y) - (relative.height / 2.0f);
        this.mRelativeToController = mc2;
        this.f306x = (float) Math.hypot(d11, d10);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.f307y = (float) (Math.atan2(d11, d10) + 1.5707963267948966d);
        } else {
            this.f307y = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull MotionPaths o10) {
        return Float.compare(this.position, o10.position);
    }

    public MotionPaths(int parentWidth, int parentHeight, KeyPosition c10, MotionPaths startTimePoint, MotionPaths endTimePoint) {
        int i10 = Key.UNSET;
        this.mPathMotionArc = i10;
        this.mAnimateRelativeTo = i10;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (startTimePoint.mAnimateRelativeTo != Key.UNSET) {
            initPolar(parentWidth, parentHeight, c10, startTimePoint, endTimePoint);
            return;
        }
        int i11 = c10.mPositionType;
        if (i11 == 1) {
            initPath(c10, startTimePoint, endTimePoint);
        } else if (i11 != 2) {
            initCartesian(c10, startTimePoint, endTimePoint);
        } else {
            initScreen(parentWidth, parentHeight, c10, startTimePoint, endTimePoint);
        }
    }

    public void getCenter(double p10, int[] toUse, double[] data, float[] point, double[] vdata, float[] velocity) {
        float f10;
        float f11 = this.f306x;
        float f12 = this.f307y;
        float f13 = this.width;
        float f14 = this.height;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        for (int i10 = 0; i10 < toUse.length; i10++) {
            float f19 = (float) data[i10];
            float f20 = (float) vdata[i10];
            int i11 = toUse[i10];
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
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.getCenter(p10, fArr, fArr2);
            float f24 = fArr[0];
            float f25 = fArr[1];
            float f26 = fArr2[0];
            float f27 = fArr2[1];
            double d10 = f11;
            double d11 = f12;
            f10 = f13;
            float sin = (float) ((f24 + (Math.sin(d11) * d10)) - (f13 / 2.0f));
            float cos = (float) ((f25 - (d10 * Math.cos(d11))) - (f14 / 2.0f));
            double d12 = f15;
            double d13 = f17;
            float sin2 = (float) (f26 + (Math.sin(d11) * d12) + (Math.cos(d11) * d13));
            f23 = (float) ((f27 - (d12 * Math.cos(d11))) + (Math.sin(d11) * d13));
            f22 = sin2;
            f11 = sin;
            f12 = cos;
            f21 = 2.0f;
        } else {
            f10 = f13;
        }
        point[0] = f11 + (f10 / f21) + 0.0f;
        point[1] = f12 + (f14 / f21) + 0.0f;
        velocity[0] = f22;
        velocity[1] = f23;
    }
}
