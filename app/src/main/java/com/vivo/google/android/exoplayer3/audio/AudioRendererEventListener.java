package com.vivo.google.android.exoplayer3.audio;

import android.os.Handler;
import com.vivo.google.android.exoplayer3.Format;
import com.vivo.google.android.exoplayer3.decoder.DecoderCounters;
import com.vivo.google.android.exoplayer3.g1;
import com.vivo.google.android.exoplayer3.v6;

/* loaded from: classes4.dex */
public interface AudioRendererEventListener {

    public static final class EventDispatcher {
        public final Handler handler;
        public final AudioRendererEventListener listener;

        public class a extends v6 {

            /* renamed from: a */
            public final /* synthetic */ DecoderCounters f27155a;

            public a(DecoderCounters decoderCounters) {
                this.f27155a = decoderCounters;
            }

            @Override // com.vivo.google.android.exoplayer3.v6
            public void a() {
                EventDispatcher.this.listener.onAudioEnabled(this.f27155a);
            }
        }

        public class b extends v6 {

            /* renamed from: a */
            public final /* synthetic */ String f27157a;

            /* renamed from: b */
            public final /* synthetic */ long f27158b;

            /* renamed from: c */
            public final /* synthetic */ long f27159c;

            public b(String str, long j2, long j3) {
                this.f27157a = str;
                this.f27158b = j2;
                this.f27159c = j3;
            }

            @Override // com.vivo.google.android.exoplayer3.v6
            public void a() {
                EventDispatcher.this.listener.onAudioDecoderInitialized(this.f27157a, this.f27158b, this.f27159c);
            }
        }

        public class c extends v6 {

            /* renamed from: a */
            public final /* synthetic */ Format f27161a;

            public c(Format format) {
                this.f27161a = format;
            }

            @Override // com.vivo.google.android.exoplayer3.v6
            public void a() {
                EventDispatcher.this.listener.onAudioInputFormatChanged(this.f27161a);
            }
        }

        public class d extends v6 {

            /* renamed from: a */
            public final /* synthetic */ int f27163a;

            /* renamed from: b */
            public final /* synthetic */ long f27164b;

            /* renamed from: c */
            public final /* synthetic */ long f27165c;

            public d(int i2, long j2, long j3) {
                this.f27163a = i2;
                this.f27164b = j2;
                this.f27165c = j3;
            }

            @Override // com.vivo.google.android.exoplayer3.v6
            public void a() {
                EventDispatcher.this.listener.onAudioTrackUnderrun(this.f27163a, this.f27164b, this.f27165c);
            }
        }

        public class e extends v6 {

            /* renamed from: a */
            public final /* synthetic */ DecoderCounters f27167a;

            public e(DecoderCounters decoderCounters) {
                this.f27167a = decoderCounters;
            }

            @Override // com.vivo.google.android.exoplayer3.v6
            public void a() {
                this.f27167a.ensureUpdated();
                EventDispatcher.this.listener.onAudioDisabled(this.f27167a);
            }
        }

        public class f extends v6 {

            /* renamed from: a */
            public final /* synthetic */ int f27169a;

            public f(int i2) {
                this.f27169a = i2;
            }

            @Override // com.vivo.google.android.exoplayer3.v6
            public void a() {
                EventDispatcher.this.listener.onAudioSessionId(this.f27169a);
            }
        }

        public EventDispatcher(Handler handler, AudioRendererEventListener audioRendererEventListener) {
            this.handler = audioRendererEventListener != null ? (Handler) g1.a(handler) : null;
            this.listener = audioRendererEventListener;
        }

        public void audioSessionId(int i2) {
            if (this.listener != null) {
                this.handler.post(new f(i2));
            }
        }

        public void audioTrackUnderrun(int i2, long j2, long j3) {
            if (this.listener != null) {
                this.handler.post(new d(i2, j2, j3));
            }
        }

        public void decoderInitialized(String str, long j2, long j3) {
            if (this.listener != null) {
                this.handler.post(new b(str, j2, j3));
            }
        }

        public void disabled(DecoderCounters decoderCounters) {
            if (this.listener != null) {
                this.handler.post(new e(decoderCounters));
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
    }

    void onAudioDecoderInitialized(String str, long j2, long j3);

    void onAudioDisabled(DecoderCounters decoderCounters);

    void onAudioEnabled(DecoderCounters decoderCounters);

    void onAudioInputFormatChanged(Format format);

    void onAudioSessionId(int i2);

    void onAudioTrackUnderrun(int i2, long j2, long j3);
}
