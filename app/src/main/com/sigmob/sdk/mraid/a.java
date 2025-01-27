package com.sigmob.sdk.mraid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Preconditions;

/* loaded from: classes4.dex */
public class a extends FrameLayout {

    /* renamed from: o */
    public static final float f19455o = 30.0f;

    /* renamed from: p */
    public static final float f19456p = 50.0f;

    /* renamed from: q */
    public static final float f19457q = 8.0f;

    /* renamed from: a */
    public final int f19458a;

    /* renamed from: b */
    public c f19459b;

    /* renamed from: c */
    public final StateListDrawable f19460c;

    /* renamed from: d */
    public b f19461d;

    /* renamed from: e */
    public final int f19462e;

    /* renamed from: f */
    public final int f19463f;

    /* renamed from: g */
    public final int f19464g;

    /* renamed from: h */
    public boolean f19465h;

    /* renamed from: i */
    public final Rect f19466i;

    /* renamed from: j */
    public final Rect f19467j;

    /* renamed from: k */
    public final Rect f19468k;

    /* renamed from: l */
    public final Rect f19469l;

    /* renamed from: m */
    public boolean f19470m;

    /* renamed from: n */
    public d f19471n;

    public enum b {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);


        /* renamed from: a */
        public final int f19480a;

        b(int i10) {
            this.f19480a = i10;
        }

        public int b() {
            return this.f19480a;
        }
    }

    public interface c {
        void a();
    }

    public final class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.setClosePressed(false);
        }

        public /* synthetic */ d(a aVar, C0592a c0592a) {
            this();
        }
    }

    public a(Context context) {
        this(context, null, 0);
    }

    public void setClosePressed(boolean z10) {
        if (z10 == a()) {
            return;
        }
        this.f19460c.setState(z10 ? FrameLayout.SELECTED_STATE_SET : FrameLayout.EMPTY_STATE_SET);
        invalidate(this.f19467j);
    }

    public void b(b bVar, Rect rect, Rect rect2) {
        a(bVar, this.f19462e, rect, rect2);
    }

    public boolean c() {
        return this.f19470m || this.f19460c.isVisible();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f19465h) {
            this.f19465h = false;
            this.f19466i.set(0, 0, getWidth(), getHeight());
            b(this.f19461d, this.f19466i, this.f19467j);
            this.f19469l.set(this.f19467j);
            Rect rect = this.f19469l;
            int i10 = this.f19464g;
            rect.inset(i10, i10);
            a(this.f19461d, this.f19469l, this.f19468k);
            this.f19460c.setBounds(this.f19468k);
        }
        if (this.f19460c.isVisible()) {
            this.f19460c.draw(canvas);
        }
    }

    public Rect getCloseBounds() {
        return this.f19467j;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return a((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f19465h = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!a((int) motionEvent.getX(), (int) motionEvent.getY(), this.f19458a) || !c()) {
            setClosePressed(false);
            super.onTouchEvent(motionEvent);
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setClosePressed(true);
        } else if (action != 1) {
            if (action == 3) {
                setClosePressed(false);
            }
        } else if (a()) {
            if (this.f19471n == null) {
                this.f19471n = new d();
            }
            postDelayed(this.f19471n, ViewConfiguration.getPressedStateDuration());
            b();
        }
        return true;
    }

    public void setCloseAlwaysInteractable(boolean z10) {
        this.f19470m = z10;
    }

    public void setCloseBoundChanged(boolean z10) {
        this.f19465h = z10;
    }

    public void setCloseBounds(Rect rect) {
        this.f19467j.set(rect);
    }

    public void setClosePosition(b bVar) {
        Preconditions.checkNotNull(bVar);
        this.f19461d = bVar;
        this.f19465h = true;
        invalidate();
    }

    public void setCloseVisible(boolean z10) {
        if (this.f19460c.setVisible(z10, false)) {
            invalidate(this.f19467j);
        }
    }

    public void setOnCloseListener(c cVar) {
        this.f19459b = cVar;
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(b bVar, int i10, Rect rect, Rect rect2) {
        Gravity.apply(bVar.b(), i10, i10, rect, rect2);
    }

    public final void b() {
        playSoundEffect(0);
        c cVar = this.f19459b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19466i = new Rect();
        this.f19467j = new Rect();
        this.f19468k = new Rect();
        this.f19469l = new Rect();
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f19460c = stateListDrawable;
        this.f19461d = b.TOP_RIGHT;
        stateListDrawable.setState(FrameLayout.EMPTY_STATE_SET);
        stateListDrawable.setCallback(this);
        this.f19458a = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f19462e = Dips.asIntPixels(50.0f, context);
        this.f19463f = Dips.asIntPixels(30.0f, context);
        this.f19464g = Dips.asIntPixels(8.0f, context);
        setWillNotDraw(false);
        this.f19470m = true;
    }

    public final void a(b bVar, Rect rect, Rect rect2) {
        a(bVar, this.f19463f, rect, rect2);
    }

    public boolean a() {
        return this.f19460c.getState() == FrameLayout.SELECTED_STATE_SET;
    }

    public boolean a(int i10, int i11, int i12) {
        Rect rect = this.f19467j;
        return i10 >= rect.left - i12 && i11 >= rect.top - i12 && i10 < rect.right + i12 && i11 < rect.bottom + i12;
    }
}
