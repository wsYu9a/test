package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.internal.x;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes2.dex */
public class ci implements Observer {

    /* renamed from: a */
    private static final String f7026a = "APKParser";

    /* renamed from: g */
    private static final String f7027g = "__xadsdk_downloaded__version__";

    /* renamed from: h */
    private static final String f7028h = "version";

    /* renamed from: b */
    private Context f7029b;

    /* renamed from: c */
    private URL f7030c;

    /* renamed from: d */
    private String f7031d;

    /* renamed from: e */
    private final bx f7032e;

    /* renamed from: f */
    private a f7033f;

    /* renamed from: i */
    private SharedPreferences f7034i;

    /* renamed from: j */
    private SharedPreferences.OnSharedPreferenceChangeListener f7035j;

    public interface a {
        void a(bx bxVar);

        void b(bx bxVar);
    }

    public ci(Context context, URL url, bx bxVar, a aVar) {
        this.f7030c = null;
        this.f7031d = null;
        this.f7035j = new cj(this);
        this.f7030c = url;
        this.f7032e = bxVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        this.f7029b = context;
        this.f7033f = aVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f7027g, 0);
        this.f7034i = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.f7035j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        x xVar = (x) observable;
        if (xVar.l() == x.a.COMPLETED) {
            this.f7033f.a(new bx(this.f7032e, xVar.g(), Boolean.TRUE));
        }
        if (xVar.l() == x.a.ERROR) {
            this.f7033f.b(new bx(this.f7032e, xVar.g(), Boolean.FALSE));
        }
    }

    public void a(String str, String str2) {
        al alVar = new al(this.f7029b, this.f7031d != null ? new URL(this.f7031d) : this.f7030c, str, str2, false);
        alVar.addObserver(this);
        alVar.a();
        SharedPreferences.Editor edit = this.f7034i.edit();
        edit.putString(f7028h, this.f7032e.toString());
        edit.apply();
    }

    public ci(Context context, String str, bx bxVar, a aVar) {
        this.f7030c = null;
        this.f7031d = null;
        this.f7035j = new cj(this);
        this.f7031d = str;
        this.f7032e = bxVar;
        a(context, aVar);
    }
}
