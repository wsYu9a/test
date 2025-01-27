package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes2.dex */
public class FlexboxItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: g */
    public static final int f8970g = 1;

    /* renamed from: h */
    public static final int f8971h = 2;

    /* renamed from: i */
    public static final int f8972i = 3;

    /* renamed from: j */
    public static final int[] f8973j = {android.R.attr.listDivider};

    /* renamed from: e */
    public Drawable f8974e;

    /* renamed from: f */
    public int f8975f;

    public FlexboxItemDecoration(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f8973j);
        this.f8974e = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setOrientation(3);
    }

    public final void a(Canvas canvas, RecyclerView parent) {
        int top;
        int intrinsicHeight;
        int left;
        int right;
        int i10;
        int i11;
        int i12;
        if (d()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left2 = parent.getLeft() - parent.getPaddingLeft();
            int right2 = parent.getRight() + parent.getPaddingRight();
            int childCount = parent.getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = parent.getChildAt(i13);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    intrinsicHeight = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    top = this.f8974e.getIntrinsicHeight() + intrinsicHeight;
                } else {
                    top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    intrinsicHeight = top - this.f8974e.getIntrinsicHeight();
                }
                if (!flexboxLayoutManager.j()) {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    right = childAt.getRight();
                    i10 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                } else if (flexboxLayoutManager.J()) {
                    i11 = Math.min(childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + this.f8974e.getIntrinsicWidth(), right2);
                    i12 = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    this.f8974e.setBounds(i12, intrinsicHeight, i11, top);
                    this.f8974e.draw(canvas);
                } else {
                    left = Math.max((childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f8974e.getIntrinsicWidth(), left2);
                    right = childAt.getRight();
                    i10 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                int i14 = left;
                i11 = right + i10;
                i12 = i14;
                this.f8974e.setBounds(i12, intrinsicHeight, i11, top);
                this.f8974e.draw(canvas);
            }
        }
    }

    public final void b(Canvas canvas, RecyclerView parent) {
        int left;
        int intrinsicWidth;
        int max;
        int bottom;
        int i10;
        int i11;
        if (e()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
            int top = parent.getTop() - parent.getPaddingTop();
            int bottom2 = parent.getBottom() + parent.getPaddingBottom();
            int childCount = parent.getChildCount();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = parent.getChildAt(i12);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexboxLayoutManager.J()) {
                    intrinsicWidth = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    left = this.f8974e.getIntrinsicWidth() + intrinsicWidth;
                } else {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    intrinsicWidth = left - this.f8974e.getIntrinsicWidth();
                }
                if (flexboxLayoutManager.j()) {
                    max = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    bottom = childAt.getBottom();
                    i10 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                } else if (flexDirection == 3) {
                    int min = Math.min(childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + this.f8974e.getIntrinsicHeight(), bottom2);
                    max = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    i11 = min;
                    this.f8974e.setBounds(intrinsicWidth, max, left, i11);
                    this.f8974e.draw(canvas);
                } else {
                    max = Math.max((childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f8974e.getIntrinsicHeight(), top);
                    bottom = childAt.getBottom();
                    i10 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                }
                i11 = bottom + i10;
                this.f8974e.setBounds(intrinsicWidth, max, left, i11);
                this.f8974e.draw(canvas);
            }
        }
    }

    public final boolean c(int position, List<a> flexLines, FlexboxLayoutManager layoutManager) {
        int G = layoutManager.G(position);
        if ((G == -1 || G >= layoutManager.getFlexLinesInternal().size() || layoutManager.getFlexLinesInternal().get(G).f9080o != position) && position != 0) {
            return flexLines.size() != 0 && flexLines.get(flexLines.size() - 1).f9081p == position - 1;
        }
        return true;
    }

    public final boolean d() {
        return (this.f8975f & 1) > 0;
    }

    public final boolean e() {
        return (this.f8975f & 2) > 0;
    }

    public final void f(Rect outRect, int position, FlexboxLayoutManager layoutManager, List<a> flexLines) {
        if (flexLines.size() == 0 || layoutManager.G(position) == 0) {
            return;
        }
        if (layoutManager.j()) {
            if (d()) {
                outRect.top = this.f8974e.getIntrinsicHeight();
                outRect.bottom = 0;
                return;
            } else {
                outRect.top = 0;
                outRect.bottom = 0;
                return;
            }
        }
        if (e()) {
            if (layoutManager.J()) {
                outRect.right = this.f8974e.getIntrinsicWidth();
                outRect.left = 0;
            } else {
                outRect.left = this.f8974e.getIntrinsicWidth();
                outRect.right = 0;
            }
        }
    }

    public final void g(Rect outRect, int position, FlexboxLayoutManager layoutManager, List<a> flexLines, int flexDirection) {
        if (c(position, flexLines, layoutManager)) {
            return;
        }
        if (layoutManager.j()) {
            if (!e()) {
                outRect.left = 0;
                outRect.right = 0;
                return;
            } else if (layoutManager.J()) {
                outRect.right = this.f8974e.getIntrinsicWidth();
                outRect.left = 0;
                return;
            } else {
                outRect.left = this.f8974e.getIntrinsicWidth();
                outRect.right = 0;
                return;
            }
        }
        if (!d()) {
            outRect.top = 0;
            outRect.bottom = 0;
        } else if (flexDirection == 3) {
            outRect.bottom = this.f8974e.getIntrinsicHeight();
            outRect.top = 0;
        } else {
            outRect.top = this.f8974e.getIntrinsicHeight();
            outRect.bottom = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, RecyclerView parent, @NonNull RecyclerView.State state) {
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            return;
        }
        if (!d() && !e()) {
            outRect.set(0, 0, 0, 0);
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
        List<a> flexLines = flexboxLayoutManager.getFlexLines();
        g(outRect, childAdapterPosition, flexboxLayoutManager, flexLines, flexboxLayoutManager.getFlexDirection());
        f(outRect, childAdapterPosition, flexboxLayoutManager, flexLines);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        a(canvas, parent);
        b(canvas, parent);
    }

    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.f8974e = drawable;
    }

    public void setOrientation(int orientation) {
        this.f8975f = orientation;
    }
}
