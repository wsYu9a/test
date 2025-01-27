package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.commercial.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;

/* loaded from: classes3.dex */
public class ImageLoaderPerfUtil {
    private static final String TAG = "ImageLoaderPerfUtil";

    /* renamed from: com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil$1 */
    public class AnonymousClass1 extends bd {
        @Override // com.kwad.sdk.utils.bd
        public void doTask() {
            ImageLoaderInfo info = ImageLoaderPerfUtil.getInfo();
            if (info.totalCount == 0) {
                c.w(ImageLoaderPerfUtil.TAG, "info.totalCount == 0");
                return;
            }
            c.d(ImageLoaderPerfUtil.TAG, "ImageLoaderInfo:" + info.toJson().toString());
            b.q(info);
        }
    }

    public static ImageLoaderInfo getInfo() {
        ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo();
        imageLoaderInfo.totalCount = ad.NH();
        imageLoaderInfo.successCount = ad.NI();
        imageLoaderInfo.failedCount = ad.NJ();
        imageLoaderInfo.duration = ad.NG();
        return imageLoaderInfo;
    }

    public static void report() {
        h.execute(new bd() { // from class: com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil.1
            @Override // com.kwad.sdk.utils.bd
            public void doTask() {
                ImageLoaderInfo info = ImageLoaderPerfUtil.getInfo();
                if (info.totalCount == 0) {
                    c.w(ImageLoaderPerfUtil.TAG, "info.totalCount == 0");
                    return;
                }
                c.d(ImageLoaderPerfUtil.TAG, "ImageLoaderInfo:" + info.toJson().toString());
                b.q(info);
            }
        });
    }
}
