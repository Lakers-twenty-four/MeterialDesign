package com.example.administrator.section12_toolbar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private FloatingActionButton fad;
    private RecyclerView recycler_view;
    private List<Eddie> mlist=new ArrayList<Eddie>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addData();
    }

    private void addData() {
        Eddie ed1=new Eddie("eddie1",R.drawable.ed1);mlist.add(ed1);
        Eddie ed2=new Eddie("eddie2",R.drawable.ed2);mlist.add(ed2);
        Eddie ed3=new Eddie("eddie3",R.drawable.ed3);mlist.add(ed3);
        Eddie ed4=new Eddie("eddie4",R.drawable.ed4);mlist.add(ed4);
        Eddie ed5=new Eddie("eddie5",R.drawable.ed5);mlist.add(ed5);
        Eddie ed6=new Eddie("eddie6",R.drawable.ed6);mlist.add(ed6);
        Eddie ed7=new Eddie("eddie7",R.drawable.ed7);mlist.add(ed7);
        Eddie ed8=new Eddie("eddie8",R.drawable.ed8);mlist.add(ed8);
        Eddie ed9=new Eddie("eddie9",R.drawable.ed9);mlist.add(ed9);
        Eddie ed10=new Eddie("eddie10",R.drawable.ed10);mlist.add(ed10);
        Eddie ed11=new Eddie("eddie7",R.drawable.ed11);mlist.add(ed11);
        Eddie ed12=new Eddie("eddie8",R.drawable.ed12);mlist.add(ed12);
        Eddie ed13=new Eddie("eddie9",R.drawable.ed13);mlist.add(ed13);
        Eddie ed14=new Eddie("eddie10",R.drawable.ed14);mlist.add(ed14);
        Eddie ed15=new Eddie("eddie10",R.drawable.ed15);mlist.add(ed15);
    }

    private void initView() {
        // 【1】findViewById()得到ToolBar的实例
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        //【2】然后调用setSupportActionBar()方法将ToolBar的实例传入
        setSupportActionBar(toolbar);

        //【5】调用findViewById()方法得到了DrawerLayout的实例
        mDrawerLayout= (DrawerLayout) findViewById(R.id.draw_layout);
        //调用getSupportActionBar()方法得到了ActionBar的实例，虽然这个ActionBar
        //的具体实现是由ToolBar来完成。
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            //接着调用 actionBar.setDefaultDisplayHomeAsUpEnabled(true);让导航按钮显示出来
            actionBar.setDisplayHomeAsUpEnabled(true);
            //又调用actionBar.setHomeAsUpIndicator(R.drawable.ic_action_document);来设置一个导航图标
            actionBar.setHomeAsUpIndicator(R.drawable.ic_action_document);
        }

        //【6】findViewById()得到RecyclerView的实例
        recycler_view= (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recycler_view.setLayoutManager(layoutManager);
        EdAdapter mAdapter = new EdAdapter(mlist);
        recycler_view.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       /* 【3】通过getMenuInflater()方法能够得到MenuInflater对象，
        再调用它的inflate()方法，就可以给当前活动创建菜单了*/
        getMenuInflater().inflate(R.menu.toolbar,menu);
        //然后给这个方法返回true,表示允许创建的菜单显示出来
        return true;
    }

    /*【4】onOptionsItemSelected()方法中，通过调用item.getItemId()来判断我们点击的是哪一个菜单项
    ，然后给每个菜单项加入自己的逻辑处理，*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(getApplicationContext(),"You click Backup",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(getApplicationContext(),"You click delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(getApplicationContext(),"You click settings",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
    //设置FloatingActionButton的点击事件
    public void FloatingActionButton(View v){
        //Toast.makeText(getApplication(),"FAB",Toast.LENGTH_SHORT).show();
        Snackbar.make(v,"删除数据",Snackbar.LENGTH_LONG).
                setAction("确定", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(),"删除成功",Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}
