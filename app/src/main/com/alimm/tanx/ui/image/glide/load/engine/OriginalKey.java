package com.alimm.tanx.ui.image.glide.load.engine;

import com.alimm.tanx.ui.image.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* loaded from: classes.dex */
class OriginalKey implements Key {

    /* renamed from: id */
    private final String f6329id;
    private final Key signature;

    public OriginalKey(String str, Key key) {
        this.f6329id = str;
        this.signature = key;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || OriginalKey.class != obj.getClass()) {
            return false;
        }
        OriginalKey originalKey = (OriginalKey) obj;
        return this.f6329id.equals(originalKey.f6329id) && this.signature.equals(originalKey.signature);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public int hashCode() {
        return this.signature.hashCode() + (this.f6329id.hashCode() * 31);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f6329id.getBytes("UTF-8"));
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
