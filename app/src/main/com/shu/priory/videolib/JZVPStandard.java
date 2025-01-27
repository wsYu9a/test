package com.shu.priory.videolib;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.shu.priory.R;
import com.shu.priory.listener.IFLYVideoListener;
import com.shu.priory.utils.h;
import com.shu.priory.utils.j;
import com.sigmob.sdk.base.common.y;
import com.sigmob.sdk.base.k;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public class JZVPStandard extends JZPlayer {
    public ProgressBar T;
    public ImageView U;
    public TextView V;
    public LinearLayout W;

    /* renamed from: aa */
    public int f17352aa;

    /* renamed from: ab */
    public int f17353ab;

    /* renamed from: ac */
    public int f17354ac;

    /* renamed from: ad */
    public int f17355ad;

    /* renamed from: ae */
    public int f17356ae;

    /* renamed from: af */
    public int f17357af;

    /* renamed from: ag */
    public int f17358ag;

    /* renamed from: ah */
    public int f17359ah;

    /* renamed from: ai */
    public int f17360ai;

    /* renamed from: aj */
    private Timer f17361aj;

    /* renamed from: ak */
    private a f17362ak;

    /* renamed from: com.shu.priory.videolib.JZVPStandard$1 */
    public class AnonymousClass1 implements DialogInterface.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            JZVPStandard.this.j();
        }
    }

    /* renamed from: com.shu.priory.videolib.JZVPStandard$2 */
    public class AnonymousClass2 implements DialogInterface.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.shu.priory.videolib.JZVPStandard$3 */
    public class AnonymousClass3 implements DialogInterface.OnCancelListener {
        public AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
        }
    }

    /* renamed from: com.shu.priory.videolib.JZVPStandard$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JZVPStandard.this.f17338r.setVisibility(4);
            JZVPStandard.this.f17332l.setVisibility(4);
        }
    }

    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            JZVPStandard.this.V();
        }
    }

    public JZVPStandard(Context context) {
        super(context);
    }

    @Override // com.shu.priory.videolib.JZPlayer
    public void I() {
        super.I();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("您当前正在使用移动网络，继续播放将消耗流量！");
        builder.setPositiveButton("继续", new DialogInterface.OnClickListener() { // from class: com.shu.priory.videolib.JZVPStandard.1
            public AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                dialogInterface.dismiss();
                JZVPStandard.this.j();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.shu.priory.videolib.JZVPStandard.2
            public AnonymousClass2() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                dialogInterface.dismiss();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.shu.priory.videolib.JZVPStandard.3
            public AnonymousClass3() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public void J() {
        int i10 = this.f17326f;
        if (i10 == 1) {
            L();
            return;
        }
        if (i10 == 3) {
            if (this.f17338r.getVisibility() == 0) {
                N();
                return;
            } else {
                M();
                return;
            }
        }
        if (i10 != 5) {
            return;
        }
        if (this.f17338r.getVisibility() == 0) {
            P();
        } else {
            O();
        }
    }

    public void K() {
        a(4, 0, 4, 0, 4);
        S();
    }

    public void L() {
        a(4, 4, 0, 0, 4);
        S();
    }

    public void M() {
        a(0, 0, 4, 4, 4);
        S();
    }

    public void N() {
        a(4, 4, 4, 4, 4);
    }

    public void O() {
        a(0, 0, 4, 4, 4);
        S();
    }

    public void P() {
        a(4, 4, 4, 4, 4);
    }

    public void Q() {
        a(4, 0, 4, 0, 4);
        S();
    }

    public void R() {
        a(4, 0, 4, 4, 0);
        S();
    }

    public void S() {
        ImageView imageView;
        int i10;
        int i11 = this.f17326f;
        if (i11 != 3) {
            if (i11 != 7) {
                if (i11 != 6) {
                    imageView = this.f17332l;
                    i10 = this.f17358ag;
                } else if (this.K == 0) {
                    this.f17332l.setVisibility(0);
                    imageView = this.f17332l;
                    i10 = this.f17360ai;
                }
            }
            this.f17332l.setVisibility(4);
            return;
        }
        this.f17332l.setVisibility(0);
        imageView = this.f17332l;
        i10 = this.f17359ah;
        imageView.setImageResource(i10);
    }

    public void T() {
        U();
        this.f17361aj = new Timer();
        a aVar = new a();
        this.f17362ak = aVar;
        this.f17361aj.schedule(aVar, y.f.f18076n);
    }

    public void U() {
        Timer timer = this.f17361aj;
        if (timer != null) {
            timer.cancel();
        }
        a aVar = this.f17362ak;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public void V() {
        int i10 = this.f17326f;
        if (i10 == 0 || i10 == 7 || i10 == 6 || getContext() == null || !(getContext() instanceof Activity)) {
            return;
        }
        ((Activity) getContext()).runOnUiThread(new Runnable() { // from class: com.shu.priory.videolib.JZVPStandard.4
            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                JZVPStandard.this.f17338r.setVisibility(4);
                JZVPStandard.this.f17332l.setVisibility(4);
            }
        });
    }

    public void a(int i10) {
        ViewGroup.LayoutParams layoutParams = this.f17332l.getLayoutParams();
        layoutParams.height = i10;
        layoutParams.width = i10;
    }

    @Override // com.shu.priory.videolib.JZPlayer
    public void b(Context context) {
        super.b(context);
        int i10 = R.id.ifly_ad_loading_progress;
        this.f17352aa = i10;
        this.f17353ab = R.id.ifly_ad_thumb;
        this.f17354ac = R.id.ifly_ad_retry_btn;
        this.f17355ad = R.id.ifly_ad_layout_retry;
        this.f17356ae = R.drawable.ifly_ad_jz_shrink;
        this.f17357af = R.drawable.ifly_ad_jz_enlarge;
        this.f17358ag = R.drawable.ifly_ad_jz_click_play_selector;
        this.f17359ah = R.drawable.ifly_ad_jz_click_pause_selector;
        this.f17360ai = R.drawable.ifly_ad_jz_click_replay_selector;
        this.T = (ProgressBar) findViewById(i10);
        this.U = (ImageView) findViewById(this.f17353ab);
        this.V = (TextView) findViewById(this.f17354ac);
        this.W = (LinearLayout) findViewById(this.f17355ad);
    }

    @Override // com.shu.priory.videolib.JZPlayer
    public int getLayoutId() {
        return R.layout.ifly_ad_jz_layout_standard;
    }

    @Override // com.shu.priory.videolib.JZPlayer
    public void l() {
        super.l();
        K();
    }

    @Override // com.shu.priory.videolib.JZPlayer
    public void m() {
        super.m();
        L();
    }

    @Override // com.shu.priory.videolib.JZPlayer
    public void o() {
        super.o();
        N();
        if (this.I.f17155a) {
            return;
        }
        j.a(this.H.f17139i);
        this.I.f17155a = true;
    }

    @Override // com.shu.priory.videolib.JZPlayer, android.view.View.OnClickListener
    public void onClick(View view) {
        IFLYVideoListener iFLYVideoListener;
        super.onClick(view);
        int id2 = view.getId();
        if (id2 == this.f17353ab) {
            com.shu.priory.videolib.a aVar = this.f17324d;
            if (aVar == null || aVar.f17370c.isEmpty() || this.f17324d.a() == null) {
                h.a("JZVideoPlayer", "播放地址无效");
                return;
            }
            int i10 = this.f17326f;
            if (i10 == 0) {
                if (this.f17324d.a().toString().startsWith(k.f18193y) || this.f17324d.a().toString().startsWith("/") || com.shu.priory.utils.k.b(getContext()) || !this.L) {
                    j();
                    return;
                } else {
                    I();
                    return;
                }
            }
            if (i10 == 6) {
                j();
                if (this.I.f17165k) {
                    return;
                }
                j.a(this.H.f17149s);
                this.I.f17165k = true;
                return;
            }
            return;
        }
        if (id2 == this.f17346z) {
            if (this.K != 0) {
                iFLYVideoListener = this.J;
                if (iFLYVideoListener == null) {
                    return;
                }
            } else if (!this.f17330j) {
                T();
                J();
                return;
            } else {
                iFLYVideoListener = this.J;
                if (iFLYVideoListener == null) {
                    return;
                }
            }
            iFLYVideoListener.onAdClick();
            return;
        }
        if (id2 == this.f17354ac) {
            if (!this.f17324d.a().toString().startsWith(k.f18193y) && !this.f17324d.a().toString().startsWith("/") && !com.shu.priory.utils.k.b(getContext()) && this.L) {
                I();
                return;
            }
            u();
            v();
            c.a(this.f17324d);
            m();
        }
    }

    @Override // com.shu.priory.videolib.JZPlayer, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        U();
    }

    @Override // com.shu.priory.videolib.JZPlayer, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        if (this.f17326f == 3) {
            V();
        } else if (this.K == 0) {
            T();
        }
    }

    @Override // com.shu.priory.videolib.JZPlayer, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == this.f17344x) {
            int action = motionEvent.getAction();
            if (action == 0) {
                U();
            } else if (action == 1) {
                T();
            }
        }
        return super.onTouch(view, motionEvent);
    }

    @Override // com.shu.priory.videolib.JZPlayer
    public void p() {
        super.p();
        O();
        T();
    }

    @Override // com.shu.priory.videolib.JZPlayer
    public void q() {
        super.q();
        R();
        IFLYVideoListener iFLYVideoListener = this.J;
        if (iFLYVideoListener != null) {
            iFLYVideoListener.onAdPlayError();
        }
    }

    @Override // com.shu.priory.videolib.JZPlayer
    public void r() {
        super.r();
        if (this.K == 0) {
            Q();
            U();
            this.f17334n.setImageResource(this.C);
        }
        if (this.I.f17159e) {
            return;
        }
        j.a(this.H.f17143m);
        this.I.f17159e = true;
    }

    @Override // com.shu.priory.videolib.JZPlayer
    public void s() {
        super.s();
        U();
    }

    @Override // com.shu.priory.videolib.JZPlayer
    public void t() {
        super.t();
        U();
    }

    public JZVPStandard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(int i10, int i11, int i12, int i13, int i14) {
        this.f17338r.setVisibility(i10);
        this.f17332l.setVisibility(i11);
        this.T.setVisibility(i12);
        this.U.setVisibility(i13);
        this.W.setVisibility(i14);
    }

    @Override // com.shu.priory.videolib.JZPlayer
    public void a(int i10, long j10) {
        super.a(i10, j10);
        this.T.setVisibility(0);
        this.f17332l.setVisibility(4);
    }

    @Override // com.shu.priory.videolib.JZPlayer
    public void a(Context context) {
        super.a(context);
        b(context);
        this.U.setOnClickListener(this);
        this.V.setOnClickListener(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0031  */
    @Override // com.shu.priory.videolib.JZPlayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.shu.priory.videolib.a r1, int r2, java.lang.Object... r3) {
        /*
            r0 = this;
            super.a(r1, r2, r3)
            int r1 = r0.f17327g
            r2 = 1
            if (r1 != r2) goto L1d
            android.widget.ImageView r1 = r0.f17333m
            int r3 = r0.f17356ae
            r1.setImageResource(r3)
            android.content.Context r1 = r0.getContext()
            r3 = 1115160576(0x42780000, float:62.0)
        L15:
            int r1 = com.shu.priory.videolib.e.a(r1, r3)
            r0.a(r1)
            goto L2d
        L1d:
            if (r1 != 0) goto L2d
            android.widget.ImageView r1 = r0.f17333m
            int r3 = r0.f17357af
            r1.setImageResource(r3)
            android.content.Context r1 = r0.getContext()
            r3 = 1110704128(0x42340000, float:45.0)
            goto L15
        L2d:
            int r1 = r0.f17328h
            if (r1 != 0) goto L39
            android.widget.ImageView r1 = r0.f17334n
            int r2 = r0.C
        L35:
            r1.setImageResource(r2)
            goto L40
        L39:
            if (r1 != r2) goto L40
            android.widget.ImageView r1 = r0.f17334n
            int r2 = r0.B
            goto L35
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.videolib.JZVPStandard.a(com.shu.priory.videolib.a, int, java.lang.Object[]):void");
    }
}
