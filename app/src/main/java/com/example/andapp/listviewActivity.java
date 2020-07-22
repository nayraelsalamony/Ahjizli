package com.example.andapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
public class listviewActivity extends BaseAdapter {
    Context context;
    ArrayList<String> namelist=new ArrayList<String>();
    ArrayList<String> addresslist=new ArrayList<String>();
    Integer photo;
    int listitem;
    listviewActivity(Context context,int listitem,Integer photo,ArrayList<String> namelist,ArrayList<String> addresslist){
      this.context=context;
      this.listitem=listitem;
      this.photo = photo;
      this.namelist=namelist;
      this.addresslist=addresslist;

    }
    @Override
    public int getCount() {
        return namelist.size();
    }

    @Override
    public Object getItem(int position) {
        return namelist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(listitem,parent,false);
        }
        ImageView imageView =convertView.findViewById(R.id.photo);
        imageView.setImageResource(photo);
        TextView textView1=convertView.findViewById(R.id.thename);
        textView1.setText(namelist.get(position));
        TextView textView2=convertView.findViewById(R.id.theaddress);
        textView2.setText(addresslist.get(position));
        return convertView;
    }

}
