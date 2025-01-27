package b.d.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.qr_codescan.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class b extends Activity {

    /* renamed from: a */
    protected static final String f4482a = "MARTIAN_QRCODE";

    /* renamed from: b */
    protected static final String f4483b = "MARTIAN_TITLE";

    /* renamed from: c */
    private String f4484c = "";

    /* renamed from: d */
    private String f4485d = "";

    /* renamed from: e */
    private Bitmap f4486e;

    /* renamed from: b */
    public /* synthetic */ boolean c(View v) {
        d();
        return false;
    }

    public static void e(Context context, Bitmap bmp) {
        File file = new File(Environment.getExternalStorageDirectory(), "Boohee");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, System.currentTimeMillis() + ".jpg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file2.getAbsolutePath())));
    }

    public static void g(Activity activity, String title, String qrcode) {
        Bundle bundle = new Bundle();
        bundle.putString(f4482a, qrcode);
        bundle.putString(f4483b, title);
        Intent intent = new Intent(activity, (Class<?>) b.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public String a(String key) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getString(key);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        e(this, this.f4486e);
        Toast.makeText(this, "二维码已保存到相册", 0).show();
    }

    public void f(String msg) {
        Toast.makeText(this, msg, 0).show();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        if (savedInstanceState != null) {
            this.f4484c = savedInstanceState.getString(f4482a);
            this.f4485d = savedInstanceState.getString(f4483b);
        } else {
            this.f4484c = a(f4482a);
            this.f4485d = a(f4483b);
        }
        if (TextUtils.isEmpty(this.f4484c)) {
            f("获取二维码失败");
            finish();
            return;
        }
        TextView textView = (TextView) findViewById(R.id.invite_title);
        ImageView imageView = (ImageView) findViewById(R.id.invite_qrcode);
        if (!TextUtils.isEmpty(this.f4485d)) {
            textView.setText(this.f4485d);
        }
        Bitmap a2 = c.a(this.f4484c);
        this.f4486e = a2;
        if (a2 == null || a2.isRecycled()) {
            f("获取二维码失败");
            finish();
        } else {
            imageView.setImageBitmap(this.f4486e);
            imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: b.d.d.a
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return b.this.c(view);
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.f4486e;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(f4482a, this.f4484c);
        outState.putString(f4483b, this.f4485d);
        super.onSaveInstanceState(outState);
    }
}
