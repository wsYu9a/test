package com.alimm.tanx.ui.image.glide.load.engine.cache;

import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.util.LruCache;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
class SafeKeyGenerator {
    private final LruCache<Key, String> loadIdToSafeHash = new LruCache<>(1000);

    public String getSafeKey(Key key) {
        String str;
        synchronized (this.loadIdToSafeHash) {
            str = this.loadIdToSafeHash.get(key);
        }
        if (str == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                key.updateDiskCacheKey(messageDigest);
                str = Util.sha256BytesToHex(messageDigest.digest());
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
            } catch (NoSuchAlgorithmException e11) {
                e11.printStackTrace();
            }
            synchronized (this.loadIdToSafeHash) {
                this.loadIdToSafeHash.put(key, str);
            }
        }
        return str;
    }
}
