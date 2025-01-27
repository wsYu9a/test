package cn.vlion.ad.inland.base;

import android.content.Context;
import android.widget.ImageView;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.view.video.VlionBaseVideoView;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.Random;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class d7 {

    /* renamed from: a */
    public g0 f2712a;

    /* renamed from: b */
    public Context f2713b;

    /* renamed from: c */
    public f5 f2714c;

    /* renamed from: d */
    public VlionBaseVideoView f2715d;

    /* renamed from: e */
    public VlionCustomParseAdData f2716e;

    /* renamed from: f */
    public VlionAdapterADConfig f2717f;

    public class a implements b {
    }

    public d7(Context context, g0 g0Var) {
        this.f2713b = context;
        this.f2712a = g0Var;
    }

    public final void a(ImageView.ScaleType scaleType, String str) {
        try {
            LogVlion.e("VlionViewManger downImg scale=" + scaleType.name());
            f5 f5Var = new f5(this.f2713b);
            this.f2714c = f5Var;
            f5Var.setScaleType(scaleType);
            g0 g0Var = this.f2712a;
            if (g0Var != null) {
                g0Var.onAdRenderSuccess(this.f2714c);
            }
            f5 f5Var2 = this.f2714c;
            a aVar = new a();
            f5Var2.getClass();
            try {
                f5Var2.f2799a = aVar;
                HttpRequestUtil.downloadBitmapNeedCache(f5Var2, str, new e5(f5Var2));
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void a(VlionCustomParseAdData vlionCustomParseAdData, VlionAdapterADConfig vlionAdapterADConfig) {
        String str;
        this.f2716e = vlionCustomParseAdData;
        try {
            if (vlionCustomParseAdData == null || vlionAdapterADConfig == null) {
                LogVlion.e("VlionViewManger  vlionCustomParseAdData is null");
                return;
            }
            this.f2717f = vlionAdapterADConfig;
            int ctype = vlionCustomParseAdData.getCtype();
            if (ctype != 2) {
                if (ctype == 3) {
                    LogVlion.e("VlionViewMangerVLION_VIDEO_TYPE");
                    a(this.f2716e);
                    return;
                } else {
                    g0 g0Var = this.f2712a;
                    if (g0Var != null) {
                        g0Var.a(i1.f2913c);
                        return;
                    }
                    return;
                }
            }
            try {
                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
                int imageScale = vlionAdapterADConfig.getImageScale();
                if (imageScale == 2) {
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                    str = "VlionViewManger scale=CENTER_CROP";
                } else if (imageScale == 3) {
                    scaleType = ImageView.ScaleType.FIT_XY;
                    str = "VlionViewManger scale=FIT_XY";
                } else {
                    if (imageScale != 4) {
                        a(scaleType, this.f2716e.getImageUrl());
                    }
                    str = "VlionViewManger scale=FIT_CENTER";
                }
                LogVlion.e(str);
                a(scaleType, this.f2716e.getImageUrl());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void a(VlionCustomParseAdData vlionCustomParseAdData) {
        try {
            String str = t.c(this.f2713b) + String.valueOf(System.currentTimeMillis()).concat(new Random().nextInt(10000) + "").concat(".mp4");
            String videoUrl = vlionCustomParseAdData.getVideoUrl();
            try {
                this.f2715d = new VlionBaseVideoView(this.f2713b);
                Executors.newSingleThreadExecutor().execute(new e7(this, videoUrl, str));
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }
}
