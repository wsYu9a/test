package cn.vlion.ad.inland.ad.view.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.h1;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public class VlionButtonSolidBgView extends FrameLayout {

    /* renamed from: a */
    public int f2425a;

    /* renamed from: b */
    public View f2426b;

    /* renamed from: c */
    public View f2427c;

    /* renamed from: d */
    public View f2428d;

    /* renamed from: e */
    public VlionDownloadProgressBar f2429e;

    /* renamed from: f */
    public RotateAnimation f2430f;

    /* renamed from: g */
    public ImageView f2431g;

    /* renamed from: h */
    public ImageView f2432h;

    /* renamed from: i */
    public ImageView f2433i;

    /* renamed from: j */
    public e f2434j;

    /* renamed from: k */
    public TextView f2435k;

    /* renamed from: l */
    public TextView f2436l;

    /* renamed from: m */
    public TextView f2437m;

    /* renamed from: n */
    public h1 f2438n;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                e eVar = VlionButtonSolidBgView.this.f2434j;
                if (eVar != null) {
                    eVar.onClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                e eVar = VlionButtonSolidBgView.this.f2434j;
                if (eVar != null) {
                    eVar.onClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                e eVar = VlionButtonSolidBgView.this.f2434j;
                if (eVar != null) {
                    eVar.onClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                e eVar = VlionButtonSolidBgView.this.f2434j;
                if (eVar != null) {
                    eVar.onClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public interface e {
        void onClick();
    }

    public VlionButtonSolidBgView(Context context) {
        this(context, null);
    }

    public final void a(int i10) {
        try {
            if (this.f2429e != null && this.f2438n != null) {
                LogVlion.e("VlionButtonSolidBgView: showProgress=" + i10);
                this.f2429e.setVisibility(0);
                int i11 = this.f2425a;
                if (i11 == 0) {
                    this.f2429e.setTextSize(17.0f);
                } else if (i11 == 1) {
                    this.f2429e.setTextSize(11.0f);
                } else if (i11 == 2) {
                    this.f2429e.setTextSize(21.0f);
                }
                this.f2429e.setProgress(i10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void hideAnimation() {
        try {
            VlionDownloadProgressBar vlionDownloadProgressBar = this.f2429e;
            if (vlionDownloadProgressBar == null) {
                return;
            }
            int i10 = this.f2425a;
            if (i10 == 0) {
                vlionDownloadProgressBar.setTextSize(17.0f);
                this.f2426b.setVisibility(8);
                this.f2427c.setVisibility(8);
            } else if (i10 == 1) {
                vlionDownloadProgressBar.setTextSize(11.0f);
                this.f2426b.setVisibility(8);
                this.f2427c.setVisibility(8);
            } else {
                if (i10 != 2) {
                    return;
                }
                vlionDownloadProgressBar.setTextSize(21.0f);
                this.f2426b.setVisibility(8);
                this.f2427c.setVisibility(8);
            }
            this.f2428d.setVisibility(8);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void onDestroy() {
        try {
            RotateAnimation rotateAnimation = this.f2430f;
            if (rotateAnimation != null) {
                rotateAnimation.cancel();
                this.f2430f = null;
            }
            if (this.f2431g != null) {
                this.f2433i.clearAnimation();
            }
            if (this.f2432h != null) {
                this.f2433i.clearAnimation();
            }
            ImageView imageView = this.f2433i;
            if (imageView != null) {
                imageView.clearAnimation();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            RotateAnimation rotateAnimation = this.f2430f;
            if (rotateAnimation != null) {
                rotateAnimation.cancel();
                this.f2430f = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        try {
            LogVlion.e("VlionButtonSolidBgView: visibility=" + i10 + " vlionButtonStatue.getProgress()=" + this.f2438n.f2846b);
            if (i10 != 0) {
                try {
                    VlionDownloadProgressBar vlionDownloadProgressBar = this.f2429e;
                    if (vlionDownloadProgressBar != null && vlionDownloadProgressBar.getVisibility() == 0) {
                        this.f2429e.setProgress(1);
                        this.f2429e.setVisibility(8);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                hideAnimation();
                return;
            }
            h1 h1Var = this.f2438n;
            if (h1Var.f2845a) {
                a(h1Var.f2846b);
                hideAnimation();
                return;
            }
            try {
                VlionDownloadProgressBar vlionDownloadProgressBar2 = this.f2429e;
                if (vlionDownloadProgressBar2 != null && vlionDownloadProgressBar2.getVisibility() == 0) {
                    this.f2429e.setProgress(1);
                    this.f2429e.setVisibility(8);
                }
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
            a(this.f2438n.f2847c);
            return;
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
        VlionSDkManager.getInstance().upLoadCatchException(th4);
    }

    public void setButtonClickListener(e eVar) {
        this.f2434j = eVar;
    }

    public void setProgress(int i10) {
        h1 h1Var;
        try {
            if (this.f2429e != null && (h1Var = this.f2438n) != null) {
                h1Var.f2845a = true;
                h1Var.f2846b = i10;
                a(i10);
                hideAnimation();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setShakeStyle(String str, boolean z10) {
        try {
            if (this.f2429e != null && this.f2438n != null) {
                LogVlion.e("VlionButtonSolidBgView: styleType==" + this.f2425a + "tips=" + str + " isShake=" + z10);
                h1 h1Var = this.f2438n;
                h1Var.f2845a = false;
                h1Var.f2847c = z10;
                a(z10);
                try {
                    VlionDownloadProgressBar vlionDownloadProgressBar = this.f2429e;
                    if (vlionDownloadProgressBar != null && vlionDownloadProgressBar.getVisibility() == 0) {
                        this.f2429e.setProgress(1);
                        this.f2429e.setVisibility(8);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                this.f2435k.setText(str);
                this.f2436l.setText(str);
                this.f2437m.setText(str);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public VlionButtonSolidBgView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(boolean z10) {
        View view;
        View.OnClickListener cVar;
        try {
            if (this.f2429e == null) {
                return;
            }
            int i10 = this.f2425a;
            if (i10 == 0) {
                this.f2426b.setVisibility(0);
                this.f2427c.setVisibility(8);
                this.f2428d.setVisibility(8);
                if (z10) {
                    this.f2431g.setVisibility(0);
                    RotateAnimation rotateAnimation = new RotateAnimation(-5.0f, 5.0f, 1, 1.0f, 1, 1.0f);
                    this.f2430f = rotateAnimation;
                    rotateAnimation.setRepeatMode(2);
                    this.f2430f.setRepeatCount(-1);
                    this.f2430f.setDuration(400L);
                    this.f2431g.setAnimation(this.f2430f);
                } else {
                    this.f2431g.clearAnimation();
                    this.f2431g.setVisibility(8);
                }
                view = this.f2426b;
                cVar = new a();
            } else {
                if (i10 != 1) {
                    if (i10 == 2) {
                        this.f2426b.setVisibility(8);
                        this.f2427c.setVisibility(8);
                        this.f2428d.setVisibility(0);
                        if (z10) {
                            this.f2433i.setVisibility(0);
                            RotateAnimation rotateAnimation2 = new RotateAnimation(-5.0f, 5.0f, 1, 1.0f, 1, 1.0f);
                            this.f2430f = rotateAnimation2;
                            rotateAnimation2.setRepeatMode(2);
                            this.f2430f.setRepeatCount(-1);
                            this.f2430f.setDuration(400L);
                            this.f2433i.setAnimation(this.f2430f);
                        } else {
                            this.f2433i.clearAnimation();
                            this.f2433i.setVisibility(8);
                        }
                        view = this.f2428d;
                        cVar = new c();
                    }
                    this.f2429e.setOnClickListener(new d());
                }
                this.f2426b.setVisibility(8);
                this.f2427c.setVisibility(0);
                this.f2428d.setVisibility(8);
                if (z10) {
                    this.f2432h.setVisibility(0);
                    RotateAnimation rotateAnimation3 = new RotateAnimation(-5.0f, 5.0f, 1, 1.0f, 1, 1.0f);
                    this.f2430f = rotateAnimation3;
                    rotateAnimation3.setRepeatMode(2);
                    this.f2430f.setRepeatCount(-1);
                    this.f2430f.setDuration(400L);
                    this.f2432h.setAnimation(this.f2430f);
                } else {
                    this.f2432h.clearAnimation();
                    this.f2432h.setVisibility(8);
                }
                view = this.f2427c;
                cVar = new b();
            }
            view.setOnClickListener(cVar);
            this.f2429e.setOnClickListener(new d());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public VlionButtonSolidBgView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        View findViewById;
        try {
            LayoutInflater.from(context).inflate(R.layout.vlion_cn_ad_button_layout, (ViewGroup) this, true);
            this.f2425a = context.obtainStyledAttributes(attributeSet, R.styleable.VlionButtonSolidBgView).getInt(R.styleable.VlionButtonSolidBgView_vlion_style_type, 0);
            this.f2438n = new h1();
            this.f2426b = findViewById(R.id.vlion_layout_style1_41dp);
            this.f2427c = findViewById(R.id.vlion_layout_style2_32dp);
            this.f2428d = findViewById(R.id.vlion_layout_style2_50dp);
            int i11 = this.f2425a;
            if (i11 == 0) {
                this.f2429e = (VlionDownloadProgressBar) findViewById(R.id.vlion_ad_app_action1);
                this.f2427c.setVisibility(8);
                this.f2428d.setVisibility(8);
            } else {
                if (i11 == 1) {
                    this.f2426b.setVisibility(8);
                    this.f2428d.setVisibility(8);
                    findViewById = findViewById(R.id.vlion_ad_app_action2);
                } else if (i11 == 2) {
                    this.f2426b.setVisibility(8);
                    this.f2427c.setVisibility(8);
                    findViewById = findViewById(R.id.vlion_ad_app_action3);
                }
                this.f2429e = (VlionDownloadProgressBar) findViewById;
            }
            this.f2431g = (ImageView) findViewById(R.id.vlion_imgv_style1);
            this.f2432h = (ImageView) findViewById(R.id.vlion_imgv_style2);
            this.f2433i = (ImageView) findViewById(R.id.vlion_imgv_style3);
            this.f2435k = (TextView) findViewById(R.id.vlion_tv_style1);
            this.f2436l = (TextView) findViewById(R.id.vlion_tv_style2);
            this.f2437m = (TextView) findViewById(R.id.vlion_tv_style3);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
