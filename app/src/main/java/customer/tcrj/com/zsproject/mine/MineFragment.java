package customer.tcrj.com.zsproject.mine;


import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import customer.tcrj.com.zsproject.MainActivity;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.RegisteActivity;
import customer.tcrj.com.zsproject.base.BaseFragment;


/**
 * Created by leict on 2018/3/22.
 */

public class MineFragment extends BaseFragment {

    @BindView(R.id.rl_01)
    RelativeLayout rl_01;


    @Override
    protected int setLayout() {
        return R.layout.mine_fragment;
    }

    @Override
    protected void setView() {
    }


    @Override
    protected void setData() {


    }




    @OnClick({R.id.rl_01})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_01:
                toClass(mContext,RegisteActivity.class);
                break;

        }
    }

}
