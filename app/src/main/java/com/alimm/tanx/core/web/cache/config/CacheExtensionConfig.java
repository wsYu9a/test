package com.alimm.tanx.core.web.cache.config;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.a;
import java.util.HashSet;
import p1.b;
import vb.e;

/* loaded from: classes.dex */
public class CacheExtensionConfig {
    private static final HashSet STATIC = new HashSet() { // from class: com.alimm.tanx.core.web.cache.config.CacheExtensionConfig.1
        {
            add("js");
            add("ico");
            add("css");
            add("png");
            add("jpg");
            add("jpeg");
            add("gif");
            add("bmp");
            add("ttf");
            add("woff");
            add("woff2");
            add("otf");
            add("eot");
            add("svg");
            add("xml");
            add("swf");
            add(e.f31296c);
            add("text");
            add("conf");
            add("webp");
        }
    };
    private static final HashSet NO_CACH = new HashSet() { // from class: com.alimm.tanx.core.web.cache.config.CacheExtensionConfig.2
        {
            add("mp4");
            add("mp3");
            add("ogg");
            add("avi");
            add("wmv");
            add("flv");
            add("rmvb");
            add("3gp");
        }
    };
    private final HashSet statics = new HashSet(STATIC);
    private final HashSet no_cache = new HashSet(NO_CACH);

    private static void add(HashSet hashSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashSet.add(str.replace(b.f29697h, "").toLowerCase().trim());
    }

    public static void addGlobalExtension(String str) {
        add(STATIC, str);
    }

    private static void remove(HashSet hashSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        hashSet.remove(str.replace(b.f29697h, "").toLowerCase().trim());
    }

    public static void removeGlobalExtension(String str) {
        remove(STATIC, str);
    }

    public CacheExtensionConfig addExtension(String str) {
        add(this.statics, str);
        return this;
    }

    public boolean canCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.toLowerCase().trim();
        if (STATIC.contains(trim)) {
            return true;
        }
        return this.statics.contains(trim);
    }

    public void clearAll() {
        clearDiskExtension();
    }

    public void clearDiskExtension() {
        this.statics.clear();
    }

    public boolean isHtml(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains(a.f6640f) || str.toLowerCase().contains("htm");
    }

    public boolean isMedia(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (NO_CACH.contains(str)) {
            return true;
        }
        return this.no_cache.contains(str.toLowerCase().trim());
    }

    public CacheExtensionConfig removeExtension(String str) {
        remove(this.statics, str);
        return this;
    }
}
