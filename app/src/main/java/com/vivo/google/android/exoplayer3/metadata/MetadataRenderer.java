package com.vivo.google.android.exoplayer3.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.vivo.google.android.exoplayer3.C0922c;
import com.vivo.google.android.exoplayer3.Format;
import com.vivo.google.android.exoplayer3.a;
import com.vivo.google.android.exoplayer3.f3;
import com.vivo.google.android.exoplayer3.g1;
import com.vivo.google.android.exoplayer3.g3;
import com.vivo.google.android.exoplayer3.h3;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class MetadataRenderer extends a implements Handler.Callback {
    public static final int MAX_PENDING_METADATA_COUNT = 5;
    public static final int MSG_INVOKE_RENDERER = 0;
    public final h3 buffer;
    public f3 decoder;
    public final g3 decoderFactory;
    public final C0922c formatHolder;
    public boolean inputStreamEnded;
    public final Output output;
    public final Handler outputHandler;
    public final Metadata[] pendingMetadata;
    public int pendingMetadataCount;
    public int pendingMetadataIndex;
    public final long[] pendingMetadataTimestamps;

    public interface Output {
        void onMetadata(Metadata metadata);
    }

    public MetadataRenderer(Output output, Looper looper) {
        this(output, looper, g3.f27422a);
    }

    public MetadataRenderer(Output output, Looper looper, g3 g3Var) {
        super(4);
        this.output = (Output) g1.a(output);
        this.outputHandler = looper == null ? null : new Handler(looper, this);
        this.decoderFactory = (g3) g1.a(g3Var);
        this.formatHolder = new C0922c();
        this.buffer = new h3();
        this.pendingMetadata = new Metadata[5];
        this.pendingMetadataTimestamps = new long[5];
    }

    private void flushPendingMetadata() {
        Arrays.fill(this.pendingMetadata, (Object) null);
        this.pendingMetadataIndex = 0;
        this.pendingMetadataCount = 0;
    }

    private void invokeRenderer(Metadata metadata) {
        Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            invokeRendererInternal(metadata);
        }
    }

    private void invokeRendererInternal(Metadata metadata) {
        this.output.onMetadata(metadata);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        invokeRendererInternal((Metadata) message.obj);
        return true;
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public boolean isEnded() {
        return this.inputStreamEnded;
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public boolean isReady() {
        return true;
    }

    @Override // com.vivo.google.android.exoplayer3.a
    public void onDisabled() {
        flushPendingMetadata();
        this.decoder = null;
    }

    @Override // com.vivo.google.android.exoplayer3.a
    public void onPositionReset(long j2, boolean z) {
        flushPendingMetadata();
        this.inputStreamEnded = false;
    }

    @Override // com.vivo.google.android.exoplayer3.a
    public void onStreamChanged(Format[] formatArr) {
        this.decoder = this.decoderFactory.a(formatArr[0]);
    }

    @Override // com.vivo.google.android.exoplayer3.Renderer
    public void render(long j2, long j3) {
        if (!this.inputStreamEnded && this.pendingMetadataCount < 5) {
            this.buffer.b();
            if (readSource(this.formatHolder, this.buffer, false) == -4) {
                if (this.buffer.c(4)) {
                    this.inputStreamEnded = true;
                } else if (!this.buffer.c(Integer.MIN_VALUE)) {
                    h3 h3Var = this.buffer;
                    h3Var.f27479f = this.formatHolder.f27231a.subsampleOffsetUs;
                    h3Var.f28192c.flip();
                    int i2 = (this.pendingMetadataIndex + this.pendingMetadataCount) % 5;
                    this.pendingMetadata[i2] = this.decoder.a(this.buffer);
                    this.pendingMetadataTimestamps[i2] = this.buffer.f28193d;
                    this.pendingMetadataCount++;
                }
            }
        }
        if (this.pendingMetadataCount > 0) {
            long[] jArr = this.pendingMetadataTimestamps;
            int i3 = this.pendingMetadataIndex;
            if (jArr[i3] <= j2) {
                invokeRenderer(this.pendingMetadata[i3]);
                Metadata[] metadataArr = this.pendingMetadata;
                int i4 = this.pendingMetadataIndex;
                metadataArr[i4] = null;
                this.pendingMetadataIndex = (i4 + 1) % 5;
                this.pendingMetadataCount--;
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.g
    public int supportsFormat(Format format) {
        return this.decoderFactory.supportsFormat(format) ? 3 : 0;
    }
}
