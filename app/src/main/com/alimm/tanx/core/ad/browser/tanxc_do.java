package com.alimm.tanx.core.ad.browser;

import android.annotation.TargetApi;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.view.ActionMenu;
import com.alimm.tanx.core.ad.view.WebMenuDialog;
import com.alimm.tanx.core.constant.AdClickConstants;
import com.alimm.tanx.core.utils.AdClickUtAnalytics;
import com.alimm.tanx.core.utils.AdWebViewUtils;
import com.alimm.tanx.core.utils.LogUtils;
import com.sigmob.sdk.base.common.y;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class tanxc_do extends AppCompatActivity {
    private long tanxc_char;
    protected String tanxc_do;
    private OrientationEventListener tanxc_else;
    protected TextView tanxc_for;
    protected String tanxc_if;
    protected ProgressBar tanxc_int;
    private WebMenuDialog tanxc_try;
    private final boolean tanxc_byte = true;
    protected final IAdWebViewCallback tanxc_new = new IAdWebViewCallback() { // from class: com.alimm.tanx.core.ad.browser.tanxc_do.1
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ad.browser.IAdWebViewCallback
        public void onHideCustomView() {
            tanxc_do.this.tanxc_do(false);
            ActionBar supportActionBar = tanxc_do.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.show();
            }
            tanxc_do tanxc_doVar = tanxc_do.this;
            if (tanxc_doVar != null) {
                tanxc_doVar.setRequestedOrientation(1);
            }
        }

        @Override // com.alimm.tanx.core.ad.browser.IAdWebViewCallback
        public void onShowCustomView(View view) {
            tanxc_do.this.tanxc_do(true);
            ActionBar supportActionBar = tanxc_do.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.hide();
            }
            tanxc_do tanxc_doVar = tanxc_do.this;
            if (tanxc_doVar != null) {
                tanxc_doVar.setRequestedOrientation(10);
            }
        }

        @Override // com.alimm.tanx.core.ad.browser.IAdWebViewCallback
        public void onTitleLoaded(String str) {
            TextView textView = tanxc_do.this.tanxc_for;
            if (textView != null) {
                textView.setText(str);
            }
        }
    };
    private boolean tanxc_case = false;
    private int tanxc_goto = -2;

    /* renamed from: com.alimm.tanx.core.ad.browser.tanxc_do$1 */
    public class AnonymousClass1 implements IAdWebViewCallback {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ad.browser.IAdWebViewCallback
        public void onHideCustomView() {
            tanxc_do.this.tanxc_do(false);
            ActionBar supportActionBar = tanxc_do.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.show();
            }
            tanxc_do tanxc_doVar = tanxc_do.this;
            if (tanxc_doVar != null) {
                tanxc_doVar.setRequestedOrientation(1);
            }
        }

        @Override // com.alimm.tanx.core.ad.browser.IAdWebViewCallback
        public void onShowCustomView(View view) {
            tanxc_do.this.tanxc_do(true);
            ActionBar supportActionBar = tanxc_do.this.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.hide();
            }
            tanxc_do tanxc_doVar = tanxc_do.this;
            if (tanxc_doVar != null) {
                tanxc_doVar.setRequestedOrientation(10);
            }
        }

        @Override // com.alimm.tanx.core.ad.browser.IAdWebViewCallback
        public void onTitleLoaded(String str) {
            TextView textView = tanxc_do.this.tanxc_for;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.browser.tanxc_do$2 */
    public class AnonymousClass2 implements WebMenuDialog.MenuClick {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.ad.view.WebMenuDialog.MenuClick
        public void click(int i10) {
            if (i10 == 1012) {
                tanxc_do.this.tanxc_new();
                return;
            }
            if (i10 != 1013) {
                if (i10 != 1016) {
                    return;
                }
                String tanxc_int = tanxc_do.this.tanxc_int();
                if (TextUtils.isEmpty(tanxc_int)) {
                    return;
                }
                ((ClipboardManager) tanxc_do.this.getSystemService("clipboard")).setText(tanxc_int);
                return;
            }
            String tanxc_int2 = tanxc_do.this.tanxc_int();
            if (TextUtils.isEmpty(tanxc_int2)) {
                return;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(tanxc_int2));
                intent.setFlags(1610612740);
                tanxc_do.this.startActivity(intent);
            } catch (Throwable th2) {
                LogUtils.d("BaseAdWebViewActivity", "showMenuDialog exception.", th2);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.browser.tanxc_do$3 */
    public class AnonymousClass3 extends OrientationEventListener {
        public AnonymousClass3(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i10) {
            tanxc_do tanxc_doVar;
            if (tanxc_do.this.tanxc_goto == -2) {
                tanxc_do.this.tanxc_goto = i10;
            }
            int abs = Math.abs(tanxc_do.this.tanxc_goto - i10);
            if (abs > 180) {
                abs = 360 - abs;
            }
            if (abs <= 60 || (tanxc_doVar = tanxc_do.this) == null) {
                return;
            }
            tanxc_doVar.setRequestedOrientation(10);
            disable();
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.browser.tanxc_do$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (tanxc_do.this.tanxc_else != null) {
                tanxc_do.this.tanxc_else.enable();
            }
        }
    }

    @TargetApi(19)
    private void tanxc_char() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(-16777216);
    }

    private void tanxc_else() {
        if (this.tanxc_try == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ActionMenu.refresh);
            arrayList.add(ActionMenu.copy);
            arrayList.add(ActionMenu.gotoweb);
            this.tanxc_try = new WebMenuDialog(this, arrayList, new WebMenuDialog.MenuClick() { // from class: com.alimm.tanx.core.ad.browser.tanxc_do.2
                public AnonymousClass2() {
                }

                @Override // com.alimm.tanx.core.ad.view.WebMenuDialog.MenuClick
                public void click(int i10) {
                    if (i10 == 1012) {
                        tanxc_do.this.tanxc_new();
                        return;
                    }
                    if (i10 != 1013) {
                        if (i10 != 1016) {
                            return;
                        }
                        String tanxc_int = tanxc_do.this.tanxc_int();
                        if (TextUtils.isEmpty(tanxc_int)) {
                            return;
                        }
                        ((ClipboardManager) tanxc_do.this.getSystemService("clipboard")).setText(tanxc_int);
                        return;
                    }
                    String tanxc_int2 = tanxc_do.this.tanxc_int();
                    if (TextUtils.isEmpty(tanxc_int2)) {
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(tanxc_int2));
                        intent.setFlags(1610612740);
                        tanxc_do.this.startActivity(intent);
                    } catch (Throwable th2) {
                        LogUtils.d("BaseAdWebViewActivity", "showMenuDialog exception.", th2);
                    }
                }
            });
        }
        try {
            this.tanxc_try.show();
        } catch (Throwable th2) {
            LogUtils.d("BaseAdWebViewActivity", "showMenuDialog exception.", th2);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        if (isFinishing()) {
            return;
        }
        setResult(-1);
        super.finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i10;
        super.onCreate(bundle);
        setTheme(R.style.Theme_AdClick_NoActionBar);
        if (getIntent() == null) {
            LogUtils.d("BaseAdWebViewActivity", "onCreate: intent is null.");
            AdClickUtAnalytics.recordActivityCreateFail(null, "BaseAdWebViewActivity", "null_intent");
            finish();
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.tanxc_if = extras.getString("url");
            LogUtils.d("BaseAdWebViewActivity", "onCreate: mUrl == " + this.tanxc_if);
            i10 = extras.getInt(AdClickConstants.FORCE_ORIENTATION, 1);
            this.tanxc_char = extras.getLong(AdClickConstants.ACTIVITY_LAUNCH_TIME, 0L);
        } else {
            this.tanxc_if = getIntent().getDataString();
            LogUtils.d("BaseAdWebViewActivity", "onCreate:getDataString  mUrl == " + this.tanxc_if);
            i10 = 1;
        }
        if (TextUtils.isEmpty(this.tanxc_if)) {
            AdClickUtAnalytics.recordActivityCreateFail(null, "BaseAdWebViewActivity", "no_url");
            finish();
            return;
        }
        try {
            if (TextUtils.equals("1", Uri.parse(this.tanxc_if).getQueryParameter("hideRightMenu"))) {
                this.tanxc_case = true;
            }
        } catch (Exception e10) {
            LogUtils.d("BaseAdWebViewActivity", "onCreate: parse url exception.", e10);
        }
        this.tanxc_do = com.alimm.tanx.core.ad.interaction.tanxc_do.tanxc_do().tanxc_do(this.tanxc_if);
        LogUtils.d("BaseAdWebViewActivity", "onCreate: mUrl = " + this.tanxc_if + ", lastUrl = " + this.tanxc_do + ", mHideRightMenu = " + this.tanxc_case);
        setContentView(tanxc_if());
        if (!tanxc_for()) {
            LogUtils.d("BaseAdWebViewActivity", "onCreate: init view failed.");
        } else {
            tanxc_do(i10);
            tanxc_char();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.show();
            supportActionBar.setDisplayShowHomeEnabled(false);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeAsUpIndicator(R.drawable.tanx_browser_close_selector);
        }
        if (!this.tanxc_case) {
            AdWebViewUtils.setShowAsAction(menu, ActionMenu.more);
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LogUtils.d("BaseAdWebViewActivity", "onDestroy: mUrl = " + this.tanxc_if);
        OrientationEventListener orientationEventListener = this.tanxc_else;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        tanxc_case();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == ActionMenu.more.f6316id) {
            tanxc_else();
            return true;
        }
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        tanxc_case();
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LogUtils.d("BaseAdWebViewActivity", "onResume: mUrl = " + this.tanxc_if);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        LogUtils.d("BaseAdWebViewActivity", "onStart: mUrl = " + this.tanxc_if);
        tanxc_try();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        LogUtils.d("BaseAdWebViewActivity", "onStop: mUrl = " + this.tanxc_if + ", mWebMenuDialog = " + this.tanxc_try);
        tanxc_byte();
        WebMenuDialog webMenuDialog = this.tanxc_try;
        if (webMenuDialog == null || !webMenuDialog.isShowing()) {
            return;
        }
        LogUtils.d("BaseAdWebViewActivity", "onStop: destroy dialog.");
        this.tanxc_try.dismiss();
        this.tanxc_try = null;
    }

    public abstract void tanxc_byte();

    public abstract void tanxc_case();

    public abstract boolean tanxc_for();

    public abstract int tanxc_if();

    public abstract String tanxc_int();

    public abstract void tanxc_new();

    public abstract void tanxc_try();

    public void tanxc_do() {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.tanx_browser_progress);
        this.tanxc_int = progressBar;
        progressBar.setVisibility(8);
        try {
            setSupportActionBar((Toolbar) findViewById(R.id.tanx_browser_toolbar));
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.tanx_browser_actionbar_bg));
                supportActionBar.setDisplayShowCustomEnabled(true);
                supportActionBar.setCustomView(View.inflate(this, R.layout.tanx_layout_browser_title, null));
                this.tanxc_for = (TextView) findViewById(R.id.tanx_browser_custom_title);
            }
        } catch (Exception e10) {
            LogUtils.d("BaseAdWebViewActivity", "setToolbar exception.", e10);
        }
    }

    public void tanxc_do(boolean z10) {
        getWindow().setFlags(z10 ? 1024 : 0, 1024);
    }

    public void tanxc_do(int i10) {
        if (i10 != 1) {
            setRequestedOrientation(i10);
            this.tanxc_else = new OrientationEventListener(this) { // from class: com.alimm.tanx.core.ad.browser.tanxc_do.3
                public AnonymousClass3(Context this) {
                    super(this);
                }

                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i102) {
                    tanxc_do tanxc_doVar;
                    if (tanxc_do.this.tanxc_goto == -2) {
                        tanxc_do.this.tanxc_goto = i102;
                    }
                    int abs = Math.abs(tanxc_do.this.tanxc_goto - i102);
                    if (abs > 180) {
                        abs = 360 - abs;
                    }
                    if (abs <= 60 || (tanxc_doVar = tanxc_do.this) == null) {
                        return;
                    }
                    tanxc_doVar.setRequestedOrientation(10);
                    disable();
                }
            };
            new Handler().postDelayed(new Runnable() { // from class: com.alimm.tanx.core.ad.browser.tanxc_do.4
                public AnonymousClass4() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (tanxc_do.this.tanxc_else != null) {
                        tanxc_do.this.tanxc_else.enable();
                    }
                }
            }, y.f.f18076n);
        }
    }
}
