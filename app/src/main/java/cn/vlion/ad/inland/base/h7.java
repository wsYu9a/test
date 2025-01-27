package cn.vlion.ad.inland.base;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* loaded from: classes.dex */
public final class h7 {

    /* renamed from: a */
    public static boolean f2858a = false;

    /* renamed from: b */
    public static int f2859b = 0;

    /* renamed from: c */
    public static boolean f2860c = false;

    /* renamed from: d */
    public static IWXAPI f2861d;

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, str);
                    f2861d = createWXAPI;
                    f2859b = createWXAPI.getWXAppSupportAPI();
                    f2858a = f2861d.isWXAppInstalled();
                    f2860c = true;
                    return;
                }
            } catch (Throwable th2) {
                StringBuilder a10 = l1.a("WXApiUtil WXApiSDK not found ");
                a10.append(th2.getMessage());
                LogVlion.e(a10.toString());
                f2860c = false;
                return;
            }
        }
        LogVlion.e("WXApiUtil createWXAPI param empty ");
    }

    public static boolean b(Context context, String str, String str2, String str3) {
        String str4;
        LogVlion.e("WXApiUtil sendReq open userName " + str3 + ",path " + str2 + ",miniprogramType 0");
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            str4 = "WXApiUtil sendReq param empty ";
        } else {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
                if (launchIntentForPackage != null) {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");
                    intent.addFlags(268435456);
                    if (launchIntentForPackage.getComponent() != null) {
                        intent.setComponent(launchIntentForPackage.getComponent());
                    }
                    context.startActivity(intent);
                }
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{str, str3, str2, "0", ""}, null);
                LogVlion.e("WXApiUtil sendReq query " + query);
                if (query == null) {
                    return true;
                }
                query.close();
                return true;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                str4 = "WXApiUtil sendReq open wx error " + th2.getMessage();
            }
        }
        LogVlion.e(str4);
        return false;
    }

    public static Boolean a(Context context, String str, String str2, String str3) {
        try {
            LogVlion.e("WXApiUtil sendReq userName " + str3 + ",path " + str2);
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
                if (f2861d == null) {
                    a(context, str);
                }
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = str3;
                req.path = str2;
                req.miniprogramType = 0;
                IWXAPI iwxapi = f2861d;
                if (iwxapi == null) {
                    LogVlion.e("WXApiUtil sendReq fail...");
                    return Boolean.FALSE;
                }
                boolean sendReq = iwxapi.sendReq(req);
                LogVlion.e("WXApiUtil sendReq ..." + sendReq);
                return Boolean.valueOf(sendReq);
            }
            LogVlion.e("WXApiUtil sendReq param empty... ");
            return Boolean.FALSE;
        } catch (Throwable th2) {
            StringBuilder a10 = l1.a("WXApiUtil WXApiSDK not found ");
            a10.append(th2.getMessage());
            LogVlion.e(a10.toString());
            return Boolean.FALSE;
        }
    }
}
