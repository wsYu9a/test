package cn.vlion.ad.inland.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.reward.VlionRewardVideoActivity;
import cn.vlion.ad.inland.base.b5;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener;
import cn.vlion.ad.inland.base.c5;
import cn.vlion.ad.inland.base.e;
import cn.vlion.ad.inland.base.g1;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.l1;
import cn.vlion.ad.inland.base.util.VlionAdStrategyUtils;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.List;

/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: c */
    public Context f2357c;

    /* renamed from: d */
    public VlionBiddingActionRewardListener f2358d;

    /* renamed from: e */
    public VlionAdapterADConfig f2359e;

    /* renamed from: f */
    public VlionCustomParseAdData f2360f;

    /* renamed from: i */
    public b5 f2363i;

    /* renamed from: k */
    public int f2365k;

    /* renamed from: l */
    public int f2366l;

    /* renamed from: m */
    public VlionBaseParameterReplace f2367m;

    /* renamed from: n */
    public long f2368n;

    /* renamed from: o */
    public long f2369o;

    /* renamed from: g */
    public String f2361g = "";

    /* renamed from: h */
    public boolean f2362h = false;

    /* renamed from: j */
    public boolean f2364j = false;

    public a(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        this.f2357c = context;
        this.f2359e = vlionAdapterADConfig;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0066 A[Catch: all -> 0x006a, TryCatch #1 {all -> 0x006a, blocks: (B:2:0x0000, B:3:0x0034, B:9:0x0055, B:10:0x0056, B:12:0x0066, B:23:0x006d, B:24:0x006e, B:5:0x0035, B:7:0x0039, B:8:0x0043, B:20:0x004e), top: B:1:0x0000, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r3) {
        /*
            r2 = this;
            java.lang.String r3 = r3.getVideoUrl()     // Catch: java.lang.Throwable -> L6a
            r2.f2361g = r3     // Catch: java.lang.Throwable -> L6a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            r3.<init>()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r0 = "downVideo url= "
            r3.append(r0)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r0 = r2.f2361g     // Catch: java.lang.Throwable -> L6a
            r3.append(r0)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L6a
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r3)     // Catch: java.lang.Throwable -> L6a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            r3.<init>()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r0 = "renderAd  下载 url= "
            r3.append(r0)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r0 = r2.f2361g     // Catch: java.lang.Throwable -> L6a
            r3.append(r0)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L6a
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r3)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r3 = r2.f2361g     // Catch: java.lang.Throwable -> L6a
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L6a
            cn.vlion.ad.inland.base.b5 r0 = r2.f2363i     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L43
            cn.vlion.ad.inland.base.b5 r0 = new cn.vlion.ad.inland.base.b5     // Catch: java.lang.Throwable -> L41
            r0.<init>()     // Catch: java.lang.Throwable -> L41
            r2.f2363i = r0     // Catch: java.lang.Throwable -> L41
            goto L43
        L41:
            r3 = move-exception
            goto L4e
        L43:
            cn.vlion.ad.inland.base.b5 r0 = r2.f2363i     // Catch: java.lang.Throwable -> L41
            cn.vlion.ad.inland.base.k4 r1 = new cn.vlion.ad.inland.base.k4     // Catch: java.lang.Throwable -> L41
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L41
            r0.a(r3, r1)     // Catch: java.lang.Throwable -> L41
            goto L55
        L4e:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r0 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L6c
            r0.upLoadCatchException(r3)     // Catch: java.lang.Throwable -> L6c
        L55:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6a
            java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L6a
            r3 = 1
            r2.f2362h = r3     // Catch: java.lang.Throwable -> L6a
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L6a
            r2.f2369o = r0     // Catch: java.lang.Throwable -> L6a
            cn.vlion.ad.inland.base.bid.VlionBiddingActionRewardListener r3 = r2.f2358d     // Catch: java.lang.Throwable -> L6a
            if (r3 == 0) goto L76
            r3.onAdRenderSuccess()     // Catch: java.lang.Throwable -> L6a
            goto L76
        L6a:
            r3 = move-exception
            goto L6f
        L6c:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6a
            throw r3     // Catch: java.lang.Throwable -> L6a
        L6f:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r0 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r0.upLoadCatchException(r3)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.ad.reward.a.a(cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.content.Context] */
    public final void a(Activity activity) {
        Activity activity2;
        StringBuilder a10 = l1.a("show isReadyShow= ");
        a10.append(this.f2362h);
        a10.append(" (null != vlionCustomParseAdData)=");
        a10.append(this.f2360f != null);
        LogVlion.e(a10.toString());
        try {
            if (this.f2362h && this.f2360f != null) {
                if (activity != null) {
                    activity2 = activity;
                } else {
                    ?? r52 = this.f2357c;
                    activity2 = r52 != 0 ? r52 : null;
                }
                if (activity2 != null) {
                    VlionRewardVideoActivity.e.f2356b = this.f2363i;
                    String str = this.f2361g;
                    C0021a c0021a = new C0021a();
                    if (str != null) {
                        try {
                            VlionRewardVideoActivity.e.f2355a.put(str, c0021a);
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                    Intent intent = new Intent(activity2, (Class<?>) VlionRewardVideoActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("VlionVideoPath", this.f2361g);
                    intent.putExtra("VlionAdapterADConfig", this.f2359e);
                    intent.putExtra("VlionCustomParseAdDataString", this.f2360f);
                    activity2.startActivity(intent);
                    this.f2362h = false;
                }
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    /* renamed from: cn.vlion.ad.inland.ad.reward.a$a */
    public class C0021a implements g1 {
        public C0021a() {
        }

        @Override // cn.vlion.ad.inland.base.g1
        public final void a(VlionADClickType vlionADClickType) {
            try {
                VlionAdapterADConfig vlionAdapterADConfig = a.this.f2359e;
                if (vlionAdapterADConfig != null) {
                    vlionAdapterADConfig.setVlionADClickType(vlionADClickType);
                }
                if (!a.this.f2719b) {
                    if (vlionADClickType.getVlionBaseParameterReplace() != null) {
                        if (a.this.f2360f.isVideo()) {
                            VlionBaseParameterReplace vlionBaseParameterReplace = vlionADClickType.getVlionBaseParameterReplace();
                            a aVar = a.this;
                            vlionBaseParameterReplace.handleVideoParameter(aVar.f2364j, aVar.f2365k, aVar.f2366l);
                        }
                        vlionADClickType.getVlionBaseParameterReplace().handleExposureParameter(a.this.f2368n);
                        vlionADClickType.getVlionBaseParameterReplace().handleRenderSuccessParameter(a.this.f2369o);
                    }
                    c5.a(a.this.f2360f, vlionADClickType);
                    if (TextUtils.equals(VlionCustomAdActiveType$VlionCustomTarget.deeplink.toString(), vlionADClickType.getTarget())) {
                        c5.b(a.this.f2360f, vlionADClickType);
                    }
                    a aVar2 = a.this;
                    aVar2.f2719b = true;
                    if (aVar2.f2359e != null && !vlionADClickType.isDefaultAdStrategy()) {
                        VlionAdStrategyUtils.getInstance().setStrategyBean(a.this.f2359e.getAdxTagId());
                    }
                }
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = a.this.f2358d;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdClick();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.g1
        public final void b(int i10) {
            try {
                VlionADEventManager.getParameterSkip(a.this.f2359e, i10);
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = a.this.f2358d;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdVideoSkip();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.g1
        public final void onAdPlayFailure(int i10, String str) {
            try {
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = a.this.f2358d;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdPlayFailure(i10, str);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.g1
        public final void onAdReward() {
            try {
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = a.this.f2358d;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdReward();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.g1
        public final void onAdVideoPlayComplete() {
            try {
                a aVar = a.this;
                aVar.f2364j = true;
                VlionBaseParameterReplace vlionBaseParameterReplace = aVar.f2367m;
                if (vlionBaseParameterReplace != null) {
                    vlionBaseParameterReplace.handleVideoFinishParameter(aVar.f2366l);
                }
                VlionCustomParseAdData vlionCustomParseAdData = a.this.f2360f;
                if (vlionCustomParseAdData != null) {
                    List<String> vm_p_succ = vlionCustomParseAdData.getVideoBean().getVm_p_succ();
                    a aVar2 = a.this;
                    c5.a(vm_p_succ, aVar2.f2367m, aVar2.f2360f);
                }
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = a.this.f2358d;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdVideoPlayComplete();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.g1
        public final void onAdVideoPlaying(int i10, int i11) {
            try {
                a aVar = a.this;
                aVar.f2365k = i10;
                aVar.f2366l = i11;
                LogVlion.e("onAdVideoPlaying current " + i10 + ",total " + i11 + ",VideoParameterReplace " + a.this.f2367m);
                VlionBaseParameterReplace vlionBaseParameterReplace = a.this.f2367m;
                if (vlionBaseParameterReplace != null) {
                    vlionBaseParameterReplace.handleVideoPlayingParameter(i10);
                }
                VlionCustomParseAdData vlionCustomParseAdData = a.this.f2360f;
                if (vlionCustomParseAdData != null) {
                    List<VlionCustomAdData.SeatbidBean.BidBean.VideoBean.VmPTrackingBean> vm_p_tracking = vlionCustomParseAdData.getVideoBean().getVm_p_tracking();
                    a aVar2 = a.this;
                    c5.a(vm_p_tracking, i10, aVar2.f2367m, aVar2.f2360f);
                }
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = a.this.f2358d;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdVideoPlaying(i10, i11);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.g1
        public final void onAdVideoStart() {
            try {
                a aVar = a.this;
                VlionCustomParseAdData vlionCustomParseAdData = aVar.f2360f;
                if (vlionCustomParseAdData != null) {
                    aVar.f2367m = new VlionBaseParameterReplace(vlionCustomParseAdData);
                    a aVar2 = a.this;
                    aVar2.f2367m.handleVideoStartParameter(aVar2.f2364j, aVar2.f2365k, aVar2.f2360f.getDuration(), a.this.f2359e);
                }
                VlionCustomParseAdData vlionCustomParseAdData2 = a.this.f2360f;
                if (vlionCustomParseAdData2 != null) {
                    List<String> vm_p_start = vlionCustomParseAdData2.getVideoBean().getVm_p_start();
                    a aVar3 = a.this;
                    c5.b(vm_p_start, aVar3.f2367m, aVar3.f2360f);
                }
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = a.this.f2358d;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdVideoStart();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.g1
        public final void a(int i10) {
            try {
                VlionAdapterADConfig vlionAdapterADConfig = a.this.f2359e;
                if (vlionAdapterADConfig != null) {
                    vlionAdapterADConfig.setDuration(i10);
                }
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = a.this.f2358d;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdClose();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.g1
        public final void a(View view) {
            try {
                a aVar = a.this;
                if (aVar.f2360f != null && !aVar.f2718a) {
                    aVar.f2368n = System.currentTimeMillis();
                    a aVar2 = a.this;
                    c5.a(aVar2.f2360f, view, aVar2.f2368n, aVar2.f2369o);
                    a.this.f2718a = true;
                }
                VlionBiddingActionRewardListener vlionBiddingActionRewardListener = a.this.f2358d;
                if (vlionBiddingActionRewardListener != null) {
                    vlionBiddingActionRewardListener.onAdExposure();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }
}
