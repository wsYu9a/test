package com.alimm.tanx.ui.image.glide;

import com.alimm.tanx.ui.image.glide.request.FutureTarget;
import com.alimm.tanx.ui.image.glide.request.target.Target;
import java.io.File;

/* loaded from: classes.dex */
interface DownloadOptions {
    FutureTarget<File> downloadOnly(int i10, int i11);

    <Y extends Target<File>> Y downloadOnly(Y y10);
}
