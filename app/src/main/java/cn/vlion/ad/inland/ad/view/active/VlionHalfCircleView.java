package cn.vlion.ad.inland.ad.view.active;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.f;
import cn.vlion.ad.inland.base.g7;
import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.y;
import l5.c;

/* loaded from: classes.dex */
public class VlionHalfCircleView extends View implements View.OnTouchListener {

    /* renamed from: a */
    public Paint f2411a;

    /* renamed from: b */
    public i0 f2412b;

    /* renamed from: c */
    public b f2413c;

    /* renamed from: d */
    public float f2414d;

    /* renamed from: e */
    public float f2415e;

    /* renamed from: f */
    public GestureDetector f2416f;

    /* renamed from: g */
    public RectF f2417g;

    /* renamed from: h */
    public int f2418h;

    /* renamed from: i */
    public g7 f2419i;

    /* renamed from: j */
    public boolean f2420j;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            try {
                VlionHalfCircleView.this.f2414d = motionEvent.getRawX();
                VlionHalfCircleView.this.f2415e = motionEvent.getRawY();
                LogVlion.e("VlionHalfCircleView ACTION_DOWN lastX=" + motionEvent.getX() + " lastY=" + motionEvent.getY());
                return true;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            return super.onFling(motionEvent, motionEvent2, f10, f11);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            return super.onScroll(motionEvent, motionEvent2, f10, f11);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            try {
                VlionHalfCircleView.this.f2420j = false;
                if (VlionHalfCircleView.a(VlionHalfCircleView.this, motionEvent.getX(), motionEvent.getY())) {
                    VlionHalfCircleView.this.f2420j = true;
                    LogVlion.e("VlionHalfCircleView   ACTION_UP isArea = " + VlionHalfCircleView.this.f2420j);
                    b bVar = VlionHalfCircleView.this.f2413c;
                    if (bVar != null) {
                        ((f) bVar).a();
                        return true;
                    }
                } else {
                    LogVlion.e("VlionHalfCircleView   ACTION_UP isArea = " + VlionHalfCircleView.this.f2420j);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            return true;
        }
    }

    public interface b {
    }

    public VlionHalfCircleView(Context context) {
        super(context);
        this.f2414d = 0.0f;
        this.f2415e = 0.0f;
        this.f2420j = false;
        a();
    }

    public final void a() {
        try {
            Paint paint = new Paint();
            this.f2411a = paint;
            paint.setColor(getResources().getColor(R.color.vlion_custom_tran_30_black_color));
            this.f2411a.setStyle(Paint.Style.FILL);
            this.f2411a.setAntiAlias(true);
            setOnTouchListener(this);
            this.f2416f = new GestureDetector(getContext(), new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public float getRawX() {
        float f10 = this.f2414d;
        try {
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        if (f10 != 0.0f) {
            this.f2414d = 0.0f;
            return f10;
        }
        LogVlion.e("ViewOnTouchDataUtils-=  注意：：-----监听的View  与 点击的View 不一致~~！！请确认 ==");
        return f10;
    }

    public String getRawXY() {
        String str = this.f2414d + "," + this.f2415e;
        y.a("ViewOnTouchDataUtils getRawXY=", str);
        return str;
    }

    public float getRawY() {
        float f10 = this.f2415e;
        try {
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        if (f10 != 0.0f) {
            this.f2415e = 0.0f;
            return f10;
        }
        LogVlion.e("ViewOnTouchDataUtils-=  注意：：-----监听的View  与 点击的View 不一致~~！！请确认 ==");
        return this.f2415e;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            float f10 = this.f2418h;
            this.f2417g = new RectF(0.0f, 0.0f, f10, f10);
            canvas.translate(0.0f, 0.0f);
            canvas.drawArc(this.f2417g, 180.0f, 180.0f, true, this.f2411a);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        try {
            int size = View.MeasureSpec.getSize(i10);
            View.MeasureSpec.getSize(i11);
            this.f2418h = size;
            setMeasuredDimension(size, size / 2);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            g7 g7Var = this.f2419i;
            if (g7Var != null) {
                g7Var.a(motionEvent);
            }
            i0 i0Var = this.f2412b;
            if (i0Var != null) {
                i0Var.onTouch(this, motionEvent);
            }
            GestureDetector gestureDetector = this.f2416f;
            if (gestureDetector != null) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
            return false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public void setListener(b bVar) {
        this.f2413c = bVar;
    }

    public void setOnTouchDataUtils(i0 i0Var) {
        this.f2412b = i0Var;
    }

    public void settingVlionViewTouch(g7 g7Var) {
        this.f2419i = g7Var;
    }

    public VlionHalfCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2414d = 0.0f;
        this.f2415e = 0.0f;
        this.f2420j = false;
        a();
    }

    public static boolean a(VlionHalfCircleView vlionHalfCircleView, float f10, float f11) {
        vlionHalfCircleView.getClass();
        try {
            int i10 = vlionHalfCircleView.f2418h / 2;
            float f12 = f10 - (r3 / 2);
            float f13 = f11 - (r3 / 2);
            double sqrt = Math.sqrt((f13 * f13) + (f12 * f12));
            return sqrt <= ((double) i10) && sqrt >= c.f27899e;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return false;
        }
    }

    public VlionHalfCircleView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2414d = 0.0f;
        this.f2415e = 0.0f;
        this.f2420j = false;
        a();
    }
}
