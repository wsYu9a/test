package t8;

import com.martian.libcomm.http.requests.HttpGetParams;
import com.martian.libcomm.http.requests.HttpPostParams;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    public static final String f30764a = "b";

    /* renamed from: b */
    public static final OkHttpClient f30765b = new OkHttpClient.Builder().connectionPool(new ConnectionPool(5, 4, TimeUnit.SECONDS)).dns(new z8.a()).addInterceptor(new s8.a()).build();

    public static w8.a a(String str, Hashtable<String, String> hashtable, int i10) {
        Response execute;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = f30765b.newBuilder().connectTimeout(i10 / 2, timeUnit).readTimeout(i10, timeUnit).build();
        Request.Builder url = new Request.Builder().url(str);
        if (hashtable != null) {
            for (Map.Entry<String, String> entry : hashtable.entrySet()) {
                url.addHeader(entry.getKey(), entry.getValue());
            }
        }
        Call newCall = build.newCall(url.build());
        w8.a aVar = new w8.a();
        try {
            execute = newCall.execute();
        } catch (Exception e10) {
            e10.printStackTrace();
            aVar.h("网络异常");
            aVar.j(e(e10));
        }
        if (execute.body() == null) {
            throw new IOException("empty body " + aVar);
        }
        String string = execute.body().string();
        aVar.g(execute.code());
        aVar.h(string);
        execute.close();
        return aVar;
    }

    public static w8.a b(HttpGetParams httpGetParams, Hashtable<String, String> hashtable, String str, int i10) {
        return a(httpGetParams.toHttpUrl(str), hashtable, i10);
    }

    public static w8.a c(HttpPostParams httpPostParams, Hashtable<String, String> hashtable, String str, int i10) {
        Response execute;
        OkHttpClient.Builder newBuilder = f30765b.newBuilder();
        long j10 = i10 / 2;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = newBuilder.connectTimeout(j10, timeUnit).readTimeout(j10, timeUnit).build();
        Request.Builder post = new Request.Builder().url(httpPostParams.toHttpUrl(str)).post(httpPostParams.toPostContent(str));
        if (hashtable != null) {
            for (Map.Entry<String, String> entry : hashtable.entrySet()) {
                post.addHeader(entry.getKey(), entry.getValue());
            }
        }
        Call newCall = build.newCall(post.build());
        w8.a aVar = new w8.a();
        try {
            execute = newCall.execute();
        } catch (Exception e10) {
            e10.printStackTrace();
            aVar.h("网络异常");
        }
        if (execute.body() == null) {
            throw new IOException("empty body " + aVar);
        }
        String string = execute.body().string();
        aVar.g(execute.code());
        aVar.h(string);
        execute.close();
        return aVar;
    }

    public static w8.a d(u8.b bVar, Hashtable<String, String> hashtable, String str, int i10) {
        if (bVar instanceof HttpGetParams) {
            return b((HttpGetParams) bVar, hashtable, str, i10);
        }
        if (bVar instanceof HttpPostParams) {
            return c((HttpPostParams) bVar, hashtable, str, i10);
        }
        w8.a aVar = new w8.a();
        aVar.h("Invalid HttpRequestParams class.");
        return aVar;
    }

    public static String e(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            if (th2.getCause() != null) {
                th2.getCause().printStackTrace(printWriter);
            } else {
                th2.printStackTrace(printWriter);
            }
            printWriter.flush();
            stringWriter.flush();
            String obj = stringWriter.toString();
            printWriter.close();
            stringWriter.close();
            return obj;
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
