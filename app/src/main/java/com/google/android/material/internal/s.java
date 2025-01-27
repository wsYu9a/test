package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
/* loaded from: classes.dex */
class s implements t {

    /* renamed from: a */
    private final ViewOverlay f7386a;

    s(@NonNull View view) {
        this.f7386a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.t
    public void add(@NonNull Drawable drawable) {
        this.f7386a.add(drawable);
    }

    @Override // com.google.android.material.internal.t
    public void remove(@NonNull Drawable drawable) {
        this.f7386a.remove(drawable);
    }
}
