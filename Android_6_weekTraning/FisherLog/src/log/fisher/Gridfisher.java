package log.fisher;
import log.fisher.R;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Gridfisher extends Activity{
	
	Integer[] imageid={R.drawable.c,R.drawable.e,R.drawable.tr,R.drawable.del,R.drawable.ct,R.drawable.pic,R.drawable.e,R.drawable.zip,R.drawable.plott};
	GridView gv;
	TextView tv;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridfisher);
		tv=(TextView) findViewById(R.id.textView1);
		tv.setTextColor(Color.parseColor("#FF8080"));
		gv=(GridView) findViewById(R.id.gridfish);
		gv.setAdapter(new Imageadapter(this));
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int a,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getBaseContext(), "pic"+(a+1)+"Selected",Toast.LENGTH_LONG ).show();
				switch (a) {
				case 0:
					Intent fi=new Intent(Gridfisher.this,Fisherr.class);
					startActivity(fi);
					break;
				case 4:
					Intent ct=new Intent(Gridfisher.this,Catches.class);
					startActivity(ct);
					break;
				default:
					break;
				}
			}
			
		});
	}
	public class Imageadapter extends BaseAdapter{
		private Context context;
		public Imageadapter(Context c) {
			// TODO Auto-generated constructor stub
			context =c;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imageid.length;
		}

		@Override
		public Object getItem(int a) {
			// TODO Auto-generated method stub
			return a;
		}

		@Override
		public long getItemId(int a) {
			// TODO Auto-generated method stub
			return a;
		}

		@Override
		public View getView(int p, View con, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imageview;
			if(con==null){
				imageview=new ImageView(context);
				imageview.setLayoutParams(new GridView.LayoutParams(85,85));
				imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
				/*imageview.setPadding(10,10,10,10);*/
			}else{
				imageview=(ImageView)con;
			}
			imageview.setImageResource(imageid[p]);
			return imageview;
		}
	
	}
}
