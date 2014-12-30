package br.com.ijoke.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ShareActionProvider;

import com.google.inject.Inject;

import java.util.Locale;

import br.com.ijoke.R;
import br.com.ijoke.entity.JokeEntity;
import br.com.ijoke.service.JokeService;
import br.com.ijoke.utils.AndroidUtils;
import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

/**
 * 
 * @author Wagner Jeronimo
 *
 */
@ContentView(R.layout.activity_home)
public class HomeActivity extends RoboFragmentActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
     * will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    @InjectView(R.id.pager)
    private ViewPager mViewPager;
    
    @Inject
    private JokeService jokeService;
    
    private JokeReaderFragment readerFragment;
    private JokeHistoryFragment historyFragment;
    private JokeEntity readingJoke;
    
    private ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        this.createFragments();
    }

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		newJokeReading();
		mViewPager.setCurrentItem(0);
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		newJokeReading();
	}

	private void newJokeReading() {
		JokeEntity jokeEntity = this.jokeService.getJokeNotRead();
		if (jokeEntity != null){
			readingJoke = jokeEntity;
			if (mShareActionProvider != null){
				mShareActionProvider.setShareIntent(createIntentShare());
			}
			this.readerFragment.updateJoke(jokeEntity);
			jokeEntity.setRead(Boolean.TRUE);
			this.jokeService.saveJoke(jokeEntity);
		}else if (readingJoke != null){
			if (mShareActionProvider != null){
				mShareActionProvider.setShareIntent(createIntentShare());
			}
			this.readerFragment.updateJoke(readingJoke);

		}
		this.historyFragment.updateView(this.jokeService.listAllJoke());
	}

	private void createFragments() {
		readerFragment = new JokeReaderFragment();
		historyFragment = new JokeHistoryFragment();	
	}
	
	private Intent createIntentShare(){
		
		Intent intent= new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Share Joke");
        StringBuilder shareJokeSb = new StringBuilder();
        shareJokeSb.append(readingJoke.getJokeTitle());
        shareJokeSb.append("\n");
        shareJokeSb.append(readingJoke.getJokeDescription());
        shareJokeSb.append("\n\n share by ijoke");
        
        intent.putExtra(Intent.EXTRA_TEXT, readingJoke.getJokeTitle() + 
        		" \n " + readingJoke.getJokeDescription() +  "\n\nshare by ijoke.");
        
        return intent;
	}

	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        // Get the menu item.
        MenuItem menuItem = menu.findItem(R.id.action_share);
        // Get the provider and hold onto it to set/change the share intent.
        mShareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        
        menuItem = menu.findItem(R.id.actionDenounce);
        menuItem.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				AndroidUtils.openActivity(HomeActivity.this, JokeConfiguration.class);
				  
				return true;
			}
		});
        
        
        newJokeReading();
        
        return true;
    }
    
    

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a DummySectionFragment (defined as a static inner class
            // below) with the page number as its lone argument.
            Fragment fragment = getFragment(position);
            
            if (fragment.getArguments() == null){
            	Bundle args = new Bundle();
                args.putInt("section_number", position + 1);
                fragment.setArguments(args);
            }
            
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_home_page1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_home_page2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_home_page3).toUpperCase(l);
            }
            return null;
        }
    }

    public Fragment getFragment(int position) {
		switch (position) {
			case 0: return this.readerFragment;
			case 1: return this.historyFragment;	
			default: return this.readerFragment;
		}
	}
    

}
