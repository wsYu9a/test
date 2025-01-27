package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.j.k;

/* loaded from: classes2.dex */
public class KsToastView extends LinearLayout {
    TextView AF;
    private String AG;
    private Runnable AH;
    private int countDown;

    /* renamed from: com.kwad.components.ad.reward.widget.KsToastView$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (KsToastView.this.countDown == 0) {
                return;
            }
            KsToastView ksToastView = KsToastView.this;
            ksToastView.A(ksToastView.countDown);
            KsToastView.b(KsToastView.this);
            KsToastView.this.postDelayed(this, 1000L);
        }
    }

    public KsToastView(Context context) {
        super(context);
        this.countDown = 3;
        this.AG = "%ss后自动进入";
        this.AH = null;
        init(context);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 3;
        this.AG = "%ss后自动进入";
        this.AH = null;
        init(context);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.countDown = 3;
        this.AG = "%ss后自动进入";
        this.AH = null;
        init(context);
    }

    public KsToastView(Context context, boolean z) {
        super(context);
        this.countDown = 3;
        this.AG = "%ss后自动进入";
        this.AH = null;
        init(context);
    }

    public void A(int i2) {
        this.AF.setText(String.format(this.AG, Integer.valueOf(i2)));
    }

    static /* synthetic */ int b(KsToastView ksToastView) {
        int i2 = ksToastView.countDown;
        ksToastView.countDown = i2 - 1;
        return i2;
    }

    private void init(Context context) {
        k.inflate(context, R.layout.ksad_interstitial_toast_layout, this);
        this.AF = (TextView) findViewById(R.id.ksad_total_count_down_text);
    }

    public final void Y(int i2) {
        if (this.AH == null) {
            this.AH = new Runnable() { // from class: com.kwad.components.ad.reward.widget.KsToastView.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (KsToastView.this.countDown == 0) {
                        return;
                    }
                    KsToastView ksToastView = KsToastView.this;
                    ksToastView.A(ksToastView.countDown);
                    KsToastView.b(KsToastView.this);
                    KsToastView.this.postDelayed(this, 1000L);
                }
            };
        }
        this.countDown = 3;
        post(this.AH);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.AH);
    }
}
