package com.martian.mibook.mvvm.yuewen.activity;

import android.content.Intent;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.martian.libmars.databinding.LayoutToolbarBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.databinding.ActivityCategoriesBinding;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.base.DefaultViewModel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.yuewen.fragment.YWTagBookListFragment;
import kc.a;
import kotlin.Metadata;
import xi.l;

@Route(path = a.f27747c)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/activity/YWTagsActivity;", "Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Lcom/martian/mibook/databinding/ActivityCategoriesBinding;", "Lcom/martian/mibook/mvvm/base/DefaultViewModel;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "c1", "(Landroid/os/Bundle;)V", "Lcom/martian/libmars/databinding/LayoutToolbarBinding;", "toolbarBinding", "s1", "(Lcom/martian/libmars/databinding/LayoutToolbarBinding;)V", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class YWTagsActivity extends BaseMVVMActivity<ActivityCategoriesBinding, DefaultViewModel> {
    @Override // com.martian.mibook.mvvm.base.BaseActivity
    public void c1(@l Bundle savedInstanceState) {
        if (((YWTagBookListFragment) getSupportFragmentManager().findFragmentByTag("tag_list_fragment")) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, YWTagBookListFragment.INSTANCE.a(), "tag_list_fragment").commit();
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void s1(@l LayoutToolbarBinding toolbarBinding) {
        super.s1(toolbarBinding);
        if (toolbarBinding != null) {
            ThemeTextView themeTextView = toolbarBinding.f12249i;
            Intent intent = getIntent();
            themeTextView.setText(ExtKt.c(intent != null ? intent.getStringExtra(YWTagBookListFragment.E) : null));
        }
    }
}
