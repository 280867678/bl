package com.example.boluouitest2.comod.baselib.view.flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.boluouitest2.R;
import com.example.boluouitest2.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;












import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class AutoFlowLayout<T> extends ViewGroup {

    /* renamed from: b */
    public List<List<View>> f1728b = new ArrayList();

    /* renamed from: c */
    public List<Integer> f1729c = new ArrayList();

    /* renamed from: d */
    public boolean f1730d;

    /* renamed from: e */
    public List<Integer> f1731e = new ArrayList();

    /* renamed from: f */
    public int f1732f;

    /* renamed from: g */
    public int f1733g;

    /* renamed from: h */
    public AbstractC0912c f1734h;

    /* renamed from: i */
    public int f1735i = -1;

    /* renamed from: j */
    public boolean f1736j;

    /* renamed from: k */
    public int f1737k = 10;

    /* renamed from: l */
    public View f1738l;

    /* renamed from: m */
    public List<View> f1739m = new ArrayList();

    /* renamed from: n */
    public FlowAdapter<T> f1740n;

    /* renamed from: o */
    public float f1741o;

    /* renamed from: p */
    public float f1742p;

    /* renamed from: q */
    public int f1743q;

    /* renamed from: r */
    public int f1744r;

    /* renamed from: s */
    public boolean f1745s;

    /* renamed from: t */
    public boolean f1746t;

    /* renamed from: u */
    public float f1747u;

    /* renamed from: v */
    public int f1748v;

    /* renamed from: w */
    public boolean f1749w;

    /* renamed from: x */
    public AbstractC0913d f1750x;

    /* renamed from: com.comod.baselib.view.flow.AutoFlowLayout$a */
    public class View$OnLongClickListenerC0910a implements View.OnLongClickListener {

        /* renamed from: b */
        public final /* synthetic */ Integer f1751b;

        public View$OnLongClickListenerC0910a(Integer num) {
            this.f1751b = num;
        }

        public boolean onLongClick(View view) {
            if (AutoFlowLayout.this.f1750x == null) {
                return false;
            }
            AutoFlowLayout.this.f1750x.mo15257a(((Integer) (this.f1751b.intValue() == -1 ? view.getTag() : this.f1751b)).intValue(), view);
            return true;
        }
    }

    /* renamed from: com.comod.baselib.view.flow.AutoFlowLayout$b */
    public class View$OnClickListenerC0911b implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ Integer f1753b;

        public View$OnClickListenerC0911b(Integer num) {
            this.f1753b = num;
        }

        public void onClick(View view) {
            if (AutoFlowLayout.this.f1736j) {
                if (AutoFlowLayout.this.f1739m.contains(view)) {
                    AutoFlowLayout.this.f1739m.remove(view);
                    view.setSelected(false);
                } else if (AutoFlowLayout.this.f1739m.size() >= AutoFlowLayout.this.f1737k) {
                    Context context = AutoFlowLayout.this.getContext();
                    ToastUtil.m9102c(context, "最多可选择" + AutoFlowLayout.this.f1737k + "个标签");
                    return;
                } else {
                    view.setSelected(true);
                    AutoFlowLayout.this.f1739m.add(view);
                    AutoFlowLayout.this.f1738l = view;
                }
            } else if (view.isSelected()) {
                view.setSelected(false);
            } else {
                if (AutoFlowLayout.this.f1738l != null) {
                    AutoFlowLayout.this.f1738l.setSelected(false);
                }
                view.setSelected(true);
                AutoFlowLayout.this.f1738l = view;
            }
            if (AutoFlowLayout.this.f1734h != null) {
                AutoFlowLayout.this.f1734h.mo15256a(((Integer) (this.f1753b.intValue() == -1 ? view.getTag() : this.f1753b)).intValue(), view);
            }
        }
    }

    /* renamed from: com.comod.baselib.view.flow.AutoFlowLayout$c */
    public interface AbstractC0912c {
        /* renamed from: a */
        void mo15256a(int i, View view);
    }

    /* renamed from: com.comod.baselib.view.flow.AutoFlowLayout$d */
    public interface AbstractC0913d {
        /* renamed from: a */
        void mo15257a(int i, View view);
    }

    public AutoFlowLayout(Context context) {
        super(context);
    }

    /* renamed from: c */
    public final void mo15222c(int i, int i2) {
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f1745s && this.f1746t) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f1747u);
            paint.setColor(this.f1748v);
            for (int i = 0; i < this.f1744r; i++) {
                int i2 = 0;
                while (true) {
                    int i3 = this.f1743q;
                    if (i2 >= i3) {
                        break;
                    }
                    View childAt = getChildAt((i3 * i) + i2);
                    if (i2 == this.f1743q - 1) {
                        if (i != this.f1744r - 1) {
                            canvas.drawLine(((float) childAt.getLeft()) - (this.f1741o / 2.0f), (this.f1742p / 2.0f) + ((float) childAt.getBottom()), (float) childAt.getRight(), (this.f1742p / 2.0f) + ((float) childAt.getBottom()), paint);
                        }
                    } else if (i == this.f1744r - 1) {
                        canvas.drawLine((this.f1741o / 2.0f) + ((float) childAt.getRight()), ((float) childAt.getTop()) - (this.f1742p / 2.0f), (this.f1741o / 2.0f) + ((float) childAt.getRight()), (float) childAt.getBottom(), paint);
                    } else {
                        if (i2 == 0) {
                            canvas.drawLine((float) childAt.getLeft(), (this.f1742p / 2.0f) + ((float) childAt.getBottom()), (this.f1741o / 2.0f) + ((float) childAt.getRight()), (this.f1742p / 2.0f) + ((float) childAt.getBottom()), paint);
                        } else {
                            canvas.drawLine(((float) childAt.getLeft()) - (this.f1741o / 2.0f), (this.f1742p / 2.0f) + ((float) childAt.getBottom()), (this.f1741o / 2.0f) + ((float) childAt.getRight()), (this.f1742p / 2.0f) + ((float) childAt.getBottom()), paint);
                        }
                        if (i == 0) {
                            canvas.drawLine((this.f1741o / 2.0f) + ((float) childAt.getRight()), (float) childAt.getTop(), (this.f1741o / 2.0f) + ((float) childAt.getRight()), (this.f1742p / 2.0f) + ((float) childAt.getBottom()), paint);
                        } else {
                            canvas.drawLine((this.f1741o / 2.0f) + ((float) childAt.getRight()), ((float) childAt.getTop()) - (this.f1742p / 2.0f), (this.f1741o / 2.0f) + ((float) childAt.getRight()), (this.f1742p / 2.0f) + ((float) childAt.getBottom()), paint);
                        }
                    }
                    i2++;
                }
            }
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(super.generateDefaultLayoutParams());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public List<View> getCheckedViews() {
        if (this.f1736j) {
            return this.f1739m;
        }
        this.f1739m.add(this.f1738l);
        return this.f1739m;
    }

    public int getColumnNumbers() {
        return this.f1743q;
    }

    public int getCutLineColor() {
        return this.f1748v;
    }

    public float getCutLineWidth() {
        return this.f1747u;
    }

    public float getHorizontalSpace() {
        return this.f1741o;
    }

    public int getMaxLineNumbers() {
        return this.f1732f;
    }

    public int getRowNumbers() {
        return this.f1744r;
    }

    public View getSelectedView() {
        return this.f1738l;
    }

    public float getVerticalSpace() {
        return this.f1742p;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1745s) {
            mo15221c();
        } else {
            mo15219b();
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.f1745s) {
            mo15220b(i, i2);
        } else {
            mo15215a(i, i2);
        }
    }

    public void setAdapter(FlowAdapter<T> aVar) {
        this.f1740n = aVar;
        if (this.f1740n.mo35214a() != 0) {
            for (int i = 0; i < this.f1740n.mo35214a(); i++) {
                addView(this.f1740n.mo11688a(i));
            }
            requestLayout();
        }
    }

    public void setAllViews(List<View> list) {
        removeAllViews();
        if (!(list == null || list.size() == 0)) {
            for (int i = 0; i < list.size(); i++) {
                addView(list.get(i));
            }
            requestLayout();
        }
    }

    public void setColumnNumbers(int i) {
        this.f1743q = i;
        requestLayout();
    }

    public void setCutLine(boolean z) {
        this.f1746t = z;
        invalidate();
    }

    public void setCutLineColor(int i) {
        this.f1748v = i;
        invalidate();
    }

    public void setCutLineWidth(float f) {
        this.f1747u = f;
        invalidate();
    }

    public void setHorizontalSpace(int i) {
        this.f1741o = (float) i;
        requestLayout();
    }

    public void setLineCenter(boolean z) {
        this.f1749w = z;
        requestLayout();
    }

    public void setMaxLines(int i) {
        this.f1732f = i;
        requestLayout();
    }

    public void setMultiChecked(boolean z) {
        this.f1736j = z;
    }

    public void setOnItemClickListener(AbstractC0912c cVar) {
        this.f1734h = cVar;
    }

    public void setOnLongItemClickListener(AbstractC0913d dVar) {
        this.f1750x = dVar;
    }

    public void setRowNumbers(int i) {
        this.f1744r = i;
        requestLayout();
    }

    public void setSingleLine(boolean z) {
        this.f1730d = z;
        requestLayout();
    }

    public void setVerticalSpace(int i) {
        this.f1742p = (float) i;
        requestLayout();
    }

    public void setmMustCheckedNum(int i) {
        this.f1737k = i;
    }

    /* renamed from: b */
    public final void mo15220b(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (this.f1744r == 0) {
            this.f1744r = getChildCount() % this.f1743q == 0 ? getChildCount() / this.f1743q : (getChildCount() / this.f1743q) + 1;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i3 = this.f1744r;
            if (i6 >= i3) {
                break;
            }
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int i12 = this.f1743q;
                if (i9 >= i12) {
                    break;
                }
                View childAt = getChildAt((i12 * i6) + i9);
                if (childAt != null) {
                    i5 = mode2;
                    i4 = mode;
                    if (childAt.getVisibility() != View.GONE) {
                        measureChild(childAt, i, i2);
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
                        i10 += childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                        i11 = Math.max(i11, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                    }
                } else {
                    i4 = mode;
                    i5 = mode2;
                }
                i9++;
                mode2 = i5;
                mode = i4;
            }
            i7 = Math.max(i10, i7);
            i8 += i11;
            i6++;
        }
        int i13 = (int) (((float) i7) + (this.f1741o * ((float) (this.f1743q - 1))) + ((float) paddingLeft) + ((float) paddingRight));
        int i14 = (int) (((float) i8) + (this.f1742p * ((float) (i3 - 1))) + ((float) paddingBottom) + ((float) paddingTop));
        if (i13 > size) {
            i13 = size;
        }
        if (i14 > size2) {
            i14 = size2;
        }
        if (mode == 1073741824) {
            i13 = size;
        }
        if (mode2 != 1073741824) {
            size2 = i14;
        }
        setMeasuredDimension(i13, size2);
    }

    /* renamed from: c */
    public final void mo15221c() {
        this.f1739m.clear();
        this.f1735i = -1;
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getChildAt(0).getLayoutParams();
        float f = this.f1741o;
        int i = this.f1743q;
        int paddingLeft = (((int) ((((float) ((width - getPaddingLeft()) - getPaddingRight())) - (f * ((float) (i - 1)))) / ((float) i))) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        float f2 = this.f1742p;
        int i2 = this.f1744r;
        int paddingTop = (((int) ((((float) ((height - getPaddingTop()) - getPaddingBottom())) - (f2 * ((float) (i2 - 1)))) / ((float) i2))) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin;
        for (int i3 = 0; i3 < this.f1744r; i3++) {
            int i4 = 0;
            while (true) {
                int i5 = this.f1743q;
                if (i4 >= i5) {
                    break;
                }
                View childAt = getChildAt((i5 * i3) + i4);
                if (childAt != null) {
                    this.f1735i++;
                    if (childAt.getVisibility() != View.GONE) {
                        mo15217a(childAt,  -1);
                        int i6 = marginLayoutParams.leftMargin;
                        int paddingLeft2 = ((int) (((float) getPaddingLeft()) + (((float) i4) * (((float) paddingLeft) + this.f1741o)))) + ((marginLayoutParams.rightMargin + i6) * i4) + i6;
                        int i7 = marginLayoutParams.topMargin;
                        int paddingTop2 = ((int) (((float) getPaddingTop()) + (((float) i3) * (((float) paddingTop) + this.f1742p)))) + ((marginLayoutParams.bottomMargin + i7) * i3) + i7;
                        childAt.layout(paddingLeft2, paddingTop2, paddingLeft2 + paddingLeft, paddingTop + paddingTop2);
                    }
                }
                i4++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    /* renamed from: a */
    @SuppressLint("ResourceType")
    public final void mo15216a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutoFlowLayout);
        this.f1730d = obtainStyledAttributes.getBoolean(R.styleable.AutoFlowLayout_singleLine, false);
        this.f1732f = obtainStyledAttributes.getInteger(R.styleable.AutoFlowLayout_maxLines, Integer.MAX_VALUE);
        this.f1736j = obtainStyledAttributes.getBoolean(R.styleable.AutoFlowLayout_multiChecked, false);
        this.f1741o = obtainStyledAttributes.getDimension(R.styleable.AutoFlowLayout_horizontalSpace, 0.0f);
        this.f1742p = obtainStyledAttributes.getDimension(R.styleable.AutoFlowLayout_verticalSpace, 0.0f);
        this.f1743q = obtainStyledAttributes.getInteger(R.styleable.AutoFlowLayout_columnNumbers, 0);
        this.f1744r = obtainStyledAttributes.getInteger(R.styleable.AutoFlowLayout_rowNumbers, 0);
        this.f1748v = obtainStyledAttributes.getColor(R.styleable.AutoFlowLayout_cutLineColor, getResources().getColor(17170432));
        this.f1747u = obtainStyledAttributes.getDimension(R.styleable.AutoFlowLayout_cutLineWidth, 1.0f);
        this.f1746t = obtainStyledAttributes.getBoolean(R.styleable.AutoFlowLayout_cutLine, false);
        this.f1749w = obtainStyledAttributes.getBoolean(R.styleable.AutoFlowLayout_lineCenter, false);
        if (this.f1743q != 0) {
            this.f1745s = true;
        }
        obtainStyledAttributes.recycle();
    }

    public AutoFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo15216a(context, attributeSet);
    }

    public AutoFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo15216a(context, attributeSet);
    }

    /* renamed from: a */
    public final void mo15215a(int i, int i2) {
        int i3;
        int i4 = 0;
        this.f1733g = 0;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        int i5 = paddingTop;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i4 >= childCount) {
                i3 = size2;
                break;
            }
            View childAt = getChildAt(i4);
            measureChild(childAt, i, i2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            i3 = size2;
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i8 = paddingLeft + measuredWidth;
            if (i8 > size) {
                i7 = Math.max(paddingLeft, measuredWidth);
                i5 += i6;
                this.f1733g++;
                if (this.f1733g >= this.f1732f) {
                    mo15222c(i4 + 1, childCount);
                    break;
                } else if (this.f1730d) {
                    mo15222c(i4 + 1, childCount);
                    break;
                } else {
                    i6 = measuredHeight;
                    paddingLeft = measuredWidth;
                }
            } else {
                i6 = Math.max(i6, measuredHeight);
                paddingLeft = i8;
            }
            if (i4 == childCount - 1) {
                i5 += i6;
                i7 = Math.max(i7, paddingLeft);
            }
            i4++;
            size2 = i3;
        }
        int i9 = i5;
        if (mode != 1073741824) {
            size = i7;
        }
        if (mode2 == 1073741824) {
            i9 = i3;
        }
        setMeasuredDimension(size, i9);
    }

    /* renamed from: b */
    public final void mo15219b() {
        this.f1735i = -1;
        this.f1733g = 0;
        this.f1728b.clear();
        this.f1731e.clear();
        this.f1729c.clear();
        this.f1739m.clear();
        int width = getWidth();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        ArrayList arrayList2 = arrayList;
        int i = paddingTop;
        int i2 = paddingLeft;
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin + getPaddingRight() + i2 > width) {
                this.f1731e.add(Integer.valueOf(i));
                this.f1728b.add(arrayList2);
                this.f1729c.add(Integer.valueOf(marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + getPaddingRight() + i2));
                arrayList2 = new ArrayList();
                this.f1733g++;
                if (this.f1733g >= this.f1732f) {
                    mo15222c(i3 + 1, childCount);
                    break;
                } else if (this.f1730d) {
                    mo15222c(i3 + 1, childCount);
                    break;
                } else {
                    i2 = 0;
                }
            }
            i2 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            i = Math.max(i, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            arrayList2.add(childAt);
            i3++;
        }
        i2 = 0;
        this.f1731e.add(Integer.valueOf(i));
        this.f1728b.add(arrayList2);
        this.f1729c.add(Integer.valueOf(i2));
        int paddingLeft2 = getPaddingLeft();
        int paddingTop2 = getPaddingTop();
        int size = this.f1728b.size();
        List<List<View>> list = this.f1728b;
        if (list.get(list.size() - 1).size() == 0) {
            size = this.f1728b.size() - 1;
        }
        int i4 = paddingTop2;
        int i5 = paddingLeft2;
        int i6 = 0;
        while (i6 < size) {
            List<View> list2 = this.f1728b.get(i6);
            int intValue = this.f1731e.get(i6).intValue();
            if (this.f1749w && this.f1729c.get(i6).intValue() < getWidth()) {
                i5 += (getWidth() - this.f1729c.get(i6).intValue()) / 2;
            }
            int i7 = i5;
            for (int i8 = 0; i8 < list2.size(); i8++) {
                View view = list2.get(i8);
                this.f1735i++;
                if (view.getVisibility() != View.GONE) {
                    mo15217a(view,  -1);
                    MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) view.getLayoutParams();
                    int i9 = marginLayoutParams2.leftMargin + i7;
                    int i10 = marginLayoutParams2.topMargin + i4;
                    view.layout(i9, i10, view.getMeasuredWidth() + i9, view.getMeasuredHeight() + i10);
                    i7 += view.getMeasuredWidth() + marginLayoutParams2.rightMargin + marginLayoutParams2.leftMargin;
                }
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) getChildAt(0).getLayoutParams();
            int paddingLeft3 = getPaddingLeft();
            i4 += intValue + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin;
            i6++;
            i5 = paddingLeft3;
        }
    }

    /* renamed from: a */
    public final void mo15217a(View view, Integer num) {
        if (view.getTag() == null) {
            view.setTag(Integer.valueOf(this.f1735i));
        }
        view.setOnLongClickListener(new View$OnLongClickListenerC0910a(num));
        view.setOnClickListener(new View$OnClickListenerC0911b(num));
    }

    /* renamed from: a */
    public boolean mo15218a() {
        if (getChildCount() <= 0) {
            return false;
        }
        removeAllViews();
        return true;
    }


}
