package com.alimm.tanx.core.view.player.cache;

import android.content.Context;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.ut.core.thread.VideoSizeThreadPool;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.view.player.cache.VideoGetSizeManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import m5.c;

/* loaded from: classes.dex */
public class VideoGetSizeManager {
    private static final int CACHED_VIDEO_SIZE_MAX_NUM = 50;
    private static final String TAG = "VideoGetSizeManager";
    public static LinkedHashMap<String, Long> mCachedVideoSizeMap = new LinkedHashMap<String, Long>(50) { // from class: com.alimm.tanx.core.view.player.cache.VideoGetSizeManager.1
        public AnonymousClass1(int i10) {
            super(i10);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Long> entry) {
            return VideoGetSizeManager.mCachedVideoSizeMap.size() > 50;
        }
    };
    private static VideoGetSizeManager sPreloadManager;
    long tempSize = 50;

    /* renamed from: com.alimm.tanx.core.view.player.cache.VideoGetSizeManager$1 */
    public static class AnonymousClass1 extends LinkedHashMap<String, Long> {
        public AnonymousClass1(int i10) {
            super(i10);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Long> entry) {
            return VideoGetSizeManager.mCachedVideoSizeMap.size() > 50;
        }
    }

    private VideoGetSizeManager(Context context) {
    }

    public static VideoGetSizeManager getInstance(Context context) {
        if (sPreloadManager == null) {
            synchronized (VideoGetSizeManager.class) {
                try {
                    if (sPreloadManager == null) {
                        sPreloadManager = new VideoGetSizeManager(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return sPreloadManager;
    }

    public /* synthetic */ void lambda$getVideoSize$13(String str, ITanxAd iTanxAd) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestProperty(c.f28316j, "identity");
            long contentLength = httpURLConnection.getContentLength();
            if (contentLength > 0) {
                mCachedVideoSizeMap.put(str, Long.valueOf(contentLength));
                if (OrangeManager.getInstance().getThreshold(OrangeManager.FEED_VIDEO_MAX_SIZE) > -1) {
                    this.tempSize = OrangeManager.getInstance().getThreshold(OrangeManager.FEED_VIDEO_MAX_SIZE) * 1048576;
                }
                TanxCommonUt.fileSizeCheck(iTanxAd, contentLength, contentLength > this.tempSize ? 1 : 0, System.currentTimeMillis() - currentTimeMillis);
            }
            LogUtils.d(TAG, "视频:" + str + " 长度：" + httpURLConnection.getContentLength() + " 时间：" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e10) {
            e10.printStackTrace();
            LogUtils.e(TAG, e10);
        }
    }

    public void getVideoSize(ITanxAd iTanxAd) {
        LogUtils.d(TAG, "getVideoSize");
        String video = iTanxAd.getBidInfo().getCreativeItem().getVideo();
        if (isPreloaded(video)) {
            return;
        }
        VideoSizeThreadPool.post(new Runnable() { // from class: x1.a

            /* renamed from: c */
            public final /* synthetic */ String f31768c;

            /* renamed from: d */
            public final /* synthetic */ ITanxAd f31769d;

            public /* synthetic */ a(String video2, ITanxAd iTanxAd2) {
                video = video2;
                iTanxAd = iTanxAd2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoGetSizeManager.this.lambda$getVideoSize$13(video, iTanxAd);
            }
        });
    }

    public boolean isPreloaded(String str) {
        return mCachedVideoSizeMap.get(str) != null;
    }
}
