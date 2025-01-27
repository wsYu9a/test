package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class KsSplashSlidePathView extends ImageView {
    private Path IM;
    private Paint IN;
    private float IO;
    private float IP;
    private float IQ;
    private float IR;
    private int IS;
    private a IT;
    private GestureDetector IU;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView$1 */
    public class AnonymousClass1 implements GestureDetector.OnGestureListener {
        public AnonymousClass1() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            if (KsSplashSlidePathView.this.IT == null) {
                return false;
            }
            KsSplashSlidePathView.this.IT.lL();
            return true;
        }
    }

    public interface a {
        void a(float f10, float f11, float f12, float f13);

        void lL();
    }

    public KsSplashSlidePathView(Context context) {
        super(context);
        this.IS = Color.parseColor("#66ffffff");
        init();
    }

    private void b(MotionEvent motionEvent) {
        if (this.IU.onTouchEvent(motionEvent)) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.IM.reset();
            this.IO = motionEvent.getX();
            float y10 = motionEvent.getY();
            this.IP = y10;
            float f10 = this.IO;
            this.IQ = f10;
            this.IR = y10;
            this.IM.moveTo(f10, y10);
            invalidate();
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                return;
            }
            c(motionEvent.getX(), motionEvent.getY());
            invalidate();
            return;
        }
        this.IM.reset();
        invalidate();
        a aVar = this.IT;
        if (aVar != null) {
            aVar.a(this.IO, this.IP, motionEvent.getX(), motionEvent.getY());
        }
    }

    private void c(float f10, float f11) {
        float abs = Math.abs(f10 - this.IQ);
        float abs2 = Math.abs(f11 - this.IR);
        if (abs >= 3.0f || abs2 >= 3.0f) {
            Path path = this.IM;
            float f12 = this.IQ;
            float f13 = this.IR;
            path.quadTo(f12, f13, (f10 + f12) / 2.0f, (f11 + f13) / 2.0f);
            this.IQ = f10;
            this.IR = f11;
        }
    }

    private void init() {
        this.IM = new Path();
        Paint paint = new Paint();
        this.IN = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.IN.setStrokeWidth(com.kwad.sdk.c.a.a.a(getContext(), 15.0f));
        this.IN.setStyle(Paint.Style.STROKE);
        this.IN.setColor(this.IS);
        this.IN.setDither(true);
        this.IU = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.1
            public AnonymousClass1() {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                if (KsSplashSlidePathView.this.IT == null) {
                    return false;
                }
                KsSplashSlidePathView.this.IT.lL();
                return true;
            }
        });
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.IM, this.IN);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b(motionEvent);
        return true;
    }

    public void setOnSlideTouchListener(a aVar) {
        this.IT = aVar;
    }

    public KsSplashSlidePathView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.IS = Color.parseColor("#66ffffff");
        init();
    }
}
