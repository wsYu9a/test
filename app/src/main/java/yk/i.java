package yk;

import android.content.Context;
import bh.b;
import com.google.gson.Gson;
import com.sntech.ads.SNInitializer;
import com.sntech.ads.impl.entity.InitConfig;
import com.sntech.net.DomainProvider;
import com.sntech.net.NetCallback;
import com.sntech.net.NetClient;
import com.sntech.net.NetRequest;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class i implements SNInitializer, SNInitializer.InitConfigSupplier {

    /* renamed from: a */
    public String f33576a = null;

    /* renamed from: b */
    public boolean f33577b = false;

    /* renamed from: c */
    public boolean f33578c = false;

    /* renamed from: d */
    public Set<SNInitializer.InitCallback> f33579d = new HashSet();

    public class a implements NetCallback {
        public a() {
        }

        @Override // com.sntech.net.NetCallback
        public final void onFailure(Exception exc) {
            i.this.c(exc);
            i.this.f33577b = false;
        }

        @Override // com.sntech.net.NetCallback
        public final void onSuccess(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has(h3.e.f26408m)) {
                    mj.j.f();
                    throw new Exception("no data");
                }
                i.this.f33576a = jSONObject.getJSONObject(h3.e.f26408m).toString();
                mj.j.d("ic_data", i.this.f33576a);
                i iVar = i.this;
                iVar.getClass();
                try {
                    b.f33565c = (InitConfig) new Gson().fromJson(iVar.f33576a, InitConfig.class);
                } catch (Exception unused) {
                }
                if (i.this.isInitSuccess()) {
                    i.this.a();
                }
            } catch (Exception e10) {
                i.this.c(e10);
                i.this.f33577b = false;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.HashSet, java.util.Set<com.sntech.ads.SNInitializer$InitCallback>] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.HashSet, java.util.Set<com.sntech.ads.SNInitializer$InitCallback>] */
    public final void a() {
        synchronized (this.f33579d) {
            try {
                Iterator it = this.f33579d.iterator();
                while (it.hasNext()) {
                    SNInitializer.InitCallback initCallback = (SNInitializer.InitCallback) it.next();
                    Objects.requireNonNull(initCallback);
                    new Thread(new h(initCallback)).start();
                }
                this.f33579d.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.HashSet, java.util.Set<com.sntech.ads.SNInitializer$InitCallback>] */
    @Override // com.sntech.ads.SNInitializer
    public final void addCallback(SNInitializer.InitCallback initCallback) {
        synchronized (this.f33579d) {
            if (initCallback != null) {
                try {
                    if (initCallback instanceof SNInitializer.InnerInitCallback) {
                        ((SNInitializer.InnerInitCallback) initCallback).supplier(this);
                    }
                    if (isInitSuccess()) {
                        new Thread(new h(initCallback)).start();
                        return;
                    }
                    this.f33579d.add(initCallback);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashSet, java.util.Set<com.sntech.ads.SNInitializer$InitCallback>] */
    public final void c(Exception exc) {
        synchronized (this.f33579d) {
            try {
                Iterator it = this.f33579d.iterator();
                while (it.hasNext()) {
                    new Thread(new Runnable() { // from class: yk.g

                        /* renamed from: c */
                        public final /* synthetic */ Exception f33574c;

                        public /* synthetic */ g(Exception exc2) {
                            exc = exc2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            SNInitializer.InitCallback.this.fail(exc);
                        }
                    }).start();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.sntech.ads.SNInitializer.InitConfigSupplier
    public final <T> T getCachedInitConfig(Class<T> cls) {
        String string = mj.j.a().getString("ic_data", null);
        if (string != null) {
            try {
                return (T) new Gson().fromJson(string, (Class) cls);
            } catch (Exception e10) {
                b.a.f1608a.m("this", "get cached init config failed", e10);
            }
        }
        return null;
    }

    @Override // com.sntech.ads.SNInitializer.InitConfigSupplier
    public final <T> T getInitConfig(Class<T> cls) {
        if (!isInitSuccess()) {
            return null;
        }
        try {
            return (T) new Gson().fromJson(this.f33576a, (Class) cls);
        } catch (Exception e10) {
            b.a.f1608a.m("this", "get init config failed", e10);
            return null;
        }
    }

    @Override // com.sntech.ads.SNInitializer
    public final synchronized void init(Context context) {
        if (!isInitSuccess() && !this.f33577b) {
            this.f33577b = true;
            NetClient.postEncryptAsync(new NetRequest.Builder().url(DomainProvider.baseUrl() + "ic").requestJSON(mj.k.e(context)).checkReqId(true).build(), new a());
        }
    }

    @Override // com.sntech.ads.SNInitializer
    public final boolean isInitSuccess() {
        return this.f33576a != null && this.f33578c;
    }

    @Override // com.sntech.ads.SNInitializer
    public final void loaderInitSuccess() {
        this.f33578c = true;
        if (isInitSuccess()) {
            a();
        }
    }
}
