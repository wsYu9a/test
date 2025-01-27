package y8;

import android.content.Context;
import java.util.Hashtable;
import u8.b;
import x8.j;
import x8.k;

/* loaded from: classes3.dex */
public abstract class d<Params extends u8.b, Data, Parser extends j> extends b<u8.b, Data> {

    /* renamed from: f */
    public static String f33070f = "UTF-8";

    /* renamed from: a */
    public Hashtable<String, String> f33071a;

    /* renamed from: b */
    public String f33072b;

    /* renamed from: c */
    public int f33073c;

    /* renamed from: d */
    public final Parser f33074d;

    /* renamed from: e */
    public Params f33075e;

    public d(Class<Params> cls, Context context, Parser parser, Hashtable<String, String> hashtable, String str) {
        this.f33073c = 20;
        this.f33071a = hashtable;
        this.f33072b = str;
        this.f33074d = parser;
        f(context);
        try {
            this.f33075e = cls.newInstance();
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (InstantiationException e11) {
            e11.printStackTrace();
        }
    }

    public void execute() {
        j();
    }

    public final void f(Context context) {
        if (this.f33071a == null) {
            this.f33071a = new Hashtable<>();
        }
        if (context == null) {
            return;
        }
        this.f33071a.put(m5.c.f28319k, context.getResources().getConfiguration().locale.toString().replace(hf.e.f26694a, "-"));
        this.f33071a.put(m5.c.f28331o, "close");
    }

    public void g(String str, String str2) {
        if (this.f33071a == null) {
            this.f33071a = new Hashtable<>();
        }
        this.f33071a.put(str, str2);
    }

    @Override // y8.b
    /* renamed from: h */
    public k doInBackground(u8.b bVar) {
        return this.f33074d.b(t8.b.d(bVar, this.f33071a, this.f33072b, this.f33073c));
    }

    public k i() {
        return super.executeBlocking(k());
    }

    public void j() {
        super.executeParallel(k());
    }

    public Params k() {
        return this.f33075e;
    }

    public Parser l() {
        return this.f33074d;
    }

    public void m(Params params) {
        this.f33075e = params;
    }

    public void n(int i10) {
        this.f33073c = i10;
    }

    public d(Class<Params> cls, Context context, Parser parser, Hashtable<String, String> hashtable) {
        this(cls, context, parser, hashtable, f33070f);
    }

    public d(Class<Params> cls, Context context, Parser parser, String str) {
        this(cls, context, parser, null, str);
    }

    public d(Class<Params> cls, Context context, Parser parser) {
        this(cls, context, parser, null, f33070f);
    }
}
