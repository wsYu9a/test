package com.wbl.ad.yzz.ms.f.m;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.ms.supporter.utils.DownloadInfo;
import java.lang.ref.SoftReference;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a */
    public static SoftReference<Activity> f33243a;

    public static class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f33244a;

        /* renamed from: b */
        public final /* synthetic */ com.wbl.ad.yzz.ms.f.h.a f33245b;

        /* renamed from: c */
        public final /* synthetic */ com.wbl.ad.yzz.ms.e.d.a f33246c;

        public a(Context context, com.wbl.ad.yzz.ms.f.h.a aVar, com.wbl.ad.yzz.ms.e.d.a aVar2) {
            this.f33244a = context;
            this.f33245b = aVar;
            this.f33246c = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12228, this, null);
        }
    }

    public static String a(String str, com.wbl.ad.yzz.ms.e.d.a aVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12227, null, str, aVar);
    }

    public static String a(String str, com.wbl.ad.yzz.ms.f.h.d dVar) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12254, null, str, dVar);
    }

    public static void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12253, null, null);
    }

    public static void a(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12256, null, activity);
    }

    public static void a(Context context, com.wbl.ad.yzz.ms.e.d.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12255, null, context, aVar);
    }

    public static void a(Context context, com.wbl.ad.yzz.ms.e.d.a aVar, DownloadInfo downloadInfo) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12250, null, context, aVar, downloadInfo);
    }

    public static void a(com.wbl.ad.yzz.ms.e.d.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12249, null, aVar);
    }

    public static boolean a(Context context, com.wbl.ad.yzz.ms.f.h.a aVar, com.wbl.ad.yzz.ms.e.d.a aVar2, Intent intent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12251, null, context, aVar, aVar2, intent);
    }

    public static boolean b(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12246, null, context);
    }

    public static boolean c(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12245, null, context);
    }

    public static boolean d(Context context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12248, null, context);
    }
}
