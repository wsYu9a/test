package com.opos.mobad.r.a;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.TextureView;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: com.opos.mobad.r.a.c$1 */
    static final class AnonymousClass1 implements PixelCopy.OnPixelCopyFinishedListener {
        AnonymousClass1() {
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i2) {
        }
    }

    public static Bitmap a(Object obj, String str) {
        Bitmap bitmap = null;
        if (obj != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (obj instanceof TextureView) {
                    bitmap = ((TextureView) obj).getBitmap();
                } else if (obj instanceof SurfaceView) {
                    SurfaceView surfaceView = (SurfaceView) obj;
                    if (Build.VERSION.SDK_INT >= 25) {
                        bitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
                        PixelCopy.request(surfaceView, bitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.opos.mobad.r.a.c.1
                            AnonymousClass1() {
                            }

                            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                            public void onPixelCopyFinished(int i2) {
                            }
                        }, surfaceView.getHandler());
                    } else {
                        bitmap = b(str);
                    }
                }
                com.opos.cmn.an.f.a.b("VideoFrameUtils", "getFirstOrCurrentFrame end:" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception unused) {
                com.opos.cmn.an.f.a.b("VideoFrameUtils", "getFirstOrCurrentFrame fail");
            }
        }
        return bitmap;
    }

    public static Bitmap a(String str) {
        return a(str, true);
    }

    public static Bitmap a(String str, boolean z) {
        Bitmap bitmap = null;
        if (!TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("VideoFrameUtils", "video path = " + str);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                if (z) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                bitmap = mediaMetadataRetriever.getFrameAtTime(0L);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("VideoFrameUtils", e2.getStackTrace(), e2);
            }
            com.opos.cmn.an.f.a.b("VideoFrameUtils", "time = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
        return bitmap;
    }

    private static Bitmap b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http://127.0.0.1")) {
            return a(str);
        }
        if (str.startsWith("file")) {
            str = Uri.parse(str).getPath();
        }
        return c(str);
    }

    private static Bitmap c(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (new File(str).exists()) {
                return a(str, false);
            }
            com.opos.cmn.an.f.a.b("VideoFrameUtils", "local video is null");
        }
        return null;
    }
}
