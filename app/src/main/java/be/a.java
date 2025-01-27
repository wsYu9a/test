package be;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.martian.mibook.R;
import com.martian.mibook.lib.account.response.MissionItem;
import l9.m0;

/* loaded from: classes3.dex */
public class a implements ca.c<MissionItem> {

    /* renamed from: a */
    public ImageView f1564a;

    /* renamed from: b */
    public TextView f1565b;

    /* renamed from: c */
    public TextView f1566c;

    @Override // ca.c
    public View b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_bookrack_mission, (ViewGroup) null);
        this.f1564a = (ImageView) inflate.findViewById(R.id.br_mission_cover);
        this.f1565b = (TextView) inflate.findViewById(R.id.br_mission_title);
        this.f1566c = (TextView) inflate.findViewById(R.id.br_mission_desc);
        return inflate;
    }

    @Override // ca.c
    /* renamed from: d */
    public void a(Context context, int i10, MissionItem missionItem) {
        m0.E(context, missionItem.getIcon(), new C0015a(context, missionItem));
        this.f1565b.setText(missionItem.getTitle());
        this.f1566c.setText(missionItem.getDesc());
    }

    /* renamed from: be.a$a */
    public class C0015a implements m0.c {

        /* renamed from: a */
        public final /* synthetic */ Context f1567a;

        /* renamed from: b */
        public final /* synthetic */ MissionItem f1568b;

        public C0015a(Context context, MissionItem missionItem) {
            this.f1567a = context;
            this.f1568b = missionItem;
        }

        @Override // l9.m0.c
        public void a(Drawable drawable) {
            m0.h(this.f1567a, drawable, a.this.f1564a, 110 == this.f1568b.getType() ? 12 : 2);
        }

        @Override // l9.m0.c
        public void onError() {
        }
    }
}
