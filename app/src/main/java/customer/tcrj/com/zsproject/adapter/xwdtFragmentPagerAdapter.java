package customer.tcrj.com.zsproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import customer.tcrj.com.zsproject.first.gridbtn.xwdeTPFregment;
import customer.tcrj.com.zsproject.first.gridbtn.xwdtFregment;
import customer.tcrj.com.zsproject.mine.MineFragment;

/**
 * Created by leict on 2018/4/19.
 */

public class xwdtFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"专题课程", "形势政策", "微视分享", "典型事迹", "形势政策", "微视分享", "典型事迹", "形势政策", "微视分享", "典型事迹"};

    public xwdtFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new xwdtFregment();
        } else if (position == 1) {
            return new xwdeTPFregment();
        }else if (position == 2){
            return new xwdeTPFregment();
        }
        return new xwdtFregment();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //用来设置tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }


}

