package com.alimm.tanx.core.view.player.cache;

import android.content.Context;
import com.alimm.tanx.core.utils.FileUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer;
import com.alimm.tanx.core.view.player.cache.videocache.file.FileNameGenerator;
import com.alimm.tanx.core.view.player.cache.videocache.file.Md5FileNameGenerator;
import com.sigmob.sdk.videocache.file.b;
import java.io.File;

/* loaded from: classes.dex */
public class ProxyCacheManager {
    public static final String CACHE_DIR = "video-cache";
    public static final int MAX_CACHE_FILE = 10;
    public static File cacheRoot;
    public static FileNameGenerator fileNameGenerator;
    private static HttpProxyCacheServer sharedProxy;

    private ProxyCacheManager() {
    }

    public static boolean clearAllCache(Context context) {
        try {
            getProxy(context);
        } catch (Exception e10) {
            LogUtils.e("ProxyCacheManager", e10);
        }
        return FileUtil.deleteFiles(FileUtil.getIndividualCacheDirectory(context, "video-cache"));
    }

    public static File getCacheFile(String str) {
        return new File(cacheRoot, fileNameGenerator.generate(str));
    }

    public static HttpProxyCacheServer getProxy(Context context) {
        HttpProxyCacheServer httpProxyCacheServer = sharedProxy;
        if (httpProxyCacheServer != null) {
            return httpProxyCacheServer;
        }
        HttpProxyCacheServer newProxy = newProxy(context);
        sharedProxy = newProxy;
        return newProxy;
    }

    public static File getTempCacheFile(String str) {
        return new File(cacheRoot, fileNameGenerator.generate(str) + b.f20592d);
    }

    private static HttpProxyCacheServer newProxy(Context context) {
        cacheRoot = FileUtil.getIndividualCacheDirectory(context, "video-cache");
        fileNameGenerator = new Md5FileNameGenerator();
        return new HttpProxyCacheServer.Builder(context).maxCacheFilesCount(10).cacheDirectory(cacheRoot).build();
    }
}
