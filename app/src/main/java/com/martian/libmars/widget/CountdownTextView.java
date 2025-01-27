package com.martian.libmars.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.martian.libmars.utils.p0;

/* loaded from: classes2.dex */
public class CountdownTextView extends AppCompatTextView {

    /* renamed from: e */
    private long f10315e;

    /* renamed from: f */
    private long f10316f;

    /* renamed from: g */
    private String f10317g;

    /* renamed from: h */
    private b f10318h;

    /* renamed from: i */
    private final Runnable f10319i;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis() + CountdownTextView.this.f10315e;
            if (CountdownTextView.this.f10316f > currentTimeMillis) {
                CountdownTextView countdownTextView = CountdownTextView.this;
                countdownTextView.setText(p0.b(countdownTextView.f10316f - currentTimeMillis));
                CountdownTextView countdownTextView2 = CountdownTextView.this;
                countdownTextView2.postDelayed(countdownTextView2.f10319i, 1000L);
                return;
            }
            CountdownTextView countdownTextView3 = CountdownTextView.this;
            countdownTextView3.setText(countdownTextView3.f10317g);
            if (CountdownTextView.this.f10318h != null) {
                CountdownTextView.this.f10318h.a(CountdownTextView.this);
            }
        }
    }

    public interface b {
        void a(CountdownTextView textView);
    }

    public CountdownTextView(Context context) {
        super(context);
        this.f10315e = 0L;
        this.f10319i = new a();
    }

    public void l(long targetTime) {
        this.f10316f = targetTime;
        removeCallbacks(this.f10319i);
        post(this.f10319i);
    }

    public void m(long targetTime, String targetText) {
        this.f10316f = targetTime;
        this.f10317g = targetText;
        removeCallbacks(this.f10319i);
        post(this.f10319i);
    }

    public void n(long timeDiff, boolean isTimeDiff) {
        this.f10316f = System.currentTimeMillis() + this.f10315e + timeDiff;
        removeCallbacks(this.f10319i);
        post(this.f10319i);
    }

    public void o() {
        Runnable runnable = this.f10319i;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f10319i);
    }

    public void setOnCountDownFinishListener(b l) {
        this.f10318h = l;
    }

    public void setServerDiffTime(long serverDiffTime) {
        this.f10315e = serverDiffTime;
    }

    public CountdownTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f10315e = 0L;
        this.f10319i = new a();
    }

    public CountdownTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f10315e = 0L;
        this.f10319i = new a();
    }
}
