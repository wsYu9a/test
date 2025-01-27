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

/* loaded from: classes2.dex */
final class ScrollEventAdapter extends RecyclerView.OnScrollListener {

    /* renamed from: a */
    private static final int f7283a = 0;

    /* renamed from: b */
    private static final int f7284b = 1;

    /* renamed from: c */
    private static final int f7285c = 2;

    /* renamed from: d */
    private static final int f7286d = 3;

    /* renamed from: e */
    private static final int f7287e = 4;

    /* renamed from: f */
    private static final int f7288f = -1;

    /* renamed from: g */
    private ViewPager2.OnPageChangeCallback f7289g;

    /* renamed from: h */
    @NonNull
    private final ViewPager2 f7290h;

    /* renamed from: i */
    @NonNull
    private final RecyclerView f7291i;

    /* renamed from: j */
    @NonNull
    private final LinearLayoutManager f7292j;

    /* renamed from: k */
    private int f7293k;

    /* renamed from: l */
    private int f7294l;

    /* renamed from: m */
    private ScrollEventValues f7295m;

    /* renamed from: n */
    private int f7296n;

    /* renamed from: o */
    private int f7297o;

    /* renamed from: p */
    private boolean f7298p;

    /* renamed from: q */
    private boolean f7299q;

    /* renamed from: r */
    private boolean f7300r;

    /* renamed from: s */
    private boolean f7301s;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AdapterState {
    }

    public static final class ScrollEventValues {

        /* renamed from: a */
        int f7302a;

        /* renamed from: b */
        float f7303b;

        /* renamed from: c */
        int f7304c;

        public void a() {
            this.f7302a = -1;
            this.f7303b = 0.0f;
            this.f7304c = 0;
        }
    }

