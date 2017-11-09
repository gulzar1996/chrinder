package com.github.gulzar1996.tinderdemo;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.SwipeDirection;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CardStackView mCardStack;
    TinderAdapter adapter;
    List<User> mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCardStack =findViewById(R.id.cardstack);
        setUpUser();
        setUpAdapter();
    }

    private void setUpAdapter() {
        adapter =new TinderAdapter(this,0);
        adapter.addAll(mUser);
        mCardStack.setAdapter(adapter);
    }

    private void setUpUser() {
        mUser = new ArrayList<>();
        mUser.add(new User("","21","Sleeping","http://images.indianexpress.com/2017/09/117.jpg?w=610"));
        mUser.add(new User("Ankita Azad","21","Sleeping","http://photogallery.indiatimes.com/photo/59472687.cms"));
        mUser.add(new User("Ankita Azad","21","Sleeping","http://images.indianexpress.com/2017/09/117.jpg?w=610"));
        mUser.add(new User("Ankita Azad","21","Sleeping","http://images.indianexpress.com/2017/09/117.jpg?w=610"));
    }

    public void rightSwipe(View view) {
        View target = mCardStack.getTopView();
        ValueAnimator rotation = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("rotation", 10f));
        rotation.setDuration(200);
        ValueAnimator translateX = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("translationX", 0f, 2000f));
        ValueAnimator translateY = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("translationY", 0f, 500f));
        translateX.setStartDelay(100);
        translateY.setStartDelay(100);
        translateX.setDuration(500);
        translateY.setDuration(500);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(rotation, translateX, translateY);
        mCardStack.swipe(SwipeDirection.Right,set);
    }

    public void leftSwipe(View view) {
        View target = mCardStack.getTopView();
        ValueAnimator rotation = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("rotation", -10f));
        rotation.setDuration(200);
        ValueAnimator translateX = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("translationX", 0f, -2000f));
        ValueAnimator translateY = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("translationY", 0f, 500f));
        translateX.setStartDelay(100);
        translateY.setStartDelay(100);
        translateX.setDuration(500);
        translateY.setDuration(500);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(rotation, translateX, translateY);
        mCardStack.swipe(SwipeDirection.Left,set);
    }
}
