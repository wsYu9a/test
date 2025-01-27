package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.j.k;

/* loaded from: classes2.dex */
public class CloseCountDownView extends LinearLayout {
    private a DM;
    private int EA;
    private TextView EB;
    private TextView ED;
    private ImageView EE;
    private Runnable EF;
    private String Ez;
    private boolean nY;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.CloseCountDownView$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (CloseCountDownView.this.nY) {
                CloseCountDownView.this.postDelayed(this, 300L);
                return;
            }
            if (CloseCountDownView.this.EA <= 0) {
                if (CloseCountDownView.this.DM != null) {
                    CloseCountDownView.this.DM.kJ();
                }
            } else {
                CloseCountDownView.this.postDelayed(this, 1000L);
                CloseCountDownView closeCountDownView = CloseCountDownView.this;
                closeCountDownView.ag(closeCountDownView.EA);
                CloseCountDownView.d(CloseCountDownView.this);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.widget.CloseCountDownView$2 */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (CloseCountDownView.this.DM != null) {
                CloseCountDownView.this.DM.dP();
            }
        }
    }

    public interface a {
        void dP();

        void kJ();
    }

    public CloseCountDownView(Context context) {
        super(context);
        this.Ez = "%ss";
        this.EA = 5;
        this.nY = false;
        this.EF = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nY) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.EA <= 0) {
                    if (CloseCountDownView.this.DM != null) {
                        CloseCountDownView.this.DM.kJ();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ag(closeCountDownView.EA);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        X(context);
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ez = "%ss";
        this.EA = 5;
        this.nY = false;
        this.EF = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nY) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.EA <= 0) {
                    if (CloseCountDownView.this.DM != null) {
                        CloseCountDownView.this.DM.kJ();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ag(closeCountDownView.EA);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        X(context);
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Ez = "%ss";
        this.EA = 5;
        this.nY = false;
        this.EF = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nY) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.EA <= 0) {
                    if (CloseCountDownView.this.DM != null) {
                        CloseCountDownView.this.DM.kJ();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ag(closeCountDownView.EA);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        X(context);
    }

    @RequiresApi(api = 21)
    public CloseCountDownView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.Ez = "%ss";
        this.EA = 5;
        this.nY = false;
        this.EF = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nY) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.EA <= 0) {
                    if (CloseCountDownView.this.DM != null) {
                        CloseCountDownView.this.DM.kJ();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ag(closeCountDownView.EA);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        X(context);
    }

    private void X(Context context) {
        setOrientation(0);
        k.inflate(context, R.layout.ksad_endcard_close_view, this);
        this.EB = (TextView) findViewById(R.id.ksad_ad_endcard_second);
        this.ED = (TextView) findViewById(R.id.ksad_ad_endcard_line);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_splash_endcard_close_img);
        this.EE = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CloseCountDownView.this.DM != null) {
                    CloseCountDownView.this.DM.dP();
                }
            }
        });
    }

    public void ag(int i2) {
        this.EB.setText(String.format(this.Ez, Integer.valueOf(i2)));
    }

    static /* synthetic */ int d(CloseCountDownView closeCountDownView) {
        int i2 = closeCountDownView.EA;
        closeCountDownView.EA = i2 - 1;
        return i2;
    }

    private void fc() {
        post(this.EF);
    }

    private void fd() {
        this.nY = true;
    }

    private void fe() {
        this.nY = false;
    }

    public final void a(AdInfo adInfo) {
        Context context;
        float f2;
        boolean bR = com.kwad.sdk.core.response.a.a.bR(adInfo);
        this.EA = com.kwad.sdk.core.response.a.a.bQ(adInfo);
        if (bR) {
            this.EB.setVisibility(0);
            this.ED.setVisibility(0);
            ag(this.EA);
            context = getContext();
            f2 = 12.0f;
        } else {
            context = getContext();
            f2 = 4.0f;
        }
        setPadding(com.kwad.sdk.c.kwai.a.a(context, f2), 0, com.kwad.sdk.c.kwai.a.a(getContext(), f2), 0);
        fc();
    }

    public final void bn() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    public final void onPageInvisible() {
        fd();
    }

    public final void onPageVisible() {
        fe();
    }

    public void setOnViewClickListener(a aVar) {
        this.DM = aVar;
    }
}
