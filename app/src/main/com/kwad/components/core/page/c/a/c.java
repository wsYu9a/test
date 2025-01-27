package com.kwad.components.core.page.c.a;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.b.h;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public final class c extends a {
    private LinearLayout QS;
    private TextView QT;
    private TextView QU;
    private TextView QV;
    private TextView QW;
    private int QX;
    private boolean QY = false;
    private boolean QZ = false;
    private Runnable Ra = new Runnable() { // from class: com.kwad.components.core.page.c.a.c.1
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.QY) {
                bt.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (c.this.QX <= 0) {
                c.this.QT.setText("任务已完成");
                c.this.QU.setVisibility(8);
                c.this.QV.setVisibility(8);
                c.this.QW.setVisibility(8);
                h hVar = (h) com.kwad.sdk.components.d.f(h.class);
                if (hVar != null && !c.this.QZ) {
                    hVar.notifyRewardVerify();
                }
            } else {
                c.this.ql();
                bt.runOnUiThreadDelay(this, 1000L);
            }
            c.i(c.this);
        }
    };
    private final com.kwad.sdk.core.c.c yv = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.page.c.a.c.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            c.this.QY = true;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            c.this.QY = false;
        }
    };

    /* renamed from: com.kwad.components.core.page.c.a.c$1 */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.QY) {
                bt.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (c.this.QX <= 0) {
                c.this.QT.setText("任务已完成");
                c.this.QU.setVisibility(8);
                c.this.QV.setVisibility(8);
                c.this.QW.setVisibility(8);
                h hVar = (h) com.kwad.sdk.components.d.f(h.class);
                if (hVar != null && !c.this.QZ) {
                    hVar.notifyRewardVerify();
                }
            } else {
                c.this.ql();
                bt.runOnUiThreadDelay(this, 1000L);
            }
            c.i(c.this);
        }
    }

    /* renamed from: com.kwad.components.core.page.c.a.c$2 */
    public class AnonymousClass2 extends com.kwad.sdk.core.c.d {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            c.this.QY = true;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            c.this.QY = false;
        }
    }

    public static /* synthetic */ int i(c cVar) {
        int i10 = cVar.QX;
        cVar.QX = i10 - 1;
        return i10;
    }

    private void qk() {
        this.QS.setVisibility(0);
        if (!this.QL.mAdTemplate.mRewardVerifyCalled) {
            ql();
            bt.runOnUiThreadDelay(this.Ra, 1000L);
        } else {
            this.QT.setText("任务已完成");
            this.QU.setVisibility(8);
            this.QV.setVisibility(8);
            this.QW.setVisibility(8);
        }
    }

    public void ql() {
        this.QU.setText(qm());
        this.QW.setText(qn());
    }

    private String qm() {
        int i10 = this.QX / 60;
        if (i10 >= 10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i10);
            return sb2.toString();
        }
        return "0" + i10;
    }

    private String qn() {
        int i10 = this.QX % 60;
        if (i10 >= 10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i10);
            return sb2.toString();
        }
        return "0" + i10;
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.a(this.yv);
        this.QX = com.kwad.sdk.core.config.d.DG();
        qk();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.QS = (LinearLayout) findViewById(R.id.ksad_reward_land_page_open_tip);
        this.QT = (TextView) findViewById(R.id.ksad_reward_land_page_open_desc);
        this.QU = (TextView) findViewById(R.id.ksad_reward_land_page_open_minute);
        this.QV = (TextView) findViewById(R.id.ksad_reward_land_page_open_colon);
        this.QW = (TextView) findViewById(R.id.ksad_reward_land_page_open_second);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.c.b.Fi();
        com.kwad.sdk.core.c.b.b(this.yv);
        bt.c(this.Ra);
    }
}
