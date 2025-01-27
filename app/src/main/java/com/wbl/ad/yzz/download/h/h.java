package com.wbl.ad.yzz.download.h;

import android.app.Activity;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0003\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0003\u0010\u000bJ\u0019\u0010\u0003\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\rR\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u001e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/wbl/ad/yzz/download/h/h;", "", "Landroid/app/Activity;", "a", "()Landroid/app/Activity;", "getContext", "", "b", "()Z", "", "sceneTag", "(Ljava/lang/String;)Z", "context", "(Landroid/app/Activity;)Z", "Ljava/lang/String;", "mSceneTag", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "mContext", "<init>", "(Ljava/lang/String;Landroid/app/Activity;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class h {

    /* renamed from: a, reason: from kotlin metadata */
    public final WeakReference<Activity> mContext;

    /* renamed from: b, reason: from kotlin metadata */
    public final String mSceneTag;

    public h(@f.b.a.e String str, @f.b.a.d Activity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = new WeakReference<>(context);
        this.mSceneTag = str == null ? "" : str;
    }

    public final Activity a() {
        return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13885, this, null);
    }

    public final boolean a(Activity context) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13888, this, context);
    }

    public final boolean a(String sceneTag) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13887, this, sceneTag);
    }

    public final boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13882, this, null);
    }

    public final Activity getContext() {
        return (Activity) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13881, this, null);
    }
}
