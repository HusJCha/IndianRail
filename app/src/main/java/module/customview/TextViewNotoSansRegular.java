package module.customview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.indianrail.android.R;


public class TextViewNotoSansRegular extends TextView {
    public TextViewNotoSansRegular(Context context) {
        super(context);
        setFontStyle(context);
    }

    public TextViewNotoSansRegular(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontStyle(context);

    }

    public TextViewNotoSansRegular(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontStyle(context);

    }

    public TextViewNotoSansRegular(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setFontStyle(context);
    }

    void setFontStyle(Context context) {
        Typeface typeface = ResourcesCompat.getFont(context, R.font.notosansregular);
        setTypeface(typeface);
    }

}