    public ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.f7290h = viewPager2;
        RecyclerView recyclerView = viewPager2.f7314j;
        this.f7291i = recyclerView;
        this.f7292j = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f7295m = new ScrollEventValues();
        i();
    }

    private void a(boolean z10) {
        this.f7301s = z10;
        this.f7293k = z10 ? 4 : 1;
        int i10 = this.f7297o;
        if (i10 != -1) {
            this.f7296n = i10;
            this.f7297o = -1;
        } else if (this.f7296n == -1) {
            this.f7296n = l();
        }
        a(1);
    }

    private void i() {
        this.f7293k = 0;
        this.f7294l = 0;
        this.f7295m.a();
        this.f7296n = -1;
        this.f7297o = -1;
        this.f7298p = false;
        this.f7299q = false;
        this.f7301s = false;
        this.f7300r = false;
    }

    private void j() {
        int top;
        ScrollEventValues scrollEventValues = this.f7295m;
        int findFirstVisibleItemPosition = this.f7292j.findFirstVisibleItemPosition();
        scrollEventValues.f7302a = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.a();
            return;
        }
        View findViewByPosition = this.f7292j.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.f7292j.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.f7292j.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.f7292j.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.f7292j.getBottomDecorationHeight(findViewByPosition);
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
        if (this.f7292j.getOrientation() == 0) {
            top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.f7291i.getPaddingLeft();
            if (this.f7290h.c()) {
                top = -top;
            }
            height = width;
        } else {
            top = (findViewByPosition.getTop() - topDecorationHeight) - this.f7291i.getPaddingTop();
        }
        int i10 = -top;
        scrollEventValues.f7304c = i10;
        if (i10 >= 0) {
            scrollEventValues.f7303b = height == 0 ? 0.0f : i10 / height;
        } else {
            if (!new AnimateLayoutChangeDetector(this.f7292j).a()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.f7304c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    private boolean k() {
        int i10 = this.f7293k;
        return i10 == 1 || i10 == 4;
    }

    private int l() {
        return this.f7292j.findFirstVisibleItemPosition();
    }

    public void b() {
        this.f7293k = 4;
        a(true);
    }

    public void c() {
        if (!f() || this.f7301s) {
            this.f7301s = false;
            j();
            ScrollEventValues scrollEventValues = this.f7295m;
            if (scrollEventValues.f7304c != 0) {
                a(2);
                return;
            }
            int i10 = scrollEventValues.f7302a;
            if (i10 != this.f7296n) {
                b(i10);
            }
            a(0);
            i();
        }
    }

    public int d() {
        return this.f7294l;
    }

    public boolean e() {
        return this.f7294l == 0;
    }

    public boolean f() {
        return this.f7294l == 1;
    }

    public boolean g() {
        return this.f7301s;
    }

    public double h() {
        j();
        ScrollEventValues scrollEventValues = this.f7295m;
        return scrollEventValues.f7302a + scrollEventValues.f7303b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i10) {
        if (!(this.f7293k == 1 && this.f7294l == 1) && i10 == 1) {
            a(false);
            return;
        }
        if (k() && i10 == 2) {
            if (this.f7299q) {
                a(2);
                this.f7298p = true;
                return;
            }
            return;
        }
        if (k() && i10 == 0) {
            j();
            if (this.f7299q) {
                ScrollEventValues scrollEventValues = this.f7295m;
                if (scrollEventValues.f7304c == 0) {
                    int i11 = this.f7296n;
                    int i12 = scrollEventValues.f7302a;
                    if (i11 != i12) {
                        b(i12);
                    }
                }
            } else {
                int i13 = this.f7295m.f7302a;
                if (i13 != -1) {
                    a(i13, 0.0f, 0);
                }
            }
            a(0);
            i();
        }
        if (this.f7293k == 2 && i10 == 0 && this.f7300r) {
            j();
            ScrollEventValues scrollEventValues2 = this.f7295m;
            if (scrollEventValues2.f7304c == 0) {
                int i14 = this.f7297o;
                int i15 = scrollEventValues2.f7302a;
                if (i14 != i15) {
                    if (i15 == -1) {
                        i15 = 0;
                    }
                    b(i15);
                }
                a(0);
                i();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if ((r5 < 0) == r3.f7290h.c()) goto L92;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrolled(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f7299q = r4
            r3.j()
            boolean r0 = r3.f7298p
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L37
            r3.f7298p = r2
            if (r6 > 0) goto L1f
            if (r6 != 0) goto L29
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            com.baidu.mobads.sdk.internal.widget.ViewPager2 r6 = r3.f7290h
            boolean r6 = r6.c()
            if (r5 != r6) goto L29
        L1f:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f7295m
            int r6 = r5.f7304c
            if (r6 == 0) goto L29
            int r5 = r5.f7302a
            int r5 = r5 + r4
            goto L2d
        L29:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f7295m
            int r5 = r5.f7302a
        L2d:
            r3.f7297o = r5
            int r6 = r3.f7296n
            if (r6 == r5) goto L45
            r3.b(r5)
            goto L45
        L37:
            int r5 = r3.f7293k
            if (r5 != 0) goto L45
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f7295m
            int r5 = r5.f7302a
            if (r5 != r1) goto L42
            r5 = 0
        L42:
            r3.b(r5)
        L45:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f7295m
            int r6 = r5.f7302a
            if (r6 != r1) goto L4c
            r6 = 0
        L4c:
            float r0 = r5.f7303b
            int r5 = r5.f7304c
            r3.a(r6, r0, r5)
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f7295m
            int r6 = r5.f7302a
            int r0 = r3.f7297o
            if (r6 == r0) goto L5d
            if (r0 != r1) goto L6b
        L5d:
            int r5 = r5.f7304c
            if (r5 != 0) goto L6b
            int r5 = r3.f7294l
            if (r5 == r4) goto L6b
            r3.a(r2)
            r3.i()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    private void b(int i10) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f7289g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i10);
        }
    }

    public void a() {
        this.f7300r = true;
    }

    public void a(int i10, boolean z10) {
        this.f7293k = z10 ? 2 : 3;
        this.f7301s = false;
        boolean z11 = this.f7297o != i10;
        this.f7297o = i10;
        a(2);
        if (z11) {
            b(i10);
        }
    }

    public void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f7289g = onPageChangeCallback;
    }

    private void a(int i10) {
        if ((this.f7293k == 3 && this.f7294l == 0) || this.f7294l == i10) {
            return;
        }
        this.f7294l = i10;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f7289g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i10);
        }
    }

    private void a(int i10, float f10, int i11) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f7289g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i10, f10, i11);
        }
    }
}
