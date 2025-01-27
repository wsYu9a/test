package cf;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import androidx.media3.common.MimeTypes;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.tencent.bugly.beta.tinker.TinkerReport;
import hf.d;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class a implements cf.b {

    /* renamed from: b */
    public static final String f1990b = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";

    /* renamed from: c */
    public static final String f1991c = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";

    /* renamed from: d */
    public static final String f1992d = "Rotate image on %1$d° [%2$s]";

    /* renamed from: e */
    public static final String f1993e = "Flip image horizontally [%s]";

    /* renamed from: f */
    public static final String f1994f = "Image can't be decoded [%s]";

    /* renamed from: a */
    public final boolean f1995a;

    public static class b {

        /* renamed from: a */
        public final af.c f1998a;

        /* renamed from: b */
        public final C0018a f1999b;

        public b(af.c cVar, C0018a c0018a) {
            this.f1998a = cVar;
            this.f1999b = c0018a;
        }
    }

    public a(boolean z10) {
        this.f1995a = z10;
    }

    @Override // cf.b
    public Bitmap a(c cVar) throws IOException {
        InputStream f10 = f(cVar);
        try {
            b e10 = e(f10, cVar);
            f10 = h(f10, cVar);
            Bitmap decodeStream = BitmapFactory.decodeStream(f10, null, g(e10.f1998a, cVar));
            if (decodeStream == null) {
                d.c(f1994f, cVar.g());
                return decodeStream;
            }
            C0018a c0018a = e10.f1999b;
            return c(decodeStream, cVar, c0018a.f1996a, c0018a.f1997b);
        } finally {
            hf.c.a(f10);
        }
    }

    public final boolean b(String str, String str2) {
        return MimeTypes.IMAGE_JPEG.equalsIgnoreCase(str2) && ImageDownloader.Scheme.ofUri(str) == ImageDownloader.Scheme.FILE;
    }

    public Bitmap c(Bitmap bitmap, c cVar, int i10, boolean z10) {
        Matrix matrix = new Matrix();
        ImageScaleType h10 = cVar.h();
        if (h10 == ImageScaleType.EXACTLY || h10 == ImageScaleType.EXACTLY_STRETCHED) {
            af.c cVar2 = new af.c(bitmap.getWidth(), bitmap.getHeight(), i10);
            float b10 = hf.b.b(cVar2, cVar.k(), cVar.l(), h10 == ImageScaleType.EXACTLY_STRETCHED);
            if (Float.compare(b10, 1.0f) != 0) {
                matrix.setScale(b10, b10);
                if (this.f1995a) {
                    d.a(f1991c, cVar2, cVar2.c(b10), Float.valueOf(b10), cVar.g());
                }
            }
        }
        if (z10) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.f1995a) {
                d.a(f1993e, cVar.g());
            }
        }
        if (i10 != 0) {
            matrix.postRotate(i10);
            if (this.f1995a) {
                d.a(f1992d, Integer.valueOf(i10), cVar.g());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public C0018a d(String str) {
        boolean z10 = true;
        int i10 = 0;
        try {
        } catch (IOException unused) {
            d.i("Can't read EXIF tags from file [%s]", str);
        }
        switch (new ExifInterface(ImageDownloader.Scheme.FILE.crop(str)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1)) {
            case 1:
            default:
                z10 = false;
                break;
            case 2:
                break;
            case 3:
                z10 = false;
                i10 = TinkerReport.KEY_APPLIED_VERSION_CHECK;
                break;
            case 4:
                i10 = TinkerReport.KEY_APPLIED_VERSION_CHECK;
                break;
            case 5:
                i10 = 270;
                break;
            case 6:
                z10 = false;
                i10 = 90;
                break;
            case 7:
                i10 = 90;
                break;
            case 8:
                z10 = false;
                i10 = 270;
                break;
        }
        return new C0018a(i10, z10);
    }

    public b e(InputStream inputStream, c cVar) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String i10 = cVar.i();
        C0018a d10 = (cVar.m() && b(i10, options.outMimeType)) ? d(i10) : new C0018a();
        return new b(new af.c(options.outWidth, options.outHeight, d10.f1996a), d10);
    }

    public InputStream f(c cVar) throws IOException {
        return cVar.e().getStream(cVar.i(), cVar.f());
    }

    public BitmapFactory.Options g(af.c cVar, c cVar2) {
        int a10;
        ImageScaleType h10 = cVar2.h();
        if (h10 == ImageScaleType.NONE) {
            a10 = 1;
        } else if (h10 == ImageScaleType.NONE_SAFE) {
            a10 = hf.b.c(cVar);
        } else {
            a10 = hf.b.a(cVar, cVar2.k(), cVar2.l(), h10 == ImageScaleType.IN_SAMPLE_POWER_OF_2);
        }
        if (a10 > 1 && this.f1995a) {
            d.a(f1990b, cVar, cVar.d(a10), Integer.valueOf(a10), cVar2.g());
        }
        BitmapFactory.Options d10 = cVar2.d();
        d10.inSampleSize = a10;
        return d10;
    }

    public InputStream h(InputStream inputStream, c cVar) throws IOException {
        try {
            inputStream.reset();
            return inputStream;
        } catch (IOException unused) {
            hf.c.a(inputStream);
            return f(cVar);
        }
    }

    /* renamed from: cf.a$a */
    public static class C0018a {

        /* renamed from: a */
        public final int f1996a;

        /* renamed from: b */
        public final boolean f1997b;

        public C0018a() {
            this.f1996a = 0;
            this.f1997b = false;
        }

        public C0018a(int i10, boolean z10) {
            this.f1996a = i10;
            this.f1997b = z10;
        }
    }
}
