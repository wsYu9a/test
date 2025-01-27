package com.martian.libmars.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat;
import com.martian.libmars.R;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: classes2.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {

    /* renamed from: a */
    private static final int f10336a = -1;

    /* renamed from: b */
    private static final int f10337b = 0;

    /* renamed from: c */
    private static final float f10338c = 30.0f;

    /* renamed from: d */
    private static final float f10339d = 0.009f;

    /* renamed from: e */
    private static final String f10340e = "BUNDLE_ID_CURRENT_X";

    /* renamed from: f */
    private static final String f10341f = "BUNDLE_ID_PARENT_STATE";
    private OnScrollStateChangedListener A;
    private OnScrollStateChangedListener.ScrollState B;
    private final EdgeEffectCompat C;
    private final EdgeEffectCompat D;
    private int E;
    private boolean F;
    private boolean G;
    private View.OnClickListener H;
    private final DataSetObserver I;
    private final Runnable J;

    /* renamed from: g */
    protected Scroller f10342g;

    /* renamed from: h */
    private final GestureDetector f10343h;

    /* renamed from: i */
    private int f10344i;

    /* renamed from: j */
    protected ListAdapter f10345j;
    private final List<Queue<View>> k;
    private boolean l;
    private final Rect m;
    private View n;
    private int o;
    private Drawable p;
    protected int q;
    protected int r;
    private Integer s;
    private int t;
    private int u;
    private int v;
    private int w;
    private e x;
    private int y;
    private boolean z;

    public interface OnScrollStateChangedListener {

        public enum ScrollState {
            SCROLL_STATE_IDLE,
            SCROLL_STATE_TOUCH_SCROLL,
            SCROLL_STATE_FLING
        }

        void a(ScrollState scrollState);
    }

    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            HorizontalListView.this.l = true;
            HorizontalListView.this.z = false;
            HorizontalListView.this.T();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            HorizontalListView.this.z = false;
            HorizontalListView.this.T();
            HorizontalListView.this.P();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }
    }

    private class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e2) {
            return HorizontalListView.this.I(e2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return HorizontalListView.this.J(e1, e2, velocityX, velocityY);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e2) {
            HorizontalListView.this.T();
            int x = HorizontalListView.this.x((int) e2.getX(), (int) e2.getY());
            if (x < 0 || HorizontalListView.this.F) {
                return;
            }
            View childAt = HorizontalListView.this.getChildAt(x);
            AdapterView.OnItemLongClickListener onItemLongClickListener = HorizontalListView.this.getOnItemLongClickListener();
            if (onItemLongClickListener != null) {
                int i2 = HorizontalListView.this.u + x;
                HorizontalListView horizontalListView = HorizontalListView.this;
                if (onItemLongClickListener.onItemLongClick(horizontalListView, childAt, i2, horizontalListView.f10345j.getItemId(i2))) {
                    HorizontalListView.this.performHapticFeedback(0);
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            HorizontalListView.this.O(Boolean.TRUE);
            HorizontalListView.this.setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_TOUCH_SCROLL);
            HorizontalListView.this.T();
            HorizontalListView horizontalListView = HorizontalListView.this;
            horizontalListView.r += (int) distanceX;
            horizontalListView.U(Math.round(distanceX));
            HorizontalListView.this.requestLayout();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e2) {
            HorizontalListView.this.T();
            AdapterView.OnItemClickListener onItemClickListener = HorizontalListView.this.getOnItemClickListener();
            int x = HorizontalListView.this.x((int) e2.getX(), (int) e2.getY());
            if (x >= 0 && !HorizontalListView.this.F) {
                View childAt = HorizontalListView.this.getChildAt(x);
                int i2 = HorizontalListView.this.u + x;
                if (onItemClickListener != null) {
                    HorizontalListView horizontalListView = HorizontalListView.this;
                    onItemClickListener.onItemClick(horizontalListView, childAt, i2, horizontalListView.f10345j.getItemId(i2));
                    return true;
                }
            }
            if (HorizontalListView.this.H == null || HorizontalListView.this.F) {
                return false;
            }
            HorizontalListView.this.H.onClick(HorizontalListView.this);
            return false;
        }

        /* synthetic */ b(HorizontalListView horizontalListView, a aVar) {
            this();
        }
    }

    @TargetApi(11)
    private static final class c {
        private c() {
        }

        public static void a(Scroller scroller, float friction) {
            if (scroller != null) {
                scroller.setFriction(friction);
            }
        }
    }

    @TargetApi(14)
    private static final class d {
        private d() {
        }

        public static float a(Scroller scroller) {
            return scroller.getCurrVelocity();
        }
    }

    public interface e {
        void a();
    }

    public HorizontalListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f10342g = new Scroller(getContext());
        this.k = new ArrayList();
        this.l = false;
        this.m = new Rect();
        this.n = null;
        this.o = 0;
        this.p = null;
        this.s = null;
        this.t = Integer.MAX_VALUE;
        this.x = null;
        this.y = 0;
        this.z = false;
        this.A = null;
        this.B = OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE;
        this.F = false;
        this.G = false;
        this.I = new a();
        this.J = new Runnable() { // from class: com.martian.libmars.widget.h
            @Override // java.lang.Runnable
            public final void run() {
                HorizontalListView.this.requestLayout();
            }
        };
        this.C = new EdgeEffectCompat(context);
        this.D = new EdgeEffectCompat(context);
        this.f10343h = new GestureDetector(context, new b(this, null));
        m();
        A();
        Q(context, attrs);
        setWillNotDraw(false);
        c.a(this.f10342g, f10339d);
    }

    private void A() {
        this.u = -1;
        this.v = -1;
        this.f10344i = 0;
        this.q = 0;
        this.r = 0;
        this.t = Integer.MAX_VALUE;
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
    }

    private void B(int viewTypeCount) {
        this.k.clear();
        for (int i2 = 0; i2 < viewTypeCount; i2++) {
            this.k.add(new LinkedList());
        }
    }

    private boolean C() {
        ListAdapter listAdapter = this.f10345j;
        return (listAdapter == null || listAdapter.isEmpty() || this.t <= 0) ? false : true;
    }

    private boolean D(int itemViewType) {
        return itemViewType < this.k.size();
    }

    private boolean E(int index) {
        return index == this.f10345j.getCount() - 1;
    }

    /* renamed from: F */
    public /* synthetic */ boolean G(View v, MotionEvent event) {
        return this.f10343h.onTouchEvent(event);
    }

    private void H(View child) {
        ViewGroup.LayoutParams y = y(child);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.E, getPaddingTop() + getPaddingBottom(), y.height);
        int i2 = y.width;
        child.measure(i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0), childMeasureSpec);
    }

    private void K(final int dx) {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i2 = this.f10344i + dx;
            this.f10344i = i2;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                int paddingLeft = getPaddingLeft() + i2;
                int paddingTop = getPaddingTop();
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                i2 += childAt.getMeasuredWidth() + this.o;
            }
        }
    }

    private void L(int adapterIndex, View view) {
        int itemViewType = this.f10345j.getItemViewType(adapterIndex);
        if (D(itemViewType)) {
            this.k.get(itemViewType).offer(view);
        }
    }

    private void M() {
        EdgeEffectCompat edgeEffectCompat = this.C;
        if (edgeEffectCompat != null) {
            edgeEffectCompat.onRelease();
        }
        EdgeEffectCompat edgeEffectCompat2 = this.D;
        if (edgeEffectCompat2 != null) {
            edgeEffectCompat2.onRelease();
        }
    }

    private void N(final int dx) {
        View leftmostChild = getLeftmostChild();
        while (leftmostChild != null && leftmostChild.getRight() + dx <= 0) {
            this.f10344i += E(this.u) ? leftmostChild.getMeasuredWidth() : this.o + leftmostChild.getMeasuredWidth();
            L(this.u, leftmostChild);
            removeViewInLayout(leftmostChild);
            this.u++;
            leftmostChild = getLeftmostChild();
        }
        View rightmostChild = getRightmostChild();
        while (rightmostChild != null && rightmostChild.getLeft() + dx >= getWidth()) {
            L(this.v, rightmostChild);
            removeViewInLayout(rightmostChild);
            this.v--;
            rightmostChild = getRightmostChild();
        }
    }

    public void O(Boolean disallowIntercept) {
        if (this.G != disallowIntercept.booleanValue()) {
            for (View view = this; view.getParent() instanceof View; view = (View) view.getParent()) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(disallowIntercept.booleanValue());
                    this.G = disallowIntercept.booleanValue();
                    return;
                }
            }
        }
    }

    public void P() {
        A();
        removeAllViewsInLayout();
        requestLayout();
    }

    private void Q(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.HorizontalListView);
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.HorizontalListView_android_divider);
            if (drawable != null) {
                setDivider(drawable);
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.HorizontalListView_dividerWidth, 0);
            if (dimensionPixelSize != 0) {
                setDividerWidth(dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void T() {
        View view = this.n;
        if (view != null) {
            view.setPressed(false);
            refreshDrawableState();
            this.n = null;
        }
    }

    public void U(final int scrolledOffset) {
        if (this.C == null || this.D == null) {
            return;
        }
        int i2 = this.q + scrolledOffset;
        Scroller scroller = this.f10342g;
        if (scroller == null || scroller.isFinished()) {
            if (i2 < 0) {
                this.C.onPull(Math.abs(scrolledOffset) / getRenderWidth());
                if (this.D.isFinished()) {
                    return;
                }
                this.D.onRelease();
                return;
            }
            if (i2 > this.t) {
                this.D.onPull(Math.abs(scrolledOffset) / getRenderWidth());
                if (this.C.isFinished()) {
                    return;
                }
                this.C.onRelease();
            }
        }
    }

    private View getLeftmostChild() {
        return getChildAt(0);
    }

    private int getRenderHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getRenderWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private View getRightmostChild() {
        return getChildAt(getChildCount() - 1);
    }

    private void l(final View child, int viewPos) {
        addViewInLayout(child, viewPos, y(child), true);
        H(child);
    }

    private void m() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.libmars.widget.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return HorizontalListView.this.G(view, motionEvent);
            }
        });
    }

    private float n() {
        return Build.VERSION.SDK_INT >= 14 ? d.a(this.f10342g) : f10338c;
    }

    private void o() {
        ListAdapter listAdapter;
        if (this.x == null || (listAdapter = this.f10345j) == null || listAdapter.getCount() - (this.v + 1) >= this.y || this.z) {
            return;
        }
        this.z = true;
        this.x.a();
    }

    private boolean p() {
        View rightmostChild;
        if (!E(this.v) || (rightmostChild = getRightmostChild()) == null) {
            return false;
        }
        int i2 = this.t;
        int right = (this.q + (rightmostChild.getRight() - getPaddingLeft())) - getRenderWidth();
        this.t = right;
        if (right < 0) {
            this.t = 0;
        }
        return this.t != i2;
    }

    private void q(Canvas canvas, Rect bounds) {
        Drawable drawable = this.p;
        if (drawable != null) {
            drawable.setBounds(bounds);
            this.p.draw(canvas);
        }
    }

    private void r(Canvas canvas) {
        int childCount = getChildCount();
        Rect rect = this.m;
        rect.top = getPaddingTop();
        Rect rect2 = this.m;
        rect2.bottom = rect2.top + getRenderHeight();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (i2 != childCount - 1 || !E(this.v)) {
                View childAt = getChildAt(i2);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.o;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                q(canvas, rect);
                if (i2 == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    q(canvas, rect);
                }
            }
        }
    }

    private void s(Canvas canvas) {
        EdgeEffectCompat edgeEffectCompat = this.C;
        if (edgeEffectCompat != null && !edgeEffectCompat.isFinished() && C()) {
            int save = canvas.save();
            int height = getHeight();
            canvas.rotate(-90.0f, 0.0f, 0.0f);
            canvas.translate((-height) + getPaddingBottom(), 0.0f);
            this.C.setSize(getRenderHeight(), getRenderWidth());
            if (this.C.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(save);
            return;
        }
        EdgeEffectCompat edgeEffectCompat2 = this.D;
        if (edgeEffectCompat2 == null || edgeEffectCompat2.isFinished() || !C()) {
            return;
        }
        int save2 = canvas.save();
        int width = getWidth();
        canvas.rotate(90.0f, 0.0f, 0.0f);
        canvas.translate(getPaddingTop(), -width);
        this.D.setSize(getRenderHeight(), getRenderWidth());
        if (this.D.draw(canvas)) {
            invalidate();
        }
        canvas.restoreToCount(save2);
    }

    public void setCurrentScrollState(OnScrollStateChangedListener.ScrollState newScrollState) {
        OnScrollStateChangedListener onScrollStateChangedListener;
        if (this.B != newScrollState && (onScrollStateChangedListener = this.A) != null) {
            onScrollStateChangedListener.a(newScrollState);
        }
        this.B = newScrollState;
    }

    private void t(final int dx) {
        View rightmostChild = getRightmostChild();
        v(rightmostChild != null ? rightmostChild.getRight() : 0, dx);
        View leftmostChild = getLeftmostChild();
        u(leftmostChild != null ? leftmostChild.getLeft() : 0, dx);
    }

    private void u(int leftEdge, final int dx) {
        int i2;
        while ((leftEdge + dx) - this.o > 0 && (i2 = this.u) >= 1) {
            int i3 = i2 - 1;
            this.u = i3;
            View view = this.f10345j.getView(i3, z(i3), this);
            l(view, 0);
            leftEdge -= this.u == 0 ? view.getMeasuredWidth() : this.o + view.getMeasuredWidth();
            this.f10344i -= leftEdge + dx == 0 ? view.getMeasuredWidth() : view.getMeasuredWidth() + this.o;
        }
    }

    private void v(int rightEdge, final int dx) {
        while (rightEdge + dx + this.o < getWidth() && this.v + 1 < this.f10345j.getCount()) {
            int i2 = this.v + 1;
            this.v = i2;
            if (this.u < 0) {
                this.u = i2;
            }
            View view = this.f10345j.getView(i2, z(i2), this);
            l(view, -1);
            rightEdge += (this.v == 0 ? 0 : this.o) + view.getMeasuredWidth();
            o();
        }
    }

    private View w(int adapterIndex) {
        int i2 = this.u;
        if (adapterIndex < i2 || adapterIndex > this.v) {
            return null;
        }
        return getChildAt(adapterIndex - i2);
    }

    public int x(final int x, final int y) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).getHitRect(this.m);
            if (this.m.contains(x, y)) {
                return i2;
            }
        }
        return -1;
    }

    private ViewGroup.LayoutParams y(View child) {
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-2, -1) : layoutParams;
    }

    private View z(int adapterIndex) {
        int itemViewType = this.f10345j.getItemViewType(adapterIndex);
        if (D(itemViewType)) {
            return this.k.get(itemViewType).poll();
        }
        return null;
    }

    protected boolean I(MotionEvent e2) {
        int x;
        this.F = !this.f10342g.isFinished();
        this.f10342g.forceFinished(true);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        T();
        if (!this.F && (x = x((int) e2.getX(), (int) e2.getY())) >= 0) {
            View childAt = getChildAt(x);
            this.n = childAt;
            if (childAt != null) {
                childAt.setPressed(true);
                refreshDrawableState();
            }
        }
        return true;
    }

    protected boolean J(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        this.f10342g.fling(this.r, 0, (int) (-velocityX), 0, 0, this.t, 0, 0);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
        requestLayout();
        return true;
    }

    public void R(int x) {
        Scroller scroller = this.f10342g;
        int i2 = this.r;
        scroller.startScroll(i2, 0, x - i2, 0);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
        requestLayout();
    }

    public void S(e listener, int numberOfItemsLeftConsideredLow) {
        this.x = listener;
        this.y = numberOfItemsLeftConsideredLow;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        s(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean pressed) {
    }

    @Override // android.widget.AdapterView
    public int getFirstVisiblePosition() {
        return this.u;
    }

    @Override // android.widget.AdapterView
    public int getLastVisiblePosition() {
        return this.v;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i2 = this.q;
        if (i2 == 0) {
            return 0.0f;
        }
        if (i2 < horizontalFadingEdgeLength) {
            return i2 / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i2 = this.q;
        int i3 = this.t;
        if (i2 == i3) {
            return 0.0f;
        }
        if (i3 - i2 < horizontalFadingEdgeLength) {
            return (i3 - i2) / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return w(this.w);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        r(canvas);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    @SuppressLint({"WrongCall"})
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.f10345j == null) {
            return;
        }
        invalidate();
        if (this.l) {
            int i2 = this.q;
            A();
            removeAllViewsInLayout();
            this.r = i2;
            this.l = false;
        }
        Integer num = this.s;
        if (num != null) {
            this.r = num.intValue();
            this.s = null;
        }
        if (this.f10342g.computeScrollOffset()) {
            this.r = this.f10342g.getCurrX();
        }
        int i3 = this.r;
        if (i3 < 0) {
            this.r = 0;
            if (this.C.isFinished()) {
                this.C.onAbsorb((int) n());
            }
            this.f10342g.forceFinished(true);
            setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        } else {
            int i4 = this.t;
            if (i3 > i4) {
                this.r = i4;
                if (this.D.isFinished()) {
                    this.D.onAbsorb((int) n());
                }
                this.f10342g.forceFinished(true);
                setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
            }
        }
        int i5 = this.q - this.r;
        N(i5);
        t(i5);
        K(i5);
        this.q = this.r;
        if (p()) {
            onLayout(changed, left, top, right, bottom);
        } else if (!this.f10342g.isFinished()) {
            ViewCompat.postOnAnimation(this, this.J);
        } else if (this.B == OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING) {
            setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.E = heightMeasureSpec;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            this.s = Integer.valueOf(bundle.getInt(f10340e));
            super.onRestoreInstanceState(bundle.getParcelable(f10341f));
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f10341f, super.onSaveInstanceState());
        bundle.putInt(f10340e, this.q);
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 1) {
            Scroller scroller = this.f10342g;
            if (scroller == null || scroller.isFinished()) {
                setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
            }
            O(Boolean.FALSE);
            M();
        } else if (event.getAction() == 3) {
            T();
            M();
            O(Boolean.FALSE);
        }
        return super.onTouchEvent(event);
    }

    public void setDivider(Drawable divider) {
        this.p = divider;
        if (divider != null) {
            setDividerWidth(divider.getIntrinsicWidth());
        } else {
            setDividerWidth(0);
        }
    }

    public void setDividerWidth(int width) {
        this.o = width;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.AdapterView, android.view.View
    public void setOnClickListener(View.OnClickListener listener) {
        this.H = listener;
    }

    public void setOnScrollStateChangedListener(OnScrollStateChangedListener listener) {
        this.A = listener;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int position) {
        this.w = position;
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.f10345j;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter adapter) {
        ListAdapter listAdapter = this.f10345j;
        if (listAdapter != null) {
            listAdapter.unregisterDataSetObserver(this.I);
        }
        if (adapter != null) {
            this.z = false;
            this.f10345j = adapter;
            adapter.registerDataSetObserver(this.I);
        }
        ListAdapter listAdapter2 = this.f10345j;
        if (listAdapter2 != null) {
            B(listAdapter2.getViewTypeCount());
        }
        P();
    }
}
