package cn.vlion.ad.inland.ad.view.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public class VlionTimeView extends FrameLayout {

    /* renamed from: a */
    public TextView f2532a;

    /* renamed from: b */
    public Context f2533b;

    /* renamed from: c */
    public TextView f2534c;

    /* renamed from: d */
    public int f2535d;

    /* renamed from: e */
    public volatile int f2536e;

    public VlionTimeView(Context context) {
        this(context, null);
    }

    public final void a() {
        try {
            LayoutInflater.from(this.f2533b).inflate(R.layout.vlion_cn_ad_progress_video, (ViewGroup) this, true);
            this.f2532a = (TextView) findViewById(R.id.vilon_tv_left_time);
            this.f2534c = (TextView) findViewById(R.id.vilon_tv_total_time);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public int getLeftSec() {
        return this.f2536e;
    }

    public void setMaxProgress(int i10) {
        try {
            this.f2535d = i10;
            this.f2534c.setText(String.valueOf(i10));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setProgress(int i10) {
        try {
            this.f2536e = this.f2535d - i10;
            String str = this.f2536e + "s后可领取奖励";
            TextView textView = this.f2532a;
            if (textView != null) {
                textView.setText(str);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public VlionTimeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VlionTimeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2535d = 100;
        this.f2536e = 0;
        this.f2533b = context;
        a();
    }
}
