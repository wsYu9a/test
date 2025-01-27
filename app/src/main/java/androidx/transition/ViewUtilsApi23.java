package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
/* loaded from: classes.dex */
class ViewUtilsApi23 extends ViewUtilsApi22 {
    private static boolean m = true;

    ViewUtilsApi23() {
    }

    @Override // androidx.transition.ViewUtilsBase
    @SuppressLint({"NewApi"})
    public void setTransitionVisibility(@NonNull View view, int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            super.setTransitionVisibility(view, i2);
        } else if (m) {
            try {
                view.setTransitionVisibility(i2);
            } catch (NoSuchMethodError unused) {
                m = false;
            }
        }
    }
}
