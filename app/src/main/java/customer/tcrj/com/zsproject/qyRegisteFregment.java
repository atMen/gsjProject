package customer.tcrj.com.zsproject;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import customer.tcrj.com.zsproject.base.BaseFragment;
import customer.tcrj.com.zsproject.widget.CountDownButton;

/**
 * Created by leict on 2018/7/2.
 */

public class qyRegisteFregment extends BaseFragment {

    @BindView(R.id.timeButton)
    CountDownButton countDownButton;


    @Override
    protected int setLayout() {
        return R.layout.registe_gr_fregment;
    }

    @Override
    protected void setView() {

        //设置Button点击事件触发倒计时
        countDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countDownButton.isFinish()) {
                    //发送验证码请求成功后调用
                    countDownButton.start();
                }
            }
        });
    }

    @Override
    protected void setData() {

    }

    @Override
    public void onDestroy() {

        if (!countDownButton.isFinish()) {
            countDownButton.cancel();
        }
        super.onDestroy();
    }

}
