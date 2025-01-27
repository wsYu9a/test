package cn.vlion.ad.inland.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import cn.vlion.ad.inland.ad.utils.install.VlionProvider;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.io.File;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class i5 {
    public static void a(Context context, String str) {
        VlionProvider.a aVar;
        try {
            LogVlion.e("VlionInstallApk installApp: StorageState = " + str);
            if (context == null || TextUtils.isEmpty(str)) {
                return;
            }
            Uri parse = Uri.parse(str);
            if (parse != null && parse.getPath() != null) {
                File file = new File(parse.getPath());
                LogVlion.e("VlionInstallApk targetFile: " + file.getPath() + "\ttargetFile = " + file.getAbsolutePath() + "\ttargetFile 是否存在:" + file.exists());
                if (file.exists()) {
                    LogVlion.e("VlionInstallApk targetFile: ---" + file.getPath());
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.DEFAULT");
                    String str2 = context.getPackageName() + ".provider";
                    synchronized (VlionProvider.f2389d) {
                        try {
                            aVar = VlionProvider.f2389d.get(str2);
                            if (aVar == null) {
                                try {
                                    aVar = VlionProvider.a(context, str2);
                                    VlionProvider.f2389d.put(str2, aVar);
                                } catch (IOException e10) {
                                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e10);
                                } catch (XmlPullParserException e11) {
                                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e11);
                                }
                            }
                        } finally {
                        }
                    }
                    Uri a10 = aVar.a(file);
                    intent.addFlags(268435456);
                    intent.addFlags(1);
                    intent.setDataAndType(a10, "application/vnd.android.package-archive");
                    context.startActivity(intent);
                    return;
                }
                return;
            }
            LogVlion.e("VlionInstallApk uriPath null ");
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
