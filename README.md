# ui
Android 实验三


实验主页面：

![](https://raw.githubusercontent.com/huangzichun666/ui/master/image/one.png)


列表布局实验截图：


![](https://raw.githubusercontent.com/huangzichun666/ui/master/image/two.png)


弹窗实验截图：

![](https://raw.githubusercontent.com/huangzichun666/ui/master/image/three.png)


菜单实验截图：


![](https://raw.githubusercontent.com/huangzichun666/ui/master/image/five.png)


![](https://raw.githubusercontent.com/huangzichun666/ui/master/image/six.png)


ActionBar实验截图：

![](https://raw.githubusercontent.com/huangzichun666/ui/master/image/four.png)



列表布局实验列表适配器代码：

public class ListAdapter extends BaseAdapter {

    public int selectedPosition=0;
    private Context mContext;
    private LayoutInflater inflater;
    private ListEntity entity;
    private List<ListEntity> entities;

    public ListAdapter(Context mContext, List<ListEntity> entities) {
        this.mContext=mContext;
        this.entities=entities;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return entities.size();
    }

    @Override
    public Object getItem(int position) {
        return entities.get(position);
    }

    @Override
    public long getItemId(int position) {
        selectedPosition=position;
        return selectedPosition;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listview_item, null);
            viewHolder.textView=convertView.findViewById(R.id.text);
            viewHolder.imageView = convertView.findViewById(R.id.image);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        entity = entities.get(position);
        viewHolder.textView.setText(entity.getText());
        viewHolder.imageView.setImageResource(entity.getImage());

        return  convertView;
    }

    class ViewHolder{
        private TextView textView;
        private ImageView imageView;
    }
}

弹窗创建代码：

public class Dialog extends AppCompatActivity {

    private Button button;
    private View altertDialogView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_activity);
        init();
    }

    public void init(){
        button = findViewById(R.id.button);
        altertDialogView = getLayoutInflater().inflate(R.layout.dialog_item,null);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder loginAltertDialog = new AlertDialog.Builder(Dialog.this);
                loginAltertDialog.setView (altertDialogView);
                loginAltertDialog.show();
            }
        });
    }
}


菜单注册代码：

<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context="com.jiapeng.munedemo.MainActivity" >

    <item
        android:id="@+id/mune_size"
        android:orderInCategory="100"
        android:title="字体大小"
        app:showAsAction="never">
        <menu>
            <item
                android:id="@+id/mune_size_big"
                android:orderInCategory="100"
                android:title="大号字体"
                app:showAsAction="never"/>

            <item
                android:id="@+id/mune_size_zhong"
                android:orderInCategory="100"
                android:title="中号字体"
                app:showAsAction="never"/>

            <item
                android:id="@+id/mune_size_small"
                android:orderInCategory="100"
                android:title="小号字体"
                app:showAsAction="never"/>

        </menu>
    </item>
    <item
        android:id="@+id/mune_setting"
        android:orderInCategory="100"
        android:title="普通菜单选项"
        app:showAsAction="never"/>

    <item
        android:id="@+id/mune_color"
        android:orderInCategory="100"
        android:title="字体颜色"
        app:showAsAction="never">

        <menu>
            <item
                android:id="@+id/mune_size_red"
                android:orderInCategory="100"
                android:title="字体变红"
                app:showAsAction="never"/>

            <item
                android:id="@+id/mune_size_balke"
                android:orderInCategory="100"
                android:title="字体变黑"
                app:showAsAction="never"/>


        </menu>
    </item>
</menu>

菜单创建代码：

public class MenuActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        init();
    }

    private void init(){
        textView = findViewById(R.id.text);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        //导入菜单布局
        getMenuInflater().inflate(R.menu.two, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //创建菜单项的点击事件
        switch (item.getItemId()) {
            case R.id.mune_size:
                break;
            case R.id.mune_setting:
                Toast.makeText(this, "点击了普通选项", Toast.LENGTH_SHORT).show();break;
            case R.id.mune_color:
                break;
            case R.id.mune_size_big:
                textView.setTextSize(20);break;
            case R.id.mune_size_zhong:
                textView.setTextSize(16);break;
            case R.id.mune_size_small:
                textView.setTextSize(10);break;
            case R.id.mune_size_red:
                textView.setTextColor(getResources().getColor(R.color.red));break;
            case R.id.mune_size_balke:
                textView.setTextColor(getResources().getColor(R.color.blake));break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

ActionBar 重要代码：

 class ModeCallback implements AbsListView.MultiChoiceModeListener {

        View actionBarView;
        TextView selectedNum;

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            // TODO Auto-generated method stub
            return true;
        }

        //退出多选模式时调用
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // TODO Auto-generated method stub
            listView.clearChoices();
        }

        //进入多选模式调用，初始化ActionBar的菜单和布局
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // TODO Auto-generated method stub
            getMenuInflater().inflate(R.menu.multiple_mode_menu, menu);
            if(actionBarView == null) {
                actionBarView = LayoutInflater.from(ActionListActivity.this).inflate(R.layout.actionbar_view, null);
                selectedNum = (TextView)actionBarView.findViewById(R.id.selected_num);
            }
            mode.setCustomView(actionBarView);
            return true;
        }

        //ActionBar上的菜单项被点击时调用
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            // TODO Auto-generated method stub
            return true;
        }

        //列表项的选中状态被改变时调用
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position,
                                              long id, boolean checked) {
            // TODO Auto-generated method stub
            updateSelectedCount();
            mode.invalidate();
            adapter.notifyDataSetChanged();
        }

        public void updateSelectedCount() {
            int selectedCount = listView.getCheckedItemCount();
            selectedNum.setText(selectedCount + "");
        }
    }





