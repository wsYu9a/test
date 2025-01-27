package com.aggmoread.sdk.z.d.a.a.e.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e extends ContextWrapper {

    /* renamed from: a */
    private WeakReference<Context> f6135a;

    public e(Context context) {
        super(context);
        this.f6135a = new WeakReference<>(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        j.f6027q.sendBroadcast(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        j.f6027q.startActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        return j.f6027q.startService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, @Nullable Bundle bundle) {
        Context context = this.f6135a.get();
        if (context != null) {
            context.startActivity(intent, bundle);
        } else {
            j.f6027q.startActivity(intent);
        }
    }
}
