package com.bytedance.pangle.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a */
    static volatile ArrayList<String> f7859a;

    /* renamed from: b */
    private static String f7860b;

    public static List<String> a() {
        AssetManager assetManager;
        try {
            assetManager = (AssetManager) AssetManager.class.newInstance();
        } catch (Exception e10) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "Execute 'AssetManager.class.newInstance()' failed. ", e10);
            assetManager = null;
        }
        return a(assetManager);
    }

    public static String b(AssetManager assetManager) {
        List<String> a10 = a(assetManager);
        StringBuilder sb2 = new StringBuilder("[");
        if (a10.size() > 0) {
            Iterator<String> it = a10.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append(" , ");
            }
            sb2.delete(sb2.lastIndexOf(" , "), sb2.length());
        }
        sb2.append("]");
        return sb2.toString();
    }

    public static List<String> a(AssetManager assetManager) {
        ArrayList arrayList = new ArrayList();
        if (assetManager == null) {
            return arrayList;
        }
        try {
            if (i.j()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        arrayList.add((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]));
                    }
                }
            } else {
                int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                for (int i10 = 0; i10 < intValue; i10++) {
                    try {
                        String str = (String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i10 + 1));
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    } catch (IndexOutOfBoundsException unused) {
                    }
                }
            }
        } catch (Throwable th2) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "ResUtils GetAssetsPaths error. ", th2);
        }
        return arrayList;
    }

    public static synchronized List<String> b() {
        ArrayList<String> arrayList;
        int i10;
        synchronized (j.class) {
            try {
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_WEB, "start");
                if (f7859a == null) {
                    synchronized (j.class) {
                        if (f7859a == null) {
                            f7859a = new ArrayList<>();
                            if (i.c()) {
                                try {
                                    Resources resources = Zeus.getAppApplication().getResources();
                                    f7859a.add(Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", TypedValues.Custom.S_STRING, "android")), 0).getApplicationInfo().sourceDir);
                                } catch (Exception e10) {
                                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "getWebViewPaths1 failed.", e10);
                                }
                            } else if (i.h()) {
                                try {
                                    Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.webkit.WebViewFactory"), "getWebViewContextAndSetProvider", new Object[0]);
                                    int i11 = Build.VERSION.SDK_INT;
                                    if (i11 < 29) {
                                        if (i11 == 28) {
                                            i10 = Build.VERSION.PREVIEW_SDK_INT;
                                            if (i10 > 0) {
                                            }
                                        }
                                        f7859a.add(((Context) invokeStaticMethod).getApplicationInfo().sourceDir);
                                    }
                                    Collections.addAll(f7859a, a(((Context) invokeStaticMethod).getApplicationInfo()));
                                } catch (Exception e11) {
                                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "getWebViewPaths2 failed.", e11);
                                }
                            }
                        }
                    }
                }
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_WEB, "finish :" + f7859a);
                arrayList = f7859a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    public static boolean a(AssetManager assetManager, String str) {
        try {
            if (i.j()) {
                Object[] objArr = (Object[]) MethodUtils.invokeMethod(assetManager, "getApkAssets", new Object[0]);
                if (objArr != null && objArr.length > 0) {
                    for (Object obj : objArr) {
                        if (TextUtils.equals((String) MethodUtils.invokeMethod(obj, "getAssetPath", new Object[0]), str)) {
                            return true;
                        }
                    }
                }
            } else {
                int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
                int i10 = 0;
                while (i10 < intValue) {
                    i10++;
                    if (TextUtils.equals((String) MethodUtils.invokeMethod(assetManager, "getCookieName", Integer.valueOf(i10)), str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable th2) {
            ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "containsPath error. ", th2);
        }
        return false;
    }

    @RequiresApi(api = 21)
    private static String[] a(ApplicationInfo applicationInfo) {
        String[] strArr;
        try {
            strArr = (String[]) com.bytedance.pangle.b.b.a.a((Class<?>) ApplicationInfo.class, "resourceDirs").get(applicationInfo);
        } catch (Throwable th2) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "get resourceDirs failed.", th2);
            strArr = new String[0];
        }
        String[][] strArr2 = {applicationInfo.splitSourceDirs, applicationInfo.sharedLibraryFiles, strArr};
        ArrayList arrayList = new ArrayList(10);
        String str = applicationInfo.sourceDir;
        if (str != null) {
            arrayList.add(str);
        }
        for (int i10 = 0; i10 < 3; i10++) {
            String[] strArr3 = strArr2[i10];
            if (strArr3 != null) {
                arrayList.addAll(Arrays.asList(strArr3));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
