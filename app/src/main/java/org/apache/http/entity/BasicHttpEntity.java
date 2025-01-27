package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
/* loaded from: classes5.dex */
public class BasicHttpEntity extends AbstractHttpEntity {
    private InputStream content;
    private long length = -1;

    @Override // org.apache.http.entity.AbstractHttpEntity, org.apache.http.HttpEntity
    @Deprecated
    public void consumeContent() throws IOException {
        InputStream inputStream = this.content;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IllegalStateException {
        InputStream inputStream = this.content;
        if (inputStream != null) {
            return inputStream;
        }
        throw new IllegalStateException("Content has not been provided");
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.length;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return this.content != null;
    }

    public void setContent(InputStream inputStream) {
        this.content = inputStream;
    }

    public void setContentLength(long j2) {
        this.length = j2;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream content = getContent();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    return;
                } else {
                    outputStream.write(bArr, 0, read);
                }
            }
        } finally {
            content.close();
        }
    }
}
