package com.kwad.components.core.page.a.kwai;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bi;

/* loaded from: classes2.dex */
public final class d extends a {
    private View LW;
    private TextView LX;
    private int LY;
    private Runnable LZ = new Runnable() { // from class: com.kwad.components.core.page.a.kwai.d.1

        /* renamed from: com.kwad.components.core.page.a.kwai.d$1$1 */
        final class RunnableC01831 implements Runnable {
            RunnableC01831() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.this.LW.setVisibility(8);
            }
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.kwad.components.core.p.a.pt().pw()) {
                bi.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (d.this.LY <= 0) {
                d.this.LX.setText("已获得权益");
                bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.a.kwai.d.1.1
                    RunnableC01831() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.LW.setVisibility(8);
                    }
                }, 500L);
                com.kwad.components.core.p.a.pt().aI(true);
            } else {
                d.this.LX.setText(String.format("倒计时%d秒", Integer.valueOf(d.this.LY)));
                d.c(d.this);
                com.kwad.components.core.p.a.pt().aH(d.this.LY);
                bi.runOnUiThreadDelay(this, 1000L);
            }
        }
    };

    /* renamed from: com.kwad.components.core.page.a.kwai.d$1 */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: com.kwad.components.core.page.a.kwai.d$1$1 */
        final class RunnableC01831 implements Runnable {
            RunnableC01831() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.this.LW.setVisibility(8);
            }
        }

        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.kwad.components.core.p.a.pt().pw()) {
                bi.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (d.this.LY <= 0) {
                d.this.LX.setText("已获得权益");
                bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.a.kwai.d.1.1
                    RunnableC01831() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.LW.setVisibility(8);
                    }
                }, 500L);
                com.kwad.components.core.p.a.pt().aI(true);
            } else {
                d.this.LX.setText(String.format("倒计时%d秒", Integer.valueOf(d.this.LY)));
                d.c(d.this);
                com.kwad.components.core.p.a.pt().aH(d.this.LY);
                bi.runOnUiThreadDelay(this, 1000L);
            }
        }
    }

    static /* synthetic */ int c(d dVar) {
        int i2 = dVar.LY;
        dVar.LY = i2 - 1;
        return i2;
    }

    private void oq() {
        TextView textView;
        if (this.LW == null || (textView = this.LX) == null) {
            return;
        }
        textView.setText(String.format("倒计时%d秒", Integer.valueOf(this.LY)));
        this.LW.setVisibility(0);
        bi.runOnUiThreadDelay(this.LZ, 1000L);
    }

    @Override // com.kwad.components.core.page.a.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.LY = com.kwad.sdk.core.response.a.a.aE(com.kwad.sdk.core.response.a.d.cb(this.LG.mAdTemplate));
        com.kwad.components.core.p.a.pt().aH(this.LY);
        oq();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.LW = findViewById(R.id.ksad_web_reward_task_layout);
        this.LX = (TextView) findViewById(R.id.ksad_web_reward_task_text);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        bi.b(this.LZ);
    }
}
