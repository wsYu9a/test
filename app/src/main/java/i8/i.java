package i8;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Environment;
import android.view.Display;
import android.view.View;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class i {
    public static Bitmap a(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.buildDrawingCache();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int i10 = rect.top;
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        decorView.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(decorView.getDrawingCache(), 0, i10, width, height - i10);
        decorView.destroyDrawingCache();
        return createBitmap;
    }

    public static void b(Activity activity, Bitmap bitmap, String str, String str2) {
        ea.c.m(activity, "图片存储", new a(str, str2, bitmap));
    }

    public class a implements ea.b {

        /* renamed from: a */
        public final /* synthetic */ String f26931a;

        /* renamed from: b */
        public final /* synthetic */ String f26932b;

        /* renamed from: c */
        public final /* synthetic */ Bitmap f26933c;

        public a(String str, String str2, Bitmap bitmap) {
            this.f26931a = str;
            this.f26932b = str2;
            this.f26933c = bitmap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x005a -> B:16:0x0081). Please report as a decompilation issue!!! */
        @Override // ea.b
        public void permissionGranted() {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return;
            }
            File file = new File(this.f26931a);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(this.f26931a + this.f26932b);
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
            }
            FileOutputStream fileOutputStream = null;
            FileOutputStream fileOutputStream2 = null;
            fileOutputStream = null;
            try {
            } catch (Exception e11) {
                e11.printStackTrace();
                fileOutputStream = fileOutputStream;
            }
            try {
                try {
                    FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                    try {
                        Bitmap bitmap = this.f26933c;
                        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
                        bitmap.compress(compressFormat, 60, fileOutputStream3);
                        fileOutputStream3.flush();
                        fileOutputStream3.close();
                        fileOutputStream = compressFormat;
                    } catch (IOException e12) {
                        e = e12;
                        fileOutputStream2 = fileOutputStream3;
                        e.printStackTrace();
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            fileOutputStream = fileOutputStream2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (Exception e13) {
                                e13.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e14) {
                    e = e14;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        @Override // ea.b
        public void permissionDenied() {
        }
    }
}
