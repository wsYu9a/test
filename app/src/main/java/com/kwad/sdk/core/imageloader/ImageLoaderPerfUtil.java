package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.y;

/* loaded from: classes2.dex */
public class ImageLoaderPerfUtil {
    private static final String TAG = "ImageLoaderPerfUtil";

    /* renamed from: com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil$1 */
    static class AnonymousClass1 extends aw {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            ImageLoaderInfo info = ImageLoaderPerfUtil.getInfo();
            if (info.totalCount == 0) {
                b.w(ImageLoaderPerfUtil.TAG, "info.totalCount == 0");
                return;
            }
            b.d(ImageLoaderPerfUtil.TAG, "ImageLoaderInfo:" + info.toJson().toString());
            KSLoggerReporter.y(info.toJson());
        }
    }

    public static ImageLoaderInfo getInfo() {
        ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo();
        imageLoaderInfo.totalCount = y.DE();
        imageLoaderInfo.successCount = y.DF();
        imageLoaderInfo.failedCount = y.DG();
        imageLoaderInfo.duration = y.DD();
        return imageLoaderInfo;
    }

    public static void report() {
        g.execute(new aw() { // from class: com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                ImageLoaderInfo info = ImageLoaderPerfUtil.getInfo();
                if (info.totalCount == 0) {
                    b.w(ImageLoaderPerfUtil.TAG, "info.totalCount == 0");
                    return;
                }
                b.d(ImageLoaderPerfUtil.TAG, "ImageLoaderInfo:" + info.toJson().toString());
                KSLoggerReporter.y(info.toJson());
            }
        });
    }
}
