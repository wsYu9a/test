package cn.vlion.ad.inland.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class i6 extends FrameLayout implements d {
    public i6(@NonNull Context context) {
        super(context, null, 0);
    }

    public abstract View getBaseSwipeView();
}
