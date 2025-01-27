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
    static class AnonymousClass1 extends Handler {

        /* renamed from: a */
        final /* synthetic */ c f25318a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Looper looper, c cVar) {
            super(looper);
            cVar = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 101) {
                cVar.a(0, (String) message.obj);
            } else if (i2 != 102) {
                super.handleMessage(message);
            } else {
                cVar.a(message.arg1, (String) null);
            }
        }
    }

    /* renamed from: com.tencent.connect.share.a$2 */
    static class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f25319a;

        /* renamed from: b */
        final /* synthetic */ Handler f25320b;

        AnonymousClass2(String str, Handler handler) {
            str = str;
            handler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a2;
            Bitmap a3 = a.a(str, 140);
            if (a3 != null) {
                String str = Environment.getExternalStorageDirectory() + "/tmp/";
                String str2 = "share2qq_temp" + i.f(str) + ".jpg";
                if (a.b(str, 140, 140)) {
                    f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound,compress!");
                    a2 = a.a(a3, str, str2);
                } else {
                    f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                    a2 = str;
                }
                f.b("openSDK_LOG.AsynScaleCompressImage", "-->destFilePath: " + a2);
                if (a2 != null) {
                    Message obtainMessage = handler.obtainMessage(101);
                    obtainMessage.obj = a2;
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
    static class AnonymousClass3 extends Handler {

        /* renamed from: a */
        final /* synthetic */ c f25321a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Looper looper, c cVar) {
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
    static class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f25322a;

        /* renamed from: b */
        final /* synthetic */ Handler f25323b;

        AnonymousClass4(ArrayList arrayList, Handler handler) {
            arrayList = arrayList;
            handler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap a2;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                String str = (String) arrayList.get(i2);
                if (!i.g(str) && i.h(str) && (a2 = a.a(str, 10000)) != null) {
                    String str2 = Environment.getExternalStorageDirectory() + "/tmp/";
                    String str3 = "share2qzone_temp" + i.f(str) + ".jpg";
                    if (a.b(str, 640, 10000)) {
                        f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound, compress!");
                        str = a.a(a2, str2, str3);
                    } else {
                        f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                    }
                    if (str != null) {
                        arrayList.set(i2, str);
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

    public static final boolean b(String str, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (options.mCancel || i4 == -1 || i5 == -1) {
            return false;
        }
        int i6 = i4 > i5 ? i4 : i5;
        if (i4 >= i5) {
            i4 = i5;
        }
        f.b("openSDK_LOG.AsynScaleCompressImage", "longSide=" + i6 + "shortSide=" + i4);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return i6 > i3 || i4 > i2;
    }

    public static final void a(Context context, String str, c cVar) {
        f.b("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage");
        if (TextUtils.isEmpty(str)) {
            cVar.a(1, (String) null);
        } else if (i.b()) {
            new Thread(new Runnable() { // from class: com.tencent.connect.share.a.2

                /* renamed from: a */
                final /* synthetic */ String f25319a;

                /* renamed from: b */
                final /* synthetic */ Handler f25320b;

                AnonymousClass2(String str2, Handler handler) {
                    str = str2;
                    handler = handler;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String a2;
                    Bitmap a3 = a.a(str, 140);
                    if (a3 != null) {
                        String str2 = Environment.getExternalStorageDirectory() + "/tmp/";
                        String str22 = "share2qq_temp" + i.f(str) + ".jpg";
                        if (a.b(str, 140, 140)) {
                            f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound,compress!");
                            a2 = a.a(a3, str2, str22);
                        } else {
                            f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                            a2 = str;
                        }
                        f.b("openSDK_LOG.AsynScaleCompressImage", "-->destFilePath: " + a2);
                        if (a2 != null) {
                            Message obtainMessage = handler.obtainMessage(101);
                            obtainMessage.obj = a2;
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
                final /* synthetic */ ArrayList f25322a;

                /* renamed from: b */
                final /* synthetic */ Handler f25323b;

                AnonymousClass4(ArrayList arrayList2, Handler handler) {
                    arrayList = arrayList2;
                    handler = handler;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap a2;
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        String str = (String) arrayList.get(i2);
                        if (!i.g(str) && i.h(str) && (a2 = a.a(str, 10000)) != null) {
                            String str2 = Environment.getExternalStorageDirectory() + "/tmp/";
                            String str3 = "share2qzone_temp" + i.f(str) + ".jpg";
                            if (a.b(str, 640, 10000)) {
                                f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound, compress!");
                                str = a.a(a2, str2, str3);
                            } else {
                                f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                            }
                            if (str != null) {
                                arrayList.set(i2, str);
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

    private static int b(BitmapFactory.Options options, int i2, int i3) {
        int ceil;
        int min;
        double d2 = options.outWidth;
        double d3 = options.outHeight;
        if (i3 == -1) {
            ceil = 1;
        } else {
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = i3;
            Double.isNaN(d4);
            ceil = (int) Math.ceil(Math.sqrt((d2 * d3) / d4));
        }
        if (i2 == -1) {
            min = 128;
        } else {
            double d5 = i2;
            Double.isNaN(d2);
            Double.isNaN(d5);
            double floor = Math.floor(d2 / d5);
            Double.isNaN(d3);
            Double.isNaN(d5);
            min = (int) Math.min(floor, Math.floor(d3 / d5));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i3 == -1 && i2 == -1) {
            return 1;
        }
        return i2 == -1 ? ceil : min;
    }

    private static Bitmap a(Bitmap bitmap, int i2) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f2 = i2 / width;
        matrix.postScale(f2, f2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    protected static final String a(Bitmap bitmap, String str, String str2) {
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
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static final Bitmap a(String str, int i2) {
        Bitmap bitmap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (options.mCancel || i3 == -1 || i4 == -1) {
            return null;
        }
        if (i3 <= i4) {
            i3 = i4;
        }
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (i3 > i2) {
            options.inSampleSize = a(options, -1, i2 * i2);
        }
        options.inJustDecodeBounds = false;
        try {
            bitmap = BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        int i5 = options.outWidth;
        int i6 = options.outHeight;
        if (i5 <= i6) {
            i5 = i6;
        }
        return i5 > i2 ? a(bitmap, i2) : bitmap;
    }

    public static final int a(BitmapFactory.Options options, int i2, int i3) {
        int b2 = b(options, i2, i3);
        if (b2 > 8) {
            return ((b2 + 7) / 8) * 8;
        }
        int i4 = 1;
        while (i4 < b2) {
            i4 <<= 1;
        }
        return i4;
    }
}
