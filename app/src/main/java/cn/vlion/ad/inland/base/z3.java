package cn.vlion.ad.inland.base;

import android.content.Context;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.bid.VlionBiddingLoadListener;
import cn.vlion.ad.inland.base.bid.VlionNativeActionListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.network.HttpCallBack;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class z3 extends e {

    /* renamed from: c */
    public Context f3542c;

    /* renamed from: d */
    public VlionAdapterADConfig f3543d;

    /* renamed from: e */
    public VlionBiddingLoadListener f3544e;

    /* renamed from: f */
    public r6 f3545f = new r6();

    /* renamed from: g */
    public q0 f3546g;

    /* renamed from: h */
    public VlionNativeActionListener f3547h;

    public class a implements HttpCallBack<VlionCustomParseAdData> {
        public a() {
        }

        @Override // cn.vlion.ad.inland.base.network.HttpCallBack
        public final void onFail(VlionAdBaseError vlionAdBaseError) {
            try {
                VlionBiddingLoadListener vlionBiddingLoadListener = z3.this.f3544e;
                if (vlionBiddingLoadListener == null || vlionAdBaseError == null) {
                    return;
                }
                vlionBiddingLoadListener.onAdLoadFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.network.HttpCallBack
        public final void onSuccess(VlionCustomParseAdData vlionCustomParseAdData) {
            VlionCustomParseAdData vlionCustomParseAdData2 = vlionCustomParseAdData;
            try {
                VlionCustomParseAdData parseBid = vlionCustomParseAdData2.parseBid();
                VlionAdapterADConfig vlionAdapterADConfig = z3.this.f3543d;
                if (vlionAdapterADConfig != null) {
                    vlionAdapterADConfig.setDspid(parseBid.getDspid());
                    z3.this.f3543d.setCrid(parseBid.getCrid());
                    z3.this.f3543d.setAd_type(parseBid.isVideo());
                    vlionCustomParseAdData2.setSlotID(z3.this.f3543d.getSlotID());
                }
                LogVlion.e("VlionCustomNativeAdManager onSuccess price=" + vlionCustomParseAdData2.getBidPrice());
                z3.a(z3.this, parseBid);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public z3(Context context, VlionAdapterADConfig vlionAdapterADConfig) {
        this.f3542c = context;
        this.f3543d = vlionAdapterADConfig;
    }

    public final void a() {
        try {
            LogVlion.e("VlionCustomNativeAdManager loadData=");
            if (this.f3543d == null) {
                return;
            }
            LogVlion.e("VlionCustomNativeAdManager vlionAdapterADConfig.getAdType()=" + this.f3543d.getAdType());
            f4.a(this.f3543d.getAdType(), this.f3543d, new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x026b A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #2 {all -> 0x00c6, blocks: (B:4:0x0007, B:6:0x001b, B:9:0x005b, B:12:0x007a, B:14:0x0080, B:16:0x0086, B:18:0x008c, B:19:0x0098, B:21:0x009e, B:24:0x00a6, B:27:0x00b0, B:33:0x00c9, B:35:0x00d3, B:38:0x00ee, B:41:0x0109, B:44:0x0124, B:47:0x011d, B:50:0x0102, B:53:0x00e7, B:54:0x0127, B:55:0x012b, B:57:0x0136, B:59:0x0140, B:61:0x0167, B:66:0x0178, B:67:0x017f, B:68:0x0185, B:70:0x018b, B:72:0x0195, B:73:0x01c7, B:75:0x01df, B:80:0x01f0, B:82:0x01f7, B:85:0x0258, B:86:0x025b, B:88:0x026b, B:93:0x020b, B:95:0x0211, B:97:0x0225, B:40:0x00f8, B:37:0x00dd, B:63:0x016e, B:43:0x0113, B:77:0x01e6), top: B:3:0x0007, inners: #0, #1, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(cn.vlion.ad.inland.base.z3 r11, cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData r12) {
        /*
            Method dump skipped, instructions count: 631
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.z3.a(cn.vlion.ad.inland.base.z3, cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData):void");
    }
}
