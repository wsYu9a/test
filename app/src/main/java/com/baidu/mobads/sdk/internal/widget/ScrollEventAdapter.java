package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* loaded from: classes.dex */
final class ScrollEventAdapter extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    private static final int f5891a = 0;

    /* renamed from: b */
    private static final int f5892b = 1;

    /* renamed from: c */
    private static final int f5893c = 2;

    /* renamed from: d */
    private static final int f5894d = 3;

    /* renamed from: e */
    private static final int f5895e = 4;

    /* renamed from: f */
    private static final int f5896f = -1;

    /* renamed from: g */
    private ViewPager2.OnPageChangeCallback f5897g;

    /* renamed from: h */
    @NonNull
    private final ViewPager2 f5898h;

    /* renamed from: i */
    @NonNull
    private final RecyclerView f5899i;

    /* renamed from: j */
    @NonNull
    private final LinearLayoutManager f5900j;
    private int k;
    private int l;
    private ScrollEventValues m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    @Retention(RetentionPolicy.SOURCE)
    private @interface AdapterState {
    }

    private static final class ScrollEventValues {

        /* renamed from: a */
        int f5901a;

        /* renamed from: b */
        float f5902b;

        /* renamed from: c */
        int f5903c;

        ScrollEventValues() {
        }

        void a() {
            this.f5901a = -1;
            this.f5902b = 0.0f;
            this.f5903c = 0;
        }
    }

    ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.f5898h = viewPager2;
        RecyclerView recyclerView = viewPager2.f5913j;
        this.f5899i = recyclerView;
        this.f5900j = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.m = new ScrollEventValues();
        i();
    }

    private void a(boolean z) {
        this.s = z;
        this.k = z ? 4 : 1;
        int i2 = this.o;
        if (i2 != -1) {
            this.n = i2;
            this.o = -1;
        } else if (this.n == -1) {
            this.n = l();
        }
        a(1);
    }

    private void i() {
        this.k = 0;
        this.l = 0;
        this.m.a();
        this.n = -1;
        this.o = -1;
        this.p = false;
        this.q = false;
        this.s = false;
        this.r = false;
    }

    private void j() {
        int top;
        ScrollEventValues scrollEventValues = this.m;
        int findFirstVisibleItemPosition = this.f5900j.findFirstVisibleItemPosition();
        scrollEventValues.f5901a = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.a();
            return;
        }
        View findViewByPosition = this.f5900j.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.f5900j.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.f5900j.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.f5900j.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.f5900j.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.f5900j.getOrientation() == 0) {
            top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.f5899i.getPaddingLeft();
            if (this.f5898h.c()) {
                top = -top;
            }
            height = width;
        } else {
            top = (findViewByPosition.getTop() - topDecorationHeight) - this.f5899i.getPaddingTop();
        }
        int i2 = -top;
        scrollEventValues.f5903c = i2;
        if (i2 >= 0) {
            scrollEventValues.f5902b = height == 0 ? 0.0f : i2 / height;
        } else {
            if (!new AnimateLayoutChangeDetector(this.f5900j).a()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.f5903c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    private boolean k() {
        int i2 = this.k;
        return i2 == 1 || i2 == 4;
    }

    private int l() {
        return this.f5900j.findFirstVisibleItemPosition();
    }

    void b() {
        this.k = 4;
        a(true);
    }

    void c() {
        if (!f() || this.s) {
            this.s = false;
            j();
            ScrollEventValues scrollEventValues = this.m;
            if (scrollEventValues.f5903c != 0) {
                a(2);
                return;
            }
            int i2 = scrollEventValues.f5901a;
            if (i2 != this.n) {
                b(i2);
            }
            a(0);
            i();
        }
    }

    int d() {
        return this.l;
    }

    boolean e() {
        return this.l == 0;
    }

    boolean f() {
        return this.l == 1;
    }

    boolean g() {
        return this.s;
    }

    double h() {
        j();
        ScrollEventValues scrollEventValues = this.m;
        double d2 = scrollEventValues.f5901a;
        double d3 = scrollEventValues.f5902b;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 + d3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
        boolean z = true;
        if (!(this.k == 1 && this.l == 1) && i2 == 1) {
            a(false);
            return;
        }
        if (k() && i2 == 2) {
            if (this.q) {
                a(2);
                this.p = true;
                return;
            }
            return;
        }
        if (k() && i2 == 0) {
            j();
            if (this.q) {
                ScrollEventValues scrollEventValues = this.m;
                if (scrollEventValues.f5903c == 0) {
                    int i3 = this.n;
                    int i4 = scrollEventValues.f5901a;
                    if (i3 != i4) {
                        b(i4);
                    }
                } else {
                    z = false;
                }
            } else {
                int i5 = this.m.f5901a;
                if (i5 != -1) {
                    a(i5, 0.0f, 0);
                }
            }
            if (z) {
                a(0);
                i();
            }
        }
        if (this.k == 2 && i2 == 0 && this.r) {
            j();
            ScrollEventValues scrollEventValues2 = this.m;
            if (scrollEventValues2.f5903c == 0) {
                int i6 = this.o;
                int i7 = scrollEventValues2.f5901a;
                if (i6 != i7) {
                    if (i7 == -1) {
                        i7 = 0;
                    }
                    b(i7);
                }
                a(0);
                i();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if ((r5 < 0) == r3.f5898h.c()) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrolled(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.q = r4
            r3.j()
            boolean r0 = r3.p
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L3d
            r3.p = r2
            if (r6 > 0) goto L22
            if (r6 != 0) goto L20
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            com.baidu.mobads.sdk.internal.widget.ViewPager2 r6 = r3.f5898h
            boolean r6 = r6.c()
            if (r5 != r6) goto L20
            goto L22
        L20:
            r5 = 0
            goto L23
        L22:
            r5 = 1
        L23:
            if (r5 == 0) goto L2f
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r6 = r5.f5903c
            if (r6 == 0) goto L2f
            int r5 = r5.f5901a
            int r5 = r5 + r4
            goto L33
        L2f:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r5 = r5.f5901a
        L33:
            r3.o = r5
            int r6 = r3.n
            if (r6 == r5) goto L4b
            r3.b(r5)
            goto L4b
        L3d:
            int r5 = r3.k
            if (r5 != 0) goto L4b
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r5 = r5.f5901a
            if (r5 != r1) goto L48
            r5 = 0
        L48:
            r3.b(r5)
        L4b:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r6 = r5.f5901a
            if (r6 != r1) goto L52
            r6 = 0
        L52:
            float r0 = r5.f5902b
            int r5 = r5.f5903c
            r3.a(r6, r0, r5)
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r6 = r5.f5901a
            int r0 = r3.o
            if (r6 == r0) goto L63
            if (r0 != r1) goto L71
        L63:
            int r5 = r5.f5903c
            if (r5 != 0) goto L71
            int r5 = r3.l
            if (r5 == r4) goto L71
            r3.a(r2)
            r3.i()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    private void b(int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f5897g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i2);
        }
    }

    void a() {
        this.r = true;
    }

    void a(int i2, boolean z) {
        this.k = z ? 2 : 3;
        this.s = false;
        boolean z2 = this.o != i2;
        this.o = i2;
        a(2);
        if (z2) {
            b(i2);
        }
    }

    void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f5897g = onPageChangeCallback;
    }

    private void a(int i2) {
        if ((this.k == 3 && this.l == 0) || this.l == i2) {
            return;
        }
        this.l = i2;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f5897g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i2);
        }
    }

    private void a(int i2, float f2, int i3) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f5897g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i2, f2, i3);
        }
    }
}
