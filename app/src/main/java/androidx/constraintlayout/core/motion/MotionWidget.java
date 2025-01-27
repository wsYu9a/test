package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Set;
import l.a;
import l.e;

/* loaded from: classes.dex */
public class MotionWidget implements TypedValues {
    public static final int FILL_PARENT = -1;
    public static final int GONE_UNSET = Integer.MIN_VALUE;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 0;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int MATCH_PARENT = -1;
    public static final int PARENT_ID = 0;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    public static final int UNSET = -1;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 4;
    public static final int WRAP_CONTENT = -2;
    private float mProgress;
    float mTransitionPathRotate;
    Motion motion;
    PropertySet propertySet;
    WidgetFrame widgetFrame;

    public static class Motion {
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int SPLINE_STRING = -1;
        public int mAnimateRelativeTo = -1;
        public int mAnimateCircleAngleTo = 0;
        public String mTransitionEasing = null;
        public int mPathMotionArc = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPolarRelativeTo = -1;
        public float mPathRotate = Float.NaN;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public int mQuantizeInterpolatorID = -1;
    }

    public static class PropertySet {
        public int visibility = 4;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;
    }

    public MotionWidget() {
        this.widgetFrame = new WidgetFrame();
        this.motion = new Motion();
        this.propertySet = new PropertySet();
    }

    public MotionWidget findViewById(int i10) {
        return null;
    }

    public float getAlpha() {
        return this.propertySet.alpha;
    }

