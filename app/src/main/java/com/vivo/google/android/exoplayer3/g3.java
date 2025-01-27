package com.vivo.google.android.exoplayer3;

/* loaded from: classes4.dex */
public interface g3 {

    /* renamed from: a */
    public static final g3 f27422a = new a();

    public static class a implements g3 {
        @Override // com.vivo.google.android.exoplayer3.g3
        public f3 a(Format format) {
            String str = format.sampleMimeType;
            str.hashCode();
            switch (str) {
                case "application/id3":
                    return new j3(null);
                case "application/x-emsg":
                    return new i3();
                case "application/x-scte35":
                    return new k3();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }

        @Override // com.vivo.google.android.exoplayer3.g3
        public boolean supportsFormat(Format format) {
            String str = format.sampleMimeType;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str);
        }
    }

    f3 a(Format format);

    boolean supportsFormat(Format format);
}
