package com.vivo.google.android.exoplayer3;

/* loaded from: classes4.dex */
public interface b4 {

    /* renamed from: a */
    public static final b4 f27216a = new a();

    public static class a implements b4 {
        public z3 a(Format format) {
            String str = format.sampleMimeType;
            str.hashCode();
            switch (str) {
                case "application/dvbsubs":
                    return new k4(format.initializationData);
                case "application/x-mp4-vtt":
                    return new x4();
                case "text/vtt":
                    return new c5();
                case "application/x-quicktime-tx3g":
                    return new u4(format.initializationData);
                case "application/x-mp4-cea-608":
                case "application/cea-608":
                    return new e4(format.sampleMimeType, format.accessibilityChannel);
                case "application/cea-708":
                    return new g4(format.accessibilityChannel);
                case "application/x-subrip":
                    return new n4();
                case "application/ttml+xml":
                    return new p4();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }
    }
}
