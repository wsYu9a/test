package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.params.CoreProtocolPNames;

@Immutable
/* loaded from: classes5.dex */
public class ResponseServer implements HttpResponseInterceptor {
    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        String str;
        if (httpResponse == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        if (httpResponse.containsHeader("Server") || (str = (String) httpResponse.getParams().getParameter(CoreProtocolPNames.ORIGIN_SERVER)) == null) {
            return;
        }
        httpResponse.addHeader("Server", str);
    }
}
