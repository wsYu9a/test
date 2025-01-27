package com.martian.apptask.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes2.dex */
public class CountdownNumberTextView extends AppCompatTextView {

    /* renamed from: e */
    private b f9657e;

    /* renamed from: f */
    private String f9658f;

    /* renamed from: g */
    private String f9659g;

    /* renamed from: h */
    private int f9660h;

    /* renamed from: i */
    private final Runnable f9661i;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CountdownNumberTextView.this.f9660h <= 0) {
                CountdownNumberTextView.this.setText(CountdownNumberTextView.this.f9658f + " 0" + CountdownNumberTextView.this.f9659g);
                if (CountdownNumberTextView.this.f9657e != null) {
                    CountdownNumberTextView.this.f9657e.a(CountdownNumberTextView.this);
                    return;
                }
                return;
            }
            CountdownNumberTextView.this.setText(CountdownNumberTextView.this.f9658f + " " + CountdownNumberTextView.this.f9660h + CountdownNumberTextView.this.f9659g);
            CountdownNumberTextView.h(CountdownNumberTextView.this);
            CountdownNumberTextView countdownNumberTextView = CountdownNumberTextView.this;
            countdownNumberTextView.postDelayed(countdownNumberTextView.f9661i, 1000L);
        }
    }

    public interface b {
        void a(CountdownNumberTextView textView);
    }

    public CountdownNumberTextView(Context context) {
        super(context);
        this.f9658f = "";
        this.f9659g = "";
        this.f9660h = 0;
        this.f9661i = new a();
    }

    static /* synthetic */ int h(CountdownNumberTextView countdownNumberTextView) {
        int i2 = countdownNumberTextView.f9660h;
        countdownNumberTextView.f9660h = i2 - 1;
        return i2;
    }

    public void m() {
        removeCallbacks(this.f9661i);
        if (this.f9660h > 0) {
            post(this.f9661i);
        }
    }

    public void n(int delay) {
        this.f9660h = delay;
        removeCallbacks(this.f9661i);
        post(this.f9661i);
    }

    public void o() {
        removeCallbacks(this.f9661i);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f9661i);
    }

    public void setDelay(int delay) {
        this.f9660h = delay;
    }

    public void setOnCountDownFinishListener(b l) {
        this.f9657e = l;
    }

    public void setPreText(String text) {
        this.f9658f = text;
    }

    public void setSufText(String text) {
        this.f9659g = text;
    }

    public CountdownNumberTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f9658f = "";
        this.f9659g = "";
        this.f9660h = 0;
        this.f9661i = new a();
    }

    public CountdownNumberTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f9658f = "";
        this.f9659g = "";
        this.f9660h = 0;
        this.f9661i = new a();
    }
}
