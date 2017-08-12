package android.com.expandablelistview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dexter John Datul on 11/08/2017.
 */

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    String[] groupNames = {"Sport", "Computer", "Food", "Car", "TV"};
    String[][] childNames = {{"Boxing", "Kick Boxing", "Judo", "FootBall",}, {"Desktop", "Laptop", "SmartPhone",},
            {"Ice Cream", "Crepes", "Cake",}, {"GMC", "BNY", "BMW",}, {"Samsung", "Toshiba", "SUZUKI",}};

    Context context;

    public ExpandableListViewAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getGroupCount() {
        return groupNames.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childNames[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupNames[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childNames[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        TextView txtView = new TextView(context);
        txtView.setText(groupNames[groupPosition]);
        txtView.setPadding(100, 0, 0, 0);
        txtView.setTextColor(Color.GREEN);
        txtView.setTextSize(50);
        return txtView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {

        final TextView txtView = new TextView(context);
        txtView.setText(childNames[groupPosition][childPosition]);
        txtView.setPadding(100, 0, 0, 0);
        txtView.setTextSize(35);
        txtView.setTextColor(Color.BLUE);

        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, txtView.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

        return txtView;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
