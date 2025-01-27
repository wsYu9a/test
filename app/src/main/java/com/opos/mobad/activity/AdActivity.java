package com.opos.mobad.activity;

import android.content.Context;
import android.content.Intent;
import com.opos.mobad.activity.webview.WebDataHepler;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.service.event.EventDescription;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* loaded from: classes4.dex */
public class AdActivity extends AdBaseActivity {
    public static void a(Context context, String str, String str2, AdItemData adItemData, String str3, EventDescription eventDescription) {
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) AdActivity.class);
            intent.putExtra("webData", new WebDataHepler(adItemData, str, str3, str2, "", eventDescription, 1));
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String str, String str2, AdItemData adItemData, String str3, EventDescription eventDescription, String str4) {
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) AdActivity.class);
            intent.putExtra("webData", new WebDataHepler(adItemData, str, str3, str2, str4, eventDescription, 2));
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
        }
    }

    public static boolean a(Context context, ComplianceInfo complianceInfo, EventDescription eventDescription) {
        return a(context, complianceInfo, eventDescription, 4);
    }

    private static boolean a(Context context, ComplianceInfo complianceInfo, EventDescription eventDescription, int i2) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, (Class<?>) AdActivity.class);
                intent.putExtra("webData", new WebDataHepler(complianceInfo, eventDescription, i2));
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                context.startActivity(intent);
                return true;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("", "", (Throwable) e2);
            }
        }
        return false;
    }

    public static boolean b(Context context, ComplianceInfo complianceInfo, EventDescription eventDescription) {
        return a(context, complianceInfo, eventDescription, 3);
    }
}
