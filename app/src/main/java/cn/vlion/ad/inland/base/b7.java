package cn.vlion.ad.inland.base;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class b7 implements z4 {

    /* renamed from: a */
    public final /* synthetic */ String f2673a;

    /* renamed from: b */
    public final /* synthetic */ a7 f2674b;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f2675a;

        /* renamed from: cn.vlion.ad.inland.base.b7$a$a */
        public class ViewOnClickListenerC0024a implements View.OnClickListener {
            public ViewOnClickListenerC0024a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    a7.a(b7.this.f2674b, false);
                    e1 e1Var = b7.this.f2674b.f2623f;
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

        public a(String str) {
            this.f2675a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e1 e1Var;
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionVideoViewBaseGroup  downloadComplete (null != vlion_ad_center_video) ");
                sb2.append(b7.this.f2674b.f2622e != null);
                LogVlion.e(sb2.toString());
                FrameLayout frameLayout = b7.this.f2674b.f2622e;
                if (frameLayout != null) {
                    frameLayout.setVisibility(0);
                    b7 b7Var = b7.this;
                    e1 e1Var2 = b7Var.f2674b.f2623f;
                    if (e1Var2 != null) {
                        e1Var2.a(this.f2675a, b7Var.f2673a);
                    }
                    LogVlion.e("VlionVideoViewBaseGroup  isAutoPlay " + b7.this.f2674b.f2619b);
                    a7 a7Var = b7.this.f2674b;
                    if (a7Var.f2619b) {
                        a7Var.a(false);
                        a7.a(b7.this.f2674b, false);
                        LogVlion.e("VlionVideoViewBaseGroup  isExposurePlay " + b7.this.f2674b.f2628k);
                        a7 a7Var2 = b7.this.f2674b;
                        if (a7Var2.f2628k && (e1Var = a7Var2.f2623f) != null) {
                            e1Var.f();
                        }
                    } else {
                        a7Var.a(false);
                        a7.a(b7.this.f2674b, true);
                    }
                    ImageView imageView = b7.this.f2674b.f2626i;
                    if (imageView != null) {
                        imageView.setOnClickListener(new ViewOnClickListenerC0024a());
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public b7(a7 a7Var, String str) {
        this.f2674b = a7Var;
        this.f2673a = str;
    }

    @Override // cn.vlion.ad.inland.base.z4
    public final void a(String str) {
        try {
            LogVlion.e("VlionVideoViewBaseGroup  downloadComplete filepath " + str);
            this.f2674b.post(new a(str));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.z4
    public final void a(VlionAdBaseError vlionAdBaseError) {
        LogVlion.e("VlionVideoViewBaseGroup  downloadFailure ");
        this.f2674b.a(false);
        a7.b(this.f2674b, true);
    }

    @Override // cn.vlion.ad.inland.base.z4
    public final void a(int i10) {
        LogVlion.e("VlionVideoViewBaseGroup  downloading ");
        this.f2674b.a(true);
    }
}
