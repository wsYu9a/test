package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes4.dex */
public class t extends View {

    /* renamed from: a */
    public final float f18903a;

    /* renamed from: b */
    public Paint f18904b;

    public t(Context context, float f10) {
        super(context);
        this.f18904b = new Paint();
        this.f18903a = f10;
    }

    public float a(int i10) {
        return (float) Math.cos((i10 * 3.141592653589793d) / 180.0d);
    }

    public final Path b(float f10, float f11) {
        Path path = new Path();
        path.moveTo(a(288) * f10, b(288) * f10);
        path.lineTo(a(108) * f11, b(108) * f11);
        path.lineTo(a(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS) * f10, b(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS) * f10);
        path.lineTo(a(TinkerReport.KEY_APPLIED_VERSION_CHECK) * f11, b(TinkerReport.KEY_APPLIED_VERSION_CHECK) * f11);
        path.lineTo(a(216) * f10, f10 * b(216));
        path.lineTo(a(TinkerReport.KEY_LOADED_EXCEPTION_DEX) * f11, f11 * b(TinkerReport.KEY_LOADED_EXCEPTION_DEX));
        path.close();
        return path;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Path a10;
        super.onDraw(canvas);
        int height = getHeight();
        int i10 = (int) this.f18903a;
        float f10 = height / 3.0f;
        float b10 = (b(18) * f10) / b(126);
        boolean z10 = true;
        this.f18904b.setAntiAlias(true);
        this.f18904b.setColor(Color.parseColor("#FFA500"));
        for (int i11 = i10; i11 > 0; i11--) {
            if (z10) {
                canvas.translate(2.0f + f10, height / 2);
                z10 = false;
            } else {
                canvas.rotate(18.0f);
                canvas.translate(2.2f * f10, 0.0f);
            }
            canvas.rotate(-18.0f);
            Path a11 = a(f10, b10);
            this.f18904b.setStyle(Paint.Style.STROKE);
            canvas.drawPath(a11, this.f18904b);
            this.f18904b.setStyle(Paint.Style.FILL);
            canvas.drawPath(a11, this.f18904b);
        }
        float f11 = this.f18903a;
        float f12 = i10;
        if (f11 > f12) {
            float f13 = (f11 - f12) + 0.25f;
            if (f13 >= 1.0f) {
                canvas.rotate(18.0f);
                canvas.translate(f10 * 2.2f, 0.0f);
                canvas.rotate(-18.0f);
                a10 = a(f10, b10);
                this.f18904b.setStyle(Paint.Style.STROKE);
                this.f18904b.setColor(Color.parseColor("#FFA500"));
                canvas.drawPath(a10, this.f18904b);
            } else {
                canvas.rotate(18.0f);
                if (f13 >= 0.5f) {
                    canvas.translate(f10 * 2.2f, 0.0f);
                    canvas.rotate(-18.0f);
                    Path a12 = a(f10, b10);
                    this.f18904b.setColor(Color.parseColor("#FFA500"));
                    this.f18904b.setStyle(Paint.Style.STROKE);
                    canvas.drawPath(a12, this.f18904b);
                    a10 = b(f10, b10);
                    this.f18904b.setColor(Color.parseColor("#FFA500"));
                } else {
                    canvas.translate(f10 * 2.2f, 0.0f);
                    canvas.rotate(-18.0f);
                    a10 = a(f10, b10);
                    this.f18904b.setStyle(Paint.Style.STROKE);
                    this.f18904b.setColor(Color.parseColor("#FFA500"));
                    canvas.drawPath(a10, this.f18904b);
                }
            }
            this.f18904b.setStyle(Paint.Style.FILL);
            canvas.drawPath(a10, this.f18904b);
        }
        for (int i12 = (int) (5.0f - this.f18903a); i12 > 0; i12--) {
            canvas.rotate(18.0f);
            canvas.translate(f10 * 2.2f, 0.0f);
            canvas.rotate(-18.0f);
            Path a13 = a(f10, b10);
            this.f18904b.setStyle(Paint.Style.STROKE);
            this.f18904b.setColor(Color.parseColor("#FFA500"));
            canvas.drawPath(a13, this.f18904b);
        }
    }

    public final Path a(float f10, float f11) {
        Path path = new Path();
        path.moveTo(a(0) * f10, b(0) * f10);
        path.lineTo(a(36) * f11, b(36) * f11);
        path.lineTo(a(72) * f10, b(72) * f10);
        path.lineTo(a(108) * f11, b(108) * f11);
        path.lineTo(a(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS) * f10, b(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS) * f10);
        path.lineTo(a(TinkerReport.KEY_APPLIED_VERSION_CHECK) * f11, b(TinkerReport.KEY_APPLIED_VERSION_CHECK) * f11);
        path.lineTo(a(216) * f10, b(216) * f10);
        path.lineTo(a(TinkerReport.KEY_LOADED_EXCEPTION_DEX) * f11, b(TinkerReport.KEY_LOADED_EXCEPTION_DEX) * f11);
        path.lineTo(a(288) * f10, f10 * b(288));
        path.lineTo(a(324) * f11, f11 * b(324));
        path.close();
        return path;
    }

    public float b(int i10) {
        return (float) Math.sin((i10 * 3.141592653589793d) / 180.0d);
    }
}
