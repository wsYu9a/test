package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.n.m;
import com.kwad.sdk.utils.ah;

/* loaded from: classes2.dex */
public class CloseCountDownView extends LinearLayout {
    private a Gk;
    private String HC;
    private int HD;
    private TextView HE;
    private TextView HF;
    private ImageView HG;
    private com.kwad.components.ad.splashscreen.widget.a HH;
    private Runnable HI;
    private boolean oY;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.CloseCountDownView$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (CloseCountDownView.this.oY) {
                CloseCountDownView.this.postDelayed(this, 300L);
                return;
            }
            if (CloseCountDownView.this.HD <= 0) {
                if (CloseCountDownView.this.Gk != null) {
                    CloseCountDownView.this.Gk.ls();
                }
            } else {
                CloseCountDownView.this.postDelayed(this, 1000L);
                CloseCountDownView closeCountDownView = CloseCountDownView.this;
                closeCountDownView.ac(closeCountDownView.HD);
                CloseCountDownView.d(CloseCountDownView.this);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.widget.CloseCountDownView$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (CloseCountDownView.this.Gk != null) {
                CloseCountDownView.this.Gk.dB();
            }
        }
    }

    public interface a {
        void dB();

        void ls();
    }

    public CloseCountDownView(Context context) {
        super(context);
        this.HC = "%ss";
        this.HD = 5;
        this.oY = false;
        this.HI = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.oY) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.HD <= 0) {
                    if (CloseCountDownView.this.Gk != null) {
                        CloseCountDownView.this.Gk.ls();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ac(closeCountDownView.HD);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        ag(context);
    }

    public void ac(int i10) {
        this.HE.setText(String.format(this.HC, Integer.valueOf(i10)));
    }

    private void ag(Context context) {
        setOrientation(0);
        m.inflate(context, R.layout.ksad_endcard_close_view, this);
        this.HE = (TextView) findViewById(R.id.ksad_ad_endcard_second);
        this.HF = (TextView) findViewById(R.id.ksad_ad_endcard_line);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_splash_endcard_close_img);
        this.HG = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.2
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CloseCountDownView.this.Gk != null) {
                    CloseCountDownView.this.Gk.dB();
                }
            }
        });
    }

    private void at() {
        post(this.HI);
    }

    public static /* synthetic */ int d(CloseCountDownView closeCountDownView) {
        int i10 = closeCountDownView.HD;
        closeCountDownView.HD = i10 - 1;
        return i10;
    }

    private void fa() {
        this.oY = true;
    }

    private void fb() {
        this.oY = false;
    }

    private void mA() {
        ah.a(this, this.HH.me());
        ah.a(this.HF, this.HH.mD());
        ah.a(this.HG, this.HH.mG());
        this.HE.setTextSize(0, this.HH.mE());
        this.HF.setTextSize(0, this.HH.mE());
        Drawable background = getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(this.HH.mF());
        }
    }

    public final void bH() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    public final void bl() {
        fb();
    }

    public final void bm() {
        fa();
    }

    public void setOnViewClickListener(a aVar) {
        this.Gk = aVar;
    }

    public final void a(AdInfo adInfo, float f10) {
        com.kwad.components.ad.splashscreen.widget.a ah2;
        boolean m37do = com.kwad.sdk.core.response.b.a.m37do(adInfo);
        if (m37do) {
            ah2 = com.kwad.components.ad.splashscreen.widget.a.ai(getContext());
        } else {
            ah2 = com.kwad.components.ad.splashscreen.widget.a.ah(getContext());
        }
        this.HH = ah2;
        ah2.d(f10);
        boolean ct = com.kwad.sdk.core.response.b.a.ct(adInfo);
        this.HD = com.kwad.sdk.core.response.b.a.cs(adInfo);
        if (m37do) {
            mA();
        }
        if (ct) {
            this.HE.setVisibility(0);
            this.HF.setVisibility(0);
            ac(this.HD);
            float mC = this.HH.mC();
            setPadding(com.kwad.sdk.c.a.a.a(getContext(), mC), 0, com.kwad.sdk.c.a.a.a(getContext(), mC), 0);
        } else {
            float mB = this.HH.mB();
            setPadding(com.kwad.sdk.c.a.a.a(getContext(), mB), 0, com.kwad.sdk.c.a.a.a(getContext(), mB), 0);
        }
        at();
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HC = "%ss";
        this.HD = 5;
        this.oY = false;
        this.HI = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.oY) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.HD <= 0) {
                    if (CloseCountDownView.this.Gk != null) {
                        CloseCountDownView.this.Gk.ls();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ac(closeCountDownView.HD);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        ag(context);
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.HC = "%ss";
        this.HD = 5;
        this.oY = false;
        this.HI = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.oY) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.HD <= 0) {
                    if (CloseCountDownView.this.Gk != null) {
                        CloseCountDownView.this.Gk.ls();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ac(closeCountDownView.HD);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        ag(context);
    }

    @RequiresApi(api = 21)
    public CloseCountDownView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.HC = "%ss";
        this.HD = 5;
        this.oY = false;
        this.HI = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.oY) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.HD <= 0) {
                    if (CloseCountDownView.this.Gk != null) {
                        CloseCountDownView.this.Gk.ls();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ac(closeCountDownView.HD);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        ag(context);
    }
}
