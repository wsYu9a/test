package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
/* loaded from: classes.dex */
class p implements q {

    /* renamed from: a */
    private final ViewGroupOverlay f7378a;

    p(@NonNull ViewGroup viewGroup) {
        this.f7378a = viewGroup.getOverlay();
    }

    @Override // com.google.android.material.internal.t
    public void add(@NonNull Drawable drawable) {
        this.f7378a.add(drawable);
    }

    @Override // com.google.android.material.internal.t
    public void remove(@NonNull Drawable drawable) {
        this.f7378a.remove(drawable);
    }

    @Override // com.google.android.material.internal.q
    public void add(@NonNull View view) {
        this.f7378a.add(view);
    }

    @Override // com.google.android.material.internal.q
    public void remove(@NonNull View view) {
        this.f7378a.remove(view);
    }
}
