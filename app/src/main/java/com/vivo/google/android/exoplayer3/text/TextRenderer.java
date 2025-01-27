package com.vivo.google.android.exoplayer3.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vivo.google.android.exoplayer3.C0922c;
import com.vivo.google.android.exoplayer3.ExoPlaybackException;
import com.vivo.google.android.exoplayer3.Format;
import com.vivo.google.android.exoplayer3.a;
import com.vivo.google.android.exoplayer3.a4;
import com.vivo.google.android.exoplayer3.b4;
import com.vivo.google.android.exoplayer3.c4;
import com.vivo.google.android.exoplayer3.d4;
import com.vivo.google.android.exoplayer3.g1;
import com.vivo.google.android.exoplayer3.z3;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class TextRenderer extends a implements Handler.Callback {
    public static final int MSG_UPDATE_OUTPUT = 0;
    public static final int REPLACEMENT_STATE_NONE = 0;
    public static final int REPLACEMENT_STATE_SIGNAL_END_OF_STREAM = 1;
    public static final int REPLACEMENT_STATE_WAIT_END_OF_STREAM = 2;
    public z3 decoder;
    public final b4 decoderFactory;
    public int decoderReplacementState;
    public final C0922c formatHolder;
    public boolean inputStreamEnded;
    public c4 nextInputBuffer;
    public d4 nextSubtitle;
    public int nextSubtitleEventIndex;
    public final Output output;
    public final Handler outputHandler;
    public boolean outputStreamEnded;
    public Format streamFormat;
    public d4 subtitle;

    public interface Output {
        void onCues(List<Cue> list);
    }

    public TextRenderer(Output output, Looper looper) {
        this(output, looper, b4.f27216a);
    }

    public TextRenderer(Output output, Looper looper, b4 b4Var) {
        super(3);
        this.output = (Output) g1.a(output);
        this.outputHandler = looper == null ? null : new Handler(looper, this);
        this.decoderFactory = b4Var;
        this.formatHolder = new C0922c();
    }

    private void clearOutput() {
        updateOutput(Collections.emptyList());
    }

    private long getNextEventTime() {
        int i2 = this.nextSubtitleEventIndex;
        if (i2 == -1 || i2 >= this.subtitle.f27293c.a()) {
            return Long.MAX_VALUE;
        }
        d4 d4Var = this.subtitle;
        return d4Var.f27293c.a(this.nextSubtitleEventIndex) + d4Var.f27294d;
    }

    private void invokeUpdateOutputInternal(List<Cue> list) {
        this.output.onCues(list);
    }

    private void releaseBuffers() {
        this.nextInputBuffer = null;
        this.nextSubtitleEventIndex = -1;
        d4 d4Var = this.subtitle;
        if (d4Var != null) {
            d4Var.b();
            this.subtitle = null;
        }
        d4 d4Var2 = this.nextSubtitle;
        if (d4Var2 != null) {
            d4Var2.b();
            this.nextSubtitle = null;
        }
    }

    private void releaseDecoder() {
        releaseBuffers();
        this.decoder.release();
        this.decoder = null;
        this.decoderReplacementState = 0;
    }

    private void replaceDecoder() {
        releaseDecoder();
        this.decoder = ((b4.a) this.decoderFactory).a(this.streamFormat);
    }

    private void updateOutput(List<Cue> list) {
        Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            invokeUpdateOutputInternal(list);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        invokeUpdateOutputInternal((List) message.obj);
        return true;
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.vivo.google.android.exoplayer3.a
    public void onDisabled() {
        this.streamFormat = null;
        clearOutput();
        releaseDecoder();
    }

    @Override // com.vivo.google.android.exoplayer3.a
    public void onPositionReset(long j2, boolean z) {
        clearOutput();
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        if (this.decoderReplacementState != 0) {
            replaceDecoder();
        } else {
            releaseBuffers();
            this.decoder.flush();
        }
    }

    @Override // com.vivo.google.android.exoplayer3.a
    public void onStreamChanged(Format[] formatArr) {
        Format format = formatArr[0];
        this.streamFormat = format;
        if (this.decoder != null) {
            this.decoderReplacementState = 1;
        } else {
            this.decoder = ((b4.a) this.decoderFactory).a(format);
        }
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public void render(long j2, long j3) {
        boolean z;
        if (this.outputStreamEnded) {
            return;
        }
        if (this.nextSubtitle == null) {
            this.decoder.a(j2);
            try {
                this.nextSubtitle = this.decoder.b();
            } catch (a4 e2) {
                throw ExoPlaybackException.createForRenderer(e2, getIndex());
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.subtitle != null) {
            long nextEventTime = getNextEventTime();
            z = false;
            while (nextEventTime <= j2) {
                this.nextSubtitleEventIndex++;
                nextEventTime = getNextEventTime();
                z = true;
            }
        } else {
            z = false;
        }
        d4 d4Var = this.nextSubtitle;
        if (d4Var != null) {
            if (d4Var.c(4)) {
                if (!z && getNextEventTime() == Long.MAX_VALUE) {
                    if (this.decoderReplacementState == 2) {
                        replaceDecoder();
                    } else {
                        releaseBuffers();
                        this.outputStreamEnded = true;
                    }
                }
            } else if (this.nextSubtitle.f28255b <= j2) {
                d4 d4Var2 = this.subtitle;
                if (d4Var2 != null) {
                    d4Var2.b();
                }
                d4 d4Var3 = this.nextSubtitle;
                this.subtitle = d4Var3;
                this.nextSubtitle = null;
                this.nextSubtitleEventIndex = d4Var3.f27293c.a(j2 - d4Var3.f27294d);
                z = true;
            }
        }
        if (z) {
            d4 d4Var4 = this.subtitle;
            updateOutput(d4Var4.f27293c.b(j2 - d4Var4.f27294d));
        }
        if (this.decoderReplacementState == 2) {
            return;
        }
        while (!this.inputStreamEnded) {
            try {
                if (this.nextInputBuffer == null) {
                    c4 a2 = this.decoder.a();
                    this.nextInputBuffer = a2;
                    if (a2 == null) {
                        return;
                    }
                }
                if (this.decoderReplacementState == 1) {
                    c4 c4Var = this.nextInputBuffer;
                    c4Var.f28074a = 4;
                    this.decoder.a((z3) c4Var);
                    this.nextInputBuffer = null;
                    this.decoderReplacementState = 2;
                    return;
                }
                int readSource = readSource(this.formatHolder, this.nextInputBuffer, false);
                if (readSource == -4) {
                    if (this.nextInputBuffer.c(4)) {
                        this.inputStreamEnded = true;
                    } else {
                        c4 c4Var2 = this.nextInputBuffer;
                        c4Var2.f27257f = this.formatHolder.f27231a.subsampleOffsetUs;
                        c4Var2.f28192c.flip();
                    }
                    this.decoder.a((z3) this.nextInputBuffer);
                    this.nextInputBuffer = null;
                } else if (readSource == -3) {
                    return;
                }
            } catch (a4 e3) {
                throw ExoPlaybackException.createForRenderer(e3, getIndex());
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.g
    public int supportsFormat(Format format) {
        ((b4.a) this.decoderFactory).getClass();
        String str = format.sampleMimeType;
        if ("text/vtt".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        return com.baidu.mobads.sdk.internal.a.f5473b.equals(g1.c(format.sampleMimeType)) ? 1 : 0;
    }
}
