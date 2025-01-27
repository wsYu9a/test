package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
/* loaded from: classes.dex */
class ViewOverlayApi18 implements ViewOverlayImpl {

    /* renamed from: a */
    private final ViewOverlay f3887a;

    ViewOverlayApi18(@NonNull View view) {
        this.f3887a = view.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(@NonNull Drawable drawable) {
        this.f3887a.add(drawable);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(@NonNull Drawable drawable) {
        this.f3887a.remove(drawable);
    }
}
