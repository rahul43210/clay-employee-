package com.mandeep.employeetracking.adapters;

import java.util.List;

import android.annotation.SuppressLint;
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
import com.mandeep.employeetracking.model.OrderDetailsPullBackPojo;
import com.mandeep.employeetracking.model.PackageInformationPojo;

@SuppressLint("ResourceAsColor")
public class OrderDetailPullBackAdapter extends BaseAdapter {
	Context context;
    List<OrderDetailsPullBackPojo> rowItems;
    Activity activity;
    public OrderDetailPullBackAdapter(Context context, List<OrderDetailsPullBackPojo> items) {
        this.context = context;
        this.rowItems = items;
    }
    private class ViewHolder {
        private TextView tv_field,tv_field_values;
        private LinearLayout ll_field;
   }
    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        LayoutInflater mInflater = (LayoutInflater)
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_order_detail_pull_back, null);
            holder = new ViewHolder();
            holder.tv_field = (TextView)convertView.findViewById(R.id.tv_field);
            holder.tv_field_values = (TextView)convertView.findViewById(R.id.tv_field_values);
            holder.ll_field = (LinearLayout)convertView.findViewById(R.id.ll_field);
            convertView.setTag(holder);
        }
        else {
        	
            holder = (ViewHolder) convertView.getTag();
        }
        OrderDetailsPullBackPojo rowItem = (OrderDetailsPullBackPojo) getItem(position);
        holder.tv_field.setText(rowItem.getFields());
        holder.tv_field_values.setText(rowItem.getFiels_value());
      if(position%2==0){
        	holder.ll_field.setBackgroundResource(R.color.background_row);
        }
        else {
        	holder.ll_field.setBackgroundResource(R.color.white);
        	
        }
        
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
