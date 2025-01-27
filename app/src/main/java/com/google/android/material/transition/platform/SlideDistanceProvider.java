package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
/* loaded from: classes2.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;

    @Px
    private int slideDistance = -1;
    private int slideEdge;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i10) {
        this.slideEdge = i10;
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int i10, @Px int i11) {
        if (i10 == 3) {
            return createTranslationXAnimator(view2, i11, 0.0f);
        }
        if (i10 == 5) {
            return createTranslationXAnimator(view2, -i11, 0.0f);
        }
        if (i10 == 48) {
            return createTranslationYAnimator(view2, -i11, 0.0f);
        }
        if (i10 == 80) {
            return createTranslationYAnimator(view2, i11, 0.0f);
        }
        if (i10 == 8388611) {
            return createTranslationXAnimator(view2, isRtl(view) ? i11 : -i11, 0.0f);
        }
        if (i10 == 8388613) {
            return createTranslationXAnimator(view2, isRtl(view) ? -i11 : i11, 0.0f);
        }
        throw new IllegalArgumentException("Invalid slide direction: " + i10);
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int i10, @Px int i11) {
        if (i10 == 3) {
            return createTranslationXAnimator(view2, 0.0f, -i11);
        }
        if (i10 == 5) {
            return createTranslationXAnimator(view2, 0.0f, i11);
        }
        if (i10 == 48) {
            return createTranslationYAnimator(view2, 0.0f, i11);
        }
        if (i10 == 80) {
            return createTranslationYAnimator(view2, 0.0f, -i11);
        }
        if (i10 == 8388611) {
            return createTranslationXAnimator(view2, 0.0f, isRtl(view) ? -i11 : i11);
        }
        if (i10 == 8388613) {
            return createTranslationXAnimator(view2, 0.0f, isRtl(view) ? i11 : -i11);
        }
        throw new IllegalArgumentException("Invalid slide direction: " + i10);
    }

    private static Animator createTranslationXAnimator(View view, float f10, float f11) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f10, f11));
    }

    private static Animator createTranslationYAnimator(View view, float f10, float f11) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f10, f11));
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i10 = this.slideDistance;
        return i10 != -1 ? i10 : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean isRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
        this.slideDistance = i10;
    }

    public void setSlideEdge(int i10) {
        this.slideEdge = i10;
    }
}
