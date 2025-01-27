package ce;

import android.app.Activity;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.martian.mibook.lib.account.response.RechargeItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class q extends BaseAdapter {

    /* renamed from: b */
    public final a f1965b;

    /* renamed from: c */
    public int f1966c = 0;

    /* renamed from: d */
    public List<RechargeItem> f1967d = new ArrayList();

    /* renamed from: e */
    public final Activity f1968e;

    public interface a {
        void a(int i10, int i11);
    }

    public static class b {

        /* renamed from: a */
        public View f1969a;

        /* renamed from: b */
        public TextView f1970b;

        /* renamed from: c */
        public TextView f1971c;
    }

    public q(Activity activity, a aVar) {
        this.f1968e = activity;
        this.f1965b = aVar;
    }

    public void b(RechargeItem[] rechargeItemArr) {
        this.f1967d.addAll(Arrays.asList(rechargeItemArr));
    }

    public RechargeItem c(int i10) {
        return this.f1967d.get(i10);
    }

    public final /* synthetic */ void d(int i10, RechargeItem rechargeItem, View view) {
        a aVar = this.f1965b;
        if (aVar != null) {
            aVar.a(i10, rechargeItem.getMoney());
        }
    }

    public void e(List<RechargeItem> list) {
        this.f1967d = list;
    }

    public void f(int i10) {
        this.f1966c = i10;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1967d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f1967d.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: ce.p.<init>(ce.q, int, com.martian.mibook.lib.account.response.RechargeItem):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // android.widget.Adapter
    @android.annotation.SuppressLint({"SetTextI18n"})
    public android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            if (r7 != 0) goto L34
            android.app.Activity r7 = r5.f1968e
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r8 = com.martian.mibook.lib.original.R.layout.txs_recharge_coin_item
            r0 = 0
            android.view.View r7 = r7.inflate(r8, r0)
            ce.q$b r8 = new ce.q$b
            r8.<init>()
            int r0 = com.martian.mibook.lib.original.R.id.iv_recharge_item
            android.view.View r0 = r7.findViewById(r0)
            r8.f1969a = r0
            int r0 = com.martian.mibook.lib.original.R.id.iv_txs_money
            android.view.View r0 = r7.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r8.f1970b = r0
            int r0 = com.martian.mibook.lib.original.R.id.iv_txs_coins
            android.view.View r0 = r7.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r8.f1971c = r0
            r7.setTag(r8)
            goto L3a
        L34:
            java.lang.Object r8 = r7.getTag()
            ce.q$b r8 = (ce.q.b) r8
        L3a:
            int r0 = r5.f1966c
            if (r0 != r6) goto L60
            android.view.View r0 = r8.f1969a
            int r1 = com.martian.libmars.R.drawable.border_button_theme_default_middle
            r0.setBackgroundResource(r1)
            android.widget.TextView r0 = r8.f1970b
            android.app.Activity r1 = r5.f1968e
            int r2 = com.martian.libmars.R.color.white
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r2)
            r0.setTextColor(r1)
            android.widget.TextView r0 = r8.f1971c
            android.app.Activity r1 = r5.f1968e
            int r2 = com.martian.libmars.R.color.white
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r2)
            r0.setTextColor(r1)
            goto L93
        L60:
            com.martian.libmars.common.ConfigSingleton r0 = com.martian.libmars.common.ConfigSingleton.D()
            boolean r0 = r0.A0()
            if (r0 == 0) goto L72
            android.view.View r0 = r8.f1969a
            int r1 = com.martian.libmars.R.drawable.border_background_withdraw_night
            r0.setBackgroundResource(r1)
            goto L79
        L72:
            android.view.View r0 = r8.f1969a
            int r1 = com.martian.libmars.R.drawable.border_background_withdraw_day
            r0.setBackgroundResource(r1)
        L79:
            android.widget.TextView r0 = r8.f1970b
            android.app.Activity r1 = r5.f1968e
            int r2 = com.martian.libmars.R.color.theme_default
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r2)
            r0.setTextColor(r1)
            android.widget.TextView r0 = r8.f1971c
            com.martian.libmars.common.ConfigSingleton r1 = com.martian.libmars.common.ConfigSingleton.D()
            int r1 = r1.j0()
            r0.setTextColor(r1)
        L93:
            java.lang.Object r0 = r5.getItem(r6)
            com.martian.mibook.lib.account.response.RechargeItem r0 = (com.martian.mibook.lib.account.response.RechargeItem) r0
            android.widget.TextView r1 = r8.f1970b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "¥"
            r2.append(r3)
            int r3 = r0.getMoney()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r3 = oe.f.o(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.setText(r2)
            android.widget.TextView r1 = r8.f1971c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r3 = r0.getTxsCoins()
            r2.append(r3)
            android.app.Activity r3 = r5.f1968e
            int r4 = com.martian.mibook.lib.account.R.string.txs_coin
            java.lang.String r3 = r3.getString(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.setText(r2)
            android.view.View r8 = r8.f1969a
            ce.p r1 = new ce.p
            r1.<init>()
            r8.setOnClickListener(r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ce.q.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
