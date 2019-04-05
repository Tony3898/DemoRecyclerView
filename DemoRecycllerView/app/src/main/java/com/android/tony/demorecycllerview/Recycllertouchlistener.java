package com.android.tony.demorecycllerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

public class Recycllertouchlistener implements RecyclerView.OnItemTouchListener {

    private GestureDetector gestureDetector;
    private ClickListener clickListener;

    public interface ClickListener
    {
        void OnClick(View v,int Position);
        void OnLongClick(View v,int Position);
    }

    Recycllertouchlistener(Context context, final RecyclerView recyclerView,final ClickListener clickListener)
    {
        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(),e.getY());
                if(child!=null && clickListener!= null)
                    clickListener.OnLongClick(child,recyclerView.getChildPosition(child));
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }
        });


    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());
        if(child!=null && clickListener!= null && gestureDetector.onTouchEvent(motionEvent))
            clickListener.OnClick(child,recyclerView.getChildPosition(child));
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }
}
