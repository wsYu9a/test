package l9;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* loaded from: classes3.dex */
public class b {
    public static int a(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        if (i12 > i11 || i13 > i10) {
            return Math.min(Math.round(i12 / i11), Math.round(i13 / i10));
        }
        return 1;
    }

    public static Bitmap b(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i10) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i10, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static Bitmap c(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, (width - width2) + 5, (height - height2) + 5, (Paint) null);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public static Bitmap d(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        int i10 = height / 2;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, i10, width, i10, matrix, false);
        Bitmap createBitmap2 = Bitmap.createBitmap(width, i10 + height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        float f10 = height;
        float f11 = width;
        float f12 = height + 4;
        canvas.drawRect(0.0f, f10, f11, f12, new Paint());
        canvas.drawBitmap(createBitmap, 0.0f, f12, (Paint) null);
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0.0f, bitmap.getHeight(), 0.0f, createBitmap2.getHeight() + 4, 1895825407, 16777215, Shader.TileMode.CLAMP));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0.0f, f10, f11, createBitmap2.getHeight() + 4, paint);
        return createBitmap2;
    }

    public static Bitmap f(File file) {
        return n(file.getPath(), 512, 512);
    }

    public static Bitmap g(File file) {
        return n(file.getPath(), 48, 48);
    }

    public static Bitmap h(Resources resources, int i10, int i11, int i12) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i10, options);
        options.inSampleSize = a(options, i11, i12);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i10, options);
    }

    public static Bitmap i(byte[] bArr, int i10) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i10;
        options.inDither = false;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static Bitmap j(byte[] bArr, int i10, int i11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        options.inSampleSize = a(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static Bitmap k(byte[] bArr) {
        return j(bArr, 256, 256);
    }

    public static Bitmap l(byte[] bArr) {
        return j(bArr, 128, 128);
    }

    public static Bitmap m(String str) {
        return BitmapFactory.decodeFile(str);
    }

    public static Bitmap n(String str, int i10, int i11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        options.inSampleSize = a(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap p(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap q(Bitmap bitmap, int i10) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float f10 = i10;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap r(View view) {
        view.clearFocus();
        view.setPressed(false);
        boolean willNotCacheDrawing = view.willNotCacheDrawing();
        view.setWillNotCacheDrawing(false);
        int drawingCacheBackgroundColor = view.getDrawingCacheBackgroundColor();
        view.setDrawingCacheBackgroundColor(0);
        if (drawingCacheBackgroundColor != 0) {
            view.destroyDrawingCache();
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache);
        view.destroyDrawingCache();
        view.setWillNotCacheDrawing(willNotCacheDrawing);
        view.setDrawingCacheBackgroundColor(drawingCacheBackgroundColor);
        return createBitmap;
    }

    public static Bitmap s(Bitmap bitmap, int i10, int i11, boolean z10) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(i10 / width, i11 / height);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            if (z10) {
                bitmap.recycle();
            }
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        } finally {
            bitmap.recycle();
        }
    }

    public static Bitmap t(Bitmap bitmap, float f10, float f11, int i10) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(f10 / width, f11 / height);
            matrix.postRotate(i10);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static Bitmap u(Bitmap bitmap, int i10) {
        try {
            Matrix matrix = new Matrix();
            matrix.postRotate(i10);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public final void e(Canvas canvas, Paint paint, Bitmap bitmap, int i10, int i11, int i12, int i13, int i14, int i15) {
        canvas.clipRect(i10, i11, i10 + i12, i13 + i11);
        canvas.drawBitmap(bitmap, i10 - (i14 * i12), i11 - (i15 * i13), paint);
        canvas.restore();
    }

    public void o(String str, Canvas canvas, Paint paint, int i10, int i11, int i12, int i13) {
        paint.setColor(i13);
        float f10 = i11;
        canvas.drawText(str, i10 + 1, f10, paint);
        float f11 = i10;
        canvas.drawText(str, f11, i11 - 1, paint);
        canvas.drawText(str, f11, i11 + 1, paint);
        canvas.drawText(str, i10 - 1, f10, paint);
        paint.setColor(i12);
        canvas.drawText(str, f11, f10, paint);
        canvas.restore();
    }

    public void v(Drawable drawable) {
        drawable.mutate();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        drawable.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }
}
