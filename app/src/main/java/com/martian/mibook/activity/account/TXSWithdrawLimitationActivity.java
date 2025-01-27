package com.martian.mibook.activity.account;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.n0;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.c0;
import com.martian.mibook.e.i4;
import com.martian.mibook.e.j4;
import com.martian.mibook.j.s2;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.mibook.lib.account.response.MissionItem;
import com.martian.mibook.lib.account.response.MissionSection;
import com.martian.mibook.lib.account.response.MissionSectionList;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class TXSWithdrawLimitationActivity extends com.martian.mibook.lib.model.b.a {
    private c0 F;

    private MissionItem t2(int tag) {
        return MiConfigSingleton.V3().L4.H(this, tag);
    }

    /* renamed from: v2 */
    public /* synthetic */ void w2(final MissionItem item, View view) {
        u2(item);
    }

    /* renamed from: x2 */
    public /* synthetic */ void y2(final MissionItem item, View view) {
        u2(item);
    }

    public View A2(LayoutInflater inflater, String title) {
        if (com.martian.libsupport.k.p(title)) {
            return null;
        }
        View inflate = inflater.inflate(R.layout.mission_section_title, (ViewGroup) null);
        j4 a2 = j4.a(inflate);
        a2.f12187d.setPadding(com.martian.libmars.d.h.b(16.0f), com.martian.libmars.d.h.b(16.0f), 0, com.martian.libmars.d.h.b(8.0f));
        a2.f12185b.setTextSize(2, 16.0f);
        a2.f12185b.setText(title);
        return inflate;
    }

    public void B2() {
        MissionSectionList missionSectionList = new MissionSectionList();
        ArrayList arrayList = new ArrayList();
        MissionSection missionSection = new MissionSection();
        missionSection.setTitle(getString(R.string.add_num));
        missionSection.setMissionItems(s2());
        MissionSection missionSection2 = new MissionSection();
        missionSection2.setTitle(getString(R.string.free_cash));
        missionSection2.setMissionItems(r2());
        arrayList.add(missionSection);
        arrayList.add(missionSection2);
        missionSectionList.setMissionSections(arrayList);
        if (missionSectionList.getMissionSections() != null) {
            this.F.f11776b.removeAllViews();
            for (MissionSection missionSection3 : missionSectionList.getMissionSections()) {
                this.F.f11776b.addView(A2(getLayoutInflater(), missionSection3.getTitle()));
                Iterator<MissionItem> it = missionSection3.getMissionItems().iterator();
                while (it.hasNext()) {
                    this.F.f11776b.addView(z2(it.next()));
                }
            }
        }
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1001 && resultCode == -1) {
            setResult(-1);
            finish();
        }
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txs_withdraw_limitation);
        this.F = c0.a(g2());
        B2();
    }

    public List<MissionItem> r2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t2(2002));
        return arrayList;
    }

    public List<MissionItem> s2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t2(2000));
        arrayList.add(t2(2001));
        return arrayList;
    }

    public void u2(MissionItem item) {
        if (item == null) {
            return;
        }
        if (item.getType() == 2000) {
            s2.o(this);
        } else if (item.getType() == 2002) {
            setResult(100);
            finish();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public View z2(final MissionItem item) {
        View inflate = getLayoutInflater().inflate(R.layout.mission_item, (ViewGroup) null);
        i4 a2 = i4.a(inflate);
        n0.l(this, item.getIcon(), a2.f12122g, item.iconRes);
        a2.f12124i.setText(item.getTitle());
        if (item.getType() == 2000) {
            MiTaskAccount x4 = MiConfigSingleton.V3().x4();
            ThemeTextView themeTextView = a2.f12124i;
            StringBuilder sb = new StringBuilder();
            sb.append(item.getTitle());
            sb.append(" (当前有效徒弟");
            sb.append(x4 != null ? Integer.valueOf(x4.getValidInviteeNum()) : "0");
            sb.append("人)");
            themeTextView.setText(sb.toString());
        }
        a2.f12121f.setText(item.getButtonText());
        a2.f12121f.setTextColor(ContextCompat.getColor(this, R.color.white));
        a2.f12121f.setBackgroundResource(R.drawable.border_button_round_default);
        a2.f12120e.setText(item.getDesc());
        a2.f12125j.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.account.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TXSWithdrawLimitationActivity.this.w2(item, view);
            }
        });
        a2.f12121f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.activity.account.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TXSWithdrawLimitationActivity.this.y2(item, view);
            }
        });
        return inflate;
    }
}
