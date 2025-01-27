package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class LayoutState {

    /* renamed from: a */
    static final int f3331a = -1;

    /* renamed from: b */
    static final int f3332b = 1;

    /* renamed from: c */
    static final int f3333c = Integer.MIN_VALUE;

    /* renamed from: d */
    static final int f3334d = -1;

    /* renamed from: e */
    static final int f3335e = 1;

    /* renamed from: g */
    int f3337g;

    /* renamed from: h */
    int f3338h;

    /* renamed from: i */
    int f3339i;

    /* renamed from: j */
    int f3340j;
    boolean m;
    boolean n;

    /* renamed from: f */
    boolean f3336f = true;
    int k = 0;
    int l = 0;

    LayoutState() {
    }

    boolean a(RecyclerView.State state) {
        int i2 = this.f3338h;
        return i2 >= 0 && i2 < state.getItemCount();
    }

    View b(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.f3338h);
        this.f3338h += this.f3339i;
        return viewForPosition;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f3337g + ", mCurrentPosition=" + this.f3338h + ", mItemDirection=" + this.f3339i + ", mLayoutDirection=" + this.f3340j + ", mStartLine=" + this.k + ", mEndLine=" + this.l + '}';
    }
}
