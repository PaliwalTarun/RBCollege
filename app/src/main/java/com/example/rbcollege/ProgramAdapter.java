//package com.example.rbcollege;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//public class ProgramAdapter extends ArrayAdapter<String> {
//
//    Context context;
//    int[] id;
//    String[] facultyName,subjectName,contentDelivered,noOfStudent,date;
//
//    public ProgramAdapter(@NonNull Context context, int[] id,String[] facultyName,String[] subjectName,String[] contentDeliverd, String[] noOfStudent,String[] date) {
//        super(context, R.layout.single_list);
//        this.context = context;
//        this.facultyName = facultyName;
//        this.subjectName = subjectName;
//        this.contentDelivered = contentDelivered;
//        this.noOfStudent = noOfStudent;
//        this.date = date;
//
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View singleData = convertView;
//        DataView viewHolder =  null;
//
//        if(singleData == null)
//        {
//            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            singleData = layoutInflater.inflate(R.layout.single_list,parent,false);
//            viewHolder = new DataView(singleData);
//            singleData.setTag(viewHolder);
//        }
//        else {
//            viewHolder = (DataView) singleData.getTag();
//        }
//        viewHolder.facultyName.setText(facultyName[position]);
//        viewHolder.sujectName.setText(subjectName[position]);
//        viewHolder.contentDeliverd.setText(contentDelivered[position]);
//        viewHolder.noOfStudent.setText(noOfStudent[position]);
//        viewHolder.date.setText(date[position]);
//
////        singleData.se
//        return singleData;
//    }
//}
