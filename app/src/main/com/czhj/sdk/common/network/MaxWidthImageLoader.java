package com.czhj.sdk.common.network;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import com.czhj.sdk.common.utils.DeviceUtils;
import com.czhj.volley.RequestQueue;
import com.czhj.volley.toolbox.ImageLoader;

/* loaded from: classes2.dex */
class MaxWidthImageLoader extends ImageLoader {

    /* renamed from: h */
    public final int f8529h;

    public MaxWidthImageLoader(RequestQueue requestQueue, Context context, ImageLoader.ImageCache imageCache) {
        super(requestQueue, imageCache);
        int min;
        Display display = DeviceUtils.getDisplay(context);
        if (display == null) {
            min = 320;
        } else {
            Point point = new Point();
            display.getSize(point);
            min = Math.min(point.x, point.y);
        }
        this.f8529h = min;
    }

    @Override // com.czhj.volley.toolbox.ImageLoader
    public ImageLoader.ImageContainer get(String str, ImageLoader.ImageListener imageListener) {
        return super.get(str, imageListener, this.f8529h, 0);
    }
}
