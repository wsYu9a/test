package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes4.dex */
public class ContentLoadingSmoothProgressBar extends SmoothProgressBar {

    /* renamed from: l */
    public static final int f26063l = 500;

    /* renamed from: m */
    public static final int f26064m = 500;

    /* renamed from: f */
    public long f26065f;

    /* renamed from: g */
    public boolean f26066g;

    /* renamed from: h */
    public boolean f26067h;

    /* renamed from: i */
    public boolean f26068i;

    /* renamed from: j */
    public final Runnable f26069j;

    /* renamed from: k */
    public final Runnable f26070k;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentLoadingSmoothProgressBar.this.f26066g = false;
            ContentLoadingSmoothProgressBar.this.f26065f = -1L;
            ContentLoadingSmoothProgressBar.this.setVisibility(8);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentLoadingSmoothProgressBar.this.f26067h = false;
            if (ContentLoadingSmoothProgressBar.this.f26068i) {
                return;
            }
            ContentLoadingSmoothProgressBar.this.f26065f = System.currentTimeMillis();
            ContentLoadingSmoothProgressBar.this.setVisibility(0);
        }
    }

    public ContentLoadingSmoothProgressBar(Context context) {
        this(context, null);
    }

    public void i() {
        this.f26068i = true;
        removeCallbacks(this.f26070k);
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = this.f26065f;
        long j11 = currentTimeMillis - j10;
        if (j11 >= 500 || j10 == -1) {
            setVisibility(8);
        } else {
            if (this.f26066g) {
                return;
            }
            postDelayed(this.f26069j, 500 - j11);
            this.f26066g = true;
        }
    }

    public final void j() {
        removeCallbacks(this.f26069j);
        removeCallbacks(this.f26070k);
    }

    public void k() {
        this.f26065f = -1L;
        this.f26068i = false;
        removeCallbacks(this.f26069j);
        if (this.f26067h) {
            return;
        }
        postDelayed(this.f26070k, 500L);
        this.f26067h = true;
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
        this.f26065f = -1L;
        this.f26066g = false;
        this.f26067h = false;
        this.f26068i = false;
        this.f26069j = new a();
        this.f26070k = new b();
    }
}
