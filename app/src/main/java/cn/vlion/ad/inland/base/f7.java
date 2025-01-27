package cn.vlion.ad.inland.base;

import android.content.Context;
import android.widget.ImageView;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.h5;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.List;

/* loaded from: classes.dex */
public final class f7 {

    /* renamed from: a */
    public g0 f2803a;

    /* renamed from: b */
    public Context f2804b;

    /* renamed from: c */
    public int f2805c;

    /* renamed from: d */
    public a7 f2806d;

    /* renamed from: e */
    public VlionCustomParseAdData f2807e;

    /* renamed from: f */
    public h5 f2808f;

    /* renamed from: g */
    public int f2809g = 4;

    /* renamed from: h */
    public VlionNativesAdVideoListener f2810h;

    public class a implements h5.a {
        public a() {
        }
    }

    public f7(Context context, g0 g0Var) {
        this.f2804b = context;
        this.f2803a = g0Var;
    }

    public final void a() {
        try {
            h5 h5Var = this.f2808f;
            if (h5Var != null) {
                h5Var.destroy();
                this.f2808f = null;
            }
            if (this.f2807e != null) {
                this.f2807e = null;
            }
            if (this.f2803a != null) {
                this.f2803a = null;
            }
            a7 a7Var = this.f2806d;
            if (a7Var != null) {
                a7Var.destroy();
                this.f2806d = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(VlionCustomParseAdData vlionCustomParseAdData, int i10) {
        try {
            String videoUrl = vlionCustomParseAdData.getVideoUrl();
            String imageUrl = vlionCustomParseAdData.getImageUrl();
            LogVlion.e("VlionViewMangerCenter initVideoData playMode=" + i10);
            a7 a7Var = new a7(this.f2804b, i10 == 2);
            this.f2806d = a7Var;
            a7Var.a(videoUrl, imageUrl);
            this.f2806d.setVideoScaleMode(this.f2809g);
            this.f2806d.setVlionNativesAdVideoListener(this.f2810h);
            g0 g0Var = this.f2803a;
            if (g0Var != null) {
                g0Var.onAdRenderSuccess(this.f2806d);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(VlionCustomParseAdData vlionCustomParseAdData, VlionAdapterADConfig vlionAdapterADConfig) {
        String str;
        this.f2807e = vlionCustomParseAdData;
        try {
            if (vlionCustomParseAdData == null || vlionAdapterADConfig == null) {
                LogVlion.e("VlionViewMangerCenter  vlionCustomParseAdData is null");
                return;
            }
            this.f2809g = vlionAdapterADConfig.getImageScale();
            LogVlion.e("VlionViewMangerCenter  vlionCustomParseAdData.getCtype()=" + this.f2807e.getCtype());
            int ctype = this.f2807e.getCtype();
            if (ctype != 2) {
                if (ctype == 3) {
                    LogVlion.e("VlionViewMangerCenter VLION_VIDEO_TYPE");
                    this.f2805c = 3;
                    a(this.f2807e, vlionAdapterADConfig.getPlayMode());
                    return;
                } else {
                    g0 g0Var = this.f2803a;
                    if (g0Var != null) {
                        g0Var.a(i1.f2913c);
                        return;
                    }
                    return;
                }
            }
            this.f2805c = 2;
            ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
            int i10 = this.f2809g;
            if (i10 == 2) {
                scaleType = ImageView.ScaleType.CENTER_CROP;
                str = "VlionViewMangerCenter scale=CENTER_CROP";
            } else if (i10 == 3) {
                scaleType = ImageView.ScaleType.FIT_XY;
                str = "VlionViewMangerCenter scale=FIT_XY";
            } else {
                if (i10 != 4) {
                    a(scaleType, this.f2807e.getImageBeanList());
                }
                str = "VlionViewMangerCenter scale=FIT_CENTER";
            }
            LogVlion.e(str);
            a(scaleType, this.f2807e.getImageBeanList());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(ImageView.ScaleType scaleType, List<String> list) {
        try {
            LogVlion.e("VlionViewMangerCenter downImg scale=" + scaleType.name());
            h5 h5Var = new h5(this.f2804b, 0);
            this.f2808f = h5Var;
            h5Var.setScaleType(scaleType);
            this.f2808f.a(list, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
