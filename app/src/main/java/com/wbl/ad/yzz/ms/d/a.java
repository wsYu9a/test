package com.wbl.ad.yzz.ms.d;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.ms.d.c;
import com.wbl.ad.yzz.ms.d.e.f;
import java.util.List;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a */
    public Activity f33054a;

    /* renamed from: com.wbl.ad.yzz.ms.d.a$a */
    public class C0760a implements c.InterfaceC0761c {

        /* renamed from: a */
        public final /* synthetic */ f f33055a;

        /* renamed from: b */
        public final /* synthetic */ boolean f33056b;

        /* renamed from: c */
        public final /* synthetic */ List f33057c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.ms.d.e.a f33058d;

        public C0760a(a aVar, f fVar, boolean z, List list, com.wbl.ad.yzz.ms.d.e.a aVar2) {
            this.f33055a = fVar;
            this.f33056b = z;
            this.f33057c = list;
            this.f33058d = aVar2;
        }

        @Override // com.wbl.ad.yzz.ms.d.c.InterfaceC0761c
        public void a(c cVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12791, this, cVar);
        }
    }

    public a(@NonNull Activity activity) {
        this.f33054a = activity;
    }

    public final void a(b bVar, String str, Integer num) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12786, this, bVar, str, num);
    }

    public void a(f fVar, com.wbl.ad.yzz.ms.d.e.a aVar, boolean z, float f2, float f3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12785, this, fVar, aVar, Boolean.valueOf(z), Float.valueOf(f2), Float.valueOf(f3));
    }

    public final void a(f fVar, com.wbl.ad.yzz.ms.d.e.a aVar, boolean z, boolean z2, float f2, float f3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12788, this, fVar, aVar, Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f2), Float.valueOf(f3));
    }
}
