package com.martian.mibook.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.martian.rpauth.MartianRPUserManager;
import l9.o0;

/* loaded from: classes3.dex */
public class IntervalCountdownTextView extends AppCompatTextView {

    /* renamed from: b */
    public long f15836b;

    /* renamed from: c */
    public long f15837c;

    /* renamed from: d */
    public String f15838d;

    /* renamed from: e */
    public boolean f15839e;

    /* renamed from: f */
    public boolean f15840f;

    /* renamed from: g */
    public b f15841g;

    /* renamed from: h */
    public final Runnable f15842h;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long a10 = MartianRPUserManager.a();
            if (IntervalCountdownTextView.this.f15837c <= a10) {
                IntervalCountdownTextView intervalCountdownTextView = IntervalCountdownTextView.this;
                intervalCountdownTextView.setText(intervalCountdownTextView.f15838d);
                if (IntervalCountdownTextView.this.f15841g != null) {
                    IntervalCountdownTextView.this.f15841g.a(IntervalCountdownTextView.this);
                    return;
                }
                return;
            }
            if (IntervalCountdownTextView.this.f15840f) {
                IntervalCountdownTextView.this.setVerticalModeText(o0.d(IntervalCountdownTextView.this.f15837c - a10));
            } else {
                String e10 = o0.e(IntervalCountdownTextView.this.f15837c - a10);
                if (IntervalCountdownTextView.this.f15839e) {
                    IntervalCountdownTextView.this.setColorText(e10);
                } else {
                    IntervalCountdownTextView.this.setText(e10);
                }
            }
            IntervalCountdownTextView intervalCountdownTextView2 = IntervalCountdownTextView.this;
            intervalCountdownTextView2.postDelayed(intervalCountdownTextView2.f15842h, 1000L);
        }
    }

    public interface b {
        void a(IntervalCountdownTextView intervalCountdownTextView);
    }

    public IntervalCountdownTextView(Context context) {
        super(context);
        this.f15836b = 0L;
        this.f15839e = false;
        this.f15840f = false;
        this.f15842h = new a();
    }

    public boolean k() {
        return this.f15837c <= MartianRPUserManager.a();
    }

    public void l(long j10) {
        this.f15839e = true;
        this.f15837c = j10;
        removeCallbacks(this.f15842h);
        post(this.f15842h);
    }

    public void m(long j10) {
        this.f15837c = j10;
        removeCallbacks(this.f15842h);
        post(this.f15842h);
    }

    public void n(long j10, String str) {
        this.f15837c = j10;
        this.f15838d = str;
        removeCallbacks(this.f15842h);
        post(this.f15842h);
    }

    public void o(long j10, boolean z10) {
        this.f15837c = System.currentTimeMillis() + this.f15836b + j10;
        removeCallbacks(this.f15842h);
        post(this.f15842h);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f15842h);
    }

    public void q(long j10) {
        this.f15837c = j10;
        this.f15840f = true;
        removeCallbacks(this.f15842h);
        post(this.f15842h);
    }

    public void r() {
        Runnable runnable = this.f15842h;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void setColorText(String str) {
        try {
            SpannableString spannableString = new SpannableString(str);
            int indexOf = str.indexOf(":");
            int lastIndexOf = str.lastIndexOf(":");
            int indexOf2 = str.indexOf("天");
            int parseColor = Color.parseColor("#30363D");
            int parseColor2 = Color.parseColor("#FFFFFF");
            if (indexOf2 > 0) {
                spannableString.setSpan(new be.b(parseColor, parseColor2), 0, indexOf2 + 1, 33);
            }
            if (indexOf > 0) {
                spannableString.setSpan(new be.b(parseColor, parseColor2), indexOf2 > 0 ? indexOf2 + 2 : 0, indexOf, 33);
                int i10 = indexOf + 1;
                spannableString.setSpan(new StyleSpan(1), indexOf, i10, 33);
                spannableString.setSpan(new ForegroundColorSpan(parseColor), indexOf, i10, 33);
            }
            if (lastIndexOf > indexOf) {
                spannableString.setSpan(new be.b(parseColor, parseColor2), indexOf + 1, lastIndexOf, 33);
                int i11 = lastIndexOf + 1;
                spannableString.setSpan(new StyleSpan(1), lastIndexOf, i11, 33);
                spannableString.setSpan(new ForegroundColorSpan(parseColor), lastIndexOf, i11, 33);
            }
            if (lastIndexOf > 0) {
                spannableString.setSpan(new be.b(parseColor, parseColor2), lastIndexOf + 1, lastIndexOf + 3, 33);
            }
            setText(spannableString);
        } catch (Exception unused) {
            setText(str);
        }
    }

    public void setOnCountDownFinishListener(b bVar) {
        this.f15841g = bVar;
    }

    public void setServerDiffTime(long j10) {
        this.f15836b = j10;
    }

    public void setVerticalModeText(String str) {
        try {
            int indexOf = str.indexOf("分");
            int indexOf2 = str.indexOf("秒");
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFF")), 0, str.length(), 17);
            spannableString.setSpan(new AbsoluteSizeSpan(10, true), 0, indexOf, 17);
            int i10 = indexOf + 1;
            spannableString.setSpan(new AbsoluteSizeSpan(11, true), indexOf, i10, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(10, true), i10, indexOf2, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(11, true), indexOf2, str.length(), 17);
            spannableString.setSpan(new StyleSpan(1), 0, str.length(), 17);
            setText(spannableString);
        } catch (Exception unused) {
            setText(str);
        }
    }

    public IntervalCountdownTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15836b = 0L;
        this.f15839e = false;
        this.f15840f = false;
        this.f15842h = new a();
    }

    public IntervalCountdownTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f15836b = 0L;
        this.f15839e = false;
        this.f15840f = false;
        this.f15842h = new a();
    }
}
