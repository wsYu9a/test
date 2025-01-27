package com.martian.apptask.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes3.dex */
public class CountdownNumberTextView extends AppCompatTextView {

    /* renamed from: b */
    public b f12001b;

    /* renamed from: c */
    public String f12002c;

    /* renamed from: d */
    public String f12003d;

    /* renamed from: e */
    public boolean f12004e;

    /* renamed from: f */
    public int f12005f;

    /* renamed from: g */
    public final Runnable f12006g;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CountdownNumberTextView.this.f12005f <= 0) {
                CountdownNumberTextView countdownNumberTextView = CountdownNumberTextView.this;
                StringBuffer stringBuffer = new StringBuffer(countdownNumberTextView.f12002c);
                stringBuffer.append(" 0");
                stringBuffer.append(CountdownNumberTextView.this.f12003d);
                countdownNumberTextView.setText(stringBuffer);
                if (CountdownNumberTextView.this.f12001b != null) {
                    CountdownNumberTextView.this.f12001b.a(CountdownNumberTextView.this);
                    return;
                }
                return;
            }
            CountdownNumberTextView countdownNumberTextView2 = CountdownNumberTextView.this;
            StringBuffer stringBuffer2 = new StringBuffer(countdownNumberTextView2.f12002c);
            stringBuffer2.append(" ");
            stringBuffer2.append(CountdownNumberTextView.this.f12005f);
            stringBuffer2.append(CountdownNumberTextView.this.f12003d);
            countdownNumberTextView2.setText(stringBuffer2);
            CountdownNumberTextView countdownNumberTextView3 = CountdownNumberTextView.this;
            countdownNumberTextView3.f12005f--;
            CountdownNumberTextView countdownNumberTextView4 = CountdownNumberTextView.this;
            countdownNumberTextView4.postDelayed(countdownNumberTextView4.f12006g, 1000L);
        }
    }

    public interface b {
        void a(CountdownNumberTextView countdownNumberTextView);
    }

    public CountdownNumberTextView(Context context) {
        super(context);
        this.f12002c = "";
        this.f12003d = "";
        this.f12004e = true;
        this.f12005f = 0;
        this.f12006g = new a();
    }

    public void k() {
        this.f12005f = 0;
        n();
    }

    public void l() {
        removeCallbacks(this.f12006g);
        if (this.f12005f > 0) {
            post(this.f12006g);
        }
    }

    public void m(int i10) {
        this.f12005f = i10;
        StringBuffer stringBuffer = new StringBuffer(this.f12002c);
        stringBuffer.append(" ");
        stringBuffer.append(i10);
        stringBuffer.append(this.f12003d);
        setText(stringBuffer);
        removeCallbacks(this.f12006g);
        post(this.f12006g);
    }

    public void n() {
        removeCallbacks(this.f12006g);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f12005f > 0) {
            l();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f12004e) {
            n();
        }
    }

    public void setDelay(int i10) {
        this.f12005f = i10;
    }

    public void setOnCountDownFinishListener(b bVar) {
        this.f12001b = bVar;
    }

    public void setPreText(String str) {
        this.f12002c = str;
    }

    public void setRemoveWhenDetach(boolean z10) {
        this.f12004e = z10;
    }

    public void setSufText(String str) {
        this.f12003d = str;
    }

    public CountdownNumberTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12002c = "";
        this.f12003d = "";
        this.f12004e = true;
        this.f12005f = 0;
        this.f12006g = new a();
    }

    public CountdownNumberTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12002c = "";
        this.f12003d = "";
        this.f12004e = true;
        this.f12005f = 0;
        this.f12006g = new a();
    }
}
