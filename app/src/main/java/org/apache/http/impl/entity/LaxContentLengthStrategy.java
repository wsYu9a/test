package org.apache.http.impl.entity;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.protocol.HTTP;

@Immutable
/* loaded from: classes5.dex */
public class LaxContentLengthStrategy implements ContentLengthStrategy {
    private final int implicitLen;

    public LaxContentLengthStrategy(int i2) {
        this.implicitLen = i2;
    }

    @Override // org.apache.http.entity.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage) throws HttpException {
        long j2;
        if (httpMessage == null) {
            throw new IllegalArgumentException("HTTP message may not be null");
        }
        boolean isParameterTrue = httpMessage.getParams().isParameterTrue(CoreProtocolPNames.STRICT_TRANSFER_ENCODING);
        Header firstHeader = httpMessage.getFirstHeader("Transfer-Encoding");
        if (firstHeader == null) {
            if (httpMessage.getFirstHeader("Content-Length") == null) {
                return this.implicitLen;
            }
            Header[] headers = httpMessage.getHeaders("Content-Length");
            if (isParameterTrue && headers.length > 1) {
                throw new ProtocolException("Multiple content length headers");
            }
            int length = headers.length - 1;
            while (true) {
                if (length < 0) {
                    j2 = -1;
                    break;
                }
                Header header = headers[length];
                try {
                    j2 = Long.parseLong(header.getValue());
                    break;
                } catch (NumberFormatException unused) {
                    if (isParameterTrue) {
                        throw new ProtocolException("Invalid content length: " + header.getValue());
                    }
                    length--;
                }
            }
            if (j2 >= 0) {
                return j2;
            }
            return -1L;
        }
        try {
            HeaderElement[] elements = firstHeader.getElements();
            if (isParameterTrue) {
                for (HeaderElement headerElement : elements) {
                    String name = headerElement.getName();
                    if (name != null && name.length() > 0 && !name.equalsIgnoreCase("chunked") && !name.equalsIgnoreCase(HTTP.IDENTITY_CODING)) {
                        throw new ProtocolException("Unsupported transfer encoding: " + name);
                    }
                }
            }
            int length2 = elements.length;
            if (HTTP.IDENTITY_CODING.equalsIgnoreCase(firstHeader.getValue())) {
                return -1L;
            }
            if (length2 > 0 && "chunked".equalsIgnoreCase(elements[length2 - 1].getName())) {
                return -2L;
            }
            if (isParameterTrue) {
                throw new ProtocolException("Chunk-encoding must be the last one applied");
            }
            return -1L;
        } catch (ParseException e2) {
            throw new ProtocolException("Invalid Transfer-Encoding header value: " + firstHeader, e2);
        }
    }

    public LaxContentLengthStrategy() {
        this(-1);
    }
}
