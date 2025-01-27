package cn.vlion.ad.inland.ta;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.ta.i;
import com.alimm.tanx.core.ad.view.TanxAdView;

/* loaded from: classes.dex */
public final class d extends TanxAdView {

    /* renamed from: a */
    public ImageView f4029a;

    public d(Context context) {
        this(context, 0);
    }

    public final void a(String str, i.a aVar) {
        try {
            ImageView imageView = this.f4029a;
            if (imageView != null) {
                HttpRequestUtil.downloadBitmapNeedCache(imageView, str, new c(aVar));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        try {
            ImageView imageView = this.f4029a;
            if (imageView != null) {
                imageView.setScaleType(scaleType);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public d(Context context, int i10) {
        this(context, (Object) null);
    }

    public d(Context context, Object obj) {
        super(context, null, 0);
        try {
            ImageView imageView = new ImageView(context);
            this.f4029a = imageView;
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.f4029a, -1, -1);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
