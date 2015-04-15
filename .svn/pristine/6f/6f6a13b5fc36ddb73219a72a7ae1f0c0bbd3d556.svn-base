package com.mandeep.employeetracking.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.model.CheckListPojo;
import com.mandeep.employeetracking.model.PackageInformationPojo;

public class CheckListAdapter extends BaseAdapter {
	Context context;
    List<CheckListPojo> rowItems;
    Activity activity;
    public CheckListAdapter(Context context, List<CheckListPojo> items) {
        this.context = context;
        this.rowItems = items;
    }
    private class ViewHolder {
        private TextView tv_question,tv_index;
   }
    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        LayoutInflater mInflater = (LayoutInflater)
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_check_list, null);
            holder = new ViewHolder();
            holder.tv_question = (TextView)convertView.findViewById(R.id.tv_question);
            holder.tv_index = (TextView)convertView.findViewById(R.id.tv_index);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        CheckListPojo rowItem = (CheckListPojo) getItem(position);
        holder.tv_question.setText(rowItem.getQuestions());
        int index = position +1;
       holder.tv_index.setText(""+index);
        
        return convertView;
    }

	@Override
    public int getCount() {    
        return rowItems.size();
    }
    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }
    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }
	
}
