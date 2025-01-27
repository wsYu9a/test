package com.google.android.material.m;

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
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class s implements v {

    /* renamed from: a */
    private static final int f7579a = -1;

    /* renamed from: b */
    private int f7580b;

    /* renamed from: c */
    @Px
    private int f7581c = -1;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface a {
    }

    public s(int i2) {
        this.f7580b = i2;
    }

    private static Animator c(View view, View view2, int i2, @Px int i3) {
        if (i2 == 3) {
            return e(view2, i3, 0.0f);
        }
        if (i2 == 5) {
            return e(view2, -i3, 0.0f);
        }
        if (i2 == 48) {
            return f(view2, -i3, 0.0f);
        }
        if (i2 == 80) {
            return f(view2, i3, 0.0f);
        }
        if (i2 == 8388611) {
            return e(view2, j(view) ? i3 : -i3, 0.0f);
        }
        if (i2 == 8388613) {
            return e(view2, j(view) ? -i3 : i3, 0.0f);
        }
        throw new IllegalArgumentException("Invalid slide direction: " + i2);
    }

    private static Animator d(View view, View view2, int i2, @Px int i3) {
        if (i2 == 3) {
            return e(view2, 0.0f, -i3);
        }
        if (i2 == 5) {
            return e(view2, 0.0f, i3);
        }
        if (i2 == 48) {
            return f(view2, 0.0f, i3);
        }
        if (i2 == 80) {
            return f(view2, 0.0f, -i3);
        }
        if (i2 == 8388611) {
            return e(view2, 0.0f, j(view) ? -i3 : i3);
        }
        if (i2 == 8388613) {
            return e(view2, 0.0f, j(view) ? i3 : -i3);
        }
        throw new IllegalArgumentException("Invalid slide direction: " + i2);
    }

    private static Animator e(View view, float f2, float f3) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f2, f3));
    }

    private static Animator f(View view, float f2, float f3) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f2, f3));
    }

    private int h(Context context) {
        int i2 = this.f7581c;
        return i2 != -1 ? i2 : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean j(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    @Override // com.google.android.material.m.v
    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return d(viewGroup, view, this.f7580b, h(view.getContext()));
    }

    @Override // com.google.android.material.m.v
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return c(viewGroup, view, this.f7580b, h(view.getContext()));
    }

    @Px
    public int g() {
        return this.f7581c;
    }

    public int i() {
        return this.f7580b;
    }

    public void k(@Px int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
        this.f7581c = i2;
    }

    public void l(int i2) {
        this.f7580b = i2;
    }
}
