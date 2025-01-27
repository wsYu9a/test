package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ConstraintSet {
    private static final int A = 22;
    private static final int B = 23;
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    private static final int C = 24;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int D = 25;
    private static final int E = 26;
    public static final int END = 7;
    private static final int F = 27;
    private static final int G = 28;
    public static final int GONE = 8;
    private static final int H = 29;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int I = 30;
    public static final int INVISIBLE = 4;
    private static final int J = 31;
    private static final int K = 32;
    private static final int L = 33;
    public static final int LEFT = 1;
    private static final int M = 34;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int N = 35;
    private static final int O = 36;
    private static final int P = 37;
    public static final int PARENT_ID = 0;
    private static final int Q = 38;
    private static final int R = 39;
    public static final int RIGHT = 2;
    private static final int S = 40;
    public static final int START = 6;
    private static final int T = 41;
    public static final int TOP = 3;
    private static final int U = 42;
    public static final int UNSET = -1;
    private static final int V = 43;
    public static final int VERTICAL = 1;
    public static final int VERTICAL_GUIDELINE = 1;
    public static final int VISIBLE = 0;
    private static final int W = 44;
    public static final int WRAP_CONTENT = -2;
    private static final int X = 45;
    private static final int Y = 46;
    private static final int Z = 47;

    /* renamed from: a */
    private static final String f1327a = "ConstraintSet";
    private static final int a0 = 48;

    /* renamed from: b */
    private static final boolean f1328b = false;
    private static final int b0 = 49;

    /* renamed from: c */
    private static final int[] f1329c = {0, 4, 8};
    private static final int c0 = 50;

    /* renamed from: d */
    private static final int f1330d = 1;
    private static final int d0 = 51;

    /* renamed from: e */
    private static SparseIntArray f1331e = null;
    private static final int e0 = 52;

    /* renamed from: f */
    private static final int f1332f = 1;
    private static final int f0 = 53;

    /* renamed from: g */
    private static final int f1333g = 2;
    private static final int g0 = 54;

    /* renamed from: h */
    private static final int f1334h = 3;
    private static final int h0 = 55;

    /* renamed from: i */
    private static final int f1335i = 4;
    private static final int i0 = 56;

    /* renamed from: j */
    private static final int f1336j = 5;
    private static final int j0 = 57;
    private static final int k = 6;
    private static final int k0 = 58;
    private static final int l = 7;
    private static final int l0 = 59;
    private static final int m = 8;
    private static final int m0 = 60;
    private static final int n = 9;
    private static final int n0 = 61;
    private static final int o = 10;
    private static final int o0 = 62;
    private static final int p = 11;
    private static final int p0 = 63;
    private static final int q = 12;
    private static final int q0 = 69;
    private static final int r = 13;
    private static final int r0 = 70;
    private static final int s = 14;
    private static final int s0 = 71;
    private static final int t = 15;
    private static final int t0 = 72;
    private static final int u = 16;
    private static final int u0 = 73;
    private static final int v = 17;
    private static final int v0 = 74;
    private static final int w = 18;
    private static final int w0 = 75;
    private static final int x = 19;
    private static final int y = 20;
    private static final int z = 21;
    private HashMap<Integer, Constraint> x0 = new HashMap<>();

    private static class Constraint {

        /* renamed from: a */
        static final int f1337a = -1;
        public float alpha;
        public boolean applyElevation;

        /* renamed from: b */
        boolean f1338b;
        public int baselineToBaseline;
        public int bottomMargin;
        public int bottomToBottom;
        public int bottomToTop;

        /* renamed from: c */
        int f1339c;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String dimensionRatio;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public float elevation;
        public int endMargin;
        public int endToEnd;
        public int endToStart;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public int heightDefault;
        public int heightMax;
        public int heightMin;
        public float heightPercent;
        public float horizontalBias;
        public int horizontalChainStyle;
        public float horizontalWeight;
        public int leftMargin;
        public int leftToLeft;
        public int leftToRight;
        public boolean mBarrierAllowsGoneWidgets;
        public int mBarrierDirection;
        public int mHeight;
        public int mHelperType;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public int orientation;
        public int rightMargin;
        public int rightToLeft;
        public int rightToRight;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public int startMargin;
        public int startToEnd;
        public int startToStart;
        public int topMargin;
        public int topToBottom;
        public int topToTop;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;
        public float verticalBias;
        public int verticalChainStyle;
        public float verticalWeight;
        public int visibility;
        public int widthDefault;
        public int widthMax;
        public int widthMin;
        public float widthPercent;

        private Constraint() {
            this.f1338b = false;
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.leftMargin = -1;
            this.rightMargin = -1;
            this.topMargin = -1;
            this.bottomMargin = -1;
            this.endMargin = -1;
            this.startMargin = -1;
            this.visibility = 0;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneEndMargin = -1;
            this.goneStartMargin = -1;
            this.verticalWeight = 0.0f;
            this.horizontalWeight = 0.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = Float.NaN;
            this.transformPivotY = Float.NaN;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.widthDefault = 0;
            this.heightDefault = 0;
            this.widthMax = -1;
            this.heightMax = -1;
            this.widthMin = -1;
            this.heightMin = -1;
            this.widthPercent = 1.0f;
            this.heightPercent = 1.0f;
            this.mBarrierAllowsGoneWidgets = false;
            this.mBarrierDirection = -1;
            this.mHelperType = -1;
        }

        public void d(int i2, ConstraintLayout.LayoutParams layoutParams) {
            this.f1339c = i2;
            this.leftToLeft = layoutParams.leftToLeft;
            this.leftToRight = layoutParams.leftToRight;
            this.rightToLeft = layoutParams.rightToLeft;
            this.rightToRight = layoutParams.rightToRight;
            this.topToTop = layoutParams.topToTop;
            this.topToBottom = layoutParams.topToBottom;
            this.bottomToTop = layoutParams.bottomToTop;
            this.bottomToBottom = layoutParams.bottomToBottom;
            this.baselineToBaseline = layoutParams.baselineToBaseline;
            this.startToEnd = layoutParams.startToEnd;
            this.startToStart = layoutParams.startToStart;
            this.endToStart = layoutParams.endToStart;
            this.endToEnd = layoutParams.endToEnd;
            this.horizontalBias = layoutParams.horizontalBias;
            this.verticalBias = layoutParams.verticalBias;
            this.dimensionRatio = layoutParams.dimensionRatio;
            this.circleConstraint = layoutParams.circleConstraint;
            this.circleRadius = layoutParams.circleRadius;
            this.circleAngle = layoutParams.circleAngle;
            this.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.orientation = layoutParams.orientation;
            this.guidePercent = layoutParams.guidePercent;
            this.guideBegin = layoutParams.guideBegin;
            this.guideEnd = layoutParams.guideEnd;
            this.mWidth = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            this.mHeight = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            this.leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            this.rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            this.topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            this.bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.verticalChainStyle = layoutParams.verticalChainStyle;
            this.horizontalChainStyle = layoutParams.horizontalChainStyle;
            boolean z = layoutParams.constrainedWidth;
            this.constrainedWidth = z;
            this.constrainedHeight = layoutParams.constrainedHeight;
            this.widthDefault = layoutParams.matchConstraintDefaultWidth;
            this.heightDefault = layoutParams.matchConstraintDefaultHeight;
            this.constrainedWidth = z;
            this.widthMax = layoutParams.matchConstraintMaxWidth;
            this.heightMax = layoutParams.matchConstraintMaxHeight;
            this.widthMin = layoutParams.matchConstraintMinWidth;
            this.heightMin = layoutParams.matchConstraintMinHeight;
            this.widthPercent = layoutParams.matchConstraintPercentWidth;
            this.heightPercent = layoutParams.matchConstraintPercentHeight;
            if (Build.VERSION.SDK_INT >= 17) {
                this.endMargin = layoutParams.getMarginEnd();
                this.startMargin = layoutParams.getMarginStart();
            }
        }

        public void e(int i2, Constraints.LayoutParams layoutParams) {
            d(i2, layoutParams);
            this.alpha = layoutParams.alpha;
            this.rotation = layoutParams.rotation;
            this.rotationX = layoutParams.rotationX;
            this.rotationY = layoutParams.rotationY;
            this.scaleX = layoutParams.scaleX;
            this.scaleY = layoutParams.scaleY;
            this.transformPivotX = layoutParams.transformPivotX;
            this.transformPivotY = layoutParams.transformPivotY;
            this.translationX = layoutParams.translationX;
            this.translationY = layoutParams.translationY;
            this.translationZ = layoutParams.translationZ;
            this.elevation = layoutParams.elevation;
            this.applyElevation = layoutParams.applyElevation;
        }

        public void f(ConstraintHelper constraintHelper, int i2, Constraints.LayoutParams layoutParams) {
            e(i2, layoutParams);
            if (constraintHelper instanceof Barrier) {
                this.mHelperType = 1;
                Barrier barrier = (Barrier) constraintHelper;
                this.mBarrierDirection = barrier.getType();
                this.mReferenceIds = barrier.getReferencedIds();
            }
        }

        public void applyTo(ConstraintLayout.LayoutParams layoutParams) {
            layoutParams.leftToLeft = this.leftToLeft;
            layoutParams.leftToRight = this.leftToRight;
            layoutParams.rightToLeft = this.rightToLeft;
            layoutParams.rightToRight = this.rightToRight;
            layoutParams.topToTop = this.topToTop;
            layoutParams.topToBottom = this.topToBottom;
            layoutParams.bottomToTop = this.bottomToTop;
            layoutParams.bottomToBottom = this.bottomToBottom;
            layoutParams.baselineToBaseline = this.baselineToBaseline;
            layoutParams.startToEnd = this.startToEnd;
            layoutParams.startToStart = this.startToStart;
            layoutParams.endToStart = this.endToStart;
            layoutParams.endToEnd = this.endToEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.leftMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = this.rightMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.topMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.bottomMargin;
            layoutParams.goneStartMargin = this.goneStartMargin;
            layoutParams.goneEndMargin = this.goneEndMargin;
            layoutParams.horizontalBias = this.horizontalBias;
            layoutParams.verticalBias = this.verticalBias;
            layoutParams.circleConstraint = this.circleConstraint;
            layoutParams.circleRadius = this.circleRadius;
            layoutParams.circleAngle = this.circleAngle;
            layoutParams.dimensionRatio = this.dimensionRatio;
            layoutParams.editorAbsoluteX = this.editorAbsoluteX;
            layoutParams.editorAbsoluteY = this.editorAbsoluteY;
            layoutParams.verticalWeight = this.verticalWeight;
            layoutParams.horizontalWeight = this.horizontalWeight;
            layoutParams.verticalChainStyle = this.verticalChainStyle;
            layoutParams.horizontalChainStyle = this.horizontalChainStyle;
            layoutParams.constrainedWidth = this.constrainedWidth;
            layoutParams.constrainedHeight = this.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = this.widthDefault;
            layoutParams.matchConstraintDefaultHeight = this.heightDefault;
            layoutParams.matchConstraintMaxWidth = this.widthMax;
            layoutParams.matchConstraintMaxHeight = this.heightMax;
            layoutParams.matchConstraintMinWidth = this.widthMin;
            layoutParams.matchConstraintMinHeight = this.heightMin;
            layoutParams.matchConstraintPercentWidth = this.widthPercent;
            layoutParams.matchConstraintPercentHeight = this.heightPercent;
            layoutParams.orientation = this.orientation;
            layoutParams.guidePercent = this.guidePercent;
            layoutParams.guideBegin = this.guideBegin;
            layoutParams.guideEnd = this.guideEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = this.mWidth;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = this.mHeight;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.startMargin);
                layoutParams.setMarginEnd(this.endMargin);
            }
            layoutParams.validate();
        }

        /* renamed from: clone */
        public Constraint m32clone() {
            Constraint constraint = new Constraint();
            constraint.f1338b = this.f1338b;
            constraint.mWidth = this.mWidth;
            constraint.mHeight = this.mHeight;
            constraint.guideBegin = this.guideBegin;
            constraint.guideEnd = this.guideEnd;
            constraint.guidePercent = this.guidePercent;
            constraint.leftToLeft = this.leftToLeft;
            constraint.leftToRight = this.leftToRight;
            constraint.rightToLeft = this.rightToLeft;
            constraint.rightToRight = this.rightToRight;
            constraint.topToTop = this.topToTop;
            constraint.topToBottom = this.topToBottom;
            constraint.bottomToTop = this.bottomToTop;
            constraint.bottomToBottom = this.bottomToBottom;
            constraint.baselineToBaseline = this.baselineToBaseline;
            constraint.startToEnd = this.startToEnd;
            constraint.startToStart = this.startToStart;
            constraint.endToStart = this.endToStart;
            constraint.endToEnd = this.endToEnd;
            constraint.horizontalBias = this.horizontalBias;
            constraint.verticalBias = this.verticalBias;
            constraint.dimensionRatio = this.dimensionRatio;
            constraint.editorAbsoluteX = this.editorAbsoluteX;
            constraint.editorAbsoluteY = this.editorAbsoluteY;
            constraint.horizontalBias = this.horizontalBias;
            constraint.horizontalBias = this.horizontalBias;
            constraint.horizontalBias = this.horizontalBias;
            constraint.horizontalBias = this.horizontalBias;
            constraint.horizontalBias = this.horizontalBias;
            constraint.orientation = this.orientation;
            constraint.leftMargin = this.leftMargin;
            constraint.rightMargin = this.rightMargin;
            constraint.topMargin = this.topMargin;
            constraint.bottomMargin = this.bottomMargin;
            constraint.endMargin = this.endMargin;
            constraint.startMargin = this.startMargin;
            constraint.visibility = this.visibility;
            constraint.goneLeftMargin = this.goneLeftMargin;
            constraint.goneTopMargin = this.goneTopMargin;
            constraint.goneRightMargin = this.goneRightMargin;
            constraint.goneBottomMargin = this.goneBottomMargin;
            constraint.goneEndMargin = this.goneEndMargin;
            constraint.goneStartMargin = this.goneStartMargin;
            constraint.verticalWeight = this.verticalWeight;
            constraint.horizontalWeight = this.horizontalWeight;
            constraint.horizontalChainStyle = this.horizontalChainStyle;
            constraint.verticalChainStyle = this.verticalChainStyle;
            constraint.alpha = this.alpha;
            constraint.applyElevation = this.applyElevation;
            constraint.elevation = this.elevation;
            constraint.rotation = this.rotation;
            constraint.rotationX = this.rotationX;
            constraint.rotationY = this.rotationY;
            constraint.scaleX = this.scaleX;
            constraint.scaleY = this.scaleY;
            constraint.transformPivotX = this.transformPivotX;
            constraint.transformPivotY = this.transformPivotY;
            constraint.translationX = this.translationX;
            constraint.translationY = this.translationY;
            constraint.translationZ = this.translationZ;
            constraint.constrainedWidth = this.constrainedWidth;
            constraint.constrainedHeight = this.constrainedHeight;
            constraint.widthDefault = this.widthDefault;
            constraint.heightDefault = this.heightDefault;
            constraint.widthMax = this.widthMax;
            constraint.heightMax = this.heightMax;
            constraint.widthMin = this.widthMin;
            constraint.heightMin = this.heightMin;
            constraint.widthPercent = this.widthPercent;
            constraint.heightPercent = this.heightPercent;
            constraint.mBarrierDirection = this.mBarrierDirection;
            constraint.mHelperType = this.mHelperType;
            int[] iArr = this.mReferenceIds;
            if (iArr != null) {
                constraint.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            }
            constraint.circleConstraint = this.circleConstraint;
            constraint.circleRadius = this.circleRadius;
            constraint.circleAngle = this.circleAngle;
            constraint.mBarrierAllowsGoneWidgets = this.mBarrierAllowsGoneWidgets;
            return constraint;
        }

        /* synthetic */ Constraint(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1331e = sparseIntArray;
        sparseIntArray.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f1331e.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
        f1331e.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
        f1331e.append(R.styleable.ConstraintSet_android_orientation, 27);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f1331e.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
        f1331e.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
        f1331e.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
        f1331e.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
        f1331e.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
        f1331e.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 75);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 75);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 75);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 75);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 75);
        f1331e.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
        f1331e.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
        f1331e.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
        f1331e.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
        f1331e.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
        f1331e.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
        f1331e.append(R.styleable.ConstraintSet_android_layout_width, 23);
        f1331e.append(R.styleable.ConstraintSet_android_layout_height, 21);
        f1331e.append(R.styleable.ConstraintSet_android_visibility, 22);
        f1331e.append(R.styleable.ConstraintSet_android_alpha, 43);
        f1331e.append(R.styleable.ConstraintSet_android_elevation, 44);
        f1331e.append(R.styleable.ConstraintSet_android_rotationX, 45);
        f1331e.append(R.styleable.ConstraintSet_android_rotationY, 46);
        f1331e.append(R.styleable.ConstraintSet_android_rotation, 60);
        f1331e.append(R.styleable.ConstraintSet_android_scaleX, 47);
        f1331e.append(R.styleable.ConstraintSet_android_scaleY, 48);
        f1331e.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
        f1331e.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
        f1331e.append(R.styleable.ConstraintSet_android_translationX, 51);
        f1331e.append(R.styleable.ConstraintSet_android_translationY, 52);
        f1331e.append(R.styleable.ConstraintSet_android_translationZ, 53);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintCircle, 61);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintCircleRadius, 62);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintCircleAngle, 63);
        f1331e.append(R.styleable.ConstraintSet_android_id, 38);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintWidth_percent, 69);
        f1331e.append(R.styleable.ConstraintSet_layout_constraintHeight_percent, 70);
        f1331e.append(R.styleable.ConstraintSet_chainUseRtl, 71);
        f1331e.append(R.styleable.ConstraintSet_barrierDirection, 72);
        f1331e.append(R.styleable.ConstraintSet_constraint_referenced_ids, 73);
        f1331e.append(R.styleable.ConstraintSet_barrierAllowsGoneWidgets, 74);
    }

    private int[] b(View view, String str) {
        int i2;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < split.length) {
            String trim = split[i3].trim();
            try {
                i2 = R.id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i2 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i2 = ((Integer) designInformation).intValue();
            }
            iArr[i4] = i2;
            i3++;
            i4++;
        }
        return i4 != split.length ? Arrays.copyOf(iArr, i4) : iArr;
    }

    private void c(int i2, int i3, int i4, int i5, int[] iArr, float[] fArr, int i6, int i7, int i8) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null && fArr.length != iArr.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null) {
            e(iArr[0]).horizontalWeight = fArr[0];
        }
        e(iArr[0]).horizontalChainStyle = i6;
        connect(iArr[0], i7, i2, i3, -1);
        for (int i9 = 1; i9 < iArr.length; i9++) {
            int i10 = iArr[i9];
            int i11 = i9 - 1;
            connect(iArr[i9], i7, iArr[i11], i8, -1);
            connect(iArr[i11], i8, iArr[i9], i7, -1);
            if (fArr != null) {
                e(iArr[i9]).horizontalWeight = fArr[i9];
            }
        }
        connect(iArr[iArr.length - 1], i8, i4, i5, -1);
    }

    private Constraint d(Context context, AttributeSet attributeSet) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
        g(constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private Constraint e(int i2) {
        if (!this.x0.containsKey(Integer.valueOf(i2))) {
            this.x0.put(Integer.valueOf(i2), new Constraint());
        }
        return this.x0.get(Integer.valueOf(i2));
    }

    private static int f(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    private void g(Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            int i3 = f1331e.get(index);
            switch (i3) {
                case 1:
                    constraint.baselineToBaseline = f(typedArray, index, constraint.baselineToBaseline);
                    break;
                case 2:
                    constraint.bottomMargin = typedArray.getDimensionPixelSize(index, constraint.bottomMargin);
                    break;
                case 3:
                    constraint.bottomToBottom = f(typedArray, index, constraint.bottomToBottom);
                    break;
                case 4:
                    constraint.bottomToTop = f(typedArray, index, constraint.bottomToTop);
                    break;
                case 5:
                    constraint.dimensionRatio = typedArray.getString(index);
                    break;
                case 6:
                    constraint.editorAbsoluteX = typedArray.getDimensionPixelOffset(index, constraint.editorAbsoluteX);
                    break;
                case 7:
                    constraint.editorAbsoluteY = typedArray.getDimensionPixelOffset(index, constraint.editorAbsoluteY);
                    break;
                case 8:
                    constraint.endMargin = typedArray.getDimensionPixelSize(index, constraint.endMargin);
                    break;
                case 9:
                    constraint.endToEnd = f(typedArray, index, constraint.endToEnd);
                    break;
                case 10:
                    constraint.endToStart = f(typedArray, index, constraint.endToStart);
                    break;
                case 11:
                    constraint.goneBottomMargin = typedArray.getDimensionPixelSize(index, constraint.goneBottomMargin);
                    break;
                case 12:
                    constraint.goneEndMargin = typedArray.getDimensionPixelSize(index, constraint.goneEndMargin);
                    break;
                case 13:
                    constraint.goneLeftMargin = typedArray.getDimensionPixelSize(index, constraint.goneLeftMargin);
                    break;
                case 14:
                    constraint.goneRightMargin = typedArray.getDimensionPixelSize(index, constraint.goneRightMargin);
                    break;
                case 15:
                    constraint.goneStartMargin = typedArray.getDimensionPixelSize(index, constraint.goneStartMargin);
                    break;
                case 16:
                    constraint.goneTopMargin = typedArray.getDimensionPixelSize(index, constraint.goneTopMargin);
                    break;
                case 17:
                    constraint.guideBegin = typedArray.getDimensionPixelOffset(index, constraint.guideBegin);
                    break;
                case 18:
                    constraint.guideEnd = typedArray.getDimensionPixelOffset(index, constraint.guideEnd);
                    break;
                case 19:
                    constraint.guidePercent = typedArray.getFloat(index, constraint.guidePercent);
                    break;
                case 20:
                    constraint.horizontalBias = typedArray.getFloat(index, constraint.horizontalBias);
                    break;
                case 21:
                    constraint.mHeight = typedArray.getLayoutDimension(index, constraint.mHeight);
                    break;
                case 22:
                    int i4 = typedArray.getInt(index, constraint.visibility);
                    constraint.visibility = i4;
                    constraint.visibility = f1329c[i4];
                    break;
                case 23:
                    constraint.mWidth = typedArray.getLayoutDimension(index, constraint.mWidth);
                    break;
                case 24:
                    constraint.leftMargin = typedArray.getDimensionPixelSize(index, constraint.leftMargin);
                    break;
                case 25:
                    constraint.leftToLeft = f(typedArray, index, constraint.leftToLeft);
                    break;
                case 26:
                    constraint.leftToRight = f(typedArray, index, constraint.leftToRight);
                    break;
                case 27:
                    constraint.orientation = typedArray.getInt(index, constraint.orientation);
                    break;
                case 28:
                    constraint.rightMargin = typedArray.getDimensionPixelSize(index, constraint.rightMargin);
                    break;
                case 29:
                    constraint.rightToLeft = f(typedArray, index, constraint.rightToLeft);
                    break;
                case 30:
                    constraint.rightToRight = f(typedArray, index, constraint.rightToRight);
                    break;
                case 31:
                    constraint.startMargin = typedArray.getDimensionPixelSize(index, constraint.startMargin);
                    break;
                case 32:
                    constraint.startToEnd = f(typedArray, index, constraint.startToEnd);
                    break;
                case 33:
                    constraint.startToStart = f(typedArray, index, constraint.startToStart);
                    break;
                case 34:
                    constraint.topMargin = typedArray.getDimensionPixelSize(index, constraint.topMargin);
                    break;
                case 35:
                    constraint.topToBottom = f(typedArray, index, constraint.topToBottom);
                    break;
                case 36:
                    constraint.topToTop = f(typedArray, index, constraint.topToTop);
                    break;
                case 37:
                    constraint.verticalBias = typedArray.getFloat(index, constraint.verticalBias);
                    break;
                case 38:
                    constraint.f1339c = typedArray.getResourceId(index, constraint.f1339c);
                    break;
                case 39:
                    constraint.horizontalWeight = typedArray.getFloat(index, constraint.horizontalWeight);
                    break;
                case 40:
                    constraint.verticalWeight = typedArray.getFloat(index, constraint.verticalWeight);
                    break;
                case 41:
                    constraint.horizontalChainStyle = typedArray.getInt(index, constraint.horizontalChainStyle);
                    break;
                case 42:
                    constraint.verticalChainStyle = typedArray.getInt(index, constraint.verticalChainStyle);
                    break;
                case 43:
                    constraint.alpha = typedArray.getFloat(index, constraint.alpha);
                    break;
                case 44:
                    constraint.applyElevation = true;
                    constraint.elevation = typedArray.getDimension(index, constraint.elevation);
                    break;
                case 45:
                    constraint.rotationX = typedArray.getFloat(index, constraint.rotationX);
                    break;
                case 46:
                    constraint.rotationY = typedArray.getFloat(index, constraint.rotationY);
                    break;
                case 47:
                    constraint.scaleX = typedArray.getFloat(index, constraint.scaleX);
                    break;
                case 48:
                    constraint.scaleY = typedArray.getFloat(index, constraint.scaleY);
                    break;
                case 49:
                    constraint.transformPivotX = typedArray.getFloat(index, constraint.transformPivotX);
                    break;
                case 50:
                    constraint.transformPivotY = typedArray.getFloat(index, constraint.transformPivotY);
                    break;
                case 51:
                    constraint.translationX = typedArray.getDimension(index, constraint.translationX);
                    break;
                case 52:
                    constraint.translationY = typedArray.getDimension(index, constraint.translationY);
                    break;
                case 53:
                    constraint.translationZ = typedArray.getDimension(index, constraint.translationZ);
                    break;
                default:
                    switch (i3) {
                        case 60:
                            constraint.rotation = typedArray.getFloat(index, constraint.rotation);
                            break;
                        case 61:
                            constraint.circleConstraint = f(typedArray, index, constraint.circleConstraint);
                            break;
                        case 62:
                            constraint.circleRadius = typedArray.getDimensionPixelSize(index, constraint.circleRadius);
                            break;
                        case 63:
                            constraint.circleAngle = typedArray.getFloat(index, constraint.circleAngle);
                            break;
                        default:
                            switch (i3) {
                                case 69:
                                    constraint.widthPercent = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    constraint.heightPercent = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e(f1327a, "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    constraint.mBarrierDirection = typedArray.getInt(index, constraint.mBarrierDirection);
                                    break;
                                case 73:
                                    constraint.mReferenceIdString = typedArray.getString(index);
                                    break;
                                case 74:
                                    constraint.mBarrierAllowsGoneWidgets = typedArray.getBoolean(index, constraint.mBarrierAllowsGoneWidgets);
                                    break;
                                case 75:
                                    Log.w(f1327a, "unused attribute 0x" + Integer.toHexString(index) + "   " + f1331e.get(index));
                                    break;
                                default:
                                    Log.w(f1327a, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f1331e.get(index));
                                    break;
                            }
                    }
            }
        }
    }

    private String h(int i2) {
        switch (i2) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.x0.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (this.x0.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                Constraint constraint = this.x0.get(Integer.valueOf(id));
                if (childAt instanceof Barrier) {
                    constraint.mHelperType = 1;
                }
                int i3 = constraint.mHelperType;
                if (i3 != -1 && i3 == 1) {
                    Barrier barrier = (Barrier) childAt;
                    barrier.setId(id);
                    barrier.setType(constraint.mBarrierDirection);
                    barrier.setAllowsGoneWidget(constraint.mBarrierAllowsGoneWidgets);
                    int[] iArr = constraint.mReferenceIds;
                    if (iArr != null) {
                        barrier.setReferencedIds(iArr);
                    } else {
                        String str = constraint.mReferenceIdString;
                        if (str != null) {
                            int[] b2 = b(barrier, str);
                            constraint.mReferenceIds = b2;
                            barrier.setReferencedIds(b2);
                        }
                    }
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                constraint.applyTo(layoutParams);
                childAt.setLayoutParams(layoutParams);
                childAt.setVisibility(constraint.visibility);
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 17) {
                    childAt.setAlpha(constraint.alpha);
                    childAt.setRotation(constraint.rotation);
                    childAt.setRotationX(constraint.rotationX);
                    childAt.setRotationY(constraint.rotationY);
                    childAt.setScaleX(constraint.scaleX);
                    childAt.setScaleY(constraint.scaleY);
                    if (!Float.isNaN(constraint.transformPivotX)) {
                        childAt.setPivotX(constraint.transformPivotX);
                    }
                    if (!Float.isNaN(constraint.transformPivotY)) {
                        childAt.setPivotY(constraint.transformPivotY);
                    }
                    childAt.setTranslationX(constraint.translationX);
                    childAt.setTranslationY(constraint.translationY);
                    if (i4 >= 21) {
                        childAt.setTranslationZ(constraint.translationZ);
                        if (constraint.applyElevation) {
                            childAt.setElevation(constraint.elevation);
                        }
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = this.x0.get(num);
            int i5 = constraint2.mHelperType;
            if (i5 != -1 && i5 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                int[] iArr2 = constraint2.mReferenceIds;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = constraint2.mReferenceIdString;
                    if (str2 != null) {
                        int[] b3 = b(barrier2, str2);
                        constraint2.mReferenceIds = b3;
                        barrier2.setReferencedIds(b3);
                    }
                }
                barrier2.setType(constraint2.mBarrierDirection);
                ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.validateParams();
                constraint2.applyTo(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (constraint2.f1338b) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                constraint2.applyTo(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public void addToHorizontalChain(int i2, int i3, int i4) {
        connect(i2, 1, i3, i3 == 0 ? 1 : 2, 0);
        connect(i2, 2, i4, i4 == 0 ? 2 : 1, 0);
        if (i3 != 0) {
            connect(i3, 2, i2, 1, 0);
        }
        if (i4 != 0) {
            connect(i4, 1, i2, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int i2, int i3, int i4) {
        connect(i2, 6, i3, i3 == 0 ? 6 : 7, 0);
        connect(i2, 7, i4, i4 == 0 ? 7 : 6, 0);
        if (i3 != 0) {
            connect(i3, 7, i2, 6, 0);
        }
        if (i4 != 0) {
            connect(i4, 6, i2, 7, 0);
        }
    }

    public void addToVerticalChain(int i2, int i3, int i4) {
        connect(i2, 3, i3, i3 == 0 ? 3 : 4, 0);
        connect(i2, 4, i4, i4 == 0 ? 4 : 3, 0);
        if (i3 != 0) {
            connect(i3, 4, i2, 3, 0);
        }
        if (i3 != 0) {
            connect(i4, 3, i2, 4, 0);
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        a(constraintLayout);
        constraintLayout.setConstraintSet(null);
    }

    public void center(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2) {
        if (i5 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (i8 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (f2 <= 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (i4 == 1 || i4 == 2) {
            connect(i2, 1, i3, i4, i5);
            connect(i2, 2, i6, i7, i8);
            this.x0.get(Integer.valueOf(i2)).horizontalBias = f2;
        } else if (i4 == 6 || i4 == 7) {
            connect(i2, 6, i3, i4, i5);
            connect(i2, 7, i6, i7, i8);
            this.x0.get(Integer.valueOf(i2)).horizontalBias = f2;
        } else {
            connect(i2, 3, i3, i4, i5);
            connect(i2, 4, i6, i7, i8);
            this.x0.get(Integer.valueOf(i2)).verticalBias = f2;
        }
    }

    public void centerHorizontally(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2) {
        connect(i2, 1, i3, i4, i5);
        connect(i2, 2, i6, i7, i8);
        this.x0.get(Integer.valueOf(i2)).horizontalBias = f2;
    }

    public void centerHorizontallyRtl(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2) {
        connect(i2, 6, i3, i4, i5);
        connect(i2, 7, i6, i7, i8);
        this.x0.get(Integer.valueOf(i2)).horizontalBias = f2;
    }

    public void centerVertically(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2) {
        connect(i2, 3, i3, i4, i5);
        connect(i2, 4, i6, i7, i8);
        this.x0.get(Integer.valueOf(i2)).verticalBias = f2;
    }

    public void clear(int i2) {
        this.x0.remove(Integer.valueOf(i2));
    }

    public void clone(Context context, int i2) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(i2, (ViewGroup) null));
    }

    public void connect(int i2, int i3, int i4, int i5, int i6) {
        if (!this.x0.containsKey(Integer.valueOf(i2))) {
            this.x0.put(Integer.valueOf(i2), new Constraint());
        }
        Constraint constraint = this.x0.get(Integer.valueOf(i2));
        switch (i3) {
            case 1:
                if (i5 == 1) {
                    constraint.leftToLeft = i4;
                    constraint.leftToRight = -1;
                } else {
                    if (i5 != 2) {
                        throw new IllegalArgumentException("Left to " + h(i5) + " undefined");
                    }
                    constraint.leftToRight = i4;
                    constraint.leftToLeft = -1;
                }
                constraint.leftMargin = i6;
                return;
            case 2:
                if (i5 == 1) {
                    constraint.rightToLeft = i4;
                    constraint.rightToRight = -1;
                } else {
                    if (i5 != 2) {
                        throw new IllegalArgumentException("right to " + h(i5) + " undefined");
                    }
                    constraint.rightToRight = i4;
                    constraint.rightToLeft = -1;
                }
                constraint.rightMargin = i6;
                return;
            case 3:
                if (i5 == 3) {
                    constraint.topToTop = i4;
                    constraint.topToBottom = -1;
                    constraint.baselineToBaseline = -1;
                } else {
                    if (i5 != 4) {
                        throw new IllegalArgumentException("right to " + h(i5) + " undefined");
                    }
                    constraint.topToBottom = i4;
                    constraint.topToTop = -1;
                    constraint.baselineToBaseline = -1;
                }
                constraint.topMargin = i6;
                return;
            case 4:
                if (i5 == 4) {
                    constraint.bottomToBottom = i4;
                    constraint.bottomToTop = -1;
                    constraint.baselineToBaseline = -1;
                } else {
                    if (i5 != 3) {
                        throw new IllegalArgumentException("right to " + h(i5) + " undefined");
                    }
                    constraint.bottomToTop = i4;
                    constraint.bottomToBottom = -1;
                    constraint.baselineToBaseline = -1;
                }
                constraint.bottomMargin = i6;
                return;
            case 5:
                if (i5 != 5) {
                    throw new IllegalArgumentException("right to " + h(i5) + " undefined");
                }
                constraint.baselineToBaseline = i4;
                constraint.bottomToBottom = -1;
                constraint.bottomToTop = -1;
                constraint.topToTop = -1;
                constraint.topToBottom = -1;
                return;
            case 6:
                if (i5 == 6) {
                    constraint.startToStart = i4;
                    constraint.startToEnd = -1;
                } else {
                    if (i5 != 7) {
                        throw new IllegalArgumentException("right to " + h(i5) + " undefined");
                    }
                    constraint.startToEnd = i4;
                    constraint.startToStart = -1;
                }
                constraint.startMargin = i6;
                return;
            case 7:
                if (i5 == 7) {
                    constraint.endToEnd = i4;
                    constraint.endToStart = -1;
                } else {
                    if (i5 != 6) {
                        throw new IllegalArgumentException("right to " + h(i5) + " undefined");
                    }
                    constraint.endToStart = i4;
                    constraint.endToEnd = -1;
                }
                constraint.endMargin = i6;
                return;
            default:
                throw new IllegalArgumentException(h(i3) + " to " + h(i5) + " unknown");
        }
    }

    public void constrainCircle(int i2, int i3, int i4, float f2) {
        Constraint e2 = e(i2);
        e2.circleConstraint = i3;
        e2.circleRadius = i4;
        e2.circleAngle = f2;
    }

    public void constrainDefaultHeight(int i2, int i3) {
        e(i2).heightDefault = i3;
    }

    public void constrainDefaultWidth(int i2, int i3) {
        e(i2).widthDefault = i3;
    }

    public void constrainHeight(int i2, int i3) {
        e(i2).mHeight = i3;
    }

    public void constrainMaxHeight(int i2, int i3) {
        e(i2).heightMax = i3;
    }

    public void constrainMaxWidth(int i2, int i3) {
        e(i2).widthMax = i3;
    }

    public void constrainMinHeight(int i2, int i3) {
        e(i2).heightMin = i3;
    }

    public void constrainMinWidth(int i2, int i3) {
        e(i2).widthMin = i3;
    }

    public void constrainPercentHeight(int i2, float f2) {
        e(i2).heightPercent = f2;
    }

    public void constrainPercentWidth(int i2, float f2) {
        e(i2).widthPercent = f2;
    }

    public void constrainWidth(int i2, int i3) {
        e(i2).mWidth = i3;
    }

    public void create(int i2, int i3) {
        Constraint e2 = e(i2);
        e2.f1338b = true;
        e2.orientation = i3;
    }

    public void createBarrier(int i2, int i3, int... iArr) {
        Constraint e2 = e(i2);
        e2.mHelperType = 1;
        e2.mBarrierDirection = i3;
        e2.f1338b = false;
        e2.mReferenceIds = iArr;
    }

    public void createHorizontalChain(int i2, int i3, int i4, int i5, int[] iArr, float[] fArr, int i6) {
        c(i2, i3, i4, i5, iArr, fArr, i6, 1, 2);
    }

    public void createHorizontalChainRtl(int i2, int i3, int i4, int i5, int[] iArr, float[] fArr, int i6) {
        c(i2, i3, i4, i5, iArr, fArr, i6, 6, 7);
    }

    public void createVerticalChain(int i2, int i3, int i4, int i5, int[] iArr, float[] fArr, int i6) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null && fArr.length != iArr.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null) {
            e(iArr[0]).verticalWeight = fArr[0];
        }
        e(iArr[0]).verticalChainStyle = i6;
        connect(iArr[0], 3, i2, i3, 0);
        for (int i7 = 1; i7 < iArr.length; i7++) {
            int i8 = iArr[i7];
            int i9 = i7 - 1;
            connect(iArr[i7], 3, iArr[i9], 4, 0);
            connect(iArr[i9], 4, iArr[i7], 3, 0);
            if (fArr != null) {
                e(iArr[i7]).verticalWeight = fArr[i7];
            }
        }
        connect(iArr[iArr.length - 1], 4, i4, i5, 0);
    }

    public boolean getApplyElevation(int i2) {
        return e(i2).applyElevation;
    }

    public Constraint getParameters(int i2) {
        return e(i2);
    }

    public void load(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint d2 = d(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        d2.f1338b = true;
                    }
                    this.x0.put(Integer.valueOf(d2.f1339c), d2);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    public void removeFromHorizontalChain(int i2) {
        if (this.x0.containsKey(Integer.valueOf(i2))) {
            Constraint constraint = this.x0.get(Integer.valueOf(i2));
            int i3 = constraint.leftToRight;
            int i4 = constraint.rightToLeft;
            if (i3 != -1 || i4 != -1) {
                if (i3 != -1 && i4 != -1) {
                    connect(i3, 2, i4, 1, 0);
                    connect(i4, 1, i3, 2, 0);
                } else if (i3 != -1 || i4 != -1) {
                    int i5 = constraint.rightToRight;
                    if (i5 != -1) {
                        connect(i3, 2, i5, 2, 0);
                    } else {
                        int i6 = constraint.leftToLeft;
                        if (i6 != -1) {
                            connect(i4, 1, i6, 1, 0);
                        }
                    }
                }
                clear(i2, 1);
                clear(i2, 2);
                return;
            }
            int i7 = constraint.startToEnd;
            int i8 = constraint.endToStart;
            if (i7 != -1 || i8 != -1) {
                if (i7 != -1 && i8 != -1) {
                    connect(i7, 7, i8, 6, 0);
                    connect(i8, 6, i3, 7, 0);
                } else if (i3 != -1 || i8 != -1) {
                    int i9 = constraint.rightToRight;
                    if (i9 != -1) {
                        connect(i3, 7, i9, 7, 0);
                    } else {
                        int i10 = constraint.leftToLeft;
                        if (i10 != -1) {
                            connect(i8, 6, i10, 6, 0);
                        }
                    }
                }
            }
            clear(i2, 6);
            clear(i2, 7);
        }
    }

    public void removeFromVerticalChain(int i2) {
        if (this.x0.containsKey(Integer.valueOf(i2))) {
            Constraint constraint = this.x0.get(Integer.valueOf(i2));
            int i3 = constraint.topToBottom;
            int i4 = constraint.bottomToTop;
            if (i3 != -1 || i4 != -1) {
                if (i3 != -1 && i4 != -1) {
                    connect(i3, 4, i4, 3, 0);
                    connect(i4, 3, i3, 4, 0);
                } else if (i3 != -1 || i4 != -1) {
                    int i5 = constraint.bottomToBottom;
                    if (i5 != -1) {
                        connect(i3, 4, i5, 4, 0);
                    } else {
                        int i6 = constraint.topToTop;
                        if (i6 != -1) {
                            connect(i4, 3, i6, 3, 0);
                        }
                    }
                }
            }
        }
        clear(i2, 3);
        clear(i2, 4);
    }

    public void setAlpha(int i2, float f2) {
        e(i2).alpha = f2;
    }

    public void setApplyElevation(int i2, boolean z2) {
        e(i2).applyElevation = z2;
    }

    public void setBarrierType(int i2, int i3) {
    }

    public void setDimensionRatio(int i2, String str) {
        e(i2).dimensionRatio = str;
    }

    public void setElevation(int i2, float f2) {
        e(i2).elevation = f2;
        e(i2).applyElevation = true;
    }

    public void setGoneMargin(int i2, int i3, int i4) {
        Constraint e2 = e(i2);
        switch (i3) {
            case 1:
                e2.goneLeftMargin = i4;
                return;
            case 2:
                e2.goneRightMargin = i4;
                return;
            case 3:
                e2.goneTopMargin = i4;
                return;
            case 4:
                e2.goneBottomMargin = i4;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                e2.goneStartMargin = i4;
                return;
            case 7:
                e2.goneEndMargin = i4;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setGuidelineBegin(int i2, int i3) {
        e(i2).guideBegin = i3;
        e(i2).guideEnd = -1;
        e(i2).guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int i2, int i3) {
        e(i2).guideEnd = i3;
        e(i2).guideBegin = -1;
        e(i2).guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int i2, float f2) {
        e(i2).guidePercent = f2;
        e(i2).guideEnd = -1;
        e(i2).guideBegin = -1;
    }

    public void setHorizontalBias(int i2, float f2) {
        e(i2).horizontalBias = f2;
    }

    public void setHorizontalChainStyle(int i2, int i3) {
        e(i2).horizontalChainStyle = i3;
    }

    public void setHorizontalWeight(int i2, float f2) {
        e(i2).horizontalWeight = f2;
    }

    public void setMargin(int i2, int i3, int i4) {
        Constraint e2 = e(i2);
        switch (i3) {
            case 1:
                e2.leftMargin = i4;
                return;
            case 2:
                e2.rightMargin = i4;
                return;
            case 3:
                e2.topMargin = i4;
                return;
            case 4:
                e2.bottomMargin = i4;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                e2.startMargin = i4;
                return;
            case 7:
                e2.endMargin = i4;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setRotation(int i2, float f2) {
        e(i2).rotation = f2;
    }

    public void setRotationX(int i2, float f2) {
        e(i2).rotationX = f2;
    }

    public void setRotationY(int i2, float f2) {
        e(i2).rotationY = f2;
    }

    public void setScaleX(int i2, float f2) {
        e(i2).scaleX = f2;
    }

    public void setScaleY(int i2, float f2) {
        e(i2).scaleY = f2;
    }

    public void setTransformPivot(int i2, float f2, float f3) {
        Constraint e2 = e(i2);
        e2.transformPivotY = f3;
        e2.transformPivotX = f2;
    }

    public void setTransformPivotX(int i2, float f2) {
        e(i2).transformPivotX = f2;
    }

    public void setTransformPivotY(int i2, float f2) {
        e(i2).transformPivotY = f2;
    }

    public void setTranslation(int i2, float f2, float f3) {
        Constraint e2 = e(i2);
        e2.translationX = f2;
        e2.translationY = f3;
    }

    public void setTranslationX(int i2, float f2) {
        e(i2).translationX = f2;
    }

    public void setTranslationY(int i2, float f2) {
        e(i2).translationY = f2;
    }

    public void setTranslationZ(int i2, float f2) {
        e(i2).translationZ = f2;
    }

    public void setVerticalBias(int i2, float f2) {
        e(i2).verticalBias = f2;
    }

    public void setVerticalChainStyle(int i2, int i3) {
        e(i2).verticalChainStyle = i3;
    }

    public void setVerticalWeight(int i2, float f2) {
        e(i2).verticalWeight = f2;
    }

    public void setVisibility(int i2, int i3) {
        e(i2).visibility = i3;
    }

    public void clear(int i2, int i3) {
        if (this.x0.containsKey(Integer.valueOf(i2))) {
            Constraint constraint = this.x0.get(Integer.valueOf(i2));
            switch (i3) {
                case 1:
                    constraint.leftToRight = -1;
                    constraint.leftToLeft = -1;
                    constraint.leftMargin = -1;
                    constraint.goneLeftMargin = -1;
                    return;
                case 2:
                    constraint.rightToRight = -1;
                    constraint.rightToLeft = -1;
                    constraint.rightMargin = -1;
                    constraint.goneRightMargin = -1;
                    return;
                case 3:
                    constraint.topToBottom = -1;
                    constraint.topToTop = -1;
                    constraint.topMargin = -1;
                    constraint.goneTopMargin = -1;
                    return;
                case 4:
                    constraint.bottomToTop = -1;
                    constraint.bottomToBottom = -1;
                    constraint.bottomMargin = -1;
                    constraint.goneBottomMargin = -1;
                    return;
                case 5:
                    constraint.baselineToBaseline = -1;
                    return;
                case 6:
                    constraint.startToEnd = -1;
                    constraint.startToStart = -1;
                    constraint.startMargin = -1;
                    constraint.goneStartMargin = -1;
                    return;
                case 7:
                    constraint.endToStart = -1;
                    constraint.endToEnd = -1;
                    constraint.endMargin = -1;
                    constraint.goneEndMargin = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void clone(ConstraintSet constraintSet) {
        this.x0.clear();
        for (Integer num : constraintSet.x0.keySet()) {
            this.x0.put(num, constraintSet.x0.get(num).m32clone());
        }
    }

    public void centerHorizontally(int i2, int i3) {
        if (i3 == 0) {
            center(i2, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i2, i3, 2, 0, i3, 1, 0, 0.5f);
        }
    }

    public void centerHorizontallyRtl(int i2, int i3) {
        if (i3 == 0) {
            center(i2, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i2, i3, 7, 0, i3, 6, 0, 0.5f);
        }
    }

    public void centerVertically(int i2, int i3) {
        if (i3 == 0) {
            center(i2, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i2, i3, 4, 0, i3, 3, 0, 0.5f);
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.x0.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id != -1) {
                if (!this.x0.containsKey(Integer.valueOf(id))) {
                    this.x0.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.x0.get(Integer.valueOf(id));
                constraint.d(id, layoutParams);
                constraint.visibility = childAt.getVisibility();
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 17) {
                    constraint.alpha = childAt.getAlpha();
                    constraint.rotation = childAt.getRotation();
                    constraint.rotationX = childAt.getRotationX();
                    constraint.rotationY = childAt.getRotationY();
                    constraint.scaleX = childAt.getScaleX();
                    constraint.scaleY = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        constraint.transformPivotX = pivotX;
                        constraint.transformPivotY = pivotY;
                    }
                    constraint.translationX = childAt.getTranslationX();
                    constraint.translationY = childAt.getTranslationY();
                    if (i3 >= 21) {
                        constraint.translationZ = childAt.getTranslationZ();
                        if (constraint.applyElevation) {
                            constraint.elevation = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    constraint.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                    constraint.mReferenceIds = barrier.getReferencedIds();
                    constraint.mBarrierDirection = barrier.getType();
                }
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void clone(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.x0.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraints.getChildAt(i2);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id != -1) {
                if (!this.x0.containsKey(Integer.valueOf(id))) {
                    this.x0.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.x0.get(Integer.valueOf(id));
                if (childAt instanceof ConstraintHelper) {
                    constraint.f((ConstraintHelper) childAt, id, layoutParams);
                }
                constraint.e(id, layoutParams);
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void connect(int i2, int i3, int i4, int i5) {
        if (!this.x0.containsKey(Integer.valueOf(i2))) {
            this.x0.put(Integer.valueOf(i2), new Constraint());
        }
        Constraint constraint = this.x0.get(Integer.valueOf(i2));
        switch (i3) {
            case 1:
                if (i5 == 1) {
                    constraint.leftToLeft = i4;
                    constraint.leftToRight = -1;
                    return;
                } else if (i5 == 2) {
                    constraint.leftToRight = i4;
                    constraint.leftToLeft = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + h(i5) + " undefined");
                }
            case 2:
                if (i5 == 1) {
                    constraint.rightToLeft = i4;
                    constraint.rightToRight = -1;
                    return;
                } else if (i5 == 2) {
                    constraint.rightToRight = i4;
                    constraint.rightToLeft = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + h(i5) + " undefined");
                }
            case 3:
                if (i5 == 3) {
                    constraint.topToTop = i4;
                    constraint.topToBottom = -1;
                    constraint.baselineToBaseline = -1;
                    return;
                } else if (i5 == 4) {
                    constraint.topToBottom = i4;
                    constraint.topToTop = -1;
                    constraint.baselineToBaseline = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + h(i5) + " undefined");
                }
            case 4:
                if (i5 == 4) {
                    constraint.bottomToBottom = i4;
                    constraint.bottomToTop = -1;
                    constraint.baselineToBaseline = -1;
                    return;
                } else if (i5 == 3) {
                    constraint.bottomToTop = i4;
                    constraint.bottomToBottom = -1;
                    constraint.baselineToBaseline = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + h(i5) + " undefined");
                }
            case 5:
                if (i5 == 5) {
                    constraint.baselineToBaseline = i4;
                    constraint.bottomToBottom = -1;
                    constraint.bottomToTop = -1;
                    constraint.topToTop = -1;
                    constraint.topToBottom = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + h(i5) + " undefined");
            case 6:
                if (i5 == 6) {
                    constraint.startToStart = i4;
                    constraint.startToEnd = -1;
                    return;
                } else if (i5 == 7) {
                    constraint.startToEnd = i4;
                    constraint.startToStart = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + h(i5) + " undefined");
                }
            case 7:
                if (i5 == 7) {
                    constraint.endToEnd = i4;
                    constraint.endToStart = -1;
                    return;
                } else if (i5 == 6) {
                    constraint.endToStart = i4;
                    constraint.endToEnd = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + h(i5) + " undefined");
                }
            default:
                throw new IllegalArgumentException(h(i3) + " to " + h(i5) + " unknown");
        }
    }
}
