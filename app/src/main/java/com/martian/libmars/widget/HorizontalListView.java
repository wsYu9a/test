package com.martian.libmars.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import com.martian.libmars.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import n9.h;

/* loaded from: classes3.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    public static final int F = -1;
    public static final int G = 0;
    public static final float H = 30.0f;
    public static final float I = 0.009f;
    public static final String J = "BUNDLE_ID_CURRENT_X";
    public static final String K = "BUNDLE_ID_PARENT_STATE";
    public boolean A;
    public boolean B;
    public View.OnClickListener C;
    public final DataSetObserver D;
    public final Runnable E;

    /* renamed from: b */
    public Scroller f12628b;

    /* renamed from: c */
    public final GestureDetector f12629c;

    /* renamed from: d */
    public int f12630d;

    /* renamed from: e */
    public ListAdapter f12631e;

    /* renamed from: f */
    public final List<Queue<View>> f12632f;

    /* renamed from: g */
    public boolean f12633g;

    /* renamed from: h */
    public final Rect f12634h;

    /* renamed from: i */
    public View f12635i;

    /* renamed from: j */
    public int f12636j;

    /* renamed from: k */
    public Drawable f12637k;

    /* renamed from: l */
    public int f12638l;

    /* renamed from: m */
    public int f12639m;

    /* renamed from: n */
    public Integer f12640n;

    /* renamed from: o */
    public int f12641o;

    /* renamed from: p */
    public int f12642p;

    /* renamed from: q */
    public int f12643q;

    /* renamed from: r */
    public int f12644r;

    /* renamed from: s */
    public e f12645s;

    /* renamed from: t */
    public int f12646t;

    /* renamed from: u */
    public boolean f12647u;

    /* renamed from: v */
    public OnScrollStateChangedListener f12648v;

    /* renamed from: w */
    public OnScrollStateChangedListener.ScrollState f12649w;

    /* renamed from: x */
    public final EdgeEffectCompat f12650x;

    /* renamed from: y */
    public final EdgeEffectCompat f12651y;

    /* renamed from: z */
    public int f12652z;

    public interface OnScrollStateChangedListener {

        public enum ScrollState {
            SCROLL_STATE_IDLE,
            SCROLL_STATE_TOUCH_SCROLL,
            SCROLL_STATE_FLING
        }

        void a(ScrollState scrollState);
    }

    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            HorizontalListView.this.f12633g = true;
            HorizontalListView.this.f12647u = false;
            HorizontalListView.this.T();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            HorizontalListView.this.f12647u = false;
            HorizontalListView.this.T();
            HorizontalListView.this.P();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public /* synthetic */ b(HorizontalListView horizontalListView, h hVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return HorizontalListView.this.I(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            return HorizontalListView.this.J(motionEvent, motionEvent2, f10, f11);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            HorizontalListView.this.T();
            int y10 = HorizontalListView.this.y((int) motionEvent.getX(), (int) motionEvent.getY());
            if (y10 < 0 || HorizontalListView.this.A) {
                return;
            }
            View childAt = HorizontalListView.this.getChildAt(y10);
            AdapterView.OnItemLongClickListener onItemLongClickListener = HorizontalListView.this.getOnItemLongClickListener();
            if (onItemLongClickListener != null) {
                int i10 = HorizontalListView.this.f12642p + y10;
                HorizontalListView horizontalListView = HorizontalListView.this;
                if (onItemLongClickListener.onItemLongClick(horizontalListView, childAt, i10, horizontalListView.f12631e.getItemId(i10))) {
                    HorizontalListView.this.performHapticFeedback(0);
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            HorizontalListView.this.O(Boolean.TRUE);
            HorizontalListView.this.setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_TOUCH_SCROLL);
            HorizontalListView.this.T();
            HorizontalListView horizontalListView = HorizontalListView.this;
            horizontalListView.f12639m += (int) f10;
            horizontalListView.U(Math.round(f10));
            HorizontalListView.this.requestLayout();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            HorizontalListView.this.T();
            AdapterView.OnItemClickListener onItemClickListener = HorizontalListView.this.getOnItemClickListener();
            int y10 = HorizontalListView.this.y((int) motionEvent.getX(), (int) motionEvent.getY());
            if (y10 >= 0 && !HorizontalListView.this.A) {
                View childAt = HorizontalListView.this.getChildAt(y10);
                int i10 = HorizontalListView.this.f12642p + y10;
                if (onItemClickListener != null) {
                    HorizontalListView horizontalListView = HorizontalListView.this;
                    onItemClickListener.onItemClick(horizontalListView, childAt, i10, horizontalListView.f12631e.getItemId(i10));
                    return true;
                }
            }
            if (HorizontalListView.this.C == null || HorizontalListView.this.A) {
                return false;
            }
            HorizontalListView.this.C.onClick(HorizontalListView.this);
            return false;
        }

        public b() {
        }
    }

    public static final class c {
        public static void a(Scroller scroller, float f10) {
            if (scroller != null) {
                scroller.setFriction(f10);
            }
        }
    }

    public static final class d {
        public static float a(Scroller scroller) {
            return scroller.getCurrVelocity();
        }
    }

    public interface e {
        void a();
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12628b = new Scroller(getContext());
        this.f12632f = new ArrayList();
        this.f12633g = false;
        this.f12634h = new Rect();
        this.f12635i = null;
        this.f12636j = 0;
        this.f12637k = null;
        this.f12640n = null;
        this.f12641o = Integer.MAX_VALUE;
        this.f12645s = null;
        this.f12646t = 0;
        this.f12647u = false;
        this.f12648v = null;
        this.f12649w = OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE;
        this.A = false;
        this.B = false;
        this.D = new a();
        this.E = new Runnable() { // from class: n9.f
            public /* synthetic */ f() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                HorizontalListView.this.requestLayout();
            }
        };
        this.f12650x = new EdgeEffectCompat(context);
        this.f12651y = new EdgeEffectCompat(context);
        this.f12629c = new GestureDetector(context, new b());
        n();
        B();
        Q(context, attributeSet);
        setWillNotDraw(false);
        c.a(this.f12628b, 0.009f);
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

    public void setCurrentScrollState(OnScrollStateChangedListener.ScrollState scrollState) {
        OnScrollStateChangedListener onScrollStateChangedListener;
        if (this.f12649w != scrollState && (onScrollStateChangedListener = this.f12648v) != null) {
            onScrollStateChangedListener.a(scrollState);
        }
        this.f12649w = scrollState;
    }

    public final View A(int i10) {
        int itemViewType = this.f12631e.getItemViewType(i10);
        if (E(itemViewType)) {
            return this.f12632f.get(itemViewType).poll();
        }
        return null;
    }

    public final void B() {
        this.f12642p = -1;
        this.f12643q = -1;
        this.f12630d = 0;
        this.f12638l = 0;
        this.f12639m = 0;
        this.f12641o = Integer.MAX_VALUE;
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
    }

    public final void C(int i10) {
        this.f12632f.clear();
        for (int i11 = 0; i11 < i10; i11++) {
            this.f12632f.add(new LinkedList());
        }
    }

    public final boolean D() {
        ListAdapter listAdapter = this.f12631e;
        return (listAdapter == null || listAdapter.isEmpty() || this.f12641o <= 0) ? false : true;
    }

    public final boolean E(int i10) {
        return i10 < this.f12632f.size();
    }

    public final boolean F(int i10) {
        return i10 == this.f12631e.getCount() - 1;
    }

    public final /* synthetic */ boolean G(View view, MotionEvent motionEvent) {
        return this.f12629c.onTouchEvent(motionEvent);
    }

    public final void H(View view) {
        ViewGroup.LayoutParams z10 = z(view);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f12652z, getPaddingTop() + getPaddingBottom(), z10.height);
        int i10 = z10.width;
        view.measure(i10 > 0 ? View.MeasureSpec.makeMeasureSpec(i10, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0), childMeasureSpec);
    }

    public boolean I(MotionEvent motionEvent) {
        int y10;
        this.A = !this.f12628b.isFinished();
        this.f12628b.forceFinished(true);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        T();
        if (!this.A && (y10 = y((int) motionEvent.getX(), (int) motionEvent.getY())) >= 0) {
            View childAt = getChildAt(y10);
            this.f12635i = childAt;
            if (childAt != null) {
                childAt.setPressed(true);
                refreshDrawableState();
            }
        }
        return true;
    }

    public boolean J(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        this.f12628b.fling(this.f12639m, 0, (int) (-f10), 0, 0, this.f12641o, 0, 0);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
        requestLayout();
        return true;
    }

    public final void K(int i10) {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i11 = this.f12630d + i10;
            this.f12630d = i11;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                int paddingLeft = getPaddingLeft() + i11;
                int paddingTop = getPaddingTop();
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                i11 += childAt.getMeasuredWidth() + this.f12636j;
            }
        }
    }

    public final void L(int i10, View view) {
        int itemViewType = this.f12631e.getItemViewType(i10);
        if (E(itemViewType)) {
            this.f12632f.get(itemViewType).offer(view);
        }
    }

    public final void M() {
        EdgeEffectCompat edgeEffectCompat = this.f12650x;
        if (edgeEffectCompat != null) {
            edgeEffectCompat.onRelease();
        }
        EdgeEffectCompat edgeEffectCompat2 = this.f12651y;
        if (edgeEffectCompat2 != null) {
            edgeEffectCompat2.onRelease();
        }
    }

    public final void N(int i10) {
        View leftmostChild = getLeftmostChild();
        while (leftmostChild != null && leftmostChild.getRight() + i10 <= 0) {
            this.f12630d += F(this.f12642p) ? leftmostChild.getMeasuredWidth() : this.f12636j + leftmostChild.getMeasuredWidth();
            L(this.f12642p, leftmostChild);
            removeViewInLayout(leftmostChild);
            this.f12642p++;
            leftmostChild = getLeftmostChild();
        }
        View rightmostChild = getRightmostChild();
        while (rightmostChild != null && rightmostChild.getLeft() + i10 >= getWidth()) {
            L(this.f12643q, rightmostChild);
            removeViewInLayout(rightmostChild);
            this.f12643q--;
            rightmostChild = getRightmostChild();
        }
    }

    public final void O(Boolean bool) {
        if (this.B != bool.booleanValue()) {
            for (View view = this; view.getParent() instanceof View; view = (View) view.getParent()) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.B = bool.booleanValue();
                    return;
                }
            }
        }
    }

    public final void P() {
        B();
        removeAllViewsInLayout();
        requestLayout();
    }

    public final void Q(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HorizontalListView);
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

    public void R(int i10) {
        Scroller scroller = this.f12628b;
        int i11 = this.f12639m;
        scroller.startScroll(i11, 0, i10 - i11, 0);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
        requestLayout();
    }

    public void S(e eVar, int i10) {
        this.f12645s = eVar;
        this.f12646t = i10;
    }

    public final void T() {
        View view = this.f12635i;
        if (view != null) {
            view.setPressed(false);
            refreshDrawableState();
            this.f12635i = null;
        }
    }

    public final void U(int i10) {
        if (this.f12650x == null || this.f12651y == null) {
            return;
        }
        int i11 = this.f12638l + i10;
        Scroller scroller = this.f12628b;
        if (scroller == null || scroller.isFinished()) {
            if (i11 < 0) {
                this.f12650x.onPull(Math.abs(i10) / getRenderWidth());
                if (this.f12651y.isFinished()) {
                    return;
                }
                this.f12651y.onRelease();
                return;
            }
            if (i11 > this.f12641o) {
                this.f12651y.onPull(Math.abs(i10) / getRenderWidth());
                if (this.f12650x.isFinished()) {
                    return;
                }
                this.f12650x.onRelease();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        t(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z10) {
    }

    @Override // android.widget.AdapterView
    public int getFirstVisiblePosition() {
        return this.f12642p;
    }

    @Override // android.widget.AdapterView
    public int getLastVisiblePosition() {
        return this.f12643q;
    }

    @Override // android.view.View
    public float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i10 = this.f12638l;
        if (i10 == 0) {
            return 0.0f;
        }
        if (i10 < horizontalFadingEdgeLength) {
            return i10 / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    public float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i10 = this.f12638l;
        int i11 = this.f12641o;
        if (i10 == i11) {
            return 0.0f;
        }
        if (i11 - i10 < horizontalFadingEdgeLength) {
            return (i11 - i10) / horizontalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return x(this.f12644r);
    }

    public final void m(View view, int i10) {
        addViewInLayout(view, i10, z(view), true);
        H(view);
    }

    public final void n() {
        setOnTouchListener(new View.OnTouchListener() { // from class: n9.g
            public /* synthetic */ g() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean G2;
                G2 = HorizontalListView.this.G(view, motionEvent);
                return G2;
            }
        });
    }

    public final float o() {
        return d.a(this.f12628b);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        s(canvas);
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    @SuppressLint({"WrongCall"})
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f12631e == null) {
            return;
        }
        invalidate();
        if (this.f12633g) {
            int i14 = this.f12638l;
            B();
            removeAllViewsInLayout();
            this.f12639m = i14;
            this.f12633g = false;
        }
        Integer num = this.f12640n;
        if (num != null) {
            this.f12639m = num.intValue();
            this.f12640n = null;
        }
        if (this.f12628b.computeScrollOffset()) {
            this.f12639m = this.f12628b.getCurrX();
        }
        int i15 = this.f12639m;
        if (i15 < 0) {
            this.f12639m = 0;
            if (this.f12650x.isFinished()) {
                this.f12650x.onAbsorb((int) o());
            }
            this.f12628b.forceFinished(true);
            setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        } else {
            int i16 = this.f12641o;
            if (i15 > i16) {
                this.f12639m = i16;
                if (this.f12651y.isFinished()) {
                    this.f12651y.onAbsorb((int) o());
                }
                this.f12628b.forceFinished(true);
                setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
            }
        }
        int i17 = this.f12638l - this.f12639m;
        N(i17);
        u(i17);
        K(i17);
        this.f12638l = this.f12639m;
        if (q()) {
            onLayout(z10, i10, i11, i12, i13);
        } else if (!this.f12628b.isFinished()) {
            ViewCompat.postOnAnimation(this, this.E);
        } else if (this.f12649w == OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING) {
            setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f12652z = i11;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f12640n = Integer.valueOf(bundle.getInt(J));
            super.onRestoreInstanceState(bundle.getParcelable(K));
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(K, super.onSaveInstanceState());
        bundle.putInt(J, this.f12638l);
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            Scroller scroller = this.f12628b;
            if (scroller == null || scroller.isFinished()) {
                setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
            }
            O(Boolean.FALSE);
            M();
        } else if (motionEvent.getAction() == 3) {
            T();
            M();
            O(Boolean.FALSE);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p() {
        ListAdapter listAdapter;
        if (this.f12645s == null || (listAdapter = this.f12631e) == null || listAdapter.getCount() - (this.f12643q + 1) >= this.f12646t || this.f12647u) {
            return;
        }
        this.f12647u = true;
        this.f12645s.a();
    }

    public final boolean q() {
        View rightmostChild;
        if (!F(this.f12643q) || (rightmostChild = getRightmostChild()) == null) {
            return false;
        }
        int i10 = this.f12641o;
        int right = (this.f12638l + (rightmostChild.getRight() - getPaddingLeft())) - getRenderWidth();
        this.f12641o = right;
        if (right < 0) {
            this.f12641o = 0;
        }
        return this.f12641o != i10;
    }

    public final void r(Canvas canvas, Rect rect) {
        Drawable drawable = this.f12637k;
        if (drawable != null) {
            drawable.setBounds(rect);
            this.f12637k.draw(canvas);
        }
    }

    public final void s(Canvas canvas) {
        int childCount = getChildCount();
        Rect rect = this.f12634h;
        rect.top = getPaddingTop();
        Rect rect2 = this.f12634h;
        rect2.bottom = rect2.top + getRenderHeight();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (i10 != childCount - 1 || !F(this.f12643q)) {
                View childAt = getChildAt(i10);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.f12636j;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                r(canvas, rect);
                if (i10 == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    r(canvas, rect);
                }
            }
        }
    }

    public void setDivider(Drawable drawable) {
        this.f12637k = drawable;
        if (drawable != null) {
            setDividerWidth(drawable.getIntrinsicWidth());
        } else {
            setDividerWidth(0);
        }
    }

    public void setDividerWidth(int i10) {
        this.f12636j = i10;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.AdapterView, android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.C = onClickListener;
    }

    public void setOnScrollStateChangedListener(OnScrollStateChangedListener onScrollStateChangedListener) {
        this.f12648v = onScrollStateChangedListener;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i10) {
        this.f12644r = i10;
    }

    public final void t(Canvas canvas) {
        EdgeEffectCompat edgeEffectCompat = this.f12650x;
        if (edgeEffectCompat != null && !edgeEffectCompat.isFinished() && D()) {
            int save = canvas.save();
            int height = getHeight();
            canvas.rotate(-90.0f, 0.0f, 0.0f);
            canvas.translate((-height) + getPaddingBottom(), 0.0f);
            this.f12650x.setSize(getRenderHeight(), getRenderWidth());
            if (this.f12650x.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(save);
            return;
        }
        EdgeEffectCompat edgeEffectCompat2 = this.f12651y;
        if (edgeEffectCompat2 == null || edgeEffectCompat2.isFinished() || !D()) {
            return;
        }
        int save2 = canvas.save();
        int width = getWidth();
        canvas.rotate(90.0f, 0.0f, 0.0f);
        canvas.translate(getPaddingTop(), -width);
        this.f12651y.setSize(getRenderHeight(), getRenderWidth());
        if (this.f12651y.draw(canvas)) {
            invalidate();
        }
        canvas.restoreToCount(save2);
    }

    public final void u(int i10) {
        View rightmostChild = getRightmostChild();
        w(rightmostChild != null ? rightmostChild.getRight() : 0, i10);
        View leftmostChild = getLeftmostChild();
        v(leftmostChild != null ? leftmostChild.getLeft() : 0, i10);
    }

    public final void v(int i10, int i11) {
        int i12;
        while ((i10 + i11) - this.f12636j > 0 && (i12 = this.f12642p) >= 1) {
            int i13 = i12 - 1;
            this.f12642p = i13;
            View view = this.f12631e.getView(i13, A(i13), this);
            m(view, 0);
            i10 -= this.f12642p == 0 ? view.getMeasuredWidth() : this.f12636j + view.getMeasuredWidth();
            this.f12630d -= i10 + i11 == 0 ? view.getMeasuredWidth() : view.getMeasuredWidth() + this.f12636j;
        }
    }

    public final void w(int i10, int i11) {
        while (i10 + i11 + this.f12636j < getWidth() && this.f12643q + 1 < this.f12631e.getCount()) {
            int i12 = this.f12643q + 1;
            this.f12643q = i12;
            if (this.f12642p < 0) {
                this.f12642p = i12;
            }
            View view = this.f12631e.getView(i12, A(i12), this);
            m(view, -1);
            i10 += (this.f12643q == 0 ? 0 : this.f12636j) + view.getMeasuredWidth();
            p();
        }
    }

    public final View x(int i10) {
        int i11 = this.f12642p;
        if (i10 < i11 || i10 > this.f12643q) {
            return null;
        }
        return getChildAt(i10 - i11);
    }

    public final int y(int i10, int i11) {
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            getChildAt(i12).getHitRect(this.f12634h);
            if (this.f12634h.contains(i10, i11)) {
                return i12;
            }
        }
        return -1;
    }

    public final ViewGroup.LayoutParams z(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-2, -1) : layoutParams;
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.f12631e;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.f12631e;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.D);
        }
        if (listAdapter != null) {
            this.f12647u = false;
            this.f12631e = listAdapter;
            listAdapter.registerDataSetObserver(this.D);
        }
        ListAdapter listAdapter3 = this.f12631e;
        if (listAdapter3 != null) {
            C(listAdapter3.getViewTypeCount());
        }
        P();
    }
}
