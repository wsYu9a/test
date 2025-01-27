package com.alimm.tanx.core.view.player.cache.videocache.file;

import android.text.TextUtils;
import com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils;
import p1.b;

/* loaded from: classes.dex */
public class Md5FileNameGenerator implements FileNameGenerator {
    private static final int MAX_EXTENSION_LENGTH = 4;

    private String getExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || lastIndexOf + 6 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.file.FileNameGenerator
    public String generate(String str) {
        String extension = getExtension(str);
        String computeMD5 = ProxyCacheUtils.computeMD5(str);
        if (TextUtils.isEmpty(extension)) {
            return computeMD5;
        }
        return computeMD5 + b.f29697h + extension;
    }
}
