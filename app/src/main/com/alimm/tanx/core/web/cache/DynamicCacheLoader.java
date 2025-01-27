package com.alimm.tanx.core.web.cache;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public class DynamicCacheLoader {
    private static volatile DynamicCacheLoader INSTANCE;

    public static DynamicCacheLoader getInstance() {
        if (INSTANCE == null) {
            synchronized (DynamicCacheLoader.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new DynamicCacheLoader();
                    }
                } finally {
                }
            }
        }
        return INSTANCE;
    }

    public File getResByUrl(File file, String str) {
        String urlPath = getUrlPath(str);
        if (!file.isDirectory()) {
            if (urlPath.endsWith(file.getName())) {
                return file;
            }
            return null;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                File resByUrl = getResByUrl(file2, str);
                if (resByUrl != null) {
                    return resByUrl;
                }
            } else if (urlPath.endsWith(file2.getName())) {
                return file2;
            }
        }
        return null;
    }

    public String getUrlPath(String str) {
        try {
            String path = new URL(str).getPath();
            return path.startsWith("/") ? path.length() == 1 ? path : path.substring(1) : path;
        } catch (MalformedURLException e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
