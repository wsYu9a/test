package com.wbl.ad.yzz.help;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.wbl.ad.yzz.util.o;

/* loaded from: classes5.dex */
public class g {

    public static class a extends SimpleTarget<Bitmap> {

        /* renamed from: a */
        public final /* synthetic */ o.a f32658a;

        public a(o.a aVar) {
            this.f32658a = aVar;
        }

        public void a(Bitmap bitmap, Transition<? super Bitmap> transition) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13743, this, bitmap, transition);
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13738, this, obj, transition);
        }
    }

    public static void a(Context context, String str, o.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13737, null, context, str, aVar);
    }
}
