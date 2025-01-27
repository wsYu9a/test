package com.jd.ad.sdk.jad_ly;

import android.text.TextUtils;
import com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;
import com.jd.ad.sdk.dl.error.JADError;

/* loaded from: classes2.dex */
public class jad_bo {
    public SplashRenderVideoHelper jad_an = null;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        if (android.text.TextUtils.isEmpty(r7) == false) goto L241;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x00b7 -> B:40:0x00d4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_an(com.jd.ad.sdk.jad_ly.jad_bo r4, android.content.Context r5, java.io.InputStream r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ly.jad_bo.jad_an(com.jd.ad.sdk.jad_ly.jad_bo, android.content.Context, java.io.InputStream, java.lang.String):java.lang.String");
    }

    public final void jad_an(VideoLoadListener videoLoadListener, int i10, String str) {
        if (videoLoadListener == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        videoLoadListener.onLoadFailure(i10, str);
    }
}
