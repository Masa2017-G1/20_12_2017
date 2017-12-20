package com.sheygam.masa_2017_20_12;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private ViewPager pager;
    private MyPersonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        pager = findViewById(R.id.my_pager);
        adapter = new MyPersonAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.second_activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.add_item){
            Random rnd = new Random();
            Person person = new Person("Person " + rnd.nextInt(1000),"person@mail.com","00000000000");
            adapter.addPerson(person);
        }
        return super.onOptionsItemSelected(item);
    }

    class MyPersonAdapter extends FragmentStatePagerAdapter {
        private ArrayList<Person> persons;
        public MyPersonAdapter(FragmentManager fm) {
            super(fm);
            persons = new ArrayList<>();
        }

        public void addPerson(Person person){
            persons.add(person);
            notifyDataSetChanged();
        }
        @Override
        public Fragment getItem(int position) {
            Person p = persons.get(position);
            PersonFragment fragment = PersonFragment.newInstance(p);
            return fragment;
        }

        @Override
        public int getCount() {
            return persons.size();
        }
    }
}
