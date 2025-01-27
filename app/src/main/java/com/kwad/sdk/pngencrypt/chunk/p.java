package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: classes2.dex */
public abstract class p extends PngChunk {
    protected p(String str, com.kwad.sdk.pngencrypt.k kVar) {
        super(str, kVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.awG;
        String str2 = ((p) obj).awG;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.awG;
        return (str == null ? 0 : str.hashCode()) + 31;
    }
}
