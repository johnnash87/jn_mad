package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";

	// Lifecycle counters

	// TODO:
	int mCreate =0;
	int mRestart = 0;
	int mStart = 0;
	int mResume = 0;
	// Create variables named
	// mCreate, mRestart, mStart and mResume
	// to count calls to onCreate(), onRestart(), onStart() and
	// onResume(). These variables should not be defined as static.

	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called.

	// TODO: Create variables for each of the TextViews
	TextView mTvCreate = null;
	TextView mTvRestart = null;
	TextView mTvStart = null;
	TextView mTvResume = null;
	// named mTvCreate, mTvRestart, mTvStart, mTvResume.
	// for displaying the current count of each counter variable

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);

		mTvCreate = (TextView) findViewById(R.id.create);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvResume = (TextView) findViewById(R.id.resume);
		mTvStart = (TextView) findViewById(R.id.start);

		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);

		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO:
				// Launch Activity Two
				// Hint: use Context's startActivity() method

				Intent intent = new Intent (ActivityOne.this,ActivityTwo.class);
				startActivity(intent);


				// Create an intent stating which Activity you would like to
				// start
				//Intent intent = null;

				// Launch the Activity using the intent

			}
		});

		// Has previous state been saved?
		if (savedInstanceState != null) {

			// TODO:

            mCreate = savedInstanceState.getInt(CREATE_KEY);
			mRestart = savedInstanceState.getInt(RESTART_KEY);
			mResume = savedInstanceState.getInt(RESUME_KEY);
			mStart = savedInstanceState.getInt(START_KEY);

			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable

		}

		// Emit LogCat message
		Log.i(TAG, "Entered the onCreate() method");

		// TODO:
		mCreate++;
		displayCounts();
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method

	}

	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStart() method");

		// TODO:
		mStart++;
		displayCounts();
		// Update the appropriate count variable
		// Update the user interface

	}

	@Override
	public void onResume() {
		super.onResume();

		// Emit LogCat message
		Log.i(TAG, "Entered the onResume() method");

		// TODO:
		mResume++;
		displayCounts();
		// Update the appropriate count variable
		// Update the user interface

	}

	@Override
	public void onPause() {
		super.onPause();

		// Emit LogCat message
		Log.i(TAG, "Entered the onPause() method");
	}

	@Override
	public void onStop() {
		super.onStop();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onRestart() method");

		// TODO:
		mRestart++;
		displayCounts();
		// Update the appropriate count variable
		// Update the user interface

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// Emit LogCat message
		Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// TODO:

		savedInstanceState.putInt(CREATE_KEY,mCreate);
		savedInstanceState.putInt(RESTART_KEY,mRestart);
		savedInstanceState.putInt(RESUME_KEY,mResume);
		savedInstanceState.putInt(START_KEY,mStart);
		super.onSaveInstanceState(savedInstanceState);
		// Save state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable

	}

	// Updates the displayed counters
	// This method expects that the counters and TextView variables use the
	// names
	// specified above
	public void displayCounts() {

		// TODO - uncomment these lines

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);

	}
}
