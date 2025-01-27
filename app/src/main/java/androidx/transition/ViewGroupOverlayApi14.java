package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
    ViewGroupOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    static ViewGroupOverlayApi14 c(ViewGroup viewGroup) {
        return (ViewGroupOverlayApi14) ViewOverlayApi14.a(viewGroup);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(@NonNull View view) {
        this.f3880a.add(view);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(@NonNull View view) {
        this.f3880a.remove(view);
    }
}
