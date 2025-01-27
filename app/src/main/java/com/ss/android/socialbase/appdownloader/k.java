package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import com.cdo.oaps.ad.OapsKey;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* loaded from: classes4.dex */
public class k {
    public static int g(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, OapsKey.KEY_STYLE, DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int gv(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "color", DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int i(String str) {
        try {
            return j(str, DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int j(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "layout", DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int q(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "id", DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int zx(String str) {
        return j(DownloadComponentManager.getAppContext(), str);
    }

    public static int zx(String str, String str2) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int j(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int j(String str, String str2) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
