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
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.n.m;

/* loaded from: classes2.dex */
public class SkipView extends LinearLayout implements com.kwad.components.ad.splashscreen.widget.b {
    private Runnable HI;
    private a Hw;
    private final b IW;
    private View IX;
    private TextView IY;
    private TextView IZ;
    private int Ja;
    private boolean oY;

    /* renamed from: ue */
    private boolean f11909ue;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.SkipView$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (SkipView.this.oY) {
                SkipView.this.postDelayed(this, 300L);
                return;
            }
            SkipView skipView = SkipView.this;
            skipView.a(skipView.IW);
            SkipView skipView2 = SkipView.this;
            skipView2.Y(skipView2.IW.Je - SkipView.this.IW.HD);
            if (!SkipView.this.IW.mP()) {
                SkipView.this.postDelayed(this, 1000L);
                b.d(SkipView.this.IW);
            } else if (SkipView.this.Hw != null) {
                SkipView.this.Hw.ls();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.widget.SkipView$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (SkipView.this.Hw != null) {
                SkipView.this.Hw.lr();
            }
        }
    }

    public interface a {
        void Z(int i10);

        void lr();

        void ls();
    }

    public static class b {
        private int HD;
        private String Jc;
        private String Jd;
        private int Je;
        private boolean Jf;
        private boolean Jg;

        private b() {
            this.Jc = "跳过";
            this.Jd = "";
            this.Je = 5;
            this.HD = 5;
            this.Jf = true;
            this.Jg = true;
        }

        public static /* synthetic */ int d(b bVar) {
            int i10 = bVar.HD;
            bVar.HD = i10 - 1;
            return i10;
        }

        public boolean mQ() {
            return this.Jf && this.Jg;
        }

        public final void Y(String str) {
            this.HD = -1;
            this.Jd = str;
        }

        public final void ae(int i10) {
            this.Je = i10;
            this.HD = i10;
        }

        public final String mO() {
            int i10 = this.HD;
            if (i10 < 0) {
                return this.Jd;
            }
            if (i10 == 0) {
                return this.Jd + 1;
            }
            return this.Jd + this.HD;
        }

        public final boolean mP() {
            return this.HD <= 0;
        }

        public /* synthetic */ b(byte b10) {
            this();
        }
    }

    public SkipView(Context context) {
        this(context, null);
    }

    private void C(AdInfo adInfo) {
        setTimerBtnVisible(com.kwad.sdk.core.response.b.a.cF(adInfo));
    }

    public void Y(int i10) {
        a aVar = this.Hw;
        if (aVar != null) {
            aVar.Z(i10);
        }
    }

    private void at() {
        a(this.IW);
        post(this.HI);
    }

    private void fa() {
        this.oY = true;
    }

    private void fb() {
        this.oY = false;
    }

    private void init() {
        setOrientation(0);
        m.inflate(getContext(), R.layout.ksad_skip_view, this);
        this.IY = (TextView) findViewById(R.id.ksad_skip_view_skip);
        this.IZ = (TextView) findViewById(R.id.ksad_skip_view_timer);
        this.IX = findViewById(R.id.ksad_skip_view_divider);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.2
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (SkipView.this.Hw != null) {
                    SkipView.this.Hw.lr();
                }
            }
        });
        setSkipBtnVisible(true);
        setTimerBtnVisible(true);
    }

    private void mN() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void A(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            return;
        }
        fa();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void B(AdInfo adInfo) {
        if (this.f11909ue) {
            mN();
        }
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            return;
        }
        fb();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final int ab(int i10) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = com.kwad.sdk.c.a.a.a(getContext(), 35.0f);
        int width = getWidth();
        setLayoutParams(layoutParams);
        return width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void bH() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.Ja = layoutParams.width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public void setOnViewListener(a aVar) {
        this.Hw = aVar;
    }

    public void setSkipBtnVisible(boolean z10) {
        this.IW.Jf = z10;
        a(this.IW);
    }

    public void setSkipText(String str) {
        this.IW.Jc = str;
        a(this.IW);
    }

    public void setTimerBtnVisible(boolean z10) {
        this.IW.Jg = z10;
        a(this.IW);
    }

    public void setTimerPrefixText(String str) {
        this.IW.Jd = str;
        a(this.IW);
    }

    public void setTimerSecond(int i10) {
        this.IW.ae(i10);
        a(this.IW);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(m.wrapContextIfNeed(context), attributeSet, i10);
        this.IW = new b((byte) 0);
        this.Ja = -1;
        this.oY = false;
        this.f11909ue = true;
        this.HI = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (SkipView.this.oY) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.IW);
                SkipView skipView2 = SkipView.this;
                skipView2.Y(skipView2.IW.Je - SkipView.this.IW.HD);
                if (!SkipView.this.IW.mP()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.d(SkipView.this.IW);
                } else if (SkipView.this.Hw != null) {
                    SkipView.this.Hw.ls();
                }
            }
        };
        init();
    }

    public final void Y(String str) {
        if (str == null) {
            return;
        }
        this.IW.Y(str);
        a(this.IW);
    }

    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.IY != null) {
            if (bVar.Jc != null) {
                this.IY.setText(bVar.Jc);
            }
            this.IY.setVisibility(this.IW.Jf ? 0 : 8);
        }
        String mO = bVar.mO();
        TextView textView = this.IZ;
        if (textView != null) {
            if (mO != null) {
                textView.setText(mO);
            }
            this.IZ.setVisibility(this.IW.Jg ? 0 : 8);
        }
        if (this.IX != null) {
            boolean mQ = this.IW.mQ();
            this.IX.setVisibility(mQ ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (!mQ) {
                    layoutParams.width = -2;
                    invalidate();
                    return;
                }
                int i10 = this.Ja;
                if (i10 > 0) {
                    layoutParams.width = i10;
                    invalidate();
                }
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.f11909ue = com.kwad.sdk.core.response.b.a.cE(adInfo);
        setTimerPrefixText(com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.Eq));
        setTimerSecond(splashSkipViewModel.skipSecond);
        if (!com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            at();
        }
        setSkipText(com.kwad.sdk.core.response.b.a.cq(adInfo));
        setVisibility(8);
        C(adInfo);
    }
}
