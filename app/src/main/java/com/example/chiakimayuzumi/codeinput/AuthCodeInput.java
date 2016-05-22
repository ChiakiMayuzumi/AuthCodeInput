package com.example.chiakimayuzumi.codeinput;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by chiakimayuzumi on 16/5/22.
 */
public class AuthCodeInput extends RelativeLayout {

  private TextView mTxtCodeNumber1;
  private TextView mTxtCodeNumber2;
  private TextView mTxtCodeNumber3;
  private TextView mTxtCodeNumber4;

  private TextView mTxtBar1;
  private TextView mTxtBar2;
  private TextView mTxtBar3;
  private TextView mTxtBar4;

  private EditText mEditText;

  private String mInputText = "";
  private TextView[] tvs;
  private TextView[] bars;
  private OnCompletionListener onCompletionListener;

  public AuthCodeInput(Context context) {
    super(context);
    initView();
  }

  public AuthCodeInput(Context context, AttributeSet attrs) {
    super(context, attrs);
    initView();
  }

  public AuthCodeInput(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initView();
  }

  /**
   * 初始化视图和数据
   */
  private void initView() {
    View.inflate(getContext(), R.layout.activity_codeinput, this);

    mEditText= (EditText) findViewById(R.id.edit_input);

    mTxtCodeNumber1 = (TextView)findViewById(R.id.text_code_number_1);
    mTxtCodeNumber2 = (TextView)findViewById(R.id.text_code_number_2);
    mTxtCodeNumber3 = (TextView)findViewById(R.id.text_code_number_3);
    mTxtCodeNumber4= (TextView)findViewById(R.id.text_code_number_4);

    mTxtBar1= (TextView)findViewById(R.id.text_bar_1);
    mTxtBar2= (TextView)findViewById(R.id.text_bar_2);
    mTxtBar3= (TextView)findViewById(R.id.text_bar_3);
    mTxtBar4= (TextView)findViewById(R.id.text_bar_4);

    tvs = new TextView[]{mTxtCodeNumber1, mTxtCodeNumber2, mTxtCodeNumber3, mTxtCodeNumber4};
    bars = new TextView[]{mTxtBar1, mTxtBar2, mTxtBar3, mTxtBar4};

    mEditText.addTextChangedListener(new TextWatcher(){

      @Override
      public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        mInputText = charSequence.toString();
        Log.d("TAG", "输入的是：" + mInputText);


        refreshUI();

        if (mInputText.length() == 4) {
          onCompletionListener.onCompleted(mInputText);
        }
      }

      @Override
      public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

      @Override
      public void afterTextChanged(Editable editable) {}

    });

  }

  private void refreshUI(){

    int length = mInputText.length();

    for (int i = 0; i < 4; i++) {
      if (i < length){
        tvs[i].setText(mInputText.charAt(i) + "");
        bars[i].setBackgroundResource(R.drawable.bar_with_number);

      } else {
        tvs[i].setText("");
        bars[i].setBackgroundResource(R.drawable.bar_no_number);
      }
    }

  }

  public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
    this.onCompletionListener = onCompletionListener;
  }

  public interface OnCompletionListener{
    void onCompleted(String text);
  }

}
