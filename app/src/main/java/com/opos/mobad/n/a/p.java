package com.opos.mobad.n.a;

import android.animation.Animator;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.umeng.analytics.pro.am;

/* loaded from: classes4.dex */
public class p implements SensorEventListener, f {

    /* renamed from: a */
    private Context f21866a;

    /* renamed from: b */
    private RelativeLayout f21867b;

    /* renamed from: c */
    private ImageView f21868c;

    /* renamed from: d */
    private TextView f21869d;

    /* renamed from: e */
    private com.opos.mobad.n.c.g f21870e;

    /* renamed from: f */
    private Animator f21871f;

    /* renamed from: g */
    private Animator f21872g;

    /* renamed from: h */
    private Animator f21873h;

    /* renamed from: i */
    private com.opos.mobad.n.c.e f21874i;

    /* renamed from: j */
    private SensorManager f21875j;
    private float n;
    private float o;
    private float p;
    private boolean k = false;
    private int l = 1000;
    private int m = 13000;
    private long q = 0;
    private boolean r = false;

    /* renamed from: com.opos.mobad.n.a.p$1 */
    class AnonymousClass1 implements Animator.AnimatorListener {
        AnonymousClass1() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            p.this.f21872g.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public p(Context context) {
        this.f21866a = context;
        g();
        this.f21872g = n.d(this.f21868c);
    }

    private void a(SensorEvent sensorEvent) {
        float[] fArr;
        if (this.r || sensorEvent == null || (fArr = sensorEvent.values) == null || fArr.length < 3) {
            return;
        }
        if (this.q > 0) {
            if (Math.sqrt(Math.pow(fArr[0] - this.n, 2.0d) + Math.pow(sensorEvent.values[1] - this.o, 2.0d) + Math.pow(sensorEvent.values[2] - this.p, 2.0d)) * 1000.0d >= this.m) {
                this.r = true;
                h();
                com.opos.mobad.n.c.g gVar = this.f21870e;
                if (gVar != null) {
                    gVar.a(this.f21867b, null);
                    return;
                }
                return;
            }
            if (SystemClock.elapsedRealtime() - this.q < this.l) {
                return;
            }
        }
        b(sensorEvent);
    }

    private void b(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        this.n = fArr[0];
        this.o = fArr[1];
        this.p = fArr[2];
        this.q = SystemClock.elapsedRealtime();
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f21866a);
        this.f21867b = relativeLayout;
        relativeLayout.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.f21866a, 18.0f));
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f21866a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21866a, 110.0f), com.opos.cmn.an.h.f.a.a(this.f21866a, 110.0f));
        layoutParams.addRule(14);
        this.f21867b.addView(relativeLayout2, layoutParams);
        relativeLayout2.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.f21866a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21866a, 84.0f), com.opos.cmn.an.h.f.a.a(this.f21866a, 84.0f));
        layoutParams2.addRule(13);
        imageView.setBackgroundResource(R.drawable.opos_mobad_bg_cricle_black);
        relativeLayout2.addView(imageView, layoutParams2);
        this.f21874i = new com.opos.mobad.n.c.e(this.f21866a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21866a, 110.0f), com.opos.cmn.an.h.f.a.a(this.f21866a, 110.0f));
        layoutParams3.addRule(13);
        this.f21874i.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f21874i.setImageResource(R.drawable.opos_mobad_bg_circle_light);
        this.f21874i.a(com.opos.cmn.an.h.f.a.a(this.f21866a, 28.0f));
        this.f21874i.b(com.opos.cmn.an.h.f.a.a(this.f21866a, 110.0f));
        relativeLayout2.addView(this.f21874i, layoutParams3);
        ImageView imageView2 = new ImageView(this.f21866a);
        this.f21868c = imageView2;
        imageView2.setImageResource(R.drawable.opos_mobad_icon_hand);
        this.f21868c.setScaleType(ImageView.ScaleType.CENTER);
        relativeLayout2.addView(this.f21868c, layoutParams2);
        TextView textView = new TextView(this.f21866a);
        textView.setTextSize(1, 18.0f);
        textView.setText("摇动手机");
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(this.f21866a, 12.0f);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, relativeLayout2.getId());
        textView.setId(View.generateViewId());
        textView.setTextColor(-1);
        this.f21867b.addView(textView, layoutParams4);
        TextView textView2 = new TextView(this.f21866a);
        this.f21869d = textView2;
        textView2.setTextSize(1, 14.0f);
        this.f21869d.setTextColor(-1);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, textView.getId());
        this.f21867b.addView(this.f21869d, layoutParams5);
    }

    private void h() {
        SensorManager sensorManager = this.f21875j;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.f21875j = null;
        }
        this.p = 0.0f;
        this.o = 0.0f;
        this.n = 0.0f;
        this.q = 0L;
    }

    private void i() {
        if (this.f21875j != null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) this.f21866a.getSystemService(am.ac);
        this.f21875j = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        if (defaultSensor != null) {
            this.f21875j.registerListener(this, defaultSensor, 1);
        }
    }

    @Override // com.opos.mobad.n.a.f
    public View a() {
        return this.f21867b;
    }

    @Override // com.opos.mobad.n.a.f
    public void a(com.opos.mobad.n.c.g gVar) {
        this.f21870e = gVar;
    }

    @Override // com.opos.mobad.n.a.f
    public void a(String str, int i2, int i3) {
        this.f21869d.setText(str);
        if (i2 > 0) {
            this.l = i2;
        }
        if (i3 > 0) {
            this.m = i3;
        }
    }

    @Override // com.opos.mobad.n.a.f
    public void b() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (this.f21873h == null) {
            this.f21873h = n.b(this.f21874i);
        }
        this.f21873h.start();
    }

    @Override // com.opos.mobad.n.a.f
    public void c() {
        if (Build.VERSION.SDK_INT >= 21 && !this.k) {
            this.k = true;
            Animator b2 = n.b(this.f21867b);
            this.f21871f = b2;
            b2.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.n.a.p.1
                AnonymousClass1() {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    p.this.f21872g.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            this.f21871f.start();
            i();
        }
    }

    @Override // com.opos.mobad.n.a.f
    public void d() {
        h();
    }

    @Override // com.opos.mobad.n.a.f
    public void e() {
        i();
    }

    @Override // com.opos.mobad.n.a.f
    public void f() {
        Animator animator = this.f21873h;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.f21871f;
        if (animator2 != null) {
            animator2.end();
        }
        Animator animator3 = this.f21872g;
        if (animator3 != null) {
            animator3.end();
        }
        h();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }
}
