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
    private static String f23253c;

    /* renamed from: a */
    private String f23254a;

    /* renamed from: b */
    private c f23255b;

    /* renamed from: d */
    private long f23256d;

    /* renamed from: e */
    private Handler f23257e;

    /* renamed from: f */
    private Runnable f23258f = new Runnable() { // from class: com.tencent.open.utils.b.2
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            com.tencent.open.a.f.a("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + i.f(b.this.f23254a) + ".jpg";
            String str2 = b.f23253c + str;
            File file = new File(str2);
            Message obtainMessage = b.this.f23257e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                com.tencent.open.a.f.a("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - b.this.f23256d));
            } else {
                Bitmap a10 = b.a(b.this.f23254a);
                if (a10 != null) {
                    z10 = b.this.a(a10, str);
                } else {
                    com.tencent.open.a.f.a("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z10 = false;
                }
                if (z10) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                com.tencent.open.a.f.a("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - b.this.f23256d));
            }
            b.this.f23257e.sendMessage(obtainMessage);
        }
    };

    /* renamed from: com.tencent.open.utils.b$1 */
    public class AnonymousClass1 extends Handler {
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            com.tencent.open.a.f.a("AsynLoadImg", "handleMessage:" + message.arg1);
            if (message.arg1 == 0) {
                b.this.f23255b.a(message.arg1, (String) message.obj);
            } else {
                b.this.f23255b.a(message.arg1, (String) null);
            }
        }
    }

    /* renamed from: com.tencent.open.utils.b$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            com.tencent.open.a.f.a("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + i.f(b.this.f23254a) + ".jpg";
            String str2 = b.f23253c + str;
            File file = new File(str2);
            Message obtainMessage = b.this.f23257e.obtainMessage();
            if (file.exists()) {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                com.tencent.open.a.f.a("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - b.this.f23256d));
            } else {
                Bitmap a10 = b.a(b.this.f23254a);
                if (a10 != null) {
                    z10 = b.this.a(a10, str);
                } else {
                    com.tencent.open.a.f.a("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z10 = false;
                }
                if (z10) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                com.tencent.open.a.f.a("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - b.this.f23256d));
            }
            b.this.f23257e.sendMessage(obtainMessage);
        }
    }

    public b(Activity activity) {
        this.f23257e = new Handler(activity.getMainLooper()) { // from class: com.tencent.open.utils.b.1
            public AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                com.tencent.open.a.f.a("AsynLoadImg", "handleMessage:" + message.arg1);
                if (message.arg1 == 0) {
                    b.this.f23255b.a(message.arg1, (String) message.obj);
                } else {
                    b.this.f23255b.a(message.arg1, (String) null);
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
            f23253c = Environment.getExternalStorageDirectory() + "/tmp/";
            this.f23256d = System.currentTimeMillis();
            this.f23254a = str;
            this.f23255b = cVar;
            new Thread(this.f23258f).start();
            return;
        }
        cVar.a(1, (String) null);
    }

    public boolean a(Bitmap bitmap, String str) {
        String str2 = f23253c;
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
                    } catch (IOException e10) {
                        e10.printStackTrace();
                        return true;
                    }
                } catch (IOException e11) {
                    e = e11;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    com.tencent.open.a.f.b("AsynLoadImg", "saveFile bmp fail---", e);
                    if (bufferedOutputStream == null) {
                        return false;
                    }
                    try {
                        bufferedOutputStream.close();
                        return false;
                    } catch (IOException e12) {
                        e12.printStackTrace();
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e13) {
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
        } catch (IOException e10) {
            e10.printStackTrace();
            com.tencent.open.a.f.a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (OutOfMemoryError e11) {
            e11.printStackTrace();
            com.tencent.open.a.f.a("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
