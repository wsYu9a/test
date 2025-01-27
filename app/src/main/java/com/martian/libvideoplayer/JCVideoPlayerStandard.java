package com.martian.libvideoplayer;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.martian.libvideoplayer.JCVideoPlayerStandard;
import com.sigmob.sdk.base.k;
import ja.l;
import ja.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;
import l9.m0;

/* loaded from: classes3.dex */
public class JCVideoPlayerStandard extends JCVideoPlayer {
    public static Timer Z0;
    public ImageView C0;
    public LinearLayout D0;
    public ImageView E0;
    public TextView F0;
    public TextView G0;
    public TextView H0;
    public PopupWindow I0;
    public c J0;
    public b K0;
    public boolean L0;
    public final BroadcastReceiver M0;
    public Dialog N0;
    public ProgressBar O0;
    public TextView P0;
    public TextView Q0;
    public ImageView R0;
    public Dialog S0;
    public ProgressBar T0;
    public TextView U0;
    public ImageView V0;
    public Dialog W0;
    public ProgressBar X0;
    public TextView Y0;

    /* renamed from: q0 */
    public ImageView f13059q0;

    /* renamed from: r0 */
    public ProgressBar f13060r0;

    /* renamed from: s0 */
    public ProgressBar f13061s0;

    /* renamed from: t0 */
    public TextView f13062t0;

