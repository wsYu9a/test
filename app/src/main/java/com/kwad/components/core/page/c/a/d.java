package com.kwad.components.core.page.c.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public final class d extends a {
    private View Rc;
    private TextView Rd;
    private int Re;
    private Runnable Rf = new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1

        /* renamed from: com.kwad.components.core.page.c.a.d$1$1 */
        public class RunnableC04391 implements Runnable {
            public RunnableC04391() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.this.Rc.setVisibility(8);
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.kwad.components.core.q.a.rJ().rM()) {
                bt.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (d.this.Re <= 0) {
                d.this.Rd.setText("已获得权益");
                bt.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1.1
                    public RunnableC04391() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.Rc.setVisibility(8);
                    }
                }, 500L);
                com.kwad.components.core.q.a.rJ().aL(true);
            } else {
                d.this.Rd.setText(String.format("倒计时%d秒", Integer.valueOf(d.this.Re)));
                d.c(d.this);
                com.kwad.components.core.q.a.rJ().aK(d.this.Re);
                bt.runOnUiThreadDelay(this, 1000L);
            }
        }
    };

    /* renamed from: com.kwad.components.core.page.c.a.d$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: com.kwad.components.core.page.c.a.d$1$1 */
        public class RunnableC04391 implements Runnable {
            public RunnableC04391() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.this.Rc.setVisibility(8);
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.kwad.components.core.q.a.rJ().rM()) {
                bt.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (d.this.Re <= 0) {
                d.this.Rd.setText("已获得权益");
                bt.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1.1
                    public RunnableC04391() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.Rc.setVisibility(8);
                    }
                }, 500L);
                com.kwad.components.core.q.a.rJ().aL(true);
            } else {
                d.this.Rd.setText(String.format("倒计时%d秒", Integer.valueOf(d.this.Re)));
                d.c(d.this);
                com.kwad.components.core.q.a.rJ().aK(d.this.Re);
                bt.runOnUiThreadDelay(this, 1000L);
            }
        }
    }

    public static /* synthetic */ int c(d dVar) {
        int i10 = dVar.Re;
        dVar.Re = i10 - 1;
        return i10;
    }

    private void qo() {
        TextView textView;
        if (this.Rc == null || (textView = this.Rd) == null) {
            return;
        }
        textView.setText(String.format("倒计时%d秒", Integer.valueOf(this.Re)));
        this.Rc.setVisibility(0);
        bt.runOnUiThreadDelay(this.Rf, 1000L);
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.Re = com.kwad.sdk.core.response.b.a.aM(com.kwad.sdk.core.response.b.e.eb(this.QL.mAdTemplate));
        com.kwad.components.core.q.a.rJ().aK(this.Re);
        qo();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Rc = findViewById(R.id.ksad_web_reward_task_layout);
        this.Rd = (TextView) findViewById(R.id.ksad_web_reward_task_text);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        bt.c(this.Rf);
    }
}
