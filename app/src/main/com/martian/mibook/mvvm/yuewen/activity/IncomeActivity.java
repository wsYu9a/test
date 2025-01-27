package com.martian.mibook.mvvm.yuewen.activity;

import android.content.Intent;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.martian.mibook.databinding.ActivityIncomeBinding;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.yuewen.viewmodel.MissionCenterViewModel;
import kc.a;
import kotlin.Metadata;
import xi.l;
import ya.e0;

@Route(path = a.f27753i)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/activity/IncomeActivity;", "Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Lcom/martian/mibook/databinding/ActivityIncomeBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/MissionCenterViewModel;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "c1", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class IncomeActivity extends BaseMVVMActivity<ActivityIncomeBinding, MissionCenterViewModel> {
    @Override // com.martian.mibook.mvvm.base.BaseActivity
    public void c1(@l Bundle savedInstanceState) {
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, com.martian.mibook.mvvm.base.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@l Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(e0.B0, true);
        }
        super.onCreate(savedInstanceState);
    }
}
