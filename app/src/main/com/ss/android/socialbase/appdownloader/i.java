package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* loaded from: classes4.dex */
public class i {
    public static int a(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "layout", DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static int b(String str) {
        return a(DownloadComponentManager.getAppContext(), str);
    }

    public static int c(String str) {
        try {
            return a(str, DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static int d(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "style", DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static int e(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "id", DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static int f(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "color", DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static int b(String str, String str2) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static int a(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, context.getPackageName());
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static int a(String str, String str2) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }
}
