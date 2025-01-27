package cn.vlion.ad.inland.ta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import com.alimm.tanx.core.ad.view.TanxAdView;

/* loaded from: classes.dex */
public final class o extends TanxAdView {

    /* renamed from: a */
    public FrameLayout f4073a;

    public o(Context context) {
        this(context, 0);
    }

    public final void a(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                FrameLayout frameLayout = this.f4073a;
                if (frameLayout != null) {
                    frameLayout.addView(view, -1, -1);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public o(Context context, int i10) {
        this(context, (Object) null);
    }

    public o(Context context, Object obj) {
        super(context, null, 0);
        try {
            this.f4073a = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.vlion_tanx_native_video, (ViewGroup) this, true).findViewById(R.id.fl_ad_video);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
