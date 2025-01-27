package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class Scene {

    /* renamed from: a */
    private Context f3796a;

    /* renamed from: b */
    private int f3797b;

    /* renamed from: c */
    private ViewGroup f3798c;

    /* renamed from: d */
    private View f3799d;

    /* renamed from: e */
    private Runnable f3800e;

    /* renamed from: f */
    private Runnable f3801f;

    public Scene(@NonNull ViewGroup viewGroup) {
        this.f3797b = -1;
        this.f3798c = viewGroup;
    }

    static void b(@NonNull ViewGroup viewGroup, @Nullable Scene scene) {
        viewGroup.setTag(R.id.transition_current_scene, scene);
    }

    @Nullable
    public static Scene getCurrentScene(@NonNull ViewGroup viewGroup) {
        return (Scene) viewGroup.getTag(R.id.transition_current_scene);
    }

    @NonNull
    public static Scene getSceneForLayout(@NonNull ViewGroup viewGroup, @LayoutRes int i2, @NonNull Context context) {
        int i3 = R.id.transition_scene_layoutid_cache;
        SparseArray sparseArray = (SparseArray) viewGroup.getTag(i3);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            viewGroup.setTag(i3, sparseArray);
        }
        Scene scene = (Scene) sparseArray.get(i2);
        if (scene != null) {
            return scene;
        }
        Scene scene2 = new Scene(viewGroup, i2, context);
        sparseArray.put(i2, scene2);
        return scene2;
    }

    boolean a() {
        return this.f3797b > 0;
    }

    public void enter() {
        if (this.f3797b > 0 || this.f3799d != null) {
            getSceneRoot().removeAllViews();
            if (this.f3797b > 0) {
                LayoutInflater.from(this.f3796a).inflate(this.f3797b, this.f3798c);
            } else {
                this.f3798c.addView(this.f3799d);
            }
        }
        Runnable runnable = this.f3800e;
        if (runnable != null) {
            runnable.run();
        }
        b(this.f3798c, this);
    }

    public void exit() {
        Runnable runnable;
        if (getCurrentScene(this.f3798c) != this || (runnable = this.f3801f) == null) {
            return;
        }
        runnable.run();
    }

    @NonNull
    public ViewGroup getSceneRoot() {
        return this.f3798c;
    }

    public void setEnterAction(@Nullable Runnable runnable) {
        this.f3800e = runnable;
    }

    public void setExitAction(@Nullable Runnable runnable) {
        this.f3801f = runnable;
    }

    private Scene(ViewGroup viewGroup, int i2, Context context) {
        this.f3797b = -1;
        this.f3796a = context;
        this.f3798c = viewGroup;
        this.f3797b = i2;
    }

    public Scene(@NonNull ViewGroup viewGroup, @NonNull View view) {
        this.f3797b = -1;
        this.f3798c = viewGroup;
        this.f3799d = view;
    }
}
