package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.n.m;
import com.kwad.sdk.utils.bd;

/* loaded from: classes3.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {
    private static String CH = "%s秒后自动关闭";
    private TextView afk;
    private ImageView afl;
    private a afm;
    private boolean afn;
    private boolean afo;
    private int countDown;

    /* renamed from: com.kwad.components.core.widget.KsAutoCloseView$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (KsAutoCloseView.this.afn) {
                if (KsAutoCloseView.this.afo) {
                    KsAutoCloseView.this.postDelayed(this, 1000L);
                    return;
                }
                if (KsAutoCloseView.this.countDown == 0) {
                    if (KsAutoCloseView.this.afm != null) {
                        KsAutoCloseView.this.afm.dA();
                    }
                } else {
                    KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                    ksAutoCloseView.x(ksAutoCloseView.countDown);
                    KsAutoCloseView.e(KsAutoCloseView.this);
                    KsAutoCloseView.this.postDelayed(this, 1000L);
                }
            }
        }
    }

    public interface a {
        void dA();

        void dB();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.countDown = 10;
        this.afn = true;
        this.afo = false;
        R(context);
    }

    private void R(Context context) {
        m.inflate(context, R.layout.ksad_auto_close, this);
        this.afk = (TextView) findViewById(R.id.ksad_auto_close_text);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_auto_close_btn);
        this.afl = imageView;
        imageView.setOnClickListener(this);
    }

    public static /* synthetic */ int e(KsAutoCloseView ksAutoCloseView) {
        int i10 = ksAutoCloseView.countDown;
        ksAutoCloseView.countDown = i10 - 1;
        return i10;
    }

    public void x(int i10) {
        this.afk.setText(String.format(CH, Integer.valueOf(i10)));
    }

    public final void V(int i10) {
        if (i10 <= 0) {
            return;
        }
        this.countDown = i10;
        post(new bd() { // from class: com.kwad.components.core.widget.KsAutoCloseView.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (KsAutoCloseView.this.afn) {
                    if (KsAutoCloseView.this.afo) {
                        KsAutoCloseView.this.postDelayed(this, 1000L);
                        return;
                    }
                    if (KsAutoCloseView.this.countDown == 0) {
                        if (KsAutoCloseView.this.afm != null) {
                            KsAutoCloseView.this.afm.dA();
                        }
                    } else {
                        KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                        ksAutoCloseView.x(ksAutoCloseView.countDown);
                        KsAutoCloseView.e(KsAutoCloseView.this);
                        KsAutoCloseView.this.postDelayed(this, 1000L);
                    }
                }
            }
        });
    }

    public final void aZ(boolean z10) {
        this.afn = z10;
        int i10 = z10 ? 0 : 8;
        TextView textView = this.afk;
        if (textView != null) {
            textView.setVisibility(i10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afm != null && view.equals(this.afl)) {
            this.afm.dB();
        }
    }

    public void setCountDownPaused(boolean z10) {
        this.afo = z10;
    }

    public void setViewListener(a aVar) {
        this.afm = aVar;
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 10;
        this.afn = true;
        this.afo = false;
        R(context);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.countDown = 10;
        this.afn = true;
        this.afo = false;
        R(context);
    }

    @RequiresApi(api = 21)
    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.countDown = 10;
        this.afn = true;
        this.afo = false;
        R(context);
    }
}
