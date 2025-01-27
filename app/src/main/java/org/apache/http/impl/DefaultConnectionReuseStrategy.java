package org.apache.http.impl;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.TokenIterator;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicTokenIterator;

@Immutable
/* loaded from: classes5.dex */
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    private boolean canResponseHaveBody(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        return (statusCode < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) ? false : true;
    }

    protected TokenIterator createTokenIterator(HeaderIterator headerIterator) {
        return new BasicTokenIterator(headerIterator);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x003c, code lost:
    
        if (java.lang.Integer.parseInt(r0[0].getValue()) < 0) goto L68;
     */
    @Override // org.apache.http.ConnectionReuseStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean keepAlive(org.apache.http.HttpResponse r6, org.apache.http.protocol.HttpContext r7) {
        /*
            r5 = this;
            if (r6 == 0) goto L8d
            if (r7 == 0) goto L85
            org.apache.http.StatusLine r7 = r6.getStatusLine()
            org.apache.http.ProtocolVersion r7 = r7.getProtocolVersion()
            java.lang.String r0 = "Transfer-Encoding"
            org.apache.http.Header r0 = r6.getFirstHeader(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L23
            java.lang.String r0 = r0.getValue()
            java.lang.String r3 = "chunked"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 != 0) goto L3f
            return r2
        L23:
            boolean r0 = r5.canResponseHaveBody(r6)
            if (r0 == 0) goto L3f
            java.lang.String r0 = "Content-Length"
            org.apache.http.Header[] r0 = r6.getHeaders(r0)
            int r3 = r0.length
            if (r3 != r1) goto L3e
            r0 = r0[r2]
            java.lang.String r0 = r0.getValue()     // Catch: java.lang.NumberFormatException -> L3e
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L3e
            if (r0 >= 0) goto L3f
        L3e:
            return r2
        L3f:
            java.lang.String r0 = "Connection"
            org.apache.http.HeaderIterator r0 = r6.headerIterator(r0)
            boolean r3 = r0.hasNext()
            if (r3 != 0) goto L51
            java.lang.String r0 = "Proxy-Connection"
            org.apache.http.HeaderIterator r0 = r6.headerIterator(r0)
        L51:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L7d
            org.apache.http.TokenIterator r6 = r5.createTokenIterator(r0)     // Catch: org.apache.http.ParseException -> L7c
            r0 = 0
        L5c:
            boolean r3 = r6.hasNext()     // Catch: org.apache.http.ParseException -> L7c
            if (r3 == 0) goto L79
            java.lang.String r3 = r6.nextToken()     // Catch: org.apache.http.ParseException -> L7c
            java.lang.String r4 = "Close"
            boolean r4 = r4.equalsIgnoreCase(r3)     // Catch: org.apache.http.ParseException -> L7c
            if (r4 == 0) goto L6f
            return r2
        L6f:
            java.lang.String r4 = "Keep-Alive"
            boolean r3 = r4.equalsIgnoreCase(r3)     // Catch: org.apache.http.ParseException -> L7c
            if (r3 == 0) goto L5c
            r0 = 1
            goto L5c
        L79:
            if (r0 == 0) goto L7d
            return r1
        L7c:
            return r2
        L7d:
            org.apache.http.HttpVersion r6 = org.apache.http.HttpVersion.HTTP_1_0
            boolean r6 = r7.lessEquals(r6)
            r6 = r6 ^ r1
            return r6
        L85:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "HTTP context may not be null."
            r6.<init>(r7)
            throw r6
        L8d:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "HTTP response may not be null."
            r6.<init>(r7)
            goto L96
        L95:
            throw r6
        L96:
            goto L95
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.DefaultConnectionReuseStrategy.keepAlive(org.apache.http.HttpResponse, org.apache.http.protocol.HttpContext):boolean");
    }
}
