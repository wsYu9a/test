package com.nostra13.universalimageloader.core.h;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import b.g.a.b.d;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class a implements com.nostra13.universalimageloader.core.h.b {

    /* renamed from: a */
    protected static final String f16007a = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";

    /* renamed from: b */
    protected static final String f16008b = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";

    /* renamed from: c */
    protected static final String f16009c = "Rotate image on %1$d° [%2$s]";

    /* renamed from: d */
    protected static final String f16010d = "Flip image horizontally [%s]";

    /* renamed from: e */
    protected static final String f16011e = "Image can't be decoded [%s]";

    /* renamed from: f */
    protected final boolean f16012f;

    protected static class b {

        /* renamed from: a */
        public final com.nostra13.universalimageloader.core.assist.c f16015a;

        /* renamed from: b */
        public final C0363a f16016b;

        protected b(com.nostra13.universalimageloader.core.assist.c cVar, C0363a c0363a) {
            this.f16015a = cVar;
            this.f16016b = c0363a;
        }
    }

    public a(boolean z) {
        this.f16012f = z;
    }

    private boolean b(String str, String str2) {
        return "image/jpeg".equalsIgnoreCase(str2) && ImageDownloader.Scheme.ofUri(str) == ImageDownloader.Scheme.FILE;
    }

    @Override // com.nostra13.universalimageloader.core.h.b
    public Bitmap a(c cVar) throws IOException {
        InputStream f2 = f(cVar);
        try {
            b e2 = e(f2, cVar);
            f2 = h(f2, cVar);
            Bitmap decodeStream = BitmapFactory.decodeStream(f2, null, g(e2.f16015a, cVar));
            if (decodeStream == null) {
                d.c(f16011e, cVar.g());
                return decodeStream;
            }
            C0363a c0363a = e2.f16016b;
            return c(decodeStream, cVar, c0363a.f16013a, c0363a.f16014b);
        } finally {
            b.g.a.b.c.a(f2);
        }
    }

    protected Bitmap c(Bitmap bitmap, c cVar, int i2, boolean z) {
        Matrix matrix = new Matrix();
        ImageScaleType h2 = cVar.h();
        if (h2 == ImageScaleType.EXACTLY || h2 == ImageScaleType.EXACTLY_STRETCHED) {
            com.nostra13.universalimageloader.core.assist.c cVar2 = new com.nostra13.universalimageloader.core.assist.c(bitmap.getWidth(), bitmap.getHeight(), i2);
            float b2 = b.g.a.b.b.b(cVar2, cVar.k(), cVar.l(), h2 == ImageScaleType.EXACTLY_STRETCHED);
            if (Float.compare(b2, 1.0f) != 0) {
                matrix.setScale(b2, b2);
                if (this.f16012f) {
                    d.a(f16008b, cVar2, cVar2.c(b2), Float.valueOf(b2), cVar.g());
                }
            }
        }
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.f16012f) {
                d.a(f16010d, cVar.g());
            }
        }
        if (i2 != 0) {
            matrix.postRotate(i2);
            if (this.f16012f) {
                d.a(f16009c, Integer.valueOf(i2), cVar.g());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    protected C0363a d(String str) {
        int i2 = 0;
        boolean z = 1;
        try {
        } catch (IOException unused) {
            d.i("Can't read EXIF tags from file [%s]", str);
        }
        switch (new ExifInterface(ImageDownloader.Scheme.FILE.crop(str)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1)) {
            case 1:
            default:
                z = 0;
                break;
            case 2:
                break;
            case 3:
                z = i2;
                i2 = TinkerReport.KEY_APPLIED_VERSION_CHECK;
                break;
            case 4:
                i2 = 1;
                z = i2;
                i2 = TinkerReport.KEY_APPLIED_VERSION_CHECK;
                break;
            case 5:
                i2 = 1;
                z = i2;
                i2 = 270;
                break;
            case 6:
                z = i2;
                i2 = 90;
                break;
            case 7:
                i2 = 1;
                z = i2;
                i2 = 90;
                break;
            case 8:
                z = i2;
                i2 = 270;
                break;
        }
        return new C0363a(i2, z);
    }

    protected b e(InputStream inputStream, c cVar) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String i2 = cVar.i();
        C0363a d2 = (cVar.m() && b(i2, options.outMimeType)) ? d(i2) : new C0363a();
        return new b(new com.nostra13.universalimageloader.core.assist.c(options.outWidth, options.outHeight, d2.f16013a), d2);
    }

    protected InputStream f(c cVar) throws IOException {
        return cVar.e().getStream(cVar.i(), cVar.f());
    }

    protected BitmapFactory.Options g(com.nostra13.universalimageloader.core.assist.c cVar, c cVar2) {
        int a2;
        ImageScaleType h2 = cVar2.h();
        if (h2 == ImageScaleType.NONE) {
            a2 = 1;
        } else if (h2 == ImageScaleType.NONE_SAFE) {
            a2 = b.g.a.b.b.c(cVar);
        } else {
            a2 = b.g.a.b.b.a(cVar, cVar2.k(), cVar2.l(), h2 == ImageScaleType.IN_SAMPLE_POWER_OF_2);
        }
        if (a2 > 1 && this.f16012f) {
            d.a(f16007a, cVar, cVar.d(a2), Integer.valueOf(a2), cVar2.g());
        }
        BitmapFactory.Options d2 = cVar2.d();
        d2.inSampleSize = a2;
        return d2;
    }

    protected InputStream h(InputStream inputStream, c cVar) throws IOException {
        try {
            inputStream.reset();
            return inputStream;
        } catch (IOException unused) {
            b.g.a.b.c.a(inputStream);
            return f(cVar);
        }
    }

    /* renamed from: com.nostra13.universalimageloader.core.h.a$a */
    protected static class C0363a {

        /* renamed from: a */
        public final int f16013a;

        /* renamed from: b */
        public final boolean f16014b;

        protected C0363a() {
            this.f16013a = 0;
            this.f16014b = false;
        }

        protected C0363a(int i2, boolean z) {
            this.f16013a = i2;
            this.f16014b = z;
        }
    }
}
