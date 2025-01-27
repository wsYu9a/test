package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class e {
    final com.kwad.sdk.pngencrypt.k auQ;
    List<PngChunk> awK = new ArrayList();
    boolean awL = false;

    /* renamed from: com.kwad.sdk.pngencrypt.chunk.e$1 */
    static class AnonymousClass1 implements c {
        final /* synthetic */ String awM;

        AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.pngencrypt.chunk.c
        public final boolean a(PngChunk pngChunk) {
            return pngChunk.awG.equals(str);
        }
    }

    /* renamed from: com.kwad.sdk.pngencrypt.chunk.e$2 */
    static class AnonymousClass2 implements c {
        final /* synthetic */ String awM;
        final /* synthetic */ String awN;

        AnonymousClass2(String str, String str2) {
            str = str;
            str2 = str2;
        }

        @Override // com.kwad.sdk.pngencrypt.chunk.c
        public final boolean a(PngChunk pngChunk) {
            if (!pngChunk.awG.equals(str)) {
                return false;
            }
            if (!(pngChunk instanceof t) || ((t) pngChunk).getKey().equals(str2)) {
                return !(pngChunk instanceof n) || ((n) pngChunk).Cg().equals(str2);
            }
            return false;
        }
    }

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.auQ = kVar;
    }

    private static List<PngChunk> a(List<PngChunk> list, String str, String str2) {
        return str2 == null ? b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
            final /* synthetic */ String awM;

            AnonymousClass1(String str3) {
                str = str3;
            }

            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                return pngChunk.awG.equals(str);
            }
        }) : b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            final /* synthetic */ String awM;
            final /* synthetic */ String awN;

            AnonymousClass2(String str3, String str22) {
                str = str3;
                str2 = str22;
            }

            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                if (!pngChunk.awG.equals(str)) {
                    return false;
                }
                if (!(pngChunk instanceof t) || ((t) pngChunk).getKey().equals(str2)) {
                    return !(pngChunk instanceof n) || ((n) pngChunk).Cg().equals(str2);
                }
                return false;
            }
        });
    }

    public final List<PngChunk> BX() {
        return this.awK;
    }

    public final List<? extends PngChunk> W(String str, String str2) {
        return a(this.awK, str, str2);
    }

    public final void a(PngChunk pngChunk, int i2) {
        pngChunk.bU(i2);
        this.awK.add(pngChunk);
        if (pngChunk.awG.equals("PLTE")) {
            this.awL = true;
        }
    }

    public String toString() {
        return "ChunkList: read: " + this.awK.size();
    }
}
