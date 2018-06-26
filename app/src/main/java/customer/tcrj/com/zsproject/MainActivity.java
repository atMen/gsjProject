package customer.tcrj.com.zsproject;

import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.jaeger.library.StatusBarUtil;

import customer.tcrj.com.zsproject.Utils.AppManager;
import customer.tcrj.com.zsproject.first.FirstFragment;
import customer.tcrj.com.zsproject.mine.MineFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fragmentManager;
    private MineFragment mineFragment;
    private FirstFragment newsFragment;

    private RelativeLayout sy;
    private RelativeLayout mine;

    private TextView sytv;
    private TextView minetv;

    private ImageView dd;
    private ImageView dd4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayuot);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this, 5,null);
        AppManager.getAppManager().addActivity(this);
        initview();
    }

    private void initview() {
        fragmentManager = getSupportFragmentManager();

        sy = (RelativeLayout) findViewById(R.id.sy);
        mine = (RelativeLayout) findViewById(R.id.mine);

        sytv = (TextView) findViewById(R.id.sy_tv);
        minetv = (TextView) findViewById(R.id.mine_tv);

        dd = (ImageView) findViewById(R.id.dd);
        dd4 = (ImageView) findViewById(R.id.dd4);



        sy.setOnClickListener(this);
        mine.setOnClickListener(this);

        setTabSelection(0);
    }

    private int num = -1;
    private void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                if (newsFragment == null) {
                    newsFragment = new FirstFragment();
                    transaction.add(R.id.contentContainer, newsFragment);
                } else {
                    transaction.show(newsFragment);
                }

                break;

            case 1:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.contentContainer, mineFragment);
                } else {
                    transaction.show(mineFragment);
                }
                break;

        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sy:

                if(num != 0){

                    sytv.setTextColor(getResources().getColor(R.color.blue));
                    minetv.setTextColor(getResources().getColor(R.color.color_text));

                    dd.setImageResource(R.drawable.sybtn);
                    dd4.setImageResource(R.drawable.mine);


                    setTabSelection(0);
                }

                num = 0;
                break;

            case R.id.mine:

                if(num != 1) {
                    sytv.setTextColor(getResources().getColor(R.color.color_text));
                    minetv.setTextColor(getResources().getColor(R.color.blue));

                    dd.setImageResource(R.drawable.sybtn_gay);
                    dd4.setImageResource(R.drawable.mine_blue);

                    setTabSelection(1);
                }
                num = 1;
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
        AppManager.getAppManager().finishActivity(this); //从栈中移除
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息

            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
//            System.exit(0);
        }
    }

    //定义一个变量，
    //来标识是否退出
    private static boolean isExit = false;
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };


}

