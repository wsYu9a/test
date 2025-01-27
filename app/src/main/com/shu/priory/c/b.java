package com.shu.priory.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.h;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    private String f16887a;

    /* renamed from: b */
    private Context f16888b;

    public b(Context context, String str) {
        this.f16888b = context;
        this.f16887a = str;
    }

    private String b() {
        return c() + File.separator + "ifly_image_cache";
    }

    private String c() {
        File cacheDir = this.f16888b.getCacheDir();
        return (cacheDir == null || TextUtils.isEmpty(cacheDir.getPath())) ? "" : cacheDir.getPath();
    }

    public Bitmap a() {
        String c10 = c();
        String a10 = a(this.f16887a);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c10);
        String str = File.separator;
        sb2.append(str);
        sb2.append("ifly_image_cache");
        sb2.append(str);
        sb2.append(a10);
        sb2.append(".cache");
        String sb3 = sb2.toString();
        if (TextUtils.isEmpty(sb3)) {
            return null;
        }
        File file = new File(sb3);
        if (file.exists()) {
            Bitmap decodeFile = BitmapFactory.decodeFile(sb3);
            if (decodeFile != null) {
                return decodeFile;
            }
            file.delete();
        }
        return null;
    }

    private String a(String str) {
        return str.split("/")[r2.length - 1];
    }

    public void a(Bitmap bitmap) {
        Bitmap.CompressFormat compressFormat;
        if (bitmap == null) {
            return;
        }
        String str = a(this.f16887a) + ".cache";
        String b10 = b();
        File file = new File(b10);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(b10 + File.separator + str);
        try {
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            if (!this.f16887a.contains("png")) {
                if (this.f16887a.contains("jpg")) {
                    compressFormat = Bitmap.CompressFormat.JPEG;
                }
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            compressFormat = Bitmap.CompressFormat.PNG;
            bitmap.compress(compressFormat, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "saveBitmap:" + th2.getMessage());
        }
    }
}