    public int getBottom() {
        return this.widgetFrame.bottom;
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.widgetFrame.getCustomAttribute(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.widgetFrame.getCustomAttributeNames();
    }

    public int getHeight() {
        WidgetFrame widgetFrame = this.widgetFrame;
        return widgetFrame.bottom - widgetFrame.top;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        int a10 = a.a(str);
        return a10 != -1 ? a10 : e.a(str);
    }

    public int getLeft() {
        return this.widgetFrame.left;
    }

    public String getName() {
        return this.widgetFrame.getId();
    }

    public MotionWidget getParent() {
        return null;
    }

    public float getPivotX() {
        return this.widgetFrame.pivotX;
    }

    public float getPivotY() {
        return this.widgetFrame.pivotY;
    }

    public int getRight() {
        return this.widgetFrame.right;
    }

    public float getRotationX() {
        return this.widgetFrame.rotationX;
    }

    public float getRotationY() {
        return this.widgetFrame.rotationY;
    }

    public float getRotationZ() {
        return this.widgetFrame.rotationZ;
    }

    public float getScaleX() {
        return this.widgetFrame.scaleX;
    }

    public float getScaleY() {
        return this.widgetFrame.scaleY;
    }

    public int getTop() {
        return this.widgetFrame.top;
    }

    public float getTranslationX() {
        return this.widgetFrame.translationX;
    }

    public float getTranslationY() {
        return this.widgetFrame.translationY;
    }

    public float getTranslationZ() {
        return this.widgetFrame.translationZ;
    }

    public float getValueAttributes(int i10) {
        switch (i10) {
            case 303:
                return this.widgetFrame.alpha;
            case 304:
                return this.widgetFrame.translationX;
            case 305:
                return this.widgetFrame.translationY;
            case 306:
                return this.widgetFrame.translationZ;
            case 307:
            default:
                return Float.NaN;
            case 308:
                return this.widgetFrame.rotationX;
            case 309:
                return this.widgetFrame.rotationY;
            case 310:
                return this.widgetFrame.rotationZ;
            case 311:
                return this.widgetFrame.scaleX;
            case 312:
                return this.widgetFrame.scaleY;
            case 313:
                return this.widgetFrame.pivotX;
            case 314:
                return this.widgetFrame.pivotY;
            case 315:
                return this.mProgress;
            case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
                return this.mTransitionPathRotate;
        }
    }

    public int getVisibility() {
        return this.propertySet.visibility;
    }

    public WidgetFrame getWidgetFrame() {
        return this.widgetFrame;
    }

    public int getWidth() {
        WidgetFrame widgetFrame = this.widgetFrame;
        return widgetFrame.right - widgetFrame.left;
    }

    public int getX() {
        return this.widgetFrame.left;
    }

    public int getY() {
        return this.widgetFrame.top;
    }

    public void layout(int i10, int i11, int i12, int i13) {
        setBounds(i10, i11, i12, i13);
    }

    public void setBounds(int i10, int i11, int i12, int i13) {
        if (this.widgetFrame == null) {
            this.widgetFrame = new WidgetFrame((ConstraintWidget) null);
        }
        WidgetFrame widgetFrame = this.widgetFrame;
        widgetFrame.top = i11;
        widgetFrame.left = i10;
        widgetFrame.right = i12;
        widgetFrame.bottom = i13;
    }

    public void setCustomAttribute(String str, int i10, float f10) {
        this.widgetFrame.setCustomAttribute(str, i10, f10);
    }

    public void setInterpolatedValue(CustomAttribute customAttribute, float[] fArr) {
        this.widgetFrame.setCustomAttribute(customAttribute.mName, 901, fArr[0]);
    }

    public void setPivotX(float f10) {
        this.widgetFrame.pivotX = f10;
    }

    public void setPivotY(float f10) {
        this.widgetFrame.pivotY = f10;
    }

    public void setRotationX(float f10) {
        this.widgetFrame.rotationX = f10;
    }

    public void setRotationY(float f10) {
        this.widgetFrame.rotationY = f10;
    }

    public void setRotationZ(float f10) {
        this.widgetFrame.rotationZ = f10;
    }

    public void setScaleX(float f10) {
        this.widgetFrame.scaleX = f10;
    }

    public void setScaleY(float f10) {
        this.widgetFrame.scaleY = f10;
    }

    public void setTranslationX(float f10) {
        this.widgetFrame.translationX = f10;
    }

    public void setTranslationY(float f10) {
        this.widgetFrame.translationY = f10;
    }

    public void setTranslationZ(float f10) {
        this.widgetFrame.translationZ = f10;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i10, boolean z10) {
        return false;
    }

    public boolean setValueAttributes(int i10, float f10) {
        switch (i10) {
            case 303:
                this.widgetFrame.alpha = f10;
                return true;
            case 304:
                this.widgetFrame.translationX = f10;
                return true;
            case 305:
                this.widgetFrame.translationY = f10;
                return true;
            case 306:
                this.widgetFrame.translationZ = f10;
                return true;
            case 307:
            default:
                return false;
            case 308:
                this.widgetFrame.rotationX = f10;
                return true;
            case 309:
                this.widgetFrame.rotationY = f10;
                return true;
            case 310:
                this.widgetFrame.rotationZ = f10;
                return true;
            case 311:
                this.widgetFrame.scaleX = f10;
                return true;
            case 312:
                this.widgetFrame.scaleY = f10;
                return true;
            case 313:
                this.widgetFrame.pivotX = f10;
                return true;
            case 314:
                this.widgetFrame.pivotY = f10;
                return true;
            case 315:
                this.mProgress = f10;
                return true;
            case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
                this.mTransitionPathRotate = f10;
                return true;
        }
    }

    public boolean setValueMotion(int i10, int i11) {
        switch (i10) {
            case TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO /* 605 */:
                this.motion.mAnimateRelativeTo = i11;
                return true;
            case TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO /* 606 */:
                this.motion.mAnimateCircleAngleTo = i11;
                return true;
            case TypedValues.MotionType.TYPE_PATHMOTION_ARC /* 607 */:
                this.motion.mPathMotionArc = i11;
                return true;
            case TypedValues.MotionType.TYPE_DRAW_PATH /* 608 */:
                this.motion.mDrawPath = i11;
                return true;
            case TypedValues.MotionType.TYPE_POLAR_RELATIVETO /* 609 */:
                this.motion.mPolarRelativeTo = i11;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS /* 610 */:
                this.motion.mQuantizeMotionSteps = i11;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE /* 611 */:
                this.motion.mQuantizeInterpolatorType = i11;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID /* 612 */:
                this.motion.mQuantizeInterpolatorID = i11;
                return true;
            default:
                return false;
        }
    }

    public void setVisibility(int i10) {
        this.propertySet.visibility = i10;
    }

    public String toString() {
        return this.widgetFrame.left + ", " + this.widgetFrame.top + ", " + this.widgetFrame.right + ", " + this.widgetFrame.bottom;
    }

    public void setCustomAttribute(String str, int i10, int i11) {
        this.widgetFrame.setCustomAttribute(str, i10, i11);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i10, int i11) {
        return setValueAttributes(i10, i11);
    }

    public void setCustomAttribute(String str, int i10, boolean z10) {
        this.widgetFrame.setCustomAttribute(str, i10, z10);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i10, float f10) {
        if (setValueAttributes(i10, f10)) {
            return true;
        }
        return setValueMotion(i10, f10);
    }

    public void setCustomAttribute(String str, int i10, String str2) {
        this.widgetFrame.setCustomAttribute(str, i10, str2);
    }

    public MotionWidget(WidgetFrame widgetFrame) {
        this.widgetFrame = new WidgetFrame();
        this.motion = new Motion();
        this.propertySet = new PropertySet();
        this.widgetFrame = widgetFrame;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i10, String str) {
        return setValueMotion(i10, str);
    }

    public boolean setValueMotion(int i10, String str) {
        if (i10 == 603) {
            this.motion.mTransitionEasing = str;
            return true;
        }
        if (i10 != 604) {
            return false;
        }
        this.motion.mQuantizeInterpolatorString = str;
        return true;
    }

    public boolean setValueMotion(int i10, float f10) {
        switch (i10) {
            case 600:
                this.motion.mMotionStagger = f10;
                return true;
            case 601:
                this.motion.mPathRotate = f10;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE /* 602 */:
                this.motion.mQuantizeMotionPhase = f10;
                return true;
            default:
                return false;
        }
    }
}
