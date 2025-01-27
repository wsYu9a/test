package com.sigmob.sdk.mraid2;

import com.umeng.analytics.pro.bt;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class n {

    /* renamed from: a */
    public final String f19815a;

    /* renamed from: b */
    public int f19816b;

    /* renamed from: c */
    public boolean f19817c;

    /* renamed from: d */
    public c f19818d;

    /* renamed from: e */
    public Timer f19819e = null;

    /* renamed from: f */
    public TimerTask f19820f = null;

    public class a extends TimerTask {

        /* renamed from: com.sigmob.sdk.mraid2.n$a$a */
        public class RunnableC0609a implements Runnable {
            public RunnableC0609a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                n.this.f19818d.f(n.this.f19815a);
            }
        }

        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (n.this.f19818d != null) {
                n.this.f19818d.f().post(new RunnableC0609a());
            }
        }
    }

    public n(c cVar, JSONObject jSONObject) {
        this.f19818d = cVar;
        this.f19816b = jSONObject.optInt(bt.f23596ba);
        this.f19817c = jSONObject.optBoolean("repeats");
        this.f19815a = jSONObject.optString("uniqueId");
    }

    public void c() {
        TimerTask timerTask = this.f19820f;
        if (timerTask != null) {
            timerTask.cancel();
            this.f19820f = null;
        }
        Timer timer = this.f19819e;
        if (timer != null) {
            timer.cancel();
            this.f19819e.purge();
            this.f19819e = null;
        }
    }

    public void d() {
        c();
    }

    public void a() {
        try {
            c();
            b();
            int i10 = this.f19816b;
            if (i10 > 0) {
                if (this.f19817c) {
                    long j10 = i10;
                    this.f19819e.schedule(this.f19820f, j10, j10);
                } else {
                    this.f19819e.schedule(this.f19820f, i10);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void b() {
        this.f19819e = new Timer();
        this.f19820f = new a();
    }
}
