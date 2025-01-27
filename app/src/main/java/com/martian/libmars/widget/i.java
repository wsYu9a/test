package com.martian.libmars.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class i extends BitmapDrawable {

    /* renamed from: a */
    private final WeakReference<j> f10397a;

    /* renamed from: b */
    private String f10398b;

    public i(Resources res, Bitmap bitmap, j bitmapDownloaderTask) {
        super(res, bitmap);
        this.f10398b = null;
        this.f10397a = new WeakReference<>(bitmapDownloaderTask);
        if (bitmapDownloaderTask != null) {
            this.f10398b = bitmapDownloaderTask.e();
        }
    }

    public j a() {
        return this.f10397a.get();
    }

    public String b() {
        return this.f10398b;
    }
}
