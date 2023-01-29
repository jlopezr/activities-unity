package com.company.product;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class OverrideExample extends UnityPlayerActivity {

  protected void onCreate(Bundle savedInstanceState) {    
    super.onCreate(savedInstanceState);    
    Log.d("OverrideActivity", "onCreate called!");
  }

  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    Log.d("OverrideActivity", "onActivityResult called!");

    Log.d("OverrideActivity", "requestCode: "+requestCode);
    Log.d("OverrideActivity", "resultCode: "+resultCode);
    Log.d("OverrideActivity", "data: "+data);

    if (requestCode == 1 && resultCode == RESULT_OK && data != null) { // Hardwired request code
      String input2 = data.getStringExtra("input2");
      Log.d("OverrideActivity", "Result from Activity is: "+input2);
      UnityPlayer.UnitySendMessage("Count Button", "OnActivityResult", input2);
    } else {
      Log.d("OverrideActivity", "Activity result received but not correct!");
    }    
  }
}