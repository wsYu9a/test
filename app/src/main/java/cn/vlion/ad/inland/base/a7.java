package cn.vlion.ad.inland.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class a7 extends FrameLayout implements cn.vlion.ad.inland.base.d {

    /* renamed from: a */
    public Context f2618a;

    /* renamed from: b */
    public boolean f2619b;

    /* renamed from: c */
    public boolean f2620c;

    /* renamed from: d */
    public b5 f2621d;

    /* renamed from: e */
    public FrameLayout f2622e;

    /* renamed from: f */
    public e1 f2623f;

    /* renamed from: g */
    public LinearLayout f2624g;

    /* renamed from: h */
    public TextView f2625h;

    /* renamed from: i */
    public ImageView f2626i;

    /* renamed from: j */
    public ProgressBar f2627j;

    /* renamed from: k */
    public boolean f2628k;

    /* renamed from: l */
    public VlionNativesAdVideoListener f2629l;

    /* renamed from: m */
    public String f2630m;

    /* renamed from: n */
    public String f2631n;

    public class a implements w0 {
        public a() {
        }
    }

    public class b implements c1 {
        public b() {
        }

        public final void a(boolean z10) {
            LogVlion.e("VlionVideoViewBaseGroup  showProgressIcon=" + z10);
            a7.this.a(z10);
        }

        public final void b(boolean z10) {
            LogVlion.e("VlionVideoViewBaseGroup  showStartPlayIcon=" + z10);
            a7.a(a7.this, z10);
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ String f2634a;

        /* renamed from: b */
        public final /* synthetic */ String f2635b;

        public c(String str, String str2) {
            this.f2634a = str;
            this.f2635b = str2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                a7.b(a7.this, false);
                a7 a7Var = a7.this;
                String str = this.f2634a;
                String str2 = this.f2635b;
                a7Var.getClass();
                try {
                    a7Var.a(true);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("VlionVideoViewBaseGroup  startDownVideo （null==vlionDownloadVideoContextState）=");
                    sb2.append(a7Var.f2621d == null);
                    sb2.append(str);
                    LogVlion.e(sb2.toString());
                    a7Var.f2621d.a(str, new b7(a7Var, str2));
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                a7.b(a7.this, false);
                a7.this.a(true);
                a7.this.a();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                a7.a(a7.this, false);
                a7.this.a(true);
                LogVlion.e("VlionVideoViewBaseGroup  vlion_cn_video_play_icon onClick");
                e1 e1Var = a7.this.f2623f;
                if (e1Var != null) {
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("VlionBaseVideoViewCenter startClickVideo null!= mMediaPlayer=");
                        sb2.append(e1Var.f2725f != null);
                        LogVlion.e(sb2.toString());
                        e1Var.f2730k = true;
                        e1Var.g();
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        }
    }

    public a7(Context context, boolean z10) {
        super(context);
        this.f2619b = false;
        this.f2620c = false;
        this.f2628k = false;
        this.f2630m = "";
        this.f2631n = "";
        this.f2618a = context;
        try {
            LayoutInflater.from(context).inflate(R.layout.vlion_cn_ad_video_layout_base, (ViewGroup) this, true);
            this.f2622e = (FrameLayout) findViewById(R.id.vlion_ad_center_video);
            this.f2624g = (LinearLayout) findViewById(R.id.vlion_ad_video_retry);
            this.f2625h = (TextView) findViewById(R.id.vlion_ad_video_button_retry);
            this.f2626i = (ImageView) findViewById(R.id.vlion_cn_video_play_icon);
            this.f2627j = (ProgressBar) findViewById(R.id.vlion_progressBar_circle);
            this.f2620c = z10;
            LogVlion.e("VlionVideoViewBaseGroup setDataSource isDownLoadPlay=" + this.f2620c);
            this.f2623f = this.f2620c ? new z0(this.f2618a) : new b1(this.f2618a);
            if (this.f2622e != null) {
                j0.a(this.f2623f);
                this.f2622e.addView(this.f2623f, new FrameLayout.LayoutParams(-1, -1));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a() {
        e1 e1Var;
        try {
            LogVlion.e("VlionVideoViewBaseGroup  startOnLineVideo =" + this.f2619b + " isExposurePlay=" + this.f2628k);
            ImageView imageView = this.f2626i;
            if (imageView != null) {
                imageView.setOnClickListener(new e());
            }
            if (this.f2619b) {
                a(true);
                if (!this.f2628k || (e1Var = this.f2623f) == null) {
                    return;
                }
                e1Var.f();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void b(String str, String str2) {
        try {
            LogVlion.e("VlionVideoViewBaseGroup setDownLoadVideo +coverUrl " + str2);
            if (this.f2621d == null) {
                this.f2621d = new b5();
            }
            TextView textView = this.f2625h;
            if (textView != null) {
                textView.setOnClickListener(new c(str, str2));
            }
            LogVlion.e("VlionVideoViewBaseGroup BuildConfig.DEBUG=false");
            boolean z10 = true;
            try {
                a(true);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionVideoViewBaseGroup  startDownVideo （null==vlionDownloadVideoContextState）=");
                if (this.f2621d != null) {
                    z10 = false;
                }
                sb2.append(z10);
                sb2.append(str);
                LogVlion.e(sb2.toString());
                this.f2621d.a(str, new b7(this, str2));
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void c(String str, String str2) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VlionVideoViewBaseGroup  setOnLinePlayVideo （null==vlionDownloadVideoContextState）=");
            sb2.append(this.f2621d == null);
            LogVlion.e(sb2.toString());
            TextView textView = this.f2625h;
            if (textView != null) {
                textView.setOnClickListener(new d());
            }
            e1 e1Var = this.f2623f;
            if (e1Var != null) {
                e1Var.a(str, str2);
            }
            a();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.d
    public final void destroy() {
        try {
            LogVlion.e(" VlionVideoViewBaseGroup destroy--=");
            e1 e1Var = this.f2623f;
            if (e1Var != null) {
                e1Var.a();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setAutoPlay(boolean z10) {
        try {
            this.f2619b = z10;
            e1 e1Var = this.f2623f;
            if (e1Var != null) {
                e1Var.setAutoPlay(z10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setClosedVolumePlay(boolean z10) {
        try {
            LogVlion.e("VlionVideoViewBaseGroup setClosedVolumePlay isClosedVolume=" + z10);
            e1 e1Var = this.f2623f;
            if (e1Var != null) {
                e1Var.setClosedVolumePlay(z10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setExposurePlay(boolean z10) {
        try {
            LogVlion.e("VlionVideoViewBaseGroup  setExposurePlay exposurePlay=" + z10);
            this.f2628k = z10;
            e1 e1Var = this.f2623f;
            if (e1Var != null) {
                e1Var.setExposurePlay(z10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setLoop(boolean z10) {
        try {
            e1 e1Var = this.f2623f;
            if (e1Var != null) {
                e1Var.setLoop(z10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setVideoScaleMode(int i10) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VlionVideoViewBaseGroup  setVideoScaleMode (null != vlionBaseVideoViewCenter)=");
            sb2.append(this.f2623f != null);
            LogVlion.e(sb2.toString());
            e1 e1Var = this.f2623f;
            if (e1Var != null) {
                e1Var.setVideoScaleMode(i10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setVlionNativesAdVideoListener(VlionNativesAdVideoListener vlionNativesAdVideoListener) {
        this.f2629l = vlionNativesAdVideoListener;
    }

    public final void a(String str, String str2) {
        try {
            this.f2630m = str;
            this.f2631n = str2;
            LogVlion.e("VlionVideoViewBaseGroup setDataSource=");
            if (this.f2620c) {
                b(str, str2);
            } else {
                c(str, str2);
            }
            this.f2623f.setAdVideoListener(new a());
            this.f2623f.setVlionBaseVideoStatueController(new b());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(boolean z10) {
        try {
            LogVlion.e("VlionVideoViewBaseGroup  showLoading=" + z10);
            ProgressBar progressBar = this.f2627j;
            if (progressBar != null) {
                progressBar.setVisibility(z10 ? 0 : 8);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(a7 a7Var, boolean z10) {
        a7Var.getClass();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VlionVideoViewBaseGroup  showPlaying=");
            sb2.append(z10);
            sb2.append(" (null != vlion_cn_video_play_icon)=");
            int i10 = 0;
            sb2.append(a7Var.f2626i != null);
            LogVlion.e(sb2.toString());
            ImageView imageView = a7Var.f2626i;
            if (imageView != null) {
                if (!z10) {
                    i10 = 8;
                }
                imageView.setVisibility(i10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void b(a7 a7Var, boolean z10) {
        a7Var.getClass();
        try {
            LogVlion.e("VlionVideoViewBaseGroup  showRetry=" + z10);
            LinearLayout linearLayout = a7Var.f2624g;
            if (linearLayout != null) {
                linearLayout.setVisibility(z10 ? 0 : 8);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
