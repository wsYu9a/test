package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes.dex */
final class ScrollEventAdapter extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    private static final int f4114a = 0;

    /* renamed from: b */
    private static final int f4115b = 1;

    /* renamed from: c */
    private static final int f4116c = 2;

    /* renamed from: d */
    private static final int f4117d = 3;

    /* renamed from: e */
    private static final int f4118e = 4;

    /* renamed from: f */
    private static final int f4119f = -1;

    /* renamed from: g */
    private ViewPager2.OnPageChangeCallback f4120g;

    /* renamed from: h */
    @NonNull
    private final ViewPager2 f4121h;

    /* renamed from: i */
    @NonNull
    private final RecyclerView f4122i;

    /* renamed from: j */
    @NonNull
    private final LinearLayoutManager f4123j;
    private int k;
    private int l;
    private ScrollEventValues m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    private static final class ScrollEventValues {

        /* renamed from: a */
        int f4124a;

        /* renamed from: b */
        float f4125b;

        /* renamed from: c */
        int f4126c;

        ScrollEventValues() {
        }

        void a() {
            this.f4124a = -1;
            this.f4125b = 0.0f;
            this.f4126c = 0;
        }
    }

    ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.f4121h = viewPager2;
        RecyclerView recyclerView = viewPager2.k;
        this.f4122i = recyclerView;
        this.f4123j = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.m = new ScrollEventValues();
        x();
    }

    private void A() {
        int top;
        ScrollEventValues scrollEventValues = this.m;
        int findFirstVisibleItemPosition = this.f4123j.findFirstVisibleItemPosition();
        scrollEventValues.f4124a = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.a();
            return;
        }
        View findViewByPosition = this.f4123j.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.f4123j.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.f4123j.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.f4123j.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.f4123j.getBottomDecorationHeight(findViewByPosition);
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
        if (this.f4123j.getOrientation() == 0) {
            top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.f4122i.getPaddingLeft();
            if (this.f4121h.c()) {
                top = -top;
            }
            height = width;
        } else {
            top = (findViewByPosition.getTop() - topDecorationHeight) - this.f4122i.getPaddingTop();
        }
        int i2 = -top;
        scrollEventValues.f4126c = i2;
        if (i2 >= 0) {
            scrollEventValues.f4125b = height == 0 ? 0.0f : i2 / height;
        } else {
            if (!new AnimateLayoutChangeDetector(this.f4123j).d()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.f4126c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    private void b(int i2, float f2, int i3) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f4120g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i2, f2, i3);
        }
    }

    private void c(int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f4120g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i2);
        }
    }

    private void d(int i2) {
        if ((this.k == 3 && this.l == 0) || this.l == i2) {
            return;
        }
        this.l = i2;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f4120g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i2);
        }
    }

    private int m() {
        return this.f4123j.findFirstVisibleItemPosition();
    }

    private boolean s() {
        int i2 = this.k;
        return i2 == 1 || i2 == 4;
    }

    private void x() {
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

    private void z(boolean z) {
        this.s = z;
        this.k = z ? 4 : 1;
        int i2 = this.o;
        if (i2 != -1) {
            this.n = i2;
            this.o = -1;
        } else if (this.n == -1) {
            this.n = m();
        }
        d(1);
    }

    double n() {
        A();
        ScrollEventValues scrollEventValues = this.m;
        double d2 = scrollEventValues.f4124a;
        double d3 = scrollEventValues.f4125b;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 + d3;
    }

    int o() {
        return this.l;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
        boolean z = true;
        if (!(this.k == 1 && this.l == 1) && i2 == 1) {
            z(false);
            return;
        }
        if (s() && i2 == 2) {
            if (this.q) {
                d(2);
                this.p = true;
                return;
            }
            return;
        }
        if (s() && i2 == 0) {
            A();
            if (this.q) {
                ScrollEventValues scrollEventValues = this.m;
                if (scrollEventValues.f4126c == 0) {
                    int i3 = this.n;
                    int i4 = scrollEventValues.f4124a;
                    if (i3 != i4) {
                        c(i4);
                    }
                } else {
                    z = false;
                }
            } else {
                int i5 = this.m.f4124a;
                if (i5 != -1) {
                    b(i5, 0.0f, 0);
                }
            }
            if (z) {
                d(0);
                x();
            }
        }
        if (this.k == 2 && i2 == 0 && this.r) {
            A();
            ScrollEventValues scrollEventValues2 = this.m;
            if (scrollEventValues2.f4126c == 0) {
                int i6 = this.o;
                int i7 = scrollEventValues2.f4124a;
                if (i6 != i7) {
                    if (i7 == -1) {
                        i7 = 0;
                    }
                    c(i7);
                }
                d(0);
                x();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if ((r5 < 0) == r3.f4121h.c()) goto L58;
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
            r3.A()
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
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f4121h
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
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r6 = r5.f4126c
            if (r6 == 0) goto L2f
            int r5 = r5.f4124a
            int r5 = r5 + r4
            goto L33
        L2f:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r5 = r5.f4124a
        L33:
            r3.o = r5
            int r6 = r3.n
            if (r6 == r5) goto L4b
            r3.c(r5)
            goto L4b
        L3d:
            int r5 = r3.k
            if (r5 != 0) goto L4b
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r5 = r5.f4124a
            if (r5 != r1) goto L48
            r5 = 0
        L48:
            r3.c(r5)
        L4b:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r6 = r5.f4124a
            if (r6 != r1) goto L52
            r6 = 0
        L52:
            float r0 = r5.f4125b
            int r5 = r5.f4126c
            r3.b(r6, r0, r5)
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.m
            int r6 = r5.f4124a
            int r0 = r3.o
            if (r6 == r0) goto L63
            if (r0 != r1) goto L71
        L63:
            int r5 = r5.f4126c
            if (r5 != 0) goto L71
            int r5 = r3.l
            if (r5 == r4) goto L71
            r3.d(r2)
            r3.x()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    boolean p() {
        return this.l == 1;
    }

    boolean q() {
        return this.s;
    }

    boolean r() {
        return this.l == 0;
    }

    void t() {
        this.k = 4;
        z(true);
    }

    void u() {
        this.r = true;
    }

    void v() {
        if (!p() || this.s) {
            this.s = false;
            A();
            ScrollEventValues scrollEventValues = this.m;
            if (scrollEventValues.f4126c != 0) {
                d(2);
                return;
            }
            int i2 = scrollEventValues.f4124a;
            if (i2 != this.n) {
                c(i2);
            }
            d(0);
            x();
        }
    }

    void w(int i2, boolean z) {
        this.k = z ? 2 : 3;
        this.s = false;
        boolean z2 = this.o != i2;
        this.o = i2;
        d(2);
        if (z2) {
            c(i2);
        }
    }

    void y(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f4120g = onPageChangeCallback;
    }
}
