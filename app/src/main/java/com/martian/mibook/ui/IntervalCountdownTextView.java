package com.martian.mibook.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.martian.libmars.utils.p0;
import com.martian.rpauth.MartianRPUserManager;

/* loaded from: classes4.dex */
public class IntervalCountdownTextView extends AppCompatTextView {

    /* renamed from: e */
    private long f14153e;

    /* renamed from: f */
    private long f14154f;

    /* renamed from: g */
    private String f14155g;

    /* renamed from: h */
    private boolean f14156h;

    /* renamed from: i */
    private boolean f14157i;

    /* renamed from: j */
    private b f14158j;
    private final Runnable k;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long t = MartianRPUserManager.t();
            if (IntervalCountdownTextView.this.f14154f <= t) {
                IntervalCountdownTextView intervalCountdownTextView = IntervalCountdownTextView.this;
                intervalCountdownTextView.setText(intervalCountdownTextView.f14155g);
                if (IntervalCountdownTextView.this.f14158j != null) {
                    IntervalCountdownTextView.this.f14158j.a(IntervalCountdownTextView.this);
                    return;
                }
                return;
            }
            if (IntervalCountdownTextView.this.f14157i) {
                IntervalCountdownTextView.this.setVerticalModeText(p0.c(IntervalCountdownTextView.this.f14154f - t));
            } else {
                String d2 = p0.d(IntervalCountdownTextView.this.f14154f - t);
                if (IntervalCountdownTextView.this.f14156h) {
                    IntervalCountdownTextView.this.setColorText(d2);
                } else {
                    IntervalCountdownTextView.this.setText(d2);
                }
            }
            IntervalCountdownTextView intervalCountdownTextView2 = IntervalCountdownTextView.this;
            intervalCountdownTextView2.postDelayed(intervalCountdownTextView2.k, 1000L);
        }
    }

    public interface b {
        void a(IntervalCountdownTextView textView);
    }

    public IntervalCountdownTextView(Context context) {
        super(context);
        this.f14153e = 0L;
        this.f14156h = false;
        this.f14157i = false;
        this.k = new a();
    }

    public boolean m() {
        return this.f14154f <= MartianRPUserManager.t();
    }

    public void n(long targetTime) {
        this.f14156h = true;
        this.f14154f = targetTime;
        removeCallbacks(this.k);
        post(this.k);
    }

    public void o(long targetTime) {
        this.f14154f = targetTime;
        removeCallbacks(this.k);
        post(this.k);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.k);
    }

    public void p(long targetTime, String targetText) {
        this.f14154f = targetTime;
        this.f14155g = targetText;
        removeCallbacks(this.k);
        post(this.k);
    }

    public void q(long timeDiff, boolean isTimeDiff) {
        this.f14154f = System.currentTimeMillis() + this.f14153e + timeDiff;
        removeCallbacks(this.k);
        post(this.k);
    }

    public void r(long targetTime) {
        this.f14154f = targetTime;
        this.f14157i = true;
        removeCallbacks(this.k);
        post(this.k);
    }

    public void s() {
        Runnable runnable = this.k;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void setColorText(String time) {
        try {
            SpannableString spannableString = new SpannableString(time);
            int indexOf = time.indexOf(":");
            int lastIndexOf = time.lastIndexOf(":");
            int indexOf2 = time.indexOf("天");
            int parseColor = Color.parseColor("#30363D");
            int parseColor2 = Color.parseColor("#FFFFFF");
            if (indexOf2 > 0) {
                spannableString.setSpan(new l(parseColor, parseColor2), 0, indexOf2 + 1, 33);
            }
            if (indexOf > 0) {
                spannableString.setSpan(new l(parseColor, parseColor2), indexOf2 > 0 ? indexOf2 + 2 : 0, indexOf, 33);
                int i2 = indexOf + 1;
                spannableString.setSpan(new StyleSpan(1), indexOf, i2, 33);
                spannableString.setSpan(new ForegroundColorSpan(parseColor), indexOf, i2, 33);
            }
            if (lastIndexOf > indexOf) {
                spannableString.setSpan(new l(parseColor, parseColor2), indexOf + 1, lastIndexOf, 33);
                int i3 = lastIndexOf + 1;
                spannableString.setSpan(new StyleSpan(1), lastIndexOf, i3, 33);
                spannableString.setSpan(new ForegroundColorSpan(parseColor), lastIndexOf, i3, 33);
            }
            if (lastIndexOf > 0) {
                spannableString.setSpan(new l(parseColor, parseColor2), lastIndexOf + 1, lastIndexOf + 3, 33);
            }
            setText(spannableString);
        } catch (Exception unused) {
            setText(time);
        }
    }

    public void setOnCountDownFinishListener(b l) {
        this.f14158j = l;
    }

    public void setServerDiffTime(long serverDiffTime) {
        this.f14153e = serverDiffTime;
    }

    public void setVerticalModeText(String time) {
        try {
            int indexOf = time.indexOf("分");
            int indexOf2 = time.indexOf("秒");
            SpannableString spannableString = new SpannableString(time);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFF")), 0, time.length(), 17);
            spannableString.setSpan(new AbsoluteSizeSpan(10, true), 0, indexOf, 17);
            int i2 = indexOf + 1;
            spannableString.setSpan(new AbsoluteSizeSpan(11, true), indexOf, i2, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(10, true), i2, indexOf2, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(11, true), indexOf2, time.length(), 17);
            spannableString.setSpan(new StyleSpan(1), 0, time.length(), 17);
            setText(spannableString);
        } catch (Exception unused) {
            setText(time);
        }
    }

    public IntervalCountdownTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f14153e = 0L;
        this.f14156h = false;
        this.f14157i = false;
        this.k = new a();
    }

    public IntervalCountdownTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f14153e = 0L;
        this.f14156h = false;
        this.f14157i = false;
        this.k = new a();
    }
}
