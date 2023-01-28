using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class Startup : MonoBehaviour
{

	public Text txt;

	// Use this for initialization
	void Start()
	{
        string input = Android.GetStringExtra("input");
		if(input!=null)
		{
			txt.text = input;
			Debug.Log(input);
		} else
		{
            txt.text = "No input extra";
            Debug.Log("No input extra");
        }
    }

    // Update is called once per frame
    void Update()
	{
			
	}
}

