package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import id.c;
import java.util.Map;

/* loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private boolean mReparent;
    private boolean mResizeClip;
    private int[] mTempLocation;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final String[] sTransitionProperties = {PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
    private static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") { // from class: androidx.transition.ChangeBounds.1
        private Rect mBounds = new Rect();

        public AnonymousClass1(Class cls, String str) {
            super(cls, str);
            this.mBounds = new Rect();
        }

        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.mBounds);
            Rect rect = this.mBounds;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.mBounds);
            this.mBounds.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.mBounds);
        }
    };
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.ChangeBounds.2
        public AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.setTopLeft(pointF);
        }
    };
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.ChangeBounds.3
        public AnonymousClass3(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.setBottomRight(pointF);
        }
    };
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.ChangeBounds.4
        public AnonymousClass4(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.ChangeBounds.5
        public AnonymousClass5(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            ViewUtils.setLeftTopRightBottom(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> POSITION_PROPERTY = new Property<View, PointF>(PointF.class, c.f26972i) { // from class: androidx.transition.ChangeBounds.6
        public AnonymousClass6(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            ViewUtils.setLeftTopRightBottom(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    private static RectEvaluator sRectEvaluator = new RectEvaluator();

    /* renamed from: androidx.transition.ChangeBounds$1 */
    public static class AnonymousClass1 extends Property<Drawable, PointF> {
        private Rect mBounds = new Rect();

        public AnonymousClass1(Class cls, String str) {
            super(cls, str);
            this.mBounds = new Rect();
        }

        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.mBounds);
            Rect rect = this.mBounds;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.mBounds);
            this.mBounds.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.mBounds);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$10 */
    public class AnonymousClass10 extends AnimatorListenerAdapter {
        final /* synthetic */ BitmapDrawable val$drawable;
        final /* synthetic */ ViewGroup val$sceneRoot;
        final /* synthetic */ float val$transitionAlpha;
        final /* synthetic */ View val$view;

        public AnonymousClass10(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f10) {
            viewGroup = viewGroup;
            bitmapDrawable = bitmapDrawable;
            view2 = view;
            transitionAlpha = f10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewUtils.getOverlay(viewGroup).remove(bitmapDrawable);
            ViewUtils.setTransitionAlpha(view2, transitionAlpha);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$2 */
    public static class AnonymousClass2 extends Property<ViewBounds, PointF> {
        public AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.setTopLeft(pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$3 */
    public static class AnonymousClass3 extends Property<ViewBounds, PointF> {
        public AnonymousClass3(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.setBottomRight(pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$4 */
    public static class AnonymousClass4 extends Property<View, PointF> {
        public AnonymousClass4(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$5 */
    public static class AnonymousClass5 extends Property<View, PointF> {
        public AnonymousClass5(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            ViewUtils.setLeftTopRightBottom(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$6 */
    public static class AnonymousClass6 extends Property<View, PointF> {
        public AnonymousClass6(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            ViewUtils.setLeftTopRightBottom(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$7 */
    public class AnonymousClass7 extends AnimatorListenerAdapter {
        private ViewBounds mViewBounds;
        final /* synthetic */ ViewBounds val$viewBounds;

        public AnonymousClass7(ViewBounds viewBounds) {
            this.val$viewBounds = viewBounds;
            this.mViewBounds = viewBounds;
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$8 */
    public class AnonymousClass8 extends AnimatorListenerAdapter {
        private boolean mIsCanceled;
        final /* synthetic */ int val$endBottom;
        final /* synthetic */ int val$endLeft;
        final /* synthetic */ int val$endRight;
        final /* synthetic */ int val$endTop;
        final /* synthetic */ Rect val$finalClip;
        final /* synthetic */ View val$view;

        public AnonymousClass8(View view, Rect rect, int i10, int i11, int i12, int i13) {
            view = view;
            rect4 = rect;
            i15 = i10;
            i17 = i11;
            i19 = i12;
            i21 = i13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.mIsCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.mIsCanceled) {
                return;
            }
            ViewCompat.setClipBounds(view, rect4);
            ViewUtils.setLeftTopRightBottom(view, i15, i17, i19, i21);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$9 */
    public class AnonymousClass9 extends TransitionListenerAdapter {
        boolean mCanceled = false;
        final /* synthetic */ ViewGroup val$parent;

        public AnonymousClass9(ViewGroup viewGroup) {
            viewGroup4 = viewGroup;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition transition) {
            ViewGroupUtils.suppressLayout(viewGroup4, false);
            this.mCanceled = true;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            if (!this.mCanceled) {
                ViewGroupUtils.suppressLayout(viewGroup4, false);
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
            ViewGroupUtils.suppressLayout(viewGroup4, false);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
            ViewGroupUtils.suppressLayout(viewGroup4, true);
        }
    }

    public static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private View mView;

        public ViewBounds(View view) {
            this.mView = view;
        }

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        public void setBottomRight(PointF pointF) {
            this.mRight = Math.round(pointF.x);
            this.mBottom = Math.round(pointF.y);
            int i10 = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = i10;
            if (this.mTopLeftCalls == i10) {
                setLeftTopRightBottom();
            }
        }

        public void setTopLeft(PointF pointF) {
            this.mLeft = Math.round(pointF.x);
            this.mTop = Math.round(pointF.y);
            int i10 = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = i10;
            if (i10 == this.mBottomRightCalls) {
                setLeftTopRightBottom();
            }
        }
    }

    public ChangeBounds() {
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (!ViewCompat.isLaidOut(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        transitionValues.values.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        if (this.mReparent) {
            transitionValues.view.getLocationInWindow(this.mTempLocation);
            transitionValues.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.mTempLocation[0]));
            transitionValues.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.mTempLocation[1]));
        }
        if (this.mResizeClip) {
            transitionValues.values.put(PROPNAME_CLIP, ViewCompat.getClipBounds(view));
        }
    }

    private boolean parentMatches(View view, View view2) {
        if (!this.mReparent) {
            return true;
        }
        TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.view) {
            return true;
        }
        return false;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i10;
        View view;
        int i11;
        ObjectAnimator objectAnimator;
        Animator mergeAnimators;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get(PROPNAME_PARENT);
        ViewGroup viewGroup3 = (ViewGroup) map2.get(PROPNAME_PARENT);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = transitionValues2.view;
        if (!parentMatches(viewGroup2, viewGroup3)) {
            int intValue = ((Integer) transitionValues.values.get(PROPNAME_WINDOW_X)).intValue();
            int intValue2 = ((Integer) transitionValues.values.get(PROPNAME_WINDOW_Y)).intValue();
            int intValue3 = ((Integer) transitionValues2.values.get(PROPNAME_WINDOW_X)).intValue();
            int intValue4 = ((Integer) transitionValues2.values.get(PROPNAME_WINDOW_Y)).intValue();
            if (intValue == intValue3 && intValue2 == intValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.mTempLocation);
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(createBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            float transitionAlpha = ViewUtils.getTransitionAlpha(view2);
            ViewUtils.setTransitionAlpha(view2, 0.0f);
            ViewUtils.getOverlay(viewGroup).add(bitmapDrawable);
            PathMotion pathMotion = getPathMotion();
            int[] iArr = this.mTempLocation;
            int i12 = iArr[0];
            int i13 = iArr[1];
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, pathMotion.getPath(intValue - i12, intValue2 - i13, intValue3 - i12, intValue4 - i13)));
            ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.10
                final /* synthetic */ BitmapDrawable val$drawable;
                final /* synthetic */ ViewGroup val$sceneRoot;
                final /* synthetic */ float val$transitionAlpha;
                final /* synthetic */ View val$view;

                public AnonymousClass10(ViewGroup viewGroup4, BitmapDrawable bitmapDrawable2, View view22, float transitionAlpha2) {
                    viewGroup = viewGroup4;
                    bitmapDrawable = bitmapDrawable2;
                    view2 = view22;
                    transitionAlpha = transitionAlpha2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ViewUtils.getOverlay(viewGroup).remove(bitmapDrawable);
                    ViewUtils.setTransitionAlpha(view2, transitionAlpha);
                }
            });
            return ofPropertyValuesHolder;
        }
        Rect rect = (Rect) transitionValues.values.get(PROPNAME_BOUNDS);
        Rect rect2 = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
        int i14 = rect.left;
        int i15 = rect2.left;
        int i16 = rect.top;
        int i17 = rect2.top;
        int i18 = rect.right;
        int i19 = rect2.right;
        int i20 = rect.bottom;
        int i21 = rect2.bottom;
        int i22 = i18 - i14;
        int i23 = i20 - i16;
        int i24 = i19 - i15;
        int i25 = i21 - i17;
        Rect rect3 = (Rect) transitionValues.values.get(PROPNAME_CLIP);
        Rect rect4 = (Rect) transitionValues2.values.get(PROPNAME_CLIP);
        if ((i22 == 0 || i23 == 0) && (i24 == 0 || i25 == 0)) {
            i10 = 0;
        } else {
            i10 = (i14 == i15 && i16 == i17) ? 0 : 1;
            if (i18 != i19 || i20 != i21) {
                i10++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i10++;
        }
        if (i10 <= 0) {
            return null;
        }
        if (this.mResizeClip) {
            view = view22;
            ViewUtils.setLeftTopRightBottom(view, i14, i16, Math.max(i22, i24) + i14, Math.max(i23, i25) + i16);
            ObjectAnimator ofPointF = (i14 == i15 && i16 == i17) ? null : ObjectAnimatorUtils.ofPointF(view, POSITION_PROPERTY, getPathMotion().getPath(i14, i16, i15, i17));
            if (rect3 == null) {
                i11 = 0;
                rect3 = new Rect(0, 0, i22, i23);
            } else {
                i11 = 0;
            }
            Rect rect5 = rect4 == null ? new Rect(i11, i11, i24, i25) : rect4;
            if (rect3.equals(rect5)) {
                objectAnimator = null;
            } else {
                ViewCompat.setClipBounds(view, rect3);
                RectEvaluator rectEvaluator = sRectEvaluator;
                Object[] objArr = new Object[2];
                objArr[i11] = rect3;
                objArr[1] = rect5;
                ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", rectEvaluator, objArr);
                ofObject.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.8
                    private boolean mIsCanceled;
                    final /* synthetic */ int val$endBottom;
                    final /* synthetic */ int val$endLeft;
                    final /* synthetic */ int val$endRight;
                    final /* synthetic */ int val$endTop;
                    final /* synthetic */ Rect val$finalClip;
                    final /* synthetic */ View val$view;

                    public AnonymousClass8(View view3, Rect rect42, int i152, int i172, int i192, int i212) {
                        view = view3;
                        rect4 = rect42;
                        i15 = i152;
                        i17 = i172;
                        i19 = i192;
                        i21 = i212;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        this.mIsCanceled = true;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (this.mIsCanceled) {
                            return;
                        }
                        ViewCompat.setClipBounds(view, rect4);
                        ViewUtils.setLeftTopRightBottom(view, i15, i17, i19, i21);
                    }
                });
                objectAnimator = ofObject;
            }
            mergeAnimators = TransitionUtils.mergeAnimators(ofPointF, objectAnimator);
        } else {
            view3 = view22;
            ViewUtils.setLeftTopRightBottom(view3, i14, i16, i18, i20);
            if (i10 != 2) {
                mergeAnimators = (i14 == i152 && i16 == i172) ? ObjectAnimatorUtils.ofPointF(view3, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath(i18, i20, i192, i212)) : ObjectAnimatorUtils.ofPointF(view3, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath(i14, i16, i152, i172));
            } else if (i22 == i24 && i23 == i25) {
                mergeAnimators = ObjectAnimatorUtils.ofPointF(view3, POSITION_PROPERTY, getPathMotion().getPath(i14, i16, i152, i172));
            } else {
                ViewBounds viewBounds = new ViewBounds(view3);
                ObjectAnimator ofPointF2 = ObjectAnimatorUtils.ofPointF(viewBounds, TOP_LEFT_PROPERTY, getPathMotion().getPath(i14, i16, i152, i172));
                ObjectAnimator ofPointF3 = ObjectAnimatorUtils.ofPointF(viewBounds, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(i18, i20, i192, i212));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofPointF2, ofPointF3);
                animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) { // from class: androidx.transition.ChangeBounds.7
                    private ViewBounds mViewBounds;
                    final /* synthetic */ ViewBounds val$viewBounds;

                    public AnonymousClass7(ViewBounds viewBounds2) {
                        this.val$viewBounds = viewBounds2;
                        this.mViewBounds = viewBounds2;
                    }
                });
                mergeAnimators = animatorSet;
            }
        }
        if (view3.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view3.getParent();
            ViewGroupUtils.suppressLayout(viewGroup4, true);
            addListener(new TransitionListenerAdapter() { // from class: androidx.transition.ChangeBounds.9
                boolean mCanceled = false;
                final /* synthetic */ ViewGroup val$parent;

                public AnonymousClass9(ViewGroup viewGroup42) {
                    viewGroup4 = viewGroup42;
                }

                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionCancel(@NonNull Transition transition) {
                    ViewGroupUtils.suppressLayout(viewGroup4, false);
                    this.mCanceled = true;
                }

                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionEnd(@NonNull Transition transition) {
                    if (!this.mCanceled) {
                        ViewGroupUtils.suppressLayout(viewGroup4, false);
                    }
                    transition.removeListener(this);
                }

                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionPause(@NonNull Transition transition) {
                    ViewGroupUtils.suppressLayout(viewGroup4, false);
                }

                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionResume(@NonNull Transition transition) {
                    ViewGroupUtils.suppressLayout(viewGroup4, true);
                }
            });
        }
        return mergeAnimators;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean z10) {
        this.mResizeClip = z10;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.CHANGE_BOUNDS);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }
}
