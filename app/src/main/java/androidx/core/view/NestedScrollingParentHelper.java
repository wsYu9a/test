package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class NestedScrollingParentHelper {

    /* renamed from: a, reason: collision with root package name */
    private int f2051a;

    /* renamed from: b, reason: collision with root package name */
    private int f2052b;

    public NestedScrollingParentHelper(@NonNull ViewGroup viewGroup) {
    }

    public int getNestedScrollAxes() {
        return this.f2051a | this.f2052b;
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2) {
        onNestedScrollAccepted(view, view2, i2, 0);
    }

    public void onStopNestedScroll(@NonNull View view) {
        onStopNestedScroll(view, 0);
    }

    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2, int i3) {
        if (i3 == 1) {
            this.f2052b = i2;
        } else {
            this.f2051a = i2;
        }
    }

    public void onStopNestedScroll(@NonNull View view, int i2) {
        if (i2 == 1) {
            this.f2052b = 0;
        } else {
            this.f2051a = 0;
        }
    }
}
