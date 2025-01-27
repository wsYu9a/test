package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* loaded from: classes7.dex */
public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(View view) {
        this.mView = view;
    }

    private ViewParent getNestedScrollingParentForType(int i2) {
        switch (i2) {
            case 0:
                return this.mNestedScrollingParentTouch;
            case 1:
                return this.mNestedScrollingParentNonTouch;
            default:
                return null;
        }
    }

    private void setNestedScrollingParentForType(int i2, ViewParent viewParent) {
        switch (i2) {
            case 0:
                this.mNestedScrollingParentTouch = viewParent;
                break;
            case 1:
                this.mNestedScrollingParentNonTouch = viewParent;
                break;
        }
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(nestedScrollingParentForType, this.mView, f2, f3, z);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(nestedScrollingParentForType, this.mView, f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i2, i3, iArr, iArr2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        ViewParent nestedScrollingParentForType;
        int i5;
        int i6;
        int[] iArr3;
        Object[] objArr = {new Integer(7090443), new Integer(3234563)};
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i4)) == null) {
            return false;
        }
        int intValue = ((Integer) objArr[1]).intValue() ^ 3234562;
        if (i2 == 0 && i3 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[intValue] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            int i7 = iArr2[0];
            i5 = iArr2[intValue];
            i6 = i7;
        } else {
            i5 = 0;
            i6 = 0;
        }
        if (iArr == null) {
            if (this.mTempNestedScrollConsumed == null) {
                this.mTempNestedScrollConsumed = new int[((Integer) objArr[0]).intValue() ^ 7090441];
            }
            iArr3 = this.mTempNestedScrollConsumed;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[intValue] = 0;
        ViewParentCompat.onNestedPreScroll(nestedScrollingParentForType, this.mView, i2, i3, iArr3, i4);
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i6;
            iArr2[intValue] = iArr2[intValue] - i5;
        }
        return (iArr3[0] == 0 && iArr3[intValue] == 0) ? 0 : intValue;
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return dispatchNestedScroll(i2, i3, i4, i5, iArr, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        ViewParent nestedScrollingParentForType;
        int i7;
        int i8;
        Integer num = new Integer(7408441);
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i6)) == null) {
            return false;
        }
        boolean intValue = ((Integer) new Object[]{num}[0]).intValue() ^ 7408440;
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[intValue ? 1 : 0] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.mView.getLocationInWindow(iArr);
            int i9 = iArr[0];
            i7 = iArr[intValue ? 1 : 0];
            i8 = i9;
        } else {
            i7 = 0;
            i8 = 0;
        }
        ViewParentCompat.onNestedScroll(nestedScrollingParentForType, this.mView, i2, i3, i4, i5, i6);
        if (iArr != null) {
            this.mView.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i8;
            iArr[intValue ? 1 : 0] = iArr[intValue ? 1 : 0] - i7;
        }
        return intValue;
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int i2) {
        return getNestedScrollingParentForType(i2) != null;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(View view) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean z) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = z;
    }

    public boolean startNestedScroll(int i2) {
        return startNestedScroll(i2, 0);
    }

    public boolean startNestedScroll(int i2, int i3) {
        if (hasNestedScrollingParent(i3)) {
            return true;
        }
        if (isNestedScrollingEnabled()) {
            View view = this.mView;
            for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
                if (ViewParentCompat.onStartNestedScroll(parent, view, this.mView, i2, i3)) {
                    setNestedScrollingParentForType(i3, parent);
                    ViewParentCompat.onNestedScrollAccepted(parent, view, this.mView, i2, i3);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public void stopNestedScroll(int i2) {
        ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i2);
        if (nestedScrollingParentForType != null) {
            ViewParentCompat.onStopNestedScroll(nestedScrollingParentForType, this.mView, i2);
            setNestedScrollingParentForType(i2, null);
        }
    }
}
