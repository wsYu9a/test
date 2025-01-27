package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: classes3.dex */
public abstract class p extends PngChunk {
    public p(String str, com.kwad.sdk.pngencrypt.k kVar) {
        super(str, kVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        String str = this.akr;
        if (str == null) {
            if (pVar.akr != null) {
                return false;
            }
        } else if (!str.equals(pVar.akr)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.akr;
        return (str == null ? 0 : str.hashCode()) + 31;
    }
}
