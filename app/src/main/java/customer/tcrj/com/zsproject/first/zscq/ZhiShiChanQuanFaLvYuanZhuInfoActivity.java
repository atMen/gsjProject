package customer.tcrj.com.zsproject.first.zscq;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.base.BaseActivity;
import customer.tcrj.com.zsproject.base.dialogActivity;


public class ZhiShiChanQuanFaLvYuanZhuInfoActivity extends BaseActivity {

    @BindView(R.id.btnback)
    ImageView btnback;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btn_zxzx)
    Button btn_zxzx;


    @Override
    protected int setLayout() {
        return R.layout.activity_zhi_shi_chan_quan_fa_lv_yuan_zhu_info;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setData() {

    }

    @OnClick({R.id.btnback,R.id.btn_zxzx})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnback:
                finish();
                break;
            case R.id.btn_zxzx:
                toClass(this,dialogActivity.class);//创业
                break;

        }
    }

}
