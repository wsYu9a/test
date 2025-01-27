package com.opos.exoplayer.core.metadata;

import com.opos.exoplayer.core.Format;

/* loaded from: classes4.dex */
public interface c {

    /* renamed from: a */
    public static final c f19096a = new c() { // from class: com.opos.exoplayer.core.metadata.c.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.metadata.c
        public boolean a(Format format) {
            String str = format.f17496f;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str);
        }

        @Override // com.opos.exoplayer.core.metadata.c
        public a b(Format format) {
            String str = format.f17496f;
            str.hashCode();
            switch (str) {
                case "application/id3":
                    return new com.opos.exoplayer.core.metadata.id3.a();
                case "application/x-emsg":
                    return new com.opos.exoplayer.core.metadata.emsg.a();
                case "application/x-scte35":
                    return new com.opos.exoplayer.core.metadata.scte35.a();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }
    };

    /* renamed from: com.opos.exoplayer.core.metadata.c$1 */
    static final class AnonymousClass1 implements c {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.metadata.c
        public boolean a(Format format) {
            String str = format.f17496f;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str);
        }

        @Override // com.opos.exoplayer.core.metadata.c
        public a b(Format format) {
            String str = format.f17496f;
            str.hashCode();
            switch (str) {
                case "application/id3":
                    return new com.opos.exoplayer.core.metadata.id3.a();
                case "application/x-emsg":
                    return new com.opos.exoplayer.core.metadata.emsg.a();
                case "application/x-scte35":
                    return new com.opos.exoplayer.core.metadata.scte35.a();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }
    }

    boolean a(Format format);

    a b(Format format);
}
