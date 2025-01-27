package com.martian.mibook.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.martian.mibook.service.TtsService;

/* loaded from: classes4.dex */
public class g extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private a f13382a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f13383b;

    /* loaded from: classes.dex */
    public interface a {
        void a(long targetTime);

        void b0();

        void d0(int chapterIndex, int contentIndex, String sourceString);

        void e0(boolean hide);

        void n0();

        void o0(int chapterIndex, int contentIndex);
    }

    public void a(Context context, a listener) {
        if (this.f13383b) {
            return;
        }
        b(listener);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TtsService.n);
        context.registerReceiver(this, intentFilter);
        this.f13383b = true;
    }

    public void b(a listener) {
        this.f13382a = listener;
    }

    public void c(Context context) {
        if (this.f13383b) {
            try {
                this.f13382a = null;
                context.unregisterReceiver(this);
                this.f13383b = false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || this.f13382a == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(TtsService.n);
        if (TtsService.r.equalsIgnoreCase(stringExtra)) {
            this.f13382a.n0();
            return;
        }
        if (TtsService.s.equalsIgnoreCase(stringExtra)) {
            this.f13382a.b0();
            return;
        }
        if (TtsService.t.equalsIgnoreCase(stringExtra)) {
            this.f13382a.d0(intent.getIntExtra(TtsService.o, 0), intent.getIntExtra(TtsService.p, 0), intent.getStringExtra(TtsService.q));
            return;
        }
        if (TtsService.u.equalsIgnoreCase(stringExtra)) {
            this.f13382a.o0(intent.getIntExtra(TtsService.o, 0), intent.getIntExtra(TtsService.p, 0));
        } else if (TtsService.v.equalsIgnoreCase(stringExtra)) {
            this.f13382a.a(intent.getLongExtra(TtsService.v, -1L));
        } else if (TtsService.w.equalsIgnoreCase(stringExtra)) {
            this.f13382a.e0(intent.getBooleanExtra(TtsService.w, true));
        }
    }
}
