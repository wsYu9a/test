package com.vivo.google.android.exoplayer3;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.vivo.google.android.exoplayer3.audio.AudioRendererEventListener;
import com.vivo.google.android.exoplayer3.metadata.MetadataRenderer;
import com.vivo.google.android.exoplayer3.text.TextRenderer;
import com.vivo.google.android.exoplayer3.video.VideoRendererEventListener;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class DefaultRenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    public static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    public static final String TAG = "DefaultRenderersFactory";
    public final long allowedVideoJoiningTimeMs;
    public final Context context;
    public final a0<b0> drmSessionManager;
    public final int extensionRendererMode;

    public DefaultRenderersFactory(Context context) {
        this(context, null);
    }

    public DefaultRenderersFactory(Context context, a0<b0> a0Var) {
        this(context, a0Var, 0);
    }

    public DefaultRenderersFactory(Context context, a0<b0> a0Var, int i2) {
        this(context, a0Var, i2, 5000L);
    }

    public DefaultRenderersFactory(Context context, a0<b0> a0Var, int i2, long j2) {
        this.context = context;
        this.drmSessionManager = a0Var;
        this.extensionRendererMode = i2;
        this.allowedVideoJoiningTimeMs = j2;
    }

    public k[] buildAudioProcessors() {
        return new k[0];
    }

    public void buildAudioRenderers(Context context, a0<b0> a0Var, k[] kVarArr, Handler handler, AudioRendererEventListener audioRendererEventListener, int i2, ArrayList<Renderer> arrayList) {
        int i3;
        arrayList.add(new p(d3.f27292a, a0Var, true, handler, audioRendererEventListener, j.a(context), kVarArr));
        if (i2 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i2 == 2) {
            size--;
        }
        try {
            i3 = size + 1;
            try {
                arrayList.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, k[].class).newInstance(handler, audioRendererEventListener, kVarArr));
            } catch (ClassNotFoundException | Exception unused) {
                size = i3;
                i3 = size;
                int i4 = i3 + 1;
                try {
                    arrayList.add(i3, (Renderer) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, k[].class).newInstance(handler, audioRendererEventListener, kVarArr));
                } catch (ClassNotFoundException | Exception unused2) {
                    i3 = i4;
                    i4 = i3;
                    arrayList.add(i4, (Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, k[].class).newInstance(handler, audioRendererEventListener, kVarArr));
                }
                arrayList.add(i4, (Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, k[].class).newInstance(handler, audioRendererEventListener, kVarArr));
            }
        } catch (ClassNotFoundException | Exception unused3) {
        }
        try {
            int i42 = i3 + 1;
            arrayList.add(i3, (Renderer) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, k[].class).newInstance(handler, audioRendererEventListener, kVarArr));
        } catch (ClassNotFoundException | Exception unused4) {
        }
        try {
            arrayList.add(i42, (Renderer) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, k[].class).newInstance(handler, audioRendererEventListener, kVarArr));
        } catch (ClassNotFoundException | Exception unused5) {
        }
    }

    public void buildMetadataRenderers(Context context, MetadataRenderer.Output output, Looper looper, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(output, looper));
    }

    public void buildMiscellaneousRenderers(Context context, Handler handler, int i2, ArrayList<Renderer> arrayList) {
    }

    public void buildTextRenderers(Context context, TextRenderer.Output output, Looper looper, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(output, looper));
    }

    public void buildVideoRenderers(Context context, a0<b0> a0Var, long j2, Handler handler, VideoRendererEventListener videoRendererEventListener, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new y6(context, d3.f27292a, j2, a0Var, false, handler, videoRendererEventListener, 50));
        if (i2 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i2 == 2) {
            size--;
        }
        try {
            arrayList.add(size, (Renderer) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Boolean.TRUE, Long.valueOf(j2), handler, videoRendererEventListener, 50));
        } catch (ClassNotFoundException | Exception unused) {
        }
    }

    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextRenderer.Output output, MetadataRenderer.Output output2) {
        ArrayList<Renderer> arrayList = new ArrayList<>();
        buildVideoRenderers(this.context, this.drmSessionManager, this.allowedVideoJoiningTimeMs, handler, videoRendererEventListener, this.extensionRendererMode, arrayList);
        buildAudioRenderers(this.context, this.drmSessionManager, buildAudioProcessors(), handler, audioRendererEventListener, this.extensionRendererMode, arrayList);
        buildTextRenderers(this.context, output, handler.getLooper(), this.extensionRendererMode, arrayList);
        buildMetadataRenderers(this.context, output2, handler.getLooper(), this.extensionRendererMode, arrayList);
        buildMiscellaneousRenderers(this.context, handler, this.extensionRendererMode, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[arrayList.size()]);
    }
}
