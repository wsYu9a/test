package cn.vlion.ad.inland.base;

import android.content.Context;
import android.widget.FrameLayout;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;

/* loaded from: classes.dex */
public abstract class n4 extends FrameLayout implements d {
    public n4(Context context) {
        super(context, null, 0);
    }

    public abstract void setAppinfo(VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean);

    public abstract void settingVlionViewTouch(g7 g7Var);
}
