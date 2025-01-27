package cn.vlion.ad.inland.ad.view.active;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.h1;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public class VlionDownloadProgressBar extends LinearLayout {

    /* renamed from: a */
    public ProgressBar f2405a;

    /* renamed from: b */
    public TextView f2406b;

    /* renamed from: c */
    public ImageView f2407c;

    /* renamed from: d */
    public int f2408d;

    /* renamed from: e */
    public h1 f2409e;

    /* renamed from: f */
    public RotateAnimation f2410f;

    public VlionDownloadProgressBar(Context context) {
        this(context, null);
    }

    public final void a(boolean z10) {
        try {
            if (z10) {
                this.f2407c.setVisibility(0);
                RotateAnimation rotateAnimation = new RotateAnimation(-5.0f, 5.0f, 1, 1.0f, 1, 1.0f);
                this.f2410f = rotateAnimation;
                rotateAnimation.setRepeatMode(2);
                this.f2410f.setRepeatCount(-1);
                this.f2410f.setDuration(400L);
                this.f2407c.setAnimation(this.f2410f);
            } else {
                hideAnimation();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public String getTextDetail() {
        try {
            TextView textView = this.f2406b;
            return textView != null ? textView.getText().toString() : "";
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public void hideAnimation() {
        try {
            ImageView imageView = this.f2407c;
            if (imageView != null) {
                imageView.clearAnimation();
                this.f2407c.setVisibility(8);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            RotateAnimation rotateAnimation = this.f2410f;
            if (rotateAnimation != null) {
                rotateAnimation.cancel();
                this.f2410f = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        try {
            LogVlion.e("VlionButtonSolidBgView: visibility=" + i10);
            if (i10 != 0) {
                try {
                    ProgressBar progressBar = this.f2405a;
                    if (progressBar != null) {
                        progressBar.setProgress(100);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                hideAnimation();
                return;
            }
            h1 h1Var = this.f2409e;
            if (h1Var != null) {
                if (!h1Var.f2845a) {
                    try {
                        ProgressBar progressBar2 = this.f2405a;
                        if (progressBar2 != null) {
                            progressBar2.setProgress(100);
                        }
                    } catch (Throwable th3) {
                        VlionSDkManager.getInstance().upLoadCatchException(th3);
                    }
                    a(this.f2409e.f2847c);
                    return;
                }
                int i11 = h1Var.f2846b;
                try {
                    ProgressBar progressBar3 = this.f2405a;
                    if (progressBar3 != null) {
                        progressBar3.setVisibility(0);
                        if (i11 <= 0) {
                            i11 = 1;
                        }
                        this.f2405a.setProgress(i11);
                    }
                } catch (Throwable th4) {
                    VlionSDkManager.getInstance().upLoadCatchException(th4);
                }
                hideAnimation();
                return;
            }
            return;
        } catch (Throwable th5) {
            VlionSDkManager.getInstance().upLoadCatchException(th5);
        }
        VlionSDkManager.getInstance().upLoadCatchException(th5);
    }

    public void setMaxProgress(int i10) {
    }

    public void setProgress(int i10) {
        try {
            h1 h1Var = this.f2409e;
            if (h1Var == null) {
                return;
            }
            int i11 = 1;
            if (i10 <= 0) {
                i10 = 1;
            }
            h1Var.f2845a = true;
            h1Var.f2846b = i10;
            try {
                ProgressBar progressBar = this.f2405a;
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                    if (i10 > 0) {
                        i11 = i10;
                    }
                    this.f2405a.setProgress(i11);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            hideAnimation();
            String str = "正在下载+" + i10 + "%";
            LogVlion.e("VlionDownloadProgressBar setProgress ---=hahahaha=" + str);
            this.f2406b.setText(str);
            LogVlion.e("VlionDownloadProgressBar vlion_ad_progress_imgv: tVisibility==0   GONE==8   INVISIBLE==4");
            LogVlion.e("VlionDownloadProgressBar vlion_ad_progress_imgv: tVisibility==" + this.f2407c.getVisibility());
            if (this.f2408d == 3) {
                setTextColor(getResources().getColor(R.color.vlion_cst_bl_bt_ft_clr));
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public void setShakeStyle(String str, boolean z10) {
        try {
            h1 h1Var = this.f2409e;
            if (h1Var == null) {
                return;
            }
            h1Var.f2845a = false;
            h1Var.f2847c = z10;
            LogVlion.e("VlionDownloadProgressBar setShakeStyle tips=" + str + " isShake=" + z10);
            a(z10);
            try {
                ProgressBar progressBar = this.f2405a;
                if (progressBar != null) {
                    progressBar.setProgress(100);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            this.f2406b.setText(String.valueOf(str));
            if (this.f2408d == 3) {
                setTextColor(getResources().getColor(R.color.vlion_custom_white_font_color));
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public void setShowType(int i10) {
        int i11;
        View findViewById;
        try {
            this.f2408d = i10;
            this.f2406b = (TextView) findViewById(R.id.vlion_ad_progress_tip);
            this.f2407c = (ImageView) findViewById(R.id.vlion_ad_progress_imgv);
            if (i10 == 1) {
                ProgressBar progressBar = (ProgressBar) findViewById(R.id.vlion_ad_progress_bar1);
                this.f2405a = progressBar;
                progressBar.setVisibility(0);
                findViewById(R.id.vlion_ad_progress_bar).setVisibility(8);
                findViewById(R.id.vlion_ad_progress_bar_blue).setVisibility(8);
                findViewById(R.id.vlion_ad_progress_bar_blue_18dp).setVisibility(8);
                i11 = R.id.vlion_ad_progress_bar_pink_18dp;
            } else {
                if (i10 != 2) {
                    if (i10 == 3) {
                        ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.vlion_ad_progress_bar_blue_18dp);
                        this.f2405a = progressBar2;
                        progressBar2.setVisibility(0);
                        findViewById(R.id.vlion_ad_progress_bar).setVisibility(8);
                        findViewById(R.id.vlion_ad_progress_bar1).setVisibility(8);
                        findViewById(R.id.vlion_ad_progress_bar_blue).setVisibility(8);
                        findViewById(R.id.vlion_ad_progress_bar_pink_18dp).setVisibility(8);
                        setTextSize(11.0f);
                        setTextColor(getResources().getColor(R.color.vlion_custom_white_font_color));
                        findViewById = findViewById(R.id.vlion_ad_progress_imgv_18dp);
                    } else if (i10 == 4) {
                        ProgressBar progressBar3 = (ProgressBar) findViewById(R.id.vlion_ad_progress_bar_pink_18dp);
                        this.f2405a = progressBar3;
                        progressBar3.setVisibility(0);
                        findViewById(R.id.vlion_ad_progress_bar).setVisibility(8);
                        findViewById(R.id.vlion_ad_progress_bar1).setVisibility(8);
                        findViewById(R.id.vlion_ad_progress_bar_blue).setVisibility(8);
                        findViewById(R.id.vlion_ad_progress_bar_blue_18dp).setVisibility(8);
                        setTextSize(11.0f);
                        setTextColor(getResources().getColor(R.color.vlion_custom_white_font_color));
                        findViewById = findViewById(R.id.vlion_ad_progress_imgv_18dp);
                    } else {
                        ProgressBar progressBar4 = (ProgressBar) findViewById(R.id.vlion_ad_progress_bar);
                        this.f2405a = progressBar4;
                        progressBar4.setVisibility(0);
                        findViewById(R.id.vlion_ad_progress_bar1).setVisibility(8);
                        findViewById(R.id.vlion_ad_progress_bar_blue).setVisibility(8);
                        findViewById(R.id.vlion_ad_progress_bar_blue_18dp).setVisibility(8);
                        i11 = R.id.vlion_ad_progress_bar_pink_18dp;
                    }
                    this.f2407c = (ImageView) findViewById;
                    return;
                }
                ProgressBar progressBar5 = (ProgressBar) findViewById(R.id.vlion_ad_progress_bar_blue);
                this.f2405a = progressBar5;
                progressBar5.setVisibility(0);
                findViewById(R.id.vlion_ad_progress_bar).setVisibility(8);
                findViewById(R.id.vlion_ad_progress_bar1).setVisibility(8);
                findViewById(R.id.vlion_ad_progress_bar_blue_18dp).setVisibility(8);
                i11 = R.id.vlion_ad_progress_bar_pink_18dp;
            }
            findViewById(i11).setVisibility(8);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setTextColor(int i10) {
        try {
            TextView textView = this.f2406b;
            if (textView != null) {
                textView.setTextColor(i10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setTextDetail(String str) {
        try {
            TextView textView = this.f2406b;
            if (textView != null) {
                textView.setText(String.valueOf(str));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setTextSize(float f10) {
        try {
            TextView textView = this.f2406b;
            if (textView != null) {
                textView.setTextSize(2, f10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public VlionDownloadProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VlionDownloadProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        try {
            LayoutInflater.from(context).inflate(R.layout.vlion_cn_ad_download_progressbar, (ViewGroup) this, true);
            int i11 = context.obtainStyledAttributes(attributeSet, R.styleable.VlionDownloadProgressBar).getInt(R.styleable.VlionDownloadProgressBar_vlion_show_type, 0);
            this.f2408d = i11;
            this.f2409e = new h1();
            setShowType(i11);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
