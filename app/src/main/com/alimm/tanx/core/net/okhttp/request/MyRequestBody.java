package com.alimm.tanx.core.net.okhttp.request;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* loaded from: classes.dex */
public class MyRequestBody extends RequestBody {
    protected Listener tanxc_for;
    protected RequestBody tanxc_if;
    protected tanxc_do tanxc_int;

    public interface Listener {
        void onRequestProgress(long j10, long j11);
    }

    public final class tanxc_do extends ForwardingSink {
        private long tanxc_if;

        public tanxc_do(Sink sink) {
            super(sink);
            this.tanxc_if = 0L;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j10) throws IOException {
            super.write(buffer, j10);
            long j11 = this.tanxc_if + j10;
            this.tanxc_if = j11;
            MyRequestBody myRequestBody = MyRequestBody.this;
            myRequestBody.tanxc_for.onRequestProgress(j11, myRequestBody.contentLength());
        }
    }

    public MyRequestBody(RequestBody requestBody, Listener listener) {
        this.tanxc_if = requestBody;
        this.tanxc_for = listener;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        try {
            return this.tanxc_if.contentLength();
        } catch (IOException e10) {
            e10.printStackTrace();
            return -1L;
        }
    }

    @Override // okhttp3.RequestBody
    /* renamed from: contentType */
    public MediaType getContentType() {
        return this.tanxc_if.getContentType();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        tanxc_do tanxc_doVar = new tanxc_do(bufferedSink);
        this.tanxc_int = tanxc_doVar;
        BufferedSink buffer = Okio.buffer(tanxc_doVar);
        this.tanxc_if.writeTo(buffer);
        buffer.flush();
    }
}
