package com.wbl.ad.yzz.util;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class i {

    /* renamed from: a */
    public DownloadManager f34349a;

    /* renamed from: b */
    public Context f34350b;

    /* renamed from: c */
    public long f34351c;

    /* renamed from: d */
    public String f34352d;

    /* renamed from: e */
    public String f34353e;

    /* renamed from: f */
    public String f34354f;

    /* renamed from: g */
    public boolean f34355g;

    /* renamed from: h */
    public BroadcastReceiver f34356h = new a();

    /* renamed from: i */
    public BroadcastReceiver f34357i = new b();

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8260, this, context, intent);
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8259, this, context, intent);
        }
    }

    public i(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        this.f34350b = context;
        this.f34352d = str2;
        this.f34354f = str;
    }

    public static /* synthetic */ Context b(i iVar) {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8285, null, iVar);
    }

    public static /* synthetic */ BroadcastReceiver c(i iVar) {
        return (BroadcastReceiver) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8288, null, iVar);
    }

    public final int a(Cursor cursor) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8287, this, cursor);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8282, this, null);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8281, this, str);
    }

    public final void a(String str, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8284, this, str, str2);
    }

    public void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8283, this, null);
    }

    public void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8278, this, null);
    }
}
