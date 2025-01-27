package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

@SuppressLint({"AppCompatCustomView"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class VisibilityAwareImageButton extends ImageButton {

    /* renamed from: a, reason: collision with root package name */
    private int f7314a;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    public final void c(int i2, boolean z) {
        super.setVisibility(i2);
        if (z) {
            this.f7314a = i2;
        }
    }

    public final int getUserSetVisibility() {
        return this.f7314a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        c(i2, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7314a = getVisibility();
    }
}
