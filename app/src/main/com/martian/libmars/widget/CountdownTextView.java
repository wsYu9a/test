package com.martian.libmars.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import l9.o0;

/* loaded from: classes3.dex */
public class CountdownTextView extends AppCompatTextView {

    /* renamed from: b */
    public long f12526b;

    /* renamed from: c */
    public long f12527c;

    /* renamed from: d */
    public String f12528d;

    /* renamed from: e */
    public b f12529e;

    /* renamed from: f */
    public final Runnable f12530f;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis() + CountdownTextView.this.f12526b;
            if (CountdownTextView.this.f12527c > currentTimeMillis) {
                CountdownTextView countdownTextView = CountdownTextView.this;
                countdownTextView.setText(o0.c(countdownTextView.f12527c - currentTimeMillis));
                CountdownTextView countdownTextView2 = CountdownTextView.this;
                countdownTextView2.postDelayed(countdownTextView2.f12530f, 1000L);
                return;
            }
            CountdownTextView countdownTextView3 = CountdownTextView.this;
            countdownTextView3.setText(countdownTextView3.f12528d);
            if (CountdownTextView.this.f12529e != null) {
                CountdownTextView.this.f12529e.a(CountdownTextView.this);
            }
        }
    }

    public interface b {
        void a(CountdownTextView countdownTextView);
    }

    public CountdownTextView(Context context) {
        super(context);
        this.f12526b = 0L;
        this.f12530f = new a();
    }

    public void j(long j10) {
        this.f12527c = j10;
        removeCallbacks(this.f12530f);
        post(this.f12530f);
    }

    public void k(long j10, String str) {
        this.f12527c = j10;
        this.f12528d = str;
        removeCallbacks(this.f12530f);
        post(this.f12530f);
    }

    public void l(long j10, boolean z10) {
        this.f12527c = System.currentTimeMillis() + this.f12526b + j10;
        removeCallbacks(this.f12530f);
        post(this.f12530f);
    }

    public void m() {
        Runnable runnable = this.f12530f;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f12530f);
    }

    public void setOnCountDownFinishListener(b bVar) {
        this.f12529e = bVar;
    }

    public void setServerDiffTime(long j10) {
        this.f12526b = j10;
    }

    public CountdownTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12526b = 0L;
        this.f12530f = new a();
    }

    public CountdownTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12526b = 0L;
        this.f12530f = new a();
    }
}
