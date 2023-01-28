package dsa.app1;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AuxiliarActivity extends Activity {

    public String input;
    public String input2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Launch Activity
        Intent i = new Intent();
        i.setComponent(new ComponentName("dsa.app2", "dsa.app2.Activity3"));
        i.putExtra("input", "XXX XXX XXX");        
        startActivityForResult(i, 1); // Hardwired request code
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) { // Hardwired request code
            input2 = data.getStringExtra("input2");
            Log.d("JUAN", "input2="+input2);
        }
    }
}