    /* renamed from: u0 */
    public ImageView f13063u0;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
                if (intExtra < 15) {
                    JCVideoPlayerStandard.this.E0.setBackgroundResource(R.drawable.jc_battery_level_10);
                } else if (intExtra < 40) {
                    JCVideoPlayerStandard.this.E0.setBackgroundResource(R.drawable.jc_battery_level_30);
                } else if (intExtra < 60) {
                    JCVideoPlayerStandard.this.E0.setBackgroundResource(R.drawable.jc_battery_level_50);
                } else if (intExtra < 80) {
                    JCVideoPlayerStandard.this.E0.setBackgroundResource(R.drawable.jc_battery_level_70);
                } else if (intExtra < 95) {
                    JCVideoPlayerStandard.this.E0.setBackgroundResource(R.drawable.jc_battery_level_90);
                } else if (intExtra <= 100) {
                    JCVideoPlayerStandard.this.E0.setBackgroundResource(R.drawable.jc_battery_level_100);
                }
                JCVideoPlayerStandard.this.getContext().unregisterReceiver(JCVideoPlayerStandard.this.M0);
                JCVideoPlayerStandard.this.L0 = false;
            }
        }
    }

    public class b extends TimerTask {
        public b() {
        }

        public final /* synthetic */ void b() {
            JCVideoPlayerStandard.this.f13046o.setVisibility(4);
            JCVideoPlayerStandard.this.f13045n.setVisibility(4);
            JCVideoPlayerStandard.this.f13039h.setVisibility(4);
            PopupWindow popupWindow = JCVideoPlayerStandard.this.I0;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            JCVideoPlayerStandard jCVideoPlayerStandard = JCVideoPlayerStandard.this;
            if (jCVideoPlayerStandard.f13034c != 3) {
                jCVideoPlayerStandard.f13060r0.setVisibility(0);
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            JCVideoPlayerStandard jCVideoPlayerStandard = JCVideoPlayerStandard.this;
            int i10 = jCVideoPlayerStandard.f13033b;
            if (i10 == 0 || i10 == 7 || i10 == 6 || jCVideoPlayerStandard.getContext() == null || !(JCVideoPlayerStandard.this.getContext() instanceof Activity)) {
                return;
            }
            ((Activity) JCVideoPlayerStandard.this.getContext()).runOnUiThread(new Runnable() { // from class: ja.t
                public /* synthetic */ t() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    JCVideoPlayerStandard.b.this.b();
                }
            });
        }
    }

    public interface c {
        void a();

        void b();
    }

    public JCVideoPlayerStandard(Context context) {
        super(context);
        this.L0 = false;
        this.M0 = new a();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void A() {
        super.A();
        m0();
    }

    public void A0() {
        int i10 = this.f13033b;
        if (i10 == 1) {
            if (this.f13046o.getVisibility() == 0) {
                t0();
                return;
            }
            return;
        }
        if (i10 == 3) {
            if (this.f13046o.getVisibility() == 0) {
                r0();
            }
        } else if (i10 == 5) {
            if (this.f13046o.getVisibility() == 0) {
                n0();
            }
        } else if (i10 == 6) {
            if (this.f13046o.getVisibility() == 0) {
                j0();
            }
        } else if (i10 == 4 && this.f13046o.getVisibility() == 0) {
            p0();
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void B() {
        super.B();
        o0();
        h0();
    }

    public void B0() {
        if (this.f13046o.getVisibility() != 0) {
            D0();
            this.H0.setText(l.e(this.F, this.G));
        }
        int i10 = this.f13033b;
        if (i10 == 1) {
            if (this.f13046o.getVisibility() == 0) {
                t0();
                return;
            } else {
                u0();
                D0();
                return;
            }
        }
        if (i10 == 3) {
            if (this.f13046o.getVisibility() == 0) {
                r0();
                return;
            } else {
                s0();
                return;
            }
        }
        if (i10 == 5) {
            if (this.f13046o.getVisibility() == 0) {
                n0();
                return;
            } else {
                o0();
                return;
            }
        }
        if (i10 == 4) {
            if (this.f13046o.getVisibility() == 0) {
                p0();
            } else {
                q0();
            }
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void C() {
        super.C();
        q0();
    }

    public void C0(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f13045n.setVisibility(i10);
        this.f13046o.setVisibility(i11);
        this.f13039h.setVisibility(i12);
        this.f13061s0.setVisibility(i13);
        this.f13063u0.setVisibility(i14);
        this.f13060r0.setVisibility(i16);
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void D() {
        super.D();
        s0();
        E0();
        c cVar = this.J0;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void D0() {
        this.F0.setText(new SimpleDateFormat("HH:mm").format(new Date()));
        if (this.L0) {
            return;
        }
        getContext().registerReceiver(this.M0, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void E() {
        super.E();
        u0();
        E0();
    }

    public void E0() {
        h0();
        Z0 = new Timer();
        b bVar = new b();
        this.K0 = bVar;
        Z0.schedule(bVar, 2500L);
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void F(int i10, int i11) {
        super.F(i10, i11);
        this.f13061s0.setVisibility(0);
        this.f13039h.setVisibility(4);
    }

    public void F0() {
        int i10 = this.f13033b;
        if (i10 == 3) {
            this.f13039h.setImageResource(R.drawable.jc_click_pause_selector);
            this.G0.setVisibility(4);
        } else if (i10 == 7) {
            this.f13039h.setImageResource(R.drawable.jc_click_error_selector);
            this.G0.setVisibility(4);
        } else if (i10 == 6) {
            this.f13039h.setImageResource(R.drawable.jc_click_replay_selector);
            this.G0.setVisibility(0);
        } else {
            this.f13039h.setImageResource(R.drawable.jc_click_play_selector);
            this.G0.setVisibility(4);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void L() {
        super.L();
        this.f13060r0.setProgress(0);
        this.f13060r0.setSecondaryProgress(0);
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void M(int i10, int i11, int i12) {
        super.M(i10, i11, i12);
        if (i10 != 0) {
            this.f13060r0.setProgress(i10);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void P(LinkedHashMap linkedHashMap, int i10, int i11, Object... objArr) {
        super.P(linkedHashMap, i10, i11, objArr);
        if (objArr.length == 0) {
            return;
        }
        this.f13062t0.setText(objArr[0].toString());
        int i12 = this.f13034c;
        if (i12 == 2) {
            this.f13041j.setImageResource(R.drawable.jc_shrink);
            this.f13059q0.setVisibility(0);
            this.C0.setVisibility(4);
            this.D0.setVisibility(0);
            if (linkedHashMap.size() == 1) {
                this.H0.setVisibility(8);
            } else {
                this.H0.setText(l.e(linkedHashMap, this.G));
                this.H0.setVisibility(0);
            }
            i0((int) getResources().getDimension(R.dimen.jc_start_button_w_h_fullscreen));
        } else if (i12 == 0 || i12 == 1) {
            this.f13041j.setImageResource(R.drawable.jc_enlarge);
            this.f13059q0.setVisibility(8);
            this.C0.setVisibility(4);
            i0((int) getResources().getDimension(R.dimen.jc_start_button_w_h_normal));
            this.D0.setVisibility(8);
            this.H0.setVisibility(8);
        } else if (i12 == 3) {
            this.C0.setVisibility(0);
            C0(4, 4, 4, 4, 4, 4, 4);
            this.D0.setVisibility(8);
            this.H0.setVisibility(8);
        }
        D0();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void Q(int i10) {
        super.Q(i10);
        if (this.W0 == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.jc_dialog_brightness, (ViewGroup) null);
            this.Y0 = (TextView) inflate.findViewById(R.id.tv_brightness);
            this.X0 = (ProgressBar) inflate.findViewById(R.id.brightness_progressbar);
            this.W0 = v0(inflate);
        }
        if (!this.W0.isShowing()) {
            this.W0.show();
        }
        if (i10 > 100) {
            i10 = 100;
        } else if (i10 < 0) {
            i10 = 0;
        }
        this.Y0.setText(i10 + "%");
        this.X0.setProgress(i10);
        A0();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void R(float f10, String str, int i10, String str2, int i11) {
        super.R(f10, str, i10, str2, i11);
        if (this.N0 == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.jc_dialog_progress, (ViewGroup) null);
            this.O0 = (ProgressBar) inflate.findViewById(R.id.duration_progressbar);
            this.P0 = (TextView) inflate.findViewById(R.id.tv_current);
            this.Q0 = (TextView) inflate.findViewById(R.id.tv_duration);
            this.R0 = (ImageView) inflate.findViewById(R.id.duration_image_tip);
            this.N0 = v0(inflate);
        }
        if (!this.N0.isShowing()) {
            this.N0.show();
        }
        this.P0.setText(str);
        this.Q0.setText(" / " + str2);
        this.O0.setProgress(i11 <= 0 ? 0 : (i10 * 100) / i11);
        if (f10 > 0.0f) {
            this.R0.setBackgroundResource(R.drawable.jc_forward_icon);
        } else {
            this.R0.setBackgroundResource(R.drawable.jc_backward_icon);
        }
        A0();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void T(float f10, int i10) {
        super.T(f10, i10);
        if (this.S0 == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.jc_dialog_volume, (ViewGroup) null);
            this.V0 = (ImageView) inflate.findViewById(R.id.volume_image_tip);
            this.U0 = (TextView) inflate.findViewById(R.id.tv_volume);
            this.T0 = (ProgressBar) inflate.findViewById(R.id.volume_progressbar);
            this.S0 = v0(inflate);
        }
        if (!this.S0.isShowing()) {
            this.S0.show();
        }
        if (i10 <= 0) {
            this.V0.setBackgroundResource(R.drawable.jc_close_volume);
        } else {
            this.V0.setBackgroundResource(R.drawable.jc_add_volume);
        }
        if (i10 > 100) {
            i10 = 100;
        } else if (i10 < 0) {
            i10 = 0;
        }
        this.U0.setText(i10 + "%");
        this.T0.setProgress(i10);
        A0();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void U(int i10) {
        super.U(i10);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(getResources().getString(R.string.tips_not_wifi));
        builder.setPositiveButton(getResources().getString(R.string.tips_not_wifi_confirm), new DialogInterface.OnClickListener() { // from class: ja.p
            public /* synthetic */ p() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                JCVideoPlayerStandard.this.x0(dialogInterface, i11);
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.tips_not_wifi_cancel), new DialogInterface.OnClickListener() { // from class: ja.q
            public /* synthetic */ q() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                JCVideoPlayerStandard.this.y0(dialogInterface, i11);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ja.r
            public /* synthetic */ r() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                JCVideoPlayerStandard.this.z0(dialogInterface);
            }
        });
        builder.create().show();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public int getLayoutId() {
        return R.layout.jc_layout_standard;
    }

    public void h0() {
        Timer timer = Z0;
        if (timer != null) {
            timer.cancel();
        }
        b bVar = this.K0;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public void i0(int i10) {
        ViewGroup.LayoutParams layoutParams = this.f13039h.getLayoutParams();
        layoutParams.height = i10;
        layoutParams.width = i10;
        ViewGroup.LayoutParams layoutParams2 = this.f13061s0.getLayoutParams();
        layoutParams2.height = i10;
        layoutParams2.width = i10;
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void j() {
        super.j();
        Dialog dialog = this.W0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void j0() {
        int i10 = this.f13034c;
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            C0(0, 4, 0, 4, 0, 4, 4);
            F0();
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void k() {
        super.k();
        Dialog dialog = this.N0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void k0() {
        int i10 = this.f13034c;
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            C0(0, 0, 0, 4, 0, 4, 4);
            F0();
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void l() {
        super.l();
        Dialog dialog = this.S0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void l0() {
        int i10 = this.f13034c;
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            C0(4, 4, 0, 4, 4, 0, 4);
            F0();
        }
    }

    public void m0() {
        int i10 = this.f13034c;
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            C0(0, 4, 0, 4, 0, 0, 4);
            F0();
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void n(Context context) {
        super.n(context);
        this.D0 = (LinearLayout) findViewById(R.id.battery_time_layout);
        this.f13060r0 = (ProgressBar) findViewById(R.id.bottom_progress);
        this.f13062t0 = (TextView) findViewById(R.id.title);
        this.f13059q0 = (ImageView) findViewById(R.id.back);
        this.f13063u0 = (ImageView) findViewById(R.id.thumb);
        this.f13061s0 = (ProgressBar) findViewById(R.id.loading);
        this.C0 = (ImageView) findViewById(R.id.back_tiny);
        this.E0 = (ImageView) findViewById(R.id.battery_level);
        this.F0 = (TextView) findViewById(R.id.video_current_time);
        this.G0 = (TextView) findViewById(R.id.retry_text);
        this.H0 = (TextView) findViewById(R.id.clarity);
        this.f13063u0.setOnClickListener(this);
        this.f13059q0.setOnClickListener(this);
        this.C0.setOnClickListener(this);
        this.H0.setOnClickListener(this);
    }

    public void n0() {
        int i10 = this.f13034c;
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            C0(4, 4, 4, 4, 4, 4, 4);
        }
    }

    public void o0() {
        int i10 = this.f13034c;
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            C0(0, 0, 0, 4, 4, 4, 4);
            F0();
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id2 = view.getId();
        if (id2 == R.id.thumb) {
            if (TextUtils.isEmpty(l.d(this.F, this.G))) {
                Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
                return;
            }
            int i10 = this.f13033b;
            if (i10 != 0) {
                if (i10 == 6) {
                    B0();
                    return;
                }
                return;
            } else if (!l.d(this.F, this.G).startsWith(k.f18193y) && !l.d(this.F, this.G).startsWith("/") && !l.h(getContext()) && !JCVideoPlayer.P) {
                U(101);
                return;
            } else {
                u(101);
                Y();
                return;
            }
        }
        if (id2 == R.id.surface_container) {
            E0();
            return;
        }
        if (id2 == R.id.back) {
            JCVideoPlayer.e();
            return;
        }
        if (id2 == R.id.back_tiny) {
            JCVideoPlayer.e();
            return;
        }
        if (id2 == R.id.clarity) {
            LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.jc_layout_clarity, (ViewGroup) null);
            s sVar = new View.OnClickListener() { // from class: ja.s

                /* renamed from: c */
                public final /* synthetic */ LinearLayout f27301c;

                public /* synthetic */ s(LinearLayout linearLayout2) {
                    linearLayout = linearLayout2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    JCVideoPlayerStandard.this.w0(linearLayout, view2);
                }
            };
            for (int i11 = 0; i11 < this.F.size(); i11++) {
                String e10 = l.e(this.F, i11);
                TextView textView = (TextView) View.inflate(getContext(), R.layout.jc_layout_clarity_item, null);
                textView.setText(e10);
                textView.setTag(Integer.valueOf(i11));
                linearLayout2.addView(textView, i11);
                textView.setOnClickListener(sVar);
                if (i11 == this.G) {
                    textView.setTextColor(Color.parseColor("#fff85959"));
                }
            }
            PopupWindow popupWindow = new PopupWindow((View) linearLayout2, -2, -2, true);
            this.I0 = popupWindow;
            popupWindow.setContentView(linearLayout2);
            this.I0.showAsDropDown(this.H0);
            linearLayout2.measure(0, 0);
            this.I0.update(this.H0, -40, 46, Math.round(linearLayout2.getMeasuredWidth() * 2), linearLayout2.getMeasuredHeight());
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        h0();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        E0();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id2 = view.getId();
        if (id2 == R.id.surface_container) {
            if (motionEvent.getAction() == 1) {
                E0();
                if (this.f13056y) {
                    int duration = getDuration();
                    this.f13060r0.setProgress((this.D * 100) / (duration != 0 ? duration : 1));
                }
                if (!this.f13056y && !this.f13055x) {
                    u(102);
                    B0();
                }
            }
        } else if (id2 == R.id.bottom_seek_progress) {
            int action = motionEvent.getAction();
            if (action == 0) {
                h0();
            } else if (action == 1) {
                E0();
            }
        }
        return super.onTouch(view, motionEvent);
    }

    public void p0() {
        int i10 = this.f13034c;
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            C0(4, 4, 4, 0, 4, 4, 0);
            F0();
        }
    }

    public void q0() {
        int i10 = this.f13034c;
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            C0(0, 0, 4, 0, 4, 4, 4);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void r() {
        super.r();
        h0();
    }

    public void r0() {
        int i10 = this.f13034c;
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            C0(4, 4, 4, 4, 4, 4, 0);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void s() {
        super.s();
        h0();
        PopupWindow popupWindow = this.I0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public void s0() {
        int i10 = this.f13034c;
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            C0(0, 0, 0, 4, 4, 4, 4);
            F0();
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void setBufferProgress(int i10) {
        super.setBufferProgress(i10);
        if (i10 != 0) {
            this.f13060r0.setSecondaryProgress(i10);
        }
    }

    public void setOnVideoStateListener(c cVar) {
        this.J0 = cVar;
    }

    public void setThumbImage(String str) {
        if (this.f13063u0 == null || ba.l.q(str)) {
            return;
        }
        m0.k(getContext(), str, this.f13063u0);
    }

    public void t0() {
        int i10 = this.f13034c;
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            C0(0, 4, 4, 0, 0, 0, 4);
        }
    }

    public void u0() {
        int i10 = this.f13034c;
        if (i10 == 0 || i10 == 1 || i10 == 2) {
            C0(0, 4, 4, 0, 0, 0, 4);
        }
    }

    public Dialog v0(View view) {
        Dialog dialog = new Dialog(getContext(), R.style.jc_style_dialog_progress);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.addFlags(8);
        window.addFlags(32);
        window.addFlags(16);
        window.setLayout(-2, -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        return dialog;
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void w() {
        super.w();
        C0(0, 4, 4, 4, 4, 4, 0);
        E0();
    }

    public final /* synthetic */ void w0(LinearLayout linearLayout, View view) {
        F(((Integer) view.getTag()).intValue(), getCurrentPositionWhenPlaying());
        this.H0.setText(l.e(this.F, this.G));
        for (int i10 = 0; i10 < linearLayout.getChildCount(); i10++) {
            if (i10 == this.G) {
                ((TextView) linearLayout.getChildAt(i10)).setTextColor(Color.parseColor("#fff85959"));
            } else {
                ((TextView) linearLayout.getChildAt(i10)).setTextColor(Color.parseColor("#ffffff"));
            }
        }
        PopupWindow popupWindow = this.I0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final /* synthetic */ void x0(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        u(101);
        Y();
        JCVideoPlayer.P = true;
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void y() {
        super.y();
        j0();
        h0();
        this.f13060r0.setProgress(100);
        c cVar = this.J0;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final /* synthetic */ void y0(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        if (this.f13034c == 2) {
            dialogInterface.dismiss();
            h();
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void z() {
        super.z();
        l0();
    }

    public final /* synthetic */ void z0(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        if (this.f13034c == 2) {
            dialogInterface.dismiss();
            h();
        }
    }

    public JCVideoPlayerStandard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L0 = false;
        this.M0 = new a();
    }
}
