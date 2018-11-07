package customer.tcrj.com.zsproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import customer.tcrj.com.zsproject.first.fgdtj.zzfcFregment;
import customer.tcrj.com.zsproject.first.xhzc.xhdtFregment;

/**
 * Created by leict on 2018/4/19.
 */

public class XieHuiDongTaiFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"协会动态", "工作动态"};

    public XieHuiDongTaiFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return new xhdtFregment();
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

