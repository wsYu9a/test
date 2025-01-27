package com.vivo.google.android.exoplayer3.video;

import android.os.Handler;
import android.view.Surface;
import com.vivo.google.android.exoplayer3.Format;
import com.vivo.google.android.exoplayer3.decoder.DecoderCounters;
import com.vivo.google.android.exoplayer3.g1;
import com.vivo.google.android.exoplayer3.v6;

/* loaded from: classes4.dex */
public interface VideoRendererEventListener {

    public static final class EventDispatcher {
        public final Handler handler;
        public final VideoRendererEventListener listener;

        public class a extends v6 {

            /* renamed from: a */
            public final /* synthetic */ DecoderCounters f28171a;

            public a(DecoderCounters decoderCounters) {
                this.f28171a = decoderCounters;
            }

            @Override // com.vivo.google.android.exoplayer3.v6
            public void a() {
                EventDispatcher.this.listener.onVideoEnabled(this.f28171a);
            }
        }

        public class b extends v6 {

            /* renamed from: a */
            public final /* synthetic */ String f28173a;

            /* renamed from: b */
            public final /* synthetic */ long f28174b;

            /* renamed from: c */
            public final /* synthetic */ long f28175c;

            public b(String str, long j2, long j3) {
                this.f28173a = str;
                this.f28174b = j2;
                this.f28175c = j3;
            }

            @Override // com.vivo.google.android.exoplayer3.v6
            public void a() {
                EventDispatcher.this.listener.onVideoDecoderInitialized(this.f28173a, this.f28174b, this.f28175c);
            }
        }

        public class c extends v6 {

            /* renamed from: a */
            public final /* synthetic */ Format f28177a;

            public c(Format format) {
                this.f28177a = format;
            }

            @Override // com.vivo.google.android.exoplayer3.v6
            public void a() {
                EventDispatcher.this.listener.onVideoInputFormatChanged(this.f28177a);
            }
        }

        public class d extends v6 {

            /* renamed from: a */
            public final /* synthetic */ int f28179a;

            /* renamed from: b */
            public final /* synthetic */ long f28180b;

            public d(int i2, long j2) {
                this.f28179a = i2;
                this.f28180b = j2;
            }

            @Override // com.vivo.google.android.exoplayer3.v6
            public void a() {
                EventDispatcher.this.listener.onDroppedFrames(this.f28179a, this.f28180b);
            }
        }

        public class e extends v6 {

            /* renamed from: a */
            public final /* synthetic */ int f28182a;

            /* renamed from: b */
            public final /* synthetic */ int f28183b;

            /* renamed from: c */
            public final /* synthetic */ int f28184c;

            /* renamed from: d */
            public final /* synthetic */ float f28185d;

            public e(int i2, int i3, int i4, float f2) {
                this.f28182a = i2;
                this.f28183b = i3;
                this.f28184c = i4;
                this.f28185d = f2;
            }

            @Override // com.vivo.google.android.exoplayer3.v6
            public void a() {
                EventDispatcher.this.listener.onVideoSizeChanged(this.f28182a, this.f28183b, this.f28184c, this.f28185d);
            }
        }

        public class f extends v6 {

            /* renamed from: a */
            public final /* synthetic */ Surface f28187a;

            public f(Surface surface) {
                this.f28187a = surface;
            }

            @Override // com.vivo.google.android.exoplayer3.v6
            public void a() {
                EventDispatcher.this.listener.onRenderedFirstFrame(this.f28187a);
            }
        }

        public class g extends v6 {

            /* renamed from: a */
            public final /* synthetic */ DecoderCounters f28189a;

            public g(DecoderCounters decoderCounters) {
                this.f28189a = decoderCounters;
            }

            @Override // com.vivo.google.android.exoplayer3.v6
            public void a() {
                this.f28189a.ensureUpdated();
                EventDispatcher.this.listener.onVideoDisabled(this.f28189a);
            }
        }

        public EventDispatcher(Handler handler, VideoRendererEventListener videoRendererEventListener) {
            this.handler = videoRendererEventListener != null ? (Handler) g1.a(handler) : null;
            this.listener = videoRendererEventListener;
        }

        public void decoderInitialized(String str, long j2, long j3) {
            if (this.listener != null) {
                this.handler.post(new b(str, j2, j3));
            }
        }

        public void disabled(DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new g(decoderCounters));
            }
        }

        public void droppedFrames(int i2, long j2) {
            if (this.listener != null) {
                this.handler.post(new d(i2, j2));
            }
        }

        public void enabled(DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new a(decoderCounters));
            }
        }

        public void inputFormatChanged(Format format) {
            if (this.listener != null) {
                this.handler.post(new c(format));
            }
        }

        public void renderedFirstFrame(Surface surface) {
            if (this.listener != null) {
                this.handler.post(new f(surface));
            }
        }

        public void videoSizeChanged(int i2, int i3, int i4, float f2) {
            if (this.listener != null) {
                this.handler.post(new e(i2, i3, i4, f2));
            }
        }
    }

    void onDroppedFrames(int i2, long j2);

    void onRenderedFirstFrame(Surface surface);

    void onVideoDecoderInitialized(String str, long j2, long j3);

    void onVideoDisabled(DecoderCounters decoderCounters);

    void onVideoEnabled(DecoderCounters decoderCounters);

    void onVideoInputFormatChanged(Format format);

    void onVideoSizeChanged(int i2, int i3, int i4, float f2);
}
