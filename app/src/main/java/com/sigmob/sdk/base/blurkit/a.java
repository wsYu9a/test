package com.sigmob.sdk.base.blurkit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final float f17595a = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    public static a f17596b;

    /* renamed from: c, reason: collision with root package name */
    public static RenderScript f17597c;

    public Bitmap a(Bitmap bitmap, int i10) {
        try {
            Allocation createFromBitmap = Allocation.createFromBitmap(f17597c, bitmap);
            Allocation createTyped = Allocation.createTyped(f17597c, createFromBitmap.getType());
            RenderScript renderScript = f17597c;
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            create.setRadius(i10);
            create.setInput(createFromBitmap);
            create.forEach(createTyped);
            createTyped.copyTo(bitmap);
        } catch (Throwable unused) {
        }
        return bitmap;
    }

    public Bitmap a(View view, int i10) {
        return a(a(view), i10);
    }

    public Bitmap a(View view, int i10, float f10) {
        return a(a(view, f10), i10);
    }

    public final Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public final Bitmap a(View view, float f10) {
        Bitmap createBitmap = Bitmap.createBitmap((int) (view.getWidth() * f10), (int) (view.getHeight() * f10), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.preScale(f10, f10);
        canvas.setMatrix(matrix);
        view.draw(canvas);
        return createBitmap;
    }

    public static a a() {
        a aVar = f17596b;
        if (aVar != null) {
            return aVar;
        }
        throw new RuntimeException("BlurKit not initialized!");
    }

    public static void a(Context context) {
        if (f17596b != null) {
            return;
        }
        f17596b = new a();
        f17597c = RenderScript.create(context.getApplicationContext());
    }
}
