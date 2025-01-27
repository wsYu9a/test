package com.martian.mibook.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.service.TtsService;

/* loaded from: classes4.dex */
public class f extends BroadcastReceiver {

    /* renamed from: a */
    private a f13380a;

    /* renamed from: b */
    private boolean f13381b;

    public interface a {
        void a(long targetTime);

        void b();

        void c();

        void d(long speed);

        void e();

        void f();

        void g(int chapterIndex, int contentIndex, boolean endPosition, boolean syncPosition);

        void h();

        void i();

        void j();
    }

    public void a(Context context, a listener) {
        if (this.f13381b) {
            return;
        }
        b(listener);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TtsService.f14100a);
        context.registerReceiver(this, intentFilter);
        this.f13381b = true;
    }

    public void b(a listener) {
        this.f13380a = listener;
    }

    public void c(Context context) {
        if (this.f13381b) {
            try {
                this.f13380a = null;
                context.unregisterReceiver(this);
                this.f13381b = false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || this.f13380a == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(TtsService.f14100a);
        if (TtsService.f14101b.equalsIgnoreCase(stringExtra)) {
            this.f13380a.j();
            return;
        }
        if (TtsService.f14102c.equalsIgnoreCase(stringExtra)) {
            this.f13380a.i();
            return;
        }
        if (TtsService.f14103d.equalsIgnoreCase(stringExtra)) {
            this.f13380a.b();
            return;
        }
        if (TtsService.f14104e.equalsIgnoreCase(stringExtra)) {
            this.f13380a.f();
            return;
        }
        if (TtsService.f14105f.equalsIgnoreCase(stringExtra)) {
            this.f13380a.d(intent.getLongExtra(TtsService.f14105f, MiConfigSingleton.V3().z4()));
            return;
        }
        if (TtsService.f14106g.equalsIgnoreCase(stringExtra)) {
            this.f13380a.a(intent.getLongExtra(TtsService.f14106g, -1L));
            return;
        }
        if (TtsService.f14107h.equalsIgnoreCase(stringExtra)) {
            this.f13380a.e();
            return;
        }
        if (TtsService.f14108i.equalsIgnoreCase(stringExtra)) {
            this.f13380a.h();
            return;
        }
        if (!TtsService.f14109j.equalsIgnoreCase(stringExtra)) {
            if (TtsService.m.equalsIgnoreCase(stringExtra)) {
                this.f13380a.c();
            }
        } else {
            this.f13380a.g(intent.getIntExtra(TtsService.o, 0), intent.getIntExtra(TtsService.p, 0), intent.getBooleanExtra(TtsService.k, false), intent.getBooleanExtra(TtsService.l, false));
        }
    }
}
