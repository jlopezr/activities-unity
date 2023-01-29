using System;
using UnityEngine;
using UnityEngine.Windows;

public class Android
{
    public static string GetStringExtra(string key)
    {
#if UNITY_ANDROID
        AndroidJavaClass UnityPlayer = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
        AndroidJavaObject currentActivity = UnityPlayer.GetStatic<AndroidJavaObject>("currentActivity");

        AndroidJavaObject intent = currentActivity.Call<AndroidJavaObject>("getIntent");
        String value = intent.Call<String>("getStringExtra", key);

        return value;
#else
        return null;
#endif
    }

    public static int Add(int a, int b)
    {
        AndroidJavaClass javacode = new AndroidJavaClass("JavaCode");
        object[] args = { 1, 2 };
        int result = javacode.CallStatic<int>("add", args);
        Debug.Log("Resultado: " + result);
        return result;
    }

    public static void SetResultAndFinish(String result)
    {
        AndroidJavaClass javacode = new AndroidJavaClass("JavaCode");
        object[] args = { result };
        javacode.CallStatic("setResultAndFinish", args);
    }

    public static void LaunchActivity(String pkg, String activity, String input)
    {
        AndroidJavaClass javacode = new AndroidJavaClass("JavaCode");
        object[] args = { pkg, activity, input };
        javacode.CallStatic("launchActivity", args);
    }

    public static void LaunchActivityForResult(String pkg, String activity, String input)
    {
        AndroidJavaClass javacode = new AndroidJavaClass("JavaCode");
        object[] args = { pkg, activity, input };
        javacode.CallStatic("launchActivityForResult", args);
    }


}