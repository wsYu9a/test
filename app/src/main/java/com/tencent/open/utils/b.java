package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: c */
    private static String f25519c;

    /* renamed from: a */
    private String f25520a;

    /* renamed from: b */
    private c f25521b;

    /* renamed from: d */
    private long f25522d;

    /* renamed from: e */
    private Handler f25523e;

    /* renamed from: f */
    private Runnable f25524f = new Runnable() { // from class: com.tencent.open.utils.b.2
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            com.tencent.open.a.f.a("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + i.f(b.this.f25520a) + ".jpg";
            String str2 = b.f25519c + str;
            File file = new File(str2);
            Message obtainMessage = b.this.f25523e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                com.tencent.open.a.f.a("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - b.this.f25522d));
            } else {
                Bitmap a2 = b.a(b.this.f25520a);
                if (a2 != null) {
                    z = b.this.a(a2, str);
                } else {
                    com.tencent.open.a.f.a("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z = false;
                }
                if (z) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                com.tencent.open.a.f.a("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - b.this.f25522d));
            }
            b.this.f25523e.sendMessage(obtainMessage);
        }
    };

    /* renamed from: com.tencent.open.utils.b$1 */
    class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            com.tencent.open.a.f.a("AsynLoadImg", "handleMessage:" + message.arg1);
            if (message.arg1 == 0) {
                b.this.f25521b.a(message.arg1, (String) message.obj);
            } else {
                b.this.f25521b.a(message.arg1, (String) null);
            }
        }
    }

    /* renamed from: com.tencent.open.utils.b$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            com.tencent.open.a.f.a("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + i.f(b.this.f25520a) + ".jpg";
            String str2 = b.f25519c + str;
            File file = new File(str2);
            Message obtainMessage = b.this.f25523e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                com.tencent.open.a.f.a("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - b.this.f25522d));
            } else {
                Bitmap a2 = b.a(b.this.f25520a);
                if (a2 != null) {
                    z = b.this.a(a2, str);
                } else {
                    com.tencent.open.a.f.a("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z = false;
                }
                if (z) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                com.tencent.open.a.f.a("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - b.this.f25522d));
            }
            b.this.f25523e.sendMessage(obtainMessage);
        }
    }

    public b(Activity activity) {
        this.f25523e = new Handler(activity.getMainLooper()) { // from class: com.tencent.open.utils.b.1
            AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.tencent.open.a.f.a("AsynLoadImg", "handleMessage:" + message.arg1);
                if (message.arg1 == 0) {
                    b.this.f25521b.a(message.arg1, (String) message.obj);
                } else {
                    b.this.f25521b.a(message.arg1, (String) null);
                }
            }
        };
    }

    public void a(String str, c cVar) {
        com.tencent.open.a.f.a("AsynLoadImg", "--save---");
        if (str != null && !str.equals("")) {
            if (!i.b()) {
                cVar.a(2, (String) null);
                return;
            }
            f25519c = Environment.getExternalStorageDirectory() + "/tmp/";
            this.f25522d = System.currentTimeMillis();
            this.f25520a = str;
            this.f25521b = cVar;
            new Thread(this.f25524f).start();
            return;
        }
        cVar.a(1, (String) null);
    }

    public boolean a(Bitmap bitmap, String str) {
        String str2 = f25519c;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                com.tencent.open.a.f.a("AsynLoadImg", "saveFile:" + str);
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    try {
                        bufferedOutputStream2.close();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    com.tencent.open.a.f.b("AsynLoadImg", "saveFile bmp fail---", e);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
        }
    }

    public static Bitmap a(String str) {
        com.tencent.open.a.f.a("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            com.tencent.open.a.f.a("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (IOException e2) {
            e2.printStackTrace();
            com.tencent.open.a.f.a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            com.tencent.open.a.f.a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
