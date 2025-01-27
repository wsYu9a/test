package com.google.android.material.textfield;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes.dex */
abstract class e {

    /* renamed from: a */
    TextInputLayout f7938a;

    /* renamed from: b */
    Context f7939b;

    /* renamed from: c */
    CheckableImageButton f7940c;

    e(@NonNull TextInputLayout textInputLayout) {
        this.f7938a = textInputLayout;
        this.f7939b = textInputLayout.getContext();
        this.f7940c = textInputLayout.getEndIconView();
    }

    abstract void a();

    boolean b(int i2) {
        return true;
    }

    void c(boolean z) {
    }

    boolean d() {
        return false;
    }
}
