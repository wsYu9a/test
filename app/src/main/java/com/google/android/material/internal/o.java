package com.google.android.material.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
class o extends r implements q {
    o(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    static o b(ViewGroup viewGroup) {
        return (o) r.a(viewGroup);
    }

    @Override // com.google.android.material.internal.q
    public void add(@NonNull View view) {
        this.f7379a.b(view);
    }

    @Override // com.google.android.material.internal.q
    public void remove(@NonNull View view) {
        this.f7379a.h(view);
    }
}
