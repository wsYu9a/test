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

/* loaded from: classes3.dex */
public final class z {

    /* renamed from: hf */
    private static Handler f11981hf = new Handler(Looper.getMainLooper());
    private static volatile boolean JE = false;

    /* renamed from: com.kwad.sdk.utils.z$1 */
    public class AnonymousClass1 extends bd {
        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            z.access$002(false);
        }
    }

    public static void P(Context context, String str) {
        b(context, str, R.layout.ksad_content_alliance_toast_2);
    }

    private static void a(Context context, String str, int i10, long j10) {
        if (com.kwad.framework.a.a.agQ.booleanValue() && !JE) {
            JE = true;
            View inflate = com.kwad.sdk.n.m.inflate(context, i10, null);
            ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context.getApplicationContext());
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
            f11981hf.postDelayed(new bd() { // from class: com.kwad.sdk.utils.z.1
                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    z.access$002(false);
                }
            }, j10);
        }
    }

    public static /* synthetic */ boolean access$002(boolean z10) {
        JE = false;
        return false;
    }

    private static void b(Context context, String str, int i10) {
        a(context, str, i10, 800L);
    }

    public static void c(Context context, String str, long j10) {
        a(context, str, R.layout.ksad_content_alliance_toast_2, 0L);
    }

    public static void d(Context context, String str, long j10) {
        a(context, str, R.layout.ksad_toast_corner, 0L);
    }

    public static void c(Context context, String str, int i10) {
        if (com.kwad.framework.a.a.agQ.booleanValue()) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.ksad_content_alliance_toast, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
        }
    }
}
