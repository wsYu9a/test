package com.shu.priory.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.shu.priory.R;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public class SplashContainer extends RelativeLayout {

    /* renamed from: a */
    private boolean f17234a;

    /* renamed from: b */
    private int f17235b;

    /* renamed from: c */
    private final a f17236c;

    /* renamed from: d */
    private int[] f17237d;

    public static class a {

        /* renamed from: a */
        private float f17238a;

        /* renamed from: b */
        private float f17239b;

        /* renamed from: c */
        private float f17240c;

        /* renamed from: d */
        private float f17241d;

        /* renamed from: e */
        private int f17242e = 1;

        public float a() {
            return this.f17238a;
        }

        public float b() {
            return this.f17239b;
        }

        public float c() {
            return this.f17240c;
        }

        public float d() {
            return this.f17241d;
        }

        public int e() {
            return this.f17242e;
        }

        public String toString() {
            return "TouchPosition{downX=" + this.f17238a + ", downY=" + this.f17239b + ", upX=" + this.f17240c + ", upY=" + this.f17241d + ", type=" + this.f17242e + '}';
        }
    }

    public SplashContainer(Context context) {
        super(context);
        this.f17236c = new a();
        this.f17237d = new int[3];
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f17236c.f17238a = motionEvent.getX();
            this.f17236c.f17239b = motionEvent.getY();
            this.f17236c.f17240c = 0.0f;
            this.f17236c.f17241d = 0.0f;
            return;
        }
        if (motionEvent.getAction() == 1) {
            this.f17236c.f17240c = motionEvent.getX();
            this.f17236c.f17241d = motionEvent.getY();
        }
    }

    public int[] getAcc() {
        return this.f17237d;
    }

    public a getTouchPosition() {
        return this.f17236c;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a(motionEvent);
        return this.f17234a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a(motionEvent);
        if (motionEvent.getAction() == 1) {
            if ((this.f17235b & 1) == 1 && this.f17236c.f17239b - this.f17236c.f17241d > 300.0f) {
                this.f17236c.f17242e = 3;
                h.b(SDKConstants.TAG, "onTouchEvent slide up");
                performClick();
                return true;
            }
            View findViewById = findViewById(R.id.ifly_skip_tv);
            if (a(motionEvent, findViewById)) {
                h.b(SDKConstants.TAG, "skip button clicked");
                findViewById.performClick();
                return true;
            }
            View findViewById2 = findViewById(R.id.ifly_splash_click);
            if ((this.f17235b & 2) == 2 || a(motionEvent, findViewById2)) {
                this.f17236c.f17242e = 1;
                h.b(SDKConstants.TAG, "onTouchEvent click");
                performClick();
                return true;
            }
        }
        return this.f17234a || super.onTouchEvent(motionEvent);
    }

    public void setAcc(int[] iArr) {
        this.f17237d = iArr;
    }

    public void setMask(int i10) {
        this.f17235b = i10;
        this.f17234a = i10 > 0;
    }

    public SplashContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17236c = new a();
        this.f17237d = new int[3];
    }

    private boolean a(MotionEvent motionEvent, View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        view.getLocationOnScreen(new int[2]);
        return rect.contains((int) (motionEvent.getRawX() - r2[0]), (int) (motionEvent.getRawY() - r2[1]));
    }

    public SplashContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f17236c = new a();
        this.f17237d = new int[3];
    }

    @RequiresApi(api = 21)
    public SplashContainer(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f17236c = new a();
        this.f17237d = new int[3];
    }
}
