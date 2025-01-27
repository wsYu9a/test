package com.wbl.ad.yzz.fragment;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import f.b.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/wbl/ad/yzz/fragment/b;", "", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Landroid/content/Intent;", "intent", "Lcom/wbl/ad/yzz/fragment/a;", com.alipay.sdk.authjs.a.f5376c, "", "startActivityForResult", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/wbl/ad/yzz/fragment/a;)V", "Lcom/wbl/ad/yzz/fragment/c;", "a", "(Landroid/app/Activity;)Lcom/wbl/ad/yzz/fragment/c;", "Landroidx/fragment/app/FragmentManager;", "manager", "(Landroidx/fragment/app/FragmentManager;)Lcom/wbl/ad/yzz/fragment/c;", "Lcom/wbl/ad/yzz/fragment/c;", "fragment", "", "isFromFragment", "<init>", "(Landroid/app/Activity;Z)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: from kotlin metadata */
    public c fragment;

    public b(@e Activity activity, boolean z) {
        if (z) {
            this.fragment = a(activity);
        } else {
            this.fragment = null;
        }
    }

    public final c a(Activity r3) {
        return (c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14092, this, r3);
    }

    public final c a(FragmentManager manager) {
        return (c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14091, this, manager);
    }

    public final void startActivityForResult(Activity r3, Intent intent, a r5) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14086, this, r3, intent, r5);
    }
}
