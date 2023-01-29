using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Buttons : MonoBehaviour
{

    public int count = 0;
    public Text txt;

    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void OnClick()
    {
        count += 1;
        txt.text = "Pressed " + count + " times";
    }

    public void OnClick2()
    {
        txt.text = "Launching dsa.app2.Activity3";        
        Android.LaunchActivity("dsa.app2", "dsa.app2.Activity3", "This cames from Unity");
    }

    public void OnClick3()
    {
        Android.SetResultAndFinish("Unity exited!");
    }

    public void OnClick4()
    {
        txt.text = "Launching dsa.app2.Activity3 for result!";        
        Android.LaunchActivityForResult("dsa.app2", "dsa.app2.Activity3", "This cames from Unity");
    }

    public void OnActivityResult(String result)
    {
        if(result!=null)
        {
            txt.text = result;
        }
    }

}