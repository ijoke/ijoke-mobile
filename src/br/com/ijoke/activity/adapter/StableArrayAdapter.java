package br.com.ijoke.activity.adapter;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import br.com.ijoke.R;
import br.com.ijoke.activity.JokeReaderFragment;
import br.com.ijoke.entity.JokeEntity;

public class StableArrayAdapter extends ArrayAdapter<JokeEntity>{
	int selectedRule = 0;
    HashMap<Integer, JokeEntity> mIdMap = new HashMap<Integer, JokeEntity>();
    Activity context;

    
    
    public StableArrayAdapter(Context context, int textViewResourceId,
        List<JokeEntity> jokes) {
      super(context, textViewResourceId, jokes);
      for (int i = 0; i < jokes.size(); i++) {
        mIdMap.put(i,jokes.get(i));
      }
      this.context = (Activity) context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	LayoutInflater inflater = context.getLayoutInflater();
    	View v = inflater.inflate(R.layout.list_item, parent, false);  
        TextView tv = (TextView)v.findViewById(R.id.listItemBase);
        JokeEntity joke = this.mIdMap.get(position);
        tv.setText(joke.getId() + " - " + joke.getJokeTitle());
        tv.setOnClickListener(new ArrayClickListener(context, joke));
      return tv;
    }

    class ArrayClickListener implements OnClickListener{
    	private JokeEntity joke;
    	private Activity activity;
    	
    	public ArrayClickListener(Activity activity, JokeEntity joke){
    		this.activity = activity;
    		this.joke = joke;
    	}
    	
    	@Override
		public void onClick(View v) {
    		final ViewPager pager = (ViewPager)activity.findViewById(R.id.pager);
			JokeReaderFragment readerFragment = (JokeReaderFragment)((FragmentPagerAdapter)pager.getAdapter()).getItem(0);
			readerFragment.updateJoke(joke);
			pager.setCurrentItem(0);
		}
    }
	
  }
