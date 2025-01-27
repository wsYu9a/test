package b.b.a.e;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.exception.NetErrorException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    static a f4270a;

    public static String a(HttpResponse httpResponse) throws NetErrorException {
        StatusLine statusLine = httpResponse.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        HttpEntity entity = httpResponse.getEntity();
        InputStream inputStream = null;
        try {
            try {
                InputStream content = entity.getContent();
                if (statusLine.getStatusCode() != 200 || content == null) {
                    throw new NetErrorException(statusCode + " " + statusLine.getReasonPhrase());
                }
                Header contentEncoding = entity.getContentEncoding();
                if (contentEncoding != null && contentEncoding.getValue().contains("gzip")) {
                    content = new GZIPInputStream(content);
                }
                int contentLength = (int) entity.getContentLength();
                if (contentLength < 0) {
                    contentLength = 4096;
                }
                String contentCharSet = EntityUtils.getContentCharSet(entity);
                if (contentCharSet == null) {
                    contentCharSet = "UTF-8";
                }
                InputStreamReader inputStreamReader = new InputStreamReader(content, contentCharSet);
                CharArrayBuffer charArrayBuffer = new CharArrayBuffer(contentLength);
                char[] cArr = new char[1024];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    charArrayBuffer.append(cArr, 0, read);
                }
                String charArrayBuffer2 = charArrayBuffer.toString();
                try {
                    content.close();
                } catch (Exception unused) {
                }
                return charArrayBuffer2;
            } catch (Exception unused2) {
                throw new NetErrorException();
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    private static HttpResponse b(Context context, String str, String str2, b.b.a.c.c cVar) throws NetErrorException {
        a aVar = f4270a;
        if (aVar == null) {
            f4270a = new a(context, str);
        } else if (!TextUtils.equals(str, aVar.f4266b)) {
            f4270a.f4266b = str;
        }
        a aVar2 = f4270a;
        return cVar != null ? aVar2.b(str2, cVar) : aVar2.b(str2, null);
    }

    private static void c() {
        f4270a = null;
    }
}
