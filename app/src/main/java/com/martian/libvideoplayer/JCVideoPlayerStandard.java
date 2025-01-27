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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.martian.libmars.utils.n0;
import com.martian.libvideoplayer.JCVideoPlayerStandard;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public class JCVideoPlayerStandard extends JCVideoPlayer {
    protected static Timer p0;
    public TextView A0;
    public PopupWindow B0;
    private c C0;
    protected b D0;
    private boolean F0;
    private final BroadcastReceiver G0;
    protected Dialog H0;
    protected ProgressBar I0;
    protected TextView J0;
    protected TextView K0;
    protected ImageView L0;
    protected Dialog M0;
    protected ProgressBar N0;
    protected TextView O0;
    protected ImageView P0;
    protected Dialog Q0;
    protected ProgressBar R0;
    protected TextView S0;
    public ImageView q0;
    public ProgressBar r0;
    public ProgressBar s0;
    public TextView t0;
    public ImageView u0;
    public ImageView v0;
    public LinearLayout w0;
    public ImageView x0;
    public TextView y0;
    public TextView z0;

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
                if (intExtra < 15) {
                    JCVideoPlayerStandard.this.x0.setBackgroundResource(R.drawable.jc_battery_level_10);
                } else if (intExtra < 40) {
                    JCVideoPlayerStandard.this.x0.setBackgroundResource(R.drawable.jc_battery_level_30);
                } else if (intExtra < 60) {
                    JCVideoPlayerStandard.this.x0.setBackgroundResource(R.drawable.jc_battery_level_50);
                } else if (intExtra < 80) {
                    JCVideoPlayerStandard.this.x0.setBackgroundResource(R.drawable.jc_battery_level_70);
                } else if (intExtra < 95) {
                    JCVideoPlayerStandard.this.x0.setBackgroundResource(R.drawable.jc_battery_level_90);
                } else if (intExtra <= 100) {
                    JCVideoPlayerStandard.this.x0.setBackgroundResource(R.drawable.jc_battery_level_100);
                }
                JCVideoPlayerStandard.this.getContext().unregisterReceiver(JCVideoPlayerStandard.this.G0);
                JCVideoPlayerStandard.this.F0 = false;
            }
        }
    }

    public class b extends TimerTask {
        public b() {
        }

        /* renamed from: c */
        public /* synthetic */ void d() {
            JCVideoPlayerStandard.this.R.setVisibility(4);
            JCVideoPlayerStandard.this.Q.setVisibility(4);
            JCVideoPlayerStandard.this.K.setVisibility(4);
            PopupWindow popupWindow = JCVideoPlayerStandard.this.B0;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
            JCVideoPlayerStandard jCVideoPlayerStandard = JCVideoPlayerStandard.this;
            if (jCVideoPlayerStandard.F != 3) {
                jCVideoPlayerStandard.r0.setVisibility(0);
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            JCVideoPlayerStandard jCVideoPlayerStandard = JCVideoPlayerStandard.this;
            int i2 = jCVideoPlayerStandard.E;
            if (i2 == 0 || i2 == 7 || i2 == 6 || jCVideoPlayerStandard.getContext() == null || !(JCVideoPlayerStandard.this.getContext() instanceof Activity)) {
                return;
            }
            ((Activity) JCVideoPlayerStandard.this.getContext()).runOnUiThread(new Runnable() { // from class: com.martian.libvideoplayer.k
                @Override // java.lang.Runnable
                public final void run() {
                    JCVideoPlayerStandard.b.this.d();
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
        this.F0 = false;
        this.G0 = new a();
    }

    /* renamed from: r0 */
    public /* synthetic */ void s0(final LinearLayout layout, View v1) {
        E(((Integer) v1.getTag()).intValue(), getCurrentPositionWhenPlaying());
        this.A0.setText(t.e(this.l0, this.m0));
        for (int i2 = 0; i2 < layout.getChildCount(); i2++) {
            if (i2 == this.m0) {
                ((TextView) layout.getChildAt(i2)).setTextColor(Color.parseColor("#fff85959"));
            } else {
                ((TextView) layout.getChildAt(i2)).setTextColor(Color.parseColor("#ffffff"));
            }
        }
        PopupWindow popupWindow = this.B0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* renamed from: t0 */
    public /* synthetic */ void u0(DialogInterface dialog, int which) {
        dialog.dismiss();
        t(101);
        X();
        JCVideoPlayer.f10685g = true;
    }

    /* renamed from: v0 */
    public /* synthetic */ void w0(DialogInterface dialog, int which) {
        dialog.dismiss();
        if (this.F == 2) {
            dialog.dismiss();
            g();
        }
    }

    /* renamed from: x0 */
    public /* synthetic */ void y0(DialogInterface dialog) {
        dialog.dismiss();
        if (this.F == 2) {
            dialog.dismiss();
            g();
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void A() {
        super.A();
        j0();
        c0();
    }

    public void A0() {
        if (this.R.getVisibility() != 0) {
            C0();
            this.A0.setText(t.e(this.l0, this.m0));
        }
        int i2 = this.E;
        if (i2 == 1) {
            if (this.R.getVisibility() == 0) {
                o0();
                return;
            } else {
                p0();
                C0();
                return;
            }
        }
        if (i2 == 3) {
            if (this.R.getVisibility() == 0) {
                m0();
                return;
            } else {
                n0();
                return;
            }
        }
        if (i2 == 5) {
            if (this.R.getVisibility() == 0) {
                i0();
                return;
            } else {
                j0();
                return;
            }
        }
        if (i2 == 4) {
            if (this.R.getVisibility() == 0) {
                k0();
            } else {
                l0();
            }
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void B() {
        super.B();
        l0();
    }

    public void B0(int topCon, int bottomCon, int startBtn, int loadingPro, int thumbImg, int coverImg, int bottomPro) {
        this.Q.setVisibility(topCon);
        this.R.setVisibility(bottomCon);
        this.K.setVisibility(startBtn);
        this.s0.setVisibility(loadingPro);
        this.u0.setVisibility(thumbImg);
        this.r0.setVisibility(bottomPro);
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void C() {
        super.C();
        n0();
        D0();
        c cVar = this.C0;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void C0() {
        this.y0.setText(new SimpleDateFormat("HH:mm").format(new Date()));
        if (this.F0) {
            return;
        }
        getContext().registerReceiver(this.G0, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void D() {
        super.D();
        p0();
        D0();
    }

    public void D0() {
        c0();
        p0 = new Timer();
        b bVar = new b();
        this.D0 = bVar;
        p0.schedule(bVar, 2500L);
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void E(int urlMapIndex, int seekToInAdvance) {
        super.E(urlMapIndex, seekToInAdvance);
        this.s0.setVisibility(0);
        this.K.setVisibility(4);
    }

    public void E0() {
        int i2 = this.E;
        if (i2 == 3) {
            this.K.setImageResource(R.drawable.jc_click_pause_selector);
            this.z0.setVisibility(4);
        } else if (i2 == 7) {
            this.K.setImageResource(R.drawable.jc_click_error_selector);
            this.z0.setVisibility(4);
        } else if (i2 == 6) {
            this.K.setImageResource(R.drawable.jc_click_replay_selector);
            this.z0.setVisibility(0);
        } else {
            this.K.setImageResource(R.drawable.jc_click_play_selector);
            this.z0.setVisibility(4);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void K() {
        super.K();
        this.r0.setProgress(0);
        this.r0.setSecondaryProgress(0);
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void L(int progress, int position, int duration) {
        super.L(progress, position, duration);
        if (progress != 0) {
            this.r0.setProgress(progress);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void O(LinkedHashMap urlMap, int defaultUrlMapIndex, int screen, Object... objects) {
        super.O(urlMap, defaultUrlMapIndex, screen, objects);
        if (objects.length == 0) {
            return;
        }
        this.t0.setText(objects[0].toString());
        int i2 = this.F;
        if (i2 == 2) {
            this.M.setImageResource(R.drawable.jc_shrink);
            this.q0.setVisibility(0);
            this.v0.setVisibility(4);
            this.w0.setVisibility(0);
            if (urlMap.size() == 1) {
                this.A0.setVisibility(8);
            } else {
                this.A0.setText(t.e(urlMap, this.m0));
                this.A0.setVisibility(0);
            }
            d0((int) getResources().getDimension(R.dimen.jc_start_button_w_h_fullscreen));
        } else if (i2 == 0 || i2 == 1) {
            this.M.setImageResource(R.drawable.jc_enlarge);
            this.q0.setVisibility(8);
            this.v0.setVisibility(4);
            d0((int) getResources().getDimension(R.dimen.jc_start_button_w_h_normal));
            this.w0.setVisibility(8);
            this.A0.setVisibility(8);
        } else if (i2 == 3) {
            this.v0.setVisibility(0);
            B0(4, 4, 4, 4, 4, 4, 4);
            this.w0.setVisibility(8);
            this.A0.setVisibility(8);
        }
        C0();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void P(int brightnessPercent) {
        super.P(brightnessPercent);
        if (this.Q0 == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.jc_dialog_brightness, (ViewGroup) null);
            this.S0 = (TextView) inflate.findViewById(R.id.tv_brightness);
            this.R0 = (ProgressBar) inflate.findViewById(R.id.brightness_progressbar);
            this.Q0 = q0(inflate);
        }
        if (!this.Q0.isShowing()) {
            this.Q0.show();
        }
        if (brightnessPercent > 100) {
            brightnessPercent = 100;
        } else if (brightnessPercent < 0) {
            brightnessPercent = 0;
        }
        this.S0.setText(brightnessPercent + "%");
        this.R0.setProgress(brightnessPercent);
        z0();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void Q(float deltaX, String seekTime, int seekTimePosition, String totalTime, int totalTimeDuration) {
        super.Q(deltaX, seekTime, seekTimePosition, totalTime, totalTimeDuration);
        if (this.H0 == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.jc_dialog_progress, (ViewGroup) null);
            this.I0 = (ProgressBar) inflate.findViewById(R.id.duration_progressbar);
            this.J0 = (TextView) inflate.findViewById(R.id.tv_current);
            this.K0 = (TextView) inflate.findViewById(R.id.tv_duration);
            this.L0 = (ImageView) inflate.findViewById(R.id.duration_image_tip);
            this.H0 = q0(inflate);
        }
        if (!this.H0.isShowing()) {
            this.H0.show();
        }
        this.J0.setText(seekTime);
        this.K0.setText(" / " + totalTime);
        this.I0.setProgress(totalTimeDuration <= 0 ? 0 : (seekTimePosition * 100) / totalTimeDuration);
        if (deltaX > 0.0f) {
            this.L0.setBackgroundResource(R.drawable.jc_forward_icon);
        } else {
            this.L0.setBackgroundResource(R.drawable.jc_backward_icon);
        }
        z0();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void S(float deltaY, int volumePercent) {
        super.S(deltaY, volumePercent);
        if (this.M0 == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.jc_dialog_volume, (ViewGroup) null);
            this.P0 = (ImageView) inflate.findViewById(R.id.volume_image_tip);
            this.O0 = (TextView) inflate.findViewById(R.id.tv_volume);
            this.N0 = (ProgressBar) inflate.findViewById(R.id.volume_progressbar);
            this.M0 = q0(inflate);
        }
        if (!this.M0.isShowing()) {
            this.M0.show();
        }
        if (volumePercent <= 0) {
            this.P0.setBackgroundResource(R.drawable.jc_close_volume);
        } else {
            this.P0.setBackgroundResource(R.drawable.jc_add_volume);
        }
        if (volumePercent > 100) {
            volumePercent = 100;
        } else if (volumePercent < 0) {
            volumePercent = 0;
        }
        this.O0.setText(volumePercent + "%");
        this.N0.setProgress(volumePercent);
        z0();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void T(int action) {
        super.T(action);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(getResources().getString(R.string.tips_not_wifi));
        builder.setPositiveButton(getResources().getString(R.string.tips_not_wifi_confirm), new DialogInterface.OnClickListener() { // from class: com.martian.libvideoplayer.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                JCVideoPlayerStandard.this.u0(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.tips_not_wifi_cancel), new DialogInterface.OnClickListener() { // from class: com.martian.libvideoplayer.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                JCVideoPlayerStandard.this.w0(dialogInterface, i2);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.martian.libvideoplayer.l
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                JCVideoPlayerStandard.this.y0(dialogInterface);
            }
        });
        builder.create().show();
    }

    public void c0() {
        Timer timer = p0;
        if (timer != null) {
            timer.cancel();
        }
        b bVar = this.D0;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public void d0(int size) {
        ViewGroup.LayoutParams layoutParams = this.K.getLayoutParams();
        layoutParams.height = size;
        layoutParams.width = size;
        ViewGroup.LayoutParams layoutParams2 = this.s0.getLayoutParams();
        layoutParams2.height = size;
        layoutParams2.width = size;
    }

    public void e0() {
        int i2 = this.F;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            B0(0, 4, 0, 4, 0, 4, 4);
            E0();
        }
    }

    public void f0() {
        int i2 = this.F;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            B0(0, 0, 0, 4, 0, 4, 4);
            E0();
        }
    }

    public void g0() {
        int i2 = this.F;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            B0(4, 4, 0, 4, 4, 0, 4);
            E0();
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public int getLayoutId() {
        return R.layout.jc_layout_standard;
    }

    public void h0() {
        int i2 = this.F;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            B0(0, 4, 0, 4, 0, 0, 4);
            E0();
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void i() {
        super.i();
        Dialog dialog = this.Q0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void i0() {
        int i2 = this.F;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            B0(4, 4, 4, 4, 4, 4, 4);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void j() {
        super.j();
        Dialog dialog = this.H0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void j0() {
        int i2 = this.F;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            B0(0, 0, 0, 4, 4, 4, 4);
            E0();
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void k() {
        super.k();
        Dialog dialog = this.M0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void k0() {
        int i2 = this.F;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            B0(4, 4, 4, 0, 4, 4, 0);
            E0();
        }
    }

    public void l0() {
        int i2 = this.F;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            B0(0, 0, 4, 0, 4, 4, 4);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void m(Context context) {
        super.m(context);
        this.w0 = (LinearLayout) findViewById(R.id.battery_time_layout);
        this.r0 = (ProgressBar) findViewById(R.id.bottom_progress);
        this.t0 = (TextView) findViewById(R.id.title);
        this.q0 = (ImageView) findViewById(R.id.back);
        this.u0 = (ImageView) findViewById(R.id.thumb);
        this.s0 = (ProgressBar) findViewById(R.id.loading);
        this.v0 = (ImageView) findViewById(R.id.back_tiny);
        this.x0 = (ImageView) findViewById(R.id.battery_level);
        this.y0 = (TextView) findViewById(R.id.video_current_time);
        this.z0 = (TextView) findViewById(R.id.retry_text);
        this.A0 = (TextView) findViewById(R.id.clarity);
        this.u0.setOnClickListener(this);
        this.q0.setOnClickListener(this);
        this.v0.setOnClickListener(this);
        this.A0.setOnClickListener(this);
    }

    public void m0() {
        int i2 = this.F;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            B0(4, 4, 4, 4, 4, 4, 0);
        }
    }

    public void n0() {
        int i2 = this.F;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            B0(0, 0, 0, 4, 4, 4, 4);
            E0();
        }
    }

    public void o0() {
        int i2 = this.F;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            B0(0, 4, 4, 0, 0, 0, 4);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer, android.view.View.OnClickListener
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        if (id == R.id.thumb) {
            if (TextUtils.isEmpty(t.d(this.l0, this.m0))) {
                Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
                return;
            }
            int i2 = this.E;
            if (i2 != 0) {
                if (i2 == 6) {
                    A0();
                    return;
                }
                return;
            } else if (!t.d(this.l0, this.m0).startsWith("file") && !t.d(this.l0, this.m0).startsWith("/") && !t.h(getContext()) && !JCVideoPlayer.f10685g) {
                T(101);
                return;
            } else {
                t(101);
                X();
                return;
            }
        }
        if (id == R.id.surface_container) {
            D0();
            return;
        }
        if (id == R.id.back) {
            JCVideoPlayer.d();
            return;
        }
        if (id == R.id.back_tiny) {
            JCVideoPlayer.d();
            return;
        }
        if (id == R.id.clarity) {
            final LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.jc_layout_clarity, (ViewGroup) null);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.martian.libvideoplayer.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    JCVideoPlayerStandard.this.s0(linearLayout, view);
                }
            };
            for (int i3 = 0; i3 < this.l0.size(); i3++) {
                String e2 = t.e(this.l0, i3);
                TextView textView = (TextView) FrameLayout.inflate(getContext(), R.layout.jc_layout_clarity_item, null);
                textView.setText(e2);
                textView.setTag(Integer.valueOf(i3));
                linearLayout.addView(textView, i3);
                textView.setOnClickListener(onClickListener);
                if (i3 == this.m0) {
                    textView.setTextColor(Color.parseColor("#fff85959"));
                }
            }
            PopupWindow popupWindow = new PopupWindow((View) linearLayout, -2, -2, true);
            this.B0 = popupWindow;
            popupWindow.setContentView(linearLayout);
            this.B0.showAsDropDown(this.A0);
            linearLayout.measure(0, 0);
            this.B0.update(this.A0, -40, 46, Math.round(linearLayout.getMeasuredWidth() * 2), linearLayout.getMeasuredHeight());
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        c0();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        D0();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer, android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        if (id == R.id.surface_container) {
            if (event.getAction() == 1) {
                D0();
                if (this.e0) {
                    int duration = getDuration();
                    this.r0.setProgress((this.j0 * 100) / (duration != 0 ? duration : 1));
                }
                if (!this.e0 && !this.d0) {
                    t(102);
                    A0();
                }
            }
        } else if (id == R.id.bottom_seek_progress) {
            int action = event.getAction();
            if (action == 0) {
                c0();
            } else if (action == 1) {
                D0();
            }
        }
        return super.onTouch(v, event);
    }

    public void p0() {
        int i2 = this.F;
        if (i2 == 0 || i2 == 1 || i2 == 2) {
            B0(0, 4, 4, 0, 0, 0, 4);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void q() {
        super.q();
        c0();
    }

    public Dialog q0(View localView) {
        Dialog dialog = new Dialog(getContext(), R.style.jc_style_dialog_progress);
        dialog.setContentView(localView);
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
    public void r() {
        super.r();
        c0();
        PopupWindow popupWindow = this.B0;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void setBufferProgress(int bufferProgress) {
        super.setBufferProgress(bufferProgress);
        if (bufferProgress != 0) {
            this.r0.setSecondaryProgress(bufferProgress);
        }
    }

    public void setOnVideoStateListener(c onVideoStateListener) {
        this.C0 = onVideoStateListener;
    }

    public void setThumbImage(String url) {
        if (this.u0 == null || com.martian.libsupport.k.p(url)) {
            return;
        }
        n0.l(getContext(), url, this.u0, R.drawable.image_loading_default_horizontal);
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void v() {
        super.v();
        B0(0, 4, 4, 4, 4, 4, 0);
        D0();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void x() {
        super.x();
        e0();
        c0();
        this.r0.setProgress(100);
        c cVar = this.C0;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void y() {
        super.y();
        g0();
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void z() {
        super.z();
        h0();
    }

    public void z0() {
        int i2 = this.E;
        if (i2 == 1) {
            if (this.R.getVisibility() == 0) {
                o0();
                return;
            }
            return;
        }
        if (i2 == 3) {
            if (this.R.getVisibility() == 0) {
                m0();
            }
        } else if (i2 == 5) {
            if (this.R.getVisibility() == 0) {
                i0();
            }
        } else if (i2 == 6) {
            if (this.R.getVisibility() == 0) {
                e0();
            }
        } else if (i2 == 4 && this.R.getVisibility() == 0) {
            k0();
        }
    }

    public JCVideoPlayerStandard(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.F0 = false;
        this.G0 = new a();
    }
}
