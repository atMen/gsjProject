package customer.tcrj.com.zsproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.OnClick;
import customer.tcrj.com.zsproject.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.btn_login)
    Button btnlogin;

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void setView() {

    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForImageView(this,10, null);
    }

    @Override
    protected void setData() {

    }

    @OnClick({R.id.btn_login})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                toClass(this,MainActivity.class);
                break;

        }
    }
}
