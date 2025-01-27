package com.opos.exoplayer.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.vivo.google.android.exoplayer3.DefaultRenderersFactory;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class g implements v {

    /* renamed from: a */
    private final Context f18824a;

    /* renamed from: b */
    @Nullable
    private final com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> f18825b;

    /* renamed from: c */
    private final int f18826c;

    /* renamed from: d */
    private final long f18827d;

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar) {
        this(context, bVar, 0);
    }

    public g(Context context, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, int i2) {
        this(context, bVar, i2, 5000L);
    }

    public g(Context context, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, int i2, long j2) {
        this.f18824a = context;
        this.f18825b = bVar;
        this.f18826c = i2;
        this.f18827d = j2;
    }

    protected void a(Context context, Handler handler, int i2, ArrayList<s> arrayList) {
    }

    protected void a(Context context, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, long j2, Handler handler, com.opos.exoplayer.core.video.f fVar, int i2, ArrayList<s> arrayList) {
        arrayList.add(new com.opos.exoplayer.core.video.c(context, com.opos.exoplayer.core.d.c.f18355a, j2, bVar, false, handler, fVar, 50));
        if (i2 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i2 == 2) {
            size--;
        }
        try {
            arrayList.add(size, (s) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, com.opos.exoplayer.core.video.f.class, Integer.TYPE).newInstance(Boolean.TRUE, Long.valueOf(j2), handler, fVar, 50));
            com.opos.cmn.an.f.a.a(DefaultRenderersFactory.TAG, "Loaded LibvpxVideoRenderer.");
        } catch (ClassNotFoundException unused) {
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating VP9 extension", e2);
        }
    }

    protected void a(Context context, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, com.opos.exoplayer.core.a.d[] dVarArr, Handler handler, com.opos.exoplayer.core.a.e eVar, int i2, ArrayList<s> arrayList) {
        int i3;
        int i4;
        arrayList.add(new com.opos.exoplayer.core.a.i(com.opos.exoplayer.core.d.c.f18355a, bVar, true, handler, eVar, com.opos.exoplayer.core.a.c.a(context), dVarArr));
        if (i2 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i2 == 2) {
            size--;
        }
        try {
            try {
                i3 = size + 1;
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating Opus extension", e2);
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            try {
                arrayList.add(size, (s) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
                com.opos.cmn.an.f.a.a(DefaultRenderersFactory.TAG, "Loaded LibopusAudioRenderer.");
            } catch (ClassNotFoundException unused2) {
                size = i3;
                i3 = size;
                try {
                    i4 = i3 + 1;
                    arrayList.add(i3, (s) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
                    com.opos.cmn.an.f.a.a(DefaultRenderersFactory.TAG, "Loaded LibflacAudioRenderer.");
                    arrayList.add(i4, (s) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
                    com.opos.cmn.an.f.a.a(DefaultRenderersFactory.TAG, "Loaded FfmpegAudioRenderer.");
                    return;
                } catch (Exception e3) {
                    throw new RuntimeException("Error instantiating FLAC extension", e3);
                }
            }
            try {
                arrayList.add(i3, (s) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
                com.opos.cmn.an.f.a.a(DefaultRenderersFactory.TAG, "Loaded LibflacAudioRenderer.");
            } catch (ClassNotFoundException unused3) {
                i3 = i4;
                i4 = i3;
                arrayList.add(i4, (s) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
                com.opos.cmn.an.f.a.a(DefaultRenderersFactory.TAG, "Loaded FfmpegAudioRenderer.");
                return;
            }
            arrayList.add(i4, (s) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
            com.opos.cmn.an.f.a.a(DefaultRenderersFactory.TAG, "Loaded FfmpegAudioRenderer.");
            return;
        } catch (ClassNotFoundException unused4) {
            return;
        } catch (Exception e4) {
            throw new RuntimeException("Error instantiating FFmpeg extension", e4);
        }
        try {
            i4 = i3 + 1;
        } catch (ClassNotFoundException unused5) {
        }
    }

    protected void a(Context context, com.opos.exoplayer.core.f.j jVar, Looper looper, int i2, ArrayList<s> arrayList) {
        arrayList.add(new com.opos.exoplayer.core.f.k(jVar, looper));
    }

    protected void a(Context context, com.opos.exoplayer.core.metadata.e eVar, Looper looper, int i2, ArrayList<s> arrayList) {
        arrayList.add(new com.opos.exoplayer.core.metadata.f(eVar, looper));
    }

    protected com.opos.exoplayer.core.a.d[] a() {
        return new com.opos.exoplayer.core.a.d[0];
    }

    @Override // com.opos.exoplayer.core.v
    public s[] a(Handler handler, com.opos.exoplayer.core.video.f fVar, com.opos.exoplayer.core.a.e eVar, com.opos.exoplayer.core.f.j jVar, com.opos.exoplayer.core.metadata.e eVar2) {
        ArrayList<s> arrayList = new ArrayList<>();
        a(this.f18824a, this.f18825b, this.f18827d, handler, fVar, this.f18826c, arrayList);
        a(this.f18824a, this.f18825b, a(), handler, eVar, this.f18826c, arrayList);
        a(this.f18824a, jVar, handler.getLooper(), this.f18826c, arrayList);
        a(this.f18824a, eVar2, handler.getLooper(), this.f18826c, arrayList);
        a(this.f18824a, handler, this.f18826c, arrayList);
        return (s[]) arrayList.toArray(new s[arrayList.size()]);
    }
}
