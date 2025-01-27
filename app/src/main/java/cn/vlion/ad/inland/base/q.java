package cn.vlion.ad.inland.base;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import cn.vlion.ad.inland.ad.config.VlionCustomAdActiveType$VlionCustomTarget;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.view.web.VLionWebViewActivity;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.net.URISyntaxException;
import java.util.List;

/* loaded from: classes.dex */
public final class q {
    public static VlionCustomAdActiveType$VlionCustomTarget a(Context context, String str, String str2, String str3, List<VlionCustomAdData.SeatbidBean.BidBean.HeadInfoBean.Headerbean> list) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                    } catch (Throwable th2) {
                        LogVlion.e("openEndPage Exception=" + th2);
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                    if (str.startsWith("http")) {
                        VLionWebViewActivity.start(context, 1, str, "", str2, str3, list);
                        return VlionCustomAdActiveType$VlionCustomTarget.h5;
                    }
                    if (a(context, str)) {
                        a(context, str, str2, str3);
                    } else {
                        VlionSDkManager.getInstance().upLoadCatchException(new Throwable("ldp  dp打不开异常 slotID = " + str2 + " dspid= " + str3 + " ldp= " + str));
                    }
                    return VlionCustomAdActiveType$VlionCustomTarget.deeplink;
                }
            } catch (Throwable th3) {
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        }
        return VlionCustomAdActiveType$VlionCustomTarget.exception;
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                new Intent("android.intent.action.VIEW", Uri.parse(str)).setFlags(268435456);
                if (context.getPackageManager() != null) {
                    return !r3.queryIntentActivities(r1, 0).isEmpty();
                }
            } catch (Throwable th2) {
                LogVlion.e("CanOpenDeeplink Exception=" + th2);
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        return false;
    }

    public static void a(Application application, String str) {
        if (application == null) {
            LogVlion.e("openDeeplink: context is null ");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            LogVlion.e("openDeeplink: deepLink isEmpty ");
            return;
        }
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.setFlags(805339136);
            parseUri.setComponent(null);
            try {
                application.startActivity(parseUri);
            } catch (ActivityNotFoundException e10) {
                StringBuilder a10 = l1.a("ActivityNotFoundException: ");
                a10.append(e10.getLocalizedMessage());
                LogVlion.e(a10.toString());
                VlionSDkManager.getInstance().upLoadCatchException(e10);
            } catch (Throwable th2) {
                LogVlion.e("openDeeplink Exception=" + th2);
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (URISyntaxException e11) {
            VlionSDkManager.getInstance().upLoadCatchException(e11);
            LogVlion.e("URISyntaxException: " + e11.getLocalizedMessage());
        } catch (Throwable th3) {
            p.a(th3, "openDeeplink Exception=", th3);
        }
    }

    public static boolean a(Context context, String str, String str2, String str3) {
        try {
            if (context == null) {
                LogVlion.e("openDeeplink: context is null ");
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                LogVlion.e("openDeeplink: deepLink isEmpty ");
                return false;
            }
            if (str.startsWith("http")) {
                String str4 = "deepLink 是http 开头上报异常 slotID = " + str2 + " dspid= " + str3 + " deepLink= " + str;
                VlionSDkManager.getInstance().upLoadCatchException(new Throwable("openDeeplink: dspid= " + str3 + "--" + str4));
                return false;
            }
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                parseUri.setFlags(805339136);
                parseUri.setComponent(null);
                context.startActivity(parseUri);
                return true;
            } catch (URISyntaxException e10) {
                VlionSDkManager.getInstance().upLoadCatchException(new Throwable("openDeeplink: dspid= " + str3 + "--" + e10));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("URISyntaxException: ");
                sb2.append(e10.getLocalizedMessage());
                LogVlion.e(sb2.toString());
                return false;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(new Throwable("openDeeplink: dspid= " + str3 + "--" + th2));
                StringBuilder sb3 = new StringBuilder();
                sb3.append("openDeeplink Exception=");
                sb3.append(th2);
                LogVlion.e(sb3.toString());
                return false;
            }
        } catch (ActivityNotFoundException e11) {
            StringBuilder a10 = l1.a("openDeeplink ActivityNotFoundException: ");
            a10.append(e11.getLocalizedMessage());
            LogVlion.e(a10.toString());
            VlionSDkManager.getInstance().upLoadCatchException(new Throwable("openDeeplink: dspid= " + str3 + "--" + e11));
            return false;
        } catch (Throwable th3) {
            LogVlion.e("openDeeplink Exception=" + th3);
            VlionSDkManager.getInstance().upLoadCatchException(new Throwable("openDeeplink: dspid= " + str3 + "--" + th3));
            return false;
        }
    }
}
