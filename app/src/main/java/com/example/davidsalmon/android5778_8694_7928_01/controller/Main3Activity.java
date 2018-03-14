package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.app.Activity;
import android.os.Bundle;
import android.os.Process;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.datasource.List_DBManager;
import com.example.davidsalmon.android5778_8694_7928_01.model.datasource.MySQL_DBManager;

import java.util.ArrayList;
import java.util.List;

/**
 * we have two "MainActivity"
 * 1)MainActivity
 * 2)Main3Activity
 * the first one : is for the loading screen while all the lists are download.
 * the second one : is for the screen with the fragments.
 * class that manage the fragments on the view.
 */
public class Main3Activity extends  AppCompatActivity {
    private static final String TAG = "MainActivity";

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionPageAdapter mSectionPageAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    /**
     *
     * @param savedInstanceState contains the most recent data, specially contains
     * data of the activity's previous initialization part.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Log.d(TAG, "onCreate: Statring.");

        /*
         * Declare the mSectionPageAdapter
         */
        mSectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());

        /*
          set up the viewPager with the sections adapter
         */
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);
        /*
         * This will contains the fragment.
         * TabLayout is the layout that contains fragment.
         * The "tableLayout" gets the mViewPager to be displayed. The mViewPager containt all the fragments we
         * added and than the "tableLayout" will contain the view with those fragments.
         */
        TabLayout tableLayout = (TabLayout) findViewById(R.id.tabs);
        tableLayout.setupWithViewPager(mViewPager);
    }

    /**
     * this function build adapter (for the view) and we add fragments to the adapter which
     * after will display as the screen view by the viewPager.
     * @param viewPager is the view that contains the fragments we added.
     */
    private void  setupViewPager(ViewPager viewPager)
    {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new BranchesFragment(),"Branchs");
        adapter.addFragment(new CarFragment(),"Cars");
        adapter.addFragment(new ClientFragment(),"Clients");
        viewPager.setAdapter(adapter);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionPageAdapter extends FragmentPagerAdapter {

        /**
         * The mFragmentList will contain our fragments.
         */
        private List<Fragment> mFragmentList = new ArrayList<>();

        /**
         * The mFragmentTitleList will contain our fragments title.
         */
        private List<String> mFragmentTitleList = new ArrayList<>();

        /**
         * add a new fragment to the lists.
         * @param fragment is the fragment to be add.
         * @param title is the title fragment to be add.
         */
        public void addFragment(Fragment fragment,String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        /**
         * @param position index in mFragmentTitleList.
         * @return the title of the fragment from the mFragmentTitleList in index "position".
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        /**
         * @param fm to display the PageAdapter (default-call the super method).
         */
        public SectionPageAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         *
         * @param position index in mFragmentList.
         * @return the fragment from the mFragmentList in index "position".
         */
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        /**
         *
         * @return the size of the fragments the mFragmentList contains.
         */
        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    /**
     * this function destroy the all application so the user won't see the loading screen.
     * the process calling the killProcess method to kill the process that specified (by his id).
     */
    @Override
    protected void onDestroy() {
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }
}
