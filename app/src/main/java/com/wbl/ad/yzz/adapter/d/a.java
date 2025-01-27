package com.wbl.ad.yzz.adapter.d;

import android.view.View;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiConfigSingleton;
import com.wbl.ad.yzz.adapter.base.BaseMultiItemQuickAdapter;
import com.wbl.ad.yzz.adapter.base.viewholder.BaseViewHolder;
import com.wbl.ad.yzz.innerconfig.d.j;
import com.wbl.ad.yzz.network.b.b.u;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\bB\u0017\u0012\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!¢\u0006\u0004\b#\u0010$J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\b\u0010\fJ\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\b\u0010\u000fJ\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\b\u0010\u0012J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\b\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H&¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u0017R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\b\u0010\u001f¨\u0006%"}, d2 = {"Lcom/wbl/ad/yzz/adapter/d/a;", "Lcom/wbl/ad/yzz/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/wbl/ad/yzz/adapter/d/b;", "Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "Lcom/wbl/ad/yzz/adapter/b/f/d;", "Lcom/wbl/ad/yzz/adapter/c/b;", "itemListener", "", "a", "(Lcom/wbl/ad/yzz/adapter/c/b;)V", "Lcom/wbl/ad/yzz/adapter/d/a$a;", "onQuickAdapterListener", "(Lcom/wbl/ad/yzz/adapter/d/a$a;)V", "", "color", "(Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/network/b/b/u$b;", "conf", "(Lcom/wbl/ad/yzz/network/b/b/u$b;)V", "Lcom/wbl/ad/yzz/innerconfig/d/j;", "sceneDataInfoWrap", "(Lcom/wbl/ad/yzz/innerconfig/d/j;)V", "t", "()V", t.k, "s", "", "B", "Z", "q", "()Z", "(Z)V", "canPlay", "", MiConfigSingleton.t0, "<init>", "(Ljava/util/List;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public abstract class a extends BaseMultiItemQuickAdapter<b, BaseViewHolder> implements com.wbl.ad.yzz.adapter.b.f.d {

    /* renamed from: B, reason: from kotlin metadata */
    public boolean canPlay;

    /* renamed from: com.wbl.ad.yzz.adapter.d.a$a */
    public interface InterfaceC0679a {
        void a(@f.b.a.e View view, @f.b.a.e com.wbl.ad.yzz.bean.b bVar, int i2);
    }

    public a(@f.b.a.e List<b> list) {
        super(list);
    }

    public abstract void a(@f.b.a.d com.wbl.ad.yzz.adapter.c.b itemListener);

    public abstract void a(@f.b.a.e InterfaceC0679a onQuickAdapterListener);

    public abstract void a(@f.b.a.e j sceneDataInfoWrap);

    public abstract void a(@f.b.a.e u.b conf);

    public abstract void a(@f.b.a.e String color);

    public final void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16019, this, Boolean.valueOf(z));
    }

    public final boolean q() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-16110, this, null);
    }

    public abstract void r();

    public final void s() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16109, this, null);
    }

    public abstract void t();
}
