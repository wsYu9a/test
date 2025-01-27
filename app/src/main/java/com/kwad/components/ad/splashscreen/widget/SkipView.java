package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.j.k;

/* loaded from: classes2.dex */
public class SkipView extends LinearLayout implements com.kwad.components.ad.splashscreen.widget.a {
    private Runnable EF;
    private a Et;
    private final b FN;
    private View FO;
    private TextView FP;
    private TextView FQ;
    private int FR;
    private boolean nY;
    private boolean sp;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.SkipView$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (SkipView.this.nY) {
                SkipView.this.postDelayed(this, 300L);
                return;
            }
            SkipView skipView = SkipView.this;
            skipView.a(skipView.FN);
            SkipView skipView2 = SkipView.this;
            skipView2.ab(skipView2.FN.FV - SkipView.this.FN.EA);
            if (!SkipView.this.FN.lz()) {
                SkipView.this.postDelayed(this, 1000L);
                b.d(SkipView.this.FN);
            } else if (SkipView.this.Et != null) {
                SkipView.this.Et.kJ();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.widget.SkipView$2 */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (SkipView.this.Et != null) {
                SkipView.this.Et.kI();
            }
        }
    }

    public interface a {
        void ac(int i2);

        void kI();

        void kJ();
    }

    static class b {
        private int EA;
        private String FT;
        private String FU;
        private int FV;
        private boolean FW;
        private boolean FX;

        private b() {
            this.FT = "跳过";
            this.FU = "";
            this.FV = 5;
            this.EA = 5;
            this.FW = true;
            this.FX = true;
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        static /* synthetic */ int d(b bVar) {
            int i2 = bVar.EA;
            bVar.EA = i2 - 1;
            return i2;
        }

        public boolean lA() {
            return this.FW && this.FX;
        }

        public final void ag(String str) {
            this.EA = -1;
            this.FU = str;
        }

        public final void ai(int i2) {
            this.FV = i2;
            this.EA = i2;
        }

        public final String ly() {
            StringBuilder sb;
            int i2;
            int i3 = this.EA;
            if (i3 < 0) {
                return this.FU;
            }
            if (i3 == 0) {
                sb = new StringBuilder();
                sb.append(this.FU);
                i2 = 1;
            } else {
                sb = new StringBuilder();
                sb.append(this.FU);
                i2 = this.EA;
            }
            sb.append(i2);
            return sb.toString();
        }

        public final boolean lz() {
            return this.EA <= 0;
        }
    }

    public SkipView(Context context) {
        this(context, null);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(k.wrapContextIfNeed(context), attributeSet, i2);
        this.FN = new b((byte) 0);
        this.FR = -1;
        this.nY = false;
        this.sp = true;
        this.EF = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (SkipView.this.nY) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.FN);
                SkipView skipView2 = SkipView.this;
                skipView2.ab(skipView2.FN.FV - SkipView.this.FN.EA);
                if (!SkipView.this.FN.lz()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.d(SkipView.this.FN);
                } else if (SkipView.this.Et != null) {
                    SkipView.this.Et.kJ();
                }
            }
        };
        init();
    }

    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.FP != null) {
            if (bVar.FT != null) {
                this.FP.setText(bVar.FT);
            }
            this.FP.setVisibility(this.FN.FW ? 0 : 8);
        }
        String ly = bVar.ly();
        TextView textView = this.FQ;
        if (textView != null) {
            if (ly != null) {
                textView.setText(ly);
            }
            this.FQ.setVisibility(this.FN.FX ? 0 : 8);
        }
        if (this.FO != null) {
            boolean lA = this.FN.lA();
            this.FO.setVisibility(lA ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (!lA) {
                    layoutParams.width = -2;
                    invalidate();
                    return;
                }
                int i2 = this.FR;
                if (i2 > 0) {
                    layoutParams.width = i2;
                    invalidate();
                }
            }
        }
    }

    public void ab(int i2) {
        a aVar = this.Et;
        if (aVar != null) {
            aVar.ac(i2);
        }
    }

    private void fc() {
        a(this.FN);
        post(this.EF);
    }

    private void fd() {
        this.nY = true;
    }

    private void fe() {
        this.nY = false;
    }

    private void init() {
        setOrientation(0);
        k.inflate(getContext(), R.layout.ksad_skip_view, this);
        this.FP = (TextView) findViewById(R.id.ksad_skip_view_skip);
        this.FQ = (TextView) findViewById(R.id.ksad_skip_view_timer);
        this.FO = findViewById(R.id.ksad_skip_view_divider);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (SkipView.this.Et != null) {
                    SkipView.this.Et.kI();
                }
            }
        });
        setSkipBtnVisible(true);
        setTimerBtnVisible(true);
    }

    private void lx() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    private void w(AdInfo adInfo) {
        setTimerBtnVisible(com.kwad.sdk.core.response.a.a.cf(adInfo));
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.sp = com.kwad.sdk.core.response.a.a.ce(adInfo);
        setTimerPrefixText(d.a(com.kwad.components.ad.splashscreen.a.a.BQ));
        setTimerSecond(splashSkipViewModel.skipSecond);
        if (!com.kwad.sdk.core.response.a.a.aU(adInfo)) {
            fc();
        }
        setSkipText(com.kwad.sdk.core.response.a.a.bO(adInfo));
        setVisibility(8);
        w(adInfo);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final int af(int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = com.kwad.sdk.c.kwai.a.a(getContext(), 35.0f);
        int width = getWidth();
        setLayoutParams(layoutParams);
        return width;
    }

    public final void ag(String str) {
        if (str == null) {
            return;
        }
        this.FN.ag(str);
        a(this.FN);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void bn() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.FR = layoutParams.width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public void setOnViewListener(a aVar) {
        this.Et = aVar;
    }

    public void setSkipBtnVisible(boolean z) {
        this.FN.FW = z;
        a(this.FN);
    }

    public void setSkipText(String str) {
        this.FN.FT = str;
        a(this.FN);
    }

    public void setTimerBtnVisible(boolean z) {
        this.FN.FX = z;
        a(this.FN);
    }

    public void setTimerPrefixText(String str) {
        this.FN.FU = str;
        a(this.FN);
    }

    public void setTimerSecond(int i2) {
        this.FN.ai(i2);
        a(this.FN);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void u(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.a.a.aU(adInfo)) {
            return;
        }
        fd();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void v(AdInfo adInfo) {
        if (this.sp) {
            lx();
        }
        if (com.kwad.sdk.core.response.a.a.aU(adInfo)) {
            return;
        }
        fe();
    }
}
