package org.apache.http.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
/* loaded from: classes5.dex */
public class HeaderGroup implements Cloneable, Serializable {
    private static final long serialVersionUID = 2608834160639271617L;
    private final List<Header> headers = new ArrayList(16);

    public void addHeader(Header header) {
        if (header == null) {
            return;
        }
        this.headers.add(header);
    }

    public void clear() {
        this.headers.clear();
    }

    public Object clone() throws CloneNotSupportedException {
        HeaderGroup headerGroup = (HeaderGroup) super.clone();
        headerGroup.headers.clear();
        headerGroup.headers.addAll(this.headers);
        return headerGroup;
    }

    public boolean containsHeader(String str) {
        for (int i2 = 0; i2 < this.headers.size(); i2++) {
            if (this.headers.get(i2).getName().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public HeaderGroup copy() {
        HeaderGroup headerGroup = new HeaderGroup();
        headerGroup.headers.addAll(this.headers);
        return headerGroup;
    }

    public Header[] getAllHeaders() {
        List<Header> list = this.headers;
        return (Header[]) list.toArray(new Header[list.size()]);
    }

    public Header getCondensedHeader(String str) {
        Header[] headers = getHeaders(str);
        if (headers.length == 0) {
            return null;
        }
        if (headers.length == 1) {
            return headers[0];
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
        charArrayBuffer.append(headers[0].getValue());
        for (int i2 = 1; i2 < headers.length; i2++) {
            charArrayBuffer.append(", ");
            charArrayBuffer.append(headers[i2].getValue());
        }
        return new BasicHeader(str.toLowerCase(Locale.ENGLISH), charArrayBuffer.toString());
    }

    public Header getFirstHeader(String str) {
        for (int i2 = 0; i2 < this.headers.size(); i2++) {
            Header header = this.headers.get(i2);
            if (header.getName().equalsIgnoreCase(str)) {
                return header;
            }
        }
        return null;
    }

    public Header[] getHeaders(String str) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.headers.size(); i2++) {
            Header header = this.headers.get(i2);
            if (header.getName().equalsIgnoreCase(str)) {
                arrayList.add(header);
            }
        }
        return (Header[]) arrayList.toArray(new Header[arrayList.size()]);
    }

    public Header getLastHeader(String str) {
        for (int size = this.headers.size() - 1; size >= 0; size--) {
            Header header = this.headers.get(size);
            if (header.getName().equalsIgnoreCase(str)) {
                return header;
            }
        }
        return null;
    }

    public HeaderIterator iterator() {
        return new BasicListHeaderIterator(this.headers, null);
    }

    public void removeHeader(Header header) {
        if (header == null) {
            return;
        }
        this.headers.remove(header);
    }

    public void setHeaders(Header[] headerArr) {
        clear();
        if (headerArr == null) {
            return;
        }
        for (Header header : headerArr) {
            this.headers.add(header);
        }
    }

    public String toString() {
        return this.headers.toString();
    }

    public void updateHeader(Header header) {
        if (header == null) {
            return;
        }
        for (int i2 = 0; i2 < this.headers.size(); i2++) {
            if (this.headers.get(i2).getName().equalsIgnoreCase(header.getName())) {
                this.headers.set(i2, header);
                return;
            }
        }
        this.headers.add(header);
    }

    public HeaderIterator iterator(String str) {
        return new BasicListHeaderIterator(this.headers, str);
    }
}
