package com.mandeep.employeetracking.adapters;




import com.mandeep.employeetracking.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class spinnerAreaAdapter extends BaseAdapter {

	Context context;
	private final String[] cities_name;
    
   
    public spinnerAreaAdapter(Context context, String[] cities_name) {
        this.context = context;
        this.cities_name = cities_name;
    }
    
    
    private class ViewHolder
    {
        private TextView cities;
        
       
    }
    
    
    @Override
	public View getView(final int position, View convertView, ViewGroup parent)
    {
        final ViewHolder holder;
        
        LayoutInflater mInflater = (LayoutInflater)
        		
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.spinner_item, null);
            
            holder = new ViewHolder();
            
            holder.cities =(TextView)convertView.findViewById(R.id.tv_cities);
             
            convertView.setTag(holder);
        }
        
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
 
      
        
        holder.cities .setText(cities_name[position]);
      
        if(position==0)
        {
        	holder.cities.setTextColor(Color.parseColor("#4F4F4F"));
        }
        
        //  holder.cities.setText(rowItems.get(position).getArea());
        
        
        

        return convertView;
    }
    


	@Override
    public int getCount() 
	{    
        return cities_name.length;
    }
	
    @Override
    public Object getItem(int position)
    {
        return cities_name.length;
    }
    
    @Override
    public long getItemId(int position) 
    {
        return cities_name.length;
    }


}
