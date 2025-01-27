package android.support.v4.view;

/* loaded from: classes7.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4);

    boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6);

    boolean hasNestedScrollingParent(int i2);

    boolean startNestedScroll(int i2, int i3);

    void stopNestedScroll(int i2);
}
