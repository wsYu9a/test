package androidx.core.view;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i10, int i11, @Nullable int[] iArr, @Nullable int[] iArr2, int i12);

    boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, @Nullable int[] iArr, int i14);

    boolean hasNestedScrollingParent(int i10);

    boolean startNestedScroll(int i10, int i11);

    void stopNestedScroll(int i10);
}
