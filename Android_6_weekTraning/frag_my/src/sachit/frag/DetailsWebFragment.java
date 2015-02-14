package sachit.frag;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewFragment;

public class DetailsWebFragment extends WebViewFragment{
	public DetailsWebFragment() {}
	WebView mWebView = getWebView();
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	super.onActivityCreated(savedInstanceState);
	mWebView = getWebView();
	WebSettings webSettings = mWebView.getSettings();
	//webSettings.setUseWebViewBackgroundForOverscrollBackground(true);
	webSettings.setJavaScriptEnabled(true);
	webSettings.setSavePassword(false);
	webSettings.setSaveFormData(false);
	webSettings.setSupportZoom(true);
	webSettings.setLoadWithOverviewMode(true);
	webSettings.setUseWideViewPort(true);
	}
	public void updateDetails(String url) {
	mWebView.loadUrl(url);
	}

}
