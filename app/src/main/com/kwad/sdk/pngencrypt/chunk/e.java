package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class e {
    final com.kwad.sdk.pngencrypt.k aOE;
    List<PngChunk> aQx = new ArrayList();
    boolean aQy = false;

    /* renamed from: com.kwad.sdk.pngencrypt.chunk.e$1 */
    public class AnonymousClass1 implements c {
        final /* synthetic */ String aQz;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.pngencrypt.chunk.c
        public final boolean a(PngChunk pngChunk) {
            return pngChunk.akr.equals(str);
        }
    }

    /* renamed from: com.kwad.sdk.pngencrypt.chunk.e$2 */
    public class AnonymousClass2 implements c {
        final /* synthetic */ String aQA;
        final /* synthetic */ String aQz;

        public AnonymousClass2(String str, String str2) {
            str = str;
            str2 = str2;
        }

        @Override // com.kwad.sdk.pngencrypt.chunk.c
        public final boolean a(PngChunk pngChunk) {
            if (!pngChunk.akr.equals(str)) {
                return false;
            }
            if (!(pngChunk instanceof t) || ((t) pngChunk).getKey().equals(str2)) {
                return !(pngChunk instanceof n) || ((n) pngChunk).Mi().equals(str2);
            }
            return false;
        }
    }

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.aOE = kVar;
    }

    private static List<PngChunk> a(List<PngChunk> list, String str, String str2) {
        return str2 == null ? b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
            final /* synthetic */ String aQz;

            public AnonymousClass1(String str3) {
                str = str3;
            }

            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                return pngChunk.akr.equals(str);
            }
        }) : b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            final /* synthetic */ String aQA;
            final /* synthetic */ String aQz;

            public AnonymousClass2(String str3, String str22) {
                str = str3;
                str2 = str22;
            }

            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                if (!pngChunk.akr.equals(str)) {
                    return false;
                }
                if (!(pngChunk instanceof t) || ((t) pngChunk).getKey().equals(str2)) {
                    return !(pngChunk instanceof n) || ((n) pngChunk).Mi().equals(str2);
                }
                return false;
            }
        });
    }

    public final List<PngChunk> LZ() {
        return this.aQx;
    }

    public final List<? extends PngChunk> al(String str, String str2) {
        return a(this.aQx, str, str2);
    }

    public String toString() {
        return "ChunkList: read: " + this.aQx.size();
    }

    public final void a(PngChunk pngChunk, int i10) {
        pngChunk.dS(i10);
        this.aQx.add(pngChunk);
        if (pngChunk.akr.equals("PLTE")) {
            this.aQy = true;
        }
    }
}
