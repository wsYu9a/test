package com.zk_oaction.adengine.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes5.dex */
class d {

    /* renamed from: a */
    private HashMap<String, a> f34738a = new HashMap<>();

    class a {

        /* renamed from: a */
        private String f34739a;

        /* renamed from: b */
        private float f34740b;

        /* renamed from: c */
        private int f34741c;

        /* renamed from: d */
        private int f34742d;

        /* renamed from: e */
        private WeakReference<Bitmap> f34743e;

        a(d dVar, String str, float f2, int i2, int i3) {
            this.f34739a = str;
            this.f34740b = f2;
            this.f34741c = i2;
            this.f34742d = i3;
        }

        public Bitmap a(byte[] bArr) {
            Bitmap bitmap;
            Bitmap createScaledBitmap;
            Bitmap bitmap2;
            synchronized (this) {
                WeakReference<Bitmap> weakReference = this.f34743e;
                bitmap = null;
                if (weakReference != null && (bitmap2 = weakReference.get()) != null && !bitmap2.isRecycled()) {
                    bitmap = bitmap2;
                } else if (bArr != null) {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    if (decodeByteArray == null) {
                        byte[] b2 = new com.zk_oaction.adengine.bitmap.a().b(this.f34739a);
                        decodeByteArray = BitmapFactory.decodeByteArray(b2, 0, b2.length);
                    }
                    if (decodeByteArray != null) {
                        float f2 = this.f34740b;
                        if (f2 != -1.0f && (this.f34741c != 480 || this.f34742d != 854)) {
                            if (f2 != 1.0f) {
                                Matrix matrix = new Matrix();
                                float f3 = this.f34740b;
                                matrix.postScale(f3, f3);
                                createScaledBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                                decodeByteArray.recycle();
                                decodeByteArray = createScaledBitmap;
                            }
                            WeakReference<Bitmap> weakReference2 = new WeakReference<>(decodeByteArray);
                            this.f34743e = weakReference2;
                            bitmap = weakReference2.get();
                        }
                        if (decodeByteArray.getWidth() != this.f34741c || decodeByteArray.getHeight() != this.f34742d) {
                            createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, this.f34741c, this.f34742d, true);
                            decodeByteArray.recycle();
                            decodeByteArray = createScaledBitmap;
                        }
                        WeakReference<Bitmap> weakReference22 = new WeakReference<>(decodeByteArray);
                        this.f34743e = weakReference22;
                        bitmap = weakReference22.get();
                    }
                }
            }
            return bitmap;
        }
    }

    d() {
    }

    private a b(String str, float f2, int i2, int i3) {
        a aVar;
        String c2 = c(str, f2);
        synchronized (this) {
            if (this.f34738a.get(c2) == null) {
                this.f34738a.put(c2, new a(this, str, f2, i2, i3));
            }
            aVar = this.f34738a.get(c2);
        }
        return aVar;
    }

    public Bitmap a(String str, float f2, int i2, int i3, byte[] bArr) {
        return b(str, f2, i2, i3).a(bArr);
    }

    protected String c(String str, float f2) {
        return str + "_" + f2;
    }
}
