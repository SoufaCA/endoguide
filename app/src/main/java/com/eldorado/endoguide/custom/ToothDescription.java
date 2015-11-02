package com.eldorado.endoguide.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.eldorado.endoguide.R;

/**
 * TODO: document your custom view class.
 */
public class ToothDescription extends TableLayout {

    private TextView descriptionText;
    private ImageView descriptionImage;

    public ToothDescription(Context context) {
        super(context);
        init(null, 0);
    }


    public ToothDescription(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    private void init(AttributeSet attrs, int defStyle) {

        inflate(getContext(), R.layout.tooth_description_view, this);

        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.ToothDescription, defStyle, 0);

        descriptionText = (TextView) findViewById(R.id.description_text);
        descriptionImage = (ImageView) findViewById(R.id.description_image);

        descriptionImage.setImageDrawable(a.getDrawable(R.styleable.ToothDescription_descriptionImage));

        a.recycle();
    }

}
