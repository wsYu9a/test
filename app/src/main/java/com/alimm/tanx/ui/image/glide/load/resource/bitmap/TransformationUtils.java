package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes.dex */
public final class TransformationUtils {
    public static final int PAINT_FLAGS = 6;
    private static final String TAG = "TransformationUtils";

    private TransformationUtils() {
    }

    public static Bitmap centerCrop(Bitmap bitmap, Bitmap bitmap2, int i10, int i11) {
        float width;
        float height;
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == i10 && bitmap2.getHeight() == i11) {
            return bitmap2;
        }
        Matrix matrix = new Matrix();
        float f10 = 0.0f;
        if (bitmap2.getWidth() * i11 > bitmap2.getHeight() * i10) {
            width = i11 / bitmap2.getHeight();
            f10 = (i10 - (bitmap2.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i10 / bitmap2.getWidth();
            height = (i11 - (bitmap2.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f10 + 0.5f), (int) (height + 0.5f));
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i10, i11, bitmap2.getConfig() != null ? bitmap2.getConfig() : Bitmap.Config.ARGB_8888);
        }
        setAlpha(bitmap2, bitmap);
        new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap;
    }

    public static Bitmap fitCenter(Bitmap bitmap, BitmapPool bitmapPool, int i10, int i11) {
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(i10 / bitmap.getWidth(), i11 / bitmap.getHeight());
        int width = (int) (bitmap.getWidth() * min);
        int height = (int) (bitmap.getHeight() * min);
        if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap.Config config = bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
        Bitmap bitmap2 = bitmapPool.get(width, height, config);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(width, height, config);
        }
        setAlpha(bitmap, bitmap2);
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "request: " + i10 + "x" + i11);
            Log.v(TAG, "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v(TAG, "toReuse: " + bitmap2.getWidth() + "x" + bitmap2.getHeight());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("minPct:   ");
            sb2.append(min);
            Log.v(TAG, sb2.toString());
        }
        Canvas canvas = new Canvas(bitmap2);
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        return bitmap2;
    }

    public static int getExifOrientationDegrees(int i10) {
        switch (i10) {
            case 3:
            case 4:
                return TinkerReport.KEY_APPLIED_VERSION_CHECK;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @TargetApi(5)
    @Deprecated
    public static int getOrientation(String str) {
        try {
            return getExifOrientationDegrees(new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0));
        } catch (Exception e10) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "Unable to get orientation for image with path=" + str, e10);
            }
            return 0;
        }
    }

    private static Bitmap.Config getSafeConfig(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    public static void initializeMatrixForRotation(int i10, Matrix matrix) {
        switch (i10) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }

    @Deprecated
    public static Bitmap orientImage(String str, Bitmap bitmap) {
        return rotateImage(bitmap, getOrientation(str));
    }

    public static Bitmap rotateImage(Bitmap bitmap, int i10) {
        if (i10 == 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate(i10);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception e10) {
            if (!Log.isLoggable(TAG, 6)) {
                return bitmap;
            }
            Log.e(TAG, "Exception when trying to orient image", e10);
            return bitmap;
        }
    }

    public static Bitmap rotateImageExif(Bitmap bitmap, BitmapPool bitmapPool, int i10) {
        Matrix matrix = new Matrix();
        initializeMatrixForRotation(i10, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        Bitmap.Config config = bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
        Bitmap bitmap2 = bitmapPool.get(round, round2, config);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(round, round2, config);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new Canvas(bitmap2).drawBitmap(bitmap, matrix, new Paint(6));
        return bitmap2;
    }

    @TargetApi(12)
    public static void setAlpha(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }
}
