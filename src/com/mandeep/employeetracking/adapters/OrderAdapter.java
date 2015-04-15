package com.mandeep.employeetracking.adapters;



import java.util.ArrayList;

import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.activity.LoginScreenActivity;
import com.mandeep.employeetracking.activity.OrderDetailPullBackActivity;
import com.mandeep.employeetracking.activity.OrderIncompleteActivity;
import com.mandeep.employeetracking.activity.WelcomeScreenActivity;
import com.mandeep.employeetracking.model.OrderDetails;

import android.R.color;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrderAdapter extends BaseAdapter  {

	Context context;
	ArrayList<OrderDetails> arr_order;
    
   
    public OrderAdapter(Context context, ArrayList<OrderDetails> arr_order) {
        this.context = context;
        this.arr_order = arr_order;
    }
    
    
    private class ViewHolder
    {
        private TextView tv_RAF_NO,tv_OrderType,tv_SimType,tv_Location,tv_Time;
        private LinearLayout ll_order_list_item;
        
       
    }
    
    
    @Override
	public View getView(final int position, View convertView, ViewGroup parent)
    {
        final ViewHolder holder;
        
        LayoutInflater mInflater = (LayoutInflater)
        		
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.order_item, null);
            
            holder = new ViewHolder();
            
            holder.tv_RAF_NO =(TextView)convertView.findViewById(R.id.tv_RAF_NO);
            holder.tv_OrderType =(TextView)convertView.findViewById(R.id.tv_OrderType);
            holder.tv_SimType =(TextView)convertView.findViewById(R.id.tv_SimType);
            holder.tv_Location =(TextView)convertView.findViewById(R.id.tv_Location);
            holder.tv_Time =(TextView)convertView.findViewById(R.id.tv_Time);
            holder.ll_order_list_item=(LinearLayout)convertView.findViewById(R.id.ll_order_list_item);
             
            convertView.setTag(holder);
        }
        
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
 
      
        
        holder.tv_RAF_NO .setText(Html.fromHtml("<p><u>"+arr_order.get(position).getRAF_NO()+"</u></p>"));
        holder.tv_OrderType .setText(arr_order.get(position).getOrder_type());
        holder.tv_SimType .setText(arr_order.get(position).getSim_type());
        holder.tv_Location .setText(arr_order.get(position).getLocation());
        holder.tv_Time .setText(arr_order.get(position).getTime());
      //  holder.cities.setText(rowItems.get(position).getArea());
        if(position%2==0)
        {
        	holder.ll_order_list_item.setBackgroundColor(Color.WHITE);
        }
        else
        {
        	holder.ll_order_list_item.setBackgroundColor(0XECECEC);
        }
        
        holder.tv_RAF_NO.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(position<2)
				{
					Intent intent = new Intent(context,OrderIncompleteActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(intent);
			
			 
			
				}
			 
				else{
					Intent intent = new Intent(context,OrderDetailPullBackActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(intent);
			
					
				}
			    
				
				
			}
		});

        

        return convertView;
    }
    
   
	@Override
    public int getCount() 
	{    
        return arr_order.size();
    }
	
    @Override
    public Object getItem(int position)
    {
        return arr_order.get(position);
    }
    
    @Override
    public long getItemId(int position) 
    {
        return arr_order.indexOf(getItem(position));
    }

	

}
