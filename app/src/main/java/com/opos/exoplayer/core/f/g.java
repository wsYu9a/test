package com.opos.exoplayer.core.f;

import com.opos.exoplayer.core.Format;

/* loaded from: classes4.dex */
public interface g {

    /* renamed from: a */
    public static final g f18747a = new g() { // from class: com.opos.exoplayer.core.f.g.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.f.g
        public boolean a(Format format) {
            String str = format.f17496f;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str);
        }

        @Override // com.opos.exoplayer.core.f.g
        public e b(Format format) {
            e aVar;
            String str = format.f17496f;
            str.hashCode();
            switch (str) {
                case "application/dvbsubs":
                    aVar = new com.opos.exoplayer.core.f.b.a(format.f17498h);
                    break;
                case "application/pgs":
                    return new com.opos.exoplayer.core.f.c.a();
                case "application/x-mp4-vtt":
                    return new com.opos.exoplayer.core.f.h.a();
                case "text/vtt":
                    return new com.opos.exoplayer.core.f.h.e();
                case "application/x-quicktime-tx3g":
                    aVar = new com.opos.exoplayer.core.f.g.a(format.f17498h);
                    break;
                case "text/x-ssa":
                    aVar = new com.opos.exoplayer.core.f.d.a(format.f17498h);
                    break;
                case "application/x-mp4-cea-608":
                case "application/cea-608":
                    aVar = new com.opos.exoplayer.core.f.a.a(format.f17496f, format.z);
                    break;
                case "application/cea-708":
                    aVar = new com.opos.exoplayer.core.f.a.b(format.z);
                    break;
                case "application/x-subrip":
                    return new com.opos.exoplayer.core.f.e.a();
                case "application/ttml+xml":
                    return new com.opos.exoplayer.core.f.f.a();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
            return aVar;
        }
    };

    /* renamed from: com.opos.exoplayer.core.f.g$1 */
    static final class AnonymousClass1 implements g {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.f.g
        public boolean a(Format format) {
            String str = format.f17496f;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str);
        }

        @Override // com.opos.exoplayer.core.f.g
        public e b(Format format) {
            e aVar;
            String str = format.f17496f;
            str.hashCode();
            switch (str) {
                case "application/dvbsubs":
                    aVar = new com.opos.exoplayer.core.f.b.a(format.f17498h);
                    break;
                case "application/pgs":
                    return new com.opos.exoplayer.core.f.c.a();
                case "application/x-mp4-vtt":
                    return new com.opos.exoplayer.core.f.h.a();
                case "text/vtt":
                    return new com.opos.exoplayer.core.f.h.e();
                case "application/x-quicktime-tx3g":
                    aVar = new com.opos.exoplayer.core.f.g.a(format.f17498h);
                    break;
                case "text/x-ssa":
                    aVar = new com.opos.exoplayer.core.f.d.a(format.f17498h);
                    break;
                case "application/x-mp4-cea-608":
                case "application/cea-608":
                    aVar = new com.opos.exoplayer.core.f.a.a(format.f17496f, format.z);
                    break;
                case "application/cea-708":
                    aVar = new com.opos.exoplayer.core.f.a.b(format.z);
                    break;
                case "application/x-subrip":
                    return new com.opos.exoplayer.core.f.e.a();
                case "application/ttml+xml":
                    return new com.opos.exoplayer.core.f.f.a();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
            return aVar;
        }
    }

    boolean a(Format format);

    e b(Format format);
}
