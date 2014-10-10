package br.com.ijoke.activity.adapter;

import java.util.HashMap;
import java.util.List;

import br.com.ijoke.R;
import br.com.ijoke.entity.JokeEntity;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class StableArrayAdapter extends ArrayAdapter<JokeEntity>{
	int selectedRule = 0;
    HashMap<Integer, JokeEntity> mIdMap = new HashMap<Integer, JokeEntity>();
    Activity context;
    public StableArrayAdapter(Context context, int textViewResourceId,
        List<JokeEntity> rules) {
      super(context, textViewResourceId, rules);
      for (int i = 0; i < rules.size(); ++i) {
        mIdMap.put(i,rules.get(i));
      }
      this.context = (Activity) context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	LayoutInflater inflater = context.getLayoutInflater();
    	View v = inflater.inflate(R.layout.list_item, parent, false);  
        TextView tv = (TextView)v.findViewById(R.id.listItemBase);
        
        final ViewPager pager = (ViewPager)context.findViewById(R.id.pager);
        
        JokeEntity j = this.mIdMap.get(position);
        
        tv.setText(j.getId() + " - " + j.getJokeTitle());
        tv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				pager.setCurrentItem(0);
			}
		});
      return tv;
    }


	
  }
