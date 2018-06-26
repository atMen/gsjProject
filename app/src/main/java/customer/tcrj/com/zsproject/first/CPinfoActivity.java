package customer.tcrj.com.zsproject.first;


import android.widget.TextView;

import butterknife.BindView;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.base.BaseActivity;

public class CPinfoActivity extends BaseActivity {

    @BindView(R.id.txtTitle)
    TextView txtTitle;

    @Override
    protected int setLayout() {
        return R.layout.activity_cpinfo;
    }

    @Override
    protected void setView() {

        txtTitle.setText("产品信息录入");
    }

    @Override
    protected void setData() {

    }
}
