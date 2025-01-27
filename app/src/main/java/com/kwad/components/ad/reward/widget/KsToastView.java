package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.n.m;

/* loaded from: classes2.dex */
public class KsToastView extends LinearLayout {
    TextView CG;
    private String CH;
    private Runnable CI;
    private int countDown;

    /* renamed from: com.kwad.components.ad.reward.widget.KsToastView$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (KsToastView.this.countDown == 0) {
                return;
            }
            KsToastView ksToastView = KsToastView.this;
            ksToastView.x(ksToastView.countDown);
            KsToastView.b(KsToastView.this);
            KsToastView.this.postDelayed(this, 1000L);
        }
    }

    public KsToastView(Context context) {
        super(context);
        this.countDown = 3;
        this.CH = "%ss后自动进入";
        this.CI = null;
        init(context);
    }

    public static /* synthetic */ int b(KsToastView ksToastView) {
        int i10 = ksToastView.countDown;
        ksToastView.countDown = i10 - 1;
        return i10;
    }

    private void init(Context context) {
        m.inflate(context, R.layout.ksad_interstitial_toast_layout, this);
        this.CG = (TextView) findViewById(R.id.ksad_total_count_down_text);
    }

    public void x(int i10) {
        this.CG.setText(String.format(this.CH, Integer.valueOf(i10)));
    }

    public final void V(int i10) {
        if (this.CI == null) {
            this.CI = new Runnable() { // from class: com.kwad.components.ad.reward.widget.KsToastView.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (KsToastView.this.countDown == 0) {
                        return;
                    }
                    KsToastView ksToastView = KsToastView.this;
                    ksToastView.x(ksToastView.countDown);
                    KsToastView.b(KsToastView.this);
                    KsToastView.this.postDelayed(this, 1000L);
                }
            };
        }
        this.countDown = 3;
        post(this.CI);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.CI);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 3;
        this.CH = "%ss后自动进入";
        this.CI = null;
        init(context);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.countDown = 3;
        this.CH = "%ss后自动进入";
        this.CI = null;
        init(context);
    }

    public KsToastView(Context context, boolean z10) {
        super(context);
        this.countDown = 3;
        this.CH = "%ss后自动进入";
        this.CI = null;
        init(context);
    }
}
