package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.transition.TransitionUtils;
import java.util.Map;

/* loaded from: classes.dex */
public class ChangeImageTransform extends Transition {
    private static final String S = "android:changeImageTransform:matrix";
    private static final String T = "android:changeImageTransform:bounds";
    private static final String[] U = {S, T};
    private static final TypeEvaluator<Matrix> V = new TypeEvaluator<Matrix>() { // from class: androidx.transition.ChangeImageTransform.1
        AnonymousClass1() {
        }

        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            return null;
        }
    };
    private static final Property<ImageView, Matrix> W = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") { // from class: androidx.transition.ChangeImageTransform.2
        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        public void set(ImageView imageView, Matrix matrix) {
            ImageViewUtils.a(imageView, matrix);
        }
    };

    /* renamed from: androidx.transition.ChangeImageTransform$1 */
    static class AnonymousClass1 implements TypeEvaluator<Matrix> {
        AnonymousClass1() {
        }

        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            return null;
        }
    }

    /* renamed from: androidx.transition.ChangeImageTransform$2 */
    static class AnonymousClass2 extends Property<ImageView, Matrix> {
        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        public void set(ImageView imageView, Matrix matrix) {
            ImageViewUtils.a(imageView, matrix);
        }
    }

    /* renamed from: androidx.transition.ChangeImageTransform$3 */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a */
        static final /* synthetic */ int[] f3717a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f3717a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3717a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ChangeImageTransform() {
    }

    private void H(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = transitionValues.values;
            map.put(T, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            map.put(S, J(imageView));
        }
    }

    private static Matrix I(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f2 = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f3 = intrinsicHeight;
        float max = Math.max(width / f2, height / f3);
        int round = Math.round((width - (f2 * max)) / 2.0f);
        int round2 = Math.round((height - (f3 * max)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        matrix.postTranslate(round, round2);
        return matrix;
    }

    @NonNull
    private static Matrix J(@NonNull ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            int i2 = AnonymousClass3.f3717a[imageView.getScaleType().ordinal()];
            if (i2 == 1) {
                return M(imageView);
            }
            if (i2 == 2) {
                return I(imageView);
            }
        }
        return new Matrix(imageView.getImageMatrix());
    }

    private ObjectAnimator K(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) W, (TypeEvaluator) new TransitionUtils.MatrixEvaluator(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    @NonNull
    private ObjectAnimator L(@NonNull ImageView imageView) {
        Property<ImageView, Matrix> property = W;
        TypeEvaluator<Matrix> typeEvaluator = V;
        Matrix matrix = MatrixUtils.f3785a;
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, (TypeEvaluator) typeEvaluator, (Object[]) new Matrix[]{matrix, matrix});
    }

    private static Matrix M(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        H(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        H(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.values.get(T);
        Rect rect2 = (Rect) transitionValues2.values.get(T);
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) transitionValues.values.get(S);
        Matrix matrix2 = (Matrix) transitionValues2.values.get(S);
        boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z) {
            return null;
        }
        ImageView imageView = (ImageView) transitionValues2.view;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return L(imageView);
        }
        if (matrix == null) {
            matrix = MatrixUtils.f3785a;
        }
        if (matrix2 == null) {
            matrix2 = MatrixUtils.f3785a;
        }
        W.set(imageView, matrix);
        return K(imageView, matrix, matrix2);
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return U;
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
