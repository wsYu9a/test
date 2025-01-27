package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.internal.u;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes.dex */
public class cf implements Observer {

    /* renamed from: a */
    private static final String f5695a = "APKParser";

    /* renamed from: g */
    private static final String f5696g = "__xadsdk_downloaded__version__";

    /* renamed from: h */
    private static final String f5697h = "version";

    /* renamed from: b */
    private Context f5698b;

    /* renamed from: c */
    private URL f5699c;

    /* renamed from: d */
    private String f5700d;

    /* renamed from: e */
    private final bu f5701e;

    /* renamed from: f */
    private a f5702f;

    /* renamed from: i */
    private SharedPreferences f5703i;

    /* renamed from: j */
    private SharedPreferences.OnSharedPreferenceChangeListener f5704j;

    public interface a {
        void a(bu buVar);

        void b(bu buVar);
    }

    public cf(Context context, URL url, bu buVar, a aVar) {
        this.f5699c = null;
        this.f5700d = null;
        this.f5704j = new cg(this);
        this.f5699c = url;
        this.f5701e = buVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        this.f5698b = context;
        this.f5702f = aVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f5696g, 0);
        this.f5703i = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.f5704j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        u uVar = (u) observable;
        if (uVar.l() == u.a.COMPLETED) {
            this.f5702f.a(new bu(this.f5701e, uVar.g(), Boolean.TRUE));
        }
        if (uVar.l() == u.a.ERROR) {
            this.f5702f.b(new bu(this.f5701e, uVar.g(), Boolean.FALSE));
        }
    }

    public void a(String str, String str2) {
        al alVar = new al(this.f5698b, this.f5700d != null ? new URL(this.f5700d) : this.f5699c, str, str2, false);
        alVar.addObserver(this);
        alVar.a();
        SharedPreferences.Editor edit = this.f5703i.edit();
        edit.putString(f5697h, this.f5701e.toString());
        edit.apply();
    }

    public cf(Context context, String str, bu buVar, a aVar) {
        this.f5699c = null;
        this.f5700d = null;
        this.f5704j = new cg(this);
        this.f5700d = str;
        this.f5701e = buVar;
        a(context, aVar);
    }
}
