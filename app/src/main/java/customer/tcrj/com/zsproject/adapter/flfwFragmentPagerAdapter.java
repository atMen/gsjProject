package customer.tcrj.com.zsproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import customer.tcrj.com.zsproject.first.gridbtn.gzggFregment;
import customer.tcrj.com.zsproject.first.gridbtn.ldjhFregment;
import customer.tcrj.com.zsproject.first.gridbtn.xwdeTPFregment;
import customer.tcrj.com.zsproject.first.gridbtn.xwdtFregment;
import customer.tcrj.com.zsproject.first.gridbtn.zxwjFregment;
import customer.tcrj.com.zsproject.first.gridbtn.zyhdFregment;
import customer.tcrj.com.zsproject.first.zcgs.flfwFregment;

/**
 * Created by leict on 2018/4/19.
 */

public class flfwFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"机构一", "机构二", "机构三", "机构四", "机构五"
            };

    public flfwFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return new flfwFregment();
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

