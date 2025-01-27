package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.h;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public static final boolean f6732a;

    static {
        f6732a = Build.VERSION.SDK_INT < 18;
    }

    private a() {
    }

    public static void a(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @NonNull FrameLayout frameLayout) {
        e(badgeDrawable, view, frameLayout);
        if (f6732a) {
            frameLayout.setForeground(badgeDrawable);
        } else {
            view.getOverlay().add(badgeDrawable);
        }
    }

    @NonNull
    public static SparseArray<BadgeDrawable> b(Context context, @NonNull h hVar) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(hVar.size());
        for (int i2 = 0; i2 < hVar.size(); i2++) {
            int keyAt = hVar.keyAt(i2);
            BadgeDrawable.SavedState savedState = (BadgeDrawable.SavedState) hVar.valueAt(i2);
            if (savedState == null) {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
            sparseArray.put(keyAt, BadgeDrawable.g(context, savedState));
        }
        return sparseArray;
    }

    @NonNull
    public static h c(@NonNull SparseArray<BadgeDrawable> sparseArray) {
        h hVar = new h();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            int keyAt = sparseArray.keyAt(i2);
            BadgeDrawable valueAt = sparseArray.valueAt(i2);
            if (valueAt == null) {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
            hVar.put(keyAt, valueAt.q());
        }
        return hVar;
    }

    public static void d(@Nullable BadgeDrawable badgeDrawable, @NonNull View view, @NonNull FrameLayout frameLayout) {
        if (badgeDrawable == null) {
            return;
        }
        if (f6732a) {
            frameLayout.setForeground(null);
        } else {
            view.getOverlay().remove(badgeDrawable);
        }
    }

    public static void e(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @NonNull FrameLayout frameLayout) {
        Rect rect = new Rect();
        (f6732a ? frameLayout : view).getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.J(view, frameLayout);
    }

    public static void f(@NonNull Rect rect, float f2, float f3, float f4, float f5) {
        rect.set((int) (f2 - f4), (int) (f3 - f5), (int) (f2 + f4), (int) (f3 + f5));
    }
}
