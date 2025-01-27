package cn.vlion.ad.inland.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.vlion.ad.inland.base.e1;
import cn.vlion.ad.inland.base.natives.VlionNativeAdData;
import cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener;
import cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener;
import cn.vlion.ad.inland.base.network.ImageCallback;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.data.VlionImageSuccessData;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.List;

/* loaded from: classes.dex */
public final class l5 extends v0 {

    /* renamed from: h */
    public VlionNativesAdVideoListener f3072h;

    /* renamed from: i */
    public VlionNativeAdData f3073i;

    /* renamed from: j */
    public VlionNativesAdVideoListener f3074j;

    /* renamed from: k */
    public String f3075k;

    /* renamed from: l */
    public m5 f3076l;

    /* renamed from: m */
    public a7 f3077m;

    public class a implements ImageCallback {
        public a() {
        }

        @Override // cn.vlion.ad.inland.base.network.ImageCallback
        public final void onFail(VlionAdBaseError vlionAdBaseError) {
            try {
                m5 m5Var = l5.this.f3076l;
                if (m5Var != null) {
                    VlionNativeAdImpMaterialListener.this.onNativeAdRenderFailure(vlionAdBaseError);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.network.ImageCallback
        public final void onSuccess(VlionImageSuccessData vlionImageSuccessData) {
            try {
                m5 m5Var = l5.this.f3076l;
                if (m5Var != null) {
                    VlionNativeAdImpMaterialListener.this.onNativeAdRenderSuccess();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements e1.j {

        /* renamed from: a */
        public final /* synthetic */ String f3079a;

        /* renamed from: b */
        public final /* synthetic */ boolean f3080b;

        /* renamed from: c */
        public final /* synthetic */ boolean f3081c;

        public class a implements VlionNativesAdVideoListener {
            public a() {
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
            public final void onAdVideoPlayError(String str) {
                try {
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = l5.this.f3072h;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onAdVideoPlayError(str);
                    }
                    VlionNativesAdVideoListener vlionNativesAdVideoListener2 = l5.this.f3074j;
                    if (vlionNativesAdVideoListener2 != null) {
                        vlionNativesAdVideoListener2.onAdVideoPlayError(str);
                    }
                    m5 m5Var = l5.this.f3076l;
                    if (m5Var != null) {
                        VlionNativeAdImpMaterialListener.this.onNativeAdRenderFailure(new VlionAdBaseError(VlionAdBaseError.AD_VIDEO_LOAD_ERROR_CODE, str));
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
            public final void onProgressUpdate(int i10, int i11) {
                try {
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = l5.this.f3072h;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onProgressUpdate(i10, i11);
                    }
                    VlionNativesAdVideoListener vlionNativesAdVideoListener2 = l5.this.f3074j;
                    if (vlionNativesAdVideoListener2 != null) {
                        vlionNativesAdVideoListener2.onProgressUpdate(i10, i11);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
            public final void onVideoAdComplete() {
                try {
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = l5.this.f3072h;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onVideoAdComplete();
                    }
                    VlionNativesAdVideoListener vlionNativesAdVideoListener2 = l5.this.f3074j;
                    if (vlionNativesAdVideoListener2 != null) {
                        vlionNativesAdVideoListener2.onVideoAdComplete();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
            public final void onVideoAdContinuePlay() {
                try {
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = l5.this.f3072h;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onVideoAdContinuePlay();
                    }
                    VlionNativesAdVideoListener vlionNativesAdVideoListener2 = l5.this.f3074j;
                    if (vlionNativesAdVideoListener2 != null) {
                        vlionNativesAdVideoListener2.onVideoAdContinuePlay();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
            public final void onVideoAdPaused() {
                try {
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = l5.this.f3072h;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onVideoAdPaused();
                    }
                    VlionNativesAdVideoListener vlionNativesAdVideoListener2 = l5.this.f3074j;
                    if (vlionNativesAdVideoListener2 != null) {
                        vlionNativesAdVideoListener2.onVideoAdPaused();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
            public final void onVideoAdStartPlay() {
                try {
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = l5.this.f3072h;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onVideoAdStartPlay();
                    }
                    VlionNativesAdVideoListener vlionNativesAdVideoListener2 = l5.this.f3074j;
                    if (vlionNativesAdVideoListener2 != null) {
                        vlionNativesAdVideoListener2.onVideoAdStartPlay();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
            public final void onVideoError(int i10, int i11) {
                try {
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = l5.this.f3072h;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onVideoError(i10, i11);
                    }
                    VlionNativesAdVideoListener vlionNativesAdVideoListener2 = l5.this.f3074j;
                    if (vlionNativesAdVideoListener2 != null) {
                        vlionNativesAdVideoListener2.onVideoError(i10, i11);
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }

            @Override // cn.vlion.ad.inland.base.natives.VlionNativesAdVideoListener
            public final void onVideoLoad() {
                try {
                    VlionNativesAdVideoListener vlionNativesAdVideoListener = l5.this.f3072h;
                    if (vlionNativesAdVideoListener != null) {
                        vlionNativesAdVideoListener.onVideoLoad();
                    }
                    VlionNativesAdVideoListener vlionNativesAdVideoListener2 = l5.this.f3074j;
                    if (vlionNativesAdVideoListener2 != null) {
                        vlionNativesAdVideoListener2.onVideoLoad();
                    }
                    m5 m5Var = l5.this.f3076l;
                    if (m5Var != null) {
                        VlionNativeAdImpMaterialListener.this.onNativeAdRenderSuccess();
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public b(String str, boolean z10, boolean z11) {
            this.f3079a = str;
            this.f3080b = z10;
            this.f3081c = z11;
        }

        @Override // cn.vlion.ad.inland.base.e1.j
        public final void a() {
            try {
                LogVlion.e("VlionNativesContainerLayout - -新建  =- ");
                l5 l5Var = l5.this;
                l5Var.f3077m.a(l5Var.f3075k, this.f3079a);
                l5 l5Var2 = l5.this;
                l5Var2.f3077m.setVideoScaleMode(l5Var2.f3073i.getVideoScale());
                l5.this.f3077m.setAutoPlay(this.f3080b);
                l5.this.f3077m.setLoop(this.f3081c);
                l5 l5Var3 = l5.this;
                l5Var3.f3077m.setClosedVolumePlay(l5Var3.f3073i.isClosedVolume());
                l5.this.f3077m.setVlionNativesAdVideoListener(new a());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public l5(Context context) {
        super(context, null);
    }

    public final void a(VlionNativeAdData vlionNativeAdData) {
        try {
            if (getContext() != null && vlionNativeAdData != null) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.vlion_base_native_layout, (ViewGroup) null, true);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.img_1);
                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.img_2);
                ImageView imageView3 = (ImageView) inflate.findViewById(R.id.img_3);
                imageView.setScaleType(vlionNativeAdData.getImageScale());
                imageView2.setScaleType(vlionNativeAdData.getImageScale());
                imageView3.setScaleType(vlionNativeAdData.getImageScale());
                List<String> imgList = vlionNativeAdData.getImgList();
                if (imgList != null) {
                    if (imgList.size() > 0) {
                        a(imageView, imgList.get(0));
                    }
                    if (imgList.size() > 1) {
                        a(imageView2, imgList.get(1));
                    }
                    if (imgList.size() > 2) {
                        a(imageView3, imgList.get(2));
                    }
                }
                try {
                    removeAllViews();
                    addView(inflate, new FrameLayout.LayoutParams(-1, -1));
                } catch (Exception e10) {
                    VlionSDkManager.getInstance().upLoadCatchException(e10);
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void b(VlionNativeAdData vlionNativeAdData) {
        try {
            if (getContext() == null || vlionNativeAdData == null || vlionNativeAdData.getImgList() == null || vlionNativeAdData.getImgList().size() <= 0) {
                return;
            }
            for (int i10 = 0; i10 < vlionNativeAdData.getImgList().size(); i10++) {
                if (i10 == 0) {
                    x0 x0Var = new x0(getContext());
                    x0Var.setScaleType(vlionNativeAdData.getImageScale());
                    a(x0Var, vlionNativeAdData.getImgList().get(0));
                    try {
                        removeAllViews();
                        addView(x0Var, new FrameLayout.LayoutParams(-1, -1));
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:2:0x0000, B:4:0x0006, B:9:0x000c, B:13:0x0033, B:16:0x003e, B:18:0x0042, B:21:0x0051, B:23:0x005f, B:24:0x0062, B:26:0x0074, B:27:0x008f, B:30:0x007c, B:32:0x0087, B:35:0x0026), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007c A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:2:0x0000, B:4:0x0006, B:9:0x000c, B:13:0x0033, B:16:0x003e, B:18:0x0042, B:21:0x0051, B:23:0x005f, B:24:0x0062, B:26:0x0074, B:27:0x008f, B:30:0x007c, B:32:0x0087, B:35:0x0026), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c() {
        /*
            r9 = this;
            android.content.Context r0 = r9.getContext()     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto La8
            cn.vlion.ad.inland.base.natives.VlionNativeAdData r0 = r9.f3073i     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto Lc
            goto La8
        Lc:
            java.lang.String r0 = r0.getVideoUrl()     // Catch: java.lang.Throwable -> L30
            r9.f3075k = r0     // Catch: java.lang.Throwable -> L30
            cn.vlion.ad.inland.base.natives.VlionNativeAdData r0 = r9.f3073i     // Catch: java.lang.Throwable -> L30
            java.lang.String r0 = r0.getVideoCover()     // Catch: java.lang.Throwable -> L30
            cn.vlion.ad.inland.base.natives.VlionNativeAdData r1 = r9.f3073i     // Catch: java.lang.Throwable -> L30
            int r1 = r1.getAutoPlay()     // Catch: java.lang.Throwable -> L30
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 != r4) goto L24
            goto L2c
        L24:
            if (r1 != r2) goto L2e
            int r1 = cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil.getConnectionType()     // Catch: java.lang.Throwable -> L30
            if (r2 != r1) goto L2e
        L2c:
            r1 = 1
            goto L33
        L2e:
            r1 = 0
            goto L33
        L30:
            r0 = move-exception
            goto La9
        L33:
            cn.vlion.ad.inland.base.natives.VlionNativeAdData r5 = r9.f3073i     // Catch: java.lang.Throwable -> L30
            int r5 = r5.getIs_circulation()     // Catch: java.lang.Throwable -> L30
            if (r5 != r4) goto L3d
            r5 = 1
            goto L3e
        L3d:
            r5 = 0
        L3e:
            cn.vlion.ad.inland.base.a7 r6 = r9.f3077m     // Catch: java.lang.Throwable -> L30
            if (r6 != 0) goto L7c
            cn.vlion.ad.inland.base.a7 r6 = new cn.vlion.ad.inland.base.a7     // Catch: java.lang.Throwable -> L30
            android.content.Context r7 = r9.getContext()     // Catch: java.lang.Throwable -> L30
            cn.vlion.ad.inland.base.natives.VlionNativeAdData r8 = r9.f3073i     // Catch: java.lang.Throwable -> L30
            int r8 = r8.getPlayMode()     // Catch: java.lang.Throwable -> L30
            if (r8 != r2) goto L51
            r3 = 1
        L51:
            r6.<init>(r7, r3)     // Catch: java.lang.Throwable -> L30
            r9.f3077m = r6     // Catch: java.lang.Throwable -> L30
            cn.vlion.ad.inland.base.l5$b r2 = new cn.vlion.ad.inland.base.l5$b     // Catch: java.lang.Throwable -> L30
            r2.<init>(r0, r1, r5)     // Catch: java.lang.Throwable -> L30
            cn.vlion.ad.inland.base.e1 r0 = r6.f2623f     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L62
            r0.a(r2)     // Catch: java.lang.Throwable -> L30
        L62:
            r9.removeAllViews()     // Catch: java.lang.Throwable -> L30
            cn.vlion.ad.inland.base.a7 r0 = r9.f3077m     // Catch: java.lang.Throwable -> L30
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams     // Catch: java.lang.Throwable -> L30
            r2 = -1
            r1.<init>(r2, r2)     // Catch: java.lang.Throwable -> L30
            r9.addView(r0, r1)     // Catch: java.lang.Throwable -> L30
            cn.vlion.ad.inland.base.m5 r0 = r9.f3076l     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L8f
            cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener$a r0 = (cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener.a) r0     // Catch: java.lang.Throwable -> L30
            cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener r0 = cn.vlion.ad.inland.base.natives.VlionNativeAdImpMaterialListener.this     // Catch: java.lang.Throwable -> L30
            r0.onNativeAdRenderSuccess()     // Catch: java.lang.Throwable -> L30
            goto L8f
        L7c:
            java.lang.String r0 = "VlionNativesContainerLayout ---- 刷新  =- "
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L30
            cn.vlion.ad.inland.base.a7 r0 = r9.f3077m     // Catch: java.lang.Throwable -> L30
            cn.vlion.ad.inland.base.e1 r1 = r0.f2623f     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L8f
            cn.vlion.ad.inland.base.c7 r2 = new cn.vlion.ad.inland.base.c7     // Catch: java.lang.Throwable -> L30
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L30
            r1.a(r2)     // Catch: java.lang.Throwable -> L30
        L8f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30
            r0.<init>()     // Catch: java.lang.Throwable -> L30
            java.lang.String r1 = "VlionNativesContainerLayout -NetWorkTypeUtil.NETWORK =- "
            r0.append(r1)     // Catch: java.lang.Throwable -> L30
            int r1 = cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil.getConnectionType()     // Catch: java.lang.Throwable -> L30
            r0.append(r1)     // Catch: java.lang.Throwable -> L30
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L30
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L30
            goto Lb0
        La8:
            return
        La9:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r1 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r1.upLoadCatchException(r0)
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.l5.c():void");
    }

    @Override // cn.vlion.ad.inland.base.v0, cn.vlion.ad.inland.base.d
    public final void destroy() {
        super.destroy();
        try {
            a7 a7Var = this.f3077m;
            if (a7Var != null) {
                a7Var.destroy();
            }
            removeAllViews();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public VlionNativeAdData getMvlionNativeAdData() {
        return this.f3073i;
    }

    public void setAdVideoListener(VlionNativesAdVideoListener vlionNativesAdVideoListener) {
        LogVlion.e("VlionNativesContainerLayout setAdVideoListener- ");
        if (vlionNativesAdVideoListener == null) {
            LogVlion.e("VlionNativesContainerLayout vlionBaseNativesVideoView null null- ");
        } else {
            this.f3072h = vlionNativesAdVideoListener;
        }
    }

    public void setAdVlionVideoListener(VlionNativesAdVideoListener vlionNativesAdVideoListener) {
        LogVlion.e("VlionNativesContainerLayout setAdVlionVideoListener- ");
        this.f3074j = vlionNativesAdVideoListener;
    }

    public void setClosedVolumePlay(boolean z10) {
        try {
            a7 a7Var = this.f3077m;
            if (a7Var != null) {
                a7Var.setClosedVolumePlay(z10);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0082 -> B:36:0x0091). Please report as a decompilation issue!!! */
    @Override // cn.vlion.ad.inland.base.v0
    public final void a(boolean z10) {
        try {
            super.a(z10);
            LogVlion.e("VlionNativesContainerLayout isResume=" + z10 + " isRectVisible=" + b() + "  ");
            if (z10 && b()) {
                try {
                    a7 a7Var = this.f3077m;
                    if (a7Var != null) {
                        a7Var.setExposurePlay(true);
                        a7 a7Var2 = this.f3077m;
                        a7Var2.getClass();
                        try {
                            LogVlion.e("VlionVideoViewBaseGroup  startVideo");
                            e1 e1Var = a7Var2.f2623f;
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
                return;
            }
            try {
                a7 a7Var3 = this.f3077m;
                if (a7Var3 != null) {
                    a7Var3.setExposurePlay(false);
                    a7 a7Var4 = this.f3077m;
                    a7Var4.getClass();
                    try {
                        LogVlion.e("VlionVideoViewBaseGroup  stopVideo ");
                        e1 e1Var2 = a7Var4.f2623f;
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
            return;
        } catch (Throwable th6) {
            VlionSDkManager.getInstance().upLoadCatchException(th6);
        }
        VlionSDkManager.getInstance().upLoadCatchException(th6);
    }

    public final void a(ImageView imageView, String str) {
        if (str != null) {
            try {
                if (u.b().a(str) != null) {
                    LogVlion.e("VlionNativesContainerLayout loadIamge 缓存图片  ：" + str);
                    imageView.setImageBitmap(u.b().a(str));
                    m5 m5Var = this.f3076l;
                    if (m5Var != null) {
                        VlionNativeAdImpMaterialListener.this.onNativeAdRenderSuccess();
                    }
                } else {
                    LogVlion.e("VlionNativesContainerLayout loadIamge 线上下载-  ：" + str);
                    HttpRequestUtil.downloadBitmapNeedCache(imageView, str, new a());
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }
}
