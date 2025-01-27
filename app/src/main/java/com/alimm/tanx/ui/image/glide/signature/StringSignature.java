package com.alimm.tanx.ui.image.glide.signature;

import com.alimm.tanx.ui.image.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import ok.a;

/* loaded from: classes.dex */
public class StringSignature implements Key {
    private final String signature;

    public StringSignature(String str) {
        if (str == null) {
            throw new NullPointerException("Signature cannot be null!");
        }
        this.signature = str;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StringSignature.class != obj.getClass()) {
            return false;
        }
        return this.signature.equals(((StringSignature) obj).signature);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public int hashCode() {
        return this.signature.hashCode();
    }

    public String toString() {
        StringBuilder a10 = a.a("StringSignature{signature='");
        a10.append(this.signature);
        a10.append('\'');
        a10.append('}');
        return a10.toString();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.signature.getBytes("UTF-8"));
    }
}
