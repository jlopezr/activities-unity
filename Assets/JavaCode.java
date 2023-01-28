import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.unity3d.player.UnityPlayer;

public class JavaCode {
    public static int add(int a, int b) {
        return a+b;
    }

    public static void setResultAndFinish(String result) {
        Intent resultIntent = new Intent();        
        resultIntent.putExtra("input2", result);
        Activity a = UnityPlayer.currentActivity;
        a.setResult(Activity.RESULT_OK, resultIntent);
        a.finish();
    }

    public static void launchActivity(String pkg, String activity, String data) {
        Intent i = new Intent();
        i.setComponent(new ComponentName(pkg, activity));
        if(data!=null) {
            i.putExtra("input",data);
        }        
        UnityPlayer.currentActivity.startActivity(i);
    }

    public static String launchActivityAndGetResult(String pkg, String activity, String data) {
        Intent i = new Intent();
        i.setComponent(new ComponentName(pkg, activity));
        if(data!=null) {
            i.putExtra("input",data);
        }        
        UnityPlayer.currentActivity.startActivityForResult(i, 1); // Request code is hardwired to 1


        return null;
    }
}
