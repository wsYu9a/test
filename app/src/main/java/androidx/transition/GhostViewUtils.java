package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
class GhostViewUtils {
    private GhostViewUtils() {
    }

    @Nullable
    static GhostView a(@NonNull View view, @NonNull ViewGroup viewGroup, @Nullable Matrix matrix) {
        return Build.VERSION.SDK_INT == 28 ? GhostViewPlatform.a(view, viewGroup, matrix) : GhostViewPort.a(view, viewGroup, matrix);
    }

    static void b(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            GhostViewPlatform.e(view);
        } else {
            GhostViewPort.e(view);
        }
    }
}
