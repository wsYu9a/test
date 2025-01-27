package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.open.a.f;
import com.tencent.open.utils.c;
import com.tencent.open.utils.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.tencent.connect.share.a$1 */
    public static class AnonymousClass1 extends Handler {

        /* renamed from: a */
        final /* synthetic */ c f23042a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Looper looper, c cVar) {
            super(looper);
            cVar = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 101) {
                cVar.a(0, (String) message.obj);
            } else if (i10 != 102) {
                super.handleMessage(message);
            } else {
                cVar.a(message.arg1, (String) null);
            }
        }
    }

    /* renamed from: com.tencent.connect.share.a$2 */
    public static class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f23043a;

        /* renamed from: b */
        final /* synthetic */ Handler f23044b;

        public AnonymousClass2(String str, Handler handler) {
            str = str;
            handler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a10;
            Bitmap a11 = a.a(str, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL);
            if (a11 != null) {
                String str = Environment.getExternalStorageDirectory() + "/tmp/";
                String str2 = "share2qq_temp" + i.f(str) + ".jpg";
                if (a.b(str, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL)) {
                    f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound,compress!");
                    a10 = a.a(a11, str, str2);
                } else {
                    f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                    a10 = str;
                }
                f.b("openSDK_LOG.AsynScaleCompressImage", "-->destFilePath: " + a10);
                if (a10 != null) {
                    Message obtainMessage = handler.obtainMessage(101);
                    obtainMessage.obj = a10;
                    handler.sendMessage(obtainMessage);
                    return;
                }
            }
            Message obtainMessage2 = handler.obtainMessage(102);
            obtainMessage2.arg1 = 3;
            handler.sendMessage(obtainMessage2);
        }
    }

    /* renamed from: com.tencent.connect.share.a$3 */
    public static class AnonymousClass3 extends Handler {

        /* renamed from: a */
        final /* synthetic */ c f23045a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Looper looper, c cVar) {
            super(looper);
            cVar = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 101) {
                super.handleMessage(message);
            } else {
                cVar.a(0, message.getData().getStringArrayList("images"));
            }
        }
    }

    /* renamed from: com.tencent.connect.share.a$4 */
    public static class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f23046a;

        /* renamed from: b */
        final /* synthetic */ Handler f23047b;

        public AnonymousClass4(ArrayList arrayList, Handler handler) {
            arrayList = arrayList;
            handler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap a10;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                String str = (String) arrayList.get(i10);
                if (!i.g(str) && i.h(str) && (a10 = a.a(str, 10000)) != null) {
                    String str2 = Environment.getExternalStorageDirectory() + "/tmp/";
                    String str3 = "share2qzone_temp" + i.f(str) + ".jpg";
                    if (a.b(str, 640, 10000)) {
                        f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound, compress!");
                        str = a.a(a10, str2, str3);
                    } else {
                        f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                    }
                    if (str != null) {
                        arrayList.set(i10, str);
                    }
                }
            }
            Message obtainMessage = handler.obtainMessage(101);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("images", arrayList);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
        }
    }

    public static final boolean b(String str, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
        }
        int i12 = options.outWidth;
        int i13 = options.outHeight;
        if (options.mCancel || i12 == -1 || i13 == -1) {
            return false;
        }
        int i14 = i12 > i13 ? i12 : i13;
        if (i12 >= i13) {
            i12 = i13;
        }
        f.b("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i14 + "shortSide=" + i12);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return i14 > i11 || i12 > i10;
    }

    public static final void a(Context context, String str, c cVar) {
        f.b("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage");
        if (TextUtils.isEmpty(str)) {
            cVar.a(1, (String) null);
        } else if (i.b()) {
            new Thread(new Runnable() { // from class: com.tencent.connect.share.a.2

                /* renamed from: a */
                final /* synthetic */ String f23043a;

                /* renamed from: b */
                final /* synthetic */ Handler f23044b;

                public AnonymousClass2(String str2, Handler handler) {
                    str = str2;
                    handler = handler;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String a10;
                    Bitmap a11 = a.a(str, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL);
                    if (a11 != null) {
                        String str2 = Environment.getExternalStorageDirectory() + "/tmp/";
                        String str22 = "share2qq_temp" + i.f(str) + ".jpg";
                        if (a.b(str, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL)) {
                            f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound,compress!");
                            a10 = a.a(a11, str2, str22);
                        } else {
                            f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                            a10 = str;
                        }
                        f.b("openSDK_LOG.AsynScaleCompressImage", "-->destFilePath: " + a10);
                        if (a10 != null) {
                            Message obtainMessage = handler.obtainMessage(101);
                            obtainMessage.obj = a10;
                            handler.sendMessage(obtainMessage);
                            return;
                        }
                    }
                    Message obtainMessage2 = handler.obtainMessage(102);
                    obtainMessage2.arg1 = 3;
                    handler.sendMessage(obtainMessage2);
                }
            }).start();
        } else {
            cVar.a(2, (String) null);
        }
    }

    public static final void a(Context context, ArrayList<String> arrayList, c cVar) {
        f.b("openSDK_LOG.AsynScaleCompressImage", "batchScaleCompressImage");
        if (arrayList == null) {
            cVar.a(1, (String) null);
        } else {
            new Thread(new Runnable() { // from class: com.tencent.connect.share.a.4

                /* renamed from: a */
                final /* synthetic */ ArrayList f23046a;

                /* renamed from: b */
                final /* synthetic */ Handler f23047b;

                public AnonymousClass4(ArrayList arrayList2, Handler handler) {
                    arrayList = arrayList2;
                    handler = handler;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap a10;
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        String str = (String) arrayList.get(i10);
                        if (!i.g(str) && i.h(str) && (a10 = a.a(str, 10000)) != null) {
                            String str2 = Environment.getExternalStorageDirectory() + "/tmp/";
                            String str3 = "share2qzone_temp" + i.f(str) + ".jpg";
                            if (a.b(str, 640, 10000)) {
                                f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound, compress!");
                                str = a.a(a10, str2, str3);
                            } else {
                                f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                            }
                            if (str != null) {
                                arrayList.set(i10, str);
                            }
                        }
                    }
                    Message obtainMessage = handler.obtainMessage(101);
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("images", arrayList);
                    obtainMessage.setData(bundle);
                    handler.sendMessage(obtainMessage);
                }
            }).start();
        }
    }

    private static int b(BitmapFactory.Options options, int i10, int i11) {
        int min;
        double d10 = options.outWidth;
        double d11 = options.outHeight;
        int ceil = i11 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d10 * d11) / i11));
        if (i10 == -1) {
            min = 128;
        } else {
            double d12 = i10;
            min = (int) Math.min(Math.floor(d10 / d12), Math.floor(d11 / d12));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i11 == -1 && i10 == -1) {
            return 1;
        }
        return i10 == -1 ? ceil : min;
    }

    private static Bitmap a(Bitmap bitmap, int i10) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f10 = i10 / width;
        matrix.postScale(f10, f10);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static final String a(Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(str2);
        String stringBuffer2 = stringBuffer.toString();
        File file2 = new File(stringBuffer2);
        if (file2.exists()) {
            file2.delete();
        }
        if (bitmap == null) {
            return null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmap.recycle();
            return stringBuffer2;
        } catch (FileNotFoundException e10) {
            e10.printStackTrace();
            return null;
        } catch (IOException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static final Bitmap a(String str, int i10) {
        Bitmap bitmap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
        }
        int i11 = options.outWidth;
        int i12 = options.outHeight;
        if (options.mCancel || i11 == -1 || i12 == -1) {
            return null;
        }
        if (i11 <= i12) {
            i11 = i12;
        }
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (i11 > i10) {
            options.inSampleSize = a(options, -1, i10 * i10);
        }
        options.inJustDecodeBounds = false;
        try {
            bitmap = BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e11) {
            e11.printStackTrace();
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        int i13 = options.outWidth;
        int i14 = options.outHeight;
        if (i13 <= i14) {
            i13 = i14;
        }
        return i13 > i10 ? a(bitmap, i10) : bitmap;
    }

    public static final int a(BitmapFactory.Options options, int i10, int i11) {
        int b10 = b(options, i10, i11);
        if (b10 > 8) {
            return ((b10 + 7) / 8) * 8;
        }
        int i12 = 1;
        while (i12 < b10) {
            i12 <<= 1;
        }
        return i12;
    }
}
