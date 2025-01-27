package cn.vlion.ad.inland.base;

import android.app.Application;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossReason;
import cn.vlion.ad.inland.base.event.VlionAdEventType;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionADNetBodyParameter;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionDAClkBodyParameter;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.app.VlionAppInfo;
import cn.vlion.ad.inland.base.util.device.VlionDeviceInfo;
import cn.vlion.ad.inland.base.util.event.VlionADEventDownParam;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.baidu.mobads.sdk.internal.bm;
import com.shu.priory.config.AdKeys;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class y0 {
    public static JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            Application application = VlionSDkManager.getInstance().getApplication();
            VlionDeviceInfo vlionDeviceInfo = VlionDeviceInfo.getInstance();
            jSONObject.put("connection_type", vlionDeviceInfo.getConnectionType(application));
            double[] location = vlionDeviceInfo.getLocation(application);
            if (location != null && location.length > 1) {
                jSONObject.put(com.umeng.analytics.pro.f.C, location[0]);
                jSONObject.put("long", location[1]);
            }
            jSONObject.put("aid", vlionDeviceInfo.getAndroidId(application));
            jSONObject.put("imei", vlionDeviceInfo.getImei(application));
            jSONObject.put(AdKeys.OAID, vlionDeviceInfo.getOaid());
            if (j5.f2992f == null) {
                synchronized (j5.class) {
                    try {
                        if (j5.f2992f == null) {
                            j5.f2992f = new j5();
                        }
                    } finally {
                    }
                }
            }
            jSONObject.put("foreback", j5.f2992f.f2993a);
            jSONObject.put("sdkv", VlionSDkManager.getInstance().getSdkVersionName());
            jSONObject.put(bt.f23628x, vlionDeviceInfo.getOs());
            jSONObject.put("osv", vlionDeviceInfo.getOsv());
            jSONObject.put("app_id", VlionSDkManager.getInstance().getAppId());
            jSONObject.put("uid", VlionServiceConfigParse.getInstance().getUuid());
            jSONObject.put("ad_source", VlionSDkManager.getInstance().getPlatformList());
            jSONObject.put(bt.P, vlionDeviceInfo.getCarrier(application));
            jSONObject.put("appv", VlionAppInfo.getInstance().getVersionName(application));
            String current = VlionServiceConfigParse.getInstance().getCurrent();
            String trace = VlionServiceConfigParse.getInstance().getTrace();
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("sid", str);
            jSONObject.put(SocialConstants.PARAM_ACT, str2);
            jSONObject.put("stime", current);
            jSONObject.put("trace", trace);
        } catch (Throwable th2) {
            p.a(th2, "VlionBaseParameter ====getParameterBaseAdVlion 请求参数=====Exception=", th2);
        }
        return jSONObject;
    }

    public static String b(String str, VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam) {
        JSONObject a10;
        String str2 = "";
        if (vlionAdapterADConfig != null && vlionADEventDownParam != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_DW_INSTALLED, vlionAdapterADConfig, vlionADEventDownParam);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdDownInstall 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            str2 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdDownInstall 请求参数=====", str2);
        }
        return str2;
    }

    public static String c(String str, VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam) {
        JSONObject a10;
        String str2 = "";
        if (vlionAdapterADConfig != null && vlionADEventDownParam != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_DW_START, vlionAdapterADConfig, vlionADEventDownParam);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdDownStart 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            str2 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdDownStart 请求参数=====", str2);
        }
        return str2;
    }

    public static String b(String str, VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam, int i10) {
        JSONObject a10;
        String str2 = "";
        if (vlionAdapterADConfig != null && vlionADEventDownParam != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_DW_PROGRESS, vlionAdapterADConfig, vlionADEventDownParam);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdDownProgress 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            a10.put("progress", i10);
            str2 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdDownProgress 请求参数=====", str2);
        }
        return str2;
    }

    public static JSONObject a(String str, String str2, VlionAdapterADConfig vlionAdapterADConfig) {
        JSONObject jSONObject = null;
        if (vlionAdapterADConfig == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            LogVlion.e("VlionBaseParameter ====getParameterAdVlion sid is empty");
            return null;
        }
        try {
            String trace = vlionAdapterADConfig.getTrace();
            String showId = vlionAdapterADConfig.getShowId();
            String template = vlionAdapterADConfig.getTemplate();
            String ad_type = vlionAdapterADConfig.getAd_type();
            String dspid = vlionAdapterADConfig.getDspid();
            String crid = vlionAdapterADConfig.getCrid();
            String showTrace = vlionAdapterADConfig.getShowTrace();
            long longValue = vlionAdapterADConfig.getAgg().longValue();
            String slotID = vlionAdapterADConfig.getSlotID();
            String platform = vlionAdapterADConfig.getPlatform();
            String account = vlionAdapterADConfig.getAccount();
            jSONObject = a(str, str2);
            jSONObject.put("ad_trace", trace);
            jSONObject.put("show_trace", showTrace);
            jSONObject.put("crid", crid);
            jSONObject.put("slot_id", showId);
            jSONObject.put("agg_id", longValue);
            jSONObject.put("platform", platform);
            jSONObject.put("account", account);
            jSONObject.put("tag_id", slotID);
            jSONObject.put("template", template);
            jSONObject.put("ad_type", ad_type);
            jSONObject.put("dsp_id", dspid);
        } catch (Throwable th2) {
            p.a(th2, "VlionBaseParameter ====getParameterAdVlion 请求参数=====Exception=", th2);
        }
        LogVlion.e("VlionBaseParameter ====getParameterAdVlion 请求参数=====");
        return jSONObject;
    }

    public static JSONObject a(String str, String str2, VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam) {
        JSONObject jSONObject = null;
        if (vlionAdapterADConfig == null) {
            return null;
        }
        try {
            jSONObject = a(str, str2, vlionAdapterADConfig);
        } catch (Throwable th2) {
            p.a(th2, "VlionBaseParameter ====getParameterAdDownBase 请求参数=====Exception=", th2);
        }
        if (jSONObject == null) {
            return jSONObject;
        }
        if (vlionADEventDownParam != null) {
            jSONObject.put("pkg_path", vlionADEventDownParam.getPkg_path());
            jSONObject.put("pkg", vlionADEventDownParam.getPkg());
            jSONObject.put("size", vlionADEventDownParam.getSize());
        }
        LogVlion.e("VlionBaseParameter ====getParameterAdDownBase 请求参数=====");
        return jSONObject;
    }

    public static String b(VlionAdapterADConfig vlionAdapterADConfig, String str, int i10) {
        JSONObject a10;
        String str2 = "";
        if (i10 > 0 && vlionAdapterADConfig != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_AD_SKIP, vlionAdapterADConfig);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdVlionSkip 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            a10.put("skip", i10);
            str2 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdVlionSkip 请求参数=====", str2);
        }
        return str2;
    }

    public static String a(String str, VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam) {
        JSONObject a10;
        String str2 = "";
        if (vlionAdapterADConfig != null && vlionADEventDownParam != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_DW_COMPLETE, vlionAdapterADConfig, vlionADEventDownParam);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdDownComplete 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            str2 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdDownComplete 请求参数=====", str2);
        }
        return str2;
    }

    public static String b(String str, VlionAdapterADConfig vlionAdapterADConfig) {
        JSONObject a10;
        String str2 = "";
        if (vlionAdapterADConfig != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_AD_TRIGGER, vlionAdapterADConfig);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdVlionTrigger 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            str2 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdVlionTrigger 请求参数=====", str2);
            return str2;
        }
        return "";
    }

    public static String a(String str, VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam, boolean z10) {
        JSONObject a10;
        String str2 = "";
        if (vlionAdapterADConfig != null && vlionADEventDownParam != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_DW_INSTALL, vlionAdapterADConfig, vlionADEventDownParam);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdDownInstall 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            a10.put("type", z10 ? DebugKt.DEBUG_PROPERTY_VALUE_AUTO : "manual");
            str2 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdDownInstall 请求参数=====", str2);
        }
        return str2;
    }

    public static String b() {
        String start;
        String str = "";
        try {
            start = VlionServiceConfigParse.getInstance().getEventsBean().getStart();
        } catch (Throwable th2) {
            p.a(th2, "VlionBaseParameter ====getParameterStart 请求参数=====Exception=", th2);
        }
        if (TextUtils.isEmpty(start)) {
            LogVlion.e("VlionBaseParameter ====getParameterStart sid is empty");
            return "";
        }
        str = a(start, "start").toString();
        y.a("VlionBaseParameter ====getParameterStart 请求参数=====", str);
        return str;
    }

    public static String a(String str, VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam, int i10) {
        JSONObject a10;
        String str2 = "";
        if (vlionAdapterADConfig != null && vlionADEventDownParam != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_DW_PAUSE, vlionAdapterADConfig, vlionADEventDownParam);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdDownPause 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            a10.put("progress", i10);
            str2 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdDownPause 请求参数=====", str2);
        }
        return str2;
    }

    public static String a(String str, VlionAdapterADConfig vlionAdapterADConfig, VlionADEventDownParam vlionADEventDownParam, int i10, double d10, long j10) {
        JSONObject a10;
        String str2 = "";
        if (vlionAdapterADConfig != null && vlionADEventDownParam != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_DW_STORAGE, vlionAdapterADConfig, vlionADEventDownParam);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdDownStorage 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            a10.put(c7.g.f1744b, i10);
            a10.put("allsize", d10);
            a10.put("surplus", j10);
            str2 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdDownStorage 请求参数=====", str2);
        }
        return str2;
    }

    public static String a(String str, VlionAdapterADConfig vlionAdapterADConfig, double d10, double d11, VlionBidderSource vlionBidderSource, VlionLossReason vlionLossReason) {
        JSONObject a10;
        String str2 = "";
        if (vlionAdapterADConfig != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_AD_BID, vlionAdapterADConfig);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdVlionBid 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            a10.put("price", d10);
            a10.put("s_price", d11);
            a10.put(p3.i.f29758c, "0");
            if (vlionBidderSource != null) {
                a10.put("bidder_source", vlionBidderSource.getValue());
            }
            if (vlionLossReason != null) {
                a10.put("loss_reason", vlionLossReason.getValue());
            }
            str2 = a10.toString();
            y.a("VlionBaseParameter ==== 请求参数=====", str2);
            return str2;
        }
        return "";
    }

    public static String a(String str, VlionAdapterADConfig vlionAdapterADConfig, double d10, double d11, double d12, VlionBidderSource vlionBidderSource) {
        JSONObject a10;
        String str2 = "";
        if (vlionAdapterADConfig != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_AD_BID, vlionAdapterADConfig);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdVlionBid 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            a10.put("price", d10);
            a10.put("s_price", d11);
            a10.put(p3.i.f29758c, "1");
            a10.put("auction_second_price", d12);
            if (vlionBidderSource != null) {
                a10.put("bidder_source", vlionBidderSource.getValue());
            }
            str2 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdVlionBid 请求参数=====", str2);
            return str2;
        }
        return "";
    }

    public static String a(String str, VlionAdapterADConfig vlionAdapterADConfig, VlionADClickType vlionADClickType) {
        String triggerType;
        String triggerParam;
        String page;
        String pagePos;
        String target;
        String isCanOpenDp;
        JSONObject a10;
        String str2 = "";
        if (vlionADClickType != null) {
            try {
                triggerType = vlionADClickType.getTriggerType();
                triggerParam = vlionADClickType.getTriggerParam();
                page = vlionADClickType.getPage();
                pagePos = vlionADClickType.getPagePos();
                target = vlionADClickType.getTarget();
                isCanOpenDp = vlionADClickType.getIsCanOpenDp();
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdVlionClick 请求参数=====Exception=", th2);
            }
        } else {
            triggerType = null;
            isCanOpenDp = null;
            triggerParam = null;
            page = null;
            pagePos = null;
            target = null;
        }
        if (vlionAdapterADConfig == null || (a10 = a(str, VlionAdEventType.VLION_EVENT_AD_CLK, vlionAdapterADConfig)) == null) {
            return "";
        }
        a10.put("trigger_type", triggerType);
        a10.put("trigger_param", triggerParam);
        a10.put("page", page);
        a10.put("page_pos", pagePos);
        a10.put("target", target);
        a10.put("is_can_open_dp", isCanOpenDp);
        str2 = a10.toString();
        y.a("VlionBaseParameter ====getParameterAdVlionClick 请求参数=====", str2);
        return str2;
    }

    public static String a(VlionAdapterADConfig vlionAdapterADConfig, String str, int i10) {
        JSONObject a10;
        String str2 = "";
        if (vlionAdapterADConfig != null) {
            try {
                a10 = a(str, "ad_close", vlionAdapterADConfig);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdVlionClose 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            a10.put("duration", i10);
            str2 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdVlionClose 请求参数=====", str2);
            return str2;
        }
        return "";
    }

    public static String a(String str, VlionAdapterADConfig vlionAdapterADConfig) {
        JSONObject a10;
        String str2 = "";
        if (vlionAdapterADConfig != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_AD_ENTER, vlionAdapterADConfig);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdVlionEnter 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            str2 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdVlionEnter 请求参数=====", str2);
            return str2;
        }
        return "";
    }

    public static String a(String str, VlionAdapterADConfig vlionAdapterADConfig, double d10, String str2) {
        JSONObject a10;
        String str3 = "";
        if (vlionAdapterADConfig != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_AD_FILL, vlionAdapterADConfig);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdVlionFill 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            a10.put("s_price", d10);
            a10.put(p3.i.f29758c, str2);
            str3 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdVlionFill 请求参数=====", str3);
            return str3;
        }
        return "";
    }

    public static String a(String str, VlionAdapterADConfig vlionAdapterADConfig, double d10, double d11) {
        JSONObject a10;
        String str2 = "";
        if (vlionAdapterADConfig != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_AD_IMP, vlionAdapterADConfig);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdVlionImp 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            a10.put("price", d10);
            a10.put("s_price", d11);
            str2 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdVlionImp 请求参数=====", str2);
            return str2;
        }
        return "";
    }

    public static String a(String str, VlionAdapterADConfig vlionAdapterADConfig, double d10) {
        JSONObject a10;
        String str2 = "";
        if (vlionAdapterADConfig != null) {
            try {
                a10 = a(str, VlionAdEventType.VLION_EVENT_AD_REQ, vlionAdapterADConfig);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdVlionReq 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            a10.put("floor", d10);
            str2 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdVlionReq 请求参数=====", str2);
            return str2;
        }
        return "";
    }

    public static String a(String str, VlionAdapterADConfig vlionAdapterADConfig, String str2) {
        JSONObject a10;
        String str3 = "";
        if (vlionAdapterADConfig != null) {
            try {
                a10 = a(str, "ad_show", vlionAdapterADConfig);
            } catch (Throwable th2) {
                p.a(th2, "VlionBaseParameter ====getParameterAdVlionShow 请求参数=====Exception=", th2);
            }
            if (a10 == null) {
                return "";
            }
            a10.put("page", str2);
            str3 = a10.toString();
            y.a("VlionBaseParameter ====getParameterAdVlionShow 请求参数=====", str3);
            return str3;
        }
        return "";
    }

    public static String a(String str, VlionAdapterADConfig vlionAdapterADConfig, String str2, String str3, int i10) {
        String str4 = "";
        if (vlionAdapterADConfig == null) {
            return "";
        }
        try {
        } catch (Throwable th2) {
            p.a(th2, "getParameterDeepLinkCheck ====getParameterDeepLinkCheck 请求参数=====Exception=", th2);
        }
        if (!TextUtils.isEmpty(str)) {
            JSONObject a10 = a(str, VlionAdEventType.VLION_EVENT_AD_DEEPLINK_CHECK, vlionAdapterADConfig);
            if (a10 == null) {
                return "";
            }
            a10.put("second", i10);
            a10.put("deeplink", str2);
            a10.put("pkg", str3);
            boolean isRunningTaskForeground = VlionDeviceInfo.getInstance().isRunningTaskForeground(VlionSDkManager.getInstance().getApplication(), VlionAppInfo.getInstance().getPackageName(VlionSDkManager.getInstance().getApplication()));
            LogVlion.e("getParameterDeepLinkCheck ====getParameterDeepLinkCheck isFront=" + isRunningTaskForeground);
            a10.put("front", isRunningTaskForeground ? "1" : "0");
            str4 = a10.toString();
            y.a("getParameterDeepLinkCheck ====getParameterDeepLinkCheck 请求参数=====", str4);
            return str4;
        }
        LogVlion.e("getParameterDeepLinkCheck ====getParameterDeepLinkCheck sid is empty");
        return "";
    }

    public static String a() {
        String frontback;
        String str = "";
        try {
            frontback = VlionServiceConfigParse.getInstance().getEventsBean().getFrontback();
        } catch (Throwable th2) {
            p.a(th2, "VlionBaseParameter ====getParameterFrontBack 请求参数=====Exception=", th2);
        }
        if (TextUtils.isEmpty(frontback)) {
            LogVlion.e("VlionBaseParameter ====getParameterFrontBack sid is empty");
            return "";
        }
        str = a(frontback, VlionAdEventType.VLION_EVENT_FRONTBACK).toString();
        y.a("VlionBaseParameter ====getParameterFrontBack 请求参数=====", str);
        return str;
    }

    public static String a(VlionADNetBodyParameter vlionADNetBodyParameter) {
        String netResp;
        String str = "";
        if (vlionADNetBodyParameter == null) {
            return "";
        }
        try {
            netResp = VlionServiceConfigParse.getInstance().getEventsBean().getNetResp();
        } catch (Throwable th2) {
            p.a(th2, "VlionBaseParameter ====getParameterNet 请求参数=====Exception=", th2);
        }
        if (TextUtils.isEmpty(netResp)) {
            LogVlion.e("VlionBaseParameter ====getParameterNet sid is empty");
            return "";
        }
        JSONObject a10 = a(netResp, VlionAdEventType.VLION_EVENT_NET_RESP);
        a10.put("url", vlionADNetBodyParameter.getUrl());
        a10.put("reqtime", vlionADNetBodyParameter.getReqtime());
        a10.put("trace", VlionServiceConfigParse.getInstance().getTrace());
        a10.put("bodysize", vlionADNetBodyParameter.getBodysize());
        a10.put("status", vlionADNetBodyParameter.getStatus());
        a10.put(bt.aZ, vlionADNetBodyParameter.getLatency());
        a10.put("api_type", vlionADNetBodyParameter.getApi_type());
        a10.put("api_status", vlionADNetBodyParameter.getApi_status());
        a10.put("error_msg", vlionADNetBodyParameter.getError_msg());
        str = a10.toString();
        y.a("VlionBaseParameter ====getParameterNet 请求参数=====", str);
        return str;
    }

    public static String a(List<String> list) {
        JSONArray jSONArray;
        String report;
        String str;
        String str2 = "";
        try {
            jSONArray = new JSONArray();
            report = VlionServiceConfigParse.getInstance().getEventsBean().getReport();
        } catch (Throwable th2) {
            p.a(th2, "VlionBaseParameter ====getParameterReport 请求参数=====Exception=", th2);
        }
        if (TextUtils.isEmpty(report)) {
            LogVlion.e("VlionBaseParameter ====getParameterReport sid is empty");
            return "";
        }
        JSONObject a10 = a(report, "report");
        Application application = VlionSDkManager.getInstance().getApplication();
        VlionDeviceInfo vlionDeviceInfo = VlionDeviceInfo.getInstance();
        a10.put(bt.J, vlionDeviceInfo.getModel());
        a10.put("manufacturer", vlionDeviceInfo.getMake());
        a10.put(bm.f6905j, vlionDeviceInfo.getMake());
        a10.put(bm.f6904i, vlionDeviceInfo.getModel());
        a10.put("memory", vlionDeviceInfo.getMemory(application));
        a10.put("storage_sd", vlionDeviceInfo.getSdStorageMemory(application));
        a10.put("storage_Internal", vlionDeviceInfo.getInternalStorageMemory(application));
        a10.put("screen_width", vlionDeviceInfo.getWidth(application));
        a10.put("screen_height", vlionDeviceInfo.getHeight(application));
        a10.put(bt.Z, vlionDeviceInfo.getBattery(application));
        a10.put(bt.N, vlionDeviceInfo.getLanguage());
        a10.put("font_type", vlionDeviceInfo.getFontType(application));
        a10.put("font_size", vlionDeviceInfo.getFontSize(application));
        a10.put(bt.M, vlionDeviceInfo.getTimezone());
        a10.put("time_system", vlionDeviceInfo.getHourFormat(application));
        a10.put(com.baidu.mobads.sdk.internal.d.f7137a, vlionDeviceInfo.getSystemInitTime());
        a10.put("bundle", VlionAppInfo.getInstance().getPackageName(application));
        StringBuilder sb2 = new StringBuilder();
        if (list != null && list.size() > 0) {
            int i10 = 0;
            while (i10 < list.size()) {
                int i11 = i10 + 1;
                if (i11 == list.size()) {
                    str = list.get(i10);
                } else {
                    sb2.append(list.get(i10));
                    str = ",";
                }
                sb2.append(str);
                i10 = i11;
            }
        }
        a10.put("pkgs", sb2.toString());
        a10.put("imei_on", a0.c(application));
        jSONArray.put(a10);
        str2 = jSONArray.toString();
        y.a("VlionBaseParameter ====getParameterReport 请求参数=====", str2);
        return str2;
    }

    public static String a(String str, int i10, String str2, long j10, VlionDAClkBodyParameter vlionDAClkBodyParameter) {
        String str3 = "";
        try {
        } catch (Throwable th2) {
            p.a(th2, "VlionBaseParameter ====getParameterStart 请求参数=====Exception=", th2);
        }
        if (TextUtils.isEmpty(str)) {
            LogVlion.e("Down 策略 : VlionBaseParameter ====getParameterStart sid is empty");
            return "";
        }
        JSONObject a10 = a(str, VlionAdEventType.VLION_EVENT_DA_DEEPLINK);
        a10.put("url", vlionDAClkBodyParameter.getClk_url());
        a10.put("pkg", str2);
        a10.put("drop_rate", vlionDAClkBodyParameter.getDrop_rate());
        a10.put("dpdelay", j10);
        a10.put("status", vlionDAClkBodyParameter.getStatus());
        a10.put("StrStr", vlionDAClkBodyParameter.getStrStr());
        a10.put("needrta", i10);
        a10.put("exp_type", vlionDAClkBodyParameter.getExp_type());
        a10.put("adgroupid", vlionDAClkBodyParameter.getAdgroupid());
        VlionDeviceInfo vlionDeviceInfo = VlionDeviceInfo.getInstance();
        a10.put("boot_time", VlionDeviceInfo.getStartupTime() + "");
        a10.put("update_time", VlionDeviceInfo.getBuildTime() + "");
        a10.put("density", vlionDeviceInfo.getDensity(VlionSDkManager.getInstance().getApplication()));
        a10.put("dpi", vlionDeviceInfo.getDpi(VlionSDkManager.getInstance().getApplication()));
        a10.put("screensize", vlionDeviceInfo.getScreensize(VlionSDkManager.getInstance().getApplication()));
        a10.put("vaid", vlionDeviceInfo.getDpi(VlionSDkManager.getInstance().getApplication()));
        a10.put("sys_cmp_time", VlionDeviceInfo.getBuildTime());
        a10.put(bm.f6905j, vlionDeviceInfo.getMake());
        a10.put(bd.f23524d, vlionDeviceInfo.getUserAgent(VlionSDkManager.getInstance().getApplication()));
        String vaid = vlionDeviceInfo.getVaid(VlionSDkManager.getInstance().getApplication());
        if (!TextUtils.isEmpty(vaid)) {
            a10.put("vaid", vaid);
        }
        a10.put("rom_version", vlionDeviceInfo.getOsv());
        str3 = a10.toString();
        y.a("VlionBaseParameter ====getParameterStart 请求参数=====", str3);
        return str3;
    }

    public static String a(String str, String str2, String str3) {
        String str4 = "";
        try {
        } catch (Throwable th2) {
            p.a(th2, "VlionBaseParameter ====getParameterStart 请求参数=====Exception=", th2);
        }
        if (TextUtils.isEmpty(str)) {
            LogVlion.e("VlionBaseParameter ====getParameterStart sid is empty");
            return "";
        }
        JSONObject a10 = a(str, str2);
        a10.put("pkg", str3);
        str4 = a10.toString();
        y.a("VlionBaseParameter ====getParameterStart 请求参数=====", str4);
        return str4;
    }

    public static String a(String str, boolean z10, int i10, String str2, VlionDAClkBodyParameter vlionDAClkBodyParameter, long j10) {
        JSONObject a10;
        String str3;
        String str4 = "";
        try {
        } catch (Throwable th2) {
            p.a(th2, "VlionBaseParameter ====getParameterStart 请求参数=====Exception=", th2);
        }
        if (TextUtils.isEmpty(str)) {
            LogVlion.e("Down 策略 : VlionBaseParameter ====getParameterStart sid is empty");
            return "";
        }
        if (z10) {
            a10 = a(str, VlionAdEventType.VLION_EVENT_DA_SHOW);
            a10.put("url", vlionDAClkBodyParameter.getClk_url());
            a10.put("show_type", vlionDAClkBodyParameter.getClk_type());
            str3 = "showdelay";
        } else {
            a10 = a(str, VlionAdEventType.VLION_EVENT_DA_CLK);
            a10.put("clk_url", vlionDAClkBodyParameter.getClk_url());
            a10.put("clk_type", vlionDAClkBodyParameter.getClk_type());
            str3 = "clickdelay";
        }
        a10.put(str3, j10);
        a10.put("pkg", str2);
        a10.put("drop_rate", vlionDAClkBodyParameter.getDrop_rate());
        a10.put("status", vlionDAClkBodyParameter.getStatus());
        a10.put("strstr", vlionDAClkBodyParameter.getStrStr());
        a10.put("needrta", i10);
        a10.put("exp_type", vlionDAClkBodyParameter.getExp_type());
        a10.put("adgroupid", vlionDAClkBodyParameter.getAdgroupid());
        VlionDeviceInfo vlionDeviceInfo = VlionDeviceInfo.getInstance();
        a10.put("boot_time", VlionDeviceInfo.getStartupTime() + "");
        a10.put("update_time", VlionDeviceInfo.getBuildTime() + "");
        a10.put("density", vlionDeviceInfo.getDensity(VlionSDkManager.getInstance().getApplication()));
        a10.put("dpi", vlionDeviceInfo.getDpi(VlionSDkManager.getInstance().getApplication()));
        a10.put("screensize", vlionDeviceInfo.getScreensize(VlionSDkManager.getInstance().getApplication()));
        a10.put("vaid", vlionDeviceInfo.getDpi(VlionSDkManager.getInstance().getApplication()));
        a10.put("sys_cmp_time", VlionDeviceInfo.getBuildTime());
        a10.put(bm.f6905j, vlionDeviceInfo.getMake());
        a10.put(bd.f23524d, vlionDeviceInfo.getUserAgent(VlionSDkManager.getInstance().getApplication()));
        String vaid = vlionDeviceInfo.getVaid(VlionSDkManager.getInstance().getApplication());
        if (!TextUtils.isEmpty(vaid)) {
            a10.put("vaid", vaid);
        }
        a10.put("rom_version", vlionDeviceInfo.getOsv());
        str4 = a10.toString();
        y.a("VlionBaseParameter ====getParameterStart 请求参数=====", str4);
        return str4;
    }
}
