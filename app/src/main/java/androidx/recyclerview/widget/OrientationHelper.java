package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class OrientationHelper {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    /* renamed from: a */
    private static final int f3390a = Integer.MIN_VALUE;

    /* renamed from: b */
    protected final RecyclerView.LayoutManager f3391b;

    /* renamed from: c */
    private int f3392c;

    /* renamed from: d */
    final Rect f3393d;

    /* renamed from: androidx.recyclerview.widget.OrientationHelper$1 */
    static class AnonymousClass1 extends OrientationHelper {
        AnonymousClass1(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedEnd(View view) {
            return this.f3391b.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedMeasurement(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f3391b.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedMeasurementInOther(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f3391b.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedStart(View view) {
            return this.f3391b.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEnd() {
            return this.f3391b.getWidth();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEndAfterPadding() {
            return this.f3391b.getWidth() - this.f3391b.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEndPadding() {
            return this.f3391b.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getMode() {
            return this.f3391b.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getModeInOther() {
            return this.f3391b.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getStartAfterPadding() {
            return this.f3391b.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTotalSpace() {
            return (this.f3391b.getWidth() - this.f3391b.getPaddingLeft()) - this.f3391b.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTransformedEndWithDecoration(View view) {
            this.f3391b.getTransformedBoundingBox(view, true, this.f3393d);
            return this.f3393d.right;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTransformedStartWithDecoration(View view) {
            this.f3391b.getTransformedBoundingBox(view, true, this.f3393d);
            return this.f3393d.left;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public void offsetChild(View view, int i2) {
            view.offsetLeftAndRight(i2);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public void offsetChildren(int i2) {
            this.f3391b.offsetChildrenHorizontal(i2);
        }
    }

    /* renamed from: androidx.recyclerview.widget.OrientationHelper$2 */
    static class AnonymousClass2 extends OrientationHelper {
        AnonymousClass2(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedEnd(View view) {
            return this.f3391b.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedMeasurement(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f3391b.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedMeasurementInOther(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f3391b.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getDecoratedStart(View view) {
            return this.f3391b.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEnd() {
            return this.f3391b.getHeight();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEndAfterPadding() {
            return this.f3391b.getHeight() - this.f3391b.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getEndPadding() {
            return this.f3391b.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getMode() {
            return this.f3391b.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getModeInOther() {
            return this.f3391b.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getStartAfterPadding() {
            return this.f3391b.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTotalSpace() {
            return (this.f3391b.getHeight() - this.f3391b.getPaddingTop()) - this.f3391b.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTransformedEndWithDecoration(View view) {
            this.f3391b.getTransformedBoundingBox(view, true, this.f3393d);
            return this.f3393d.bottom;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public int getTransformedStartWithDecoration(View view) {
            this.f3391b.getTransformedBoundingBox(view, true, this.f3393d);
            return this.f3393d.top;
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public void offsetChild(View view, int i2) {
            view.offsetTopAndBottom(i2);
        }

        @Override // androidx.recyclerview.widget.OrientationHelper
        public void offsetChildren(int i2) {
            this.f3391b.offsetChildrenVertical(i2);
        }
    }

    /* synthetic */ OrientationHelper(RecyclerView.LayoutManager layoutManager, AnonymousClass1 anonymousClass1) {
        this(layoutManager);
    }

    public static OrientationHelper createHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) { // from class: androidx.recyclerview.widget.OrientationHelper.1
            AnonymousClass1(RecyclerView.LayoutManager layoutManager2) {
                super(layoutManager2);
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedEnd(View view) {
                return this.f3391b.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedMeasurement(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f3391b.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedMeasurementInOther(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f3391b.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedStart(View view) {
                return this.f3391b.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getEnd() {
                return this.f3391b.getWidth();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getEndAfterPadding() {
                return this.f3391b.getWidth() - this.f3391b.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getEndPadding() {
                return this.f3391b.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getMode() {
                return this.f3391b.getWidthMode();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getModeInOther() {
                return this.f3391b.getHeightMode();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getStartAfterPadding() {
                return this.f3391b.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getTotalSpace() {
                return (this.f3391b.getWidth() - this.f3391b.getPaddingLeft()) - this.f3391b.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getTransformedEndWithDecoration(View view) {
                this.f3391b.getTransformedBoundingBox(view, true, this.f3393d);
                return this.f3393d.right;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getTransformedStartWithDecoration(View view) {
                this.f3391b.getTransformedBoundingBox(view, true, this.f3393d);
                return this.f3393d.left;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public void offsetChild(View view, int i2) {
                view.offsetLeftAndRight(i2);
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public void offsetChildren(int i2) {
                this.f3391b.offsetChildrenHorizontal(i2);
            }
        };
    }

    public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager layoutManager, int i2) {
        if (i2 == 0) {
            return createHorizontalHelper(layoutManager);
        }
        if (i2 == 1) {
            return createVerticalHelper(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static OrientationHelper createVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) { // from class: androidx.recyclerview.widget.OrientationHelper.2
            AnonymousClass2(RecyclerView.LayoutManager layoutManager2) {
                super(layoutManager2);
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedEnd(View view) {
                return this.f3391b.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedMeasurement(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f3391b.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedMeasurementInOther(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f3391b.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getDecoratedStart(View view) {
                return this.f3391b.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getEnd() {
                return this.f3391b.getHeight();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getEndAfterPadding() {
                return this.f3391b.getHeight() - this.f3391b.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getEndPadding() {
                return this.f3391b.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getMode() {
                return this.f3391b.getHeightMode();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getModeInOther() {
                return this.f3391b.getWidthMode();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getStartAfterPadding() {
                return this.f3391b.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getTotalSpace() {
                return (this.f3391b.getHeight() - this.f3391b.getPaddingTop()) - this.f3391b.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getTransformedEndWithDecoration(View view) {
                this.f3391b.getTransformedBoundingBox(view, true, this.f3393d);
                return this.f3393d.bottom;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public int getTransformedStartWithDecoration(View view) {
                this.f3391b.getTransformedBoundingBox(view, true, this.f3393d);
                return this.f3393d.top;
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public void offsetChild(View view, int i2) {
                view.offsetTopAndBottom(i2);
            }

            @Override // androidx.recyclerview.widget.OrientationHelper
            public void offsetChildren(int i2) {
                this.f3391b.offsetChildrenVertical(i2);
            }
        };
    }

    public abstract int getDecoratedEnd(View view);

    public abstract int getDecoratedMeasurement(View view);

    public abstract int getDecoratedMeasurementInOther(View view);

    public abstract int getDecoratedStart(View view);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.f3391b;
    }

    public abstract int getMode();

    public abstract int getModeInOther();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public int getTotalSpaceChange() {
        if (Integer.MIN_VALUE == this.f3392c) {
            return 0;
        }
        return getTotalSpace() - this.f3392c;
    }

    public abstract int getTransformedEndWithDecoration(View view);

    public abstract int getTransformedStartWithDecoration(View view);

    public abstract void offsetChild(View view, int i2);

    public abstract void offsetChildren(int i2);

    public void onLayoutComplete() {
        this.f3392c = getTotalSpace();
    }

    private OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        this.f3392c = Integer.MIN_VALUE;
        this.f3393d = new Rect();
        this.f3391b = layoutManager;
    }
}
