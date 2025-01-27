package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.protocol.HTTP;

@NotThreadSafe
/* loaded from: classes5.dex */
public class StringEntity extends AbstractHttpEntity implements Cloneable {
    protected final byte[] content;

    public StringEntity(String str, ContentType contentType) {
        if (str == null) {
            throw new IllegalArgumentException("Source string may not be null");
        }
        Charset charset = contentType != null ? contentType.getCharset() : null;
        charset = charset == null ? HTTP.DEF_CONTENT_CHARSET : charset;
        try {
            this.content = str.getBytes(charset.name());
            if (contentType != null) {
                setContentType(contentType.toString());
            }
        } catch (UnsupportedEncodingException unused) {
            throw new UnsupportedCharsetException(charset.name());
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IOException {
        return new ByteArrayInputStream(this.content);
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.content.length;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        outputStream.write(this.content);
        outputStream.flush();
    }

    @Deprecated
    public StringEntity(String str, String str2, String str3) throws UnsupportedEncodingException {
        if (str != null) {
            str2 = str2 == null ? "text/plain" : str2;
            str3 = str3 == null ? "ISO-8859-1" : str3;
            this.content = str.getBytes(str3);
            setContentType(str2 + HTTP.CHARSET_PARAM + str3);
            return;
        }
        throw new IllegalArgumentException("Source string may not be null");
    }

    public StringEntity(String str, String str2) throws UnsupportedEncodingException {
        this(str, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), str2));
    }

    public StringEntity(String str, Charset charset) {
        this(str, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), charset));
    }

    public StringEntity(String str) throws UnsupportedEncodingException {
        this(str, ContentType.DEFAULT_TEXT);
    }
}
