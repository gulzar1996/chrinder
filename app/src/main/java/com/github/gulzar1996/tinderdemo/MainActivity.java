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
        for (int i=0;i<50; i++){
        mUser.add(new User("Not Emilia Clarke","24","Hunting","https://timedotcom.files.wordpress.com/2017/06/emilia-clarke-quiz.jpg"));
        mUser.add(new User("Vicky Donor","21","Sleeping","https://pbs.twimg.com/media/C3pLaVuUkAAw87n.jpg"));
        mUser.add(new User("Katy Perry","28","Singing","https://media.vanityfair.com/photos/58c815f89a1bb337a29dbe43/master/w_768,c_limit/Katy-Perry-Rainbow-Hair-SS-16.jpg"));
        mUser.add(new User("Shradha","21","Actor","https://s-media-cache-ak0.pinimg.com/736x/2c/da/47/2cda4706ab1bd42c46962cd3cfc27356.jpg"));}

    }

    public void rightSwipe(View view) {
        View target = mCardStack.getTopView();
        ValueAnimator rotation = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("rotation", 10f));
        rotation.setDuration(200);
        ValueAnimator translateX = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("translationX", 0f, 2000f));
        ValueAnimator translateY = ObjectAnimator.ofPropertyValuesHolder(
                target, PropertyValuesHolder.ofFloat("translationY", 0f, -500f));
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
                target, PropertyValuesHolder.ofFloat("translationY", 0f, -500f));
        translateX.setStartDelay(100);
        translateY.setStartDelay(100);
        translateX.setDuration(500);
        translateY.setDuration(500);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(rotation, translateX, translateY);
        mCardStack.swipe(SwipeDirection.Left,set);
    }
}
