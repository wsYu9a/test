package com.martian.libmars.utils;

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

/* loaded from: classes2.dex */
public class i0 {
    public static int a(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        if (i2 > reqHeight || i3 > reqWidth) {
            return Math.min(Math.round(i2 / reqHeight), Math.round(i3 / reqWidth));
        }
        return 1;
    }

    public static Bitmap b(Bitmap src, Bitmap.CompressFormat format, int quality) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        src.compress(format, quality, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static Bitmap c(Bitmap src, Bitmap watermark) {
        if (src == null) {
            return null;
        }
        int width = src.getWidth();
        int height = src.getHeight();
        int width2 = watermark.getWidth();
        int height2 = watermark.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(src, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(watermark, (width - width2) + 5, (height - height2) + 5, (Paint) null);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public static Bitmap d(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        int i2 = height / 2;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, i2, width, i2, matrix, false);
        Bitmap createBitmap2 = Bitmap.createBitmap(width, i2 + height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        float f2 = height;
        float f3 = width;
        float f4 = height + 4;
        canvas.drawRect(0.0f, f2, f3, f4, new Paint());
        canvas.drawBitmap(createBitmap, 0.0f, f4, (Paint) null);
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0.0f, bitmap.getHeight(), 0.0f, createBitmap2.getHeight() + 4, 1895825407, 16777215, Shader.TileMode.CLAMP));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0.0f, f2, f3, createBitmap2.getHeight() + 4, paint);
        return createBitmap2;
    }

    public static Bitmap f(File file) {
        return n(file.getPath(), 512, 512);
    }

    public static Bitmap g(File file) {
        return n(file.getPath(), 48, 48);
    }

    public static Bitmap h(Resources res, int resId, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = a(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static Bitmap i(byte[] bytes, int sampleSize) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = sampleSize;
        options.inDither = false;
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
    }

    public static Bitmap j(byte[] bytes, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
        options.inSampleSize = a(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
    }

    public static Bitmap k(byte[] bytes) {
        return j(bytes, 256, 256);
    }

    public static Bitmap l(byte[] bytes) {
        return j(bytes, 128, 128);
    }

    public static Bitmap m(String path) {
        return BitmapFactory.decodeFile(path);
    }

    public static Bitmap n(String path, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(path, options);
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        options.inSampleSize = a(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(path, options);
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

    public static Bitmap q(Bitmap bitmap, int round) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float f2 = round;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap r(View v) {
        v.clearFocus();
        v.setPressed(false);
        boolean willNotCacheDrawing = v.willNotCacheDrawing();
        v.setWillNotCacheDrawing(false);
        int drawingCacheBackgroundColor = v.getDrawingCacheBackgroundColor();
        v.setDrawingCacheBackgroundColor(0);
        if (drawingCacheBackgroundColor != 0) {
            v.destroyDrawingCache();
        }
        v.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
        v.buildDrawingCache();
        Bitmap drawingCache = v.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache);
        v.destroyDrawingCache();
        v.setWillNotCacheDrawing(willNotCacheDrawing);
        v.setDrawingCacheBackgroundColor(drawingCacheBackgroundColor);
        return createBitmap;
    }

    public static Bitmap s(Bitmap bitmapOrg, int w, int h2, boolean recycleOrg) {
        try {
            int width = bitmapOrg.getWidth();
            int height = bitmapOrg.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(w / width, h2 / height);
            Bitmap createBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0, width, height, matrix, true);
            if (recycleOrg) {
                bitmapOrg.recycle();
            }
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmapOrg;
        } finally {
            bitmapOrg.recycle();
        }
    }

    public static Bitmap t(Bitmap bitmapOrg, float w, float h2, int angle) {
        try {
            int width = bitmapOrg.getWidth();
            int height = bitmapOrg.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(w / width, h2 / height);
            matrix.postRotate(angle);
            Bitmap createBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0, width, height, matrix, true);
            bitmapOrg.recycle();
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmapOrg;
        }
    }

    public static Bitmap u(Bitmap bitmapOrg, int angle) {
        try {
            Matrix matrix = new Matrix();
            matrix.postRotate(angle);
            Bitmap createBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0, bitmapOrg.getWidth(), bitmapOrg.getHeight(), matrix, true);
            bitmapOrg.recycle();
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmapOrg;
        }
    }

    public final void e(Canvas g2, Paint paint, Bitmap imgBit, int x, int y, int w, int h2, int line, int row) {
        g2.clipRect(x, y, x + w, h2 + y);
        g2.drawBitmap(imgBit, x - (line * w), y - (row * h2), paint);
        g2.restore();
    }

    public void o(String strMsg, Canvas g2, Paint paint, int setx, int sety, int fg, int bg) {
        paint.setColor(bg);
        float f2 = sety;
        g2.drawText(strMsg, setx + 1, f2, paint);
        float f3 = setx;
        g2.drawText(strMsg, f3, sety - 1, paint);
        g2.drawText(strMsg, f3, sety + 1, paint);
        g2.drawText(strMsg, setx - 1, f2, paint);
        paint.setColor(fg);
        g2.drawText(strMsg, f3, f2, paint);
        g2.restore();
    }

    public void v(Drawable drawable) {
        drawable.mutate();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        drawable.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }
}
