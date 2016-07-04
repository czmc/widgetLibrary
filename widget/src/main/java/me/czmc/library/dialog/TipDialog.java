package me.czmc.library.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import me.czmc.library.widget.R;


public class TipDialog extends CommonDialog {
    private Button btn_cancel;
    private Button btn_confirm;
    protected OnDialogBtnClickListener mOnClickListener;
    private TextView txt_content;
    private TextView txt_title;

    public interface OnDialogBtnClickListener {
        void onLeftBtnClicked(TipDialog tipDialog);
        void onRightBtnClicked(TipDialog tipDialog);
    }

    public TipDialog(Context context) {
        super(context);
        setContentView(R.layout.dialog_tip);
        this.txt_title = (TextView) findViewById(R.id.txt_title);
        this.txt_content = (TextView) findViewById(R.id.txt_content);
        this.btn_cancel = (Button) findViewById(R.id.btn_cancel);
        this.btn_cancel.setOnClickListener(this);
        this.btn_confirm = (Button) findViewById(R.id.btn_confirm);
        this.btn_confirm.setOnClickListener(this);
    }

    public static TipDialog newInstance(Context context) {
        return new TipDialog(context);
    }

    public void hideTitle() {
        this.txt_title.setVisibility(View.GONE);
    }

    public void setTitle(String title) {
        this.txt_title.setText(title);
    }

    public void setContent(String content) {
        this.txt_content.setText(content);
    }

    public void setLeftBtnText(String leftBtnText) {
        this.btn_cancel.setText(leftBtnText);
    }

    public void setRightBtnText(String rightBtnText) {
        this.btn_confirm.setText(rightBtnText);
    }

    public void setOnBtnClickListener(OnDialogBtnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_confirm) {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onRightBtnClicked(this);
            }

            if (this.mOnClickListener != null) {
                this.mOnClickListener.onLeftBtnClicked(this);
            }
        } else if (i == R.id.btn_cancel) {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onLeftBtnClicked(this);
            }
        } else {
        }
    }
}