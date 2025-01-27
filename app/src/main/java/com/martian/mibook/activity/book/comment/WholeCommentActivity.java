package com.martian.mibook.activity.book.comment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.activity.j1;
import com.martian.libsupport.k;
import com.martian.mibook.activity.book.BookInfoActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.f.p3;
import com.martian.mibook.lib.model.b.a;
import com.martian.mibook.lib.model.g.b;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public class WholeCommentActivity extends a {
    public static final String F = "WHOLE_COMMENT_BOOK_INFO";
    private p3 G;
    private BookInfoActivity.o H;

    public static void r2(j1 activity, BookInfoActivity.o bookInfo) {
        Bundle bundle = new Bundle();
        bundle.putString(F, GsonUtils.b().toJson(bookInfo));
        activity.startActivityForResult(WholeCommentActivity.class, bundle, BookInfoActivity.R);
    }

    @Override // com.martian.libmars.activity.j1
    protected void U1(boolean nightMode) {
        super.U1(nightMode);
        p3 p3Var = this.G;
        if (p3Var != null) {
            p3Var.p0();
        }
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == -1) {
            p3 p3Var = this.G;
            if (p3Var != null) {
                p3Var.m();
                return;
            }
            return;
        }
        if (requestCode == 1004 && resultCode == -1) {
            b.K(this, MiConfigSingleton.V3().T3("登录成功", 1004));
        } else if (requestCode == 777 && resultCode == -1) {
            setResult(-1);
        }
    }

    @Override // com.martian.mibook.lib.model.b.a, com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_fragment);
        String string = savedInstanceState != null ? savedInstanceState.getString(F) : G0(F);
        if (!k.p(string)) {
            this.H = (BookInfoActivity.o) GsonUtils.b().fromJson(string, BookInfoActivity.o.class);
        }
        BookInfoActivity.o oVar = this.H;
        if (oVar == null) {
            k1("获取信息失败");
            finish();
            return;
        }
        if (!k.p(oVar.c())) {
            Z1(this.H.c());
        }
        p3 p3Var = (p3) getSupportFragmentManager().findFragmentByTag("whole_comments_fragment");
        this.G = p3Var;
        if (p3Var == null) {
            this.G = p3.b0(this.H);
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, this.G, "whole_comments_fragment").commit();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (this.H != null) {
            outState.putString(F, GsonUtils.b().toJson(this.H));
        }
    }
}
