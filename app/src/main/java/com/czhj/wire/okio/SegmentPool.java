package com.czhj.wire.okio;

import android.support.v4.media.session.PlaybackStateCompat;

/* loaded from: classes2.dex */
final class SegmentPool {

    /* renamed from: a */
    public static final long f8957a = 65536;

    /* renamed from: b */
    public static Segment f8958b;

    /* renamed from: c */
    public static long f8959c;

    public static void a(Segment segment) {
        if (segment.f8955f != null || segment.f8956g != null) {
            throw new IllegalArgumentException();
        }
        if (segment.f8953d) {
            return;
        }
        synchronized (SegmentPool.class) {
            try {
                long j10 = f8959c + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                if (j10 > 65536) {
                    return;
                }
                f8959c = j10;
                segment.f8955f = f8958b;
                segment.f8952c = 0;
                segment.f8951b = 0;
                f8958b = segment;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static Segment a() {
        synchronized (SegmentPool.class) {
            try {
                Segment segment = f8958b;
                if (segment == null) {
                    return new Segment();
                }
                f8958b = segment.f8955f;
                segment.f8955f = null;
                f8959c -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return segment;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
