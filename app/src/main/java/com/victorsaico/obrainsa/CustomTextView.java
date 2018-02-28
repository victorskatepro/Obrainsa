package com.victorsaico.obrainsa;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);

        if (!isInEditMode())
            font(context, null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode())
            font(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (!isInEditMode())
            font(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        if (!isInEditMode())
            font(context, attrs);
    }

    public void font(Context context, AttributeSet attrs) {
        try {
            TypedArray attributeArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
            String fontName = attributeArray.getString(R.styleable.CustomTextView_font);
            Typeface museo = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontName);
            super.setTypeface(museo);
        } catch (Exception e) {
            Typeface museo = Typeface.createFromAsset(context.getAssets(), "fonts/DINPro.otf");
            super.setTypeface(museo);
            Log.e("Exception", e.toString());
        }
    }
}