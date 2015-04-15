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
import com.mandeep.employeetracking.model.PackageInformationPojo;

public class PackageInformationAdapter extends BaseAdapter {
	Context context;
    List<PackageInformationPojo> rowItems;
    Activity activity;
    public PackageInformationAdapter(Context context, List<PackageInformationPojo> items) {
        this.context = context;
        this.rowItems = items;
    }
    private class ViewHolder {
        private TextView tv_item_head,tv_call_type,tv_unit_price,tv_min_price,tv_off_peak_price,
        tv_unit,tv_min_unit;
        private LinearLayout ll_call_chat;
   }
    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        LayoutInflater mInflater = (LayoutInflater)
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_package_details, null);
            holder = new ViewHolder();
            holder.tv_item_head = (TextView)convertView.findViewById(R.id.tv_item_head);
            holder.tv_call_type = (TextView)convertView.findViewById(R.id.tv_call_type);
            holder.tv_unit_price = (TextView)convertView.findViewById(R.id.tv_unit_price);
            holder.tv_min_price = (TextView)convertView.findViewById(R.id.tv_min_price);
            holder.tv_off_peak_price = (TextView)convertView.findViewById(R.id.tv_off_peak_price);
            holder.tv_unit = (TextView)convertView.findViewById(R.id.tv_unit);
            holder.tv_min_unit = (TextView)convertView.findViewById(R.id.tv_min_unit);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        PackageInformationPojo rowItem = (PackageInformationPojo) getItem(position);
        holder.tv_item_head.setText(rowItem.getItems());
        holder.tv_call_type.setText(rowItem.getCall_type());
        holder.tv_unit_price.setText(rowItem.getUnit_price());
        holder.tv_min_price.setText(rowItem.getMin_price());
        holder.tv_off_peak_price.setText(rowItem.getOff_peak_price());
        holder.tv_unit.setText(rowItem.getUnit());
        holder.tv_min_unit.setText(rowItem.getMin_unit());
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
