package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public final class v {
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static volatile boolean Gv = false;

    /* renamed from: com.kwad.sdk.utils.v$1 */
    static class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            v.access$002(false);
        }
    }

    public static void H(Context context, String str) {
        c(context, str, R.layout.ksad_content_alliance_toast_2);
    }

    private static void a(Context context, String str, int i2, long j2) {
        if (com.kwad.b.kwai.a.Yh.booleanValue() && !Gv) {
            Gv = true;
            View inflate = com.kwad.sdk.j.k.inflate(context, i2, null);
            ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context.getApplicationContext());
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
            mHandler.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.v.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    v.access$002(false);
                }
            }, j2);
        }
    }

    static /* synthetic */ boolean access$002(boolean z) {
        Gv = false;
        return false;
    }

    private static void c(Context context, String str, int i2) {
        a(context, str, i2, 800L);
    }

    public static void c(Context context, String str, long j2) {
        a(context, str, R.layout.ksad_content_alliance_toast_2, 0L);
    }

    public static void d(Context context, String str, int i2) {
        if (com.kwad.b.kwai.a.Yh.booleanValue()) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.ksad_content_alliance_toast, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
        }
    }

    public static void d(Context context, String str, long j2) {
        a(context, str, R.layout.ksad_toast_corner, 0L);
    }
}
