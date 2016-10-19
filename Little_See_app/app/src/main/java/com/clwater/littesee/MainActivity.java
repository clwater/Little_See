package com.clwater.littesee;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.clwater.littesee.Activity.AboutActivity;
import com.clwater.littesee.Activity.BaseActivity;
import com.clwater.littesee.Fragment.HaoQiXinFragment;
import com.clwater.littesee.Fragment.ImageFragment;
import com.clwater.littesee.Fragment.WangyiFragment;
import com.clwater.littesee.Fragment.ZhiHuFragment;
import com.clwater.littesee.Utils.Analysis.ZhiHuAnalysis;
import com.clwater.littesee.Utils.DBHelper.ZhiHu;
import com.clwater.littesee.Utils.DBHelper.ZhiHuDaoOrm;
import com.j256.ormlite.table.TableUtils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {


    @InjectView(R.id.ma_layout)
    public DrawerLayout drawerLayout;
    @InjectView(R.id.ma_nv)
    public NavigationView navigationView;
    @InjectView(R.id.mv_toolbar)
    public Toolbar toolbar;


    private WangyiFragment _wangyi;
    private ZhiHuFragment _zhihu;
    private ImageFragment _image;
    private HaoQiXinFragment _haoqixin;

    public static Context context;


    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


        initNavigationView();
        setDefaultFragment();


        context = this;
        
        //testSql();
        testDom();

    }

    private void testDom() {
        String text = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<beauties>\n" +
                "    <beauty>\n" +
                "        <name>11111</name>\n" +
                "        <age>28</age>\n" +
                "    </beauty>\n" +
                "    <beauty>\n" +
                "        <name>22222</name>\n" +
                "        <age>23</age>\n" +
                "    </beauty>\n" +
                "\n" +
                "</beauties>";
        InputStream inputStream = new ByteArrayInputStream(text.getBytes());


        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            // 获取根节点
            Element root = document.getDocumentElement();

            parse(root);

            for (Beauty b : beautyList) {
                result += b.toString();
            }

            Log.d("gzb" , "" + result);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Beauty beauty = null;
    private ArrayList<Beauty> beautyList = new ArrayList<Beauty>();

    /**
     *
     * @param element 将要进行遍历的节点
     */
    private void parse(Element element) {
        NodeList nodelist = element.getChildNodes();
        int size = nodelist.getLength();
        for (int i = 0; i < size; i++) {
            // 获取特定位置的node
            Node element2 = (Node) nodelist.item(i);
            /* getNodeName获取tagName，例如<book>thinking in android</book>这个Element的getNodeName返回book
             * getNodeType返回当前节点的确切类型，如Element、Attr、Text等
             * getNodeValue 返回节点内容，如果当前为Text节点，则返回文本内容；否则会返回null
             * getTextContent 返回当前节点以及其子代节点的文本字符串，这些字符串会拼成一个字符串给用户返回。例如
             * 对<book><name>thinking in android</name><price>12.23</price></book>调用此方法，则会返回“thinking in android12.23”
             */
            String tagName = element2.getNodeName();
            if (tagName.equals("beauty")
                    && element2.getNodeType() == Document.ELEMENT_NODE) {
                beauty = new Beauty();
                Log.i("通知：", "创建beauty");
                if (element2.getNodeType() == Document.ELEMENT_NODE) {
                    parse((Element) element2);
                }
                Log.i("通知：", "添加beauty");
                beautyList.add(beauty);

            }

            if (tagName.equals("name")) {
                String name = element2.getTextContent();
                Log.i("通知：", "name" + name);
                beauty.setName(name);

            }
            if (tagName.equals("age")) {
                String age = element2.getTextContent();
                Log.i("通知：", "age" + age);
                beauty.setAge(age);

            }

        }

    }

    /**
     *
     * @author chenzheng_java 这里使用内部类是为了效率考虑，内部类要比单独顶一个bean类更加的高效以及节约空间
     *
     */
    private class Beauty {
        String name;
        String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "资料 [年龄=" + age + ", 姓名=" + name + "]";
        }

    }


    private void testSql() {
        ZhiHuAnalysis.Analysis(context);

    }


    private void setDefaultFragment() {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        //_zhihu = new ZhiHuFragment();
        //_image = new ImageFragment();
        _haoqixin = new HaoQiXinFragment();
        transaction.replace(R.id.id_content, _haoqixin);
        transaction.commit();

    }


    private void initNavigationView() {
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_nv);
        ab.setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(navigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        switch (item.getItemId()) {
            case R.id.nav_zhihu:
                toolbar.setTitle("知乎");
                if (_zhihu == null){
                    _zhihu = new ZhiHuFragment();
                }
                transaction.replace(R.id.id_content, _zhihu);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_wangyi:
                toolbar.setTitle("网易");
                if (_wangyi == null){
                    _wangyi = new WangyiFragment();
                }
                transaction.replace(R.id.id_content, _wangyi);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_image:
                toolbar.setTitle("图片");
                if (_image == null){
                    _image = new ImageFragment();
                }
                transaction.replace(R.id.id_content, _image);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_haoqixin:
                toolbar.setTitle("haoqixin");
                if (_haoqixin == null){
                    _haoqixin = new HaoQiXinFragment();
                }
                transaction.replace(R.id.id_content, _haoqixin);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_about:
                drawerLayout.closeDrawers();
                startActivity(new Intent(this , AboutActivity.class));
                break;
        }

        return true;
    }


    private void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener()
                {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem)
                    {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.actionbar_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.action_bar_about:
                startActivity(new Intent(this , AboutActivity.class));
                return true;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true ;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}


