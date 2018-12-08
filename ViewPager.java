
////////////////////////////////////////////
public class MyFragment extends Fragment {
	public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	
	public static final MyFragment newInstance(String message)
	{
		MyFragment f = new MyFragment();
		Bundle bdl = new Bundle(1);
	    bdl.putString(EXTRA_MESSAGE, message);
	    f.setArguments(bdl);
	    return f;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
		String message = getArguments().getString(EXTRA_MESSAGE);
		View v = inflater.inflate(R.layout.myfragment_layout, container, false);
		TextView messageTextView = (TextView)v.findViewById(R.id.textView);
		messageTextView.setText(message);
		
        return v;
    }
	
}
/////////////////////////////////////////////////////////////////
public class PageViewActivity extends FragmentActivity {
	MyPageAdapter pageAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_view);
        
        List<Fragment> fragments = getFragments();
        
        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
        
        ViewPager pager = (ViewPager)findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);
        
    }
    
    private List<Fragment> getFragments(){
    	List<Fragment> fList = new ArrayList<Fragment>();
    	
    	fList.add(MyFragment.newInstance("Fragment 1"));
    	fList.add(MyFragment.newInstance("Fragment 2"));
    	fList.add(MyFragment.newInstance("Fragment 3"));
    	
    	return fList;
    }

    private class MyPageAdapter extends FragmentPagerAdapter {
    	private List<Fragment> fragments;

        public MyPageAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }
     
        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }
}
