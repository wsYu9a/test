package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
class g extends e {
    g(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        this.f7938a.setEndIconOnClickListener(null);
        this.f7938a.setEndIconDrawable((Drawable) null);
        this.f7938a.setEndIconContentDescription((CharSequence) null);
    }
}
