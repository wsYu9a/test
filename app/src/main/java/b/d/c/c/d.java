package b.d.c.c;

import android.content.Context;
import b.d.c.b.j;
import b.d.c.b.k;
import com.martian.libcomm.http.requests.b;
import java.util.Hashtable;
import org.apache.http.HttpHeaders;

/* loaded from: classes.dex */
public abstract class d<Params extends com.martian.libcomm.http.requests.b, Data, Parser extends j> extends c<com.martian.libcomm.http.requests.b, Data> {

    /* renamed from: a */
    public static String f4467a = "UTF-8";

    /* renamed from: b */
    protected Hashtable<String, String> f4468b;

    /* renamed from: c */
    protected String f4469c;

    /* renamed from: d */
    private final Parser f4470d;

    /* renamed from: e */
    private Params f4471e;

    public d(Class<Params> paramsClass, Context ctx, Parser parser, Hashtable<String, String> properties, String charset) {
        this.f4468b = properties;
        this.f4469c = charset;
        this.f4470d = parser;
        f(ctx);
        try {
            this.f4471e = paramsClass.newInstance();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
    }

    private void f(Context ctx) {
        if (this.f4468b == null) {
            this.f4468b = new Hashtable<>();
        }
        if (ctx == null) {
            return;
        }
        this.f4468b.put(HttpHeaders.ACCEPT_LANGUAGE, ctx.getResources().getConfiguration().locale.toString().replace("_", "-"));
        this.f4468b.put("Connection", "close");
    }

    public void execute() {
        j();
    }

    public void g(String name, String value) {
        if (this.f4468b == null) {
            this.f4468b = new Hashtable<>();
        }
        this.f4468b.put(name, value);
    }

    @Override // b.d.c.c.c
    /* renamed from: h */
    public k doInBackground(com.martian.libcomm.http.requests.b param) {
        return this.f4470d.a(b.d.c.a.b.e(param, this.f4468b, this.f4469c));
    }

    public k i() {
        return super.executeBlocking(k());
    }

    public void j() {
        super.executeParallel(k());
    }

    public Params k() {
        return this.f4471e;
    }

    public Parser l() {
        return this.f4470d;
    }

    public void m(Params params) {
        this.f4471e = params;
    }

    public d(Class<Params> paramsClass, Context ctx, Parser parser, Hashtable<String, String> properties) {
        this(paramsClass, ctx, parser, properties, f4467a);
    }

    public d(Class<Params> paramsClass, Context ctx, Parser parser, String charset) {
        this(paramsClass, ctx, parser, null, charset);
    }

    public d(Class<Params> paramsClass, Context ctx, Parser parser) {
        this(paramsClass, ctx, parser, null, f4467a);
    }
}
