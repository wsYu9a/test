package cn.vlion.ad.inland.ad.view.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity;
import cn.vlion.ad.inland.ad.view.active.VlionAdClosedView;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.g1;
import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.y5;
import java.util.Random;

/* loaded from: classes.dex */
public class VlionVideoSkipDialogView extends LinearLayout {

    /* renamed from: a */
    public Context f2548a;

    /* renamed from: b */
    public TextView f2549b;

    /* renamed from: c */
    public TextView f2550c;

    /* renamed from: d */
    public TextView f2551d;

    /* renamed from: e */
    public TextView f2552e;

    /* renamed from: f */
    public e f2553f;

    /* renamed from: g */
    public VlionAdClosedView f2554g;

    public class a implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ i0 f2555a;

        public b(i0 i0Var) {
            this.f2555a = i0Var;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                VlionVideoSkipDialogView vlionVideoSkipDialogView = VlionVideoSkipDialogView.this;
                if (vlionVideoSkipDialogView != null) {
                    vlionVideoSkipDialogView.setVisibility(8);
                    e eVar = VlionVideoSkipDialogView.this.f2553f;
                    if (eVar != null) {
                        VlionADClickType vlionADClickType = new VlionADClickType("click", this.f2555a.b(), "popup", "button", "");
                        y5 y5Var = (y5) eVar;
                        try {
                            LogVlion.e("VlionRewardVideoViewActivity onContinue=");
                            VlionBaseVideoView vlionBaseVideoView = y5Var.f3531a.f2333k;
                            if (vlionBaseVideoView != null) {
                                vlionBaseVideoView.c();
                            }
                            vlionADClickType.setTarget(VlionCustomAdActiveType$VlionCustomTarget.videocontinue.toString());
                            VlionADEventManager.submitClick(y5Var.f3531a.f2329g, vlionADClickType);
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                }
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                VlionVideoSkipDialogView vlionVideoSkipDialogView = VlionVideoSkipDialogView.this;
                if (vlionVideoSkipDialogView != null) {
                    vlionVideoSkipDialogView.setVisibility(8);
                    e eVar = VlionVideoSkipDialogView.this.f2553f;
                    if (eVar != null) {
                        y5 y5Var = (y5) eVar;
                        try {
                            LogVlion.e("VlionRewardVideoViewActivity onExit");
                            VlionRewardVideoActivity vlionRewardVideoActivity = y5Var.f3531a;
                            g1 g1Var = vlionRewardVideoActivity.f2323a;
                            if (g1Var != null) {
                                g1Var.b(vlionRewardVideoActivity.f2347y);
                            }
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                        y5Var.f3531a.finish();
                    }
                }
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        }
    }

    public interface e {
    }

    public VlionVideoSkipDialogView(Context context) {
        this(context, null);
    }

    public final void a() {
        try {
            LayoutInflater.from(this.f2548a).inflate(R.layout.vlion_cn_ad_reward_skip, (ViewGroup) this, true);
            this.f2549b = (TextView) findViewById(R.id.vilon_tv_left_time_des);
            this.f2550c = (TextView) findViewById(R.id.vilon_tv_continue);
            this.f2552e = (TextView) findViewById(R.id.vlion_tv_num_reward);
            int nextInt = new Random().nextInt(25) + 75;
            this.f2552e.setText(nextInt + "" + getResources().getString(R.string.vlion_custom_ad_text_num_reward));
            this.f2551d = (TextView) findViewById(R.id.vilon_tv_exit);
            this.f2554g = (VlionAdClosedView) findViewById(R.id.vlion_ad_closed);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public void setVlionVideoSkipCallBack(e eVar) {
        this.f2553f = eVar;
    }

    public VlionVideoSkipDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(String str) {
        try {
            setVisibility(0);
            this.f2549b.setText(str);
            setOnClickListener(new a());
            this.f2550c.setOnClickListener(new b(new i0(this.f2550c)));
            this.f2551d.setOnClickListener(new c());
            this.f2554g.a("X", true, new d(new i0(this.f2554g)));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public VlionVideoSkipDialogView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2548a = context;
        a();
    }

    public class d implements VlionAdClosedView.d {

        /* renamed from: a */
        public final /* synthetic */ i0 f2558a;

        public d(i0 i0Var) {
            this.f2558a = i0Var;
        }

        @Override // cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d
        public final void a() {
            try {
                VlionVideoSkipDialogView vlionVideoSkipDialogView = VlionVideoSkipDialogView.this;
                if (vlionVideoSkipDialogView != null) {
                    vlionVideoSkipDialogView.setVisibility(8);
                    e eVar = VlionVideoSkipDialogView.this.f2553f;
                    if (eVar != null) {
                        VlionADClickType vlionADClickType = new VlionADClickType("click", this.f2558a.b(), "popup", "", "");
                        y5 y5Var = (y5) eVar;
                        try {
                            LogVlion.e("VlionRewardVideoViewActivity onContinue=");
                            VlionBaseVideoView vlionBaseVideoView = y5Var.f3531a.f2333k;
                            if (vlionBaseVideoView != null) {
                                vlionBaseVideoView.c();
                            }
                            vlionADClickType.setTarget(VlionCustomAdActiveType$VlionCustomTarget.videocontinue.toString());
                            VlionADEventManager.submitClick(y5Var.f3531a.f2329g, vlionADClickType);
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                }
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        }

        @Override // cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d
        public final void a(boolean z10) {
            try {
                VlionVideoSkipDialogView vlionVideoSkipDialogView = VlionVideoSkipDialogView.this;
                if (vlionVideoSkipDialogView != null) {
                    vlionVideoSkipDialogView.setVisibility(8);
                    e eVar = VlionVideoSkipDialogView.this.f2553f;
                    if (eVar != null) {
                        VlionADClickType vlionADClickType = new VlionADClickType("click", this.f2558a.b(), "popup", "", "");
                        y5 y5Var = (y5) eVar;
                        try {
                            LogVlion.e("VlionRewardVideoViewActivity onContinue=");
                            VlionBaseVideoView vlionBaseVideoView = y5Var.f3531a.f2333k;
                            if (vlionBaseVideoView != null) {
                                vlionBaseVideoView.c();
                            }
                            vlionADClickType.setTarget(VlionCustomAdActiveType$VlionCustomTarget.videocontinue.toString());
                            VlionADEventManager.submitClick(y5Var.f3531a.f2329g, vlionADClickType);
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                }
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        }
    }
}
