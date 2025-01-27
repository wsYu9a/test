package s4;

import android.view.View;
import java.util.List;

/* loaded from: classes2.dex */
public interface d {
    public static final int B0 = -1;

    void a(View view, int index, int indexInFlexLine, com.google.android.flexbox.a flexLine);

    void addView(View view);

    void addView(View view, int index);

    int b(int widthSpec, int padding, int childDimension);

    View c(int index);

    int d(int heightSpec, int padding, int childDimension);

    int e(View view);

    void f(com.google.android.flexbox.a flexLine);

    View g(int index);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<com.google.android.flexbox.a> getFlexLines();

    List<com.google.android.flexbox.a> getFlexLinesInternal();

    int getFlexWrap();

    int getJustifyContent();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    void h(int position, View view);

    int i(View view, int index, int indexInFlexLine);

    boolean j();

    void removeAllViews();

    void removeViewAt(int index);

    void setAlignContent(int alignContent);

    void setAlignItems(int alignItems);

    void setFlexDirection(int flexDirection);

    void setFlexLines(List<com.google.android.flexbox.a> flexLines);

    void setFlexWrap(int flexWrap);

    void setJustifyContent(int justifyContent);

    void setMaxLine(int maxLine);
}
