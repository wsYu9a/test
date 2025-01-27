package com.martian.apptask.g;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Environment;
import android.view.Display;
import android.view.View;
import com.martian.libmars.utils.w0;
import com.martian.libsupport.permission.TipInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public class i {

    static class a implements com.martian.libsupport.permission.f {

        /* renamed from: a */
        final /* synthetic */ Activity f9655a;

        a(final Activity val$activity) {
            this.f9655a = val$activity;
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionDenied() {
            w0.a(this.f9655a, "缺少存储权限");
        }

        @Override // com.martian.libsupport.permission.f
        public void permissionGranted() {
            w0.a(this.f9655a, "授权成功");
        }
    }

    public static Bitmap a(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.buildDrawingCache();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int i2 = rect.top;
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        decorView.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(decorView.getDrawingCache(), 0, i2, width, height - i2);
        decorView.destroyDrawingCache();
        return createBitmap;
    }

    public static String b(Activity activity, Bitmap bmp, String dirName, String fileName) throws IOException {
        if (!com.martian.libsupport.permission.g.d(activity, com.kuaishou.weapon.p0.g.f9324i)) {
            com.martian.libsupport.permission.g.h(activity, new a(activity), new String[]{com.kuaishou.weapon.p0.g.f9325j}, true, new TipInfo("权限申请", "需要存储权限才能生成分享图片\n \n 请点击 \"前往开启\"-\"权限管理\"-打开所需权限。", "取消", "前往开启"), true);
            return "";
        }
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return "";
        }
        File file = new File(dirName);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(dirName + fileName);
        if (!file2.exists()) {
            file2.createNewFile();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bmp.compress(Bitmap.CompressFormat.PNG, 60, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return file2.getAbsolutePath();
    }
}
