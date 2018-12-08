//////////////////////////Scrolling Activity Behavior
@CoordinatorLayout.DefaultBehavior(
    FloatingActionButton.Behavior.class)
public class FloatingActionButton extends ImageButton {
    ...
    public static class Behavior 
        extends CoordinatorLayout.Behavior<FloatingActionButton> {
        private boolean updateFabVisibility(
           CoordinatorLayout parent, AppBarLayout appBarLayout, 
           FloatingActionButton child {
           if (a long condition) {
                // If the anchor's bottom is below the seam, 
                // we'll animate our FAB out
                child.hide();
            } else {
                // Else, we'll animate our FAB back in
                child.show();
            }
        }
    }
    ...
}


/////////////SwipeDismissBehavior

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_swipe_behavior);
    mCardView = (CardView) findViewById(R.id.swype_card);
    final SwipeDismissBehavior<CardView> swipe 
        = new SwipeDismissBehavior();
        swipe.setSwipeDirection(
            SwipeDismissBehavior.SWIPE_DIRECTION_ANY);
        swipe.setListener(
            new SwipeDismissBehavior.OnDismissListener() {
            @Override public void onDismiss(View view) {
                Toast.makeText(SwipeBehaviorExampleActivity.this,
                    "Card swiped !!", Toast.LENGTH_SHORT).show();
            }
            @Override 
            public void onDragStateChanged(int state) {}
        });
        LayoutParams coordinatorParams = 
            (LayoutParams) mCardView.getLayoutParams();
        coordinatorParams.setBehavior(swipe);
    }
