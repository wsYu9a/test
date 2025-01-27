package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class ChildHelper {

    /* renamed from: a */
    private static final boolean f3190a = false;

    /* renamed from: b */
    private static final String f3191b = "ChildrenHelper";

    /* renamed from: c */
    final Callback f3192c;

    /* renamed from: d */
    final Bucket f3193d = new Bucket();

    /* renamed from: e */
    final List<View> f3194e = new ArrayList();

    static class Bucket {

        /* renamed from: a */
        static final int f3195a = 64;

        /* renamed from: b */
        static final long f3196b = Long.MIN_VALUE;

        /* renamed from: c */
        long f3197c = 0;

        /* renamed from: d */
        Bucket f3198d;

        Bucket() {
        }

        private void c() {
            if (this.f3198d == null) {
                this.f3198d = new Bucket();
            }
        }

        void a(int i2) {
            if (i2 < 64) {
                this.f3197c &= (1 << i2) ^ (-1);
                return;
            }
            Bucket bucket = this.f3198d;
            if (bucket != null) {
                bucket.a(i2 - 64);
            }
        }

        int b(int i2) {
            Bucket bucket = this.f3198d;
            return bucket == null ? i2 >= 64 ? Long.bitCount(this.f3197c) : Long.bitCount(this.f3197c & ((1 << i2) - 1)) : i2 < 64 ? Long.bitCount(this.f3197c & ((1 << i2) - 1)) : bucket.b(i2 - 64) + Long.bitCount(this.f3197c);
        }

        boolean d(int i2) {
            if (i2 < 64) {
                return (this.f3197c & (1 << i2)) != 0;
            }
            c();
            return this.f3198d.d(i2 - 64);
        }

        boolean e(int i2) {
            if (i2 >= 64) {
                c();
                return this.f3198d.e(i2 - 64);
            }
            long j2 = 1 << i2;
            long j3 = this.f3197c;
            boolean z = (j3 & j2) != 0;
            long j4 = j3 & (j2 ^ (-1));
            this.f3197c = j4;
            long j5 = j2 - 1;
            this.f3197c = (j4 & j5) | Long.rotateRight((j5 ^ (-1)) & j4, 1);
            Bucket bucket = this.f3198d;
            if (bucket != null) {
                if (bucket.d(0)) {
                    g(63);
                }
                this.f3198d.e(0);
            }
            return z;
        }

        void f() {
            this.f3197c = 0L;
            Bucket bucket = this.f3198d;
            if (bucket != null) {
                bucket.f();
            }
        }

        void g(int i2) {
            if (i2 < 64) {
                this.f3197c |= 1 << i2;
            } else {
                c();
                this.f3198d.g(i2 - 64);
            }
        }

        void insert(int i2, boolean z) {
            if (i2 >= 64) {
                c();
                this.f3198d.insert(i2 - 64, z);
                return;
            }
            long j2 = this.f3197c;
            boolean z2 = (Long.MIN_VALUE & j2) != 0;
            long j3 = (1 << i2) - 1;
            this.f3197c = ((j2 & (j3 ^ (-1))) << 1) | (j2 & j3);
            if (z) {
                g(i2);
            } else {
                a(i2);
            }
            if (z2 || this.f3198d != null) {
                c();
                this.f3198d.insert(0, z2);
            }
        }

        public String toString() {
            if (this.f3198d == null) {
                return Long.toBinaryString(this.f3197c);
            }
            return this.f3198d.toString() + "xx" + Long.toBinaryString(this.f3197c);
        }
    }

    interface Callback {
        void addView(View view, int i2);

        void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i2);

        View getChildAt(int i2);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i2);
    }

    ChildHelper(Callback callback) {
        this.f3192c = callback;
    }

    private int h(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int childCount = this.f3192c.getChildCount();
        int i3 = i2;
        while (i3 < childCount) {
            int b2 = i2 - (i3 - this.f3193d.b(i3));
            if (b2 == 0) {
                while (this.f3193d.d(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += b2;
        }
        return -1;
    }

    private void l(View view) {
        this.f3194e.add(view);
        this.f3192c.onEnteredHiddenState(view);
    }

    private boolean t(View view) {
        if (!this.f3194e.remove(view)) {
            return false;
        }
        this.f3192c.onLeftHiddenState(view);
        return true;
    }

    void a(View view, int i2, boolean z) {
        int childCount = i2 < 0 ? this.f3192c.getChildCount() : h(i2);
        this.f3193d.insert(childCount, z);
        if (z) {
            l(view);
        }
        this.f3192c.addView(view, childCount);
    }

    void b(View view, boolean z) {
        a(view, -1, z);
    }

    void c(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        int childCount = i2 < 0 ? this.f3192c.getChildCount() : h(i2);
        this.f3193d.insert(childCount, z);
        if (z) {
            l(view);
        }
        this.f3192c.attachViewToParent(view, childCount, layoutParams);
    }

    void d(int i2) {
        int h2 = h(i2);
        this.f3193d.e(h2);
        this.f3192c.detachViewFromParent(h2);
    }

    View e(int i2) {
        int size = this.f3194e.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f3194e.get(i3);
            RecyclerView.ViewHolder childViewHolder = this.f3192c.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i2 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    View f(int i2) {
        return this.f3192c.getChildAt(h(i2));
    }

    int g() {
        return this.f3192c.getChildCount() - this.f3194e.size();
    }

    View i(int i2) {
        return this.f3192c.getChildAt(i2);
    }

    int j() {
        return this.f3192c.getChildCount();
    }

    void k(View view) {
        int indexOfChild = this.f3192c.indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f3193d.g(indexOfChild);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int m(View view) {
        int indexOfChild = this.f3192c.indexOfChild(view);
        if (indexOfChild == -1 || this.f3193d.d(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.f3193d.b(indexOfChild);
    }

    boolean n(View view) {
        return this.f3194e.contains(view);
    }

    void o() {
        this.f3193d.f();
        for (int size = this.f3194e.size() - 1; size >= 0; size--) {
            this.f3192c.onLeftHiddenState(this.f3194e.get(size));
            this.f3194e.remove(size);
        }
        this.f3192c.removeAllViews();
    }

    void p(View view) {
        int indexOfChild = this.f3192c.indexOfChild(view);
        if (indexOfChild < 0) {
            return;
        }
        if (this.f3193d.e(indexOfChild)) {
            t(view);
        }
        this.f3192c.removeViewAt(indexOfChild);
    }

    void q(int i2) {
        int h2 = h(i2);
        View childAt = this.f3192c.getChildAt(h2);
        if (childAt == null) {
            return;
        }
        if (this.f3193d.e(h2)) {
            t(childAt);
        }
        this.f3192c.removeViewAt(h2);
    }

    boolean r(View view) {
        int indexOfChild = this.f3192c.indexOfChild(view);
        if (indexOfChild == -1) {
            t(view);
            return true;
        }
        if (!this.f3193d.d(indexOfChild)) {
            return false;
        }
        this.f3193d.e(indexOfChild);
        t(view);
        this.f3192c.removeViewAt(indexOfChild);
        return true;
    }

    void s(View view) {
        int indexOfChild = this.f3192c.indexOfChild(view);
        if (indexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f3193d.d(indexOfChild)) {
            this.f3193d.a(indexOfChild);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f3193d.toString() + ", hidden list:" + this.f3194e.size();
    }
}
