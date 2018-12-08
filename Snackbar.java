


Snackbar snackbar = Snackbar.make(myCoordinatorLayout, "Message is deleted", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                               //perform an action on action buton pressed
                            }
                        });
snackbar.show();

