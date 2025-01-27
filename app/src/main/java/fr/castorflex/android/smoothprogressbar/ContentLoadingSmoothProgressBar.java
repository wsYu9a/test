package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes5.dex */
public class ContentLoadingSmoothProgressBar extends SmoothProgressBar {

    /* renamed from: e */
    private static final int f35250e = 500;

    /* renamed from: f */
    private static final int f35251f = 500;

    /* renamed from: g */
    private long f35252g;

    /* renamed from: h */
    private boolean f35253h;

    /* renamed from: i */
    private boolean f35254i;

    /* renamed from: j */
    private boolean f35255j;
    private final Runnable k;
    private final Runnable l;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentLoadingSmoothProgressBar.this.f35253h = false;
            ContentLoadingSmoothProgressBar.this.f35252g = -1L;
            ContentLoadingSmoothProgressBar.this.setVisibility(8);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentLoadingSmoothProgressBar.this.f35254i = false;
            if (ContentLoadingSmoothProgressBar.this.f35255j) {
                return;
            }
            ContentLoadingSmoothProgressBar.this.f35252g = System.currentTimeMillis();
            ContentLoadingSmoothProgressBar.this.setVisibility(0);
        }
    }

    public ContentLoadingSmoothProgressBar(Context context) {
        this(context, null);
    }

    private void j() {
        removeCallbacks(this.k);
        removeCallbacks(this.l);
    }

    public void i() {
        this.f35255j = true;
        removeCallbacks(this.l);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f35252g;
        long j3 = currentTimeMillis - j2;
        if (j3 >= 500 || j2 == -1) {
            setVisibility(8);
        } else {
            if (this.f35253h) {
                return;
            }
            postDelayed(this.k, 500 - j3);
            this.f35253h = true;
        }
    }

    public void k() {
        this.f35252g = -1L;
        this.f35255j = false;
        removeCallbacks(this.k);
        if (this.f35254i) {
            return;
        }
        postDelayed(this.l, 500L);
        this.f35254i = true;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    public ContentLoadingSmoothProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f35252g = -1L;
        this.f35253h = false;
        this.f35254i = false;
        this.f35255j = false;
        this.k = new a();
        this.l = new b();
    }
}
