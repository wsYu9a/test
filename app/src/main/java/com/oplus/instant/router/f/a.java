package com.oplus.instant.router.f;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.oplus.instant.router.callback.Callback;
import com.oplus.instant.router.h.e;
import java.util.Map;

/* loaded from: classes4.dex */
public class a extends ContentObserver {

    /* renamed from: a */
    private static Handler f16071a;

    /* renamed from: b */
    private static HandlerThread f16072b;

    /* renamed from: c */
    private static final Object f16073c = new Object();

    /* renamed from: d */
    private Context f16074d;

    /* renamed from: e */
    private Map<String, Object> f16075e;

    /* renamed from: f */
    private Callback f16076f;

    /* renamed from: g */
    private Uri f16077g;

    public a(Context context, Map<String, Object> map, Callback callback, Uri uri) {
        super(a());
        this.f16074d = context;
        this.f16075e = map;
        this.f16076f = callback;
        this.f16077g = uri;
    }

    protected static Handler a() {
        Handler handler;
        synchronized (f16073c) {
            HandlerThread handlerThread = f16072b;
            if (handlerThread == null || !handlerThread.isAlive()) {
                HandlerThread handlerThread2 = new HandlerThread("instant_callback");
                f16072b = handlerThread2;
                handlerThread2.start();
                Looper looper = f16072b.getLooper();
                f16071a = looper != null ? new Handler(looper) : new Handler();
            }
            handler = f16071a;
        }
        return handler;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Uri uri = this.f16077g;
        if (uri != null) {
            onChange(z, uri);
            return;
        }
        Context context = this.f16074d;
        if (context != null) {
            context.getContentResolver().unregisterContentObserver(this);
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri) {
        Context context;
        Uri uri2 = this.f16077g;
        if (uri2 == null || !uri2.equals(uri) || (context = this.f16074d) == null) {
            return;
        }
        Callback callback = this.f16076f;
        if (callback != null) {
            callback.onResponse(this.f16075e, e.b(context, uri));
        }
        this.f16074d.getContentResolver().unregisterContentObserver(this);
    }
}
