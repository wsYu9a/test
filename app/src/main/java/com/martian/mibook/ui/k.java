package com.martian.mibook.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.martian.libmars.utils.n0;
import com.martian.mibook.lib.account.response.MissionItem;
import com.martian.ttbookhd.R;

/* loaded from: classes4.dex */
public class k implements com.martian.libsupport.bannerView.d<MissionItem> {

    /* renamed from: a */
    private ImageView f14262a;

    /* renamed from: b */
    private TextView f14263b;

    /* renamed from: c */
    private TextView f14264c;

    class a implements n0.c {

        /* renamed from: a */
        final /* synthetic */ Context f14265a;

        /* renamed from: b */
        final /* synthetic */ MissionItem f14266b;

        a(final Context val$missionItem, final MissionItem val$context) {
            this.f14265a = val$missionItem;
            this.f14266b = val$context;
        }

        @Override // com.martian.libmars.utils.n0.c
        public void onError() {
        }

        @Override // com.martian.libmars.utils.n0.c
        public void onSuccess(Drawable resource) {
            n0.h(this.f14265a, resource, k.this.f14262a, 110 == this.f14266b.getType() ? 12 : 2);
        }
    }

    @Override // com.martian.libsupport.bannerView.d
    public View b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_bookrack_mission, (ViewGroup) null);
        this.f14262a = (ImageView) inflate.findViewById(R.id.br_mission_cover);
        this.f14263b = (TextView) inflate.findViewById(R.id.br_mission_title);
        this.f14264c = (TextView) inflate.findViewById(R.id.br_mission_desc);
        return inflate;
    }

    @Override // com.martian.libsupport.bannerView.d
    /* renamed from: d */
    public void a(final Context context, int i2, final MissionItem missionItem) {
        n0.E(context, missionItem.getIcon(), new a(context, missionItem));
        this.f14263b.setText(missionItem.getTitle());
        this.f14264c.setText(missionItem.getDesc());
    }
}
