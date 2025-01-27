package cn.vlion.ad.inland.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.vlion.ad.inland.base.f7;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.List;

/* loaded from: classes.dex */
public final class h5 extends FrameLayout implements d {

    /* renamed from: a */
    public a f2848a;

    /* renamed from: b */
    public volatile boolean f2849b;

    /* renamed from: c */
    public ImageView f2850c;

    /* renamed from: d */
    public ImageView f2851d;

    /* renamed from: e */
    public ImageView f2852e;

    /* renamed from: f */
    public int f2853f;

    /* renamed from: g */
    public int f2854g;

    /* renamed from: h */
    public int f2855h;

    /* renamed from: i */
    public int f2856i;

    public interface a {
    }

    public h5(Context context, int i10) {
        super(context, null, 0);
        this.f2849b = false;
        try {
            LayoutInflater.from(context).inflate(R.layout.vlion_cn_ad_image_group, (ViewGroup) this, true);
            this.f2850c = (ImageView) findViewById(R.id.vlion_img_one);
            this.f2851d = (ImageView) findViewById(R.id.vlion_img_two);
            this.f2852e = (ImageView) findViewById(R.id.vlion_img_three);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(List list, f7.a aVar) {
        a aVar2;
        try {
            this.f2848a = aVar;
            this.f2849b = false;
            this.f2853f = 0;
            LogVlion.e("VlionImageViewGroup  loadAd");
            if (list == null || list.size() <= 0) {
                if (this.f2854g != this.f2853f || (aVar2 = this.f2848a) == null) {
                    return;
                }
                VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_IS_IMAGE_LIST_EMPTY;
                i1 i1Var = new i1(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                g0 g0Var = f7.this.f2803a;
                if (g0Var != null) {
                    g0Var.a(i1Var);
                    return;
                }
                return;
            }
            int size = list.size();
            LogVlion.e("VlionImageViewGroup  size=" + size);
            if (size >= 3) {
                ImageView imageView = this.f2851d;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                ImageView imageView2 = this.f2852e;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                size = 3;
            }
            this.f2853f = size;
            if (size > 1) {
                setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            LogVlion.e("VlionImageViewGroup  size=" + size);
            for (int i10 = 0; i10 < size; i10++) {
                String str = (String) list.get(i10);
                if (i10 == 0) {
                    try {
                        HttpRequestUtil.downloadBitmap(this.f2850c, str, new g5(this));
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }
                if (i10 == 1) {
                    try {
                        HttpRequestUtil.downloadBitmap(this.f2851d, str, new g5(this));
                    } catch (Throwable th3) {
                        VlionSDkManager.getInstance().upLoadCatchException(th3);
                    }
                }
                if (i10 == 2) {
                    try {
                        HttpRequestUtil.downloadBitmap(this.f2852e, str, new g5(this));
                    } catch (Throwable th4) {
                        VlionSDkManager.getInstance().upLoadCatchException(th4);
                    }
                }
            }
        } catch (Throwable th5) {
            VlionSDkManager.getInstance().upLoadCatchException(th5);
        }
    }

    @Override // cn.vlion.ad.inland.base.d
    public final void destroy() {
        try {
            if (this.f2848a != null) {
                this.f2848a = null;
            }
            removeAllViews();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public ImageView getVlion_img_one() {
        return this.f2850c;
    }

    public ImageView getVlion_img_three() {
        return this.f2852e;
    }

    public ImageView getVlion_img_two() {
        return this.f2851d;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        try {
            LogVlion.e("VlionImageViewGroup  scaleType=:" + scaleType);
            if (scaleType == null) {
                throw new NullPointerException();
            }
            ImageView imageView = this.f2850c;
            if (imageView != null) {
                imageView.setScaleType(scaleType);
            }
            ImageView imageView2 = this.f2851d;
            if (imageView2 != null) {
                imageView2.setScaleType(scaleType);
            }
            ImageView imageView3 = this.f2852e;
            if (imageView3 != null) {
                imageView3.setScaleType(scaleType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
