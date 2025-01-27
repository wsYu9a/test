package cn.vlion.ad.inland.ad.view.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.view.video.VolumeControlView;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.a7;
import cn.vlion.ad.inland.base.b0;
import cn.vlion.ad.inland.base.e1;
import cn.vlion.ad.inland.base.h5;
import cn.vlion.ad.inland.base.i0;
import cn.vlion.ad.inland.base.j0;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.util.handle.VlionClickParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.v0;
import java.util.List;

/* loaded from: classes.dex */
public class VlionDownloadVideoLayout extends v0 {

    /* renamed from: h */
    public FrameLayout f2518h;

    /* renamed from: i */
    public LinearLayout f2519i;

    /* renamed from: j */
    public View f2520j;

    /* renamed from: k */
    public VolumeControlView f2521k;

    /* renamed from: l */
    public int f2522l;

    /* renamed from: m */
    public boolean f2523m;

    public class a implements VolumeControlView.b {

        /* renamed from: a */
        public final /* synthetic */ a7 f2524a;

        public a(a7 a7Var) {
            this.f2524a = a7Var;
        }

        @Override // cn.vlion.ad.inland.ad.view.video.VolumeControlView.b
        public final void a(boolean z10) {
            try {
                a7 a7Var = this.f2524a;
                if (a7Var != null) {
                    a7Var.setClosedVolumePlay(z10);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements VlionNativesAdVideoListener {

        /* renamed from: a */
        public final /* synthetic */ d f2525a;

        public b(d dVar) {
            this.f2525a = dVar;
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onAdVideoPlayError(String str) {
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onProgressUpdate(int i10, int i11) {
            try {
                VlionDownloadVideoLayout vlionDownloadVideoLayout = VlionDownloadVideoLayout.this;
                if (vlionDownloadVideoLayout != null) {
                    vlionDownloadVideoLayout.f2523m = true;
                    vlionDownloadVideoLayout.f2522l = i10;
                }
                d dVar = this.f2525a;
                if (dVar != null) {
                    dVar.onAdVideoPlaying(i10, i11);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onVideoAdComplete() {
            try {
                VlionDownloadVideoLayout.this.f2523m = false;
                d dVar = this.f2525a;
                if (dVar != null) {
                    dVar.onAdVideoPlayComplete();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onVideoAdContinuePlay() {
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onVideoAdPaused() {
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onVideoAdStartPlay() {
            d dVar = this.f2525a;
            if (dVar != null) {
                dVar.onAdVideoStart();
            }
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onVideoError(int i10, int i11) {
        }

        @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
        public final void onVideoLoad() {
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ d f2527a;

        /* renamed from: b */
        public final /* synthetic */ i0 f2528b;

        /* renamed from: c */
        public final /* synthetic */ String f2529c;

        /* renamed from: d */
        public final /* synthetic */ List f2530d;

        public c(d dVar, i0 i0Var, String str, List list) {
            this.f2527a = dVar;
            this.f2528b = i0Var;
            this.f2529c = str;
            this.f2530d = list;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                if (this.f2527a != null) {
                    VlionADClickType vlionADClickType = new VlionADClickType("click", b0.a(this.f2528b), "main", "hotsplot", "");
                    VlionClickParameterReplace vlionClickParameterReplace = new VlionClickParameterReplace(this.f2529c, this.f2530d);
                    vlionClickParameterReplace.handleBaseParameter(VlionDownloadVideoLayout.this.f2519i);
                    vlionClickParameterReplace.handleClickParameter(this.f2528b, vlionADClickType);
                    vlionADClickType.setVlionBaseParameterReplace(vlionClickParameterReplace);
                    this.f2527a.a(vlionADClickType);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public interface d {
        void a(VlionADClickType vlionADClickType);

        void onAdVideoPlayComplete();

        void onAdVideoPlaying(int i10, int i11);

        void onAdVideoStart();
    }

    public VlionDownloadVideoLayout(Context context) {
        this(context, null);
    }

    public final void a(View view, boolean z10, boolean z11, int i10, boolean z12, boolean z13, String str, List<VlionCustomAdData.SeatbidBean.BidBean.McBean.macroValues> list, d dVar) {
        if (view == null) {
            return;
        }
        try {
            this.f2520j = view;
            LinearLayout linearLayout = this.f2519i;
            if (linearLayout != null) {
                try {
                    linearLayout.removeAllViews();
                    j0.a(view);
                    linearLayout.addView(view, new LinearLayout.LayoutParams(-1, -1));
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
            if (!z10) {
                this.f2518h.setVisibility(8);
                this.f2519i.setOnClickListener(new c(dVar, new i0(this.f2519i), str, list));
                return;
            }
            this.f2518h.setVisibility(0);
            VolumeControlView volumeControlView = this.f2521k;
            volumeControlView.getClass();
            try {
                volumeControlView.f2560a = z11;
                volumeControlView.setImageResource(z11 ? R.drawable.vlion_cn_ad_volume_close : R.drawable.vlion_cn_ad_volume_open);
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
            if (view instanceof a7) {
                a7 a7Var = (a7) view;
                this.f2521k.setVolumeControlListener(new a(a7Var));
                a7Var.setClosedVolumePlay(z11);
                LogVlion.e("VlionDownloadVideoLayout  isAutoPlay=" + z12 + " isLoop ==" + z13);
                a7Var.setAutoPlay(z12);
                a7Var.setLoop(z13);
                a7Var.setVideoScaleMode(i10);
                a7Var.setVlionNativesAdVideoListener(new b(dVar));
            }
        } catch (Throwable th4) {
            VlionSDkManager.getInstance().upLoadCatchException(th4);
        }
    }

    public final void c() {
        try {
            View view = this.f2520j;
            if (view != null) {
                if (view instanceof h5) {
                    LogVlion.e(" 222 destroy--=");
                    ((h5) this.f2520j).destroy();
                } else if (view instanceof a7) {
                    LogVlion.e(" 1111 destroy--=");
                    ((a7) this.f2520j).destroy();
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public int getCurrent() {
        return this.f2522l;
    }

    public VlionDownloadVideoLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VlionDownloadVideoLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2523m = false;
        try {
            LayoutInflater.from(context).inflate(R.layout.vlion_cn_ad_download_video_layout, (ViewGroup) this, true);
            this.f2518h = (FrameLayout) findViewById(R.id.vlion_video_fl_progress_layout);
            this.f2519i = (LinearLayout) findViewById(R.id.vlion_video_ll_play_container);
            this.f2521k = (VolumeControlView) findViewById(R.id.soundView);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.v0
    public final void a(boolean z10) {
        try {
            super.a(z10);
            LogVlion.e("VlionDownloadVideoLayout isResume=" + z10 + " isRectVisible=" + b());
            if (z10 && b()) {
                try {
                    View view = this.f2520j;
                    if (view != null && (view instanceof a7)) {
                        a7 a7Var = (a7) view;
                        a7Var.setExposurePlay(true);
                        try {
                            LogVlion.e("VlionVideoViewBaseGroup  startVideo");
                            e1 e1Var = a7Var.f2623f;
                            if (e1Var != null) {
                                e1Var.f();
                            }
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
            }
            try {
                View view2 = this.f2520j;
                if (view2 != null && (view2 instanceof a7)) {
                    a7 a7Var2 = (a7) view2;
                    a7Var2.setExposurePlay(false);
                    try {
                        LogVlion.e("VlionVideoViewBaseGroup  stopVideo ");
                        e1 e1Var2 = a7Var2.f2623f;
                        if (e1Var2 != null) {
                            e1Var2.h();
                        }
                    } catch (Throwable th4) {
                        VlionSDkManager.getInstance().upLoadCatchException(th4);
                    }
                }
            } catch (Throwable th5) {
                VlionSDkManager.getInstance().upLoadCatchException(th5);
            }
        } catch (Throwable th6) {
            VlionSDkManager.getInstance().upLoadCatchException(th6);
        }
    }
}
