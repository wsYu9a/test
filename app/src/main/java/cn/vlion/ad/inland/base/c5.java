package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionNetRespType;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.timer.VlionTimer;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class c5 {

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ VlionCustomParseAdData f2683a;

        /* renamed from: b */
        public final /* synthetic */ View f2684b;

        /* renamed from: c */
        public final /* synthetic */ long f2685c;

        /* renamed from: d */
        public final /* synthetic */ long f2686d;

        public a(VlionCustomParseAdData vlionCustomParseAdData, View view, long j10, long j11) {
            this.f2683a = vlionCustomParseAdData;
            this.f2684b = view;
            this.f2685c = j10;
            this.f2686d = j11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                VlionBaseParameterReplace vlionBaseParameterReplace = new VlionBaseParameterReplace(this.f2683a);
                vlionBaseParameterReplace.handleBaseParameter(this.f2684b);
                vlionBaseParameterReplace.handleExposureParameter(this.f2685c);
                vlionBaseParameterReplace.handleRenderSuccessParameter(this.f2686d);
                List<String> imptrackers = this.f2683a.getBidBean().getImptrackers();
                String a10 = c5.a(this.f2683a, VlionNetRespType.api_imp);
                long bidPrice = this.f2683a.getBidPrice();
                boolean isSingleBid = this.f2683a.isSingleBid();
                LogVlion.e("VlionEventAction submitImp isSingleBid=" + isSingleBid);
                if (imptrackers == null || imptrackers.size() <= 0) {
                    return;
                }
                for (int i10 = 0; i10 < imptrackers.size(); i10++) {
                    String handleReplace = vlionBaseParameterReplace.handleReplace(c5.a(imptrackers.get(i10), isSingleBid ? bidPrice - 1 : bidPrice));
                    LogVlion.e("VlionEventAction submitImp i=" + i10 + " url: " + handleReplace + ",impHeader=" + a10);
                    HttpRequestUtil.submitBehavior(handleReplace, VlionNetRespType.api_imp, a10);
                }
            } catch (Throwable th2) {
                LogVlion.e("submitImp Exception=" + th2);
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ VlionCustomParseAdData f2687a;

        /* renamed from: b */
        public final /* synthetic */ VlionADClickType f2688b;

        public b(VlionCustomParseAdData vlionCustomParseAdData, VlionADClickType vlionADClickType) {
            this.f2687a = vlionCustomParseAdData;
            this.f2688b = vlionADClickType;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                List<String> clicktrackers = this.f2687a.getBidBean().getClicktrackers();
                String a10 = c5.a(this.f2687a, VlionNetRespType.adx_click);
                long bidPrice = this.f2687a.getBidPrice();
                boolean isSingleBid = this.f2687a.isSingleBid();
                LogVlion.e("VlionEventAction submitClick isSingleBid=" + isSingleBid);
                if (clicktrackers == null || clicktrackers.size() <= 0) {
                    return;
                }
                for (int i10 = 0; i10 < clicktrackers.size(); i10++) {
                    String a11 = c5.a(clicktrackers.get(i10), isSingleBid ? bidPrice - 1 : bidPrice);
                    VlionADClickType vlionADClickType = this.f2688b;
                    if (vlionADClickType != null && vlionADClickType.getVlionBaseParameterReplace() != null) {
                        a11 = this.f2688b.getVlionBaseParameterReplace().handleReplace(a11);
                    }
                    LogVlion.e("VlionEventAction submitClick i=" + i10 + " url: " + a11);
                    HttpRequestUtil.submitBehavior(a11, VlionNetRespType.adx_click, a10);
                }
            } catch (Throwable th2) {
                LogVlion.e("submitClick Exception=" + th2);
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ VlionCustomParseAdData f2689a;

        /* renamed from: b */
        public final /* synthetic */ VlionADClickType f2690b;

        public c(VlionCustomParseAdData vlionCustomParseAdData, VlionADClickType vlionADClickType) {
            this.f2689a = vlionCustomParseAdData;
            this.f2690b = vlionADClickType;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                List<String> dp_tracking = this.f2689a.getBidBean().getDp_tracking();
                String a10 = c5.a(this.f2689a, VlionNetRespType.adx_dp_tracking);
                long bidPrice = this.f2689a.getBidPrice();
                boolean isSingleBid = this.f2689a.isSingleBid();
                LogVlion.e("VlionEventAction submitClickDpTacking isSingleBid=" + isSingleBid);
                if (dp_tracking == null || dp_tracking.size() <= 0) {
                    return;
                }
                for (int i10 = 0; i10 < dp_tracking.size(); i10++) {
                    String a11 = c5.a(dp_tracking.get(i10), isSingleBid ? bidPrice - 1 : bidPrice);
                    VlionADClickType vlionADClickType = this.f2690b;
                    if (vlionADClickType != null && vlionADClickType.getVlionBaseParameterReplace() != null) {
                        a11 = this.f2690b.getVlionBaseParameterReplace().handleReplace(a11);
                    }
                    LogVlion.e("VlionEventAction submitClickDpTacking i=" + i10 + " url: " + a11);
                    HttpRequestUtil.submitBehavior(a11, VlionNetRespType.adx_dp_tracking, a10);
                }
            } catch (Throwable th2) {
                LogVlion.e("submitClickDpTacking Exception=" + th2);
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public static String a(VlionCustomParseAdData vlionCustomParseAdData, String str) {
        Gson gson;
        List<VlionCustomAdData.SeatbidBean.BidBean.HeadInfoBean.Headerbean> download_ldp;
        if (vlionCustomParseAdData != null) {
            try {
                if (vlionCustomParseAdData.getBidBean() != null && vlionCustomParseAdData.getBidBean().getHead_info() != null) {
                    if (str.equals(VlionNetRespType.api_imp)) {
                        if (vlionCustomParseAdData.getBidBean().getHead_info().getImp() != null) {
                            gson = new Gson();
                            download_ldp = vlionCustomParseAdData.getBidBean().getHead_info().getImp();
                        }
                    } else if (str.equals(VlionNetRespType.adx_click)) {
                        if (vlionCustomParseAdData.getBidBean().getHead_info().getClick() != null) {
                            gson = new Gson();
                            download_ldp = vlionCustomParseAdData.getBidBean().getHead_info().getClick();
                        }
                    } else if (str.equals(VlionNetRespType.adx_dp_tracking)) {
                        if (vlionCustomParseAdData.getBidBean().getHead_info().getConv() != null) {
                            gson = new Gson();
                            download_ldp = vlionCustomParseAdData.getBidBean().getHead_info().getConv();
                        }
                    } else if (str.equals(VlionNetRespType.adx_video_start)) {
                        if (vlionCustomParseAdData.getBidBean().getHead_info().getConv() != null) {
                            gson = new Gson();
                            download_ldp = vlionCustomParseAdData.getBidBean().getHead_info().getConv();
                        }
                    } else if (str.equals(VlionNetRespType.adx_video_playing)) {
                        if (vlionCustomParseAdData.getBidBean().getHead_info().getConv() != null) {
                            gson = new Gson();
                            download_ldp = vlionCustomParseAdData.getBidBean().getHead_info().getConv();
                        }
                    } else if (str.equals(VlionNetRespType.adx_video_finish)) {
                        if (vlionCustomParseAdData.getBidBean().getHead_info().getConv() != null) {
                            gson = new Gson();
                            download_ldp = vlionCustomParseAdData.getBidBean().getHead_info().getConv();
                        }
                    } else if (str.equals(VlionNetRespType.adx_download_start)) {
                        if (vlionCustomParseAdData.getBidBean().getHead_info().getDownload_url() != null) {
                            gson = new Gson();
                            download_ldp = vlionCustomParseAdData.getBidBean().getHead_info().getDownload_url();
                        }
                    } else if (str.equals(VlionNetRespType.adx_download_complete)) {
                        if (vlionCustomParseAdData.getBidBean().getHead_info().getConv() != null) {
                            gson = new Gson();
                            download_ldp = vlionCustomParseAdData.getBidBean().getHead_info().getConv();
                        }
                    } else if (str.equals(VlionNetRespType.adx_install_start)) {
                        if (vlionCustomParseAdData.getBidBean().getHead_info().getConv() != null) {
                            gson = new Gson();
                            download_ldp = vlionCustomParseAdData.getBidBean().getHead_info().getConv();
                        }
                    } else if (str.equals(VlionNetRespType.adx_install_complete)) {
                        if (vlionCustomParseAdData.getBidBean().getHead_info().getConv() != null) {
                            gson = new Gson();
                            download_ldp = vlionCustomParseAdData.getBidBean().getHead_info().getConv();
                        }
                    } else if (str.equals(VlionNetRespType.adx_active_complete) && vlionCustomParseAdData.getBidBean().getHead_info().getDownload_ldp() != null) {
                        gson = new Gson();
                        download_ldp = vlionCustomParseAdData.getBidBean().getHead_info().getDownload_ldp();
                    }
                    return gson.toJson(download_ldp);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        return "";
    }

    public static void b(VlionCustomParseAdData vlionCustomParseAdData, VlionADClickType vlionADClickType) {
        try {
            if (vlionCustomParseAdData == null) {
                LogVlion.e("VlionEventAction submitClickDpTacking  vlionCustomParseAdData is null");
            } else {
                VlionTimer.getInstance().startTimer(0L, new c(vlionCustomParseAdData, vlionADClickType));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void c(ArrayList<String> arrayList, String str, VlionBaseParameterReplace vlionBaseParameterReplace) {
        if (arrayList != null) {
            try {
                if (arrayList.size() == 0) {
                    return;
                }
                LogVlion.e("VlionEventAction submitInstallComplete");
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    String str2 = arrayList.get(i10);
                    if (vlionBaseParameterReplace != null) {
                        str2 = vlionBaseParameterReplace.handleReplace(str2);
                    }
                    LogVlion.e("VlionEventAction submitClick i=" + i10 + " url: " + str2);
                    HttpRequestUtil.submitBehavior(arrayList, VlionNetRespType.adx_install_complete, str);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public static void d(ArrayList<String> arrayList, String str, VlionBaseParameterReplace vlionBaseParameterReplace) {
        try {
            LogVlion.e("VlionEventAction submitInstallStart tracking=" + arrayList.size());
            if (arrayList.size() == 0) {
                return;
            }
            LogVlion.e("VlionEventAction submitInstallStart tracking.size()=" + arrayList.size());
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                String str2 = arrayList.get(i10);
                if (vlionBaseParameterReplace != null) {
                    str2 = vlionBaseParameterReplace.handleReplace(str2);
                }
                LogVlion.e("VlionEventAction submitClick i=" + i10 + " url: " + str2);
                HttpRequestUtil.submitBehavior(str2, VlionNetRespType.adx_install_start, str);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static String a(String str, long j10) {
        if (str == null) {
            return "";
        }
        try {
            String replace = str.replace("${AUCTION_PRICE}", String.valueOf(j10));
            LogVlion.e("VlionCoreEventAction replaceResult:" + replace);
            return replace;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public static void b(ArrayList<String> arrayList, String str, VlionBaseParameterReplace vlionBaseParameterReplace) {
        try {
            LogVlion.e("VlionEventAction submitDownloadStart");
            if (arrayList != null && arrayList.size() != 0) {
                LogVlion.e("VlionEventAction submitDownloadStart tracking.size()=" + arrayList.size());
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    String str2 = arrayList.get(i10);
                    if (vlionBaseParameterReplace != null) {
                        str2 = vlionBaseParameterReplace.handleReplace(str2);
                    }
                    LogVlion.e("VlionEventAction submitClick i=" + i10 + " url: " + str2);
                    HttpRequestUtil.submitBehavior(arrayList, VlionNetRespType.adx_download_start, str);
                }
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(VlionCustomParseAdData vlionCustomParseAdData, View view, long j10, long j11) {
        try {
            if (vlionCustomParseAdData == null) {
                LogVlion.e("VlionEventAction  submitImp vlionCustomParseAdData is null");
            } else {
                VlionTimer.getInstance().startTimer(0L, new a(vlionCustomParseAdData, view, j10, j11));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void b(List<String> list, VlionBaseParameterReplace vlionBaseParameterReplace, VlionCustomParseAdData vlionCustomParseAdData) {
        try {
            LogVlion.e("VlionEventAction submitVideoStart");
            if (vlionBaseParameterReplace != null && list != null) {
                try {
                    if (list.size() > 0) {
                        for (String str : list) {
                            LogVlion.e("VlionEventAction url" + str);
                            vlionBaseParameterReplace.handleReplace(str);
                        }
                    }
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
            String str2 = "";
            if (vlionCustomParseAdData != null && vlionCustomParseAdData.getBidBean() != null && vlionCustomParseAdData.getBidBean().getHead_info() != null && vlionCustomParseAdData.getBidBean().getHead_info().getConv() != null) {
                str2 = new Gson().toJson(vlionCustomParseAdData.getBidBean().getHead_info().getClick());
            }
            HttpRequestUtil.submitBehavior(list, VlionNetRespType.adx_video_start, str2);
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public static void a(VlionCustomParseAdData vlionCustomParseAdData, VlionADClickType vlionADClickType) {
        try {
            if (vlionCustomParseAdData == null) {
                LogVlion.e("VlionEventAction submitClick  vlionCustomParseAdData is null");
            } else {
                VlionTimer.getInstance().startTimer(0L, new b(vlionCustomParseAdData, vlionADClickType));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(ArrayList<String> arrayList, String str, VlionBaseParameterReplace vlionBaseParameterReplace) {
        if (arrayList != null) {
            try {
                if (arrayList.size() == 0) {
                    return;
                }
                LogVlion.e("VlionEventAction submitDownloadComplete");
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    String str2 = arrayList.get(i10);
                    if (vlionBaseParameterReplace != null) {
                        str2 = vlionBaseParameterReplace.handleReplace(str2);
                    }
                    LogVlion.e("VlionEventAction submitClick i=" + i10 + " url: " + str2);
                    HttpRequestUtil.submitBehavior(arrayList, VlionNetRespType.adx_download_complete, str);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public static void a(List<VlionCustomAdData.SeatbidBean.BidBean.VideoBean.VmPTrackingBean> list, int i10, VlionBaseParameterReplace vlionBaseParameterReplace, VlionCustomParseAdData vlionCustomParseAdData) {
        LogVlion.e("VlionEventAction submitVideoPlayingSec  " + i10);
        try {
            String a10 = a(vlionCustomParseAdData, VlionNetRespType.adx_video_playing);
            if (list == null || list.size() <= 0) {
                return;
            }
            for (int i11 = 0; i11 < list.size(); i11++) {
                VlionCustomAdData.SeatbidBean.BidBean.VideoBean.VmPTrackingBean vmPTrackingBean = list.get(i11);
                if (vmPTrackingBean != null && vmPTrackingBean.getPlay_sec() == i10) {
                    LogVlion.e("VlionEventAction submitVideoPlayingSec getPlay_sec=" + i10);
                    if (vlionBaseParameterReplace != null) {
                        try {
                            if (vmPTrackingBean.getList() != null && vmPTrackingBean.getList().size() > 0) {
                                Iterator<String> it = vmPTrackingBean.getList().iterator();
                                while (it.hasNext()) {
                                    vlionBaseParameterReplace.handleReplace(it.next());
                                }
                            }
                        } catch (Throwable th2) {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        }
                    }
                    HttpRequestUtil.submitBehavior(vmPTrackingBean.getList(), VlionNetRespType.adx_video_playing, a10);
                }
            }
        } catch (Throwable th3) {
            LogVlion.e("submitVideoPlayingSec Exception=" + th3);
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public static void a(List<String> list, VlionBaseParameterReplace vlionBaseParameterReplace, VlionCustomParseAdData vlionCustomParseAdData) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                if (vlionBaseParameterReplace != null) {
                    try {
                        if (list.size() > 0) {
                            Iterator<String> it = list.iterator();
                            while (it.hasNext()) {
                                vlionBaseParameterReplace.handleReplace(it.next());
                            }
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }
                LogVlion.e("VlionEventAction submitVideoFinish tracking.size()=" + list.size());
                HttpRequestUtil.submitBehavior(list, VlionNetRespType.adx_video_finish, a(vlionCustomParseAdData, VlionNetRespType.adx_video_finish));
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        }
    }
}
